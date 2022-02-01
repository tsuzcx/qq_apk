import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel.b;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class abmh
{
  public static long NU;
  
  public static boolean YD()
  {
    if ((BaseActivity.sTopActivity instanceof FragmentActivity))
    {
      localObject = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).a();
        if (!(localObject instanceof xxh)) {}
      }
    }
    for (Object localObject = (xxh)localObject;; localObject = null) {
      return (localObject != null) && (((xxh)localObject).SY());
    }
  }
  
  /* Error */
  public static android.graphics.drawable.Drawable a(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    // Byte code:
    //   0: new 49	android/graphics/drawable/StateListDrawable
    //   3: dup
    //   4: invokespecial 53	android/graphics/drawable/StateListDrawable:<init>	()V
    //   7: astore 6
    //   9: new 55	afej
    //   12: dup
    //   13: ldc 57
    //   15: invokestatic 63	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   18: iload_2
    //   19: iconst_2
    //   20: idiv
    //   21: i2f
    //   22: iload_1
    //   23: iload_2
    //   24: invokespecial 66	afej:<init>	(IFII)V
    //   27: astore 5
    //   29: new 55	afej
    //   32: dup
    //   33: ldc 57
    //   35: invokestatic 63	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   38: iload_2
    //   39: iconst_2
    //   40: idiv
    //   41: i2f
    //   42: iload_1
    //   43: iload_2
    //   44: invokespecial 66	afej:<init>	(IFII)V
    //   47: astore_0
    //   48: new 55	afej
    //   51: dup
    //   52: aload_3
    //   53: invokestatic 63	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   56: iload_2
    //   57: iconst_2
    //   58: idiv
    //   59: i2f
    //   60: iload_1
    //   61: iload_2
    //   62: invokespecial 66	afej:<init>	(IFII)V
    //   65: astore 4
    //   67: new 55	afej
    //   70: dup
    //   71: new 68	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   78: ldc 71
    //   80: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_3
    //   84: aload_3
    //   85: ldc 77
    //   87: invokevirtual 82	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   90: iconst_1
    //   91: iadd
    //   92: invokevirtual 86	java/lang/String:substring	(I)Ljava/lang/String;
    //   95: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 63	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   104: iload_2
    //   105: iconst_2
    //   106: idiv
    //   107: i2f
    //   108: iload_1
    //   109: iload_2
    //   110: invokespecial 66	afej:<init>	(IFII)V
    //   113: astore_3
    //   114: aload_3
    //   115: sipush 204
    //   118: invokevirtual 95	android/graphics/drawable/Drawable:setAlpha	(I)V
    //   121: aload_3
    //   122: astore_0
    //   123: aload 6
    //   125: iconst_1
    //   126: newarray int
    //   128: dup
    //   129: iconst_0
    //   130: ldc 96
    //   132: iastore
    //   133: aload_0
    //   134: invokevirtual 100	android/graphics/drawable/StateListDrawable:addState	([ILandroid/graphics/drawable/Drawable;)V
    //   137: aload 6
    //   139: iconst_1
    //   140: newarray int
    //   142: dup
    //   143: iconst_0
    //   144: ldc 101
    //   146: iastore
    //   147: aload 4
    //   149: invokevirtual 100	android/graphics/drawable/StateListDrawable:addState	([ILandroid/graphics/drawable/Drawable;)V
    //   152: aload 6
    //   154: areturn
    //   155: astore 4
    //   157: aload 5
    //   159: astore_3
    //   160: ldc 103
    //   162: iconst_2
    //   163: ldc 105
    //   165: aload 4
    //   167: invokestatic 111	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   170: aload_3
    //   171: astore 4
    //   173: goto -50 -> 123
    //   176: astore 5
    //   178: aload 4
    //   180: astore_3
    //   181: aload 5
    //   183: astore 4
    //   185: goto -25 -> 160
    //   188: astore 5
    //   190: aload_3
    //   191: astore_0
    //   192: aload 4
    //   194: astore_3
    //   195: aload 5
    //   197: astore 4
    //   199: goto -39 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	paramContext	Context
    //   0	202	1	paramInt1	int
    //   0	202	2	paramInt2	int
    //   0	202	3	paramString	String
    //   65	83	4	localafej1	afej
    //   155	11	4	localException1	Exception
    //   171	27	4	localObject	Object
    //   27	131	5	localafej2	afej
    //   176	6	5	localException2	Exception
    //   188	8	5	localException3	Exception
    //   7	146	6	localStateListDrawable	android.graphics.drawable.StateListDrawable
    // Exception table:
    //   from	to	target	type
    //   48	67	155	java/lang/Exception
    //   67	114	176	java/lang/Exception
    //   114	121	188	java/lang/Exception
  }
  
  public static MessageForApollo a(List<MessageForApollo> paramList, int paramInt, long paramLong)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      Object localObject = (MessageRecord)paramList.get(i);
      if (!(localObject instanceof MessageForApollo)) {}
      do
      {
        i -= 1;
        break;
        localObject = (MessageForApollo)localObject;
      } while ((((MessageForApollo)localObject).roomId != paramLong) || (((MessageForApollo)localObject).gameId != paramInt));
      return localObject;
    }
    return null;
  }
  
  public static List<MessageForApollo> a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    Object localObject1 = paramQQAppInterface.b().k(paramString, paramInt1);
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      if (!QLog.isColorLevel()) {
        break label272;
      }
      QLog.d("CmGameTemp_CmGameSessionUtil", 2, "in aio, cache size:" + ((List)localObject1).size());
      paramString = (String)localObject1;
    }
    for (;;)
    {
      if ((paramString == null) || (paramString.size() == 0))
      {
        QLog.i("CmGameTemp_CmGameSessionUtil", 2, "msgRcd size is 0.");
        return null;
        if (QLog.isColorLevel()) {
          QLog.d("CmGameTemp_CmGameSessionUtil", 2, "NOT in aio.");
        }
        paramString = paramQQAppInterface.b().a(paramString, paramInt1, new int[] { -2039 }, 20);
      }
      else
      {
        localObject1 = new ArrayList();
        abhe localabhe = (abhe)paramQQAppInterface.getManager(211);
        paramInt1 = paramString.size() - 1;
        if (paramInt1 >= 0)
        {
          Object localObject2 = (MessageRecord)paramString.get(paramInt1);
          if (!(localObject2 instanceof MessageForApollo)) {}
          for (;;)
          {
            paramInt1 -= 1;
            break;
            localObject2 = (MessageForApollo)localObject2;
            if ((((MessageForApollo)localObject2).gameId == paramInt2) && (((MessageForApollo)localObject2).roomId == paramLong))
            {
              ((List)localObject1).add(localObject2);
              ((MessageForApollo)localObject2).gameStatus = 3;
              if (YD()) {
                localabhe.a().e((MessageForApollo)localObject2);
              }
              ApolloGameUtil.a(paramQQAppInterface, (MessageForApollo)localObject2);
            }
          }
        }
        return localObject1;
        label272:
        paramString = (String)localObject1;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, ApolloGameData paramApolloGameData, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameSessionUtil", 2, "[checkGameApp]");
    }
    if ((paramQQAppInterface == null) || (paramContext == null) || (paramApolloGameData == null) || (paramSessionInfo == null))
    {
      QLog.e("CmGameTemp_CmGameSessionUtil", 1, "[checkGameApp] invalid param");
      return;
    }
    if (!aqiz.isAppInstalled(paramContext, paramApolloGameData.gameAppPkgName))
    {
      paramQQAppInterface = String.format("https://m.gamecenter.qq.com/directout/detail/%s?_wv=2147484679&_wwv=4&ADTAG=limixiuteam&autodownload=1&pf=invite&appid=%s&notShowPub=1&asyncMode=3&appType=1&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_anim=true&_nav_alpha=0", new Object[] { paramApolloGameData.gameAppid, paramApolloGameData.gameAppid });
      paramSessionInfo = new Intent(paramContext, QQBrowserActivity.class);
      paramSessionInfo.putExtra("big_brother_source_key", "biz_src_zf_lmx");
      VasWebviewUtil.openQQBrowserActivity(paramContext, paramQQAppInterface, -1L, paramSessionInfo, false, -1);
      return;
    }
    ((abhh)paramQQAppInterface.getManager(153)).a().a(paramApolloGameData.gameId, paramApolloGameData.gameAppid, 0, paramSessionInfo.aTl, paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ApolloPanel.b localb = new ApolloPanel.b();
    Object localObject = (abxk)paramQQAppInterface.getManager(155);
    ApolloGameData localApolloGameData = ((abxk)localObject).a(paramInt);
    String str = acfp.m(2131704126);
    if ((localApolloGameData != null) && (!TextUtils.isEmpty(localApolloGameData.name)))
    {
      localObject = ((abxk)localObject).a(localApolloGameData.actionId);
      if (localObject == null) {
        break label164;
      }
      str = ((ApolloActionData)localObject).actionName;
    }
    label164:
    for (;;)
    {
      int i = localApolloGameData.actionId;
      localb.gameName = localApolloGameData.name;
      for (;;)
      {
        localb.actionName = str;
        localb.actionId = i;
        localb.gameId = paramInt;
        localb.roomId = paramLong;
        localb.gameStatus = 1;
        localb.msgType = 3;
        a(paramQQAppInterface, paramString, localb);
        return;
        localb.gameName = acfp.m(2131704128);
        i = 0;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, ApolloPanel.b paramb)
  {
    if ((paramb == null) || (paramQQAppInterface == null))
    {
      QLog.e("CmGameTemp_CmGameSessionUtil", 1, "[sendGameMsg], errInfo->param is null.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameSessionUtil", 2, new Object[] { "[sendGameMsg], gameId:", Integer.valueOf(paramb.gameId), ",roomId:", Long.valueOf(paramb.roomId), ",extendInfo:", paramb.gameExtendJson });
    }
    ApolloMessage localApolloMessage = new ApolloMessage();
    if (!TextUtils.isEmpty(paramb.actionName)) {
      localApolloMessage.name = paramb.actionName.getBytes();
    }
    if (0 == 0) {}
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("gameId", paramb.gameId);
        ((JSONObject)localObject).put("gameMode", paramb.gameMode);
        ((JSONObject)localObject).put("roomid", paramb.roomId);
        if (paramb.gameId == 1)
        {
          ((JSONObject)localObject).put("msgTyep", 2);
          ((JSONObject)localObject).put("gameName", paramb.gameName);
          if (!TextUtils.isEmpty(paramb.gameExtendJson)) {
            ((JSONObject)localObject).put("gameExtendJson", paramb.gameExtendJson);
          }
          ((JSONObject)localObject).put("gameStatus", paramb.gameStatus);
          if (localObject != null) {
            localApolloMessage.extStr = ((JSONObject)localObject).toString();
          }
          localObject = ((abhh)paramQQAppInterface.getManager(153)).b(paramQQAppInterface.getCurrentAccountUin());
          localApolloMessage.sender_ts = aqft.ag(((ApolloBaseInfo)localObject).apolloServerTS);
          localApolloMessage.sender_status = ((ApolloBaseInfo)localObject).apolloStatus;
          localObject = ((abxk)paramQQAppInterface.getManager(155)).a(paramb.gameId);
          if ((localObject == null) || (1 != ((ApolloGameData)localObject).hasOwnArk)) {
            break label511;
          }
          i = 297;
          localApolloMessage.flag = (i | 0x200);
          paramString = anbi.a(paramQQAppInterface, paramString, paramQQAppInterface.getCurrentAccountUin(), 1036, localApolloMessage);
          if (paramb.gameId == 1)
          {
            paramString.msgType = 2;
            paramString.gameId = paramb.gameId;
            paramString.mGameMode = paramb.gameMode;
            paramString.roomId = paramb.roomId;
            paramString.mApolloMessage.id = paramb.actionId;
            paramString.gameName = paramb.gameName;
            paramString.gameExtendJson = paramb.gameExtendJson;
            paramString.gameStatus = paramb.gameStatus;
            paramString.extendJson = ("{\"gameStatus\":" + paramb.gameStatus + "}");
            paramQQAppInterface.b().a(paramString, null);
            NU = System.currentTimeMillis();
          }
        }
        else
        {
          ((JSONObject)localObject).put("msgTyep", paramb.msgType);
          continue;
        }
        paramString.msgType = paramb.msgType;
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.d("CmGameTemp_CmGameSessionUtil", 2, paramQQAppInterface, new Object[0]);
        return;
      }
      continue;
      label511:
      int i = 41;
      continue;
      Object localObject = null;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong, int paramInt)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameSessionUtil", 2, new Object[] { "[addFakeInviteMsgLocal], gameId:", Integer.valueOf(paramInt), ",roomId:", Long.valueOf(paramLong), ",robotUin:", paramString1 });
    }
    ApolloPanel.b localb = new ApolloPanel.b();
    Object localObject2 = (abxk)paramQQAppInterface.getManager(155);
    ApolloGameData localApolloGameData = ((abxk)localObject2).a(paramInt);
    Object localObject1 = acfp.m(2131704127);
    if ((localApolloGameData != null) && (!TextUtils.isEmpty(localApolloGameData.name)))
    {
      localObject2 = ((abxk)localObject2).a(localApolloGameData.actionId);
      if (localObject2 == null) {
        break label711;
      }
      localObject1 = ((ApolloActionData)localObject2).actionName;
    }
    label698:
    label711:
    for (;;)
    {
      int i = localApolloGameData.actionId;
      localb.gameName = localApolloGameData.name;
      localb.actionName = ((String)localObject1);
      localb.actionId = i;
      localb.gameId = paramInt;
      localb.roomId = paramLong;
      localb.gameStatus = 0;
      localb.msgType = 3;
      localObject2 = new ApolloMessage();
      if (!TextUtils.isEmpty(localb.actionName)) {
        ((ApolloMessage)localObject2).name = localb.actionName.getBytes();
      }
      localObject1 = null;
      if (0 == 0) {}
      for (;;)
      {
        try
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("gameId", localb.gameId);
          ((JSONObject)localObject1).put("gameMode", localb.gameMode);
          ((JSONObject)localObject1).put("roomid", localb.roomId);
          if (localb.gameId == 1)
          {
            ((JSONObject)localObject1).put("msgTyep", 2);
            ((JSONObject)localObject1).put("gameName", localb.gameName);
            if (!TextUtils.isEmpty(localb.gameExtendJson)) {
              ((JSONObject)localObject1).put("gameExtendJson", localb.gameExtendJson);
            }
            ((JSONObject)localObject1).put("gameStatus", localb.gameStatus);
            if (localObject1 != null) {
              ((ApolloMessage)localObject2).extStr = ((JSONObject)localObject1).toString();
            }
            localObject1 = ((abhh)paramQQAppInterface.getManager(153)).b(paramQQAppInterface.getCurrentAccountUin());
            ((ApolloMessage)localObject2).sender_ts = aqft.ag(((ApolloBaseInfo)localObject1).apolloServerTS);
            ((ApolloMessage)localObject2).sender_status = ((ApolloBaseInfo)localObject1).apolloStatus;
            i = 41;
            paramInt = i;
            if (localApolloGameData != null)
            {
              paramInt = i;
              if (1 == localApolloGameData.hasOwnArk) {
                paramInt = 297;
              }
            }
            ((ApolloMessage)localObject2).flag = (paramInt | 0x200);
            localObject1 = anbi.a(paramQQAppInterface, paramString1, paramQQAppInterface.getCurrentAccountUin(), 1036, (ApolloMessage)localObject2);
            if (localb.gameId != 1) {
              break label698;
            }
            ((MessageForApollo)localObject1).msgType = 2;
            ((MessageForApollo)localObject1).gameId = localb.gameId;
            ((MessageForApollo)localObject1).mGameMode = localb.gameMode;
            ((MessageForApollo)localObject1).roomId = localb.roomId;
            ((MessageForApollo)localObject1).mApolloMessage.id = localb.actionId;
            ((MessageForApollo)localObject1).gameName = localb.gameName;
            ((MessageForApollo)localObject1).gameExtendJson = localb.gameExtendJson;
            ((MessageForApollo)localObject1).gameStatus = localb.gameStatus;
            ((MessageForApollo)localObject1).extendJson = ("{\"gameStatus\":" + localb.gameStatus + ",\"robotOpenId\":" + paramString2 + "}");
            ((MessageForApollo)localObject1).senderuin = paramString1;
            ((MessageForApollo)localObject1).issend = 0;
            paramQQAppInterface.b().b((MessageRecord)localObject1, paramQQAppInterface.getCurrentAccountUin());
            NU = System.currentTimeMillis();
            return;
            localb.gameName = acfp.m(2131704129);
            i = 0;
            break;
          }
          ((JSONObject)localObject1).put("msgTyep", localb.msgType);
          continue;
          ((MessageForApollo)localObject1).msgType = localb.msgType;
        }
        catch (Throwable paramQQAppInterface)
        {
          QLog.d("CmGameTemp_CmGameSessionUtil", 2, paramQQAppInterface, new Object[0]);
          return;
        }
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    QLog.d("CmGameTemp_CmGameSessionUtil", 1, "sendGameAppArkMessage");
    try
    {
      SessionInfo localSessionInfo = new SessionInfo();
      localSessionInfo.cZ = 1036;
      localSessionInfo.aTl = paramString1;
      localSessionInfo.troopUin = paramQQAppInterface.getCurrentAccountUin();
      paramString1 = new JSONObject(paramString2);
      paramString2 = paramString1.optString("app");
      String str1 = paramString1.optString("view");
      String str2 = paramString1.optString("desc");
      String str3 = paramString1.optString("prompt");
      String str4 = paramString1.optString("ver");
      Object localObject = paramString1.optJSONObject("meta");
      paramString1 = null;
      if (localObject != null) {
        paramString1 = ((JSONObject)localObject).toString();
      }
      if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str4)))
      {
        QLog.d("CmGameTemp_CmGameSessionUtil", 1, new Object[] { "[sendGameAppArkMessage] failed, invalid param, appName=", paramString2, ", appView=", str1, ", appMinVersion=", str4 });
        return false;
      }
      localObject = new ArkAppMessage();
      ((ArkAppMessage)localObject).appName = paramString2;
      ((ArkAppMessage)localObject).appView = str1;
      ((ArkAppMessage)localObject).appMinVersion = str4;
      ((ArkAppMessage)localObject).appDesc = str2;
      ((ArkAppMessage)localObject).promptText = str3;
      ((ArkAppMessage)localObject).metaList = paramString1;
      ujt.b(paramQQAppInterface, localSessionInfo, (ArkAppMessage)localObject);
      return true;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("CmGameTemp_CmGameSessionUtil", 1, "[sendGameAppArkMessage] exception=", paramQQAppInterface);
    }
    return false;
  }
  
  public static ColorStateList b(int paramInt1, int paramInt2)
  {
    return new ColorStateList(new int[][] { { 16842919 }, { 0 } }, new int[] { paramInt2, paramInt1 });
  }
  
  public static List<MessageForApollo> b(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    Object localObject = paramQQAppInterface.b().k(paramString, paramInt1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      if (!QLog.isColorLevel()) {
        break label236;
      }
      QLog.d("CmGameTemp_CmGameSessionUtil", 2, "in aio, cache size:" + ((List)localObject).size());
      paramQQAppInterface = (QQAppInterface)localObject;
    }
    for (;;)
    {
      if ((paramQQAppInterface == null) || (paramQQAppInterface.size() == 0))
      {
        QLog.i("CmGameTemp_CmGameSessionUtil", 2, "msgRcd size is 0.");
        return null;
        if (QLog.isColorLevel()) {
          QLog.d("CmGameTemp_CmGameSessionUtil", 2, "NOT in aio.");
        }
        paramQQAppInterface = paramQQAppInterface.b().a(paramString, paramInt1, new int[] { -2039 }, 20);
      }
      else
      {
        paramString = new ArrayList();
        paramInt1 = paramQQAppInterface.size() - 1;
        if (paramInt1 >= 0)
        {
          localObject = (MessageRecord)paramQQAppInterface.get(paramInt1);
          if (!(localObject instanceof MessageForApollo)) {}
          for (;;)
          {
            paramInt1 -= 1;
            break;
            localObject = (MessageForApollo)localObject;
            if ((((MessageForApollo)localObject).gameStatus == paramInt2) && (((MessageForApollo)localObject).roomId > 0L) && (((MessageForApollo)localObject).gameId > 0)) {
              paramString.add(localObject);
            }
          }
        }
        return paramString;
        label236:
        paramQQAppInterface = (QQAppInterface)localObject;
      }
    }
  }
  
  public static List<MessageForApollo> b(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    Object localObject1 = paramQQAppInterface.b().k(paramString, paramInt1);
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      if (!QLog.isColorLevel()) {
        break label311;
      }
      QLog.d("CmGameTemp_CmGameSessionUtil", 2, "in aio, cache size:" + ((List)localObject1).size());
      paramString = (String)localObject1;
    }
    for (;;)
    {
      if ((paramString == null) || (paramString.size() == 0))
      {
        QLog.i("CmGameTemp_CmGameSessionUtil", 2, "msgRcd size is 0.");
        return null;
        if (QLog.isColorLevel()) {
          QLog.d("CmGameTemp_CmGameSessionUtil", 2, "NOT in aio.");
        }
        paramString = paramQQAppInterface.b().a(paramString, paramInt1, new int[] { -2039 }, 20);
      }
      else
      {
        localObject1 = new ArrayList();
        abhe localabhe = (abhe)paramQQAppInterface.getManager(211);
        paramInt1 = paramString.size() - 1;
        if (paramInt1 >= 0)
        {
          Object localObject2 = (MessageRecord)paramString.get(paramInt1);
          if (!(localObject2 instanceof MessageForApollo)) {}
          for (;;)
          {
            paramInt1 -= 1;
            break;
            localObject2 = (MessageForApollo)localObject2;
            if ((((MessageForApollo)localObject2).gameId == paramInt2) && (((MessageForApollo)localObject2).roomId == paramLong))
            {
              ((List)localObject1).add(localObject2);
              ((MessageForApollo)localObject2).gameStatus = 1;
              if (YD()) {
                localabhe.a().e((MessageForApollo)localObject2);
              }
              ApolloGameUtil.a(paramQQAppInterface, (MessageForApollo)localObject2);
            }
            else if (((MessageForApollo)localObject2).gameStatus == 0)
            {
              ((MessageForApollo)localObject2).gameStatus = 3;
              ApolloGameUtil.a(paramQQAppInterface, (MessageForApollo)localObject2);
              if (YD()) {
                localabhe.a().e((MessageForApollo)localObject2);
              }
            }
          }
        }
        return localObject1;
        label311:
        paramString = (String)localObject1;
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    ((abhh)paramQQAppInterface.getManager(153)).a().et(paramString1, paramString2);
  }
  
  public static List<MessageForApollo> c(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    Object localObject = paramQQAppInterface.b().k(paramString, paramInt);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      if (!QLog.isColorLevel()) {
        break label197;
      }
      QLog.d("CmGameTemp_CmGameSessionUtil", 2, "in aio, cache size:" + ((List)localObject).size());
      paramQQAppInterface = (QQAppInterface)localObject;
    }
    for (;;)
    {
      if ((paramQQAppInterface == null) || (paramQQAppInterface.size() == 0))
      {
        QLog.i("CmGameTemp_CmGameSessionUtil", 2, "msgRcd size is 0.");
        return null;
        if (QLog.isColorLevel()) {
          QLog.d("CmGameTemp_CmGameSessionUtil", 2, "NOT in aio.");
        }
        paramQQAppInterface = paramQQAppInterface.b().a(paramString, paramInt, new int[] { -2039 }, 20);
      }
      else
      {
        paramString = new ArrayList();
        paramInt = paramQQAppInterface.size() - 1;
        if (paramInt >= 0)
        {
          localObject = (MessageRecord)paramQQAppInterface.get(paramInt);
          if (!(localObject instanceof MessageForApollo)) {}
          for (;;)
          {
            paramInt -= 1;
            break;
            paramString.add((MessageForApollo)localObject);
          }
        }
        return paramString;
        label197:
        paramQQAppInterface = (QQAppInterface)localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abmh
 * JD-Core Version:    0.7.0.1
 */