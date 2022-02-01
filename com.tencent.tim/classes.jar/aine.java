import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.mobileqq.data.MessageForLimitChatTopic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.limitchat.LimitChatUtil.3;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aine
{
  public static int FF()
  {
    return 16001;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, aftr paramaftr, long paramLong, int paramInt)
  {
    return a(paramQQAppInterface, paramaftr, paramLong, paramInt, 1044);
  }
  
  public static long a(QQAppInterface paramQQAppInterface, aftr paramaftr, long paramLong, int paramInt1, int paramInt2)
  {
    if ((paramQQAppInterface == null) || (paramaftr == null)) {
      return -1L;
    }
    int i = -4023;
    if (paramInt1 != 1)
    {
      paramInt1 = i;
      if (paramInt2 != 1045) {}
    }
    else
    {
      paramInt1 = -4024;
    }
    MessageForLimitChatTopic localMessageForLimitChatTopic = (MessageForLimitChatTopic)anbi.d(paramInt1);
    Object localObject = paramQQAppInterface.b().f(paramaftr.bFC, paramInt2);
    if ((localObject != null) && (!((List)localObject).isEmpty())) {}
    for (long l = ((ChatMessage)((List)localObject).get(((List)localObject).size() - 1)).shmsgseq + 1L;; l = Math.abs(new Random().nextInt()))
    {
      paramLong -= 5L;
      localMessageForLimitChatTopic.init(paramQQAppInterface.getCurrentAccountUin(), paramaftr.bFC, paramQQAppInterface.getCurrentAccountUin(), paramaftr.tipsWording, paramLong, paramInt1, paramInt2, l);
      localMessageForLimitChatTopic.isread = true;
      localMessageForLimitChatTopic.shmsgseq = l;
      localObject = new JSONObject();
      a((JSONObject)localObject, paramaftr);
      localMessageForLimitChatTopic.saveExtInfoToExtStr("match_chat_msg_data_key", ((JSONObject)localObject).toString());
      if (QLog.isDevelopLevel()) {
        QLog.i("LimitChatUtil", 4, String.format(Locale.getDefault(), "addTopicMessage in seq %s  time %s", new Object[] { Long.valueOf(l), Long.valueOf(paramLong) }));
      }
      if (!achp.a(paramQQAppInterface, localMessageForLimitChatTopic, false))
      {
        paramQQAppInterface.b().b(localMessageForLimitChatTopic, localMessageForLimitChatTopic.selfuin);
        if (QLog.isDevelopLevel()) {
          QLog.i("LimitChatUtil", 4, String.format(Locale.getDefault(), "addTopicMessage in 2", new Object[0]));
        }
      }
      return localMessageForLimitChatTopic.time;
    }
  }
  
  private static Intent a(Context paramContext, String paramString1, String paramString2, Long paramLong, String paramString3, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatUtil", 2, "makeIntent, uin:" + paramString1 + " nick:" + paramString2 + " timestamp:" + paramLong + " topic:" + paramString3);
    }
    paramContext = new Intent(paramContext, ChatActivity.class);
    paramContext.putExtra("uin", paramString1);
    paramContext.putExtra("uinname", paramString2);
    paramContext.putExtra("uintype", 1044);
    if (paramInt == 0) {
      paramContext.putExtra("entrance", 21);
    }
    for (;;)
    {
      paramContext.putExtra("key_limitchat_auto_open", true);
      paramString1 = new Bundle();
      paramString1.putInt("key_limitchat_from_type", paramInt);
      paramContext.putExtras(paramString1);
      return paramContext;
      paramContext.putExtra("entrance", 20);
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, Long paramLong, String paramString3, int paramInt)
  {
    paramActivity.startActivityForResult(a(paramActivity, paramString1, paramString2, paramLong, paramString3, paramInt), FF());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, boolean paramBoolean, MessageRecord paramMessageRecord, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LimitChatUtil", 2, String.format("addGrayTipsMessage frdUin:%s msg:%s ", new Object[] { paramString1, aqft.pk(paramString3) }));
    }
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1))) {}
    do
    {
      return;
      l = anaz.gQ();
      if ((paramBoolean) || (paramMessageRecord == null) || (!a(paramQQAppInterface, paramString1, paramInt2, paramMessageRecord))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("LimitChatUtil", 2, String.format("addGrayTipsMessage last tip message is same", new Object[0]));
    return;
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatUtil", 2, String.format("addGrayTipsMessage start add tip message", new Object[0]));
    }
    paramString1 = new ahwa(paramString1, paramQQAppInterface.getCurrentAccountUin(), paramString3, paramInt1, -5020, paramInt2, l);
    paramString1.wording = paramString3;
    if (paramMessageRecord != null) {}
    for (long l = paramMessageRecord.shmsgseq;; l = Math.abs(new Random().nextInt()))
    {
      if (!TextUtils.isEmpty(paramString4))
      {
        paramMessageRecord = new Bundle();
        paramInt1 = paramString3.indexOf(paramString4);
        if (paramInt1 >= 0)
        {
          paramInt2 = paramString4.length();
          paramMessageRecord.putInt("key_action", paramInt3);
          paramMessageRecord.putString("textColor", "#1e6fff");
          paramMessageRecord.putString("key_action_DATA", paramString2);
          paramMessageRecord.putString("key_a_action_DATA", paramInt4 + "");
          paramString1.addHightlightItem(paramInt1, paramInt2 + paramInt1, paramMessageRecord);
        }
      }
      paramString2 = new MessageForUniteGrayTip();
      paramString2.initGrayTipMsg(paramQQAppInterface, paramString1);
      paramString2.isread = true;
      paramString2.shmsgseq = l;
      paramString2.mNeedTimeStamp = true;
      paramString2.updateUniteGrayTipMsgData(paramQQAppInterface);
      paramQQAppInterface.b().b(paramString2, paramQQAppInterface.getCurrentAccountUin());
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    afsi localafsi = (afsi)paramQQAppInterface.getManager(264);
    ExtendFriendUserInfo localExtendFriendUserInfo = localafsi.a(paramString1, true);
    paramQQAppInterface = localExtendFriendUserInfo;
    if (localExtendFriendUserInfo == null) {
      paramQQAppInterface = new ExtendFriendUserInfo();
    }
    paramQQAppInterface.uin = paramString1;
    if (paramBoolean) {}
    for (paramString1 = "{}";; paramString1 = null)
    {
      paramQQAppInterface.miniProfileMsg = paramString1;
      paramQQAppInterface.tagID = paramInt;
      paramQQAppInterface.tagName = paramString2;
      localafsi.a(paramQQAppInterface);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, String paramString2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, int paramInt3)
  {
    afsi localafsi = (afsi)paramQQAppInterface.getManager(264);
    ExtendFriendUserInfo localExtendFriendUserInfo = localafsi.a(paramString1, true);
    paramQQAppInterface = localExtendFriendUserInfo;
    if (localExtendFriendUserInfo == null) {
      paramQQAppInterface = new ExtendFriendUserInfo();
    }
    paramQQAppInterface.uin = paramString1;
    if (paramBoolean1)
    {
      paramString1 = "{}";
      paramQQAppInterface.miniProfileMsg = paramString1;
      paramQQAppInterface.tagID = paramInt1;
      paramQQAppInterface.tagName = paramString2;
      paramQQAppInterface.distance = paramInt2;
      if ((!paramBoolean2) || (paramInt2 < 0)) {
        break label109;
      }
    }
    label109:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      paramQQAppInterface.showDistanceHLight = paramBoolean1;
      paramQQAppInterface.fromType = paramInt3;
      localafsi.a(paramQQAppInterface);
      return;
      paramString1 = null;
      break;
    }
  }
  
  private static void a(JSONObject paramJSONObject, aftr paramaftr)
  {
    JSONArray localJSONArray;
    Iterator localIterator;
    Object localObject;
    JSONObject localJSONObject;
    boolean bool;
    try
    {
      if (paramaftr.tipsWording != null) {
        paramJSONObject.put("topic_msg", paramaftr.tipsWording);
      }
      if (paramaftr.a != null)
      {
        if (paramaftr.a.bFu != null) {
          paramJSONObject.put("age", paramaftr.a.bFu);
        }
        paramJSONObject.put("gender", paramaftr.a.mGender);
        paramJSONObject.put("matchTagId", paramaftr.tagId);
        paramJSONObject.put("matchTagName", paramaftr.tagName);
        if (paramaftr.a.constellation != null) {
          paramJSONObject.put("constellation", paramaftr.a.constellation);
        }
        if (paramaftr.a.bFv != null) {
          paramJSONObject.put("school", paramaftr.a.bFv);
        }
        if (paramaftr.a.company != null) {
          paramJSONObject.put("company", paramaftr.a.company);
        }
        if (paramaftr.a.city != null) {
          paramJSONObject.put("city", paramaftr.a.city);
        }
        if (paramaftr.a.mDeclaration != null) {
          paramJSONObject.put("declaration", paramaftr.a.mDeclaration);
        }
        if (paramaftr.a.mVoiceUrl != null) {
          paramJSONObject.put("voiceUrl", paramaftr.a.mVoiceUrl);
        }
        paramJSONObject.put("voiceDuration", paramaftr.a.mVoiceDuration);
        if (paramaftr.a.bFw != null) {
          paramJSONObject.put("signWords", paramaftr.a.bFw);
        }
        if (paramaftr.a.wr != null)
        {
          localJSONArray = new JSONArray();
          localIterator = paramaftr.a.wr.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label432;
            }
            localObject = (afty)localIterator.next();
            if (((afty)localObject).tagName != null)
            {
              localJSONObject = new JSONObject();
              localJSONObject.put("tagName", ((afty)localObject).tagName);
              if (((afty)localObject).cUr == 0) {
                break;
              }
              bool = true;
              localJSONObject.put("tagSame", bool);
              localJSONArray.put(localJSONObject);
            }
          }
        }
      }
      else
      {
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("LimitChatUtil", 4, "initProfileJSON " + paramJSONObject);
      }
    }
    label432:
    do
    {
      bool = false;
      break;
      if (localJSONArray.length() > 0) {
        paramJSONObject.put("personalTags", localJSONArray);
      }
      paramJSONObject.put("popular", paramaftr.a.XK);
      if (paramaftr.a.ws != null)
      {
        localJSONArray = new JSONArray();
        localIterator = paramaftr.a.ws.iterator();
        while (localIterator.hasNext())
        {
          localObject = (aftz)localIterator.next();
          if (((aftz)localObject).schoolName != null)
          {
            localJSONObject = new JSONObject();
            localJSONObject.put("shcool_name", ((aftz)localObject).schoolName);
            localJSONObject.put("shcool_state", ((aftz)localObject).XL);
            localJSONArray.put(localJSONObject);
          }
        }
        if (localJSONArray.length() > 0) {
          paramJSONObject.put("shcoolInfos", localJSONArray);
        }
      }
    } while (paramaftr.a.distance < 0);
    paramJSONObject.put("distance", paramaftr.a.distance);
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    while ((paramMessageRecord == null) || (!(paramMessageRecord instanceof MessageForUniteGrayTip)) || (((MessageForUniteGrayTip)paramMessageRecord).tipParam.dbK != paramInt)) {
      return false;
    }
    return true;
  }
  
  public static boolean aD(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    while (!kg(paramMessageRecord.istroop)) {
      return false;
    }
    return true;
  }
  
  @Deprecated
  public static boolean aE(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    while (!kh(paramMessageRecord.istroop)) {
      return false;
    }
    return true;
  }
  
  public static void ag(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatUtil", 2, "getLimitChatState in mainprocess");
    }
    aind.a().ag(paramQQAppInterface, paramString);
  }
  
  public static void ah(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("LimitChatUtil", 2, "tryAddRecentUser begin");
          }
          paramQQAppInterface = paramQQAppInterface.a().a();
        } while (paramQQAppInterface == null);
        if (!paramQQAppInterface.kG(paramString)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("LimitChatUtil", 2, "tryAddRecentUser ,find rencentuser");
      return;
      paramString = paramQQAppInterface.a(paramString, 0);
      long l = NetConnInfoCenter.getServerTime();
      if (paramString.lastmsgtime < l) {
        paramString.lastmsgtime = l;
      }
      paramQQAppInterface.e(paramString);
    } while (!QLog.isColorLevel());
    QLog.d("LimitChatUtil", 2, "tryAddRecentUser end");
  }
  
  public static void ai(QQAppInterface paramQQAppInterface, String paramString)
  {
    ((alur)paramQQAppInterface.getManager(285)).OZ(paramString);
  }
  
  public static int e(AppInterface paramAppInterface)
  {
    int j = 0;
    int i;
    if ((paramAppInterface instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatUtil", 2, "getLimitChatState in mainprocess");
      }
      paramAppInterface = (afwh)paramAppInterface.getManager(292);
      if (paramAppInterface == null) {
        break label100;
      }
      i = paramAppInterface.getState();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatUtil", 2, "getLimitChatState :" + i);
      }
      return i;
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("LimitChatUtil", 2, "getLimitChatState in otherprocess,ERROR");
        i = j;
        continue;
        label100:
        i = 0;
      }
    }
  }
  
  @Deprecated
  public static boolean f(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null) {
      return false;
    }
    return kh(paramSessionInfo.cZ);
  }
  
  public static void g(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    ThreadManager.executeOnSubThread(new LimitChatUtil.3(paramQQAppInterface, paramMessageRecord));
  }
  
  public static boolean h(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramQQAppInterface == null) || (paramMessageRecord == null) || (TextUtils.isEmpty(paramMessageRecord.frienduin))) {}
    String str;
    do
    {
      return false;
      int i = e(paramQQAppInterface);
      str = j(paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatUtil", 2, "checkInterceptMessage, current state:" + i + " uin:" + str);
      }
    } while (paramMessageRecord.frienduin.equals(str));
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatUtil", 2, "checkInterceptMessage, intercept");
    }
    ag(paramQQAppInterface, paramMessageRecord.frienduin);
    return true;
  }
  
  public static String j(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatUtil", 2, "getLimitChatUin in mainprocess");
      }
      paramAppInterface = (afwh)paramAppInterface.getManager(292);
      if (paramAppInterface == null) {
        break label96;
      }
      paramAppInterface = paramAppInterface.uK();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatUtil", 2, "getLimitChatUin :" + paramAppInterface);
      }
      return paramAppInterface;
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatUtil", 2, "getLimitChatState in otherprocess");
      }
      paramAppInterface = null;
      continue;
      label96:
      paramAppInterface = null;
    }
  }
  
  public static boolean kf(int paramInt)
  {
    return (paramInt == 3342337) || (paramInt == 3342338) || (paramInt == 3342339);
  }
  
  public static boolean kg(int paramInt)
  {
    return (1044 == paramInt) || (1045 == paramInt);
  }
  
  @Deprecated
  public static boolean kh(int paramInt)
  {
    return 1037 == paramInt;
  }
  
  public static void n(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LimitChatUtil", 2, "startAddFriendActivity " + paramString1 + " " + paramString2 + " " + paramString3);
    }
    paramString3 = ((afsi)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(264)).a(paramString1, false);
    int i = 8;
    if (paramString3 != null) {
      i = ExtendFriendUserInfo.fromTypeToSubID(paramString3.fromType);
    }
    if ((paramContext instanceof Activity))
    {
      paramContext = (Activity)paramContext;
      paramString1 = AddFriendLogicActivity.a(paramContext, 1, paramString1, null, 3094, i, paramString2, null, null, paramContext.getResources().getString(2131691039), null);
      if (paramString1 != null) {
        paramString1.putExtra("entrance", 1);
      }
      paramContext.startActivityForResult(paramString1, 16002);
    }
  }
  
  public static boolean n(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (paramQQAppInterface != null)
    {
      Object localObject = paramQQAppInterface.b().b(paramString, paramInt, null);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        Collections.sort((List)localObject, new ainf());
        localObject = (MessageRecord)((List)localObject).get(((List)localObject).size() - 1);
        if ((localObject instanceof MessageForLimitChatTopic))
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("LimitChatUtil", 4, "clearLastTopicMessage done:" + ((MessageRecord)localObject).msgseq);
          }
          paramQQAppInterface.b().t(paramString, paramInt, ((MessageRecord)localObject).uniseq);
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aine
 * JD-Core Version:    0.7.0.1
 */