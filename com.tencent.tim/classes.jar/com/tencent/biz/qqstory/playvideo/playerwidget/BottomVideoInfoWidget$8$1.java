package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Activity;
import android.os.Bundle;
import qmo;
import qmu;
import qmv;
import rnq;

public class BottomVideoInfoWidget$8$1
  implements Runnable
{
  public BottomVideoInfoWidget$8$1(qmu paramqmu) {}
  
  public void run()
  {
    Activity localActivity = this.a.this$0.getActivity();
    if (rnq.a().a(localActivity, new Bundle(), 467)) {
      qmo.a(this.a.this$0, localActivity, this.a.asf, this.a.val$vid, this.a.wb, this.a.val$name, this.a.axM, this.a.axN, this.a.b);
    }
    for (;;)
    {
      this.a.this$0.bpm();
      return;
      qmo.a(this.a.this$0, new qmv(this, localActivity));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget.8.1
 * JD-Core Version:    0.7.0.1
 */