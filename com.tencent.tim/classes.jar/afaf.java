import android.content.Intent;
import com.tencent.mobileqq.data.QzoneCommonIntent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import cooperation.qzone.QzoneExternalRequest;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class afaf
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramIntent == null) {}
    while (!(paramIntent instanceof QzoneCommonIntent)) {
      return;
    }
    paramIntent = (QzoneCommonIntent)paramIntent;
    paramIntent.getProcessor().a(this, paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if ((paramIntent instanceof QzoneCommonIntent))
    {
      avpr localavpr = ((QzoneCommonIntent)paramIntent).getRequest();
      byte[] arrayOfByte = localavpr.encode();
      paramIntent = arrayOfByte;
      if (arrayOfByte == null) {
        paramIntent = new byte[4];
      }
      paramPacket.setTimeout(30000L);
      paramPacket.setSSOCommand("SQQzoneSvc." + localavpr.uniKey());
      paramPacket.putSendData(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afaf
 * JD-Core Version:    0.7.0.1
 */