import android.os.Bundle;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class aakq
  implements BusinessObserver
{
  aakq(aakp paramaakp, RecentBaseData paramRecentBaseData, QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "unfollow isSuccess:" + String.valueOf(paramBoolean) + ", uin: " + this.d.qx());
    }
    if (!paramBoolean)
    {
      aakp.a(this.this$0, 2131697432);
      return;
    }
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          mobileqq_mp.UnFollowResponse localUnFollowResponse = new mobileqq_mp.UnFollowResponse();
          localUnFollowResponse.mergeFrom(paramBundle);
          if (((mobileqq_mp.RetInfo)localUnFollowResponse.ret_info.get()).ret_code.get() != 0) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("RecentPubAccHelper", 2, "unfollow success");
          }
          aakp.a(this.this$0, this.d, this.val$appInterface);
          StructLongMessageDownloadProcessor.aP(this.val$appInterface, this.d.qx());
          ((apsa)this.val$appInterface.getManager(132)).TL(this.d.qx());
          aakp.b(this.this$0, this.d, this.val$appInterface);
        }
      }
      catch (Exception paramBundle)
      {
        continue;
      }
      aakp.a(this.this$0);
      return;
      aakp.b(this.this$0, 2131697432);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aakq
 * JD-Core Version:    0.7.0.1
 */