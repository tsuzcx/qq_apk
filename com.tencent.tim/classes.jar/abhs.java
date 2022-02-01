import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloPanelManager.1;
import com.tencent.mobileqq.apollo.ApolloPanelManager.2;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloSlaveInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class abhs
{
  public long Nr;
  public abzy a;
  public AtomicInteger aR = new AtomicInteger(0);
  private abzy b;
  private boolean bDb;
  public volatile boolean bDc;
  public String bgg;
  public volatile int coS;
  public int coT;
  public ConcurrentHashMap<Long, ApolloSlaveInfo> ds = new ConcurrentHashMap();
  private WeakReference<BaseChatPie> ff;
  private WeakReference<abhs.a> fg;
  private WeakReference<QQAppInterface> mAppRef;
  
  public abhs(QQAppInterface paramQQAppInterface)
  {
    this.mAppRef = new WeakReference(paramQQAppInterface);
  }
  
  private void c(abzy paramabzy)
  {
    if ((getApp() == null) || (this.ff.get() == null) || (paramabzy == null)) {
      return;
    }
    BaseChatPie localBaseChatPie = (BaseChatPie)this.ff.get();
    SessionInfo localSessionInfo = ((BaseChatPie)this.ff.get()).a();
    localBaseChatPie.jdField_a_of_type_Abzy = paramabzy;
    int i;
    if (localSessionInfo.cZ == 3000) {
      i = 11;
    }
    for (;;)
    {
      Intent localIntent = TroopMemberListActivity.c(localBaseChatPie.mActivity, localSessionInfo.aTl, i);
      if (localBaseChatPie.vm() == 21) {
        localIntent.putExtra("param_troop_send_apollo_msg", true);
      }
      localIntent.putExtra("param_is_pop_up_style", true);
      localIntent.putExtra("param_troop_send_apollo_msg", true);
      localBaseChatPie.mActivity.startActivityForResult(localIntent, 6001);
      VipUtils.a(localBaseChatPie.app, "cmshow", "Apollo", "g_action_double_clk", localSessionInfo.aTl, -1, ApolloUtil.gi(localSessionInfo.cZ), new String[] { "" + paramabzy.c.actionId, "655_" + paramabzy.cud, "1", String.valueOf(System.currentTimeMillis() / 1000L) });
      return;
      if (localSessionInfo.cZ == 1) {
        i = 3;
      } else {
        i = 0;
      }
    }
  }
  
  public void a(abhs.a parama)
  {
    this.fg = new WeakReference(parama);
  }
  
  public void a(abzy paramabzy, BaseChatPie paramBaseChatPie)
  {
    this.ff = new WeakReference(paramBaseChatPie);
    b(paramabzy);
  }
  
  public void a(BaseChatPie paramBaseChatPie, abzy paramabzy)
  {
    if ((paramBaseChatPie == null) || (paramBaseChatPie.app == null)) {
      return;
    }
    this.b = paramabzy;
    this.ff = new WeakReference(paramBaseChatPie);
    this.bDc = true;
    ((aqrb)paramBaseChatPie.app.getBusinessHandler(71)).ag(paramBaseChatPie.app.getCurrentUin(), 262144, "get gold balance");
  }
  
  public void b(abzy paramabzy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Apollo_PanelManager", 2, "[checkSlavesBeforeSend]");
    }
    this.jdField_a_of_type_Abzy = paramabzy;
    if ((System.currentTimeMillis() - this.Nr <= 120000L) && (paramabzy != null))
    {
      ThreadManager.getUIHandler().post(new ApolloPanelManager.1(this, paramabzy));
      return;
    }
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("cmd", "apollo_terminal_info.get_user_slaves_v2");
        localJSONObject.put("from", "android");
        if (paramabzy == null) {
          break label196;
        }
        if (paramabzy.c != null) {
          break label180;
        }
      }
      catch (Throwable paramabzy)
      {
        JSONObject localJSONObject;
        QLog.e("Apollo_PanelManager", 1, "[checkSlavesBeforeSend], errInfo->", paramabzy);
        return;
      }
      localJSONObject.put("actionId", paramabzy);
      paramabzy = new JSONArray();
      paramabzy.put(Long.parseLong(getApp().getCurrentAccountUin()));
      localJSONObject.put("toUins", paramabzy);
      ((aqrb)getApp().getBusinessHandler(71)).l("apollo_terminal_info.get_user_slaves_v2", localJSONObject.toString(), -1L, 7);
      return;
      label180:
      int i = paramabzy.c.actionId;
      paramabzy = Integer.valueOf(i);
      continue;
      label196:
      paramabzy = null;
    }
  }
  
  public void b(BaseChatPie paramBaseChatPie, abzy paramabzy)
  {
    if ((paramabzy == null) || (paramBaseChatPie == null) || (paramBaseChatPie.app == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Apollo_PanelManager", 2, new Object[] { "[sendActionMsg] mainInfo=", paramabzy });
    }
    SessionInfo localSessionInfo = paramBaseChatPie.a();
    paramabzy.c.atNickName = "";
    paramabzy.c.inputText = "";
    if (localSessionInfo.cZ == 0)
    {
      paramabzy.c.peerUin = localSessionInfo.aTl;
      paramabzy.c.inputText = aofy.iF(paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
    }
    label123:
    while (((localSessionInfo.cZ != 1) && (localSessionInfo.cZ != 3000)) || (paramBaseChatPie.mActivity == null))
    {
      localObject1 = paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
      if ((localObject1 == null) || (((String)localObject1).length() <= 99)) {
        break;
      }
      ChatActivityUtils.h(paramBaseChatPie.app.getApplication(), 2131719509, 1);
      return;
    }
    Object localObject1 = new ArrayList();
    appb.a(paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), (ArrayList)localObject1);
    Object localObject2;
    if (paramabzy.c.personNum == 1) {
      if ((((ArrayList)localObject1).size() == 1) && (0L != ((MessageForText.AtTroopMemberInfo)((ArrayList)localObject1).get(0)).uin) && (((MessageForText.AtTroopMemberInfo)((ArrayList)localObject1).get(0)).startPos == 0)) {
        localObject2 = aofy.iF(paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
      }
    }
    label793:
    label1111:
    for (;;)
    {
      try
      {
        paramabzy.c.atNickName = ((String)localObject2).substring(0, ((MessageForText.AtTroopMemberInfo)((ArrayList)localObject1).get(0)).textLen);
        if (((MessageForText.AtTroopMemberInfo)((ArrayList)localObject1).get(0)).textLen >= paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() - 1)
        {
          paramabzy.c.inputText = "";
          paramabzy.c.peerUin = (((MessageForText.AtTroopMemberInfo)((ArrayList)localObject1).get(0)).uin + "");
          paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
          i = 0;
          if (!TextUtils.isEmpty(paramabzy.c.inputText)) {
            break label753;
          }
          j = 2;
          i = j;
          if (TextUtils.isEmpty(paramabzy.bkj)) {
            break label1111;
          }
          if (paramabzy.cue != 0) {
            continue;
          }
          i = 6;
          VipUtils.a(paramBaseChatPie.app, "cmshow", "Apollo", "g_action_double_clk", localSessionInfo.aTl, -1, ApolloUtil.gi(localSessionInfo.cZ), new String[] { "" + paramabzy.c.actionId, "655_" + paramabzy.cud, "0", String.valueOf(System.currentTimeMillis() / 1000L) });
          localObject2 = paramBaseChatPie.app;
          String str1 = localSessionInfo.aTl;
          j = ApolloUtil.gi(localSessionInfo.cZ);
          String str2 = "" + paramabzy.c.actionId;
          if (!TextUtils.isEmpty(paramabzy.bkj)) {
            break label793;
          }
          localObject1 = "0";
          VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "g_action_double_sent", str1, i, j, new String[] { str2, localObject1, paramabzy.c.peerUin, String.valueOf(System.currentTimeMillis() / 1000L) });
          break label123;
        }
        paramabzy.c.inputText = ((String)localObject2).substring(((MessageForText.AtTroopMemberInfo)((ArrayList)localObject1).get(0)).textLen);
        continue;
      }
      catch (Exception localException)
      {
        int j;
        if (QLog.isColorLevel()) {
          QLog.d("Apollo_PanelManager", 2, "inputText err:" + localException.getMessage());
        }
        paramabzy.c.inputText = "";
        continue;
        i = j;
        if (paramabzy.cue != 1) {
          break label1111;
        }
      }
      int i = 7;
      continue;
      label753:
      if (TextUtils.isEmpty(paramabzy.bkj))
      {
        i = 3;
      }
      else if (paramabzy.cue == 0)
      {
        i = 4;
      }
      else if (paramabzy.cue == 1)
      {
        i = 5;
        continue;
        localObject1 = paramabzy.bkj;
        continue;
        if (paramabzy.c.actionType == 5)
        {
          a(paramabzy, paramBaseChatPie);
          return;
        }
        paramBaseChatPie.jdField_a_of_type_Abzy = paramabzy;
        i = 0;
        if (localSessionInfo.cZ == 3000) {
          i = 11;
        }
        for (;;)
        {
          localObject1 = TroopMemberListActivity.c(paramBaseChatPie.mActivity, localSessionInfo.aTl, i);
          if (paramBaseChatPie.vm() == 21) {
            ((Intent)localObject1).putExtra("param_troop_send_apollo_msg", true);
          }
          ((Intent)localObject1).putExtra("param_is_pop_up_style", true);
          ((Intent)localObject1).putExtra("param_troop_send_apollo_msg", true);
          paramBaseChatPie.mActivity.startActivityForResult((Intent)localObject1, 6001);
          VipUtils.a(paramBaseChatPie.app, "cmshow", "Apollo", "g_action_double_clk", localSessionInfo.aTl, -1, ApolloUtil.gi(localSessionInfo.cZ), new String[] { "" + paramabzy.c.actionId, "655_" + paramabzy.cud, "1", String.valueOf(System.currentTimeMillis() / 1000L) });
          return;
          if (localSessionInfo.cZ == 1) {
            i = 3;
          }
        }
        if (paramabzy.c.personNum != 0) {
          break label123;
        }
        paramabzy.c.inputText = aofy.iF(paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
        paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
        break label123;
        if ((localSessionInfo.cZ != 1) && (localSessionInfo.cZ != 3000)) {
          paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
        }
        if (paramBaseChatPie.mActivity == null) {
          break;
        }
        paramBaseChatPie.a(paramabzy);
        return;
      }
    }
  }
  
  public void c(BaseChatPie paramBaseChatPie, abzy paramabzy)
  {
    if ((paramBaseChatPie == null) || (paramBaseChatPie.app == null) || (paramBaseChatPie.a() == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Apollo_PanelManager", 2, new Object[] { "[previewNewAction] apolloInfo=", paramabzy });
    }
    SessionInfo localSessionInfo = paramBaseChatPie.a();
    ApolloActionData localApolloActionData = paramabzy.c;
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.mActionId = localApolloActionData.actionId;
    localSpriteTaskParam.mActionType = 0;
    localSpriteTaskParam.mAioType = localSessionInfo.cZ;
    localSpriteTaskParam.crd = 3;
    localSpriteTaskParam.mMsgId = -10000L;
    localSpriteTaskParam.cre = 0;
    localSpriteTaskParam.sC = 0.0F;
    boolean bool;
    if (paramabzy.cue == 1)
    {
      bool = true;
      localSpriteTaskParam.bEW = bool;
      localSpriteTaskParam.bhv = paramabzy.bkj;
      localSpriteTaskParam.crb = localApolloActionData.personNum;
      paramabzy = paramBaseChatPie.app.getCurrentUin();
      localSpriteTaskParam.mSenderUin = String.valueOf(paramabzy);
      if (localSessionInfo.cZ != 0) {
        break label338;
      }
      localSpriteTaskParam.bbE = localSessionInfo.aTl;
    }
    label338:
    while (localSpriteTaskParam.crb == 0)
    {
      if (localApolloActionData.actionType == 5)
      {
        localSpriteTaskParam.mActionType = 5;
        paramabzy = (abhh)paramBaseChatPie.app.getManager(153);
        if ((paramabzy != null) && (paramabzy.a() != null))
        {
          localSpriteTaskParam.bhw = paramabzy.a().bgg;
          if (QLog.isColorLevel()) {
            QLog.d("Apollo_PanelManager", 2, new Object[] { "[previewNewAction] mSlaveExtJson=", localSpriteTaskParam.bhw });
          }
        }
      }
      paramabzy = abrj.a(paramBaseChatPie.app);
      if (paramabzy != null) {
        paramabzy.a().a(localSpriteTaskParam);
      }
      VipUtils.a(paramBaseChatPie.app, "cmshow", "Apollo", "action_preview_play", ApolloUtil.gi(localSessionInfo.cZ), 0, new String[] { String.valueOf(localApolloActionData.actionId) });
      return;
      bool = false;
      break;
    }
    paramabzy = ((acff)paramBaseChatPie.app.getManager(51)).b(paramabzy);
    int i;
    if (paramabzy != null) {
      if (paramabzy.gender == 1) {
        i = 1;
      }
    }
    for (;;)
    {
      label377:
      if (i != 0) {}
      for (paramabzy = "-2";; paramabzy = "-1")
      {
        localSpriteTaskParam.bbE = paramabzy;
        break;
        i = 0;
        break label377;
      }
      i = 1;
    }
  }
  
  public void cBZ()
  {
    if (this.fg != null)
    {
      this.fg.clear();
      this.fg = null;
    }
  }
  
  public void cCa()
  {
    if ((this.ff == null) || (this.ff.get() == null) || (this.b == null)) {}
    for (;;)
    {
      return;
      this.bDc = false;
      BaseChatPie localBaseChatPie = (BaseChatPie)this.ff.get();
      SessionInfo localSessionInfo = localBaseChatPie.a();
      ApolloActionData localApolloActionData = this.b.c;
      int i = this.coS;
      if (localApolloActionData.currencyType != 1) {
        continue;
      }
      HashMap localHashMap = new HashMap();
      int j = this.coS;
      Object localObject4;
      String str2;
      Object localObject5;
      Object localObject3;
      Object localObject2;
      String str1;
      Object localObject1;
      if (localApolloActionData.currencyNum <= i)
      {
        localObject4 = acfp.m(2131702620);
        str2 = String.format(localBaseChatPie.mContext.getResources().getString(2131690345), new Object[] { Integer.valueOf(localApolloActionData.currencyNum), Integer.valueOf(j) });
        localObject5 = acfp.m(2131702625);
        localObject3 = "requestSSO";
        localObject2 = localObject5;
        str1 = str2;
        localObject1 = localObject4;
        if (localSessionInfo == null) {
          break label584;
        }
        VipUtils.a(localBaseChatPie.app, "cmshow", "Apollo", "icon_alert_show", ApolloUtil.gi(localSessionInfo.cZ), 0, new String[] { "" + localApolloActionData.actionId });
        localObject1 = "requestSSO";
        str1 = str2;
        localObject2 = localObject4;
        localHashMap.put("APOLLO_POP_TYPE", "dialog");
        localHashMap.put("feeType", String.valueOf(localApolloActionData.feeType));
        localHashMap.put("title", localObject2);
        localHashMap.put("content", str1);
        localHashMap.put("rightString", localObject5);
        localHashMap.put("url", localObject1);
        localHashMap.put("actionId", String.valueOf(localApolloActionData.actionId));
        localObject1 = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject1).put("packageId", String.valueOf(this.b.cud));
        localHashMap.put("extendJson", ((JSONObject)localObject1).toString());
        localObject1 = localBaseChatPie.app.getHandler(ChatActivity.class);
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((MqqHandler)localObject1).obtainMessage(45);
        ((Message)localObject1).obj = localHashMap;
        ((Message)localObject1).sendToTarget();
        return;
        localObject4 = acfp.m(2131702617);
        str2 = String.format(localBaseChatPie.mContext.getString(2131690344), new Object[] { Integer.valueOf(localApolloActionData.currencyNum), Integer.valueOf(j) });
        localObject5 = acfp.m(2131702623);
        String str3 = abxi.bjm + "&adtag=authGold";
        localObject3 = str3;
        localObject2 = localObject5;
        str1 = str2;
        localObject1 = localObject4;
        if (localSessionInfo != null)
        {
          VipUtils.a(localBaseChatPie.app, "cmshow", "Apollo", "debt_alert_show", ApolloUtil.gi(localSessionInfo.cZ), 0, new String[] { "" + localApolloActionData.actionId });
          localObject1 = localObject4;
          str1 = str2;
          localObject2 = localObject5;
          localObject3 = str3;
        }
        label584:
        localObject4 = localObject1;
        localObject1 = localObject3;
        localObject5 = localObject2;
        localObject2 = localObject4;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("Apollo_PanelManager", 1, "[authGoldAction] Exception:", localException);
        }
      }
    }
  }
  
  public QQAppInterface getApp()
  {
    if (this.mAppRef == null) {
      return null;
    }
    return (QQAppInterface)this.mAppRef.get();
  }
  
  public void l(long paramLong, String paramString1, String paramString2)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("Apollo_PanelManager", 2, new Object[] { "[onGetSlaveListFromSvr], ret:", Long.valueOf(paramLong), "resqData:", paramString1, ",reqData:", paramString2 });
    }
    if (0L != paramLong) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        this.Nr = System.currentTimeMillis();
        i = new JSONObject(paramString2).optInt("actionId");
        if (QLog.isColorLevel()) {
          QLog.d("Apollo_PanelManager", 2, new Object[] { "actionId:", Integer.valueOf(i), ",orgActionId:" });
        }
        paramString2 = getApp().getCurrentAccountUin();
        paramString1 = new JSONObject(paramString1);
        this.bgg = paramString1.toString();
        paramString1 = paramString1.getJSONObject("data");
        JSONArray localJSONArray = paramString1.getJSONArray("slaveInfoList");
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          i = 0;
          if (i < localJSONArray.length())
          {
            ApolloSlaveInfo localApolloSlaveInfo = (ApolloSlaveInfo)aqec.convertFrom(localJSONArray.getJSONObject(i), ApolloSlaveInfo.class);
            if (localApolloSlaveInfo == null) {
              break label349;
            }
            this.ds.put(Long.valueOf(localApolloSlaveInfo.uin), localApolloSlaveInfo);
            break label349;
          }
        }
        this.coT = paramString1.optInt("defaultActId");
        paramString1 = (ApolloSlaveInfo)this.ds.get(Long.valueOf(Long.parseLong(paramString2)));
        this.aR.set(paramString1.slaveTotal);
        if (paramString1.isCaptured == 1) {
          bool = true;
        }
        this.bDb = bool;
        if (QLog.isColorLevel()) {
          QLog.d("Apollo_PanelManager", 2, new Object[] { "my slave info", paramString1.toString() });
        }
        ThreadManager.getUIHandler().post(new ApolloPanelManager.2(this));
        return;
      }
      catch (Throwable paramString1)
      {
        QLog.e("Apollo_PanelManager", 1, "[onGetSlaveListFromSvr], errInfo->", paramString1);
        return;
      }
      label349:
      i += 1;
    }
  }
  
  public void onDestroy()
  {
    if (this.ds != null)
    {
      this.ds.clear();
      this.ds = null;
    }
    this.bgg = null;
  }
  
  public void p(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.fg != null)
    {
      abhs.a locala = (abhs.a)this.fg.get();
      if (locala != null) {
        locala.p(paramInt, paramBoolean1, paramBoolean2);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void p(int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abhs
 * JD-Core Version:    0.7.0.1
 */