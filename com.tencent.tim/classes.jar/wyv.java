import android.text.TextUtils;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkBabyqCardInfo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

public class wyv
  extends wyw
{
  private static final Set<WeakReference<wyv>> bm = Collections.synchronizedSet(new HashSet());
  private boolean bgy;
  public boolean bgz;
  public WeakReference<MessageForArkApp> dX;
  private WeakReference<ArkBabyqCardInfo> dY;
  private WeakReference<RecommendCommonMessage> dZ;
  private WeakReference<RecommendCommonMessage.ArkMsgAppInfo> ea;
  private SessionInfo mSessionInfo;
  protected WeakReference<wyv> mWeakThis = new WeakReference(this);
  
  public wyv()
  {
    bm.add(this.mWeakThis);
    wyy.a();
    wyy.g(this.mWeakThis);
  }
  
  public static void Da(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.ArkAioContainerWrapper", 4, String.format(Locale.CHINA, "doArkAppEvent type:%d", new Object[] { Integer.valueOf(paramInt) }));
    }
    if (paramInt == 2)
    {
      wyy.a();
      wyy.clear();
    }
    for (;;)
    {
      synchronized (bm)
      {
        Iterator localIterator = bm.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (WeakReference)localIterator.next();
        if ((localObject2 == null) || (((WeakReference)localObject2).get() == null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ArkApp.ArkAioContainerWrapper", 4, "doArkAppEvent.(item == null || item.get() == null)");
          }
          localIterator.remove();
        }
      }
      Object localObject2 = (wyv)((WeakReference)localObject2).get();
      ((wyv)localObject2).doOnEvent(paramInt);
      if (paramInt == 2) {
        b((wyv)localObject2);
      }
    }
    if (paramInt == 2) {
      bm.clear();
    }
  }
  
  public static MessageForArkApp a(String paramString)
  {
    synchronized (bm)
    {
      Iterator localIterator = bm.iterator();
      Object localObject;
      label42:
      MessageForArkApp localMessageForArkApp;
      do
      {
        if (localIterator.hasNext())
        {
          localObject = (WeakReference)localIterator.next();
          if (localObject != null) {
            break label42;
          }
        }
        do
        {
          do
          {
            do
            {
              return null;
              localObject = (wyv)((WeakReference)localObject).get();
            } while (localObject == null);
            localObject = ((wyv)localObject).dX;
          } while (localObject == null);
          localMessageForArkApp = (MessageForArkApp)((WeakReference)localObject).get();
        } while (localMessageForArkApp == null);
      } while ((!paramString.equals(localMessageForArkApp.getExtInfoFromExtStr("pa_msgId"))) && (!paramString.equals(String.valueOf(localMessageForArkApp.uniseq))));
      paramString = (MessageForArkApp)((WeakReference)localObject).get();
      return paramString;
    }
  }
  
  public static void a(wyv paramwyv)
  {
    if (paramwyv == null) {
      return;
    }
    synchronized (bm)
    {
      bm.remove(paramwyv.mWeakThis);
      return;
    }
  }
  
  public static void b(wyv paramwyv)
  {
    WeakReference localWeakReference = paramwyv.dX;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((MessageForArkApp)localWeakReference.get()).arkContainer = null;
    }
    localWeakReference = paramwyv.dZ;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((RecommendCommonMessage)localWeakReference.get()).mOldAppInfo.mArkContainer = null;
    }
    localWeakReference = paramwyv.ea;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((RecommendCommonMessage.ArkMsgAppInfo)localWeakReference.get()).mArkContainer = null;
    }
    paramwyv = paramwyv.dY;
    if ((paramwyv != null) && (paramwyv.get() != null)) {
      ((ArkBabyqCardInfo)paramwyv.get()).mArkBabyqContainer = null;
    }
  }
  
  public SessionInfo a()
  {
    return this.mSessionInfo;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat, ArkBabyqCardInfo paramArkBabyqCardInfo, SessionInfo paramSessionInfo)
  {
    this.bgy = false;
    if (paramArkBabyqCardInfo != null) {
      this.dY = new WeakReference(paramArkBabyqCardInfo);
    }
    if (!super.a(paramString1, paramString2, paramString3, paramString4, paramFloat, paramSessionInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkAioContainerWrapper", 4, String.format("super.init return false!!! wrapper: %h.", new Object[] { this }));
      }
      return false;
    }
    bm.add(this.mWeakThis);
    this.bgC = true;
    wyy.a();
    wyy.g(this.mWeakThis);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat, MessageForArkApp paramMessageForArkApp, SessionInfo paramSessionInfo)
  {
    this.bgy = false;
    if (paramMessageForArkApp != null)
    {
      this.dX = new WeakReference(paramMessageForArkApp);
      a(paramSessionInfo, paramMessageForArkApp.senderuin);
    }
    if (!super.a(paramString1, paramString2, paramString3, paramString4, paramFloat, paramSessionInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkAioContainerWrapper", 4, String.format("super.init return false!!! wrapper: %h.", new Object[] { this }));
      }
      return false;
    }
    bm.add(this.mWeakThis);
    wyy.a();
    wyy.g(this.mWeakThis);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat, RecommendCommonMessage.ArkMsgAppInfo paramArkMsgAppInfo, SessionInfo paramSessionInfo)
  {
    if (paramArkMsgAppInfo != null) {
      this.ea = new WeakReference(paramArkMsgAppInfo);
    }
    if (!super.a(paramString1, paramString2, paramString3, paramString4, paramFloat, paramSessionInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkAioContainerWrapper", 4, String.format("super.init return false!!! wrapper: %h.", new Object[] { this }));
      }
      return false;
    }
    bm.add(this.mWeakThis);
    wyy.a();
    wyy.g(this.mWeakThis);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat, RecommendCommonMessage paramRecommendCommonMessage, SessionInfo paramSessionInfo)
  {
    if (paramRecommendCommonMessage != null)
    {
      this.dZ = new WeakReference(paramRecommendCommonMessage);
      a(paramSessionInfo, paramRecommendCommonMessage.senderuin);
    }
    if (!super.a(paramString1, paramString2, paramString3, paramString4, paramFloat, paramSessionInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkAioContainerWrapper", 4, String.format("super.init return false!!! wrapper: %h.", new Object[] { this }));
      }
      return false;
    }
    bm.add(this.mWeakThis);
    wyy.a();
    wyy.g(this.mWeakThis);
    return true;
  }
  
  public void activateView(boolean paramBoolean)
  {
    boolean bool = this.mIsActivated;
    super.activateView(paramBoolean);
    if (bool == this.mIsActivated) {
      return;
    }
    if (this.mIsActivated)
    {
      wyy.a();
      wyy.g(this.mWeakThis);
      return;
    }
    wyy.a();
    wyy.h(this.mWeakThis);
  }
  
  public void cdu()
  {
    this.bgz = true;
  }
  
  public void cdv()
  {
    this.bgz = false;
    if (this.bgy) {
      super.doOnEvent(2);
    }
  }
  
  public void destroy()
  {
    super.destroy();
    wyy.a();
    wyy.i(this.mWeakThis);
  }
  
  public void doOnEvent(int paramInt)
  {
    if ((paramInt == 2) && (this.bgz))
    {
      this.bgy = true;
      return;
    }
    super.doOnEvent(paramInt);
  }
  
  public String getConfigString()
  {
    if (this.dX == null) {
      return "";
    }
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)this.dX.get();
    if (localMessageForArkApp == null) {
      return "";
    }
    return localMessageForArkApp.ark_app_message.config;
  }
  
  public String getViewId()
  {
    if (this.dX == null) {
      return null;
    }
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)this.dX.get();
    if (localMessageForArkApp == null) {
      return null;
    }
    String str = localMessageForArkApp.getExtInfoFromExtStr("pa_msgId");
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return String.valueOf(localMessageForArkApp.uniseq);
  }
  
  public String hs(String paramString)
  {
    if (paramString == null) {
      localObject = "";
    }
    MessageForArkApp localMessageForArkApp;
    do
    {
      do
      {
        do
        {
          return localObject;
          localObject = paramString;
        } while (this.dX == null);
        localMessageForArkApp = (MessageForArkApp)this.dX.get();
        localObject = paramString;
      } while (localMessageForArkApp == null);
      localObject = paramString;
    } while (localMessageForArkApp.ark_app_message == null);
    String str2 = localMessageForArkApp.ark_app_message.appName;
    String str1 = ArkAppMgr.loadAppDesc(str2);
    Object localObject = str1;
    if (TextUtils.isEmpty(str1)) {
      if (!ArkAppMgr.isValidAppName(str2)) {
        break label186;
      }
    }
    label186:
    for (localObject = str2;; localObject = "")
    {
      str1 = paramString;
      if (localMessageForArkApp.ark_app_message.appDesc != null) {
        str1 = paramString.replace("%APP_DESC%", (CharSequence)localObject).replace("$APP_DESC$", (CharSequence)localObject);
      }
      paramString = str1;
      if (localMessageForArkApp.ark_app_message.appName != null) {
        paramString = str1.replace("%APP_NAME%", str2).replace("$APP_NAME$", str2);
      }
      localObject = paramString;
      if (localMessageForArkApp.ark_app_message.promptText == null) {
        break;
      }
      return paramString.replace("%PROMPT%", localMessageForArkApp.ark_app_message.promptText).replace("$PROMPT$", localMessageForArkApp.ark_app_message.promptText);
    }
  }
  
  public void setSessionInfo(SessionInfo paramSessionInfo)
  {
    this.mSessionInfo = paramSessionInfo;
  }
  
  public void zo(boolean paramBoolean)
  {
    this.bgC = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wyv
 * JD-Core Version:    0.7.0.1
 */