import VipRecommend.MQQ.CommPayInfo;
import VipRecommend.MQQ.UserInfo;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class ando
  extends swr
{
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("VipPayLogicServer.getCommPayInfo ".equals(paramToServiceMsg.getServiceCmd()))
    {
      if (paramFromServiceMsg == null) {
        return null;
      }
      paramToServiceMsg = new UniPacket(true);
      try
      {
        paramToServiceMsg.setEncodeName("utf-8");
        paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
        paramToServiceMsg = (CommPayInfo)paramToServiceMsg.getByClass("payInfo", new CommPayInfo());
        return paramToServiceMsg;
      }
      catch (RuntimeException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        return null;
      }
      catch (Exception paramToServiceMsg)
      {
        return null;
      }
    }
    return null;
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MQQ.VipPayLogicServer.VipPayLogicObj");
    paramUniPacket.setFuncName("getCommPayInfo");
    paramUniPacket.put("userInfo", (UserInfo)paramToServiceMsg.extraData.getSerializable("VIPRecommendPayRequest"));
    return true;
  }
  
  public String[] y()
  {
    return new String[] { "VipPayLogicServer" };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ando
 * JD-Core Version:    0.7.0.1
 */