import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class anew
  extends MSFServlet
{
  private ArrayList<Integer> Ar;
  private String cdt;
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg != null) {}
    for (int i = paramFromServiceMsg.getResultCode();; i = -1)
    {
      paramIntent = new Bundle();
      paramIntent.putString("msg", "servlet result code is " + i);
      paramIntent.putString("requestType", this.cdt);
      paramIntent.putIntegerArrayList("appid", this.Ar);
      if (i != 1000) {
        break label148;
      }
      paramFromServiceMsg = avyw.a(paramFromServiceMsg.getWupBuffer());
      if (paramFromServiceMsg == null) {
        break;
      }
      paramIntent.putInt("ret", 0);
      paramIntent.putSerializable("data", paramFromServiceMsg);
      notifyObserver(null, 1007, true, paramIntent, akln.class);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QzoneGetQbossServlet", 2, "QZONE_GET_QBOSS_DATA fail, decode result is null");
    }
    paramIntent.putInt("ret", -2);
    notifyObserver(null, 1007, false, paramIntent, akln.class);
    return;
    label148:
    if (QLog.isColorLevel()) {
      QLog.d("QzoneGetQbossServlet", 2, "QZONE_GET_QBOSS_DATA fail, resultCode=" + i);
    }
    paramIntent.putInt("ret", -3);
    notifyObserver(null, 1007, false, paramIntent, akln.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    long l = paramIntent.getLongExtra("selfuin", 0L);
    Object localObject = paramIntent.getIntegerArrayListExtra("appid");
    boolean bool = paramIntent.getBooleanExtra("needReport", false);
    this.cdt = paramIntent.getStringExtra("requestType");
    this.Ar = ((ArrayList)localObject);
    avyw localavyw = new avyw(Long.valueOf(l).longValue(), (ArrayList)localObject, bool);
    localObject = localavyw.encode();
    paramIntent = (Intent)localObject;
    if (localObject == null)
    {
      QLog.e("QzoneGetQbossServlet", 1, "onSend request encode result is null.cmd=" + localavyw.uniKey());
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(60000L);
    paramPacket.setSSOCommand("SQQzoneSvc." + localavyw.uniKey());
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anew
 * JD-Core Version:    0.7.0.1
 */