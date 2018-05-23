import { NativeModules } from 'react-native';

const { NavigationBarColor } = NativeModules;

const changeNavigationBarColor = (color = String) =>
  NavigationBarColor.changeNavigationBarColor(color);
const HideNavigationBar = () =>
  NavigationBarColor.HideNavigationBar();
const ShowNavigationBar = () =>
  NavigationBarColor.ShowNavigationBar();

export { changeNavigationBarColor, HideNavigationBar, ShowNavigationBar };
