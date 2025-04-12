# 🛡️ SecureNotes

A secure Android notes app using AES encryption, biometric login, and TLS-pinned sync. Built to demonstrate local and network-layer security practices in a production-grade mobile app.

---

## 🔑 Features

- AES-encrypted local storage (EncryptedFile, EncryptedSharedPrefs)
- Biometric authentication (Fingerprint/Face unlock)
- TLS certificate pinning (OkHttp)
- Dark mode with Jetpack Compose UI
- Shared notes sync via HTTPS (simulated)

---

## 🛠 Tech Stack

- Kotlin, Jetpack Compose
- AndroidX Security
- BiometricPrompt API
- OkHttp + TLS Pinning
- MVVM + Clean Architecture

---

## 🧠 Architecture

Presentation (Compose UI) │ ├── ViewModel (Business Logic) │ ├── Repository │ ├── LocalDataSource (EncryptedPrefs) │ └── RemoteDataSource (TLS API) │ └── Model (Encrypted Notes)`

---

## 🔐 Security Practices

- All notes stored with AES-256 encryption via `EncryptedFile`
- Secure login with BiometricPrompt + fallback PIN
- HTTPS enforced with `OkHttpClient` certificate pinning
- No sensitive logs, static analysis passed with Lint + Detekt

---

## 🚀 Getting Started

```bash
git clone https://github.com/yourname/SecureNotes.git
open in Android Studio
Run on device (min SDK 23)

📁 Folder Structure

app/
├── ui/
├── viewmodel/
├── data/
│   ├── local/
│   └── remote/
├── model/
└── util/


🗺 Roadmap
 -AES encryption
 -Biometric auth

🧾 License
MIT © 2025 Moin Khan
