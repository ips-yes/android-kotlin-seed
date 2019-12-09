## IPS Android Seed

An architecturally sound starting point for an Android application.

### Languages / Frameworks

 - [Retrofit](https://square.github.io/retrofit/) A type-safe HTTP client
 - [Timber](https://github.com/JakeWharton/timber) Lightweight logging utility built on top of Android native log
 - [Dagger](https://dagger.dev/android.html) Dependency injection framework

### Architectural Paradigm

 - Utilizes MVVM
 - Organizes classes by feature

#### Directories
 - api directory contains the REST client classes
 - di contains the Dependency injection classes
 - utils contains any global library classes

### Complimentary Tools
[IPS Express Seed](https://github.com/ips-yes/express-seed) Node.js Express server that the application calls to login. Follow the Express Seed Setup on your local machine.

### Android App Setup

Before running the Android application, the IP address in the Node.js server's URL needs to be set. This value can be found in the `AndroidManifest.xml` file:
```
<meta-data android:name="api_url" android:value="http://172.16.32.131:3001/express_seed/api/v1/"/>
```
The application should then be able to connect to the server and will display a login screen. When attempting to log in, a Toast message will appear, which will indicate if the login attempt was successful or not.