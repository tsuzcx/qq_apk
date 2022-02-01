package com.tencent.mobileqq.scribble;

import amjf;
import aoll;
import aolm;
import aomi;
import aqiw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ScribbleResMgr$5
  implements Runnable
{
  ScribbleResMgr$5(ScribbleResMgr paramScribbleResMgr, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ScribbleResMgr.b(this.this$0, this.val$iconType, 0, true);
    aoll localaoll = new aoll();
    localaoll.f = new amjf(this);
    localaoll.bZ = "";
    localaoll.mHttpMethod = 0;
    if (this.val$iconType == 3)
    {
      localaoll.bZ = ScribbleResMgr.e(this.this$0);
      localaoll.atY = ScribbleResMgr.a(this.this$0);
    }
    if (this.val$iconType == 4)
    {
      localaoll.bZ = ScribbleResMgr.f(this.this$0);
      localaoll.atY = ScribbleResMgr.c(this.this$0);
    }
    localaoll.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
    this.val$app.getNetEngine(0).a(localaoll);
    if (QLog.isColorLevel()) {
      QLog.i("ScribbleResMgrdownloading", 2, "startDownloadhttpscribbleRes, url: " + localaoll.bZ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleResMgr.5
 * JD-Core Version:    0.7.0.1
 */