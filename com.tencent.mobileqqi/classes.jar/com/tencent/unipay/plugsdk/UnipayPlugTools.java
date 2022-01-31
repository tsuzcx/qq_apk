package com.tencent.unipay.plugsdk;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.RemoteException;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class UnipayPlugTools
{
  private String DownLoadURL = "http://imgcache.qq.com/bossweb/midas/TencentUnipay.apk";
  public String LOG_TAG = "TencentUnipay";
  private int SDK_SUPPORT_MIN_VERSION = 4;
  private Context context = null;
  private boolean installed = false;
  
  public UnipayPlugTools(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void intallTencentUnipayFromInternet()
  {
    if (!this.DownLoadURL.equals(""))
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(this.DownLoadURL));
      this.context.startActivity(localIntent);
    }
  }
  
  public static void invokeCallBack(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2)
  {
    try
    {
      UnipayPlugAPI.unipayPlugCallBack.UnipayCallBack(paramInt1, paramInt2, paramInt3, paramInt4, 0, paramString1, paramString2);
      return;
    }
    catch (RemoteException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public boolean checkUnipayAPP()
  {
    Object localObject;
    if (!isInstalledTencentUnipay(this.context)) {
      localObject = null;
    }
    try
    {
      localInputStream = this.context.getClass().getResourceAsStream("/assets/TencentUnipay.apk");
      localObject = localInputStream;
    }
    catch (Exception localException2)
    {
      InputStream localInputStream;
      label28:
      label190:
      break label28;
    }
    if (localObject != null)
    {
      localObject = new AlertDialog.Builder(this.context);
      ((AlertDialog.Builder)localObject).setTitle("安全提示");
      ((AlertDialog.Builder)localObject).setMessage("您还没有安装腾讯安全支付插件,请先安装");
      ((AlertDialog.Builder)localObject).setPositiveButton("确认", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          UnipayPlugTools.this.installTencentUnipayFromSDcard(UnipayPlugTools.this.context, "TencentUnipay.apk");
        }
      });
      ((AlertDialog.Builder)localObject).setNegativeButton("取消", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          UnipayPlugTools.this.installed = false;
          UnipayPlugTools.invokeCallBack(-1, -1, -1, -1, "取消安装回调", null);
        }
      });
      ((AlertDialog.Builder)localObject).show();
    }
    for (;;)
    {
      return this.installed;
      localObject = new AlertDialog.Builder(this.context);
      ((AlertDialog.Builder)localObject).setTitle("安全提示");
      ((AlertDialog.Builder)localObject).setMessage("您还没有安装腾讯安全支付插件,请先下载安装");
      ((AlertDialog.Builder)localObject).setPositiveButton("确认", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          UnipayPlugTools.this.intallTencentUnipayFromInternet();
        }
      });
      ((AlertDialog.Builder)localObject).setNegativeButton("取消", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          UnipayPlugTools.this.installed = false;
          UnipayPlugTools.invokeCallBack(-1, -1, -1, -1, "取消下载回调", null);
        }
      });
      ((AlertDialog.Builder)localObject).show();
      continue;
      if (isHasHighVersionInAssets(this.context)) {
        localObject = null;
      }
      try
      {
        localInputStream = this.context.getClass().getResourceAsStream("/assets/TencentUnipay.apk");
        localObject = localInputStream;
      }
      catch (Exception localException1)
      {
        int i;
        break label190;
      }
      if (localObject != null)
      {
        localObject = new AlertDialog.Builder(this.context);
        ((AlertDialog.Builder)localObject).setTitle("安全提示");
        ((AlertDialog.Builder)localObject).setMessage("请您升级安全支付插件，免流量。");
        ((AlertDialog.Builder)localObject).setPositiveButton("确认", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            UnipayPlugTools.this.installTencentUnipayFromSDcard(UnipayPlugTools.this.context, "TencentUnipay.apk");
          }
        });
        ((AlertDialog.Builder)localObject).show();
      }
      else
      {
        this.installed = true;
        continue;
        i = getInstalledAPKVersion();
        if (this.SDK_SUPPORT_MIN_VERSION > i)
        {
          localObject = new AlertDialog.Builder(this.context);
          ((AlertDialog.Builder)localObject).setTitle("安全提示");
          ((AlertDialog.Builder)localObject).setMessage("您需要更新腾讯安全支付插件,请先下载更新");
          ((AlertDialog.Builder)localObject).setPositiveButton("确认", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              UnipayPlugTools.this.intallTencentUnipayFromInternet();
            }
          });
          ((AlertDialog.Builder)localObject).setNegativeButton("取消", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              UnipayPlugTools.this.installed = false;
              UnipayPlugTools.invokeCallBack(-1, -1, -1, -1, "取消下载回调", null);
            }
          });
          ((AlertDialog.Builder)localObject).show();
        }
        else
        {
          this.installed = true;
        }
      }
    }
  }
  
  public boolean copyApkFromAssets(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = paramContext.getAssets().open(paramString1);
      paramString1 = new File(paramString2);
      paramString1.createNewFile();
      paramString1 = new FileOutputStream(paramString1);
      paramString2 = new byte[1024];
      for (;;)
      {
        int i = paramContext.read(paramString2);
        if (i <= 0)
        {
          paramString1.flush();
          paramString1.close();
          paramContext.close();
          return true;
        }
        paramString1.write(paramString2, 0, i);
      }
      return false;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public int getInstalledAPKVersion()
  {
    int i = 0;
    if (isInstalledTencentUnipay(this.context)) {}
    try
    {
      i = this.context.getPackageManager().getPackageInfo("com.tencent.unipay", 0).versionCode;
      return i;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public void installTencentUnipayFromSDcard(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setAction("android.intent.action.VIEW");
    for (;;)
    {
      try
      {
        InputStream localInputStream = paramContext.getClass().getResourceAsStream("/assets/" + paramString);
        localFileOutputStream = paramContext.openFileOutput(paramString, 1);
        arrayOfByte = new byte[1024];
        i = localInputStream.read(arrayOfByte);
        if (i != -1) {
          continue;
        }
        localFileOutputStream.flush();
        localInputStream.close();
        localFileOutputStream.close();
      }
      catch (Exception localException)
      {
        FileOutputStream localFileOutputStream;
        byte[] arrayOfByte;
        int i;
        localException.printStackTrace();
        continue;
      }
      localIntent.setDataAndType(Uri.fromFile(new File(paramContext.getFilesDir().getPath() + "/" + paramString)), "application/vnd.android.package-archive");
      paramContext.startActivity(localIntent);
      return;
      localFileOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public boolean isHasHighVersionInAssets(Context paramContext)
  {
    String str = String.valueOf(paramContext.getCacheDir().getAbsolutePath()) + "/TencentUnipayTemp.apk";
    try
    {
      if (copyApkFromAssets(paramContext, "TencentUnipay.apk", str))
      {
        int i = paramContext.getPackageManager().getPackageArchiveInfo(str, 1).versionCode;
        int j = paramContext.getPackageManager().getPackageInfo("com.tencent.unipay", 0).versionCode;
        if (i > j) {
          return true;
        }
      }
      else
      {
        return false;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  public boolean isInstalledTencentUnipay(Context paramContext)
  {
    boolean bool = false;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.tencent.unipay", 0);
      if (paramContext != null) {
        bool = true;
      }
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = null;
        Log.i(this.LOG_TAG, "com.tencent.unipay is not installed.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.unipay.plugsdk.UnipayPlugTools
 * JD-Core Version:    0.7.0.1
 */