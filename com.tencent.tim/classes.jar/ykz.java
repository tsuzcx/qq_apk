import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituResponse;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.zhitu.gate.ZhituSafeGate.GateInfo;
import tencent.im.zhitu.gate.ZhituSafeGate.RspBody;

public class ykz
  extends MSFServlet
{
  private void a(Intent paramIntent, int paramInt, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("ErrorCode", paramInt);
    localBundle.putParcelable("FromServerMsg", paramFromServiceMsg);
    localBundle.putString("UniqueKey", paramIntent.getStringExtra("ZhituReqKey"));
    notifyObserver(paramIntent, 0, false, localBundle, yks.class);
  }
  
  private byte[] r(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 4];
    aqoj.DWord2Byte(arrayOfByte, 0, paramArrayOfByte.length + 4);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    return arrayOfByte;
  }
  
  public String[] getPreferSSOCommands()
  {
    return new String[] { "AIMessage.Text2Image", "MQInference.ZhituReport" };
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituServlet", 2, "onReceive with code: " + paramFromServiceMsg.getResultCode());
    }
    Object localObject = paramIntent.getStringExtra("ZhituCMD");
    if (((String)localObject).equals("MQInference.ZhituReport")) {}
    int i;
    do
    {
      do
      {
        do
        {
          return;
          if (!((String)localObject).equals("ZhituGate.Check")) {
            break label295;
          }
          if (!paramFromServiceMsg.isSuccess()) {
            break;
          }
          paramIntent = getAppRuntime();
        } while ((paramIntent == null) || (!(paramIntent instanceof AppInterface)));
        i = paramFromServiceMsg.getWupBuffer().length - 4;
        localObject = new byte[i];
        aqoj.copyData((byte[])localObject, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
        paramFromServiceMsg.putWupBuffer((byte[])localObject);
        for (;;)
        {
          try
          {
            paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
            localObject = new ZhituSafeGate.RspBody();
            ((ZhituSafeGate.RspBody)localObject).mergeFrom(paramFromServiceMsg);
            i = ((ZhituSafeGate.RspBody)localObject).int32_result.get();
            if (i != 0) {
              break;
            }
            i = ((ZhituSafeGate.GateInfo)((ZhituSafeGate.RspBody)localObject).gate_info.get()).uint32_state.get();
            paramFromServiceMsg = ykm.a((QQAppInterface)paramIntent);
            if (i == 1)
            {
              bool = true;
              paramFromServiceMsg.Ad(bool);
              long l = System.currentTimeMillis();
              ykm.a((QQAppInterface)paramIntent).gl(l);
              return;
            }
          }
          catch (Exception paramIntent)
          {
            QLog.e("ZhituServlet", 2, "onReceive CMD_SAFE_GATE has exception: ", paramIntent);
            return;
          }
          boolean bool = false;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ZhituServlet", 2, "onReceive CMD_SAFE_GATE failed result: " + i);
      return;
      i = paramFromServiceMsg.getResultCode();
    } while (!QLog.isColorLevel());
    QLog.d("ZhituServlet", 2, "onReceive CMD_SAFE_GATE not Success code is : " + i);
    return;
    label295:
    if (!paramFromServiceMsg.isSuccess())
    {
      a(paramIntent, 1, paramFromServiceMsg);
      return;
    }
    localObject = paramFromServiceMsg.getWupBuffer();
    if (localObject != null)
    {
      String str = new String(Arrays.copyOfRange((byte[])localObject, 4, localObject.length));
      for (;;)
      {
        try
        {
          if (!TextUtils.isEmpty(str))
          {
            localObject = (ZhituResponse)aqec.convertFromJsonObject(new JSONObject(str), ZhituResponse.class);
            Bundle localBundle = new Bundle();
            localBundle.putInt("ErrorCode", 0);
            localBundle.putParcelable("Response", (Parcelable)localObject);
            localBundle.putString("UniqueKey", paramIntent.getStringExtra("ZhituReqKey"));
            localBundle.putInt("StartIdx", paramIntent.getIntExtra("StartIdx", 0));
            localBundle.putString("QueryText", paramIntent.getStringExtra("QueryText"));
            notifyObserver(paramIntent, 0, true, localBundle, yks.class);
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ZhituServlet", 2, "parse json error with str:\n" + str + "\n" + localJSONException);
          }
          a(paramIntent, 3, paramFromServiceMsg);
          return;
        }
        ZhituResponse localZhituResponse = new ZhituResponse();
      }
    }
    a(paramIntent, 2, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      return;
    }
    String str = paramIntent.getStringExtra("ZhituCMD");
    paramPacket.setSSOCommand(str);
    if (QLog.isColorLevel()) {
      QLog.d("ZhituServlet", 2, "onSend with cmd: " + str);
    }
    paramIntent = paramIntent.getByteArrayExtra("ZhituRequestBytes");
    if (paramIntent != null)
    {
      paramPacket.putSendData(r(paramIntent));
      return;
    }
    throw new IllegalArgumentException("no bytes to send");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ykz
 * JD-Core Version:    0.7.0.1
 */