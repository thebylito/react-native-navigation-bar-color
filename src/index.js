import { NativeModules, Platform } from 'react-native';

const { NavigationBarColor } = NativeModules;

const changeNavigationBarColor = (color = String, light = false, withoutAnimation = false) => {
  if(Platform.OS === 'android') {
    const LightNav = light ? true : false;
    NavigationBarColor.changeNavigationBarColor(color, LightNav, withoutAnimation);
  }
};
const HideNavigationBar = () => {
  if(Platform.OS === 'android') {
    return NavigationBarColor.HideNavigationBar();
  } else {
    return false;
  }
};
const ShowNavigationBar = () => {
  if(Platform.OS === 'android') {
    NavigationBarColor.ShowNavigationBar();
  } else {
    return false;
  }
};
export { changeNavigationBarColor, HideNavigationBar, ShowNavigationBar };
