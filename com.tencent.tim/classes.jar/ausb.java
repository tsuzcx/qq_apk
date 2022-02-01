import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.notification.NotifyIdManager.1;
import com.tencent.util.notification.NotifyIdManager.2;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class ausb
  implements Manager
{
  static AtomicBoolean eC = new AtomicBoolean(true);
  private AtomicBoolean eB = new AtomicBoolean(false);
  private int esi;
  private final QQAppInterface mApp;
  private Map<String, Integer> pJ;
  private Map<String, Boolean> pK;
  private Map<String, Boolean> pL;
  
  public ausb(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.pK = new ConcurrentHashMap();
    this.pL = new ConcurrentHashMap();
    ewA();
  }
  
  public static void Wb(boolean paramBoolean)
  {
    eC.set(paramBoolean);
  }
  
  private aofe a(String paramString)
  {
    paramString = new aofe(paramString, 16);
    paramString.setSpan(new ForegroundColorSpan(BaseApplicationImpl.context.getResources().getColor(2131166501)), 0, paramString.length(), 33);
    return paramString;
  }
  
  public static ausb a()
  {
    return a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public static ausb a(QQAppInterface paramQQAppInterface)
  {
    return (ausb)paramQQAppInterface.getManager(313);
  }
  
  public static TroopMemberInfo a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return null;
    }
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    try
    {
      paramString1 = (TroopMemberInfo)paramQQAppInterface.find(TroopMemberInfo.class, new String[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    finally
    {
      paramQQAppInterface.close();
    }
  }
  
  public static boolean aJK()
  {
    return eC.get();
  }
  
  private void ewA()
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    Object localObject = this.mApp.getCurrentAccountUin();
    localObject = this.mApp.getApp().getSharedPreferences((String)localObject, 4);
    String str = ((SharedPreferences)localObject).getString("SP_KEY_CURRENT_NOTIFY_ID_MAP", "");
    if (!TextUtils.isEmpty(str)) {
      try
      {
        String[] arrayOfString1 = str.split(",");
        int j = arrayOfString1.length;
        int i = 0;
        while (i < j)
        {
          String[] arrayOfString2 = arrayOfString1[i].split("=");
          localConcurrentHashMap.put(arrayOfString2[0], Integer.valueOf(Integer.parseInt(arrayOfString2[1])));
          i += 1;
        }
        if (!QLog.isColorLevel()) {
          break label153;
        }
      }
      catch (Exception localException)
      {
        QLog.e("NotifyIdManager", 1, "restoreUinIdMapFromSp: failed. ", localException);
      }
    } else {
      QLog.d("NotifyIdManager", 2, new Object[] { "restoreUinIdMapFromSp: invoked. ", " mapStr: ", str });
    }
    label153:
    this.pJ = localConcurrentHashMap;
    this.esi = ((SharedPreferences)localObject).getInt("SP_KEY_CURRENT_NOTIFY_ID", 512);
  }
  
  private void ewy()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = this.pJ.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localStringBuilder.append(str).append("=").append(this.pJ.get(str)).append(",");
    }
    if (localStringBuilder.length() >= 1) {
      localStringBuilder.delete(localStringBuilder.length() - 1, localStringBuilder.length());
    }
    if (QLog.isColorLevel()) {
      QLog.i("NotifyIdManager", 2, "saveUinIdMapToSp: invoked.  mapAsString: " + localStringBuilder);
    }
    localObject = this.mApp.getCurrentAccountUin();
    this.mApp.getApp().getSharedPreferences((String)localObject, 4).edit().putString("SP_KEY_CURRENT_NOTIFY_ID_MAP", localStringBuilder.toString()).apply();
  }
  
  private void ewz()
  {
    String str = this.mApp.getCurrentAccountUin();
    this.mApp.getApp().getSharedPreferences(str, 4).edit().putInt("SP_KEY_CURRENT_NOTIFY_ID", this.esi).apply();
    if (QLog.isColorLevel()) {
      QLog.d("NotifyIdManager", 2, new Object[] { "saveCurrentIdToSp: invoked. ", " mCurrentMinId: ", Integer.valueOf(this.esi) });
    }
  }
  
  public static boolean g(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage == null) {}
    while ((!ne(paramMessage.istroop)) || (!tb(paramMessage.frienduin))) {
      return false;
    }
    return true;
  }
  
  public static boolean ne(int paramInt)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (((localAppRuntime instanceof QQAppInterface)) && (!((QQAppInterface)localAppRuntime).abm())) {
      return false;
    }
    if ((paramInt == 0) || (paramInt == 1) || (paramInt == 3000) || (paramInt == 1009) || (paramInt == 1001) || (paramInt == 10002) || (paramInt == 10004) || (paramInt == 1003) || (paramInt == 1004) || (paramInt == 1005) || (paramInt == 1020) || (paramInt == 1000) || (paramInt == 1023) || (paramInt == 1024) || (paramInt == 1025) || (paramInt == 10007) || (paramInt == 10008)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean tb(String paramString)
  {
    return Friends.isValidUin(paramString);
  }
  
  public void ZA(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("NotifyIdManager", 2, "cancelNotificationByUin: call stack: ", new RuntimeException());
    }
    Integer localInteger = (Integer)this.pJ.get(paramString);
    if (QLog.isColorLevel()) {
      QLog.i("NotifyIdManager", 2, "cancelNotificationByUin: invoked.  notifyId: " + localInteger + " friendUin: " + paramString);
    }
    if (localInteger != null) {
      QQNotificationManager.getInstance().cancel("NotifyIdManager", localInteger.intValue());
    }
    this.pJ.remove(paramString);
    ewy();
  }
  
  public void Zz(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NotifyIdManager", 2, "clearUinNeedShowCareMap: invoked.  friendOrTroopUin: " + paramString);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      this.pK.remove(paramString);
      this.pL.remove(paramString);
    }
  }
  
  public void a(QQMessageFacade.Message paramMessage, Intent paramIntent, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if ((cn(paramMessage.frienduin, paramMessage.senderuin)) && (paramMessage.istroop == 1))
    {
      paramSpannableStringBuilder.clear();
      paramIntent = paramIntent.getStringExtra("uinname");
      paramSpannableStringBuilder.append(new aofe("[" + paramIntent + "]", 16));
      paramSpannableStringBuilder.append(a(acfp.m(2131709168)));
      paramSpannableStringBuilder.append(new aofe(paramMessage.nickName, 16));
    }
  }
  
  public void a(QQMessageFacade.Message paramMessage, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if ((abbf.jb(this.mApp.getCurrentAccountUin() + paramMessage.senderuin)) && (paramMessage.istroop == 0)) {
      paramSpannableStringBuilder.append(a(acfp.m(2131709170)));
    }
  }
  
  public void a(QQMessageFacade.Message paramMessage, TextView paramTextView)
  {
    paramTextView = paramTextView.getHandler();
    if ((h(paramMessage)) && (paramTextView != null))
    {
      this.eB.set(true);
      paramTextView.postDelayed(new NotifyIdManager.1(this), 5000L);
    }
  }
  
  public String c(String paramString, QQMessageFacade.Message paramMessage)
  {
    String str = paramString;
    if (abbf.jb(this.mApp.getCurrentAccountUin() + paramMessage.frienduin)) {
      str = acfp.m(2131709169) + paramString;
    }
    return str;
  }
  
  public boolean cn(@Nullable String paramString1, @Nullable String paramString2)
  {
    long l = System.currentTimeMillis();
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return false;
      if ((Looper.myLooper() == Looper.getMainLooper()) && (QLog.isColorLevel())) {
        QLog.i("NotifyIdManager", 2, "troopMemberIsCared: invoked. run on ui thread. ");
      }
      paramString1 = a(this.mApp, paramString1, paramString2);
      if (QLog.isColorLevel()) {
        QLog.i("NotifyIdManager", 2, "troopMemberIsCared: invoked. cost: " + (System.currentTimeMillis() - l));
      }
    } while (paramString1 == null);
    return paramString1.isTroopFollowed;
  }
  
  public String d(String paramString, QQMessageFacade.Message paramMessage)
  {
    Resources localResources = BaseApplication.getContext().getResources();
    boolean bool = a(this.mApp).cn(paramMessage.frienduin, paramMessage.senderuin);
    if (QLog.isColorLevel()) {
      QLog.i("NotifyIdManager", 2, "getCareTroopMemberMsgText: invoked.  troopMemberIsCared: " + bool);
    }
    Object localObject = (Boolean)this.pK.get(paramMessage.frienduin);
    Boolean localBoolean = (Boolean)this.pL.get(paramMessage.frienduin);
    if ((bool) || ((localObject != null) && (((Boolean)localObject).booleanValue())))
    {
      if (localObject == null) {
        this.pK.put(paramMessage.frienduin, Boolean.valueOf(true));
      }
      localObject = acfp.m(2131709171) + paramString;
    }
    do
    {
      do
      {
        return localObject;
        if (paramMessage.bizType == 16) {
          break;
        }
        localObject = paramString;
      } while (localBoolean == null);
      localObject = paramString;
    } while (!localBoolean.booleanValue());
    if (localBoolean == null) {
      this.pL.put(paramMessage.frienduin, Boolean.valueOf(true));
    }
    return localResources.getString(2131701843) + paramString;
  }
  
  public void dXJ()
  {
    ((CardHandler)this.mApp.getBusinessHandler(2)).cHv();
  }
  
  public void ewB()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotifyIdManager", 2, "cancelAllNotification: invoked. ");
    }
    ThreadManager.excute(new NotifyIdManager.2(this, QQNotificationManager.getInstance()), 16, null, false);
    this.pJ.clear();
    ewy();
  }
  
  public void f(SessionInfo paramSessionInfo)
  {
    paramSessionInfo = paramSessionInfo.aTl;
    if (QLog.isColorLevel()) {
      QLog.d("NotifyIdManager", 2, new Object[] { "onAioResume: invoked. ", " curFriendUin: ", paramSessionInfo });
    }
    ZA(paramSessionInfo);
    Zz(paramSessionInfo);
  }
  
  public int fO(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotifyIdManager", 2, new Object[] { "uniqueNotifyIdByUin: invoked. ", " friendUin: ", paramString });
    }
    if (this.pJ.containsKey(paramString)) {
      return ((Integer)this.pJ.get(paramString)).intValue();
    }
    this.esi += 1;
    if (this.esi >= 522) {
      this.esi = 512;
    }
    this.pJ.put(paramString, Integer.valueOf(this.esi));
    ewy();
    ewz();
    return this.esi;
  }
  
  public void h(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NotifyIdManager", 2, new Object[] { "cancelNotificationByMessage: invoked. ", " message: ", paramMessage });
      }
      if (!j(paramMessage)) {
        ZA(paramMessage.frienduin);
      }
    }
  }
  
  public boolean h(QQMessageFacade.Message paramMessage)
  {
    return abbf.jb(this.mApp.getCurrentAccountUin() + paramMessage.senderuin);
  }
  
  public boolean i(QQMessageFacade.Message paramMessage)
  {
    return (this.eB.get()) && (!h(paramMessage));
  }
  
  public boolean j(QQMessageFacade.Message paramMessage)
  {
    return (paramMessage != null) && (paramMessage.counter > 0);
  }
  
  public void onDestroy()
  {
    this.pJ.clear();
    ewy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     ausb
 * JD-Core Version:    0.7.0.1
 */