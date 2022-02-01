import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.script.SpriteBridge.1;
import com.tencent.mobileqq.apollo.script.SpriteBridge.2;
import com.tencent.mobileqq.apollo.script.SpriteBridge.3;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class abqz
  implements abrl
{
  private CopyOnWriteArrayList<WeakReference<abrn>> J;
  private abrc jdField_a_of_type_Abrc;
  private abrd jdField_a_of_type_Abrd;
  private abro jdField_a_of_type_Abro;
  private String bhu;
  
  public abqz(abrc paramabrc, abro paramabro, abrd paramabrd)
  {
    this.jdField_a_of_type_Abrc = paramabrc;
    this.jdField_a_of_type_Abro = paramabro;
    this.jdField_a_of_type_Abrd = paramabrd;
    this.J = new CopyOnWriteArrayList();
  }
  
  private String a(SpriteTaskParam paramSpriteTaskParam)
  {
    Object localObject;
    if (paramSpriteTaskParam == null) {
      localObject = ri();
    }
    String str;
    do
    {
      return localObject;
      if (!aD(paramSpriteTaskParam.mActionType, paramSpriteTaskParam.mActionId))
      {
        QLog.w("cmshow_scripted_SpriteBridge", 1, "[playAction], fail to load script.");
        paramSpriteTaskParam.mStatus = 4;
        return ri();
      }
      str = this.jdField_a_of_type_Abrd.b(paramSpriteTaskParam);
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    paramSpriteTaskParam.mStatus = 4;
    return ri();
  }
  
  private boolean aD(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Abrc == null) || (this.jdField_a_of_type_Abrc.getApp() == null)) {
      return false;
    }
    return ((abrg)this.jdField_a_of_type_Abrc.getApp().getManager(249)).a().a(paramInt1, paramInt2) != null;
  }
  
  private void bGH()
  {
    ThreadManager.getUIHandler().post(new SpriteBridge.3(this));
  }
  
  private boolean hU(int paramInt)
  {
    boolean bool2;
    if ((this.jdField_a_of_type_Abrc == null) || (this.jdField_a_of_type_Abrc.mAppRef == null))
    {
      bool2 = false;
      return bool2;
    }
    Object localObject1 = (QQAppInterface)this.jdField_a_of_type_Abrc.mAppRef.get();
    if (localObject1 != null)
    {
      Object localObject2 = ((QQAppInterface)localObject1).getApp().getSharedPreferences("apollo_action_random", 0);
      localObject1 = String.valueOf(paramInt);
      if (((SharedPreferences)localObject2).getInt((String)localObject1, -1) > 0) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        if (bool1) {
          break;
        }
        localObject2 = ((SharedPreferences)localObject2).edit();
        ((SharedPreferences.Editor)localObject2).putInt((String)localObject1, paramInt);
        ((SharedPreferences.Editor)localObject2).commit();
        return bool1;
      }
    }
    return false;
  }
  
  private String ri()
  {
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.mTaskId = 0;
    localSpriteTaskParam.mActionId = 4;
    localSpriteTaskParam.crh = 2;
    localSpriteTaskParam.crd = 5;
    localSpriteTaskParam.mMsgId = 1000000L;
    return this.jdField_a_of_type_Abrd.b(localSpriteTaskParam);
  }
  
  public void HS(int paramInt)
  {
    if ((this.J == null) || (this.J.size() == 0)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.J.iterator();
      while (localIterator.hasNext())
      {
        abrn localabrn = (abrn)((WeakReference)localIterator.next()).get();
        if (localabrn != null) {
          localabrn.HV(paramInt);
        }
      }
    }
  }
  
  public void a(abrc paramabrc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBridge", 2, "[initSprite]");
    }
    int i = abrj.gf(0);
    if ((this.jdField_a_of_type_Abrd == null) || (paramabrc == null) || (!paramabrc.isSurfaceReady())) {
      abwh.a(i, 300, 160, new Object[] { "glview is not ready" });
    }
    String str;
    abqt localabqt;
    do
    {
      do
      {
        return;
      } while (!aD(0, -1));
      if (TextUtils.isEmpty(this.bhu))
      {
        str = this.jdField_a_of_type_Abrd.rj();
        QLog.d("CmShowStatUtil", 1, "get spriteJs");
      }
      while (TextUtils.isEmpty(str))
      {
        abwh.a(i, 300, 301, new Object[] { "spriteJs is empty" });
        return;
        str = this.bhu;
        QLog.d("CmShowStatUtil", 1, "spriteJs from cache");
        this.bhu = null;
      }
      localabqt = abrj.a(paramabrc.getApp());
    } while (localabqt == null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initSprite('").append(str).append("');");
    abwh.gN(i, 350);
    QLog.d("cmshow_scripted_SpriteBridge", 1, "TraceReport CmShowStatUtil commitJS:(initSprite )");
    localabqt.CN(localStringBuilder.toString());
    ThreadManager.executeOnSubThread(new SpriteBridge.2(this, localabqt, paramabrc));
  }
  
  public void a(abrn paramabrn)
  {
    if (this.J == null) {
      return;
    }
    this.J.add(new WeakReference(paramabrn));
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam == null) {
      return;
    }
    ThreadManager.excute(new SpriteBridge.1(this, paramSpriteTaskParam), 192, null, true);
  }
  
  public void a(ChatMessage paramChatMessage, ArrayList<Integer> paramArrayList1, ArrayList<Integer> paramArrayList2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBridge", 2, "[buildSpriteTask]");
    }
    if ((paramChatMessage == null) || (this.jdField_a_of_type_Abrc == null) || (this.jdField_a_of_type_Abro == null) || (paramArrayList1 == null) || (paramArrayList1.size() == 0)) {}
    while (!abrj.f(this.jdField_a_of_type_Abrc.getApp(), paramChatMessage.istroop, paramChatMessage.frienduin)) {
      return;
    }
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.mActionId = ((Integer)paramArrayList1.get(0)).intValue();
    localSpriteTaskParam.bGG = 1;
    localSpriteTaskParam.sM = paramArrayList1;
    localSpriteTaskParam.sN = paramArrayList2;
    localSpriteTaskParam.mActionType = 1;
    localSpriteTaskParam.mAioType = paramChatMessage.istroop;
    if (paramChatMessage.isSend())
    {
      localSpriteTaskParam.crd = 0;
      localSpriteTaskParam.mIsSend = paramChatMessage.isSend();
      localSpriteTaskParam.mMsgId = paramChatMessage.uniseq;
      if (localSpriteTaskParam.mAioType != 0) {
        break label225;
      }
      if (!paramChatMessage.isSend()) {
        break label204;
      }
      localSpriteTaskParam.mSenderUin = paramChatMessage.selfuin;
      localSpriteTaskParam.bbE = paramChatMessage.frienduin;
    }
    for (;;)
    {
      a(localSpriteTaskParam);
      return;
      localSpriteTaskParam.crd = 1;
      break;
      label204:
      localSpriteTaskParam.mSenderUin = paramChatMessage.frienduin;
      localSpriteTaskParam.bbE = paramChatMessage.selfuin;
      continue;
      label225:
      if ((localSpriteTaskParam.mAioType == 1) || (localSpriteTaskParam.mAioType == 3000)) {
        localSpriteTaskParam.mSenderUin = paramChatMessage.senderuin;
      }
    }
  }
  
  public void b(int paramInt, MessageForApollo paramMessageForApollo)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBridge", 2, new Object[] { "[buildSpriteTask], from:", Integer.valueOf(paramInt) });
    }
    if ((paramMessageForApollo == null) || (this.jdField_a_of_type_Abrc == null) || (this.jdField_a_of_type_Abro == null)) {
      break label49;
    }
    label49:
    while (!abrj.f(this.jdField_a_of_type_Abrc.getApp(), paramMessageForApollo.istroop, paramMessageForApollo.frienduin)) {
      return;
    }
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.mActionId = ApolloUtil.a(this.jdField_a_of_type_Abrc.getApp(), paramMessageForApollo);
    localSpriteTaskParam.mActionType = ApolloUtil.b(this.jdField_a_of_type_Abrc.getApp(), paramMessageForApollo);
    localSpriteTaskParam.mAioType = paramMessageForApollo.istroop;
    localSpriteTaskParam.crd = paramInt;
    localSpriteTaskParam.mIsSend = paramMessageForApollo.isSend();
    localSpriteTaskParam.mMsgId = paramMessageForApollo.uniseq;
    localSpriteTaskParam.cre = paramMessageForApollo.audioId;
    localSpriteTaskParam.sC = paramMessageForApollo.audioStartTime;
    if (paramMessageForApollo.isDoubleAction()) {
      i = 1;
    }
    localSpriteTaskParam.crb = i;
    localSpriteTaskParam.bhv = paramMessageForApollo.inputText;
    localSpriteTaskParam.bEW = paramMessageForApollo.isBarrageMode();
    localSpriteTaskParam.bhw = paramMessageForApollo.extendJson;
    if (localSpriteTaskParam.mAioType == 0) {
      if (paramMessageForApollo.isSend())
      {
        localSpriteTaskParam.mSenderUin = paramMessageForApollo.selfuin;
        localSpriteTaskParam.bbE = paramMessageForApollo.frienduin;
      }
    }
    for (;;)
    {
      a(localSpriteTaskParam);
      if (paramInt != 2) {
        break;
      }
      abrj.a(this.jdField_a_of_type_Abrc.getApp(), localSpriteTaskParam);
      return;
      localSpriteTaskParam.mSenderUin = paramMessageForApollo.frienduin;
      localSpriteTaskParam.bbE = paramMessageForApollo.selfuin;
      continue;
      if ((localSpriteTaskParam.mAioType == 1) || (localSpriteTaskParam.mAioType == 3000))
      {
        localSpriteTaskParam.bbE = Long.toString(paramMessageForApollo.mApolloMessage.peer_uin);
        localSpriteTaskParam.mSenderUin = paramMessageForApollo.senderuin;
      }
    }
  }
  
  public void b(SpriteTaskParam paramSpriteTaskParam)
  {
    boolean bool = true;
    if ((paramSpriteTaskParam == null) || (this.jdField_a_of_type_Abrd == null) || (this.jdField_a_of_type_Abrc == null) || (!this.jdField_a_of_type_Abrc.isSurfaceReady())) {}
    Object localObject1;
    do
    {
      return;
      if ((paramSpriteTaskParam.sN != null) && (paramSpriteTaskParam.sN.size() > 0) && (!this.jdField_a_of_type_Abrc.Ze()))
      {
        QLog.w("cmshow_scripted_SpriteBridge", 2, "[playAction], BackgroundSurface is not ready and add now");
        bGH();
        return;
      }
      this.jdField_a_of_type_Abrd.a(paramSpriteTaskParam);
      if (!aD(paramSpriteTaskParam.mActionType, paramSpriteTaskParam.mActionId))
      {
        QLog.w("cmshow_scripted_SpriteBridge", 1, "[playAction], fail to load script.");
        paramSpriteTaskParam.mStatus = 4;
        return;
      }
      localObject2 = this.jdField_a_of_type_Abrd.b(paramSpriteTaskParam);
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramSpriteTaskParam.mStatus = 4;
        return;
      }
      localObject1 = (abrg)this.jdField_a_of_type_Abrc.getApp().getManager(249);
      localObject3 = ((abrg)localObject1).a();
    } while (localObject3 == null);
    Object localObject3 = ((abrf)localObject3).a(paramSpriteTaskParam.mActionType);
    if (localObject3 == null)
    {
      QLog.w("cmshow_scripted_SpriteBridge", 1, "actionScript == null.");
      paramSpriteTaskParam.mStatus = 4;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBridge", 2, new Object[] { "[playAction], ready to play, actionId:", Integer.valueOf(paramSpriteTaskParam.mActionId) });
    }
    paramSpriteTaskParam.mStatus = 2;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playAction('").append((String)localObject2).append("');");
    ((abqu)localObject3).CN(localStringBuilder.toString());
    ((abqu)localObject3).bv(paramSpriteTaskParam.mSenderUin, false);
    ((abqu)localObject3).bv(paramSpriteTaskParam.bbE, false);
    Object localObject2 = this.jdField_a_of_type_Abrc.getApp();
    if (!TextUtils.isEmpty(paramSpriteTaskParam.bhv)) {}
    for (;;)
    {
      abvg.a((QQAppInterface)localObject2, paramSpriteTaskParam, bool, paramSpriteTaskParam.bEW);
      localObject1 = ((abrg)localObject1).a();
      if ((localObject1 == null) || (abrj.S(this.jdField_a_of_type_Abrc.getApp()))) {
        break;
      }
      if ((paramSpriteTaskParam.sN == null) || (paramSpriteTaskParam.sN.size() <= 0)) {
        break label371;
      }
      ((abqy)localObject1).hZ(paramSpriteTaskParam.sN);
      return;
      bool = false;
    }
    label371:
    ((abqy)localObject1).cEv();
  }
  
  public void cEA()
  {
    this.bhu = this.jdField_a_of_type_Abrd.rj();
  }
  
  public void clear()
  {
    if (this.J != null) {
      this.J.clear();
    }
  }
  
  public void d(ChatMessage paramChatMessage, int paramInt)
  {
    if ((paramChatMessage == null) || (this.jdField_a_of_type_Abrc == null) || (this.jdField_a_of_type_Abro == null)) {}
    while (!abrj.f(this.jdField_a_of_type_Abrc.getApp(), paramChatMessage.istroop, paramChatMessage.frienduin)) {
      return;
    }
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.mActionId = paramInt;
    ApolloActionData localApolloActionData = abrj.a(this.jdField_a_of_type_Abrc.getApp(), paramInt);
    if (localApolloActionData != null)
    {
      localSpriteTaskParam.mActionType = localApolloActionData.actionType;
      localSpriteTaskParam.crb = localApolloActionData.personNum;
    }
    localSpriteTaskParam.mAioType = paramChatMessage.istroop;
    if (paramChatMessage.isSend())
    {
      localSpriteTaskParam.crd = 0;
      localSpriteTaskParam.mIsSend = paramChatMessage.isSend();
      localSpriteTaskParam.mMsgId = paramChatMessage.uniseq;
      if (localSpriteTaskParam.mAioType != 0) {
        break label188;
      }
      if (!paramChatMessage.isSend()) {
        break label169;
      }
      localSpriteTaskParam.mSenderUin = paramChatMessage.selfuin;
      localSpriteTaskParam.bbE = paramChatMessage.frienduin;
    }
    for (;;)
    {
      a(localSpriteTaskParam);
      return;
      localSpriteTaskParam.crd = 1;
      break;
      label169:
      localSpriteTaskParam.mSenderUin = paramChatMessage.frienduin;
      localSpriteTaskParam.bbE = paramChatMessage.selfuin;
      continue;
      label188:
      if ((localSpriteTaskParam.mAioType == 1) || (localSpriteTaskParam.mAioType == 3000)) {
        localSpriteTaskParam.mSenderUin = paramChatMessage.senderuin;
      }
    }
  }
  
  public void f(MessageForApollo paramMessageForApollo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBridge", 2, new Object[] { "[sendMsg], msg:", paramMessageForApollo });
    }
    try
    {
      if (!aD(paramMessageForApollo.actionType, paramMessageForApollo.mApolloMessage.id))
      {
        QLog.w("cmshow_scripted_SpriteBridge", 1, "[sendMsg], fail to load script, actionType:" + paramMessageForApollo.actionType);
        return;
      }
      JSONObject localJSONObject = new JSONObject();
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("id", paramMessageForApollo.mApolloMessage.id);
      if (paramMessageForApollo.mApolloMessage.name != null) {
        ((JSONObject)localObject).put("name", abrj.replaceBlank(aqgo.encodeToString(paramMessageForApollo.mApolloMessage.name, 0)));
      }
      if (paramMessageForApollo.mApolloMessage.text != null) {
        ((JSONObject)localObject).put("atText", abrj.replaceBlank(aqgo.encodeToString(paramMessageForApollo.mApolloMessage.text, 0)));
      }
      ((JSONObject)localObject).put("peerUin", paramMessageForApollo.mApolloMessage.peer_uin);
      if (!TextUtils.isEmpty(paramMessageForApollo.mApolloMessage.extStr)) {
        ((JSONObject)localObject).put("extraStr", new JSONObject(paramMessageForApollo.mApolloMessage.extStr));
      }
      ApolloMessage localApolloMessage = paramMessageForApollo.mApolloMessage;
      localApolloMessage.flag |= 0x200;
      ((JSONObject)localObject).put("model", ApolloActionData.getModelString(paramMessageForApollo.mApolloMessage.id));
      ((JSONObject)localObject).put("flag", paramMessageForApollo.mApolloMessage.flag);
      ((JSONObject)localObject).put("senderTS", paramMessageForApollo.mApolloMessage.sender_ts);
      ((JSONObject)localObject).put("peerTS", paramMessageForApollo.mApolloMessage.peer_ts);
      ((JSONObject)localObject).put("senderStatus", paramMessageForApollo.mApolloMessage.sender_status);
      ((JSONObject)localObject).put("peerStatus", paramMessageForApollo.mApolloMessage.peer_status);
      if (8 == paramMessageForApollo.actionType)
      {
        ((JSONObject)localObject).put("actionRootPath", "" + paramMessageForApollo.mApolloMessage.id);
        ((JSONObject)localObject).put("isSend", hU(paramMessageForApollo.mApolloMessage.id));
      }
      localJSONObject.put("type", paramMessageForApollo.actionType);
      localJSONObject.put("basicMsg", localObject);
      paramMessageForApollo = abrj.a(this.jdField_a_of_type_Abrc.getApp());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendMsg").append("('").append(localJSONObject.toString()).append("');");
      if (paramMessageForApollo != null)
      {
        paramMessageForApollo.CN(((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Throwable paramMessageForApollo)
    {
      QLog.e("cmshow_scripted_SpriteBridge", 1, paramMessageForApollo, new Object[0]);
    }
  }
  
  public void ia(List<SpriteTaskParam> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (this.jdField_a_of_type_Abrd == null) || (this.jdField_a_of_type_Abrc == null) || (!this.jdField_a_of_type_Abrc.isSurfaceReady())) {}
    do
    {
      return;
      localObject = ((abrg)this.jdField_a_of_type_Abrc.getApp().getManager(249)).a();
    } while (localObject == null);
    Object localObject = ((abrf)localObject).a(0);
    if (localObject == null)
    {
      QLog.w("cmshow_scripted_SpriteBridge", 1, "actionScript == null.");
      return;
    }
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)paramList.next();
      try
      {
        localJSONArray.put(new JSONObject(a(localSpriteTaskParam)));
        ((abqu)localObject).bv(localSpriteTaskParam.mSenderUin, false);
      }
      catch (Exception localException)
      {
        QLog.e("cmshow_scripted_SpriteBridge", 1, "[playAction] e:", localException);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBridge", 2, "[playAction], ready to play");
    }
    paramList = new StringBuilder();
    paramList.append("playShowAction('").append(localJSONArray.toString()).append("');");
    ((abqu)localObject).CN(paramList.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abqz
 * JD-Core Version:    0.7.0.1
 */