import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;

public class ceu
  extends CardObserver
{
  public ceu(Conversation paramConversation) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramBoolean) && (paramObject != null) && (!Utils.a(paramObject.uin, this.a.a.a())))
      {
        this.a.a(8, paramObject.uin, -2147483648);
        this.a.k();
      }
      return;
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString != null) && (this.a.a.a().equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onGreetingRecv");
      }
      this.a.a(8, AppConstants.V, 1001);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ceu
 * JD-Core Version:    0.7.0.1
 */