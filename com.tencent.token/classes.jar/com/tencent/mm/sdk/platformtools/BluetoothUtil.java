package com.tencent.mm.sdk.platformtools;

import android.media.AudioManager;
import android.os.Build.VERSION;

public class BluetoothUtil
{
  public static boolean startBluetooth(AudioManager paramAudioManager)
  {
    if ((Integer.valueOf(Build.VERSION.SDK).intValue() >= 8) && (paramAudioManager.isBluetoothScoAvailableOffCall()))
    {
      if (PhoneStatusWatcher.isCalling()) {
        return false;
      }
      paramAudioManager.startBluetoothSco();
      paramAudioManager.setBluetoothScoOn(true);
      return true;
    }
    return false;
  }
  
  public static void stopBluetooth(AudioManager paramAudioManager)
  {
    if ((Integer.valueOf(Build.VERSION.SDK).intValue() >= 8) && (!PhoneStatusWatcher.isCalling())) {
      paramAudioManager.stopBluetoothSco();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BluetoothUtil
 * JD-Core Version:    0.7.0.1
 */