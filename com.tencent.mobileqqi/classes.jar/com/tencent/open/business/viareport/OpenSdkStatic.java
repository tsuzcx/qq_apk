package com.tencent.open.business.viareport;

import android.os.Bundle;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;

public class OpenSdkStatic
{
  protected static OpenSdkStatic a;
  
  public static OpenSdkStatic a()
  {
    try
    {
      if (a == null) {
        a = new OpenSdkStatic();
      }
      OpenSdkStatic localOpenSdkStatic = a;
      return localOpenSdkStatic;
    }
    finally {}
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Bundle paramBundle, boolean paramBoolean)
  {
    try
    {
      CommonDataAdapter.a().a(Integer.valueOf(paramString1).intValue());
      label14:
      Object localObject = ReportConfig.a();
      String str = String.valueOf(CommonDataAdapter.a().a());
      if (!((String)localObject).equals(str))
      {
        ReportManager.a().a((String)localObject, new BatchReportInfo(), null, true);
        ReportConfig.a(str);
      }
      localObject = new BatchReportInfo();
      ((BatchReportInfo)localObject).c = paramString4;
      ((BatchReportInfo)localObject).a = paramString2;
      ((BatchReportInfo)localObject).f = APNUtil.a(CommonDataAdapter.a().a());
      ((BatchReportInfo)localObject).e = paramString5;
      ((BatchReportInfo)localObject).d = paramString1;
      ((BatchReportInfo)localObject).b = paramString3;
      ((BatchReportInfo)localObject).g = String.valueOf(System.currentTimeMillis());
      ReportManager.a().a((BatchReportInfo)localObject, paramBundle, paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      break label14;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    a(paramString1, paramString2, paramString3, paramString4, CommonDataAdapter.a().e(), null, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.business.viareport.OpenSdkStatic
 * JD-Core Version:    0.7.0.1
 */