import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class abww
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TraceReport", 2, "onReceive cmd=" + paramIntent.getStringExtra("cmd") + ",success=" + paramFromServiceMsg.isSuccess() + ", retCode=" + paramFromServiceMsg.getResultCode());
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
      Bundle localBundle = new Bundle();
      localBundle.putInt("extra_result_code", paramFromServiceMsg.getResultCode());
      localBundle.putString("cmd", paramIntent.getStringExtra("cmd"));
      localBundle.putInt("retryTime", paramIntent.getIntExtra("retryTime", 0));
      localBundle.putByteArray("request_data", paramIntent.getByteArrayExtra("data"));
      localBundle.putSerializable("serializable", paramIntent.getSerializableExtra("serializable"));
      localBundle.putBundle("extra_bundle_key", paramIntent.getBundleExtra("extra_bundle_key"));
      localBundle.putByteArray("data", arrayOfByte);
      notifyObserver(paramIntent, 0, paramFromServiceMsg.isSuccess(), localBundle, null);
      return;
      arrayOfByte = null;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    String str = paramIntent.getStringExtra("cmd");
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    long l = paramIntent.getIntExtra("timeout", 30000);
    if (!TextUtils.isEmpty(str))
    {
      paramPacket.setSSOCommand(str);
      paramPacket.setTimeout(l);
      if (arrayOfByte == null) {
        break label118;
      }
      paramIntent = new byte[arrayOfByte.length + 4];
      aqoj.DWord2Byte(paramIntent, 0, arrayOfByte.length + 4);
      aqoj.b(paramIntent, 4, arrayOfByte, arrayOfByte.length);
      paramPacket.putSendData(paramIntent);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TraceReport", 2, "onSend exit cmd=" + str);
      }
      return;
      label118:
      paramIntent = new byte[4];
      aqoj.DWord2Byte(paramIntent, 0, 4L);
      paramPacket.putSendData(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abww
 * JD-Core Version:    0.7.0.1
 */