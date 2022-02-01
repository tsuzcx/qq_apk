import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class acsa
  extends toa
{
  public acsa(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, tom paramtom)
  {
    super(paramQQAppInterface, paramQQMessageFacade, paramtom);
    if (QLog.isColorLevel()) {
      QLog.d("TinyIdMsgMessageManager", 2, "TinyIdMsgMessageManager() called with: app = [" + paramQQAppInterface + "], msgFacade = [" + paramQQMessageFacade + "], msgPool = [" + paramtom + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acsa
 * JD-Core Version:    0.7.0.1
 */