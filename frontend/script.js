async function shortenUrl() {
    const longUrl = document.getElementById("urlInput").value.trim();
    const loader = document.getElementById("loader");
    const resultDiv = document.getElementById("result");
    const input = document.getElementById("urlInput");

    if (!longUrl) {
        // Add shake animation to input
        input.style.animation = "shake 0.5s";
        setTimeout(() => {
            input.style.animation = "";
        }, 500);
        return;
    }

    // Basic URL validation
    try {
        new URL(longUrl);
    } catch (e) {
        input.style.animation = "shake 0.5s";
        setTimeout(() => {
            input.style.animation = "";
        }, 500);
        return;
    }

    // Show loader with smooth transition
    loader.classList.remove("hidden");
    resultDiv.classList.add("hidden");

    try {
        // Send API request
        const response = await fetch("http://localhost:4567/shorten", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ url: longUrl })
        });

        const data = await response.json();

        // Hide loader & show result with smooth animation
        setTimeout(() => {
            loader.classList.add("hidden");
            resultDiv.classList.remove("hidden");

            // Update link
            const shortUrlA = document.getElementById("shortUrl");
            shortUrlA.href = data.shortUrl;
            shortUrlA.textContent = data.shortUrl;

            // Reset copy button state
            resetCopyButton();
        }, 500);
    } catch (error) {
        console.error("Error shortening URL:", error);
        loader.classList.add("hidden");
        alert("Failed to shorten URL. Please try again.");
    }
}

function copyToClipboard() {
    const url = document.getElementById("shortUrl").textContent;
    const btn = document.getElementById("copyBtn");
    const copyIcon = document.getElementById("copyIcon");
    const copyText = document.getElementById("copyText");

    navigator.clipboard.writeText(url).then(() => {
        // Update button to "Copied" state
        btn.classList.add("copied");
        copyIcon.textContent = "✓";
        copyText.textContent = "Copied!";

        // Reset after 2 seconds
        setTimeout(() => {
            resetCopyButton();
        }, 2000);
    }).catch(err => {
        console.error("Failed to copy:", err);
        alert("Failed to copy to clipboard");
    });
}

function resetCopyButton() {
    const btn = document.getElementById("copyBtn");
    const copyIcon = document.getElementById("copyIcon");
    const copyText = document.getElementById("copyText");
    
    btn.classList.remove("copied");
    copyIcon.textContent = "📋";
    copyText.textContent = "Copy";
}

// Add shake animation style dynamically
const style = document.createElement('style');
style.textContent = `
    @keyframes shake {
        0%, 100% { transform: translateX(0); }
        10%, 30%, 50%, 70%, 90% { transform: translateX(-5px); }
        20%, 40%, 60%, 80% { transform: translateX(5px); }
    }
`;
document.head.appendChild(style);

// Allow Enter key to submit
document.getElementById("urlInput").addEventListener("keypress", function(event) {
    if (event.key === "Enter") {
        shortenUrl();
    }
});