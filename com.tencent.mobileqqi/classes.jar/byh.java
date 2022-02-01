import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.systemmsg.SystemMsgController;

public class byh
  implements Runnable
{
  public byh(ChatActivity paramChatActivity) {}
  
  public void run()
  {
    ChatActivity.d(this.a, ChatActivity.d(this.a));
    ChatActivity.a(this.a, ChatActivity.e(this.a));
    if (ChatActivity.e(this.a)) {
      ChatActivityFacade.a(this.a.b, this.a.a);
    }
    for (;;)
    {
      this.a.b.a().c(this.a.a.jdField_a_of_type_JavaLangString, this.a.a.jdField_a_of_type_Int);
      try
      {
        if (this.a.a.jdField_a_of_type_Int == 0) {
          SystemMsgController.a().a(Long.parseLong(this.a.a.jdField_a_of_type_JavaLangString), this.a.b);
        }
        for (;;)
        {
          label129:
          ChatActivity.d(this.a);
          return;
          if (this.a.a.jdField_a_of_type_Long != -1L) {
            break;
          }
          this.a.a.jdField_a_of_type_Long = this.a.b.a().b(this.a.a.jdField_a_of_type_JavaLangString, this.a.a.jdField_a_of_type_Int);
          break;
          if ((this.a.a.jdField_a_of_type_Int == 1) && (this.a.a.b != null)) {
            SystemMsgController.a().a(Long.parseLong(this.a.a.b), this.a.b);
          }
        }
      }
      catch (Exception localException)
      {
        break label129;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     byh
 * JD-Core Version:    0.7.0.1
 */