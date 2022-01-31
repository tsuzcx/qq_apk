import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;

public class vxc
  extends MessageObserver
{
  public vxc(ConfessChatPie paramConfessChatPie) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2, int paramInt3)
  {
    if ((paramString1 == null) || (!paramString1.equals(this.a.a.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.a.a.jdField_a_of_type_Int) || (paramInt3 != this.a.a.e))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.ConfessChatPie", 2, "onUpdateSendMsgError_confess err uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2 + " topicId " + paramInt3);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.ConfessChatPie", 2, "onUpdateSendMsgError_confess uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2 + " errorCode " + paramInt2 + " topicId " + paramInt3);
    }
    this.a.b(196608);
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    if ((paramString == null) || (!paramString.equals(this.a.a.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.a.a.jdField_a_of_type_Int) || (paramInt2 != this.a.a.e))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.ConfessChatPie", 2, "onSendResult_confess err uin " + paramString + " type " + paramInt1 + " uniseq " + paramLong + " topicId " + paramInt2);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.ConfessChatPie", 2, "onSendResult_confess uin " + paramString + " type " + paramInt1 + " uniseq " + paramLong + " topicId " + paramInt2);
    }
    this.a.q = true;
    this.a.a(262144, null, paramLong);
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    this.a.b(65536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vxc
 * JD-Core Version:    0.7.0.1
 */