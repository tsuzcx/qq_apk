package com.tencent.smtt.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.smtt.sdk.c.a;

final class b$2
  implements c.a
{
  b$2(Context paramContext) {}
  
  public void a(String paramString)
  {
    SharedPreferences.Editor localEditor = this.a.getSharedPreferences("sai", 0).edit();
    localEditor.putBoolean("pdi", false);
    localEditor.commit();
    TbsLog.e("TBSEmergency", "Execute command [1004](" + paramString + ")");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.utils.b.2
 * JD-Core Version:    0.7.0.1
 */