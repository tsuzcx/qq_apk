import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import java.io.File;
import mqq.manager.Manager;

public class ajcd
  implements Manager
{
  CompoundButton.OnCheckedChangeListener a;
  boolean cnw = true;
  QQAppInterface mApp;
  
  public ajcd(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    if (SettingCloneUtil.isContainValue(this.mApp.getApp(), this.mApp.getCurrentUin(), null, "system_notification_enabled_key")) {}
    for (boolean bool = SettingCloneUtil.readValue(this.mApp.getApp(), this.mApp.getCurrentUin(), null, "system_notification_enabled_key", true);; bool = age())
    {
      this.cnw = bool;
      return;
    }
  }
  
  private Bitmap G(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("NewMsgNotificationManager", 2, new Object[] { "getBitmapFromLocal: invoked. ", " id: ", Integer.valueOf(i), " iconUrl: ", paramString });
      }
      i = ahwc.hX(i);
      paramString = BitmapFactory.decodeResource(this.mApp.getApp().getResources(), i);
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.e("NewMsgNotificationManager", 1, "getBitmapFromLocal: failed. ", paramString);
      return null;
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("NewMsgNotificationManager", 2, "getBitmapFromLocal: failed. ", paramString);
        }
      }
    }
  }
  
  public static Bitmap H(String paramString)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      QLog.e("NewMsgNotificationManager", 1, new Object[] { "getBitmapFromUrl: failed. can't run in ui thread. ", paramString });
      return null;
    }
    String str = aoiz.getFilePath(paramString);
    Object localObject = new File(str);
    long l1 = SystemClock.uptimeMillis();
    localObject = new aquz(paramString, (File)localObject);
    ((aquz)localObject).cWw = true;
    ((aquz)localObject).retryCount = 2;
    ((aquz)localObject).key = str;
    ((aquz)localObject).XY(512);
    int i = aqva.a((aquz)localObject, null, null);
    long l2 = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("NewMsgNotificationManager", 2, "download cost " + (l2 - l1) + " result " + i + " key " + ((aquz)localObject).key + " iconUrl: " + paramString);
    }
    return SafeBitmapFactory.decodeFile(str);
  }
  
  private boolean M(int paramInt, String paramString)
  {
    boolean bool1 = true;
    boolean bool2 = age();
    if (QLog.isColorLevel()) {
      QLog.d("NewMsgNotificationManager", 2, new Object[] { "newMsgNotificationEnabled: invoked. ", " systemNotificationEnabled: ", Boolean.valueOf(bool2) });
    }
    if ((kn(paramInt)) || (nm(paramString))) {
      bool1 = aqn();
    }
    return bool1;
  }
  
  public static ajcd a(QQAppInterface paramQQAppInterface)
  {
    return (ajcd)paramQQAppInterface.getManager(349);
  }
  
  private static boolean kn(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 3000) || (paramInt == 1009) || (paramInt == 1001) || (paramInt == 10002) || (paramInt == 10004) || (paramInt == 1003) || (paramInt == 1004) || (paramInt == 1005) || (paramInt == 1020) || (paramInt == 1000) || (paramInt == 1023) || (paramInt == 1024) || (paramInt == 1025) || (paramInt == 7220) || (paramInt == 7120) || (paramInt == 7200) || (paramInt == 1008) || (paramInt == 3001) || (paramInt == 7210) || (paramInt == 7230) || (paramInt == 7) || (paramInt == 6000) || (paramInt == 6003) || (paramInt == 7000) || (paramInt == 10007) || (paramInt == 10008);
  }
  
  private static boolean nm(String paramString)
  {
    return acbn.bkJ.equals(paramString);
  }
  
  private void o(BaseActivity paramBaseActivity)
  {
    Intent localIntent = aqin.d(this.mApp.getApp());
    if (BaseActivity.sTopActivity != null)
    {
      BaseActivity.sTopActivity.startActivity(localIntent);
      return;
    }
    paramBaseActivity.startActivity(localIntent);
  }
  
  public Bitmap a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return paramBitmap;
      if ("2".equals(paramString1)) {
        return H(paramString2);
      }
    } while (!"1".equals(paramString1));
    return G(paramString2);
  }
  
  public CompoundButton.OnCheckedChangeListener a(NotifyPushSettingActivity paramNotifyPushSettingActivity, FormSwitchItem paramFormSwitchItem, FormSimpleItem paramFormSimpleItem)
  {
    this.a = new ajce(this, paramNotifyPushSettingActivity, paramFormSwitchItem);
    return this.a;
  }
  
  public void a(FormSwitchItem paramFormSwitchItem1, TextView paramTextView, FormSwitchItem paramFormSwitchItem2)
  {
    int i = 0;
    boolean bool1 = age();
    if (bool1 != this.cnw)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewMsgNotificationManager", 2, new Object[] { "onNotifyPushActivityResume: invoked. ", " curSystemState[系统设置发生了变化]: ", Boolean.valueOf(bool1), " systemNotificationEnabled: ", Boolean.valueOf(this.cnw) });
      }
      this.cnw = bool1;
      SettingCloneUtil.writeValue(this.mApp.getApp(), this.mApp.getCurrentUin(), null, "system_notification_enabled_key", bool1);
      paramFormSwitchItem1 = paramFormSwitchItem1.a();
      paramFormSwitchItem2 = paramFormSwitchItem2.a();
      if (bool1) {
        break label201;
      }
      paramFormSwitchItem1.setAlpha(0.5F);
      paramFormSwitchItem2.setAlpha(0.5F);
    }
    for (;;)
    {
      if (bool1) {
        i = 8;
      }
      paramTextView.setVisibility(i);
      return;
      boolean bool2 = aqn();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("NewMsgNotificationManager", 2, new Object[] { "onNotifyPushActivityResume: invoked. [系统设置未变化]", " curSystemState: ", Boolean.valueOf(bool1), " globalSwitchOn: ", Boolean.valueOf(bool2) });
      break;
      label201:
      paramFormSwitchItem1.setAlpha(1.0F);
      paramFormSwitchItem2.setAlpha(1.0F);
    }
  }
  
  public boolean aF(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return true;
    }
    return M(paramMessageRecord.istroop, paramMessageRecord.frienduin);
  }
  
  public boolean age()
  {
    boolean bool = QQNotificationManager.getInstance().areNotificationsEnabled(BaseApplicationImpl.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("NewMsgNotificationManager", 2, new Object[] { "systemNotificationEnabled: invoked. ", " enable: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public boolean aqn()
  {
    boolean bool = SettingCloneUtil.readValue(this.mApp.getApp(), this.mApp.getCurrentUin(), null, "new_msg_notification_key", true);
    if (QLog.isColorLevel()) {
      QLog.d("NewMsgNotificationManager", 2, new Object[] { "globalSwitchOn: invoked. ", " enable: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public void b(BaseActivity paramBaseActivity, TextView paramTextView)
  {
    Object localObject = this.mApp.getApp().getResources();
    int i = paramTextView.getCurrentTextColor();
    String str = ((Resources)localObject).getString(2131697099);
    localObject = new SpannableString(str + "允许QQ通知" + ((Resources)localObject).getString(2131697100));
    ((SpannableString)localObject).setSpan(new ajcf(this, paramBaseActivity), str.length(), (str + "允许QQ通知").length(), 17);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
    paramTextView.setClickable(true);
    paramTextView.setTextColor(i);
  }
  
  public boolean bh(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewMsgNotificationManager", 2, new Object[] { "needDecodeIcon: invoked. ", " iconType: ", paramString1, " iconUrl: ", paramString2 });
    }
    return (("1".equals(paramString1)) || ("2".equals(paramString1))) && (!TextUtils.isEmpty(paramString2));
  }
  
  public boolean f(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage == null) {
      return true;
    }
    return M(paramMessage.istroop, paramMessage.frienduin);
  }
  
  public void onActivityDestroy()
  {
    this.a = null;
  }
  
  public void onDestroy() {}
  
  public void u(BaseActivity paramBaseActivity)
  {
    ajcg localajcg = new ajcg(this);
    ajch localajch = new ajch(this, paramBaseActivity);
    aqha.a(paramBaseActivity, 230, null, paramBaseActivity.getString(2131695156), paramBaseActivity.getString(2131721058), paramBaseActivity.getString(2131695155), localajch, localajcg).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajcd
 * JD-Core Version:    0.7.0.1
 */