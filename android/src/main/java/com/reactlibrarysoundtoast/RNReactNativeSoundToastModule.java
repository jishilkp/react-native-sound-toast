
package com.reactlibrarysoundtoast;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RNReactNativeSoundToastModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNReactNativeSoundToastModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNReactNativeSoundToast";
  }

  @ReactMethod
  public void showToast(String text) {
    Context context = getReactApplicationContext();
    Toast.makeText(context, text, Toast.LENGTH_LONG).show();
  }

  @ReactMethod
  public void showLongToast(String text) {
    Context context = getReactApplicationContext();
    Toast.makeText(context, text, Toast.LENGTH_LONG).show();
  }

  @ReactMethod
  public void showShortToast(String text) {
    Context context = getReactApplicationContext();
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
  }

  @ReactMethod
  public void showToastAtTop(String text) {
    Context context = getReactApplicationContext();
    Toast toast= Toast.makeText(context,text, Toast.LENGTH_SHORT);
    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
    toast.show();
  }

  @ReactMethod
  public void showToastAtCenter(String text) {
    Context context = getReactApplicationContext();
    Toast toast= Toast.makeText(context,text, Toast.LENGTH_SHORT);
    toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);
    toast.show();
  }

}