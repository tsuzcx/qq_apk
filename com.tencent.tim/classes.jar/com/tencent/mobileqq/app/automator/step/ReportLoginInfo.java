package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import anot;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import mqq.app.MobileQQ;

public class ReportLoginInfo
  extends AsyncStep
{
  private String SP_MARK_TIME = "mark_time_";
  private String TIME_STAMP_NAME = "byte_data_time_stamp";
  
  private String md5sum(String paramString)
  {
    int i = 0;
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes(Charset.forName("US-ASCII")), 0, paramString.length());
      paramString = new StringBuilder();
      localObject = ((MessageDigest)localObject).digest();
      int j = localObject.length;
      while (i < j)
      {
        paramString.append(String.format("%02x", new Object[] { Integer.valueOf(localObject[i] & 0xFF) }));
        i += 1;
      }
      paramString = paramString.toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  private void report()
  {
    try
    {
      String str2 = this.a.app.getCurrentAccountUin();
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      str2 = md5sum(str1);
      long l = this.a.app.getApplication().getSharedPreferences(this.SP_MARK_TIME + str2, 0).getLong(this.TIME_STAMP_NAME, 0L);
      anot.c(this.a.app, "dc00899", "TSTViewTime", str1, "AChanged", "2", 0, 0, SecUtil.toHexString(NetConnInfoCenter.GUID), "", "", String.valueOf(l));
      if (QLog.isColorLevel()) {
        QLog.d("ReportLoginInfo", 2, "---> report login! --- uin: " + str1 + " Guid: " + SecUtil.toHexString(NetConnInfoCenter.GUID) + " reportID： " + l);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public int od()
  {
    report();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.ReportLoginInfo
 * JD-Core Version:    0.7.0.1
 */