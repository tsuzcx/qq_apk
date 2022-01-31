import com.dataline.activities.LiteActivity;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.qphone.base.util.QLog;

class an
  implements Runnable
{
  an(ak paramak, boolean paramBoolean, long paramLong, String paramString) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean) {
      LiteActivity.a(this.jdField_a_of_type_Ak.a);
    }
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_Ak.a.b.a().b(this.jdField_a_of_type_Long);
    DataLineMsgSet localDataLineMsgSet = this.jdField_a_of_type_Ak.a.b.a().a(this.jdField_a_of_type_Long);
    if ((localDataLineMsgSet != null) && (!localDataLineMsgSet.isSingle())) {
      if (!LiteActivity.a(this.jdField_a_of_type_Ak.a).a(this.jdField_a_of_type_Long, LiteActivity.a(this.jdField_a_of_type_Ak.a))) {
        LiteActivity.a(this.jdField_a_of_type_Ak.a).notifyDataSetChanged();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Ak.a.b.a().i();
      if (QLog.isColorLevel()) {
        QLog.d(LiteActivity.jdField_a_of_type_JavaLangString, 2, "sPath = " + this.jdField_a_of_type_JavaLangString);
      }
      return;
      LiteActivity.a(this.jdField_a_of_type_Ak.a).notifyDataSetChanged();
      if ((localDataLineMsgRecord != null) && (!localDataLineMsgRecord.bIsResendOrRecvFile))
      {
        LiteActivity.c(this.jdField_a_of_type_Ak.a);
        LiteActivity.b(this.jdField_a_of_type_Ak.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     an
 * JD-Core Version:    0.7.0.1
 */