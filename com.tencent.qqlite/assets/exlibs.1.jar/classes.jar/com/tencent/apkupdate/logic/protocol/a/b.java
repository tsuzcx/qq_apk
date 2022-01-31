package com.tencent.apkupdate.logic.protocol.a;

import android.os.Message;
import com.qq.taf.jce.JceStruct;
import com.tencent.apkupdate.c.f;
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
    Object localObject = new ReportApkFileInfoRequest();
    ((ReportApkFileInfoRequest)localObject).apkFileInfoList = ((ArrayList)this.a);
    a((JceStruct)localObject);
    localObject = new StringBuffer("UploadApkHttpRequest:prepareData;apkFileInfoList= [");
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ApkFileInfo localApkFileInfo = (ApkFileInfo)localIterator.next();
      ((StringBuffer)localObject).append("pkgname=" + localApkFileInfo.packageName + ";apkId=" + localApkFileInfo.apkId + "| \n\r");
    }
    f.a("UploadApkHttpRequest", ((StringBuffer)localObject).toString() + "]");
  }
  
  protected final void a(JceStruct paramJceStruct1, JceStruct paramJceStruct2)
  {
    if ((paramJceStruct2 != null) && ((paramJceStruct2 instanceof ReportApkFileInfoResponse)))
    {
      paramJceStruct2 = (ReportApkFileInfoResponse)paramJceStruct2;
      f.a("UploadApkHttpRequest", "UploadApkHttpRequest:onFinished; ret=" + paramJceStruct2.ret);
      if (paramJceStruct2.ret == 0)
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
  }
  
  protected final void b()
  {
    Message localMessage = com.tencent.apkupdate.logic.a.a().obtainMessage();
    localMessage.what = 4;
    localMessage.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.apkupdate.logic.protocol.a.b
 * JD-Core Version:    0.7.0.1
 */