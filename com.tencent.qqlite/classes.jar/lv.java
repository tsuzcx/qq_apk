import android.os.Handler;
import android.os.Message;
import com.tencent.biz.common.util.OfflineSecurity;
import com.tencent.biz.common.util.OfflineSecurity.VerifyListener;

public final class lv
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    if (OfflineSecurity.jdField_a_of_type_ComTencentBizCommonUtilOfflineSecurity$VerifyListener != null)
    {
      OfflineSecurity.jdField_a_of_type_ComTencentBizCommonUtilOfflineSecurity$VerifyListener.a(((Boolean)paramMessage.obj).booleanValue());
      OfflineSecurity.jdField_a_of_type_ComTencentBizCommonUtilOfflineSecurity$VerifyListener = null;
      OfflineSecurity.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     lv
 * JD-Core Version:    0.7.0.1
 */