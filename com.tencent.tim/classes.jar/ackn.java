import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecommendTroopManagerImp.3;
import com.tencent.mobileqq.app.RecommendTroopManagerImp.4;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecTroopBusinessItem;
import com.tencent.mobileqq.data.RecommendTroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.troop.data.NotificationRecommendTroopItem;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tencent.im.kqq.searchgroup.SearchGroup.GroupInfo;
import tencent.im.oidb.cmd0x935.oidb_0x935.Color;
import tencent.im.oidb.cmd0x935.oidb_0x935.GPS;
import tencent.im.oidb.cmd0x935.oidb_0x935.Label;
import tencent.im.oidb.cmd0x935.oidb_0x935.NotifyInfo;
import tencent.im.oidb.cmd0x935.oidb_0x935.RecommendInfo;
import tencent.im.oidb.cmd0x935.oidb_0x935.ReqBody;
import tencent.im.oidb.cmd0x935.oidb_0x935.RgroupInfo;
import tencent.im.oidb.cmd0x935.oidb_0x935.RspBody;
import tencent.im.oidb.cmd0x9fa.oidb_0x9fa.AddFeedbackHateGroupCmd;
import tencent.im.oidb.cmd0x9fa.oidb_0x9fa.ReqBody;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb.Color;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb.Label;
import tencent.im.oidb.oidb_0xc26.RgoupLabel;
import tencent.im.oidb.oidb_0xc26.RgroupColor;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.qun.group_activity.group_activity.GroupAct;

