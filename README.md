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

## ✅ Issues Fixed

### 1. CSS File Reference Error
- **Problem**: HTML referenced `style.css` but file was named `styles.css`
- **Fix**: Updated index.html to reference correct filename

### 2. Missing CORS Configuration
- **Problem**: Frontend couldn't make API calls due to CORS restrictions
- **Fix**: Added CORS headers to backend

### 3. Java Package Structure Issues
- **Problem**: Missing package declarations causing compilation errors
- **Fix**: Added `package com.urlshortener;` to all Java files

### 4. Maven Configuration
- **Problem**: Missing Java version and compiler configuration
- **Fix**: Added proper Maven properties and compiler plugin

### 5. Duplicate/Unused Files
- **Problem**: UrlController.java and UrlStore.java causing compilation errors
- **Fix**: Removed unused files that conflicted with main implementation

### 6. Server Management
- **Problem**: No proper process management for Java backend
- **Fix**: Created supervisor configuration for automatic startup and restart

### 7. Frontend Serving
- **Problem**: Frontend files not accessible
- **Fix**: Configured Nginx to serve static files and proxy API requests

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
