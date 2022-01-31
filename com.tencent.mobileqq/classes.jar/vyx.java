import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SendMenuEventResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class vyx
  implements BusinessObserver
{
  public vyx(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "requestQidiKefu ... onReceive = " + paramBoolean);
    }
    if (paramBoolean) {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        mobileqq_mp.SendMenuEventResponse localSendMenuEventResponse = new mobileqq_mp.SendMenuEventResponse();
        localSendMenuEventResponse.mergeFrom(paramBundle);
        paramInt = localSendMenuEventResponse.ret_info.ret_code.get();
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "requestQidiKefu ... onReceive: retCode = " + paramInt);
        }
        if (paramInt == 0)
        {
          this.a.ak = true;
          this.a.bn();
          this.a.aY();
          return;
        }
      }
      catch (Exception paramBundle) {}
    }
    this.a.w(2131430033);
    this.a.aY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vyx
 * JD-Core Version:    0.7.0.1
 */