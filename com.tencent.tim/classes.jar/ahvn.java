import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gameparty.GamePartyManager.4;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Vector;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.GameTeam_MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.GameTeam_StartGameMessage;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.GameTeam_TurnOverMessage;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.GameTeam_UpdateTeamMessage;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.InviteSource;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.MsgBody;

public class ahvn
  implements adqq.a, Manager
{
  static int dbv = 3600;
  public Vector<ahvn.b> D = new Vector();
  private SharedPreferences S;
  private ahvr a;
  public String bLP;
  public int bZj;
  public int bZk;
  private boolean ciu;
  public long createTime;
  public int dbw;
  public int expire;
  protected Handler handler = new ahvo(this, Looper.getMainLooper());
  public String teamId;
  private String toUin;
  private int uinType;
  public long updateTime;
  private WeakReference<QQAppInterface> weakApp;
  
  public ahvn(QQAppInterface paramQQAppInterface)
  {
    this.weakApp = new WeakReference(paramQQAppInterface);
    this.ciu = false;
    this.uinType = -1;
    this.bZj = 0;
    this.bZk = 0;
    this.createTime = 0L;
    this.expire = dbv;
    this.updateTime = 0L;
    this.bLP = "";
    this.dbw = 0;
    Object localObject = paramQQAppInterface.getApp();
    int i;
    if (Build.VERSION.SDK_INT > 10) {
      i = 4;
    }
    for (;;)
    {
      this.S = ((BaseApplication)localObject).getSharedPreferences("GamePartyManger", i);
      localObject = this.S.getString("gamePartyInfo" + paramQQAppInterface.getCurrentAccountUin(), "");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      try
      {
        this.teamId = new JSONObject((String)localObject).getString("teamId");
        a("https://openmobile.qq.com/gameteam/get_team_context?uin=" + paramQQAppInterface.getCurrentAccountUin(), new ahvp(this));
        this.a = ((ahvr)a());
        adqq.a("com.tencent.qqopen.teamup", this);
        return;
        i = 0;
      }
      catch (JSONException paramQQAppInterface)
      {
        for (;;)
        {
          this.ciu = false;
        }
      }
    }
  }
  
  private void a(SubMsgType0xaa.GameTeam_TurnOverMessage paramGameTeam_TurnOverMessage)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.weakApp.get();
    if (localQQAppInterface == null) {
      return;
    }
    int i = paramGameTeam_TurnOverMessage.uint32_sessionType.get();
    Object localObject2 = paramGameTeam_TurnOverMessage.str_sourceUin.get();
    String str1 = paramGameTeam_TurnOverMessage.str_actionUin.get();
    int j = paramGameTeam_TurnOverMessage.actionType.get();
    String str2 = paramGameTeam_TurnOverMessage.str_teamId.get();
    boolean bool = localQQAppInterface.getCurrentAccountUin().equals(str1);
    long l = NetConnInfoCenter.getServerTime();
    int k = hU(i);
    Object localObject1;
    if (bool)
    {
      paramGameTeam_TurnOverMessage = localQQAppInterface.getApp().getString(2131694215);
      switch (j)
      {
      case 5: 
      default: 
        return;
      case 1: 
        localObject1 = localQQAppInterface.getApp().getString(2131694234);
      }
    }
    for (;;)
    {
      String str3 = localQQAppInterface.getApp().getString(2131694236);
      paramGameTeam_TurnOverMessage = paramGameTeam_TurnOverMessage + (String)localObject1 + str3;
      localObject1 = (MessageForGrayTips)anbi.d(-2049);
      ((MessageForGrayTips)localObject1).init(localQQAppInterface.getAccount(), (String)localObject2, str1, paramGameTeam_TurnOverMessage, l, -2049, k, 0L);
      str1 = String.format("https://openmobile.qq.com/TeamGame/index.html?_wv=1031&uin=%s&team_id=%s&srcSessionType=%d&srcSessionUin=%s", new Object[] { localQQAppInterface.getAccount(), str2, Integer.valueOf(i), localObject2 });
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("key_action", 1);
      ((Bundle)localObject2).putString("key_action_DATA", str1);
      ((Bundle)localObject2).putString("key_a_action_DATA", str1);
      ((MessageForGrayTips)localObject1).addHightlightItem(paramGameTeam_TurnOverMessage.indexOf(str3), paramGameTeam_TurnOverMessage.length(), (Bundle)localObject2);
      ((MessageForGrayTips)localObject1).isread = true;
      localQQAppInterface.b().b((MessageRecord)localObject1, localQQAppInterface.getCurrentAccountUin());
      arts.a().a(localQQAppInterface.getCurrentAccountUin(), "", "", "2000", "2011", "0", false);
      return;
      switch (k)
      {
      default: 
        paramGameTeam_TurnOverMessage = str1;
        break;
      case 0: 
        paramGameTeam_TurnOverMessage = aqgv.a(localQQAppInterface, str1, (String)localObject2, 0, 0);
        break;
      case 1: 
        paramGameTeam_TurnOverMessage = aqgv.a(localQQAppInterface, str1, (String)localObject2, 1, 0);
        break;
      case 3000: 
        paramGameTeam_TurnOverMessage = aqgv.a(localQQAppInterface, str1, (String)localObject2, 2, 0);
        break;
        localObject1 = localQQAppInterface.getApp().getString(2131694237);
        continue;
        localObject1 = localQQAppInterface.getApp().getString(2131694221);
        continue;
        localObject1 = localQQAppInterface.getApp().getString(2131694235);
      }
    }
  }
  
  private void a(SubMsgType0xaa.GameTeam_TurnOverMessage paramGameTeam_TurnOverMessage, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.weakApp.get();
    if (localQQAppInterface == null) {}
    int m;
    String str3;
    int i;
    Object localObject;
    boolean bool2;
    boolean bool1;
    label252:
    do
    {
      String str1;
      int j;
      long l;
      String str2;
      int k;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    m = paramGameTeam_TurnOverMessage.uint32_sessionType.get();
                    str3 = paramGameTeam_TurnOverMessage.str_sourceUin.get();
                    String str4 = paramGameTeam_TurnOverMessage.str_actionUin.get();
                    str1 = paramGameTeam_TurnOverMessage.str_teamId.get();
                    i = paramGameTeam_TurnOverMessage.uint32_currentCount.get();
                    j = paramGameTeam_TurnOverMessage.uint32_totalCount.get();
                    l = paramGameTeam_TurnOverMessage.uint64_buildTeamTime.get();
                    str2 = paramGameTeam_TurnOverMessage.str_leaderUin.get();
                    k = paramGameTeam_TurnOverMessage.uin32_leaderStatus.get();
                    localObject = null;
                    if (paramGameTeam_TurnOverMessage.InviteSourceList.has()) {
                      localObject = paramGameTeam_TurnOverMessage.InviteSourceList.get();
                    }
                    bool2 = localQQAppInterface.getCurrentAccountUin().equals(str4);
                    if ((this.ciu) && (!TextUtils.isEmpty(this.teamId)) && (this.teamId.equals(str1))) {}
                    for (bool1 = true;; bool1 = false)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("GamePartyManager", 2, "handlePushMsg_TurnOver_BlueBar, self = " + bool2 + ", expired = " + paramBoolean + ", inParty = " + this.ciu + ", inSameParty = " + bool1);
                      }
                      if (!paramBoolean) {
                        break label252;
                      }
                      if (!bool1) {
                        break;
                      }
                      dqr();
                      return;
                    }
                    switch (paramGameTeam_TurnOverMessage.actionType.get())
                    {
                    default: 
                      return;
                    case 1: 
                      if (bool2)
                      {
                        this.uinType = hU(m);
                        this.toUin = str3;
                        this.teamId = str1;
                        this.bZj = i;
                        this.bZk = j;
                        this.createTime = l;
                        this.bLP = str2;
                        this.dbw = k;
                        dqq();
                        return;
                      }
                      break;
                    }
                  } while (!bool1);
                  this.bZj = i;
                  this.bZk = j;
                  this.dbw = k;
                  this.a.setChanged();
                  this.a.notifyObservers(Integer.valueOf(2));
                  return;
                  if (!bool2) {
                    break;
                  }
                } while (!bool1);
                dqr();
                return;
              } while (!bool1);
              this.bZj = i;
              this.bZk = j;
              this.dbw = k;
              this.a.setChanged();
              this.a.notifyObservers(Integer.valueOf(2));
              return;
            } while (!bool1);
            dqr();
            return;
            if (!bool2) {
              break;
            }
          } while (!bool1);
          dqr();
          return;
        } while (!bool1);
        this.bZj = i;
        this.bZk = j;
        this.dbw = k;
        this.a.setChanged();
        this.a.notifyObservers(Integer.valueOf(2));
        return;
      } while (!bool2);
      this.uinType = hU(m);
      this.toUin = str3;
      this.D.clear();
      if (localObject == null)
      {
        this.D.add(new ahvn.b(this.uinType, this.toUin));
        this.teamId = str1;
        this.bZj = i;
        this.bZk = j;
        this.createTime = l;
        this.bLP = str2;
        this.dbw = k;
        dqq();
        return;
      }
      paramGameTeam_TurnOverMessage = ((List)localObject).iterator();
      while (paramGameTeam_TurnOverMessage.hasNext())
      {
        localObject = (SubMsgType0xaa.InviteSource)paramGameTeam_TurnOverMessage.next();
        if ((((SubMsgType0xaa.InviteSource)localObject).type.has()) && (((SubMsgType0xaa.InviteSource)localObject).src.has()))
        {
          m = ((SubMsgType0xaa.InviteSource)localObject).type.get();
          localObject = ((SubMsgType0xaa.InviteSource)localObject).src.get();
          if ((m >= 0) && (!TextUtils.isEmpty((CharSequence)localObject)))
          {
            localObject = new ahvn.b(hU(m), (String)localObject);
            this.D.add(localObject);
          }
        }
      }
    } while ((!bool2) || (!bool1));
    this.D.clear();
    if (localObject == null) {
      this.D.add(new ahvn.b(hU(m), str3));
    }
    for (;;)
    {
      this.a.setChanged();
      this.a.notifyObservers(Integer.valueOf(2));
      return;
      paramGameTeam_TurnOverMessage = ((List)localObject).iterator();
      while (paramGameTeam_TurnOverMessage.hasNext())
      {
        localObject = (SubMsgType0xaa.InviteSource)paramGameTeam_TurnOverMessage.next();
        if ((((SubMsgType0xaa.InviteSource)localObject).type.has()) && (((SubMsgType0xaa.InviteSource)localObject).src.has()))
        {
          i = ((SubMsgType0xaa.InviteSource)localObject).type.get();
          localObject = ((SubMsgType0xaa.InviteSource)localObject).src.get();
          if ((i >= 0) && (!TextUtils.isEmpty((CharSequence)localObject)))
          {
            localObject = new ahvn.b(hU(i), (String)localObject);
            this.D.add(localObject);
          }
        }
      }
    }
  }
  
  private void clean()
  {
    this.ciu = false;
    this.uinType = -1;
    this.toUin = "";
    this.teamId = "";
    this.bZj = 0;
    this.bZk = 0;
    this.createTime = 0L;
    this.updateTime = 0L;
    this.bLP = "";
    this.dbw = 0;
    this.D.clear();
  }
  
  public static int hT(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 1;
    }
    return 2;
  }
  
  public static int hU(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 1;
    }
    return 3000;
  }
  
  public boolean C(int paramInt, String paramString)
  {
    Object localObject = (QQAppInterface)this.weakApp.get();
    if (localObject == null) {
      return false;
    }
    if ((this.ciu) && (paramInt >= 0) && (!TextUtils.isEmpty(paramString)))
    {
      if (((QQAppInterface)localObject).getCurrentAccountUin().equals(this.bLP))
      {
        localObject = this.D.iterator();
        ahvn.b localb;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localb = (ahvn.b)((Iterator)localObject).next();
        } while ((paramInt != localb.uinType) || (!paramString.equals(localb.toUin)));
        return true;
      }
      if ((paramInt == this.uinType) && (paramString.equals(this.toUin))) {
        return true;
      }
    }
    return false;
  }
  
  public Observable a()
  {
    if (this.a == null) {
      this.a = new ahvr();
    }
    return this.a;
  }
  
  public void a(String paramString, ahvn.a parama)
  {
    ThreadManager.post(new GamePartyManager.4(this, paramString, parama), 5, null, false);
  }
  
  protected void a(SubMsgType0xaa.GameTeam_StartGameMessage paramGameTeam_StartGameMessage, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.weakApp.get();
    if (localQQAppInterface == null) {}
    do
    {
      return;
      if ((paramGameTeam_StartGameMessage.str_appid.has()) && (paramGameTeam_StartGameMessage.str_packageName.has()) && (paramGameTeam_StartGameMessage.str_gamedata.has()) && (paramGameTeam_StartGameMessage.str_title.has()) && (paramGameTeam_StartGameMessage.str_summary.has()) && (paramGameTeam_StartGameMessage.str_picUrl.has()) && (paramGameTeam_StartGameMessage.uint64_buildTeamTime.has()) && (paramGameTeam_StartGameMessage.uint64_createMsgTime.has()) && (paramGameTeam_StartGameMessage.uint32_platformType.has())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("GamePartyManager", 2, "handlePushMsg_StartGame, parse param failed");
    return;
    Object localObject = paramGameTeam_StartGameMessage.str_gamedata.get().split("_");
    long l2;
    long l1;
    if (localObject.length > 2)
    {
      localObject = localObject[2];
      l2 = paramGameTeam_StartGameMessage.uint64_buildTeamTime.get();
      l1 = NetConnInfoCenter.getServerTime();
      if (l1 <= l2) {
        break label338;
      }
    }
    label338:
    for (l1 -= l2;; l1 = l2 - l1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GamePartyManager", 2, "handlePushMsg_StartGame, createTime = " + l2);
      }
      if ((paramGameTeam_StartGameMessage.uint32_platformType.get() & 0x2) != 2) {
        break;
      }
      localObject = "[\"" + (String)localObject + "\"]";
      try
      {
        String str = URLEncoder.encode((String)localObject, "utf-8");
        localObject = str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
      }
      a("https://openmobile.qq.com/gameteam/get_team_info?uin=" + localQQAppInterface.getCurrentAccountUin() + "&team_list=" + (String)localObject, new ahvq(this, l1, paramGameTeam_StartGameMessage, l2, paramBoolean));
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("GamePartyManager", 2, "handlePushMsg_StartGame, parse gamedata failed");
      return;
    }
  }
  
  protected void a(SubMsgType0xaa.GameTeam_UpdateTeamMessage paramGameTeam_UpdateTeamMessage)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.weakApp.get();
    if (localQQAppInterface == null) {}
    for (;;)
    {
      return;
      if ((!paramGameTeam_UpdateTeamMessage.str_teamId.has()) || (!paramGameTeam_UpdateTeamMessage.uint32_status.has()) || (!paramGameTeam_UpdateTeamMessage.uint32_current_count.has()) || (!paramGameTeam_UpdateTeamMessage.uint64_buildTeamTime.has()) || (!paramGameTeam_UpdateTeamMessage.uint64_createMsgTime.has()) || (!paramGameTeam_UpdateTeamMessage.str_leaderUin.has()) || (!paramGameTeam_UpdateTeamMessage.uin32_leaderStatus.has()))
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("GamePartyManager", 2, "handlePushMsg_UpdateTeam, parse param failed");
        return;
      }
      long l = paramGameTeam_UpdateTeamMessage.uint64_buildTeamTime.get();
      String str = paramGameTeam_UpdateTeamMessage.str_teamId.get();
      int i = paramGameTeam_UpdateTeamMessage.uint32_status.get();
      int j = paramGameTeam_UpdateTeamMessage.uint32_current_count.get();
      if (QLog.isColorLevel()) {
        QLog.d("GamePartyManager", 2, "handlePushMsg_UpdateTeam, teamId = " + str + ", status = " + i + ", member = " + j + ", createTime = " + l);
      }
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("team_id", str);
        ((JSONObject)localObject).put("status", i);
        ((JSONObject)localObject).put("member_count", j);
        label244:
        localObject = ((JSONObject)localObject).toString();
        try
        {
          ArkAppCenter.f("com.tencent.qqopen.teamup", "update_team_info", (String)localObject, "json");
          localObject = new Intent();
          ((Intent)localObject).setAction("android.intent.action.gameparty.notify");
          ((Intent)localObject).putExtra("uin", localQQAppInterface.getCurrentAccountUin());
          ((Intent)localObject).putExtra("teamId", str);
          localQQAppInterface.getApp().sendBroadcast((Intent)localObject);
          j = paramGameTeam_UpdateTeamMessage.uin32_leaderStatus.get();
          if ((!this.ciu) || (TextUtils.isEmpty(this.teamId)) || (!this.teamId.equals(str))) {
            continue;
          }
          if (i >= 5)
          {
            dqr();
            return;
          }
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("GamePartyManager", 2, "arkNotify failed, .so not loaded");
            }
          }
        }
        if ((i <= 0) || (this.dbw == j)) {
          continue;
        }
        this.dbw = j;
        this.a.setChanged();
        this.a.notifyObservers(Integer.valueOf(2));
        return;
      }
      catch (JSONException localJSONException)
      {
        break label244;
      }
    }
  }
  
  public void a(SubMsgType0xaa.MsgBody paramMsgBody, boolean paramBoolean)
  {
    if (!paramMsgBody.cmd.has()) {}
    label10:
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            break label10;
            break label10;
            do
            {
              return;
            } while ((paramMsgBody.cmd.get() != 1) || (!paramMsgBody.msg_gameTeamMsg.has()));
            paramMsgBody = (SubMsgType0xaa.GameTeam_MsgBody)paramMsgBody.msg_gameTeamMsg.get();
          } while (!paramMsgBody.uint32_GameTeamCmd.has());
          i = paramMsgBody.uint32_GameTeamCmd.get();
          if (i != 2000) {
            break;
          }
        } while (!paramMsgBody.msg_turnOverMessage.has());
        b((SubMsgType0xaa.GameTeam_TurnOverMessage)paramMsgBody.msg_turnOverMessage.get());
        return;
        if (i != 2001) {
          break;
        }
      } while (!paramMsgBody.msg_startGameMessage.has());
      a((SubMsgType0xaa.GameTeam_StartGameMessage)paramMsgBody.msg_startGameMessage.get(), paramBoolean);
      return;
    } while ((i != 2002) || (paramBoolean) || (!paramMsgBody.msg_updateTeamMessage.has()));
    a((SubMsgType0xaa.GameTeam_UpdateTeamMessage)paramMsgBody.msg_updateTeamMessage.get());
  }
  
  protected void b(SubMsgType0xaa.GameTeam_TurnOverMessage paramGameTeam_TurnOverMessage)
  {
    if ((!paramGameTeam_TurnOverMessage.uint32_sessionType.has()) || (!paramGameTeam_TurnOverMessage.actionType.has()) || (!paramGameTeam_TurnOverMessage.str_sourceUin.has()) || (!paramGameTeam_TurnOverMessage.str_actionUin.has()) || (!paramGameTeam_TurnOverMessage.str_teamId.has()) || (!paramGameTeam_TurnOverMessage.uint32_currentCount.has()) || (!paramGameTeam_TurnOverMessage.uint32_totalCount.has()) || (!paramGameTeam_TurnOverMessage.uint64_buildTeamTime.has()) || (!paramGameTeam_TurnOverMessage.uint64_createMsgTime.has()) || (!paramGameTeam_TurnOverMessage.str_leaderUin.has()) || (!paramGameTeam_TurnOverMessage.uin32_leaderStatus.has()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GamePartyManager", 2, "handlePushMsg_TurnOver, parse param failed");
      }
      return;
    }
    long l1 = paramGameTeam_TurnOverMessage.uint64_createMsgTime.get();
    try
    {
      if (l1 < this.updateTime)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GamePartyManager", 2, "handlePushMsg_TurnOver, msgTime before updateTime, drop it");
        }
        return;
      }
    }
    finally {}
    this.updateTime = l1;
    long l2 = paramGameTeam_TurnOverMessage.uint64_buildTeamTime.get();
    l1 = NetConnInfoCenter.getServerTime();
    if (l1 > l2) {}
    for (l1 -= l2;; l1 = l2 - l1)
    {
      if (paramGameTeam_TurnOverMessage.uint32_expire.has())
      {
        this.expire = paramGameTeam_TurnOverMessage.uint32_expire.get();
        if (this.expire <= 0) {
          this.expire = dbv;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("GamePartyManager", 2, "handlePushMsg_TurnOver, createTime = " + l2 + ", expire = " + this.expire + ", deltaTime = " + l1);
      }
      if (l1 >= this.expire) {
        break;
      }
      a(paramGameTeam_TurnOverMessage, false);
      a(paramGameTeam_TurnOverMessage);
      return;
    }
    a(paramGameTeam_TurnOverMessage, true);
  }
  
  public Object c(int paramInt, Object paramObject)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.weakApp.get();
    if (localQQAppInterface == null) {
      return null;
    }
    switch (paramInt)
    {
    case 1: 
    default: 
      paramObject = null;
    }
    for (;;)
    {
      return paramObject;
      Object localObject1 = Boolean.valueOf(false);
      Object localObject2 = (MessageForArkApp)paramObject;
      paramObject = localObject1;
      if (localObject2 != null)
      {
        paramObject = localObject1;
        if (((MessageForArkApp)localObject2).ark_app_message != null)
        {
          try
          {
            paramObject = new JSONObject(((MessageForArkApp)localObject2).ark_app_message.metaList).getJSONObject("teamup").getJSONObject("invitation");
            paramInt = paramObject.optInt("forward");
            paramObject = paramObject.optString("leader");
            switch (paramInt)
            {
            case 0: 
              paramObject = Boolean.valueOf(false);
            }
          }
          catch (JSONException paramObject)
          {
            paramObject.printStackTrace();
            paramObject = localObject1;
          }
          if (localQQAppInterface.getCurrentAccountUin().equals(paramObject))
          {
            paramObject = Boolean.valueOf(true);
          }
          else
          {
            paramObject = Boolean.valueOf(false);
            continue;
            paramObject = Boolean.valueOf(true);
            continue;
            continue;
            paramObject = (Bundle)paramObject;
            if (paramObject != null)
            {
              paramInt = paramObject.getInt("uintype");
              localObject1 = paramObject.getString("uin");
              Object localObject3 = paramObject.getString("forward_ark_app_name");
              String str1 = paramObject.getString("forward_ark_app_view");
              String str2 = paramObject.getString("forward_ark_app_desc");
              String str3 = paramObject.getString("forward_ark_app_ver");
              String str4 = paramObject.getString("forward_ark_app_prompt");
              localObject2 = paramObject.getString("forward_ark_app_meta");
              paramObject = new ArkAppMessage(str4, (String)localObject3, str2, str1, str3, (String)localObject2, paramObject.getString("forward_ark_app_config"), paramObject.getString("forward_ark_app_compat"));
              try
              {
                localObject2 = new JSONObject((String)localObject2);
                localObject3 = ((JSONObject)localObject2).getJSONObject("teamup").getJSONObject("misc");
                ((JSONObject)localObject3).put("forwardUin", localQQAppInterface.getCurrentAccountUin());
                ((JSONObject)localObject3).put("forwardDstType", hT(paramInt));
                ((JSONObject)localObject3).put("forwardDstUin", localObject1);
                paramObject.metaList = ((JSONObject)localObject2).toString();
              }
              catch (JSONException localJSONException)
              {
                localJSONException.printStackTrace();
              }
              continue;
              paramObject = Boolean.valueOf(false);
            }
            else
            {
              paramObject = null;
              continue;
              paramObject = localJSONException;
            }
          }
        }
      }
    }
  }
  
  public void dqq()
  {
    this.handler.removeMessages(1);
    Message localMessage = this.handler.obtainMessage(1);
    long l2 = this.expire;
    long l3 = NetConnInfoCenter.getServerTime();
    if (this.createTime == 0L) {
      this.createTime = l3;
    }
    long l1 = l2;
    if (l3 > this.createTime) {
      l1 = l2 - (l3 - this.createTime);
    }
    if (l1 > 0L)
    {
      this.ciu = true;
      if (this.a != null)
      {
        this.a.setChanged();
        this.a.notifyObservers(Integer.valueOf(1));
      }
      this.handler.sendMessageDelayed(localMessage, l1 * 1000L + 30000L);
    }
  }
  
  public void dqr()
  {
    if (this.a != null)
    {
      this.a.setChanged();
      this.a.notifyObservers(Integer.valueOf(3));
    }
    clean();
    this.handler.removeMessages(1);
  }
  
  public void onDestroy()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.weakApp.get();
    if (localQQAppInterface == null) {
      return;
    }
    SharedPreferences.Editor localEditor = this.S.edit();
    JSONObject localJSONObject;
    if (this.ciu) {
      localJSONObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("teamId", this.teamId);
        localEditor.putString("gamePartyInfo" + localQQAppInterface.getCurrentAccountUin(), localJSONObject.toString());
        localEditor.commit();
        adqq.GC("com.tencent.qqopen.teamup");
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
      }
      localEditor.putString("gamePartyInfo" + localQQAppInterface.getCurrentAccountUin(), "");
    }
  }
  
  public static abstract interface a
  {
    public abstract void Gk(String paramString);
  }
  
  public class b
  {
    public String toUin;
    public int uinType;
    
    public b(int paramInt, String paramString)
    {
      this.uinType = paramInt;
      this.toUin = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahvn
 * JD-Core Version:    0.7.0.1
 */