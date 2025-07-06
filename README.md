# Duty Planner

## Overview
Duty Planner is an Android application for tracking and scheduling duties. The project uses Kotlin and Jetpack Compose and follows a multi-module structure to keep the codebase organized.

## Module Roles
- **app** – Entry point of the Android application, combines all modules and hosts the Compose UI.
- **core** – Shared utilities, UI components and theming used by other modules.
- **domain** – Pure Kotlin layer containing business models and use cases.
- **data** – Data layer providing repository implementations and local persistence (Room database).
- **features** – Feature specific presentation modules and screens.

## Requirements
- **JDK 17**
- **Android Studio Hedgehog** or newer
- Android SDK with API level 35
- Gradle 8.11 (provided via the wrapper)

## Build and Run
To build the debug version from the command line:

```bash
./gradlew clean :app:assembleDebug
```

To install the APK on a connected device/emulator:

```bash
./gradlew :app:installDebug
```

You can also open the project in Android Studio and run it directly from the IDE.

## Contributing
Contributions are welcome!

1. Fork the repository and create a feature branch.
2. Follow the Kotlin coding conventions and run the tests with `./gradlew test` before submitting.
3. Create a pull request describing your changes.

