package com.tencent.tim.cloudfile;

import android.view.View;
import atgs;
import atgt;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class CloudFileSendRecvActivity$14
  implements Runnable
{
  CloudFileSendRecvActivity$14(CloudFileSendRecvActivity paramCloudFileSendRecvActivity, View paramView1, List paramList, View paramView2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SendRecvActivity", 2, "need upload");
    }
    CloudFileSendRecvActivity.c(this.this$0).setVisibility(0);
    this.Kr.setOnClickListener(new atgs(this));
    this.Ks.setOnClickListener(new atgt(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.CloudFileSendRecvActivity.14
 * JD-Core Version:    0.7.0.1
 */