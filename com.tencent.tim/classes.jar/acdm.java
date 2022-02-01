import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class acdm
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataLineServlet", 2, "onReceive called");
    }
    if (paramIntent == null)
    {
      QLog.e("DataLineServlet", 1, "onReceive : req is null");
      return;
    }
    paramIntent.getExtras().putParcelable("response", paramFromServiceMsg);
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
    paramFromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), paramIntent);
    ((acde)localQQAppInterface.getBusinessHandler(8)).k(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataLineServlet", 2, "onSend called");
    }
    if (paramIntent == null) {
      QLog.e("DataLineServlet", 1, "onSend : req is null");
    }
    do
    {
      return;
      paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
      if (paramIntent == null) {
        break;
      }
      paramPacket.setSSOCommand(paramIntent.getServiceCmd());
      paramPacket.putSendData(paramIntent.getWupBuffer());
      paramPacket.setTimeout(paramIntent.getTimeout());
    } while (paramIntent.isNeedCallback());
    paramPacket.setNoResponse();
    return;
    QLog.e("DataLineServlet", 1, "onSend : toMsg is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acdm
 * JD-Core Version:    0.7.0.1
 */