import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.BasePicOprerator;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PicUpExtraInfo;

public class eao
  extends AsyncTask
{
  public eao(BasePicOprerator paramBasePicOprerator, PicFowardInfo paramPicFowardInfo) {}
  
  protected Void a(Void... paramVarArgs)
  {
    Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "doForward", "start");
    if (this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.a("doForward", "rec==null");
      this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.a(4, this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
      return null;
    }
    paramVarArgs = (MessageForPic)this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    paramVarArgs.path = this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g;
    Object localObject = new CompressInfo();
    ((CompressInfo)localObject).c = paramVarArgs.path;
    CompressOperator.b((CompressInfo)localObject);
    if (((CompressInfo)localObject).jdField_e_of_type_JavaLangString != null)
    {
      paramVarArgs.thumbMsgUrl = ((CompressInfo)localObject).jdField_e_of_type_JavaLangString;
      paramVarArgs.thumbWidth = ((CompressInfo)localObject).d;
      paramVarArgs.thumbHeight = ((CompressInfo)localObject).jdField_e_of_type_Int;
    }
    paramVarArgs.serial();
    this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramVarArgs.frienduin, paramVarArgs.istroop, paramVarArgs.uniseq, paramVarArgs.msgData);
    if ((this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_b_of_type_Int == 1001) && (!this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.c)))
    {
      this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.c, this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
      BasePicOprerator.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "getFowardTask.start old lbs protocol", "");
      return null;
    }
    paramVarArgs = new TransferRequest();
    paramVarArgs.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    paramVarArgs.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
    paramVarArgs.c = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
    paramVarArgs.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
    paramVarArgs.jdField_b_of_type_Int = 1;
    paramVarArgs.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
    paramVarArgs.jdField_a_of_type_Boolean = true;
    paramVarArgs.d = this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_Int;
    paramVarArgs.h = this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g;
    localObject = new TransferRequest.PicUpExtraInfo();
    ((TransferRequest.PicUpExtraInfo)localObject).jdField_a_of_type_Boolean = false;
    paramVarArgs.jdField_a_of_type_JavaLangObject = localObject;
    paramVarArgs.jdField_a_of_type_ComTencentMobileqqPicUpCallBack = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator;
    localObject = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    ((TransFileController)localObject).d(paramVarArgs.jdField_b_of_type_JavaLangString + paramVarArgs.jdField_a_of_type_Long);
    ((TransFileController)localObject).a(paramVarArgs);
    BasePicOprerator.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "doForward", "end");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eao
 * JD-Core Version:    0.7.0.1
 */