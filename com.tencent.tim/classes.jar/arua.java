import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.jce.ReqHead;
import com.tencent.tmassistant.common.jce.Request;
import com.tencent.tmassistant.common.jce.SdkInfo;
import com.tencent.tmassistant.common.jce.Ticket;
import com.tencent.tmassistant.common.jce.TicketWtLogin;
import com.tencent.tmassistantbase.network.PostHttpRequest;

public abstract class arua
  extends PostHttpRequest
{
  public int b(JceStruct paramJceStruct)
  {
    try
    {
      paramJceStruct = ProtocolPackage.buildRequest(paramJceStruct);
      if (paramJceStruct == null) {
        return -1;
      }
    }
    catch (Throwable paramJceStruct)
    {
      for (;;)
      {
        paramJceStruct = null;
      }
      Object localObject = new SdkInfo();
      ((SdkInfo)localObject).versionCode = 1;
      ((SdkInfo)localObject).versionName = aroi.a().getAppVersionName();
      ((SdkInfo)localObject).name = "AppNews";
      ((SdkInfo)localObject).channel = "";
      ((SdkInfo)localObject).builderNum = "";
      paramJceStruct.head.sdkInfo = ((SdkInfo)localObject);
      localObject = new TicketWtLogin();
      ((TicketWtLogin)localObject).uin = aroi.a().getUin();
      ((TicketWtLogin)localObject).A2 = aroi.a().getA2().getBytes();
      Ticket localTicket = new Ticket();
      localTicket.value = ProtocolPackage.jceStructToUTF8Byte((JceStruct)localObject);
      localTicket.type = 1;
      paramJceStruct.head.ticket = localTicket;
      int i = paramJceStruct.head.requestId;
      sendRequest(ProtocolPackage.buildPostData(paramJceStruct));
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arua
 * JD-Core Version:    0.7.0.1
 */