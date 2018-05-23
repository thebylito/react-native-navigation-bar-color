import { NativeModules } from 'react-native';

const { NavigationBarColor } = NativeModules;

const changeNavigationBarColor = (color = String) =>
  NavigationBarColor.changeNavigationBarColor(color);

export { changeNavigationBarColor };
