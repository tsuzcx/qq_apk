import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.troop.group_activity_info.RspBody;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import tencent.im.cs.modifyexamine.modifyexamine.ReqBody;
import tencent.im.cs.modifyexamine.modifyexamine.RspBody;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.ReqBody;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.RspBody;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpateBuffer;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpateResult;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpdateItem;
import tencent.im.oidb.cmd0x78f.oidb_0x78f.RspBody;
import tencent.im.oidb.cmd0x874.cmd0x874.ConvertToGroupReq;
import tencent.im.oidb.cmd0x874.cmd0x874.ConvertToGroupRsp;
import tencent.im.oidb.cmd0x874.cmd0x874.ReqBody;
import tencent.im.oidb.cmd0x874.cmd0x874.RspBody;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.GroupGeoInfo;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.ReqBody;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.RspBody;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.groupinfo;
import tencent.im.oidb.cmd0x8a1.cmd0x8a1.CreateGroupInfo;
import tencent.im.oidb.cmd0x8a1.cmd0x8a1.GroupGeoInfo;
import tencent.im.oidb.cmd0x8a1.cmd0x8a1.ReqBody;
import tencent.im.oidb.cmd0x8a1.cmd0x8a1.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.video_url.video_url.RspBody;
import tencent.qun.group_activity.group_activity.RspBody;

