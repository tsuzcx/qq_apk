package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.model.uidomain.ComposeMailUI.ImageScaleDegree;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;

class FtnListActivity$47
  implements Runnable
{
  FtnListActivity$47(FtnListActivity paramFtnListActivity, ComposeMailUI.ImageScaleDegree paramImageScaleDegree) {}
  
  public void run()
  {
    ImageUtil.CompressImage(FtnListActivity.access$2200(this.this$0), this.val$degree);
    this.this$0.runOnUiThread(new FtnListActivity.47.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.47
 * JD-Core Version:    0.7.0.1
 */