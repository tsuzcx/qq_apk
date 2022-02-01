import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.sso.cmd.TimDocSSOMsg.BatchGetReqBody;
import com.tencent.tim.sso.cmd.TimDocSSOMsg.BatchGetRspBody;
import com.tencent.tim.sso.cmd.TimDocSSOMsg.CancelPinPadReqBody;
import com.tencent.tim.sso.cmd.TimDocSSOMsg.CancelPinPadRspBody;
import com.tencent.tim.sso.cmd.TimDocSSOMsg.DeletePadReqBody;
import com.tencent.tim.sso.cmd.TimDocSSOMsg.DeletePadRspBody;
import com.tencent.tim.sso.cmd.TimDocSSOMsg.GetPadListReqBody;
import com.tencent.tim.sso.cmd.TimDocSSOMsg.GetPadListRspBody;
import com.tencent.tim.sso.cmd.TimDocSSOMsg.GetPadRightInfoReqBody;
import com.tencent.tim.sso.cmd.TimDocSSOMsg.GetPadRightInfoRspBody;
import com.tencent.tim.sso.cmd.TimDocSSOMsg.GetSharedPadListRspBody;
import com.tencent.tim.sso.cmd.TimDocSSOMsg.GetTipFlagReqBody;
import com.tencent.tim.sso.cmd.TimDocSSOMsg.GetTipFlagRspBody;
import com.tencent.tim.sso.cmd.TimDocSSOMsg.LoginInfo;
import com.tencent.tim.sso.cmd.TimDocSSOMsg.PadId;
import com.tencent.tim.sso.cmd.TimDocSSOMsg.PadInfo;
import com.tencent.tim.sso.cmd.TimDocSSOMsg.PinPadReqBody;
import com.tencent.tim.sso.cmd.TimDocSSOMsg.PinPadRspBody;
import com.tencent.tim.sso.cmd.TimDocSSOMsg.SetPadRightInfoReqBody;
import com.tencent.tim.sso.cmd.TimDocSSOMsg.SetPadRightInfoRspBody;
import com.tencent.tim.sso.cmd.TimDocSSOMsg.SetTipFlagReqBody;
import com.tencent.tim.sso.cmd.TimDocSSOMsg.SetTipFlagRspBody;
import com.tencent.tim.sso.cmd.TimDocSSOMsg.UinRightInfo;
import com.tencent.tim.teamwork.BrowsePadInfo;
import com.tencent.tim.teamwork.CreatedPadInfo;
import com.tencent.tim.teamwork.PadInfo;
import com.tencent.tim.teamwork.PadInfoForStructMsg;
import com.tencent.tim.teamwork.ReSendCmd;
import com.tencent.tim.teamwork.SharedPadInfo;
import com.tencent.tim.teamwork.TeamWorkHandler.1;
import com.tencent.tim.teamwork.TeamWorkHandler.4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.request.Ticket;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xae9.online_docs.DocId;
import tencent.im.oidb.cmd0xb05.cmd0xb05.CreateReq;
import tencent.im.oidb.cmd0xb05.cmd0xb05.CreateRsp;
import tencent.im.oidb.cmd0xb05.cmd0xb05.ReqBody;
import tencent.im.oidb.cmd0xb05.cmd0xb05.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class aulh
  extends accg
{
  public static long ayT;
  private static String cIy = "key_get_all_list";
  private static String cIz = "get_all_list_flag";
  private static String cjJ;
  public static String cjS = "https://docs.qq.com/desktop/m/index.html?_wv=2";
  private static String ckp;
  public boolean aeg;
  private SparseIntArray ag = new SparseIntArray();
  public long ayP;
  public long ayQ;
  public long ayR;
  public long ayS;
  public boolean cLc;
  private volatile int dNV;
  private volatile int dNW;
  private boolean dje;
  private Set<String> du = Collections.synchronizedSet(new HashSet());
  private Runnable iu = new TeamWorkHandler.1(this);
  private ConcurrentHashMap<String, Integer> jM = new ConcurrentHashMap();
  
  static
  {
    cjJ = "key_type_list";
    ckp = "key_type_operation";
  }
  
  public aulh(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.cLc = aqmj.c(paramAppInterface.getApp(), paramAppInterface.getCurrentAccountUin(), "tencent_docs_config_enable_assistant", false);
    this.aeg = aqmj.c(paramAppInterface.getApp(), paramAppInterface.getCurrentAccountUin(), "tencent_docs_config_preload_tool_process", false);
  }
  
  public aulh(QQAppInterface paramQQAppInterface)
  {
    this(paramQQAppInterface);
  }
  
  private void U(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg = paramToServiceMsg.getServiceCmd();
      if (QLog.isColorLevel()) {
        QLog.i("TeamWorkHandler_T", 2, " handleGetPadListRspNew remove cmd: " + paramToServiceMsg);
      }
      if (!TextUtils.isEmpty(paramToServiceMsg)) {
        this.du.remove(paramToServiceMsg);
      }
    }
  }
  
  private String a(ReSendCmd paramReSendCmd)
  {
    TicketManager localTicketManager = (TicketManager)this.mApp.getManager(2);
    if (localTicketManager != null)
    {
      paramReSendCmd = localTicketManager.GetSkey(this.mApp.getCurrentAccountUin(), 16L, new aulj(this, localTicketManager, paramReSendCmd));
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
      auli localauli = new auli(this, (TicketManager)localObject, paramReSendCmd);
      localObject = ((TicketManager)localObject).GetPskey(str, 16L, new String[] { "docs.qq.com" }, localauli);
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
  
  public static void a(AppInterface paramAppInterface, String paramString, aulh.a parama)
  {
    ThreadManager.executeOnNetWorkThread(new TeamWorkHandler.4(paramAppInterface, paramString, parama));
  }
  
  public static void a(PadInfo paramPadInfo, TimDocSSOMsg.PadInfo paramPadInfo1)
  {
    if ((paramPadInfo != null) && (paramPadInfo1 != null)) {}
    for (;;)
    {
      try
      {
        paramPadInfo.domainId = paramPadInfo1.uint32_domainid.get();
        if (paramPadInfo1.bytes_localpadid.has())
        {
          str = paramPadInfo1.bytes_localpadid.get().toStringUtf8();
          paramPadInfo.padId = str;
          if (!paramPadInfo1.bytes_pad_url.has()) {
            break label430;
          }
          str = paramPadInfo1.bytes_pad_url.get().toStringUtf8();
          paramPadInfo.pad_url = str;
          paramPadInfo.type = paramPadInfo1.uint32_type.get();
          if (!paramPadInfo1.bytes_title.has()) {
            break label437;
          }
          str = paramPadInfo1.bytes_title.get().toStringUtf8();
          paramPadInfo.title = str;
          paramPadInfo.createTime = paramPadInfo1.uint64_create_time.get();
          paramPadInfo.creatorUin = paramPadInfo1.uint64_creator_uin.get();
          if (!paramPadInfo1.bytes_creator_nick.has()) {
            break label444;
          }
          str = paramPadInfo1.bytes_creator_nick.get().toStringUtf8();
          paramPadInfo.creatorNick = str;
          paramPadInfo.lastEditorUin = paramPadInfo1.uint64_last_editor_uin.get();
          if (!paramPadInfo1.bytes_last_editor_nick.has()) {
            break label451;
          }
          str = paramPadInfo1.bytes_last_editor_nick.get().toStringUtf8();
          paramPadInfo.lastEditorNick = str;
          paramPadInfo.lastEditTime = paramPadInfo1.uint64_last_edit_time.get();
          paramPadInfo.pinedFlag = paramPadInfo1.bool_pinned_flag.get();
          paramPadInfo.lastViewerUin = paramPadInfo1.uint64_last_viewer_uin.get();
          if (!paramPadInfo1.bytes_last_viewer_nick.has()) {
            break label458;
          }
          str = paramPadInfo1.bytes_last_viewer_nick.get().toStringUtf8();
          paramPadInfo.lastViewerNick = str;
          paramPadInfo.lastViewTime = paramPadInfo1.uint64_last_view_time.get();
          paramPadInfo.lastPinnedTime = paramPadInfo1.uint64_last_pinned_time.get();
          paramPadInfo.currentUserBrowseTime = paramPadInfo1.uint64_current_user_browse_time.get();
          paramPadInfo.shardUin = paramPadInfo1.uint64_hostuser_uin.get();
          if (!paramPadInfo1.bytes_hostuser_nick.has()) {
            break label465;
          }
          str = paramPadInfo1.bytes_hostuser_nick.get().toStringUtf8();
          paramPadInfo.shardNick = str;
          paramPadInfo.lastshardTime = paramPadInfo1.uint64_last_auth_time.get();
          paramPadInfo.policy = paramPadInfo1.uint32_policy.get();
          paramPadInfo.lastUnPinnedTime = paramPadInfo1.uint64_last_unpinned_time.get();
          paramPadInfo.itemDeleteFlag = paramPadInfo1.bool_delete_flag.get();
          paramPadInfo.itemLateDeleteTime = paramPadInfo1.uint64_last_delete_time.get();
          if (paramPadInfo1.bytes_thumb_url.has())
          {
            paramPadInfo1 = paramPadInfo1.bytes_thumb_url.get().toStringUtf8();
            paramPadInfo.thumbUrl = paramPadInfo1;
          }
        }
        else
        {
          str = "";
          continue;
        }
        paramPadInfo1 = "";
        continue;
        str = "";
      }
      finally {}
      label430:
      continue;
      label437:
      String str = "";
      continue;
      label444:
      str = "";
      continue;
      label451:
      str = "";
      continue;
      label458:
      str = "";
      continue;
      label465:
      str = "";
    }
  }
  
  private void a(ReSendCmd paramReSendCmd)
  {
    if (paramReSendCmd != null)
    {
      QLog.i("TeamWorkHandler", 1, " reTrySendCmd retry cmd：" + paramReSendCmd.cmd);
      if (paramReSendCmd.cmd != 1) {
        break label62;
      }
      e(paramReSendCmd.dNF, paramReSendCmd.dNG, paramReSendCmd.djb, paramReSendCmd.djc);
    }
    label62:
    do
    {
      do
      {
        return;
        if (paramReSendCmd.cmd == 2)
        {
          Zq(paramReSendCmd.cjb);
          return;
        }
        if (paramReSendCmd.cmd == 3)
        {
          Zr(paramReSendCmd.cjb);
          return;
        }
        if (paramReSendCmd.cmd == 4)
        {
          eq(paramReSendCmd.dNH, paramReSendCmd.cjb);
          return;
        }
        if (paramReSendCmd.cmd == 5)
        {
          er(paramReSendCmd.dNH, paramReSendCmd.cjb);
          return;
        }
        if (paramReSendCmd.cmd == 6)
        {
          e(paramReSendCmd.dNF, paramReSendCmd.dNG, paramReSendCmd.djb, paramReSendCmd.djc);
          return;
        }
        if (paramReSendCmd.cmd == 9)
        {
          dL(paramReSendCmd.dNH, paramReSendCmd.cjb);
          return;
        }
        if (paramReSendCmd.cmd == 8)
        {
          Zs(paramReSendCmd.cjb);
          return;
        }
        if (paramReSendCmd.cmd == 10)
        {
          aaQ(1);
          return;
        }
        if (paramReSendCmd.cmd == 11)
        {
          kV(1, 1);
          return;
        }
      } while (12 != paramReSendCmd.cmd);
      if (paramReSendCmd.dNI == 0)
      {
        nY(paramReSendCmd.GP);
        return;
      }
    } while (paramReSendCmd.dNI != 1);
    b(paramReSendCmd);
  }
  
  private static void a(String paramString, aulh.a parama)
  {
    try
    {
      QLog.d("TeamWorkHandler", 1, "file_app: result= " + paramString);
      if (paramString != null)
      {
        QLog.d("TeamWorkHandler", 2, paramString);
        JSONObject localJSONObject = new JSONObject(paramString);
        int i = localJSONObject.getInt("retcode");
        localJSONObject.optString("msg");
        if (i == 0)
        {
          paramString = (JSONObject)localJSONObject.get("storage");
          long l1 = paramString.getLong("total");
          long l2 = paramString.getLong("used");
          if (parama == null) {
            return;
          }
          parama.b(Long.valueOf(l1), Long.valueOf(l2));
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.e("TeamWorkHandler", 2, "handleStorageSize: " + paramString);
        }
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TeamWorkHandler", 2, paramString, new Object[0]);
        }
      }
    }
    if (parama != null)
    {
      parama.onError("");
      return;
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
  
  private void b(ReSendCmd paramReSendCmd)
  {
    if (paramReSendCmd != null) {}
    for (;;)
    {
      Object localObject1;
      TimDocSSOMsg.BatchGetReqBody localBatchGetReqBody;
      try
      {
        boolean bool = TextUtils.isEmpty(paramReSendCmd.cjb);
        if (bool) {
          return;
        }
        localObject1 = new ArrayList();
        ((List)localObject1).add(paramReSendCmd.cjb);
        paramReSendCmd.cmd = 12;
        paramReSendCmd.GP = ((List)localObject1);
        Object localObject2 = a("batchGetPadInfo", paramReSendCmd);
        if (localObject2 == null) {
          continue;
        }
        localBatchGetReqBody = new TimDocSSOMsg.BatchGetReqBody();
        localBatchGetReqBody.msg_login_info.set((MessageMicro)localObject2);
        localBatchGetReqBody.uint32_appid.set(2);
        localObject1 = ((List)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          TimDocSSOMsg.PadId localPadId = new TimDocSSOMsg.PadId();
          localPadId.bytes_pad_url.set(ByteStringMicro.copyFromUtf8((String)localObject2));
          localBatchGetReqBody.rpt_msg_padid_list.add(localPadId);
          continue;
        }
        localObject1 = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "TimDocSvc.BatchGetPadInfo");
      }
      finally {}
      ((ToServiceMsg)localObject1).putWupBuffer(localBatchGetReqBody.toByteArray());
      ((ToServiceMsg)localObject1).extraData.putParcelable("key_resend_cmd", paramReSendCmd);
      sendPbReq((ToServiceMsg)localObject1);
      if (QLog.isColorLevel()) {
        QLog.i("TeamWorkHandler_T", 2, "getPadInfoUrlStructMsg sendCmd.padUrl" + paramReSendCmd.cjb);
      }
    }
  }
  
  /* Error */
  private boolean b(ReSendCmd paramReSendCmd)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +109 -> 112
    //   6: aload_1
    //   7: getfield 476	com/tencent/tim/teamwork/ReSendCmd:cjb	Ljava/lang/String;
    //   10: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +99 -> 112
    //   16: aload_0
    //   17: getfield 81	aulh:jM	Ljava/util/concurrent/ConcurrentHashMap;
    //   20: aload_1
    //   21: getfield 476	com/tencent/tim/teamwork/ReSendCmd:cjb	Ljava/lang/String;
    //   24: invokevirtual 694	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 696	java/lang/Integer
    //   30: astore 4
    //   32: aload 4
    //   34: ifnull +20 -> 54
    //   37: aload 4
    //   39: invokevirtual 699	java/lang/Integer:intValue	()I
    //   42: istore_2
    //   43: iload_2
    //   44: iconst_3
    //   45: if_icmplt +9 -> 54
    //   48: iconst_0
    //   49: istore_3
    //   50: aload_0
    //   51: monitorexit
    //   52: iload_3
    //   53: ireturn
    //   54: aload_0
    //   55: aload_1
    //   56: iconst_1
    //   57: invokespecial 590	aulh:a	(Lcom/tencent/tim/teamwork/ReSendCmd;Z)Ljava/lang/String;
    //   60: astore 4
    //   62: aload 4
    //   64: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   67: ifne +40 -> 107
    //   70: aload 4
    //   72: invokevirtual 593	java/lang/String:length	()I
    //   75: ifle +32 -> 107
    //   78: ldc 199
    //   80: iconst_1
    //   81: new 135	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   88: ldc_w 701
    //   91: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_1
    //   95: getfield 455	com/tencent/tim/teamwork/ReSendCmd:cmd	I
    //   98: invokevirtual 458	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   101: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 149	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   107: iconst_1
    //   108: istore_3
    //   109: goto -59 -> 50
    //   112: iconst_0
    //   113: istore_3
    //   114: goto -64 -> 50
    //   117: astore_1
    //   118: aload_0
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	aulh
    //   0	122	1	paramReSendCmd	ReSendCmd
    //   42	4	2	i	int
    //   49	65	3	bool	boolean
    //   30	41	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	32	117	finally
    //   37	43	117	finally
    //   54	107	117	finally
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
  
  private void lX(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int m;
    boolean bool6;
    boolean bool5;
    boolean bool7;
    boolean bool4;
    for (;;)
    {
      int n;
      String str;
      ArrayList localArrayList;
      try
      {
        bool1 = paramFromServiceMsg.isSuccess();
        n = ((Integer)paramToServiceMsg.getAttribute(cjJ)).intValue();
        m = ((Integer)paramToServiceMsg.getAttribute(ckp)).intValue();
        str = paramToServiceMsg.extraData.getString(cIy, "");
        j = 0;
        i = 0;
        bool6 = false;
        bool5 = false;
        bool7 = false;
        bool4 = false;
        localArrayList = new ArrayList();
        if (QLog.isColorLevel()) {
          QLog.i("TeamWorkHandler", 2, " handleGetPadListRspNew typeList " + n + ",typeOperation " + m);
        }
        if (!bool1) {
          break label2156;
        }
        paramFromServiceMsg = new TimDocSSOMsg.GetPadListRspBody();
        try
        {
          paramFromServiceMsg.mergeFrom((byte[])paramObject);
          bool2 = bool1;
        }
        catch (Exception paramObject)
        {
          QLog.e("TeamWorkHandler", 1, " handleGetPadListRsp exception: " + paramObject.toString());
          bool2 = false;
          continue;
        }
        if (!bool2) {
          break;
        }
        i = paramFromServiceMsg.uint32_retcode.get();
        j = paramFromServiceMsg.uint32_total_count.get();
        paramObject = paramFromServiceMsg.bytes_timestamp.get().toStringUtf8();
        bool3 = paramFromServiceMsg.bool_endflag.get();
        if (paramFromServiceMsg.uint32_auto_fresh_interval.has())
        {
          k = paramFromServiceMsg.uint32_auto_fresh_interval.get();
          if (ayT != k)
          {
            ayT = k;
            aull.p(this.app.getApp(), this.app.getCurrentAccountUin(), "key_teamwork_auto_fresh_interval_time", k);
          }
          if (str.equals(cIz)) {
            this.ayS = System.currentTimeMillis();
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("TeamWorkHandler", 2, " handleGetPadListRspNew  retCode: " + i + ",isEnd: " + bool3);
          }
          if (i <= 10000) {
            break label713;
          }
          bool1 = false;
          QLog.e("TeamWorkHandler", 1, " error handleGetPadListRspNew: retCode: " + i + ",isEnd: " + bool3);
          bool6 = bool7;
          bool5 = bool3;
          bool7 = bool1;
          if (i != 200011) {
            break label2523;
          }
          bool1 = a((ReSendCmd)paramToServiceMsg.extraData.getParcelable("key_resend_cmd"));
          if (!bool1) {
            break label2383;
          }
          return;
        }
        if (n == 1)
        {
          this.ayQ = System.currentTimeMillis();
          continue;
        }
        if (n != 3) {
          break label484;
        }
      }
      finally {}
      this.ayR = System.currentTimeMillis();
      continue;
      label484:
      this.ayP = System.currentTimeMillis();
      continue;
      label494:
      if ((bool4 == true) && (!bool1)) {
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          i = 3;
          if (str.equals(cIz))
          {
            e(n, 3, false, true);
            if (QLog.isColorLevel()) {
              QLog.i("TeamWorkHandler", 2, " handleGetPadListRspNew mIsGetAll: " + this.dje);
            }
            if ((this.dje) && (bool1))
            {
              if (n != 2) {
                break label2243;
              }
              if (QLog.isColorLevel()) {
                QLog.i("TeamWorkHandler", 2, " handleGetPadListRspNew getAllList next: 1");
              }
              e(1, 1, false, true);
            }
          }
        }
      }
      for (;;)
      {
        label543:
        if (!this.dje) {
          break label2299;
        }
        if ((!bool1) || (n != 5)) {
          break label2429;
        }
        label640:
        this.dje = false;
        notifyUI(1, bool4, new Object[] { Integer.valueOf(4), Integer.valueOf(k), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(i), localArrayList });
        break;
        label713:
        this.ag.put(1, 0);
        if ((i == 0) || (i == 5) || (i == 6))
        {
          paramFromServiceMsg = paramFromServiceMsg.rpt_msg_pad_list.get();
          if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
          {
            Iterator localIterator = paramFromServiceMsg.iterator();
            if (localIterator.hasNext())
            {
              TimDocSSOMsg.PadInfo localPadInfo = (TimDocSSOMsg.PadInfo)localIterator.next();
              if (n == 1) {
                paramFromServiceMsg = new CreatedPadInfo();
              }
              for (;;)
              {
                a(paramFromServiceMsg, localPadInfo);
                paramFromServiceMsg.type_list = n;
                localArrayList.add(paramFromServiceMsg);
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.i("TeamWorkHandler", 2, " handleGetPadListRspNew localPadInfo: " + paramFromServiceMsg.toString());
                break;
                if (n == 3) {
                  paramFromServiceMsg = new SharedPadInfo();
                } else if (n == 5) {
                  paramFromServiceMsg = new PadInfoForStructMsg();
                } else {
                  paramFromServiceMsg = new BrowsePadInfo();
                }
              }
            }
          }
        }
        paramFromServiceMsg = (aull)this.app.getManager(372);
        if ((i != 0) && (i != 3)) {
          break label2468;
        }
        if (i == 3) {
          paramFromServiceMsg.aaR(n);
        }
        if (n != 5) {
          break label2453;
        }
        paramFromServiceMsg.oa(localArrayList);
        while (n == 1)
        {
          bool1 = bool5;
          bool4 = bool3;
          if (aull.g(this.app.getApp(), this.app.getCurrentAccountUin(), "key_teamwork_created_timestamp_appid2", "").equals(paramObject)) {
            break label2437;
          }
          bool1 = true;
          aull.x(this.app.getApp(), this.app.getCurrentAccountUin(), "key_teamwork_created_timestamp_appid2", paramObject);
          bool4 = bool3;
          break label2437;
          label1033:
          paramFromServiceMsg.evB();
          label1037:
          if (n != 2) {
            break label2046;
          }
          aull.ao(this.app.getApp(), this.app.getCurrentAccountUin(), "key_team_work_browse_refresh_time");
          k = i;
          bool5 = bool2;
          i = j;
          bool3 = bool1;
          bool2 = bool4;
          j = k;
          bool1 = bool5;
          break label2406;
          label1094:
          paramFromServiceMsg.c(2, localArrayList, n);
          continue;
          if (m == 3) {
            paramFromServiceMsg.c(1, localArrayList, n);
          }
        }
        if (n == 2)
        {
          bool1 = bool5;
          bool4 = bool3;
          if (aull.g(this.app.getApp(), this.app.getCurrentAccountUin(), "key_teamwork_browse_timestamp_appid2", "").equals(paramObject)) {
            break label2437;
          }
          bool1 = true;
          aull.x(this.app.getApp(), this.app.getCurrentAccountUin(), "key_teamwork_browse_timestamp_appid2", paramObject);
          bool4 = bool3;
          break label2437;
        }
        bool1 = bool5;
        bool4 = bool3;
        if (n != 3) {
          break label2437;
        }
        bool1 = bool5;
        bool4 = bool3;
        if (aull.g(this.app.getApp(), this.app.getCurrentAccountUin(), "key_teamwork_shared_timestamp_appid2", "").equals(paramObject)) {
          break label2437;
        }
        bool1 = true;
        aull.x(this.app.getApp(), this.app.getCurrentAccountUin(), "key_teamwork_shared_timestamp_appid2", paramObject);
        bool4 = bool3;
        break label2437;
        label1282:
        k = 0;
        if (n == 2)
        {
          k = paramFromServiceMsg.OG();
          break label2483;
        }
        if (n != 1) {
          break label2483;
        }
        k = paramFromServiceMsg.OF();
        break label2483;
        label1315:
        if (i == 5)
        {
          bool1 = bool5;
          bool4 = bool3;
          if (localArrayList == null) {
            break label2437;
          }
          bool1 = bool5;
          bool4 = bool3;
          if (localArrayList.size() <= 0) {
            break label2437;
          }
          if (n == 5) {
            paramFromServiceMsg.oa(localArrayList);
          }
          while (n == 1)
          {
            bool1 = bool5;
            bool4 = bool3;
            if (aull.g(this.app.getApp(), this.app.getCurrentAccountUin(), "key_teamwork_created_timestamp_appid2", "").equals(paramObject)) {
              break label2437;
            }
            bool1 = true;
            aull.x(this.app.getApp(), this.app.getCurrentAccountUin(), "key_teamwork_created_timestamp_appid2", paramObject);
            bool4 = bool3;
            break label2437;
            paramFromServiceMsg.nZ(localArrayList);
          }
          if (n == 2)
          {
            bool1 = bool5;
            bool4 = bool3;
            if (aull.g(this.app.getApp(), this.app.getCurrentAccountUin(), "key_teamwork_browse_timestamp_appid2", "").equals(paramObject)) {
              break label2437;
            }
            bool1 = true;
            aull.x(this.app.getApp(), this.app.getCurrentAccountUin(), "key_teamwork_browse_timestamp_appid2", paramObject);
            bool4 = bool3;
            break label2437;
          }
          if (n == 3)
          {
            bool1 = bool5;
            bool4 = bool3;
            if (aull.g(this.app.getApp(), this.app.getCurrentAccountUin(), "key_teamwork_shared_timestamp_appid2", "").equals(paramObject)) {
              break label2437;
            }
            bool1 = true;
            aull.x(this.app.getApp(), this.app.getCurrentAccountUin(), "key_teamwork_shared_timestamp_appid2", paramObject);
            bool4 = bool3;
            break label2437;
          }
          bool1 = bool5;
          bool4 = bool3;
          if (n != 5) {
            break label2437;
          }
          bool1 = bool5;
          bool4 = bool3;
          if (aull.g(this.app.getApp(), this.app.getCurrentAccountUin(), "key_teamwork_pin_items_in_all_timestamp_appid2", "").equals(paramObject)) {
            break label2437;
          }
          bool1 = true;
          aull.x(this.app.getApp(), this.app.getCurrentAccountUin(), "key_teamwork_pin_items_in_all_timestamp_appid2", paramObject);
          bool4 = bool3;
          break label2437;
        }
        bool1 = bool5;
        bool4 = bool3;
        if (i != 6) {
          break label2437;
        }
        if (n != 5) {
          break label2508;
        }
        paramFromServiceMsg.oa(localArrayList);
        label1707:
        while (n == 1)
        {
          bool1 = bool5;
          bool4 = bool3;
          if (aull.g(this.app.getApp(), this.app.getCurrentAccountUin(), "key_teamwork_created_timestamp_appid2", "").equals(paramObject)) {
            break label2437;
          }
          bool1 = true;
          aull.x(this.app.getApp(), this.app.getCurrentAccountUin(), "key_teamwork_created_timestamp_appid2", paramObject);
          bool4 = bool3;
          break label2437;
          label1783:
          paramFromServiceMsg.c(2, localArrayList, n);
          continue;
          if (m == 3) {
            paramFromServiceMsg.c(1, localArrayList, n);
          }
        }
        if (n == 2)
        {
          bool1 = bool5;
          bool4 = bool3;
          if (aull.g(this.app.getApp(), this.app.getCurrentAccountUin(), "key_teamwork_browse_timestamp_appid2", "").equals(paramObject)) {
            break label2437;
          }
          bool1 = true;
          aull.x(this.app.getApp(), this.app.getCurrentAccountUin(), "key_teamwork_browse_timestamp_appid2", paramObject);
          bool4 = bool3;
          break label2437;
        }
        if (n == 3)
        {
          bool1 = bool5;
          bool4 = bool3;
          if (aull.g(this.app.getApp(), this.app.getCurrentAccountUin(), "key_teamwork_shared_timestamp_appid2", "").equals(paramObject)) {
            break label2437;
          }
          bool1 = true;
          aull.x(this.app.getApp(), this.app.getCurrentAccountUin(), "key_teamwork_shared_timestamp_appid2", paramObject);
          bool4 = bool3;
          break label2437;
        }
        bool1 = bool5;
        bool4 = bool3;
        if (n != 5) {
          break label2437;
        }
        bool1 = bool5;
        bool4 = bool3;
        if (aull.g(this.app.getApp(), this.app.getCurrentAccountUin(), "key_teamwork_pin_items_in_all_timestamp_appid2", "").equals(paramObject)) {
          break label2437;
        }
        bool1 = true;
        aull.x(this.app.getApp(), this.app.getCurrentAccountUin(), "key_teamwork_pin_items_in_all_timestamp_appid2", paramObject);
        bool4 = bool3;
        break label2437;
        label2046:
        if (n == 1)
        {
          aull.ao(this.app.getApp(), this.app.getCurrentAccountUin(), "key_team_work_created_refresh_time");
          k = i;
          bool5 = bool2;
          i = j;
          bool3 = bool1;
          bool2 = bool4;
          j = k;
          bool1 = bool5;
          break label2406;
        }
        bool6 = bool1;
        bool5 = bool4;
        bool7 = bool2;
        if (n != 3) {
          break label2523;
        }
        aull.ao(this.app.getApp(), this.app.getCurrentAccountUin(), "key_team_work_shared_refresh_time");
        bool6 = bool1;
        bool5 = bool4;
        bool7 = bool2;
        break label2523;
        label2156:
        QLog.i("TeamWorkHandler", 1, " handleGetPadListRsp faied code: " + paramFromServiceMsg.getResultCode());
        bool4 = bool1;
        k = 0;
        j = 0;
        bool1 = false;
        bool2 = false;
        break label494;
        e(n, 3, false, false);
        break label543;
        bool1 = true;
        U(paramToServiceMsg);
        i = m;
        break label543;
        U(paramToServiceMsg);
        i = m;
        break label543;
        label2243:
        if (n == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.i("TeamWorkHandler", 2, " handleGetPadListRspNew getAllList next: 5");
          }
          e(5, 1, false, true);
        }
        else if ((n == 5) && (QLog.isColorLevel()))
        {
          QLog.i("TeamWorkHandler", 2, " handleGetPadListRspNew getAllList finish.");
        }
      }
      label2299:
      notifyUI(1, bool4, new Object[] { Integer.valueOf(n), Integer.valueOf(k), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(i), localArrayList });
    }
    boolean bool1 = bool2;
    boolean bool3 = bool4;
    boolean bool2 = bool6;
    break label2406;
    label2383:
    int k = j;
    bool1 = false;
    int j = i;
    bool2 = bool3;
    bool3 = bool4;
    int i = k;
    for (;;)
    {
      label2406:
      bool4 = bool1;
      k = j;
      bool1 = bool2;
      bool2 = bool3;
      j = i;
      break;
      label2429:
      if (bool4) {
        break label2299;
      }
      break label640;
      for (;;)
      {
        label2437:
        if (i == 5) {
          break label2506;
        }
        if (i != 6) {
          break label1037;
        }
        break label1033;
        label2453:
        if (m == 1) {
          break label1094;
        }
        if (m != 2) {
          break;
        }
        break label1094;
        label2468:
        if (i == 1) {
          break label1282;
        }
        if (i != 2) {
          break label1315;
        }
        break label1282;
        label2483:
        bool1 = bool5;
        bool4 = bool3;
        if (j == k)
        {
          bool4 = true;
          bool1 = bool5;
        }
      }
      label2506:
      break label1033;
      label2508:
      if (m == 1) {
        break label1783;
      }
      if (m != 2) {
        break label1707;
      }
      break label1783;
      label2523:
      k = i;
      bool1 = bool7;
      i = j;
      bool3 = bool6;
      bool2 = bool5;
      j = k;
    }
  }
  
  private void lY(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = paramFromServiceMsg.isSuccess();
    int m = ((Integer)paramToServiceMsg.getAttribute(ckp)).intValue();
    boolean bool3 = false;
    boolean bool2 = false;
    paramFromServiceMsg = new ArrayList();
    if (QLog.isColorLevel()) {
      QLog.i("TeamWorkHandler", 2, " handleGetSharedPadListRsp ,typeOperation " + m);
    }
    aull localaull = (aull)this.app.getManager(372);
    int j;
    int i;
    if (!bool1)
    {
      j = 0;
      i = 0;
    }
    label107:
    int k;
    for (;;)
    {
      if (localaull.OH() == i)
      {
        bool3 = true;
        notifyUI(1, bool1, new Object[] { Integer.valueOf(3), Integer.valueOf(j), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(i), Integer.valueOf(m), paramFromServiceMsg });
        label171:
        return;
        bool1 = false;
        Object localObject = new TimDocSSOMsg.GetSharedPadListRspBody();
        try
        {
          ((TimDocSSOMsg.GetSharedPadListRspBody)localObject).mergeFrom((byte[])paramObject);
          i = ((TimDocSSOMsg.GetSharedPadListRspBody)localObject).uint32_retcode.get();
          if (i <= 10000) {
            break label333;
          }
          QLog.e("TeamWorkHandler", 1, " error handleGetPadListRsp: retCode: " + i + ",totalCount: " + 0);
          if ((i == 200011) && (a((ReSendCmd)paramToServiceMsg.extraData.getParcelable("key_resend_cmd")))) {
            break label171;
          }
          k = 0;
          j = i;
          i = k;
        }
        catch (Exception paramToServiceMsg)
        {
          QLog.i("TeamWorkHandler", 1, " handleGetSharedPadListRsp exception: " + paramToServiceMsg.toString());
          j = 0;
          i = 0;
        }
        continue;
        label333:
        k = ((TimDocSSOMsg.GetSharedPadListRspBody)localObject).uint32_total_count.get();
        j = ((TimDocSSOMsg.GetSharedPadListRspBody)localObject).uint32_timestamp.get();
        if (QLog.isColorLevel()) {
          QLog.i("TeamWorkHandler", 2, " handleGetPadListRsp  retCode: " + i + ",totalCount: " + k);
        }
        paramToServiceMsg = ((TimDocSSOMsg.GetSharedPadListRspBody)localObject).rpt_msg_pad_list.get();
        bool1 = bool3;
        if (paramToServiceMsg != null)
        {
          bool1 = bool3;
          if (paramToServiceMsg.size() > 0)
          {
            paramObject = paramToServiceMsg.iterator();
            if (paramObject.hasNext())
            {
              TimDocSSOMsg.PadInfo localPadInfo = (TimDocSSOMsg.PadInfo)paramObject.next();
              localObject = new SharedPadInfo();
              if (localPadInfo.bytes_pad_url.has())
              {
                paramToServiceMsg = localPadInfo.bytes_pad_url.get().toStringUtf8();
                label486:
                ((PadInfo)localObject).pad_url = paramToServiceMsg;
                ((PadInfo)localObject).type = localPadInfo.uint32_type.get();
                if (!localPadInfo.bytes_title.has()) {
                  break label899;
                }
                paramToServiceMsg = localPadInfo.bytes_title.get().toStringUtf8();
                label528:
                ((PadInfo)localObject).title = paramToServiceMsg;
                ((PadInfo)localObject).createTime = localPadInfo.uint64_create_time.get();
                ((PadInfo)localObject).creatorUin = localPadInfo.uint64_creator_uin.get();
                if (!localPadInfo.bytes_creator_nick.has()) {
                  break label906;
                }
                paramToServiceMsg = localPadInfo.bytes_creator_nick.get().toStringUtf8();
                label583:
                ((PadInfo)localObject).creatorNick = paramToServiceMsg;
                ((PadInfo)localObject).lastEditorUin = localPadInfo.uint64_last_editor_uin.get();
                if (!localPadInfo.bytes_last_editor_nick.has()) {
                  break label913;
                }
                paramToServiceMsg = localPadInfo.bytes_last_editor_nick.get().toStringUtf8();
                label625:
                ((PadInfo)localObject).lastEditorNick = paramToServiceMsg;
                ((PadInfo)localObject).lastEditTime = localPadInfo.uint64_last_edit_time.get();
                ((PadInfo)localObject).pinedFlag = localPadInfo.bool_pinned_flag.get();
                ((PadInfo)localObject).lastViewerUin = localPadInfo.uint64_last_viewer_uin.get();
                if (!localPadInfo.bytes_last_viewer_nick.has()) {
                  break label920;
                }
                paramToServiceMsg = localPadInfo.bytes_last_viewer_nick.get().toStringUtf8();
                label693:
                ((PadInfo)localObject).lastViewerNick = paramToServiceMsg;
                ((PadInfo)localObject).lastViewTime = localPadInfo.uint64_last_view_time.get();
                ((PadInfo)localObject).lastPinnedTime = localPadInfo.uint64_last_pinned_time.get();
                ((PadInfo)localObject).currentUserBrowseTime = localPadInfo.uint64_current_user_browse_time.get();
                ((PadInfo)localObject).shardUin = localPadInfo.uint64_hostuser_uin.get();
                if (!localPadInfo.bytes_hostuser_nick.has()) {
                  break label927;
                }
                paramToServiceMsg = localPadInfo.bytes_hostuser_nick.get().toStringUtf8();
                label774:
                ((PadInfo)localObject).shardNick = paramToServiceMsg;
                ((PadInfo)localObject).lastshardTime = localPadInfo.uint64_last_auth_time.get();
                ((PadInfo)localObject).policy = localPadInfo.uint32_policy.get();
                ((PadInfo)localObject).lastUnPinnedTime = localPadInfo.uint64_last_unpinned_time.get();
                ((PadInfo)localObject).itemDeleteFlag = localPadInfo.bool_delete_flag.get();
                ((PadInfo)localObject).itemLateDeleteTime = localPadInfo.uint64_last_delete_time.get();
                if (!localPadInfo.bytes_thumb_url.has()) {
                  break label934;
                }
              }
              label899:
              label906:
              label913:
              label920:
              label927:
              label934:
              for (paramToServiceMsg = localPadInfo.bytes_thumb_url.get().toStringUtf8();; paramToServiceMsg = "")
              {
                ((PadInfo)localObject).thumbUrl = paramToServiceMsg;
                ((PadInfo)localObject).type_list = 3;
                paramFromServiceMsg.add(localObject);
                break;
                paramToServiceMsg = "";
                break label486;
                paramToServiceMsg = "";
                break label528;
                paramToServiceMsg = "";
                break label583;
                paramToServiceMsg = "";
                break label625;
                paramToServiceMsg = "";
                break label693;
                paramToServiceMsg = "";
                break label774;
              }
            }
            if ((i == 3) && (k == 0)) {
              localaull.aaR(3);
            }
            bool1 = bool3;
            if (i == 0)
            {
              if ((m != 1) && (m != 2)) {
                break label1080;
              }
              localaull.c(2, paramFromServiceMsg, 3);
              label987:
              if (aull.b(this.app.getApp(), this.app.getCurrentAccountUin(), "key_teamwork_shared_timestamp", 0) == j) {
                break label1103;
              }
              bool1 = true;
              aull.o(this.app.getApp(), this.app.getCurrentAccountUin(), "key_teamwork_shared_timestamp", j);
            }
          }
        }
      }
    }
    for (;;)
    {
      aull.ao(this.app.getApp(), this.app.getCurrentAccountUin(), "key_team_work_shared_refresh_time");
      j = i;
      bool3 = true;
      i = k;
      bool2 = bool1;
      bool1 = bool3;
      break;
      label1080:
      if (m != 3) {
        break label987;
      }
      localaull.c(1, paramFromServiceMsg, 3);
      break label987;
      bool3 = false;
      break label107;
      label1103:
      bool1 = false;
    }
  }
  
  private void mf(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = paramFromServiceMsg.isSuccess();
    String str = "";
    if (QLog.isColorLevel()) {
      QLog.i("TeamWorkHandler", 2, " handleDeleteSharedPadRsp ,resultCode: " + paramFromServiceMsg.getResultCode());
    }
    TimDocSSOMsg.DeletePadRspBody localDeletePadRspBody;
    if (bool1) {
      localDeletePadRspBody = new TimDocSSOMsg.DeletePadRspBody();
    }
    for (;;)
    {
      try
      {
        localDeletePadRspBody.mergeFrom((byte[])paramObject);
        paramFromServiceMsg = str;
        bool2 = bool1;
        if (bool1)
        {
          i = localDeletePadRspBody.uint32_retcode.get();
          paramFromServiceMsg = localDeletePadRspBody.bytes_pad_url.get().toStringUtf8();
          if ((i == 0) && (localDeletePadRspBody.uint32_retcode.has()))
          {
            paramToServiceMsg = (aull)this.app.getManager(372);
            if (paramToServiceMsg != null)
            {
              paramToServiceMsg.gQ(paramFromServiceMsg, 3);
              e(2, 3, false, false);
            }
            if (QLog.isColorLevel()) {
              QLog.i("TeamWorkHandler", 2, " handleDeleteSharedPadRsp delete url : " + paramFromServiceMsg + ",retCode: " + i);
            }
            bool2 = bool1;
          }
        }
        else
        {
          notifyUI(2, bool2, new Object[] { Integer.valueOf(3), paramFromServiceMsg });
          return;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        int i;
        QLog.i("TeamWorkHandler", 1, " handleDeleteSharedPadRsp exception: " + paramFromServiceMsg.toString());
        bool1 = false;
        continue;
        QLog.e("TeamWorkHandler", 1, "error handleDeleteSharedPadRsp delete url : " + paramFromServiceMsg + ",retCode: " + i);
        if ((i == 200011) && (a((ReSendCmd)paramToServiceMsg.extraData.getParcelable("key_resend_cmd")))) {
          continue;
        }
        bool1 = false;
        continue;
      }
      QLog.i("TeamWorkHandler", 1, " handleDeleteSharedPadRsp faied code: " + paramFromServiceMsg.getResultCode());
      paramFromServiceMsg = str;
      boolean bool2 = bool1;
    }
  }
  
  private void mg(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = paramFromServiceMsg.isSuccess();
    int k = ((Integer)paramToServiceMsg.getAttribute("key_tip_flag_type", Integer.valueOf(-1))).intValue();
    if (QLog.isColorLevel()) {
      QLog.i("TeamWorkHandler", 2, " handleGetTipFlagRsp ");
    }
    if (bool1) {
      paramFromServiceMsg = new TimDocSSOMsg.GetTipFlagRspBody();
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (!bool1) {
          break label367;
        }
        m = paramFromServiceMsg.uint32_retcode.get();
        if (m == 0)
        {
          i = paramFromServiceMsg.uint32_flag.get();
          if ((k != 1) || (i != 1)) {
            break label364;
          }
          this.ag.put(10, 0);
          aull.o(this.app.getApp(), this.app.getCurrentAccountUin(), "key_team_work_guide_flag", 1);
          j = i;
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.i("TeamWorkHandler", 2, " handleGetTipFlagRsp retCode: " + m + ",flag: " + i);
            bool2 = bool1;
            j = i;
          }
          notifyUI(8, bool2, new Object[] { Integer.valueOf(k), Integer.valueOf(j) });
          return;
        }
      }
      catch (Exception paramObject)
      {
        int m;
        QLog.e("TeamWorkHandler", 1, " handleGetTipFlagRsp exception: " + paramObject.toString());
        bool1 = false;
        continue;
        QLog.e("TeamWorkHandler", 1, "error handleGetTipFlagRsp  retCode: " + m);
        if ((m == 200011) && (a((ReSendCmd)paramToServiceMsg.extraData.getParcelable("key_resend_cmd")))) {
          continue;
        }
        int i = -1;
        bool1 = false;
        continue;
      }
      QLog.e("TeamWorkHandler", 1, " handleGetTipFlagRsp faied code: " + paramFromServiceMsg.getResultCode());
      int j = -1;
      boolean bool2 = bool1;
      continue;
      label364:
      continue;
      label367:
      j = -1;
      bool2 = bool1;
    }
  }
  
  private void mh(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = paramFromServiceMsg.isSuccess();
    int i = ((Integer)paramToServiceMsg.getAttribute("key_tip_flag_type", Integer.valueOf(-1))).intValue();
    int j = ((Integer)paramToServiceMsg.getAttribute("key_tip_flag", Integer.valueOf(-1))).intValue();
    if (QLog.isColorLevel()) {
      QLog.i("TeamWorkHandler", 2, " handleSetTipFlagRsp ");
    }
    if (bool1) {
      paramFromServiceMsg = new TimDocSSOMsg.SetTipFlagRspBody();
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        bool3 = bool1;
        if (bool1)
        {
          k = paramFromServiceMsg.uint32_retcode.get();
          if (k != 0) {
            continue;
          }
          bool2 = bool1;
          if (i == 1)
          {
            this.ag.put(11, 0);
            bool2 = bool1;
            if (j != -1)
            {
              aull.o(this.app.getApp(), this.app.getCurrentAccountUin(), "key_team_work_guide_flag", j);
              bool2 = bool1;
            }
          }
          bool3 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.i("TeamWorkHandler", 2, " handleSetTipFlagRsp retCode: " + k);
            bool3 = bool2;
          }
        }
        notifyUI(9, bool3, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        return;
      }
      catch (Exception paramObject)
      {
        int k;
        QLog.e("TeamWorkHandler", 1, " handleSetTipFlagRsp exception: " + paramObject.toString());
        bool1 = false;
        continue;
        QLog.e("TeamWorkHandler", 1, "error handleSetTipFlagRsp retCode: " + k);
        if ((k == 200011) && (a((ReSendCmd)paramToServiceMsg.extraData.getParcelable("key_resend_cmd")))) {
          continue;
        }
        boolean bool2 = false;
        continue;
      }
      QLog.e("TeamWorkHandler", 1, " handleSetTipFlagRsp faied code: " + paramFromServiceMsg.getResultCode());
      boolean bool3 = bool1;
    }
  }
  
  private void mi(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = paramFromServiceMsg.isSuccess();
    ArrayList localArrayList = new ArrayList();
    if (QLog.isColorLevel()) {
      QLog.i("TeamWorkHandler", 2, " handleBatchGetPadInfo ");
    }
    boolean bool1;
    int i;
    if (bool2)
    {
      paramFromServiceMsg = new TimDocSSOMsg.BatchGetRspBody();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        bool1 = bool2;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          QLog.e("TeamWorkHandler", 1, " handleBatchGetPadInfo exception: " + paramObject.toString());
          bool1 = false;
        }
      }
      if (!bool1) {
        break label368;
      }
      i = paramFromServiceMsg.uint32_retcode.get();
      if (i == 0)
      {
        this.ag.put(12, 0);
        paramToServiceMsg = paramFromServiceMsg.rpt_msg_pad_list.get().iterator();
        while (paramToServiceMsg.hasNext())
        {
          paramFromServiceMsg = (TimDocSSOMsg.PadInfo)paramToServiceMsg.next();
          paramObject = new PadInfo();
          a(paramObject, paramFromServiceMsg);
          if (QLog.isColorLevel()) {
            QLog.d("TeamWorkHandler", 2, "handleBatchGetPadInfo localPadInfo:" + paramObject.toString());
          }
          localArrayList.add(paramObject);
        }
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.i("TeamWorkHandler", 2, " handleBatchGetPadInfo retCode: " + i);
          bool2 = bool1;
        }
      }
    }
    for (;;)
    {
      notifyUI(10, bool2, new Object[] { localArrayList });
      do
      {
        return;
        QLog.e("TeamWorkHandler", 1, "error handleBatchGetPadInfo retCode: " + i);
      } while ((i == 200011) && (a((ReSendCmd)paramToServiceMsg.extraData.getParcelable("key_resend_cmd"))));
      bool1 = false;
      break;
      QLog.e("TeamWorkHandler", 1, " handleBatchGetPadInfo faied code: " + paramFromServiceMsg.getResultCode());
      continue;
      label368:
      bool2 = bool1;
    }
  }
  
  /* Error */
  private void mj(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: invokevirtual 709	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   6: istore 5
    //   8: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +30 -> 41
    //   14: ldc 133
    //   16: iconst_2
    //   17: new 135	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 1033
    //   27: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: iload 5
    //   32: invokevirtual 240	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   35: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 149	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: aload_1
    //   42: getfield 678	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   45: ldc_w 680
    //   48: invokevirtual 805	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   51: checkcast 452	com/tencent/tim/teamwork/ReSendCmd
    //   54: astore_1
    //   55: aload_1
    //   56: ifnull +17 -> 73
    //   59: aload_1
    //   60: getfield 476	com/tencent/tim/teamwork/ReSendCmd:cjb	Ljava/lang/String;
    //   63: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   66: istore 6
    //   68: iload 6
    //   70: ifeq +6 -> 76
    //   73: aload_0
    //   74: monitorexit
    //   75: return
    //   76: iload 5
    //   78: ifeq -5 -> 73
    //   81: new 1015	com/tencent/tim/sso/cmd/TimDocSSOMsg$BatchGetRspBody
    //   84: dup
    //   85: invokespecial 1016	com/tencent/tim/sso/cmd/TimDocSSOMsg$BatchGetRspBody:<init>	()V
    //   88: astore_2
    //   89: aload_2
    //   90: aload_3
    //   91: checkcast 241	[B
    //   94: checkcast 241	[B
    //   97: invokevirtual 1017	com/tencent/tim/sso/cmd/TimDocSSOMsg$BatchGetRspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   100: pop
    //   101: iload 5
    //   103: ifeq -30 -> 73
    //   106: aload_2
    //   107: getfield 1018	com/tencent/tim/sso/cmd/TimDocSSOMsg$BatchGetRspBody:uint32_retcode	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   110: invokevirtual 272	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   113: istore 4
    //   115: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +43 -> 161
    //   121: ldc 133
    //   123: iconst_2
    //   124: new 135	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   131: ldc_w 1035
    //   134: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_1
    //   138: getfield 476	com/tencent/tim/teamwork/ReSendCmd:cjb	Ljava/lang/String;
    //   141: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc_w 1037
    //   147: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: iload 4
    //   152: invokevirtual 458	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   155: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 149	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   161: iload 4
    //   163: ifne +223 -> 386
    //   166: aload_0
    //   167: getfield 81	aulh:jM	Ljava/util/concurrent/ConcurrentHashMap;
    //   170: aload_1
    //   171: getfield 476	com/tencent/tim/teamwork/ReSendCmd:cjb	Ljava/lang/String;
    //   174: invokevirtual 694	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   177: checkcast 696	java/lang/Integer
    //   180: astore_3
    //   181: aload_3
    //   182: ifnonnull +175 -> 357
    //   185: aload_0
    //   186: getfield 81	aulh:jM	Ljava/util/concurrent/ConcurrentHashMap;
    //   189: aload_1
    //   190: getfield 476	com/tencent/tim/teamwork/ReSendCmd:cjb	Ljava/lang/String;
    //   193: iconst_0
    //   194: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   197: invokevirtual 1040	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   200: pop
    //   201: aload_2
    //   202: getfield 1019	com/tencent/tim/sso/cmd/TimDocSSOMsg$BatchGetRspBody:rpt_msg_pad_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   205: invokevirtual 835	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   208: astore_2
    //   209: aload_2
    //   210: ifnull -137 -> 73
    //   213: aload_2
    //   214: invokeinterface 818 1 0
    //   219: istore 4
    //   221: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   224: ifeq +43 -> 267
    //   227: ldc 133
    //   229: iconst_2
    //   230: new 135	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   237: ldc_w 1035
    //   240: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload_1
    //   244: getfield 476	com/tencent/tim/teamwork/ReSendCmd:cjb	Ljava/lang/String;
    //   247: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc_w 1042
    //   253: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: iload 4
    //   258: invokevirtual 458	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   261: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 529	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   267: iload 4
    //   269: iconst_1
    //   270: if_icmpne -197 -> 73
    //   273: aload_0
    //   274: getfield 213	aulh:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   277: sipush 372
    //   280: invokevirtual 856	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   283: checkcast 780	aull
    //   286: aload_1
    //   287: aload_2
    //   288: iconst_0
    //   289: invokeinterface 1045 2 0
    //   294: checkcast 263	com/tencent/tim/sso/cmd/TimDocSSOMsg$PadInfo
    //   297: invokevirtual 1048	aull:a	(Lcom/tencent/tim/teamwork/ReSendCmd;Lcom/tencent/tim/sso/cmd/TimDocSSOMsg$PadInfo;)V
    //   300: goto -227 -> 73
    //   303: astore_1
    //   304: aload_0
    //   305: monitorexit
    //   306: aload_1
    //   307: athrow
    //   308: astore_3
    //   309: ldc 133
    //   311: iconst_1
    //   312: new 135	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   319: ldc_w 1050
    //   322: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload_1
    //   326: getfield 476	com/tencent/tim/teamwork/ReSendCmd:cjb	Ljava/lang/String;
    //   329: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: ldc_w 1052
    //   335: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload_3
    //   339: invokevirtual 743	java/lang/Exception:toString	()Ljava/lang/String;
    //   342: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   351: iconst_0
    //   352: istore 5
    //   354: goto -253 -> 101
    //   357: aload_0
    //   358: getfield 81	aulh:jM	Ljava/util/concurrent/ConcurrentHashMap;
    //   361: astore 7
    //   363: aload_1
    //   364: getfield 476	com/tencent/tim/teamwork/ReSendCmd:cjb	Ljava/lang/String;
    //   367: astore 8
    //   369: aload_3
    //   370: invokevirtual 699	java/lang/Integer:intValue	()I
    //   373: pop
    //   374: aload 7
    //   376: aload 8
    //   378: aload_3
    //   379: invokevirtual 1040	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   382: pop
    //   383: goto -182 -> 201
    //   386: ldc 133
    //   388: iconst_1
    //   389: new 135	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   396: ldc_w 1054
    //   399: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: aload_1
    //   403: getfield 476	com/tencent/tim/teamwork/ReSendCmd:cjb	Ljava/lang/String;
    //   406: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: ldc_w 1037
    //   412: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: iload 4
    //   417: invokevirtual 458	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   420: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   423: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   426: iload 4
    //   428: ldc_w 801
    //   431: if_icmpne -358 -> 73
    //   434: aload_0
    //   435: aload_1
    //   436: invokespecial 1056	aulh:b	(Lcom/tencent/tim/teamwork/ReSendCmd;)Z
    //   439: istore 5
    //   441: iload 5
    //   443: ifeq -370 -> 73
    //   446: goto -373 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	449	0	this	aulh
    //   0	449	1	paramToServiceMsg	ToServiceMsg
    //   0	449	2	paramFromServiceMsg	FromServiceMsg
    //   0	449	3	paramObject	Object
    //   113	319	4	i	int
    //   6	436	5	bool1	boolean
    //   66	3	6	bool2	boolean
    //   361	14	7	localConcurrentHashMap	ConcurrentHashMap
    //   367	10	8	str	String
    // Exception table:
    //   from	to	target	type
    //   2	41	303	finally
    //   41	55	303	finally
    //   59	68	303	finally
    //   81	89	303	finally
    //   89	101	303	finally
    //   106	161	303	finally
    //   166	181	303	finally
    //   185	201	303	finally
    //   201	209	303	finally
    //   213	267	303	finally
    //   273	300	303	finally
    //   309	351	303	finally
    //   357	383	303	finally
    //   386	426	303	finally
    //   434	441	303	finally
    //   89	101	308	java/lang/Exception
  }
  
  /* Error */
  public void VT(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: ifeq +17 -> 20
    //   6: aload_0
    //   7: iconst_4
    //   8: iconst_1
    //   9: invokevirtual 1062	aulh:w	(IZ)Z
    //   12: istore_2
    //   13: iload_2
    //   14: ifne +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: getfield 822	aulh:dje	Z
    //   24: ifne -7 -> 17
    //   27: aload_0
    //   28: iconst_1
    //   29: putfield 822	aulh:dje	Z
    //   32: aload_0
    //   33: iconst_2
    //   34: iconst_1
    //   35: iload_1
    //   36: iconst_1
    //   37: invokevirtual 473	aulh:e	(IIZZ)V
    //   40: goto -23 -> 17
    //   43: astore_3
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_3
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	aulh
    //   0	48	1	paramBoolean	boolean
    //   12	2	2	bool	boolean
    //   43	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	13	43	finally
    //   20	40	43	finally
  }
  
  public void Zp(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("TeamWorkHandler", 1, "---- deleteItemOfAllList pad url is null ----");
    }
    TimDocSSOMsg.DeletePadReqBody localDeletePadReqBody = new TimDocSSOMsg.DeletePadReqBody();
    localDeletePadReqBody.bytes_pad_url.set(ByteStringMicro.copyFromUtf8(paramString));
    ReSendCmd localReSendCmd = new ReSendCmd();
    localReSendCmd.cmd = 13;
    localReSendCmd.cjb = paramString;
    Object localObject = a("send deleteItemOfAllList", localReSendCmd);
    if (localObject == null) {
      QLog.e("TeamWorkHandler", 1, "---- deleteItemOfAllList -- loginInfo is null ---");
    }
    do
    {
      return;
      localDeletePadReqBody.msg_login_info.set((MessageMicro)localObject);
      localDeletePadReqBody.uint32_appid.set(2);
      localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "TimDocSvc.DeleteAllDocListPad");
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).extraData.putParcelable("key_resend_cmd", localReSendCmd);
      ((ToServiceMsg)localObject).putWupBuffer(localDeletePadReqBody.toByteArray());
      super.sendPbReq((ToServiceMsg)localObject);
    } while (!QLog.isColorLevel());
    QLog.i("TeamWorkHandler", 2, "send deleteItemOfAllList padUrl : " + paramString);
  }
  
  public void Zq(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("TeamWorkHandler", 1, "---- deleteCreatedPadReq pad url is null ----");
    }
    TimDocSSOMsg.DeletePadReqBody localDeletePadReqBody = new TimDocSSOMsg.DeletePadReqBody();
    localDeletePadReqBody.bytes_pad_url.set(ByteStringMicro.copyFromUtf8(paramString));
    ReSendCmd localReSendCmd = new ReSendCmd();
    localReSendCmd.cmd = 2;
    localReSendCmd.cjb = paramString;
    paramString = a("send deleteCreatedPadReq", localReSendCmd);
    if (paramString == null) {
      QLog.e("TeamWorkHandler", 1, "---- deleteCreatedPadReq -- loginInfo is null ---");
    }
    do
    {
      return;
      localDeletePadReqBody.msg_login_info.set(paramString);
      localDeletePadReqBody.uint32_appid.set(2);
      paramString = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "TimDocSvc.DeletePad");
      paramString.setTimeout(30000L);
      paramString.extraData.putParcelable("key_resend_cmd", localReSendCmd);
      paramString.putWupBuffer(localDeletePadReqBody.toByteArray());
      super.sendPbReq(paramString);
    } while (!QLog.isColorLevel());
    QLog.i("TeamWorkHandler", 2, "send deleteCreatedPadReq ");
  }
  
  public void Zr(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("TeamWorkHandler", 1, "---- deleteBrowsePadReq pad url is null ----");
    }
    TimDocSSOMsg.DeletePadReqBody localDeletePadReqBody = new TimDocSSOMsg.DeletePadReqBody();
    localDeletePadReqBody.bytes_pad_url.set(ByteStringMicro.copyFromUtf8(paramString));
    ReSendCmd localReSendCmd = new ReSendCmd();
    localReSendCmd.cmd = 3;
    localReSendCmd.cjb = paramString;
    paramString = a("send deleteBrowsePadReq", localReSendCmd);
    if (paramString == null) {
      QLog.e("TeamWorkHandler", 1, "---- deleteBrowsePadReq -- loginInfo is null ---");
    }
    do
    {
      return;
      localDeletePadReqBody.msg_login_info.set(paramString);
      localDeletePadReqBody.uint32_appid.set(2);
      paramString = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "TimDocSvc.DeleteBrowseHistory");
      paramString.setTimeout(30000L);
      paramString.extraData.putParcelable("key_resend_cmd", localReSendCmd);
      paramString.putWupBuffer(localDeletePadReqBody.toByteArray());
      super.sendPbReq(paramString);
    } while (!QLog.isColorLevel());
    QLog.i("TeamWorkHandler", 2, "send deleteBrowsePadReq ");
  }
  
  public void Zs(String paramString)
  {
    TimDocSSOMsg.DeletePadReqBody localDeletePadReqBody = new TimDocSSOMsg.DeletePadReqBody();
    localDeletePadReqBody.bytes_pad_url.set(ByteStringMicro.copyFromUtf8(paramString));
    ReSendCmd localReSendCmd = new ReSendCmd();
    localReSendCmd.cmd = 8;
    localReSendCmd.cjb = paramString;
    paramString = a("send deleteSharedPadReq", localReSendCmd);
    if (paramString == null) {
      QLog.e("TeamWorkHandler", 1, "---- deleteSharedPadReq -- loginInfo is null ---");
    }
    do
    {
      return;
      localDeletePadReqBody.msg_login_info.set(paramString);
      localDeletePadReqBody.uint32_appid.set(2);
      paramString = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "TimDocSvc.DeleteSharedPad");
      paramString.setTimeout(30000L);
      paramString.extraData.putParcelable("key_resend_cmd", localReSendCmd);
      paramString.putWupBuffer(localDeletePadReqBody.toByteArray());
      super.sendPbReq(paramString);
    } while (!QLog.isColorLevel());
    QLog.i("TeamWorkHandler", 2, "send deleteBrowsePadReq ");
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
  
  public void aaQ(int paramInt)
  {
    TimDocSSOMsg.GetTipFlagReqBody localGetTipFlagReqBody = new TimDocSSOMsg.GetTipFlagReqBody();
    localGetTipFlagReqBody.uint32_appid.set(2);
    ReSendCmd localReSendCmd = null;
    if (paramInt == 1)
    {
      localGetTipFlagReqBody.uint32_type.set(2);
      localReSendCmd = new ReSendCmd();
      localReSendCmd.cmd = 10;
    }
    Object localObject = a("send getTipFlagReq", localReSendCmd);
    if (localObject == null) {
      QLog.e("TeamWorkHandler", 1, "---- getTipFlagReq -- loginInfo is null ---");
    }
    do
    {
      return;
      localGetTipFlagReqBody.msg_login_info.set((MessageMicro)localObject);
      localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "TimDocSvc.GetTipFlag");
      ((ToServiceMsg)localObject).setTimeout(30000L);
      if (localReSendCmd != null) {
        ((ToServiceMsg)localObject).extraData.putParcelable("key_resend_cmd", localReSendCmd);
      }
      ((ToServiceMsg)localObject).addAttribute("key_tip_flag_type", Integer.valueOf(paramInt));
      ((ToServiceMsg)localObject).putWupBuffer(localGetTipFlagReqBody.toByteArray());
      super.sendPbReq((ToServiceMsg)localObject);
    } while (!QLog.isColorLevel());
    QLog.i("TeamWorkHandler", 2, "send getTipFlagReq type: " + paramInt);
  }
  
  public void af(List<PadInfo> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      QLog.e("TeamWorkHandler", 1, "---- batchDeletePadReq pad urls is null ----");
      return;
    }
    TimDocSSOMsg.DeletePadReqBody localDeletePadReqBody = new TimDocSSOMsg.DeletePadReqBody();
    Object localObject = a("send batchDeletePadReq", null);
    if (localObject == null)
    {
      QLog.e("TeamWorkHandler", 1, "---- batchDeletePadReq -- loginInfo is null ---");
      return;
    }
    localDeletePadReqBody.msg_login_info.set((MessageMicro)localObject);
    localDeletePadReqBody.uint32_appid.set(2);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (PadInfo)paramList.next();
      TimDocSSOMsg.PadId localPadId = new TimDocSSOMsg.PadId();
      localPadId.uint32_domainid.set(((PadInfo)localObject).domainId);
      localPadId.bytes_localpadid.set(ByteStringMicro.copyFromUtf8(((PadInfo)localObject).padId));
      localDeletePadReqBody.rpt_msg_padid_list.add(localPadId);
    }
    paramList = "TimDocSvc.DeleteAllDocListPad";
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramList = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), paramList);
      paramList.setTimeout(30000L);
      paramList.putWupBuffer(localDeletePadReqBody.toByteArray());
      paramList.extraData.putBoolean("is_batch", true);
      paramList.extraData.putInt("delete_type", paramInt);
      super.sendPbReq(paramList);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("TeamWorkHandler", 2, "send batchDeletePadReq ");
      return;
      paramList = "TimDocSvc.DeleteAllDocListPad";
      continue;
      paramList = "TimDocSvc.DeleteSharedPad";
    }
  }
  
  public void ao(int paramInt, String paramString1, String paramString2)
  {
    if ((this.app == null) || (TextUtils.isEmpty(paramString1)))
    {
      QLog.w("TeamWorkHandler", 1, "copyPadInfoSelf|app or padInfo empty");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TeamWorkHandler", 2, "copyPadInfoSelf|title=" + paramString2 + ",domainId=" + paramInt + ",padId=" + paramString1);
    }
    cmd0xb05.CreateReq localCreateReq = new cmd0xb05.CreateReq();
    localCreateReq.title.set(ByteStringMicro.copyFromUtf8(paramString2));
    localCreateReq.create_type.set(4);
    localCreateReq.create_source.set(4);
    paramString2 = new online_docs.DocId();
    paramString2.domain_id.set(paramInt);
    paramString2.pad_id.set(ByteStringMicro.copyFromUtf8(paramString1));
    localCreateReq.doc_id.set(paramString2);
    paramString1 = new cmd0xb05.ReqBody();
    paramString1.create_req.set(localCreateReq);
    paramString2 = new oidb_sso.OIDBSSOPkg();
    paramString2.uint32_command.set(2821);
    paramString2.uint32_service_type.set(3);
    paramString2.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramString1.toByteArray()));
    paramString1 = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "OidbSvc.0xb05_3");
    paramString1.putWupBuffer(paramString2.toByteArray());
    super.sendPbReq(paramString1);
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
  
  public void e(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = null;
    if ((paramBoolean1) && (!w(paramInt1, paramBoolean2))) {
      return;
    }
    TimDocSSOMsg.GetPadListReqBody localGetPadListReqBody = new TimDocSSOMsg.GetPadListReqBody();
    Object localObject2;
    if (paramInt1 == 1)
    {
      localObject2 = "TimDocSvc.GetCreatedList";
      localObject1 = "key_teamwork_created_timestamp_appid2";
    }
    for (;;)
    {
      localGetPadListReqBody.uint32_count.set(20);
      localObject1 = aull.g(this.app.getApp(), this.app.getCurrentAccountUin(), (String)localObject1, "");
      localGetPadListReqBody.uint32_appid.set(2);
      if ((paramInt2 == 1) || (paramInt2 == 2)) {
        localGetPadListReqBody.uint32_request_type.set(2);
      }
      TimDocSSOMsg.LoginInfo localLoginInfo;
      for (;;)
      {
        localGetPadListReqBody.bytes_timestamp.set(ByteStringMicro.copyFromUtf8((String)localObject1));
        localGetPadListReqBody.uint32_list_type.set(paramInt1);
        localObject1 = new ReSendCmd();
        ((ReSendCmd)localObject1).cmd = 1;
        ((ReSendCmd)localObject1).dNG = paramInt2;
        ((ReSendCmd)localObject1).dNF = paramInt1;
        ((ReSendCmd)localObject1).djb = paramBoolean1;
        ((ReSendCmd)localObject1).djc = paramBoolean2;
        localLoginInfo = a("send getPadListReq", (ReSendCmd)localObject1);
        if (localLoginInfo != null) {
          break label263;
        }
        QLog.e("TeamWorkHandler", 1, "---- getPadListReq -- loginInfo is null ---");
        return;
        if (paramInt1 == 2)
        {
          localObject2 = "TimDocSvc.GetBrowseList";
          localObject1 = "key_teamwork_browse_timestamp_appid2";
          break;
        }
        if (paramInt1 == 3)
        {
          localObject2 = "TimDocSvc.GetSharedPadList";
          localObject1 = "key_teamwork_shared_timestamp_appid2";
          break;
        }
        if (paramInt1 != 5) {
          break label482;
        }
        localObject2 = "TimDocSvc.GetAllDocList";
        localObject1 = "key_teamwork_pin_items_in_all_timestamp_appid2";
        break;
        if (paramInt2 == 3) {
          localGetPadListReqBody.uint32_request_type.set(1);
        }
      }
      label263:
      localGetPadListReqBody.msg_login_info.set(localLoginInfo);
      if (paramInt2 != 3)
      {
        if (((paramInt1 == 5) || (paramInt1 == 1)) && (((this.dje) && (this.du.contains("TimDocSvc.GetBrowseList"))) || (this.du.contains(localObject2)))) {
          break;
        }
        this.du.add(localObject2);
      }
      localObject2 = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), (String)localObject2);
      ((ToServiceMsg)localObject2).addAttribute(cjJ, Integer.valueOf(paramInt1));
      ((ToServiceMsg)localObject2).addAttribute(ckp, Integer.valueOf(paramInt2));
      if (paramBoolean2) {
        ((ToServiceMsg)localObject2).extraData.putString(cIy, cIz);
      }
      ((ToServiceMsg)localObject2).extraData.putParcelable("key_resend_cmd", (Parcelable)localObject1);
      ((ToServiceMsg)localObject2).setTimeout(30000L);
      ((ToServiceMsg)localObject2).putWupBuffer(localGetPadListReqBody.toByteArray());
      super.sendPbReq((ToServiceMsg)localObject2);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("TeamWorkHandler", 2, "send getPadListReqNew typeList: " + paramInt1 + ",typeOpreation: " + paramInt2);
      return;
      label482:
      localObject2 = null;
    }
  }
  
  public void eq(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("TeamWorkHandler", 1, "---- pinPadReq pad url is null ----");
    }
    TimDocSSOMsg.PinPadReqBody localPinPadReqBody = new TimDocSSOMsg.PinPadReqBody();
    localPinPadReqBody.bytes_pad_url.set(ByteStringMicro.copyFromUtf8(paramString));
    localPinPadReqBody.uint32_list_type.set(paramInt);
    Object localObject = null;
    ReSendCmd localReSendCmd;
    TimDocSSOMsg.LoginInfo localLoginInfo;
    if (paramInt == 1)
    {
      localObject = "TimDocSvc.PinCreatedPad";
      localReSendCmd = new ReSendCmd();
      localReSendCmd.cmd = 4;
      localReSendCmd.cjb = paramString;
      localReSendCmd.dNH = paramInt;
      localLoginInfo = a("send pinPadReq", localReSendCmd);
      if (localLoginInfo != null) {
        break label146;
      }
      QLog.e("TeamWorkHandler", 1, "---- pinPadReq -- loginInfo is null ---");
    }
    label146:
    do
    {
      return;
      if (paramInt == 2)
      {
        localObject = "TimDocSvc.PinBrowsePad";
        break;
      }
      if (paramInt == 3)
      {
        localObject = "TimDocSvc.PinSharedPad";
        break;
      }
      if (paramInt != 4) {
        break;
      }
      localObject = "TimDocSvc.PinAllDocListPad";
      break;
      localPinPadReqBody.msg_login_info.set(localLoginInfo);
      localPinPadReqBody.uint32_appid.set(2);
      localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), (String)localObject);
      ((ToServiceMsg)localObject).putWupBuffer(localPinPadReqBody.toByteArray());
      ((ToServiceMsg)localObject).addAttribute(cjJ, Integer.valueOf(paramInt));
      ((ToServiceMsg)localObject).extraData.putParcelable("key_resend_cmd", localReSendCmd);
      ((ToServiceMsg)localObject).setTimeout(30000L);
      super.sendPbReq((ToServiceMsg)localObject);
    } while (!QLog.isColorLevel());
    QLog.i("TeamWorkHandler", 2, "send pinPadReq pinPadType: " + paramInt + ",padUrl: " + paramString);
  }
  
  public void er(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("TeamWorkHandler", 1, "---- cancelPinPadReq pad url is null ----");
    }
    TimDocSSOMsg.CancelPinPadReqBody localCancelPinPadReqBody = new TimDocSSOMsg.CancelPinPadReqBody();
    localCancelPinPadReqBody.bytes_pad_url.set(ByteStringMicro.copyFromUtf8(paramString));
    localCancelPinPadReqBody.uint32_list_type.set(paramInt);
    Object localObject = null;
    ReSendCmd localReSendCmd;
    TimDocSSOMsg.LoginInfo localLoginInfo;
    if (paramInt == 1)
    {
      localObject = "TimDocSvc.CancelPinCreatedPad";
      localReSendCmd = new ReSendCmd();
      localReSendCmd.cmd = 5;
      localReSendCmd.cjb = paramString;
      localReSendCmd.dNH = paramInt;
      localLoginInfo = a("send cancelPinPadReq", localReSendCmd);
      if (localLoginInfo != null) {
        break label146;
      }
      QLog.e("TeamWorkHandler", 1, "---- cancelPinPadReq -- loginInfo is null ---");
    }
    label146:
    do
    {
      return;
      if (paramInt == 2)
      {
        localObject = "TimDocSvc.CancelPinBrowsePad";
        break;
      }
      if (paramInt == 3)
      {
        localObject = "TimDocSvc.CancelPinSharedPad";
        break;
      }
      if (paramInt != 4) {
        break;
      }
      localObject = "TimDocSvc.CancelPinAllDocListPad";
      break;
      localCancelPinPadReqBody.msg_login_info.set(localLoginInfo);
      localCancelPinPadReqBody.uint32_appid.set(2);
      localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), (String)localObject);
      ((ToServiceMsg)localObject).putWupBuffer(localCancelPinPadReqBody.toByteArray());
      ((ToServiceMsg)localObject).addAttribute(cjJ, Integer.valueOf(paramInt));
      ((ToServiceMsg)localObject).extraData.putParcelable("key_resend_cmd", localReSendCmd);
      ((ToServiceMsg)localObject).setTimeout(30000L);
      super.sendPbReq((ToServiceMsg)localObject);
    } while (!QLog.isColorLevel());
    QLog.i("TeamWorkHandler", 2, "send cancelPinPadReq pinPadType: " + paramInt + ",padUrl: " + paramString);
  }
  
  public void evv()
  {
    evw();
    ThreadManager.getUIHandler().postDelayed(this.iu, 5000L);
  }
  
  public void evw()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.iu);
  }
  
  /* Error */
  public JSONObject g(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_2
    //   6: ldc_w 1411
    //   9: invokestatic 1416	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   12: astore_2
    //   13: aload_2
    //   14: ifnull +199 -> 213
    //   17: ldc_w 1418
    //   20: iconst_3
    //   21: anewarray 574	java/lang/Object
    //   24: dup
    //   25: iconst_0
    //   26: aload_0
    //   27: getfield 213	aulh:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   30: invokevirtual 216	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   33: aastore
    //   34: dup
    //   35: iconst_1
    //   36: aload_1
    //   37: aastore
    //   38: dup
    //   39: iconst_2
    //   40: aload_2
    //   41: aastore
    //   42: invokestatic 1422	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   45: astore_1
    //   46: aload_0
    //   47: getfield 213	aulh:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   50: invokevirtual 216	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   53: aload_1
    //   54: ldc 221
    //   56: invokestatic 1428	jqc:m	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +147 -> 208
    //   64: new 531	org/json/JSONObject
    //   67: dup
    //   68: aload_1
    //   69: invokespecial 533	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   72: astore_2
    //   73: aload_2
    //   74: astore_1
    //   75: aload_2
    //   76: ldc_w 535
    //   79: invokevirtual 1431	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   82: ifne +14 -> 96
    //   85: aload_2
    //   86: ldc_w 535
    //   89: iconst_m1
    //   90: invokevirtual 1434	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   93: pop
    //   94: aload_2
    //   95: astore_1
    //   96: aload_1
    //   97: astore_2
    //   98: aload_1
    //   99: ifnonnull +20 -> 119
    //   102: new 531	org/json/JSONObject
    //   105: dup
    //   106: invokespecial 1435	org/json/JSONObject:<init>	()V
    //   109: astore_2
    //   110: aload_2
    //   111: ldc_w 535
    //   114: iconst_m1
    //   115: invokevirtual 1434	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   118: pop
    //   119: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +13 -> 135
    //   125: ldc 199
    //   127: iconst_2
    //   128: aload_2
    //   129: invokevirtual 1436	org/json/JSONObject:toString	()Ljava/lang/String;
    //   132: invokestatic 529	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: aload_2
    //   136: areturn
    //   137: astore_2
    //   138: aload_3
    //   139: astore_1
    //   140: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   143: ifeq +14 -> 157
    //   146: ldc 199
    //   148: iconst_2
    //   149: aload_2
    //   150: iconst_0
    //   151: anewarray 574	java/lang/Object
    //   154: invokestatic 577	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   157: goto -61 -> 96
    //   160: astore_2
    //   161: aload 4
    //   163: astore_1
    //   164: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   167: ifeq +14 -> 181
    //   170: ldc 199
    //   172: iconst_2
    //   173: aload_2
    //   174: iconst_0
    //   175: anewarray 574	java/lang/Object
    //   178: invokestatic 577	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   181: goto -85 -> 96
    //   184: astore_1
    //   185: aload_1
    //   186: invokevirtual 1439	org/json/JSONException:printStackTrace	()V
    //   189: goto -70 -> 119
    //   192: astore_3
    //   193: aload_2
    //   194: astore_1
    //   195: aload_3
    //   196: astore_2
    //   197: goto -33 -> 164
    //   200: astore_3
    //   201: aload_2
    //   202: astore_1
    //   203: aload_3
    //   204: astore_2
    //   205: goto -65 -> 140
    //   208: aconst_null
    //   209: astore_1
    //   210: goto -114 -> 96
    //   213: aconst_null
    //   214: astore_1
    //   215: goto -155 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	aulh
    //   0	218	1	paramString1	String
    //   0	218	2	paramString2	String
    //   4	135	3	localObject1	Object
    //   192	4	3	localJSONException	JSONException
    //   200	4	3	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   1	161	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   5	13	137	java/io/UnsupportedEncodingException
    //   17	60	137	java/io/UnsupportedEncodingException
    //   64	73	137	java/io/UnsupportedEncodingException
    //   5	13	160	org/json/JSONException
    //   17	60	160	org/json/JSONException
    //   64	73	160	org/json/JSONException
    //   110	119	184	org/json/JSONException
    //   75	94	192	org/json/JSONException
    //   75	94	200	java/io/UnsupportedEncodingException
  }
  
  public long iB()
  {
    if (ayT == 0L) {
      ayT = aull.c(this.app.getApp(), this.app.getCurrentAccountUin(), "key_teamwork_auto_fresh_interval_time", 0);
    }
    return ayT;
  }
  
  public void kU(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = paramFromServiceMsg.isSuccess();
    int j = ((Integer)paramToServiceMsg.getAttribute(cjJ)).intValue();
    if (QLog.isColorLevel()) {
      QLog.i("TeamWorkHandler", 2, " handleGetPadRightsInfo ,resultCode: " + paramFromServiceMsg.getResultCode());
    }
    if (!bool1) {
      paramToServiceMsg = "";
    }
    label122:
    int i;
    for (;;)
    {
      if (!bool1) {
        QLog.i("TeamWorkHandler", 1, " handleGetPadRightsInfo faied code: " + paramFromServiceMsg.getResultCode());
      }
      notifyUI(5, bool1, new Object[] { paramToServiceMsg, Integer.valueOf(j) });
      return;
      localObject = new TimDocSSOMsg.GetPadRightInfoRspBody();
      try
      {
        ((TimDocSSOMsg.GetPadRightInfoRspBody)localObject).mergeFrom((byte[])paramObject);
        i = ((TimDocSSOMsg.GetPadRightInfoRspBody)localObject).uint32_retcode.get();
        if (i == 0) {
          break label277;
        }
        QLog.e("TeamWorkHandler", 1, "error handleGetPadRightsInfo url : " + "" + ",retCode: " + i);
        if ((i == 200011) && (a((ReSendCmd)paramToServiceMsg.extraData.getParcelable("key_resend_cmd")))) {
          break label122;
        }
        paramToServiceMsg = "";
        bool1 = false;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.i("TeamWorkHandler", 1, " handleGetPadRightsInfo exception: " + paramToServiceMsg.toString());
        paramToServiceMsg = "";
        bool1 = false;
      }
      continue;
      label277:
      paramToServiceMsg = ((TimDocSSOMsg.GetPadRightInfoRspBody)localObject).bytes_pad_url.get().toStringUtf8();
      if (((TimDocSSOMsg.GetPadRightInfoRspBody)localObject).uint32_pad_right.has()) {
        break;
      }
      QLog.e("TeamWorkHandler", 1, "error handleGetPadRightsInfo url : " + paramToServiceMsg + ",has not padrights filed ");
      bool1 = false;
    }
    paramObject = null;
    aull localaull = (aull)this.app.getManager(372);
    if (localaull != null) {
      paramObject = localaull.a(paramToServiceMsg, j);
    }
    int k = ((TimDocSSOMsg.GetPadRightInfoRspBody)localObject).uint32_pad_right.get();
    Object localObject = ((TimDocSSOMsg.GetPadRightInfoRspBody)localObject).rpt_msg_uin_right_info.get();
    if (paramObject == null)
    {
      boolean bool2 = false;
      bool1 = false;
      if (j == 4)
      {
        i = 1;
        bool2 = bool1;
        if (i <= 4)
        {
          paramFromServiceMsg = localaull.b(paramToServiceMsg, i);
          if (paramFromServiceMsg != null)
          {
            bool1 = true;
            paramFromServiceMsg.policy = k;
            if ((k != 1) && (k != 2)) {
              break label467;
            }
            paramFromServiceMsg.setRightsList((List)localObject);
          }
          for (;;)
          {
            i += 1;
            break;
            label467:
            paramFromServiceMsg.setRightsList(new ArrayList());
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.w("TeamWorkHandler", 2, "pad is not exxisted ,but in other list find : " + bool2);
      }
      if (!bool2)
      {
        notifyUI(7, true, new Object[] { paramToServiceMsg, Integer.valueOf(k), localObject });
        return;
      }
      notifyUI(5, true, new Object[] { paramToServiceMsg, Integer.valueOf(j) });
      return;
    }
    paramObject.policy = k;
    if ((k == 1) || (k == 2)) {
      paramObject.setRightsList((List)localObject);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TeamWorkHandler", 2, " handleGetPadRightsInfo url : " + paramToServiceMsg + ",retCode: " + i);
      }
      bool1 = true;
      break;
      paramObject.setRightsList(new ArrayList());
    }
  }
  
  public void kV(int paramInt1, int paramInt2)
  {
    TimDocSSOMsg.SetTipFlagReqBody localSetTipFlagReqBody = new TimDocSSOMsg.SetTipFlagReqBody();
    localSetTipFlagReqBody.uint32_appid.set(2);
    localSetTipFlagReqBody.uint32_flag.set(paramInt2);
    ReSendCmd localReSendCmd = null;
    if (paramInt1 == 1)
    {
      localSetTipFlagReqBody.uint32_type.set(2);
      localReSendCmd = new ReSendCmd();
      localReSendCmd.cmd = 11;
    }
    Object localObject = a("send setTipFlagReq", localReSendCmd);
    if (localObject == null) {
      QLog.e("TeamWorkHandler", 1, "---- setTipFlagReq -- loginInfo is null ---");
    }
    do
    {
      return;
      localSetTipFlagReqBody.msg_login_info.set((MessageMicro)localObject);
      localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "TimDocSvc.SetTipFlag");
      ((ToServiceMsg)localObject).setTimeout(30000L);
      if (localReSendCmd != null) {
        ((ToServiceMsg)localObject).extraData.putParcelable("key_resend_cmd", localReSendCmd);
      }
      ((ToServiceMsg)localObject).addAttribute("key_tip_flag_type", Integer.valueOf(paramInt1));
      ((ToServiceMsg)localObject).addAttribute("key_tip_flag", Integer.valueOf(paramInt2));
      ((ToServiceMsg)localObject).putWupBuffer(localSetTipFlagReqBody.toByteArray());
      super.sendPbReq((ToServiceMsg)localObject);
    } while (!QLog.isColorLevel());
    QLog.i("TeamWorkHandler", 2, "send setTipFlagReq type: " + paramInt1 + ",flag: " + paramInt2);
  }
  
  public void lZ(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = paramFromServiceMsg.isSuccess();
    String str = "";
    if (QLog.isColorLevel()) {
      QLog.i("TeamWorkHandler", 2, " handleDeleteAllListRsp ");
    }
    TimDocSSOMsg.DeletePadRspBody localDeletePadRspBody;
    if (bool1) {
      localDeletePadRspBody = new TimDocSSOMsg.DeletePadRspBody();
    }
    for (;;)
    {
      try
      {
        localDeletePadRspBody.mergeFrom((byte[])paramObject);
        paramFromServiceMsg = str;
        bool2 = bool1;
        if (bool1)
        {
          i = localDeletePadRspBody.uint32_retcode.get();
          paramFromServiceMsg = localDeletePadRspBody.bytes_pad_url.get().toStringUtf8();
          if (i == 0)
          {
            this.ag.put(13, 0);
            paramToServiceMsg = (aull)this.app.getManager(372);
            if (paramToServiceMsg != null)
            {
              paramToServiceMsg.gQ(paramFromServiceMsg, 4);
              VT(false);
            }
            if (QLog.isColorLevel()) {
              QLog.i("TeamWorkHandler", 2, " handleDeleteAllListRsp delete url : " + paramFromServiceMsg + ",retCode: " + i);
            }
            bool2 = bool1;
          }
        }
        else
        {
          notifyUI(2, bool2, new Object[] { Integer.valueOf(4), paramFromServiceMsg });
          return;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        int i;
        QLog.e("TeamWorkHandler", 1, " handleDeleteAllListRsp exception: " + paramFromServiceMsg.toString());
        bool1 = false;
        continue;
        QLog.e("TeamWorkHandler", 1, "error handleDeleteAllListRsp delete url : " + paramFromServiceMsg + ",retCode: " + i);
        if ((i == 200011) && (a((ReSendCmd)paramToServiceMsg.extraData.getParcelable("key_resend_cmd")))) {
          continue;
        }
        bool1 = false;
        continue;
      }
      QLog.i("TeamWorkHandler", 1, " handleDeleteCreatedPadRsp faied code: " + paramFromServiceMsg.getResultCode());
      paramFromServiceMsg = str;
      boolean bool2 = bool1;
    }
  }
  
  public void ma(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = paramFromServiceMsg.isSuccess();
    String str = "";
    if (QLog.isColorLevel()) {
      QLog.i("TeamWorkHandler", 2, " handleDeleteCreatedPadRsp ");
    }
    TimDocSSOMsg.DeletePadRspBody localDeletePadRspBody;
    if (bool1) {
      localDeletePadRspBody = new TimDocSSOMsg.DeletePadRspBody();
    }
    for (;;)
    {
      try
      {
        localDeletePadRspBody.mergeFrom((byte[])paramObject);
        paramFromServiceMsg = str;
        bool2 = bool1;
        if (bool1)
        {
          i = localDeletePadRspBody.uint32_retcode.get();
          paramFromServiceMsg = localDeletePadRspBody.bytes_pad_url.get().toStringUtf8();
          localDeletePadRspBody.uint32_list_type.get();
          localDeletePadRspBody.uint32_domainid.get();
          localDeletePadRspBody.bytes_localpadid.get().toStringUtf8();
          if (i == 0)
          {
            this.ag.put(2, 0);
            paramToServiceMsg = (aull)this.app.getManager(372);
            if (paramToServiceMsg != null)
            {
              paramToServiceMsg.gQ(paramFromServiceMsg, 1);
              paramToServiceMsg.gQ(paramFromServiceMsg, 2);
              e(2, 1, false, false);
              e(2, 2, false, false);
            }
            if (QLog.isColorLevel()) {
              QLog.i("TeamWorkHandler", 2, " handleDeleteCreatedPadRsp delete url : " + paramFromServiceMsg + ",retCode: " + i);
            }
            bool2 = bool1;
          }
        }
        else
        {
          notifyUI(2, bool2, new Object[] { Integer.valueOf(1), paramFromServiceMsg });
          return;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        int i;
        QLog.e("TeamWorkHandler", 1, " handleDeleteCreatedPadRsp exception: " + paramFromServiceMsg.toString());
        bool1 = false;
        continue;
        QLog.e("TeamWorkHandler", 1, "error handleDeleteCreatedPadRsp delete url : " + paramFromServiceMsg + ",retCode: " + i);
        if ((i == 200011) && (a((ReSendCmd)paramToServiceMsg.extraData.getParcelable("key_resend_cmd")))) {
          continue;
        }
        bool1 = false;
        continue;
      }
      QLog.i("TeamWorkHandler", 1, " handleDeleteCreatedPadRsp faied code: " + paramFromServiceMsg.getResultCode());
      paramFromServiceMsg = str;
      boolean bool2 = bool1;
    }
  }
  
  public void mb(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = paramFromServiceMsg.isSuccess();
    String str = "";
    if (QLog.isColorLevel()) {
      QLog.i("TeamWorkHandler", 2, " handleDeleteBrowsePadRsp ,resultCode: " + paramFromServiceMsg.getResultCode());
    }
    TimDocSSOMsg.DeletePadRspBody localDeletePadRspBody;
    if (bool1) {
      localDeletePadRspBody = new TimDocSSOMsg.DeletePadRspBody();
    }
    for (;;)
    {
      try
      {
        localDeletePadRspBody.mergeFrom((byte[])paramObject);
        paramFromServiceMsg = str;
        bool2 = bool1;
        if (bool1)
        {
          i = localDeletePadRspBody.uint32_retcode.get();
          paramFromServiceMsg = localDeletePadRspBody.bytes_pad_url.get().toStringUtf8();
          if (i == 0)
          {
            this.ag.put(3, 0);
            paramToServiceMsg = (aull)this.app.getManager(372);
            if (paramToServiceMsg != null)
            {
              paramToServiceMsg.gQ(paramFromServiceMsg, 2);
              e(2, 2, false, false);
            }
            if (QLog.isColorLevel()) {
              QLog.i("TeamWorkHandler", 2, " handleDeleteBrowsePadRsp delete url : " + paramFromServiceMsg + ",retCode: " + i);
            }
            bool2 = bool1;
          }
        }
        else
        {
          notifyUI(2, bool2, new Object[] { Integer.valueOf(2), paramFromServiceMsg });
          return;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        int i;
        QLog.i("TeamWorkHandler", 1, " handleDeleteBrowsePadRsp exception: " + paramFromServiceMsg.toString());
        bool1 = false;
        continue;
        QLog.e("TeamWorkHandler", 1, "error handleDeleteBrowsePadRsp delete url : " + paramFromServiceMsg + ",retCode: " + i);
        if ((i == 200011) && (a((ReSendCmd)paramToServiceMsg.extraData.getParcelable("key_resend_cmd")))) {
          continue;
        }
        bool1 = false;
        continue;
      }
      QLog.i("TeamWorkHandler", 1, " handleDeleteBrowsePadRsp faied code: " + paramFromServiceMsg.getResultCode());
      paramFromServiceMsg = str;
      boolean bool2 = bool1;
    }
  }
  
  public void mc(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = paramFromServiceMsg.isSuccess();
    int i = paramToServiceMsg.extraData.getInt("delete_type");
    paramToServiceMsg = new ArrayList();
    if (QLog.isColorLevel()) {
      QLog.i("TeamWorkHandler", 2, " handlebatchDeletePadRsp ,resultCode: " + paramFromServiceMsg.getResultCode());
    }
    boolean bool1;
    int j;
    if (bool2)
    {
      paramFromServiceMsg = new TimDocSSOMsg.DeletePadRspBody();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        bool1 = bool2;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          TimDocSSOMsg.PadId localPadId;
          QLog.i("TeamWorkHandler", 1, " handlebatchDeletePadRsp exception: " + paramObject.toString());
          bool1 = false;
          continue;
          paramToServiceMsg.add(localPadId.bytes_pad_url.get().toStringUtf8());
        }
        e(2, i, false, false);
      }
      if (!bool1) {
        break label414;
      }
      j = paramFromServiceMsg.uint32_retcode.get();
      if (j == 0)
      {
        paramObject = (aull)this.app.getManager(372);
        if ((paramObject != null) && (paramFromServiceMsg.rpt_msg_padid_list.has()))
        {
          paramFromServiceMsg = paramFromServiceMsg.rpt_msg_padid_list.get().iterator();
          for (;;)
          {
            if (!paramFromServiceMsg.hasNext()) {
              break label266;
            }
            localPadId = (TimDocSSOMsg.PadId)paramFromServiceMsg.next();
            if (localPadId.uint32_retcode.get() != 0) {
              break;
            }
            paramObject.ab(localPadId.uint32_domainid.get(), localPadId.bytes_localpadid.get().toStringUtf8(), i);
          }
        }
        label266:
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.i("TeamWorkHandler", 2, " handlebatchDeletePadRsp, retCode: " + j);
          bool2 = bool1;
        }
      }
    }
    for (;;)
    {
      notifyUI(11, bool2, new Object[] { Integer.valueOf(i), paramToServiceMsg });
      return;
      QLog.e("TeamWorkHandler", 1, "error handlebatchDeletePadRsp, retCode: " + j);
      if (j == 200011) {}
      bool1 = false;
      break;
      QLog.i("TeamWorkHandler", 1, " handlebatchDeletePadRsp faied code: " + paramFromServiceMsg.getResultCode());
      continue;
      label414:
      bool2 = bool1;
    }
  }
  
  public void md(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = paramFromServiceMsg.isSuccess();
    int i = ((Integer)paramToServiceMsg.getAttribute(cjJ)).intValue();
    String str = "";
    if (QLog.isColorLevel()) {
      QLog.i("TeamWorkHandler", 2, " handlePinPadRsp typePad: " + i + ",resultCode: " + paramFromServiceMsg.getResultCode());
    }
    TimDocSSOMsg.PinPadRspBody localPinPadRspBody;
    if (bool1) {
      localPinPadRspBody = new TimDocSSOMsg.PinPadRspBody();
    }
    for (;;)
    {
      try
      {
        localPinPadRspBody.mergeFrom((byte[])paramObject);
        paramFromServiceMsg = str;
        bool2 = bool1;
        if (bool1)
        {
          j = localPinPadRspBody.uint32_retcode.get();
          paramFromServiceMsg = localPinPadRspBody.bytes_pad_url.get().toStringUtf8();
          if (j != 0) {
            continue;
          }
          this.ag.put(4, 0);
          paramToServiceMsg = (aull)this.app.getManager(372);
          if (paramToServiceMsg != null)
          {
            if (i == 4)
            {
              paramObject = new PadInfo();
              paramObject.lastPinnedTime = localPinPadRspBody.uint64_last_pinned_time.get();
              paramToServiceMsg.j(paramFromServiceMsg, true, paramObject.lastPinnedTime);
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.i("TeamWorkHandler", 2, " handlePinPadRsp url : " + paramFromServiceMsg + ",retCode: " + j);
            }
            bool2 = bool1;
          }
        }
        else
        {
          notifyUI(3, bool2, new Object[] { Integer.valueOf(i), paramFromServiceMsg });
          return;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        int j;
        QLog.e("TeamWorkHandler", 1, " handlePinPadRsp exception: " + paramFromServiceMsg.toString());
        bool1 = false;
        continue;
        paramObject = paramToServiceMsg.a(paramFromServiceMsg, i);
        if (paramObject == null) {
          continue;
        }
        paramObject.pinedFlag = true;
        paramObject.lastPinnedTime = localPinPadRspBody.uint64_last_pinned_time.get();
        paramObject.domainId = localPinPadRspBody.uint32_domainid.get();
        paramObject.padId = localPinPadRspBody.bytes_localpadid.get().toStringUtf8();
        paramToServiceMsg.h(paramObject);
        continue;
        QLog.e("TeamWorkHandler", 1, "error handlePinPadRsp url : " + paramFromServiceMsg + ",retCode: " + j);
        if ((j == 200011) && (a((ReSendCmd)paramToServiceMsg.extraData.getParcelable("key_resend_cmd")))) {
          continue;
        }
        bool1 = false;
        continue;
      }
      QLog.i("TeamWorkHandler", 1, " handlePinPadRsp faied code: " + paramFromServiceMsg.getResultCode());
      paramFromServiceMsg = str;
      boolean bool2 = bool1;
    }
  }
  
  public void me(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = paramFromServiceMsg.isSuccess();
    int i = ((Integer)paramToServiceMsg.getAttribute(cjJ)).intValue();
    String str = "";
    if (QLog.isColorLevel()) {
      QLog.i("TeamWorkHandler", 2, " handleCancelPinPadRsp typePad: " + i + ",resultCode: " + paramFromServiceMsg.getResultCode());
    }
    TimDocSSOMsg.CancelPinPadRspBody localCancelPinPadRspBody;
    if (bool1) {
      localCancelPinPadRspBody = new TimDocSSOMsg.CancelPinPadRspBody();
    }
    for (;;)
    {
      try
      {
        localCancelPinPadRspBody.mergeFrom((byte[])paramObject);
        paramFromServiceMsg = str;
        bool2 = bool1;
        if (bool1)
        {
          paramFromServiceMsg = localCancelPinPadRspBody.bytes_pad_url.get().toStringUtf8();
          j = localCancelPinPadRspBody.uint32_retcode.get();
          if (j != 0) {
            continue;
          }
          this.ag.put(5, 0);
          paramToServiceMsg = (aull)this.app.getManager(372);
          if (paramToServiceMsg != null)
          {
            if (i == 4) {
              paramToServiceMsg.j(paramFromServiceMsg, false, 0L);
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.i("TeamWorkHandler", 2, " handleCancelPinPadRsp url : " + paramFromServiceMsg + ",retCode: " + j);
            }
            bool2 = bool1;
          }
        }
        else
        {
          notifyUI(4, bool2, new Object[] { Integer.valueOf(i), paramFromServiceMsg });
          return;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        int j;
        QLog.i("TeamWorkHandler", 1, " handleCancelPinPadRsp exception: " + paramFromServiceMsg.toString());
        bool1 = false;
        continue;
        paramObject = paramToServiceMsg.a(paramFromServiceMsg, i);
        if (paramObject == null) {
          continue;
        }
        paramObject.pinedFlag = false;
        paramObject.lastPinnedTime = 0L;
        paramToServiceMsg.h(paramObject);
        continue;
        QLog.e("TeamWorkHandler", 1, "error handleCancelPinPadRsp url : " + paramFromServiceMsg + ",retCode: " + j);
        if ((j == 200011) && (a((ReSendCmd)paramToServiceMsg.extraData.getParcelable("key_resend_cmd")))) {
          continue;
        }
        bool1 = false;
        continue;
      }
      QLog.i("TeamWorkHandler", 1, " handleCancelPinPadRsp faied code: " + paramFromServiceMsg.getResultCode());
      paramFromServiceMsg = str;
      boolean bool2 = bool1;
    }
  }
  
  public void mk(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      notifyUI(14, false, new Object[] { null, Integer.valueOf(0), null, Integer.valueOf(-1) });
      return;
    }
    if ((!paramFromServiceMsg.isSuccess()) || (paramFromServiceMsg.getResultCode() != 1000))
    {
      notifyUI(14, false, new Object[] { null, Integer.valueOf(0), null, Integer.valueOf(paramFromServiceMsg.getResultCode()) });
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    int i;
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null)) {
          break;
        }
        if (paramToServiceMsg.uint32_result.has())
        {
          i = paramToServiceMsg.uint32_result.get();
          QLog.i("TeamWorkHandler", 1, "handleCopyPadSelf|retCode=" + i);
          notifyUI(14, false, new Object[] { null, Integer.valueOf(0), null, Integer.valueOf(i) });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        notifyUI(14, false, new Object[] { null, Integer.valueOf(0), null, Integer.valueOf(-1) });
        return;
      }
      i = -1;
    }
    paramFromServiceMsg = new cmd0xb05.RspBody();
    for (;;)
    {
      try
      {
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        paramToServiceMsg = (cmd0xb05.CreateRsp)paramFromServiceMsg.create_rsp.get();
        paramFromServiceMsg = (online_docs.DocId)paramToServiceMsg.doc_id.get();
        if (paramToServiceMsg.doc_url.has())
        {
          paramToServiceMsg = paramToServiceMsg.doc_url.get().toStringUtf8();
          i = (int)paramFromServiceMsg.domain_id.get();
          if (!paramFromServiceMsg.pad_id.has()) {
            break label537;
          }
          paramFromServiceMsg = paramFromServiceMsg.pad_id.get().toStringUtf8();
          if (QLog.isColorLevel()) {
            QLog.d("TeamWorkHandler", 2, "handleCopyPadSelf|success padUrl=" + paramToServiceMsg);
          }
          paramObject = paramToServiceMsg;
          if (paramToServiceMsg.startsWith("//")) {
            paramObject = "https:" + paramToServiceMsg;
          }
          notifyUI(14, true, new Object[] { paramObject, Integer.valueOf(i), paramFromServiceMsg, Integer.valueOf(0) });
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TeamWorkHandler", 2, paramToServiceMsg, new Object[0]);
        }
        notifyUI(14, false, new Object[] { null, Integer.valueOf(0), null, Integer.valueOf(-1) });
        return;
      }
      paramToServiceMsg = "";
      continue;
      label537:
      paramFromServiceMsg = "";
    }
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("TimDocSvc.GetCreatedList");
      this.allowCmdSet.add("TimDocSvc.GetBrowseList");
      this.allowCmdSet.add("TimDocSvc.DeletePad");
      this.allowCmdSet.add("TimDocSvc.DeleteBrowseHistory");
      this.allowCmdSet.add("TimDocSvc.PinCreatedPad");
      this.allowCmdSet.add("TimDocSvc.PinBrowsePad");
      this.allowCmdSet.add("TimDocSvc.CancelPinCreatedPad");
      this.allowCmdSet.add("TimDocSvc.CancelPinBrowsePad");
      this.allowCmdSet.add("TimDocSvc.GetPadRightInfo");
      this.allowCmdSet.add("TimDocSvc.SetPadRightInfo");
      this.allowCmdSet.add("TimDocSvc.GetSharedPadList");
      this.allowCmdSet.add("TimDocSvc.PinSharedPad");
      this.allowCmdSet.add("TimDocSvc.CancelPinSharedPad");
      this.allowCmdSet.add("TimDocSvc.DeleteSharedPad");
      this.allowCmdSet.add("TimDocSvc.GetTipFlag");
      this.allowCmdSet.add("TimDocSvc.SetTipFlag");
      this.allowCmdSet.add("TimDocSvc.DeleteAllDocListPad");
      this.allowCmdSet.add("TimDocSvc.PinAllDocListPad");
      this.allowCmdSet.add("TimDocSvc.CancelPinAllDocListPad");
      this.allowCmdSet.add("TimDocSvc.GetAllDocList");
      this.allowCmdSet.add("OidbSvc.0xb05_3");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  public void nY(List<String> paramList)
  {
    if ((paramList == null) && (paramList.isEmpty())) {}
    ReSendCmd localReSendCmd;
    Object localObject;
    do
    {
      return;
      localReSendCmd = new ReSendCmd();
      localReSendCmd.cmd = 12;
      localReSendCmd.GP = paramList;
      localObject = a("batchGetPadInfo", localReSendCmd);
    } while (localObject == null);
    TimDocSSOMsg.BatchGetReqBody localBatchGetReqBody = new TimDocSSOMsg.BatchGetReqBody();
    localBatchGetReqBody.msg_login_info.set((MessageMicro)localObject);
    localBatchGetReqBody.uint32_appid.set(2);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (String)paramList.next();
      TimDocSSOMsg.PadId localPadId = new TimDocSSOMsg.PadId();
      localPadId.bytes_pad_url.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localBatchGetReqBody.rpt_msg_padid_list.add(localPadId);
    }
    paramList = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "TimDocSvc.BatchGetPadInfo");
    paramList.putWupBuffer(localBatchGetReqBody.toByteArray());
    if (localReSendCmd != null) {
      paramList.extraData.putParcelable("key_resend_cmd", localReSendCmd);
    }
    super.sendPbReq(paramList);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return aulm.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (("TimDocSvc.GetCreatedList".equals(paramFromServiceMsg.getServiceCmd())) || ("TimDocSvc.GetBrowseList".equals(paramFromServiceMsg.getServiceCmd())) || ("TimDocSvc.GetSharedPadList".equals(paramFromServiceMsg.getServiceCmd())) || ("TimDocSvc.GetAllDocList".equals(paramFromServiceMsg.getServiceCmd()))) {
      lX(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      ReSendCmd localReSendCmd;
      do
      {
        return;
        if ("TimDocSvc.DeletePad".equals(paramFromServiceMsg.getServiceCmd()))
        {
          ma(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("TimDocSvc.DeleteBrowseHistory".equals(paramFromServiceMsg.getServiceCmd()))
        {
          mb(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("TimDocSvc.DeleteSharedPad".equals(paramFromServiceMsg.getServiceCmd()))
        {
          if (paramToServiceMsg.extraData.getBoolean("is_batch"))
          {
            mc(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          mf(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (("TimDocSvc.PinBrowsePad".equals(paramFromServiceMsg.getServiceCmd())) || ("TimDocSvc.PinCreatedPad".equals(paramFromServiceMsg.getServiceCmd())) || ("TimDocSvc.PinSharedPad".equals(paramFromServiceMsg.getServiceCmd())) || ("TimDocSvc.PinAllDocListPad".equals(paramFromServiceMsg.getServiceCmd())))
        {
          md(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (("TimDocSvc.CancelPinCreatedPad".equals(paramFromServiceMsg.getServiceCmd())) || ("TimDocSvc.CancelPinBrowsePad".equals(paramFromServiceMsg.getServiceCmd())) || ("TimDocSvc.CancelPinSharedPad".equals(paramFromServiceMsg.getServiceCmd())) || ("TimDocSvc.CancelPinAllDocListPad".equals(paramFromServiceMsg.getServiceCmd())))
        {
          me(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("TimDocSvc.GetPadRightInfo".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
        {
          kU(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("TimDocSvc.SetPadRightInfo".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
        {
          kV(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("TimDocSvc.GetSharedPadList".equals(paramFromServiceMsg.getServiceCmd()))
        {
          lY(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("TimDocSvc.GetTipFlag".equals(paramFromServiceMsg.getServiceCmd()))
        {
          mg(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("TimDocSvc.SetTipFlag".equals(paramFromServiceMsg.getServiceCmd()))
        {
          mh(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (!"TimDocSvc.BatchGetPadInfo".equals(paramFromServiceMsg.getServiceCmd())) {
          break;
        }
        localReSendCmd = (ReSendCmd)paramToServiceMsg.extraData.getParcelable("key_resend_cmd");
        if (localReSendCmd.dNI == 0)
        {
          mi(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
      } while (localReSendCmd.dNI != 1);
      mj(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
      if ("TimDocSvc.DeleteAllDocListPad".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramToServiceMsg.extraData.getBoolean("is_batch"))
        {
          mc(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        lZ(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0xb05_3".equals(paramFromServiceMsg.getServiceCmd()));
    mk(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public boolean w(int paramInt, boolean paramBoolean)
  {
    long l;
    if (!paramBoolean) {
      if (paramInt == 1) {
        l = this.ayQ;
      }
    }
    while (System.currentTimeMillis() - l >= iB() * 1000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TeamWorkHandler", 2, "canBeGetPadListContinue isSuccess:" + true);
      }
      return true;
      if (paramInt == 3)
      {
        l = this.ayR;
      }
      else
      {
        l = this.ayP;
        continue;
        l = this.ayS;
      }
    }
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void b(Long paramLong1, Long paramLong2);
    
    public abstract void onError(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aulh
 * JD-Core Version:    0.7.0.1
 */