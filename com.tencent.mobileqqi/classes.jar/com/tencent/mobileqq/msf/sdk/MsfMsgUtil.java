package com.tencent.mobileqq.msf.sdk;

import android.os.SystemClock;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import oicq.wlogin_sdk.request.WFastLoginInfo;

public class MsfMsgUtil
{
  public static ToServiceMsg getAppDataIncermentMsg(String paramString1, String paramString2, String[] paramArrayOfString, long paramLong)
  {
    paramString1 = new ToServiceMsg(paramString1, paramString2, "App_DataIncerment");
    paramString1.setMsfCommand(MsfCommand.appDataIncerment);
    paramString1.getAttributes().put("to_dataIncerment_app", new Object[] { paramArrayOfString, Long.valueOf(paramLong) });
    paramString1.setNeedCallback(false);
    return paramString1;
  }
  
  public static ToServiceMsg getConnOpenMsg(String paramString)
  {
    paramString = new ToServiceMsg(paramString, "0", "cmd_openConn");
    paramString.setMsfCommand(MsfCommand.openConn);
    paramString.setNeedCallback(false);
    paramString.setTimeout(30000L);
    return paramString;
  }
  
  public static ToServiceMsg getCurrentDataCountMsg(String paramString, String[] paramArrayOfString)
  {
    paramString = new ToServiceMsg(paramString, "0", "App_GetDataCount");
    paramString.addAttribute(paramString.getServiceCmd(), paramArrayOfString);
    paramString.setMsfCommand(MsfCommand.getAppDataCount);
    return paramString;
  }
  
  public static ToServiceMsg getGatewayIpMsg(String paramString)
  {
    paramString = new ToServiceMsg(paramString, "0", "cmd_getGatewayIp");
    paramString.setMsfCommand(MsfCommand.getGatewayIp);
    paramString.setNeedCallback(false);
    paramString.setTimeout(30000L);
    return paramString;
  }
  
  public static ToServiceMsg getNetworkTrafficDebugInfo(String paramString)
  {
    paramString = new ToServiceMsg(paramString, "0", "App_NerworkTrafficDebugInfo");
    paramString.setMsfCommand(MsfCommand.getMsfDebugInfo);
    return paramString;
  }
  
  public static ToServiceMsg getRdmReportMsg(String paramString, RdmReq paramRdmReq)
  {
    if (paramRdmReq.params != null) {
      paramRdmReq.params.put("param_reportTime", String.valueOf(SystemClock.elapsedRealtime()));
    }
    paramString = new ToServiceMsg(paramString, "0", "App_reportRDM");
    paramString.setMsfCommand(MsfCommand.reportRdm);
    JceOutputStream localJceOutputStream = new JceOutputStream();
    paramRdmReq.writeTo(localJceOutputStream);
    paramString.addAttribute(paramString.getServiceCmd(), localJceOutputStream.toByteArray());
    paramString.setNeedCallback(false);
    return paramString;
  }
  
  public static ToServiceMsg getReportLogMsg(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = new ToServiceMsg(paramString1, "0", "App_ReportLog");
    paramString1.setMsfCommand(MsfCommand.appReportLog);
    paramString1.getAttributes().put(paramString1.getServiceCmd(), new String[] { paramString2, paramString3, paramString4 });
    paramString1.setNeedCallback(false);
    return paramString1;
  }
  
  public static ToServiceMsg getSetConnStatusMsg(String paramString, int paramInt)
  {
    paramString = new ToServiceMsg(paramString, "0", "cmd_getSetMsfConnStatus");
    paramString.setMsfCommand(MsfCommand.setMsfConnStatus);
    paramString.setNeedCallback(true);
    paramString.getAttributes().put("status", Integer.valueOf(paramInt));
    paramString.setTimeout(30000L);
    return paramString;
  }
  
  public static ToServiceMsg get_wt_AskDevLockSms(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = new ToServiceMsg(paramString1, paramString2, "cmd_appUseWtLogin");
    paramString1.setMsfCommand(MsfCommand.wt_AskDevLockSms);
    paramString1.setTimeout(paramLong);
    return paramString1;
  }
  
