import NS_SEVEN_PIECE_PUZZLE_ADV_LIMIT.AdvExposureInfo;
import NS_SEVEN_PIECE_PUZZLE_ADV_LIMIT.ExposeAndGetAdvInfoReq;
import NS_SEVEN_PIECE_PUZZLE_ADV_LIMIT.ExposeAndGetAdvInfoRsp;
import NS_SEVEN_PIECE_PUZZLE_ADV_LIMIT.GetAdvInfoReq;
import NS_SEVEN_PIECE_PUZZLE_ADV_LIMIT.GetAdvInfoRsp;
import android.content.Intent;
import android.os.Bundle;
import com.qq.taf.jce.JceStruct;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public final class yyi
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int i;
    int j;
    String str;
    Bundle localBundle;
    int k;
    if (paramFromServiceMsg != null)
    {
      i = paramFromServiceMsg.getResultCode();
      j = paramIntent.getIntExtra("key_operation", -1);
      str = paramIntent.getStringExtra("key_adID");
      localBundle = new Bundle();
      if (i != 1000) {
        break label322;
      }
      k = -10000;
      paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
      if (j != 0) {
        break label278;
      }
      localObject1 = (ExposeAndGetAdvInfoRsp)yyj.a(paramFromServiceMsg, "ExposeAndGetAdvInfo");
      if (localObject1 == null) {
        break label339;
      }
      i = ((ExposeAndGetAdvInfoRsp)localObject1).Code;
      paramFromServiceMsg = ((ExposeAndGetAdvInfoRsp)localObject1).Msg;
      localObject1 = ((ExposeAndGetAdvInfoRsp)localObject1).vecAdvExposureInfo;
    }
    for (;;)
    {
      label98:
      j = k;
      if (i == 0)
      {
        j = k;
        if (localObject1 != null)
        {
          j = k;
          if (((ArrayList)localObject1).size() > 0) {
            j = ((AdvExposureInfo)((ArrayList)localObject1).get(0)).iAuditResult;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QBossC2SCheckerServlet", 2, "onReceive: " + str + ", code: " + j);
      }
      label183:
      localBundle.putString("msg", paramFromServiceMsg);
      localBundle.putInt("code", j);
      localBundle.putString("adid", str);
      if (QLog.isColorLevel()) {
        QLog.d("QBossC2SCheckerServlet", 2, "onReceive code=" + j + " adID=" + str);
      }
      if (j == 0) {}
      for (boolean bool = true;; bool = false)
      {
        notifyObserver(paramIntent, 100, bool, localBundle, yyh.class);
        return;
        i = -1;
        break;
        label278:
        if (1 != j) {
          break label339;
        }
        localObject1 = (GetAdvInfoRsp)yyj.a(paramFromServiceMsg, "GetAdvInfo");
        if (localObject1 == null) {
          break label339;
        }
        i = ((GetAdvInfoRsp)localObject1).Code;
        paramFromServiceMsg = ((GetAdvInfoRsp)localObject1).Msg;
        localObject1 = ((GetAdvInfoRsp)localObject1).vecAdvExposureInfo;
        break label98;
        label322:
        j = -20000;
        paramFromServiceMsg = (FromServiceMsg)localObject1;
        break label183;
      }
      label339:
      i = -10000;
      localObject1 = null;
      paramFromServiceMsg = localObject2;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("key_operation", -1);
    Object localObject3 = paramIntent.getStringExtra("key_uin");
    paramIntent = paramIntent.getStringExtra("key_adID");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("QBossC2SCheckerServlet", 2, "onSend operationType= " + i + " adID=" + paramIntent);
    }
    paramIntent = "";
    Object localObject2 = "";
    Object localObject1 = null;
    if (i == 0)
    {
      paramIntent = "RevenueQboss.ExposeAndGetAdvInfo";
      localObject2 = "ExposeAndGetAdvInfo";
      localObject1 = new ExposeAndGetAdvInfoReq(localArrayList, (String)localObject3);
    }
    for (;;)
    {
      localObject3 = new yyj((String)localObject3, (JceStruct)localObject1, paramIntent, (String)localObject2);
      localObject2 = ((yyj)localObject3).encode();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        QLog.e("QBossC2SCheckerServlet", 1, "onSend request encode result is null.cmd = " + ((yyj)localObject3).uniKey());
        localObject1 = new byte[4];
      }
      paramPacket.setTimeout(30000L);
      paramPacket.setSSOCommand("SQQzoneSvc." + paramIntent);
      paramPacket.putSendData((byte[])localObject1);
      return;
      if (1 == i)
      {
        paramIntent = "RevenueQboss.GetAdvInfo";
        localObject2 = "GetAdvInfo";
        localObject1 = new GetAdvInfoReq(localArrayList, (String)localObject3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yyi
 * JD-Core Version:    0.7.0.1
 */