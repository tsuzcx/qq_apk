package com.tencent.smtt.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.smtt.sdk.c.a;

final class q$14
  implements c.a
{
  q$14(Context paramContext) {}
  
  public void a(String paramString)
  {
    SharedPreferences.Editor localEditor = this.a.getSharedPreferences("sai", 0).edit();
    localEditor.putBoolean("ucst", false);
    localEditor.commit();
    TbsLog.e("TbsUtils", "Execute command [1016](" + paramString + ")");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.utils.q.14
 * JD-Core Version:    0.7.0.1
 */