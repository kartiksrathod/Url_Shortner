# URL Shortener - Test Results

## ✅ All Tests Passed!

### Test 1: URL Shortening
```bash
curl -X POST http://localhost:3000/shorten \
  -H "Content-Type: application/json" \
  -d '{"url":"https://www.google.com"}'
```
**Result:** ✅ Success
- Generates 6-character random code
- Returns short URL with correct base URL (http://localhost:3000/)

### Test 2: URL Redirect
```bash
curl -v http://localhost:3000/[CODE]
```
**Result:** ✅ Success
- Returns HTTP 302 Found
- Location header points to original URL
- Redirect works correctly

### Test 3: Frontend Interface
- ✅ Page loads at http://localhost:3000
- ✅ URL input field works
- ✅ Shorten button generates short URLs
- ✅ Copy to clipboard functionality works
- ✅ Short URL links are clickable

### Test 4: End-to-End Flow
1. User enters long URL: `https://www.example.com/very/long/url/that/needs/shortening`
2. System generates short URL: `http://localhost:3000/nhAsIP`
3. User clicks short URL
4. System redirects to original URL
5. ✅ All working perfectly!

## Architecture

- **Backend:** Java Spark Framework on port 4567
- **Frontend:** Static HTML/CSS/JS served via Nginx on port 3000
- **Nginx:** Proxies API requests to backend, serves static files, handles short URL redirects
- **Storage:** In-memory HashMap (persists while server is running)

## Services Status
```
java-backend    RUNNING   (Java Spark on port 4567)
nginx-proxy     RUNNING   (Serving on port 3000)
```

## URLs
- **Frontend Application:** http://localhost:3000
- **Backend API:** http://localhost:4567 (proxied through Nginx)

---
**Status:** 🎉 Fully Functional & Ready to Use!
