# Embit
Embit is for the environmentally conscious smartphone user. It gets users thinking about how much 
energy their phone really uses, and from where that energy is sourced. Embit strives to be a first 
step in our homes' meterless future, where devices self-track and self-report their power 
consumption.
# Getting Started
This project requires Android Studio to run and deploy the app. If you do not have an Android Device
some functionality can be emulated using a virtual device.

### Installation
1. Clone the repository to your local machine.
2. Open Android Studio and select to 'Open an Existing Project'
3. Select your local clone of Embit to open it.
4. Download a Virtual Device or connect an Android device using at least API level 21.
5. Select the app in the build configurations and click run to deploy.

# Testing
To run the test suite, launch a virtual device or connect an android device. In Android Studio,
select the test suite that you want to run within the androidTest directory. Then, right click and 
select the Run 'exampleTest' option. Additional tests can be added to the existing test suite or 
within the androidTest directory.

# Deployment
Embit is currently under development and no final build has been published on an app store. To run 
the app, connect an Android device or set up a virtual device with API level 21 or higher in Android
Studio. Cloning the repository and running the app from Android Studio will give the most recent 
version of the app with all of the completed features included.

Future development through feature branches is an option for development. In that case, select the 
feature branch that you want to deploy and repeat the steps above.

# Technologies Used
The primary logic of the app relies on Android Intents which broadcast events such as battery or 
charging status changes. The data is stores in a persistent Room library and occasionally sent to 
the Embit database for integration into the Embit clean energy ecosystem. 

The website associated with the project development, [https://jacobasmith.github.io/embit/] uses
the Bulma CSS framework. 

# Contributing
If you are interested in contributing to the project, either submit a pull request or request access
to the repo. If creating a new feature, use a separate development branch and do a pull request into
the main branch. For more information on the project and why you might want to contribute, see our
project website: [https://jacobasmith.github.io/embit/].

# Authors
This app and website were created by three UNC Chapel Hill undergraduates for our Comp 523, Software
Engineering laboratory project. Our team members include: 
Jacob A. Smith [JacobASmith]("https://github.com/JacobASmith")
Prabhath Kotha [prabhathkotha]("https://github.com/prabhathkotha")
Raj Gandecha [rgandecha]("https://github.com/rgandecha")

# License
To be determined.

# Acknowledgements
We would like to give a special thanks to our mentor, Jaime Vega, for keeping us on track and offering
his wisdom when we get stuck. We also want to thank Eric Scheier, who without his vision we would 
not be making this app. And, last but not least, we would like to thank our professor, Dr. Jeff 
Terrell, for giving us the opportunity to create real software and work on a meaningful project. 
Thank you all! 

 
