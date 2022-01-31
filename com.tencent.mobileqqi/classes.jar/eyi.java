import android.os.Handler;
import com.tencent.mobileqq.activity.voip.VoipDialInterface;
import com.tencent.mobileqq.activity.voip.VoipErrorCodeEnum;
import com.tencent.qphone.base.util.QLog;
import org.pjsip.pjsua.PjsuaAppCallback;

public class eyi
  extends PjsuaAppCallback
{
  private eyi(VoipDialInterface paramVoipDialInterface) {}
  
  public void onCallState(int paramInt1, int paramInt2)
  {
    QLog.d(VoipDialInterface.a, 4, String.format("onCallState=%d", new Object[] { Integer.valueOf(paramInt2) }));
    VoipDialInterface.a(this.a, paramInt1);
    VoipDialInterface.a(this.a).sendMessage(VoipDialInterface.a(this.a).obtainMessage(VoipErrorCodeEnum.VOIP_STATE_CALLING.ordinal(), paramInt2, 0));
  }
  
  public void onRegState(int paramInt1, int paramInt2, int paramInt3)
  {
    if (VoipDialInterface.a(this.a).length() == 0) {}
  }
  
  public void onRequestLog(String paramString)
  {
    QLog.d(VoipDialInterface.a, 4, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eyi
 * JD-Core Version:    0.7.0.1
 */