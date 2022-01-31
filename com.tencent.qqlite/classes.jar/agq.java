import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;

public class agq
  extends CardObserver
{
  public agq(Conversation paramConversation) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramBoolean) && (paramObject != null) && (!Utils.a(paramObject.uin, this.a.a.a())))
      {
        this.a.a(8, paramObject.uin, -2147483648);
        this.a.m();
      }
      return;
    }
  }
  
  protected void onGreetingRecv(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString != null) && (this.a.a.a().equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onGreetingRecv");
      }
      this.a.a(8, AppConstants.Z, 1001);
    }
  }
  
  protected void onUpdateAvatar(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (Conversation.c(this.a)) && (this.a.a != null) && (Utils.a(paramString, this.a.a.a()))) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     agq
 * JD-Core Version:    0.7.0.1
 */