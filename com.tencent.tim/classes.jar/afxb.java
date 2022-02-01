import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.BaseStateHandler.1;
import com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.BaseStateHandler.2;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class afxb
{
  public afxd b;
  public final String bFQ = "ExtendFriendLimitChat";
  public aftr c = new aftr();
  private int cUX = -1;
  
  afxb(afxd paramafxd, int paramInt)
  {
    this.b = paramafxd;
    this.c.clear();
    this.cUX = paramInt;
  }
  
  void IH(boolean paramBoolean)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.cUX + " onCScancelMatchMsg in wrong state!! " + paramBoolean);
  }
  
  void NB(int paramInt)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.cUX + " requestMatch in wrong state!! id:" + paramInt);
  }
  
  void apK()
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.cUX + " cancelMatch in wrong state!!");
  }
  
  public void b(aftr paramaftr)
  {
    this.c.uin = paramaftr.uin;
    this.c.sig = paramaftr.sig;
    this.c.bFC = paramaftr.bFC;
    this.c.tipsWording = paramaftr.tipsWording;
    this.c.timeStamp = paramaftr.timeStamp;
    this.c.matchExpiredTime = paramaftr.matchExpiredTime;
    this.c.aeN = paramaftr.aeN;
    this.c.tagId = paramaftr.tagId;
    this.c.tagName = paramaftr.tagName;
    this.c.a = paramaftr.a;
  }
  
  void b(boolean paramBoolean, int paramInt, aftr paramaftr, String paramString)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.cUX + " onCSRequestMsg in wrong state!!");
  }
  
  void b(boolean paramBoolean, aftr paramaftr)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.cUX + " onPushMsg in wrong state!!");
  }
  
  public void c(aftr paramaftr)
  {
    this.c.clear();
    if (paramaftr != null) {
      b(paramaftr);
    }
  }
  
  public void clearStatus()
  {
    this.c.clear();
  }
  
  protected void d(aftr paramaftr)
  {
    ThreadManager.getSubThreadHandler().post(new BaseStateHandler.2(this, paramaftr));
  }
  
  protected void e(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    this.b.mApp.a().h(String.valueOf(paramString1), String.valueOf(paramString2), paramArrayOfByte);
  }
  
  protected void fz(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("ExtendFriendLimitChat", 2, "saveMatchAlgorithmId UIN IS EMPTY");
      return;
    }
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2))
    {
      str = "0";
      QLog.e("ExtendFriendLimitChat", 2, "saveMatchAlgorithmId algorithmId IS EMPTY");
    }
    ThreadManager.getSubThreadHandler().post(new BaseStateHandler.1(this, paramString1, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afxb
 * JD-Core Version:    0.7.0.1
 */