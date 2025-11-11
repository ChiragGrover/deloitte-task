# Deloitte Android Coding Task

This repository contains a simple **Android Jetpack Compose** application built as part of the Deloitte coding exercise.  
The goal was to demonstrate clean architecture, modern Android development practices, and testing — all implemented within **4–6 hours**.

---

## Technologies Used

| Category | Library / Tool |
|-----------|----------------|
| **Language** | Kotlin |
| **UI Framework** | Jetpack Compose (Material 3) |
| **Architecture** | MVVM | Clean Architecture
| **Dependency Injection** | Hilt (Dagger) |
| **Async / Concurrency** | Kotlin Coroutines & StateFlow |
| **Networking** | Retrofit + OkHttp + Gson |
| **Image Loading** | Coil Compose |
| **Navigation** | Jetpack Navigation Compose |
| **Testing** | JUnit4 • MockK • Mockito • Turbine • Compose UI Test |
| **Build System** | Gradle (Kotlin DSL) |

---

## Features

- Displays a **list of users** using Jetpack Compose `LazyColumn`.  
- Selecting a user opens a **detail screen** showing profile photo, username, and email.  
- Uses **StateFlow** for reactive UI updates from the ViewModel.  
- Fully built with **Jetpack Compose** and Material 3 components.  
- Includes **unit and UI tests** verifying ViewModel and composable rendering.  

---

## Assumptions

- This project is intended as a **technical demo**, not a full production app.  
- The user data is mocked locally; API calls are simulated.  
- The focus is on **architecture, testability, and modern Compose usage**.  
- UI design is minimal — only functional elements were prioritized.  
- Built within **4–6 hours**, as per the assignment guidelines.  

---

## Architecture Overview
presentation/
 ├── UserListScreen.kt
 └── UserDetailScreen.kt
domain/
 └── model/User.kt
features/
 ├── user/UserViewModel.kt
 └── user/UserState.kt
data/
 └── api/ (placeholder for network setup)
 
 Pattern Used: MVVM (Model-View-ViewModel)

## Testing Summary
Type	Libraries	Purpose
Unit Tests	JUnit • Mockito • Turbine	Validate ViewModel & Flow logic
UI Tests	Compose UI Test • MockK	Verify composables render correctly
Coroutine Tests	kotlinx-coroutines-test	Ensure structured concurrency and state emission

## Screenshots
User List Screen	User Detail Screen
screenshots and video are placed inside the /screenshots folder at the project root.


## Notes
Target SDK: 36
Min SDK: 29
Compose Compiler: 1.7.x
Development Time: ~4–6 hours
Focus: Architecture, Testability, and Compose best practices
Testing Tools: JUnit, MockK, Mockito, Compose UI Test
