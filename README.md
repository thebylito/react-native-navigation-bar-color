# React Native Navigation Bar Color Change

React Native Navigation Bar Color Change is a [React Native](http://facebook.github.io/react-native/) library for change color of navigation/Bottom bar on Android.

### Android Only

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
  	```include ':react-native-navigation-bar-color'
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
import { View, Text, Button } from 'react-native';
import changeNavigationBarColor, {
  HideNavigationBar,
  ShowNavigationBar,
} from 'react-native-navigation-bar-color';

export default class Mynewapp extends Component {
  setNavigationColor = (color) => {
    changeNavigationBarColor(color);
  };
  hideNavigation = () => {
    HideNavigationBar();
  };

  showNavigation = () => {
    ShowNavigationBar();
  };

  render() {
    return (
      <View
        style={{
          flex: 1,
          justifyContent: 'space-around',
          alignContent: 'center',
          alignItems: 'center',
        }}
      >
        <Button
          title="Set color red"
          onPress={() => {
            this.setNavigationColor('red');
          }}
        />
        <Button
          title="Set color blue"
          onPress={() => {
            this.setNavigationColor('blue');
          }}
        />
        <Button
          title="Hide bar"
          onPress={() => {
            this.hideNavigation();
          }}
        />
        <Button
          title="Show bar"
          onPress={() => {
            this.showNavigation();
          }}
        />
        <Text>Hello Word!</Text>
      </View>
    );
  }
}
```

## API

### `changeNavigationBarColor(color, Boolean(light icon color) )`: (Android)
Change color of Navigation/Bottom bar.
color can be a HEX color, or name.
ex: green, blue, #80b3ff, #ffffff....

Light is true? icon color may be White.
False? May be a Black or Gray.

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

##OR

```javascript
  example = async () => {
      try{
          const response = await changeNavigationBarColor('#80b3ff', true);
          console.log(response)// {success: true}
      }catch(e){
          console.log(e)// {success: false}
      }
    
  };
```

### `HideNavigationBar()`: (Android)
Hide Navigation Bar

```javascript
  import { HideNavigationBar } from 'react-native-navigation-bar-color';
 ...
  hide = () => {
      HideNavigationBar();
  };
```

### `ShowNavigationBar()`: (Android)
Show Navigation Bar

```javascript
  import { ShowNavigationBar } from 'react-native-navigation-bar-color';
 ...
  show = () => {
      ShowNavigationBar();
  };
```

## License

MIT
