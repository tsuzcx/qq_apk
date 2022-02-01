package com.tencent.mobileqq.scribble;

import amje;
import aoll;
import aolm;
import aomg;
import aomi;
import aopo;
import aqhq;
import aqiw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ScribbleResMgr$4
  implements Runnable
{
  ScribbleResMgr$4(ScribbleResMgr paramScribbleResMgr, ScribbleResMgr.ResInfo paramResInfo) {}
  
  public void run()
  {
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = ScribbleResMgr.Q(this.a.resType, this.a.sourceId);
    if (aqhq.fileExists((String)localObject2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScribbleResMgr", 2, "res exist, return:" + this.a.sourceId + " " + this.a.resType + " file:" + (String)localObject2 + " url:" + this.a.sourceUrl);
      }
      localObject1 = (aopo)((QQAppInterface)localObject1).getManager(193);
      if (((aopo)localObject1).isEnable()) {
        ((aopo)localObject1).be(this.a.sourceUrl, aqhq.getFileOrFolderSize((String)localObject2));
      }
      ScribbleResMgr.a(this.this$0, this.a, 1);
    }
    do
    {
      return;
      ScribbleResMgr.b(this.this$0, this.a.resType, this.a.sourceId, true);
      localObject2 = new aoll();
      ((aoll)localObject2).f = new amje(this);
      ((aoll)localObject2).bZ = this.a.sourceUrl;
      ((aoll)localObject2).mHttpMethod = 0;
      if (this.a.resType == 1) {
        ((aoll)localObject2).atY = ScribbleResMgr.Q(this.a.resType, this.a.sourceId);
      }
      if (this.a.resType == 2) {
        ((aoll)localObject2).atY = ScribbleResMgr.eY(this.a.sourceId);
      }
      ScribbleResMgr.a(this.this$0, ((aoll)localObject2).atY);
      ((aoll)localObject2).mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
      ((QQAppInterface)localObject1).getNetEngine(0).a((aomg)localObject2);
    } while (!QLog.isColorLevel());
    QLog.i("ScribbleResMgrdownloading", 2, "starthttpDownloadscribbleRes, url: " + this.a.sourceUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleResMgr.4
 * JD-Core Version:    0.7.0.1
 */