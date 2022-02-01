import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountChatMsgData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.message.GameBasicInfo;
import com.tencent.mobileqq.gamecenter.message.GameSwitchConfig;
import com.tencent.mobileqq.gamecenter.message.GameUserInfo;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ahtc
{
  public static String PREFIX;
  public static String TAG = ahtj.bLH + "GameMsgUtil";
  public static String bLG = "https://fastest.gamecenter.qq.com/_fst_/speed_gamecenter_qq_com/_fst_/pushgame/v1/home/msg?_wv=18950115&_wwv=393&_fst_id=194";
  public static String[] fl = { "🕹", "🎮", "🔊", "🔉", "🔈", "📢", "✉", "📨", "📧", "📩", "💌", "📪", "📫", "📬", "📮" };
  public static int[] kW;
  
  static
  {
    PREFIX = "[游戏好友]";
    kW = new int[] { 23, 40, 19, 43, 21, 9, 20, 106, 35, 10, 25, 24, 1, 0, 33, 32, 12, 27, 13, 22, 3, 18, 30, 31, 81, 82, 26, 2, 37, 50, 42, 83, 34, 11, 49, 84, 39, 78, 5, 4, 6, 85, 86, 87, 46, 88, 44, 89, 48, 14, 90, 41, 36, 91, 51, 164, 174, 171, 165, 166, 161, 167, 170, 169, 172, 173, 168, 175, 17, 60, 61, 92, 93, 163, 66, 58, 7, 8, 57, 29, 28, 74, 59, 80, 16, 70, 77, 62, 15, 68, 75, 76, 45, 52, 53, 54, 55, 56, 63, 73, 72, 65, 94, 64 };
  }
  
  public static Intent a(Context paramContext, QQMessageFacade.Message paramMessage, QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = new Intent(paramContext, GameCenterActivity.class);
    String str1 = paramMessage.frienduin;
    localIntent.putExtra("uin", str1);
    localIntent.putExtra("uintype", 10007);
    if (paramQQAppInterface != null) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "getIntentFromMsg is called!.");
      }
      paramContext = paramQQAppInterface.a().b(str1, 10007);
      if (paramContext == null) {
        break label365;
      }
      str2 = paramContext.tinyInfo.fromRoleId;
      str3 = paramContext.tinyInfo.toRoleId;
      QLog.i(TAG, 1, "[getIntentFromMsg], uin:" + str1 + ",fRoleId:" + str2 + ",mRoleId:" + str3);
      localObject = (ahta)paramQQAppInterface.getManager(358);
      paramContext = ((ahta)localObject).a(str3);
      if (paramContext == null) {
        break label397;
      }
      paramContext = ((ahta)localObject).a(paramContext.mAppId);
      if ((paramContext == null) || (paramContext.mSyncSwitch == 1)) {
        break label397;
      }
      i = 0;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        String str2;
        String str3;
        Object localObject;
        label365:
        QLog.e(TAG, 1, "getIntentFromMsg is called!. error", paramContext);
        continue;
        continue;
        int i = 1;
      }
    }
    paramContext = ((ahta)localObject).wD();
    if (i == 0)
    {
      localObject = ((ahta)localObject).a(str1);
      if (localObject != null)
      {
        paramContext = paramContext + "&&gameId=" + ((GameCenterSessionInfo)localObject).wx() + "&gameName=" + ((GameCenterSessionInfo)localObject).wy() + "&sessionId=" + ((GameCenterSessionInfo)localObject).getSessionId() + "&requestCount=" + ((GameCenterSessionInfo)localObject).getRequestCount();
        localIntent.putExtra("url", paramContext);
        localIntent.putExtra("sessionType", i);
        localIntent.putExtra("sessionId", str1);
        localIntent.putExtra("roleId", str2);
        localIntent.putExtra("myRoleId", str3);
        localIntent.addFlags(268435456);
        localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
        localIntent.putExtra("big_brother_source_key", "biz_src_zf_games");
        localIntent.putExtra("game_msg_enter_from", 1);
        g(paramQQAppInterface, paramMessage.frienduin, 10006, 2);
        return localIntent;
      }
    }
  }
  
  public static Bitmap a(QQMessageFacade.Message paramMessage, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    paramMessage = ahtd.s(paramMessage);
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = TAG;
      localStringBuilder = new StringBuilder().append("[getGameRoleBitmap],roleId:").append(paramMessage).append(" thread column = ");
      if (Looper.getMainLooper() != Looper.myLooper()) {
        break label125;
      }
    }
    long l1;
    label125:
    for (boolean bool = true;; bool = false)
    {
      QLog.d((String)localObject, 2, bool);
      l1 = SystemClock.elapsedRealtime();
      paramQQAppInterface = ((ahta)paramQQAppInterface.getManager(358)).a(paramMessage);
      if (paramQQAppInterface != null) {
        break;
      }
      QLog.w(TAG, 1, "getGameRoleBitmap usrInfo is null, roleId:" + paramMessage);
      return null;
    }
    if (TextUtils.isEmpty(paramQQAppInterface.mFaceUrl))
    {
      QLog.w(TAG, 1, " getGameRoleBitmap faceurl is null, roleId:" + paramMessage);
      return null;
    }
    paramMessage = aoiz.getFile(paramQQAppInterface.mFaceUrl);
    if ((paramMessage != null) && (paramMessage.exists()))
    {
      paramQQAppInterface = BitmapFactory.decodeFile(paramMessage.getAbsolutePath());
      paramMessage = paramQQAppInterface;
      if (QLog.isColorLevel())
      {
        QLog.d(TAG, 2, "getGameRoleBitmap is called!.decode from file" + paramQQAppInterface);
        paramMessage = paramQQAppInterface;
      }
    }
    for (;;)
    {
      long l2 = SystemClock.elapsedRealtime();
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "getGameRoleBitmap is called!. total cost = " + (l2 - l1));
      }
      return paramMessage;
      paramMessage = BaseApplicationImpl.getApplication().getResources().getDrawable(2130840732);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = paramMessage;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = paramMessage;
      try
      {
        paramMessage = URLDrawable.getDrawable(new URL(paramQQAppInterface.mFaceUrl), (URLDrawable.URLDrawableOptions)localObject);
      }
      catch (MalformedURLException paramQQAppInterface)
      {
        for (;;)
        {
          try
          {
            paramMessage.setTag(aqbn.d(100, 100, 6));
            paramMessage.setDecodeHandler(aqbn.b);
            if (paramMessage == null) {
              continue;
            }
            paramMessage = paramMessage.getCurrDrawable();
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, "getGameRoleBitmap is called!." + paramMessage.getClass().getSimpleName());
            }
            if (!(paramMessage instanceof BitmapDrawable)) {
              continue;
            }
            paramQQAppInterface = ((BitmapDrawable)paramMessage).getBitmap();
            paramMessage = paramQQAppInterface;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(TAG, 2, "getGameRoleBitmap is called!. bitmap = " + paramQQAppInterface);
            paramMessage = paramQQAppInterface;
          }
          catch (MalformedURLException paramQQAppInterface)
          {
            continue;
            paramMessage = null;
          }
          paramQQAppInterface = paramQQAppInterface;
          paramMessage = null;
          paramQQAppInterface.printStackTrace();
        }
      }
    }
  }
  
  public static URLDrawable a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    paramQQAppInterface = ((ahta)paramQQAppInterface.getManager(358)).a(paramString);
    if (paramQQAppInterface == null)
    {
      QLog.w(TAG, 1, "usrInfo is null, roleId:" + paramString);
      return null;
    }
    if (TextUtils.isEmpty(paramQQAppInterface.mFaceUrl))
    {
      QLog.w(TAG, 1, "faceurl is null, roleId:" + paramString);
      return null;
    }
    paramString = paramContext.getResources().getDrawable(2130840645);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = paramString;
    localURLDrawableOptions.mLoadingDrawable = paramString;
    localURLDrawableOptions.mRequestWidth = wja.dp2px(60.0F, paramContext.getResources());
    localURLDrawableOptions.mRequestHeight = wja.dp2px(60.0F, paramContext.getResources());
    try
    {
      paramContext = URLDrawable.getDrawable(new URL(paramQQAppInterface.mFaceUrl), localURLDrawableOptions);
      try
      {
        paramContext.setTag(aqbn.d(100, 100, 6));
        paramContext.setDecodeHandler(aqbn.b);
        return paramContext;
      }
      catch (MalformedURLException paramQQAppInterface) {}
    }
    catch (MalformedURLException paramQQAppInterface)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
    paramQQAppInterface.printStackTrace();
    return paramContext;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, RecentBaseData paramRecentBaseData, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramRecentBaseData == null)) {
      return paramString;
    }
    try
    {
      paramQQAppInterface = a(paramQQAppInterface, paramQQAppInterface.b().a(paramRecentBaseData.qx(), paramRecentBaseData.ng()), paramString);
      return paramQQAppInterface;
    }
    catch (Throwable paramQQAppInterface) {}
    return paramString;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    paramString = BaseApplicationImpl.getContext().getString(2131694208) + paramString;
    if (paramQQAppInterface == null) {
      return paramString;
    }
    paramMessageRecord = ahtd.r(paramMessageRecord);
    if (TextUtils.isEmpty(paramMessageRecord)) {
      return paramString;
    }
    paramQQAppInterface = (ahta)paramQQAppInterface.getManager(358);
    paramMessageRecord = paramQQAppInterface.a(paramMessageRecord);
    if (paramMessageRecord == null) {
      return paramString;
    }
    paramQQAppInterface = paramQQAppInterface.a(paramMessageRecord.mAppId);
    if ((paramQQAppInterface == null) || (paramQQAppInterface.mSyncSwitch == 1)) {
      return paramString;
    }
    return BaseApplicationImpl.getContext().getString(2131694209) + paramMessageRecord.mName;
  }
  
  public static String a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramMessageRecord != null) && (paramQQAppInterface != null))
    {
      String str = ahtd.s(paramMessageRecord);
      paramQQAppInterface = ((ahta)paramQQAppInterface.getManager(358)).a(str);
      if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.mNickInGame))) {
        return paramQQAppInterface.mNickInGame;
      }
      paramMessageRecord = new TinyInfo(paramMessageRecord.getExtInfoFromExtStr("ext_key_game_msg_info"));
      if (!TextUtils.isEmpty(paramMessageRecord.nickName)) {
        return paramMessageRecord.nickName;
      }
    }
    return BaseApplicationImpl.getApplication().getResources().getString(2131694203);
  }
  
  public static void a(Context paramContext, ahsz paramahsz)
  {
    QLog.i(TAG, 1, "[startGame]");
    if (paramahsz == null)
    {
      QLog.w(TAG, 1, "fail to start game, detailInfo is null.");
      return;
    }
    QLog.i(TAG, 1, "appId:" + paramahsz.mAppId);
    String str2 = paramahsz.mStartGameUrl;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = GameBasicInfo.getDefaultGameLaunchUrl(paramahsz.mAppId);
    }
    paramahsz = new Intent(paramContext, QQBrowserActivity.class);
    paramahsz.putExtra("url", str1);
    paramContext.startActivity(paramahsz);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, GameCenterSessionInfo paramGameCenterSessionInfo)
  {
    if ((paramQQAppInterface == null) || (paramGameCenterSessionInfo == null) || (paramContext == null)) {
      return;
    }
    paramQQAppInterface = (ahta)paramQQAppInterface.getManager(358);
    Intent localIntent = new Intent(paramContext, GameCenterActivity.class);
    String str = paramQQAppInterface.wD();
    paramQQAppInterface = str;
    if (paramGameCenterSessionInfo != null)
    {
      paramQQAppInterface = str;
      if (paramGameCenterSessionInfo.getSessionType() == 0) {
        paramQQAppInterface = str + "&&gameId=" + paramGameCenterSessionInfo.wx() + "&gameName=" + paramGameCenterSessionInfo.wy() + "&sessionId=" + paramGameCenterSessionInfo.getSessionId() + "&requestCount=" + paramGameCenterSessionInfo.getRequestCount();
      }
    }
    localIntent.putExtra("url", paramQQAppInterface);
    if (paramGameCenterSessionInfo != null)
    {
      localIntent.putExtra("sessionType", paramGameCenterSessionInfo.getSessionType());
      localIntent.putExtra("sessionId", paramGameCenterSessionInfo.getSessionId());
      localIntent.putExtra("roleId", paramGameCenterSessionInfo.ww());
      localIntent.putExtra("myRoleId", paramGameCenterSessionInfo.pk());
    }
    localIntent.addFlags(268435456);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("big_brother_source_key", "biz_src_zf_games");
    paramContext.startActivity(localIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, MsgSummary paramMsgSummary, RecentItemPublicAccountChatMsgData paramRecentItemPublicAccountChatMsgData)
  {
    long l1 = System.currentTimeMillis();
    Object localObject = paramQQAppInterface.b().d("2747277822", 1008);
    ahta localahta = (ahta)paramQQAppInterface.getManager(358);
    if (!localahta.anX()) {}
    RecentUser localRecentUser;
    GameCenterSessionInfo localGameCenterSessionInfo;
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
                localahta.cie = false;
                localahta.cif = false;
              } while (!aS(paramQQAppInterface));
              paramMessage = paramQQAppInterface.a();
              localRecentUser = paramMessage.a("2747277822", 1008);
              paramRecentItemPublicAccountChatMsgData.mUnreadNum += localahta.Fj();
              if ((!az((MessageRecord)localObject)) || (((MessageRecord)localObject).isread)) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d(TAG, 2, "[buildMessageBody] has unread public account message.return.");
            return;
          } while ((az((MessageRecord)localObject)) && (localahta.Fj() == 0));
          localGameCenterSessionInfo = localahta.a();
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[buildMessageBody] last info:" + localGameCenterSessionInfo + ",  msg:" + localObject);
          }
          if ((localGameCenterSessionInfo != null) && (localGameCenterSessionInfo.eI() != 0L)) {
            break;
          }
        } while (az((MessageRecord)localObject));
        paramQQAppInterface = paramMessage.a("2747277822", 1008);
      } while (paramQQAppInterface == null);
      paramMessage.f(paramQQAppInterface);
      return;
    } while ((localGameCenterSessionInfo.Fi() <= 0) && (localObject != null) && (localGameCenterSessionInfo.eI() <= ((MessageRecord)localObject).time));
    if (localGameCenterSessionInfo.getSessionType() == 0)
    {
      paramMsgSummary.strContent = new aofk("[" + localGameCenterSessionInfo.getRequestCount() + "位好友请求] 来自" + localGameCenterSessionInfo.wy(), 3, 16, -1);
      long l2 = j(paramQQAppInterface);
      paramRecentItemPublicAccountChatMsgData.mDisplayTime = (l2 / 1000L);
      if (!isToday(l2))
      {
        localRecentUser.lastmsgtime = localGameCenterSessionInfo.eI();
        paramRecentItemPublicAccountChatMsgData.mDisplayTime = localGameCenterSessionInfo.eI();
        paramMessage = BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0);
        paramQQAppInterface = "sp_top_last_time" + paramQQAppInterface.getCurrentAccountUin();
        paramMessage.edit().putLong(paramQQAppInterface, System.currentTimeMillis()).commit();
      }
    }
    for (;;)
    {
      localahta.cie = true;
      if (localahta.Fj() != 0) {
        localahta.cif = true;
      }
      awot.a().c(localGameCenterSessionInfo.wx(), "1", "145", "920", "92003", "206345", "0", "0", "8", "0");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(TAG, 2, "[buildMessageBody] msgSummary:" + paramMsgSummary.toString() + "，user:" + localRecentUser.lastmsgtime + " ， cost time:" + (System.currentTimeMillis() - l1));
      return;
      localObject = localGameCenterSessionInfo.getNickName();
      paramMessage = localahta.wE();
      paramQQAppInterface = paramMessage;
      if (!TextUtils.isEmpty(paramMessage)) {}
      try
      {
        int i = paramMessage.indexOf("<");
        int j = paramMessage.indexOf(">");
        paramQQAppInterface = paramMessage;
        if (j >= 0)
        {
          paramQQAppInterface = paramMessage;
          if (i >= 0)
          {
            paramQQAppInterface = paramMessage.substring(i, j + 1);
            j = Integer.parseInt(paramQQAppInterface.substring(1, paramQQAppInterface.length() - 1));
            i = j;
            if (j >= fl.length) {
              i = 0;
            }
            paramQQAppInterface = paramMessage.replace(paramQQAppInterface, fl[i]);
          }
        }
      }
      catch (Exception paramMessage)
      {
        for (;;)
        {
          paramQQAppInterface = PREFIX;
          QLog.e(TAG, 2, paramMessage, new Object[0]);
        }
      }
      paramMsgSummary.strContent = new aofk(paramQQAppInterface + " " + (String)localObject + ": " + localGameCenterSessionInfo.wA(), 3, 16, -1);
      localRecentUser.lastmsgtime = localGameCenterSessionInfo.eI();
      paramRecentItemPublicAccountChatMsgData.mDisplayTime = localGameCenterSessionInfo.eI();
    }
  }
  
  public static void a(String paramString, Context paramContext, GameCenterSessionInfo paramGameCenterSessionInfo)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = new Intent(paramContext, GameCenterActivity.class);
    String str = paramString;
    if (paramGameCenterSessionInfo != null)
    {
      str = paramString;
      if (paramGameCenterSessionInfo.getSessionType() == 0) {
        str = paramString + "&&gameId=" + paramGameCenterSessionInfo.wx() + "&gameName=" + paramGameCenterSessionInfo.wy() + "&sessionId=" + paramGameCenterSessionInfo.getSessionId() + "&requestCount=" + paramGameCenterSessionInfo.getRequestCount();
      }
    }
    localIntent.putExtra("url", str);
    if (paramGameCenterSessionInfo != null)
    {
      localIntent.putExtra("sessionType", paramGameCenterSessionInfo.getSessionType());
      localIntent.putExtra("sessionId", paramGameCenterSessionInfo.getSessionId());
      localIntent.putExtra("roleId", paramGameCenterSessionInfo.ww());
      localIntent.putExtra("myRoleId", paramGameCenterSessionInfo.pk());
    }
    localIntent.addFlags(268435456);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("big_brother_source_key", "biz_src_zf_games");
    paramContext.startActivity(localIntent);
  }
  
  public static boolean aS(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[isPubAccountReceiveMsg] ret = " + true);
    }
    return true;
  }
  
  public static boolean az(MessageRecord paramMessageRecord)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramMessageRecord != null)
    {
      bool1 = bool2;
      if (TextUtils.isEmpty(paramMessageRecord.msg))
      {
        bool1 = bool2;
        if (paramMessageRecord.time != 0L) {}
      }
    }
    else
    {
      bool1 = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[checkMesssageIsValid] ret = " + bool1);
    }
    return bool1;
  }
  
  public static String d(String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject = paramQQAppInterface.a().a(paramString, 10007);
    if ((localObject != null) && (((ConversationInfo)localObject).tinyInfo != null))
    {
      localObject = ((ahta)paramQQAppInterface.getManager(358)).a(((ConversationInfo)localObject).tinyInfo.fromRoleId);
      if ((localObject != null) && (!TextUtils.isEmpty(((GameUserInfo)localObject).mNickInGame))) {
        return ((GameUserInfo)localObject).mNickInGame;
      }
      paramString = paramQQAppInterface.a(10007).a(paramString, 10007);
      if (paramString != null)
      {
        paramString = new TinyInfo(paramString.getExtInfoFromExtStr("ext_key_game_msg_info"));
        if (!TextUtils.isEmpty(paramString.nickName)) {
          return paramString.nickName;
        }
      }
    }
    return BaseApplicationImpl.getApplication().getResources().getString(2131694203);
  }
  
  public static void d(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    QLog.i(TAG, 1, "[enterGameMsgChatPie], uin:" + paramString1 + ",fRoleId:" + paramString2 + ",mRoleId:" + paramString3 + ", clickFrom = " + paramInt);
    Intent localIntent = new Intent(paramContext, ChatActivity.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("game_msg_friend_role_id", paramString2);
    localIntent.putExtra("game_msg_my_role_id", paramString3);
    localIntent.putExtra("uintype", 10007);
    localIntent.putExtra("game_msg_enter_from", paramInt);
    paramContext.startActivity(localIntent);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if (paramQQAppInterface != null) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "enterGameMsgChatPie is called.");
      }
      Object localObject = paramQQAppInterface.a().b(paramString, 10007);
      if (localObject != null)
      {
        String str1 = ((ConversationInfo)localObject).tinyInfo.fromRoleId;
        String str2 = ((ConversationInfo)localObject).tinyInfo.toRoleId;
        GameCenterSessionInfo localGameCenterSessionInfo = ((ahta)paramQQAppInterface.getManager(358)).a(paramString);
        localObject = localGameCenterSessionInfo;
        if (localGameCenterSessionInfo == null) {
          localObject = new GameCenterSessionInfo();
        }
        ((GameCenterSessionInfo)localObject).setSessionId(paramString);
        ((GameCenterSessionInfo)localObject).Kx(str1);
        ((GameCenterSessionInfo)localObject).xx(str2);
        a(paramQQAppInterface, paramContext, (GameCenterSessionInfo)localObject);
        g(paramQQAppInterface, paramString, 10004, 1);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static String eo(int paramInt)
  {
    if (paramInt > 99) {
      return "99+";
    }
    return paramInt + "";
  }
  
  public static void g(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    if (paramQQAppInterface == null) {}
    String str;
    do
    {
      return;
      str = getKey(paramInt1);
      try
      {
        paramQQAppInterface = paramQQAppInterface.a(10007).a(paramString, 10007);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "report called with: key = [" + str + "], from = [" + paramInt1 + "], fromType = [" + paramInt2 + "]");
        }
        if (paramQQAppInterface == null)
        {
          QLog.d(TAG, 1, "report called with: conversationInfo null. key = [" + str + "], from = [" + paramInt1 + "], fromType = [" + paramInt2 + "]");
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e(TAG, 1, "report called with:  key = [" + str + "], fromType = [" + paramInt1 + "], fromType = [" + paramInt2 + "]", paramQQAppInterface);
        return;
      }
      paramString = paramQQAppInterface.getExtInfoFromExtStr("ext_key_game_msg_info");
    } while (TextUtils.isEmpty(paramString));
    anot.a(null, "dc00898", "", "", str, str, paramInt2, 0, String.valueOf(new TinyInfo(paramString, paramQQAppInterface.isSend()).gameAppId), "", "", "");
  }
  
  private static String getKey(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 10001: 
      return "0X800AD42";
    case 10002: 
      return "0X800AD41";
    case 10003: 
      return "0X800AD40";
    case 10004: 
      return "0X800AD3F";
    case 10005: 
      return "0X800AD3E";
    }
    return "0X800AD3D";
  }
  
  public static String getTimeString(long paramLong)
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).set(((Calendar)localObject).get(1), ((Calendar)localObject).get(2), ((Calendar)localObject).get(5) - 1, 0, 0, 0);
    long l = ((Calendar)localObject).getTime().getTime();
    if (isToday(paramLong))
    {
      localObject = new Date(paramLong);
      return new SimpleDateFormat("HH:mm").format((Date)localObject);
    }
    if (paramLong > l) {
      return "昨天";
    }
    if (paramLong > l - 518400000L) {
      return "两天前";
    }
    if (paramLong > l - 2505600000L) {
      return "一周前";
    }
    return "一月前";
  }
  
  private static boolean isThisTime(long paramLong, String paramString)
  {
    Date localDate = new Date(paramLong);
    paramString = new SimpleDateFormat(paramString);
    return paramString.format(localDate).equals(paramString.format(new Date()));
  }
  
  public static boolean isToday(long paramLong)
  {
    return isThisTime(paramLong, "yyyy-MM-dd");
  }
  
  public static long j(QQAppInterface paramQQAppInterface)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0).getLong("sp_top_last_time" + paramQQAppInterface.getCurrentAccountUin(), 0L);
  }
  
  public static void m(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    d(paramContext, paramString1, paramString2, paramString3, 0);
  }
  
  public static void report(int paramInt1, int paramInt2)
  {
    String str = getKey(paramInt1);
    anot.a(null, "dc00898", "", "", str, str, paramInt2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahtc
 * JD-Core Version:    0.7.0.1
 */