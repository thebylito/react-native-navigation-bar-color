import { NativeModules } from 'react-native';

const { NavigationBarColor } = NativeModules;

const changeNavigationBarColor = (color = String, light = false) => {
  const LightNav = light ? true : false;
  NavigationBarColor.changeNavigationBarColor(color, LightNav);
};
const HideNavigationBar = () => NavigationBarColor.HideNavigationBar();
const ShowNavigationBar = () => NavigationBarColor.ShowNavigationBar();

export { changeNavigationBarColor, HideNavigationBar, ShowNavigationBar };
