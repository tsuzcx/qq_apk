import android.content.ContentValues;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;

public class czu
  implements Runnable
{
  public czu(DataLineMsgProxy paramDataLineMsgProxy, long paramLong, String paramString) {}
  
  public void run()
  {
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy.a(this.jdField_a_of_type_Long);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("path", this.jdField_a_of_type_JavaLangString);
    if (localDataLineMsgRecord != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy.a(DataLineMsgRecord.tableName(), localContentValues, "msgId=?", new String[] { String.valueOf(localDataLineMsgRecord.msgId) }, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     czu
 * JD-Core Version:    0.7.0.1
 */