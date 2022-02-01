import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

public class gnw
  implements Runnable
{
  public gnw(TransFileController paramTransFileController, String paramString, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    CompressInfo localCompressInfo = new CompressInfo(this.jdField_a_of_type_JavaLangString, 0);
    localCompressInfo.f = 0;
    CompressOperator.a(localCompressInfo);
    if (QLog.isColorLevel()) {
      QLog.d("Barry uploadPortrait", 2, ".uploadPhoto(), img_path = " + localCompressInfo.e);
    }
    if (!StringUtil.b(localCompressInfo.e))
    {
      TransferRequest localTransferRequest = new TransferRequest();
      localTransferRequest.jdField_a_of_type_Boolean = true;
      localTransferRequest.g = localCompressInfo.e;
      localTransferRequest.b = 22;
      localTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack = new gnx(this);
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a(localTransferRequest);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gnw
 * JD-Core Version:    0.7.0.1
 */