import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class byx
  extends MessageObserver
{
  public byx(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals(BusinessCmrTmpChatPie.a(this.a).jdField_a_of_type_JavaLangString)) || (paramInt1 != BusinessCmrTmpChatPie.b(this.a).jdField_a_of_type_Int))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessChatPie", 2, "onUpdateSendMsgError exception uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
    }
    if (paramInt1 == 1024) {
      QQToast.a(BusinessCmrTmpChatPie.b(this.a), "errorCode" + paramInt2, 0).b(BusinessCmrTmpChatPie.a(this.a).getTitleBarHeight());
    }
    this.a.a(196608);
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (BusinessCmrTmpChatPie.d(this.a).jdField_a_of_type_JavaLangString != null) && (BusinessCmrTmpChatPie.e(this.a).jdField_a_of_type_JavaLangString.equals(paramString)))
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
    if ((paramString != null) && (BusinessCmrTmpChatPie.f(this.a).jdField_a_of_type_JavaLangString != null) && (BusinessCmrTmpChatPie.g(this.a).jdField_a_of_type_JavaLangString.equals(paramString)))
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
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.equals(BusinessCmrTmpChatPie.c(this.a).jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.a.j = true;
    this.a.a(131072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     byx
 * JD-Core Version:    0.7.0.1
 */