package com.tencent.biz.subscribe;

import aoll;
import aolm;
import aomi;
import aqiw;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import rzf;

public final class SubscribeUtils$1
  implements Runnable
{
  public SubscribeUtils$1(String paramString1, File paramFile, String paramString2) {}
  
  public void run()
  {
    aoll localaoll = new aoll();
    localaoll.f = new rzf(this);
    localaoll.bZ = this.val$downloadUrl;
    localaoll.mHttpMethod = 0;
    localaoll.atY = this.D.getPath();
    localaoll.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
    QQStoryContext.a();
    QQStoryContext.c().getNetEngine(0).a(localaoll);
    QLog.i("DownLoadZipFile", 1, "startDownloadZipFile, url: " + this.val$downloadUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.SubscribeUtils.1
 * JD-Core Version:    0.7.0.1
 */