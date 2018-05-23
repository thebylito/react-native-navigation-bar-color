# React Native Navigation Bar Color Change

React Native Navigation Bar Color Change is a [React Native](http://facebook.github.io/react-native/) library for change color of navigation/Bottom bar on Android.

### Android Version
Using an expandable Android Fingerprint API library, which combines [Samsung](http://developer.samsung.com/galaxy/pass#) and [MeiZu](http://open-wiki.flyme.cn/index.php?title=%E6%8C%87%E7%BA%B9%E8%AF%86%E5%88%ABAPI)'s official Fingerprint API.

Samsung and MeiZu's Fingerprint SDK supports most devices which system versions less than Android 6.0.

<div>
<img src="https://github.com/thebylito/react-native-navigation-bar-color/raw/master/screenshots/screenShot1.jpg" height="600">
<img src="https://github.com/thebylito/react-native-navigation-bar-color/raw/master/screenshots/screenShot2.jpg" height="600">
<img src="https://github.com/thebylito/react-native-navigation-bar-color/raw/master/screenshots/screenShot3.jpg" height="600">
</div>

## Table of Contents

- [Installation](#installation)
- [Example](#example)
- [API](#api)
- [License](#license)

## Installation

`$ npm install react-native-navigation-bar-color --save`

### Automatic Configuration

`$ react-native link react-native-navigation-bar-color`

### Manual Configuration

#### Android

1. Open up `android/app/src/main/java/[...]/MainApplication.java`
  - Add `import com.thebylito.navigationbarcolor.NavigationBarColorPackage;` to the imports at the top of the file
  - Add `new NavigationBarColorPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
include ':react-native-navigation-bar-color'
project(':react-native-navigation-bar-color').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-navigation-bar-color/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
    compile project(':react-native-navigation-bar-color')
  	```

## Example

**Android Implementation**
```javascript
import React, { Component } from 'react';
import { View, Text } from 'react-native';
import changeNavigationBarColor from 'react-native-navigation-bar-color';

export default class Mynewapp extends Component {
  componentDidMount = () => {
    this.example();
  };

  example = () => {
    changeNavigationBarColor('red');
  };

  render() {
    return (
      <View
        style={{
          flex: 1,
          justifyContent: 'center',
          alignItems: 'center',
        }}
      >
        <Text>Hello Word!</Text>
      </View>
    );
  }
}
```

## API

### `changeNavigationBarColor(color)`: (Android)
Change color of Navigation/Bottom bar.
color can be a HEX color, or name.
ex: green, blue, #80b3ff, #ffffff....

- Returns a `Promise`

```javascript
  example = async () => {
      try{
          const response = await changeNavigationBarColor('#80b3ff');
          console.log(response)// {success: true}
      }catch(e){
          console.log(e)// {success: false}
      }
    
  };
```

## License

MIT
