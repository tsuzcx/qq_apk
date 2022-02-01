package com.tencent.mobileqq.activity.bless;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.QQVideoView;
import com.tencent.qphone.base.util.QLog;
import ylg;

public class BlessActivity$7$1
  implements Runnable
{
  public BlessActivity$7$1(ylg paramylg) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(BlessActivity.a(this.a.this$0), 2, "videoview bring to top");
    }
    if (BlessActivity.b(this.a.this$0) != null) {
      BlessActivity.b(this.a.this$0).setVisibility(8);
    }
    if (BlessActivity.a(this.a.this$0) != null) {
      BlessActivity.a(this.a.this$0).bringToFront();
    }
    this.a.this$0.findViewById(2131369627).bringToFront();
    this.a.this$0.findViewById(2131379769).bringToFront();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessActivity.7.1
 * JD-Core Version:    0.7.0.1
 */