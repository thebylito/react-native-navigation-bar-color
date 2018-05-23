//  Created by react-native-create-bridge

package com.thebylito.navigationbarcolor;


import android.graphics.Color;
import android.os.Build;
import android.view.View;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;

import java.util.HashMap;
import java.util.Map;

import com.facebook.react.uimanager.IllegalViewOperationException;

import static com.facebook.react.bridge.UiThreadUtil.runOnUiThread;

public class NavigationBarColorModule extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "NavigationBarColor";
    private static ReactApplicationContext reactContext = null;
    private static final int UI_FLAG_HIDE_NAV_BAR = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

    public NavigationBarColorModule(ReactApplicationContext context) {
        // Pass in the context to the constructor and save it so you can emit events
        // https://facebook.github.io/react-native/docs/native-modules-android.html#the-toast-module
        super(context);
        reactContext = context;
    }


    @Override
    public String getName() {
        // Tell React the name of the module
        // https://facebook.github.io/react-native/docs/native-modules-android.html#the-toast-module
        return REACT_CLASS;
    }

    @Override
    public Map<String, Object> getConstants() {
        // Export any constants to be used in your native module
        // https://facebook.github.io/react-native/docs/native-modules-android.html#the-toast-module
        final Map<String, Object> constants = new HashMap<>();
        constants.put("EXAMPLE_CONSTANT", "example");

        return constants;
    }

    @ReactMethod
    public void changeNavigationBarColor(String color, Promise promise) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getCurrentActivity().getWindow().setNavigationBarColor(Color.parseColor(String.valueOf(color)));
                WritableMap map = Arguments.createMap();
                map.putBoolean("success", true);
                promise.resolve(map);
            }else{

                WritableMap map = Arguments.createMap();
                map.putBoolean("success", false);
                map.putString("message", "Lollpop or more required");
                promise.reject((Throwable) map);
            }

        } catch (IllegalViewOperationException e) {
            WritableMap map = Arguments.createMap();
            map.putBoolean("success", false);
            promise.reject("error", e);
        }

    }

    @ReactMethod
    public void HideNavigationBar(Promise promise) {
        try {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    View decorView = getCurrentActivity().getWindow().getDecorView();
                    decorView.setSystemUiVisibility(UI_FLAG_HIDE_NAV_BAR);
                }
            });
        } catch (IllegalViewOperationException e) {
            WritableMap map = Arguments.createMap();
            map.putBoolean("success", false);
            promise.reject("error", e);
        }
    }

    @ReactMethod
    public void ShowNavigationBar(Promise promise) {
        try {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    View decorView = getCurrentActivity().getWindow().getDecorView();
                    int uiOptions = View.SYSTEM_UI_FLAG_VISIBLE;
                    decorView.setSystemUiVisibility(uiOptions);
                }
            });
        } catch (IllegalViewOperationException e) {
            WritableMap map = Arguments.createMap();
            map.putBoolean("success", false);
            promise.reject("error", e);
        }
    }
}



