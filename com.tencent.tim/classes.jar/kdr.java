import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class kdr
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EcShopServlet", 2, "onReceive cmd=" + paramIntent.getStringExtra("cmd") + ",success=" + paramFromServiceMsg.isSuccess());
    }
    byte[] arrayOfByte;
    if (paramFromServiceMsg.isSuccess())
    {
      int i = paramFromServiceMsg.getWupBuffer().length - 4;
      arrayOfByte = new byte[i];
      aqoj.copyData(arrayOfByte, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    }
    for (;;)
    {
      new Bundle().putByteArray("data", arrayOfByte);
      kdp localkdp = (kdp)((QQAppInterface)super.getAppRuntime()).getBusinessHandler(68);
      if (localkdp != null) {
        localkdp.a(paramIntent, paramFromServiceMsg, arrayOfByte);
      }
      QLog.d("EcShopServlet", 2, "onReceive exit");
      return;
      arrayOfByte = null;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    String str = paramIntent.getStringExtra("cmd");
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    long l = paramIntent.getLongExtra("timeout", 30000L);
    if (!TextUtils.isEmpty(str))
    {
      paramPacket.setSSOCommand("SQQShopFolderSvc." + str);
      paramPacket.setTimeout(l);
      if (arrayOfByte == null) {
        break label135;
      }
      paramIntent = new byte[arrayOfByte.length + 4];
      aqoj.DWord2Byte(paramIntent, 0, arrayOfByte.length + 4);
      aqoj.b(paramIntent, 4, arrayOfByte, arrayOfByte.length);
      paramPacket.putSendData(paramIntent);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EcShopServlet", 2, "onSend exit cmd=" + str);
      }
      return;
      label135:
      paramIntent = new byte[4];
      aqoj.DWord2Byte(paramIntent, 0, 4L);
      paramPacket.putSendData(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kdr
 * JD-Core Version:    0.7.0.1
 */