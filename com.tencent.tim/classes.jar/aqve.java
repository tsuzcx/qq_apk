import QC.LoginInfo;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.manager.TicketManager;

public class aqve
{
  private String cxY;
  private String cxZ = "req";
  private String cya = "rsp";
  private String mCmd;
  private HashMap<String, JceStruct> pp = new HashMap();
  
  public aqve(String paramString1, String paramString2)
  {
    this.mCmd = paramString2;
    this.cxY = paramString1;
    if (!acct.ad().containsKey(paramString2)) {
      acct.b(paramString2, new int[] { 13 });
    }
  }
  
  public aqve(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mCmd = paramString2;
    this.cxY = paramString1;
    if (!acct.ad().containsKey(paramString2)) {
      acct.b(paramString2, new int[] { 13 });
    }
    this.cxZ = paramString3;
    this.cya = paramString4;
  }
  
  public static LoginInfo a()
  {
    try
    {
      Object localObject = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localObject == null) {
        return null;
      }
      String str = ((AppInterface)localObject).getCurrentAccountUin();
      localObject = ((TicketManager)((AppInterface)localObject).getManager(2)).getSkey(str);
      LoginInfo localLoginInfo = new LoginInfo();
      localLoginInfo.lUin = Long.parseLong(str);
      localLoginInfo.iKeyType = 1;
      localLoginInfo.sSKey = ((String)localObject);
      localLoginInfo.iOpplat = 2;
      localLoginInfo.sClientVer = aqgz.getQQVersion();
      return localLoginInfo;
    }
    catch (Exception localException)
    {
      QLog.e("JceProtocol", 1, localException, new Object[0]);
    }
    return null;
  }
  
  public static String d(ToServiceMsg paramToServiceMsg)
  {
    return paramToServiceMsg.getServiceCmd() + "_" + paramToServiceMsg.extraData.get(accb.SEQ_KEY);
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = d(paramToServiceMsg);
    anac.Qe(paramToServiceMsg);
    if (this.pp.containsKey(paramToServiceMsg))
    {
      paramFromServiceMsg = (JceStruct)this.pp.get(paramToServiceMsg);
      this.pp.remove(paramToServiceMsg);
      return paramUniPacket.getByClass(this.cya, paramFromServiceMsg);
    }
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket, int paramInt)
  {
    paramUniPacket.setServantName(this.cxY);
    paramUniPacket.setFuncName(paramToServiceMsg.extraData.getString("funcName"));
    paramUniPacket.setRequestId(paramInt);
    paramUniPacket.put(this.cxZ, paramToServiceMsg.extraData.get("req"));
  }
  
  public void a(String paramString, JceStruct paramJceStruct1, JceStruct paramJceStruct2, acci paramacci, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    paramacci = ((acle)localQQAppInterface.getBusinessHandler(13)).createToServiceMsg(this.mCmd, paramacci, paramBoolean);
    String str = d(paramacci);
    this.pp.put(str, paramJceStruct2);
    anac.a(this, str);
    paramacci.extraData.putSerializable("req", paramJceStruct1);
    paramacci.extraData.putString("funcName", paramString);
    localQQAppInterface.sendToService(paramacci);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqve
 * JD-Core Version:    0.7.0.1
 */