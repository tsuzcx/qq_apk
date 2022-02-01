import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler.1;
import com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler.4;
import com.tencent.biz.pubaccount.ecshopassit.view.CustomTabView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
import tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp;
import tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp.AdInfo;
import tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp.PosAdInfo;
import tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp.RedPointInfo;
import tencent.im.oidb.qqshop.qq_ad.QQAdReport;
import tencent.im.oidb.qqshop.qq_ad.QQAdReportRsp;

public class kds
  extends accg
{
  public static int aIc = 300000;
  public boolean Bu;
  public Set<Long> I = new HashSet();
  String Yw;
  public long et;
  public long rO;
  
  public kds(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    ThreadManagerV2.excute(new EcshopAdHandler.1(this), 16, null, false);
  }
  
  private List<ChatMessage> a(List<ChatMessage> paramList, long paramLong)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      ChatMessage localChatMessage = (ChatMessage)paramList.get(i);
      Object localObject;
      if ((localChatMessage instanceof MessageForArkApp))
      {
        localObject = ((MessageForArkApp)localChatMessage).ark_app_message;
        if (localObject != null)
        {
          localObject = ((ArkAppMessage)localObject).metaList;
          if (aqmr.isEmpty((String)localObject)) {}
        }
      }
      for (;;)
      {
        try
        {
          localObject = new JSONObject((String)localObject).optJSONObject("gdt");
          if ((QLog.isColorLevel()) && (localObject != null)) {
            QLog.i("EcshopAdHandler", 2, "---aid---" + paramLong + "gdtJson: " + ((JSONObject)localObject).optString("aid"));
          }
          if ((localObject != null) && (paramLong == ((JSONObject)localObject).optLong("aid"))) {
            localArrayList.add(localChatMessage);
          }
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          continue;
        }
        i += 1;
        break;
        long l1;
        if ((localException1 instanceof MessageForStructing))
        {
          localObject = ((MessageForStructing)localException1).structingMsg;
          if ((localObject instanceof StructMsgForGeneralShare))
          {
            localObject = (StructMsgForGeneralShare)localObject;
            if ((((StructMsgForGeneralShare)localObject).mStructMsgItemLists != null) && (((StructMsgForGeneralShare)localObject).mStructMsgItemLists.size() > 0))
            {
              localObject = (anqu)((StructMsgForGeneralShare)localObject).mStructMsgItemLists.get(0);
              if (localObject != null) {
                l1 = 0L;
              }
            }
          }
        }
        try
        {
          long l2 = Long.parseLong(((anqu)localObject).chj);
          l1 = l2;
        }
        catch (Exception localException2)
        {
          label294:
          break label294;
        }
        if (QLog.isColorLevel()) {
          QLog.i("EcshopAdHandler", 2, "---aid---" + l1);
        }
        if (paramLong == l1) {
          localArrayList.add(localException1);
        }
      }
    }
    return localArrayList;
  }
  
  /* Error */
  public static kds.a a(kds.a parama, MessageRecord paramMessageRecord)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aload_0
    //   5: areturn
    //   6: aload_1
    //   7: ldc 167
    //   9: invokevirtual 172	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   12: astore 5
    //   14: aload_1
    //   15: ldc 174
    //   17: invokevirtual 172	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   20: astore 4
    //   22: ldc 176
    //   24: astore_3
    //   25: aload_1
    //   26: ldc 178
    //   28: invokevirtual 172	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   31: astore 6
    //   33: aload_3
    //   34: astore_2
    //   35: new 85	org/json/JSONObject
    //   38: dup
    //   39: aload 4
    //   41: invokespecial 88	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   44: astore 4
    //   46: aload_3
    //   47: astore_2
    //   48: aload 4
    //   50: ldc 180
    //   52: invokevirtual 121	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   55: astore_3
    //   56: aload_3
    //   57: astore_2
    //   58: aload 4
    //   60: ldc 182
    //   62: invokevirtual 121	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   65: astore 4
    //   67: aload 4
    //   69: astore_2
    //   70: aload_0
    //   71: aload_1
    //   72: getfield 185	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   75: invokevirtual 190	java/lang/String:trim	()Ljava/lang/String;
    //   78: invokestatic 162	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   81: putfield 193	kds$a:puin	J
    //   84: aload_0
    //   85: aload_3
    //   86: putfield 196	kds$a:YD	Ljava/lang/String;
    //   89: aload_0
    //   90: aload 6
    //   92: putfield 199	kds$a:view_id	Ljava/lang/String;
    //   95: aload_0
    //   96: aload 5
    //   98: putfield 202	kds$a:msg_id	Ljava/lang/String;
    //   101: aload_0
    //   102: aload_2
    //   103: putfield 205	kds$a:trace_id	Ljava/lang/String;
    //   106: aload_0
    //   107: iconst_0
    //   108: putfield 208	kds$a:source	I
    //   111: aload_0
    //   112: areturn
    //   113: astore_3
    //   114: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq +12 -> 129
    //   120: ldc 101
    //   122: iconst_2
    //   123: ldc 210
    //   125: aload_3
    //   126: invokestatic 214	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   129: aload_2
    //   130: astore_3
    //   131: ldc 216
    //   133: astore_2
    //   134: goto -64 -> 70
    //   137: astore_1
    //   138: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq -57 -> 84
    //   144: ldc 101
    //   146: iconst_2
    //   147: ldc 218
    //   149: aload_1
    //   150: invokestatic 214	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   153: goto -69 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	parama	kds.a
    //   0	156	1	paramMessageRecord	MessageRecord
    //   34	100	2	localObject1	Object
    //   24	62	3	str1	String
    //   113	13	3	localException	Exception
    //   130	1	3	localObject2	Object
    //   20	48	4	localObject3	Object
    //   12	85	5	str2	String
    //   31	60	6	str3	String
    // Exception table:
    //   from	to	target	type
    //   35	46	113	java/lang/Exception
    //   48	56	113	java/lang/Exception
    //   58	67	113	java/lang/Exception
    //   70	84	137	java/lang/Exception
  }
  
  public static void a(AppInterface paramAppInterface, ChatMessage paramChatMessage, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EcshopAdHandler", 1, "--> bindViewForGdtReport");
    }
    try
    {
      paramChatMessage = kdm.a(paramChatMessage);
      if (paramChatMessage != null)
      {
        paramView.setTag(2131381958, new GdtAd(paramChatMessage));
        paramView.setTag(2131381957, new kdu(paramAppInterface));
      }
      return;
    }
    catch (Throwable paramAppInterface)
    {
      paramAppInterface.printStackTrace();
      QLog.d("EcshopAdHandler", 1, "bindViewForGdtReport:" + paramAppInterface.getStackTrace().toString());
    }
  }
  
  private void a(qq_ad.QQAdGetRsp paramQQAdGetRsp)
  {
    if ((paramQQAdGetRsp.del_aid.has()) && ((BaseActivity.sTopActivity instanceof FragmentActivity)))
    {
      ChatFragment localChatFragment = ((FragmentActivity)BaseActivity.sTopActivity).getChatFragment();
      Object localObject1 = paramQQAdGetRsp.del_aid.get();
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        paramQQAdGetRsp = j();
        if (QLog.isColorLevel()) {
          QLog.d("EcshopAdHandler", 2, "---cacheRiskAids---" + paramQQAdGetRsp);
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Long localLong = (Long)((Iterator)localObject1).next();
          if (paramQQAdGetRsp.contains(localLong))
          {
            if (QLog.isColorLevel()) {
              QLog.i("EcshopAdHandler", 2, "already deleted!!!");
            }
          }
          else if ((localChatFragment != null) && (localChatFragment.b != null))
          {
            Object localObject2 = a(localChatFragment.b.a.getList(), localLong.longValue());
            if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
            {
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                ChatMessage localChatMessage = (ChatMessage)((Iterator)localObject2).next();
                localChatFragment.b.a(localChatMessage);
              }
              if (this.app != null) {
                zyn.putString(this.app.getCurrentAccountUin(), "risk_ad_del_time", whn.h(NetConnInfoCenter.getServerTimeMillis(), "yyyyMMdd"));
              }
              ei(localLong.longValue());
            }
          }
        }
      }
    }
  }
  
  private void bH(List<qq_ad.QQAdGetRsp.RedPointInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EcshopAdHandler", 2, "[onResponseRedpoint]");
    }
    if ((BaseActivity.sTopActivity instanceof FragmentActivity))
    {
      Object localObject = ((FragmentActivity)BaseActivity.sTopActivity).getChatFragment();
      if ((localObject != null) && (((ChatFragment)localObject).b != null) && (((ChatFragment)localObject).b.mAIORootView != null) && (((ChatFragment)localObject).b.mAIORootView.findViewById(2131364469) != null))
      {
        localObject = (CustomTabView)((ChatFragment)localObject).b.mAIORootView.findViewById(2131364469).findViewWithTag("echopCustomTabView");
        if (QLog.isColorLevel()) {
          QLog.i("EcshopAdHandler", 2, "[onResponseRedpoint]" + localObject);
        }
        if (localObject != null) {
          ((CustomTabView)localObject).bK(paramList);
        }
      }
    }
  }
  
  private void ei(long paramLong)
  {
    if (this.app == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("EcshopAdHandler", 2, "---saveRiskAids---");
    }
    Object localObject = new Gson();
    Set localSet = j();
    localSet.add(Long.valueOf(paramLong));
    localObject = ((Gson)localObject).toJson(localSet);
    zyn.putString(this.app.getCurrentAccountUin(), "risk_ids", (String)localObject);
  }
  
  private Set<Long> j()
  {
    HashSet localHashSet = new HashSet();
    if (this.app == null) {}
    String str;
    do
    {
      return localHashSet;
      str = zyn.getString(this.app.getCurrentAccountUin(), "risk_ids", "");
      if (QLog.isColorLevel()) {
        QLog.i("EcshopAdHandler", 2, "---getRiskAids---" + str);
      }
    } while (aqmr.isEmpty(str));
    return (Set)new Gson().fromJson(str, new kdt(this).getType());
  }
  
  public void a(int paramInt, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    kds.a locala = new kds.a();
    locala.aId = paramInt;
    a(locala, paramMessageRecord);
    a(locala, null);
  }
  
  public void a(List<Long> paramList, List<Integer> paramList1, boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EcshopAdHandler", 2, "pull ad pos:" + paramList + ",count:" + paramList1 + ",syn:" + paramBoolean);
    }
    try
    {
      String str1 = whn.h(NetConnInfoCenter.getServerTimeMillis(), "yyyyMMdd");
      if (QLog.isColorLevel()) {
        QLog.i("EcshopAdHandler", 2, "currentTs:" + str1);
      }
      String str2 = zyn.getString(this.app.getCurrentAccountUin(), "risk_ad_del_time", str1);
      if (QLog.isColorLevel()) {
        QLog.i("EcshopAdHandler", 2, "cacheTs:" + str2);
      }
      if (!str1.equals(str2))
      {
        if (QLog.isColorLevel()) {
          QLog.i("EcshopAdHandler", 2, "---removeRiskAids---");
        }
        zyn.dX(this.app.getCurrentAccountUin(), "risk_ids");
      }
      if (TextUtils.isEmpty(paramString)) {
        paramString = "SQQShopAdSdkSvr.getAd";
      }
      for (;;)
      {
        ThreadManagerV2.excute(new EcshopAdHandler.4(this, paramList, paramList1, paramBoolean, paramString), 16, null, false);
        return;
        this.Yw = paramString;
      }
      return;
    }
    catch (Exception paramList)
    {
      QLog.e("EcshopAdHandler", 1, "pullAd failed err msg: " + paramList.getMessage());
    }
  }
  
  public void a(kds.a parama, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EcshopAdHandler", 2, "do ad report info:" + parama.toString());
    }
    qq_ad.QQAdReport localQQAdReport;
    Object localObject2;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = "SQQShopAdSdkReportSvr.AdReport";
      localQQAdReport = new qq_ad.QQAdReport();
      localQQAdReport.type.set(parama.aId);
      localObject2 = localQQAdReport.view_id;
      if (parama.view_id != null) {
        break label627;
      }
      localObject1 = "";
      label84:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.trace_id;
      if (parama.trace_id != null) {
        break label635;
      }
      localObject1 = "";
      label107:
      ((PBStringField)localObject2).set((String)localObject1);
      localQQAdReport.act_time.set((int)(System.currentTimeMillis() / 1000L));
      localObject2 = localQQAdReport.sns_uid;
      if (parama.Yy != null) {
        break label643;
      }
      localObject1 = "";
      label146:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.resolution;
      if (parama.resolution != null) {
        break label651;
      }
      localObject1 = "";
      label169:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.referer;
      if (parama.referer != null) {
        break label659;
      }
      localObject1 = "";
      label192:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.user_agent;
      if (parama.Yz != null) {
        break label667;
      }
      localObject1 = "";
      label215:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.q_user_agent;
      if (parama.YA != null) {
        break label675;
      }
      localObject1 = "";
      label238:
      ((PBStringField)localObject2).set((String)localObject1);
      localQQAdReport.feeds_index.set(parama.aIe);
      localQQAdReport.is_impression.set(parama.is_impression);
      localQQAdReport.is_installed.set(parama.is_installed);
      localObject2 = localQQAdReport.feeds_video_attachment;
      if (parama.YB != null) {
        break label683;
      }
      localObject1 = "";
      label297:
      ((PBStringField)localObject2).set((String)localObject1);
      localQQAdReport.platform_id.set(109);
      localObject2 = localQQAdReport.imei;
      if (arxr.getImei() != null) {
        break label691;
      }
      localObject1 = "";
      label329:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.click_source;
      if (parama.YC != null) {
        break label698;
      }
      localObject1 = "";
      label352:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.antispam_info;
      if (parama.antispam_info != null) {
        break label706;
      }
      localObject1 = "";
      label375:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = aqgz.be(BaseApplicationImpl.getApplication().getApplicationContext());
      PBStringField localPBStringField = localQQAdReport.hardware_addr;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localPBStringField.set((String)localObject1);
      localQQAdReport.stay_time.set(parama.aIf);
      localQQAdReport.net_type.set(jqc.getNetWorkType());
      localQQAdReport.client_id.set(parama.aIg);
      localQQAdReport.action_id.set(parama.action_id);
      localQQAdReport.msg_floor.set(parama.aIh);
      localQQAdReport.puin.set(parama.puin);
      localQQAdReport.ad_puin.set(parama.rP);
      localQQAdReport.version.set("3.4.4");
      localObject2 = localQQAdReport.ad_id;
      if (parama.YD != null) {
        break label714;
      }
      localObject1 = "";
      label527:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.msgid;
      if (parama.msg_id != null) {
        break label722;
      }
    }
    label643:
    label651:
    label659:
    label667:
    label675:
    label683:
    label691:
    label698:
    label706:
    label714:
    label722:
    for (Object localObject1 = "";; localObject1 = parama.msg_id)
    {
      ((PBStringField)localObject2).set((String)localObject1);
      localQQAdReport.get_back.set(false);
      localQQAdReport.source.set(parama.source);
      parama = new ToServiceMsg("mobileqq.service", this.app.getCurrentUin(), paramString);
      parama.putWupBuffer(localQQAdReport.toByteArray());
      super.sendPbReq(parama);
      return;
      acct.b(paramString, new int[] { 139 });
      break;
      label627:
      localObject1 = parama.view_id;
      break label84;
      label635:
      localObject1 = parama.trace_id;
      break label107;
      localObject1 = parama.Yy;
      break label146;
      localObject1 = parama.resolution;
      break label169;
      localObject1 = parama.referer;
      break label192;
      localObject1 = parama.Yz;
      break label215;
      localObject1 = parama.YA;
      break label238;
      localObject1 = parama.YB;
      break label297;
      localObject1 = arxr.getImei();
      break label329;
      localObject1 = parama.YC;
      break label352;
      localObject1 = parama.antispam_info;
      break label375;
      localObject1 = parama.YD;
      break label527;
    }
  }
  
  protected Class<? extends acci> observerClass()
  {
    return kdz.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return;
      if (("SQQShopAdSdkSvr.getAd".equals(paramToServiceMsg.getServiceCmd())) || ((!TextUtils.isEmpty(this.Yw)) && (this.Yw.equals(paramToServiceMsg.getServiceCmd()))))
      {
        paramToServiceMsg = new qq_ad.QQAdGetRsp();
        try
        {
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          if (paramToServiceMsg.pos_ads_info.has())
          {
            paramFromServiceMsg = paramToServiceMsg.pos_ads_info.get().iterator();
            while (paramFromServiceMsg.hasNext())
            {
              paramObject = (qq_ad.QQAdGetRsp.PosAdInfo)paramFromServiceMsg.next();
              if (paramObject.ads_info.has())
              {
                paramObject = paramObject.ads_info.get().iterator();
                while (paramObject.hasNext())
                {
                  qq_ad.QQAdGetRsp.AdInfo localAdInfo = (qq_ad.QQAdGetRsp.AdInfo)paramObject.next();
                  this.I.add(Long.valueOf(localAdInfo.aid.get()));
                }
              }
            }
          }
          if (!QLog.isColorLevel()) {
            break label228;
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          notifyUI(2, false, paramToServiceMsg);
          QLog.e("EcshopAdHandler", 2, "Get ad error:", paramFromServiceMsg);
          return;
        }
        QLog.i("EcshopAdHandler", 2, "redpoint info: " + paramToServiceMsg.red_point.toString());
        label228:
        bH(paramToServiceMsg.red_point.get());
        a(paramToServiceMsg);
        notifyUI(1, true, paramToServiceMsg);
        return;
      }
      paramToServiceMsg = new qq_ad.QQAdReportRsp();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (QLog.isColorLevel())
        {
          QLog.i("EcshopAdHandler", 2, "rsp:" + aqec.convert2JSON(paramToServiceMsg));
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("EcshopAdHandler", 2, "Report error:", paramToServiceMsg);
      }
    }
  }
  
  public static class a
  {
    public String YA;
    public String YB;
    public String YC;
    public String YD;
    public String Yy;
    public String Yz;
    public int aId;
    public int aIe;
    public int aIf;
    public int aIg;
    public int aIh;
    public int action_id;
    public String antispam_info;
    public boolean is_impression;
    public boolean is_installed;
    public String msg_id;
    public long puin;
    public long rP;
    public String referer;
    public String resolution;
    public int source;
    public String trace_id;
    public String view_id;
    
    public String toString()
    {
      return aqec.convert2JSON(this).toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kds
 * JD-Core Version:    0.7.0.1
 */