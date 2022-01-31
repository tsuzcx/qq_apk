package com.tencent.mobileqq.mtt;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;

public class MttData
{
  public static final int a = 4;
  public static final String a = "FLAGS";
  public static final boolean a = true;
  public static final int b = 5;
  public static final String b = "ACTION";
  public static final int c = 6;
  public static final String c = "CATEGORYS";
  public static final int d = 7;
  public static final String d = "KEY_PID";
  public static final int e = 50079;
  public static final String e = "KEY_EUSESTAT";
  private static final String jdField_f_of_type_JavaLangString = "com.tencent.QQBrowser.action.VIEW";
  private static final String jdField_g_of_type_JavaLangString = "KEY_APPNAME";
  private static final String h = "KEY_PKG";
  private static final String i = "KEY_ACT";
  private static final String j = "KEY_PENDINGINTENT";
  private static final String k = "TASK_ID";
  private PendingIntent jdField_a_of_type_AndroidAppPendingIntent;
  private Uri jdField_a_of_type_AndroidNetUri;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int jdField_f_of_type_Int;
  private int jdField_g_of_type_Int;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  private String q;
  
  public MttData() {}
  
  public MttData(String paramString1, String paramString2, String paramString3, PendingIntent paramPendingIntent, Uri paramUri, Bundle paramBundle, int paramInt)
  {
    this.m = paramString1;
    this.l = paramString2;
    this.n = paramString3;
    this.jdField_a_of_type_AndroidAppPendingIntent = paramPendingIntent;
    if ((this.l == null) && (paramPendingIntent != null)) {
      this.l = paramPendingIntent.getTargetPackage();
    }
    this.jdField_a_of_type_AndroidNetUri = paramUri;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.f = paramInt;
    if (paramBundle != null)
    {
      this.q = paramBundle.getString("ACTION");
      this.g = paramBundle.getInt("FLAGS", -1);
      this.jdField_a_of_type_ArrayOfJavaLangString = paramBundle.getStringArray("CATEGORYS");
      this.o = paramBundle.getString("KEY_PID");
      this.p = paramBundle.getString("KEY_EUSESTAT");
    }
  }
  
  public int a()
  {
    return this.g;
  }
  
  public PendingIntent a()
  {
    return this.jdField_a_of_type_AndroidAppPendingIntent;
  }
  
  public Intent a()
  {
    Intent localIntent = new Intent("com.tencent.QQBrowser.action.VIEW");
    localIntent.setData(this.jdField_a_of_type_AndroidNetUri);
    localIntent.putExtra("KEY_APPNAME", this.m);
    localIntent.putExtra("KEY_PKG", "com.tencent.qq");
    localIntent.putExtra("KEY_ACT", this.n);
    localIntent.putExtra("KEY_PID", this.o);
    localIntent.putExtra("KEY_EUSESTAT", this.p);
    if (this.jdField_a_of_type_AndroidAppPendingIntent != null) {
      localIntent.putExtra("KEY_PENDINGINTENT", this.jdField_a_of_type_AndroidAppPendingIntent);
    }
    if (this.f >= 0) {
      localIntent.putExtra("TASK_ID", this.f);
    }
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    }
    localIntent.setFlags(268435456);
    return localIntent;
  }
  
  public Drawable a(Context paramContext)
  {
    if (paramContext == null) {}
    PackageManager localPackageManager;
    int i1;
    do
    {
      return null;
      localPackageManager = paramContext.getPackageManager();
      try
      {
        Drawable localDrawable = localPackageManager.getApplicationIcon(this.l);
        return localDrawable;
      }
      catch (Exception localException)
      {
        i1 = this.f;
      }
    } while (i1 <= 0);
    for (;;)
    {
      try
      {
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(10).iterator();
        if (paramContext.hasNext())
        {
          ActivityManager.RunningTaskInfo localRunningTaskInfo = (ActivityManager.RunningTaskInfo)paramContext.next();
          if (localRunningTaskInfo.id != i1) {
            continue;
          }
          paramContext = localPackageManager.getApplicationIcon(localRunningTaskInfo.baseActivity.getPackageName());
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        return null;
      }
      paramContext = null;
    }
  }
  
  public Uri a()
  {
    return this.jdField_a_of_type_AndroidNetUri;
  }
  
  public Bundle a()
  {
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  public String a()
  {
    return this.m;
  }
  
  public boolean a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    this.m = paramIntent.getStringExtra("KEY_APPNAME");
    this.l = paramIntent.getStringExtra("KEY_PKG");
    this.n = paramIntent.getStringExtra("KEY_ACT");
    this.jdField_a_of_type_AndroidAppPendingIntent = ((PendingIntent)paramIntent.getParcelableExtra("KEY_PENDINGINTENT"));
    if ((this.l == null) && (this.jdField_a_of_type_AndroidAppPendingIntent != null)) {
      this.l = this.jdField_a_of_type_AndroidAppPendingIntent.getTargetPackage();
    }
    this.f = paramIntent.getIntExtra("TASK_ID", -1);
    this.jdField_a_of_type_AndroidOsBundle = paramIntent.getExtras();
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      this.q = this.jdField_a_of_type_AndroidOsBundle.getString("ACTION");
      this.g = this.jdField_a_of_type_AndroidOsBundle.getInt("FLAGS", -1);
      this.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_AndroidOsBundle.getStringArray("CATEGORYS");
      this.o = this.jdField_a_of_type_AndroidOsBundle.getString("KEY_PID");
      this.p = this.jdField_a_of_type_AndroidOsBundle.getString("KEY_EUSESTAT");
    }
    this.jdField_a_of_type_AndroidNetUri = paramIntent.getData();
    return true;
  }
  
  public String[] a()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public int b()
  {
    return this.f;
  }
  
  public String b()
  {
    return this.l;
  }
  
  public String c()
  {
    return this.n;
  }
  
  public String d()
  {
    return this.q;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.mtt.MttData
 * JD-Core Version:    0.7.0.1
 */