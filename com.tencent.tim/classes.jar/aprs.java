import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.c;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class aprs
{
  private static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong, TroopInfo paramTroopInfo, boolean paramBoolean)
  {
    String str;
    if (paramTroopInfo.isTroopOwner(paramQQAppInterface.getCurrentAccountUin()))
    {
      str = "0";
      paramString2 = paramString2.replace("$GCODE$", paramString1).replace("$CLIENTVER$", "android3.4.4").replace("$UIN$", paramQQAppInterface.getCurrentAccountUin()).replace("$LANG$", "zh_CN").replace("$GROUPAPPID$", Long.toString(paramLong)).replace("$ROLE$", str);
      if (!paramBoolean) {
        break label143;
      }
    }
    label143:
    for (paramQQAppInterface = "1";; paramQQAppInterface = "2")
    {
      paramString1 = paramString2.replace("$ENTERSOURCE$", paramQQAppInterface).replace("$GUIN$", paramString1).replace("$UNREADNUM$", String.valueOf(0));
      paramQQAppInterface = paramString1;
      if (!TextUtils.isEmpty(paramTroopInfo.newTroopName)) {
        paramQQAppInterface = paramString1.replace("$GNAME$", paramTroopInfo.newTroopName);
      }
      return paramQQAppInterface;
      if (paramTroopInfo.isAdmin())
      {
        str = "1";
        break;
      }
      str = "2";
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, aotc.c paramc)
  {
    TroopInfo localTroopInfo = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramSessionInfo.aTl);
    if (localTroopInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAppShortcutUtils", 2, "OnClickListener. troopInfo is null.");
      }
    }
    String str1;
    label306:
    label314:
    label376:
    label383:
    do
    {
      return;
      anot.a(null, "dc00898", "", "", "0X800AD09", "0X800AD09", 0, 0, "", paramSessionInfo.aTl, Long.toString(localTroopInfo.dwGroupClassExt), Long.toString(paramc.aqz));
      str1 = paramc.cmX;
      if (paramc.aqz == 101761547L)
      {
        aiob.b(paramQQAppInterface, paramContext, 1, paramSessionInfo.aTl, 0);
        return;
      }
      if (paramc.aqz == 101793773L)
      {
        a(paramQQAppInterface, paramContext, localTroopInfo, paramSessionInfo);
        return;
      }
      if (paramc.aqz == 101817424L)
      {
        b(paramQQAppInterface, paramContext, localTroopInfo, paramSessionInfo);
        return;
      }
      if (paramc.aqz == 101847770L)
      {
        paramQQAppInterface = TroopMemberListActivity.c(paramContext, paramSessionInfo.aTl, 19);
        paramQQAppInterface.putExtra("TROOP_INFO_MEMBER_NUM", localTroopInfo.wMemberNum);
        paramContext.startActivity(paramQQAppInterface);
        return;
      }
      boolean bool;
      int i;
      if ((paramc.aqz == 1101236949L) && (aerd.c().mIsEnable) && (localTroopInfo.mIsFreezed == 1) && ((localTroopInfo.isAdmin()) || (localTroopInfo.isTroopOwner(paramQQAppInterface.getCurrentAccountUin()))))
      {
        bool = TroopManager.c.iC(localTroopInfo.groupFreezeReason);
        if (!localTroopInfo.isTroopOwner(paramQQAppInterface.getCurrentAccountUin())) {
          break label396;
        }
        String str2 = paramSessionInfo.aTl;
        if (!bool) {
          break label376;
        }
        i = 15;
        String str3 = VipUtils.a(0, i).toString();
        String str4 = acfp.m(2131703757);
        aprt localaprt = new aprt();
        if (!bool) {
          break label383;
        }
        localObject = "0X800A57F";
        if (!bool) {
          break label390;
        }
        i = 1;
        VipUtils.a(paramContext, str2, str3, str4, localaprt, (String)localObject, i, bool);
      }
      for (;;)
      {
        if (!MiniAppLauncher.isMiniAppUrl(str1)) {
          break label405;
        }
        MiniAppLauncher.startMiniApp(paramContext, a(paramQQAppInterface, paramSessionInfo.aTl, str1, paramc.aqz, localTroopInfo, true), 4007, apuh.a(localTroopInfo, paramSessionInfo.aTl), null);
        return;
        i = 8;
        break;
        localObject = "0X8009E38";
        break label306;
        i = 3;
        break label314;
        VipUtils.O(paramContext, bool);
      }
      if ((str1.startsWith("http")) || (str1.startsWith("https")))
      {
        localObject = new Intent(paramContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", a(paramQQAppInterface, paramSessionInfo.aTl, str1, paramc.aqz, localTroopInfo, true));
        ((Intent)localObject).putExtra("webStyle", "noBottomBar");
        ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
        paramContext.startActivity((Intent)localObject);
        return;
      }
    } while (!str1.startsWith("mqqapi"));
    label390:
    label396:
    label405:
    paramSessionInfo = a(paramQQAppInterface, paramSessionInfo.aTl, str1, paramc.aqz, localTroopInfo, true);
    Object localObject = new Intent(paramContext, JumpActivity.class);
    paramQQAppInterface = paramSessionInfo;
    if (paramc.aqz == 1105981808L) {
      paramQQAppInterface = rnw.a((Intent)localObject, paramSessionInfo, null);
    }
    ((Intent)localObject).setData(Uri.parse(paramQQAppInterface));
    paramContext.startActivity((Intent)localObject);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, TroopInfo paramTroopInfo, SessionInfo paramSessionInfo)
  {
    aeof localaeof = (aeof)aeif.a().o(535);
    if ((localaeof == null) || (localaeof.a == null)) {
      QQToast.a(paramContext, 0, 2131694552, 0).show();
    }
    aohy localaohy;
    boolean bool;
    do
    {
      return;
      localaohy = (aohy)paramQQAppInterface.getManager(339);
      bool = localaohy.e(2, 1, paramTroopInfo.uin);
      paramSessionInfo = aoij.a(bool, paramTroopInfo.isTroopOwner(paramQQAppInterface.getCurrentAccountUin()), paramTroopInfo.isAdmin(), paramTroopInfo.troopowneruin, paramSessionInfo.aTl, 0);
      switch (localaeof.a.getVersion())
      {
      default: 
        if (!localaohy.a(paramContext, 2, paramTroopInfo.troopuin, 0)) {
          break label231;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopAppShortcutUtils", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(0) });
    return;
    QQToast.a(paramContext, 0, 2131694552, 0).show();
    return;
    if (bool)
    {
      localaohy.b(paramContext, paramTroopInfo.troopuin, 1, 2, 0, paramSessionInfo);
      return;
    }
    localaohy.a(paramContext, paramTroopInfo.troopuin, 1, 2, 0, paramSessionInfo);
    return;
    label231:
    aoij.a(paramQQAppInterface, localaeof.a.getJumpType(), localaeof.a.getJumpUrl(), localaeof.a.tC(), paramSessionInfo, 1);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Context paramContext, TroopInfo paramTroopInfo, SessionInfo paramSessionInfo)
  {
    String str = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = (aohy)paramQQAppInterface.getManager(339);
    boolean bool = paramQQAppInterface.e(4, -1, paramSessionInfo.aTl);
    paramTroopInfo = aoij.a(bool, paramTroopInfo.isTroopOwner(str), paramTroopInfo.isAdmin(), paramTroopInfo.troopowneruin, paramSessionInfo.aTl, 0);
    if (bool)
    {
      paramQQAppInterface.b(paramContext, paramSessionInfo.aTl, 1, 4, 0, paramTroopInfo);
      return;
    }
    paramQQAppInterface.a(paramContext, paramSessionInfo.aTl, 1, 4, 0, paramTroopInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aprs
 * JD-Core Version:    0.7.0.1
 */