  public static ToServiceMsg get_wt_CheckDevLockSms(String paramString1, String paramString2, long paramLong1, String paramString3, byte[] paramArrayOfByte, long paramLong2)
  {
    paramString1 = new ToServiceMsg(paramString1, paramString2, "cmd_appUseWtLogin");
    paramString1.setMsfCommand(MsfCommand.wt_CheckDevLockSms);
    paramString1.getAttributes().put("subAppid", Long.valueOf(paramLong1));
    paramString1.getAttributes().put("smdCode", paramString3);
    paramString1.getAttributes().put("sppKey", paramArrayOfByte);
    paramString1.setTimeout(paramLong2);
    return paramString1;
  }
  
  public static ToServiceMsg get_wt_CheckDevLockStatus(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    paramString1 = new ToServiceMsg(paramString1, paramString2, "cmd_appUseWtLogin");
    paramString1.setMsfCommand(MsfCommand.wt_CheckDevLockStatus);
    paramString1.getAttributes().put("subAppid", Long.valueOf(paramLong1));
    paramString1.setTimeout(paramLong2);
    return paramString1;
  }
  
  public static ToServiceMsg get_wt_CheckPictureAndGetSt(String paramString1, String paramString2, byte[] paramArrayOfByte, long paramLong)
  {
    paramString1 = new ToServiceMsg(paramString1, paramString2, "cmd_appUseWtLogin");
    paramString1.setMsfCommand(MsfCommand.wt_CheckPictureAndGetSt);
    paramString1.getAttributes().put("userInput", paramArrayOfByte);
    paramString1.setTimeout(paramLong);
    return paramString1;
  }
  
  public static ToServiceMsg get_wt_CheckSMSAndGetSt(String paramString1, String paramString2, byte[] paramArrayOfByte, long paramLong)
  {
    paramString1 = new ToServiceMsg(paramString1, paramString2, "cmd_appUseWtLogin");
    paramString1.setMsfCommand(MsfCommand.wt_CheckSMSAndGetSt);
    paramString1.getAttributes().put("userInput", paramArrayOfByte);
    paramString1.setTimeout(paramLong);
    return paramString1;
  }
  
  public static ToServiceMsg get_wt_CheckSMSAndGetStExt(String paramString1, String paramString2, byte[] paramArrayOfByte, long paramLong)
  {
    paramString1 = new ToServiceMsg(paramString1, paramString2, "cmd_appUseWtLogin");
    paramString1.setMsfCommand(MsfCommand.wt_CheckSMSAndGetStExt);
    paramString1.getAttributes().put("userInput", paramArrayOfByte);
    paramString1.setTimeout(paramLong);
    return paramString1;
  }
  
  public static ToServiceMsg get_wt_CheckSMSVerifyLoginAccount(String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    paramString1 = new ToServiceMsg(paramString1, "0", "cmd_appUseWtLogin");
    paramString1.setMsfCommand(MsfCommand.wt_CheckSMSVerifyLoginAccount);
    paramString1.getAttributes().put("countryCode", paramString3);
    paramString1.getAttributes().put("userAccount", paramString2);
    paramString1.getAttributes().put("appid", Integer.valueOf(paramInt));
    paramString1.setTimeout(paramLong);
    return paramString1;
  }
  
  public static ToServiceMsg get_wt_CloseCode(String paramString1, String paramString2, long paramLong1, byte[] paramArrayOfByte, int paramInt, ArrayList paramArrayList, long paramLong2)
  {
    paramString1 = new ToServiceMsg(paramString1, paramString2, "cmd_appUseWtLogin");
    paramString1.setMsfCommand(MsfCommand.wt_CloseCode);
    paramString1.getAttributes().put("appid", Long.valueOf(paramLong1));
    paramString1.getAttributes().put("code", paramArrayOfByte);
    paramString1.getAttributes().put("version", Integer.valueOf(paramInt));
    paramString1.getAttributes().put("data", paramArrayList);
    paramString1.setTimeout(paramLong2);
    return paramString1;
  }
  
