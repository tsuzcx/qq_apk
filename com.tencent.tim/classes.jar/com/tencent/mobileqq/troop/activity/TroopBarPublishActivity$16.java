package com.tencent.mobileqq.troop.activity;

import acfp;
import android.widget.ImageView;
import android.widget.TextView;
import aouy;
import aouz;
import java.io.File;

public class TroopBarPublishActivity$16
  implements Runnable
{
  TroopBarPublishActivity$16(TroopBarPublishActivity paramTroopBarPublishActivity, String paramString) {}
  
  public void run()
  {
    if (this.val$outPath == null)
    {
      this.this$0.dXi();
      this.this$0.cOU = false;
      this.this$0.aaf.setText(acfp.m(2131715587));
      this.this$0.aaf.setTextColor(-65536);
      this.this$0.Ed.setOnClickListener(new aouy(this));
      return;
    }
    this.this$0.cOU = false;
    this.this$0.aaf.setText("");
    this.this$0.aaf.setCompoundDrawablesWithIntrinsicBounds(2130849182, 0, 0, 0);
    this.this$0.mVideoPath = this.val$outPath;
    this.this$0.a.size = new File(this.val$outPath).length();
    this.this$0.Ed.setOnClickListener(new aouz(this));
    this.this$0.db(TroopBarPublishActivity.c(this.this$0), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishActivity.16
 * JD-Core Version:    0.7.0.1
 */