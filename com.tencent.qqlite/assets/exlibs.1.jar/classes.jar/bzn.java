import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;

public class bzn
  extends MessageObserver
{
  public bzn(FriendChatPie paramFriendChatPie) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals(FriendChatPie.g(this.a).jdField_a_of_type_JavaLangString)) || (paramInt1 != FriendChatPie.h(this.a).jdField_a_of_type_Int))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "onUpdateSendMsgError exception uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
    }
    this.a.a(196608);
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (FriendChatPie.j(this.a).jdField_a_of_type_JavaLangString != null) && (FriendChatPie.k(this.a).jdField_a_of_type_JavaLangString.equals(paramString)))
    {
      ChatActivityUtils.a();
      if (paramBoolean) {
        this.a.h();
      }
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean1) {
      this.a.C();
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (FriendChatPie.l(this.a).jdField_a_of_type_JavaLangString != null) && (FriendChatPie.m(this.a).jdField_a_of_type_JavaLangString.equals(paramString)))
    {
      ChatActivityUtils.a();
      if (paramBoolean) {
        this.a.h();
      }
    }
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    this.a.a(65536);
  }
  
  protected void d(boolean paramBoolean, String paramString)
  {
    MultiMsgManager.a().b("send struct msg  ");
    MultiMsgManager.a().c();
    MultiMsgManager.a().a("all cost time ");
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.equals(FriendChatPie.i(this.a).jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.a.j = true;
    this.a.a(131072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bzn
 * JD-Core Version:    0.7.0.1
 */