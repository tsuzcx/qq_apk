import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.relationx.batchAdd.BatchAddFriendData.1;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ltencent.im.oidb.cmd0x777.cmd0x777.AddFrdInfo;>;
import java.util.Locale;
import java.util.Random;
import tencent.im.oidb.cmd0x777.cmd0x777.AddFrdInfo;
import tencent.im.oidb.cmd0x777.cmd0x777.ReqBody;
import tencent.im.oidb.cmd0x777.cmd0x777.RspBody;

public class alui
{
  private String aKI;
  private final ArrayList<cmd0x777.AddFrdInfo> aQ = new ArrayList();
  private final long[] ap = new long[30];
  private int bDB = 0;
  private String bYw = null;
  private int dxC = 0;
  private int dxD = 0;
  private String mTroopUin = null;
  private final ArrayList<Long> yX = new ArrayList();
  
  public static boolean A(long paramLong1, long paramLong2)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong2 * 1000L);
    int i = localCalendar.get(6);
    int j = localCalendar.get(1);
    localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(1000L * paramLong1);
    int k = localCalendar.get(6);
    int m = localCalendar.get(1);
    return ((j == m) && (i > k)) || (j > m);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if ((paramContext == null) || (paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("BatchAddFriendData", 2, String.format("onBAFTipClick troopUin_type_recUin %s_%d_%s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString3 }));
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        Intent localIntent = new Intent(paramContext, SelectMemberActivity.class);
        localIntent.putExtra("param_from", 30);
        localIntent.putExtra("group_uin", paramString1);
        localIntent.putExtra("param_groupcode", paramString2);
        localIntent.putExtra("param_from", 30);
        localIntent.putExtra("param_subtype", 4);
        localIntent.putExtra("param_entrance", 30);
        localIntent.putExtra("param_max", 30);
        localIntent.putExtra("param_exit_animation", 3);
        localIntent.putExtra("batch_addfrd_scene_type", paramInt);
        if (!TextUtils.isEmpty(paramString3)) {
          localIntent.putExtra("batch_addfrd_recommand_uin", paramString3);
        }
        paramContext.startActivity(localIntent);
        ((Activity)paramContext).overridePendingTransition(2130772009, 0);
      }
      ThreadManager.post(new BatchAddFriendData.1(paramInt, paramQQAppInterface, paramString1), 8, null, true);
    } while (!QLog.isDevelopLevel());
    QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "onBAFTipClick troopUin: %s", new Object[] { paramString1 }));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, List<cmd0x777.AddFrdInfo> paramList)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      if (QLog.isDevelopLevel()) {
        QLog.d("BatchAddFriendData", 4, "showResult not in ui thread !");
      }
    }
    do
    {
      return;
      if ((paramActivity != null) && (paramList != null) && (paramList.size() != 0)) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    if (paramActivity == null) {}
    for (paramQQAppInterface = "showResult context is null !";; paramQQAppInterface = "showResult list is null or size is zero !")
    {
      QLog.d("BatchAddFriendData", 4, paramQQAppInterface);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    int m = 0;
    int n = 0;
    Object localObject1 = paramList.iterator();
    int j = 0;
    int i = 0;
    label103:
    Object localObject2;
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (cmd0x777.AddFrdInfo)((Iterator)localObject1).next();
        if (localObject2 != null) {
          if (((cmd0x777.AddFrdInfo)localObject2).uint32_send_req_flag.get() == 1) {
            if (((cmd0x777.AddFrdInfo)localObject2).uint32_send_req_result.get() == 0) {
              k += 1;
            }
          }
        }
      }
    }
    for (;;)
    {
      break label103;
      m += 1;
      continue;
      if (((cmd0x777.AddFrdInfo)localObject2).uint32_send_req_flag.get() == 2)
      {
        j += 1;
        if (((cmd0x777.AddFrdInfo)localObject2).uint32_allow_type.get() == 1) {
          i += 1;
        } else if (((cmd0x777.AddFrdInfo)localObject2).uint32_allow_type.get() == 2) {
          localArrayList.add(localObject2);
        }
      }
      else
      {
        n += 1;
        continue;
        if (QLog.isDevelopLevel()) {
          QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "showResult total: %s, sendOk: %s, sendFail: %s, notSend: %s, clientFail: %s, refuseAdd: %s, answerQuestion: %s", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(localArrayList.size()) }));
        }
        label353:
        label374:
        cmd0x777.AddFrdInfo localAddFrdInfo;
        if (k > 0)
        {
          QQToast.a(BaseApplication.getContext(), 0, acfp.m(2131703158), 0).show();
          if (localArrayList.size() <= 0) {
            break label466;
          }
          localObject1 = null;
          localObject2 = null;
          Iterator localIterator = localArrayList.iterator();
          if (!localIterator.hasNext()) {
            break label516;
          }
          localAddFrdInfo = (cmd0x777.AddFrdInfo)localIterator.next();
          if ((localObject1 != null) && (localAddFrdInfo.uint32_send_req_result.get() <= ((cmd0x777.AddFrdInfo)localObject1).uint32_send_req_result.get())) {
            break label468;
          }
          localObject3 = localAddFrdInfo;
          paramList = (List<cmd0x777.AddFrdInfo>)localObject1;
        }
        for (;;)
        {
          localObject2 = paramList;
          localObject1 = localObject3;
          break label374;
          if ((m <= 0) && (n <= 0)) {
            break label353;
          }
          QQToast.a(BaseApplication.getContext(), 0, acfp.m(2131703161), 0).show();
          break label353;
          label466:
          break;
          label468:
          paramList = localAddFrdInfo;
          localObject3 = localObject1;
          if (localObject2 != null)
          {
            paramList = localAddFrdInfo;
            localObject3 = localObject1;
            if (localAddFrdInfo.uint32_send_req_result.get() <= ((cmd0x777.AddFrdInfo)localObject2).uint32_send_req_result.get())
            {
              paramList = (List<cmd0x777.AddFrdInfo>)localObject2;
              localObject3 = localObject1;
            }
          }
        }
        label516:
        Object localObject3 = null;
        if ((localArrayList.size() == 1) && (localObject1 != null)) {
          paramList = ((cmd0x777.AddFrdInfo)localObject1).bytes_remark.get();
        }
        for (;;)
        {
          paramList = aqha.a(paramActivity, String.format(Locale.getDefault(), acfp.m(2131703165), new Object[] { paramList }), 0, 0, null, null);
          paramList.setPositiveButton(2131721079, new aluj());
          if ((paramActivity != null) && (!paramActivity.isFinishing())) {
            paramList.show();
          }
          anot.a(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "frd_select", "notAdd_exp", 0, 0, paramString, String.valueOf(j), "", "");
          return;
          if ((localArrayList.size() == 2) && (localObject1 != null) && (localObject2 != null))
          {
            paramList = String.format(Locale.getDefault(), "%s、%s", new Object[] { ((cmd0x777.AddFrdInfo)localObject1).bytes_remark.get(), ((cmd0x777.AddFrdInfo)localObject2).bytes_remark.get() });
          }
          else
          {
            paramList = (List<cmd0x777.AddFrdInfo>)localObject3;
            if (localObject1 != null)
            {
              paramList = (List<cmd0x777.AddFrdInfo>)localObject3;
              if (localObject2 != null) {
                paramList = String.format(Locale.getDefault(), "%s、%s等%s位好友", new Object[] { ((cmd0x777.AddFrdInfo)localObject1).bytes_remark.get(), ((cmd0x777.AddFrdInfo)localObject2).bytes_remark.get(), Integer.valueOf(localArrayList.size()) });
              }
            }
          }
        }
      }
    }
  }
  
  private void b(FriendListHandler paramFriendListHandler)
  {
    if (paramFriendListHandler == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("BatchAddFriendData", 4, "sendResult friendListHandler is null ");
      }
      return;
    }
    TroopManager localTroopManager = (TroopManager)paramFriendListHandler.app.getManager(52);
    acff localacff = (acff)paramFriendListHandler.app.getManager(51);
    ArrayList localArrayList = (ArrayList)this.aQ.clone();
    boolean bool1 = false;
    int i = 0;
    cmd0x777.AddFrdInfo localAddFrdInfo;
    label90:
    TroopMemberInfo localTroopMemberInfo;
    label160:
    int j;
    for (;;)
    {
      if (i < localArrayList.size())
      {
        localAddFrdInfo = (cmd0x777.AddFrdInfo)localArrayList.get(i);
        if (localAddFrdInfo == null)
        {
          i += 1;
        }
        else if (localAddFrdInfo.uint32_send_req_flag.get() == 2)
        {
          localTroopMemberInfo = localTroopManager.c(this.mTroopUin, String.valueOf(localAddFrdInfo.uint64_uin.get()));
          if (localTroopMemberInfo == null) {
            break label317;
          }
          if (!TextUtils.isEmpty(localTroopMemberInfo.troopremark))
          {
            localAddFrdInfo.bytes_remark.set(localTroopMemberInfo.troopremark);
            PBUInt32Field localPBUInt32Field = localAddFrdInfo.uint32_send_req_result;
            if (localTroopMemberInfo.commonFrdCnt != -2147483648) {
              break label308;
            }
            j = 0;
            label180:
            localPBUInt32Field.set(j);
          }
        }
        else
        {
          label186:
          if (localAddFrdInfo.uint32_send_req_flag.get() == -2147483648) {
            break label473;
          }
        }
      }
    }
    label308:
    label317:
    label473:
    for (boolean bool2 = true;; bool2 = bool1)
    {
      if (localAddFrdInfo.uint32_send_req_flag.get() == 1)
      {
        bool1 = bool2;
        if (localAddFrdInfo.uint32_send_req_result.get() == 0) {
          break label90;
        }
        localacff.bF(Long.toString(localAddFrdInfo.uint64_uin.get()), false);
        bool1 = bool2;
        break label90;
        if (!TextUtils.isEmpty(localTroopMemberInfo.troopnick))
        {
          localAddFrdInfo.bytes_remark.set(localTroopMemberInfo.troopnick);
          break label160;
        }
        if (TextUtils.isEmpty(localTroopMemberInfo.friendnick)) {
          break label160;
        }
        localAddFrdInfo.bytes_remark.set(localTroopMemberInfo.friendnick);
        break label160;
        j = localTroopMemberInfo.commonFrdCnt;
        break label180;
        if (!QLog.isDevelopLevel()) {
          break label186;
        }
        QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "sendResult TroopMemberInfo is null [troopUin: %s, memberUin: %s] ", new Object[] { this.mTroopUin, Long.valueOf(localAddFrdInfo.uint64_uin.get()) }));
        break label186;
      }
      localacff.bF(Long.toString(localAddFrdInfo.uint64_uin.get()), false);
      bool1 = bool2;
      break label90;
      this.aQ.clear();
      paramFriendListHandler.notifyUI(112, bool1, new Object[] { this.mTroopUin, localArrayList });
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "sendResult isSuc: %s, troop: %s, size: %s", new Object[] { Boolean.valueOf(bool1), this.mTroopUin, Integer.valueOf(localArrayList.size()) }));
      return;
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1))) {
      if (QLog.isDevelopLevel()) {
        QLog.d("BatchAddFriendData", 4, "doAddBAFGrayTip invalidate params!");
      }
    }
    Object localObject2;
    TroopInfo localTroopInfo;
    do
    {
      return;
      localObject2 = (TroopManager)paramQQAppInterface.getManager(52);
      localTroopInfo = ((TroopManager)localObject2).b(paramString1);
    } while (localTroopInfo == null);
    apwn.a(paramQQAppInterface, true, localTroopInfo);
    Object localObject1 = paramQQAppInterface.b().f(paramString1, 1);
    long l1;
    label108:
    long l2;
    int j;
    int i;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      l1 = ((ChatMessage)((List)localObject1).get(((List)localObject1).size() - 1)).shmsgseq;
      l2 = anaz.gQ();
      j = 0;
      if (TextUtils.isEmpty(paramString3)) {
        break label618;
      }
      i = 1;
      localObject1 = String.format(Locale.getDefault(), acfp.m(2131703159), new Object[] { paramString3, Integer.valueOf(paramInt2) });
      if (paramInt2 != 1) {
        break label745;
      }
      paramString3 = String.format(Locale.getDefault(), acfp.m(2131703162), new Object[] { paramString3 });
      paramInt2 = 1;
    }
    for (;;)
    {
      label187:
      label217:
      Object localObject3;
      if (paramInt1 == 0)
      {
        paramString3 = paramString3 + acfp.m(2131703166);
        localObject1 = acfp.m(2131703163);
        i = paramString3.indexOf((String)localObject1);
        j = ((String)localObject1).length();
        localObject1 = new ahwa(paramString1, paramString1, paramString3, 1, -5020, 135178, l2);
        ((ahwa)localObject1).wording = paramString3;
        paramString3 = new Bundle();
        paramString3.putInt("key_action", 24);
        paramString3.putString("key_action_DATA", paramString1);
        paramString3.putString("key_a_action_DATA", localTroopInfo.troopcode);
        ((ahwa)localObject1).addHightlightItem(i, i + j, paramString3);
        localObject3 = new StringBuilder().append("newJoin-");
        if (paramInt2 == 0) {
          break label729;
        }
        paramString3 = paramString2;
        label348:
        ((ahwa)localObject1).bLT = paramString3;
        localObject3 = new MessageForUniteGrayTip();
        ((MessageForUniteGrayTip)localObject3).initGrayTipMsg(paramQQAppInterface, (ahwa)localObject1);
        ((MessageForUniteGrayTip)localObject3).isread = true;
        ((MessageForUniteGrayTip)localObject3).shmsgseq = l1;
        ((MessageForUniteGrayTip)localObject3).mNeedTimeStamp = true;
        ((MessageForUniteGrayTip)localObject3).updateUniteGrayTipMsgData(paramQQAppInterface);
        paramQQAppInterface.b().b((MessageRecord)localObject3, paramQQAppInterface.getCurrentAccountUin());
        localTroopInfo.dwLastInsertBAFTipTime = NetConnInfoCenter.getServerTime();
        localTroopInfo.wInsertBAFTipCount += 1;
        localTroopInfo.dwLastBAFTipMsgUniSeq = ((MessageForUniteGrayTip)localObject3).uniseq;
        ((TroopManager)localObject2).i(localTroopInfo);
        paramString3 = "1";
        if (paramInt1 > 0) {
          paramString3 = "0";
        }
        localObject2 = apwn.b(true, 1);
        if (localTroopInfo.wInsertBAFTipCount != 1) {
          break label737;
        }
      }
      label729:
      label737:
      for (localObject1 = "0";; localObject1 = "1")
      {
        anot.a(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "Grp_AIO", (String)localObject2, 0, 0, paramString1, (String)localObject1, "", paramString3);
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("BatchAddFriendData", 4, String.format("doAddBAFGrayTip time: %s count: %s uniseq: %s, msgSeq: %s, shmsgseq: %s, recmmendUin=%s", new Object[] { Long.valueOf(localTroopInfo.dwLastInsertBAFTipTime), Integer.valueOf(localTroopInfo.wInsertBAFTipCount), Long.valueOf(localTroopInfo.dwLastBAFTipMsgUniSeq), Long.valueOf(l1), Long.valueOf(((MessageForUniteGrayTip)localObject3).shmsgseq), paramString2 }));
        return;
        l1 = Math.abs(new Random().nextInt());
        break label108;
        label618:
        paramString3 = String.format(Locale.getDefault(), acfp.m(2131703164), new Object[] { Integer.valueOf(paramInt2) });
        i = j;
        localObject1 = paramString3;
        if (paramInt2 != 1) {
          break label745;
        }
        i = j;
        localObject1 = paramString3;
        if (TextUtils.isEmpty(paramString2)) {
          break label745;
        }
        paramString3 = String.format(Locale.getDefault(), acfp.m(2131703160), new Object[] { paramString2 });
        paramInt2 = 0;
        break label187;
        paramString3 = paramString3 + acfp.m(2131703157);
        break label217;
        paramString3 = "";
        break label348;
      }
      label745:
      paramInt2 = i;
      paramString3 = (String)localObject1;
    }
  }
  
  public void a(FriendListHandler paramFriendListHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 0;
    if (paramFriendListHandler == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("BatchAddFriendData", 4, "handleAddBatchTroopMembers friendListHandler is null ");
      }
      return;
    }
    paramToServiceMsg = paramToServiceMsg.extraData.getLongArray("send_uin_array");
    int i;
    if (this.dxC <= 0) {
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("BatchAddFriendData", 4, "handleAddBatchTroopMembers is not cur sending resp!");
        return;
        if ((paramToServiceMsg == null) || (paramToServiceMsg.length < this.dxC))
        {
          i = 0;
          continue;
        }
        i = 0;
        for (;;)
        {
          if (i >= this.dxC) {
            break label376;
          }
          if (paramToServiceMsg[i] != this.ap[i])
          {
            i = 0;
            break;
          }
          i += 1;
        }
      }
      int k = this.dxC;
      paramToServiceMsg = new cmd0x777.RspBody();
      int m = FriendListHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (m == 0)
      {
        paramToServiceMsg = paramToServiceMsg.rpt_add_frd_info.get();
        this.dxC = 0;
        if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0)) {
          this.aQ.addAll(paramToServiceMsg);
        }
        if (QLog.isDevelopLevel())
        {
          paramFromServiceMsg = Locale.getDefault();
          if (paramToServiceMsg != null) {
            break label359;
          }
        }
      }
      label359:
      for (i = j;; i = paramToServiceMsg.size())
      {
        QLog.d("BatchAddFriendData", 4, String.format(paramFromServiceMsg, "handleAddBatchTroopMembers result: %s sending: %s, cur:%s  total: %s pending: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(this.aQ.size()), Integer.valueOf(this.yX.size()) }));
        if (this.yX.size() <= 0) {
          break label370;
        }
        c(paramFriendListHandler);
        return;
        paramFromServiceMsg = new ArrayList();
        i = 0;
        for (;;)
        {
          paramToServiceMsg = paramFromServiceMsg;
          if (i >= k) {
            break;
          }
          paramToServiceMsg = new cmd0x777.AddFrdInfo();
          paramToServiceMsg.uint64_uin.set(this.ap[i]);
          paramToServiceMsg.uint32_send_req_flag.set(-2147483648);
          paramFromServiceMsg.add(paramToServiceMsg);
          i += 1;
        }
      }
      label370:
      b(paramFriendListHandler);
      return;
      label376:
      i = 1;
    }
  }
  
  public boolean b(String paramString1, String paramString2, String paramString3, List<String> paramList, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("BatchAddFriendData", 4, "init uinList is null or empty!");
      }
      return false;
    }
    if (paramBoolean)
    {
      this.yX.clear();
      this.aQ.clear();
      this.dxC = 0;
    }
    if ((this.yX.size() > 0) || (this.aQ.size() > 0) || (this.dxC > 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "init isSending pending: %s result: %s curSending: ", new Object[] { Integer.valueOf(this.yX.size()), Integer.valueOf(this.aQ.size()), Integer.valueOf(this.dxC) }));
      }
      return false;
    }
    this.mTroopUin = paramString1;
    this.aKI = paramString2;
    this.bYw = paramString3;
    this.bDB = paramInt1;
    this.dxD = paramInt2;
    paramString1 = paramList.iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (String)paramString1.next();
      if ((paramString2 != null) && (!paramString2.isEmpty())) {
        try
        {
          long l = Long.parseLong(paramString2);
          this.yX.add(Long.valueOf(l));
        }
        catch (Throwable paramString2)
        {
          paramString2.printStackTrace();
        }
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "init pending: %s, troopuin: %s, troopcode: %s, sourceId: %s, subSourceId: %s, msg: %s", new Object[] { Integer.valueOf(this.yX.size()), this.mTroopUin, this.aKI, Integer.valueOf(this.bDB), Integer.valueOf(this.dxD), this.bYw }));
    }
    return true;
  }
  
  public void c(FriendListHandler paramFriendListHandler)
  {
    if (paramFriendListHandler == null) {}
    for (;;)
    {
      try
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("BatchAddFriendData", 4, "doSendBatchAddFriendForTroopMember friendListHandler is null ");
        }
        return;
      }
      finally {}
      Object localObject = (acff)paramFriendListHandler.app.getManager(51);
      this.dxC = Math.min(this.yX.size(), this.ap.length);
      int i = this.dxC;
      if (i > 0)
      {
        long l1 = 0L;
        try
        {
          long l2 = Long.parseLong(this.aKI);
          l1 = l2;
        }
        catch (Throwable localThrowable)
        {
          cmd0x777.ReqBody localReqBody;
          localThrowable.printStackTrace();
          continue;
        }
        localReqBody = new cmd0x777.ReqBody();
        localReqBody.uint64_group_uin.set(l1);
        localReqBody.bytes_msg.set(this.bYw);
        localReqBody.uint32_source_id.set(this.bDB);
        localReqBody.uint32_sub_source_id.set(this.dxD);
        i = this.dxC - 1;
        if (i >= 0)
        {
          l1 = ((Long)this.yX.remove(i)).longValue();
          this.ap[i] = l1;
          localReqBody.rpt_uint64_uin.add(Long.valueOf(l1));
          ((acff)localObject).bF(Long.toString(l1), true);
          i -= 1;
        }
        else
        {
          localObject = paramFriendListHandler.makeOIDBPkg("OidbSvc.0x777", 1911, 1, localThrowable.toByteArray());
          ((ToServiceMsg)localObject).extraData.putLongArray("send_uin_array", this.ap);
          paramFriendListHandler.sendPbReq((ToServiceMsg)localObject);
          if (QLog.isDevelopLevel()) {
            QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "doSendBatchAddFriendForTroopMember sending: %s pending: %s", new Object[] { Integer.valueOf(this.dxC), Integer.valueOf(this.yX.size()) }));
          }
        }
      }
      else
      {
        b(paramFriendListHandler);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alui
 * JD-Core Version:    0.7.0.1
 */