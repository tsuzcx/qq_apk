package com.tencent.trackrecordlib.g;

import alla;
import android.content.Context;
import android.provider.Settings.Secure;
import android.text.TextUtils.SimpleStringSplitter;
import android.util.Log;

public class a
{
  private static final String a = a.class.getName();
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      try
      {
        i = Settings.Secure.getInt(paramContext.getApplicationContext().getContentResolver(), "accessibility_enabled");
        TextUtils.SimpleStringSplitter localSimpleStringSplitter = new TextUtils.SimpleStringSplitter(':');
        if (i != 1) {
          continue;
        }
        paramContext = alla.getString(paramContext.getContentResolver(), "enabled_accessibility_services");
        if (paramContext == null) {
          continue;
        }
        localSimpleStringSplitter.setString(paramContext);
        do
        {
          if (!localSimpleStringSplitter.hasNext()) {
            break;
          }
        } while (!localSimpleStringSplitter.next().equalsIgnoreCase("com.google.android.marvin.talkback/com.google.android.marvin.talkback.TalkBackService"));
        return true;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.e(a, "Error finding setting, default accessibility to not found: " + localThrowable.getMessage());
          int i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.trackrecordlib.g.a
 * JD-Core Version:    0.7.0.1
 */