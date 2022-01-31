import com.dataline.activities.LiteActivity;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.qphone.base.util.QLog;

class t
  implements Runnable
{
  t(q paramq, boolean paramBoolean, long paramLong, String paramString) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean) {
      LiteActivity.a(this.jdField_a_of_type_Q.a);
    }
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_Q.a.app.a().a().b(this.jdField_a_of_type_Long);
    DataLineMsgSet localDataLineMsgSet = this.jdField_a_of_type_Q.a.app.a().a(this.jdField_a_of_type_Long);
    if ((localDataLineMsgSet != null) && (!localDataLineMsgSet.isSingle())) {
      if (!LiteActivity.a(this.jdField_a_of_type_Q.a).a(this.jdField_a_of_type_Long, LiteActivity.a(this.jdField_a_of_type_Q.a))) {
        LiteActivity.a(this.jdField_a_of_type_Q.a).notifyDataSetChanged();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Q.a.app.a().a().d();
      if (QLog.isColorLevel()) {
        QLog.d(LiteActivity.jdField_a_of_type_JavaLangString, 2, "LiteActivity.onRecvFile, msgId[" + this.jdField_a_of_type_Long + "], sPath = " + this.jdField_a_of_type_JavaLangString + "], set[" + localDataLineMsgSet + "], msgItem[" + localDataLineMsgRecord);
      }
      return;
      LiteActivity.a(this.jdField_a_of_type_Q.a).notifyDataSetChanged();
      if ((localDataLineMsgRecord != null) && (!localDataLineMsgRecord.bIsResendOrRecvFile))
      {
        LiteActivity.a(this.jdField_a_of_type_Q.a.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, LiteActivity.a(this.jdField_a_of_type_Q.a));
        LiteActivity.a(LiteActivity.a(this.jdField_a_of_type_Q.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     t
 * JD-Core Version:    0.7.0.1
 */