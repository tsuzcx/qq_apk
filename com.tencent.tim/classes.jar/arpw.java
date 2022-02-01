import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.BindGroupConfirmActivity;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import mqq.observer.BusinessObserver;

public class arpw
  implements BusinessObserver
{
  public arpw(BindGroupConfirmActivity paramBindGroupConfirmActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("ssoAccount");
    if (!this.this$0.app.getCurrentAccountUin().equals(localObject)) {}
    for (;;)
    {
      return;
      this.this$0.mHandler.removeCallbacks(this.this$0.ic);
      if (paramBoolean)
      {
        localObject = new GetAppInfoProto.GetAppinfoResponse();
        try
        {
          paramBundle = paramBundle.getByteArray("data");
          if (paramBundle != null)
          {
            ((GetAppInfoProto.GetAppinfoResponse)localObject).mergeFrom(paramBundle);
            if ((((GetAppInfoProto.GetAppinfoResponse)localObject).has()) && (((GetAppInfoProto.GetAppinfoResponse)localObject).ret.get() == 0))
            {
              paramBundle = this.this$0.mHandler.obtainMessage();
              paramBundle.what = 3;
              paramBundle.obj = localObject;
              this.this$0.mHandler.sendMessage(paramBundle);
              return;
            }
          }
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arpw
 * JD-Core Version:    0.7.0.1
 */