package com.tencent.open.downloadnew.common;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcommon.Common;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.downloadnew.DownloadManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

public class IntentFactory
{
  public static final int a = 1;
  protected static final String a = "IntentFactory";
  public static ArrayList a;
  public static final int b = 2;
  public static String b = "com.tencent.open.download.start";
  public static final int c = 3;
  public static String c = "com.tencent.open.download.pause";
  public static final int d = 4;
  public static String d = "com.tencent.open.download.restart";
  public static final int e = 5;
  public static String e = "com.tencent.open.download.complete";
  public static final int f = 6;
  public static String f = "com.tencent.open.download.open";
  public static String g = "com.tencent.open.download.yyb";
  
  static
  {
    a = new ArrayList();
    a.add(e);
    a.add(f);
    a.add(c);
    a.add(g);
    a.add(d);
    a.add(b);
  }
  
  public static PendingIntent a(int paramInt, NoticeParam paramNoticeParam)
  {
    Intent localIntent = new Intent();
    if (paramNoticeParam != null) {
      localIntent.putExtra("noticeParam", paramNoticeParam);
    }
    paramNoticeParam = Common.p();
    if (!TextUtils.isEmpty(paramNoticeParam)) {
      localIntent.putExtra("processName", paramNoticeParam);
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      return PendingIntent.getBroadcast(CommonDataAdapter.a().a(), (int)(System.currentTimeMillis() & 0xFFFFFFF), localIntent, 134217728);
      localIntent.setAction(c);
      continue;
      localIntent.setAction(b);
      continue;
      localIntent.setAction(e);
      continue;
      localIntent.setAction(g);
      continue;
      localIntent.setAction(f);
    }
  }
  
  protected static String a(Bundle paramBundle)
  {
    Object localObject1;
    if (paramBundle == null)
    {
      localObject1 = "";
      return localObject1;
    }
    String str3 = paramBundle.getString("id");
    LogUtility.b("IntentFactory", "appId=" + str3);
    String str5;
    if (!TextUtils.isEmpty(str3))
    {
      Object localObject2 = paramBundle.getString("downloadUrl");
      String str4 = paramBundle.getString("packageName");
      String str1 = paramBundle.getString("serverApkVersion");
      localObject1 = str1;
      if (str1 == null) {
        localObject1 = "0";
      }
      str5 = paramBundle.getString("via");
      String str2 = paramBundle.getString("splitvia");
      int j = AppUtil.a(str4);
      int k = AppUtil.b(DownloadManager.a().a(str3));
      if (APNUtil.c(CommonDataAdapter.a().a())) {}
      for (int i = 1;; i = 0)
      {
        try
        {
          str1 = URLEncoder.encode((String)localObject2, "utf-8");
          localObject2 = str1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            localUnsupportedEncodingException.printStackTrace();
            continue;
            paramBundle = paramBundle + "&via=" + str5;
          }
        }
        paramBundle = "&from=-10&id=" + str3 + "&channelId=" + paramBundle.getString("from") + "&installedVersion=" + String.valueOf(j) + "&localVersion=" + k + "&serverApkVersion=" + (String)localObject1 + "&typeId=" + "0" + "&msgType=" + "56" + "&sendTime=" + str3 + "&downloadUrl=" + (String)localObject2 + "&packageName=" + str4 + "&nt=" + i;
        if (!TextUtils.isEmpty(str5)) {
          break label334;
        }
        localObject1 = paramBundle;
        if (TextUtils.isEmpty(str2)) {
          break;
        }
        return paramBundle + "&splitvia=" + str2;
      }
    }
    label334:
    return "";
  }
  
  protected static boolean a(String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.IntentFactory
 * JD-Core Version:    0.7.0.1
 */