# Weather App - Android Development

This is an Android weather application built during the course of Android Development. The app provides real-time weather information and forecasts, developed using **Jetpack Compose** and **Kotlin**. It offers detailed weather data including temperature, humidity, wind speed, and atmospheric conditions.

## Features
- Real-time weather updates and forecasts
- Location-based weather information
- Detailed weather metrics:
  - Temperature (current and forecasted)
  - Humidity levels
  - Wind speed and direction
  - Atmospheric pressure
- User-friendly interface built using Jetpack Compose
- Responsive layout that adapts to different screen sizes
- Beautiful weather condition icons
- Seamless location detection

## Screenshots
Here are some screenshots of the app in action:

<div style="display: flex; justify-content: space-between;">
    <img src="https://github.com/yatinsingh825/weatherApp/blob/main/IMG-20241113-WA0001.jpg" width="300" style="margin-right: 10px;">
    <img src="https://github.com/yatinsingh825/weatherApp/blob/main/IMG-20241113-WA0002.jpg" width="300">
</div>

<div style="display: flex; justify-content: space-between; margin-top: 20px;">
    <img src="https://github.com/yatinsingh825/weatherApp/blob/main/IMG-20241113-WA0003.jpg" width="300" style="margin-right: 10px;">
    <img src="https://github.com/yatinsingh825/weatherApp/blob/main/IMG-20241113-WA0004.jpg" width="300">
</div>

<div style="display: flex; justify-content: space-between; margin-top: 20px;">
    <img src="https://github.com/yatinsingh825/weatherApp/blob/main/IMG-20241113-WA0005.jpg" width="300" style="margin-right: 10px;">
    <img src="https://github.com/yatinsingh825/weatherApp/blob/main/IMG-20241113-WA0006.jpg" width="300">
</div>

## Installation
To get this project up and running on your local machine, follow these steps:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yatinsingh825/weatherApp.git
   ```
2. **Open the project in Android Studio**.
3. **Add your Weather API key**:
   - Navigate to `app/src/main/res/values/`
   - Create a `secrets.xml` file if it doesn't exist
   - Add your API key:
     ```xml
     <resources>
         <string name="weather_api_key">YOUR_API_KEY_HERE</string>
     </resources>
     ```
4. **Sync the project with Gradle files**.
5. **Run the app** on an emulator or a physical Android device.

## Usage
After launching the app, you can:
- View current weather conditions for your location
- Check detailed weather metrics including temperature, humidity, and wind speed
- View weather information for different locations
- Refresh weather data with a simple pull-to-refresh gesture

## Technologies Used
- **Kotlin**: The primary programming language used for development
- **Jetpack Compose**: UI toolkit for building native Android applications
- **Retrofit**: For making API calls to weather services
- **Android Studio**: IDE for developing and running the Android app
- **Weather API**: For fetching real-time weather data
- **Location Services**: For accessing device location

## Permissions Required
The app requires the following permissions:
- `ACCESS_FINE_LOCATION`: For precise location-based weather data
- `ACCESS_COARSE_LOCATION`: For approximate location data
- `INTERNET`: For fetching weather information

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact
If you have any questions or suggestions, feel free to reach out to me:
- **Email**: yatinsingh825@gmail.com
- **GitHub**: yatinsingh825
- **LinkedIn**: www.linkedin.com/in/yatinsingh825

## Acknowledgments
- Weather data provided by [Weather API Service Name]
- Icons and design inspiration from [Source]
- Special thanks to all contributors and the Android development community
