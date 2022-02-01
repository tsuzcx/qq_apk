import android.text.TextUtils;
import com.tencent.ark.ArkAppPanelReport.ReqBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.Proto.EchoRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.Map;

public class adqx
  extends accg
{
  private static final int[] kD = { 95 };
  
  public adqx(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    try
    {
      paramToServiceMsg = new String((byte[])paramObject, "UTF-8");
      paramFromServiceMsg = paramToServiceMsg;
      if (paramToServiceMsg == null) {
        paramFromServiceMsg = "";
      }
      return paramFromServiceMsg;
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        ArkAppCenter.r("ArkApp.BusinessHandler", String.format("onReceive_AppMsg, fail convert data to string", new Object[0]));
        paramToServiceMsg = null;
      }
    }
  }
  
  private void a(String paramString, boolean paramBoolean, byte[] paramArrayOfByte, int paramInt1, int paramInt2, acci paramacci)
  {
    paramacci = super.createToServiceMsg(paramString, paramacci);
    paramacci.addAttribute("SendTime", Long.valueOf(System.currentTimeMillis()));
    paramacci.addAttribute("IsGenericCmd", Boolean.valueOf(paramBoolean));
    paramacci.addAttribute("IsPanelRequest", Boolean.valueOf(false));
    paramacci.addAttribute("NotifyType", Integer.valueOf(paramInt2));
    paramacci.putWupBuffer(paramArrayOfByte);
    if (paramInt1 > 0) {
      paramacci.setTimeout(paramInt1);
    }
    if (!acct.ad().containsKey(paramString)) {
      acct.b(paramString, kD);
    }
    super.sendPbReq(paramacci);
  }
  
  private Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      try
      {
        paramToServiceMsg = (Proto.EchoRsp)new Proto.EchoRsp().mergeFrom((byte[])paramObject);
        if (paramToServiceMsg == null) {
          return null;
        }
        if (paramToServiceMsg.msg.has())
        {
          paramToServiceMsg = paramToServiceMsg.msg.get();
          paramFromServiceMsg = paramToServiceMsg;
          if (paramToServiceMsg == null) {
            paramFromServiceMsg = "";
          }
          return paramFromServiceMsg;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        return null;
      }
      paramToServiceMsg = null;
    }
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, acci paramacci)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramacci == null)) {
      return false;
    }
    paramacci = super.createToServiceMsg(paramString, paramacci);
    paramacci.addAttribute("SendTime", Long.valueOf(System.currentTimeMillis()));
    paramacci.addAttribute("IsGenericCmd", Boolean.valueOf(true));
    paramacci.addAttribute("IsPanelRequest", Boolean.valueOf(true));
    paramacci.addAttribute("NotifyType", Integer.valueOf(paramInt2));
    if (paramInt1 > 0) {
      paramacci.setTimeout(paramInt1);
    }
    if (!acct.ad().containsKey(paramString)) {
      acct.b(paramString, kD);
    }
    super.sendPbReq(paramacci);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2, acci paramacci)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramacci == null)) {
      return false;
    }
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    try
    {
      paramString2 = str.getBytes("UTF-8");
      a(paramString1, true, paramString2, paramInt1, paramInt2, paramacci);
      return true;
    }
    catch (Exception paramString2)
    {
      ArkAppCenter.r("ArkApp.BusinessHandler", String.format("sendAppMsg, fail convert content to bytes array, cmd=%s, content=%s", new Object[] { paramString1, str }));
    }
    return false;
  }
  
  public boolean lg(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    ArkAppPanelReport.ReqBody localReqBody = new ArkAppPanelReport.ReqBody();
    localReqBody.bytes_app_name.set(ByteStringMicro.copyFromUtf8(paramString));
    ArkAppCenter.o("ArkApp.BusinessHandler", String.format("reportArkAppPanelIconClick appName=%s", new Object[] { paramString }));
    paramString = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "ArkAppPanel.Report");
    paramString.putWupBuffer(localReqBody.toByteArray());
    paramString.setNeedCallback(false);
    sendPbReq(paramString);
    return true;
  }
  
  protected Class<? extends acci> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = paramFromServiceMsg.isSuccess();
    long l1 = ((Long)paramToServiceMsg.getAttribute("SendTime")).longValue();
    long l2 = System.currentTimeMillis();
    boolean bool2 = ((Boolean)paramToServiceMsg.getAttribute("IsGenericCmd")).booleanValue();
    boolean bool3 = ((Boolean)paramToServiceMsg.getAttribute("IsPanelRequest")).booleanValue();
    int i = ((Integer)paramToServiceMsg.getAttribute("NotifyType")).intValue();
    String str = paramFromServiceMsg.getServiceCmd();
    ArkAppCenter.r("ArkApp.BusinessHandler", String.format("onReceive, cmd=%s, app-msg=%s, panelRequest=%s, suc=%s, delay=%d, ", new Object[] { str, Boolean.toString(bool2), Boolean.toString(bool3), Boolean.toString(bool1), Long.valueOf(l2 - l1) }));
    if (bool1) {
      if (bool2) {
        if (!bool3) {}
      }
    }
    for (;;)
    {
      if (paramObject != null)
      {
        super.notifyUI(paramToServiceMsg, i, true, paramObject);
        return;
        paramObject = a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        continue;
        if (str.equalsIgnoreCase("ArkAppSvc.Echo")) {
          paramObject = b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        }
      }
      else
      {
        super.notifyUI(paramToServiceMsg, i, false, null);
        return;
      }
      paramObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adqx
 * JD-Core Version:    0.7.0.1
 */