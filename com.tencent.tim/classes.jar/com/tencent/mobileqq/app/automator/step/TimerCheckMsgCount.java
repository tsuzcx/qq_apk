package com.tencent.mobileqq.app.automator.step;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Environment;
import android.text.TextUtils;
import anpc;
import ausc;
import awit;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TimerCheckMsgCount
  extends AsyncStep
{
  public static String bqr = "com.ss.android.article.news";
  public static String bqs = "com.ss.android.article.lite";
  public static String bqt = "com.tencent.reading";
  public static String bqu = "com.tencent.readingplus";
  private long Re;
  private long Rf;
  private String bqv;
  private Context mContext;
  private List<String> xV;
  
  private void cNI()
  {
    if (this.a.app != null) {
      this.mContext = this.a.app.getApp();
    }
    this.xV = new ArrayList();
    this.bqv = awit.f(this.a.app);
    long l = System.currentTimeMillis();
    Object localObject4 = jx(bqr);
    Object localObject3 = jx(bqs);
    Object localObject2 = jx(bqt);
    Object localObject1 = jx(bqu);
    this.Re = (System.currentTimeMillis() - l);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 2, "Scan Package Time: " + this.Re);
    }
    l = System.currentTimeMillis();
    Object localObject5;
    Object localObject6;
    if (!TextUtils.isEmpty((CharSequence)localObject4))
    {
      q(new File(jv(bqr)));
      if (!this.xV.isEmpty())
      {
        localObject5 = this.xV.iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (String)((Iterator)localObject5).next();
          if (!TextUtils.isEmpty((CharSequence)localObject6))
          {
            HashMap localHashMap = new HashMap();
            localHashMap.put("tt_product_no", "1");
            localHashMap.put("tt_version_code", localObject4);
            localHashMap.put("tt_report_time", localObject6);
            localHashMap.put("uin", this.a.app.getCurrentAccountUin());
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.tt_report", 2, new Object[] { bqr, " dateString: ", localObject6 });
            }
            anpc.a(this.a.app.getApp()).collectPerformance(this.a.app.getCurrentAccountUin(), "actReadInJoyReportTT", true, 1L, 0L, localHashMap, null, false);
          }
        }
      }
    }
    this.xV.clear();
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      q(new File(jv(bqs)));
      if (!this.xV.isEmpty())
      {
        localObject4 = this.xV.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (String)((Iterator)localObject4).next();
          if (!TextUtils.isEmpty((CharSequence)localObject5))
          {
            localObject6 = new HashMap();
            ((HashMap)localObject6).put("tt_product_no", "0");
            ((HashMap)localObject6).put("tt_version_code", localObject3);
            ((HashMap)localObject6).put("tt_report_time", localObject5);
            ((HashMap)localObject6).put("uin", this.a.app.getCurrentAccountUin());
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.tt_report", 2, new Object[] { bqs, " dateString: ", localObject5 });
            }
            anpc.a(this.a.app.getApp()).collectPerformance(this.a.app.getCurrentAccountUin(), "actReadInJoyReportTT", true, 1L, 0L, (HashMap)localObject6, null, false);
          }
        }
      }
    }
    this.xV.clear();
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      q(new File(jw(bqt)));
      if (!this.xV.isEmpty())
      {
        localObject3 = this.xV.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            localObject5 = new HashMap();
            ((HashMap)localObject5).put("kb_product_no", "1");
            ((HashMap)localObject5).put("kb_version_code", localObject2);
            ((HashMap)localObject5).put("kb_report_time", localObject4);
            ((HashMap)localObject5).put("uin", this.a.app.getCurrentAccountUin());
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.tt_report", 2, new Object[] { bqt, " dateString: ", localObject4 });
            }
            anpc.a(this.a.app.getApp()).collectPerformance(this.a.app.getCurrentAccountUin(), "actReadInJoyReportKB", true, 1L, 0L, (HashMap)localObject5, null, false);
          }
        }
      }
    }
    this.xV.clear();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      q(new File(jw(bqu)));
      if (!this.xV.isEmpty())
      {
        localObject2 = this.xV.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject4 = new HashMap();
            ((HashMap)localObject4).put("kb_product_no", "0");
            ((HashMap)localObject4).put("kb_version_code", localObject1);
            ((HashMap)localObject4).put("kb_report_time", localObject3);
            ((HashMap)localObject4).put("uin", this.a.app.getCurrentAccountUin());
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.tt_report", 2, new Object[] { bqu, " dateString: ", localObject3 });
            }
            anpc.a(this.a.app.getApp()).collectPerformance(this.a.app.getCurrentAccountUin(), "actReadInJoyReportKB", true, 1L, 0L, (HashMap)localObject4, null, false);
          }
        }
      }
    }
    this.Rf = (System.currentTimeMillis() - l);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 2, "Scan Directory Time: " + this.Rf);
    }
    localObject1 = new Date();
    localObject2 = new SimpleDateFormat("yyyy.MM.dd");
    awit.o(this.a.app, ((DateFormat)localObject2).format((Date)localObject1));
    localObject1 = ((DateFormat)localObject2).format((Date)localObject1);
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("uin", this.a.app.getCurrentAccountUin());
    ((HashMap)localObject2).put("report_time", localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 2, new Object[] { "uin: ", this.a.app.getCurrentAccountUin(), ", report_time: ", localObject1 });
    }
    anpc.a(this.a.app.getApp()).collectPerformance(this.a.app.getCurrentAccountUin(), "actReadInJoyReportTTKB", true, 1L, 0L, (HashMap)localObject2, null, false);
  }
  
  private String jv(String paramString)
  {
    return Environment.getExternalStorageDirectory().getPath() + "/Android" + Environment.getDataDirectory() + "/" + paramString + "/cache/hashedimages";
  }
  
  private String jw(String paramString)
  {
    return Environment.getExternalStorageDirectory().getPath() + "/Android" + Environment.getDataDirectory() + "/" + paramString + "/files/data/news_image";
  }
  
  private String jx(String paramString)
  {
    try
    {
      paramString = ausc.getPackageInfo(BaseApplicationImpl.getContext(), paramString);
      if (paramString != null)
      {
        paramString = paramString.versionName;
        return paramString;
      }
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      QLog.i("QQInitHandler", 1, "[getAppVersion], e = " + paramString);
    }
    return "null";
  }
  
  private void q(File paramFile)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        paramFile = paramFile.listFiles();
        int j = paramFile.length;
        if (i < j)
        {
          File localFile = paramFile[i];
          if (localFile.isDirectory())
          {
            q(localFile);
          }
          else if (localFile.isFile())
          {
            Object localObject = new Date(localFile.lastModified());
            localObject = new SimpleDateFormat("yyyy.MM.dd").format((Date)localObject);
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.tt_report", 2, new Object[] { "filePath: ", localFile.getPath(), ", time: ", localObject });
            }
            if (((TextUtils.isEmpty(this.bqv)) || (((String)localObject).compareTo(this.bqv) >= 0)) && (!this.xV.contains(localObject))) {
              this.xV.add(localObject);
            }
          }
        }
      }
      catch (Exception paramFile)
      {
        paramFile.printStackTrace();
        QLog.d("Q.readinjoy.tt_report", 1, paramFile.toString());
      }
      return;
      i += 1;
    }
  }
  
  public int od()
  {
    ThreadManager.executeOnNetWorkThread(new TimerCheckMsgCount.1(this));
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.TimerCheckMsgCount
 * JD-Core Version:    0.7.0.1
 */