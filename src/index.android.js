import { NativeModules } from "react-native";

const { NavigationBarColor } = NativeModules;

const changeNavigationBarColor = (
  color = String,
  light = false,
  animated = true
) => {
  const LightNav = light ? true : false;
  NavigationBarColor.changeNavigationBarColor(color, LightNav, animated);
};

const hideNavigationBar = () => {
  return NavigationBarColor.hideNavigationBar();
};

const showNavigationBar = () => {
  NavigationBarColor.showNavigationBar();
};

export { changeNavigationBarColor, hideNavigationBar, showNavigationBar };
