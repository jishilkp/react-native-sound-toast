
# react-native-react-native-sound-toast

## Getting started

`$ npm install react-native-react-native-sound-toast --save`

### Mostly automatic installation

`$ react-native link react-native-react-native-sound-toast`

### Manual installation


#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNReactNativeSoundToastPackage;` to the imports at the top of the file
  - Add `new RNReactNativeSoundToastPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-react-native-sound-toast'
  	project(':react-native-react-native-sound-toast').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-react-native-sound-toast/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-react-native-sound-toast')
  	```


## Usage
```javascript
import RNReactNativeSoundToast from 'react-native-react-native-sound-toast';

// TODO: What to do with the module?
RNReactNativeSoundToast;
```
  