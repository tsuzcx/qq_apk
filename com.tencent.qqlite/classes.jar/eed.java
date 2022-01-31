import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;

public class eed
  implements Runnable
{
  public eed(BaseShortVideoOprerator paramBaseShortVideoOprerator, ShortVideoUploadInfo paramShortVideoUploadInfo) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo;
    int i;
    if (((ShortVideoUploadInfo)localObject).jdField_g_of_type_Int == 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.a((ShortVideoUploadInfo)localObject);
      i = 1;
    }
    for (;;)
    {
      if (localObject == null)
      {
        return;
        if (((ShortVideoUploadInfo)localObject).jdField_g_of_type_Int == 1)
        {
          localObject = (MessageForShortVideo)((ShortVideoUploadInfo)localObject).a;
          i = 0;
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
        long l = System.currentTimeMillis();
        TransferRequest localTransferRequest = new TransferRequest();
        localTransferRequest.jdField_a_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
        localTransferRequest.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).frienduin;
        localTransferRequest.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
        if (((MessageRecord)localObject).istroop == 0) {
          localTransferRequest.jdField_b_of_type_Int = 6;
        }
        for (;;)
        {
          localTransferRequest.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
          localTransferRequest.jdField_a_of_type_Boolean = true;
          localTransferRequest.d = 0;
          localTransferRequest.e = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo.e;
          localTransferRequest.h = (this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo.jdField_g_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo.h + "QQ_&_MoblieQQ_&_QQ" + this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo.jdField_f_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo.jdField_f_of_type_JavaLangString);
          if (this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack != null) {
            localTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack = this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator;
          }
          localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTransferRequest);
          if (i != 0) {
            BaseShortVideoOprerator.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator, (MessageRecord)localObject);
          }
          Logger.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.jdField_a_of_type_JavaLangString, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
          Logger.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.jdField_a_of_type_JavaLangString, "doSendShortVideo.start", "TransferRequest: " + localTransferRequest.toString());
          return;
          if (((MessageRecord)localObject).istroop == 3000) {
            localTransferRequest.jdField_b_of_type_Int = 17;
          } else if (((MessageRecord)localObject).istroop == 1) {
            localTransferRequest.jdField_b_of_type_Int = 9;
          }
        }
      }
      localObject = null;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eed
 * JD-Core Version:    0.7.0.1
 */