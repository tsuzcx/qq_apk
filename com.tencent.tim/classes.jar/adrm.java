import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkTipsManager.4;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import mqq.os.MqqHandler;

public class adrm
{
  private static volatile adrm jdField_a_of_type_Adrm;
  private long Vy = -1L;
  private adrm.a jdField_a_of_type_Adrm$a;
  private achq b = new adrn(this);
  private WeakReference<BaseChatPie> dT;
  private WeakReference<wyv> gx;
  private WeakReference<QQAppInterface> mAppRef;
  private boolean mShowing;
  
  private void GM(String paramString)
  {
    boolean bool2 = true;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("showMainTip : ref null= :");
      if (this.mAppRef != null) {
        break label130;
      }
      bool1 = true;
      localObject = ((StringBuilder)localObject).append(bool1).append(", isHide=");
      if (paramString != null) {
        break label135;
      }
    }
    label130:
    label135:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      QLog.d("ArkTipsManager", 2, bool1);
      if (this.mAppRef != null)
      {
        localObject = (QQAppInterface)this.mAppRef.get();
        if (localObject != null)
        {
          localObject = ((QQAppInterface)localObject).getHandler(Conversation.class);
          Message localMessage = new Message();
          localMessage.what = 1052;
          localMessage.obj = paramString;
          ((MqqHandler)localObject).sendMessage(localMessage);
        }
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  public static adrm a()
  {
    if (jdField_a_of_type_Adrm == null) {}
    try
    {
      if (jdField_a_of_type_Adrm == null) {
        jdField_a_of_type_Adrm = new adrm();
      }
      return jdField_a_of_type_Adrm;
    }
    finally {}
  }
  
  private void a(Bitmap paramBitmap, Context paramContext)
  {
    if ((this.jdField_a_of_type_Adrm$a != null) && (paramContext != null))
    {
      paramBitmap = new BitmapDrawable(paramContext.getResources(), paramBitmap);
      if (this.jdField_a_of_type_Adrm$a.gy != null)
      {
        paramContext = (TipsBar)this.jdField_a_of_type_Adrm$a.gy.get();
        if (paramContext != null) {
          paramContext.setTipsIcon(paramBitmap);
        }
        anot.c((QQAppInterface)this.mAppRef.get(), "dc00898", "", "", "0X8009EDE", "0X8009EDE", 4, 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_Adrm$a.gz != null)
      {
        paramContext = (yhw)this.jdField_a_of_type_Adrm$a.gz.get();
        if (paramContext != null) {
          paramContext.P(paramBitmap);
        }
      }
    }
  }
  
  private void a(MessageForArkApp paramMessageForArkApp, boolean paramBoolean)
  {
    if (paramMessageForArkApp != null)
    {
      if (paramMessageForArkApp.arkContainer != null)
      {
        paramMessageForArkApp.arkContainer.cdv();
        if (paramBoolean) {
          paramMessageForArkApp.arkContainer.doOnEvent(2);
        }
      }
      if (paramMessageForArkApp.mExtendMsgArkAppList != null)
      {
        Iterator localIterator = paramMessageForArkApp.mExtendMsgArkAppList.iterator();
        while (localIterator.hasNext())
        {
          MessageForArkApp localMessageForArkApp = (MessageForArkApp)localIterator.next();
          if ((localMessageForArkApp != null) && (localMessageForArkApp.arkContainer != null))
          {
            localMessageForArkApp.arkContainer.cdv();
            localMessageForArkApp.arkContainer.doOnEvent(2);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("ArkTipsManager", 2, "msg container has dettached:" + paramMessageForArkApp.uniseq + ",destroy:" + paramBoolean + ",c=" + paramMessageForArkApp.arkContainer);
      }
    }
  }
  
  public static String b(MessageForArkApp paramMessageForArkApp)
  {
    if ((paramMessageForArkApp == null) || (paramMessageForArkApp.ark_app_message == null) || (TextUtils.isEmpty(paramMessageForArkApp.ark_app_message.appDesc))) {
      paramMessageForArkApp = "";
    }
    String str;
    do
    {
      return paramMessageForArkApp;
      str = paramMessageForArkApp.ark_app_message.appDesc;
      paramMessageForArkApp = str;
    } while (str.length() <= 4);
    return str.substring(0, 4);
  }
  
  private void c(MessageForArkApp paramMessageForArkApp)
  {
    if (paramMessageForArkApp != null)
    {
      if (paramMessageForArkApp.arkContainer != null) {
        paramMessageForArkApp.arkContainer.cdu();
      }
      if (paramMessageForArkApp.mExtendMsgArkAppList != null)
      {
        Iterator localIterator = paramMessageForArkApp.mExtendMsgArkAppList.iterator();
        while (localIterator.hasNext())
        {
          MessageForArkApp localMessageForArkApp = (MessageForArkApp)localIterator.next();
          if ((localMessageForArkApp != null) && (localMessageForArkApp.arkContainer != null)) {
            localMessageForArkApp.arkContainer.cdu();
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("ArkTipsManager", 2, "msg container has attached:" + paramMessageForArkApp.uniseq + ",c=" + paramMessageForArkApp.arkContainer);
      }
    }
  }
  
  private void cUc()
  {
    GM(null);
  }
  
  private void ft(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_Adrm$a != null) && (this.jdField_a_of_type_Adrm$a.bvk != null) && (this.jdField_a_of_type_Adrm$a.bvk.equals(paramString1)) && (this.dT != null))
    {
      paramString1 = (BaseChatPie)this.dT.get();
      if (paramString1 != null)
      {
        paramString1 = paramString1.a(paramString2, this.jdField_a_of_type_Adrm$a.Vz);
        this.jdField_a_of_type_Adrm$a.gz = new WeakReference(paramString1);
      }
    }
  }
  
  public MessageForArkApp a()
  {
    if (this.jdField_a_of_type_Adrm$a != null) {
      return this.jdField_a_of_type_Adrm$a.d;
    }
    return null;
  }
  
  public TipsBar a(Context paramContext)
  {
    TipsBar localTipsBar = new TipsBar(paramContext);
    adrm.a locala = this.jdField_a_of_type_Adrm$a;
    if ((locala != null) && (locala.aPk != null))
    {
      locala.gy = new WeakReference(localTipsBar);
      localTipsBar.setTipsText(locala.aPk);
    }
    ea(paramContext);
    return localTipsBar;
  }
  
  public wyv a()
  {
    if (this.jdField_a_of_type_Adrm$a == null) {
      return null;
    }
    return this.jdField_a_of_type_Adrm$a.b;
  }
  
  public void a(wyv paramwyv, SessionInfo paramSessionInfo, MessageForArkApp paramMessageForArkApp, String paramString, QQAppInterface paramQQAppInterface)
  {
    if ((paramSessionInfo == null) || (paramMessageForArkApp == null)) {}
    long l1;
    long l2;
    label92:
    String str1;
    Object localObject;
    boolean bool;
    do
    {
      return;
      if ((paramMessageForArkApp.istroop == 1) || (paramMessageForArkApp.istroop == 3000)) {}
      for (l1 = paramMessageForArkApp.shmsgseq;; l1 = paramMessageForArkApp.time)
      {
        l2 = paramMessageForArkApp.uniseq;
        if (l2 != this.Vy) {
          break label92;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("ArkTipsManager", 2, "showTip deleting:" + l2);
        return;
      }
      str1 = paramSessionInfo.aTl;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("showTip sessUin:").append(str1).append(",first Show ? ");
        if (this.jdField_a_of_type_Adrm$a != null) {
          break;
        }
        bool = true;
        QLog.i("ArkTipsManager", 2, bool + ", msg=" + paramString);
      }
    } while (str1 == null);
    String str2 = paramSessionInfo.aTn;
    this.mAppRef = new WeakReference(paramQQAppInterface);
    if (paramMessageForArkApp.ark_app_message != null)
    {
      localObject = paramMessageForArkApp.ark_app_message.appName;
      label207:
      if (this.jdField_a_of_type_Adrm$a != null) {
        break label376;
      }
      this.jdField_a_of_type_Adrm$a = new adrm.a(paramwyv, str1, l1, l2, str2, paramSessionInfo.cZ, (String)localObject, paramMessageForArkApp);
    }
    label376:
    while ((this.jdField_a_of_type_Adrm$a.b == paramwyv) && (l1 == this.jdField_a_of_type_Adrm$a.Vz))
    {
      if (paramQQAppInterface != null) {
        paramQQAppInterface.addObserver(this.b);
      }
      if (QLog.isColorLevel()) {
        QLog.i("ArkTipsManager", 2, "showTip view:" + paramwyv + "msgID ? " + l1);
      }
      c(paramMessageForArkApp);
      this.jdField_a_of_type_Adrm$a.aPk = paramString;
      GM(paramString);
      ft(str1, paramString);
      if (paramMessageForArkApp.ark_app_message != null) {
        adqu.a(paramQQAppInterface, paramMessageForArkApp.ark_app_message.appName, "AIOStatusBarShow", 0, 0, 0L, 0L, 0L, "", "");
      }
      this.mShowing = true;
      return;
      bool = false;
      break;
      localObject = "";
      break label207;
    }
    if ((this.jdField_a_of_type_Adrm$a.b != paramwyv) && (this.jdField_a_of_type_Adrm$a.b != null))
    {
      if (str1.equals(this.jdField_a_of_type_Adrm$a.bvk)) {
        break label474;
      }
      a(this.jdField_a_of_type_Adrm$a.d, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Adrm$a.a(paramwyv, str1, l1, l2, str2, paramSessionInfo.cZ, (String)localObject, paramMessageForArkApp);
      break;
      label474:
      a(this.jdField_a_of_type_Adrm$a.d, false);
    }
  }
  
  public void a(wyw paramwyw, SessionInfo paramSessionInfo, String paramString)
  {
    if ((!this.mShowing) || (this.jdField_a_of_type_Adrm$a == null) || (paramString == null) || (paramwyw != this.jdField_a_of_type_Adrm$a.b)) {
      break label29;
    }
    label29:
    while ((this.gx != null) && (this.gx.get() == paramwyw)) {
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("updateCurrentTip : sessionInfo:");
      if (paramSessionInfo != null) {
        break label186;
      }
    }
    label186:
    for (String str = "";; str = paramSessionInfo.aTl)
    {
      QLog.d("ArkTipsManager", 2, str + ",tar:" + this.jdField_a_of_type_Adrm$a.bvk + ",c=" + paramwyw);
      this.jdField_a_of_type_Adrm$a.aPk = paramString;
      GM(paramString);
      if ((paramSessionInfo == null) || (paramSessionInfo.aTl == null) || (!paramSessionInfo.aTl.equals(this.jdField_a_of_type_Adrm$a.bvk)) || (paramSessionInfo.cZ != this.jdField_a_of_type_Adrm$a.type)) {
        break;
      }
      ft(this.jdField_a_of_type_Adrm$a.bvk, paramString);
      return;
    }
  }
  
  public boolean bU(long paramLong)
  {
    if (this.jdField_a_of_type_Adrm$a == null) {}
    while (this.jdField_a_of_type_Adrm$a.msgUniseq != paramLong) {
      return false;
    }
    return true;
  }
  
  public void c(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_a_of_type_Adrm$a == null) || (paramActivity == null) || (paramQQAppInterface == null)) {
      return;
    }
    int i = this.jdField_a_of_type_Adrm$a.type;
    String str1 = this.jdField_a_of_type_Adrm$a.bvk;
    String str2 = this.jdField_a_of_type_Adrm$a.targetName;
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("need_jump_to_msg", true);
    localBundle.putLong("searched_timeorseq", this.jdField_a_of_type_Adrm$a.Vz);
    aalb.a(paramActivity, paramQQAppInterface, str1, i, str2, false, localBundle);
  }
  
  public void cUd()
  {
    if (this.jdField_a_of_type_Adrm$a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkTipsManager", 2, "onEnterConversation");
      }
      GM(this.jdField_a_of_type_Adrm$a.aPk);
    }
  }
  
  public void ea(Context paramContext)
  {
    if (this.jdField_a_of_type_Adrm$a == null) {
      return;
    }
    String str1 = this.jdField_a_of_type_Adrm$a.arkAppName;
    String str2 = this.jdField_a_of_type_Adrm$a.d.ark_app_message.appView;
    if (ArkAppMgr.getInstance().getAppPathByNameFromLocal(str1, str2, null, false) != null)
    {
      ArkAppCacheMgr.getAppIcon(str1, new adro(this, paramContext));
      return;
    }
    ArkAppMgr.getInstance().getAppPathByName(str1, str2, "0.0.0.1", null, new adrp(this, str1, paramContext));
  }
  
  public void h(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (paramQQAppInterface == null) {}
    while (QQAppInterface.isAppOnForeground(paramQQAppInterface.getApp())) {
      return;
    }
    QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(paramQQAppInterface.getApp());
    Intent localIntent = new Intent();
    localIntent.putExtra("param_notifyid", 239);
    localBuilder.setSmallIcon(2130842267).setWhen(System.currentTimeMillis()).setContentTitle(paramString1).setContentText(paramString2).setContentIntent(PendingIntent.getActivity(paramQQAppInterface.getApp(), 0, localIntent, 0));
    paramQQAppInterface = localBuilder.build();
    paramQQAppInterface.flags = 16;
    localQQNotificationManager.notify("ArkTipsManager", 239, paramQQAppInterface);
  }
  
  public void hideTips()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("hideTips : mCurrentTip :");
      if (this.jdField_a_of_type_Adrm$a != null) {
        break label131;
      }
    }
    label131:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ArkTipsManager", 2, bool);
      if (this.jdField_a_of_type_Adrm$a != null)
      {
        if (this.mAppRef != null)
        {
          localObject = (QQAppInterface)this.mAppRef.get();
          if (localObject != null) {
            ((QQAppInterface)localObject).removeObserver(this.b);
          }
        }
        this.jdField_a_of_type_Adrm$a = null;
        if (this.dT != null)
        {
          localObject = (BaseChatPie)this.dT.get();
          if (localObject != null) {
            ((BaseChatPie)localObject).a(null, -1L);
          }
        }
        cUc();
        this.mShowing = false;
        this.mAppRef = null;
      }
      return;
    }
  }
  
  public void iU(long paramLong)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("useq=").append(paramLong);
      if (this.jdField_a_of_type_Adrm$a != null) {
        break label66;
      }
    }
    label66:
    for (String str = "";; str = "<>" + this.jdField_a_of_type_Adrm$a.b + "," + this.jdField_a_of_type_Adrm$a.msgUniseq)
    {
      QLog.d("ArkTipsManager", 2, str);
      ArkAppCenter.a().postToMainThread(new ArkTipsManager.4(this, paramLong));
      return;
    }
  }
  
  public boolean isShowing()
  {
    return this.mShowing;
  }
  
  public void r(BaseChatPie paramBaseChatPie)
  {
    this.dT = new WeakReference(paramBaseChatPie);
    if (this.jdField_a_of_type_Adrm$a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkTipsManager", 2, "onEnterAIO");
      }
      ft(paramBaseChatPie.oL(), this.jdField_a_of_type_Adrm$a.aPk);
    }
  }
  
  public void reportClick()
  {
    if ((this.jdField_a_of_type_Adrm$a != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Adrm$a.arkAppName)) && (this.mAppRef != null))
    {
      adqu.a((QQAppInterface)this.mAppRef.get(), this.jdField_a_of_type_Adrm$a.arkAppName, "AIOStatusBarClick", 0, 0, 0L, 0L, 0L, "", "");
      anot.c((QQAppInterface)this.mAppRef.get(), "dc00898", "", "", "0X8009EE2", "0X8009EE2", 4, 0, "", "", "", "");
    }
  }
  
  public void s(BaseChatPie paramBaseChatPie)
  {
    if ((this.dT != null) && (this.dT.get() == paramBaseChatPie))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkTipsManager", 2, "onExitAIO");
      }
      this.dT = null;
    }
  }
  
  public static class a
  {
    public long Vz;
    public String aPk;
    public String arkAppName;
    public wyv b;
    public String bvk;
    public MessageForArkApp d;
    public WeakReference<TipsBar> gy;
    public WeakReference<yhw> gz;
    public long msgUniseq;
    public String targetName;
    public int type;
    
    a(wyv paramwyv, String paramString1, long paramLong1, long paramLong2, String paramString2, int paramInt, String paramString3, MessageForArkApp paramMessageForArkApp)
    {
      a(paramwyv, paramString1, paramLong1, paramLong2, paramString2, paramInt, paramString3, paramMessageForArkApp);
    }
    
    void a(wyv paramwyv, String paramString1, long paramLong1, long paramLong2, String paramString2, int paramInt, String paramString3, MessageForArkApp paramMessageForArkApp)
    {
      this.b = paramwyv;
      this.bvk = paramString1;
      this.Vz = paramLong1;
      this.targetName = paramString2;
      this.type = paramInt;
      this.msgUniseq = paramLong2;
      this.arkAppName = paramString3;
      this.d = paramMessageForArkApp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adrm
 * JD-Core Version:    0.7.0.1
 */