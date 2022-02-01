import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class afxc
  extends afxb
{
  public final String TAG = "ExtendFriendLimitChatIdleStateHandler";
  
  afxc(afxd paramafxd, int paramInt)
  {
    super(paramafxd, paramInt);
  }
  
  void IH(boolean paramBoolean)
  {
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onCancelMatchMsg 取消匹配: " + paramBoolean);
  }
  
  public void NB(int paramInt)
  {
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "requestMatch id" + paramInt);
    Object localObject = new aftr();
    ((aftr)localObject).tagId = paramInt;
    this.b.a(101, (aftr)localObject);
    localObject = (afsg)this.b.mApp.getBusinessHandler(127);
    if (localObject != null)
    {
      int i = afwh.K(this.b.mApp);
      ((afsg)localObject).g(this.b.mApp.getCurrentAccountUin(), i, paramInt);
    }
  }
  
  void b(boolean paramBoolean, int paramInt, aftr paramaftr, String paramString)
  {
    if ((paramBoolean) && (paramaftr != null))
    {
      QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onCSRequestMsg 请求匹配 " + paramInt + paramaftr.toString());
      return;
    }
    paramaftr = paramString;
    if (paramString == null) {
      paramaftr = "";
    }
    QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onCSRequestMsg 请求匹配失败 suc:" + paramBoolean + " ret:" + paramInt + " errMsg : " + paramaftr);
  }
  
  void b(boolean paramBoolean, aftr paramaftr)
  {
    if (paramaftr == null)
    {
      QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg null indo");
      return;
    }
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg ");
    if (paramBoolean)
    {
      e(paramaftr.bFC, paramaftr.uin, paramaftr.sig);
      d(paramaftr);
      fz(paramaftr.bFC, paramaftr.aeN);
      return;
    }
    QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afxc
 * JD-Core Version:    0.7.0.1
 */