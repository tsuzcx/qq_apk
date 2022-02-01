package com.tencent.apkupdate.logic.protocol.a;

import android.os.Message;
import com.qq.taf.jce.JceStruct;
import com.tencent.apkupdate.b.i;
import com.tencent.apkupdate.logic.a;
import com.tencent.apkupdate.logic.protocol.BaseHttpRequest;
import com.tencent.apkupdate.logic.protocol.jce.ApkFileInfo;
import com.tencent.apkupdate.logic.protocol.jce.ReportApkFileInfoRequest;
import com.tencent.apkupdate.logic.protocol.jce.ReportApkFileInfoResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
  extends BaseHttpRequest
{
  private final List a;
  
  public b(List paramList)
  {
    this.a = paramList;
  }
  
  public final void onDataReceiveFailed()
  {
    Message localMessage = a.a().obtainMessage();
    localMessage.what = 4;
    localMessage.sendToTarget();
  }
  
  public final void onFinished(JceStruct paramJceStruct1, JceStruct paramJceStruct2)
  {
    if ((paramJceStruct2 != null) && ((paramJceStruct2 instanceof ReportApkFileInfoResponse)))
    {
      paramJceStruct2 = (ReportApkFileInfoResponse)paramJceStruct2;
      i.a("UploadApkHttpRequest", "UploadApkHttpRequest:onFinished; ret=" + paramJceStruct2.ret);
      if (paramJceStruct2.ret == 0)
      {
        paramJceStruct2 = a.a().obtainMessage();
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
            paramJceStruct2 = a.a().obtainMessage();
            paramJceStruct2.what = 8;
            paramJceStruct2.obj = paramJceStruct1;
            paramJceStruct2.sendToTarget();
          }
        }
      }
    }
  }
  
  public final void prepareData()
  {
    super.prepareData();
    Object localObject = new ReportApkFileInfoRequest();
    ((ReportApkFileInfoRequest)localObject).apkFileInfoList = ((ArrayList)this.a);
    setData((JceStruct)localObject);
    localObject = new StringBuffer("UploadApkHttpRequest:prepareData;apkFileInfoList= [");
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ApkFileInfo localApkFileInfo = (ApkFileInfo)localIterator.next();
      ((StringBuffer)localObject).append("pkgname=" + localApkFileInfo.packageName + ";apkId=" + localApkFileInfo.apkId + "| \n\r");
    }
    i.a("UploadApkHttpRequest", ((StringBuffer)localObject).toString() + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.apkupdate.logic.protocol.a.b
 * JD-Core Version:    0.7.0.1
 */