public class ackn
  implements Manager
{
  protected QQAppInterface app;
  private SosoInterface.a b = new ackp(this, 3, true, true, 60000L, false, false, "TroopNotifyAndRecommendView");
  public boolean bJh;
  protected final String boX = "recommendtroop_notification";
  protected final String boY = "recommendtroop_notification_status";
  protected acms c;
  protected Object cD = new Object();
  protected SparseArray<Boolean> cj = new SparseArray();
  protected SparseArray<Long> ck = new SparseArray();
  public int cxG;
  protected int cxH = -1;
  protected EntityManager em;
  public int isEnd;
  SharedPreferences pref;
  private ArrayList<oidb_0x935.NotifyInfo> tD = new ArrayList(5);
  public int uo;
  protected List<SearchGroup.GroupInfo> xQ;
  public List<RecommendTroopItem> xR = new ArrayList();
  
  public ackn(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.pref = this.app.getApp().getSharedPreferences("recommend_troop_info" + this.app.getAccount(), 0);
    this.em = this.app.a().createEntityManager();
    this.c = ((acms)this.app.getBusinessHandler(20));
  }
  
  public static int E(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.b().k(acbn.bkV, 4001);
    int j;
    if ((paramQQAppInterface == null) || (paramQQAppInterface.size() == 0))
    {
      j = 0;
      return j;
    }
    paramQQAppInterface = paramQQAppInterface.iterator();
    int i = 0;
    label40:
    if (paramQQAppInterface.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramQQAppInterface.next();
      String str = localMessageRecord.msg;
      if ((str == null) || (str.length() <= 0) || ((localMessageRecord.msgtype != -1039) && (localMessageRecord.msgtype != -1040)) || (localMessageRecord.extStr == null) || (localMessageRecord.extStr.length() <= 0) || (localMessageRecord.isread)) {
        break label164;
      }
      i += 1;
    }
    label164:
    for (;;)
    {
      break label40;
      j = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RecommendTroopManagerImp", 2, "getRecommendUnreadCount" + i);
      return i;
    }
  }
  
  public static int F(QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences("recommend_troop_info" + paramQQAppInterface.getAccount(), 0);
    if (paramQQAppInterface != null) {
      i = paramQQAppInterface.getInt("unread_recommend_troop_count", 0);
    }
    return i;
  }
  
  private RecTroopBusinessItem a(RecTroopBusinessItem paramRecTroopBusinessItem)
  {
    List localList = this.em.query(RecTroopBusinessItem.class, false, null, null, null, null, "timeStamp desc", null);
    if ((localList != null) && (localList.size() != 0))
    {
      RecTroopBusinessItem localRecTroopBusinessItem = (RecTroopBusinessItem)localList.get(0);
      paramRecTroopBusinessItem = localRecTroopBusinessItem;
      if (localList.size() > 60)
      {
        int i = localList.size() - 1;
        for (;;)
        {
          paramRecTroopBusinessItem = localRecTroopBusinessItem;
          if (i < 60) {
            break;
          }
          paramRecTroopBusinessItem = (RecTroopBusinessItem)localList.get(i);
          this.em.remove(paramRecTroopBusinessItem);
          i -= 1;
        }
      }
    }
    return paramRecTroopBusinessItem;
  }
  
  private static oidb_0x9fb.Color a(oidb_0x935.Color paramColor)
  {
    oidb_0x9fb.Color localColor = new oidb_0x9fb.Color();
    localColor.uint32_b.set(paramColor.uint32_b.get());
    localColor.uint32_g.set(paramColor.uint32_g.get());
    localColor.uint32_r.set(paramColor.uint32_r.get());
    return localColor;
  }
  
  private static oidb_0x9fb.Color a(oidb_0xc26.RgroupColor paramRgroupColor)
  {
    oidb_0x9fb.Color localColor = new oidb_0x9fb.Color();
    localColor.uint32_b.set(paramRgroupColor.uint32_b.get());
    localColor.uint32_g.set(paramRgroupColor.uint32_g.get());
    localColor.uint32_r.set(paramRgroupColor.uint32_r.get());
    return localColor;
  }
  
  private void a(int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.mergeFrom(paramArrayOfByte);
        if ((localOIDBSSOPkg == null) || (!localOIDBSSOPkg.uint32_result.has()) || (localOIDBSSOPkg.uint32_result.get() != 0) || (!localOIDBSSOPkg.bytes_bodybuffer.has()) || (localOIDBSSOPkg.bytes_bodybuffer.get() == null))
        {
          if (!localOIDBSSOPkg.uint32_result.has()) {
            break label214;
          }
          paramInt = localOIDBSSOPkg.uint32_result.get();
          if (!localOIDBSSOPkg.str_error_msg.has()) {
            break label221;
          }
          paramArrayOfByte = localOIDBSSOPkg.str_error_msg.get();
          QLog.e("RecommendTroopManagerImp", 1, String.format("parseRecommendTroop, errcode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramInt), paramArrayOfByte }));
          return;
        }
        paramArrayOfByte = new oidb_0x935.RspBody();
        paramArrayOfByte.mergeFrom(localOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
        if ((paramInt != 1) && (paramInt == 2))
        {
          ThreadManager.post(new RecommendTroopManagerImp.3(this, paramLong, paramArrayOfByte), 8, null, true);
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("RecommendTroopManagerImp", 2, "parseRecommendTroop sso error");
        }
      }
      return;
      label214:
      paramInt = -8888;
      continue;
      label221:
      paramArrayOfByte = "";
    }
  }
  
  private void a(long paramLong, oidb_0x935.RspBody paramRspBody)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendTroopManagerImp", 2, "saveNotificationRecommendTroop, lastuin = " + paramLong);
    }
    this.isEnd = paramRspBody.is_end.get();
    int i = this.xR.size();
    if (paramRspBody.cur_pos.get() == 1)
    {
      cMc();
      if (QLog.isColorLevel()) {
        QLog.d("RecommendTroopManagerImp", 2, "get first page clear the db");
      }
    }
    Object localObject = paramRspBody.recommend_info.get();
    EntityTransaction localEntityTransaction = this.em.getTransaction();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = ((List)localObject).iterator();
    int j = 50 - i;
    if (localIterator1.hasNext())
    {
      localObject = (oidb_0x935.RecommendInfo)localIterator1.next();
      if (j >= 0) {
        break label324;
      }
      this.isEnd = 1;
    }
    try
    {
      localEntityTransaction.commit();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Iterator localIterator2;
        oidb_0x935.RgroupInfo localRgroupInfo;
        NotificationRecommendTroopItem localNotificationRecommendTroopItem;
        if (QLog.isColorLevel()) {
          QLog.e("RecommendTroopManagerImp", 2, "saveNotificationRecommendTroop commit error");
        }
        localEntityTransaction.end();
      }
    }
    finally
    {
      localEntityTransaction.end();
    }
    if (localArrayList.size() > 0) {
      JE(0);
    }
    if ((this.uo == paramRspBody.cur_pos.get() - 1) || (paramRspBody.cur_pos.get() == 1))
    {
      this.xR.addAll(localArrayList);
      this.uo = paramRspBody.cur_pos.get();
      if (QLog.isColorLevel())
      {
        QLog.d("RecommendTroopManagerImp", 2, "getNotificationRecommendTroopList add page" + localArrayList.size());
        paramRspBody = localArrayList.iterator();
        while (paramRspBody.hasNext())
        {
          localObject = (RecommendTroopItem)paramRspBody.next();
          QLog.d("RecommendTroopManagerImp", 2, "RecommendTroop from network = " + localObject);
        }
        label324:
        localObject = ((oidb_0x935.RecommendInfo)localObject).msg_groups.get();
        if (localObject == null) {
          return;
        }
        localEntityTransaction.begin();
        localIterator2 = ((List)localObject).iterator();
        i = j;
        do
        {
          j = i;
          if (!localIterator2.hasNext()) {
            break;
          }
          localRgroupInfo = (oidb_0x935.RgroupInfo)localIterator2.next();
          if (i < 0)
          {
            this.isEnd = 1;
            j = i;
            break;
          }
          localNotificationRecommendTroopItem = new NotificationRecommendTroopItem();
        } while (!localRgroupInfo.uint64_group_code.has());
        localNotificationRecommendTroopItem.uin = String.valueOf(localRgroupInfo.uint64_group_code.get());
        if (localRgroupInfo.bytes_group_name.has()) {
          localNotificationRecommendTroopItem.name = new String(localRgroupInfo.bytes_group_name.get().toByteArray());
        }
        if (localRgroupInfo.bytes_group_memo.has()) {
          localNotificationRecommendTroopItem.intro = new String(localRgroupInfo.bytes_group_memo.get().toByteArray());
        }
        localNotificationRecommendTroopItem.labelList = aM(localRgroupInfo.rpt_group_label.get());
        localNotificationRecommendTroopItem.memberNum = localRgroupInfo.uint32_member_num.get();
        localNotificationRecommendTroopItem.x935RgroupInfo = localRgroupInfo.toByteArray();
        if (localRgroupInfo.bytes_algorithm.has())
        {
          localObject = localRgroupInfo.bytes_algorithm.get().toStringUtf8();
          label568:
          localNotificationRecommendTroopItem.recomAlgol = ((String)localObject);
          if (!localRgroupInfo.bytes_join_group_auth.has()) {
            break label729;
          }
          localObject = localRgroupInfo.bytes_join_group_auth.get().toStringUtf8();
          label599:
          localNotificationRecommendTroopItem.authSig = ((String)localObject);
          if (!localRgroupInfo.uint32_activity.has()) {
            break label737;
          }
          j = localRgroupInfo.uint32_activity.get();
          label627:
          localNotificationRecommendTroopItem.activity = j;
          if (!localRgroupInfo.int32_uin_privilege.has()) {
            break label743;
          }
        }
        label729:
        label737:
        label743:
        for (j = localRgroupInfo.int32_uin_privilege.get();; j = -1)
        {
          localNotificationRecommendTroopItem.privilege = j;
          this.em.persistOrReplace(localNotificationRecommendTroopItem);
          localArrayList.add(localNotificationRecommendTroopItem);
          if (QLog.isColorLevel()) {
            QLog.d("RecommendTroopManagerImp", 2, "saveNotificationRecommendTroop into db, recommend troop = " + localNotificationRecommendTroopItem);
          }
          i -= 1;
          break;
          localObject = "";
          break label568;
          localObject = "";
          break label599;
          j = 0;
          break label627;
        }
      }
    }
    this.c.notifyUI(29, true, this.xR);
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt, String paramString)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    ThreadManager.post(new RecommendTroopManagerImp.4(paramAppInterface, paramInt, paramString), 5, null, true);
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt, String paramString, BusinessObserver paramBusinessObserver)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    try
    {
      long l = Long.valueOf(paramString).longValue();
      Object localObject1 = new oidb_0x9fa.ReqBody();
      ((oidb_0x9fa.ReqBody)localObject1).uint32_appid.set(1);
      ((oidb_0x9fa.ReqBody)localObject1).int32_channel.set(paramInt);
      Object localObject2 = new oidb_0x9fa.AddFeedbackHateGroupCmd();
      ((oidb_0x9fa.AddFeedbackHateGroupCmd)localObject2).uint64_group_code.add(Long.valueOf(l));
      ((oidb_0x9fa.ReqBody)localObject1).msg_add_hate_group.set((MessageMicro)localObject2);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2554);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x9fa.ReqBody)localObject1).toByteArray()));
      localObject1 = new NewIntent(paramAppInterface.getApplication(), jnl.class);
      ((NewIntent)localObject1).setWithouLogin(true);
      ((NewIntent)localObject1).putExtra("cmd", "OidbSvc.0x9fa_0");
      ((NewIntent)localObject1).putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((NewIntent)localObject1).setObserver(paramBusinessObserver);
      paramAppInterface.startServlet((NewIntent)localObject1);
      a(paramAppInterface, paramInt, paramString);
      return;
    }
    catch (Exception paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList, long paramLong, HashMap<String, Integer> paramHashMap)
  {
    EntityTransaction localEntityTransaction = this.em.getTransaction();
    for (;;)
    {
      int j;
      try
      {
        localEntityTransaction.begin();
        int i = paramArrayList.size();
        j = 0;
        RecommendTroopInfo localRecommendTroopInfo;
        if (j < this.xQ.size())
        {
          Object localObject = (SearchGroup.GroupInfo)this.xQ.get(j);
          if ((localObject == null) || ((localObject != null) && (((SearchGroup.GroupInfo)localObject).dwGroupUin.get() == 0) && (((SearchGroup.GroupInfo)localObject).dwGroupCode.get() == 0))) {
            break label585;
          }
          localRecommendTroopInfo = (RecommendTroopInfo)this.em.find(RecommendTroopInfo.class, String.valueOf(((SearchGroup.GroupInfo)localObject).dwGroupCode.get()));
          if (localRecommendTroopInfo != null) {
            break label579;
          }
          localRecommendTroopInfo = new RecommendTroopInfo();
          k = 0;
          localRecommendTroopInfo.code = String.valueOf(((SearchGroup.GroupInfo)localObject).dwGroupUin.get());
          localRecommendTroopInfo.uin = String.valueOf(((SearchGroup.GroupInfo)localObject).dwGroupCode.get());
          localRecommendTroopInfo.ownerUin = String.valueOf(((SearchGroup.GroupInfo)localObject).dwGroupOwnerId.get());
          localRecommendTroopInfo.curMemberNum = ((SearchGroup.GroupInfo)localObject).dwCurMemberNum.get();
          localRecommendTroopInfo.maxMemberNum = ((SearchGroup.GroupInfo)localObject).dwMaxMemberNum.get();
          localRecommendTroopInfo.name = ((SearchGroup.GroupInfo)localObject).sGroupName.get();
          localRecommendTroopInfo.fingerMemo = ((SearchGroup.GroupInfo)localObject).sGroupFingerMem.get();
          localRecommendTroopInfo.faceId = ((SearchGroup.GroupInfo)localObject).dwGroupFaceId.get();
          localRecommendTroopInfo.faceUrl = ((SearchGroup.GroupInfo)localObject).sGroupFaceUrl.get();
          localRecommendTroopInfo.tag = ((SearchGroup.GroupInfo)localObject).sGroupTag.get();
          localRecommendTroopInfo.classId = ((SearchGroup.GroupInfo)localObject).dwGroupClass.get();
          localRecommendTroopInfo.classText = ((SearchGroup.GroupInfo)localObject).sGroupClassText.get();
          localRecommendTroopInfo.level = ((SearchGroup.GroupInfo)localObject).dwGroupLevel.get();
          localRecommendTroopInfo.isSameCity = ((SearchGroup.GroupInfo)localObject).bSameCity.get();
          localRecommendTroopInfo.isTroopFull = ((SearchGroup.GroupInfo)localObject).bGroupFull.get();
          localRecommendTroopInfo.isTroopAllow = ((SearchGroup.GroupInfo)localObject).bGroupAllow.get();
          localRecommendTroopInfo.isTroopIn = ((SearchGroup.GroupInfo)localObject).bGroupIn.get();
          localRecommendTroopInfo.hotDegree = ((SearchGroup.GroupInfo)localObject).dwGroupHotDegree.get();
          localRecommendTroopInfo.flagExt = ((SearchGroup.GroupInfo)localObject).dwGroupFlagExt.get();
          localRecommendTroopInfo.authType = ((SearchGroup.GroupInfo)localObject).dwAuthGroupType.get();
          localRecommendTroopInfo.location = ((SearchGroup.GroupInfo)localObject).sGroupLocation.get();
          localRecommendTroopInfo.option = ((short)((SearchGroup.GroupInfo)localObject).dwGroupOption.get());
          if (k == 0)
          {
            this.em.persistOrReplace(localRecommendTroopInfo);
            localObject = anbi.d(-1039);
            String str = localRecommendTroopInfo.name;
            ((MessageRecord)localObject).extStr = localRecommendTroopInfo.uin;
            ((MessageRecord)localObject).init(this.app.getAccount(), acbn.bkV, "0", str, paramLong, -1039, 4001, 0L);
            paramArrayList.add(localObject);
            paramHashMap.put(localRecommendTroopInfo.uin, Integer.valueOf(1));
            k = i + 1;
            i = k;
            if (k < 60) {
              break label585;
            }
          }
        }
        else
        {
          localEntityTransaction.commit();
          return;
        }
        this.em.update(localRecommendTroopInfo);
        continue;
        int k = 1;
      }
      catch (Exception paramArrayList)
      {
        paramArrayList.printStackTrace();
        return;
      }
      finally
      {
        localEntityTransaction.end();
      }
      label579:
      continue;
      label585:
      j += 1;
    }
  }
  
  private void a(HashMap<String, Integer> paramHashMap, int paramInt, List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
        if ((localMessageRecord.msgtype == -1039) && (paramHashMap.containsKey(localMessageRecord.extStr)))
        {
          this.app.b().t(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
          paramList.remove(i);
        }
        i -= 1;
      }
      int j = 0;
      int k = paramList.size() - 1;
      while (k >= 0)
      {
        paramHashMap = (MessageRecord)paramList.get(k);
        i = j;
        if (paramHashMap.msgtype == -1039)
        {
          j += 1;
          i = j;
          if (j > paramInt)
          {
            this.app.b().t(paramHashMap.frienduin, paramHashMap.istroop, paramHashMap.uniseq);
            paramHashMap = (RecommendTroopInfo)this.em.find(RecommendTroopInfo.class, paramHashMap.extStr);
            i = j;
            if (paramHashMap != null)
            {
              this.em.remove(paramHashMap);
              i = j;
            }
          }
        }
        k -= 1;
        j = i;
      }
    }
  }
  
  public static List<oidb_0x9fb.Label> aM(List<oidb_0x935.Label> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_0x935.Label localLabel = (oidb_0x935.Label)paramList.next();
      oidb_0x9fb.Label localLabel1 = new oidb_0x9fb.Label();
      localLabel1.bytes_name.set(localLabel.bytes_name.get());
      localLabel1.edging_color.set(a((oidb_0x935.Color)localLabel.edging_color.get()));
      localLabel1.text_color.set(a((oidb_0x935.Color)localLabel.text_color.get()));
      localLabel1.enum_type.set(localLabel.enum_type.get());
      localLabel1.uint32_label_attr.set(localLabel.uint32_label_attr.get());
      localLabel1.uint32_label_type.set(localLabel.uint32_label_type.get());
      localArrayList.add(localLabel1);
    }
    return localArrayList;
  }
  
  public static List<oidb_0x9fb.Label> aN(List<oidb_0xc26.RgoupLabel> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_0xc26.RgoupLabel localRgoupLabel = (oidb_0xc26.RgoupLabel)paramList.next();
      oidb_0x9fb.Label localLabel = new oidb_0x9fb.Label();
      localLabel.bytes_name.set(localRgoupLabel.bytes_name.get());
      localLabel.edging_color.set(a((oidb_0xc26.RgroupColor)localRgoupLabel.edging_color.get()));
      localLabel.text_color.set(a((oidb_0xc26.RgroupColor)localRgoupLabel.text_color.get()));
      localLabel.enum_type.set(localRgoupLabel.enum_type.get());
      localLabel.uint32_label_attr.set(localRgoupLabel.uint32_label_attr.get());
      localLabel.uint32_label_type.set(localRgoupLabel.uint32_label_type.get());
      localArrayList.add(localLabel);
    }
    return localArrayList;
  }
  
  private void cMb()
  {
    int i = E(this.app);
    try
    {
      this.pref.edit().putInt("unread_recommend_troop_count", i).commit();
      this.app.a().G(acbn.bkT, 9000, F(this.app));
      Object localObject = (ackm)this.app.getManager(33);
      MessageRecord localMessageRecord = e();
      if ((localMessageRecord != null) && (!((ackm)localObject).c(acbn.bkT, 9000, localMessageRecord.time))) {
        ((ackm)localObject).a(acbn.bkT, 9000, acfp.m(2131692100), localMessageRecord.time, localMessageRecord.time);
      }
      localObject = this.app.getHandler(Conversation.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(1009));
      }
      localObject = this.app.getHandler(TroopNotifyAndRecommendView.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(105));
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecommendTroopManagerImp", 2, "update troopRecommendUnreadCount failed! + msg = " + localException.getMessage());
        }
      }
    }
  }
  
  private void notifyChanged()
  {
    MqqHandler localMqqHandler = this.app.getHandler(ContactListView.class);
    if (localMqqHandler != null)
    {
      localMqqHandler.removeMessages(1);
      localMqqHandler.sendEmptyMessageDelayed(1, 100L);
    }
  }
  
  public void EK(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    List localList = this.app.b().k(acbn.bkV, 4001);
    if ((localList != null) && (localList.size() > 0))
    {
      i = localList.size() - 1;
      while (i >= 0)
      {
        MessageRecord localMessageRecord = (MessageRecord)localList.get(i);
        if ((localMessageRecord.msgtype == -1039) && (!TextUtils.isEmpty(localMessageRecord.extStr)) && (localMessageRecord.extStr.equals(paramString)))
        {
          this.app.b().t(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
          localList.remove(i);
        }
        i -= 1;
      }
    }
    int i = E(this.app);
    this.pref.edit().putInt("unread_recommend_troop_count", i).commit();
  }
  
  public void JE(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("RecommendTroopManagerImp", 4, "updateDBStatsus:" + paramInt);
    }
    SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences("recommendtroop_notification", 0).edit();
    localEditor.putInt("recommendtroop_notification_status", paramInt);
    localEditor.commit();
    this.cxH = paramInt;
  }
  
  public void a(int paramInt1, oidb_0x935.GPS paramGPS, int paramInt2, BusinessObserver paramBusinessObserver)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("RecommendTroopManagerImp", 4, "getRecommend0x935TroopFromServer() start getRecommend0x935TroopFromServer");
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("RecommendTroopManagerImp", 4, "getRecommendTroopFromServer() start getRecommendTroopFromServer");
    }
    if ((this.cj.get(paramInt1) != null) && (((Boolean)this.cj.get(paramInt1)).booleanValue())) {
      return;
    }
    if (this.ck.get(paramInt1) != null) {}
    for (long l1 = ((Long)this.ck.get(paramInt1)).longValue();; l1 = 0L)
    {
      long l2 = System.currentTimeMillis() / 1000L;
      if ((l1 > 0L) && (l2 - l1 < 60L)) {}
      this.ck.append(paramInt1, Long.valueOf(l2));
      this.cj.append(paramInt1, Boolean.valueOf(true));
      if (QLog.isDevelopLevel()) {
        QLog.d("RecommendTroopManagerImp", 4, "getRecommendTroopFromServer() start");
      }
      Object localObject = new oidb_0x935.ReqBody();
      ((oidb_0x935.ReqBody)localObject).uint32_appid.set(1);
      ((oidb_0x935.ReqBody)localObject).uint32_pos.set(this.uo);
      if (paramGPS != null) {
        ((oidb_0x935.ReqBody)localObject).msg_gps.set(paramGPS);
      }
      if ((this.tD != null) && (!this.tD.isEmpty()))
      {
        if (QLog.isDevelopLevel())
        {
          paramGPS = new StringBuilder();
          Iterator localIterator = this.tD.iterator();
          while (localIterator.hasNext())
          {
            oidb_0x935.NotifyInfo localNotifyInfo = (oidb_0x935.NotifyInfo)localIterator.next();
            paramGPS.append(localNotifyInfo.uint64_notify_gc.get() + "," + localNotifyInfo.uint32_notify_type.get() + " ");
          }
          QLog.d("RecommendTroopManagerImp", 4, "getRecommendTroopFromServer() report " + paramGPS.toString());
        }
        ((oidb_0x935.ReqBody)localObject).msg_notify_info.set(this.tD);
      }
      paramGPS = new oidb_sso.OIDBSSOPkg();
      paramGPS.uint32_command.set(2357);
      paramGPS.uint32_result.set(0);
      paramGPS.uint32_service_type.set(paramInt2);
      paramGPS.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x935.ReqBody)localObject).toByteArray()));
      localObject = new NewIntent(this.app.getApplication(), jnl.class);
      ((NewIntent)localObject).setWithouLogin(true);
      ((NewIntent)localObject).putExtra("cmd", "OidbSvc.0x935_" + String.valueOf(paramInt2));
      ((NewIntent)localObject).putExtra("data", paramGPS.toByteArray());
      ((NewIntent)localObject).setObserver(paramBusinessObserver);
      this.app.startServlet((NewIntent)localObject);
      return;
    }
  }
  
  public void a(long paramLong, oidb_0x935.GPS paramGPS, int paramInt)
  {
    a(2, paramGPS, paramInt, new acko(this, paramLong));
  }
  
  public boolean abC()
  {
    synchronized (this.cD)
    {
      SosoInterface.a(this.b);
      return true;
    }
  }
  
  public void c(String paramString, BusinessObserver paramBusinessObserver)
  {
    Object localObject = new oidb_0x935.ReqBody();
    try
    {
      l = Long.valueOf(paramString).longValue();
      if (l == 0L) {
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      long l;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("RecommendTroopManagerImp", 2, "setRecommendTroopDeleted NumberFormatException + " + paramString);
        }
        l = 0L;
      }
      ((oidb_0x935.ReqBody)localObject).uint32_appid.set(1);
      ((oidb_0x935.ReqBody)localObject).uint64_black_gc.set(l);
      paramString = new oidb_sso.OIDBSSOPkg();
      paramString.uint32_command.set(2357);
      paramString.uint32_result.set(0);
      paramString.uint32_service_type.set(7);
      paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x935.ReqBody)localObject).toByteArray()));
      localObject = new NewIntent(this.app.getApplication(), jnl.class);
      ((NewIntent)localObject).setWithouLogin(true);
      ((NewIntent)localObject).putExtra("cmd", "OidbSvc.0x935_7");
      ((NewIntent)localObject).putExtra("data", paramString.toByteArray());
      ((NewIntent)localObject).setObserver(paramBusinessObserver);
      this.app.startServlet((NewIntent)localObject);
    }
  }
  
  public void cMa()
  {
    if (this.tD != null) {
      this.tD.clear();
    }
  }
  
  public void cMc()
  {
    if (this.em != null) {
      this.em.drop(NotificationRecommendTroopItem.class);
    }
    this.app.b().zC(-1039);
    this.app.b().zC(-1040);
    this.pref.edit().putInt("unread_recommend_troop_count", 0).commit();
  }
  
  public void cMd()
  {
    this.uo = 0;
    this.isEnd = 0;
    this.xR.clear();
  }
  
  public void cmt()
  {
    this.app.b().zB(-1039);
    this.app.b().zB(-1040);
    this.pref.edit().putInt("unread_recommend_troop_count", 0).commit();
  }
  
  public void dG(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendTroopManagerImp", 2, "updateTroopRecommend content:" + paramString + ",\n uin: " + this.app.getAccount() + ", version:" + paramInt);
    }
    try
    {
      if (new JSONObject(paramString).getInt("showNewTroopRecommend") == 1) {}
      for (boolean bool = true;; bool = false)
      {
        this.bJh = bool;
        paramString = this.app.getPreferences();
        paramString.edit().putBoolean("show_new_troop_recommend", bool);
        paramString.edit().commit();
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.d("RecommendTroopManagerImp", 1, "updateLebaConfig e:" + paramString.toString());
    }
  }
  
  public void dK(ArrayList<oidb_0x935.NotifyInfo> paramArrayList)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("saveGroupSysNotifyReportData ");
      if (paramArrayList != null) {
        break label70;
      }
    }
    label70:
    for (Object localObject = "null";; localObject = Integer.valueOf(paramArrayList.size()))
    {
      QLog.d("RecommendTroopManagerImp", 2, localObject);
      if ((this.tD != null) && (paramArrayList != null))
      {
        this.tD.clear();
        this.tD.addAll(paramArrayList);
      }
      return;
    }
  }
  
  public MessageRecord e()
  {
    try
    {
      List localList = this.app.b().k(acbn.bkV, 4001);
      if ((localList != null) && (localList.size() > 0))
      {
        int i = localList.size() - 1;
        while (i >= 0)
        {
          MessageRecord localMessageRecord = (MessageRecord)localList.get(i);
          if (((localMessageRecord.msgtype == -1039) || (localMessageRecord.msgtype == -1040)) && (localMessageRecord.msg != null))
          {
            int j = localMessageRecord.msg.length();
            if (j > 0) {
              return localMessageRecord;
            }
          }
          i -= 1;
        }
      }
      return null;
    }
    catch (NullPointerException localNullPointerException) {}
  }
  
  public List<RecommendTroopItem> ef()
  {
    List localList = null;
    MqqHandler localMqqHandler = this.app.getHandler(TroopNotifyAndRecommendView.class);
    Message localMessage = localMqqHandler.obtainMessage();
    localMessage.what = 1015;
    if (this.em != null)
    {
      localList = this.em.query(NotificationRecommendTroopItem.class, false, null, new String[0], null, null, null, null);
      this.em.close();
      localMessage.obj = localList;
      if ((QLog.isColorLevel()) && (localList != null))
      {
        QLog.d("RecommendTroopManagerImp", 2, "getNotificationRecommendTroopList from db, sz = " + localList.size());
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          RecommendTroopItem localRecommendTroopItem = (RecommendTroopItem)localIterator.next();
          QLog.d("RecommendTroopManagerImp", 2, "RecommendTroop from db = " + localRecommendTroopItem);
        }
      }
      localMqqHandler.sendMessage(localMessage);
    }
    return localList;
  }
  
  public void je(List<group_activity.GroupAct> paramList)
  {
    if ((this.xQ == null) || (this.xQ.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    long l = NetConnInfoCenter.getServerTime();
    Object localObject;
    if ((paramList != null) && (paramList.size() != 0))
    {
      localObject = (group_activity.GroupAct)paramList.get(0);
      if (localObject != null)
      {
        paramList = new RecTroopBusinessItem();
        paramList.id = String.valueOf(((group_activity.GroupAct)localObject).uint32_act_id.get());
        paramList.title = ((group_activity.GroupAct)localObject).string_title.get();
        paramList.des = ((group_activity.GroupAct)localObject).string_des.get();
        paramList.jumpType = ((group_activity.GroupAct)localObject).uint32_jumptype.get();
        paramList.jumpUrl = ((group_activity.GroupAct)localObject).string_url.get();
        paramList.jumpParam = ((group_activity.GroupAct)localObject).string_jumpparam.get();
        paramList.iconUrl = ((group_activity.GroupAct)localObject).string_iconurl.get();
        paramList.btnText = ((group_activity.GroupAct)localObject).string_btntext.get();
        paramList.startTime = ((group_activity.GroupAct)localObject).uint32_start_time.get();
        paramList.endTime = ((group_activity.GroupAct)localObject).uint32_end_time.get();
        paramList.timeStamp = l;
        this.em.persistOrReplace(paramList);
      }
    }
    for (;;)
    {
      localObject = paramList;
      if (paramList == null) {
        localObject = a(paramList);
      }
      if (localObject != null)
      {
        paramList = anbi.d(-1040);
        paramList.extStr = ((RecTroopBusinessItem)localObject).id;
        paramList.init(this.app.getAccount(), acbn.bkV, "0", ((RecTroopBusinessItem)localObject).title, l, -1040, 4001, 0L);
        localArrayList.add(paramList);
        this.app.b().zC(-1040);
      }
      paramList = new HashMap();
      a(localArrayList, l, paramList);
      int i;
      if ((localArrayList.size() >= 1) || ((localArrayList.size() == 1) && (localObject == null)))
      {
        i = 60 - localArrayList.size();
        if (i > 0) {
          break label396;
        }
        this.app.b().zC(-1039);
      }
      for (;;)
      {
        this.app.b().s(localArrayList, this.app.getAccount());
        this.xQ.clear();
        notifyChanged();
        cMb();
        return;
        label396:
        a(paramList, i, this.app.b().k(acbn.bkV, 4001));
      }
      paramList = null;
    }
  }
  
  public void jf(List<group_activity.GroupAct> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    je(paramList);
  }
  
  public void onDestroy() {}
  
  public String rM()
  {
    try
    {
      Object localObject = this.app.b().k(acbn.bkV, 4001);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        int i = ((List)localObject).size() - 1;
        while (i >= 0)
        {
          MessageRecord localMessageRecord = (MessageRecord)((List)localObject).get(i);
          if (((localMessageRecord.msgtype == -1039) || (localMessageRecord.msgtype == -1040)) && (localMessageRecord.msg != null) && (localMessageRecord.msg.length() > 0))
          {
            localObject = localMessageRecord.msg;
            return localObject;
          }
          i -= 1;
        }
      }
      return "";
    }
    catch (NullPointerException localNullPointerException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ackn
 * JD-Core Version:    0.7.0.1
 */