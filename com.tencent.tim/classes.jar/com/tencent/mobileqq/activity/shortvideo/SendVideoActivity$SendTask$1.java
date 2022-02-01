package com.tencent.mobileqq.activity.shortvideo;

import ambj;
import android.content.Intent;
import anff;
import anfr;
import angi;
import angt;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import sza;

class SendVideoActivity$SendTask$1
  implements Runnable
{
  SendVideoActivity$SendTask$1(SendVideoActivity.SendTask paramSendTask) {}
  
  public void run()
  {
    Object localObject2;
    Object localObject1;
    if (this.this$0.Q != null)
    {
      int i = this.this$0.Q.getIntExtra("file_send_business_type", 2);
      if (QLog.isColorLevel()) {
        QLog.d("SendVideoActivity", 2, "#SendTask# run(), busiType = " + i + ",VideoFileDir = " + this.this$0.Q.getStringExtra("file_video_source_dir"));
      }
      int j = this.this$0.Q.getIntExtra("uintype", -1);
      if (j == 9501) {
        i = 4;
      }
      localObject2 = anfr.a(0, i);
      localObject1 = anfr.a(this.this$0.Q, (angi)localObject2);
      ((angi)localObject2).c((angt)localObject1);
      if (j != 9501) {
        break label214;
      }
      localObject2 = new sza(this.this$0.mActivity.app);
      ((sza)localObject2).ar(((sza)localObject2).a((angt)localObject1));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendVideoActivity", 2, "#SendTask# run(): success");
      }
      if (!this.this$0.btc)
      {
        this.this$0.mActivity.setResult(-1, this.this$0.Q);
        this.this$0.mActivity.finish();
      }
      return;
      label214:
      localObject2 = new anff(this.this$0.mActivity.app);
      localObject1 = ((anff)localObject2).a((angt)localObject1);
      if (this.this$0.mActivity.app != null) {
        ((ambj)this.this$0.mActivity.app.getManager(326)).aG(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).uniseq);
      }
      ((anff)localObject2).ar((MessageRecord)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendTask.1
 * JD-Core Version:    0.7.0.1
 */