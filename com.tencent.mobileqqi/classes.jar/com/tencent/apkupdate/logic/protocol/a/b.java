package com.tencent.apkupdate.logic.protocol.a;

import android.os.Message;
import com.qq.taf.jce.JceStruct;
import com.tencent.apkupdate.logic.protocol.jce.ApkFileInfo;
import com.tencent.apkupdate.logic.protocol.jce.ReportApkFileInfoRequest;
import com.tencent.apkupdate.logic.protocol.jce.ReportApkFileInfoResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
  extends com.tencent.apkupdate.logic.protocol.a
{
  private final List a;
  
  public b(List paramList)
  {
    this.a = paramList;
  }
  
  protected final void a()
  {
    super.a();
    ReportApkFileInfoRequest localReportApkFileInfoRequest = new ReportApkFileInfoRequest();
    localReportApkFileInfoRequest.apkFileInfoList = ((ArrayList)this.a);
    a(localReportApkFileInfoRequest);
  }
  
  protected final void a(JceStruct paramJceStruct1, JceStruct paramJceStruct2)
  {
    if ((paramJceStruct2 != null) && ((paramJceStruct2 instanceof ReportApkFileInfoResponse)) && (((ReportApkFileInfoResponse)paramJceStruct2).ret == 0))
    {
      paramJceStruct2 = com.tencent.apkupdate.logic.a.a().obtainMessage();
      paramJceStruct2.what = 3;
      paramJceStruct2.sendToTarget();
      if (paramJceStruct1 != null)
      {
        paramJceStruct2 = (ReportApkFileInfoRequest)paramJceStruct1;
        paramJceStruct1 = new ArrayList();
        paramJceStruct2 = paramJceStruct2.apkFileInfoList.iterator();
        while (paramJceStruct2.hasNext()) {
          paramJceStruct1.add(((ApkFileInfo)paramJceStruct2.next()).packageName);
        }
        if (paramJceStruct1.size() > 0)
        {
          paramJceStruct2 = com.tencent.apkupdate.logic.a.a().obtainMessage();
          paramJceStruct2.what = 8;
          paramJceStruct2.obj = paramJceStruct1;
          paramJceStruct2.sendToTarget();
        }
      }
    }
  }
  
  protected final void b()
  {
    Message localMessage = com.tencent.apkupdate.logic.a.a().obtainMessage();
    localMessage.what = 4;
    localMessage.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.apkupdate.logic.protocol.a.b
 * JD-Core Version:    0.7.0.1
 */