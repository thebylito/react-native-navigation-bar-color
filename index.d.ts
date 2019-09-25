declare module "react-native-navigation-bar-color" {
    function changeNavigationBarColor(color: string, light: boolean, withoutAnimation: boolean): void;
    function HideNavigationBar(): boolean;
    function ShowNavigationBar(): boolean;

    export { changeNavigationBarColor, HideNavigationBar, ShowNavigationBar };
}
