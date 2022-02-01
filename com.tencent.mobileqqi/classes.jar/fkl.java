import android.content.ContentValues;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;

public class fkl
  implements Runnable
{
  public fkl(DataLineMsgProxy paramDataLineMsgProxy, long paramLong) {}
  
  public void run()
  {
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy.a(this.jdField_a_of_type_Long);
    if (localDataLineMsgRecord != null)
    {
      localDataLineMsgRecord.issuc = false;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("issuc", Boolean.valueOf(false));
      this.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy.a(DataLineMsgRecord.tableName(), localContentValues, "msgId=?", new String[] { String.valueOf(localDataLineMsgRecord.msgId) }, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fkl
 * JD-Core Version:    0.7.0.1
 */