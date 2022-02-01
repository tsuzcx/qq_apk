package com.tencent.smtt.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.smtt.sdk.c.a;

final class b$4
  implements c.a
{
  b$4(Context paramContext) {}
  
  public void a(String paramString)
  {
    paramString = this.a.getSharedPreferences("sai", 0).edit();
    paramString.putBoolean("gpai", false);
    paramString.commit();
    TbsLog.e("TBSEmergency", "Execute command [1012](+extra+)");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.utils.b.4
 * JD-Core Version:    0.7.0.1
 */