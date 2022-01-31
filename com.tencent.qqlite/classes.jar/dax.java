import android.content.ContentValues;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;

public class dax
  implements Runnable
{
  public dax(DataLineMsgProxy paramDataLineMsgProxy, long paramLong, String paramString, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy.a(this.jdField_a_of_type_Long);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("serverPath", this.jdField_a_of_type_JavaLangString);
    localContentValues.put("md5", this.jdField_a_of_type_ArrayOfByte);
    if (localDataLineMsgRecord != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy.a(DataLineMsgRecord.tableName(), localContentValues, "msgId=?", new String[] { String.valueOf(localDataLineMsgRecord.msgId) }, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dax
 * JD-Core Version:    0.7.0.1
 */