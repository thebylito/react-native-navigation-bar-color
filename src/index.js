import {NativeModules, Platform, processColor} from 'react-native';

const {NavigationBarColor} = NativeModules;

const changeNavigationBarColor = (
  color = String,
  light = false,
  animated = true,
) => {
  if (Platform.OS === 'android') {
    const LightNav = light ? true : false;
    return NavigationBarColor.changeNavigationBarColor(processColor(color), LightNav, animated);
  }
};
const hideNavigationBar = () => {
  if (Platform.OS === 'android') {
    return NavigationBarColor.hideNavigationBar();
  } else {
    return false;
  }
};
const showNavigationBar = () => {
  if (Platform.OS === 'android') {
    return NavigationBarColor.showNavigationBar();
  } else {
    return false;
  }
};

export {changeNavigationBarColor, hideNavigationBar, showNavigationBar};
