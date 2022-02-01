package com.tencent.mobileqq.app.automator;

import acoo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class TimerChecker
  extends LinearGroup
{
  public void onCreate()
  {
    long l = System.currentTimeMillis();
    Object localObject = acoo.ko;
    StringBuilder localStringBuilder = new StringBuilder("{");
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if ((Math.abs(l - this.a.O.getLong("LAST_UPDATE_TIME_PRE_" + localObject[i], 0L)) >= localObject[i] * 60 * 60 * 1000) && (acoo.ek[i].length() > 2))
      {
        localStringBuilder.append(acoo.ek[i]).append(',');
        this.a.O.edit().putLong("LAST_UPDATE_TIME_PRE_" + localObject[i], l).commit();
      }
      i += 1;
    }
    localObject = localStringBuilder.toString();
    this.mPattern = (((String)localObject).substring(0, ((String)localObject).length() - 1) + "}");
    super.onCreate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.TimerChecker
 * JD-Core Version:    0.7.0.1
 */