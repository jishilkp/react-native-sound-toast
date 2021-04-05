
# react-native-sound-toast

A react native module to show native toast message, play sound and adjust system volume. Currently it works only on Android.

## Features

- Show Toast
- Play sound & Adjust system volume

## Getting started

`$ npm install react-native-sound-toast --save`

### Mostly automatic installation

`$ react-native link react-native-sound-toast`

## Usage
```javascript
import RNReactNativeSoundToast from 'react-native-sound-toast';

// TODO: What to do with the module?
RNReactNativeSoundToast;

RNNativeSoundToast.showToastAtCenter("Hello World");

RNNativeSoundToast.playSound("my_sound","wav");

RNNativeSoundToast.increaseSound();

```

## Toast API

- showToast(message)
- showLongToast(message)
- showShortToast(message)
- showToastAtTop(message)
- showToastAtCenter(message)

## Sound API

First you'll need to add audio files to your project.

Save your sound clip files under the directory android/app/src/main/res/raw. Note that files in this directory must be lowercase and underscored (e.g. my_file_name.wav) and that subdirectories are not supported by Android

- playSound(filename, type)
- increaseSound()
- decreaseSound()
- muteSound()
- unMuteSound()

## Note

This library is created for learning purpose, so please don't expect regular maintenance.

