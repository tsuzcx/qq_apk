package com.tencent.biz.qqstory.takevideo;

import acfp;
import com.tencent.mobileqq.widget.QQToast;
import rbr;
import rbs;
import rdc;
import rel;

public class EditPicSave$1$1
  implements Runnable
{
  public EditPicSave$1$1(rbs paramrbs) {}
  
  public void run()
  {
    this.a.this$0.b.changeState(0);
    this.a.this$0.aGH = true;
    this.a.this$0.updateProgress(100);
    this.a.this$0.dismissProgressDialog();
    QQToast.a(this.a.this$0.a.getContext(), 2, acfp.m(2131705464), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditPicSave.1.1
 * JD-Core Version:    0.7.0.1
 */