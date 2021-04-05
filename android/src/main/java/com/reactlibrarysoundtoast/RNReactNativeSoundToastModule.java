
package com.reactlibrarysoundtoast;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Gravity;
import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.io.File;

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

  @ReactMethod
  public void playSound(String name, String type) {
    MediaPlayer mediaPlayer;
    Context context = getReactApplicationContext();
    int soundResID = context.getResources().getIdentifier(name, "raw", context.getPackageName());

    if (soundResID > 0) {
      mediaPlayer = MediaPlayer.create(context, soundResID);
    } else {
      mediaPlayer = MediaPlayer.create(context, getUriFromFile(name, type));
    }
    try {
      if (mediaPlayer.isPlaying()) {
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = MediaPlayer.create(context, soundResID);
      } mediaPlayer.start();
    } catch(Exception e) {
      Toast.makeText(context,"Sound file not found",Toast.LENGTH_SHORT).show();
    }
  }

  @ReactMethod
  public void increaseSound() {
    Context context = getReactApplicationContext();
    AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
    audioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
  }

  @ReactMethod
  public void decreaseSound() {
    Context context = getReactApplicationContext();
    AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
    audioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
  }

  @ReactMethod
  public void muteSound() {
    Context context = getReactApplicationContext();
    AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
    audioManager.adjustVolume(AudioManager.ADJUST_MUTE, AudioManager.FLAG_SHOW_UI);
  }

  @ReactMethod
  public void unMuteSound() {
    Context context = getReactApplicationContext();
    AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
    audioManager.adjustVolume(AudioManager.ADJUST_UNMUTE, AudioManager.FLAG_SHOW_UI);
  }

  private Uri getUriFromFile(String name, String type) {
    String folder = getReactApplicationContext().getFilesDir().getAbsolutePath();
    String file = name + "." + type;
    File ref = new File(folder + "/" + file);
    if (ref.exists()) {
      ref.setReadable(true, false);
    }
    return Uri.parse("file://" + folder + "/" + file);
  }

}