public class accc
  extends accg
{
  private String TAG = "TroopFileHandler";
  protected Map<String, Long> jg = new HashMap();
  protected Map<String, Long> jh = new HashMap();
  
  public accc(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public static long Z(String paramString)
  {
    try
    {
      long l = Long.valueOf(paramString).longValue();
      return l;
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  private void a(cmd0x874.RspBody paramRspBody)
  {
    String str = String.valueOf(paramRspBody.msg_convert_group.uint64_conf_uin.get());
    paramRspBody = String.valueOf(paramRspBody.msg_convert_group.uint64_group_code.get());
    if ((TextUtils.isEmpty(paramRspBody)) || (TextUtils.equals("0", paramRspBody)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "handleTransferDiscussionToTroop, troopUin:" + paramRspBody + "  discussionUin:" + str);
      }
      return;
    }
    Object localObject1 = new TroopInfo();
    ((TroopInfo)localObject1).troopuin = paramRspBody;
    ((TroopInfo)localObject1).dwAdditionalFlag = 1L;
    Object localObject2 = (TroopManager)this.app.getManager(52);
    if (localObject2 != null) {
      ((TroopManager)localObject2).k((TroopInfo)localObject1);
    }
    localObject2 = (acms)this.app.getBusinessHandler(20);
    if (localObject2 != null) {
      ((acms)localObject2).Fa(((TroopInfo)localObject1).troopuin);
    }
    localObject2 = (apbc)this.app.getManager(32);
    if (localObject2 != null) {
      ((apbc)localObject2).aS(this.app, ((TroopInfo)localObject1).troopuin);
    }
    localObject2 = (TroopManager)this.app.getManager(52);
    if (localObject2 != null) {
      ((TroopManager)localObject2).l(((TroopManager)localObject2).b(((TroopInfo)localObject1).troopuin));
    }
    localObject1 = (acdu)this.app.getManager(53);
    ((acdu)localObject1).jj.put(str, new String[] { paramRspBody, this.app.getCurrentAccountUin() });
    ((acdu)localObject1).bL.add(paramRspBody);
    notifyUI(41, true, new Object[] { Integer.valueOf(2131698372), str, paramRspBody, Boolean.valueOf(true) });
  }
  
  private void b(cmd0x874.RspBody paramRspBody)
  {
    notifyUI(41, false, new Object[] { Integer.valueOf(gs(paramRspBody.uint32_code.get())) });
  }
  
  private void bg(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"OidbSvc.0x8a1_0".equals(paramFromServiceMsg.getServiceCmd())) {}
    while (paramToServiceMsg.extraData.getInt("type", 0) != 2) {
      return;
    }
    bo(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void bh(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"OpenGroupSvc.GroupActivityInfo".equals(paramFromServiceMsg.getServiceCmd())) {}
    while ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str = paramToServiceMsg.extraData.getString("troopCode");
    boolean bool = paramToServiceMsg.extraData.getBoolean("isFromAIO");
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      if (bool) {
        this.jg.remove(str);
      }
      for (;;)
      {
        notifyUI(6, false, new Object[] { str, Boolean.valueOf(bool) });
        return;
        this.jh.remove(str);
      }
    }
    paramToServiceMsg = new group_activity_info.RspBody();
    try
    {
      paramToServiceMsg = (group_activity_info.RspBody)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg != null) && (paramToServiceMsg.error_code.get() == 0)) {
        break label262;
      }
      if (!bool) {
        break label247;
      }
      this.jg.remove(str);
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        if (bool) {
          this.jg.remove(str);
        }
        for (;;)
        {
          notifyUI(6, false, new Object[] { str, Boolean.valueOf(bool) });
          return;
          this.jh.remove(str);
        }
        this.jh.remove(str);
      }
    }
    notifyUI(6, false, new Object[] { str, Boolean.valueOf(bool) });
    return;
    label247:
    if (bool) {
      this.jg.remove(str);
    }
    for (;;)
    {
      label262:
      notifyUI(6, false, new Object[] { str, Boolean.valueOf(bool) });
      return;
      this.jh.remove(str);
    }
  }
  
  private void bi(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"OidbSvc.0x78f_1".equals(paramFromServiceMsg.getServiceCmd())) {}
    while ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str = paramToServiceMsg.extraData.getString("troopCode");
    long l = paramToServiceMsg.extraData.getLong("troopUin");
    int i = paramToServiceMsg.extraData.getInt("pageIndex");
    int j = paramToServiceMsg.extraData.getInt("pageCount");
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      notifyUI(12, false, new Object[] { str, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramFromServiceMsg.getResultCode()) });
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramObject = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramToServiceMsg = paramObject;
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      for (;;)
      {
        paramObject.printStackTrace();
      }
      k = paramToServiceMsg.uint32_result.get();
      if (k == 0) {
        break label291;
      }
      notifyUI(12, false, new Object[] { str, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      return;
      label291:
      paramFromServiceMsg = new oidb_0x78f.RspBody();
    }
    if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()))
    {
      notifyUI(12, false, new Object[] { str, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramFromServiceMsg.getResultCode()) });
      return;
    }
    try
    {
      int k;
      paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      try
      {
        paramToServiceMsg = aprd.a(l, paramFromServiceMsg.opt_msg_record.get().toByteArray(), paramFromServiceMsg.uint32_cur_cnt.get());
        notifyUI(12, true, new Object[] { Integer.valueOf(i), Integer.valueOf(paramFromServiceMsg.uint32_total_cnt.get()), Integer.valueOf(paramFromServiceMsg.uint32_cur_cnt.get()), paramToServiceMsg });
        return;
      }
      catch (IOException paramToServiceMsg)
      {
        notifyUI(12, false, new Object[] { str, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(-1) });
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        notifyUI(12, false, new Object[] { str, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(-1) });
      }
    }
  }
  
  private void bj(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"GroupActivity.GetList".equals(paramFromServiceMsg.getServiceCmd())) {}
    while ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    paramToServiceMsg = (ackn)this.app.getManager(22);
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      paramToServiceMsg.jf(null);
      notifyUI(11, false, null);
      return;
    }
    paramFromServiceMsg = new group_activity.RspBody();
    try
    {
      paramFromServiceMsg = (group_activity.RspBody)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.uint32_error_code.get() != 0))
      {
        paramToServiceMsg.jf(null);
        notifyUI(11, false, null);
        return;
      }
    }
    catch (Exception paramFromServiceMsg)
    {
      paramToServiceMsg.jf(null);
      notifyUI(11, false, null);
      return;
    }
    paramObject = paramFromServiceMsg.act_list.get();
    if (paramObject == null)
    {
      paramToServiceMsg.jf(null);
      notifyUI(11, false, null);
      return;
    }
    paramToServiceMsg.jf(paramObject);
    notifyUI(11, true, paramObject);
    if (aqiw.getSystemNetwork(this.app.getApplication().getApplicationContext()) == 1)
    {
      paramToServiceMsg = new String[3];
      paramToServiceMsg[0] = "param_WIFIRecommendTroopYunYingDownload";
      paramToServiceMsg[1] = "param_WIFIFlow";
      paramToServiceMsg[2] = "param_Flow";
    }
    for (;;)
    {
      this.app.sendAppDataIncerment(this.app.getCurrentAccountUin(), paramToServiceMsg, paramFromServiceMsg.getSerializedSize());
      return;
      paramToServiceMsg = new String[3];
      paramToServiceMsg[0] = "param_XGRecommendTroopYunYingDownload";
      paramToServiceMsg[1] = "param_XGFlow";
      paramToServiceMsg[2] = "param_Flow";
    }
  }
  
  private void bk(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"OidbSvc.0x5d6_1".equals(paramFromServiceMsg.getServiceCmd())) {}
    while ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    Object localObject2 = paramToServiceMsg.extraData.getString("troopUin");
    int j = paramToServiceMsg.extraData.getInt("reqType");
    boolean bool = paramToServiceMsg.extraData.getBoolean("isList");
    String str = paramToServiceMsg.extraData.getString("troop_delete_top_from_conversation");
    Object localObject1 = paramToServiceMsg.extraData.getStringArrayList("key_commonly_used_troop_list");
    if (localObject1 != null) {
      P((List)localObject1, j);
    }
    if (bool)
    {
      localObject1 = new Object[] { Integer.valueOf(-1), Integer.valueOf(j), null, null, str };
      if (paramFromServiceMsg.getResultCode() == 1000) {
        break label245;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 4, "handleSetCommonlyUsedTroop ResultCode=" + paramFromServiceMsg.getResultCode());
      }
      if (!bool) {
        break label238;
      }
    }
    label238:
    for (int i = 42;; i = 18)
    {
      notifyUI(i, false, localObject1);
      return;
      localObject1 = new Object[] { localObject2, Integer.valueOf(j), Integer.valueOf(-1), null, str };
      break;
    }
    label245:
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramObject = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramObject != null) && (paramObject.uint32_result.has()) && (paramObject.bytes_bodybuffer.has()) && (paramObject.bytes_bodybuffer.get() != null)) {
        break label389;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 4, "handleSetCommonlyUsedTroop sso empty");
      }
      if (!bool) {
        break label382;
      }
      i = 42;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 4, "handleSetCommonlyUsedTroop decode package failed");
        }
        if (bool) {}
        for (i = 42;; i = 18)
        {
          notifyUI(i, false, localObject1);
          return;
        }
        i = 18;
      }
      Object localObject3 = new oidb_0x5d6.RspBody();
      try
      {
        ((oidb_0x5d6.RspBody)localObject3).mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
        paramFromServiceMsg = ((oidb_0x5d6.RspBody)localObject3).str_wording.get();
        i = paramObject.uint32_result.get();
        localTroopManager = (TroopManager)this.app.getManager(52);
        paramObject = new StringBuilder("start handleSetCommonlyUsedTroop retCode =").append(i).append(" reqType=").append(j).append(" isList=").append(bool);
        if (!bool) {
          break label678;
        }
        localObject2 = ((oidb_0x5d6.RspBody)localObject3).rpt_msg_update_result.get();
        paramToServiceMsg = new HashMap();
        if (localObject2 == null) {
          break label619;
        }
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (oidb_0x5d6.SnsUpateResult)((Iterator)localObject2).next();
          paramToServiceMsg.put(localTroopManager.jq(String.valueOf(((oidb_0x5d6.SnsUpateResult)localObject3).uint64_uin.get())), Integer.valueOf(((oidb_0x5d6.SnsUpateResult)localObject3).uint32_result.get()));
          paramObject.append(" troopUin=").append(((oidb_0x5d6.SnsUpateResult)localObject3).uint64_uin.get());
        }
        i = 42;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        if (!bool) {
          break label860;
        }
      }
    }
    notifyUI(i, false, localObject1);
    return;
    label382:
    TroopManager localTroopManager;
    label389:
    label609:
    notifyUI(i, false, localObject1);
    return;
    label619:
    notifyUI(42, true, new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramToServiceMsg, paramFromServiceMsg, str });
    label659:
    if (QLog.isColorLevel())
    {
      QLog.d(this.TAG, 4, paramObject.toString());
      return;
      label678:
      if ((i != 0) || (localObject2 == null)) {
        break label785;
      }
      if (j != 0) {
        break label768;
      }
      localTroopManager.n((String)localObject2, paramToServiceMsg.extraData.getLong("timestamp"));
    }
    for (;;)
    {
      paramObject.append(" troopUin=").append((String)localObject2);
      notifyUI(18, true, new Object[] { localObject2, Integer.valueOf(j), Integer.valueOf(i), paramFromServiceMsg, str });
      break label659;
      break;
      label768:
      if (j == 1)
      {
        localTroopManager.kw((String)localObject2);
        continue;
        label785:
        if (i == 1224)
        {
          aqmj.W(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), (String)localObject2);
          paramToServiceMsg = (TroopManager)this.app.getManager(52);
          long l = NetConnInfoCenter.getServerTime();
          if (j == 0)
          {
            paramToServiceMsg.n((String)localObject2, l);
            break label870;
          }
          paramToServiceMsg.kw((String)localObject2);
          break label870;
          label860:
          i = 18;
          break label609;
        }
      }
      continue;
      label870:
      i = 0;
    }
  }
  
  private void bl(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"OidbSvc.0x580_1".equals(paramFromServiceMsg.getServiceCmd())) {}
    int i;
    long l1;
    String str;
    do
    {
      long l2;
      long l3;
      int j;
      int k;
      boolean bool;
      do
      {
        do
        {
          return;
        } while (paramFromServiceMsg.getResultCode() != 1000);
        i = paramToServiceMsg.extraData.getInt("appId");
        l1 = paramToServiceMsg.extraData.getLong("troopUin");
        l2 = paramToServiceMsg.extraData.getLong("troopCode");
        l3 = paramToServiceMsg.extraData.getLong("userUin");
        paramFromServiceMsg = paramToServiceMsg.extraData.getString("feedsId");
        j = paramToServiceMsg.extraData.getInt("time");
        str = paramToServiceMsg.extraData.getString("cmd");
        k = paramToServiceMsg.extraData.getInt("feedType");
        bool = paramToServiceMsg.extraData.getBoolean("aioRequest", false);
        paramToServiceMsg = (byte[])paramObject;
        paramToServiceMsg = aptr.a(this.app, i, l1, l2, l3, paramFromServiceMsg, j, paramToServiceMsg);
      } while ((TextUtils.isEmpty(str)) || (paramToServiceMsg == null));
      short s = (short)paramToServiceMsg.length;
      if ("OidbSvc.0x852_35".equals(str))
      {
        aptr.a(this.app, i, l1, l2, s, paramToServiceMsg, l3, paramFromServiceMsg, j);
        return;
      }
      if ("OidbSvc.0x852_48".equals(str))
      {
        aptr.a(this.app, i, l1, l2, s, paramToServiceMsg, (short)k, bool);
        return;
      }
    } while (!"OidbSvc.0x8ca_2".equals(str));
    ((acms)this.app.getBusinessHandler(20)).a(this.app, "" + l1, paramToServiceMsg, i);
  }
  
  private void bm(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"OidbSvc.0x852_35".equals(paramFromServiceMsg.getServiceCmd())) {}
    while (paramFromServiceMsg.getResultCode() != 1000) {
      return;
    }
    int i = paramToServiceMsg.extraData.getInt("appId");
    long l1 = paramToServiceMsg.extraData.getLong("troopUin");
    long l2 = paramToServiceMsg.extraData.getLong("troopCode");
    long l3 = paramToServiceMsg.extraData.getLong("userUin");
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("feedsId");
    int j = paramToServiceMsg.extraData.getInt("time");
    paramToServiceMsg = (byte[])paramObject;
    aptr.a(this.app, i, l1, l2, l3, paramFromServiceMsg, j, paramToServiceMsg);
  }
  
  private void bn(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"OidbSvc.0x852_48".equals(paramFromServiceMsg.getServiceCmd())) {}
    do
    {
      long l1;
      long l2;
      int j;
      do
      {
        do
        {
          return;
        } while (paramFromServiceMsg.getResultCode() != 1000);
        i = paramToServiceMsg.extraData.getInt("appId");
        l1 = paramToServiceMsg.extraData.getLong("troopUin");
        l2 = paramToServiceMsg.extraData.getLong("troopCode");
        paramToServiceMsg.extraData.getLong("userUin");
        paramFromServiceMsg = paramToServiceMsg.extraData.getString("feedsId");
        paramToServiceMsg.extraData.getInt("time");
        j = paramToServiceMsg.extraData.getInt("feedType");
        boolean bool = paramToServiceMsg.extraData.getBoolean("aioRequest", false);
        paramToServiceMsg = (byte[])paramObject;
        paramToServiceMsg = aptr.a(this.app, l1, l2, paramToServiceMsg, j, i, bool);
        if ((j == 23) && (paramToServiceMsg != null))
        {
          notifyUI(21, true, paramToServiceMsg);
          return;
        }
      } while ((j != 34) || (paramToServiceMsg == null));
      paramObject = this.app.b();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramToServiceMsg);
      int i = (int)anaz.gQ();
      paramObject.a().a(this.app, String.valueOf(l1), String.valueOf(l2), localArrayList, 34, i, 0, paramFromServiceMsg);
      paramToServiceMsg = this.app.getHandler(Conversation.class);
    } while (paramToServiceMsg == null);
    paramToServiceMsg.sendEmptyMessage(1009);
  }
  
  private void bo(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    apbc.e locale = new apbc.e();
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      notifyUI(28, false, locale);
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      notifyUI(28, false, locale);
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramFromServiceMsg == null)
      {
        notifyUI(28, false, locale);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      notifyUI(28, false, locale);
      return;
    }
    int i = paramFromServiceMsg.uint32_result.get();
    if ((i != 0) && ((i != 129) || (i != 130)))
    {
      locale.resultCode = i;
      notifyUI(28, false, locale);
      return;
    }
    paramToServiceMsg = new cmd0x8a1.RspBody();
    try
    {
      paramToServiceMsg.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      if ((paramToServiceMsg == null) || (paramToServiceMsg.uint32_create_option.get() != 1))
      {
        notifyUI(28, false, locale);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      notifyUI(28, false, locale);
      return;
    }
    paramFromServiceMsg = new TroopInfo();
    paramFromServiceMsg.troopuin = String.valueOf(paramToServiceMsg.uint32_group_code.get());
    notifyUI(28, true, paramFromServiceMsg);
  }
  
  private void bp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"OidbSvc.0x874_1".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      notifyUI(41, false, new Object[] { Integer.valueOf(2131698365) });
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      notifyUI(41, false, new Object[] { Integer.valueOf(2131698365) });
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null))
      {
        notifyUI(41, false, new Object[] { Integer.valueOf(2131698365) });
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      notifyUI(41, false, new Object[] { Integer.valueOf(2131698365) });
      return;
    }
    paramFromServiceMsg = new cmd0x874.RspBody();
    try
    {
      paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      if (paramFromServiceMsg.uint32_code.get() == 0)
      {
        a(paramFromServiceMsg);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      notifyUI(41, false, new Object[] { Integer.valueOf(2131698365) });
      return;
    }
    b(paramFromServiceMsg);
  }
  
  private void bq(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((!"OidbSvc.0x89a_0".equals(paramFromServiceMsg.getServiceCmd())) && (!"OidbSvc.0x570_8".equals(paramFromServiceMsg.getServiceCmd()))) {}
    int i;
    do
    {
      return;
      i = paramToServiceMsg.extraData.getInt("key_subcmd", -1);
      if (i == 1)
      {
        br(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (i == 2)
      {
        ((apsw)this.app.getManager(48)).jW(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (i == 3)
      {
        bw(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (i == 4)
      {
        bs(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (i != 9);
    bu(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void br(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      notifyUI(29, false, null);
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      notifyUI(29, false, null);
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramToServiceMsg == null)
      {
        notifyUI(29, false, null);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      notifyUI(29, false, null);
      return;
    }
    paramFromServiceMsg = new oidb_0x89a.RspBody();
    try
    {
      paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      if (paramFromServiceMsg == null)
      {
        notifyUI(29, false, null);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      notifyUI(29, false, null);
      return;
    }
    int i = paramToServiceMsg.uint32_result.get();
    if (i != 0)
    {
      paramToServiceMsg = new String(paramFromServiceMsg.str_errorinfo.get().toByteArray());
      notifyUI(29, false, new Object[] { Long.valueOf(i), paramToServiceMsg });
      return;
    }
    notifyUI(29, true, new Object[] { Long.valueOf(paramFromServiceMsg.uint64_group_code.get()), "" });
  }
  
  private void bs(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      notifyUI(43, false, null);
      return;
    }
    String str1 = paramToServiceMsg.extraData.getString("name");
    String str2 = paramToServiceMsg.extraData.getString("troopUin");
    paramToServiceMsg = new Object[4];
    paramToServiceMsg[0] = str2;
    paramToServiceMsg[1] = str1;
    paramToServiceMsg[2] = null;
    paramToServiceMsg[3] = Integer.valueOf(0);
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      notifyUI(43, false, paramToServiceMsg);
      return;
    }
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if (paramFromServiceMsg == null)
      {
        notifyUI(43, false, paramToServiceMsg);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      notifyUI(43, false, paramToServiceMsg);
      return;
    }
    paramObject = new oidb_0x89a.RspBody();
    try
    {
      paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      int i = paramFromServiceMsg.uint32_result.get();
      if (i != 0)
      {
        if (paramObject.str_errorinfo.has()) {
          paramToServiceMsg[2] = paramObject.str_errorinfo.get().toStringUtf8();
        }
        if (i == 1328) {
          paramToServiceMsg[2] = acfp.m(2131703235);
        }
        paramToServiceMsg[3] = Integer.valueOf(i);
        notifyUI(43, false, paramToServiceMsg);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      notifyUI(43, false, paramToServiceMsg);
      return;
    }
    long l = paramObject.uint64_group_code.get();
    notifyUI(43, true, new Object[] { "" + l, str1, null });
  }
  
  private void bt(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"VideoShareSrv.get_video_src".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    paramToServiceMsg = paramToServiceMsg.extraData.getString("pageUrl");
    ArrayList localArrayList = new ArrayList();
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      notifyUI(25, false, new Object[] { paramToServiceMsg, localArrayList, Integer.valueOf(-1) });
      return;
    }
    paramFromServiceMsg = new video_url.RspBody();
    try
    {
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if (paramFromServiceMsg.int32_result.get() != 0)
      {
        notifyUI(25, false, new Object[] { paramToServiceMsg, localArrayList, Integer.valueOf(-1) });
        return;
      }
    }
    catch (Exception paramFromServiceMsg)
    {
      notifyUI(25, false, new Object[] { paramToServiceMsg, localArrayList, Integer.valueOf(-1) });
      return;
    }
    paramObject = paramFromServiceMsg.rpt_bytes_play_urls.get();
    int i = paramFromServiceMsg.uint32_total_time.get();
    paramFromServiceMsg = paramObject.iterator();
    while (paramFromServiceMsg.hasNext()) {
      localArrayList.add(new String(((ByteStringMicro)paramFromServiceMsg.next()).toByteArray()));
    }
    notifyUI(25, true, new Object[] { paramToServiceMsg, localArrayList, Integer.valueOf(i) });
  }
  
  private void bu(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      notifyUI(44, false, null);
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "handleConfessTalkSwitch req or resp is null.");
      }
    }
    label150:
    label300:
    long l;
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (paramFromServiceMsg.getResultCode() != 1000)
          {
            notifyUI(44, false, null);
            if (QLog.isColorLevel()) {
              QLog.i(this.TAG, 2, "handleConfessTalkSwitch resp result code not ok.");
            }
          }
          else
          {
            paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
            try
            {
              paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
              if (paramToServiceMsg != null) {
                break label150;
              }
              notifyUI(44, false, null);
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i(this.TAG, 2, "handleConfessTalkSwitch sso pkg is null.");
              return;
            }
            catch (InvalidProtocolBufferMicroException paramToServiceMsg)
            {
              notifyUI(44, false, null);
            }
            if (QLog.isColorLevel())
            {
              QLog.i(this.TAG, 2, "handleConfessTalkSwitch InvalidProtocolBufferMicroException");
              return;
              int i = paramToServiceMsg.uint32_result.get();
              if (i != 0)
              {
                notifyUI(44, false, new Object[] { Long.valueOf(i) });
                if (QLog.isColorLevel()) {
                  QLog.i(this.TAG, 2, "handleConfessTalkSwitch result code != 0 resultCode : " + i);
                }
              }
              else
              {
                paramFromServiceMsg = new oidb_0x89a.RspBody();
                try
                {
                  paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
                  if (paramFromServiceMsg != null) {
                    break label300;
                  }
                  notifyUI(44, false, null);
                  if (QLog.isColorLevel())
                  {
                    QLog.i(this.TAG, 2, "handleConfessTalkSwitch rspBody is null.");
                    return;
                  }
                }
                catch (InvalidProtocolBufferMicroException paramToServiceMsg)
                {
                  notifyUI(44, false, null);
                }
              }
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.i(this.TAG, 2, "handleConfessTalkSwitch InvalidProtocolBufferMicroException.");
      return;
      l = paramFromServiceMsg.uint64_group_code.get();
      notifyUI(44, true, new Object[] { Long.valueOf(l) });
    } while (!QLog.isColorLevel());
    QLog.i(this.TAG, 2, "handleConfessTalkSwitch success, troopCode is: " + l);
  }
  
  private int gs(int paramInt)
  {
    int[] arrayOfInt = new int[11];
    int[] tmp6_5 = arrayOfInt;
    tmp6_5[0] = 2131698372;
    int[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 2131698368;
    int[] tmp17_11 = tmp11_6;
    tmp17_11[2] = 2131698364;
    int[] tmp23_17 = tmp17_11;
    tmp23_17[3] = 2131698367;
    int[] tmp29_23 = tmp23_17;
    tmp29_23[4] = 2131698371;
    int[] tmp35_29 = tmp29_23;
    tmp35_29[5] = 2131698369;
    int[] tmp41_35 = tmp35_29;
    tmp41_35[6] = 2131698374;
    int[] tmp48_41 = tmp41_35;
    tmp48_41[7] = 2131698366;
    int[] tmp55_48 = tmp48_41;
    tmp55_48[8] = 2131698373;
    int[] tmp62_55 = tmp55_48;
    tmp62_55[9] = 2131698365;
    int[] tmp69_62 = tmp62_55;
    tmp69_62[10] = 2131698370;
    tmp69_62;
    if ((paramInt >= 0) && (paramInt < arrayOfInt.length)) {
      return arrayOfInt[paramInt];
    }
    return 2131698365;
  }
  
  public void B(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG + ".troop.location_info", 2, "modifyTroopName==>name:" + paramString2);
    }
    Object localObject1 = new oidb_0x89a.ReqBody();
    for (;;)
    {
      try
      {
        long l = Long.parseLong(paramString1);
        ((oidb_0x89a.ReqBody)localObject1).uint64_group_code.set(l);
        Object localObject2 = new oidb_0x89a.groupinfo();
        if (!TextUtils.isEmpty(paramString2)) {
          ((oidb_0x89a.groupinfo)localObject2).string_group_name.set(ByteStringMicro.copyFromUtf8(paramString2));
        }
        ((oidb_0x89a.ReqBody)localObject1).st_group_info.set((MessageMicro)localObject2);
        if (paramBoolean)
        {
          i = 15;
          localObject2 = new oidb_sso.OIDBSSOPkg();
          ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2202);
          ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
          ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(i);
          ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x89a.ReqBody)localObject1).toByteArray()));
          localObject1 = createToServiceMsg("OidbSvc.0x89a_0");
          ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
          ((ToServiceMsg)localObject1).extraData.putInt("key_subcmd", 4);
          ((ToServiceMsg)localObject1).extraData.putString("troopUin", paramString1);
          ((ToServiceMsg)localObject1).extraData.putString("name", paramString2);
          sendPbReq((ToServiceMsg)localObject1);
          return;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      int i = 0;
    }
  }
  
  public boolean N(String paramString, int paramInt)
  {
    int j = jqc.getNetWorkType();
    int i = j;
    if (j == -1) {
      i = 2;
    }
    if (i == 0)
    {
      QQToast.a(BaseApplication.getContext(), 2131698346, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299627));
      return false;
    }
    O(paramString, paramInt, null);
    return true;
  }
  
  public void O(String paramString1, int paramInt, @Nullable String paramString2)
  {
    if (!aqiw.isNetworkAvailable(null)) {
      return;
    }
    Object localObject1 = (TroopManager)this.app.getManager(52);
    String str = ((TroopManager)localObject1).jp(paramString1);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "setCommonlyUsedTroop, troopCode = " + paramString1 + ", troopUin = " + str + " from" + paramString2);
    }
    if (aqmj.f(this.app.getApplication(), this.app.getCurrentAccountUin()).contains(str))
    {
      l = NetConnInfoCenter.getServerTime();
      if (paramInt == 0) {
        ((TroopManager)localObject1).n(str, l);
      }
      for (;;)
      {
        notifyUI(18, true, new Object[] { str, Integer.valueOf(paramInt), Integer.valueOf(0), null });
        return;
        ((TroopManager)localObject1).kw(str);
      }
    }
    Object localObject2 = new oidb_0x5d6.SnsUpdateItem();
    ((oidb_0x5d6.SnsUpdateItem)localObject2).uint32_update_sns_type.set(13569);
    long l = NetConnInfoCenter.getServerTime();
    if (paramInt == 0)
    {
      int i = (byte)(int)(l >> 24 & 0xFF);
      int j = (byte)(int)(l >> 16 & 0xFF);
      int k = (byte)(int)(l >> 8 & 0xFF);
      int m = (byte)(int)(0xFF & l);
      ((oidb_0x5d6.SnsUpdateItem)localObject2).bytes_value.set(ByteStringMicro.copyFrom(new byte[] { i, j, k, m }));
    }
    for (;;)
    {
      localObject1 = new ArrayList();
      ((List)localObject1).add(localObject2);
      localObject2 = new oidb_0x5d6.SnsUpateBuffer();
      ((oidb_0x5d6.SnsUpateBuffer)localObject2).uint64_uin.set(Z(paramString1));
      ((oidb_0x5d6.SnsUpateBuffer)localObject2).rpt_msg_sns_update_item.set((List)localObject1);
      paramString1 = new ArrayList();
      paramString1.add(localObject2);
      localObject1 = new oidb_0x5d6.ReqBody();
      ((oidb_0x5d6.ReqBody)localObject1).uint32_domain.set(11);
      ((oidb_0x5d6.ReqBody)localObject1).uint32_seq.set(0);
      ((oidb_0x5d6.ReqBody)localObject1).rpt_msg_update_buffer.set(paramString1);
      paramString1 = new oidb_sso.OIDBSSOPkg();
      paramString1.uint32_command.set(1494);
      paramString1.uint32_result.set(0);
      paramString1.uint32_service_type.set(11);
      paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d6.ReqBody)localObject1).toByteArray()));
      localObject1 = createToServiceMsg("OidbSvc.0x5d6_1");
      ((ToServiceMsg)localObject1).extraData.putString("troopUin", str);
      ((ToServiceMsg)localObject1).extraData.putInt("reqType", paramInt);
      ((ToServiceMsg)localObject1).extraData.putLong("timestamp", l);
      ((ToServiceMsg)localObject1).extraData.putInt("update_sns_type", 13569);
      ((ToServiceMsg)localObject1).extraData.putString("source_from", paramString2);
      ((ToServiceMsg)localObject1).putWupBuffer(paramString1.toByteArray());
      sendPbReq((ToServiceMsg)localObject1);
      return;
      if (paramInt != 1) {}
    }
  }
  
  public void P(List<String> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "setCommonlyUsedTroopList， troopUinList is null or empty ...");
      }
      return;
    }
    TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
    long l = NetConnInfoCenter.getServerTime();
    Object localObject1 = new ArrayList();
    ArrayList localArrayList1;
    if (paramList.size() > 20)
    {
      localArrayList1 = new ArrayList(paramList.subList(19, paramList.size()));
      paramList = paramList.subList(0, 19);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "troopUinList.size() > 20， troopUinListLeft size :" + localArrayList1.size());
      }
    }
    for (;;)
    {
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        String str = (String)paramList.next();
        Object localObject2 = new oidb_0x5d6.SnsUpdateItem();
        ((oidb_0x5d6.SnsUpdateItem)localObject2).uint32_update_sns_type.set(13569);
        if (paramInt == 0)
        {
          int i = (byte)(int)(l >> 24 & 0xFF);
          int j = (byte)(int)(l >> 16 & 0xFF);
          int k = (byte)(int)(l >> 8 & 0xFF);
          int m = (byte)(int)(0xFF & l);
          ((oidb_0x5d6.SnsUpdateItem)localObject2).bytes_value.set(ByteStringMicro.copyFrom(new byte[] { i, j, k, m }));
        }
        for (;;)
        {
          ArrayList localArrayList2 = new ArrayList();
          localArrayList2.add(localObject2);
          localObject2 = new oidb_0x5d6.SnsUpateBuffer();
          ((oidb_0x5d6.SnsUpateBuffer)localObject2).uint64_uin.set(Z(localTroopManager.jr(str)));
          ((oidb_0x5d6.SnsUpateBuffer)localObject2).rpt_msg_sns_update_item.set(localArrayList2);
          ((List)localObject1).add(localObject2);
          break;
          if (paramInt != 1) {}
        }
      }
      paramList = new oidb_0x5d6.ReqBody();
      paramList.uint32_domain.set(11);
      paramList.uint32_seq.set(0);
      paramList.rpt_msg_update_buffer.set((List)localObject1);
      localObject1 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1494);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(11);
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramList.toByteArray()));
      paramList = createToServiceMsg("OidbSvc.0x5d6_1");
      paramList.extraData.putBoolean("isList", true);
      paramList.extraData.putInt("reqType", paramInt);
      paramList.extraData.putLong("timestamp", l);
      paramList.extraData.putInt("update_sns_type", 13569);
      paramList.extraData.putStringArrayList("key_commonly_used_troop_list", localArrayList1);
      paramList.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
      sendPbReq(paramList);
      return;
      localArrayList1 = null;
    }
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, long paramLong3, long paramLong4, int paramInt5, String paramString3, byte[] paramArrayOfByte, int paramInt6)
  {
    cmd0x8a1.ReqBody localReqBody = new cmd0x8a1.ReqBody();
    localReqBody.uint32_create_option.set(1);
    cmd0x8a1.CreateGroupInfo localCreateGroupInfo = new cmd0x8a1.CreateGroupInfo();
    localCreateGroupInfo.uint32_group_code.set((int)paramLong1);
    localCreateGroupInfo.uint32_group_size.set(paramInt1);
    localCreateGroupInfo.uint64_owner_uin.set(paramLong2);
    localCreateGroupInfo.uint32_group_option.set(paramInt2);
    localCreateGroupInfo.string_group_name.set(ByteStringMicro.copyFromUtf8(paramString1));
    localCreateGroupInfo.string_group_finger_memo.set(ByteStringMicro.copyFromUtf8(paramString2));
    localCreateGroupInfo.string_group_rich_finger_memo.set(ByteStringMicro.copyFromUtf8(paramString2));
    localCreateGroupInfo.uint32_group_class.set(0);
    localCreateGroupInfo.uint32_group_class_ext.set(paramInt3);
    localCreateGroupInfo.uint32_group_type_flag.set(paramInt4);
    paramString1 = new cmd0x8a1.GroupGeoInfo();
    paramString1.uint32_city_id.set(paramInt5);
    paramString1.uint64_latitude.set(paramLong3);
    paramString1.uint64_longtitude.set(paramLong4);
    paramString1.string_geo_content.set(ByteStringMicro.copyFromUtf8(paramString3));
    localCreateGroupInfo.msg_group_geo_info.set(paramString1);
    localCreateGroupInfo.string_sign.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localCreateGroupInfo.uint64_create_flag.set(16L);
    localCreateGroupInfo.uint32_group_face.set(0);
    localCreateGroupInfo.uint32_app_id.set(200000007);
    localReqBody.msg_create_group_info.set(localCreateGroupInfo);
    paramString1 = new oidb_sso.OIDBSSOPkg();
    paramString1.uint32_command.set(2209);
    paramString1.uint32_result.set(0);
    paramString1.uint32_service_type.set(7);
    paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramString2 = createToServiceMsg("OidbSvc.0x8a1_0");
    paramString2.putWupBuffer(paramString1.toByteArray());
    paramString2.extraData.putInt("type", 2);
    sendPbReq(paramString2);
  }
  
  public void a(long paramLong1, int paramInt1, String paramString1, long paramLong2, List<String> paramList, int paramInt2, long paramLong3, long paramLong4, long paramLong5, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG + ".troop.location_info", 2, "modifyTroopInfoBy0x89a==>cityId:" + paramInt2 + "|lat:" + paramLong3 + "|lon:" + paramLong4);
    }
    oidb_0x89a.ReqBody localReqBody = new oidb_0x89a.ReqBody();
    localReqBody.uint64_group_code.set(paramLong1);
    oidb_0x89a.groupinfo localgroupinfo = new oidb_0x89a.groupinfo();
    localgroupinfo.uint32_group_type_flag.set(paramInt1);
    if (!TextUtils.isEmpty(paramString1)) {
      localgroupinfo.string_group_name.set(ByteStringMicro.copyFromUtf8(paramString1));
    }
    localgroupinfo.uint32_group_class_ext.set((int)paramLong2);
    paramString1 = apyh.a(BaseApplicationImpl.getApplication()).a(BaseApplicationImpl.getApplication(), String.valueOf(localgroupinfo.uint32_group_class_ext.get()));
    if (paramString1 != null) {
      localgroupinfo.string_group_class_text.set(ByteStringMicro.copyFromUtf8(paramString1.name));
    }
    paramString1 = new ArrayList();
    if (paramList != null)
    {
      paramInt1 = 0;
      while (paramInt1 < paramList.size())
      {
        if (!TextUtils.isEmpty((CharSequence)paramList.get(paramInt1))) {
          paramString1.add(ByteStringMicro.copyFromUtf8((String)paramList.get(paramInt1)));
        }
        paramInt1 += 1;
      }
    }
    if (paramString1.size() == 0) {
      paramString1.add(ByteStringMicro.copyFrom("".getBytes()));
    }
    localgroupinfo.rpt_string_group_tag.set(paramString1);
    if ((paramLong3 != 0L) || (paramLong4 != 0L))
    {
      paramString1 = new oidb_0x89a.GroupGeoInfo();
      paramString1.uint32_city_id.set(paramInt2);
      paramString1.uint64_latitude.set(paramLong3);
      paramString1.uint64_longtitude.set(paramLong4);
      if (paramString2 != null) {
        paramString1.string_geo_content.set(ByteStringMicro.copyFromUtf8(paramString2));
      }
      paramString1.uint64_poi_id.set(paramLong5);
      localgroupinfo.msg_group_geo_info.set(paramString1);
    }
    if (paramString3 != null)
    {
      localgroupinfo.string_group_finger_memo.set(ByteStringMicro.copyFromUtf8(paramString3));
      localgroupinfo.string_group_rich_finger_memo.set(ByteStringMicro.copyFromUtf8(paramString3));
    }
    localReqBody.st_group_info.set(localgroupinfo);
    paramString1 = new oidb_sso.OIDBSSOPkg();
    paramString1.uint32_command.set(2202);
    paramString1.uint32_result.set(0);
    paramString1.uint32_service_type.set(0);
    paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramList = createToServiceMsg("OidbSvc.0x89a_0");
    paramList.putWupBuffer(paramString1.toByteArray());
    paramList.extraData.putInt("key_subcmd", 1);
    sendPbReq(paramList);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramString = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), paramString);
    paramString.putWupBuffer(paramArrayOfByte);
    if (paramBundle != null) {
      paramString.extraData = paramBundle;
    }
    sendPbReq(paramString);
  }
  
  public void aD(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = ByteBuffer.allocate(5);
    for (;;)
    {
      try
      {
        ((ByteBuffer)localObject).putInt(Integer.valueOf(paramString).intValue());
        if (!paramBoolean) {
          break label155;
        }
        ((ByteBuffer)localObject).put((byte)1);
        localObject = ((ByteBuffer)localObject).array();
        paramString = new oidb_sso.OIDBSSOPkg();
        paramString.uint32_command.set(1384);
        paramString.uint32_result.set(0);
        paramString.uint32_service_type.set(22);
        paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom((byte[])localObject));
        localObject = createToServiceMsg("OidbSvc.0x568_22");
        ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
        ((ToServiceMsg)localObject).extraData.putBoolean("isAllowAnonymousChat", paramBoolean);
        sendPbReq((ToServiceMsg)localObject);
        return;
      }
      catch (NumberFormatException localNumberFormatException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.TAG, 2, "setAnonymousChat failed because NumberFormatException, troopUin : " + paramString);
      return;
      label155:
      localNumberFormatException.put((byte)0);
    }
  }
  
  public void aE(String paramString, boolean paramBoolean)
  {
    Object localObject = new oidb_0x89a.ReqBody();
    ((oidb_0x89a.ReqBody)localObject).uint64_group_code.set(Long.valueOf(paramString).longValue());
    paramString = new oidb_0x89a.groupinfo();
    if (!paramBoolean) {}
    for (int i = 8192;; i = 0)
    {
      paramString.uint32_group_flagext3.set(i);
      paramString.uint32_group_flagext3_mask.set(8192);
      ((oidb_0x89a.ReqBody)localObject).st_group_info.set(paramString);
      paramString = new oidb_sso.OIDBSSOPkg();
      paramString.uint32_command.set(2202);
      paramString.uint32_result.set(0);
      paramString.uint32_service_type.set(0);
      paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x89a.ReqBody)localObject).toByteArray()));
      localObject = createToServiceMsg("OidbSvc.0x89a_0");
      ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
      ((ToServiceMsg)localObject).extraData.putInt("key_subcmd", 9);
      sendPbReq((ToServiceMsg)localObject);
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "setConfessTalkSwitch isOn :" + paramBoolean);
      }
      return;
    }
  }
  
  public void aQ(Object paramObject)
  {
    notifyUI(9, true, paramObject);
  }
  
  public void aR(Object paramObject)
  {
    notifyUI(13, true, paramObject);
  }
  
  public void aS(Object paramObject)
  {
    notifyUI(20, true, paramObject);
  }
  
  public void aT(Object paramObject)
  {
    notifyUI(22, true, paramObject);
  }
  
  public void bv(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"OidbSvc.0x568_22".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    boolean bool = paramToServiceMsg.extraData.getBoolean("isAllowAnonymousChat", false);
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      notifyUI(30, false, Boolean.valueOf(bool));
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null))
      {
        notifyUI(30, false, Boolean.valueOf(bool));
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      notifyUI(30, false, Boolean.valueOf(bool));
      return;
    }
    if (paramToServiceMsg.uint32_result.get() != 0)
    {
      notifyUI(30, false, Boolean.valueOf(bool));
      return;
    }
    notifyUI(30, true, Boolean.valueOf(bool));
  }
  
  public void bw(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      notifyUI(36, false, null);
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      notifyUI(36, false, null);
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramToServiceMsg == null)
      {
        notifyUI(36, false, null);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      notifyUI(36, false, null);
      return;
    }
    int i = paramToServiceMsg.uint32_result.get();
    if (i != 0)
    {
      notifyUI(36, false, new Object[] { Long.valueOf(i) });
      return;
    }
    paramFromServiceMsg = new oidb_0x89a.RspBody();
    try
    {
      paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      if (paramFromServiceMsg == null)
      {
        notifyUI(36, false, null);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      notifyUI(36, false, null);
      return;
    }
    notifyUI(36, true, new Object[] { Long.valueOf(paramFromServiceMsg.uint64_group_code.get()) });
  }
  
  public void bx(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l3 = -1L;
    if (!"ModifyExamine.GetModifyTimes".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      notifyUI(38, false, null);
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      notifyUI(38, false, null);
      return;
    }
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      notifyUI(38, false, null);
      return;
    }
    paramToServiceMsg = (byte[])paramObject;
    paramFromServiceMsg = new modifyexamine.RspBody();
    for (;;)
    {
      try
      {
        paramFromServiceMsg.mergeFrom(paramToServiceMsg);
        if (!paramFromServiceMsg.uint32_result.has()) {
          break label250;
        }
        l1 = paramFromServiceMsg.uint32_result.get();
        if (!paramFromServiceMsg.uint32_limit_times.has()) {
          break label242;
        }
        l2 = paramFromServiceMsg.uint32_limit_times.get();
        if (paramFromServiceMsg.uint32_modify_times.has()) {
          l3 = paramFromServiceMsg.uint32_modify_times.get();
        }
        paramToServiceMsg = "";
        if (paramFromServiceMsg.str_errmsg.has()) {
          paramToServiceMsg = paramFromServiceMsg.str_errmsg.get();
        }
        notifyUI(38, true, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), paramToServiceMsg });
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i(this.TAG, 4, "onRspResend parsing error");
      return;
      label242:
      long l2 = -1L;
      continue;
      label250:
      long l1 = -1L;
    }
  }
  
  public void by(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"GroupFileAppSvr.GetFileInfo".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    notifyUI(39, true, paramObject);
  }
  
  public void bz(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"GroupFileAppSvr.GetFileSearch".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    notifyUI(40, true, paramObject);
  }
  
  public void eC(String paramString1, String paramString2)
  {
    modifyexamine.ReqBody localReqBody = new modifyexamine.ReqBody();
    localReqBody.uint64_gc.set(Long.valueOf(paramString1).longValue());
    localReqBody.skey.set(paramString2);
    paramString1 = createToServiceMsg("ModifyExamine.GetModifyTimes");
    paramString1.putWupBuffer(localReqBody.toByteArray());
    sendPbReq(paramString1);
  }
  
  public void hh(long paramLong)
  {
    Object localObject1 = new cmd0x874.ReqBody();
    ((cmd0x874.ReqBody)localObject1).uint32_subcmd.set(1);
    Object localObject2 = new cmd0x874.ConvertToGroupReq();
    ((cmd0x874.ConvertToGroupReq)localObject2).uint64_conf_uin.set(paramLong);
    ((cmd0x874.ReqBody)localObject1).msg_convert_group.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2164);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x874.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg("OidbSvc.0x874_1");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x89b_1");
      this.allowCmdSet.add("OidbSvc.0x8a1_0");
      this.allowCmdSet.add("GroupFileAppSvr.DelFile");
      this.allowCmdSet.add("GroupFileAppSvr.GetFileList");
      this.allowCmdSet.add("GroupFileAppSvr.GetFileListV2");
      this.allowCmdSet.add("GroupFileAppSvr.GetFileInfo");
      this.allowCmdSet.add("GroupFileAppSvr.GetFileSearch");
      this.allowCmdSet.add("CommunityForum.GetLatestPost");
      this.allowCmdSet.add("OpenGroupSvc.GroupActivityInfo");
      this.allowCmdSet.add("GroupActivity.GetList");
      this.allowCmdSet.add("OidbSvc.0x78f_1");
      this.allowCmdSet.add("OidbSvc.0x5d6_3");
      this.allowCmdSet.add("OidbSvc.0x5d6_1");
      this.allowCmdSet.add("OidbSvc.0x8cf_6");
      this.allowCmdSet.add("OidbSvc.0x8d3_1");
      this.allowCmdSet.add("OidbSvc.0x852_35");
      this.allowCmdSet.add("OidbSvc.0x580_1");
      this.allowCmdSet.add("OidbSvc.0x88c_1");
      this.allowCmdSet.add("OidbSvc.0x852_48");
      this.allowCmdSet.add("OidbSvc.0x89a_0");
      this.allowCmdSet.add("OidbSvc.0x570_8");
      this.allowCmdSet.add("VideoShareSrv.get_video_src");
      this.allowCmdSet.add("OidbSvc.0x568_22");
      this.allowCmdSet.add("OidbSvc.0x568_21");
      this.allowCmdSet.add("GrpMemberLBS.ReportLBS");
      this.allowCmdSet.add("OidbSvc.0x8b4");
      this.allowCmdSet.add("ModifyExamine.GetModifyTimes");
      this.allowCmdSet.add("OidbSvc.0x874_1");
      this.allowCmdSet.add("OidbSvc.0x904_1");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return accd.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(this.TAG, 4, "onReceive");
    }
    if (QLog.isDevelopLevel()) {
      QLog.d(this.TAG, 4, "res.getServiceCmd():" + paramFromServiceMsg.getServiceCmd());
    }
    String str = paramFromServiceMsg.getServiceCmd();
    if (msgCmdFilter(str))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "cmdfilter error=" + str);
      }
      return;
    }
    bg(paramToServiceMsg, paramFromServiceMsg, paramObject);
    bp(paramToServiceMsg, paramFromServiceMsg, paramObject);
    bq(paramToServiceMsg, paramFromServiceMsg, paramObject);
    bh(paramToServiceMsg, paramFromServiceMsg, paramObject);
    bj(paramToServiceMsg, paramFromServiceMsg, paramObject);
    bi(paramToServiceMsg, paramFromServiceMsg, paramObject);
    bk(paramToServiceMsg, paramFromServiceMsg, paramObject);
    bl(paramToServiceMsg, paramFromServiceMsg, paramObject);
    bm(paramToServiceMsg, paramFromServiceMsg, paramObject);
    bn(paramToServiceMsg, paramFromServiceMsg, paramObject);
    bt(paramToServiceMsg, paramFromServiceMsg, paramObject);
    bv(paramToServiceMsg, paramFromServiceMsg, paramObject);
    bx(paramToServiceMsg, paramFromServiceMsg, paramObject);
    by(paramToServiceMsg, paramFromServiceMsg, paramObject);
    bz(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     accc
 * JD-Core Version:    0.7.0.1
 */