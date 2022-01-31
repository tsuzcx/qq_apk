import com.dataline.activities.LiteActivity;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import java.io.File;

class al
  implements Runnable
{
  al(ak paramak, long paramLong, String paramString) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_Ak.a.b.a().b(this.jdField_a_of_type_Long);
    DataLineMsgSet localDataLineMsgSet = this.jdField_a_of_type_Ak.a.b.a().a(this.jdField_a_of_type_Long);
    if ((localDataLineMsgSet != null) && (!localDataLineMsgSet.isSingle())) {
      if (!LiteActivity.a(this.jdField_a_of_type_Ak.a).a(this.jdField_a_of_type_Long, LiteActivity.a(this.jdField_a_of_type_Ak.a))) {
        LiteActivity.a(this.jdField_a_of_type_Ak.a).notifyDataSetChanged();
      }
    }
    for (;;)
    {
      if ((localObject != null) && (((DataLineMsgRecord)localObject).path != null) && (((DataLineMsgRecord)localObject).thumbPath != null) && (((DataLineMsgRecord)localObject).path.equals(this.jdField_a_of_type_JavaLangString)))
      {
        localObject = new File(((DataLineMsgRecord)localObject).thumbPath);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
      }
      return;
      LiteActivity.a(this.jdField_a_of_type_Ak.a).notifyDataSetChanged();
      if ((localObject != null) && (!((DataLineMsgRecord)localObject).bIsResendOrRecvFile))
      {
        LiteActivity.c(this.jdField_a_of_type_Ak.a);
        LiteActivity.b(this.jdField_a_of_type_Ak.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     al
 * JD-Core Version:    0.7.0.1
 */