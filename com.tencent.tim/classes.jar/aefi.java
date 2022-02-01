import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class aefi
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.isSuccess()) {}
    for (byte[] arrayOfByte = aqnv.J(paramFromServiceMsg.getWupBuffer());; arrayOfByte = null)
    {
      new Bundle().putByteArray("data", arrayOfByte);
      acms localacms = (acms)((QQAppInterface)getAppRuntime()).getBusinessHandler(20);
      if (localacms != null) {
        localacms.a(paramIntent, paramFromServiceMsg, arrayOfByte);
      }
      return;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    paramPacket.setSSOCommand(paramIntent.getStringExtra("cmd"));
    paramPacket.putSendData(aqnv.I(arrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aefi
 * JD-Core Version:    0.7.0.1
 */