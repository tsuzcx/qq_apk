package com.tencent.mobileqq.app;

import acgi;
import android.text.TextUtils;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.Setting;
import com.tencent.qphone.base.util.QLog;

public class HotChatShare$3
  implements Runnable
{
  public HotChatShare$3(acgi paramacgi) {}
  
  public void run()
  {
    Object localObject = "stranger_" + String.valueOf(200) + "_" + this.this$0.e.ownerUin;
    localObject = this.this$0.app.a((String)localObject);
    if ((localObject != null) && (!TextUtils.isEmpty(((Setting)localObject).url))) {
      this.this$0.boq = (((Setting)localObject).url + "140");
    }
    if (QLog.isColorLevel()) {
      QLog.i("HotChatShare", 2, "handleShare.fromdb.ownerHeadUrl=" + this.this$0.boq);
    }
    if (!TextUtils.isEmpty(this.this$0.boq)) {
      if (this.this$0.currentState == 0) {
        this.this$0.currentState = 2;
      }
    }
    for (;;)
    {
      if (this.this$0.currentState == 3) {
        this.this$0.a.runOnUiThread(new HotChatShare.3.1(this));
      }
      return;
      if (this.this$0.currentState == 1)
      {
        this.this$0.currentState = 3;
        continue;
        ((FriendListHandler)this.this$0.app.getBusinessHandler(1)).a(this.this$0.e.ownerUin, 200, (byte)1, (byte)1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatShare.3
 * JD-Core Version:    0.7.0.1
 */