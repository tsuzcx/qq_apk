package com.tencent.mobileqq.profile;

import aldt;
import android.os.Handler;
import android.os.Message;
import aquy;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class VipProfileCardPreviewActivity$4
  implements Runnable
{
  VipProfileCardPreviewActivity$4(VipProfileCardPreviewActivity paramVipProfileCardPreviewActivity, int paramInt, String paramString) {}
  
  public void run()
  {
    Object localObject = new aldt(this);
    int i = this.this$0.a(this.val$url, (aquy)localObject);
    if ((i == 19) || (i == 0))
    {
      localObject = this.this$0.mHandler.obtainMessage(20);
      ((Message)localObject).arg1 = this.val$pos;
      this.this$0.mHandler.sendMessage((Message)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, String.format("style download success , url : %s, position : %d ", new Object[] { this.val$url, Integer.valueOf(this.val$pos) }));
      }
      this.this$0.V.remove(this.val$url);
    }
    do
    {
      return;
      localObject = this.this$0.mHandler.obtainMessage(21);
      ((Message)localObject).arg1 = this.val$pos;
      this.this$0.mHandler.sendMessage((Message)localObject);
    } while (!QLog.isColorLevel());
    QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, String.format("styles download fail , url : %s, position : %d ", new Object[] { this.val$url, Integer.valueOf(this.val$pos) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardPreviewActivity.4
 * JD-Core Version:    0.7.0.1
 */