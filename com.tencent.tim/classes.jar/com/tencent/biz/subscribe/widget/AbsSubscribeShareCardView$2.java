package com.tencent.biz.subscribe.widget;

import aoll;
import aolm;
import aomi;
import aqiw;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import java.util.ArrayList;
import sij;

public class AbsSubscribeShareCardView$2
  implements Runnable
{
  AbsSubscribeShareCardView$2(AbsSubscribeShareCardView paramAbsSubscribeShareCardView, ArrayList paramArrayList1, int paramInt, String paramString, ArrayList paramArrayList2, AbsSubscribeShareCardView.a parama) {}
  
  public void run()
  {
    aoll localaoll = new aoll();
    localaoll.f = new sij(this);
    localaoll.bZ = ((String)this.gr.get(this.bwX));
    localaoll.mHttpMethod = 0;
    localaoll.atY = this.val$outPath;
    localaoll.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
    QQStoryContext.a();
    QQStoryContext.c().getNetEngine(0).a(localaoll);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView.2
 * JD-Core Version:    0.7.0.1
 */