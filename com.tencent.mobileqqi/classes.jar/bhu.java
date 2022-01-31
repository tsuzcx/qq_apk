import android.os.Handler;
import android.os.Message;
import com.tencent.biz.common.util.OfflineSecurity;
import com.tencent.biz.common.util.OfflineSecurity.VerifyListener;

public final class bhu
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bhu
 * JD-Core Version:    0.7.0.1
 */