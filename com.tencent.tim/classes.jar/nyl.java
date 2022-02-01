import android.os.Bundle;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class nyl
  implements BusinessObserver
{
  nyl(nyj paramnyj, nyi paramnyi) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "do unfollow->uin:" + this.b.mUin + ", success:" + String.valueOf(paramBoolean));
    }
    if ((nyj.a(this.this$0) != null) && (nyj.a(this.this$0).isResume())) {
      nyj.a(this.this$0).showProgressBar(false);
    }
    if (!paramBoolean) {
      nyj.a(this.this$0);
    }
    for (;;)
    {
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
              QLog.d("ServiceAccountFolderFeedAdapter", 2, "unfollow success");
            }
            nyj.b(this.this$0, this.b);
            StructLongMessageDownloadProcessor.aP(nyj.a(this.this$0), this.b.mUin);
            ((apsa)nyj.a(this.this$0).getManager(132)).TL(this.b.mUin);
            return;
          }
          nyj.a(this.this$0);
          return;
        }
      }
      catch (Exception paramBundle) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nyl
 * JD-Core Version:    0.7.0.1
 */