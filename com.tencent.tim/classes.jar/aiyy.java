import android.os.Message;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aiyy
{
  private static aiyy a;
  private int Qa = 1;
  private boolean cmO;
  private boolean cmP;
  
  private aiyy()
  {
    if (NetConnInfoCenter.socketConnState == 4) {
      this.Qa = 2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoadingStateManager", 2, "LoadingStateManager init loadingstate = " + this.Qa);
    }
  }
  
  public static aiyy a()
  {
    if (a == null) {
      a = new aiyy();
    }
    return a;
  }
  
  public int FC()
  {
    return this.Qa;
  }
  
  public void LH(boolean paramBoolean)
  {
    this.cmP = paramBoolean;
  }
  
  public void LI(boolean paramBoolean)
  {
    this.cmO = paramBoolean;
  }
  
  public void Qv(int paramInt)
  {
    this.Qa = paramInt;
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, QQAppInterface paramQQAppInterface)
  {
    if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getAttribute("_tag_socket") == null)) {}
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel())
          {
            QLog.d("LoadingStateManager", 2, "notifyIsNotIllegalNetWork mShowIllegalNetworkBar=" + this.cmO);
            QLog.d("LoadingStateManager", 2, "changeConversationLoadingState mShowErrorNetworkBar=" + this.cmP);
          }
        } while ((!this.cmO) && (!this.cmP));
        if (!this.cmP) {
          break;
        }
        paramFromServiceMsg = paramQQAppInterface.getHandler(Conversation.class);
      } while (paramFromServiceMsg == null);
      paramFromServiceMsg.obtainMessage(10002, null).sendToTarget();
      return;
      if (!apX()) {
        Qv(0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("LoadingStateManager", 2, "notifyIsNotIllegalNetWork");
      }
      paramFromServiceMsg = paramQQAppInterface.getHandler(Conversation.class);
    } while (paramFromServiceMsg == null);
    paramFromServiceMsg.obtainMessage(1134012, null).sendToTarget();
  }
  
  public boolean apV()
  {
    return this.cmO;
  }
  
  public boolean apW()
  {
    return (this.Qa == 1) || (this.Qa == 2);
  }
  
  public boolean apX()
  {
    return this.Qa == 3;
  }
  
  public boolean apY()
  {
    return this.Qa == 4;
  }
  
  public void onDestroy()
  {
    a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiyy
 * JD-Core Version:    0.7.0.1
 */