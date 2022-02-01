import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.script.SpriteUIHandler;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class abrd
{
  static Map<String, Integer> iZ = new HashMap();
  private abrc c;
  int cqW = -1;
  int cqX = -1;
  private Map<String, Long> iR = new HashMap();
  Map<String, Integer> ja = new HashMap();
  Map<String, String> jb = new ConcurrentHashMap(2);
  
  public abrd(abrc paramabrc)
  {
    this.c = paramabrc;
  }
  
  private abrd.a a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int j = 0;
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null)) {
      return null;
    }
    if (this.ja.containsKey(paramString)) {}
    Object localObject1;
    Object localObject2;
    for (int i = ((Integer)this.ja.get(paramString)).intValue();; i = 0)
    {
      localObject1 = (abhh)paramQQAppInterface.getManager(153);
      localObject2 = ((abhh)localObject1).g(paramQQAppInterface, paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      return null;
    }
    for (;;)
    {
      try
      {
        Object localObject3 = new JSONArray((String)localObject2);
        if (((JSONArray)localObject3).length() <= 0) {
          return null;
        }
        if (i >= ((JSONArray)localObject3).length())
        {
          i = j;
          localObject2 = new abrd.a();
          localObject3 = ((JSONArray)localObject3).getJSONObject(i);
          ((abrd.a)localObject2).cqW = ((JSONObject)localObject3).getInt("type");
          ((abrd.a)localObject2).actionId = ((JSONObject)localObject3).getInt("id");
          localObject3 = ((abhh)localObject1).b(paramString);
          if (localObject3 == null) {
            return null;
          }
          if ((((abrd.a)localObject2).cqW == 4) && (!((ApolloBaseInfo)localObject3).hasPet))
          {
            ((ApolloBaseInfo)localObject3).appearAction = null;
            ((abhh)localObject1).a((ApolloBaseInfo)localObject3);
            return null;
          }
          if (QLog.isColorLevel()) {
            QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "[hasAppearAction] index:", Integer.valueOf(i), ",id:", Integer.valueOf(((abrd.a)localObject2).actionId), ",standType:", Integer.valueOf(((abrd.a)localObject2).cqW) });
          }
          if (((abrd.a)localObject2).actionId <= 0)
          {
            QLog.e("cmshow_scripted_SpriteRscBuilder", 1, new Object[] { "appearAction not correct,actionId:", Integer.valueOf(((abrd.a)localObject2).actionId) });
            return null;
          }
          if (!ApolloUtil.aF(((abrd.a)localObject2).actionId, 0))
          {
            if (QLog.isColorLevel()) {
              QLog.i("cmshow_scripted_SpriteRscBuilder", 2, "hasAppearAction isActionResDone is false.");
            }
            paramString = new ApolloActionData();
            paramString.actionId = ((abrd.a)localObject2).actionId;
            localObject1 = ApolloUtil.a(paramString, 5);
            abto.b(paramQQAppInterface, ApolloUtil.a(paramString, 4), (String)localObject1);
            return null;
          }
          this.ja.put(paramString, Integer.valueOf(i + 1));
          return localObject2;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("cmshow_scripted_SpriteRscBuilder", 2, "hasAppearAction error:", paramQQAppInterface);
        return null;
      }
    }
  }
  
  private SpriteTaskParam a(abrd.a parama)
  {
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    if (parama == null)
    {
      localSpriteTaskParam.mActionId = 4;
      localSpriteTaskParam.crh = 2;
      localSpriteTaskParam.crd = 5;
      localSpriteTaskParam.mMsgId = 1000000L;
    }
    do
    {
      return localSpriteTaskParam;
      localSpriteTaskParam.mTaskId = 1;
      localSpriteTaskParam.mActionId = parama.actionId;
      localSpriteTaskParam.crh = 12;
      localSpriteTaskParam.crd = 5;
      localSpriteTaskParam.mMsgId = 1000000L;
    } while (parama.cqW != 4);
    localSpriteTaskParam.mActionType = 7;
    return localSpriteTaskParam;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return "";
    }
    boolean bool1 = ((abhh)paramQQAppInterface.getManager(153)).jm(paramString);
    boolean bool2 = paramString.equals(paramQQAppInterface.getCurrentAccountUin());
    int i = abrj.a(paramInt, bool2, bool1, 1, paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "getNicknamePath uin:", ApolloUtil.iY(paramString), ", isMe:", Boolean.valueOf(bool2), ",isYellowVip:", Boolean.valueOf(bool1), ",isRight:", Boolean.valueOf(paramBoolean), ",bubbleId:", Integer.valueOf(i) });
    }
    return abvg.i(paramInt, i, abhh.h(paramQQAppInterface, paramString));
  }
  
  private String a(boolean paramBoolean, String paramString, int paramInt)
  {
    boolean bool2 = false;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    boolean bool1;
    try
    {
      Object localObject2 = new JSONObject(paramString).optJSONObject("action");
      Object localObject1;
      if (paramBoolean)
      {
        localObject1 = ((JSONObject)localObject2).optString("actionId");
        if (((JSONObject)localObject2).optInt("actionPlatform") <= 0) {
          break label249;
        }
        bool1 = true;
        break label246;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          if (!paramBoolean) {
            bool2 = true;
          }
          if (ApolloUtil.a(paramInt, bool2, Integer.parseInt((String)localObject1), bool1))
          {
            localObject2 = File.separator + (String)localObject1;
            localObject1 = localObject2;
            if (bool1) {
              localObject1 = (String)localObject2 + File.separator + "android";
            }
            return (String)localObject1 + File.separator + "action";
          }
        }
      }
      else
      {
        localObject1 = ((JSONObject)localObject2).optString("actionPeerId");
        int i = ((JSONObject)localObject2).optInt("actionPeerPlatform");
        if (i > 0) {}
        for (bool1 = true;; bool1 = false) {
          break;
        }
      }
      return null;
    }
    catch (Exception localException)
    {
      QLog.e("cmshow_scripted_SpriteRscBuilder", 1, "[random] the json is not right," + paramString);
    }
    for (;;)
    {
      label246:
      break;
      label249:
      bool1 = false;
    }
  }
  
  private JSONArray a(SpriteTaskParam paramSpriteTaskParam)
  {
    if ((paramSpriteTaskParam == null) || (this.c == null)) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray();
        JSONObject localJSONObject2 = a(paramSpriteTaskParam.mSenderUin, this.c, paramSpriteTaskParam, true, false);
        if ((this.c.mAioType == 0) || (paramSpriteTaskParam.crb == 1))
        {
          localJSONObject1 = a(paramSpriteTaskParam.bbE, this.c, paramSpriteTaskParam, false, false);
          if (localJSONObject2 != null)
          {
            localJSONArray.put(localJSONObject2);
            JSONObject localJSONObject3 = b(paramSpriteTaskParam.mSenderUin, this.c, true);
            if (localJSONObject3 != null) {
              localJSONObject2.put("pet", localJSONObject3);
            }
          }
          if (localJSONObject1 != null)
          {
            localJSONArray.put(localJSONObject1);
            paramSpriteTaskParam = b(paramSpriteTaskParam.bbE, this.c, false);
            if (paramSpriteTaskParam != null) {
              localJSONObject1.put("pet", paramSpriteTaskParam);
            }
          }
          return localJSONArray;
        }
      }
      catch (Throwable paramSpriteTaskParam)
      {
        QLog.e("cmshow_scripted_SpriteRscBuilder", 1, "[getBasicActionJs],", paramSpriteTaskParam);
        return null;
      }
      finally
      {
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "[getBasicActionJs], cost:", Long.valueOf(l2 - l1) });
        }
      }
      JSONObject localJSONObject1 = null;
    }
  }
  
  public static JSONArray a(QQAppInterface paramQQAppInterface, JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramQQAppInterface == null)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteRscBuilder", 2, "[getActionJson]");
    }
    for (;;)
    {
      JSONArray localJSONArray1;
      int j;
      boolean bool2;
      try
      {
        localJSONArray1 = new JSONArray();
        paramJSONObject = paramJSONObject.optString("actionList");
        JSONArray localJSONArray2 = new JSONArray(paramJSONObject);
        if ((localJSONArray2 == null) || (localJSONArray2.length() == 0)) {
          break label504;
        }
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "ReqAction,", paramJSONObject });
        }
        abxk localabxk = (abxk)paramQQAppInterface.getManager(155);
        int i = 0;
        j = 0;
        if (j < localJSONArray2.length())
        {
          paramJSONObject = localJSONArray2.getJSONObject(j);
          if (paramJSONObject == null) {
            break label507;
          }
          int k = paramJSONObject.optInt("actionId");
          int m = paramJSONObject.optInt("perNum");
          if (QLog.isColorLevel()) {
            QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "ReqAction,actId:", Integer.valueOf(k), ",perNum:", Integer.valueOf(m) });
          }
          if (-1 == m)
          {
            paramJSONObject = localabxk.a(k);
            if (paramJSONObject != null) {
              break label501;
            }
            QLog.i("cmshow_scripted_SpriteRscBuilder", 1, "ReqAction,[getActionsPath], warning: data is null. call checkApolloPanelJsonVer, id:" + k);
            if (i == 0)
            {
              aczo.r(paramQQAppInterface, 1);
              i = 1;
              break label507;
            }
          }
          else
          {
            paramJSONObject = new ApolloActionData();
            paramJSONObject.actionId = k;
            paramJSONObject.personNum = m;
            bool2 = ApolloUtil.aF(k, paramJSONObject.personNum);
            Object localObject = (abhh)paramQQAppInterface.getManager(153);
            if (bool2) {
              break label495;
            }
            bool1 = ((abhh)localObject).a(paramJSONObject, 4, null);
            if (!QLog.isColorLevel()) {
              break label514;
            }
            QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "ReqAction,isActionDone:", Boolean.valueOf(bool2), ",ret:", Boolean.valueOf(bool1) });
            break label514;
            localObject = new JSONObject();
            String[] arrayOfString = abvg.a(1, k, 0, true);
            ((JSONObject)localObject).put("actionId", k);
            ((JSONObject)localObject).put("actionPath", abvg.ab(arrayOfString[0], 3));
            if (paramJSONObject.personNum == 1) {
              ((JSONObject)localObject).put("peerPath", abvg.ab(abvg.a(1, k, 0, false)[0], 3));
            }
            localJSONArray1.put(localObject);
            if (QLog.isColorLevel()) {
              QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "ReqAction,put into array, id:", Integer.valueOf(k) });
            }
          }
          break label507;
        }
        else
        {
          return localJSONArray1;
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.e("cmshow_scripted_SpriteRscBuilder", 1, paramQQAppInterface, new Object[0]);
        return null;
      }
      label495:
      boolean bool1 = false;
      continue;
      label501:
      continue;
      label504:
      return localJSONArray1;
      label507:
      j += 1;
      continue;
      label514:
      if (!bool2) {
        if (!bool1) {}
      }
    }
  }
  
  private JSONObject a(String paramString, abrc paramabrc, SpriteTaskParam paramSpriteTaskParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    JSONObject localJSONObject;
    for (;;)
    {
      int j;
      try
      {
        localJSONObject = a(paramString, paramabrc, abrj.a(paramString, paramSpriteTaskParam, paramabrc, paramBoolean1));
        if (!a(paramSpriteTaskParam)) {
          return localJSONObject;
        }
        j = abhh.h(paramabrc.getApp(), paramString);
        int k = ((Integer)abvg.a(paramString, j, paramabrc.getApp(), true)[0]).intValue();
        paramString = abvg.a(paramString, paramabrc.getApp(), true);
        if ((paramString == null) || (paramString.length != 2)) {
          break label440;
        }
        int m = ((Integer)paramString[0]).intValue();
        if (paramSpriteTaskParam == null) {
          break;
        }
        if (!paramBoolean1) {
          break label444;
        }
        i = 1;
        localJSONObject.put("isMaster", i);
        if ((paramBoolean1) && (!TextUtils.isEmpty(paramSpriteTaskParam.bhv)))
        {
          localJSONObject.put("text", abrj.replaceBlank(aqgo.encodeToString(paramSpriteTaskParam.bhv.getBytes("utf-8"), 0)));
          if (paramSpriteTaskParam.bEW) {
            continue;
          }
          localJSONObject.put("bubbleType", 0);
          if ((j == 1) && (paramSpriteTaskParam.mActionId > abxi.ctt) && (abhh.R(paramabrc.getApp())))
          {
            i = 2;
            localJSONObject.put("bubble", f(paramSpriteTaskParam.bhv, m, i));
          }
        }
        else
        {
          int n = paramSpriteTaskParam.crh;
          int i1 = paramSpriteTaskParam.mActionId;
          i = m;
          if (k >= 0) {
            i = k;
          }
          paramString = abvg.a(n, i1, i, paramBoolean1, j);
          if (paramString == null) {
            break label442;
          }
          if (paramString.length >= 2) {
            break label323;
          }
          break label442;
        }
        if ((j != 2) || (paramSpriteTaskParam.mActionId >= abxi.ctt)) {
          break label433;
        }
        i = 1;
        continue;
        localJSONObject.put("bubbleType", 1);
        continue;
        if (paramSpriteTaskParam.crb != 0) {
          break label350;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("cmshow_scripted_SpriteRscBuilder", 1, paramString, new Object[0]);
        return null;
      }
      label323:
      if ((paramabrc.mAioType == 0) && (!paramBoolean1) && (!paramBoolean2)) {
        break;
      }
      label350:
      paramabrc = paramString[0];
      paramString = paramabrc;
      if (8 == paramSpriteTaskParam.mActionType)
      {
        paramString = paramabrc;
        if (!TextUtils.isEmpty(paramSpriteTaskParam.bhw))
        {
          paramSpriteTaskParam = a(paramBoolean1, paramSpriteTaskParam.bhw, paramSpriteTaskParam.mActionId);
          paramString = paramabrc;
          if (!TextUtils.isEmpty(paramSpriteTaskParam)) {
            paramString = paramabrc + paramSpriteTaskParam;
          }
        }
      }
      localJSONObject.put("action", paramString);
      break;
      label433:
      int i = j;
      continue;
      label440:
      return null;
      label442:
      return null;
      label444:
      i = 0;
    }
    return localJSONObject;
  }
  
  private JSONObject a(String paramString, abrc paramabrc, boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("uin", paramString);
      abvg.a(paramString, paramabrc.getApp(), localJSONObject);
      Object localObject = abvg.a(paramString, paramabrc.getApp(), true);
      if ((localObject == null) || (localObject.length != 2))
      {
        abrj.j(301, new Object[] { "roleInfos is null" });
        return null;
      }
      int j = ((Integer)localObject[0]).intValue();
      localObject = (int[])localObject[1];
      if ((localObject == null) || (localObject.length == 0))
      {
        abrj.j(301, new Object[] { "dressInfo is null" });
        return null;
      }
      JSONArray localJSONArray = new JSONArray();
      int k = localObject.length;
      int i = 0;
      while (i < k)
      {
        localJSONArray.put(abvg.z(1, Integer.valueOf(localObject[i]).intValue()));
        i += 1;
      }
      localJSONObject.put("dress", localJSONArray);
      localJSONObject.put("role", abvg.z(0, j));
      if (((paramabrc.mAioType == 1) || (paramabrc.mAioType == 3000)) && (!"-1".equals(paramString)) && (!"-2".equals(paramString)))
      {
        localJSONObject.put("nameplate", a(paramabrc.getApp(), paramString, j, paramBoolean));
        localObject = paramabrc.mSelfUin;
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).equals(paramString))) {
          break label395;
        }
      }
      label395:
      for (paramString = acfp.m(2131714732);; paramString = abrj.a(paramabrc.getApp(), paramabrc.mAioType, paramString, paramabrc.mFriendUin, true))
      {
        if (!TextUtils.isEmpty(paramString)) {
          localJSONObject.put("nickname", abrj.replaceBlank(aqgo.encodeToString(paramString.getBytes("utf-8"), 0)));
        }
        if (this.c.a == null) {
          break;
        }
        localJSONObject.put("scale", this.c.a.scale);
        localJSONObject.put("xPos", this.c.a.xPos);
        localJSONObject.put("yPos", this.c.a.bU);
        break;
      }
      return localJSONObject;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmshow_scripted_SpriteRscBuilder", 1, paramString, new Object[0]);
      return null;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, int[] paramArrayOfInt, abxt.a parama)
  {
    if (paramArrayOfInt == null) {
      return;
    }
    int i;
    if (paramInt == 0)
    {
      QLog.i("cmshow_scripted_SpriteRscBuilder", 1, "role id is 0, uin:" + ApolloUtil.iY(paramString));
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        abxt.a(-1L, paramQQAppInterface, paramString, "", 0, "", parama);
        return;
        i = 0;
        for (;;)
        {
          if (i >= paramArrayOfInt.length) {
            break label152;
          }
          if (!ApolloUtil.ig(paramArrayOfInt[i]))
          {
            QLog.w("cmshow_scripted_SpriteRscBuilder", 2, "dress rsc NOT exist, id:" + paramArrayOfInt[i]);
            i = 1;
            break;
          }
          i += 1;
        }
      }
      if (parama == null) {
        break;
      }
      parama.a(-1L, paramQQAppInterface, paramString, "", "", paramInt, paramArrayOfInt, 10);
      return;
      label152:
      i = 0;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, abto.e parame)
  {
    int i;
    if (!ApolloUtil.jO(paramString))
    {
      i = 1;
      if (i == 0) {
        break label25;
      }
      abto.a(paramQQAppInterface, paramString, parame);
    }
    label25:
    while (parame == null)
    {
      return;
      i = 0;
      break;
    }
    parame.aR(true, 0);
  }
  
  public static Pair<String, Integer> b(String paramString, int paramInt)
  {
    Pair localPair = null;
    if (TextUtils.isEmpty(paramString)) {
      paramString = localPair;
    }
    int i;
    String str;
    do
    {
      do
      {
        return paramString;
        i = ApolloUtil.a(248.0F, paramString, paramInt);
        if (ApolloUtil.aJ(0, i)) {
          break;
        }
        paramString = localPair;
      } while (!QLog.isColorLevel());
      QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "getQzoneBubbleRsc, bubble res not exist bubbleId=", Integer.valueOf(i) });
      return null;
      str = abvg.i(0, i, paramInt);
      localPair = new Pair(str, Integer.valueOf(i));
      paramString = localPair;
    } while (!QLog.isColorLevel());
    QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "getQzoneBubbleRsc, bubbleId=", Integer.valueOf(i), ", bubbleRsc=", str });
    return localPair;
  }
  
  public static String b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if ((!ApolloUtil.aJ(paramInt1, paramInt2)) && (!ApolloUtil.aJ(0, paramInt2))) {
      return "";
    }
    return abvg.i(paramInt1, paramInt2, paramInt3);
  }
  
  private JSONArray b(SpriteTaskParam paramSpriteTaskParam)
  {
    if ((paramSpriteTaskParam == null) || (this.c == null)) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    for (;;)
    {
      int k;
      int m;
      try
      {
        localJSONArray = new JSONArray();
        paramSpriteTaskParam = paramSpriteTaskParam.sM;
        localabxk = (abxk)this.c.getApp().getManager(155);
        i = 0;
        k = 0;
        j = -1;
        if (k < paramSpriteTaskParam.size())
        {
          m = ((Integer)paramSpriteTaskParam.get(k)).intValue();
          if (-1 != j)
          {
            localObject = localabxk.a(j);
            if ((localObject != null) && (((ApolloActionData)localObject).isHasPostAction()) && (j != m))
            {
              localObject = e(j, 2);
              if (localObject != null) {
                localJSONArray.put(localObject);
              }
            }
          }
          Object localObject = localabxk.a(m);
          if (localObject != null)
          {
            if ((m != j) && (((ApolloActionData)localObject).isHasPreAction()))
            {
              localObject = e(m, 0);
              if (localObject != null) {
                localJSONArray.put(localObject);
              }
            }
            localObject = e(m, 1);
            if (localObject == null) {
              break label431;
            }
            localJSONArray.put(localObject);
            break label431;
          }
          j = -1;
          i = 1;
          QLog.i("cmshow_scripted_SpriteRscBuilder", 1, "[insertPrePost], action NOT exist locally, id:" + m);
        }
      }
      catch (Throwable paramSpriteTaskParam)
      {
        JSONArray localJSONArray;
        abxk localabxk;
        int i;
        QLog.e("cmshow_scripted_SpriteRscBuilder", 1, "[getWhiteFaceActions],", paramSpriteTaskParam);
        return null;
        if (-1 != j)
        {
          paramSpriteTaskParam = localabxk.a(j);
          if ((paramSpriteTaskParam != null) && (paramSpriteTaskParam.isHasPostAction()))
          {
            paramSpriteTaskParam = e(j, 2);
            if (paramSpriteTaskParam != null) {
              localJSONArray.put(paramSpriteTaskParam);
            }
          }
        }
        if (i != 0) {
          aczo.r(this.c.getApp(), 1);
        }
        return localJSONArray;
      }
      finally
      {
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "[getWhiteFaceActions], cost:", Long.valueOf(l2 - l1) });
        }
      }
      label431:
      int j = m;
      k += 1;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt, int[] paramArrayOfInt, abxt.a parama)
  {
    int k = 0;
    if (paramArrayOfInt == null) {}
    do
    {
      return;
      int i = 0;
      for (;;)
      {
        int j = k;
        if (i < paramArrayOfInt.length)
        {
          if (!ApolloUtil.ig(paramArrayOfInt[i]))
          {
            QLog.w("cmshow_scripted_SpriteRscBuilder", 2, "checkThreeDressRsc rsc NOT exist, id:" + paramArrayOfInt[i]);
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            break;
          }
          c(paramQQAppInterface, paramString, paramInt, paramArrayOfInt, parama);
          return;
        }
        i += 1;
      }
    } while (parama == null);
    parama.a(-1L, paramQQAppInterface, paramString, "", "", paramInt, paramArrayOfInt, 10);
  }
  
  static String c(String paramString, int paramInt, boolean paramBoolean)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder("def/role/0/Bubble/");
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONArray(paramString);
        int j = paramString.length();
        if (i < j)
        {
          JSONObject localJSONObject = paramString.getJSONObject(i);
          int k = localJSONObject.optInt("roleId", -1);
          if ((k == -1) || (k != paramInt)) {
            continue;
          }
          if (!paramBoolean) {
            continue;
          }
          paramString = "namePlateIdRight";
          localStringBuilder.append(localJSONObject.optInt(paramString, 0));
        }
        localStringBuilder.append("/dress");
      }
      catch (Exception paramString)
      {
        QLog.e("ApolloPet", 1, "getPetNamePlate error:", paramString);
        continue;
      }
      return localStringBuilder.toString();
      paramString = "namePlateIdLeft";
      continue;
      i += 1;
    }
  }
  
  /* Error */
  private JSONArray c(SpriteTaskParam paramSpriteTaskParam)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: getfield 49	abrd:c	Labrc;
    //   8: ifnonnull +7 -> 15
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_1
    //   14: areturn
    //   15: invokestatic 321	java/lang/System:currentTimeMillis	()J
    //   18: lstore_2
    //   19: new 88	org/json/JSONArray
    //   22: dup
    //   23: invokespecial 322	org/json/JSONArray:<init>	()V
    //   26: astore 6
    //   28: aload_0
    //   29: getfield 49	abrd:c	Labrc;
    //   32: getfield 333	abrc:mAioType	I
    //   35: ifne +163 -> 198
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 49	abrd:c	Labrc;
    //   43: getfield 522	abrc:mSelfUin	Ljava/lang/String;
    //   46: aload_0
    //   47: getfield 49	abrd:c	Labrc;
    //   50: iconst_1
    //   51: invokespecial 425	abrd:a	(Ljava/lang/String;Labrc;Z)Lorg/json/JSONObject;
    //   54: astore_1
    //   55: aload_0
    //   56: aload_0
    //   57: getfield 49	abrd:c	Labrc;
    //   60: getfield 556	abrc:mFriendUin	Ljava/lang/String;
    //   63: aload_0
    //   64: getfield 49	abrd:c	Labrc;
    //   67: iconst_0
    //   68: invokespecial 425	abrd:a	(Ljava/lang/String;Labrc;Z)Lorg/json/JSONObject;
    //   71: astore 7
    //   73: aload_0
    //   74: aload_0
    //   75: getfield 49	abrd:c	Labrc;
    //   78: getfield 522	abrc:mSelfUin	Ljava/lang/String;
    //   81: aload_0
    //   82: getfield 49	abrd:c	Labrc;
    //   85: iconst_1
    //   86: invokevirtual 345	abrd:b	(Ljava/lang/String;Labrc;Z)Lorg/json/JSONObject;
    //   89: astore 8
    //   91: aload_0
    //   92: aload_0
    //   93: getfield 49	abrd:c	Labrc;
    //   96: getfield 556	abrc:mFriendUin	Ljava/lang/String;
    //   99: aload_0
    //   100: getfield 49	abrd:c	Labrc;
    //   103: iconst_0
    //   104: invokevirtual 345	abrd:b	(Ljava/lang/String;Labrc;Z)Lorg/json/JSONObject;
    //   107: astore 9
    //   109: aload 8
    //   111: ifnull +13 -> 124
    //   114: aload_1
    //   115: ldc_w 347
    //   118: aload 8
    //   120: invokevirtual 350	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   123: pop
    //   124: aload 9
    //   126: ifnull +14 -> 140
    //   129: aload 7
    //   131: ldc_w 347
    //   134: aload 9
    //   136: invokevirtual 350	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   139: pop
    //   140: aload 6
    //   142: aload_1
    //   143: invokevirtual 342	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   146: pop
    //   147: aload 6
    //   149: aload 7
    //   151: invokevirtual 342	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   154: pop
    //   155: invokestatic 321	java/lang/System:currentTimeMillis	()J
    //   158: lstore 4
    //   160: aload 6
    //   162: astore_1
    //   163: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq -153 -> 13
    //   169: ldc 138
    //   171: iconst_2
    //   172: iconst_2
    //   173: anewarray 4	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: ldc_w 670
    //   181: aastore
    //   182: dup
    //   183: iconst_1
    //   184: lload 4
    //   186: lload_2
    //   187: lsub
    //   188: invokestatic 357	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   191: aastore
    //   192: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   195: aload 6
    //   197: areturn
    //   198: aload_0
    //   199: aload_1
    //   200: getfield 325	com/tencent/mobileqq/apollo/script/SpriteTaskParam:mSenderUin	Ljava/lang/String;
    //   203: aload_0
    //   204: getfield 49	abrd:c	Labrc;
    //   207: iconst_1
    //   208: invokespecial 425	abrd:a	(Ljava/lang/String;Labrc;Z)Lorg/json/JSONObject;
    //   211: astore_1
    //   212: aload_0
    //   213: aload_0
    //   214: getfield 49	abrd:c	Labrc;
    //   217: getfield 522	abrc:mSelfUin	Ljava/lang/String;
    //   220: aload_0
    //   221: getfield 49	abrd:c	Labrc;
    //   224: iconst_1
    //   225: invokevirtual 345	abrd:b	(Ljava/lang/String;Labrc;Z)Lorg/json/JSONObject;
    //   228: astore 7
    //   230: aload 7
    //   232: ifnull +13 -> 245
    //   235: aload_1
    //   236: ldc_w 347
    //   239: aload 7
    //   241: invokevirtual 350	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   244: pop
    //   245: aload 6
    //   247: aload_1
    //   248: invokevirtual 342	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   251: pop
    //   252: goto -97 -> 155
    //   255: astore_1
    //   256: ldc 138
    //   258: iconst_1
    //   259: ldc_w 672
    //   262: aload_1
    //   263: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   266: invokestatic 321	java/lang/System:currentTimeMillis	()J
    //   269: lstore 4
    //   271: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   274: ifeq +29 -> 303
    //   277: ldc 138
    //   279: iconst_2
    //   280: iconst_2
    //   281: anewarray 4	java/lang/Object
    //   284: dup
    //   285: iconst_0
    //   286: ldc_w 670
    //   289: aastore
    //   290: dup
    //   291: iconst_1
    //   292: lload 4
    //   294: lload_2
    //   295: lsub
    //   296: invokestatic 357	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   299: aastore
    //   300: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   303: aconst_null
    //   304: areturn
    //   305: astore_1
    //   306: invokestatic 321	java/lang/System:currentTimeMillis	()J
    //   309: lstore 4
    //   311: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   314: ifeq +29 -> 343
    //   317: ldc 138
    //   319: iconst_2
    //   320: iconst_2
    //   321: anewarray 4	java/lang/Object
    //   324: dup
    //   325: iconst_0
    //   326: ldc_w 670
    //   329: aastore
    //   330: dup
    //   331: iconst_1
    //   332: lload 4
    //   334: lload_2
    //   335: lsub
    //   336: invokestatic 357	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   339: aastore
    //   340: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   343: aload_1
    //   344: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	this	abrd
    //   0	345	1	paramSpriteTaskParam	SpriteTaskParam
    //   18	317	2	l1	long
    //   158	175	4	l2	long
    //   26	220	6	localJSONArray	JSONArray
    //   71	169	7	localJSONObject1	JSONObject
    //   89	30	8	localJSONObject2	JSONObject
    //   107	28	9	localJSONObject3	JSONObject
    // Exception table:
    //   from	to	target	type
    //   19	109	255	java/lang/Throwable
    //   114	124	255	java/lang/Throwable
    //   129	140	255	java/lang/Throwable
    //   140	155	255	java/lang/Throwable
    //   198	230	255	java/lang/Throwable
    //   235	245	255	java/lang/Throwable
    //   245	252	255	java/lang/Throwable
    //   19	109	305	finally
    //   114	124	305	finally
    //   129	140	305	finally
    //   140	155	305	finally
    //   198	230	305	finally
    //   235	245	305	finally
    //   245	252	305	finally
    //   256	266	305	finally
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString, int paramInt, int[] paramArrayOfInt, abxt.a parama)
  {
    if ((abvg.a(paramString, paramInt, paramArrayOfInt, paramQQAppInterface, new abre(parama, paramQQAppInterface, paramInt, paramArrayOfInt))) && (parama != null)) {
      parama.a(-1L, paramQQAppInterface, paramString, "", "", paramInt, paramArrayOfInt, 22);
    }
  }
  
  public static void clearAction(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = abhh.o();
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).edit();
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("cmshow_scripted_SpriteRscBuilder", 2, "[clearAction] clear action success ");
          }
          ((SharedPreferences.Editor)localObject).remove(paramString).apply();
        }
      }
    }
  }
  
  private String dg(int paramInt)
  {
    if ((this.c == null) || (this.c.getApp() == null)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramInt = ((abhh)this.c.getApp().getManager(153)).fV(paramInt);
    if ((paramInt != -1) && (!ApolloUtil.aF(paramInt, 0)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ApolloPet", 2, "download random pet action:" + paramInt);
      }
      Object localObject = new ApolloActionData();
      ((ApolloActionData)localObject).actionId = paramInt;
      String str = ApolloUtil.a((ApolloActionData)localObject, 5);
      localObject = ApolloUtil.a((ApolloActionData)localObject, 4);
      abto.b(this.c.getApp(), (String)localObject, str);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (paramInt != -1) {
        localStringBuilder.append(paramInt).append("/action/action");
      }
    }
  }
  
  private JSONObject e(int paramInt1, int paramInt2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Object localObject = new SpriteTaskParam();
      ((SpriteTaskParam)localObject).mActionId = paramInt1;
      ((SpriteTaskParam)localObject).bGG = paramInt2;
      ((SpriteTaskParam)localObject).mAioType = this.c.mAioType;
      ((SpriteTaskParam)localObject).mActionType = 1;
      if (!a((SpriteTaskParam)localObject)) {
        return null;
      }
      localObject = ((abxk)this.c.getApp().getManager(155)).a(paramInt1);
      if (localObject == null) {
        return null;
      }
      localJSONObject.put("actionId", paramInt1);
      localJSONObject.put("action", abvg.a(paramInt1, paramInt2, true, this.c.Zb())[0]);
      if (((ApolloActionData)localObject).personNum == 1) {
        localJSONObject.put("actionPeer", abvg.a(paramInt1, paramInt2, false, this.c.Zb())[0]);
      }
      if (this.c.mAioType == 0)
      {
        localJSONObject.put("actionDis", ((ApolloActionData)localObject).actionMoveDis * (float)aqgz.hL() / 7.0F / 368.0F);
        localJSONObject.put("actionPeerDis", ((ApolloActionData)localObject).peerMoveDis * (float)aqgz.hL() / 7.0F / 368.0F);
      }
      else
      {
        localJSONObject.put("posType", ((ApolloActionData)localObject).playArea);
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmshow_scripted_SpriteRscBuilder", 1, "[getWhiteFaceSingleAction],", localThrowable);
      return null;
    }
    return localThrowable;
  }
  
  public static String f(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i = ApolloUtil.b(208.0F, paramString, paramInt2);
    if ((!ApolloUtil.aJ(paramInt1, i)) && (!ApolloUtil.aJ(0, i))) {
      return "";
    }
    return abvg.i(paramInt1, i, paramInt2);
  }
  
  public JSONArray a(JSONArray paramJSONArray)
  {
    JSONArray localJSONArray = new JSONArray();
    if ((this.c == null) || (this.c.getApp() == null) || (paramJSONArray == null)) {
      return localJSONArray;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramJSONArray.length();
    int i = 0;
    for (;;)
    {
      int k;
      if (i < j) {
        try
        {
          k = ((Integer)paramJSONArray.get(i)).intValue();
          if (k == 0) {
            break label207;
          }
          if (ApolloUtil.aF(k, 0)) {
            break label176;
          }
          QLog.e("ApolloPet", 1, "getPetActions download:" + k);
          Object localObject = new ApolloActionData();
          ((ApolloActionData)localObject).actionId = k;
          String str = ApolloUtil.a((ApolloActionData)localObject, 5);
          localObject = ApolloUtil.a((ApolloActionData)localObject, 4);
          abto.b(this.c.getApp(), (String)localObject, str);
        }
        catch (Exception paramJSONArray)
        {
          QLog.e("ApolloPet", 1, "getPetActions error:", paramJSONArray);
        }
      } else {
        return localJSONArray;
      }
      label176:
      localStringBuilder.setLength(0);
      localStringBuilder.append(k).append("/action/action");
      localJSONArray.put(localStringBuilder.toString());
      label207:
      i += 1;
    }
  }
  
  public JSONObject a(SpriteTaskParam paramSpriteTaskParam)
  {
    label377:
    for (;;)
    {
      try
      {
        Object localObject2;
        Object localObject1;
        if ((paramSpriteTaskParam.crh == 12) && (paramSpriteTaskParam.mActionId > 0))
        {
          localObject2 = ApolloUtil.dv(paramSpriteTaskParam.mActionId);
          if (!new File((String)localObject2).exists())
          {
            localObject1 = localObject2;
            if (QLog.isColorLevel())
            {
              QLog.d("cmshow_scripted_SpriteRscBuilder", 1, new Object[] { "[getAudioParam] audio not found for " + (String)localObject2, ",action:", Integer.valueOf(paramSpriteTaskParam.mActionId) });
              localObject1 = localObject2;
            }
            int i = ((String)localObject1).indexOf(".apollo");
            if (-1 != i)
            {
              localObject1 = ((String)localObject1).substring(i + ".apollo/action/".length());
              localObject2 = new JSONObject();
              ((JSONObject)localObject2).put("path", localObject1);
              ((JSONObject)localObject2).put("delayMill", paramSpriteTaskParam.sC * 1000.0F);
              return localObject2;
            }
          }
          else
          {
            localObject1 = ((String)localObject2).substring(abxi.bip.length());
            continue;
          }
        }
        else
        {
          localObject2 = (abhh)this.c.getApp().getManager(153);
          ApolloActionData localApolloActionData = ((abxk)this.c.getApp().getManager(155)).a(paramSpriteTaskParam.mActionId);
          if ((localApolloActionData != null) && (localApolloActionData.hasSound))
          {
            localObject1 = abxi.bip + paramSpriteTaskParam.mActionId + "/" + "music.amr";
            if (new File((String)localObject1).exists()) {
              break label377;
            }
            ((abhh)localObject2).a(localApolloActionData, 4, null);
            continue;
          }
          if (paramSpriteTaskParam.cre > 0)
          {
            localObject2 = abto.di(paramSpriteTaskParam.cre);
            localObject1 = localObject2;
            if (new File((String)localObject2).exists()) {
              continue;
            }
            abto.a(this.c.getApp(), null, paramSpriteTaskParam.cre, false);
            localObject1 = localObject2;
            continue;
          }
          return null;
        }
      }
      catch (Exception paramSpriteTaskParam)
      {
        QLog.e("cmshow_scripted_SpriteRscBuilder", 1, paramSpriteTaskParam, new Object[0]);
        return null;
      }
    }
  }
  
  public boolean a(SpriteTaskParam paramSpriteTaskParam)
  {
    if ((paramSpriteTaskParam == null) || (this.c == null) || (this.c.getApp() == null)) {
      return false;
    }
    if (paramSpriteTaskParam.crh == 1) {
      return b(paramSpriteTaskParam);
    }
    if (paramSpriteTaskParam.crh == 6)
    {
      if (!ApolloUtil.aH(5, paramSpriteTaskParam.mActionId))
      {
        abto.b(this.c.getApp(), ApolloUtil.dr(paramSpriteTaskParam.mActionId) + "/d.zip", ApolloUtil.ds(paramSpriteTaskParam.mActionId));
        return false;
      }
    }
    else if (paramSpriteTaskParam.crh == 12)
    {
      if (!ApolloUtil.aF(paramSpriteTaskParam.mActionId, 0))
      {
        Object localObject = new ApolloActionData();
        ((ApolloActionData)localObject).actionId = paramSpriteTaskParam.mActionId;
        paramSpriteTaskParam = ApolloUtil.a((ApolloActionData)localObject, 5);
        localObject = ApolloUtil.a((ApolloActionData)localObject, 4);
        abto.b(this.c.getApp(), (String)localObject, paramSpriteTaskParam);
        return false;
      }
    }
    else if ((paramSpriteTaskParam.crh == 11) || (paramSpriteTaskParam.crh == 7))
    {
      paramSpriteTaskParam = abvg.a(paramSpriteTaskParam.crh, paramSpriteTaskParam.mActionId, 0, true);
      if ((paramSpriteTaskParam.length > 0) && (!TextUtils.isEmpty(paramSpriteTaskParam[0])) && (!new File(ApolloRender.getRscStaticPath(paramSpriteTaskParam[0], "json")).exists()))
      {
        abto.a(this.c.getApp(), this.c.getApp().getCurrentAccountUin(), null, 0, null, -1, -1, true);
        return false;
      }
    }
    return true;
  }
  
  public Pair<String, Integer> b(String paramString)
  {
    int i = 2;
    Object localObject = new Pair("def/basic/action/4/action/action", Integer.valueOf(0));
    if (TextUtils.isEmpty(paramString)) {
      return localObject;
    }
    StringBuilder localStringBuilder;
    if ((abhh.h(this.c.getApp(), paramString) != 2) && (x(this.c.getApp(), paramString)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.cqX).append("/action/action");
      SharedPreferences localSharedPreferences = this.c.getApp().getApp().getSharedPreferences("apollo_sp", 0);
      if (!localSharedPreferences.getBoolean("stand_type_" + this.cqW, false)) {}
      switch (this.cqW)
      {
      default: 
        localObject = null;
        abqt localabqt = abrj.a(this.c.getApp());
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (localabqt != null)) {
          localabqt.ey(paramString, (String)localObject);
        }
        localSharedPreferences.edit().putBoolean("stand_type_" + this.cqW, true).commit();
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "getSpriteShowPath stand:", Integer.valueOf(this.cqW), ", uin:", ApolloUtil.iY(paramString) });
        }
        if (this.c.mAioType == 3000)
        {
          label297:
          VipUtils.a(null, "cmshow", "Apollo", "appearanceaction", i, this.cqW, new String[] { String.valueOf(this.cqX) });
          if (this.cqW != 4) {
            break label400;
          }
        }
        break;
      }
    }
    label400:
    for (i = 7;; i = 0)
    {
      return new Pair(localStringBuilder.toString(), Integer.valueOf(i));
      localObject = acfp.m(2131714736);
      break;
      localObject = acfp.m(2131714740);
      break;
      localObject = acfp.m(2131714734);
      break;
      i = this.c.mAioType;
      break label297;
      return localObject;
    }
  }
  
  public String b(SpriteTaskParam paramSpriteTaskParam)
  {
    int j = 0;
    if ((paramSpriteTaskParam == null) || (this.c == null)) {
      return null;
    }
    label349:
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        int i;
        if (this.c.cqU == 0)
        {
          localObject = ApolloActionData.getModelString(paramSpriteTaskParam.mActionId);
          localJSONObject.put("model", localObject);
          localJSONObject.put("actionId", paramSpriteTaskParam.mActionId);
          localJSONObject.put("taskId", paramSpriteTaskParam.mTaskId);
          localJSONObject.put("actionType", paramSpriteTaskParam.mActionType);
          localJSONObject.put("from", paramSpriteTaskParam.crd);
          if (!abrj.S(this.c.getApp())) {
            break label349;
          }
          i = 1;
          localJSONObject.put("isHide", i);
          i = j;
          if (paramSpriteTaskParam.mIsSend) {
            i = 1;
          }
          localJSONObject.put("isSender", i);
          if (paramSpriteTaskParam.mActionType == 1)
          {
            localObject = c(paramSpriteTaskParam);
            JSONArray localJSONArray = b(paramSpriteTaskParam);
            localJSONObject.put("sprites", localObject);
            localJSONObject.put("actions", localJSONArray);
            localObject = a(paramSpriteTaskParam);
            if (localObject != null) {
              localJSONObject.put("audio", localObject);
            }
            if (!TextUtils.isEmpty(paramSpriteTaskParam.bhw)) {
              localJSONObject.put("extraMsg", new JSONObject(paramSpriteTaskParam.bhw));
            }
            return localJSONObject.toString();
          }
        }
        else
        {
          if (paramSpriteTaskParam.mActionId > 0)
          {
            localObject = ApolloActionData.getModelString(paramSpriteTaskParam.mActionId);
            continue;
          }
          if (paramSpriteTaskParam.crh == 14)
          {
            localObject = "3D";
            continue;
          }
          localObject = abvg.b(paramSpriteTaskParam.mSenderUin, this.c.getApp());
          continue;
        }
        Object localObject = a(paramSpriteTaskParam);
        if (localObject != null)
        {
          localJSONObject.put("sprites", localObject);
          continue;
          i = 0;
        }
      }
      catch (Throwable paramSpriteTaskParam)
      {
        QLog.e("cmshow_scripted_SpriteRscBuilder", 1, "[getActionJsParam],", paramSpriteTaskParam);
        return null;
      }
    }
  }
  
  /* Error */
  public JSONObject b(String paramString, abrc paramabrc, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 103	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 401	org/json/JSONObject:<init>	()V
    //   7: astore 14
    //   9: iconst_1
    //   10: istore 11
    //   12: iconst_1
    //   13: istore 12
    //   15: iconst_1
    //   16: istore 6
    //   18: iconst_m1
    //   19: istore 5
    //   21: new 624	java/util/ArrayList
    //   24: dup
    //   25: invokespecial 944	java/util/ArrayList:<init>	()V
    //   28: astore 15
    //   30: aload_2
    //   31: invokevirtual 432	abrc:getApp	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   34: sipush 153
    //   37: invokevirtual 80	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   40: checkcast 82	abhh
    //   43: astore 13
    //   45: iload 5
    //   47: istore 9
    //   49: iload 11
    //   51: istore 7
    //   53: iload 5
    //   55: istore 10
    //   57: iload 12
    //   59: istore 8
    //   61: aload 13
    //   63: aload_1
    //   64: invokevirtual 117	abhh:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ApolloBaseInfo;
    //   67: astore 16
    //   69: aload 16
    //   71: ifnonnull +5 -> 76
    //   74: aconst_null
    //   75: areturn
    //   76: iload 5
    //   78: istore 9
    //   80: iload 11
    //   82: istore 7
    //   84: iload 5
    //   86: istore 10
    //   88: iload 12
    //   90: istore 8
    //   92: aload 16
    //   94: invokevirtual 948	com/tencent/mobileqq/data/ApolloBaseInfo:getApolloPetDress	()Labkd;
    //   97: astore 17
    //   99: aload 17
    //   101: ifnull +989 -> 1090
    //   104: iload 5
    //   106: istore 9
    //   108: iload 11
    //   110: istore 7
    //   112: iload 5
    //   114: istore 10
    //   116: iload 12
    //   118: istore 8
    //   120: aload 16
    //   122: getfield 123	com/tencent/mobileqq/data/ApolloBaseInfo:hasPet	Z
    //   125: ifeq +965 -> 1090
    //   128: iload 5
    //   130: istore 9
    //   132: iload 11
    //   134: istore 7
    //   136: iload 5
    //   138: istore 10
    //   140: iload 12
    //   142: istore 8
    //   144: aload 17
    //   146: getfield 954	abkd:in	Ljava/util/HashMap;
    //   149: ifnull +941 -> 1090
    //   152: iload 5
    //   154: istore 9
    //   156: iload 11
    //   158: istore 7
    //   160: iload 5
    //   162: istore 10
    //   164: iload 12
    //   166: istore 8
    //   168: aload 17
    //   170: getfield 954	abkd:in	Ljava/util/HashMap;
    //   173: invokevirtual 956	java/util/HashMap:isEmpty	()Z
    //   176: ifne +914 -> 1090
    //   179: iload 5
    //   181: istore 9
    //   183: iload 11
    //   185: istore 7
    //   187: iload 5
    //   189: istore 10
    //   191: iload 12
    //   193: istore 8
    //   195: aload 14
    //   197: ldc_w 511
    //   200: iconst_0
    //   201: aload 17
    //   203: getfield 958	abkd:roleId	I
    //   206: invokestatic 507	abvg:z	(II)Ljava/lang/String;
    //   209: invokevirtual 350	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   212: pop
    //   213: iload 5
    //   215: istore 4
    //   217: iload 5
    //   219: istore 9
    //   221: iload 11
    //   223: istore 7
    //   225: iload 5
    //   227: istore 10
    //   229: iload 12
    //   231: istore 8
    //   233: iconst_1
    //   234: aload 17
    //   236: getfield 958	abkd:roleId	I
    //   239: invokestatic 961	com/tencent/mobileqq/apollo/utils/ApolloUtil:aG	(II)Z
    //   242: ifne +27 -> 269
    //   245: iconst_0
    //   246: istore 7
    //   248: iconst_0
    //   249: istore 8
    //   251: iconst_0
    //   252: istore 6
    //   254: iload 5
    //   256: istore 9
    //   258: iload 5
    //   260: istore 10
    //   262: aload 17
    //   264: getfield 958	abkd:roleId	I
    //   267: istore 4
    //   269: iload 4
    //   271: istore 9
    //   273: iload 6
    //   275: istore 7
    //   277: iload 4
    //   279: istore 10
    //   281: iload 6
    //   283: istore 8
    //   285: aload 17
    //   287: getfield 954	abkd:in	Ljava/util/HashMap;
    //   290: invokevirtual 962	java/util/HashMap:size	()I
    //   293: newarray int
    //   295: astore 18
    //   297: iload 4
    //   299: istore 9
    //   301: iload 6
    //   303: istore 7
    //   305: iload 4
    //   307: istore 10
    //   309: iload 6
    //   311: istore 8
    //   313: aload 17
    //   315: getfield 954	abkd:in	Ljava/util/HashMap;
    //   318: invokevirtual 966	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   321: invokeinterface 972 1 0
    //   326: astore 19
    //   328: iconst_0
    //   329: istore 5
    //   331: iload 4
    //   333: istore 9
    //   335: iload 6
    //   337: istore 7
    //   339: iload 4
    //   341: istore 10
    //   343: iload 6
    //   345: istore 8
    //   347: aload 19
    //   349: invokeinterface 977 1 0
    //   354: ifeq +54 -> 408
    //   357: iload 4
    //   359: istore 9
    //   361: iload 6
    //   363: istore 7
    //   365: iload 4
    //   367: istore 10
    //   369: iload 6
    //   371: istore 8
    //   373: aload 18
    //   375: iload 5
    //   377: aload 19
    //   379: invokeinterface 981 1 0
    //   384: checkcast 983	java/util/Map$Entry
    //   387: invokeinterface 986 1 0
    //   392: checkcast 70	java/lang/Integer
    //   395: invokevirtual 74	java/lang/Integer:intValue	()I
    //   398: iastore
    //   399: iload 5
    //   401: iconst_1
    //   402: iadd
    //   403: istore 5
    //   405: goto -74 -> 331
    //   408: iload 4
    //   410: istore 9
    //   412: iload 6
    //   414: istore 7
    //   416: iload 4
    //   418: istore 10
    //   420: iload 6
    //   422: istore 8
    //   424: new 88	org/json/JSONArray
    //   427: dup
    //   428: invokespecial 322	org/json/JSONArray:<init>	()V
    //   431: astore 19
    //   433: iload 4
    //   435: istore 9
    //   437: iload 6
    //   439: istore 7
    //   441: iload 4
    //   443: istore 10
    //   445: iload 6
    //   447: istore 8
    //   449: aload 18
    //   451: arraylength
    //   452: istore 11
    //   454: iload 6
    //   456: istore 5
    //   458: iconst_0
    //   459: istore 8
    //   461: iload 8
    //   463: iload 11
    //   465: if_icmpge +72 -> 537
    //   468: aload 18
    //   470: iload 8
    //   472: iaload
    //   473: istore 9
    //   475: iload 5
    //   477: istore 6
    //   479: iload 5
    //   481: istore 7
    //   483: aload 19
    //   485: iconst_1
    //   486: iload 9
    //   488: invokestatic 507	abvg:z	(II)Ljava/lang/String;
    //   491: invokevirtual 342	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   494: pop
    //   495: iload 5
    //   497: istore 6
    //   499: iload 5
    //   501: istore 7
    //   503: iconst_2
    //   504: iload 9
    //   506: invokestatic 961	com/tencent/mobileqq/apollo/utils/ApolloUtil:aG	(II)Z
    //   509: ifne +940 -> 1449
    //   512: iconst_0
    //   513: istore 7
    //   515: iconst_0
    //   516: istore 5
    //   518: iconst_0
    //   519: istore 6
    //   521: aload 15
    //   523: iload 9
    //   525: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   528: invokeinterface 991 2 0
    //   533: pop
    //   534: goto +915 -> 1449
    //   537: iload 5
    //   539: istore 6
    //   541: iload 5
    //   543: istore 7
    //   545: aload 14
    //   547: ldc_w 509
    //   550: aload 19
    //   552: invokevirtual 350	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   555: pop
    //   556: iload 5
    //   558: istore 6
    //   560: iload 5
    //   562: istore 7
    //   564: aload 14
    //   566: ldc_w 655
    //   569: aload 17
    //   571: getfield 958	abkd:roleId	I
    //   574: invokevirtual 407	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   577: pop
    //   578: iload 5
    //   580: istore 6
    //   582: iload 5
    //   584: istore 7
    //   586: aload_0
    //   587: aload 17
    //   589: getfield 958	abkd:roleId	I
    //   592: ldc_w 993
    //   595: invokevirtual 997	abrd:u	(ILjava/lang/String;)Ljava/lang/String;
    //   598: astore 18
    //   600: iload 5
    //   602: istore 6
    //   604: iload 5
    //   606: istore 7
    //   608: aload_0
    //   609: aload 17
    //   611: getfield 958	abkd:roleId	I
    //   614: ldc_w 999
    //   617: invokevirtual 997	abrd:u	(ILjava/lang/String;)Ljava/lang/String;
    //   620: astore 19
    //   622: iload 5
    //   624: istore 6
    //   626: iload 5
    //   628: istore 7
    //   630: aload 18
    //   632: invokestatic 58	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   635: ifne +57 -> 692
    //   638: iload 5
    //   640: istore 6
    //   642: iload 5
    //   644: istore 7
    //   646: aload 19
    //   648: invokestatic 58	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   651: ifne +41 -> 692
    //   654: iload 5
    //   656: istore 6
    //   658: iload 5
    //   660: istore 7
    //   662: aload 14
    //   664: ldc_w 1001
    //   667: aload 19
    //   669: invokevirtual 350	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   672: pop
    //   673: iload 5
    //   675: istore 6
    //   677: iload 5
    //   679: istore 7
    //   681: aload 14
    //   683: ldc_w 1003
    //   686: aload 18
    //   688: invokevirtual 350	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   691: pop
    //   692: iload 5
    //   694: istore 6
    //   696: iload 5
    //   698: istore 7
    //   700: aload_0
    //   701: aload 17
    //   703: getfield 958	abkd:roleId	I
    //   706: invokespecial 1005	abrd:dg	(I)Ljava/lang/String;
    //   709: astore 18
    //   711: iload 5
    //   713: istore 6
    //   715: iload 5
    //   717: istore 7
    //   719: aload 18
    //   721: invokestatic 58	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   724: ifne +22 -> 746
    //   727: iload 5
    //   729: istore 6
    //   731: iload 5
    //   733: istore 7
    //   735: aload 14
    //   737: ldc_w 1007
    //   740: aload 18
    //   742: invokevirtual 350	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   745: pop
    //   746: iload 5
    //   748: istore 6
    //   750: iload 5
    //   752: istore 7
    //   754: aload 16
    //   756: getfield 1010	com/tencent/mobileqq/data/ApolloBaseInfo:petNick	Ljava/lang/String;
    //   759: invokestatic 58	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   762: ifne +53 -> 815
    //   765: iload 5
    //   767: istore 6
    //   769: iload 5
    //   771: istore 7
    //   773: aload_2
    //   774: getfield 898	abrc:cqU	I
    //   777: ifne +38 -> 815
    //   780: iload 5
    //   782: istore 6
    //   784: iload 5
    //   786: istore 7
    //   788: aload 14
    //   790: ldc_w 531
    //   793: aload 16
    //   795: getfield 1010	com/tencent/mobileqq/data/ApolloBaseInfo:petNick	Ljava/lang/String;
    //   798: ldc_w 447
    //   801: invokevirtual 451	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   804: iconst_0
    //   805: invokestatic 457	aqgo:encodeToString	([BI)Ljava/lang/String;
    //   808: invokestatic 460	abrj:replaceBlank	(Ljava/lang/String;)Ljava/lang/String;
    //   811: invokevirtual 350	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   814: pop
    //   815: iload 5
    //   817: istore 6
    //   819: iload 5
    //   821: istore 7
    //   823: aload 14
    //   825: ldc_w 517
    //   828: aload 13
    //   830: getfield 1013	abhh:bfZ	Ljava/lang/String;
    //   833: aload 17
    //   835: getfield 958	abkd:roleId	I
    //   838: iload_3
    //   839: invokestatic 1015	abrd:c	(Ljava/lang/String;IZ)Ljava/lang/String;
    //   842: invokevirtual 350	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   845: pop
    //   846: iload 5
    //   848: istore 6
    //   850: iload 5
    //   852: istore 7
    //   854: aload_0
    //   855: getfield 49	abrd:c	Labrc;
    //   858: getfield 534	abrc:a	Labkg;
    //   861: ifnull +87 -> 948
    //   864: iload 5
    //   866: istore 6
    //   868: iload 5
    //   870: istore 7
    //   872: aload 14
    //   874: ldc_w 536
    //   877: aload_0
    //   878: getfield 49	abrd:c	Labrc;
    //   881: getfield 534	abrc:a	Labkg;
    //   884: getfield 541	abkg:scale	F
    //   887: f2d
    //   888: invokevirtual 544	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   891: pop
    //   892: iload 5
    //   894: istore 6
    //   896: iload 5
    //   898: istore 7
    //   900: aload 14
    //   902: ldc_w 546
    //   905: aload_0
    //   906: getfield 49	abrd:c	Labrc;
    //   909: getfield 534	abrc:a	Labkg;
    //   912: getfield 548	abkg:xPos	F
    //   915: f2d
    //   916: invokevirtual 544	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   919: pop
    //   920: iload 5
    //   922: istore 6
    //   924: iload 5
    //   926: istore 7
    //   928: aload 14
    //   930: ldc_w 550
    //   933: aload_0
    //   934: getfield 49	abrd:c	Labrc;
    //   937: getfield 534	abrc:a	Labkg;
    //   940: getfield 553	abkg:bU	F
    //   943: f2d
    //   944: invokevirtual 544	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   947: pop
    //   948: iload 5
    //   950: ifeq +111 -> 1061
    //   953: iload 5
    //   955: ifne +491 -> 1446
    //   958: aload_2
    //   959: ifnull +487 -> 1446
    //   962: aload_2
    //   963: invokevirtual 432	abrc:getApp	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   966: ifnull +480 -> 1446
    //   969: ldc_w 666
    //   972: iconst_1
    //   973: new 289	java/lang/StringBuilder
    //   976: dup
    //   977: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   980: ldc_w 1017
    //   983: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: aload_1
    //   987: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   990: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   993: invokestatic 312	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   996: aload 13
    //   998: ifnull +448 -> 1446
    //   1001: aload 15
    //   1003: invokeinterface 1018 1 0
    //   1008: newarray int
    //   1010: astore 16
    //   1012: aload 15
    //   1014: invokeinterface 1019 1 0
    //   1019: astore 15
    //   1021: iconst_0
    //   1022: istore 5
    //   1024: aload 15
    //   1026: invokeinterface 977 1 0
    //   1031: ifeq +36 -> 1067
    //   1034: aload 16
    //   1036: iload 5
    //   1038: aload 15
    //   1040: invokeinterface 981 1 0
    //   1045: checkcast 70	java/lang/Integer
    //   1048: invokevirtual 74	java/lang/Integer:intValue	()I
    //   1051: iastore
    //   1052: iload 5
    //   1054: iconst_1
    //   1055: iadd
    //   1056: istore 5
    //   1058: goto -34 -> 1024
    //   1061: aconst_null
    //   1062: astore 14
    //   1064: goto -111 -> 953
    //   1067: aload_2
    //   1068: invokevirtual 432	abrc:getApp	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1071: aload_1
    //   1072: aload 13
    //   1074: invokevirtual 1022	abhh:a	()Labto$b;
    //   1077: iload 4
    //   1079: aload 16
    //   1081: iconst_m1
    //   1082: iconst_m1
    //   1083: iconst_1
    //   1084: invokestatic 833	abto:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Labto$b;I[IIIZ)V
    //   1087: aload 14
    //   1089: areturn
    //   1090: aconst_null
    //   1091: areturn
    //   1092: astore 14
    //   1094: aconst_null
    //   1095: astore 13
    //   1097: iconst_1
    //   1098: istore 6
    //   1100: iload 5
    //   1102: istore 4
    //   1104: iload 6
    //   1106: istore 5
    //   1108: ldc 138
    //   1110: iconst_1
    //   1111: aload 14
    //   1113: iconst_0
    //   1114: anewarray 4	java/lang/Object
    //   1117: invokestatic 420	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1120: iload 5
    //   1122: ifne +126 -> 1248
    //   1125: aload_2
    //   1126: ifnull +122 -> 1248
    //   1129: aload_2
    //   1130: invokevirtual 432	abrc:getApp	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1133: ifnull +115 -> 1248
    //   1136: ldc_w 666
    //   1139: iconst_1
    //   1140: new 289	java/lang/StringBuilder
    //   1143: dup
    //   1144: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   1147: ldc_w 1017
    //   1150: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1153: aload_1
    //   1154: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1157: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1160: invokestatic 312	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1163: aload 13
    //   1165: ifnull +83 -> 1248
    //   1168: aload 15
    //   1170: invokeinterface 1018 1 0
    //   1175: newarray int
    //   1177: astore 14
    //   1179: aload 15
    //   1181: invokeinterface 1019 1 0
    //   1186: astore 15
    //   1188: iconst_0
    //   1189: istore 5
    //   1191: aload 15
    //   1193: invokeinterface 977 1 0
    //   1198: ifeq +30 -> 1228
    //   1201: aload 14
    //   1203: iload 5
    //   1205: aload 15
    //   1207: invokeinterface 981 1 0
    //   1212: checkcast 70	java/lang/Integer
    //   1215: invokevirtual 74	java/lang/Integer:intValue	()I
    //   1218: iastore
    //   1219: iload 5
    //   1221: iconst_1
    //   1222: iadd
    //   1223: istore 5
    //   1225: goto -34 -> 1191
    //   1228: aload_2
    //   1229: invokevirtual 432	abrc:getApp	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1232: aload_1
    //   1233: aload 13
    //   1235: invokevirtual 1022	abhh:a	()Labto$b;
    //   1238: iload 4
    //   1240: aload 14
    //   1242: iconst_m1
    //   1243: iconst_m1
    //   1244: iconst_1
    //   1245: invokestatic 833	abto:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Labto$b;I[IIIZ)V
    //   1248: aconst_null
    //   1249: areturn
    //   1250: astore 14
    //   1252: aconst_null
    //   1253: astore 13
    //   1255: iconst_1
    //   1256: istore 6
    //   1258: iload 5
    //   1260: istore 4
    //   1262: iload 6
    //   1264: istore 5
    //   1266: iload 5
    //   1268: ifne +126 -> 1394
    //   1271: aload_2
    //   1272: ifnull +122 -> 1394
    //   1275: aload_2
    //   1276: invokevirtual 432	abrc:getApp	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1279: ifnull +115 -> 1394
    //   1282: ldc_w 666
    //   1285: iconst_1
    //   1286: new 289	java/lang/StringBuilder
    //   1289: dup
    //   1290: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   1293: ldc_w 1017
    //   1296: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1299: aload_1
    //   1300: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1303: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1306: invokestatic 312	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1309: aload 13
    //   1311: ifnull +83 -> 1394
    //   1314: aload 15
    //   1316: invokeinterface 1018 1 0
    //   1321: newarray int
    //   1323: astore 16
    //   1325: aload 15
    //   1327: invokeinterface 1019 1 0
    //   1332: astore 15
    //   1334: iconst_0
    //   1335: istore 5
    //   1337: aload 15
    //   1339: invokeinterface 977 1 0
    //   1344: ifeq +30 -> 1374
    //   1347: aload 16
    //   1349: iload 5
    //   1351: aload 15
    //   1353: invokeinterface 981 1 0
    //   1358: checkcast 70	java/lang/Integer
    //   1361: invokevirtual 74	java/lang/Integer:intValue	()I
    //   1364: iastore
    //   1365: iload 5
    //   1367: iconst_1
    //   1368: iadd
    //   1369: istore 5
    //   1371: goto -34 -> 1337
    //   1374: aload_2
    //   1375: invokevirtual 432	abrc:getApp	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1378: aload_1
    //   1379: aload 13
    //   1381: invokevirtual 1022	abhh:a	()Labto$b;
    //   1384: iload 4
    //   1386: aload 16
    //   1388: iconst_m1
    //   1389: iconst_m1
    //   1390: iconst_1
    //   1391: invokestatic 833	abto:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Labto$b;I[IIIZ)V
    //   1394: aload 14
    //   1396: athrow
    //   1397: astore 14
    //   1399: iload 7
    //   1401: istore 5
    //   1403: iload 9
    //   1405: istore 4
    //   1407: goto -141 -> 1266
    //   1410: astore 14
    //   1412: iload 6
    //   1414: istore 5
    //   1416: goto -150 -> 1266
    //   1419: astore 14
    //   1421: goto -155 -> 1266
    //   1424: astore 14
    //   1426: iload 8
    //   1428: istore 5
    //   1430: iload 10
    //   1432: istore 4
    //   1434: goto -326 -> 1108
    //   1437: astore 14
    //   1439: iload 7
    //   1441: istore 5
    //   1443: goto -335 -> 1108
    //   1446: aload 14
    //   1448: areturn
    //   1449: iload 8
    //   1451: iconst_1
    //   1452: iadd
    //   1453: istore 8
    //   1455: goto -994 -> 461
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1458	0	this	abrd
    //   0	1458	1	paramString	String
    //   0	1458	2	paramabrc	abrc
    //   0	1458	3	paramBoolean	boolean
    //   215	1218	4	i	int
    //   19	1423	5	j	int
    //   16	1397	6	k	int
    //   51	1389	7	m	int
    //   59	1395	8	n	int
    //   47	1357	9	i1	int
    //   55	1376	10	i2	int
    //   10	456	11	i3	int
    //   13	217	12	i4	int
    //   43	1337	13	localabhh	abhh
    //   7	1081	14	localJSONObject	JSONObject
    //   1092	20	14	localThrowable1	Throwable
    //   1177	64	14	arrayOfInt	int[]
    //   1250	145	14	localObject1	Object
    //   1397	1	14	localObject2	Object
    //   1410	1	14	localObject3	Object
    //   1419	1	14	localObject4	Object
    //   1424	1	14	localThrowable2	Throwable
    //   1437	10	14	localThrowable3	Throwable
    //   28	1324	15	localObject5	Object
    //   67	1320	16	localObject6	Object
    //   97	737	17	localabkd	abkd
    //   295	446	18	localObject7	Object
    //   326	342	19	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   30	45	1092	java/lang/Throwable
    //   30	45	1250	finally
    //   61	69	1397	finally
    //   92	99	1397	finally
    //   120	128	1397	finally
    //   144	152	1397	finally
    //   168	179	1397	finally
    //   195	213	1397	finally
    //   233	245	1397	finally
    //   262	269	1397	finally
    //   285	297	1397	finally
    //   313	328	1397	finally
    //   347	357	1397	finally
    //   373	399	1397	finally
    //   424	433	1397	finally
    //   449	454	1397	finally
    //   483	495	1410	finally
    //   503	512	1410	finally
    //   521	534	1410	finally
    //   545	556	1410	finally
    //   564	578	1410	finally
    //   586	600	1410	finally
    //   608	622	1410	finally
    //   630	638	1410	finally
    //   646	654	1410	finally
    //   662	673	1410	finally
    //   681	692	1410	finally
    //   700	711	1410	finally
    //   719	727	1410	finally
    //   735	746	1410	finally
    //   754	765	1410	finally
    //   773	780	1410	finally
    //   788	815	1410	finally
    //   823	846	1410	finally
    //   854	864	1410	finally
    //   872	892	1410	finally
    //   900	920	1410	finally
    //   928	948	1410	finally
    //   1108	1120	1419	finally
    //   61	69	1424	java/lang/Throwable
    //   92	99	1424	java/lang/Throwable
    //   120	128	1424	java/lang/Throwable
    //   144	152	1424	java/lang/Throwable
    //   168	179	1424	java/lang/Throwable
    //   195	213	1424	java/lang/Throwable
    //   233	245	1424	java/lang/Throwable
    //   262	269	1424	java/lang/Throwable
    //   285	297	1424	java/lang/Throwable
    //   313	328	1424	java/lang/Throwable
    //   347	357	1424	java/lang/Throwable
    //   373	399	1424	java/lang/Throwable
    //   424	433	1424	java/lang/Throwable
    //   449	454	1424	java/lang/Throwable
    //   483	495	1437	java/lang/Throwable
    //   503	512	1437	java/lang/Throwable
    //   521	534	1437	java/lang/Throwable
    //   545	556	1437	java/lang/Throwable
    //   564	578	1437	java/lang/Throwable
    //   586	600	1437	java/lang/Throwable
    //   608	622	1437	java/lang/Throwable
    //   630	638	1437	java/lang/Throwable
    //   646	654	1437	java/lang/Throwable
    //   662	673	1437	java/lang/Throwable
    //   681	692	1437	java/lang/Throwable
    //   700	711	1437	java/lang/Throwable
    //   719	727	1437	java/lang/Throwable
    //   735	746	1437	java/lang/Throwable
    //   754	765	1437	java/lang/Throwable
    //   773	780	1437	java/lang/Throwable
    //   788	815	1437	java/lang/Throwable
    //   823	846	1437	java/lang/Throwable
    //   854	864	1437	java/lang/Throwable
    //   872	892	1437	java/lang/Throwable
    //   900	920	1437	java/lang/Throwable
    //   928	948	1437	java/lang/Throwable
  }
  
  public boolean b(SpriteTaskParam paramSpriteTaskParam)
  {
    if ((paramSpriteTaskParam == null) || (this.c == null) || (this.c.getApp() == null)) {
      return false;
    }
    long l1 = System.currentTimeMillis();
    abhh localabhh = (abhh)this.c.getApp().getManager(153);
    ApolloActionData localApolloActionData = ((abxk)this.c.getApp().getManager(155)).a(paramSpriteTaskParam.mActionId);
    if (localApolloActionData == null)
    {
      QLog.i("cmshow_scripted_SpriteRscBuilder", 1, "warning: data is null. call checkApolloPanelJsonVer, id:" + paramSpriteTaskParam.mActionId);
      aczo.r(this.c.getApp(), 1);
      return false;
    }
    int j;
    int k;
    int i;
    if (paramSpriteTaskParam.mActionType == 1) {
      if (paramSpriteTaskParam.mAioType != 0)
      {
        bool1 = true;
        j = paramSpriteTaskParam.mActionId;
        k = paramSpriteTaskParam.bGG;
        if (!bool1) {
          break label340;
        }
        i = 0;
      }
    }
    label154:
    label340:
    boolean bool3;
    label644:
    label650:
    label694:
    label700:
    for (boolean bool1 = ApolloUtil.b(j, k, i, bool1);; bool1 = bool3)
    {
      Object localObject = ((abrg)this.c.getApp().getManager(249)).a();
      if (!bool1)
      {
        if (localObject != null) {
          ((SpriteUIHandler)localObject).d(0, 0, paramSpriteTaskParam.mMsgId);
        }
        bool1 = localabhh.a(localApolloActionData, 4, null);
        if (localObject != null) {
          if (!bool1) {
            break label694;
          }
        }
      }
      for (i = 0;; i = 6) {
        for (;;)
        {
          ((SpriteUIHandler)localObject).d(i, 1, paramSpriteTaskParam.mMsgId);
          long l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "[downloadIfActionNotExist end, actionId:", Integer.valueOf(paramSpriteTaskParam.mActionId), ",costT:", Long.valueOf(l2 - l1), ",threadId:", Long.valueOf(Thread.currentThread().getId()), ",actionType:", Integer.valueOf(paramSpriteTaskParam.mActionType) });
          }
          return true;
          bool1 = false;
          break;
          i = localApolloActionData.personNum;
          break label154;
          bool3 = ApolloUtil.aF(paramSpriteTaskParam.mActionId, localApolloActionData.personNum);
          if ((8 != paramSpriteTaskParam.mActionType) || (paramSpriteTaskParam.bhw == null) || (!bool3)) {
            break label700;
          }
          boolean bool2 = bool3;
          try
          {
            localObject = new JSONObject(paramSpriteTaskParam.bhw).optJSONObject("action");
            bool2 = bool3;
            String str = ((JSONObject)localObject).optString("actionId");
            bool1 = bool3;
            bool2 = bool3;
            if (!TextUtils.isEmpty(str))
            {
              bool2 = bool3;
              i = Integer.parseInt(str);
              bool2 = bool3;
              if (((JSONObject)localObject).optInt("actionPlatform") <= 0) {
                break label644;
              }
              bool4 = true;
              label465:
              bool1 = bool3;
              bool2 = bool3;
              if (!ApolloUtil.a(paramSpriteTaskParam.mActionId, false, i, bool4)) {
                bool1 = false;
              }
            }
            bool3 = bool1;
            bool2 = bool1;
            if (1 == localApolloActionData.personNum)
            {
              bool3 = bool1;
              if (bool1)
              {
                bool2 = bool1;
                str = ((JSONObject)localObject).optString("actionPeerId");
                bool3 = bool1;
                bool2 = bool1;
                if (!TextUtils.isEmpty(str))
                {
                  bool2 = bool1;
                  i = Integer.parseInt(str);
                  bool2 = bool1;
                  if (((JSONObject)localObject).optInt("actionPeerPlatform") <= 0) {
                    break label650;
                  }
                }
              }
            }
            for (boolean bool4 = true;; bool4 = false)
            {
              bool3 = bool1;
              bool2 = bool1;
              if (!ApolloUtil.a(paramSpriteTaskParam.mActionId, true, i, bool4)) {
                bool3 = false;
              }
              if (!bool3)
              {
                bool2 = bool3;
                QLog.e("cmshow_scripted_SpriteRscBuilder", 1, "[random] action nis not exist," + paramSpriteTaskParam.bhw);
              }
              bool1 = bool3;
              break;
              bool4 = false;
              break label465;
            }
          }
          catch (Exception localException)
          {
            QLog.e("cmshow_scripted_SpriteRscBuilder", 1, "[random] the json is not right," + paramSpriteTaskParam.bhw);
            bool1 = bool2;
          }
        }
      }
    }
  }
  
  public void ia(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    Object localObject3;
    Object localObject1;
    do
    {
      return;
      localObject3 = new ArrayList();
      Iterator localIterator = paramList.iterator();
      i = 1;
      localObject1 = null;
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramList = a(this.c.getApp(), str);
        if (str.equals(this.c.mSelfUin)) {}
        for (localObject1 = a(paramList);; localObject1 = localObject2)
        {
          ((SpriteTaskParam)localObject1).mTaskId = i;
          ((SpriteTaskParam)localObject1).mIsSend = true;
          ((SpriteTaskParam)localObject1).mSenderUin = str;
          ((List)localObject3).add(localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "playAppearAction task action:", Integer.valueOf(((SpriteTaskParam)localObject1).mActionId), ",uin:", str.substring(0, 4) });
          }
          i += 1;
          localObject1 = paramList;
          break;
          localObject2 = a(paramList);
          paramList = (List<String>)localObject1;
        }
      }
      abrj.a(this.c, (List)localObject3);
    } while (localObject1 == null);
    Object localObject2 = this.c.getApp().getApp().getSharedPreferences("apollo_sp", 0);
    if (!((SharedPreferences)localObject2).getBoolean("stand_type_" + ((abrd.a)localObject1).cqW, false)) {}
    switch (((abrd.a)localObject1).cqW)
    {
    default: 
      paramList = null;
      localObject3 = abrj.a(this.c.getApp());
      if ((!TextUtils.isEmpty(paramList)) && (localObject3 != null)) {
        ((abqt)localObject3).ey(this.c.mSelfUin, paramList);
      }
      ((SharedPreferences)localObject2).edit().putBoolean("stand_type_" + ((abrd.a)localObject1).cqW, true).commit();
      if (this.c.mAioType != 3000) {
        break;
      }
    }
    for (int i = 2;; i = this.c.mAioType)
    {
      VipUtils.a(null, "cmshow", "Apollo", "appearanceaction", i, ((abrd.a)localObject1).cqW, new String[] { String.valueOf(((abrd.a)localObject1).actionId) });
      return;
      paramList = acfp.m(2131714735);
      break;
      paramList = acfp.m(2131714731);
      break;
      paramList = acfp.m(2131714738);
      break;
    }
  }
  
  public void reset()
  {
    if (this.ja != null) {
      this.ja.clear();
    }
  }
  
  public String rj()
  {
    if (this.c == null) {
      return null;
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      JSONObject localJSONObject2;
      JSONObject localJSONObject3;
      if (this.c.mAioType == 0)
      {
        localJSONObject2 = a(this.c.mSelfUin, this.c, true);
        localJSONObject3 = a(this.c.mFriendUin, this.c, false);
        JSONObject localJSONObject4;
        if (abhh.h(this.c.getApp(), this.c.mSelfUin) != 2)
        {
          localJSONObject4 = b(this.c.mSelfUin, this.c, true);
          if (localJSONObject4 != null) {
            localJSONObject2.put("pet", localJSONObject4);
          }
        }
        if (abhh.h(this.c.getApp(), this.c.mFriendUin) != 2)
        {
          localJSONObject4 = b(this.c.mFriendUin, this.c, false);
          if (localJSONObject4 != null) {
            localJSONObject3.put("pet", localJSONObject4);
          }
        }
        localJSONArray.put(localJSONObject2);
        localJSONArray.put(localJSONObject3);
      }
      for (;;)
      {
        localJSONObject1.put("sprites", localJSONArray);
        return localJSONObject1.toString();
        localJSONObject2 = a(this.c.mSelfUin, this.c, true);
        if (abhh.h(this.c.getApp(), this.c.mSelfUin) != 2)
        {
          localJSONObject3 = b(this.c.mSelfUin, this.c, true);
          if (localJSONObject3 != null) {
            localJSONObject2.put("pet", localJSONObject3);
          }
        }
        localJSONArray.put(localJSONObject2);
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmshow_scripted_SpriteRscBuilder", 1, "[getSpriteJsParam],", localThrowable);
    }
  }
  
  String u(int paramInt, String paramString)
  {
    int i = 0;
    if ((this.c == null) || (this.c.getApp() == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    Object localObject = paramInt + "_" + paramString;
    if (this.jb.containsKey(localObject)) {
      return (String)this.jb.get(localObject);
    }
    localObject = (abhh)this.c.getApp().getManager(153);
    if (TextUtils.isEmpty(((abhh)localObject).bfZ)) {
      return null;
    }
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray(((abhh)localObject).bfZ);
        int j = localJSONArray.length();
        if (i < j)
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          int k = localJSONObject.optInt("roleId", -1);
          if ((k == -1) || (k != paramInt)) {
            continue;
          }
          paramInt = localJSONObject.getInt(paramString);
          if (ApolloUtil.aF(paramInt, 0)) {
            return paramInt + "/action/action";
          }
          QLog.e("ApolloPet", 1, "getPetBasicActions download action:" + paramInt);
          paramString = new ApolloActionData();
          paramString.actionId = paramInt;
          ((abhh)localObject).a(paramString, 4);
        }
      }
      catch (Exception paramString)
      {
        QLog.e("ApolloPet", 1, "getPetBasicActions error:", paramString);
        continue;
      }
      return null;
      i += 1;
    }
  }
  
  boolean x(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null)) {
      return false;
    }
    int i;
    if (this.ja.containsKey(paramString))
    {
      i = ((Integer)this.ja.get(paramString)).intValue();
      if (!iZ.containsKey(paramString)) {
        break label682;
      }
    }
    label682:
    for (int j = ((Integer)iZ.get(paramString)).intValue();; j = 0)
    {
      Object localObject = abhh.o();
      aqrb localaqrb = (aqrb)paramQQAppInterface.getBusinessHandler(71);
      JSONArray localJSONArray;
      try
      {
        if (this.iR.get(paramString) == null) {}
        for (long l = 0L; (!((SharedPreferences)localObject).contains(paramString)) && (NetConnInfoCenter.getServerTime() - l > 180L); l = ((Long)this.iR.get(paramString)).longValue())
        {
          paramQQAppInterface = new JSONObject();
          paramQQAppInterface.put("lastRequestTime", NetConnInfoCenter.getServerTimeMillis());
          ((SharedPreferences)localObject).edit().putString(paramString, paramQQAppInterface.toString()).commit();
          localaqrb.d(new long[] { Long.parseLong(paramString) });
          this.iR.put(paramString, Long.valueOf(NetConnInfoCenter.getServerTime()));
          return false;
        }
        JSONObject localJSONObject = new JSONObject(((SharedPreferences)localObject).getString(paramString, "{}"));
        localJSONArray = localJSONObject.optJSONArray("action");
        l = localJSONObject.optLong("lastRequestTime");
        if ((j >= 5) || (NetConnInfoCenter.getServerTime() - l > 10800000L))
        {
          if (QLog.isColorLevel()) {
            QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "hasSpecialStandAction getApolloStandAction openCount:", Integer.valueOf(j), ",lastRequestSpTime:", Long.valueOf(l) });
          }
          iZ.put(paramString, Integer.valueOf(0));
          localaqrb.d(new long[] { Long.parseLong(paramString) });
          localJSONObject.put("lastRequestTime", NetConnInfoCenter.getServerTimeMillis());
          ((SharedPreferences)localObject).edit().putString(paramString, localJSONObject.toString()).commit();
        }
        for (;;)
        {
          if (localJSONArray == null) {
            break label688;
          }
          if (localJSONArray.length() > 0) {
            break;
          }
          break label688;
          iZ.put(paramString, Integer.valueOf(j + 1));
        }
        j = i;
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("cmshow_scripted_SpriteRscBuilder", 2, "hasSpecialStandAction error:", paramQQAppInterface);
        return false;
      }
      if (i >= localJSONArray.length()) {
        j = 0;
      }
      localObject = localJSONArray.getJSONObject(j);
      this.cqW = ((JSONObject)localObject).getInt("type");
      this.cqX = ((JSONObject)localObject).getInt("id");
      if ((this.cqW == 4) && (!((abhh)paramQQAppInterface.getManager(153)).b(paramString).hasPet))
      {
        clearAction(paramString);
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "[hasSpecialStandAction] uin:", paramString, ",index:", Integer.valueOf(j), ",id:", Integer.valueOf(this.cqX), ",standType:", Integer.valueOf(this.cqW) });
      }
      if (!ApolloUtil.aF(this.cqX, 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("cmshow_scripted_SpriteRscBuilder", 2, "hasSpecialStandAction isActionResDone is false.");
        }
        paramString = new ApolloActionData();
        paramString.actionId = this.cqX;
        localObject = ApolloUtil.a(paramString, 5);
        abto.b(paramQQAppInterface, ApolloUtil.a(paramString, 4), (String)localObject);
        return false;
      }
      this.ja.put(paramString, Integer.valueOf(j + 1));
      return true;
      i = 0;
      break;
    }
    label688:
    return false;
  }
  
  public static class a
  {
    public int actionId;
    public int cqW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abrd
 * JD-Core Version:    0.7.0.1
 */