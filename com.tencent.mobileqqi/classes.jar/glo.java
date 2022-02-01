import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.subaccount.logic.SubAccountGetMessageControll;
import com.tencent.qphone.base.util.QLog;

public class glo
  extends MessageObserver
{
  public glo(SubAccountGetMessageControll paramSubAccountGetMessageControll) {}
  
  public void b(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    paramString = SubAccountGetMessageControll.a(this.a);
    if ((paramBoolean) && (paramSubAccountBackProtocData != null)) {}
    try
    {
      if (!paramSubAccountBackProtocData.a)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.subaccount.SubAccountGetMessageControll", 2, "onGetSubAccountMsgNotify： is get msg last finish = false");
        }
        return;
      }
      SubAccountGetMessageControll.a(this.a, false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.subaccount.SubAccountGetMessageControll", 2, "onGetSubAccountMsgNotify： observer = >onGetSubAccountMsgNotify pushNum =" + SubAccountGetMessageControll.a(this.a));
      }
      if (SubAccountGetMessageControll.a(this.a) > 0)
      {
        SubAccountGetMessageControll.a(this.a, 0);
        this.a.a(false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.subaccount.SubAccountGetMessageControll", 2, "onGetSubAccountMsgNotify： observer = >onGetSubAccountMsgNotify end");
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     glo
 * JD-Core Version:    0.7.0.1
 */