import android.os.Handler;
import android.os.Message;
import com.tencent.biz.common.util.ImageUtil;
import com.tencent.biz.common.util.LoadedCallBack;
import com.tencent.qphone.base.util.QLog;

public final class bhs
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.arg1 == 0) && (ImageUtil.jdField_a_of_type_ComTencentBizCommonUtilLoadedCallBack != null)) {
      ImageUtil.jdField_a_of_type_ComTencentBizCommonUtilLoadedCallBack.a((String)paramMessage.obj);
    }
    for (;;)
    {
      ImageUtil.jdField_a_of_type_ComTencentBizCommonUtilLoadedCallBack = null;
      ImageUtil.d = null;
      ImageUtil.e = null;
      long l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i(ImageUtil.b, 2, "======time:" + (l - ImageUtil.jdField_a_of_type_Long) + ", start:" + ImageUtil.jdField_a_of_type_Long + ", endTime:" + l);
      }
      return;
      ImageUtil.jdField_a_of_type_ComTencentBizCommonUtilLoadedCallBack.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bhs
 * JD-Core Version:    0.7.0.1
 */