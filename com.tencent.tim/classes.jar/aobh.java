import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.teamwork.DocsGrayTipsInfo;
import com.tencent.mobileqq.teamwork.ReSendCmd;
import com.tencent.mobileqq.teamwork.SharePolicyInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.teamwork.TimDocSSOMsg.GetPadRightInfoReqBody;
import com.tencent.pb.teamwork.TimDocSSOMsg.GetPadRightInfoRspBody;
import com.tencent.pb.teamwork.TimDocSSOMsg.LoginInfo;
import com.tencent.pb.teamwork.TimDocSSOMsg.SetPadRightInfoReqBody;
import com.tencent.pb.teamwork.TimDocSSOMsg.SetPadRightInfoRspBody;
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xbab.cmd0xbab.GroupGetReq;
import tencent.im.oidb.cmd0xbab.cmd0xbab.GroupGetRsp;
import tencent.im.oidb.cmd0xbab.cmd0xbab.GroupSetReq;
import tencent.im.oidb.cmd0xbab.cmd0xbab.GroupSetRsp;
import tencent.im.oidb.cmd0xbab.cmd0xbab.ReqBody;
import tencent.im.oidb.cmd0xbab.cmd0xbab.RspBody;
import tencent.im.oidb.cmd0xbab.cmd0xbab.UserGetReq;
import tencent.im.oidb.cmd0xbab.cmd0xbab.UserGetRsp;
import tencent.im.oidb.cmd0xbab.cmd0xbab.UserSetReq;
import tencent.im.oidb.cmd0xbab.cmd0xbab.UserSetRsp;

