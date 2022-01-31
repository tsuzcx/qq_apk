import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager;
import com.tencent.qphone.base.util.QLog;

public class zqc
  implements Runnable
{
  public zqc(MsgProxy paramMsgProxy, QSlowTableManager paramQSlowTableManager, String paramString, int paramInt) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceQslowtableQSlowTableManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceQslowtableQSlowTableManager.a(MessageRecord.getTableName(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int), null, null);
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e("Q.msg.MsgProxy", 1, "delete slowtable excep :", localRuntimeException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zqc
 * JD-Core Version:    0.7.0.1
 */