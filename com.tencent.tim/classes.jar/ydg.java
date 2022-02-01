import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class ydg
  implements BusinessObserver
{
  ydg(ycd paramycd) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "success:" + String.valueOf(paramBoolean));
    }
    int k = 1;
    paramInt = 1;
    int j;
    if (!paramBoolean)
    {
      this.this$0.oh(2131697432);
      j = paramInt;
    }
    for (;;)
    {
      if (j != 0) {
        this.this$0.aAt();
      }
      return;
      j = paramInt;
      if (!paramBoolean) {
        continue;
      }
      int i = k;
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        j = paramInt;
        if (paramBundle == null) {
          continue;
        }
        i = k;
        mobileqq_mp.FollowResponse localFollowResponse = new mobileqq_mp.FollowResponse();
        i = k;
        localFollowResponse.mergeFrom(paramBundle);
        i = k;
        j = ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.get();
        if (j == 0)
        {
          i = k;
          kbp.a(this.this$0.app, "P_CliOper", "Pb_account_lifeservice", "", "0x8005750", "0x8005750", 0, 0, this.this$0.sessionInfo.aTl, "", "", "", false);
          i = k;
          paramBundle = (acja)this.this$0.app.getManager(56);
          if (paramBundle != null)
          {
            i = k;
            paramBundle = paramBundle.a(this.this$0.sessionInfo.aTl);
            if (paramBundle != null)
            {
              i = k;
              if (this.this$0.a == null)
              {
                i = k;
                this.this$0.a = ((PublicAccountHandler)this.this$0.app.getBusinessHandler(11));
              }
              i = k;
              this.this$0.a.bb(paramBundle);
              paramInt = 1;
              break label492;
            }
          }
        }
        label492:
        for (;;)
        {
          i = paramInt;
          this.this$0.blm = true;
          i = paramInt;
          this.this$0.blu = true;
          i = paramInt;
          this.this$0.cgN();
          j = paramInt;
          i = paramInt;
          if (!this.this$0.blJ) {
            break;
          }
          i = paramInt;
          paramBundle = (PlusPanel)ycd.a(this.this$0).B(8);
          j = paramInt;
          if (paramBundle == null) {
            break;
          }
          i = paramInt;
          paramBundle.update();
          j = paramInt;
          break;
          i = k;
          this.this$0.Tj();
          paramInt = 0;
          break label492;
          i = k;
          this.this$0.Tj();
          paramInt = 0;
          continue;
          if (j == 58)
          {
            i = k;
            this.this$0.oh(2131697429);
            j = paramInt;
            break;
          }
          if (j == 65)
          {
            i = k;
            this.this$0.oh(2131697402);
            j = paramInt;
            break;
          }
          i = k;
          this.this$0.oh(2131697432);
          j = paramInt;
          break;
        }
      }
      catch (Exception paramBundle)
      {
        j = i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ydg
 * JD-Core Version:    0.7.0.1
 */