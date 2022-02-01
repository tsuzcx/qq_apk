package com.tencent.mobileqq.imcore.constants;

import android.os.Environment;
import java.io.File;

public class AppConstants
{
  public static final String APP_NAME = "mobileQQ";
  public static final String SDCARD_PATH = SDCARD_ROOT + "/Tencent/Tim/";
  public static final String SDCARD_ROOT = Environment.getExternalStorageDirectory().getAbsolutePath();
  
  public static abstract interface Preferences
  {
    public static final String SECURITY_KEY = "security_key";
  }
  
  public static abstract interface VALUE
  {
    public static final int UIN_TYPE_FRIEND = 0;
    public static final int UIN_TYPE_Init = -1;
    public static final int UIN_TYPE_TROOP = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.constants.AppConstants
 * JD-Core Version:    0.7.0.1
 */