package com.tencent.open.business.base.appreport;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import arwo;
import arwt;
import arxh;
import arxn;
import arxu;
import arxu.a;
import arxv;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;

public final class AppReport$1
  implements Runnable
{
  public AppReport$1(String paramString1, int paramInt, Context paramContext, String paramString2, WebView paramWebView, String paramString3) {}
  
  public void run()
  {
    int m = 0;
    for (;;)
    {
      try
      {
        arwt.i("AppReport", "<AppReport> begin incrementalReport,packageName : " + this.val$packageName + ", packageType :" + this.eli);
        if (this.Z == null)
        {
          arwt.e("AppReport", "<AppReport> incrementalReport context is null !");
          return;
        }
        HashMap localHashMap = new HashMap();
        Object localObject2;
        Object localObject3;
        int k;
        if ((this.val$packageName == null) || (!this.val$packageName.equals("com.tencent.android.qqdownloader")) || (this.eli != 8))
        {
          Object localObject1 = this.Z.getSharedPreferences("appcenter_app_report", 0);
          boolean bool1 = ((SharedPreferences)localObject1).getBoolean("is_app_last_fullReport_success", false);
          if (!arxn.ct(this.Z))
          {
            arwt.d("AppReport", "<AppReport> Package scan is closed !!!!");
            if (bool1)
            {
              j = this.eli;
              i = j;
            }
            try
            {
              if (!TextUtils.isEmpty(this.val$packageName))
              {
                localObject1 = this.Z.getPackageManager().getPackageInfo(this.val$packageName, 0);
                if ((((PackageInfo)localObject1).applicationInfo.flags & 0x1) != 0) {
                  continue;
                }
                i = j;
                if ((((PackageInfo)localObject1).applicationInfo.flags & 0x80) != 0) {
                  continue;
                }
              }
              arxu.aR(this.Z, this.val$packageName, i);
            }
            catch (PackageManager.NameNotFoundException localNameNotFoundException1)
            {
              arwt.d("AppReport", "<AppReport> Package scan is closed, get packageinfo error : " + localNameNotFoundException1.toString());
              continue;
            }
            if ((this.cDb != null) && (this.val$webView != null)) {
              arxv.a(this.Z, this.val$webView, this.cDb, true, this.val$uin);
            }
          }
          else
          {
            long l = localNameNotFoundException1.getLong("app_last_fullReport_success_time", 0L);
            boolean bool2 = localNameNotFoundException1.getBoolean("is_incremental_report_overflow", false);
            if (l != 0L)
            {
              if (!bool1)
              {
                arwt.d("AppReport", "last full report failed , do incremental report !!!");
                arxu.a(this.Z, this.cDb, this.val$webView, this.val$uin, true);
                return;
              }
              if (bool2)
              {
                arwt.d("AppReport", "last incremental report overflow , do full report !!!");
                arxu.a(this.Z, this.cDb, this.val$webView, this.val$uin, true);
                return;
              }
              localObject2 = arxu.l(this.Z);
              if ((localObject2 != null) && (((Map)localObject2).size() >= 70))
              {
                arxu.mLock.lock();
                this.Z.deleteFile("appcenter_app_report_storage_file.txt");
                arxu.mLock.unlock();
                localObject2 = this.Z.getSharedPreferences("appcenter_app_report", 0).edit();
                ((SharedPreferences.Editor)localObject2).putBoolean("is_incremental_report_overflow", true);
                ((SharedPreferences.Editor)localObject2).commit();
                arxu.a(this.Z, this.cDb, this.val$webView, this.val$uin, true);
                return;
              }
              if ((localObject2 != null) && (((Map)localObject2).size() > 0)) {
                localHashMap.putAll((Map)localObject2);
              }
              localObject3 = new StringBuilder().append("<AppReport> increamental report package local size :");
              if (localObject2 == null) {
                break label1169;
              }
              i = ((Map)localObject2).size();
              arwt.i("AppReport", i);
            }
          }
        }
        else
        {
          k = this.eli;
          j = k;
          String str1;
          String str2;
          if (this.cDb == null)
          {
            j = k;
            if (this.val$packageName != null)
            {
              str1 = "0";
              str2 = " ";
              localObject2 = str2;
              localObject3 = str1;
              i = m;
            }
          }
          try
          {
            localObject4 = this.Z.getPackageManager().getPackageInfo(this.val$packageName, 0);
            localObject2 = str2;
            localObject3 = str1;
            i = m;
            m = ((PackageInfo)localObject4).versionCode;
            localObject2 = str2;
            localObject3 = str1;
            i = m;
            str1 = ((PackageInfo)localObject4).versionName;
            localObject2 = str2;
            localObject3 = str1;
            i = m;
            str2 = arxn.aq(this.Z, this.val$packageName);
            localObject2 = str2;
            localObject3 = str1;
            i = m;
            if ((((PackageInfo)localObject4).applicationInfo.flags & 0x1) == 0)
            {
              localObject2 = str2;
              localObject3 = str1;
              i = m;
              int i1 = ((PackageInfo)localObject4).applicationInfo.flags;
              j = k;
              localObject4 = str2;
              localObject5 = str1;
              n = m;
              if ((i1 & 0x80) == 0) {}
            }
            else
            {
              j = k | 0x1;
              n = m;
              localObject5 = str1;
              localObject4 = str2;
            }
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException2)
          {
            j = k;
            Object localObject4 = localObject2;
            Object localObject5 = localObject3;
            int n = i;
            if (this.eli == 8) {
              continue;
            }
            arwt.e("AppReport", "<AppReport> get Package info form package <" + this.val$packageName + "> error : " + localNameNotFoundException2.toString());
            j = k;
            localObject4 = localObject2;
            localObject5 = localObject3;
            n = i;
            continue;
            arwt.i("AppReport", "<AppReport> increamental report package size : " + localHashMap.size());
            localObject2 = arxu.a(this.Z, localHashMap, "INC", this.val$uin);
            arwt.i("AppReport", "<AppReport> incremental report params : " + ((Bundle)localObject2).toString());
            if (arwo.isNetworkAvailable(this.Z)) {
              continue;
            }
            arxu.aR(this.Z, this.val$packageName, j);
            return;
            if (!TextUtils.isEmpty(((Bundle)localObject2).getString("sid"))) {
              continue;
            }
            if ((this.val$packageName == null) || (!this.val$packageName.equals("com.tencent.android.qqdownloader")) || (this.eli != 8)) {
              continue;
            }
            arwt.i("AppReport", "<AppReport> incremental report sid is null but still report myapp uninstall event");
            ((Bundle)localObject2).putString("sid", "fakesid");
            new arxh("http://fusionbase.qq.com/cgi-bin/appstage/sdk_update", "POST", new arxu.a(this.Z, this.val$packageName, j, this.cDb, this.val$webView)).execute(new Bundle[] { localObject2 });
            return;
            arxu.aR(this.Z, this.val$packageName, j);
            return;
            new arxh("http://fusionbase.qq.com/cgi-bin/appstage/sdk_update", "POST", new arxu.a(this.Z, this.val$packageName, j, this.cDb, this.val$webView)).execute(new Bundle[] { localObject2 });
          }
          localHashMap.put(this.val$packageName, arxu.a(this.val$packageName, n, (String)localObject5, j, (String)localObject4));
          if (localHashMap.size() <= 0)
          {
            arwt.i("AppReport", "<AppReport> Nothing to report, Incremental report finished !");
            return;
          }
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        int j;
        return;
      }
      int i = j | 0x1;
      continue;
      label1169:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.business.base.appreport.AppReport.1
 * JD-Core Version:    0.7.0.1
 */