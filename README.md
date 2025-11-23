# URL Shortener Application

A simple yet functional URL shortener built with Java Spark Framework (backend) and Vanilla JavaScript (frontend).

## 🎯 Features

- ✅ Shorten long URLs to 6-character codes
- ✅ Redirect short URLs to original URLs
- ✅ Copy shortened URL to clipboard
- ✅ Clean and responsive UI
- ✅ In-memory storage (persists while server is running)

## 🛠️ Tech Stack

**Backend:**
- Java 17
- Spark Framework (lightweight web framework)
- Gson (JSON handling)
- Maven (build tool)

**Frontend:**
- Vanilla JavaScript (no frameworks)
- HTML5
- CSS3 (Modern styling)
- Nginx (serving static files)

## 🏗️ Architecture

- **Backend API**: Runs on port 4567
- **Frontend**: Served via Nginx on port 3000
- **API Endpoints**:
  - `POST /shorten` - Create a short URL
  - `GET /:code` - Redirect to original URL



## 🚀 Running the Application

### Access URLs
- **Frontend**: http://localhost:3000
- **Backend API**: http://localhost:4567

### Managing Services
```bash
# Check status
sudo supervisorctl status

# Restart backend
sudo supervisorctl restart java-backend

# View logs
tail -f /var/log/supervisor/java-backend.out.log
```

## 📝 API Usage

### Create Short URL
```bash
curl -X POST http://localhost:3000/shorten \
  -H "Content-Type: application/json" \
  -d '{"url":"https://www.example.com"}'
```

### Access Short URL
```bash
curl -L http://localhost:3000/abc123
```

## 📦 Project Structure

```
/app/
├── backend/
│   ├── pom.xml
│   └── src/main/java/com-urlShortner/
│       ├── Main.java
│       └── UrlService.java
├── frontend/
│   ├── index.html
│   ├── script.js
│   └── styles.css
└── README.md
```

## 📊 Current Status

✅ All issues resolved - application fully functional!

---

**Made with ❤️ using Java + Spark + Vanilla JS**