  public static ToServiceMsg get_wt_CloseDevLock(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    paramString1 = new ToServiceMsg(paramString1, paramString2, "cmd_appUseWtLogin");
    paramString1.setMsfCommand(MsfCommand.wt_CloseDevLock);
    paramString1.getAttributes().put("subAppid", Long.valueOf(paramLong1));
    paramString1.setTimeout(paramLong2);
    return paramString1;
  }
  
  public static ToServiceMsg get_wt_GetA1WithA1(String paramString1, String paramString2, long paramLong1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WFastLoginInfo paramWFastLoginInfo, long paramLong6)
  {
    paramString1 = new ToServiceMsg(paramString1, paramString2, "cmd_appUseWtLogin");
    paramString1.setMsfCommand(MsfCommand.wt_GetA1WithA1);
    paramString1.getAttributes().put("dwSrcAppid", Long.valueOf(paramLong1));
    paramString1.getAttributes().put("dwSubSrcAppid", Long.valueOf(paramLong2));
    paramString1.getAttributes().put("dstAppName", paramArrayOfByte1);
    paramString1.getAttributes().put("dwDstSsoVer", Long.valueOf(paramLong3));
    paramString1.getAttributes().put("dwDstAppid", Long.valueOf(paramLong4));
    paramString1.getAttributes().put("dwSubDstAppid", Long.valueOf(paramLong5));
    paramString1.getAttributes().put("dstAppVer", paramArrayOfByte2);
    paramString1.getAttributes().put("dstAppSign", paramArrayOfByte3);
    paramString1.getAttributes().put("fastLoginInfo", paramWFastLoginInfo);
    paramString1.setTimeout(paramLong6);
    return paramString1;
  }
  
  public static ToServiceMsg get_wt_GetStViaSMSVerifyLogin(String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    paramString1 = new ToServiceMsg(paramString1, "0", "cmd_appUseWtLogin");
    paramString1.setMsfCommand(MsfCommand.wt_GetStViaSMSVerifyLogin);
    paramString1.getAttributes().put("userAccount", paramString3);
    paramString1.getAttributes().put("countryCode", paramString2);
    paramString1.getAttributes().put("appid", Integer.valueOf(paramInt));
    paramString1.setTimeout(paramLong);
    return paramString1;
  }
  
  public static ToServiceMsg get_wt_GetStWithPasswd(String paramString1, String paramString2, long paramLong1, String paramString3, long paramLong2)
  {
    paramString1 = new ToServiceMsg(paramString1, paramString2, "cmd_appUseWtLogin");
    paramString1.setMsfCommand(MsfCommand.wt_GetStWithPasswd);
    paramString1.getAttributes().put("appid", Long.valueOf(paramLong1));
    paramString1.getAttributes().put("passwd", paramString3);
    paramString1.setTimeout(paramLong2);
    return paramString1;
  }
  
  public static ToServiceMsg get_wt_GetStWithoutPasswd(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3)
  {
    paramString1 = new ToServiceMsg(paramString1, paramString2, "cmd_appUseWtLogin");
    paramString1.setMsfCommand(MsfCommand.wt_GetStWithoutPasswd);
    paramString1.getAttributes().put("dwSrcAppid", Long.valueOf(paramLong1));
    paramString1.getAttributes().put("dwDstAppid", Long.valueOf(paramLong2));
    paramString1.setTimeout(paramLong3);
    return paramString1;
  }
  
  public static ToServiceMsg get_wt_GetSubaccountStViaSMSVerifyLogin(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, long paramLong)
  {
    paramString1 = new ToServiceMsg(paramString1, "0", "cmd_appUseWtLogin");
    paramString1.setMsfCommand(MsfCommand.wt_GetStViaSMSVerifyLogin);
    paramString1.getAttributes().put("userAccount", paramString4);
    paramString1.getAttributes().put("countryCode", paramString3);
    paramString1.getAttributes().put("appid", Integer.valueOf(paramInt));
    paramString1.getAttributes().put("from_where", "subaccount");
    paramString1.getAttributes().put("mainaccount", paramString2);
    paramString1.setTimeout(paramLong);
    return paramString1;
  }
  
