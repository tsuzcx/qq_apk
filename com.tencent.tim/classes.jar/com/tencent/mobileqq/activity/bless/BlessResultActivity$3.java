package com.tencent.mobileqq.activity.bless;

import android.os.Message;
import aqhq;
import aqhu;
import aurf;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class BlessResultActivity$3
  implements Runnable
{
  BlessResultActivity$3(BlessResultActivity paramBlessResultActivity, String paramString) {}
  
  public void run()
  {
    try
    {
      long l = aqhq.getFileSizes(this.val$path);
      if (l < 25600L)
      {
        localObject = this.this$0.b.obtainMessage(1004);
        this.this$0.b.sendMessage((Message)localObject);
        return;
      }
      Object localObject = BlessResultActivity.hL(this.val$path);
      aqhu.b(BaseApplication.getContext(), this.val$path, (String)localObject, 160, 160);
      if (QLog.isColorLevel()) {
        QLog.d("BlessResultActivity", 2, "share ptv to FC. srcLen:" + l + " ,objLen:" + aqhq.getFileSizes((String)localObject) + " , thumbPath:" + (String)localObject);
      }
      Message localMessage = this.this$0.b.obtainMessage(1004);
      localMessage.obj = localObject;
      this.this$0.b.sendMessage(localMessage);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessResultActivity.3
 * JD-Core Version:    0.7.0.1
 */