# 📱 SIM Registration System (Java GUI)

A **Java Swing application** that simulates a SIM card registration system with the following features:

- 📱 **Phone number validation** (10 digits)  
- 🌍 **Automatic network detection** (Vodacom, MTN, Telkom, Cell C)  
- 💾 **Save user info** to a file (`users.txt`)  
- 🖥 **Automatic device information** display (computer name, IP address, OS, username)  
- 🪟 **Graphical User Interface (GUI)** for easy interaction  

---

## 🛠 Features

1. **Register SIM**  
   - Enter your name, surname, and phone number  
   - Phone number is validated (must be 10 digits)  
   - Network is detected automatically based on phone number prefix  
   - User info is saved to `users.txt`  

2. **Device Info**  
   - Displays your computer name, IP address, username, and OS  

3. **GUI Interaction**  
   - User-friendly Swing interface  
   - Buttons for registration and device info  
   - Scrollable output area for messages  

---

## 📂 Files

| File | Description |
|------|-------------|
| `SimRegistrationGUI.java` | Main Java program with GUI and registration logic |
| `users.txt` | Auto-generated file storing registered users (created at runtime) |

---

## 💻 Requirements

- Java 8 or higher  
- Command-line terminal or IDE that supports Swing (Eclipse, IntelliJ, NetBeans, VS Code)  

---

## ▶ How to Run

1. Compile the program:

```bash
javac SimRegistrationGUI.java
