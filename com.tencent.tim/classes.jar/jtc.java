import android.os.Bundle;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class jtc
  implements BusinessObserver
{
  public jtc(EqqAccountDetailActivity paramEqqAccountDetailActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      if (!EqqAccountDetailActivity.a(this.this$0)) {
        this.this$0.oh(2131697432);
      }
    }
    for (;;)
    {
      EqqAccountDetailActivity.a(this.this$0);
      if (EqqAccountDetailActivity.b(this.this$0) == 0) {
        EqqAccountDetailActivity.a(this.this$0);
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("crmtest", 4, "receive sendCrmDetailInfoRequest, ts=" + System.currentTimeMillis());
      }
      return;
      if (paramBoolean) {}
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          mobileqq_mp.GetEqqAccountDetailInfoResponse localGetEqqAccountDetailInfoResponse = new mobileqq_mp.GetEqqAccountDetailInfoResponse();
          localGetEqqAccountDetailInfoResponse.mergeFrom(paramBundle);
          if (((mobileqq_mp.RetInfo)localGetEqqAccountDetailInfoResponse.ret_info.get()).ret_code.get() == 0)
          {
            if ((this.this$0.b == null) || ((localGetEqqAccountDetailInfoResponse.seqno.has()) && (localGetEqqAccountDetailInfoResponse.seqno.get() != this.this$0.b.seqno)))
            {
              this.this$0.a = localGetEqqAccountDetailInfoResponse;
              paramBundle = new EqqDetail(this.this$0.a);
              if ((EqqAccountDetailActivity.b(this.this$0)) && (paramBundle.followType == 1))
              {
                this.this$0.a(paramBundle, false);
                continue;
              }
              this.this$0.a(paramBundle, true);
              continue;
            }
            if ((!EqqAccountDetailActivity.c(this.this$0)) || (this.this$0.b.followType != 1)) {
              continue;
            }
            this.this$0.azt();
            continue;
          }
          this.this$0.oh(2131697432);
          continue;
        }
        if (EqqAccountDetailActivity.d(this.this$0)) {
          continue;
        }
        this.this$0.oh(2131697432);
      }
      catch (Exception paramBundle) {}
      if (!EqqAccountDetailActivity.e(this.this$0)) {
        this.this$0.oh(2131697432);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jtc
 * JD-Core Version:    0.7.0.1
 */