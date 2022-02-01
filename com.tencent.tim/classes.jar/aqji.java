import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class aqji
{
  private static aqji.a a;
  
  public static int LY()
  {
    return a().dZz;
  }
  
  public static int LZ()
  {
    return a().dZx;
  }
  
  public static void UM(String paramString)
  {
    paramString = aqji.a.a(paramString);
    try
    {
      a = paramString;
      return;
    }
    finally {}
  }
  
  public static aqji.a a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = aqji.a.a(igl.b(276).content);
      }
      return a;
    }
    finally {}
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, long paramLong, boolean paramBoolean)
  {
    boolean bool1 = false;
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", String.valueOf(paramLong));
    paramVideoAppInterface = paramVideoAppInterface.a(6, 0, 0, localBundle, null);
    int i;
    int j;
    if (paramVideoAppInterface != null)
    {
      int k = paramVideoAppInterface.getInt("mask", 1);
      int m = paramVideoAppInterface.getInt("num");
      boolean bool2 = paramVideoAppInterface.getBoolean("forceDisableInviteBox");
      i = m;
      j = k;
      if (QLog.isColorLevel())
      {
        QLog.i("QAVGroupConfig", 2, "canShowInviteBox, forceDisableInviteBox[" + bool2 + "], mask[" + k + "], num[" + m + "]");
        j = k;
        i = m;
      }
    }
    for (;;)
    {
      if (paramBoolean) {
        paramBoolean = true;
      }
      do
      {
        return paramBoolean;
        if (1 != j) {
          break label249;
        }
        if (!AudioHelper.isDev()) {
          break;
        }
        j = AudioHelper.jY(6);
        if (j == 1) {
          return true;
        }
        paramBoolean = bool1;
      } while (j == 0);
      paramVideoAppInterface = a();
      if (i > paramVideoAppInterface.dZA)
      {
        QLog.w("QAVGroupConfig", 1, "onGAudioInvite, 成员太多, relationId[" + paramLong + "], show_invite_box[" + paramVideoAppInterface.dZA + "], MemberNum[" + i + "]");
        return false;
      }
      return true;
      label249:
      aqji.c.Xu(j);
      return false;
      i = 0;
      j = 1;
    }
  }
  
  public static boolean a(String paramString1, QQAppInterface paramQQAppInterface, String paramString2)
  {
    TroopInfo localTroopInfo = ((TroopManager)paramQQAppInterface.getManager(52)).c(paramString2);
    boolean bool1 = false;
    boolean bool3;
    boolean bool4;
    label53:
    String str;
    int i;
    if (localTroopInfo != null)
    {
      if ((localTroopInfo.dwAdditionalFlag & 1L) != 1L) {
        break label570;
      }
      bool3 = true;
      if ((localTroopInfo.dwCmdUinUinFlag & 1L) != 1L) {
        break label576;
      }
      bool4 = true;
      str = "";
      i = b(localTroopInfo);
      bool1 = false;
      if ((localTroopInfo.troopPrivilegeFlag & 0x6100000) != 0L) {
        break label582;
      }
      bool1 = true;
      str = acfp.m(2131710330);
      label90:
      if ((!bool1) || (!localTroopInfo.isAdmin())) {
        break label720;
      }
      str = str + acfp.m(2131710335);
    }
    label156:
    label207:
    label720:
    for (boolean bool5 = false;; bool5 = bool1)
    {
      boolean bool2 = false;
      int j = localTroopInfo.getMemNumForAutoInviteIntoGroup(paramQQAppInterface);
      if (j >= 0) {
        if (i >= j)
        {
          bool1 = true;
          bool2 = bool1;
          if (!bool1) {
            break label717;
          }
          str = str + acfp.m(2131710334);
          bool2 = bool1;
        }
      }
      for (;;)
      {
        if ((bool5) || (bool2))
        {
          bool1 = false;
          paramQQAppInterface = ((apsw)paramQQAppInterface.getManager(48)).a(paramString2);
          paramString1 = new StringBuilder().append("getCanAutoInviteMemIntoTroop[").append(paramString1).append("], groupUin[").append(paramString2).append("][").append(localTroopInfo.troopname).append("], \n群禁言时间戳[").append(localTroopInfo.dwGagTimeStamp).append("], \n群禁言[");
          if (paramQQAppInterface != null) {
            break label708;
          }
        }
        for (long l = 0L;; l = paramQQAppInterface.gagTimeStamp)
        {
          QLog.w("QAVGroupConfig", 1, l + "], \n被禁言到期时间戳[" + localTroopInfo.dwGagTimeStamp_me + "], \n群成员数量[" + localTroopInfo.wMemberNum + "], \n群成员数量Client[" + localTroopInfo.wMemberNumClient + "], \n最大的邀请自动入群人数[" + localTroopInfo.maxInviteMemNum + "|" + j + "], \n后台配置_每次选人上限[" + pD() + "], \n后台配置_通话成员邀请上限[" + LZ() + "], \nmMemberInvitingFlag[" + localTroopInfo.mMemberInvitingFlag + "], \nisOnlyTroopMemberInviteOption[" + localTroopInfo.isOnlyTroopMemberInviteOption() + "], \n群能力标记位troopPrivilegeFlag[" + localTroopInfo.troopPrivilegeFlag + "], \n群标记位dwGroupFlagExt3[" + localTroopInfo.dwGroupFlagExt3 + "], \n群的加入方式cGroupOption[" + localTroopInfo.cGroupOption + "], \nneedAdminCheck[" + bool5 + "], \nneedAgree[" + bool2 + "], \nbOwner[" + bool3 + "_" + localTroopInfo.dwAdditionalFlag + "], \nbAdmin[" + bool4 + "_" + localTroopInfo.dwCmdUinUinFlag + "], \nisAdmin[" + localTroopInfo.isAdmin() + "], \nlog[" + str + "], \n可以邀请[" + bool1 + "]");
          return bool1;
          bool3 = false;
          break;
          bool4 = false;
          break label53;
          if ((localTroopInfo.troopPrivilegeFlag & 0x2000000) == 33554432L)
          {
            if (i > 50) {}
            for (bool1 = true;; bool1 = false)
            {
              str = acfp.m(2131710331);
              break;
            }
          }
          if ((localTroopInfo.troopPrivilegeFlag & 0x4000000) == 67108864L)
          {
            if (i > 100) {}
            for (bool1 = true;; bool1 = false)
            {
              str = acfp.m(2131710332);
              break;
            }
          }
          if ((localTroopInfo.troopPrivilegeFlag & 0x100000) != 1048576L) {
            break label90;
          }
          bool1 = false;
          str = acfp.m(2131710336);
          break label90;
          bool1 = false;
          break label156;
          bool1 = true;
          break label207;
        }
      }
    }
  }
  
  public static boolean ab(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (apsw)paramQQAppInterface.getManager(48);
    boolean bool1 = paramQQAppInterface.hs(paramString);
    boolean bool2 = paramQQAppInterface.eL(paramString);
    if ((bool1) || (bool2)) {}
    for (bool1 = true; 1 == AudioHelper.jY(7); bool1 = false)
    {
      AudioHelper.UA(acfp.m(2131710333));
      return true;
    }
    return bool1;
  }
  
  static int b(TroopInfo paramTroopInfo)
  {
    int i = paramTroopInfo.wMemberNumClient;
    if (AudioHelper.aCz()) {
      QLog.w("QAVGroupConfig", 1, "getMemberNum, troopuin[" + paramTroopInfo.troopuin + "], wMemberNumClient[" + paramTroopInfo.wMemberNumClient + "], wMemberNum[" + paramTroopInfo.wMemberNum + "], uin[" + paramTroopInfo.uin + "], troopcode[" + paramTroopInfo.troopcode + "]");
    }
    return i;
  }
  
  public static Bundle b(QQAppInterface paramQQAppInterface, String paramString)
  {
    int k = c(paramQQAppInterface, true, paramString);
    int m = paramQQAppInterface.cs(paramString);
    Object localObject = (apsw)paramQQAppInterface.getManager(48);
    boolean bool3 = ((apsw)localObject).bg(paramString, paramQQAppInterface.getCurrentAccountUin());
    boolean bool4 = ((apsw)localObject).hs(paramString);
    boolean bool5 = ((apsw)localObject).eL(paramString);
    paramQQAppInterface = ((apsw)localObject).a(paramString);
    int j = 0;
    boolean bool2 = false;
    int i;
    boolean bool1;
    if ((!bool5) && (bool3))
    {
      i = 2131697827;
      bool1 = true;
      localObject = new Bundle();
      ((Bundle)localObject).putInt("mask", m);
      ((Bundle)localObject).putInt("num", k);
      ((Bundle)localObject).putBoolean("isAdmin", bool4);
      ((Bundle)localObject).putBoolean("isOwner", bool5);
      ((Bundle)localObject).putBoolean("forceDisableInviteBox", bool1);
      ((Bundle)localObject).putInt("errId", i);
      paramString = new StringBuilder().append("getGroupMask, troopUin[").append(paramString).append("], mask[").append(m).append("], num[").append(k).append("], isOwner[").append(bool5).append("], isMemberGaged[").append(bool3).append("], isAdmin[").append(bool4).append("], gagTimeStamp[");
      if ((paramQQAppInterface == null) || (paramQQAppInterface.gagTimeStamp == 0L)) {
        break label321;
      }
    }
    label321:
    for (bool2 = true;; bool2 = false)
    {
      QLog.w("QAVGroupConfig", 1, bool2 + "], forceDisableInviteBox[" + bool1 + "]");
      return localObject;
      bool1 = bool2;
      i = j;
      if (bool4) {
        break;
      }
      bool1 = bool2;
      i = j;
      if (paramQQAppInterface == null) {
        break;
      }
      bool1 = bool2;
      i = j;
      if (paramQQAppInterface.gagTimeStamp == 0L) {
        break;
      }
      i = 2131697826;
      bool1 = true;
      break;
    }
  }
  
  public static int c(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString)
  {
    int i = 0;
    if (paramQQAppInterface != null)
    {
      if (paramBoolean) {
        i = q(paramQQAppInterface, paramString);
      }
    }
    else {
      return i;
    }
    return ((acdu)paramQQAppInterface.getManager(53)).cn(paramString);
  }
  
  public static void c(String paramString1, QQAppInterface paramQQAppInterface, String paramString2)
  {
    acms localacms = (acms)paramQQAppInterface.getBusinessHandler(20);
    if (localacms == null) {}
    for (;;)
    {
      return;
      try
      {
        l = Long.parseLong(paramString2);
        if (l == 0L) {
          continue;
        }
        paramString1 = paramString1 + "_" + AudioHelper.hG();
        String str = String.valueOf(l);
        paramQQAppInterface.addObserver(new aqjj(l, paramString1, paramQQAppInterface, str));
        localacms.I(l, 480, 0);
        paramString2 = ((TroopManager)paramQQAppInterface.getManager(52)).c(paramString2);
        if (paramString2.maxInviteMemNum == 0)
        {
          paramQQAppInterface.addObserver(new aqjk(str, paramQQAppInterface, paramString1));
          localacms.Fa(str);
        }
        QLog.w("QAVGroupConfig", 1, "getGroupInfo[" + paramString1 + "], troopuin[" + l + "], maxInviteMemNum[" + paramString2.maxInviteMemNum + "]");
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l = 0L;
        }
      }
    }
  }
  
  public static int pD()
  {
    return a().dZy;
  }
  
  public static int q(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject2 = (TroopManager)paramQQAppInterface.getManager(52);
    int k = b(((TroopManager)localObject2).c(paramString));
    long l = System.currentTimeMillis();
    Object localObject1 = "getGroupMemberNum, groupUin[" + paramString + "], memberCount[" + k + "]";
    int i;
    if (k - 10 < LZ())
    {
      Object localObject3 = ((TroopManager)localObject2).al(String.valueOf(paramString));
      if (localObject3 != null)
      {
        paramString = (aptw)paramQQAppInterface.getManager(203);
        localObject2 = (asgx)paramQQAppInterface.getManager(165);
        localObject3 = ((List)localObject3).iterator();
        paramQQAppInterface = (QQAppInterface)localObject1;
        i = 0;
        while (((Iterator)localObject3).hasNext())
        {
          localObject1 = (TroopMemberInfo)((Iterator)localObject3).next();
          if ((paramString.gM(((TroopMemberInfo)localObject1).memberuin)) || (((asgx)localObject2).sM(((TroopMemberInfo)localObject1).memberuin))) {
            paramQQAppInterface = paramQQAppInterface + "\nisRobotUin[" + ((TroopMemberInfo)localObject1).memberuin + "]";
          } else {
            i += 1;
          }
        }
        localObject1 = paramQQAppInterface + "\nCalcCount[" + i + "]";
      }
    }
    for (;;)
    {
      int j = i;
      if (i == 0) {
        j = k;
      }
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVGroupConfig", 1, "" + (String)localObject1 + ", time[" + (System.currentTimeMillis() - l) + "]");
      }
      return j;
      i = 0;
    }
  }
  
  public static class a
  {
    int dZA = 20;
    int dZx = 40;
    int dZy = 9;
    int dZz = 9;
    HashMap<String, aqji.d> oW = new HashMap();
    int task_id = 0;
    
    static a a(String paramString)
    {
      if (!TextUtils.isEmpty(paramString)) {
        try
        {
          paramString = new JSONObject(paramString);
          a locala = new a();
          locala.task_id = paramString.optInt("task_id");
          if (paramString.has("max_gaudio_member")) {
            locala.dZx = paramString.optInt("max_gaudio_member");
          }
          if (paramString.has("max_select_num")) {
            locala.dZy = paramString.optInt("max_select_num");
          }
          if (paramString.has("show_invite_box")) {
            locala.dZA = paramString.optInt("show_invite_box");
          }
          if (paramString.has("auto_select_num")) {
            locala.dZz = paramString.optInt("auto_select_num");
          }
          return locala;
        }
        catch (Exception paramString)
        {
          QLog.d("QAVGroupConfig", 1, "parseJson, Exception", paramString);
        }
      }
      return new a();
    }
    
    public aqji.d a(String paramString)
    {
      long l = System.currentTimeMillis();
      Object localObject1 = null;
      Iterator localIterator = this.oW.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (aqji.d)((Map.Entry)localObject2).getValue();
        if (l > ((aqji.d)localObject2).asY) {
          localIterator.remove();
        }
        for (localObject2 = localObject1;; localObject2 = localObject1) {
          do
          {
            localObject1 = localObject2;
            break;
          } while ((localObject1 == null) && (TextUtils.equals(paramString, str)));
        }
      }
      return localObject1;
    }
    
    public void bl(String paramString1, String paramString2, String paramString3)
    {
      if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
        return;
      }
      long l = 600000L;
      if (AudioHelper.isDev()) {
        l = 60000L;
      }
      aqji.d locald = new aqji.d();
      locald.asY = (l + System.currentTimeMillis());
      locald.QF = paramString2;
      locald.QG = paramString3;
      this.oW.put(paramString1, locald);
    }
    
    public String toString()
    {
      return "task_id[" + this.task_id + "], max_gaudio_member[" + this.dZx + "], max_select_num[" + this.dZy + "], show_invite_box[" + this.dZA + "], auto_select_num[" + this.dZz + "]";
    }
  }
  
  public static class b
  {
    public String QE;
    public boolean cUo;
    
    public static b a(Bundle paramBundle)
    {
      b localb = new b();
      localb.QE = paramBundle.getString("uin");
      localb.cUo = paramBundle.getBoolean("enableInvite");
      return localb;
    }
    
    public static void d(String paramString1, QQAppInterface paramQQAppInterface, String paramString2)
    {
      boolean bool = aqji.a(paramString1, paramQQAppInterface, paramString2);
      paramString1 = new Intent();
      paramString1.setAction("tencent.video.q2v.GroupInfoChanged");
      paramString1.putExtra("uin", paramString2);
      paramString1.putExtra("enableInvite", bool);
      paramString1.setPackage(paramQQAppInterface.getApplication().getPackageName());
      paramQQAppInterface.getApp().sendBroadcast(paramString1);
    }
  }
  
  public static class c
  {
    public static void SF(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        iF("0X8008CC7");
        return;
      }
      iF("0X8008CC8");
    }
    
    public static void SG(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        iF("0X8008CBA");
        return;
      }
      iF("0X8008CB5");
    }
    
    public static void SH(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        iF("0X8008E7D");
        return;
      }
      iF("0X8008E7E");
    }
    
    public static void Xu(int paramInt)
    {
      if (paramInt == 4) {
        iF("0X8009187");
      }
      while (paramInt != 2) {
        return;
      }
      iF("0X8009188");
    }
    
    public static void cf(int paramInt, boolean paramBoolean)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVGroupConfig", 1, "reportAVGroupNum, num[" + paramInt + "], isVideo[" + paramBoolean + "]");
      }
      HashMap localHashMap;
      if (paramBoolean)
      {
        localHashMap = new HashMap();
        localHashMap.put("num", String.valueOf(paramInt));
        UserAction.onUserAction("reportAVGroupNum_video", true, -1L, -1L, localHashMap, true);
      }
      for (;;)
      {
        localHashMap = new HashMap();
        localHashMap.put("isVideo", String.valueOf(paramBoolean));
        localHashMap.put("num", String.valueOf(paramInt));
        UserAction.onUserAction("reportAVGroupNum", true, -1L, -1L, localHashMap, true);
        return;
        localHashMap = new HashMap();
        localHashMap.put("num", String.valueOf(paramInt));
        UserAction.onUserAction("reportAVGroupNum_audio", true, -1L, -1L, localHashMap, true);
      }
    }
    
    public static void edX()
    {
      iF("0X8008CC3");
    }
    
    public static void edY()
    {
      iF("0X8008CC4");
    }
    
    public static void edZ()
    {
      iF("0X8008CC5");
    }
    
    public static void eea()
    {
      iF("0X8008CC6");
    }
    
    public static void iF(String paramString)
    {
      if (!QLog.isDevelopLevel()) {}
      for (;;)
      {
        anot.a(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
        return;
        QLog.w("QAVGroupConfig", 1, "reportClickEvent, key[" + paramString + "]");
      }
    }
  }
  
  public static class d
  {
    public String QF;
    public String QG;
    long asY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqji
 * JD-Core Version:    0.7.0.1
 */