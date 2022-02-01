import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public final class vrc
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramIntent == null) {
      return;
    }
    Bundle localBundle = paramIntent.getExtras();
    paramIntent = null;
    if (paramFromServiceMsg.isSuccess())
    {
      paramIntent = bgau.b(paramFromServiceMsg.getWupBuffer());
      localBundle.putInt("data_error_code", 0);
    }
    for (;;)
    {
      QQStoryContext.a().a().a(localBundle, paramIntent);
      return;
      localBundle.putString("data_error_msg", paramFromServiceMsg.getBusinessFailMsg());
      localBundle.putInt("data_error_code", paramFromServiceMsg.getBusinessFailCode());
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    paramPacket.setSSOCommand(paramIntent.getStringExtra("cmd"));
    paramPacket.putSendData(bgau.a(arrayOfByte));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    paramPacket.autoResend = paramIntent.getBooleanExtra("support_retry", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrc
 * JD-Core Version:    0.7.0.1
 */