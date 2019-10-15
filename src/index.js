import { NativeModules, Platform } from 'react-native';

const { NavigationBarColor } = NativeModules;

const changeNavigationBarColor = (color = String, light = false, animated = true) => {
  if(Platform.OS === 'android') {
    const LightNav = light ? true : false;
    NavigationBarColor.changeNavigationBarColor(color, LightNav, animated);
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
