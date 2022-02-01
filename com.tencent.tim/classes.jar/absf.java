import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView.PlayActionConfig;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView.a;
import com.tencent.mobileqq.apollo.sdk.CmShowSpriteDrawerInfoBridge.2;
import com.tencent.mobileqq.apollo.sdk.CmShowSpriteDrawerInfoBridge.3;
import com.tencent.mobileqq.apollo.sdk.CmShowSpriteDrawerInfoBridge.5;
import com.tencent.mobileqq.apollo.sdk.IPCSpriteContext;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class absf
  implements abrl
{
  private abro jdField_a_of_type_Abro;
  private abse jdField_a_of_type_Abse;
  private absl jdField_a_of_type_Absl;
  private absk c;
  private HashMap<String, Integer> iy = new HashMap();
  
  public absf(abse paramabse, abro paramabro, absk paramabsk, absl paramabsl)
  {
    this.jdField_a_of_type_Abse = paramabse;
    this.jdField_a_of_type_Abro = paramabro;
    this.c = paramabsk;
    this.jdField_a_of_type_Absl = paramabsl;
  }
  
  private boolean aD(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Abse == null) {}
    while (this.jdField_a_of_type_Absl.a(paramInt1, paramInt2) == null) {
      return false;
    }
    return true;
  }
  
  public void CP(String paramString)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("uin", paramString);
      paramString = new StringBuilder();
      paramString.append("removeBubbleAccessory('").append(((JSONObject)localObject).toString()).append("');");
      localObject = this.jdField_a_of_type_Absl.a(100);
      if (localObject == null)
      {
        QLog.w("CmShow_SpriteDrawerInfoBridge", 1, "actionScript == null.");
        return;
      }
      ((absc)localObject).CN(paramString.toString());
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteDrawerInfoBridge", 1, "showBubble e:" + paramString);
    }
  }
  
  public void a(abse paramabse, int paramInt, CmShowRenderView.a parama, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteDrawerInfoBridge", 2, "[initSprite]");
    }
    abwh.Il(paramabse.zM());
    abwh.gN(paramabse.zM(), 300);
    if ((this.c == null) || (paramabse == null) || (!paramabse.isSurfaceReady())) {
      if (paramabse != null) {
        abwh.a(paramabse.zM(), 300, 160, new Object[] { "glview is not ready" });
      }
    }
    do
    {
      return;
      if (aD(100, -1)) {
        break;
      }
      QLog.w("CmShow_SpriteDrawerInfoBridge", 1, "[initSprite], fail to load script.");
      if (paramabse.cqU == 1) {
        ThreadManager.getUIHandler().post(new CmShowSpriteDrawerInfoBridge.5(this, paramabse));
      }
    } while (paramabse == null);
    abwh.a(paramabse.zM(), 300, 200, new Object[] { "script no exit" });
    return;
    Bundle localBundle = new Bundle();
    IPCSpriteContext localIPCSpriteContext = paramabse.a();
    if (paramBundle != null)
    {
      localIPCSpriteContext.crp = paramBundle.getInt("SelfRotate");
      localIPCSpriteContext.crq = paramBundle.getInt("FriendRotate");
      QLog.i("CmShow_SpriteDrawerInfoBridge", 1, "mSelfRotate:" + localIPCSpriteContext.crp + " mFriendRotate:" + localIPCSpriteContext.crq);
      if (!TextUtils.isEmpty(paramabse.mSelfUin)) {
        this.iy.put(paramabse.mSelfUin, Integer.valueOf(localIPCSpriteContext.crp));
      }
      if (!TextUtils.isEmpty(paramabse.mFriendUin)) {
        this.iy.put(paramabse.mFriendUin, Integer.valueOf(localIPCSpriteContext.crq));
      }
    }
    localBundle.putParcelable("IPCSpriteContext", localIPCSpriteContext);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "action_render_view_get_initavatar_js", localBundle, new absi(this, parama, paramInt, paramabse));
  }
  
  public void a(abse paramabse, CmShowRenderView.PlayActionConfig paramPlayActionConfig)
  {
    int i = 1;
    if ((paramabse == null) || (paramPlayActionConfig == null)) {
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject1 = abru.a(paramPlayActionConfig);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      QLog.i("CmShow_SpriteDrawerInfoBridge", 1, "playAction cacheActionJs:" + (String)localObject1);
      localObject2 = new SpriteTaskParam();
      ((SpriteTaskParam)localObject2).mActionId = paramPlayActionConfig.mActionId;
      ((SpriteTaskParam)localObject2).crb = 1;
      ((SpriteTaskParam)localObject2).mAioType = 0;
      ((SpriteTaskParam)localObject2).crd = 6;
      ((SpriteTaskParam)localObject2).mIsSend = true;
      if ((!TextUtils.isEmpty(paramabse.mSelfUin)) && (!paramabse.mSelfUin.equals(paramPlayActionConfig.mUin)))
      {
        ((SpriteTaskParam)localObject2).bbE = paramabse.mSelfUin;
        ((SpriteTaskParam)localObject2).mSenderUin = paramabse.mFriendUin;
        ((SpriteTaskParam)localObject2).mTaskId = paramPlayActionConfig.crn;
        ((SpriteTaskParam)localObject2).cri = paramPlayActionConfig.cri;
        ((SpriteTaskParam)localObject2).bhx = ((String)localObject1);
        if (!paramPlayActionConfig.mLoop) {
          break label222;
        }
      }
      for (;;)
      {
        ((SpriteTaskParam)localObject2).crj = i;
        ((SpriteTaskParam)localObject2).a = this;
        ((SpriteTaskParam)localObject2).av = paramPlayActionConfig.av;
        a((SpriteTaskParam)localObject2);
        return;
        ((SpriteTaskParam)localObject2).bbE = paramabse.mFriendUin;
        ((SpriteTaskParam)localObject2).mSenderUin = paramabse.mSelfUin;
        break;
        label222:
        i = 0;
      }
    }
    localObject1 = new Bundle();
    Object localObject2 = paramabse.a();
    if ((!TextUtils.isEmpty(paramabse.mSelfUin)) && (!paramabse.mSelfUin.equals(paramPlayActionConfig.mUin)))
    {
      ((IPCSpriteContext)localObject2).mFriendUin = ((IPCSpriteContext)localObject2).mSelfUin;
      ((IPCSpriteContext)localObject2).mSelfUin = paramPlayActionConfig.mUin;
    }
    ((Bundle)localObject1).putParcelable("IPCSpriteContext", (Parcelable)localObject2);
    ((Bundle)localObject1).putParcelable("PlayActionConfig", paramPlayActionConfig);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "action_render_view_play_action", (Bundle)localObject1, new absg(this, l, paramPlayActionConfig));
  }
  
  public void a(abse paramabse, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteDrawerInfoBridge", 2, "[initSprite]");
    }
    if ((this.c == null) || (paramabse == null) || (!paramabse.isSurfaceReady())) {
      if (paramabse != null) {
        abwh.a(paramabse.zM(), 300, 160, new Object[] { "glview is not ready" });
      }
    }
    do
    {
      return;
      if (aD(100, -1)) {
        break;
      }
      QLog.w("CmShow_SpriteDrawerInfoBridge", 1, "[checkfDressChanged], fail to load script.");
    } while (paramabse.cqU != 1);
    ThreadManager.getUIHandler().post(new CmShowSpriteDrawerInfoBridge.3(this, paramabse));
    return;
    Bundle localBundle = new Bundle();
    IPCSpriteContext localIPCSpriteContext = paramabse.a();
    String str1 = localIPCSpriteContext.mSelfUin;
    String str2 = localIPCSpriteContext.mFriendUin;
    Integer localInteger;
    if (!TextUtils.isEmpty(paramString2))
    {
      localInteger = (Integer)this.iy.get(paramString2);
      if (localInteger != null) {
        localIPCSpriteContext.crq = localInteger.intValue();
      }
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      localInteger = (Integer)this.iy.get(paramString1);
      if (localInteger != null) {
        localIPCSpriteContext.crp = localInteger.intValue();
      }
    }
    localIPCSpriteContext.mFriendUin = paramString2;
    localIPCSpriteContext.mSelfUin = paramString1;
    localBundle.putParcelable("IPCSpriteContext", localIPCSpriteContext);
    localIPCSpriteContext.mFriendUin = str2;
    localIPCSpriteContext.mSelfUin = str1;
    QIPCClientHelper.getInstance().callServer("cm_game_module", "action_render_view_get_initavatar_js", localBundle, new absh(this, paramabse));
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam == null) {
      return;
    }
    ThreadManager.excute(new CmShowSpriteDrawerInfoBridge.2(this, paramSpriteTaskParam), 192, null, true);
  }
  
  public void ah(List<String> paramList, boolean paramBoolean)
  {
    Object localObject;
    try
    {
      localObject = new JSONObject();
      if (paramList == null) {
        break label172;
      }
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localJSONArray.put((String)paramList.next());
      }
      ((JSONObject)localObject).put("uins", localJSONArray);
    }
    catch (Throwable paramList)
    {
      QLog.e("CmShow_SpriteDrawerInfoBridge", 1, "clearAvatar e:" + paramList);
      return;
    }
    for (;;)
    {
      int i;
      ((JSONObject)localObject).put("isClearAll", i);
      paramList = new StringBuilder();
      paramList.append("clearSprite('").append(((JSONObject)localObject).toString()).append("');");
      localObject = this.jdField_a_of_type_Absl.a(100);
      if (localObject == null)
      {
        QLog.w("CmShow_SpriteDrawerInfoBridge", 1, "actionScript == null.");
        return;
      }
      ((absc)localObject).CN(paramList.toString());
      return;
      label172:
      if (paramBoolean) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public void b(SpriteTaskParam paramSpriteTaskParam)
  {
    if ((paramSpriteTaskParam == null) || (this.c == null) || (this.jdField_a_of_type_Abse == null) || (!this.jdField_a_of_type_Abse.isSurfaceReady())) {
      return;
    }
    Object localObject1 = this.c;
    absk.a(paramSpriteTaskParam);
    localObject1 = "";
    if (!TextUtils.isEmpty(paramSpriteTaskParam.bhx)) {
      localObject1 = paramSpriteTaskParam.bhx;
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramSpriteTaskParam.mStatus = 4;
      return;
    }
    Object localObject3 = this.jdField_a_of_type_Absl.a(paramSpriteTaskParam.mActionType);
    Object localObject2 = localObject3;
    if (localObject3 == null)
    {
      QLog.i("CmShow_SpriteDrawerInfoBridge", 1, "playAction CmShow_ get sdk basic script");
      localObject3 = this.jdField_a_of_type_Absl.a(100);
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        QLog.w("CmShow_SpriteDrawerInfoBridge", 1, "actionScript == null.");
        paramSpriteTaskParam.mStatus = 4;
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteDrawerInfoBridge", 2, new Object[] { "[playAction], ready to play, actionId:", Integer.valueOf(paramSpriteTaskParam.mActionId) });
    }
    paramSpriteTaskParam.mStatus = 2;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("playAction('").append((String)localObject1).append("');");
    localObject2.CN(((StringBuilder)localObject3).toString());
    localObject2.bv(paramSpriteTaskParam.mSenderUin, false);
    localObject2.bv(paramSpriteTaskParam.bbE, false);
    localObject1 = ApolloUtil.a();
    if (!TextUtils.isEmpty(paramSpriteTaskParam.bhv)) {}
    for (boolean bool = true;; bool = false)
    {
      abvg.a((QQAppInterface)localObject1, paramSpriteTaskParam, bool, paramSpriteTaskParam.bEW);
      return;
    }
  }
  
  public void bx(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("uin", paramString);
        if (paramBoolean)
        {
          i = 1;
          ((JSONObject)localObject).put("showOrHide", i);
          paramString = new StringBuilder();
          paramString.append("showOrHideSprite('").append(((JSONObject)localObject).toString()).append("');");
          localObject = this.jdField_a_of_type_Absl.a(100);
          if (localObject == null)
          {
            QLog.w("CmShow_SpriteDrawerInfoBridge", 1, "actionScript == null.");
            return;
          }
          ((absc)localObject).CN(paramString.toString());
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("CmShow_SpriteDrawerInfoBridge", 1, "showOrHideAvatar e:" + paramString);
        return;
      }
      int i = 2;
    }
  }
  
  public void clear() {}
  
  public void dm(String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("uin", paramString);
        if (paramInt == 1)
        {
          localObject1 = "2D";
          ((JSONObject)localObject2).put("model", localObject1);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("changeSpriteModel('").append(((JSONObject)localObject2).toString()).append("');");
          localObject2 = this.jdField_a_of_type_Absl.a(100);
          if (localObject2 == null)
          {
            QLog.w("CmShow_SpriteDrawerInfoBridge", 1, "actionScript == null.");
            return;
          }
          ((absc)localObject2).CN(((StringBuilder)localObject1).toString());
          abru.dl(paramString, paramInt);
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("CmShow_SpriteDrawerInfoBridge", 1, "changeSpriteModel e:" + paramString);
        return;
      }
      Object localObject1 = "3D";
    }
  }
  
  public void f(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      this.iy.put(paramString, Integer.valueOf(paramInt3));
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("uin", paramString);
      ((JSONObject)localObject).put("xPos", paramInt1);
      ((JSONObject)localObject).put("yPos", paramInt2);
      ((JSONObject)localObject).put("rotate", paramInt3);
      paramString = new StringBuilder();
      paramString.append("updateSpriteParam('").append(((JSONObject)localObject).toString()).append("');");
      localObject = this.jdField_a_of_type_Absl.a(100);
      if (localObject == null)
      {
        QLog.w("CmShow_SpriteDrawerInfoBridge", 1, "actionScript == null.");
        return;
      }
      ((absc)localObject).CN(paramString.toString());
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteDrawerInfoBridge", 1, "updateAvatarParam e:" + paramString);
    }
  }
  
  public void gL(int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("taskId", paramInt2);
      ((JSONObject)localObject).put("actionId", paramInt1);
      ((JSONObject)localObject).put("stopAll", 1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopAction('").append(((JSONObject)localObject).toString()).append("');");
      localObject = this.jdField_a_of_type_Absl.a(100);
      if (localObject == null)
      {
        QLog.w("CmShow_SpriteDrawerInfoBridge", 1, "actionScript == null.");
        return;
      }
      ((absc)localObject).CN(localStringBuilder.toString());
      this.jdField_a_of_type_Abro.removeTask(paramInt2);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("CmShow_SpriteDrawerInfoBridge", 1, "showBubble e:" + localThrowable);
    }
  }
  
  public void k(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("uin", paramString1);
        localJSONObject.put("text", abrj.replaceBlank(aqgo.encodeToString(paramString2.getBytes("utf-8"), 0)));
        localJSONObject.put("direction", paramInt1);
        paramString1 = "";
        if (paramInt2 != 1) {
          break label407;
        }
        Object localObject = abrd.b(paramString2, 1);
        if (QLog.isColorLevel()) {
          QLog.d("CmShow_SpriteDrawerInfoBridge", 2, new Object[] { "showBubble, 2d bubbleInfo=", localObject });
        }
        if (localObject == null) {
          break label407;
        }
        paramString1 = (String)((Pair)localObject).first;
        paramInt1 = ((Integer)((Pair)localObject).second).intValue();
        localObject = paramString1;
        if (TextUtils.isEmpty(paramString1))
        {
          ApolloUtil.Da("本地无qzone气泡资源，请检查配置是否ok");
          localObject = abrd.f(paramString2, 0, 1);
        }
        localJSONObject.put("bubblePath2D", localObject);
        if (paramInt1 != -1) {
          localJSONObject.put("bubbleId2D", paramInt1);
        }
        paramString1 = "";
        if (paramInt2 == 1)
        {
          localObject = abrd.b(paramString2, 2);
          if (QLog.isColorLevel()) {
            QLog.d("CmShow_SpriteDrawerInfoBridge", 2, new Object[] { "showBubble, 3d bubbleInfo=", localObject });
          }
          if (localObject != null)
          {
            paramString1 = (String)((Pair)localObject).first;
            paramInt1 = ((Integer)((Pair)localObject).second).intValue();
            localObject = paramString1;
            if (TextUtils.isEmpty(paramString1)) {
              localObject = abrd.f(paramString2, 0, 2);
            }
            localJSONObject.put("bubblePath3D", localObject);
            if (paramInt1 != -1) {
              localJSONObject.put("bubbleId3D", paramInt1);
            }
            paramString1 = new StringBuilder();
            paramString1.append("setBubbleAccessory('").append(localJSONObject.toString()).append("');");
            paramString2 = this.jdField_a_of_type_Absl.a(100);
            if (paramString2 == null)
            {
              QLog.w("CmShow_SpriteDrawerInfoBridge", 1, "actionScript == null.");
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.d("CmShow_SpriteDrawerInfoBridge", 2, new Object[] { "showBubble, script=", paramString1.toString() });
            }
            paramString2.CN(paramString1.toString());
            return;
          }
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("CmShow_SpriteDrawerInfoBridge", 1, "showBubble e:" + paramString1);
        return;
      }
      paramInt1 = -1;
      continue;
      label407:
      paramInt1 = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     absf
 * JD-Core Version:    0.7.0.1
 */