public class aobh
  extends accg
{
  private static String cjJ = "key_type_list";
  private static String cjK;
  public boolean aeg;
  private SparseIntArray ag = new SparseIntArray();
  public boolean cLc;
  private volatile int dNV;
  private volatile int dNW;
  
  public aobh(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.cLc = aqmj.c(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), "tencent_docs_config_enable_assistant", false);
    this.aeg = aqmj.c(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), "tencent_docs_config_preload_tool_process", false);
  }
  
  public static void AQ(String paramString)
  {
    paramString = j(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  public static int Z(String paramString1, String paramString2)
  {
    int j = -1;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("global_padid", paramString1);
      paramString1 = aobk.b(localJSONObject, paramString2, "https://docs.qq.com/form/collect/recordcnt", "docs.qq.com");
      i = j;
      if (paramString1 != null)
      {
        paramString1 = new JSONObject(paramString1);
        i = j;
        if (paramString1.optInt("code", -1) == 0) {
          i = paramString1.optInt("total_cnt");
        }
      }
    }
    catch (JSONException paramString1)
    {
      do
      {
        int i = j;
      } while (!QLog.isColorLevel());
      QLog.e("TeamWorkHandler", 2, paramString1, new Object[0]);
    }
    return i;
    return -1;
  }
  
  private String a(ReSendCmd paramReSendCmd)
  {
    TicketManager localTicketManager = (TicketManager)this.mApp.getManager(2);
    if (localTicketManager != null)
    {
      paramReSendCmd = localTicketManager.GetSkey(this.mApp.getCurrentAccountUin(), 16L, new aobj(this, localTicketManager, paramReSendCmd));
      if ((paramReSendCmd != null) && (paramReSendCmd._sig != null))
      {
        paramReSendCmd = new String(paramReSendCmd._sig);
        QLog.i("TeamWorkHandler", 1, "getSkeyFromServerAndRetry get skey with promise success! ");
        return paramReSendCmd;
      }
      QLog.i("TeamWorkHandler", 1, "getSkeyFromServerAndRetry get skey from server now! ");
    }
    for (;;)
    {
      return null;
      QLog.e("TeamWorkHandler", 1, "getSkeyFromServerAndRetry,ticketmanager is null");
    }
  }
  
  private String a(ReSendCmd paramReSendCmd, boolean paramBoolean)
  {
    Object localObject = (TicketManager)this.mApp.getManager(2);
    if (localObject != null)
    {
      String str = this.app.getCurrentAccountUin();
      aobi localaobi = new aobi(this, (TicketManager)localObject, paramReSendCmd);
      localObject = ((TicketManager)localObject).GetPskey(str, 16L, new String[] { "docs.qq.com" }, localaobi);
      if ((localObject != null) && (((Ticket)localObject)._pskey_map != null) && (((Ticket)localObject)._pskey_map.get("docs.qq.com") != null))
      {
        QLog.i("TeamWorkHandler", 1, "getPskeyFromServerAndRetry get pskey with promise success! isImediately Resend: " + paramBoolean);
        localObject = new String((byte[])((Ticket)localObject)._pskey_map.get("docs.qq.com"));
        if (paramBoolean)
        {
          a(paramReSendCmd);
          return localObject;
        }
      }
      else
      {
        QLog.i("TeamWorkHandler", 1, "getPskeyFromServerAndRetry get pskey from server now!");
      }
    }
    else
    {
      for (;;)
      {
        return null;
        QLog.e("TeamWorkHandler", 1, "getPskeyFromServerAndRetry,ticketmanager is null");
      }
    }
    return localObject;
  }
  
  public static String a(String paramString, SharePolicyInfo paramSharePolicyInfo)
  {
    int j = 1;
    localObject2 = null;
    try
    {
      i = paramSharePolicyInfo.policy;
      if (i != 0) {
        break label457;
      }
      i = 1;
    }
    catch (JSONException paramSharePolicyInfo)
    {
      for (;;)
      {
        int i;
        JSONObject localJSONObject;
        Object localObject1;
        paramString = localObject2;
        if (QLog.isColorLevel()) {
          QLog.e("TeamWorkHandler", 2, paramSharePolicyInfo, new Object[0]);
        }
        continue;
        paramString = null;
      }
    }
    localJSONObject = new JSONObject();
    localJSONObject.put("url", URLEncoder.encode(paramSharePolicyInfo.share_url));
    if (paramSharePolicyInfo.title != null) {
      localJSONObject.put("title", URLEncoder.encode(paramSharePolicyInfo.title));
    }
    localJSONObject.put("type", 0);
    if (paramSharePolicyInfo.folderId == null)
    {
      localObject1 = "0";
      localJSONObject.put("folderId", localObject1);
      localObject1 = new StringBuilder("https://docs.qq.com/cgi-bin/online_docs/wxqrcode").append('?').append("domainId=").append(paramSharePolicyInfo.cjj).append("&padId=").append(paramSharePolicyInfo.padId).append("&dataType=");
      if (paramSharePolicyInfo.docType != 3) {
        break label386;
      }
    }
    for (;;)
    {
      localObject1 = aobk.m(paramString, j + "&page=" + "pages/shareFriend/shareFriend" + "&ac=" + "share" + "&t=" + "0" + "&policy=" + String.valueOf(i) + "&right_flag=" + "1" + "&param=" + localJSONObject.toString() + "&type=" + "1", "docs.qq.com");
      if (localObject1 == null) {
        break label452;
      }
      paramSharePolicyInfo = new JSONObject((String)localObject1);
      paramString = paramSharePolicyInfo;
      for (;;)
      {
        try
        {
          if (paramSharePolicyInfo.optInt("retcode", -1) != 0)
          {
            paramSharePolicyInfo.put("retcode", -1);
            paramString = paramSharePolicyInfo;
            if (QLog.isColorLevel())
            {
              QLog.e("TeamWorkHandler", 2, "failed result" + (String)localObject1);
              paramString = paramSharePolicyInfo;
            }
          }
          paramSharePolicyInfo = paramString;
          if (paramString == null) {
            paramString = new JSONObject();
          }
        }
        catch (JSONException localJSONException2)
        {
          label386:
          paramString = paramSharePolicyInfo;
          paramSharePolicyInfo = localJSONException2;
          continue;
        }
        try
        {
          paramString.put("retcode", -1);
          paramSharePolicyInfo = paramString;
        }
        catch (JSONException localJSONException1)
        {
          paramSharePolicyInfo = paramString;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("TeamWorkHandler", 2, localJSONException1, new Object[0]);
          paramSharePolicyInfo = paramString;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("TeamWorkHandler", 2, paramSharePolicyInfo.toString());
      }
      return (String)paramSharePolicyInfo.opt("key");
      localObject1 = paramSharePolicyInfo.folderId;
      break;
      j = 0;
    }
  }
  
  private static JSONObject a(String paramString, int paramInt, boolean paramBoolean)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("uintype", paramInt);
    localJSONObject.put("uin", paramString);
    if (paramBoolean) {}
    for (paramInt = 2;; paramInt = 1)
    {
      localJSONObject.put("info", paramInt);
      localJSONObject.put("new", 1);
      return localJSONObject;
    }
  }
  
  /* Error */
  public static JSONObject a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aload 5
    //   8: new 198	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 332
    //   18: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc_w 334
    //   28: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_1
    //   32: ldc_w 336
    //   35: invokestatic 339	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   38: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc_w 341
    //   44: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: iload_2
    //   48: invokevirtual 275	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   51: ldc_w 343
    //   54: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_3
    //   58: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc_w 345
    //   64: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload 4
    //   69: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: ldc 87
    //   77: invokestatic 304	aobk:m	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   80: astore_3
    //   81: aload_3
    //   82: ifnull +187 -> 269
    //   85: new 76	org/json/JSONObject
    //   88: dup
    //   89: aload_3
    //   90: invokespecial 95	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   93: astore_1
    //   94: aload_1
    //   95: astore_0
    //   96: aload_1
    //   97: ldc_w 306
    //   100: iconst_m1
    //   101: invokevirtual 101	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   104: ifeq +49 -> 153
    //   107: aload_1
    //   108: ldc_w 306
    //   111: iconst_m1
    //   112: invokevirtual 245	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   115: pop
    //   116: aload_1
    //   117: astore_0
    //   118: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   121: ifeq +32 -> 153
    //   124: ldc_w 347
    //   127: iconst_2
    //   128: new 198	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   135: ldc_w 308
    //   138: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_3
    //   142: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 173	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: aload_1
    //   152: astore_0
    //   153: aload_0
    //   154: astore_1
    //   155: aload_0
    //   156: ifnonnull +20 -> 176
    //   159: new 76	org/json/JSONObject
    //   162: dup
    //   163: invokespecial 77	org/json/JSONObject:<init>	()V
    //   166: astore_1
    //   167: aload_1
    //   168: ldc_w 306
    //   171: iconst_m1
    //   172: invokevirtual 245	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   175: pop
    //   176: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   179: ifeq +14 -> 193
    //   182: ldc_w 347
    //   185: iconst_2
    //   186: aload_1
    //   187: invokevirtual 298	org/json/JSONObject:toString	()Ljava/lang/String;
    //   190: invokestatic 311	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: aload_1
    //   194: areturn
    //   195: astore_1
    //   196: aload 6
    //   198: astore_0
    //   199: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +15 -> 217
    //   205: ldc_w 347
    //   208: iconst_2
    //   209: aload_1
    //   210: iconst_0
    //   211: anewarray 115	java/lang/Object
    //   214: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   217: goto -64 -> 153
    //   220: astore_1
    //   221: aload 7
    //   223: astore_0
    //   224: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   227: ifeq +15 -> 242
    //   230: ldc_w 347
    //   233: iconst_2
    //   234: aload_1
    //   235: iconst_0
    //   236: anewarray 115	java/lang/Object
    //   239: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   242: goto -89 -> 153
    //   245: astore_0
    //   246: aload_0
    //   247: invokevirtual 350	org/json/JSONException:printStackTrace	()V
    //   250: goto -74 -> 176
    //   253: astore_3
    //   254: aload_1
    //   255: astore_0
    //   256: aload_3
    //   257: astore_1
    //   258: goto -34 -> 224
    //   261: astore_3
    //   262: aload_1
    //   263: astore_0
    //   264: aload_3
    //   265: astore_1
    //   266: goto -67 -> 199
    //   269: aconst_null
    //   270: astore_0
    //   271: goto -118 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	paramString1	String
    //   0	274	1	paramString2	String
    //   0	274	2	paramInt	int
    //   0	274	3	paramString3	String
    //   0	274	4	paramString4	String
    //   0	274	5	paramString5	String
    //   4	193	6	localObject1	Object
    //   1	221	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   6	81	195	org/json/JSONException
    //   85	94	195	org/json/JSONException
    //   6	81	220	java/io/UnsupportedEncodingException
    //   85	94	220	java/io/UnsupportedEncodingException
    //   167	176	245	org/json/JSONException
    //   96	116	253	java/io/UnsupportedEncodingException
    //   118	151	253	java/io/UnsupportedEncodingException
    //   96	116	261	org/json/JSONException
    //   118	151	261	org/json/JSONException
  }
  
  public static JSONObject a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    try
    {
      paramString2 = aobk.a(paramJSONObject, paramString1, "https://docs.qq.com/cgi-go/imp/import_form_file", paramString2);
      if (paramString2 != null)
      {
        paramJSONObject = new JSONObject(paramString2);
        paramString1 = paramJSONObject;
      }
      label77:
      return null;
    }
    catch (JSONException paramString2)
    {
      do
      {
        try
        {
          if (paramJSONObject.optInt("retcode", -1) != 0)
          {
            paramString1 = paramJSONObject;
            if (QLog.isColorLevel())
            {
              QLog.e("TeamWorkHandler", 2, "checkFormCache failed result" + paramString2);
              paramString1 = paramJSONObject;
            }
          }
          return paramString1;
        }
        catch (JSONException paramString2)
        {
          break label77;
        }
        paramString2 = paramString2;
        paramJSONObject = null;
        paramString1 = paramJSONObject;
      } while (!QLog.isColorLevel());
      QLog.e("TeamWorkHandler", 2, paramString2, new Object[0]);
      return paramJSONObject;
    }
  }
  
  private void a(ReSendCmd paramReSendCmd)
  {
    if (paramReSendCmd != null)
    {
      QLog.i("TeamWorkHandler", 1, " reTrySendCmd retry cmd：" + paramReSendCmd.cmd);
      if (paramReSendCmd.cmd == 9) {
        dL(paramReSendCmd.dNH, paramReSendCmd.cjb);
      }
    }
  }
  
  private boolean a(ReSendCmd paramReSendCmd)
  {
    if (paramReSendCmd != null)
    {
      int i = this.ag.get(paramReSendCmd.cmd, 0);
      QLog.i("TeamWorkHandler", 1, " handleResponseTry retry cmd：" + paramReSendCmd.cmd + ", retryCount: " + i);
      if ((paramReSendCmd != null) && (i < 3))
      {
        this.ag.put(paramReSendCmd.cmd, i + 1);
        String str = a(paramReSendCmd, true);
        if ((!TextUtils.isEmpty(str)) && (str.length() > 0)) {
          QLog.i("TeamWorkHandler", 1, " handleResponseTry retry to get pskey from SDK success,cmd: " + paramReSendCmd.cmd);
        }
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(String paramString, SharePolicyInfo paramSharePolicyInfo)
  {
    Object localObject = UUID.randomUUID().toString().replaceAll("-", "");
    paramSharePolicyInfo = new StringBuilder("https://docs.qq.com/cgi-bin/api/wechatshare/shareTips").append('?').append("domainId=").append(paramSharePolicyInfo.cjj).append("&padId=").append(paramSharePolicyInfo.padId).append("&xsrf=").append((String)localObject);
    localObject = new StringBuilder().append("TOK=").append((String)localObject);
    try
    {
      paramString = aobk.i(paramString, paramSharePolicyInfo.toString(), "docs.qq.com", ((StringBuilder)localObject).toString());
      if (paramString != null)
      {
        if (new JSONObject(paramString).optInt("retcode", -1) == 0) {
          break label157;
        }
        if (QLog.isColorLevel()) {
          QLog.e("TeamWorkHandler", 2, "wechatShareTips failed result" + paramString);
        }
      }
    }
    catch (JSONException paramString)
    {
      label157:
      while (!QLog.isColorLevel()) {}
      QLog.e("TeamWorkHandler", 2, paramString, new Object[0]);
    }
    return false;
    return true;
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, int paramInt, List<String> paramList1, List<String> paramList2, List<String> paramList3)
  {
    if (TextUtils.isEmpty(paramString3)) {
      return false;
    }
    JSONObject localJSONObject;
    JSONArray localJSONArray;
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("policy", paramInt);
      if (((paramList1 == null) || (paramList1.isEmpty())) && ((paramList2 == null) || (paramList2.isEmpty())) && ((paramList3 == null) || (paramList3.isEmpty()))) {
        break label288;
      }
      localJSONArray = new JSONArray();
      if (paramList1 != null)
      {
        paramList1 = paramList1.iterator();
        while (paramList1.hasNext())
        {
          String str = (String)paramList1.next();
          if (str != null) {
            localJSONArray.put(a(str, 0, paramBoolean2));
          }
        }
      }
      if (paramList2 == null) {
        break label219;
      }
    }
    catch (JSONException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TeamWorkHandler", 2, paramString1, new Object[0]);
      }
      return false;
    }
    paramList1 = paramList2.iterator();
    while (paramList1.hasNext())
    {
      paramList2 = (String)paramList1.next();
      if (paramList2 != null) {
        localJSONArray.put(a(paramList2, 2, paramBoolean2));
      }
    }
    label219:
    if (paramList3 != null)
    {
      paramList1 = paramList3.iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (String)paramList1.next();
        if (paramList2 != null) {
          localJSONArray.put(a(paramList2, 3, paramBoolean2));
        }
      }
    }
    localJSONObject.put("addmemlist", localJSONArray);
    label288:
    paramList1 = UUID.randomUUID().toString().replaceAll("-", "");
    paramString2 = new StringBuilder(String.format("https://docs.qq.com/cgi-bin/redirect/%s/ep/api/setpadinfo", new Object[] { paramString2 })).append('?').append("localPadId=").append(paramString3).append("&type=1").append("&data=").append(localJSONObject.toString()).append("&dataType=");
    if (paramBoolean1) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramString2 = paramString2.append(paramInt).append("&xsrf=").append(paramList1);
      paramString3 = new StringBuilder().append("TOK=").append(paramList1);
      paramString1 = aobk.i(paramString1, paramString2.toString(), "docs.qq.com", paramString3.toString());
      if (paramString1 == null) {
        break;
      }
      if (new JSONObject(paramString1).optInt("retcode", -1) == 0) {
        break label490;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("TeamWorkHandler", 2, "setPolicy4AllByHttp failed result" + paramString1);
      break;
    }
    label490:
    return true;
  }
  
  public static void aW(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = aobk.j("doc_url=" + URLEncoder.encode(paramString3), paramString1, "https://docs.qq.com/cgi-bin/online_docs/doc_content", "docs.qq.com");
    if (!TextUtils.isEmpty(paramString1)) {
      aqhq.z(zo(), arwv.encodeHexStr(paramString2), paramString1);
    }
  }
  
  /* Error */
  public static JSONObject b(String paramString1, int paramInt, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_2
    //   3: new 198	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 498
    //   13: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_0
    //   17: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc_w 341
    //   23: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: iload_1
    //   27: invokevirtual 275	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: ldc 87
    //   35: invokestatic 304	aobk:m	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   38: astore 4
    //   40: aload 4
    //   42: ifnull +155 -> 197
    //   45: new 76	org/json/JSONObject
    //   48: dup
    //   49: aload 4
    //   51: invokespecial 95	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   54: astore_2
    //   55: aload_2
    //   56: astore_0
    //   57: aload_2
    //   58: ldc_w 306
    //   61: iconst_m1
    //   62: invokevirtual 101	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   65: ifeq +50 -> 115
    //   68: aload_2
    //   69: ldc_w 306
    //   72: iconst_m1
    //   73: invokevirtual 245	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   76: pop
    //   77: aload_2
    //   78: astore_0
    //   79: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +33 -> 115
    //   85: ldc_w 500
    //   88: iconst_2
    //   89: new 198	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 308
    //   99: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload 4
    //   104: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 173	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aload_2
    //   114: astore_0
    //   115: aload_0
    //   116: astore_2
    //   117: aload_0
    //   118: ifnonnull +20 -> 138
    //   121: new 76	org/json/JSONObject
    //   124: dup
    //   125: invokespecial 77	org/json/JSONObject:<init>	()V
    //   128: astore_2
    //   129: aload_2
    //   130: ldc_w 306
    //   133: iconst_m1
    //   134: invokevirtual 245	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   137: pop
    //   138: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq +14 -> 155
    //   144: ldc_w 500
    //   147: iconst_2
    //   148: aload_2
    //   149: invokevirtual 298	org/json/JSONObject:toString	()Ljava/lang/String;
    //   152: invokestatic 311	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: aload_2
    //   156: areturn
    //   157: astore_2
    //   158: aload_3
    //   159: astore_0
    //   160: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   163: ifeq +15 -> 178
    //   166: ldc_w 500
    //   169: iconst_2
    //   170: aload_2
    //   171: iconst_0
    //   172: anewarray 115	java/lang/Object
    //   175: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   178: goto -63 -> 115
    //   181: astore_0
    //   182: aload_0
    //   183: invokevirtual 350	org/json/JSONException:printStackTrace	()V
    //   186: goto -48 -> 138
    //   189: astore_3
    //   190: aload_2
    //   191: astore_0
    //   192: aload_3
    //   193: astore_2
    //   194: goto -34 -> 160
    //   197: aconst_null
    //   198: astore_0
    //   199: goto -84 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	paramString1	String
    //   0	202	1	paramInt	int
    //   0	202	2	paramString2	String
    //   1	158	3	localObject	Object
    //   189	4	3	localJSONException	JSONException
    //   38	65	4	str	String
    // Exception table:
    //   from	to	target	type
    //   2	40	157	org/json/JSONException
    //   45	55	157	org/json/JSONException
    //   129	138	181	org/json/JSONException
    //   57	77	189	org/json/JSONException
    //   79	113	189	org/json/JSONException
  }
  
  public static JSONObject b(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      String str = aobk.b(paramJSONObject, paramString, "https://docs.qq.com/cgi-go/imp/import_form_cache", "docs.qq.com");
      if (str != null)
      {
        paramJSONObject = new JSONObject(str);
        paramString = paramJSONObject;
      }
      label87:
      return null;
    }
    catch (JSONException localJSONException1)
    {
      do
      {
        try
        {
          if (paramJSONObject.optInt("retcode", -1) != 0)
          {
            paramJSONObject.put("retcode", -1);
            paramString = paramJSONObject;
            if (QLog.isColorLevel())
            {
              QLog.e("TeamWorkHandler", 2, "checkFormCache failed result" + str);
              paramString = paramJSONObject;
            }
          }
          return paramString;
        }
        catch (JSONException localJSONException2)
        {
          break label87;
        }
        localJSONException1 = localJSONException1;
        paramJSONObject = null;
        paramString = paramJSONObject;
      } while (!QLog.isColorLevel());
      QLog.e("TeamWorkHandler", 2, localJSONException1, new Object[0]);
      return paramJSONObject;
    }
  }
  
  public static String bA(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      Object localObject = paramString1.split("\\$");
      if (localObject.length == 2)
      {
        new JSONObject();
        try
        {
          paramString1 = UUID.randomUUID().toString().replaceAll("-", "");
          StringBuilder localStringBuilder1 = new StringBuilder().append("TOK=").append(paramString1);
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("domain_id=");
          localStringBuilder2.append(localObject[0]);
          localStringBuilder2.append("&pad_id=");
          localStringBuilder2.append(localObject[1]);
          localStringBuilder2.append("&list_type=");
          localStringBuilder2.append(5);
          localStringBuilder2.append("&xsrf=");
          localStringBuilder2.append(paramString1);
          localObject = new HashMap();
          ((Map)localObject).put("HTTP_X_XSRF_PROTECTION", paramString1);
          paramString1 = aobk.a(localStringBuilder2.toString(), paramString2, "https://docs.qq.com/cgi-bin/online_docs/doc_delete", "docs.qq.com", localStringBuilder1.toString(), (Map)localObject, false);
          return paramString1;
        }
        catch (Exception paramString1)
        {
          paramString1.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public static JSONObject c(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      String str = aobk.b(paramJSONObject, paramString, "https://docs.qq.com/cgi-go/imp/import_form_url", "docs.qq.com");
      if (str != null)
      {
        paramJSONObject = new JSONObject(str);
        paramString = paramJSONObject;
      }
      label78:
      return null;
    }
    catch (JSONException localJSONException1)
    {
      do
      {
        try
        {
          if (paramJSONObject.optInt("retcode", -1) != 0)
          {
            paramString = paramJSONObject;
            if (QLog.isColorLevel())
            {
              QLog.e("TeamWorkHandler", 2, "checkFormCache failed result" + str);
              paramString = paramJSONObject;
            }
          }
          return paramString;
        }
        catch (JSONException localJSONException2)
        {
          break label78;
        }
        localJSONException1 = localJSONException1;
        paramJSONObject = null;
        paramString = paramJSONObject;
      } while (!QLog.isColorLevel());
      QLog.e("TeamWorkHandler", 2, localJSONException1, new Object[0]);
      return paramJSONObject;
    }
  }
  
  public static void dUh()
  {
    Object localObject1 = new File(zo());
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (System.currentTimeMillis() - localObject2.lastModified() > 7200000L) {
          localObject2.delete();
        }
        i += 1;
      }
    }
  }
  
  /* Error */
  public static JSONObject f(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: new 198	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 555
    //   13: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_0
    //   17: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: ldc 87
    //   25: invokestatic 304	aobk:m	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull +150 -> 180
    //   33: new 76	org/json/JSONObject
    //   36: dup
    //   37: aload_3
    //   38: invokespecial 95	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   41: astore_1
    //   42: aload_1
    //   43: astore_0
    //   44: aload_1
    //   45: ldc_w 306
    //   48: iconst_m1
    //   49: invokevirtual 101	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   52: ifeq +48 -> 100
    //   55: aload_1
    //   56: ldc_w 306
    //   59: iconst_m1
    //   60: invokevirtual 245	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   63: pop
    //   64: aload_1
    //   65: astore_0
    //   66: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +31 -> 100
    //   72: ldc 113
    //   74: iconst_2
    //   75: new 198	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   82: ldc_w 308
    //   85: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_3
    //   89: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 173	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aload_1
    //   99: astore_0
    //   100: aload_0
    //   101: astore_1
    //   102: aload_0
    //   103: ifnonnull +20 -> 123
    //   106: new 76	org/json/JSONObject
    //   109: dup
    //   110: invokespecial 77	org/json/JSONObject:<init>	()V
    //   113: astore_1
    //   114: aload_1
    //   115: ldc_w 306
    //   118: iconst_m1
    //   119: invokevirtual 245	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   122: pop
    //   123: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq +13 -> 139
    //   129: ldc 113
    //   131: iconst_2
    //   132: aload_1
    //   133: invokevirtual 298	org/json/JSONObject:toString	()Ljava/lang/String;
    //   136: invokestatic 311	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: aload_1
    //   140: areturn
    //   141: astore_1
    //   142: aload_2
    //   143: astore_0
    //   144: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +14 -> 161
    //   150: ldc 113
    //   152: iconst_2
    //   153: aload_1
    //   154: iconst_0
    //   155: anewarray 115	java/lang/Object
    //   158: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   161: goto -61 -> 100
    //   164: astore_0
    //   165: aload_0
    //   166: invokevirtual 350	org/json/JSONException:printStackTrace	()V
    //   169: goto -46 -> 123
    //   172: astore_2
    //   173: aload_1
    //   174: astore_0
    //   175: aload_2
    //   176: astore_1
    //   177: goto -33 -> 144
    //   180: aconst_null
    //   181: astore_0
    //   182: goto -82 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	paramString1	String
    //   0	185	1	paramString2	String
    //   1	142	2	localObject	Object
    //   172	4	2	localJSONException	JSONException
    //   28	61	3	str	String
    // Exception table:
    //   from	to	target	type
    //   2	29	141	org/json/JSONException
    //   33	42	141	org/json/JSONException
    //   114	123	164	org/json/JSONException
    //   44	64	172	org/json/JSONException
    //   66	98	172	org/json/JSONException
  }
  
  private static File j(String paramString)
  {
    return new File(zo(), arwv.encodeHexStr(paramString));
  }
  
  private void kV(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    int i = ((Integer)paramToServiceMsg.getAttribute(cjJ)).intValue();
    if (QLog.isColorLevel()) {
      QLog.i("TeamWorkHandler", 2, " handleSetPadRightsInfo ,resultCode: " + paramFromServiceMsg.getResultCode());
    }
    if (!bool) {
      paramToServiceMsg = "";
    }
    for (;;)
    {
      if (!bool) {
        QLog.i("TeamWorkHandler", 1, " handleGetPadRightsInfo faied code: " + paramFromServiceMsg.getResultCode());
      }
      notifyUI(6, bool, new Object[] { paramToServiceMsg, Integer.valueOf(i) });
      return;
      paramToServiceMsg = new TimDocSSOMsg.SetPadRightInfoRspBody();
      int j;
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        j = paramToServiceMsg.uint32_retcode.get();
        if (j == 0) {
          break label247;
        }
        QLog.e("TeamWorkHandler", 1, "error handleSetPadRightsInfo  url : " + "" + ",retCode: " + j);
        paramToServiceMsg = "";
        bool = false;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.i("TeamWorkHandler", 1, " handleSetPadRightsInfo exception: " + paramToServiceMsg.toString());
        paramToServiceMsg = "";
        bool = false;
      }
      continue;
      label247:
      paramToServiceMsg = paramToServiceMsg.bytes_pad_url.get().toStringUtf8();
      if (QLog.isColorLevel()) {
        QLog.i("TeamWorkHandler", 2, " handleSetPadRightsInfo url : " + paramToServiceMsg + ",retCode: " + j);
      }
      bool = true;
    }
  }
  
  private void kW(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    try
    {
      DocsGrayTipsInfo localDocsGrayTipsInfo = (DocsGrayTipsInfo)paramToServiceMsg.getAttribute("data");
      long l = ((Long)paramToServiceMsg.getAttribute("seq")).longValue();
      paramToServiceMsg = new cmd0xbab.RspBody();
      int j = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      int i;
      if (j == 0)
      {
        paramToServiceMsg = (cmd0xbab.UserGetRsp)paramToServiceMsg.user_get_rsp.get();
        int k = paramToServiceMsg.policy.get();
        int m = paramToServiceMsg.privilege_flag.get();
        int n = paramToServiceMsg.member_number.get();
        int i1 = paramToServiceMsg.exp_remain_time.get();
        i = paramToServiceMsg.exp_set_time.get();
        QLog.i("TeamWorkHandler" + aoaf.cjv, 2, " handleGetUserAuthDocsGrayTips  | policy=" + k + " privilege =" + m + " memberNum = " + n + " remainTime = " + i1 + " setTime= " + i);
        if ((Integer.valueOf(localDocsGrayTipsInfo.ciU).intValue() == m) && (Integer.valueOf(localDocsGrayTipsInfo.ciT).intValue() == k))
        {
          if ((i == 0) || (i1 != 0)) {
            break label425;
          }
          i = 0;
        }
      }
      for (;;)
      {
        a(localDocsGrayTipsInfo, i, l);
        boolean bool = true;
        paramToServiceMsg = "";
        for (;;)
        {
          if (!bool) {
            notifyUI(8, bool, new Object[] { localDocsGrayTipsInfo, paramToServiceMsg, Long.valueOf(l) });
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("TeamWorkHandler" + aoaf.cjv, 2, " handleGetUserAuthDocsGrayTips ,result: " + j);
          return;
          bool = false;
          paramToServiceMsg = this.app.getApp().getString(2131720940);
          continue;
          bool = false;
          paramToServiceMsg = localDocsGrayTipsInfo.ciR;
        }
      }
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.e("TeamWorkHandler" + aoaf.cjv, 1, " handleGetUserAuthDocsGrayTips exception = " + paramToServiceMsg.toString());
      return;
    }
    label425:
  }
  
  private void kX(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      DocsGrayTipsInfo localDocsGrayTipsInfo;
      try
      {
        localDocsGrayTipsInfo = (DocsGrayTipsInfo)paramToServiceMsg.getAttribute("data");
        long l = ((Long)paramToServiceMsg.getAttribute("seq")).longValue();
        paramToServiceMsg = new cmd0xbab.RspBody();
        int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
        if (i == 0)
        {
          paramToServiceMsg = (cmd0xbab.UserSetRsp)paramToServiceMsg.user_set_rsp.get();
          paramToServiceMsg = localDocsGrayTipsInfo.ciQ;
          if ("1".equals(localDocsGrayTipsInfo.ciL))
          {
            anot.a(null, "CliOper", "", "", "0X8009550", "0X8009550", 0, 0, "", "", "", "");
            break label309;
            notifyUI(9, bool, new Object[] { localDocsGrayTipsInfo, paramToServiceMsg, Long.valueOf(l) });
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("TeamWorkHandler" + aoaf.cjv, 2, " handleSetUserAuthDocsGrayTips ,result: " + i);
          }
          else if ("2".equals(localDocsGrayTipsInfo.ciL))
          {
            anot.a(null, "CliOper", "", "", "0X8009552", "0X8009552", 0, 0, "", "", "", "");
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("TeamWorkHandler" + aoaf.cjv, 1, " handleSetUserAuthDocsGrayTips  exception = " + paramToServiceMsg.toString());
        return;
      }
      boolean bool = false;
      paramToServiceMsg = localDocsGrayTipsInfo.ciR;
      continue;
      label309:
      bool = true;
    }
  }
  
  private void kY(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    try
    {
      DocsGrayTipsInfo localDocsGrayTipsInfo = (DocsGrayTipsInfo)paramToServiceMsg.getAttribute("data");
      long l = ((Long)paramToServiceMsg.getAttribute("seq")).longValue();
      paramToServiceMsg = new cmd0xbab.RspBody();
      int k = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      boolean bool;
      if (k == 0)
      {
        paramToServiceMsg = (cmd0xbab.GroupGetRsp)paramToServiceMsg.group_get_rsp.get();
        int i = paramToServiceMsg.policy.get();
        paramFromServiceMsg = paramToServiceMsg.user_list.get();
        int n = paramToServiceMsg.total_members.get();
        int i1 = paramToServiceMsg.privilege_members.get();
        int i2 = paramToServiceMsg.privilege_flag.get();
        int i3 = paramToServiceMsg.member_number.get();
        int m = paramToServiceMsg.exp_remain_time.get();
        int j = paramToServiceMsg.exp_set_time.get();
        QLog.i("TeamWorkHandler" + aoaf.cjv, 1, " handleGetGroupAuthDocsGrayTips  | policy = " + i + " userInfoList.size() = " + paramFromServiceMsg.size() + " totalMembers = " + n + " privilegeMembers = " + i1 + " privilege = " + i2 + " memberNum = " + i3 + " remainTime = " + m + " setTime = " + j + " docsGrayTipsInfo.policy = " + localDocsGrayTipsInfo.ciT + " docsGrayTipsInfo.privilege = " + localDocsGrayTipsInfo.ciU);
        if ((Integer.valueOf(localDocsGrayTipsInfo.ciU).intValue() == i2) && (Integer.valueOf(localDocsGrayTipsInfo.ciT).intValue() == i))
        {
          i = j;
          if (j != 0)
          {
            i = j;
            if (m == 0) {
              i = 0;
            }
          }
          b(localDocsGrayTipsInfo, i, l);
          bool = true;
          paramToServiceMsg = "";
        }
      }
      for (;;)
      {
        QLog.i("TeamWorkHandler" + aoaf.cjv, 1, " handleGetGroupAuthDocsGrayTips. result = " + k + ", isSuccess = " + bool);
        if (bool) {
          break;
        }
        notifyUI(10, bool, new Object[] { localDocsGrayTipsInfo, paramToServiceMsg, Long.valueOf(l) });
        return;
        bool = false;
        paramToServiceMsg = this.app.getApp().getString(2131720940);
        continue;
        bool = false;
        paramToServiceMsg = localDocsGrayTipsInfo.ciR;
      }
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.e("TeamWorkHandler" + aoaf.cjv, 1, " handleGetGroupAuthDocsGrayTips exception = " + paramToServiceMsg.toString());
    }
  }
  
  private void kZ(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      DocsGrayTipsInfo localDocsGrayTipsInfo;
      try
      {
        localDocsGrayTipsInfo = (DocsGrayTipsInfo)paramToServiceMsg.getAttribute("data");
        long l = ((Long)paramToServiceMsg.getAttribute("seq")).longValue();
        paramToServiceMsg = new cmd0xbab.RspBody();
        int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
        if (i == 0)
        {
          paramToServiceMsg = (cmd0xbab.GroupSetRsp)paramToServiceMsg.group_set_rsp.get();
          paramToServiceMsg = localDocsGrayTipsInfo.ciQ;
          if ("1".equals(localDocsGrayTipsInfo.ciL))
          {
            anot.a(null, "CliOper", "", "", "0X8009550", "0X8009550", 1, 0, "", "", "", "");
            break label303;
            QLog.i("TeamWorkHandler" + aoaf.cjv, 1, " handleSetGroupAuthDocsGrayTips. result = " + i);
            notifyUI(11, bool, new Object[] { localDocsGrayTipsInfo, paramToServiceMsg, Long.valueOf(l) });
          }
          else if ("2".equals(localDocsGrayTipsInfo.ciL))
          {
            anot.a(null, "CliOper", "", "", "0X8009552", "0X8009552", 1, 0, "", "", "", "");
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("TeamWorkHandler" + aoaf.cjv, 1, " handleSetGroupAuthDocsGrayTips  exception = " + paramToServiceMsg.toString());
        return;
      }
      boolean bool = false;
      paramToServiceMsg = localDocsGrayTipsInfo.ciR;
      continue;
      label303:
      bool = true;
    }
  }
  
  public static String nP(String paramString)
  {
    return Uri.parse(paramString).getLastPathSegment();
  }
  
  public static String nQ(String paramString)
  {
    return aqhq.readFileContent(j(paramString));
  }
  
  public static boolean pM(String paramString)
  {
    paramString = j(paramString);
    if (System.currentTimeMillis() - paramString.lastModified() > 7200000L)
    {
      paramString.delete();
      return false;
    }
    return paramString.exists();
  }
  
  public static String zo()
  {
    if (cjK != null) {
      return cjK;
    }
    String str = awri.Hp();
    str = str + "Tencent" + "/" + "tdoc" + "/";
    cjK = str;
    return str;
  }
  
  public String F(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString1 = "xsrf=" + paramString3 + "&uin=" + paramString1;
      paramString2 = "vfwebqq=" + paramString2 + ";TOK=" + paramString3;
      paramString1 = aobk.a(paramString1, this.app.getCurrentAccountUin(), "https://docs.qq.com/cgi-bin/online_docs/tool_decryptuin", "docs.qq.com", paramString2, null, false);
      if (TextUtils.isEmpty(paramString1)) {
        return null;
      }
      paramString1 = new JSONObject(paramString1);
      int i = paramString1.optInt("cgicode", -1);
      paramString2 = paramString1.optString("msg");
      if (i == 0) {
        return paramString1.optString("uin");
      }
      QLog.w("TeamWorkHandler", 1, "no result, cgicode: " + i + " msg: " + paramString2);
      return null;
    }
    catch (JSONException paramString1)
    {
      QLog.e("TeamWorkHandler", 1, paramString1.getLocalizedMessage(), paramString1);
    }
    return null;
  }
  
  TimDocSSOMsg.LoginInfo a(String paramString, ReSendCmd paramReSendCmd)
  {
    Object localObject = (TicketManager)this.mApp.getManager(2);
    if (localObject != null)
    {
      String str2 = ((TicketManager)localObject).getPskey(this.mApp.getCurrentAccountUin(), "docs.qq.com");
      String str1 = ((TicketManager)localObject).getSkey(this.mApp.getAccount());
      if (!TextUtils.isEmpty(str2))
      {
        localObject = new TimDocSSOMsg.LoginInfo();
        ((TimDocSSOMsg.LoginInfo)localObject).bytes_pskey.set(ByteStringMicro.copyFromUtf8(str2));
        this.dNV = 0;
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(str1))
        {
          this.dNW = 0;
          if (localObject != null) {
            ((TimDocSSOMsg.LoginInfo)localObject).bytes_skey.set(ByteStringMicro.copyFromUtf8(str1));
          }
        }
        label317:
        label319:
        do
        {
          do
          {
            return localObject;
            QLog.i("TeamWorkHandler", 1, paramString + " pSkey is null, try to get pskey from server,reTryGetPskeyCount " + this.dNV);
            if ((this.dNV < 3) && (paramReSendCmd != null))
            {
              this.dNV += 1;
              str2 = a(paramReSendCmd, false);
              if (TextUtils.isEmpty(str2)) {
                break label336;
              }
              this.dNV = 0;
              localObject = new TimDocSSOMsg.LoginInfo();
              ((TimDocSSOMsg.LoginInfo)localObject).bytes_pskey.set(ByteStringMicro.copyFromUtf8(str2));
              break;
            }
            this.dNV = 0;
            localObject = new TimDocSSOMsg.LoginInfo();
            break;
            QLog.i("TeamWorkHandler", 1, paramString + " skey is null,try to get skey from server, reTryGetSkeyCount: " + this.dNW);
            if ((this.dNW >= 3) || (paramReSendCmd == null)) {
              break label319;
            }
            this.dNW += 1;
            paramString = a(paramReSendCmd);
            if (TextUtils.isEmpty(paramString)) {
              break label317;
            }
            this.dNW = 0;
          } while (localObject == null);
          ((TimDocSSOMsg.LoginInfo)localObject).bytes_skey.set(ByteStringMicro.copyFromUtf8(paramString));
          return localObject;
          return null;
          this.dNV = 0;
        } while (localObject != null);
        return new TimDocSSOMsg.LoginInfo();
        label336:
        localObject = null;
      }
    }
    return null;
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, List<TimDocSSOMsg.UinRightInfo> paramList)
  {
    if (!aqiw.isNetSupport(BaseApplicationImpl.getContext())) {
      notifyUI(6, false, new Object[] { "", Integer.valueOf(paramInt2) });
    }
    do
    {
      return;
      TimDocSSOMsg.SetPadRightInfoReqBody localSetPadRightInfoReqBody = new TimDocSSOMsg.SetPadRightInfoReqBody();
      localSetPadRightInfoReqBody.bytes_pad_url.set(ByteStringMicro.copyFromUtf8(paramString));
      TimDocSSOMsg.LoginInfo localLoginInfo = a("send setPadRightsInfo", null);
      if (localLoginInfo != null) {
        localSetPadRightInfoReqBody.msg_login_info.set(localLoginInfo);
      }
      localSetPadRightInfoReqBody.uint32_appid.set(2);
      localSetPadRightInfoReqBody.uint32_pad_right.set(paramInt1);
      if ((paramList != null) && (paramList.size() > 0)) {
        localSetPadRightInfoReqBody.rpt_msg_uin_right_info.set(paramList);
      }
      paramList = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "TimDocSvc.SetPadRightInfo");
      paramList.addAttribute(cjJ, Integer.valueOf(paramInt2));
      paramList.putWupBuffer(localSetPadRightInfoReqBody.toByteArray());
      paramList.setTimeout(30000L);
      super.sendPbReq(paramList);
    } while (!QLog.isColorLevel());
    QLog.i("TeamWorkHandler", 2, "send setPadRightsInfo,padUrl: " + paramString);
  }
  
  public void a(DocsGrayTipsInfo paramDocsGrayTipsInfo, int paramInt, long paramLong)
  {
    boolean bool = false;
    try
    {
      if (!aqiw.isNetSupport(BaseApplicationImpl.getContext()))
      {
        localObject1 = BaseApplicationImpl.getContext();
        if (TextUtils.isEmpty(paramDocsGrayTipsInfo.ciS)) {}
        for (paramDocsGrayTipsInfo = this.app.getApp().getString(2131696272);; paramDocsGrayTipsInfo = paramDocsGrayTipsInfo.ciS)
        {
          QQToast.a((Context)localObject1, paramDocsGrayTipsInfo, 0).show();
          return;
        }
      }
      Object localObject1 = new cmd0xbab.UserSetReq();
      ((cmd0xbab.UserSetReq)localObject1).uin.set(Long.parseLong(paramDocsGrayTipsInfo.uin));
      ((cmd0xbab.UserSetReq)localObject1).doc_url.set(paramDocsGrayTipsInfo.url);
      ((cmd0xbab.UserSetReq)localObject1).policy.set(Integer.valueOf(paramDocsGrayTipsInfo.ciO).intValue());
      Object localObject2 = ((cmd0xbab.UserSetReq)localObject1).only;
      if (Integer.valueOf(paramDocsGrayTipsInfo.ciP).intValue() == 1) {
        bool = true;
      }
      ((PBBoolField)localObject2).set(bool);
      ((cmd0xbab.UserSetReq)localObject1).privilege_flag.set(Integer.valueOf(paramDocsGrayTipsInfo.ciN).intValue());
      ((cmd0xbab.UserSetReq)localObject1).exp_set_time.set(paramInt);
      localObject2 = new cmd0xbab.ReqBody();
      ((cmd0xbab.ReqBody)localObject2).user_set_req.set((MessageMicro)localObject1);
      localObject1 = makeOIDBPkg("OidbSvc.0xbab_2", 2987, 2, ((cmd0xbab.ReqBody)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).addAttribute("data", paramDocsGrayTipsInfo);
      ((ToServiceMsg)localObject1).addAttribute("seq", Long.valueOf(paramLong));
      sendPbReq((ToServiceMsg)localObject1);
      QLog.i("TeamWorkHandler" + aoaf.cjv, 2, "set user auth | uin = " + paramDocsGrayTipsInfo.uin + " docUrl = " + paramDocsGrayTipsInfo.url + " setploicy = " + paramDocsGrayTipsInfo.ciO + " setonly= " + paramDocsGrayTipsInfo.ciP + " setprivilege=" + paramDocsGrayTipsInfo.ciN + " bNeedtime = " + paramDocsGrayTipsInfo.ciY + " settime=" + paramInt);
      return;
    }
    catch (Exception paramDocsGrayTipsInfo)
    {
      QLog.e("TeamWorkHandler" + aoaf.cjv, 1, "set user auth exception = " + paramDocsGrayTipsInfo.toString());
    }
  }
  
  public void a(DocsGrayTipsInfo paramDocsGrayTipsInfo, long paramLong)
  {
    try
    {
      if (!aqiw.isNetSupport(BaseApplicationImpl.getContext()))
      {
        localObject = BaseApplicationImpl.getContext();
        if (TextUtils.isEmpty(paramDocsGrayTipsInfo.ciS)) {}
        for (paramDocsGrayTipsInfo = this.app.getApp().getString(2131696272);; paramDocsGrayTipsInfo = paramDocsGrayTipsInfo.ciS)
        {
          QQToast.a((Context)localObject, paramDocsGrayTipsInfo, 0).show();
          return;
        }
      }
      Object localObject = new cmd0xbab.UserGetReq();
      ((cmd0xbab.UserGetReq)localObject).uin.set(Long.parseLong(paramDocsGrayTipsInfo.uin));
      ((cmd0xbab.UserGetReq)localObject).doc_url.set(paramDocsGrayTipsInfo.url);
      cmd0xbab.ReqBody localReqBody = new cmd0xbab.ReqBody();
      localReqBody.user_get_req.set((MessageMicro)localObject);
      localObject = makeOIDBPkg("OidbSvc.0xbab_1", 2987, 1, localReqBody.toByteArray());
      ((ToServiceMsg)localObject).addAttribute("data", paramDocsGrayTipsInfo);
      ((ToServiceMsg)localObject).addAttribute("seq", Long.valueOf(paramLong));
      sendPbReq((ToServiceMsg)localObject);
      QLog.i("TeamWorkHandler" + aoaf.cjv, 2, "get user auth | uin = " + paramDocsGrayTipsInfo.uin + " docUrl = " + paramDocsGrayTipsInfo.url);
      return;
    }
    catch (Exception paramDocsGrayTipsInfo)
    {
      QLog.e("TeamWorkHandler" + aoaf.cjv, 1, "get user auth exception = " + paramDocsGrayTipsInfo.toString());
    }
  }
  
  /* Error */
  public JSONObject ae()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: getfield 178	aobh:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   9: ldc_w 1096
    //   12: ldc 87
    //   14: invokestatic 304	aobk:m	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   17: astore_3
    //   18: aload_3
    //   19: ifnull +148 -> 167
    //   22: new 76	org/json/JSONObject
    //   25: dup
    //   26: aload_3
    //   27: invokespecial 95	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   30: astore_2
    //   31: aload_2
    //   32: astore_1
    //   33: aload_2
    //   34: ldc_w 306
    //   37: iconst_m1
    //   38: invokevirtual 101	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   41: ifeq +48 -> 89
    //   44: aload_2
    //   45: ldc_w 306
    //   48: iconst_m1
    //   49: invokevirtual 245	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   52: pop
    //   53: aload_2
    //   54: astore_1
    //   55: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   58: ifeq +31 -> 89
    //   61: ldc 113
    //   63: iconst_2
    //   64: new 198	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   71: ldc_w 308
    //   74: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_3
    //   78: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 173	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   87: aload_2
    //   88: astore_1
    //   89: aload_1
    //   90: astore_2
    //   91: aload_1
    //   92: ifnonnull +20 -> 112
    //   95: new 76	org/json/JSONObject
    //   98: dup
    //   99: invokespecial 77	org/json/JSONObject:<init>	()V
    //   102: astore_2
    //   103: aload_2
    //   104: ldc_w 306
    //   107: iconst_m1
    //   108: invokevirtual 245	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   111: pop
    //   112: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +13 -> 128
    //   118: ldc 113
    //   120: iconst_2
    //   121: aload_2
    //   122: invokevirtual 298	org/json/JSONObject:toString	()Ljava/lang/String;
    //   125: invokestatic 311	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: aload_2
    //   129: areturn
    //   130: astore_2
    //   131: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +14 -> 148
    //   137: ldc 113
    //   139: iconst_2
    //   140: aload_2
    //   141: iconst_0
    //   142: anewarray 115	java/lang/Object
    //   145: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   148: goto -59 -> 89
    //   151: astore_1
    //   152: aload_1
    //   153: invokevirtual 350	org/json/JSONException:printStackTrace	()V
    //   156: goto -44 -> 112
    //   159: astore_3
    //   160: aload_2
    //   161: astore_1
    //   162: aload_3
    //   163: astore_2
    //   164: goto -33 -> 131
    //   167: aconst_null
    //   168: astore_1
    //   169: goto -80 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	aobh
    //   1	91	1	localObject1	Object
    //   151	2	1	localJSONException1	JSONException
    //   161	8	1	localObject2	Object
    //   30	99	2	localObject3	Object
    //   130	31	2	localJSONException2	JSONException
    //   163	1	2	localJSONException3	JSONException
    //   17	61	3	str	String
    //   159	4	3	localJSONException4	JSONException
    // Exception table:
    //   from	to	target	type
    //   2	18	130	org/json/JSONException
    //   22	31	130	org/json/JSONException
    //   103	112	151	org/json/JSONException
    //   33	53	159	org/json/JSONException
    //   55	87	159	org/json/JSONException
  }
  
  public void b(DocsGrayTipsInfo paramDocsGrayTipsInfo, int paramInt, long paramLong)
  {
    boolean bool = false;
    try
    {
      if (!aqiw.isNetSupport(BaseApplicationImpl.getContext()))
      {
        localObject1 = BaseApplicationImpl.getContext();
        if (TextUtils.isEmpty(paramDocsGrayTipsInfo.ciS)) {}
        for (paramDocsGrayTipsInfo = this.app.getApp().getString(2131696272);; paramDocsGrayTipsInfo = paramDocsGrayTipsInfo.ciS)
        {
          QQToast.a((Context)localObject1, paramDocsGrayTipsInfo, 0).show();
          return;
        }
      }
      Object localObject1 = new cmd0xbab.GroupSetReq();
      ((cmd0xbab.GroupSetReq)localObject1).group_code.set(Long.parseLong(paramDocsGrayTipsInfo.uin));
      ((cmd0xbab.GroupSetReq)localObject1).doc_url.set(paramDocsGrayTipsInfo.url);
      ((cmd0xbab.GroupSetReq)localObject1).policy.set(Integer.valueOf(paramDocsGrayTipsInfo.ciO).intValue());
      Object localObject2 = ((cmd0xbab.GroupSetReq)localObject1).only;
      if (Integer.valueOf(paramDocsGrayTipsInfo.ciP).intValue() == 1) {
        bool = true;
      }
      ((PBBoolField)localObject2).set(bool);
      ((cmd0xbab.GroupSetReq)localObject1).privilege_flag.set(Integer.valueOf(paramDocsGrayTipsInfo.ciN).intValue());
      ((cmd0xbab.GroupSetReq)localObject1).exp_set_time.set(paramInt);
      localObject2 = new cmd0xbab.ReqBody();
      ((cmd0xbab.ReqBody)localObject2).group_set_req.set((MessageMicro)localObject1);
      localObject1 = makeOIDBPkg("OidbSvc.0xbab_4", 2987, 4, ((cmd0xbab.ReqBody)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).addAttribute("data", paramDocsGrayTipsInfo);
      ((ToServiceMsg)localObject1).addAttribute("seq", Long.valueOf(paramLong));
      sendPbReq((ToServiceMsg)localObject1);
      QLog.i("TeamWorkHandler" + aoaf.cjv, 1, "set group auth | uin = " + paramDocsGrayTipsInfo.uin + " docUrl = " + paramDocsGrayTipsInfo.url + " setploicy = " + paramDocsGrayTipsInfo.ciO + " setonly= " + paramDocsGrayTipsInfo.ciP + " setprivilege=" + paramDocsGrayTipsInfo.ciN + " bNeedtime = " + paramDocsGrayTipsInfo.ciY + " settime=" + paramInt);
      return;
    }
    catch (Exception paramDocsGrayTipsInfo)
    {
      QLog.e("TeamWorkHandler" + aoaf.cjv, 1, "set group auth exception = " + paramDocsGrayTipsInfo.toString());
    }
  }
  
  public void b(DocsGrayTipsInfo paramDocsGrayTipsInfo, long paramLong)
  {
    try
    {
      if (!aqiw.isNetSupport(BaseApplicationImpl.getContext()))
      {
        localObject = BaseApplicationImpl.getContext();
        if (TextUtils.isEmpty(paramDocsGrayTipsInfo.ciS)) {}
        for (paramDocsGrayTipsInfo = this.app.getApp().getString(2131696272);; paramDocsGrayTipsInfo = paramDocsGrayTipsInfo.ciS)
        {
          QQToast.a((Context)localObject, paramDocsGrayTipsInfo, 0).show();
          return;
        }
      }
      Object localObject = new cmd0xbab.GroupGetReq();
      ((cmd0xbab.GroupGetReq)localObject).group_code.set(Long.parseLong(paramDocsGrayTipsInfo.uin));
      ((cmd0xbab.GroupGetReq)localObject).doc_url.set(paramDocsGrayTipsInfo.url);
      cmd0xbab.ReqBody localReqBody = new cmd0xbab.ReqBody();
      localReqBody.group_get_req.set((MessageMicro)localObject);
      localObject = makeOIDBPkg("OidbSvc.0xbab_3", 2987, 3, localReqBody.toByteArray());
      ((ToServiceMsg)localObject).addAttribute("data", paramDocsGrayTipsInfo);
      ((ToServiceMsg)localObject).addAttribute("seq", Long.valueOf(paramLong));
      sendPbReq((ToServiceMsg)localObject);
      QLog.i("TeamWorkHandler" + aoaf.cjv, 1, "get group auth | uin = " + paramDocsGrayTipsInfo.uin + " docUrl = " + paramDocsGrayTipsInfo.url + ", msgSeq = " + paramLong);
      return;
    }
    catch (Exception paramDocsGrayTipsInfo)
    {
      QLog.e("TeamWorkHandler" + aoaf.cjv, 1, "get group auth exception = " + paramDocsGrayTipsInfo.toString());
    }
  }
  
  public void dL(int paramInt, String paramString)
  {
    if (!aqiw.isNetSupport(BaseApplicationImpl.getContext())) {
      notifyUI(5, false, new Object[] { "", Integer.valueOf(paramInt) });
    }
    do
    {
      return;
      TimDocSSOMsg.GetPadRightInfoReqBody localGetPadRightInfoReqBody = new TimDocSSOMsg.GetPadRightInfoReqBody();
      localGetPadRightInfoReqBody.uint32_appid.set(2);
      localGetPadRightInfoReqBody.bytes_pad_url.set(ByteStringMicro.copyFromUtf8(paramString));
      ReSendCmd localReSendCmd = new ReSendCmd();
      localReSendCmd.cmd = 9;
      localReSendCmd.dNH = paramInt;
      localReSendCmd.cjb = paramString;
      Object localObject = a("send GetPadRightInfoReqBody", localReSendCmd);
      if (localObject == null)
      {
        QLog.e("TeamWorkHandler", 1, "---- GetPadRightInfoReqBody -- loginInfo is null ---");
        return;
      }
      localGetPadRightInfoReqBody.msg_login_info.set((MessageMicro)localObject);
      localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "TimDocSvc.GetPadRightInfo");
      ((ToServiceMsg)localObject).putWupBuffer(localGetPadRightInfoReqBody.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).addAttribute(cjJ, Integer.valueOf(paramInt));
      ((ToServiceMsg)localObject).extraData.putParcelable("key_resend_cmd", localReSendCmd);
      super.sendPbReq((ToServiceMsg)localObject);
    } while (!QLog.isColorLevel());
    QLog.i("TeamWorkHandler", 2, "send GetPadRightInfoReqBody,padUrl: " + paramString);
  }
  
  public void kU(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    int j = ((Integer)paramToServiceMsg.getAttribute(cjJ)).intValue();
    if (QLog.isColorLevel()) {
      QLog.i("TeamWorkHandler", 2, " handleGetPadRightsInfo ,resultCode: " + paramFromServiceMsg.getResultCode());
    }
    if (!bool) {
      paramToServiceMsg = "";
    }
    label122:
    TimDocSSOMsg.GetPadRightInfoRspBody localGetPadRightInfoRspBody;
    for (;;)
    {
      if (!bool) {
        QLog.i("TeamWorkHandler", 1, " handleGetPadRightsInfo faied code: " + paramFromServiceMsg.getResultCode());
      }
      notifyUI(5, bool, new Object[] { paramToServiceMsg, Integer.valueOf(j) });
      return;
      localGetPadRightInfoRspBody = new TimDocSSOMsg.GetPadRightInfoRspBody();
      try
      {
        localGetPadRightInfoRspBody.mergeFrom((byte[])paramObject);
        i = localGetPadRightInfoRspBody.uint32_retcode.get();
        if (i == 0) {
          break label277;
        }
        QLog.e("TeamWorkHandler", 1, "error handleGetPadRightsInfo url : " + "" + ",retCode: " + i);
        if ((i == 200011) && (a((ReSendCmd)paramToServiceMsg.extraData.getParcelable("key_resend_cmd")))) {
          break label122;
        }
        paramToServiceMsg = "";
        bool = false;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.i("TeamWorkHandler", 1, " handleGetPadRightsInfo exception: " + paramToServiceMsg.toString());
        paramToServiceMsg = "";
        bool = false;
      }
      continue;
      label277:
      paramToServiceMsg = localGetPadRightInfoRspBody.bytes_pad_url.get().toStringUtf8();
      if (localGetPadRightInfoRspBody.uint32_pad_right.has()) {
        break;
      }
      QLog.e("TeamWorkHandler", 1, "error handleGetPadRightsInfo url : " + paramToServiceMsg + ",has not padrights filed ");
      bool = false;
    }
    int i = localGetPadRightInfoRspBody.uint32_pad_right.get();
    paramFromServiceMsg = localGetPadRightInfoRspBody.rpt_msg_uin_right_info.get();
    if (0 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TeamWorkHandler", 2, "pad is not exxisted ,but in other list find : " + false);
      }
      notifyUI(7, true, new Object[] { paramToServiceMsg, Integer.valueOf(i), paramFromServiceMsg });
      return;
    }
    if ((i == 1) || (i == 2)) {
      throw new NullPointerException();
    }
    new ArrayList();
    throw new NullPointerException();
  }
  
  protected Class<? extends acci> observerClass()
  {
    return aobo.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("TimDocSvc.GetPadRightInfo".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      kU(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if ("TimDocSvc.SetPadRightInfo".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        kV(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xbab_1".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        kW(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xbab_2".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        kX(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xbab_3".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        kY(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0xbab_4".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()));
    kZ(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  /* Error */
  public JSONObject r(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: ifnonnull +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: invokestatic 407	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   11: invokevirtual 408	java/util/UUID:toString	()Ljava/lang/String;
    //   14: ldc_w 410
    //   17: ldc_w 412
    //   20: invokevirtual 415	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   23: astore 4
    //   25: new 198	java/lang/StringBuilder
    //   28: dup
    //   29: ldc_w 1230
    //   32: invokespecial 254	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   35: bipush 63
    //   37: invokevirtual 257	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   40: ldc_w 1232
    //   43: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokestatic 546	java/lang/System:currentTimeMillis	()J
    //   49: invokevirtual 1137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   52: ldc_w 419
    //   55: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload 4
    //   60: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: astore_2
    //   64: new 198	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   71: ldc_w 421
    //   74: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload 4
    //   79: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: astore 4
    //   84: aload_1
    //   85: aload_0
    //   86: getfield 178	aobh:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   89: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   92: aload_2
    //   93: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: ldc 87
    //   98: aload 4
    //   100: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 1235	aobk:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   106: astore 4
    //   108: aload 4
    //   110: ifnull +143 -> 253
    //   113: new 76	org/json/JSONObject
    //   116: dup
    //   117: aload 4
    //   119: invokespecial 95	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   122: astore_2
    //   123: aload_2
    //   124: astore_1
    //   125: aload_2
    //   126: ldc_w 306
    //   129: iconst_m1
    //   130: invokevirtual 101	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   133: ifeq +40 -> 173
    //   136: aload_2
    //   137: astore_1
    //   138: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq +32 -> 173
    //   144: ldc 113
    //   146: iconst_2
    //   147: new 198	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   154: ldc_w 1237
    //   157: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload 4
    //   162: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 173	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: aload_2
    //   172: astore_1
    //   173: aload_1
    //   174: astore_2
    //   175: aload_1
    //   176: ifnonnull +20 -> 196
    //   179: new 76	org/json/JSONObject
    //   182: dup
    //   183: invokespecial 77	org/json/JSONObject:<init>	()V
    //   186: astore_2
    //   187: aload_2
    //   188: ldc_w 306
    //   191: iconst_m1
    //   192: invokevirtual 245	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   195: pop
    //   196: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq +13 -> 212
    //   202: ldc 113
    //   204: iconst_2
    //   205: aload_2
    //   206: invokevirtual 298	org/json/JSONObject:toString	()Ljava/lang/String;
    //   209: invokestatic 311	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: aload_2
    //   213: areturn
    //   214: astore_2
    //   215: aload_3
    //   216: astore_1
    //   217: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   220: ifeq +14 -> 234
    //   223: ldc 113
    //   225: iconst_2
    //   226: aload_2
    //   227: iconst_0
    //   228: anewarray 115	java/lang/Object
    //   231: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   234: goto -61 -> 173
    //   237: astore_1
    //   238: aload_1
    //   239: invokevirtual 350	org/json/JSONException:printStackTrace	()V
    //   242: goto -46 -> 196
    //   245: astore_3
    //   246: aload_2
    //   247: astore_1
    //   248: aload_3
    //   249: astore_2
    //   250: goto -33 -> 217
    //   253: aconst_null
    //   254: astore_1
    //   255: goto -82 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	this	aobh
    //   0	258	1	paramJSONObject	JSONObject
    //   63	150	2	localObject1	Object
    //   214	33	2	localJSONException1	JSONException
    //   249	1	2	localJSONException2	JSONException
    //   1	215	3	localObject2	Object
    //   245	4	3	localJSONException3	JSONException
    //   23	138	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   8	108	214	org/json/JSONException
    //   113	123	214	org/json/JSONException
    //   187	196	237	org/json/JSONException
    //   125	136	245	org/json/JSONException
    //   138	171	245	org/json/JSONException
  }
  
  /* Error */
  public JSONObject t(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 407	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   5: invokevirtual 408	java/util/UUID:toString	()Ljava/lang/String;
    //   8: ldc_w 410
    //   11: ldc_w 412
    //   14: invokevirtual 415	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   17: astore 4
    //   19: new 198	java/lang/StringBuilder
    //   22: dup
    //   23: ldc_w 1241
    //   26: invokespecial 254	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   29: bipush 63
    //   31: invokevirtual 257	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   34: ldc_w 1232
    //   37: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokestatic 546	java/lang/System:currentTimeMillis	()J
    //   43: invokevirtual 1137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   46: ldc_w 419
    //   49: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload 4
    //   54: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: astore_2
    //   58: aload_1
    //   59: invokestatic 394	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   62: ifne +15 -> 77
    //   65: aload_2
    //   66: ldc_w 1243
    //   69: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_1
    //   73: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: new 198	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   84: ldc_w 421
    //   87: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload 4
    //   92: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: astore_1
    //   96: aload_0
    //   97: getfield 178	aobh:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   100: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   103: aload_2
    //   104: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: ldc 87
    //   109: aload_1
    //   110: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 424	aobk:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   116: astore 4
    //   118: aload 4
    //   120: invokestatic 394	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   123: ifne +143 -> 266
    //   126: new 76	org/json/JSONObject
    //   129: dup
    //   130: aload 4
    //   132: invokespecial 95	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   135: astore_2
    //   136: aload_2
    //   137: astore_1
    //   138: aload_2
    //   139: ldc_w 306
    //   142: iconst_m1
    //   143: invokevirtual 101	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   146: ifeq +40 -> 186
    //   149: aload_2
    //   150: astore_1
    //   151: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +32 -> 186
    //   157: ldc 113
    //   159: iconst_2
    //   160: new 198	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   167: ldc_w 1245
    //   170: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload 4
    //   175: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 173	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aload_2
    //   185: astore_1
    //   186: aload_1
    //   187: astore_2
    //   188: aload_1
    //   189: ifnonnull +20 -> 209
    //   192: new 76	org/json/JSONObject
    //   195: dup
    //   196: invokespecial 77	org/json/JSONObject:<init>	()V
    //   199: astore_2
    //   200: aload_2
    //   201: ldc_w 306
    //   204: iconst_m1
    //   205: invokevirtual 245	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   208: pop
    //   209: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq +13 -> 225
    //   215: ldc 113
    //   217: iconst_2
    //   218: aload_2
    //   219: invokevirtual 298	org/json/JSONObject:toString	()Ljava/lang/String;
    //   222: invokestatic 311	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: aload_2
    //   226: areturn
    //   227: astore_2
    //   228: aload_3
    //   229: astore_1
    //   230: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   233: ifeq +14 -> 247
    //   236: ldc 113
    //   238: iconst_2
    //   239: aload_2
    //   240: iconst_0
    //   241: anewarray 115	java/lang/Object
    //   244: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   247: goto -61 -> 186
    //   250: astore_1
    //   251: aload_1
    //   252: invokevirtual 350	org/json/JSONException:printStackTrace	()V
    //   255: goto -46 -> 209
    //   258: astore_3
    //   259: aload_2
    //   260: astore_1
    //   261: aload_3
    //   262: astore_2
    //   263: goto -33 -> 230
    //   266: aconst_null
    //   267: astore_1
    //   268: goto -82 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	this	aobh
    //   0	271	1	paramString	String
    //   57	169	2	localObject1	Object
    //   227	33	2	localJSONException1	JSONException
    //   262	1	2	localJSONException2	JSONException
    //   1	228	3	localObject2	Object
    //   258	4	3	localJSONException3	JSONException
    //   17	157	4	str	String
    // Exception table:
    //   from	to	target	type
    //   2	77	227	org/json/JSONException
    //   77	136	227	org/json/JSONException
    //   200	209	250	org/json/JSONException
    //   138	149	258	org/json/JSONException
    //   151	184	258	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aobh
 * JD-Core Version:    0.7.0.1
 */