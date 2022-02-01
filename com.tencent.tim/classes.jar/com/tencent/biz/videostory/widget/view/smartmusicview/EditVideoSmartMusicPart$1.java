package com.tencent.biz.videostory.widget.view.smartmusicview;

import aoll;
import aolm;
import aomi;
import aqiw;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import srs;
import srt;

public class EditVideoSmartMusicPart$1
  implements Runnable
{
  public EditVideoSmartMusicPart$1(srs paramsrs) {}
  
  public void run()
  {
    aoll localaoll = new aoll();
    localaoll.f = new srt(this);
    localaoll.bZ = srs.a(this.this$0);
    localaoll.mHttpMethod = 0;
    localaoll.atY = srs.a(this.this$0).getPath();
    localaoll.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
    QQStoryContext.a();
    QQStoryContext.c().getNetEngine(0).a(localaoll);
    QLog.i("EditVideoSmartMusicPart", 1, "startDownloadAnim, url: " + srs.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.EditVideoSmartMusicPart.1
 * JD-Core Version:    0.7.0.1
 */