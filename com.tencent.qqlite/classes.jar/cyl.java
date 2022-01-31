import MessageSvcPack.UinPairReadInfo;
import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.BaseMessageProcessor.RequestBuilder;
import com.tencent.mobileqq.app.message.C2CMessageProcessor;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class cyl
  implements BaseMessageProcessor.RequestBuilder
{
  public cyl(C2CMessageProcessor paramC2CMessageProcessor, ArrayList paramArrayList) {}
  
  public ToServiceMsg a()
  {
    Object localObject = new StringBuilder("-ReportList-");
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      UinPairReadInfo localUinPairReadInfo = (UinPairReadInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      ((StringBuilder)localObject).append("-uin:").append(localUinPairReadInfo.lPeerUin).append("-ReadTime-").append(localUinPairReadInfo.lLastReadTime);
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "<ReadReport><S>_C2C:" + ((StringBuilder)localObject).toString());
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageC2CMessageProcessor.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("MessageSvc.MsgReadedReport");
    ((ToServiceMsg)localObject).extraData.putSerializable("vMsgKey", this.jdField_a_of_type_JavaUtilArrayList);
    ((ToServiceMsg)localObject).extraData.putByteArray("vSyncCookie", this.jdField_a_of_type_ComTencentMobileqqAppMessageC2CMessageProcessor.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a());
    ((ToServiceMsg)localObject).extraData.putBoolean("bPbReadedReport", true);
    ((ToServiceMsg)localObject).setEnableFastResend(true);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cyl
 * JD-Core Version:    0.7.0.1
 */