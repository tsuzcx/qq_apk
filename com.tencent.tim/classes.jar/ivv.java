import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenDialogActivity;
import com.tencent.av.smallscreen.SmallScreenService;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class ivv
{
  public static final String[] aQ = { "vivo Y51A", "2014011" };
  static String[] aR = { "com.qzone.preview.BasePictureViewer", "com.qzone.preview.LocalPictureViewer", "com.qzone.preview.QzonePictureViewer", "com.qzone.preview.QZoneVideoFloatActivity", "com.tencent.mobileqq.activity.FriendProfileImageActivity", "com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity", "com.tencent.mobileqq.activity.photo.PhotoPreviewActivity", "com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity", "com.tencent.av.gaudio.GaInviteDialogActivity", "com.tencent.av.ui.MultiIncomingCallsActivity", "com.tencent.av.ui.GAudioMembersCtrlActivity", "com.tencent.av.ui.VideoInviteActivity", "com.tencent.mobileqq.activity.selectmember.SelectMemberActivity", "cooperation.qzone.QzonePicturePluginProxyActivity", "com.tencent.av.utils.PopupDialog", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity", "com.miui.permcenter.permissions.AppPermissionsEditorActivity", "com.meizu.safe.security.AppSecActivity", "com.android.settings.Settings$AppDrawOverlaySettingsActivity", "com.tencent.biz.qrcode.activity.QRDisplayActivity", "com.tencent.mobileqq.activity.ForwardRecentActivity", "cooperation.qzone.share.QZoneShareActivity" };
  static int auA = -1;
  static int auB = -1;
  static int auC = -1;
  public static int auD = 0;
  
  static iwc a()
  {
    imf localimf = ijc.a(BaseApplicationImpl.getContext());
    iwc localiwc;
    if (!localimf.isEmpty())
    {
      localiwc = new iwc();
      if (localiwc.b(localimf)) {}
    }
    while (!QLog.isColorLevel())
    {
      return null;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SmallScreenUtils", 2, "getSmallScreenConfigParser --> parseConfig fail");
      return localiwc;
    }
    QLog.d("SmallScreenUtils", 2, "getSmallScreenConfigParser --> Can not get PlayLoad Config");
    return null;
    return localiwc;
  }
  
  public static void a(long paramLong, int paramInt, Context paramContext)
  {
    boolean bool2 = false;
    Object localObject = VideoController.a();
    boolean bool1 = bool2;
    if (paramInt == 2)
    {
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 21)
      {
        bool1 = bool2;
        if (((VideoController)localObject).a().wG()) {
          bool1 = true;
        }
      }
    }
    QLog.w("SmallScreenUtils", 1, "avideo actionOff, seq[" + paramLong + "], isNeedBlock[" + bool1 + "], actionOffFrom[" + paramInt + "]");
    if (bool1) {}
    do
    {
      return;
      localObject = new Intent(paramContext, SmallScreenService.class);
      try
      {
        paramContext.stopService((Intent)localObject);
        return;
      }
      catch (Exception paramContext) {}
    } while (!QLog.isColorLevel());
    QLog.e("SmallScreenUtils", 2, "actionOff e = " + paramContext);
  }
  
  public static void a(long paramLong, int paramInt, Context paramContext, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    Intent localIntent = new Intent(paramContext, SmallScreenService.class);
    try
    {
      auD = paramInt;
      paramContext.stopService(localIntent);
      paramContext.startService(localIntent);
      if (!ad(BaseApplicationImpl.getContext())) {
        ikp.kQ(32);
      }
      if (AudioHelper.aCz()) {
        QLog.w("SmallScreenUtils", 1, "avideo actionOn isFloatWindowOpAllowed, isFloatWindowOpAllowed[" + isFloatWindowOpAllowed(paramContext) + "], isCalling[" + jkg.isCalling(paramContext) + "], isHome[" + ac(paramContext) + "], isNeedStartDialog[" + paramBoolean1 + "], actionOnFrom[" + paramInt + "], seq[" + paramLong + "]");
      }
      if (a(paramContext, paramBoolean1, paramString, paramBoolean2)) {
        anot.a(null, "CliOper", "", "", "0X80057D8", "0X80057D8", 0, 0, "", "", "", "");
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SmallScreenUtils", 2, "actionOn e = " + localException);
        }
      }
    }
  }
  
  public static void a(Context paramContext, iiv paramiiv)
  {
    int i = paramiiv.amI;
    int j = paramiiv.relationType;
    int k = paramiiv.state;
    if (QLog.isColorLevel())
    {
      QLog.d("SmallScreenUtils", 2, "reportActionOn SessionType = " + i);
      QLog.d("SmallScreenUtils", 2, "reportActionOn relationType = " + j);
      QLog.d("SmallScreenUtils", 2, "reportActionOn state = " + k);
    }
    if (paramiiv.jdField_a_of_type_Iiv$a.anA > 0) {
      if (paramiiv.jdField_a_of_type_Iiv$b.groupId > 0L) {
        paramiiv = "0X8005A49";
      }
    }
    for (;;)
    {
      if ((paramiiv != null) && (isFloatWindowOpAllowed(paramContext))) {
        anot.a(null, "CliOper", "", "", paramiiv, paramiiv, 0, 0, "", "", "", "");
      }
      return;
      if (paramiiv.jdField_a_of_type_Iiv$a.anA == 5)
      {
        paramiiv = "0X8005A48";
      }
      else
      {
        paramiiv = "0X8005A47";
        continue;
        switch (i)
        {
        }
        for (;;)
        {
          paramiiv = null;
          break;
          switch (k)
          {
          case 2: 
          case 3: 
          default: 
            paramiiv = null;
          }
          for (;;)
          {
            break;
            paramiiv = "0X8005A44";
            continue;
            paramiiv = "0X8005A43";
          }
          switch (k)
          {
          case 2: 
          case 3: 
          default: 
            paramiiv = null;
          }
          for (;;)
          {
            break;
            paramiiv = "0X80057DE";
            continue;
            paramiiv = "0X80057DD";
          }
          switch (j)
          {
          default: 
            paramiiv = null;
          }
          for (;;)
          {
            break;
            paramiiv = "0X8005A46";
            continue;
            paramiiv = "0X8005A45";
          }
          switch (j)
          {
          }
        }
        paramiiv = "0X80057E0";
        continue;
        paramiiv = "0X80057DF";
      }
    }
  }
  
  public static void a(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    boolean bool;
    label49:
    label64:
    AnimationSet localAnimationSet;
    if (paramView != null)
    {
      localObject = paramView.getTag(2131373917);
      if (localObject != null) {
        break label190;
      }
      bool = false;
      if ((!paramBoolean2) || (!bool)) {
        break label236;
      }
      localObject = paramView.getTag(2131373918);
      if (localObject != null) {
        break label203;
      }
      bool = false;
      if ((paramView.getVisibility() != 0) || (!bool)) {
        break label216;
      }
      bool = true;
      if (bool != paramBoolean1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SmallScreenUtils", 2, "startSetVisibleAnimation isVisible = " + paramBoolean1);
        }
        localAnimationSet = new AnimationSet(true);
        if (!paramBoolean1) {
          break label222;
        }
      }
    }
    label190:
    label203:
    label216:
    label222:
    for (Object localObject = new AlphaAnimation(0.0F, 1.0F);; localObject = new AlphaAnimation(1.0F, 0.0F))
    {
      ((AlphaAnimation)localObject).setDuration(400L);
      localAnimationSet.addAnimation((Animation)localObject);
      localAnimationSet.setAnimationListener(new ivw(paramView, paramBoolean1));
      paramView.startAnimation(localAnimationSet);
      paramView.setVisibility(0);
      paramView.setTag(2131373918, Boolean.valueOf(paramBoolean1));
      paramView.setTag(2131373917, Boolean.valueOf(paramBoolean2));
      return;
      bool = ((Boolean)localObject).booleanValue();
      break;
      bool = ((Boolean)localObject).booleanValue();
      break label49;
      bool = false;
      break label64;
    }
    label236:
    paramView.clearAnimation();
    if (paramBoolean1) {}
    for (;;)
    {
      paramView.setVisibility(i);
      break;
      i = 8;
    }
  }
  
  public static boolean a(long paramLong, VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    boolean bool2 = false;
    SmallScreenService.Vy = false;
    boolean bool1 = bool2;
    if (paramVideoAppInterface != null)
    {
      bool1 = bool2;
      if (paramVideoAppInterface.getApplication() != null)
      {
        bool1 = bool2;
        if (paramVideoAppInterface.getApp() != null)
        {
          bool1 = bool2;
          if (paramVideoAppInterface.b() != null)
          {
            bool1 = bool2;
            if (paramVideoAppInterface.b().b() != null)
            {
              Object localObject = paramVideoAppInterface.b().b();
              String str = ((iiv)localObject).peerUin;
              if ((((iiv)localObject).amI == 3) || (((iiv)localObject).amI == 4)) {
                str = String.valueOf(((iiv)localObject).ll);
              }
              localObject = new Intent("tencent.video.v2q.SmallScreenState");
              ((Intent)localObject).setPackage(paramVideoAppInterface.getApplication().getPackageName());
              ((Intent)localObject).putExtra("SmallScreenState", paramInt);
              jlc.a((Intent)localObject, paramLong);
              ((Intent)localObject).putExtra("uin", str);
              paramVideoAppInterface.getApp().sendBroadcast((Intent)localObject);
              if (QLog.isDevelopLevel()) {
                QLog.w("SmallScreenUtils", 1, "sendSmallScreenStateBroadcast, state[" + paramInt + "], seq[" + paramLong + "]");
              }
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    int i = 5;
    boolean bool = false;
    if (!paramBoolean1)
    {
      paramBoolean1 = true;
      i = 1;
    }
    for (;;)
    {
      if (AudioHelper.aCz()) {
        QLog.w("SmallScreenUtils", 1, "startSmallScreenDialogActivity, ret[" + paramBoolean1 + "], code[" + i + "]");
      }
      return paramBoolean1;
      if (isDisable())
      {
        i = 7;
        paramBoolean1 = bool;
      }
      else if (isFloatWindowOpAllowed(paramContext))
      {
        i = 2;
        paramBoolean1 = bool;
      }
      else if (jkg.isCalling(paramContext))
      {
        i = 3;
        paramBoolean1 = bool;
      }
      else if (ac(paramContext))
      {
        i = 4;
        paramBoolean1 = bool;
      }
      else
      {
        paramBoolean1 = bool;
        if (!af(paramContext)) {
          if ((!TextUtils.isEmpty(paramString)) && (d(paramString, paramBoolean2) >= 5))
          {
            i = 6;
            paramBoolean1 = bool;
          }
          else
          {
            paramString = new Intent(paramContext, SmallScreenDialogActivity.class);
            paramString.addFlags(268435456);
            paramString.addFlags(536870912);
            paramString.addFlags(67108864);
            paramString.addFlags(131072);
            paramString.putExtra("is_video", paramBoolean2);
            paramContext.startActivity(paramString);
            i = 100;
            paramBoolean1 = true;
          }
        }
      }
    }
  }
  
  public static boolean ac(Context paramContext)
  {
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool4;
    try
    {
      List localList = paramContext.getPackageManager().queryIntentActivities(new Intent("android.intent.action.MAIN", null).addCategory("android.intent.category.HOME"), 0);
      bool2 = bool4;
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
      if (paramContext != null)
      {
        bool2 = bool4;
        paramContext = paramContext.iterator();
        bool2 = bool1;
        bool3 = bool1;
        if (paramContext.hasNext())
        {
          bool2 = bool1;
          String str = ((ActivityManager.RunningTaskInfo)paramContext.next()).topActivity.getClassName();
          bool2 = bool1;
          Iterator localIterator = localList.iterator();
          do
          {
            bool2 = bool1;
            if (!localIterator.hasNext()) {
              break;
            }
            bool2 = bool1;
            bool3 = ((ResolveInfo)localIterator.next()).activityInfo.name.equals(str);
          } while (!bool3);
          bool1 = true;
          for (;;)
          {
            if (bool1) {
              return bool1;
            }
            break;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      igd.aL("SmallScreenUtils", paramContext.getMessage());
      return bool2;
    }
    return bool3;
  }
  
  public static boolean ad(Context paramContext)
  {
    boolean bool = VideoController.isScreenLocked(paramContext);
    if (((Build.MANUFACTURER.equals("Xiaomi")) && (Build.MODEL.equals("HM NOTE 1TD"))) || (Build.MODEL.equals("MI 3C")) || (Build.MODEL.equals("HM NOTE 1S"))) {}
    for (int i = 1; (bool) && (i == 0); i = 0) {
      return true;
    }
    return false;
  }
  
  public static boolean ae(Context paramContext)
  {
    return (b(paramContext, 24, true)) || (vI());
  }
  
  public static boolean af(Context paramContext)
  {
    boolean bool1;
    if (paramContext == null)
    {
      bool1 = false;
      return bool1;
    }
    label121:
    do
    {
      try
      {
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
        if ((paramContext == null) || (paramContext.size() <= 0)) {
          break label121;
        }
        paramContext = ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity;
      }
      catch (Throwable paramContext)
      {
        boolean bool2;
        return false;
      }
      bool2 = jjd.contains(aR, paramContext.getClassName());
      bool1 = bool2;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.w("SmallScreenUtils", 1, "checkTopActivityHideSmallScreen, topActivity[" + paramContext.getClassName() + "], check[" + bool2 + "]");
      return bool2;
      paramContext = null;
    } while (paramContext != null);
    return false;
  }
  
  public static void arh()
  {
    if (QLog.isColorLevel())
    {
      StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
      String str = "";
      int j = arrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        str = str + "ste[" + i + "]" + arrayOfStackTraceElement[i].toString() + "\n";
        i += 1;
      }
      QLog.d("SmallScreenUtils", 2, str);
    }
  }
  
  public static boolean b(Context paramContext, int paramInt, boolean paramBoolean)
  {
    if (isDisable()) {}
    for (;;)
    {
      return false;
      if (vL()) {
        paramInt = n(paramContext, paramInt);
      }
      while (paramInt == 0)
      {
        return true;
        int i = o(paramContext, paramInt);
        paramInt = i;
        if (!paramBoolean)
        {
          paramInt = i;
          if (i != 0) {
            if (vK()) {
              paramInt = 0;
            } else {
              paramInt = 2;
            }
          }
        }
      }
    }
  }
  
  public static int cu(int paramInt)
  {
    switch (paramInt)
    {
    case 9: 
    default: 
      return 2130772230;
    case 1: 
      return 2130772227;
    case 2: 
      return 2130772228;
    case 3: 
      return 2130772226;
    case 4: 
      return 2130772225;
    case 5: 
      return 2130772224;
    case 6: 
      return 2130772232;
    case 7: 
      return 2130772233;
    case 8: 
      return 2130772231;
    }
    return 2130772229;
  }
  
  public static int d(String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = getSharedPreferences(paramString);
    if (paramBoolean) {}
    for (paramString = "pref_show_dialog_video";; paramString = "pref_show_dialog_audio")
    {
      int i = localSharedPreferences.getInt(paramString, 0);
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenUtils", 2, "getPrefShowDialog result = " + i);
      }
      return i;
    }
  }
  
  public static void e(String paramString, int paramInt, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = getSharedPreferences(paramString).edit();
    if (paramBoolean) {}
    for (paramString = "pref_show_dialog_video";; paramString = "pref_show_dialog_audio")
    {
      localEditor.putInt(paramString, paramInt).commit();
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenUtils", 2, "setPrefShowDialog value = " + paramInt);
      }
      return;
    }
  }
  
  static SharedPreferences getSharedPreferences(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("com.tencent.av.smallscreen" + paramString, 0);
  }
  
  public static boolean hasSmartBar()
  {
    boolean bool3 = false;
    boolean bool2 = bool3;
    if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {}
    boolean bool1;
    try
    {
      bool1 = ((Boolean)Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
      if (Build.DEVICE.equals("mx2"))
      {
        bool2 = true;
        return bool2;
      }
    }
    catch (Exception localException)
    {
      do
      {
        do
        {
          for (;;)
          {
            bool1 = false;
          }
          bool2 = bool3;
        } while (Build.DEVICE.equals("mx"));
        bool2 = bool3;
      } while (Build.DEVICE.equals("m9"));
    }
    return bool1;
  }
  
  public static boolean isAppOnForeground(Context paramContext)
  {
    boolean bool2 = false;
    String str = paramContext.getPackageName();
    for (;;)
    {
      try
      {
        localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
        List localList = localActivityManager.getRunningTasks(1);
        localRunningAppProcessInfo = null;
        paramContext = localRunningAppProcessInfo;
        if (localList != null)
        {
          paramContext = localRunningAppProcessInfo;
          if (localList.size() > 0) {
            paramContext = ((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity;
          }
        }
        if ((paramContext == null) || (!paramContext.getPackageName().startsWith(str))) {
          break label260;
        }
        if (!QLog.isDevelopLevel()) {
          break label265;
        }
        QLog.d("SmallScreenUtils", 2, "isAppOnForeground componentName = " + paramContext);
      }
      catch (Throwable paramContext)
      {
        ActivityManager localActivityManager;
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
        bool1 = bool2;
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("SmallScreenUtils", 2, "isAppOnForeground e = " + paramContext);
        return false;
      }
      if (bool1)
      {
        paramContext = localActivityManager.getRunningAppProcesses();
        if (paramContext != null)
        {
          paramContext = paramContext.iterator();
          if (paramContext.hasNext())
          {
            localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
            if ((localRunningAppProcessInfo.importance != 100) || (!localRunningAppProcessInfo.processName.startsWith(str))) {
              continue;
            }
            if (QLog.isDevelopLevel()) {
              QLog.d("SmallScreenUtils", 2, "isAppOnForeground appProcess.processName = " + localRunningAppProcessInfo.processName);
            }
            bool1 = true;
            return bool1;
          }
        }
        bool1 = false;
        continue;
      }
      continue;
      label260:
      boolean bool1 = false;
      continue;
      label265:
      bool1 = true;
    }
  }
  
  public static boolean isDisable()
  {
    return false;
  }
  
  public static boolean isFloatWindowOpAllowed(Context paramContext)
  {
    boolean bool = false;
    if ((b(paramContext, 24, false)) || (vI())) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isIntentAvailable(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().queryIntentActivities(new Intent(paramString), 65536).size() > 0;
  }
  
  public static void jL(String paramString)
  {
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    int j = arrayOfStackTraceElement.length;
    paramString = "" + "getTrace[" + paramString + "]\n";
    int i = 1;
    while (i < j)
    {
      paramString = paramString + "ste[" + i + "]" + arrayOfStackTraceElement[i].toString() + "\n";
      i += 1;
    }
    QLog.d("SmallScreenUtils", 1, paramString);
  }
  
  /* Error */
  public static int n(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 753	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 4
    //   6: ldc_w 755
    //   9: invokestatic 761	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   12: astore 5
    //   14: new 143	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   21: ldc_w 763
    //   24: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_0
    //   28: invokevirtual 719	android/content/Context:getPackageName	()Ljava/lang/String;
    //   31: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc_w 765
    //   37: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: astore 6
    //   45: aload 4
    //   47: aload 5
    //   49: iconst_1
    //   50: anewarray 16	java/lang/String
    //   53: dup
    //   54: iconst_0
    //   55: ldc_w 767
    //   58: aastore
    //   59: aload 6
    //   61: aconst_null
    //   62: aconst_null
    //   63: invokestatic 773	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   66: astore 5
    //   68: aload 5
    //   70: ifnull +177 -> 247
    //   73: aload 5
    //   75: astore 4
    //   77: aload 5
    //   79: invokeinterface 778 1 0
    //   84: ifeq +163 -> 247
    //   87: aload 5
    //   89: astore 4
    //   91: aload 5
    //   93: iconst_0
    //   94: invokeinterface 780 2 0
    //   99: istore_3
    //   100: iload_3
    //   101: ifne +68 -> 169
    //   104: iconst_0
    //   105: istore_2
    //   106: aload 5
    //   108: astore 4
    //   110: ldc 112
    //   112: iconst_1
    //   113: new 143	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   120: ldc_w 782
    //   123: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: iload_3
    //   127: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   130: ldc_w 784
    //   133: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: iload_2
    //   137: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   140: ldc 165
    //   142: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 172	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: iload_2
    //   152: istore_1
    //   153: aload 5
    //   155: ifnull +12 -> 167
    //   158: aload 5
    //   160: invokeinterface 787 1 0
    //   165: iload_2
    //   166: istore_1
    //   167: iload_1
    //   168: ireturn
    //   169: iconst_2
    //   170: istore_2
    //   171: goto -65 -> 106
    //   174: astore 6
    //   176: aconst_null
    //   177: astore 5
    //   179: aload 5
    //   181: astore 4
    //   183: ldc 112
    //   185: iconst_1
    //   186: ldc_w 789
    //   189: aload 6
    //   191: invokestatic 792	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   194: aload 5
    //   196: astore 4
    //   198: aload_0
    //   199: iload_1
    //   200: invokestatic 630	ivv:o	(Landroid/content/Context;I)I
    //   203: istore_2
    //   204: iload_2
    //   205: istore_1
    //   206: aload 5
    //   208: ifnull -41 -> 167
    //   211: aload 5
    //   213: invokeinterface 787 1 0
    //   218: iload_2
    //   219: ireturn
    //   220: astore_0
    //   221: aconst_null
    //   222: astore 4
    //   224: aload 4
    //   226: ifnull +10 -> 236
    //   229: aload 4
    //   231: invokeinterface 787 1 0
    //   236: aload_0
    //   237: athrow
    //   238: astore_0
    //   239: goto -15 -> 224
    //   242: astore 6
    //   244: goto -65 -> 179
    //   247: iconst_0
    //   248: istore_2
    //   249: goto -98 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	paramContext	Context
    //   0	252	1	paramInt	int
    //   105	144	2	i	int
    //   99	28	3	j	int
    //   4	226	4	localObject1	Object
    //   12	200	5	localObject2	Object
    //   43	17	6	str	String
    //   174	16	6	localThrowable1	Throwable
    //   242	1	6	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	68	174	java/lang/Throwable
    //   0	68	220	finally
    //   77	87	238	finally
    //   91	100	238	finally
    //   110	151	238	finally
    //   183	194	238	finally
    //   198	204	238	finally
    //   77	87	242	java/lang/Throwable
    //   91	100	242	java/lang/Throwable
    //   110	151	242	java/lang/Throwable
  }
  
  @TargetApi(23)
  public static int o(Context paramContext, int paramInt)
  {
    do
    {
      for (;;)
      {
        try
        {
          if (vJ())
          {
            boolean bool = Settings.canDrawOverlays(paramContext);
            if (bool)
            {
              i = 0;
              k = i;
              m = i;
            }
          }
        }
        catch (InvocationTargetException paramContext)
        {
          Object localObject;
          if (QLog.isColorLevel()) {
            QLog.e("SmallScreenUtils", 2, "checkOp_Common InvocationTargetException", paramContext);
          }
          return 2;
          int i = j;
          continue;
        }
        catch (Exception paramContext)
        {
          int m = 0;
          int k = m;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("SmallScreenUtils", 2, "checkOp_Common Exception", paramContext);
          return m;
        }
        try
        {
          if (QLog.isColorLevel())
          {
            m = i;
            QLog.w("SmallScreenUtils", 1, "checkOp_Common canDrawOve rlays, op[" + paramInt + "], result[" + i + "]");
            k = i;
          }
          return k;
        }
        catch (Exception paramContext)
        {
          continue;
          j = 0;
          continue;
        }
        i = 2;
      }
      localObject = paramContext.getSystemService("appops");
      paramContext = Class.forName("android.app.AppOpsManager").getMethod("checkOp", new Class[] { Integer.TYPE, Integer.TYPE, String.class }).invoke(localObject, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramContext.getApplicationInfo().uid), paramContext.getPackageName() });
      if (paramContext == null) {
        break label317;
      }
      j = ((Integer)paramContext).intValue();
      if (3 != j) {
        break label281;
      }
      i = Build.VERSION.SDK_INT;
      if (i >= 23) {
        break label281;
      }
      i = 0;
      k = i;
      m = i;
    } while (!QLog.isColorLevel());
    m = i;
    QLog.w("SmallScreenUtils", 1, "checkOp_Common suc, op[" + paramInt + "], mode[" + j + "], result[" + i + "]");
    return i;
  }
  
  public static void o(Context paramContext, boolean paramBoolean)
  {
    Intent localIntent = new Intent("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("isResume", paramBoolean);
    paramContext.sendBroadcast(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenUtils", 2, "sendHideSmallScreenBroadcast:" + paramBoolean);
    }
  }
  
  public static boolean tY()
  {
    boolean bool2 = true;
    boolean bool1;
    if (!imh.tY())
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenUtils", 2, "isSupportSmallScreen --> Small Screen Switch Is Closed");
      }
      bool1 = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenUtils", 2, "isSupportSmallScreen result = " + bool1);
      }
      return bool1;
      iwc localiwc = a();
      bool1 = bool2;
      if (localiwc != null)
      {
        bool1 = bool2;
        if (localiwc.auK > 0) {
          bool1 = false;
        }
      }
    }
  }
  
  public static boolean vI()
  {
    String[] arrayOfString = aQ;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (Build.MODEL.equals(str))
      {
        QLog.w("SmallScreenUtils", 1, "useTypeToast, model[" + Build.MODEL + "]");
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  @TargetApi(23)
  static boolean vJ()
  {
    if (auA == -1)
    {
      auA = 0;
      if (Build.VERSION.SDK_INT < 28) {
        break label32;
      }
      auA = 1;
    }
    while (auA == 1)
    {
      return true;
      label32:
      if (Build.VERSION.SDK_INT < 23) {}
    }
    return false;
  }
  
  static boolean vK()
  {
    if (auB == -1)
    {
      auB = 0;
      if ((Build.MANUFACTURER.equals("vivo")) && (!"vivo X6D".equalsIgnoreCase(Build.MODEL)) && (!"vivo X6D".equalsIgnoreCase(Build.MODEL))) {
        break label56;
      }
    }
    while (auB == 1)
    {
      return true;
      label56:
      auB = 1;
    }
    return false;
  }
  
  public static boolean vL()
  {
    return (Build.VERSION.SDK_INT >= 21) && (Build.MANUFACTURER.equalsIgnoreCase("vivo"));
  }
  
  public static boolean vM()
  {
    boolean bool2 = true;
    boolean bool1;
    if (!imh.tY())
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenUtils", 2, "isSupportSmallScreenVideo --> Small Screen Switch Is Closed");
      }
      bool1 = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenUtils", 2, "isSupportSmallScreenVideo result = " + bool1);
      }
      return bool1;
      iwc localiwc = a();
      bool1 = bool2;
      if (localiwc != null)
      {
        bool1 = bool2;
        if (localiwc.auM > 0) {
          bool1 = false;
        }
      }
    }
  }
  
  public static boolean vN()
  {
    boolean bool2 = true;
    boolean bool1;
    if (!imh.tY())
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenUtils", 2, "isSupportSmallScreenAudio --> Small Screen Switch Is Closed");
      }
      bool1 = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenUtils", 2, "isSupportSmallScreenAudio result = " + bool1);
      }
      return bool1;
      iwc localiwc = a();
      bool1 = bool2;
      if (localiwc != null)
      {
        bool1 = bool2;
        if (localiwc.auN > 0) {
          bool1 = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ivv
 * JD-Core Version:    0.7.0.1
 */