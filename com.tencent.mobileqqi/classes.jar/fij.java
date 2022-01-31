import MessageSvcPack.UinPairReadInfo;
import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class fij
  extends SendMessageHandler.SendMessageRunnable
{
  public fij(MessageHandler paramMessageHandler, ArrayList paramArrayList, long paramLong1, long paramLong2) {}
  
  public void run()
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
      QLog.d("Q.msg.MessageHandler", 2, "<ReadReport><S>_C2C_reqSeq:" + this.jdField_a_of_type_Long + ((StringBuilder)localObject).toString());
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("MessageSvc.MsgReadedReport");
    ((ToServiceMsg)localObject).extraData.putSerializable("vMsgKey", this.jdField_a_of_type_JavaUtilArrayList);
    ((ToServiceMsg)localObject).extraData.putByteArray("vSyncCookie", this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.a());
    ((ToServiceMsg)localObject).extraData.putBoolean("bPbReadedReport", true);
    ((ToServiceMsg)localObject).extraData.putLong("timeOut", this.e);
    ((ToServiceMsg)localObject).extraData.putLong("startTime", this.b);
    ((ToServiceMsg)localObject).extraData.putInt("retryIndex", this.jdField_a_of_type_Int);
    ((ToServiceMsg)localObject).extraData.putLong("msgSeq", this.jdField_a_of_type_Long);
    ((ToServiceMsg)localObject).setEnableFastResend(true);
    ((ToServiceMsg)localObject).setTimeout(this.e);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a((ToServiceMsg)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fij
 * JD-Core Version:    0.7.0.1
 */