  public static ToServiceMsg get_wt_RefreshPictureData(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = new ToServiceMsg(paramString1, paramString2, "cmd_appUseWtLogin");
    paramString1.setMsfCommand(MsfCommand.wt_RefreshPictureData);
    paramString1.setTimeout(paramLong);
    return paramString1;
  }
  
  public static ToServiceMsg get_wt_RefreshSMSData(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = new ToServiceMsg(paramString1, paramString2, "cmd_appUseWtLogin");
    paramString1.setMsfCommand(MsfCommand.wt_RefreshSMSData);
    paramString1.setTimeout(paramLong);
    return paramString1;
  }
  
  public static ToServiceMsg get_wt_RefreshSMSVerifyLoginCode(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    paramString1 = new ToServiceMsg(paramString1, "0", "cmd_appUseWtLogin");
    paramString1.setMsfCommand(MsfCommand.wt_RefreshSMSVerifyLoginCode);
    paramString1.getAttributes().put("userAccount", paramString3);
    paramString1.getAttributes().put("countryCode", paramString2);
    paramString1.setTimeout(paramLong);
    return paramString1;
  }
  
  public static ToServiceMsg get_wt_RegGetSMSVerifyLoginAccount(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong)
  {
    paramString = new ToServiceMsg(paramString, "0", "cmd_appUseWtLogin");
    paramString.setMsfCommand(MsfCommand.wt_RegGetSMSVerifyLoginAccount);
    paramString.getAttributes().put("msgchk", paramArrayOfByte1);
    paramString.getAttributes().put("nick", paramArrayOfByte2);
    paramString.setTimeout(paramLong);
    return paramString;
  }
  
  public static ToServiceMsg get_wt_VerifyCode(String paramString1, String paramString2, long paramLong1, boolean paramBoolean, byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt, long paramLong2)
  {
    paramString1 = new ToServiceMsg(paramString1, paramString2, "cmd_appUseWtLogin");
    paramString1.setMsfCommand(MsfCommand.wt_VerifyCode);
    paramString1.getAttributes().put("appid", Long.valueOf(paramLong1));
    paramString1.getAttributes().put("close", Boolean.valueOf(paramBoolean));
    paramString1.getAttributes().put("code", paramArrayOfByte);
    paramString1.getAttributes().put("tlv", paramArrayOfInt);
    paramString1.getAttributes().put("version", Integer.valueOf(paramInt));
    paramString1.setTimeout(paramLong2);
    return paramString1;
  }
  
  public static ToServiceMsg get_wt_VerifySMSVerifyLoginCode(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    paramString1 = new ToServiceMsg(paramString1, "0", "cmd_appUseWtLogin");
    paramString1.setMsfCommand(MsfCommand.wt_VerifySMSVerifyLoginCode);
    paramString1.getAttributes().put("code", paramString4);
    paramString1.getAttributes().put("userAccount", paramString3);
    paramString1.getAttributes().put("countryCode", paramString2);
    paramString1.setTimeout(paramLong);
    return paramString1;
  }
  
  public static ToServiceMsg get_wt_setRegDevLockFlag(String paramString, int paramInt, long paramLong)
  {
    paramString = new ToServiceMsg(paramString, "0", "cmd_appUseWtLogin");
    paramString.setMsfCommand(MsfCommand.wt_setRegDevLockFlag);
    paramString.getAttributes().put("flag", Integer.valueOf(paramInt));
    paramString.setTimeout(paramLong);
    paramString.setNeedCallback(false);
    return paramString;
  }
  
  public static boolean hasResendBy10008(ToServiceMsg paramToServiceMsg)
  {
    boolean bool = false;
    if (paramToServiceMsg.getAttributes().get("_attr_msg_has_resend_by_10008") != null) {
      bool = ((Boolean)paramToServiceMsg.getAttributes().get("_attr_msg_has_resend_by_10008")).booleanValue();
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.MsfMsgUtil
 * JD-Core Version:    0.7.0.1
 */