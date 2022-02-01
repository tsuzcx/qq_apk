import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.script.SpriteUIHandler;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView.PlayActionConfig;
import com.tencent.mobileqq.apollo.sdk.IPCSpriteContext;
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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class absk
{
  static Map<String, Integer> iZ = new HashMap();
  int cqW = -1;
  int cqX = -1;
  private abse d;
  private Map<String, Long> iR = new HashMap();
  Map<String, Integer> ja = new HashMap();
  Map<String, String> jb = new ConcurrentHashMap(2);
  
  public absk(abse paramabse)
  {
    this.d = paramabse;
  }
  
  public static String a(SpriteTaskParam paramSpriteTaskParam, IPCSpriteContext paramIPCSpriteContext, CmShowRenderView.PlayActionConfig paramPlayActionConfig)
  {
    int j = 0;
    if ((paramSpriteTaskParam == null) || (paramIPCSpriteContext == null) || (paramPlayActionConfig == null)) {
      return null;
    }
    label341:
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        String str;
        int i;
        if (paramIPCSpriteContext.cqU == 0)
        {
          str = ApolloActionData.getModelString(paramSpriteTaskParam.mActionId);
          localJSONObject.put("loop", paramPlayActionConfig.mLoop);
          localJSONObject.put("needRestore", paramPlayActionConfig.bFa);
          localJSONObject.put("model", str);
          localJSONObject.put("actionId", paramSpriteTaskParam.mActionId);
          localJSONObject.put("taskId", paramSpriteTaskParam.mTaskId);
          localJSONObject.put("actionType", paramSpriteTaskParam.mActionType);
          localJSONObject.put("from", paramSpriteTaskParam.crd);
          if (!abrj.S(ApolloUtil.a())) {
            break label341;
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
            paramPlayActionConfig = b(paramSpriteTaskParam, paramIPCSpriteContext);
            paramIPCSpriteContext = a(paramSpriteTaskParam, paramIPCSpriteContext);
            localJSONObject.put("sprites", paramPlayActionConfig);
            localJSONObject.put("actions", paramIPCSpriteContext);
            paramIPCSpriteContext = a(paramSpriteTaskParam);
            if (paramIPCSpriteContext != null) {
              localJSONObject.put("audio", paramIPCSpriteContext);
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
            str = ApolloActionData.getModelString(paramSpriteTaskParam.mActionId);
            continue;
          }
          if (paramSpriteTaskParam.crh == 14)
          {
            str = "3D";
            continue;
          }
          str = abvg.b(paramSpriteTaskParam.mSenderUin, ApolloUtil.a());
          continue;
        }
        paramIPCSpriteContext = a(paramSpriteTaskParam, paramIPCSpriteContext, paramPlayActionConfig);
        if (paramIPCSpriteContext != null)
        {
          localJSONObject.put("sprites", paramIPCSpriteContext);
          continue;
          i = 0;
        }
      }
      catch (Throwable paramSpriteTaskParam)
      {
        QLog.e("CmShow_SpriteRscBuilder", 1, "[getActionJsParam],", paramSpriteTaskParam);
        return null;
      }
    }
  }
  
  public static String a(IPCSpriteContext paramIPCSpriteContext)
  {
    if (paramIPCSpriteContext == null) {
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      if (!TextUtils.isEmpty(paramIPCSpriteContext.mSelfUin)) {
        localJSONArray.put(a(paramIPCSpriteContext.mSelfUin, paramIPCSpriteContext, true));
      }
      if (!TextUtils.isEmpty(paramIPCSpriteContext.mFriendUin)) {
        localJSONArray.put(a(paramIPCSpriteContext.mFriendUin, paramIPCSpriteContext, false));
      }
      localJSONObject.put("sprites", localJSONArray);
      paramIPCSpriteContext = localJSONObject.toString();
      return paramIPCSpriteContext;
    }
    catch (Throwable paramIPCSpriteContext)
    {
      QLog.e("CmShow_SpriteRscBuilder", 1, "[getSpriteJsParam],", paramIPCSpriteContext);
    }
    return null;
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
      QLog.d("CmShow_SpriteRscBuilder", 2, new Object[] { "getNicknamePath uin:", ApolloUtil.iY(paramString), ", isMe:", Boolean.valueOf(bool2), ",isYellowVip:", Boolean.valueOf(bool1), ",isRight:", Boolean.valueOf(paramBoolean), ",bubbleId:", Integer.valueOf(i) });
    }
    return abvg.i(paramInt, i, abhh.h(paramQQAppInterface, paramString));
  }
  
  private static String a(boolean paramBoolean, String paramString, int paramInt)
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
          break label246;
        }
        bool1 = true;
        break label243;
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
      QLog.e("CmShow_SpriteRscBuilder", 1, "[random] the json is not right," + paramString);
    }
    for (;;)
    {
      label243:
      break;
      label246:
      bool1 = false;
    }
  }
  
  private static JSONArray a(SpriteTaskParam paramSpriteTaskParam, IPCSpriteContext paramIPCSpriteContext)
  {
    if ((paramSpriteTaskParam == null) || (paramIPCSpriteContext == null)) {
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
        localabxk = (abxk)ApolloUtil.a().getManager(155);
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
              localObject = a(j, 2, paramIPCSpriteContext);
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
              localObject = a(m, 0, paramIPCSpriteContext);
              if (localObject != null) {
                localJSONArray.put(localObject);
              }
            }
            localObject = a(m, 1, paramIPCSpriteContext);
            if (localObject == null) {
              break label420;
            }
            localJSONArray.put(localObject);
            break label420;
          }
          j = -1;
          i = 1;
          QLog.i("CmShow_SpriteRscBuilder", 1, "[insertPrePost], action NOT exist locally, id:" + m);
        }
      }
      catch (Throwable paramSpriteTaskParam)
      {
        JSONArray localJSONArray;
        abxk localabxk;
        int i;
        QLog.e("CmShow_SpriteRscBuilder", 1, "[getWhiteFaceActions],", paramSpriteTaskParam);
        return null;
        if (-1 != j)
        {
          paramSpriteTaskParam = localabxk.a(j);
          if ((paramSpriteTaskParam != null) && (paramSpriteTaskParam.isHasPostAction()))
          {
            paramSpriteTaskParam = a(j, 2, paramIPCSpriteContext);
            if (paramSpriteTaskParam != null) {
              localJSONArray.put(paramSpriteTaskParam);
            }
          }
        }
        if (i != 0) {
          aczo.r(ApolloUtil.a(), 1);
        }
        return localJSONArray;
      }
      finally
      {
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("CmShow_SpriteRscBuilder", 2, new Object[] { "[getWhiteFaceActions], cost:", Long.valueOf(l2 - l1) });
        }
      }
      label420:
      int j = m;
      k += 1;
    }
  }
  
  private static JSONArray a(SpriteTaskParam paramSpriteTaskParam, IPCSpriteContext paramIPCSpriteContext, CmShowRenderView.PlayActionConfig paramPlayActionConfig)
  {
    if ((paramSpriteTaskParam == null) || (paramIPCSpriteContext == null)) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray();
        JSONObject localJSONObject = a(paramSpriteTaskParam.mSenderUin, paramIPCSpriteContext, paramSpriteTaskParam, true, false, paramPlayActionConfig);
        if ((paramIPCSpriteContext.mAioType == 0) || (paramSpriteTaskParam.crb == 1))
        {
          paramSpriteTaskParam = a(paramSpriteTaskParam.bbE, paramIPCSpriteContext, paramSpriteTaskParam, false, false, paramPlayActionConfig);
          if (localJSONObject != null) {
            localJSONArray.put(localJSONObject);
          }
          if (paramSpriteTaskParam != null) {
            localJSONArray.put(paramSpriteTaskParam);
          }
          return localJSONArray;
        }
      }
      catch (Throwable paramSpriteTaskParam)
      {
        QLog.e("CmShow_SpriteRscBuilder", 1, "[getBasicActionJs],", paramSpriteTaskParam);
        return null;
      }
      finally
      {
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("CmShow_SpriteRscBuilder", 2, new Object[] { "[getBasicActionJs], cost:", Long.valueOf(l2 - l1) });
        }
      }
      paramSpriteTaskParam = null;
    }
  }
  
  private static JSONObject a(int paramInt1, int paramInt2, IPCSpriteContext paramIPCSpriteContext)
  {
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject();
      Object localObject = new SpriteTaskParam();
      ((SpriteTaskParam)localObject).mActionId = paramInt1;
      ((SpriteTaskParam)localObject).bGG = paramInt2;
      ((SpriteTaskParam)localObject).mAioType = paramIPCSpriteContext.mAioType;
      ((SpriteTaskParam)localObject).mActionType = 1;
      if (!a((SpriteTaskParam)localObject)) {
        return null;
      }
      localObject = ((abxk)ApolloUtil.a().getManager(155)).a(paramInt1);
      if (localObject == null) {
        return null;
      }
      localJSONObject.put("actionId", paramInt1);
      localJSONObject.put("action", abvg.a(paramInt1, paramInt2, true, paramIPCSpriteContext.Zb())[0]);
      if (((ApolloActionData)localObject).personNum == 1) {
        localJSONObject.put("actionPeer", abvg.a(paramInt1, paramInt2, false, paramIPCSpriteContext.Zb())[0]);
      }
      if (paramIPCSpriteContext.mAioType == 0)
      {
        localJSONObject.put("actionDis", ((ApolloActionData)localObject).actionMoveDis * (float)aqgz.hL() / 7.0F / 368.0F);
        localJSONObject.put("actionPeerDis", ((ApolloActionData)localObject).peerMoveDis * (float)aqgz.hL() / 7.0F / 368.0F);
      }
      else
      {
        localJSONObject.put("posType", ((ApolloActionData)localObject).playArea);
      }
    }
    catch (Throwable paramIPCSpriteContext)
    {
      QLog.e("CmShow_SpriteRscBuilder", 1, "[getWhiteFaceSingleAction],", paramIPCSpriteContext);
      return null;
    }
    return localJSONObject;
  }
  
  public static JSONObject a(SpriteTaskParam paramSpriteTaskParam)
  {
    label349:
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
              QLog.d("CmShow_SpriteRscBuilder", 1, new Object[] { "[getAudioParam] audio not found for " + (String)localObject2, ",action:", Integer.valueOf(paramSpriteTaskParam.mActionId) });
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
          localObject2 = (abhh)ApolloUtil.a().getManager(153);
          ApolloActionData localApolloActionData = ((abxk)ApolloUtil.a().getManager(155)).a(paramSpriteTaskParam.mActionId);
          if ((localApolloActionData != null) && (localApolloActionData.hasSound))
          {
            localObject1 = abxi.bip + paramSpriteTaskParam.mActionId + "/" + "music.amr";
            if (new File((String)localObject1).exists()) {
              break label349;
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
            abto.a(ApolloUtil.a(), null, paramSpriteTaskParam.cre, false);
            localObject1 = localObject2;
            continue;
          }
          return null;
        }
      }
      catch (Exception paramSpriteTaskParam)
      {
        QLog.e("CmShow_SpriteRscBuilder", 1, paramSpriteTaskParam, new Object[0]);
        return null;
      }
    }
  }
  
  private static JSONObject a(String paramString, IPCSpriteContext paramIPCSpriteContext, SpriteTaskParam paramSpriteTaskParam, boolean paramBoolean1, boolean paramBoolean2, CmShowRenderView.PlayActionConfig paramPlayActionConfig)
  {
    JSONObject localJSONObject;
    for (;;)
    {
      int m;
      int i;
      int j;
      int n;
      try
      {
        localJSONObject = a(paramString, paramIPCSpriteContext, false);
        if (!a(paramSpriteTaskParam)) {
          return localJSONObject;
        }
        m = abhh.h(ApolloUtil.a(), paramString);
        i = ((Integer)abvg.a(paramString, m, ApolloUtil.a(), true)[0]).intValue();
        paramString = abvg.a(paramString, ApolloUtil.a(), true);
        if ((paramString == null) || (paramString.length != 2)) {
          break label603;
        }
        j = ((Integer)paramString[0]).intValue();
        if (paramSpriteTaskParam == null) {
          break;
        }
        if (!paramBoolean1) {
          break label607;
        }
        k = 1;
        localJSONObject.put("isMaster", k);
        if ((paramBoolean1) && (!TextUtils.isEmpty(paramSpriteTaskParam.bhv)))
        {
          localJSONObject.put("text", abrj.replaceBlank(aqgo.encodeToString(paramSpriteTaskParam.bhv.getBytes("utf-8"), 0)));
          if (paramSpriteTaskParam.bEW) {
            continue;
          }
          localJSONObject.put("bubbleType", 0);
          if ((m == 1) && (paramSpriteTaskParam.mActionId > abxi.ctt) && (abhh.R(ApolloUtil.a())))
          {
            k = 2;
            localJSONObject.put("bubble", f(paramSpriteTaskParam.bhv, j, k));
          }
        }
        else
        {
          n = paramSpriteTaskParam.crh;
          i1 = paramSpriteTaskParam.mActionId;
          if (i < 0) {
            break label305;
          }
          k = i;
          paramString = abvg.a(n, i1, k, paramBoolean1, m, paramPlayActionConfig);
          if (paramString == null) {
            break label605;
          }
          if (paramString.length >= 2) {
            break label312;
          }
          break label605;
        }
        if ((m != 2) || (paramSpriteTaskParam.mActionId >= abxi.ctt)) {
          break label596;
        }
        k = 1;
        continue;
        localJSONObject.put("bubbleType", 1);
        continue;
        k = j;
      }
      catch (Throwable paramString)
      {
        QLog.e("CmShow_SpriteRscBuilder", 1, paramString, new Object[0]);
        return null;
      }
      label305:
      continue;
      label312:
      if ((paramSpriteTaskParam.crb == 0) && (paramIPCSpriteContext.mAioType == 0) && (!paramBoolean1) && (!paramBoolean2)) {
        break;
      }
      paramIPCSpriteContext = paramString[0];
      paramString = paramIPCSpriteContext;
      if (8 == paramSpriteTaskParam.mActionType)
      {
        paramString = paramIPCSpriteContext;
        if (!TextUtils.isEmpty(paramSpriteTaskParam.bhw))
        {
          String str = a(paramBoolean1, paramSpriteTaskParam.bhw, paramSpriteTaskParam.mActionId);
          paramString = paramIPCSpriteContext;
          if (!TextUtils.isEmpty(str)) {
            paramString = paramIPCSpriteContext + str;
          }
        }
      }
      localJSONObject.put("action", paramString);
      if (paramPlayActionConfig == null) {
        break;
      }
      int i1 = paramPlayActionConfig.cri;
      paramPlayActionConfig.cri = 1;
      int i2 = paramSpriteTaskParam.mActionId;
      if (i >= 0)
      {
        k = i;
        localJSONObject.put("preAction", abvg.a(n, i2, k, paramBoolean1, m, paramPlayActionConfig)[0]);
        paramPlayActionConfig.cri = 2;
        i2 = paramSpriteTaskParam.mActionId;
        if (i < 0) {
          break label582;
        }
        k = i;
        label498:
        localJSONObject.put("mainAction", abvg.a(n, i2, k, paramBoolean1, m, paramPlayActionConfig)[0]);
        paramPlayActionConfig.cri = 3;
        k = paramSpriteTaskParam.mActionId;
        if (i < 0) {
          break label589;
        }
      }
      for (;;)
      {
        localJSONObject.put("postAction", abvg.a(n, k, i, paramBoolean1, m, paramPlayActionConfig)[0]);
        paramPlayActionConfig.cri = i1;
        break label613;
        k = j;
        break;
        label582:
        k = j;
        break label498;
        label589:
        i = j;
      }
      label596:
      int k = m;
      continue;
      label603:
      return null;
      label605:
      return null;
      label607:
      k = 0;
    }
    label613:
    return localJSONObject;
  }
  
  private static JSONObject a(String paramString, IPCSpriteContext paramIPCSpriteContext, boolean paramBoolean)
  {
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("uin", paramString);
      abvg.a(paramString, ApolloUtil.a(), localJSONObject);
      Object localObject = abvg.a(paramString, ApolloUtil.a(), true);
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
      if (((paramIPCSpriteContext.mAioType == 1) || (paramIPCSpriteContext.mAioType == 3000)) && (!"-1".equals(paramString)) && (!"-2".equals(paramString)))
      {
        localJSONObject.put("nameplate", a(ApolloUtil.a(), paramString, j, paramBoolean));
        localObject = paramIPCSpriteContext.mSelfUin;
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).equals(paramString))) {
          break label418;
        }
      }
      label418:
      for (localObject = acfp.m(2131714732);; localObject = abrj.a(ApolloUtil.a(), paramIPCSpriteContext.mAioType, paramString, paramIPCSpriteContext.mFriendUin, true))
      {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localJSONObject.put("nickname", abrj.replaceBlank(aqgo.encodeToString(((String)localObject).getBytes("utf-8"), 0)));
        }
        localJSONObject.put("scale", paramIPCSpriteContext.scale);
        if (paramIPCSpriteContext.xPos != -2.147484E+009F) {
          localJSONObject.put("xPos", paramIPCSpriteContext.xPos);
        }
        if (paramIPCSpriteContext.bU != -2.147484E+009F) {
          localJSONObject.put("yPos", paramIPCSpriteContext.bU);
        }
        if ((TextUtils.isEmpty(paramIPCSpriteContext.mSelfUin)) || (!paramIPCSpriteContext.mSelfUin.equals(paramString))) {
          break;
        }
        localJSONObject.put("rotate", paramIPCSpriteContext.crp);
        break label469;
      }
      localJSONObject.put("rotate", paramIPCSpriteContext.crq);
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteRscBuilder", 1, paramString, new Object[0]);
      return null;
    }
    label469:
    return localJSONObject;
  }
  
  public static boolean a(SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam == null) {
      return false;
    }
    if (paramSpriteTaskParam.crh == 1) {
      return b(paramSpriteTaskParam);
    }
    if (paramSpriteTaskParam.crh == 6)
    {
      if (!ApolloUtil.aH(5, paramSpriteTaskParam.mActionId))
      {
        abto.b(ApolloUtil.a(), ApolloUtil.dr(paramSpriteTaskParam.mActionId) + "/d.zip", ApolloUtil.ds(paramSpriteTaskParam.mActionId));
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
        abto.b(ApolloUtil.a(), (String)localObject, paramSpriteTaskParam);
        return false;
      }
    }
    else if ((paramSpriteTaskParam.crh == 11) || (paramSpriteTaskParam.crh == 7))
    {
      paramSpriteTaskParam = abvg.a(paramSpriteTaskParam.crh, paramSpriteTaskParam.mActionId, 0, true);
      if ((paramSpriteTaskParam.length > 0) && (!TextUtils.isEmpty(paramSpriteTaskParam[0])) && (!new File(ApolloRender.getRscStaticPath(paramSpriteTaskParam[0], "json")).exists()))
      {
        abto.a(ApolloUtil.a(), ApolloUtil.a().getCurrentAccountUin(), null, 0, null, -1, -1, true);
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  private static JSONArray b(SpriteTaskParam paramSpriteTaskParam, IPCSpriteContext paramIPCSpriteContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +7 -> 12
    //   8: aconst_null
    //   9: astore_0
    //   10: aload_0
    //   11: areturn
    //   12: invokestatic 328	java/lang/System:currentTimeMillis	()J
    //   15: lstore_2
    //   16: new 192	org/json/JSONArray
    //   19: dup
    //   20: invokespecial 193	org/json/JSONArray:<init>	()V
    //   23: astore 6
    //   25: aload_1
    //   26: getfield 387	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:mAioType	I
    //   29: ifne +132 -> 161
    //   32: aload_1
    //   33: getfield 196	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:mSelfUin	Ljava/lang/String;
    //   36: aload_1
    //   37: iconst_1
    //   38: invokestatic 199	absk:a	(Ljava/lang/String;Lcom/tencent/mobileqq/apollo/sdk/IPCSpriteContext;Z)Lorg/json/JSONObject;
    //   41: astore_0
    //   42: aload_1
    //   43: getfield 205	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:mFriendUin	Ljava/lang/String;
    //   46: aload_1
    //   47: iconst_0
    //   48: invokestatic 199	absk:a	(Ljava/lang/String;Lcom/tencent/mobileqq/apollo/sdk/IPCSpriteContext;Z)Lorg/json/JSONObject;
    //   51: astore 7
    //   53: aload_1
    //   54: getfield 196	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:mSelfUin	Ljava/lang/String;
    //   57: aload_1
    //   58: iconst_1
    //   59: invokestatic 670	absk:b	(Ljava/lang/String;Lcom/tencent/mobileqq/apollo/sdk/IPCSpriteContext;Z)Lorg/json/JSONObject;
    //   62: astore 8
    //   64: aload_1
    //   65: getfield 205	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:mFriendUin	Ljava/lang/String;
    //   68: aload_1
    //   69: iconst_0
    //   70: invokestatic 670	absk:b	(Ljava/lang/String;Lcom/tencent/mobileqq/apollo/sdk/IPCSpriteContext;Z)Lorg/json/JSONObject;
    //   73: astore_1
    //   74: aload 8
    //   76: ifnull +13 -> 89
    //   79: aload_0
    //   80: ldc_w 672
    //   83: aload 8
    //   85: invokevirtual 91	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   88: pop
    //   89: aload_1
    //   90: ifnull +13 -> 103
    //   93: aload 7
    //   95: ldc_w 672
    //   98: aload_1
    //   99: invokevirtual 91	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   102: pop
    //   103: aload 6
    //   105: aload_0
    //   106: invokevirtual 202	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   109: pop
    //   110: aload 6
    //   112: aload 7
    //   114: invokevirtual 202	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   117: pop
    //   118: invokestatic 328	java/lang/System:currentTimeMillis	()J
    //   121: lstore 4
    //   123: aload 6
    //   125: astore_0
    //   126: invokestatic 238	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq -119 -> 10
    //   132: ldc 181
    //   134: iconst_2
    //   135: iconst_2
    //   136: anewarray 4	java/lang/Object
    //   139: dup
    //   140: iconst_0
    //   141: ldc_w 674
    //   144: aastore
    //   145: dup
    //   146: iconst_1
    //   147: lload 4
    //   149: lload_2
    //   150: lsub
    //   151: invokestatic 375	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   154: aastore
    //   155: invokestatic 266	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   158: aload 6
    //   160: areturn
    //   161: aload_0
    //   162: getfield 171	com/tencent/mobileqq/apollo/script/SpriteTaskParam:mSenderUin	Ljava/lang/String;
    //   165: aload_1
    //   166: iconst_1
    //   167: invokestatic 199	absk:a	(Ljava/lang/String;Lcom/tencent/mobileqq/apollo/sdk/IPCSpriteContext;Z)Lorg/json/JSONObject;
    //   170: astore_0
    //   171: aload_1
    //   172: getfield 196	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:mSelfUin	Ljava/lang/String;
    //   175: aload_1
    //   176: iconst_1
    //   177: invokestatic 670	absk:b	(Ljava/lang/String;Lcom/tencent/mobileqq/apollo/sdk/IPCSpriteContext;Z)Lorg/json/JSONObject;
    //   180: astore_1
    //   181: aload_1
    //   182: ifnull +12 -> 194
    //   185: aload_0
    //   186: ldc_w 672
    //   189: aload_1
    //   190: invokevirtual 91	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   193: pop
    //   194: aload 6
    //   196: aload_0
    //   197: invokevirtual 202	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   200: pop
    //   201: goto -83 -> 118
    //   204: astore_0
    //   205: ldc 181
    //   207: iconst_1
    //   208: ldc_w 676
    //   211: aload_0
    //   212: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   215: invokestatic 328	java/lang/System:currentTimeMillis	()J
    //   218: lstore 4
    //   220: invokestatic 238	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +29 -> 252
    //   226: ldc 181
    //   228: iconst_2
    //   229: iconst_2
    //   230: anewarray 4	java/lang/Object
    //   233: dup
    //   234: iconst_0
    //   235: ldc_w 674
    //   238: aastore
    //   239: dup
    //   240: iconst_1
    //   241: lload 4
    //   243: lload_2
    //   244: lsub
    //   245: invokestatic 375	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   248: aastore
    //   249: invokestatic 266	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   252: aconst_null
    //   253: areturn
    //   254: astore_0
    //   255: invokestatic 328	java/lang/System:currentTimeMillis	()J
    //   258: lstore 4
    //   260: invokestatic 238	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq +29 -> 292
    //   266: ldc 181
    //   268: iconst_2
    //   269: iconst_2
    //   270: anewarray 4	java/lang/Object
    //   273: dup
    //   274: iconst_0
    //   275: ldc_w 674
    //   278: aastore
    //   279: dup
    //   280: iconst_1
    //   281: lload 4
    //   283: lload_2
    //   284: lsub
    //   285: invokestatic 375	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   288: aastore
    //   289: invokestatic 266	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   292: aload_0
    //   293: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	paramSpriteTaskParam	SpriteTaskParam
    //   0	294	1	paramIPCSpriteContext	IPCSpriteContext
    //   15	269	2	l1	long
    //   121	161	4	l2	long
    //   23	172	6	localJSONArray	JSONArray
    //   51	62	7	localJSONObject1	JSONObject
    //   62	22	8	localJSONObject2	JSONObject
    // Exception table:
    //   from	to	target	type
    //   16	74	204	java/lang/Throwable
    //   79	89	204	java/lang/Throwable
    //   93	103	204	java/lang/Throwable
    //   103	118	204	java/lang/Throwable
    //   161	181	204	java/lang/Throwable
    //   185	194	204	java/lang/Throwable
    //   194	201	204	java/lang/Throwable
    //   16	74	254	finally
    //   79	89	254	finally
    //   93	103	254	finally
    //   103	118	254	finally
    //   161	181	254	finally
    //   185	194	254	finally
    //   194	201	254	finally
    //   205	215	254	finally
  }
  
  /* Error */
  public static JSONObject b(String paramString, IPCSpriteContext paramIPCSpriteContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 52	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 53	org/json/JSONObject:<init>	()V
    //   7: astore 13
    //   9: iconst_1
    //   10: istore 10
    //   12: iconst_1
    //   13: istore 11
    //   15: iconst_1
    //   16: istore 5
    //   18: iconst_m1
    //   19: istore 4
    //   21: new 336	java/util/ArrayList
    //   24: dup
    //   25: invokespecial 677	java/util/ArrayList:<init>	()V
    //   28: astore 14
    //   30: invokestatic 116	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   33: sipush 153
    //   36: invokevirtual 216	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   39: checkcast 218	abhh
    //   42: astore 12
    //   44: iload 4
    //   46: istore 8
    //   48: iload 10
    //   50: istore 6
    //   52: iload 4
    //   54: istore 9
    //   56: iload 11
    //   58: istore 7
    //   60: aload 12
    //   62: aload_0
    //   63: invokevirtual 680	abhh:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ApolloBaseInfo;
    //   66: astore 15
    //   68: aload 15
    //   70: ifnonnull +5 -> 75
    //   73: aconst_null
    //   74: areturn
    //   75: iload 4
    //   77: istore 8
    //   79: iload 10
    //   81: istore 6
    //   83: iload 4
    //   85: istore 9
    //   87: iload 11
    //   89: istore 7
    //   91: aload 15
    //   93: invokevirtual 686	com/tencent/mobileqq/data/ApolloBaseInfo:getApolloPetDress	()Labkd;
    //   96: astore 16
    //   98: aload 16
    //   100: ifnull +968 -> 1068
    //   103: iload 4
    //   105: istore 8
    //   107: iload 10
    //   109: istore 6
    //   111: iload 4
    //   113: istore 9
    //   115: iload 11
    //   117: istore 7
    //   119: aload 15
    //   121: getfield 689	com/tencent/mobileqq/data/ApolloBaseInfo:hasPet	Z
    //   124: ifeq +944 -> 1068
    //   127: iload 4
    //   129: istore 8
    //   131: iload 10
    //   133: istore 6
    //   135: iload 4
    //   137: istore 9
    //   139: iload 11
    //   141: istore 7
    //   143: aload 16
    //   145: getfield 695	abkd:in	Ljava/util/HashMap;
    //   148: ifnull +920 -> 1068
    //   151: iload 4
    //   153: istore 8
    //   155: iload 10
    //   157: istore 6
    //   159: iload 4
    //   161: istore 9
    //   163: iload 11
    //   165: istore 7
    //   167: aload 16
    //   169: getfield 695	abkd:in	Ljava/util/HashMap;
    //   172: invokevirtual 697	java/util/HashMap:isEmpty	()Z
    //   175: ifne +893 -> 1068
    //   178: iload 4
    //   180: istore 8
    //   182: iload 10
    //   184: istore 6
    //   186: iload 4
    //   188: istore 9
    //   190: iload 11
    //   192: istore 7
    //   194: aload 13
    //   196: ldc_w 587
    //   199: iconst_0
    //   200: aload 16
    //   202: getfield 700	abkd:roleId	I
    //   205: invokestatic 583	abvg:z	(II)Ljava/lang/String;
    //   208: invokevirtual 91	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   211: pop
    //   212: iload 4
    //   214: istore_3
    //   215: iload 4
    //   217: istore 8
    //   219: iload 10
    //   221: istore 6
    //   223: iload 4
    //   225: istore 9
    //   227: iload 11
    //   229: istore 7
    //   231: iconst_1
    //   232: aload 16
    //   234: getfield 700	abkd:roleId	I
    //   237: invokestatic 703	com/tencent/mobileqq/apollo/utils/ApolloUtil:aG	(II)Z
    //   240: ifne +26 -> 266
    //   243: iconst_0
    //   244: istore 6
    //   246: iconst_0
    //   247: istore 7
    //   249: iconst_0
    //   250: istore 5
    //   252: iload 4
    //   254: istore 8
    //   256: iload 4
    //   258: istore 9
    //   260: aload 16
    //   262: getfield 700	abkd:roleId	I
    //   265: istore_3
    //   266: iload_3
    //   267: istore 8
    //   269: iload 5
    //   271: istore 6
    //   273: iload_3
    //   274: istore 9
    //   276: iload 5
    //   278: istore 7
    //   280: aload 16
    //   282: getfield 695	abkd:in	Ljava/util/HashMap;
    //   285: invokevirtual 704	java/util/HashMap:size	()I
    //   288: newarray int
    //   290: astore 17
    //   292: iload_3
    //   293: istore 8
    //   295: iload 5
    //   297: istore 6
    //   299: iload_3
    //   300: istore 9
    //   302: iload 5
    //   304: istore 7
    //   306: aload 16
    //   308: getfield 695	abkd:in	Ljava/util/HashMap;
    //   311: invokevirtual 708	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   314: invokeinterface 714 1 0
    //   319: astore 18
    //   321: iconst_0
    //   322: istore 4
    //   324: iload_3
    //   325: istore 8
    //   327: iload 5
    //   329: istore 6
    //   331: iload_3
    //   332: istore 9
    //   334: iload 5
    //   336: istore 7
    //   338: aload 18
    //   340: invokeinterface 719 1 0
    //   345: ifeq +52 -> 397
    //   348: iload_3
    //   349: istore 8
    //   351: iload 5
    //   353: istore 6
    //   355: iload_3
    //   356: istore 9
    //   358: iload 5
    //   360: istore 7
    //   362: aload 17
    //   364: iload 4
    //   366: aload 18
    //   368: invokeinterface 723 1 0
    //   373: checkcast 725	java/util/Map$Entry
    //   376: invokeinterface 728 1 0
    //   381: checkcast 260	java/lang/Integer
    //   384: invokevirtual 347	java/lang/Integer:intValue	()I
    //   387: iastore
    //   388: iload 4
    //   390: iconst_1
    //   391: iadd
    //   392: istore 4
    //   394: goto -70 -> 324
    //   397: iload_3
    //   398: istore 8
    //   400: iload 5
    //   402: istore 6
    //   404: iload_3
    //   405: istore 9
    //   407: iload 5
    //   409: istore 7
    //   411: new 192	org/json/JSONArray
    //   414: dup
    //   415: invokespecial 193	org/json/JSONArray:<init>	()V
    //   418: astore 18
    //   420: iload_3
    //   421: istore 8
    //   423: iload 5
    //   425: istore 6
    //   427: iload_3
    //   428: istore 9
    //   430: iload 5
    //   432: istore 7
    //   434: aload 17
    //   436: arraylength
    //   437: istore 10
    //   439: iload 5
    //   441: istore 4
    //   443: iconst_0
    //   444: istore 7
    //   446: iload 7
    //   448: iload 10
    //   450: if_icmpge +72 -> 522
    //   453: aload 17
    //   455: iload 7
    //   457: iaload
    //   458: istore 8
    //   460: iload 4
    //   462: istore 5
    //   464: iload 4
    //   466: istore 6
    //   468: aload 18
    //   470: iconst_1
    //   471: iload 8
    //   473: invokestatic 583	abvg:z	(II)Ljava/lang/String;
    //   476: invokevirtual 202	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   479: pop
    //   480: iload 4
    //   482: istore 5
    //   484: iload 4
    //   486: istore 6
    //   488: iconst_2
    //   489: iload 8
    //   491: invokestatic 703	com/tencent/mobileqq/apollo/utils/ApolloUtil:aG	(II)Z
    //   494: ifne +917 -> 1411
    //   497: iconst_0
    //   498: istore 6
    //   500: iconst_0
    //   501: istore 4
    //   503: iconst_0
    //   504: istore 5
    //   506: aload 14
    //   508: iload 8
    //   510: invokestatic 263	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   513: invokeinterface 733 2 0
    //   518: pop
    //   519: goto +892 -> 1411
    //   522: iload 4
    //   524: istore 5
    //   526: iload 4
    //   528: istore 6
    //   530: aload 13
    //   532: ldc_w 585
    //   535: aload 18
    //   537: invokevirtual 91	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   540: pop
    //   541: iload 4
    //   543: istore 5
    //   545: iload 4
    //   547: istore 6
    //   549: aload 13
    //   551: ldc_w 734
    //   554: aload 16
    //   556: getfield 700	abkd:roleId	I
    //   559: invokevirtual 96	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   562: pop
    //   563: iload 4
    //   565: istore 5
    //   567: iload 4
    //   569: istore 6
    //   571: aload 16
    //   573: getfield 700	abkd:roleId	I
    //   576: ldc_w 736
    //   579: invokestatic 740	absk:u	(ILjava/lang/String;)Ljava/lang/String;
    //   582: astore 17
    //   584: iload 4
    //   586: istore 5
    //   588: iload 4
    //   590: istore 6
    //   592: aload 16
    //   594: getfield 700	abkd:roleId	I
    //   597: ldc_w 742
    //   600: invokestatic 740	absk:u	(ILjava/lang/String;)Ljava/lang/String;
    //   603: astore 18
    //   605: iload 4
    //   607: istore 5
    //   609: iload 4
    //   611: istore 6
    //   613: aload 17
    //   615: invokestatic 154	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   618: ifne +57 -> 675
    //   621: iload 4
    //   623: istore 5
    //   625: iload 4
    //   627: istore 6
    //   629: aload 18
    //   631: invokestatic 154	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   634: ifne +41 -> 675
    //   637: iload 4
    //   639: istore 5
    //   641: iload 4
    //   643: istore 6
    //   645: aload 13
    //   647: ldc_w 744
    //   650: aload 18
    //   652: invokevirtual 91	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   655: pop
    //   656: iload 4
    //   658: istore 5
    //   660: iload 4
    //   662: istore 6
    //   664: aload 13
    //   666: ldc_w 746
    //   669: aload 17
    //   671: invokevirtual 91	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   674: pop
    //   675: iload 4
    //   677: istore 5
    //   679: iload 4
    //   681: istore 6
    //   683: aload 16
    //   685: getfield 700	abkd:roleId	I
    //   688: invokestatic 749	absk:dg	(I)Ljava/lang/String;
    //   691: astore 17
    //   693: iload 4
    //   695: istore 5
    //   697: iload 4
    //   699: istore 6
    //   701: aload 17
    //   703: invokestatic 154	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   706: ifne +22 -> 728
    //   709: iload 4
    //   711: istore 5
    //   713: iload 4
    //   715: istore 6
    //   717: aload 13
    //   719: ldc_w 751
    //   722: aload 17
    //   724: invokevirtual 91	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   727: pop
    //   728: iload 4
    //   730: istore 5
    //   732: iload 4
    //   734: istore 6
    //   736: aload 15
    //   738: getfield 754	com/tencent/mobileqq/data/ApolloBaseInfo:petNick	Ljava/lang/String;
    //   741: invokestatic 154	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   744: ifne +53 -> 797
    //   747: iload 4
    //   749: istore 5
    //   751: iload 4
    //   753: istore 6
    //   755: aload_1
    //   756: getfield 58	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:cqU	I
    //   759: ifne +38 -> 797
    //   762: iload 4
    //   764: istore 5
    //   766: iload 4
    //   768: istore 6
    //   770: aload 13
    //   772: ldc_w 603
    //   775: aload 15
    //   777: getfield 754	com/tencent/mobileqq/data/ApolloBaseInfo:petNick	Ljava/lang/String;
    //   780: ldc_w 520
    //   783: invokevirtual 524	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   786: iconst_0
    //   787: invokestatic 530	aqgo:encodeToString	([BI)Ljava/lang/String;
    //   790: invokestatic 533	abrj:replaceBlank	(Ljava/lang/String;)Ljava/lang/String;
    //   793: invokevirtual 91	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   796: pop
    //   797: iload 4
    //   799: istore 5
    //   801: iload 4
    //   803: istore 6
    //   805: aload 13
    //   807: ldc_w 593
    //   810: aload 12
    //   812: getfield 757	abhh:bfZ	Ljava/lang/String;
    //   815: aload 16
    //   817: getfield 700	abkd:roleId	I
    //   820: iload_2
    //   821: invokestatic 761	absk:c	(Ljava/lang/String;IZ)Ljava/lang/String;
    //   824: invokevirtual 91	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   827: pop
    //   828: iload 4
    //   830: istore 5
    //   832: iload 4
    //   834: istore 6
    //   836: aload 13
    //   838: ldc_w 605
    //   841: aload_1
    //   842: getfield 607	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:scale	F
    //   845: f2d
    //   846: invokevirtual 432	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   849: pop
    //   850: iload 4
    //   852: istore 5
    //   854: iload 4
    //   856: istore 6
    //   858: aload_1
    //   859: getfield 610	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:xPos	F
    //   862: ldc_w 611
    //   865: fcmpl
    //   866: ifeq +25 -> 891
    //   869: iload 4
    //   871: istore 5
    //   873: iload 4
    //   875: istore 6
    //   877: aload 13
    //   879: ldc_w 612
    //   882: aload_1
    //   883: getfield 610	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:xPos	F
    //   886: f2d
    //   887: invokevirtual 432	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   890: pop
    //   891: iload 4
    //   893: istore 5
    //   895: iload 4
    //   897: istore 6
    //   899: aload_1
    //   900: getfield 615	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:bU	F
    //   903: ldc_w 611
    //   906: fcmpl
    //   907: ifeq +25 -> 932
    //   910: iload 4
    //   912: istore 5
    //   914: iload 4
    //   916: istore 6
    //   918: aload 13
    //   920: ldc_w 617
    //   923: aload_1
    //   924: getfield 615	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:bU	F
    //   927: f2d
    //   928: invokevirtual 432	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   931: pop
    //   932: iload 4
    //   934: ifeq +108 -> 1042
    //   937: iload 4
    //   939: ifne +469 -> 1408
    //   942: aload_1
    //   943: ifnull +465 -> 1408
    //   946: invokestatic 116	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   949: ifnull +459 -> 1408
    //   952: ldc_w 763
    //   955: iconst_1
    //   956: new 300	java/lang/StringBuilder
    //   959: dup
    //   960: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   963: ldc_w 765
    //   966: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   969: aload_0
    //   970: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   976: invokestatic 322	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   979: aload 12
    //   981: ifnull +427 -> 1408
    //   984: aload 14
    //   986: invokeinterface 766 1 0
    //   991: newarray int
    //   993: astore_1
    //   994: aload 14
    //   996: invokeinterface 767 1 0
    //   1001: astore 14
    //   1003: iconst_0
    //   1004: istore 4
    //   1006: aload 14
    //   1008: invokeinterface 719 1 0
    //   1013: ifeq +35 -> 1048
    //   1016: aload_1
    //   1017: iload 4
    //   1019: aload 14
    //   1021: invokeinterface 723 1 0
    //   1026: checkcast 260	java/lang/Integer
    //   1029: invokevirtual 347	java/lang/Integer:intValue	()I
    //   1032: iastore
    //   1033: iload 4
    //   1035: iconst_1
    //   1036: iadd
    //   1037: istore 4
    //   1039: goto -33 -> 1006
    //   1042: aconst_null
    //   1043: astore 13
    //   1045: goto -108 -> 937
    //   1048: invokestatic 116	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1051: aload_0
    //   1052: aload 12
    //   1054: invokevirtual 770	abhh:a	()Labto$b;
    //   1057: iload_3
    //   1058: aload_1
    //   1059: iconst_m1
    //   1060: iconst_m1
    //   1061: iconst_1
    //   1062: invokestatic 668	abto:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Labto$b;I[IIIZ)V
    //   1065: aload 13
    //   1067: areturn
    //   1068: aconst_null
    //   1069: areturn
    //   1070: astore 13
    //   1072: aconst_null
    //   1073: astore 12
    //   1075: iconst_1
    //   1076: istore 5
    //   1078: iload 4
    //   1080: istore_3
    //   1081: iload 5
    //   1083: istore 4
    //   1085: ldc 181
    //   1087: iconst_1
    //   1088: aload 13
    //   1090: iconst_0
    //   1091: anewarray 4	java/lang/Object
    //   1094: invokestatic 505	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1097: iload 4
    //   1099: ifne +120 -> 1219
    //   1102: aload_1
    //   1103: ifnull +116 -> 1219
    //   1106: invokestatic 116	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1109: ifnull +110 -> 1219
    //   1112: ldc_w 763
    //   1115: iconst_1
    //   1116: new 300	java/lang/StringBuilder
    //   1119: dup
    //   1120: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   1123: ldc_w 765
    //   1126: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1129: aload_0
    //   1130: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1133: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1136: invokestatic 322	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1139: aload 12
    //   1141: ifnull +78 -> 1219
    //   1144: aload 14
    //   1146: invokeinterface 766 1 0
    //   1151: newarray int
    //   1153: astore_1
    //   1154: aload 14
    //   1156: invokeinterface 767 1 0
    //   1161: astore 13
    //   1163: iconst_0
    //   1164: istore 4
    //   1166: aload 13
    //   1168: invokeinterface 719 1 0
    //   1173: ifeq +29 -> 1202
    //   1176: aload_1
    //   1177: iload 4
    //   1179: aload 13
    //   1181: invokeinterface 723 1 0
    //   1186: checkcast 260	java/lang/Integer
    //   1189: invokevirtual 347	java/lang/Integer:intValue	()I
    //   1192: iastore
    //   1193: iload 4
    //   1195: iconst_1
    //   1196: iadd
    //   1197: istore 4
    //   1199: goto -33 -> 1166
    //   1202: invokestatic 116	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1205: aload_0
    //   1206: aload 12
    //   1208: invokevirtual 770	abhh:a	()Labto$b;
    //   1211: iload_3
    //   1212: aload_1
    //   1213: iconst_m1
    //   1214: iconst_m1
    //   1215: iconst_1
    //   1216: invokestatic 668	abto:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Labto$b;I[IIIZ)V
    //   1219: aconst_null
    //   1220: areturn
    //   1221: astore 13
    //   1223: aconst_null
    //   1224: astore 12
    //   1226: iconst_1
    //   1227: istore 5
    //   1229: iload 4
    //   1231: istore_3
    //   1232: iload 5
    //   1234: istore 4
    //   1236: iload 4
    //   1238: ifne +120 -> 1358
    //   1241: aload_1
    //   1242: ifnull +116 -> 1358
    //   1245: invokestatic 116	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1248: ifnull +110 -> 1358
    //   1251: ldc_w 763
    //   1254: iconst_1
    //   1255: new 300	java/lang/StringBuilder
    //   1258: dup
    //   1259: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   1262: ldc_w 765
    //   1265: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1268: aload_0
    //   1269: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1272: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1275: invokestatic 322	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1278: aload 12
    //   1280: ifnull +78 -> 1358
    //   1283: aload 14
    //   1285: invokeinterface 766 1 0
    //   1290: newarray int
    //   1292: astore_1
    //   1293: aload 14
    //   1295: invokeinterface 767 1 0
    //   1300: astore 14
    //   1302: iconst_0
    //   1303: istore 4
    //   1305: aload 14
    //   1307: invokeinterface 719 1 0
    //   1312: ifeq +29 -> 1341
    //   1315: aload_1
    //   1316: iload 4
    //   1318: aload 14
    //   1320: invokeinterface 723 1 0
    //   1325: checkcast 260	java/lang/Integer
    //   1328: invokevirtual 347	java/lang/Integer:intValue	()I
    //   1331: iastore
    //   1332: iload 4
    //   1334: iconst_1
    //   1335: iadd
    //   1336: istore 4
    //   1338: goto -33 -> 1305
    //   1341: invokestatic 116	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1344: aload_0
    //   1345: aload 12
    //   1347: invokevirtual 770	abhh:a	()Labto$b;
    //   1350: iload_3
    //   1351: aload_1
    //   1352: iconst_m1
    //   1353: iconst_m1
    //   1354: iconst_1
    //   1355: invokestatic 668	abto:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Labto$b;I[IIIZ)V
    //   1358: aload 13
    //   1360: athrow
    //   1361: astore 13
    //   1363: iload 6
    //   1365: istore 4
    //   1367: iload 8
    //   1369: istore_3
    //   1370: goto -134 -> 1236
    //   1373: astore 13
    //   1375: iload 5
    //   1377: istore 4
    //   1379: goto -143 -> 1236
    //   1382: astore 13
    //   1384: goto -148 -> 1236
    //   1387: astore 13
    //   1389: iload 7
    //   1391: istore 4
    //   1393: iload 9
    //   1395: istore_3
    //   1396: goto -311 -> 1085
    //   1399: astore 13
    //   1401: iload 6
    //   1403: istore 4
    //   1405: goto -320 -> 1085
    //   1408: aload 13
    //   1410: areturn
    //   1411: iload 7
    //   1413: iconst_1
    //   1414: iadd
    //   1415: istore 7
    //   1417: goto -971 -> 446
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1420	0	paramString	String
    //   0	1420	1	paramIPCSpriteContext	IPCSpriteContext
    //   0	1420	2	paramBoolean	boolean
    //   214	1182	3	i	int
    //   19	1385	4	j	int
    //   16	1360	5	k	int
    //   50	1352	6	m	int
    //   58	1358	7	n	int
    //   46	1322	8	i1	int
    //   54	1340	9	i2	int
    //   10	441	10	i3	int
    //   13	215	11	i4	int
    //   42	1304	12	localabhh	abhh
    //   7	1059	13	localJSONObject	JSONObject
    //   1070	19	13	localThrowable1	Throwable
    //   1161	19	13	localIterator	java.util.Iterator
    //   1221	138	13	localObject1	Object
    //   1361	1	13	localObject2	Object
    //   1373	1	13	localObject3	Object
    //   1382	1	13	localObject4	Object
    //   1387	1	13	localThrowable2	Throwable
    //   1399	10	13	localThrowable3	Throwable
    //   28	1291	14	localObject5	Object
    //   66	710	15	localApolloBaseInfo	ApolloBaseInfo
    //   96	720	16	localabkd	abkd
    //   290	433	17	localObject6	Object
    //   319	332	18	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   30	44	1070	java/lang/Throwable
    //   30	44	1221	finally
    //   60	68	1361	finally
    //   91	98	1361	finally
    //   119	127	1361	finally
    //   143	151	1361	finally
    //   167	178	1361	finally
    //   194	212	1361	finally
    //   231	243	1361	finally
    //   260	266	1361	finally
    //   280	292	1361	finally
    //   306	321	1361	finally
    //   338	348	1361	finally
    //   362	388	1361	finally
    //   411	420	1361	finally
    //   434	439	1361	finally
    //   468	480	1373	finally
    //   488	497	1373	finally
    //   506	519	1373	finally
    //   530	541	1373	finally
    //   549	563	1373	finally
    //   571	584	1373	finally
    //   592	605	1373	finally
    //   613	621	1373	finally
    //   629	637	1373	finally
    //   645	656	1373	finally
    //   664	675	1373	finally
    //   683	693	1373	finally
    //   701	709	1373	finally
    //   717	728	1373	finally
    //   736	747	1373	finally
    //   755	762	1373	finally
    //   770	797	1373	finally
    //   805	828	1373	finally
    //   836	850	1373	finally
    //   858	869	1373	finally
    //   877	891	1373	finally
    //   899	910	1373	finally
    //   918	932	1373	finally
    //   1085	1097	1382	finally
    //   60	68	1387	java/lang/Throwable
    //   91	98	1387	java/lang/Throwable
    //   119	127	1387	java/lang/Throwable
    //   143	151	1387	java/lang/Throwable
    //   167	178	1387	java/lang/Throwable
    //   194	212	1387	java/lang/Throwable
    //   231	243	1387	java/lang/Throwable
    //   260	266	1387	java/lang/Throwable
    //   280	292	1387	java/lang/Throwable
    //   306	321	1387	java/lang/Throwable
    //   338	348	1387	java/lang/Throwable
    //   362	388	1387	java/lang/Throwable
    //   411	420	1387	java/lang/Throwable
    //   434	439	1387	java/lang/Throwable
    //   468	480	1399	java/lang/Throwable
    //   488	497	1399	java/lang/Throwable
    //   506	519	1399	java/lang/Throwable
    //   530	541	1399	java/lang/Throwable
    //   549	563	1399	java/lang/Throwable
    //   571	584	1399	java/lang/Throwable
    //   592	605	1399	java/lang/Throwable
    //   613	621	1399	java/lang/Throwable
    //   629	637	1399	java/lang/Throwable
    //   645	656	1399	java/lang/Throwable
    //   664	675	1399	java/lang/Throwable
    //   683	693	1399	java/lang/Throwable
    //   701	709	1399	java/lang/Throwable
    //   717	728	1399	java/lang/Throwable
    //   736	747	1399	java/lang/Throwable
    //   755	762	1399	java/lang/Throwable
    //   770	797	1399	java/lang/Throwable
    //   805	828	1399	java/lang/Throwable
    //   836	850	1399	java/lang/Throwable
    //   858	869	1399	java/lang/Throwable
    //   877	891	1399	java/lang/Throwable
    //   899	910	1399	java/lang/Throwable
    //   918	932	1399	java/lang/Throwable
  }
  
  public static boolean b(SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam == null) {
      return false;
    }
    if (ApolloUtil.a() == null)
    {
      QLog.e("CmShow_SpriteRscBuilder", 1, "CmShow downloadIfAIOActionNotExist taskParam:" + paramSpriteTaskParam);
      return false;
    }
    long l1 = System.currentTimeMillis();
    abhh localabhh = (abhh)ApolloUtil.a().getManager(153);
    ApolloActionData localApolloActionData = ((abxk)ApolloUtil.a().getManager(155)).a(paramSpriteTaskParam.mActionId);
    if (localApolloActionData == null)
    {
      QLog.i("CmShow_SpriteRscBuilder", 1, "warning: data is null. call checkApolloPanelJsonVer, id:" + paramSpriteTaskParam.mActionId);
      aczo.r(ApolloUtil.a(), 1);
      return false;
    }
    boolean bool1;
    label158:
    label168:
    Object localObject;
    if (paramSpriteTaskParam.mActionType == 1) {
      if (paramSpriteTaskParam.mAioType != 0)
      {
        bool1 = true;
        int j = paramSpriteTaskParam.mActionId;
        int k = paramSpriteTaskParam.bGG;
        if (!bool1) {
          break label339;
        }
        i = 0;
        bool1 = ApolloUtil.b(j, k, i, bool1);
        localObject = ((abrg)ApolloUtil.a().getManager(249)).a();
        if (!bool1)
        {
          if (localObject != null) {
            ((SpriteUIHandler)localObject).d(0, 0, paramSpriteTaskParam.mMsgId);
          }
          bool1 = localabhh.a(localApolloActionData, 4, null);
          if (localObject != null) {
            if (!bool1) {
              break label720;
            }
          }
        }
      }
    }
    label670:
    label676:
    label720:
    for (int i = 0;; i = 6)
    {
      label339:
      label376:
      boolean bool3;
      for (;;)
      {
        ((SpriteUIHandler)localObject).d(i, 1, paramSpriteTaskParam.mMsgId);
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("CmShow_SpriteRscBuilder", 2, new Object[] { "[downloadIfActionNotExist end, actionId:", Integer.valueOf(paramSpriteTaskParam.mActionId), ",costT:", Long.valueOf(l2 - l1), ",threadId:", Long.valueOf(Thread.currentThread().getId()), ",actionType:", Integer.valueOf(paramSpriteTaskParam.mActionType) });
        }
        return true;
        bool1 = false;
        break;
        i = localApolloActionData.personNum;
        break label158;
        if ((ApolloUtil.aF(paramSpriteTaskParam.mActionId, localApolloActionData.personNum)) || (ApolloUtil.jdMethod_if(paramSpriteTaskParam.mActionId)))
        {
          bool1 = true;
          bool3 = bool1;
          if (8 == paramSpriteTaskParam.mActionType)
          {
            bool3 = bool1;
            if (paramSpriteTaskParam.bhw != null)
            {
              bool3 = bool1;
              if (bool1) {
                bool3 = bool1;
              }
            }
          }
        }
        else
        {
          try
          {
            localObject = new JSONObject(paramSpriteTaskParam.bhw).optJSONObject("action");
            bool3 = bool1;
            String str = ((JSONObject)localObject).optString("actionId");
            boolean bool2 = bool1;
            bool3 = bool1;
            if (!TextUtils.isEmpty(str))
            {
              bool3 = bool1;
              i = Integer.parseInt(str);
              bool3 = bool1;
              if (((JSONObject)localObject).optInt("actionPlatform") <= 0) {
                break label670;
              }
              bool4 = true;
              label489:
              bool2 = bool1;
              bool3 = bool1;
              if (!ApolloUtil.a(paramSpriteTaskParam.mActionId, false, i, bool4)) {
                bool2 = false;
              }
            }
            bool1 = bool2;
            bool3 = bool2;
            if (1 == localApolloActionData.personNum)
            {
              bool1 = bool2;
              if (bool2)
              {
                bool3 = bool2;
                str = ((JSONObject)localObject).optString("actionPeerId");
                bool1 = bool2;
                bool3 = bool2;
                if (!TextUtils.isEmpty(str))
                {
                  bool3 = bool2;
                  i = Integer.parseInt(str);
                  bool3 = bool2;
                  if (((JSONObject)localObject).optInt("actionPeerPlatform") <= 0) {
                    break label676;
                  }
                }
              }
            }
            for (boolean bool4 = true;; bool4 = false)
            {
              bool1 = bool2;
              bool3 = bool2;
              if (!ApolloUtil.a(paramSpriteTaskParam.mActionId, true, i, bool4)) {
                bool1 = false;
              }
              if (!bool1)
              {
                bool3 = bool1;
                QLog.e("CmShow_SpriteRscBuilder", 1, "[random] action nis not exist," + paramSpriteTaskParam.bhw);
              }
              break;
              bool1 = false;
              break label376;
              bool4 = false;
              break label489;
            }
            bool1 = bool3;
          }
          catch (Exception localException)
          {
            QLog.e("CmShow_SpriteRscBuilder", 1, "[random] the json is not right," + paramSpriteTaskParam.bhw);
          }
        }
      }
      break label168;
    }
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
            QLog.d("CmShow_SpriteRscBuilder", 2, "[clearAction] clear action success ");
          }
          ((SharedPreferences.Editor)localObject).remove(paramString).apply();
        }
      }
    }
  }
  
  private static String dg(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramInt = ((abhh)ApolloUtil.a().getManager(153)).fV(paramInt);
    if ((paramInt != -1) && (!ApolloUtil.aF(paramInt, 0)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ApolloPet", 2, "download random pet action:" + paramInt);
      }
      Object localObject = new ApolloActionData();
      ((ApolloActionData)localObject).actionId = paramInt;
      String str = ApolloUtil.a((ApolloActionData)localObject, 5);
      localObject = ApolloUtil.a((ApolloActionData)localObject, 4);
      abto.b(ApolloUtil.a(), (String)localObject, str);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (paramInt != -1) {
        localStringBuilder.append(paramInt).append("/action/action");
      }
    }
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
  
  static String u(int paramInt, String paramString)
  {
    return null;
  }
  
  public JSONArray a(JSONArray paramJSONArray)
  {
    JSONArray localJSONArray = new JSONArray();
    if ((this.d == null) || (ApolloUtil.a() == null) || (paramJSONArray == null)) {
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
            break label199;
          }
          if (ApolloUtil.aF(k, 0)) {
            break label168;
          }
          QLog.e("ApolloPet", 1, "getPetActions download:" + k);
          Object localObject = new ApolloActionData();
          ((ApolloActionData)localObject).actionId = k;
          String str = ApolloUtil.a((ApolloActionData)localObject, 5);
          localObject = ApolloUtil.a((ApolloActionData)localObject, 4);
          abto.b(ApolloUtil.a(), (String)localObject, str);
        }
        catch (Exception paramJSONArray)
        {
          QLog.e("ApolloPet", 1, "getPetActions error:", paramJSONArray);
        }
      } else {
        return localJSONArray;
      }
      label168:
      localStringBuilder.setLength(0);
      localStringBuilder.append(k).append("/action/action");
      localJSONArray.put(localStringBuilder.toString());
      label199:
      i += 1;
    }
  }
  
  public Pair<String, Integer> b(String paramString)
  {
    int i = 2;
    Object localObject = new Pair("def/basic/action/4/action/action", Integer.valueOf(0));
    if (TextUtils.isEmpty(paramString)) {
      return localObject;
    }
    StringBuilder localStringBuilder;
    if ((abhh.h(ApolloUtil.a(), paramString) != 2) && (x(ApolloUtil.a(), paramString)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.cqX).append("/action/action");
      SharedPreferences localSharedPreferences = ApolloUtil.a().getApp().getSharedPreferences("apollo_sp", 0);
      if (!localSharedPreferences.getBoolean("stand_type_" + this.cqW, false)) {}
      switch (this.cqW)
      {
      case 4: 
      default: 
        localObject = null;
        abqt localabqt = abrj.a(ApolloUtil.a());
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (localabqt != null)) {
          localabqt.ey(paramString, (String)localObject);
        }
        localSharedPreferences.edit().putBoolean("stand_type_" + this.cqW, true).commit();
        if (this.d.mAioType == 3000)
        {
          label244:
          VipUtils.a(null, "cmshow", "Apollo", "appearanceaction", i, this.cqW, new String[] { String.valueOf(this.cqX) });
          if (this.cqW != 4) {
            break label357;
          }
        }
        break;
      }
    }
    label357:
    for (i = 7;; i = 0)
    {
      return new Pair(localStringBuilder.toString(), Integer.valueOf(i));
      localObject = acfp.m(2131714733);
      break;
      localObject = acfp.m(2131714740);
      break;
      localObject = acfp.m(2131714734);
      break;
      localObject = acfp.m(2131714736);
      break;
      i = this.d.mAioType;
      break label244;
      return localObject;
    }
  }
  
  public void reset()
  {
    if (this.ja != null) {
      this.ja.clear();
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
        break label686;
      }
    }
    label686:
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
            QLog.d("CmShow_SpriteRscBuilder", 2, new Object[] { "hasSpecialStandAction getApolloStandAction openCount:", Integer.valueOf(j), ",lastRequestSpTime:", Long.valueOf(l) });
          }
          iZ.put(paramString, Integer.valueOf(0));
          localaqrb.d(new long[] { Long.parseLong(paramString) });
          localJSONObject.put("lastRequestTime", NetConnInfoCenter.getServerTimeMillis());
          ((SharedPreferences)localObject).edit().putString(paramString, localJSONObject.toString()).commit();
        }
        for (;;)
        {
          if (localJSONArray == null) {
            break label692;
          }
          if (localJSONArray.length() > 0) {
            break;
          }
          break label692;
          iZ.put(paramString, Integer.valueOf(j + 1));
        }
        j = i;
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("CmShow_SpriteRscBuilder", 2, "hasSpecialStandAction error:", paramQQAppInterface);
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
        QLog.d("CmShow_SpriteRscBuilder", 2, new Object[] { "[hasSpecialStandAction] uin:", paramString, ",index:", Integer.valueOf(j), ",id:", Integer.valueOf(this.cqX), ",standType:", Integer.valueOf(this.cqW) });
      }
      if (!ApolloUtil.aF(this.cqX, 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("CmShow_SpriteRscBuilder", 2, "hasSpecialStandAction isActionResDone is false.");
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
    label692:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     absk
 * JD-Core Version:    0.7.0.1
 */