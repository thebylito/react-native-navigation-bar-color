# React Native Navigation Bar Color Change
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2Fthebylito%2Freact-native-navigation-bar-color.svg?type=shield)](https://app.fossa.io/projects/git%2Bgithub.com%2Fthebylito%2Freact-native-navigation-bar-color?ref=badge_shield)


React Native Navigation Bar Color Change is a [React Native](http://facebook.github.io/react-native/) library for change color of navigation/Bottom bar on Android.

### Android Only

<div>
<img src="https://github.com/thebylito/react-native-navigation-bar-color/raw/master/screenshots/screenShot1.jpg" height="600">
<img src="https://github.com/thebylito/react-native-navigation-bar-color/raw/master/screenshots/screenShot2.jpg" height="600">
<img src="https://github.com/thebylito/react-native-navigation-bar-color/raw/master/screenshots/screenShot3.jpg" height="600">
<img src="https://user-images.githubusercontent.com/29806253/46919604-96247c00-cfaf-11e8-996a-81330dad6562.png" height="600">
</div>

## Table of Contents

- [Installation](#installation)
- [Example](#example)
- [API](#api)
- [License](#license)

## Installation

<details>
<summary>react-native >= 0.60.0</summary>

### 1 - Install the package:

`$ yarn add react-native-navigation-bar-color`

or

`$ npm install react-native-navigation-bar-color --save`

## That's is all!

</details>

<details>

<summary>react-native <= 0.59.0</summary>

### 1 - Install the package:

`$ yarn add react-native-navigation-bar-color`

or

`$ npm install react-native-navigation-bar-color --save`

### 2 - Configure package:

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
    implementation project(':react-native-navigation-bar-color')
  	```
</details>

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
  hideNavigation() {
    HideNavigationBar();
  };

  showNavigation() {
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
          backgroundColor: 'white'
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
          title="Set color ligth"
          onPress={() => {
            changeNavigationBarColor('#ffffff', true);
          }}
        />
        <Button
          title="Hide bar"
          onPress={this.hideNavigation}
        />
        <Button
          title="Show bar"
          onPress={this.showNavigation}
        />
        <Text>Hello Word!</Text>
      </View>
    );
  }
}
```

## API

### `changeNavigationBarColor(color, Boolean(light icon color), Boolean(animated - default is true))`: (Android)
Change color of Navigation/Bottom bar.
color can be a HEX color, or name.
ex: green, blue, #80b3ff, #ffffff....

Light is true? icons will be dark.

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

## OR

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


[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2Fthebylito%2Freact-native-navigation-bar-color.svg?type=large)](https://app.fossa.io/projects/git%2Bgithub.com%2Fthebylito%2Freact-native-navigation-bar-color?ref=badge_large)
