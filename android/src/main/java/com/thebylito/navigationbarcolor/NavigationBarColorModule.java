//  Created by react-native-create-bridge

package com.thebylito.navigationbarcolor;


import android.graphics.Color;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import java.util.HashMap;
import java.util.Map;
import com.facebook.react.uimanager.IllegalViewOperationException;

public class NavigationBarColorModule extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "NavigationBarColor";
    private static ReactApplicationContext reactContext = null;


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
            getCurrentActivity().getWindow().setNavigationBarColor(Color.parseColor(String.valueOf(color)));
            WritableMap map = Arguments.createMap();
            map.putBoolean("success", true);
            promise.resolve(map);

        } catch (IllegalViewOperationException e) {
            WritableMap map = Arguments.createMap();
            map.putBoolean("success", false);
            promise.reject("error", e);
        }

    }
}



