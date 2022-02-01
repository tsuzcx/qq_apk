import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class ycu
  implements BusinessObserver
{
  ycu(ycd paramycd, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      this.this$0.oh(2131697432);
    }
    for (;;)
    {
      ycd.c(this.this$0);
      if (ycd.d(this.this$0) == 0) {
        this.this$0.aAt();
      }
      return;
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          mobileqq_mp.UnFollowResponse localUnFollowResponse = new mobileqq_mp.UnFollowResponse();
          localUnFollowResponse.mergeFrom(paramBundle);
          if (((mobileqq_mp.RetInfo)localUnFollowResponse.ret_info.get()).ret_code.get() == 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.this$0.TAG, 2, "unfollow success");
            }
            ycd.a(this.this$0, ycd.a(this.this$0));
            kbp.a(this.this$0.app, "P_CliOper", "Pb_account_lifeservice", this.val$uin, "0X8005A2D", "0X8005A2D", 0, 0, "", "", "", "", false);
            StructLongMessageDownloadProcessor.aP(this.this$0.app, this.val$uin);
            ((apsa)this.this$0.app.getManager(132)).TL(this.this$0.sessionInfo.aTl);
            ycd.b(this.this$0, false);
          }
          else
          {
            this.this$0.oh(2131697432);
          }
        }
      }
      catch (Exception paramBundle) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ycu
 * JD-Core Version:    0.7.0.1
 */