import GIFT_MALL_PROTOCOL.doufu_piece_rsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.manager.MonitorManager;
import java.util.HashMap;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class anea
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramIntent == null) || (paramFromServiceMsg == null))
    {
      MonitorManager.a().d(19, 1, " 请求失败 intent =" + paramIntent + "  respone= " + paramFromServiceMsg, false);
      return;
    }
    int i = paramFromServiceMsg.getResultCode();
    paramIntent = new Bundle();
    paramIntent.putString("msg", "servlet result code is " + i);
    if (i == 1000)
    {
      paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
      doufu_piece_rsp localdoufu_piece_rsp = avst.a(paramFromServiceMsg, new int[1]);
      if (localdoufu_piece_rsp != null)
      {
        paramIntent.putInt("ret", 0);
        paramIntent.putSerializable("data", localdoufu_piece_rsp);
        notifyObserver(null, 1009, true, paramIntent, akln.class);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BirthDayNoticeServlet", 2, "GET_BIRTHDAY_DATA fail, decode result is null");
      }
      paramIntent.putInt("ret", -2);
      MonitorManager.a().d(19, 2, " 解包失败 " + paramFromServiceMsg, false);
      notifyObserver(null, 1009, false, paramIntent, akln.class);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BirthDayNoticeServlet", 2, "GET_BIRTHDAY_DATA fail, resultCode=" + i);
    }
    MonitorManager.a().d(19, 3, " 后台返回失败， 错误码 " + i + " 错误信息 " + paramFromServiceMsg.getBusinessFailMsg(), false);
    paramIntent.putInt("ret", -3);
    notifyObserver(null, 1009, false, paramIntent, akln.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    avst localavst = new avst(Long.valueOf(paramIntent.getLongExtra("selfuin", 0L)).longValue(), new HashMap());
    byte[] arrayOfByte = localavst.encode();
    paramIntent = arrayOfByte;
    if (arrayOfByte == null)
    {
      QLog.e("BirthDayNoticeServlet", 1, "onSend request encode result is null.cmd=" + localavst.uniKey());
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(60000L);
    paramPacket.setSSOCommand("SQQzoneSvc." + localavst.uniKey());
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anea
 * JD-Core Version:    0.7.0.1
 */