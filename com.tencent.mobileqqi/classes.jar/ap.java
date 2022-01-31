import com.dataline.activities.LiteActivity;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;

class ap
  implements Runnable
{
  ap(ak paramak, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_Ak.a.b.a().b(this.jdField_a_of_type_Long);
    if (localDataLineMsgRecord == null) {}
    label206:
    do
    {
      do
      {
        return;
      } while (localDataLineMsgRecord.isSendFromLocal());
      if (this.jdField_a_of_type_Boolean)
      {
        localDataLineMsgRecord.issuc = true;
        localDataLineMsgRecord.fileMsgStatus = 0L;
        this.jdField_a_of_type_Ak.a.b.a().c(localDataLineMsgRecord.msgId);
        this.jdField_a_of_type_Ak.a.b.a().i();
      }
      for (;;)
      {
        DataLineMsgSet localDataLineMsgSet = this.jdField_a_of_type_Ak.a.b.a().a(this.jdField_a_of_type_Long);
        if ((localDataLineMsgSet == null) || (localDataLineMsgSet.isSingle())) {
          break label206;
        }
        if (LiteActivity.a(this.jdField_a_of_type_Ak.a).a(this.jdField_a_of_type_Long, LiteActivity.a(this.jdField_a_of_type_Ak.a))) {
          break;
        }
        LiteActivity.a(this.jdField_a_of_type_Ak.a).notifyDataSetChanged();
        return;
        localDataLineMsgRecord.fileMsgStatus = 1L;
        this.jdField_a_of_type_Ak.a.b.a().c(localDataLineMsgRecord.msgId);
        this.jdField_a_of_type_Ak.a.b.a().i();
      }
      LiteActivity.a(this.jdField_a_of_type_Ak.a).notifyDataSetChanged();
    } while (localDataLineMsgRecord.bIsResendOrRecvFile);
    LiteActivity.c(this.jdField_a_of_type_Ak.a);
    LiteActivity.b(this.jdField_a_of_type_Ak.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ap
 * JD-Core Version:    0.7.0.1
 */