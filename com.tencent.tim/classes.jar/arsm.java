import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.QuickLoginAuthorityActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class arsm
  extends WtloginObserver
{
  public arsm(QuickLoginAuthorityActivity paramQuickLoginAuthorityActivity) {}
  
  public void OnCloseCode(String paramString, byte[] paramArrayOfByte1, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
  {
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "wtloginObserver.OnCloseCode userAccount=" + paramString + " ret=" + paramInt);
    if (paramInt == 0)
    {
      this.this$0.eb(null);
      this.this$0.moveTaskToBack(true);
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, acfp.m(2131712637) + paramInt + ")", 2000).show();
    this.this$0.eb(null);
    this.this$0.moveTaskToBack(true);
  }
  
  public void OnException(String paramString, int paramInt)
  {
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "wtloginObserver.OnException e=" + paramString);
    this.this$0.eb(null);
    this.this$0.moveTaskToBack(true);
  }
  
  public void OnVerifyCode(String paramString, byte[] paramArrayOfByte1, long paramLong, ArrayList<String> paramArrayList, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
  {
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "wtloginObserver.OnVerifyCode userAccount=" + paramString + " ret=" + paramInt);
    if (paramInt == 0)
    {
      paramArrayOfByte1 = new ArrayList();
      this.this$0.a.CloseCode(paramString, 16L, QuickLoginAuthorityActivity.a(this.this$0), 1, paramArrayOfByte1, QuickLoginAuthorityActivity.a(this.this$0));
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, acfp.m(2131712636) + paramInt + ")", 2000).show();
    this.this$0.eb(null);
    this.this$0.moveTaskToBack(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arsm
 * JD-Core Version:    0.7.0.1
 */