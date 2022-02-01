package com.tencent.androidqqmail.tim;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class TimReportManager
{
  public static void reportClickEvent(Context paramContext, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Log.i("reportClickEvent", "tValue = " + paramString1);
    Intent localIntent = new Intent("com.tencent.androidqqmail.tim.mail.broadcast");
    localIntent.putExtra("cmd", "reportClick");
    localIntent.putExtra("tValue", paramString1);
    localIntent.putExtra("entrance", paramInt1);
    localIntent.putExtra("reserve1", paramInt2);
    localIntent.putExtra("reserve2", paramInt3);
    localIntent.putExtra("reserve3", paramInt4);
    localIntent.putExtra("reserve4", paramInt5);
    localIntent.putExtra("reserve5", paramString2);
    localIntent.putExtra("reserve6", paramString3);
    localIntent.putExtra("reserve7", paramString4);
    localIntent.putExtra("reserve8", paramString5);
    paramContext.sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.androidqqmail.tim.TimReportManager
 * JD-Core Version:    0.7.0.1
 */