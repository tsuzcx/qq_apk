import android.os.AsyncTask;
import android.os.SystemClock;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.BasePicOprerator;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PicUpExtraInfo;
import com.tencent.qphone.base.util.QLog;

public class gie
  extends AsyncTask
{
  public gie(BasePicOprerator paramBasePicOprerator, PicUploadInfo paramPicUploadInfo) {}
  
  protected Void a(Void... paramVarArgs)
  {
    paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo;
    Object localObject = new CompressInfo();
    ((CompressInfo)localObject).c = paramVarArgs.jdField_g_of_type_JavaLangString;
    CompressOperator.b((CompressInfo)localObject);
    if (((CompressInfo)localObject).jdField_e_of_type_JavaLangString != null)
    {
      paramVarArgs.h = ((CompressInfo)localObject).jdField_e_of_type_JavaLangString;
      paramVarArgs.jdField_f_of_type_Int = ((CompressInfo)localObject).d;
      paramVarArgs.jdField_g_of_type_Int = ((CompressInfo)localObject).jdField_e_of_type_Int;
    }
    paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.a(paramVarArgs);
    if (MessageForPic.class.isInstance(paramVarArgs)) {
      if (!QLog.isColorLevel()) {
        break label530;
      }
    }
    label530:
    for (long l = SystemClock.uptimeMillis();; l = 0L)
    {
      BasePicOprerator.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator, (MessageForPic)paramVarArgs);
      Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "cachePicToDisk", "cost:" + (SystemClock.uptimeMillis() - l));
      if ((this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_b_of_type_Int == 1001) && (!this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.c)))
      {
        this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.c, this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString, paramVarArgs.uniseq);
        if (this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_b_of_type_Boolean) {
          BasePicOprerator.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator, paramVarArgs);
        }
        Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo, "getSendTask.start old lbs protocol", "");
        return null;
      }
      this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramVarArgs;
      l = System.currentTimeMillis();
      localObject = new TransferRequest();
      ((TransferRequest)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      ((TransferRequest)localObject).jdField_b_of_type_JavaLangString = paramVarArgs.frienduin;
      ((TransferRequest)localObject).c = paramVarArgs.senderuin;
      ((TransferRequest)localObject).jdField_a_of_type_Int = paramVarArgs.istroop;
      ((TransferRequest)localObject).jdField_b_of_type_Int = 1;
      ((TransferRequest)localObject).jdField_a_of_type_Long = paramVarArgs.uniseq;
      ((TransferRequest)localObject).jdField_a_of_type_Boolean = true;
      ((TransferRequest)localObject).d = this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_Int;
      ((TransferRequest)localObject).jdField_g_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString;
      ((TransferRequest)localObject).jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_f_of_type_JavaLangString;
      TransferRequest.PicUpExtraInfo localPicUpExtraInfo = new TransferRequest.PicUpExtraInfo();
      if (this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.a() == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localPicUpExtraInfo.jdField_a_of_type_Boolean = bool;
        ((TransferRequest)localObject).jdField_a_of_type_JavaLangObject = localPicUpExtraInfo;
        ((TransferRequest)localObject).jdField_a_of_type_ComTencentMobileqqPicUpCallBack = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator;
        ((TransferRequest)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((TransferRequest)localObject);
        Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "sendReq", "cost:" + (System.currentTimeMillis() - l));
        if (this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_b_of_type_Boolean) {
          BasePicOprerator.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator, paramVarArgs);
        }
        Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "getSendTask.start", "");
        return null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gie
 * JD-Core Version:    0.7.0.1
 */