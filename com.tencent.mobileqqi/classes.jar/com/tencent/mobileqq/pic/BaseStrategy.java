package com.tencent.mobileqq.pic;

import android.os.Bundle;
import com.tencent.mobileqq.activity.PredownloadTest.ConfigInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.servlet.ReportServlet;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public abstract class BaseStrategy
  implements PreDownloadStrategy, BusinessObserver
{
  public static final String a = "UseLocalFlowSet";
  public static final String b = "MaxWifiFlow";
  public static long c = 0L;
  public static final String c = "Max4GFlow";
  public static long d = 0L;
  public static final String d = "Max3GFlow";
  public static final String e = "Max2GFlow";
  public static final String f = "PreDownPolicy";
  public static final String g = "PicDTPt2";
  protected long a;
  QQAppInterface a;
  protected long b;
  public long e = 524288000L;
  public long f = 10485760L;
  public long g = 10485760L;
  public long h = 5242880L;
  
  public PredownloadTest.ConfigInfo a()
  {
    return null;
  }
  
  public void a()
  {
    c = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "UseLocalFlowSet", 0L);
    d = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "PicDTPt2", 0L);
    this.e = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "MaxWifiFlow", 524288000L);
    this.f = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Max4GFlow", 10485760L);
    this.g = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Max3GFlow", 10485760L);
    this.h = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Max2GFlow", 5242880L);
  }
  
  public void a(PredownloadTest.ConfigInfo paramConfigInfo) {}
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.registObserver(this);
    a();
  }
  
  public boolean a(long paramLong, int paramInt1, int paramInt2)
  {
    b();
    if (paramInt2 == 0)
    {
      if (this.b >= this.e)
      {
        PicReporter.a(paramInt2, this.e);
        Logger.a("PIC_TAG_PRELOAD", "isOverLimit", "result:true,netWokrType:" + paramInt2 + ",picTrafficFlowWIFI:" + this.b);
        return true;
      }
    }
    else if (paramInt2 == 1)
    {
      if (this.jdField_a_of_type_Long >= this.f)
      {
        PicReporter.a(paramInt2, this.f);
        Logger.a("PIC_TAG_PRELOAD", "isOverLimit", "result:true,netWokrType:" + paramInt2 + ",picTrafficFlowXG:" + this.jdField_a_of_type_Long);
        return true;
      }
    }
    else if (paramInt2 == 2)
    {
      if (this.jdField_a_of_type_Long >= this.g)
      {
        PicReporter.a(paramInt2, this.g);
        Logger.a("PIC_TAG_PRELOAD", "isOverLimit", "result:true,netWokrType:" + paramInt2 + ",picTrafficFlowXG:" + this.jdField_a_of_type_Long);
        return true;
      }
    }
    else if ((paramInt2 == 3) && (this.jdField_a_of_type_Long >= this.h))
    {
      PicReporter.a(paramInt2, this.h);
      Logger.a("PIC_TAG_PRELOAD", "isOverLimit", "result:true,netWokrType:" + paramInt2 + ",picTrafficFlowXG:" + this.jdField_a_of_type_Long);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ReportServlet.class);
    localNewIntent.putExtra("sendType", 3);
    localNewIntent.putExtra("tags", new String[] { "param_XGC2CPicDownloadFlow", "param_XGGroupPicDownloadFlow", "param_WIFIC2CPicDownloadFlow", "param_WIFIGroupPicDownloadFlow" });
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((3 == paramInt) && (paramBoolean))
    {
      paramBundle = paramBundle.getLongArray("__base_tag_curentDay");
      if ((paramBundle != null) && (paramBundle.length == 4))
      {
        this.jdField_a_of_type_Long = (paramBundle[0] + paramBundle[1]);
        this.b = (paramBundle[2] + paramBundle[3]);
        Logger.a("PIC_TAG_PRELOAD", "", "onReceive", "picTrafficFlowXG:" + this.jdField_a_of_type_Long + ",C2CPicDownFlowXG:" + paramBundle[0] + ",Group/DiscussPicDownFlowXG:" + paramBundle[1] + ",\npicTrafficFlowWIFI:" + this.b + ",C2CPicDownFlowWIFI:" + paramBundle[2] + ",Group/DiscussPicDownFlowWIFI:" + paramBundle[3]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.BaseStrategy
 * JD-Core Version:    0.7.0.1
 */