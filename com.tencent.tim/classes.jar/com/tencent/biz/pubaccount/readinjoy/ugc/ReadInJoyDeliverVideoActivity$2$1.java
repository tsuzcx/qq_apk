package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import mjn;

public class ReadInJoyDeliverVideoActivity$2$1
  implements Runnable
{
  public ReadInJoyDeliverVideoActivity$2$1(mjn parammjn) {}
  
  public void run()
  {
    QLog.d("ReadInJoyDeliverVideoActivity", 2, "initCompositionManager: success, update UI");
    ReadInJoyDeliverVideoActivity.a(this.a.this$0).setVisibility(4);
    ReadInJoyDeliverVideoActivity.a(this.a.this$0).setVisibility(0);
    ReadInJoyDeliverVideoActivity.a(this.a.this$0).setClickable(true);
    ReadInJoyDeliverVideoActivity.a(this.a.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity.2.1
 * JD-Core Version:    0.7.0.1
 */