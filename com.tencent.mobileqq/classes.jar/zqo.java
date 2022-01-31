import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.managers.DraftTextManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import com.tencent.widget.TraceUtils;

public class zqo
  implements Runnable
{
  public zqo(QQMessageFacade paramQQMessageFacade) {}
  
  public void run()
  {
    TraceUtils.a("initMsgCache");
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "before refreshCache");
    }
    QQMessageFacade.a(this.a, DraftTextManager.a(QQMessageFacade.a(this.a)));
    this.a.a().a();
    this.a.d();
    QQMessageFacade.a(this.a);
    this.a.notifyObservers(new RecentUser());
    if (QLog.isColorLevel())
    {
      QLog.d("Q.msg.QQMessageFacade", 2, "after refreshCache");
      long l2 = System.currentTimeMillis();
      MsgAutoMonitorUtil.a().a("MSG_InitCostTime", l2 - l1 + "");
    }
    TraceUtils.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zqo
 * JD-Core Version:    0.7.0.1
 */