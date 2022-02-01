import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.script.SpriteUtil.1;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Apollo3DMessage;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class abrj
{
  private static int crl = 0;
  
  public static boolean S(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(paramQQAppInterface);
    if (paramQQAppInterface == null) {}
    do
    {
      return true;
      if (-1 == paramQQAppInterface.cqT) {
        paramQQAppInterface.cEC();
      }
    } while (paramQQAppInterface.cqT == 1);
    return false;
  }
  
  public static boolean T(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(paramQQAppInterface);
    return (paramQQAppInterface == null) || (paramQQAppInterface.Zc());
  }
  
  public static boolean U(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      do
      {
        return false;
        if (abhh.aV(BaseApplicationImpl.getContext())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("cmshow_scripted_SpriteUtil", 2, "NOT allowed to use cmshow.");
      return false;
    } while (!ApolloEngine.BJ());
    return true;
  }
  
  public static boolean V(QQAppInterface paramQQAppInterface)
  {
    if (!U(paramQQAppInterface))
    {
      QLog.i("cmshow_scripted_SpriteUtil", 1, "not meet basic case.");
      return false;
    }
    if (1 != abvg.c(paramQQAppInterface.getCurrentUin(), paramQQAppInterface))
    {
      QLog.i("cmshow_scripted_SpriteUtil", 1, "cmshow switch NOT opend.");
      return false;
    }
    return true;
  }
  
  public static int a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if ((paramInt1 == 0) || (8 == paramInt1)) {
      paramInt2 = ApolloUtil.b(208.0F, paramString, paramInt3);
    }
    do
    {
      do
      {
        return paramInt2;
        if (3 == paramInt1) {
          return 32;
        }
        if (6 != paramInt1) {
          break;
        }
        paramInt2 = 33;
      } while (paramInt3 != 2);
      return 75;
      if (7 == paramInt1)
      {
        if (paramInt3 != 2) {
          break;
        }
        return 74;
      }
    } while (9 == paramInt1);
    QLog.d("cmshow_scripted_SpriteUtil", 1, new Object[] { "Other bubble type, NOT Handle, bubbleType:", Integer.valueOf(paramInt1), ", bubbleId:", Integer.valueOf(32) });
    return 32;
  }
  
  public static int a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, boolean paramBoolean3)
  {
    int i = 26;
    paramInt2 = 0;
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        break label89;
      }
      if (paramBoolean3) {
        paramInt2 = 81;
      }
    }
    else if (!paramBoolean1)
    {
      if (!paramBoolean2) {
        break label101;
      }
      if (!paramBoolean3) {
        break label95;
      }
      paramInt2 = 84;
    }
    for (;;)
    {
      if (ApolloUtil.aI(paramInt1, paramInt2)) {
        return paramInt2;
      }
      QLog.w("cmshow_scripted_SpriteUtil", 1, "nick bubble not exist, id:" + paramInt2);
      paramInt1 = i;
      if (paramBoolean1) {
        paramInt1 = 25;
      }
      return paramInt1;
      paramInt2 = 82;
      break;
      label89:
      paramInt2 = 25;
      break;
      label95:
      paramInt2 = 83;
      continue;
      label101:
      paramInt2 = 26;
    }
    return paramInt2;
  }
  
  public static abjp a(String paramString1, QQAppInterface paramQQAppInterface, int paramInt, String paramString2)
  {
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramString1);
        int j = paramString1.optInt("isNeedRemark");
        JSONArray localJSONArray1 = paramString1.optJSONArray("uins");
        paramString1 = new JSONObject();
        JSONArray localJSONArray2 = new JSONArray();
        int i = 0;
        if (i < localJSONArray1.length())
        {
          JSONObject localJSONObject = new JSONObject();
          String str1 = localJSONArray1.optString(i);
          if (j == 0)
          {
            bool = true;
            String str2 = a(paramQQAppInterface, paramInt, str1, paramString2, bool);
            localJSONObject.put("uin", str1);
            localJSONObject.put("nickname", str2);
            localJSONArray2.put(localJSONObject);
            i += 1;
          }
        }
        else
        {
          paramString1.put("nicknames", localJSONArray2);
          paramQQAppInterface = new abjp();
          paramQQAppInterface.bDs = true;
          paramQQAppInterface.bgF = paramString1.toString();
          return paramQQAppInterface;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("cmshow_scripted_SpriteUtil", 1, paramString1, new Object[0]);
        return null;
      }
      boolean bool = false;
    }
  }
  
  public static abqt a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    return (abqt)((abrg)paramQQAppInterface.getManager(249)).a().a(0);
  }
  
  public static abqz a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return null;
      paramQQAppInterface = a(paramQQAppInterface);
    } while (paramQQAppInterface == null);
    return paramQQAppInterface.a();
  }
  
  public static abrc a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    return ((abrg)paramQQAppInterface.getManager(249)).a();
  }
  
  public static abrd a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    return ((abrg)paramQQAppInterface.getManager(249)).b();
  }
  
  public static abrg a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    return (abrg)paramQQAppInterface.getManager(249);
  }
  
  public static ApolloActionData a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    return ((abxk)paramQQAppInterface.getManager(155)).c(paramInt);
  }
  
  public static MessageForApollo a(String paramString, abrc paramabrc)
  {
    for (;;)
    {
      try
      {
        if (paramabrc.d() == null) {
          return null;
        }
        JSONObject localJSONObject = new JSONObject(new JSONObject(paramString).optString("basicMsg"));
        Object localObject = new ApolloMessage();
        ((ApolloMessage)localObject).id = localJSONObject.optInt("id");
        paramString = localJSONObject.optString("name");
        if (!TextUtils.isEmpty(paramString)) {
          ((ApolloMessage)localObject).name = aqgo.decode(paramString.getBytes("utf-8"), 0);
        }
        ((ApolloMessage)localObject).flag = localJSONObject.optInt("flag");
        ((ApolloMessage)localObject).peer_status = localJSONObject.optInt("peerStatus");
        ((ApolloMessage)localObject).sender_status = localJSONObject.optInt("senderStatus");
        ((ApolloMessage)localObject).peer_ts = localJSONObject.optLong("peerTS");
        ((ApolloMessage)localObject).sender_ts = localJSONObject.optLong("senderTS");
        ((ApolloMessage)localObject).peer_uin = localJSONObject.optLong("peerUin");
        paramString = localJSONObject.optString("atText");
        if (!paramString.isEmpty()) {
          ((ApolloMessage)localObject).text = aqgo.decode(paramString.getBytes("utf-8"), 0);
        }
        paramString = localJSONObject.optJSONObject("extraStr");
        localJSONObject = localJSONObject.optJSONObject("extendJson");
        if (paramString == null)
        {
          paramString = new JSONObject();
          if (localJSONObject != null) {
            paramString.put("extendJson", localJSONObject);
          }
          ((ApolloMessage)localObject).extStr = paramString.toString();
          paramabrc = anbi.a(paramabrc.getApp(), paramabrc.d().sessionInfo.aTl, paramabrc.d().sessionInfo.troopUin, paramabrc.mAioType, (ApolloMessage)localObject);
          paramabrc.inputText = paramString.optString("inputText");
          paramabrc.audioId = paramString.optInt("audioID");
          if (paramString.has("audioStartTime")) {
            paramabrc.audioStartTime = ((float)paramString.optDouble("audioStartTime"));
          }
          paramabrc.actionType = paramString.optInt("actionType");
          if (localJSONObject != null) {
            paramabrc.extendJson = localJSONObject.toString();
          }
          if (paramString.has("mApollo3DMessage"))
          {
            paramString = paramString.getJSONObject("mApollo3DMessage");
            localObject = new Apollo3DMessage();
            ((Apollo3DMessage)localObject).setMessageWithJSONObject(paramString);
            paramabrc.mApollo3DMessage = ((Apollo3DMessage)localObject);
          }
          return paramabrc;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("cmshow_scripted_SpriteUtil", 1, paramString, new Object[0]);
        return null;
      }
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteUtil", 2, new Object[] { "[getSpriteName], uin:", paramString1, ",sessionType:", Integer.valueOf(paramInt), ",groupUin:", paramString2, ",isNeedRemark:", Boolean.valueOf(paramBoolean) });
    }
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)))
    {
      paramString1 = "";
      return paramString1;
    }
    if (("-1".equals(paramString1)) || ("-2".equals(paramString1))) {
      return "";
    }
    String str = "";
    if (-1 == paramInt) {
      paramString2 = aqgv.c(paramQQAppInterface, paramString1, true);
    }
    label253:
    do
    {
      for (;;)
      {
        paramQQAppInterface = paramString2;
        if (!TextUtils.isEmpty(paramString2)) {
          paramQQAppInterface = paramString2.replace("\\", "").replace("'", "").replace("\"", "");
        }
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          break;
        }
        return paramQQAppInterface;
        if ((paramInt != 1) && (paramInt != 3000)) {
          break label272;
        }
        if (paramBoolean) {}
        for (str = aqgv.p(paramQQAppInterface, paramString2, paramString1);; str = aqgv.o(paramQQAppInterface, paramString2, paramString1))
        {
          if (!TextUtils.isEmpty(str))
          {
            paramString2 = str;
            if (!str.equals(paramString1)) {
              break;
            }
          }
          paramString2 = ((acff)paramQQAppInterface.getManager(51)).e(paramString1);
          if (paramString2 == null) {
            break label253;
          }
          paramString2 = paramString2.name;
          break;
        }
        ((FriendListHandler)paramQQAppInterface.getBusinessHandler(1)).bC(paramString1, false);
        paramString2 = str;
      }
      paramString2 = str;
    } while (paramInt != 0);
    label272:
    if (paramBoolean) {}
    for (str = aqgv.p(paramQQAppInterface, paramString1);; str = aqgv.c(paramQQAppInterface, paramString1, true))
    {
      paramString2 = str;
      if (!paramString1.equals(str)) {
        break;
      }
      ((FriendListHandler)paramQQAppInterface.getBusinessHandler(1)).bC(paramString1, false);
      paramString2 = str;
      break;
    }
  }
  
  public static void a(abrc paramabrc, List<SpriteTaskParam> paramList)
  {
    if ((paramabrc == null) || (paramList == null) || (paramList.size() == 0)) {}
    do
    {
      return;
      paramabrc = a(paramabrc.getApp());
    } while (paramabrc == null);
    paramabrc.a().ia(paramList);
  }
  
  public static void a(abrs paramabrs, int paramInt, ApolloActionData paramApolloActionData)
  {
    if (paramabrs == null) {
      return;
    }
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.mActionId = paramApolloActionData.actionId;
    localSpriteTaskParam.crh = paramInt;
    localSpriteTaskParam.mActionType = paramApolloActionData.actionType;
    localSpriteTaskParam.crd = 5;
    localSpriteTaskParam.crb = 0;
    localSpriteTaskParam.mMsgId = 1000000L;
    localSpriteTaskParam.mIsSend = true;
    localSpriteTaskParam.bEW = false;
    paramApolloActionData = paramabrs.a();
    if ((paramApolloActionData != null) && (paramApolloActionData.getApp() != null)) {
      localSpriteTaskParam.mSenderUin = String.valueOf(paramApolloActionData.mSelfUin);
    }
    paramabrs.a().a(localSpriteTaskParam);
  }
  
  public static void a(abrs paramabrs, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramabrs == null) || (paramabrs.a() == null)) {
      return;
    }
    abqt localabqt = paramabrs.a();
    paramabrs.a().setBubbleType(paramInt1);
    paramabrs = paramabrs.getApp();
    int i = 1;
    if (paramabrs != null) {
      i = abhh.h(paramabrs, paramabrs.getCurrentUin());
    }
    localabqt.F("", paramString, a(paramInt1, paramInt2, paramString, i));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SpriteTaskParam paramSpriteTaskParam)
  {
    if ((paramSpriteTaskParam == null) || (paramQQAppInterface == null)) {}
    abrc localabrc;
    int k;
    label71:
    do
    {
      do
      {
        return;
        localabrc = a(paramQQAppInterface);
      } while (localabrc == null);
      k = localabrc.mAioType;
      if ((1 == k) || (3000 == k))
      {
        i = 0;
        int j;
        if (!TextUtils.isEmpty(paramSpriteTaskParam.bhv))
        {
          if (paramSpriteTaskParam.bEW) {
            i = 2;
          }
        }
        else
        {
          if (!paramSpriteTaskParam.mIsSend) {
            break label161;
          }
          j = 0;
          k = ApolloUtil.gi(k);
          str = Integer.toString(paramSpriteTaskParam.mActionId);
          if (paramSpriteTaskParam.crb != 0) {
            break label166;
          }
        }
        for (paramSpriteTaskParam = "0";; paramSpriteTaskParam = "1")
        {
          VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "g_msg_clk", j, k, new String[] { str, paramSpriteTaskParam, String.valueOf(i), String.valueOf(System.currentTimeMillis() / 1000L), localabrc.mFriendUin });
          return;
          i = 1;
          break;
          j = 1;
          break label71;
        }
      }
    } while (k != 0);
    label161:
    label166:
    String str = "0";
    if (!TextUtils.isEmpty(paramSpriteTaskParam.bhv)) {
      str = "1";
    }
    if (paramSpriteTaskParam.mIsSend) {}
    for (int i = 0;; i = 1)
    {
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "msg_clk", i, 0, new String[] { Integer.toString(paramSpriteTaskParam.mActionId), str, "", String.valueOf(System.currentTimeMillis() / 1000L), localabrc.mFriendUin });
      return;
    }
  }
  
  public static boolean a(String paramString, SpriteTaskParam paramSpriteTaskParam, abrc paramabrc, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((TextUtils.isEmpty(paramString)) || (paramabrc == null) || (paramabrc.getApp() == null)) {
      bool1 = false;
    }
    label111:
    do
    {
      do
      {
        do
        {
          return bool1;
          paramabrc = paramabrc.getApp().getCurrentAccountUin();
          if ((TextUtils.isEmpty(paramSpriteTaskParam.bbE)) || (paramSpriteTaskParam.bbE.length() <= 4)) {
            break label111;
          }
          if ((!paramString.equals(paramSpriteTaskParam.bbE)) || (!paramString.equals(paramabrc))) {
            break;
          }
          bool1 = bool2;
        } while (!paramString.equals(paramSpriteTaskParam.mSenderUin));
        if (!paramString.equals(paramSpriteTaskParam.mSenderUin)) {
          break;
        }
        bool1 = bool2;
      } while (paramBoolean);
      return false;
      if (TextUtils.isEmpty(paramSpriteTaskParam.mSenderUin)) {
        break;
      }
      bool1 = bool2;
    } while (paramString.equals(paramabrc));
    return false;
    return false;
  }
  
  public static void cd(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      paramQQAppInterface = a(paramQQAppInterface);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.bEU = true;
  }
  
  public static void ce(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      abrc localabrc;
      SharedPreferences localSharedPreferences;
      int i;
      do
      {
        do
        {
          do
          {
            return;
            localabrc = a(paramQQAppInterface);
          } while (localabrc == null);
          localSharedPreferences = localabrc.mPref;
        } while (localSharedPreferences == null);
        i = localSharedPreferences.getInt("audio_tips_times" + localabrc.mSelfUin, 0);
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_SpriteUtil", 2, "totalTimes:" + i);
        }
      } while (3 == i);
      localSharedPreferences.edit().putInt("audio_tips_times" + localabrc.mSelfUin, i + 1).commit();
      paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.post(new SpriteUtil.1());
  }
  
  public static boolean e(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    return false;
  }
  
  public static boolean f(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    int i = gf(0);
    if (!U(paramQQAppInterface))
    {
      abwh.a(i, 10, 102, new Object[] { "not meet basic case" });
      QLog.i("cmshow_scripted_SpriteUtil", 1, "not meet basic case.");
    }
    do
    {
      do
      {
        return false;
        if (1 != abvg.c(paramQQAppInterface.getCurrentUin(), paramQQAppInterface))
        {
          abwh.a(i, 10, 101, new Object[] { "cmshow switch NOT opend" });
          QLog.i("cmshow_scripted_SpriteUtil", 1, "cmshow switch NOT opend.");
          return false;
        }
        if (!jof.a().dd(paramString)) {
          break;
        }
        abwh.a(i, 10, 104, new Object[] { "aio anonymous" });
      } while (!QLog.isColorLevel());
      QLog.d("cmshow_scripted_SpriteUtil", 2, "aio anonymous.");
      return false;
    } while ((!e(paramQQAppInterface, paramInt, paramString)) || (T(paramQQAppInterface)));
    paramQQAppInterface = new SessionInfo();
    paramQQAppInterface.cZ = paramInt;
    paramQQAppInterface.aTl = paramString;
    return true;
  }
  
  public static int ge(int paramInt)
  {
    switch (paramInt)
    {
    case 8: 
    default: 
      return 0;
    case 7: 
      return 1;
    }
    return 2;
  }
  
  public static int gf(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 1;
    case 1: 
      return 2;
    case 2: 
      return 3;
    }
    return 113;
  }
  
  public static void j(int paramInt, Object... paramVarArgs)
  {
    if (BaseApplicationImpl.sProcessId != 1) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = BaseApplicationImpl.getApplication().peekAppRuntime();
      } while ((localObject == null) || (!(localObject instanceof QQAppInterface)));
      localObject = a((QQAppInterface)localObject);
    } while (localObject == null);
    int i = paramInt;
    if (paramInt == 0) {
      i = -100;
    }
    ((abrg)localObject).i(i, paramVarArgs);
  }
  
  public static String replaceBlank(String paramString)
  {
    String str = "";
    if (paramString != null) {
      str = Pattern.compile("\\s*|\t|\r|\n").matcher(paramString).replaceAll("");
    }
    return str;
  }
  
  public static int y(QQAppInterface paramQQAppInterface)
  {
    return abhh.b(paramQQAppInterface);
  }
  
  public static int zN()
  {
    return (int)(aqgz.hK() * 4L / 3L);
  }
  
  public static int zO()
  {
    return (int)aqgz.hK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abrj
 * JD-Core Version:    0.7.0.1
 */