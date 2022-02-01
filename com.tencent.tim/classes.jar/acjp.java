import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Set;

public class acjp
  extends acfd
{
  public acjp(QQAppInterface paramQQAppInterface) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface_friendListObserver", 2, "onUpdateFriendInfo uin:" + paramString + ",isSuccess:" + paramBoolean);
    }
    if (this.this$0.bN.contains(paramString))
    {
      if ((this.this$0.b.a.Bi() == 1) && (paramString != null) && (paramString.equals(((QQMessageFacade.Message)this.this$0.b.a.ek().get(0)).frienduin)) && (this.this$0.isBackground_Pause) && (this.this$0.abm()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQAppInterface_friendListObserver", 2, "update notifcation");
        }
        QQAppInterface.a(this.this$0, (QQMessageFacade.Message)this.this$0.b.a.ek().get(0), false);
      }
      this.this$0.bN.remove(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface_friendListObserver", 2, "removeObserver");
    }
    this.this$0.removeObserver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acjp
 * JD-Core Version:    0.7.0.1
 */