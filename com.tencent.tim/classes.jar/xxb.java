import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class xxb
  implements BusinessObserver
{
  xxb(xwq paramxwq) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      this.a.oh(2131697432);
    }
    for (;;)
    {
      ChatActivityUtils.bJs();
      return;
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          mobileqq_mp.FollowResponse localFollowResponse = new mobileqq_mp.FollowResponse();
          localFollowResponse.mergeFrom(paramBundle);
          paramInt = ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.get();
          if (paramInt == 0)
          {
            ((FriendListHandler)this.a.app.getBusinessHandler(1)).by(true, false);
            paramBundle = (aceb)this.a.app.getBusinessHandler(21);
            if (paramBundle != null) {
              paramBundle.hq(SystemClock.uptimeMillis());
            }
          }
          else if (paramInt == 58)
          {
            this.a.oh(2131697429);
          }
          else if (paramInt == 65)
          {
            this.a.oh(2131697402);
          }
          else if (paramInt == 20)
          {
            this.a.oh(2131697403);
          }
          else
          {
            this.a.oh(2131697432);
          }
        }
      }
      catch (Exception paramBundle) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xxb
 * JD-Core Version:    0.7.0.1
 */