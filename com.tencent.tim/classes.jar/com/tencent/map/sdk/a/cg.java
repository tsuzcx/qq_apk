package com.tencent.map.sdk.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public final class cg
{
  public String a = "";
  public int b = 0;
  public String c = "";
  public String d = "";
  public int e;
  
  public cg()
  {
    try
    {
      this.a = ac.a().getPackageName();
      PackageInfo localPackageInfo = ac.a().getPackageManager().getPackageInfo(this.a, 0);
      this.b = localPackageInfo.versionCode;
      this.c = localPackageInfo.versionName;
      this.e = ac.c();
      this.d = "";
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.cg
 * JD-Core Version:    0.7.0.1
 */