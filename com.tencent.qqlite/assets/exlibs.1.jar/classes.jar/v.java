import com.dataline.activities.LiteActivity;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;

class v
  implements Runnable
{
  v(p paramp, long paramLong) {}
  
  public void run()
  {
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_P.a.app.a().a().b(this.jdField_a_of_type_Long);
    if (localDataLineMsgRecord == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!localDataLineMsgRecord.isSendFromLocal());
        this.jdField_a_of_type_P.a.app.a().a().d();
        DataLineMsgSet localDataLineMsgSet = this.jdField_a_of_type_P.a.app.a().a(this.jdField_a_of_type_Long);
        if ((localDataLineMsgSet == null) || (localDataLineMsgSet.isSingle())) {
          break;
        }
      } while (LiteActivity.a(this.jdField_a_of_type_P.a).a(this.jdField_a_of_type_Long, LiteActivity.a(this.jdField_a_of_type_P.a)));
      LiteActivity.a(this.jdField_a_of_type_P.a).notifyDataSetChanged();
      return;
      LiteActivity.a(this.jdField_a_of_type_P.a).notifyDataSetChanged();
    } while (localDataLineMsgRecord.bIsResendOrRecvFile);
    LiteActivity.a(this.jdField_a_of_type_P.a.a, LiteActivity.a(this.jdField_a_of_type_P.a));
    LiteActivity.a(LiteActivity.a(this.jdField_a_of_type_P.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     v
 * JD-Core Version:    0.7.0.1
 */