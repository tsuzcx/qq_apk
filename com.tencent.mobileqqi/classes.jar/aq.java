import com.dataline.activities.LiteActivity;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;

class aq
  implements Runnable
{
  aq(ak paramak, long paramLong) {}
  
  public void run()
  {
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_Ak.a.b.a().b(this.jdField_a_of_type_Long);
    if (localDataLineMsgRecord == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!localDataLineMsgRecord.isSendFromLocal());
        this.jdField_a_of_type_Ak.a.b.a().i();
        DataLineMsgSet localDataLineMsgSet = this.jdField_a_of_type_Ak.a.b.a().a(this.jdField_a_of_type_Long);
        if ((localDataLineMsgSet == null) || (localDataLineMsgSet.isSingle())) {
          break;
        }
      } while (LiteActivity.a(this.jdField_a_of_type_Ak.a).a(this.jdField_a_of_type_Long, LiteActivity.a(this.jdField_a_of_type_Ak.a)));
      LiteActivity.a(this.jdField_a_of_type_Ak.a).notifyDataSetChanged();
      return;
      LiteActivity.a(this.jdField_a_of_type_Ak.a).notifyDataSetChanged();
    } while (localDataLineMsgRecord.bIsResendOrRecvFile);
    LiteActivity.c(this.jdField_a_of_type_Ak.a);
    LiteActivity.b(this.jdField_a_of_type_Ak.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     aq
 * JD-Core Version:    0.7.0.1
 */