import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class yvb
  extends MSFServlet
{
  private static String a = "QRCodeServlet";
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg != null) {
      QLog.d(a, 2, paramFromServiceMsg.toString());
    }
    Object localObject = null;
    boolean bool;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      bool = true;
      if (!bool) {
        break label120;
      }
      paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
      if (paramFromServiceMsg != null) {
        break label75;
      }
      bool = false;
      paramFromServiceMsg = (FromServiceMsg)localObject;
    }
    for (;;)
    {
      notifyObserver(paramIntent, 0, bool, paramFromServiceMsg, BusinessObserver.class);
      return;
      bool = false;
      break;
      label75:
      localObject = bgau.b(paramFromServiceMsg);
      paramFromServiceMsg = new Bundle();
      localObject = new String((byte[])localObject);
      paramFromServiceMsg.putString("result", (String)localObject);
      QLog.d(a, 2, (String)localObject);
      continue;
      label120:
      QLog.e(a, 2, " MSF response is null");
      paramFromServiceMsg = null;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      return;
    }
    Object localObject1 = new JSONObject();
    for (;;)
    {
      int i;
      String str;
      Object localObject2;
      try
      {
        paramIntent = paramIntent.getExtras();
        String[] arrayOfString = new String[15];
        arrayOfString[0] = "skey";
        arrayOfString[1] = "no_verify_token";
        arrayOfString[2] = "d";
        arrayOfString[3] = "appid";
        arrayOfString[4] = "ul";
        arrayOfString[5] = "bqq";
        arrayOfString[6] = "md5";
        arrayOfString[7] = "fromuin";
        arrayOfString[8] = "touin";
        arrayOfString[9] = "imei";
        arrayOfString[10] = "ip";
        arrayOfString[11] = "url";
        arrayOfString[12] = "guid";
        arrayOfString[13] = "uuid";
        arrayOfString[14] = "type";
        int j = arrayOfString.length;
        i = 0;
        if (i >= j) {
          break label245;
        }
        str = arrayOfString[i];
        if (!paramIntent.containsKey(str)) {
          break label315;
        }
        localObject2 = paramIntent.get(str);
        if ((localObject2 instanceof ArrayList)) {
          ((JSONObject)localObject1).put(str, new JSONArray((ArrayList)localObject2));
        } else if (TextUtils.equals("type", str)) {
          ((JSONObject)localObject1).put(str, Integer.valueOf(localObject2.toString()));
        }
      }
      catch (JSONException paramIntent)
      {
        QLog.d(a, 2, "json error");
        return;
      }
      ((JSONObject)localObject1).put(str, localObject2);
      break label315;
      label245:
      localObject1 = ((JSONObject)localObject1).toString();
      paramPacket.setTimeout(30000L);
      paramPacket.setSSOCommand(paramIntent.getString("cmd"));
      paramPacket.putSendData(bgau.a(((String)localObject1).getBytes()));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i(a, 2, "onSend result: " + (String)localObject1);
      return;
      label315:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yvb
 * JD-Core Version:    0.7.0.1
 */