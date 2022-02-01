package com.tencent.biz.subscribe.widget.relativevideo;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import java.util.List;

class RelativePersonalBottomView$3
  implements Runnable
{
  RelativePersonalBottomView$3(RelativePersonalBottomView paramRelativePersonalBottomView, SimpleBaseEvent paramSimpleBaseEvent) {}
  
  public void run()
  {
    if ((RelativePersonalBottomView.a(this.this$0) != null) && (RelativePersonalBottomView.a(this.this$0).getContext() != null) && (!((Activity)RelativePersonalBottomView.a(this.this$0).getContext()).isFinishing()))
    {
      if (!(this.a instanceof SubDraftChangeEvent)) {
        break label114;
      }
      RelativePersonalBottomView.a(this.this$0);
      if ((((SubDraftChangeEvent)this.a).getIsSave()) && (RelativePersonalBottomView.a(this.this$0).size() > 1) && (RelativePersonalBottomView.a(this.this$0).getCurrentItem() != 1)) {
        RelativePersonalBottomView.a(this.this$0).setCurrentItem(1);
      }
    }
    label114:
    while ((!(this.a instanceof SubscribeFeedsEvent)) || (RelativePersonalBottomView.a(this.this$0).getCurrentItem() == 0) || (((SubscribeFeedsEvent)this.a).mState != 1)) {
      return;
    }
    RelativePersonalBottomView.a(this.this$0).setCurrentItem(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalBottomView.3
 * JD-Core Version:    0.7.0.1
 */