import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.BaseGaInvite;
import com.tencent.av.gaudio.GaInviteDialogActivity;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.utils.TraeHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

public class jko
{
  static jko jdField_b_of_type_Jko;
  RemoteViews jdField_a_of_type_AndroidWidgetRemoteViews = null;
  QQNotificationManager jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager = null;
  jkd jdField_a_of_type_Jkd;
  jko.b jdField_a_of_type_Jko$b = null;
  final jko.b jdField_b_of_type_Jko$b = new jko.b(null);
  Map<String, jko.b> dk = new LinkedHashMap();
  VideoAppInterface mApp = null;
  Context mContext = null;
  int mFlag = 0;
  boolean mIsActive = false;
  Notification mNotification = null;
  
  private jko(VideoAppInterface paramVideoAppInterface)
  {
    this.mApp = paramVideoAppInterface;
    if (this.mContext == null) {
      this.mContext = this.mApp.getApplication().getApplicationContext();
    }
    this.jdField_a_of_type_Jkd = new jkd(this.mContext);
  }
  
  private Notification a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, int paramInt, Bitmap paramBitmap, PendingIntent paramPendingIntent, List<jko.a> paramList)
  {
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(this.mContext);
    localBuilder.setSmallIcon(paramInt);
    localBuilder.setContentTitle(paramString1);
    localBuilder.setContentText(paramString2);
    localBuilder.setWhen(System.currentTimeMillis());
    localBuilder.setLargeIcon(paramBitmap);
    localBuilder.setContentIntent(paramPendingIntent);
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramString1 = paramList.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (jko.a)paramString1.next();
        localBuilder.addAction(paramString2.icon, paramString2.title, paramString2.pendingIntent);
      }
    }
    if (paramBoolean2)
    {
      localBuilder.setPriority(2);
      localBuilder.setFullScreenIntent(paramPendingIntent, true);
      localBuilder.setVibrate(TraeHelper.v);
      this.mNotification = localBuilder.build();
      paramString1 = this.mNotification;
      paramString1.flags |= 0x2;
      paramString1 = this.mNotification;
      paramString1.flags |= 0x20;
      if ((!jjc.xA()) || (!paramBoolean2)) {
        break label358;
      }
      paramString1 = this.mNotification;
      paramString1.flags &= 0xFFFFFFF7;
      paramString1 = this.mNotification;
      paramString1.flags |= 0x4;
      paramString1 = this.mNotification;
      paramString1.flags |= 0x1;
      label253:
      if (Build.VERSION.SDK_INT >= 21)
      {
        if (!paramBoolean2) {
          break label409;
        }
        this.mNotification.category = "call";
        paramString1 = this.mNotification;
      }
    }
    for (paramString1.flags |= 0x80;; paramString1.flags &= 0xFFFFFF7F)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QAVNotification", 2, "useDefaultStyle flags: " + this.mNotification.flags);
      }
      return this.mNotification;
      localBuilder.setPriority(0);
      localBuilder.setFullScreenIntent(null, false);
      localBuilder.setVibrate(null);
      break;
      label358:
      paramString1 = this.mNotification;
      paramString1.flags |= 0x8;
      paramString1 = this.mNotification;
      paramString1.flags &= 0xFFFFFFFB;
      paramString1 = this.mNotification;
      paramString1.flags &= 0xFFFFFFFE;
      break label253;
      label409:
      this.mNotification.category = null;
      paramString1 = this.mNotification;
    }
  }
  
  private ArrayList<jko.a> a(jko.b paramb, Intent paramIntent)
  {
    if ((paramb == null) || (paramIntent == null)) {
      return null;
    }
    switch (paramb.type)
    {
    default: 
      return null;
    }
    ArrayList localArrayList = new ArrayList(2);
    paramIntent = new Intent(paramIntent);
    paramIntent.setAction("com.tencent.qav.notify.accept");
    paramIntent.putExtra("session_id", paramb.sessionId);
    localArrayList.add(new jko.a(2130842963, acfp.m(2131710350), PendingIntent.getActivity(this.mContext, 0, paramIntent, 134217728)));
    paramIntent = new Intent("com.tencent.qav.notify.refuse");
    paramIntent.putExtra("uin", this.mApp.getCurrentAccountUin());
    paramIntent.putExtra("session_id", paramb.sessionId);
    paramIntent.putExtra("notify_type", paramb.type);
    paramIntent.putExtra("uinType", paramb.uinType);
    localArrayList.add(new jko.a(2130842965, acfp.m(2131710349), PendingIntent.getBroadcast(this.mContext, 0, paramIntent, 134217728)));
    return localArrayList;
  }
  
  private jko.b a(String paramString, int paramInt)
  {
    jko.b localb = null;
    iiv localiiv = igv.a().c(paramString);
    if (localiiv != null)
    {
      localb = new jko.b(null);
      localb.sessionId = paramString;
      localb.sessionType = paramInt;
      if ((localiiv.amI == 1) || (localiiv.amI == 2))
      {
        localb.name = this.mApp.getDisplayName(localiiv.uinType, localiiv.peerUin, localiiv.MP);
        localb.bG = this.mApp.a(localiiv.uinType, localiiv.peerUin, null, true, true);
        if (localiiv.amI == 1)
        {
          localb.type = 47;
          this.dk.put(paramString, localb);
          if (!QLog.isColorLevel()) {
            return localb;
          }
          QLog.i("QAVNotification", 2, "createNotifyData, we create one data, data[" + localb + "]");
        }
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return localb;
        localb.type = 42;
        continue;
        String str;
        if (localiiv.Qw)
        {
          str = String.valueOf(localiiv.ll);
          localb.name = this.mApp.getDisplayName(localiiv.uinType, str, null);
          localb.bG = this.mApp.a(localiiv.uinType, str, null, true, true);
          localb.type = 48;
        }
        else
        {
          str = String.valueOf(localiiv.ll);
          localb.name = this.mApp.getDisplayName(localiiv.uinType, str, null);
          localb.bG = this.mApp.a(localiiv.uinType, str, null, true, true);
          if (localiiv.amI == 3) {
            localb.type = 62;
          } else {
            localb.type = 63;
          }
        }
      }
    }
    QLog.i("QAVNotification", 2, "createNotifyData, no sessionInfo, id[" + paramString + "]");
    return null;
    return localb;
  }
  
  public static jko a(VideoAppInterface paramVideoAppInterface)
  {
    if ((jdField_b_of_type_Jko == null) && (paramVideoAppInterface != null)) {}
    try
    {
      if (jdField_b_of_type_Jko == null) {
        jdField_b_of_type_Jko = new jko(paramVideoAppInterface);
      }
      return jdField_b_of_type_Jko;
    }
    finally {}
  }
  
  private void a(jko.b paramb, boolean paramBoolean)
  {
    a(paramb, paramBoolean, null, false);
  }
  
  private void a(jko.b paramb, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    a(paramb, paramBoolean1, paramString, paramBoolean2, false);
  }
  
  private void a(jko.b paramb, boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool1 = this.mApp.b().sB();
    boolean bool2 = cP(paramb.sessionId);
    boolean bool3 = cO(paramb.sessionId);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(200);
      ((StringBuilder)localObject1).append("updateNotification, data=").append(paramb).append(", create=").append(paramBoolean1).append(", time=").append(paramString).append(", invite=").append(paramBoolean2).append(", fullScreen=").append(paramBoolean3).append(", isSessionCanNotify=").append(bool3);
      QLog.d("QAVNotification", 2, ((StringBuilder)localObject1).toString());
    }
    if ((bool1) || ((!paramBoolean2) && (!bool2)) || (!bool3)) {}
    do
    {
      do
      {
        return;
        if (!TextUtils.isEmpty(paramString)) {
          a(paramb);
        }
        paramBoolean2 = jjc.cJ(this.mApp.getCurrentAccountUin());
        if (QLog.isColorLevel()) {
          QLog.w("QAVNotification", 2, "updateNotification avCallBtnState[" + paramBoolean2 + "]");
        }
      } while ((!paramBoolean2) && (TextUtils.isEmpty(paramString)) && (!a(paramb)));
      paramBoolean2 = TraeHelper.ai(BaseApplicationImpl.getContext());
      if (QLog.isColorLevel()) {
        QLog.w("QAVNotification", 2, "updateNotification canDisturb[" + paramBoolean2 + "]");
      }
    } while ((!paramBoolean2) && (TextUtils.isEmpty(paramString)) && (!a(paramb)));
    PendingIntent localPendingIntent = null;
    Object localObject4 = "";
    Object localObject5 = "";
    StringBuilder localStringBuilder = null;
    paramString = (String)localObject5;
    Object localObject1 = localObject4;
    Object localObject2 = localPendingIntent;
    Object localObject3 = localStringBuilder;
    int i;
    switch (paramb.type)
    {
    default: 
      localObject3 = localStringBuilder;
      localObject2 = localPendingIntent;
      localObject1 = localObject4;
      paramString = (String)localObject5;
    case 49: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 58: 
    case 59: 
    case 60: 
      i = iiv.ant;
      localPendingIntent = null;
      if (localObject2 != null)
      {
        ((Intent)localObject2).putExtra("MultiAVType", i);
        ((Intent)localObject2).putExtra("Fromwhere", "AVNotification");
        ((Intent)localObject2).addFlags(4194304);
        ((Intent)localObject2).addFlags(262144);
        ((Intent)localObject2).putExtra("param_notifyid", 235);
        ((Intent)localObject2).putExtra("fullscreen", paramBoolean3);
        if ((paramb.type != 40) && (paramb.type != 45) && (paramb.type != 43)) {
          ((Intent)localObject2).addFlags(268435456);
        }
        localPendingIntent = PendingIntent.getActivity(this.mContext, 0, (Intent)localObject2, 134217728);
      }
      if (i == 2) {
        localObject1 = ((String)localObject1).replace(this.mContext.getString(2131721245), this.mContext.getString(2131721246));
      }
      break;
    }
    for (;;)
    {
      if (i == 2) {
        paramString = paramString.replace(this.mContext.getString(2131721245), this.mContext.getString(2131721246));
      }
      for (;;)
      {
        localObject4 = a(paramb, (Intent)localObject2);
        if (QLog.isColorLevel())
        {
          localObject5 = new StringBuilder(300);
          localStringBuilder = ((StringBuilder)localObject5).append("updateNotification title: ").append((String)localObject1).append(", state: ").append(paramString).append(", id: ").append(paramb.id).append(", sessionId: ").append(paramb.sessionId).append(", name: ").append(paramb.name).append(", type: ").append(paramb.type).append(", avType: ").append(i).append(", actions: ");
          if (localObject4 != null) {
            break label2065;
          }
        }
        label2065:
        for (localObject2 = "null";; localObject2 = Integer.valueOf(((ArrayList)localObject4).size()))
        {
          localStringBuilder.append(localObject2).append(", time: ").append(System.currentTimeMillis());
          QLog.d("QAVNotification", 2, ((StringBuilder)localObject5).toString());
          try
          {
            paramString = a(paramBoolean1, paramBoolean3, (String)localObject1, paramString, 2130842268, (Bitmap)localObject3, localPendingIntent, (List)localObject4);
            if (Build.VERSION.SDK_INT >= 26) {
              QQNotificationManager.addChannelIfNeed(paramString, "CHANNEL_ID_SHOW_BADGE");
            }
            if (paramBoolean1) {
              this.mApp.a(true, paramString);
            }
            if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager == null) {
              this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager = QQNotificationManager.getInstance();
            }
            this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notify("QAVNotification", 235, paramString);
            paramb.isHide = false;
            jko.b.a(this.jdField_b_of_type_Jko$b, paramb);
            this.jdField_a_of_type_Jko$b = paramb;
            this.mIsActive = true;
            return;
          }
          catch (Throwable paramb)
          {
            QLog.e("QAVNotification", 1, "updateNotification fail.", paramb);
            return;
          }
          localObject2 = new Intent(this.mContext, AVActivity.class);
          ((Intent)localObject2).putExtra("isDoubleVideoMeeting", true);
          ((Intent)localObject2).putExtra("sessionType", paramb.sessionType);
          ((Intent)localObject2).putExtra("GroupId", paramb.id);
          localObject1 = paramb.name;
          if (paramb.sessionType == 4) {}
          for (paramString = this.mContext.getString(2131697886);; paramString = this.mContext.getString(2131697880))
          {
            localObject3 = paramb.bG;
            break;
          }
          localObject2 = new Intent(this.mContext, VideoInviteActivity.class);
          localObject1 = paramb.name;
          paramString = this.mContext.getString(2131721739);
          localObject3 = paramb.bG;
          break;
          localObject2 = new Intent(this.mContext, VideoInviteActivity.class);
          ((Intent)localObject2).addFlags(4194304);
          ((Intent)localObject2).addFlags(262144);
          localObject1 = paramb.name;
          paramString = this.mContext.getString(2131697885);
          localObject3 = paramb.bG;
          break;
          localObject2 = new Intent(this.mContext, AVActivity.class);
          ((Intent)localObject2).putExtra("sessionType", paramb.sessionType);
          ((Intent)localObject2).putExtra("uin", paramb.id);
          localObject1 = paramb.name;
          paramString = this.mContext.getString(2131697558);
          localObject3 = paramb.bG;
          break;
          localObject2 = new Intent(this.mContext, GaInviteDialogActivity.class);
          ((Intent)localObject2).putExtra("sessionType", paramb.sessionType);
          ((Intent)localObject2).putExtra("uinType", paramb.uinType);
          BaseGaInvite.a((Intent)localObject2, "updateNotification");
          localObject1 = paramb.name;
          if (TextUtils.isEmpty(paramb.SH)) {}
          for (paramString = this.mContext.getString(2131697856);; paramString = String.format(this.mContext.getString(2131697857), new Object[] { w(paramb.SH, 7) }))
          {
            localObject3 = paramb.bG;
            break;
          }
          localObject2 = jkq.c(this.mContext, paramb.sessionId);
          localObject1 = paramb.name;
          if (TextUtils.isEmpty(paramb.SH)) {}
          for (paramString = this.mContext.getString(2131697856);; paramString = String.format(this.mContext.getString(2131697857), new Object[] { w(paramb.SH, 7) }))
          {
            localObject3 = paramb.bG;
            break;
          }
          localObject2 = new Intent(this.mContext, AVActivity.class);
          ((Intent)localObject2).putExtra("sessionType", paramb.sessionType);
          ((Intent)localObject2).putExtra("uin", paramb.id);
          localObject1 = paramb.name;
          paramString = this.mContext.getString(2131697886);
          localObject3 = paramb.bG;
          break;
          localObject2 = new Intent(this.mContext, AVActivity.class);
          ((Intent)localObject2).putExtra("sessionType", paramb.sessionType);
          ((Intent)localObject2).putExtra("GroupId", paramb.id);
          localObject1 = paramb.name;
          paramString = this.mContext.getString(2131697558);
          localObject3 = paramb.bG;
          break;
          localObject2 = new Intent(this.mContext, AVActivity.class);
          ((Intent)localObject2).putExtra("sessionType", paramb.sessionType);
          ((Intent)localObject2).putExtra("GroupId", paramb.id);
          localObject1 = paramb.name;
          paramString = this.mContext.getString(2131697880);
          localObject3 = paramb.bG;
          break;
          localObject2 = new Intent(this.mContext, AVActivity.class);
          ((Intent)localObject2).putExtra("GroupId", paramb.id);
          ((Intent)localObject2).putExtra("Type", 2);
          ((Intent)localObject2).putExtra("sessionType", 3);
          ((Intent)localObject2).putExtra("uinType", paramb.uinType);
          ((Intent)localObject2).putExtra("sessionType", paramb.sessionType);
          localObject1 = paramb.name;
          paramString = this.mContext.getString(2131697752);
          localObject3 = paramb.bG;
          break;
          localObject2 = jkq.d(this.mContext, paramb.sessionId);
          localObject1 = paramb.name;
          paramString = this.mContext.getString(2131690633);
          localObject3 = paramb.bG;
          break;
          localObject2 = jkq.d(this.mContext, paramb.sessionId);
          localObject1 = paramb.name;
          paramString = this.mContext.getString(2131721739);
          localObject3 = paramb.bG;
          break;
          localObject2 = jkq.d(this.mContext, paramb.sessionId);
          localObject1 = paramb.name;
          if (TextUtils.isEmpty(paramb.SH)) {}
          for (paramString = this.mContext.getString(2131697856);; paramString = String.format(this.mContext.getString(2131697857), new Object[] { w(paramb.SH, 7) }))
          {
            localObject3 = paramb.bG;
            break;
          }
          localObject2 = new Intent(this.mContext, AVActivity.class);
          ((Intent)localObject2).putExtra("GroupId", paramb.id);
          ((Intent)localObject2).putExtra("Type", 2);
          ((Intent)localObject2).putExtra("sessionType", 3);
          ((Intent)localObject2).putExtra("uinType", paramb.uinType);
          ((Intent)localObject2).putExtra("sessionType", paramb.sessionType);
          localObject1 = paramb.name;
          paramString = this.mContext.getString(2131697880);
          localObject3 = paramb.bG;
          break;
          localObject2 = new Intent(this.mContext, AVActivity.class);
          ((Intent)localObject2).putExtra("GroupId", paramb.id);
          ((Intent)localObject2).putExtra("Type", 2);
          ((Intent)localObject2).putExtra("sessionType", 3);
          ((Intent)localObject2).putExtra("uinType", paramb.uinType);
          ((Intent)localObject2).putExtra("sessionType", paramb.sessionType);
          localObject1 = paramb.name;
          paramString = this.mContext.getString(2131697886);
          localObject3 = paramb.bG;
          break;
        }
      }
    }
  }
  
  private boolean a(jko.b paramb)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((this.mFlag != 2) || (isActive()))
    {
      bool1 = bool2;
      if (isActive())
      {
        bool1 = bool2;
        if (!jko.b.a(this.jdField_b_of_type_Jko$b, paramb)) {}
      }
    }
    else
    {
      bool1 = true;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("QAVNotification", 4, "isNeedNotificationAnyWay, flag[" + this.mFlag + "], active[" + isActive() + "], come[" + paramb + "], last[" + this.jdField_b_of_type_Jko$b + "], need[" + bool1 + "]");
    }
    return bool1;
  }
  
  public static void bD(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QAVNotification", 2, "cancelNotificationForce", new Throwable());
    }
    QQNotificationManager.getInstance().cancel("QAVNotification", 235);
  }
  
  private boolean cN(String paramString)
  {
    if ((this.jdField_a_of_type_Jko$b == null) || (!this.mIsActive)) {}
    while (!TextUtils.equals(paramString, this.jdField_a_of_type_Jko$b.sessionId)) {
      return false;
    }
    return true;
  }
  
  private boolean cO(String paramString)
  {
    boolean bool2 = false;
    paramString = igv.a().c(paramString);
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (!paramString.a(this.mApp)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean cP(String paramString)
  {
    boolean bool2 = false;
    paramString = igv.a().c(paramString);
    boolean bool1 = bool2;
    if (paramString != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QAVNotification", 2, "isSessionIdVisible sessionInfo.sessionStatus = " + paramString.amH);
      }
      bool1 = bool2;
      if (paramString.amH != 3) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private String w(String paramString, int paramInt)
  {
    if (paramString == null) {}
    for (Object localObject1 = "";; localObject1 = paramString)
    {
      Object localObject2 = localObject1;
      if (((String)localObject1).length() >= paramInt)
      {
        localObject2 = localObject1;
        if (paramInt > 0)
        {
          localObject1 = paramString.toCharArray();
          paramString = String.valueOf(localObject1[0]);
          paramInt = 1;
          while (paramInt < 5)
          {
            paramString = paramString + String.valueOf(localObject1[paramInt]);
            paramInt += 1;
          }
          localObject2 = paramString + "...";
        }
      }
      return localObject2;
    }
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      a(paramString1, paramString2, paramBitmap, paramString3, paramInt1, paramInt2, paramInt3, null);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4)
  {
    for (;;)
    {
      try
      {
        boolean bool1 = this.mApp.b().sB();
        boolean bool2 = this.mApp.b().b().tc();
        boolean bool3 = this.mApp.b().isGameMode();
        boolean bool4 = cN(paramString1);
        if (QLog.isColorLevel()) {
          QLog.w("QAVNotification", 2, "addNotification, sessionId[" + paramString1 + "], name[" + paramString2 + "], id[" + paramString3 + "], type[" + paramInt1 + "], uinType[" + paramInt2 + "], sessionType[" + paramInt3 + "], isNearbyVideoChat[" + bool1 + "], isActiveSession[" + bool4 + "], isBeInviting[" + bool2 + "], isGameMode[" + bool3 + "]");
        }
        if ((bool1) || ((bool2) && (bool3))) {
          return;
        }
        if (TextUtils.isEmpty(paramString1)) {
          continue;
        }
        if (bool4)
        {
          jko.b localb = this.jdField_a_of_type_Jko$b;
          localb.sessionId = paramString1;
          localb.bG = paramBitmap;
          localb.type = paramInt1;
          localb.id = paramString3;
          localb.name = paramString2;
          localb.uinType = paramInt2;
          localb.sessionType = paramInt3;
          localb.SH = paramString4;
          a(localb, false);
          continue;
        }
        paramString2 = new jko.b(paramString1, paramString2, paramBitmap, paramString3, paramInt1, paramInt2, paramInt3, null);
      }
      finally {}
      this.dk.put(paramString1, paramString2);
      a(paramString2, true);
    }
  }
  
  public void a(jko.b paramb)
  {
    int i = 48;
    if (paramb == null) {}
    for (;;)
    {
      return;
      iiv localiiv = igv.a().c(paramb.sessionId);
      if (localiiv != null)
      {
        int j = paramb.type;
        if (localiiv.Qw) {
          if (!localiiv.te()) {}
        }
        while (paramb.type != i)
        {
          if (QLog.isColorLevel()) {
            QLog.i("QAVNotification", 2, "checkAndUpdateNotifyData, pre[" + paramb.type + "], cur[" + i + "], info[" + localiiv + "]");
          }
          paramb.type = i;
          return;
          if (localiiv.td())
          {
            paramb.sessionType = localiiv.amI;
            continue;
            if (localiiv.ti())
            {
              if (localiiv.td())
              {
                if (localiiv.amI == 3)
                {
                  i = 62;
                  continue;
                }
                i = 63;
              }
            }
            else if (localiiv.isConnected())
            {
              if (localiiv.amI == 1)
              {
                i = 47;
                continue;
              }
              i = 42;
              continue;
            }
          }
          i = j;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      try
      {
        boolean bool1 = this.mApp.b().sB();
        boolean bool2 = this.mApp.b().isGameMode();
        boolean bool3 = cN(paramString1);
        QLog.w("QAVNotification", 1, "addInviteNotification, sessionId[" + paramString1 + "], name[" + paramString2 + "], id[" + paramString3 + "], type[" + paramInt1 + "], uinType[" + paramInt2 + "], sessionType[" + paramInt3 + "], isNearbyVideoChat[" + bool1 + "], isActiveSession[" + bool3 + "], isGameMode[" + bool2 + "]");
        if ((bool1) || (bool2)) {
          return;
        }
        if (TextUtils.isEmpty(paramString1)) {
          continue;
        }
        if (!bool3) {
          break label269;
        }
        jko.b localb = this.jdField_a_of_type_Jko$b;
        localb.sessionId = paramString1;
        localb.bG = paramBitmap;
        localb.type = paramInt1;
        localb.id = paramString3;
        localb.uinType = paramInt2;
        localb.sessionType = paramInt3;
        localb.name = paramString2;
        localb.SH = null;
        if (paramBoolean)
        {
          a(localb, true, null, true);
          continue;
        }
        a(localb, false, null, true);
      }
      finally {}
      continue;
      label269:
      paramString2 = new jko.b(paramString1, paramString2, paramBitmap, paramString3, paramInt1, paramInt2, paramInt3, null);
      this.dk.put(paramString1, paramString2);
      a(paramString2, true, null, true);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4)
  {
    for (;;)
    {
      try
      {
        boolean bool3 = this.mApp.b().sB();
        boolean bool4 = this.mApp.b().isGameMode();
        boolean bool5 = cN(paramString1);
        QLog.d("QAVNotification", 1, String.format("addFullScreenInviteNotification isNearbyVideoChat=%s isGameMode=%s isActiveSession=%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5) }));
        boolean bool1;
        jko.b localb;
        if ((!bool3) && (!bool4))
        {
          bool1 = true;
          boolean bool2 = bool1;
          if (!bool1)
          {
            bool2 = bool1;
            if (jjc.xA()) {
              bool2 = true;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.i("QAVNotification", 2, "addFullScreenInviteNotification needNotify[" + bool2 + "], isGameMode[" + bool4 + "], isNearbyVideoChat[" + bool3 + "], isUseCompatMode[" + jjc.xA() + "]");
          }
          if ((bool2) && (!TextUtils.isEmpty(paramString1)))
          {
            if (!bool5) {
              break label299;
            }
            localb = this.jdField_a_of_type_Jko$b;
            localb.sessionId = paramString1;
            localb.bG = paramBitmap;
            localb.type = paramInt1;
            localb.id = paramString3;
            localb.uinType = paramInt2;
            localb.sessionType = paramInt3;
            localb.name = paramString2;
            localb.SH = paramString4;
            if (!paramBoolean) {
              continue;
            }
            a(localb, true, null, true, true);
          }
        }
        else
        {
          bool1 = false;
          continue;
        }
        a(localb, false, null, true, true);
        continue;
        paramString2 = new jko.b(paramString1, paramString2, paramBitmap, paramString3, paramInt1, paramInt2, paramInt3, paramString4);
      }
      finally {}
      label299:
      this.dk.put(paramString1, paramString2);
      a(paramString2, true, null, true, true);
    }
  }
  
  public void axu()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QAVNotification", 2, "cancelNotificationEx mIsActive: " + this.mIsActive, new Throwable());
      }
      if (this.mIsActive)
      {
        if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {
          this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("QAVNotification", 235);
        }
        this.mApp.a(false, null);
        this.jdField_a_of_type_Jko$b = null;
        this.mIsActive = false;
        this.dk.clear();
        this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager = null;
        this.mNotification = null;
        this.jdField_a_of_type_AndroidWidgetRemoteViews = null;
      }
      return;
    }
    finally {}
  }
  
  public void bj(String paramString1, String paramString2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QAVNotification", 2, "changeNotificationSessionId " + paramString1 + " to " + paramString2);
      }
      jko.b localb = (jko.b)this.dk.get(paramString1);
      if (localb != null)
      {
        this.dk.remove(paramString1);
        this.dk.put(paramString2, localb);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public boolean cL(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +42 -> 49
    //   10: ldc 195
    //   12: iconst_2
    //   13: new 197	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   20: ldc_w 742
    //   23: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: getfield 45	jko:mIsActive	Z
    //   30: invokevirtual 397	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   33: ldc_w 744
    //   36: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_1
    //   40: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 408	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aload_0
    //   50: aload_1
    //   51: invokespecial 662	jko:cN	(Ljava/lang/String;)Z
    //   54: ifeq +44 -> 98
    //   57: aload_0
    //   58: getfield 47	jko:jdField_a_of_type_Jko$b	Ljko$b;
    //   61: iconst_1
    //   62: putfield 529	jko$b:isHide	Z
    //   65: aload_0
    //   66: getfield 37	jko:jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager	Lcom/tencent/commonsdk/util/notification/QQNotificationManager;
    //   69: ifnull +15 -> 84
    //   72: aload_0
    //   73: getfield 37	jko:jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager	Lcom/tencent/commonsdk/util/notification/QQNotificationManager;
    //   76: ldc 195
    //   78: sipush 235
    //   81: invokevirtual 622	com/tencent/commonsdk/util/notification/QQNotificationManager:cancel	(Ljava/lang/String;I)V
    //   84: aload_0
    //   85: aconst_null
    //   86: putfield 47	jko:jdField_a_of_type_Jko$b	Ljko$b;
    //   89: aload_0
    //   90: iconst_0
    //   91: putfield 45	jko:mIsActive	Z
    //   94: aload_0
    //   95: monitorexit
    //   96: iload_2
    //   97: ireturn
    //   98: iconst_0
    //   99: istore_2
    //   100: goto -6 -> 94
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	jko
    //   0	108	1	paramString	String
    //   1	99	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	49	103	finally
    //   49	84	103	finally
    //   84	94	103	finally
  }
  
  /* Error */
  public boolean cM(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 52	jko:dk	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 736 2 0
    //   12: checkcast 9	jko$b
    //   15: astore_3
    //   16: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +58 -> 77
    //   22: ldc 195
    //   24: iconst_1
    //   25: new 197	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   32: ldc_w 747
    //   35: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_1
    //   39: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc_w 749
    //   45: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_0
    //   49: getfield 45	jko:mIsActive	Z
    //   52: invokevirtual 397	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   55: ldc_w 751
    //   58: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_3
    //   62: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   65: ldc_w 345
    //   68: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 425	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload_3
    //   78: ifnull +29 -> 107
    //   81: aload_3
    //   82: getfield 529	jko$b:isHide	Z
    //   85: ifeq +22 -> 107
    //   88: aload_0
    //   89: getfield 45	jko:mIsActive	Z
    //   92: ifne +15 -> 107
    //   95: aload_0
    //   96: aload_3
    //   97: iconst_1
    //   98: invokespecial 684	jko:a	(Ljko$b;Z)V
    //   101: iconst_1
    //   102: istore_2
    //   103: aload_0
    //   104: monitorexit
    //   105: iload_2
    //   106: ireturn
    //   107: iconst_0
    //   108: istore_2
    //   109: goto -6 -> 103
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	jko
    //   0	117	1	paramString	String
    //   102	7	2	bool	boolean
    //   15	82	3	localb	jko.b
    // Exception table:
    //   from	to	target	type
    //   2	77	112	finally
    //   81	101	112	finally
  }
  
  public void cancelNotification(String paramString)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("QAVNotification", 2, "cancelNotification mIsActive: " + this.mIsActive + ", sessionId:" + paramString, new Throwable());
        }
        if (cN(paramString))
        {
          if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {
            this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("QAVNotification", 235);
          }
          this.dk.remove(paramString);
          this.jdField_a_of_type_Jko$b = null;
          this.mIsActive = false;
          jko.b.a(this.jdField_b_of_type_Jko$b, null);
          if (!this.dk.isEmpty())
          {
            paramString = this.dk.values().iterator();
            if (paramString.hasNext()) {
              a((jko.b)paramString.next(), true);
            }
            return;
          }
          nK(0);
          this.mApp.a(false, null);
          continue;
        }
        this.dk.remove(paramString);
      }
      finally {}
    }
  }
  
  public boolean isActive()
  {
    return this.mIsActive;
  }
  
  public void n(String paramString1, int paramInt, String paramString2)
  {
    for (;;)
    {
      boolean bool2;
      boolean bool3;
      jko.b localb2;
      try
      {
        jko.b localb3 = (jko.b)this.dk.get(paramString1);
        jko.b localb1 = localb3;
        if (localb3 == null)
        {
          int i = this.mFlag;
          localb1 = localb3;
          if (i != 2) {}
        }
        boolean bool1;
        try
        {
          localb1 = a(paramString1, paramInt);
          bool1 = this.mApp.b().sB();
          bool2 = cP(paramString1);
          bool3 = cN(paramString1);
          boolean bool4 = this.mApp.b().isGameMode();
          if (QLog.isColorLevel()) {
            QLog.w("QAVNotification", 2, "updateNotification, sessionId[" + paramString1 + "], mIsActive[" + this.mIsActive + "], SessionType[" + paramInt + "], isNearbyVideoChat[" + bool1 + "], isSessionIdVisible[" + bool2 + "], isActiveSession[" + bool3 + "], isGameMode[" + bool4 + "], time[" + paramString2 + "], data[" + localb1 + "]");
          }
          if (bool4)
          {
            bool4 = a(localb1);
            if (!bool4) {
              return;
            }
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          QLog.i("QAVNotification", 1, "updateNotification exception", localThrowable);
          localb2 = localb3;
          continue;
        }
        if (bool1) {
          continue;
        }
      }
      finally {}
      if ((bool2) && (localb2 != null) && ((bool3) || (a(localb2))))
      {
        paramString1 = igv.a().c(paramString1);
        if (((paramString1 == null) || (paramString1.a.anA != 4)) && (((this.mIsActive) && (this.mNotification != null)) || (a(localb2)))) {
          a(localb2, true, paramString2, false);
        }
      }
    }
  }
  
  public void nK(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QAVNotification", 2, "updateFlag, flag[" + paramInt + "]");
    }
    this.mFlag = paramInt;
  }
  
  static class a
  {
    public final int icon;
    public final PendingIntent pendingIntent;
    public final String title;
    
    public a(int paramInt, String paramString, PendingIntent paramPendingIntent)
    {
      this.icon = paramInt;
      this.title = paramString;
      this.pendingIntent = paramPendingIntent;
    }
  }
  
  class b
  {
    String SH;
    Bitmap bG;
    String id;
    boolean isHide = false;
    String name;
    String sessionId;
    int sessionType;
    int type;
    int uinType;
    
    private b()
    {
      b(null);
    }
    
    b(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4)
    {
      this.sessionId = paramString1;
      this.name = paramString2;
      this.bG = paramBitmap;
      this.id = paramString3;
      this.type = paramInt1;
      this.uinType = paramInt2;
      this.sessionType = paramInt3;
      this.SH = paramString4;
    }
    
    private void b(b paramb)
    {
      if (paramb != null)
      {
        this.sessionId = paramb.sessionId;
        this.type = paramb.type;
        this.id = paramb.id;
        this.name = paramb.name;
        this.SH = paramb.SH;
        this.uinType = paramb.uinType;
        this.sessionType = paramb.sessionType;
        this.isHide = paramb.isHide;
        return;
      }
      this.sessionId = "";
      this.type = 0;
      this.id = "";
      this.name = "";
      this.SH = "";
      this.uinType = 0;
      this.sessionType = 0;
      this.isHide = false;
    }
    
    private boolean b(b paramb)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramb != null) {
        if (TextUtils.equals(this.sessionId, paramb.sessionId))
        {
          bool1 = bool2;
          if (this.type != paramb.type)
          {
            bool1 = bool2;
            if (!paramb.xM()) {}
          }
        }
        else
        {
          bool1 = true;
        }
      }
      return bool1;
    }
    
    private boolean xM()
    {
      return (this.type == 47) || (this.type == 42) || (this.type == 48) || (this.type == 44);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append("NotifyData{sessionId[").append(this.sessionId).append("], id[").append(this.id).append("], type[").append(this.type).append("], uinType[").append(this.uinType).append("], name[").append(this.name).append("], extraName[").append(this.SH).append("], head[");
      if (this.bG != null) {}
      for (boolean bool = true;; bool = false) {
        return bool + "], isHide[" + this.isHide + "]}";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jko
 * JD-Core Version:    0.7.0.1
 */