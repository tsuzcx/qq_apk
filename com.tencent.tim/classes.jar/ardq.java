import KQQ.ProfSmpInfoRes;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DateNickNameInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x857.TroopTips0x857.WereWolfPush;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.ReqBody;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.ReqBody;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.RspBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xdd.submsgtype0xdd.MsgBody;

public class ardq
  extends accg
{
  protected static HashMap<String, WeakReference<TextView>> pG = new HashMap();
  protected ardq.b a = new ardq.b();
  protected BroadcastReceiver bG = new ardw(this);
  aree c = null;
  public String cAf;
  public boolean isNight;
  protected LruCache<String, String> mCache = new LruCache(100);
  
  public ardq(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.cAf = paramQQAppInterface.getApp().getSharedPreferences("werewolves_sp", 0).getString("judgeUin", "");
    IntentFilter localIntentFilter = new IntentFilter("tencent.video.v2q.memberSpeaking");
    paramQQAppInterface.getApplication().registerReceiver(this.bG, localIntentFilter);
  }
  
  public aree a(String paramString)
  {
    if (this.c == null) {
      this.c = new aree(paramString);
    }
    if (!TextUtils.isEmpty(paramString)) {
      this.c.cAg = paramString;
    }
    return this.c;
  }
  
  protected jnm.d a(ardq.a<oidb_0x8e4.RspBody> parama)
  {
    return new ardu(this, parama);
  }
  
  public void a(int paramInt1, int paramInt2, ardq.a<oidb_0x8e4.RspBody> parama)
  {
    oidb_0x8e4.ReqBody localReqBody = new oidb_0x8e4.ReqBody();
    localReqBody.uint32_max_member_num.set(paramInt1, true);
    localReqBody.uint32_zone_id.set(paramInt2);
    jnm.a(this.app, a(parama), localReqBody.toByteArray(), "OidbSvc.0x8e4_1", 2276, 1, new Bundle(), 5000L);
  }
  
  public void a(TextView paramTextView, String paramString1, String paramString2)
  {
    if (this.app.getCurrentAccountUin().equals(paramString1)) {}
    do
    {
      try
      {
        paramTextView.setText(String.format(paramString2, new Object[] { this.app.getCurrentNickname() }));
        return;
      }
      catch (Exception paramString1)
      {
        paramTextView.setText(this.app.getCurrentNickname());
        return;
      }
      Object localObject = (acff)this.app.getManager(51);
      if (((acff)localObject).isFriend(paramString1))
      {
        paramString1 = aqgv.A(this.app, paramString1);
        try
        {
          paramTextView.setText(String.format(paramString2, new Object[] { paramString1 }));
          return;
        }
        catch (Exception paramString2)
        {
          paramTextView.setText(paramString1);
          return;
        }
      }
      localObject = ((acff)localObject).a(paramString1);
      if ((localObject != null) && (((DateNickNameInfo)localObject).nickName != null) && (!((DateNickNameInfo)localObject).nickName.equals(paramString1))) {
        try
        {
          paramTextView.setText(String.format(paramString2, new Object[] { ((DateNickNameInfo)localObject).nickName }));
          return;
        }
        catch (Exception paramString1)
        {
          paramTextView.setText(((DateNickNameInfo)localObject).nickName);
          return;
        }
      }
      paramTextView.setText(paramString1);
      paramTextView.setTag(new String[] { paramString1, paramString2 });
      if (pG.containsKey(paramString1))
      {
        pG.remove(paramString1);
        pG.put(paramString1, new WeakReference(paramTextView));
        return;
      }
      pG.put(paramString1, new WeakReference(paramTextView));
      paramTextView = createToServiceMsg("ProfileService.GetSimpleInfo");
      paramString2 = new ArrayList();
      paramString2.add(paramString1);
      paramTextView.extraData.putStringArrayList("uinList", paramString2);
      paramTextView.extraData.putBoolean("reqDateNick", true);
      send(paramTextView);
    } while (!QLog.isColorLevel());
    QLog.d("WerewolvesHandler", 2, "WerewolvesHandler: setNickname->sendToServiceMsg, uin = " + paramString1);
  }
  
  public void a(ardq.a<oidb_0x8e4.RspBody> parama)
  {
    if (QLog.isColorLevel()) {
      QLog.e("WerewolvesHandler", 2, "reqInviteId");
    }
    oidb_0x8e4.ReqBody localReqBody = new oidb_0x8e4.ReqBody();
    jnm.a(this.app, a(parama), localReqBody.toByteArray(), "OidbSvc.0x8e4_6", 2276, 6, new Bundle(), 5000L);
  }
  
  public void a(HotChatInfo paramHotChatInfo, int paramInt1, int paramInt2, ardq.a<oidb_0x8e4.RspBody> parama)
  {
    if (QLog.isColorLevel()) {
      QLog.e("WerewolvesHandler", 2, "exitRoom");
    }
    oidb_0x8ed.ReqBody localReqBody = new oidb_0x8ed.ReqBody();
    ards localards = new ards(this, parama);
    try
    {
      long l = Long.parseLong(paramHotChatInfo.troopUin);
      localReqBody.uint64_room_id.set(l, true);
      localReqBody.rpt_uint64_uins.add(Long.valueOf(this.app.getLongAccountUin()));
      jnm.a(this.app, b(new ardt(this, localards, paramHotChatInfo, l, paramInt2, paramInt1, parama)), localReqBody.toByteArray(), "OidbSvc.0x8ed_2", 2285, 2, new Bundle(), 5000L);
      return;
    }
    catch (Exception paramHotChatInfo)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("WerewolvesHandler", 2, "hotChatInfo.troopUin is wrong");
    }
  }
  
  public void a(HotChatInfo paramHotChatInfo, ardq.a<oidb_0x8ed.RspBody> parama)
  {
    if (QLog.isColorLevel()) {
      QLog.e("WerewolvesHandler", 2, "exitRoom");
    }
    oidb_0x8ed.ReqBody localReqBody = new oidb_0x8ed.ReqBody();
    try
    {
      long l = Long.parseLong(paramHotChatInfo.troopUin);
      localReqBody.uint64_room_id.set(l, true);
      localReqBody.rpt_uint64_uins.add(Long.valueOf(this.app.getLongAccountUin()));
      jnm.a(this.app, b(new ardr(this, parama, paramHotChatInfo)), localReqBody.toByteArray(), "OidbSvc.0x8ed_2", 2285, 2, new Bundle(), 5000L);
      ajry.a().cB(l);
      ajrb.c(this.app.getCurrentAccountUin(), "game_room_last_time", Long.valueOf(anaz.gQ()));
      try
      {
        if ((paramHotChatInfo.troopUin != null) && (!paramHotChatInfo.troopUin.equals("0"))) {
          this.app.b().N(paramHotChatInfo.troopUin, 1);
        }
        if (this.c != null)
        {
          this.c.onDestroy();
          return;
        }
      }
      catch (Exception paramHotChatInfo)
      {
        for (;;)
        {
          paramHotChatInfo.printStackTrace();
        }
      }
      return;
    }
    catch (Exception paramHotChatInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WerewolvesHandler", 2, "hotChatInfo.troopUin is wrong");
      }
    }
  }
  
  public void a(String paramString, long paramLong, ardq.a<oidb_0x8e4.RspBody> parama)
  {
    if (QLog.isColorLevel()) {
      QLog.e("WerewolvesHandler", 2, "kickInviteUser");
    }
    oidb_0x8e4.ReqBody localReqBody = new oidb_0x8e4.ReqBody();
    localReqBody.string_invite_id.set(ByteStringMicro.copyFromUtf8(paramString), true);
    localReqBody.uint64_kick_uin.set(paramLong, true);
    jnm.a(this.app, a(parama), localReqBody.toByteArray(), "OidbSvc.0x8e4_5", 2276, 5, new Bundle(), 5000L);
  }
  
  public void a(String paramString, ardq.a<oidb_0x8e4.RspBody> parama)
  {
    oidb_0x8e4.ReqBody localReqBody = new oidb_0x8e4.ReqBody();
    localReqBody.string_invite_id.set(ByteStringMicro.copyFromUtf8(paramString), true);
    jnm.a(this.app, a(parama), localReqBody.toByteArray(), "OidbSvc.0x8e4_3", 2276, 3, new Bundle(), 5000L);
  }
  
  public void a(String paramString, boolean paramBoolean, ardq.a<oidb_0x8e4.RspBody> parama)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("WerewolvesHandler", 2, "acceptInvite failed, invitedId null; isAccept = " + paramBoolean);
      return;
    }
    oidb_0x8e4.ReqBody localReqBody = new oidb_0x8e4.ReqBody();
    localReqBody.string_invite_id.set(ByteStringMicro.copyFromUtf8(paramString), true);
    paramString = localReqBody.uint32_accept_invite;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      paramString.set(i, true);
      localReqBody.uint32_ready_state.set(2);
      jnm.a(this.app, a(parama), localReqBody.toByteArray(), "OidbSvc.0x8e4_2", 2276, 2, new Bundle(), 5000L);
      return;
    }
  }
  
  public void a(TroopTips0x857.WereWolfPush paramWereWolfPush, byte[] paramArrayOfByte)
  {
    if (paramWereWolfPush == null) {}
    String str2;
    long l;
    String str1;
    do
    {
      do
      {
        return;
        if ((!paramWereWolfPush.uint64_game_room.has()) || (!paramWereWolfPush.bytes_judge_words.has()) || (!paramWereWolfPush.uint64_judge_uin.has())) {
          break label502;
        }
        str2 = paramWereWolfPush.uint64_game_room.get() + "";
        l = anaz.gQ();
        str1 = paramWereWolfPush.bytes_judge_words.get().toStringUtf8();
        if (!TextUtils.isEmpty(str1)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.werewolf.WereWolfPush", 2, "uint64_game_room:" + str2 + ", msg is empty");
      return;
      localObject = this.app.a(false);
    } while (localObject == null);
    Object localObject = ((HotChatManager)localObject).a(str2);
    if ((localObject == null) || (!((HotChatInfo)localObject).isGameRoom))
    {
      ((acfv)this.app.getBusinessHandler(35)).Je(2);
      return;
    }
    localObject = this.app.b().a(str2, 1);
    MessageRecord localMessageRecord = anbi.d(-1000);
    localMessageRecord.init(this.app.getCurrentAccountUin(), str2, this.app.getCurrentAccountUin(), str1, l, -1000, 1, l);
    if (localObject != null) {
      localMessageRecord.shmsgseq = ((QQMessageFacade.Message)localObject).shmsgseq;
    }
    localMessageRecord.senderuin = (paramWereWolfPush.uint64_judge_uin.get() + "");
    this.cAf = localMessageRecord.senderuin;
    localObject = "";
    if (paramWereWolfPush.bytes_judge_nickname.has())
    {
      localObject = paramWereWolfPush.bytes_judge_nickname.get().toStringUtf8();
      ((TroopManager)this.app.getManager(52)).a(str2, paramWereWolfPush.uint64_judge_uin.get() + "", (String)localObject, 0, null, null, 0, 0, 0, 0L, (byte)0, 0L, 0.0D);
    }
    localMessageRecord.isread = true;
    localMessageRecord.issend = 0;
    localMessageRecord.saveExtInfoToExtStr("isJudgeMsg", "true");
    this.app.b().b(localMessageRecord, this.app.getCurrentAccountUin());
    paramWereWolfPush = this.app.a().a();
    paramWereWolfPush.f(paramWereWolfPush.a(str2, 1));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("uint64_game_room:").append(str2).append("|judge_nickname:").append((String)localObject).append("|msg:");
      if (!TextUtils.isEmpty(str1)) {
        break label521;
      }
    }
    label521:
    for (paramWereWolfPush = "";; paramWereWolfPush = str1.substring(0, 1) + "***" + str1.substring(str1.length() - 1) + "|msg len:" + str1.length())
    {
      QLog.d("Q.werewolf.WereWolfPush", 2, paramWereWolfPush);
      label502:
      if (this.c == null) {
        break;
      }
      this.c.F("WereWolfPush", paramArrayOfByte);
      return;
    }
  }
  
  protected jnm.d b(ardq.a<oidb_0x8ed.RspBody> parama)
  {
    return new ardv(this, parama);
  }
  
  public void b(int paramInt1, int paramInt2, ardq.a<oidb_0x8e4.RspBody> parama)
  {
    if (QLog.isColorLevel()) {
      QLog.e("WerewolvesHandler", 2, "quickStartGame");
    }
    oidb_0x8e4.ReqBody localReqBody = new oidb_0x8e4.ReqBody();
    localReqBody.uint32_play_way.set(1, true);
    localReqBody.uint32_max_member_num.set(paramInt1);
    localReqBody.uint32_zone_id.set(paramInt2);
    jnm.a(this.app, a(parama), localReqBody.toByteArray(), "OidbSvc.0x8e4_4", 2276, 4, new Bundle(), 5000L);
  }
  
  public void b(String paramString, ardq.a<oidb_0x8e4.RspBody> parama)
  {
    if (QLog.isColorLevel()) {
      QLog.e("WerewolvesHandler", 2, "startGame");
    }
    oidb_0x8e4.ReqBody localReqBody = new oidb_0x8e4.ReqBody();
    localReqBody.string_invite_id.set(ByteStringMicro.copyFromUtf8(paramString), true);
    localReqBody.uint32_play_way.set(2, true);
    jnm.a(this.app, a(parama), localReqBody.toByteArray(), "OidbSvc.0x8e4_4", 2276, 4, new Bundle(), 5000L);
  }
  
  public void b(String paramString, boolean paramBoolean, ardq.a<oidb_0x8e4.RspBody> parama)
  {
    oidb_0x8e4.ReqBody localReqBody = new oidb_0x8e4.ReqBody();
    localReqBody.string_invite_id.set(ByteStringMicro.copyFromUtf8(paramString));
    paramString = localReqBody.uint32_ready_state;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      paramString.set(i);
      jnm.a(this.app, a(parama), localReqBody.toByteArray(), "OidbSvc.0x8e4_7", 2276, 7, new Bundle(), 5000L);
      return;
    }
  }
  
  public void bF(byte[] paramArrayOfByte)
  {
    submsgtype0xdd.MsgBody localMsgBody = new submsgtype0xdd.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramArrayOfByte);
      notifyUI(1, true, localMsgBody);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("WerewolvesHandler", 2, QLog.getStackTraceString(paramArrayOfByte));
    }
  }
  
  public void clear()
  {
    this.c = null;
  }
  
  public void d(HotChatInfo paramHotChatInfo)
  {
    try
    {
      long l = Long.parseLong(paramHotChatInfo.troopUin);
      ajry.a().cB(l);
      ajrb.c(this.app.getCurrentAccountUin(), "game_room_last_time", Long.valueOf(anaz.gQ()));
      if ((paramHotChatInfo.troopUin != null) && (!paramHotChatInfo.troopUin.equals("0"))) {
        this.app.b().N(paramHotChatInfo.troopUin, 1);
      }
      if (this.c != null) {
        this.c.onDestroy();
      }
      HotChatManager localHotChatManager = (HotChatManager)this.app.getManager(60);
      List localList = localHotChatManager.dX();
      if (localList != null) {
        localList.remove(paramHotChatInfo);
      }
      localHotChatManager.b(paramHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_IS_DISBANDED);
      return;
    }
    catch (Exception paramHotChatInfo)
    {
      paramHotChatInfo.printStackTrace();
    }
  }
  
  protected Class<? extends acci> observerClass()
  {
    return arec.class;
  }
  
  public void onDestroy()
  {
    ajry localajry = ajry.a();
    this.app.getApplication().unregisterReceiver(this.bG);
    localajry.dyZ();
    localajry.unbindService();
    if (this.c != null) {
      this.c.onDestroy();
    }
    if (!TextUtils.isEmpty(this.cAf)) {
      this.app.getApp().getSharedPreferences("werewolves_sp", 0).edit().putString("judgeUin", this.cAf).commit();
    }
    this.a.removeCallbacksAndMessages(null);
    super.onDestroy();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.protocol", 2, "WereWolevsHandler onReceive. cmd=" + (String)localObject);
    }
    if ("ProfileService.GetSimpleInfo".equals(localObject))
    {
      paramToServiceMsg = paramToServiceMsg.extraData.getStringArrayList("uinList");
      if (paramFromServiceMsg.isSuccess())
      {
        localObject = (ArrayList)paramObject;
        if ((localObject != null) && (paramToServiceMsg != null) && (((ArrayList)localObject).size() > 0) && (paramToServiceMsg.size() > 0))
        {
          paramObject = (String)paramToServiceMsg.get(0);
          paramFromServiceMsg = ((ProfSmpInfoRes)((ArrayList)localObject).get(0)).sDateNick;
          paramToServiceMsg = paramFromServiceMsg;
          if (TextUtils.isEmpty(paramFromServiceMsg)) {
            paramToServiceMsg = ((ProfSmpInfoRes)((ArrayList)localObject).get(0)).strNick;
          }
          paramFromServiceMsg = new Message();
          paramFromServiceMsg.obj = new String[] { paramObject, paramToServiceMsg };
          this.a.sendMessage(paramFromServiceMsg);
        }
      }
    }
  }
  
  public static abstract interface a<T>
  {
    public abstract void v(int paramInt, T paramT);
  }
  
  public static class b
    extends Handler
  {
    public b()
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      paramMessage = (String[])paramMessage.obj;
      Object localObject = paramMessage[0];
      CharSequence localCharSequence = paramMessage[1];
      WeakReference localWeakReference = (WeakReference)ardq.pG.remove(localObject);
      if ((localWeakReference != null) && (localWeakReference.get() != null))
      {
        if (!(((TextView)localWeakReference.get()).getTag() instanceof String[])) {
          break label142;
        }
        paramMessage = (String[])((TextView)localWeakReference.get()).getTag();
      }
      for (;;)
      {
        if ((paramMessage != null) && (paramMessage.length == 2) && (paramMessage[0].equals(localObject))) {}
        try
        {
          ((TextView)localWeakReference.get()).setText(String.format(paramMessage[1], new Object[] { localCharSequence }));
          ((TextView)localWeakReference.get()).setText(localCharSequence);
          return;
          label142:
          paramMessage = null;
        }
        catch (Exception paramMessage)
        {
          for (;;)
          {
            ((TextView)localWeakReference.get()).setText(localCharSequence);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ardq
 * JD-Core Version:    0.7.0.1
 */