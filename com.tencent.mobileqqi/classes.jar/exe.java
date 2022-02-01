import android.os.Handler;
import com.tencent.mobileqq.activity.voip.VoipTencentPayActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.unipay.plugsdk.IUnipayServiceCallBack.Stub;

public class exe
  extends IUnipayServiceCallBack.Stub
{
  public exe(VoipTencentPayActivity paramVoipTencentPayActivity) {}
  
  public void UnipayCallBack(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, String paramString2)
  {
    QLog.d("UnipayPlugAPI", 2, "UnipayCallBack \n\nresultCode = " + paramInt1 + "\npayChannel = " + paramInt2 + "\npayState = " + paramInt3 + "\nproviderState = " + paramInt4 + "\nnpayMsg =" + paramString1);
    if ((paramInt1 == 0) || (paramInt1 == 2))
    {
      VoipTencentPayActivity.a().post(new exf(this));
      return;
    }
    VoipTencentPayActivity.a(this.a);
  }
  
  public void UnipayNeedLogin() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     exe
 * JD-Core Version:    0.7.0.1
 */