import android.os.Bundle;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailBaseInfoModel.1.1;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SetFunctionFlagResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

public final class jua
  implements BusinessObserver
{
  jua(QQAppInterface paramQQAppInterface, jzs.a parama, int paramInt, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseInfoModel", 2, "success:" + String.valueOf(paramBoolean));
    }
    PublicAccountHandler localPublicAccountHandler = (PublicAccountHandler)this.val$app.getBusinessHandler(11);
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          Object localObject = new mobileqq_mp.SetFunctionFlagResponse();
          ((mobileqq_mp.SetFunctionFlagResponse)localObject).mergeFrom(paramBundle);
          if (((mobileqq_mp.RetInfo)((mobileqq_mp.SetFunctionFlagResponse)localObject).ret_info.get()).ret_code.get() == 0)
          {
            ((mobileqq_mp.RetInfo)((mobileqq_mp.SetFunctionFlagResponse)localObject).ret_info.get()).ret_code.get();
            if (QLog.isColorLevel()) {
              QLog.d("AccountDetailBaseInfoModel", 2, "sendSetFunctionFlagRequest success");
            }
            this.a.state = this.BG;
            paramBundle = null;
            localObject = (acja)this.val$app.getManager(56);
            if (localObject != null) {
              paramBundle = ((acja)localObject).a(this.val$uin);
            }
            if (paramBundle != null)
            {
              if (this.a.aGI == 6)
              {
                if (this.BG == 1) {
                  paramBundle.mShowMsgFlag = this.BG;
                }
                ThreadManager.getSubThreadHandler().postDelayed(new AccountDetailBaseInfoModel.1.1(this, paramBundle), 10L);
                localPublicAccountHandler.notifyUI(109, true, this.a);
                return;
              }
              if (this.a.aGI != 3) {
                continue;
              }
              paramBundle.isSyncLbs = true;
              if (this.a.state != 1) {
                break label315;
              }
              paramBoolean = true;
              paramBundle.isAgreeSyncLbs = paramBoolean;
              continue;
            }
          }
          else
          {
            localPublicAccountHandler.notifyUI(109, false, this.a);
          }
        }
        else
        {
          localPublicAccountHandler.notifyUI(109, false, this.a);
          return;
          localPublicAccountHandler.notifyUI(109, false, this.a);
        }
        return;
      }
      catch (Exception paramBundle)
      {
        return;
      }
      label315:
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jua
 * JD-Core Version:    0.7.0.1
 */