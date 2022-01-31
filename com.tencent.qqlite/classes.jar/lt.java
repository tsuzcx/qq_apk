import android.os.Handler;
import android.os.Message;
import com.tencent.biz.common.util.ShareToQZone;
import com.tencent.biz.common.util.ShareToQZoneBack;
import com.tencent.qphone.base.util.QLog;

public final class lt
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.i(ShareToQZone.jdField_a_of_type_JavaLangString, 2, "======handleMessage =========");
    }
    if (ShareToQZone.jdField_a_of_type_ComTencentBizCommonUtilShareToQZoneBack != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(ShareToQZone.jdField_a_of_type_JavaLangString, 2, "======handleMessage *****");
      }
      ShareToQZone.jdField_a_of_type_ComTencentBizCommonUtilShareToQZoneBack.a(paramMessage.arg1, ShareToQZone.b);
    }
    ShareToQZone.jdField_a_of_type_AndroidContentContext = null;
    ShareToQZone.jdField_a_of_type_AndroidOsBundle = null;
    ShareToQZone.jdField_a_of_type_ComTencentBizCommonUtilShareToQZoneBack = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     lt
 * JD-Core Version:    0.7.0.1
 */