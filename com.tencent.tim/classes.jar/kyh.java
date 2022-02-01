import android.content.Intent;
import android.os.Bundle;
import com.tencent.aladdin.config.network.AladdinRequestHandler;
import com.tencent.aladdin.config.network.AladdinResponseHandler;
import com.tencent.biz.pubaccount.readinjoy.config.AladdinListener;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class kyh
  extends AladdinRequestHandler
{
  private static void at(Bundle paramBundle)
  {
    HashMap localHashMap = new HashMap();
    int i = paramBundle.getInt("key_ret_code", 0);
    localHashMap.put("param_OpCode", String.valueOf(paramBundle.getInt("key_rsp_type", 0)));
    localHashMap.put("param_FailCode", String.valueOf(i));
    long l1 = paramBundle.getLong("key_config_count");
    long l2 = paramBundle.getLong("key_failed_count");
    localHashMap.put("param_ConfigCount", String.valueOf(l1));
    localHashMap.put("param_FailCount", String.valueOf(l2));
    l1 = paramBundle.getLong("key_response_timestamp", 0L) - paramBundle.getLong("key_request_timestamp", 0L);
    localHashMap.put("param_CostTime", String.valueOf(l1));
    paramBundle = anpc.a(kxm.getAppRuntime().getApplication());
    String str = kxm.getAccount();
    if (i == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle.collectPerformance(str, "actKanDianAladdinResult", bool, l1, 0L, localHashMap, null, false);
      return;
    }
  }
  
  private static byte[] n(byte[] paramArrayOfByte)
  {
    long l = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[(int)l + 4];
    aqoj.DWord2Byte(arrayOfByte, 0, 4L + l);
    aqoj.b(arrayOfByte, 4, paramArrayOfByte, (int)l);
    return arrayOfByte;
  }
  
  public static byte[] o(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length - 4;
    byte[] arrayOfByte = new byte[i];
    aqoj.copyData(arrayOfByte, 0, paramArrayOfByte, 4, i);
    return arrayOfByte;
  }
  
  public void onSend(byte[] paramArrayOfByte, Bundle paramBundle, AladdinResponseHandler paramAladdinResponseHandler)
  {
    AppRuntime localAppRuntime = kxm.getAppRuntime();
    NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), kyh.a.class);
    localNewIntent.putExtra("key_body_bytes", paramArrayOfByte);
    localNewIntent.putExtra("key_extra_info", paramBundle);
    localNewIntent.putExtra("key_response_handler", paramAladdinResponseHandler);
    localNewIntent.putParcelableArrayListExtra("key_aladdin_listeners", kyd.kq);
    localAppRuntime.startServlet(localNewIntent);
  }
  
  public static class a
    extends MSFServlet
  {
    public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
    {
      QLog.i("QQAladdinRequestHandler", 1, "[onReceive] cmd=" + paramFromServiceMsg.getServiceCmd() + " appSeq=" + paramFromServiceMsg.getAppSeq() + " success=" + paramFromServiceMsg.isSuccess() + " resultCode=" + paramFromServiceMsg.getResultCode());
      if (!paramFromServiceMsg.isSuccess()) {
        return;
      }
      AladdinResponseHandler localAladdinResponseHandler = (AladdinResponseHandler)paramIntent.getParcelableExtra("key_response_handler");
      for (;;)
      {
        try
        {
          Object localObject = kyh.o(paramFromServiceMsg.getWupBuffer());
          int i = paramFromServiceMsg.getResultCode();
          QLog.i("QQAladdinRequestHandler", 1, "[onReceive] msfRetCode = " + i);
          if (i != 1000) {
            break;
          }
          if (localObject != null)
          {
            paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])localObject);
            i = paramFromServiceMsg.uint32_result.get();
            QLog.i("QQAladdinRequestHandler", 1, "[onReceive] oidbResult = " + i);
            if ((paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null))
            {
              paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
              QLog.i("QQAladdinRequestHandler", 1, "[onReceive] bytes length = " + paramFromServiceMsg.length);
              if ((i != 0) || (paramFromServiceMsg.length <= 0)) {
                break;
              }
              localObject = (Bundle)paramIntent.getParcelableExtra("key_extra_info");
              localAladdinResponseHandler.onReceive(paramFromServiceMsg, (Bundle)localObject);
              kyh.au((Bundle)localObject);
              paramIntent = paramIntent.getParcelableArrayListExtra("key_aladdin_listeners");
              if ((paramIntent == null) || (paramIntent.size() <= 0)) {
                break;
              }
              i = 0;
              if (i >= paramIntent.size()) {
                break;
              }
              ((AladdinListener)paramIntent.get(i)).aIe();
              i += 1;
              continue;
            }
            QLog.e("QQAladdinRequestHandler", 1, "[onReceive] oidb bytes_bodybuffer is empty");
            continue;
          }
          QLog.e("QQAladdinRequestHandler", 1, "[onReceive] msf data is empty");
        }
        catch (Exception paramIntent)
        {
          QLog.e("QQAladdinRequestHandler", 1, "[onReceive] ", paramIntent);
          return;
        }
      }
    }
    
    public void onSend(Intent paramIntent, Packet paramPacket)
    {
      paramIntent = paramIntent.getByteArrayExtra("key_body_bytes");
      if (paramIntent != null)
      {
        paramIntent = lup.makeOIDBPkg("OidbSvc.0xbf8", 3064, 0, paramIntent);
        paramPacket.setSSOCommand(paramIntent.getServiceCmd());
        paramPacket.putSendData(kyh.p(paramIntent.getWupBuffer()));
        paramPacket.setAttributes(paramIntent.getAttributes());
        return;
      }
      QLog.e("QQAladdinRequestHandler", 1, "[onSend] bytes are null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     kyh
 * JD-Core Version:    0.7.0.1
 */