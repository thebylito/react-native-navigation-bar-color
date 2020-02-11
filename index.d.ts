declare module "react-native-navigation-bar-color" {
    function changeNavigationBarColor(color: string, light: boolean, animated: boolean): void;
    function HideNavigationBar(): boolean;
    function ShowNavigationBar(): boolean;

    export default changeNavigationBarColor;
    export { HideNavigationBar, ShowNavigationBar };
}
