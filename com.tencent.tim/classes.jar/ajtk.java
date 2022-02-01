import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ajtk
{
  public static aqju a(Activity paramActivity, String paramString, int paramInt)
  {
    return a(paramActivity, paramString, paramInt, 0L);
  }
  
  public static aqju a(Activity paramActivity, String paramString, int paramInt, long paramLong)
  {
    paramString = aqha.a(paramActivity, 230, null, acfp.m(2131706837), acfp.m(2131706843), acfp.m(2131706768), new ajtq(paramActivity, paramString, paramInt, paramLong), new ajtr());
    if (!paramActivity.isFinishing()) {
      paramString.show();
    }
    return paramString;
  }
  
  public static aqju a(Activity paramActivity, String paramString1, String paramString2)
  {
    if (paramActivity.isFinishing()) {
      paramString1 = null;
    }
    aqju localaqju;
    do
    {
      return paramString1;
      localaqju = aqha.a(paramActivity, 230);
      localaqju.setTitle(paramString1);
      localaqju.setMessage(paramString2);
      localaqju.setNegativeButton(acfp.m(2131706777), new ajto());
      localaqju.setPositiveButton(acfp.m(2131706762), new ajtp(paramActivity));
      paramString1 = localaqju;
    } while (paramActivity.isFinishing());
    localaqju.show();
    return localaqju;
  }
  
  public static aqju a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = aqha.a(paramContext, 230);
      paramContext.setTitle(paramString1);
      paramContext.setMessage(paramString2);
      paramContext.setPositiveButton(2131721079, new ajtn());
      paramContext.show();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static aqju a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    try
    {
      aqju localaqju = aqha.a(paramContext, 230);
      localaqju.setTitle(paramString1);
      localaqju.setMessage(paramString2);
      localaqju.setNegativeButton(acfp.m(2131706781), new ajtl());
      localaqju.setPositiveButton(acfp.m(2131706769), new ajtm(paramContext, paramString3, paramInt));
      localaqju.show();
      return localaqju;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static void a(Context paramContext, HotChatInfo paramHotChatInfo, int paramInt, String paramString1, String paramString2)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    paramHotChatInfo.isGameRoom = true;
    Object localObject = localQQAppInterface.a().createEntityManager();
    ((EntityManager)localObject).update(paramHotChatInfo);
    ((EntityManager)localObject).close();
    localObject = (HotChatManager)localQQAppInterface.getManager(60);
    List localList = ((HotChatManager)localObject).dX();
    if ((localList != null) && (!localList.contains(paramHotChatInfo))) {
      localList.add(paramHotChatInfo);
    }
    ((HotChatManager)localObject).a(paramHotChatInfo, 4);
    paramHotChatInfo = new Intent(paramContext, ChatActivity.class);
    paramHotChatInfo.putExtra("uin", paramInt + "");
    paramHotChatInfo.putExtra("uintype", 1);
    paramHotChatInfo.putExtra("troop_uin", paramInt + "");
    paramHotChatInfo.putExtra("uinname", paramString2);
    paramHotChatInfo.putExtra("hotnamecode", paramString1);
    paramHotChatInfo = wja.a(paramHotChatInfo, new int[] { 2 });
    paramHotChatInfo.addFlags(268435456);
    paramContext.startActivity(paramHotChatInfo);
    aqmj.a(paramContext, localQQAppInterface.getCurrentAccountUin(), false, System.currentTimeMillis());
    aqmj.o(paramContext, localQQAppInterface.getCurrentAccountUin(), true);
  }
  
  public static void ar(Context paramContext, int paramInt)
  {
    String str = "https://nearby.qq.com/werewolf/game-overview.html?_bid=2652&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_anim=true&_nav_alpha=0&_wv=16779011&_wwv=5&from=" + paramInt;
    if (jqc.isValidUrl(str)) {}
    try
    {
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("url", URLUtil.guessUrl(str));
      localIntent.putExtra("op_type", "wolf");
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("GameRoomUtils", 2, "发起新游戏 error, " + paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajtk
 * JD-Core Version:    0.7.0.1
 */