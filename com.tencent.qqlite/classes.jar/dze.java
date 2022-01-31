import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.BasePicOprerator;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PicUpExtraInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

class dze
  extends AsyncTask
{
  dze(dzd paramdzd) {}
  
  protected Void a(Void... paramVarArgs)
  {
    Logger.a(this.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_b_of_type_JavaLangString, this.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadNotExistFiles start");
    int i = 0;
    while (i < this.a.a.jdField_a_of_type_JavaUtilArrayList.size())
    {
      PicFowardInfo localPicFowardInfo = (PicFowardInfo)this.a.a.b.get(i);
      paramVarArgs = (PicResult)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (paramVarArgs.d == -2)
      {
        String str = BasePicOprerator.a(this.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator, localPicFowardInfo);
        if (str != null)
        {
          Logger.a(this.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_b_of_type_JavaLangString, this.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.uploadFiles", "Upload [" + i + "]mLocalPath ＝ " + str);
          TransferRequest localTransferRequest = new TransferRequest();
          localTransferRequest.e = false;
          localTransferRequest.jdField_a_of_type_JavaLangString = this.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
          localTransferRequest.jdField_b_of_type_JavaLangString = this.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
          localTransferRequest.c = this.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
          localTransferRequest.jdField_a_of_type_Int = this.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
          localTransferRequest.jdField_b_of_type_Int = 1;
          localTransferRequest.jdField_a_of_type_Long = (this.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + i);
          for (paramVarArgs = localTransferRequest.jdField_b_of_type_JavaLangString + localTransferRequest.jdField_a_of_type_Long; this.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a.containsKey(paramVarArgs); paramVarArgs = localTransferRequest.jdField_b_of_type_JavaLangString + localTransferRequest.jdField_a_of_type_Long) {
            localTransferRequest.jdField_a_of_type_Long += 100L;
          }
          localTransferRequest.jdField_a_of_type_Boolean = true;
          localTransferRequest.d = localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_Int;
          localTransferRequest.h = str;
          paramVarArgs = new TransferRequest.PicUpExtraInfo();
          paramVarArgs.jdField_a_of_type_Boolean = false;
          localTransferRequest.jdField_a_of_type_JavaLangObject = paramVarArgs;
          localTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack = new dzf(this, i, str);
          this.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTransferRequest);
        }
      }
      else
      {
        i += 1;
        continue;
      }
      paramVarArgs.d = -1;
      paramVarArgs.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = new PicInfoInterface.ErrInfo();
      paramVarArgs.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_b_of_type_JavaLangString = ("Get target pic filepath of [" + i + "] failed");
      if ((localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_b_of_type_Int == 1) || (localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_b_of_type_Int == 3000)) {}
      for (paramVarArgs.jdField_a_of_type_JavaLangObject = this.a.a.a(null, null, i);; paramVarArgs.jdField_a_of_type_JavaLangObject = this.a.a.a(null, null, i))
      {
        Logger.b(this.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_b_of_type_JavaLangString, this.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.uploadFiles", "Upload [" + i + "] failed, errDec ＝ " + paramVarArgs.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_b_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.e("MultiMsg", 2, "[uploadForwardMultiMsgPics] upload [" + i + "] failed, errDec ＝ " + paramVarArgs.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_b_of_type_JavaLangString);
        }
        dzd.a(this.a);
        if (dzd.a(this.a) != 0) {
          break;
        }
        dzc.a(this.a.a);
        break;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dze
 * JD-Core Version:    0.7.0.1
 */