package com.tencent.smtt.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.smtt.sdk.c.a;

final class q$7
  implements c.a
{
  q$7(Context paramContext) {}
  
  public void a(String paramString)
  {
    SharedPreferences.Editor localEditor = this.a.getSharedPreferences("sai", 0).edit();
    localEditor.putBoolean("scfh", false);
    localEditor.commit();
    TbsLog.e("TbsUtils", "Execute command [1009](" + paramString + ")");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.utils.q.7
 * JD-Core Version:    0.7.0.1
 */