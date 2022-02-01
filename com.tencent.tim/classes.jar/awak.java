import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareData;
import java.util.ArrayList;
import java.util.Map;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class awak
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      QLog.e("QzoneShare.QzoneShareServlet", 1, "QzoneShareServlet onReceive success.");
      return;
    }
    QLog.e("QzoneShare.QzoneShareServlet", 1, "QzoneShareServlet onReceive fail.");
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramIntent = paramIntent.getExtras();
    Object localObject1 = (QZoneShareData)paramIntent.get("sharedata");
    long l = ((QZoneShareData)localObject1).appid;
    Object localObject2 = ((QZoneShareData)localObject1).appName;
    String str1 = ((QZoneShareData)localObject1).mTitle;
    String str2 = ((QZoneShareData)localObject1).mSummary;
    String str3 = ((QZoneShareData)localObject1).targetUrl;
    String str4 = ((QZoneShareData)localObject1).extString;
    ArrayList localArrayList = ((QZoneShareData)localObject1).ER;
    int i = ((QZoneShareData)localObject1).iUrlInfoFrm;
    Map localMap = ((QZoneShareData)localObject1).xcxMapEx;
    String str5 = paramIntent.getString("reason");
    localObject2 = new awaj((String)localObject2, str3, 2020014, paramIntent.getLong("uin"), str1, str2, str5, localArrayList, l, str4, i, localMap, ((QZoneShareData)localObject1).qc);
    localObject1 = ((awaj)localObject2).encode();
    paramIntent = (Intent)localObject1;
    if (localObject1 == null) {
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(60000L);
    paramPacket.setSSOCommand("SQQzoneSvc." + ((awaj)localObject2).uniKey());
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awak
 * JD-Core Version:    0.7.0.1
 */