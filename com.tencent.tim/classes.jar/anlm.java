import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import common.config.service.QzoneConfig;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

public class anlm
{
  private static AtomicInteger bX = new AtomicInteger(-2147483648);
  private static AtomicInteger bY = new AtomicInteger(-2147483648);
  private static AtomicInteger bZ = new AtomicInteger(-2147483648);
  public static int bgColor;
  private static boolean cIo;
  public static int dJT = -2368549;
  public static int dJU;
  private static int dJV;
  public static int dJW;
  public static final int dJX;
  private static boolean isInited;
  public static int textColor;
  
  static
  {
    int i = 0;
    for (;;)
    {
      if (i < anlj.gS.length)
      {
        if (TextUtils.equals("2920", anlj.gS[i])) {
          dJU = i;
        }
      }
      else
      {
        dJV = 0;
        dJW = wja.dp2px(22.0F, BaseApplicationImpl.getApplication().getApplicationContext().getResources());
        dJX = wja.dp2px(40.0F, BaseApplicationImpl.getApplication().getApplicationContext().getResources());
        return;
      }
      i += 1;
    }
  }
  
  public static int Kb()
  {
    if (bgColor != 0) {
      return bgColor;
    }
    Object localObject = QIPCClientHelper.getInstance().getClient().callServer("QzoneIPCModule", "action_qzone_get_themeid", null);
    if ((localObject != null) && (((EIPCResult)localObject).data != null))
    {
      localObject = ((EIPCResult)localObject).data.getString("themeId");
      if (!"2971".equals(localObject)) {
        break label63;
      }
      bgColor = -1;
    }
    for (;;)
    {
      return bgColor;
      label63:
      if ("2921".equals(localObject)) {
        bgColor = -657670;
      } else if ("3064".equals(localObject)) {
        bgColor = -7084;
      } else if ("3063".equals(localObject)) {
        bgColor = -15542596;
      } else if ("3066".equals(localObject)) {
        bgColor = -34918;
      } else if ("3065".equals(localObject)) {
        bgColor = -10145065;
      } else if ("3067".equals(localObject)) {
        bgColor = -39054;
      } else if ("3491".equals(localObject)) {
        bgColor = -15120003;
      }
    }
  }
  
  public static int Kc()
  {
    if (textColor != 0) {
      return textColor;
    }
    Object localObject = QIPCClientHelper.getInstance().getClient().callServer("QzoneIPCModule", "action_qzone_get_themeid", null);
    if ((localObject != null) && (((EIPCResult)localObject).data != null))
    {
      localObject = ((EIPCResult)localObject).data.getString("themeId");
      if (!"2971".equals(localObject)) {
        break label67;
      }
      textColor = Color.parseColor("#03081A");
    }
    for (;;)
    {
      return textColor;
      label67:
      if ("2921".equals(localObject)) {
        textColor = Color.parseColor("#03081A");
      } else if ("3064".equals(localObject)) {
        textColor = Color.parseColor("#03081A");
      } else if ("3063".equals(localObject)) {
        textColor = -1;
      } else if ("3066".equals(localObject)) {
        textColor = -1;
      } else if ("3065".equals(localObject)) {
        textColor = -1;
      } else if ("3067".equals(localObject)) {
        textColor = -1;
      } else if ("3491".equals(localObject)) {
        textColor = -1;
      }
    }
  }
  
  public static final int Kd()
  {
    int i = 1;
    int j = 0;
    int k = 0;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      if ((i == 0) || (bY.get() == -2147483648) || (!lG(bY.get()))) {
        break label54;
      }
      i = bY.get();
    }
    label54:
    do
    {
      return i;
      i = 0;
      break;
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      i = k;
    } while (localObject == null);
    Object localObject = ThemeUtil.getUinThemePreferences((AppRuntime)localObject);
    i = ((SharedPreferences)localObject).getInt("key_simple_ui_pref_828", -1);
    if (!lG(i))
    {
      i = ((SharedPreferences)localObject).getInt("key_simple_ui_pref_new", 0);
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).remove("key_simple_ui_pref_new");
      ((SharedPreferences.Editor)localObject).commit();
      if (!lG(i)) {
        i = j;
      }
    }
    for (;;)
    {
      bY.compareAndSet(-2147483648, i);
      return i;
      i = anlj.nJ[i];
    }
  }
  
  public static int Ke()
  {
    int i = 1;
    int j = 0;
    int k = 0;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      if ((i == 0) || (bZ.get() == -2147483648) || (!lG(bZ.get()))) {
        break label54;
      }
      i = bZ.get();
    }
    label54:
    do
    {
      return i;
      i = 0;
      break;
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      i = k;
    } while (localObject == null);
    Object localObject = ThemeUtil.getUinThemePreferences((AppRuntime)localObject);
    i = ((SharedPreferences)localObject).getInt("key_simple_no_night_ui_828", -1);
    if (!lG(i))
    {
      k = ((SharedPreferences)localObject).getInt("key_simple_no_night_ui_new", 0);
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).remove("key_simple_no_night_ui_new");
      ((SharedPreferences.Editor)localObject).commit();
      i = j;
      if (lG(k))
      {
        if (k != dJU) {
          break label152;
        }
        i = j;
      }
    }
    for (;;)
    {
      bZ.compareAndSet(-2147483648, i);
      return i;
      label152:
      i = anlj.nJ[k];
    }
  }
  
  public static int Kf()
  {
    if (!isInited)
    {
      dRy();
      dRz();
      isInited = true;
    }
    if (ayn()) {
      return dJV;
    }
    return 0;
  }
  
  private static final void QH(String paramString)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((bX.get() != -2147483648) && (bY.get() != -2147483648) && (lG(bY.get())))
    {
      localObject = (anlk)((QQAppInterface)localObject).getBusinessHandler(154);
      if (bX.get() != 1) {
        break label150;
      }
    }
    label150:
    for (boolean bool = true;; bool = false)
    {
      int i = bY.get();
      ((anlk)localObject).f(bool, i);
      ((anlk)localObject).notifyUI(4, true, new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), paramString });
      if (QLog.isColorLevel()) {
        QLog.i("SimpleUILogSimpleUIUtil", 1, String.format(Locale.getDefault(), "onGetSimpleUISwitchOnLogin [%b,%b]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) }));
      }
      return;
    }
  }
  
  public static void Ve(int paramInt)
  {
    dJV = paramInt;
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("key_simple_status_sp_" + ((QQAppInterface)localObject).getCurrentAccountUin(), 0).edit();
      ((SharedPreferences.Editor)localObject).putInt("simple_ui_mode_switch", paramInt);
      ((SharedPreferences.Editor)localObject).apply();
    }
  }
  
  public static final boolean Vr()
  {
    return pp(ThemeUtil.getCurrentThemeId());
  }
  
  public static SystemBarCompact a(SystemBarCompact paramSystemBarCompact, Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    int i = 0;
    boolean bool = true;
    if (paramActivity == null) {
      return null;
    }
    if (ImmersiveUtils.isSupporImmersive() == 0) {
      return null;
    }
    int k = Kb();
    if (ImmersiveUtils.aJW())
    {
      paramActivity.getWindow().addFlags(ImmersiveUtils.FLAG_TRANSLUCENT_STATUS);
      ImmersiveUtils.clearCoverForStatus(paramActivity.getWindow(), true);
      if (paramSystemBarCompact == null) {
        if (!paramBoolean1)
        {
          paramBoolean1 = bool;
          paramSystemBarCompact = new SystemBarCompact(paramActivity, paramBoolean1, k);
          paramSystemBarCompact.init();
        }
      }
      for (;;)
      {
        ImmersiveUtils.setStatusTextColor(paramBoolean2, paramActivity.getWindow());
        return paramSystemBarCompact;
        paramBoolean1 = false;
        break;
        paramSystemBarCompact.setStatusBarColor(k);
      }
    }
    if (paramSystemBarCompact == null)
    {
      paramActivity.getWindow().addFlags(ImmersiveUtils.FLAG_TRANSLUCENT_STATUS);
      ImmersiveUtils.clearCoverForStatus(paramActivity.getWindow(), true);
      if (paramBoolean2) {
        i = dJT;
      }
      paramSystemBarCompact = new SystemBarCompact(paramActivity, true, i);
      paramSystemBarCompact.init();
      return paramSystemBarCompact;
    }
    i = j;
    if (paramBoolean2) {
      i = dJT;
    }
    paramSystemBarCompact.setStatusBarColor(i);
    return paramSystemBarCompact;
  }
  
  public static void a(ImmersiveTitleBar2 paramImmersiveTitleBar2, Window paramWindow)
  {
    if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.aJW()) && (!cIo)) {
      if (pq(ThemeUtil.getCurrentThemeId())) {
        if (!ThemeUtil.isSimpleColrThemeStateBarUseWhite(ThemeUtil.getCurrentThemeId())) {
          ImmersiveUtils.setStatusTextColor(false, paramWindow);
        }
      }
    }
    while ((ImmersiveUtils.isSupporImmersive() == 0) || (paramImmersiveTitleBar2 == null))
    {
      return;
      ImmersiveUtils.setStatusTextColor(true, paramWindow);
      return;
      ImmersiveUtils.setStatusTextColor(true, paramWindow);
      return;
    }
    paramImmersiveTitleBar2.setBackgroundColor(dJT);
  }
  
  public static void a(SystemBarCompact paramSystemBarCompact, Window paramWindow)
  {
    a(paramSystemBarCompact, paramWindow, null);
  }
  
  public static void a(SystemBarCompact paramSystemBarCompact, Window paramWindow, Boolean paramBoolean)
  {
    if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.aJW()) && (!cIo)) {
      if (paramBoolean == null)
      {
        bool = true;
        if (!pq(ThemeUtil.getCurrentThemeId())) {
          break label64;
        }
        if (ThemeUtil.isSimpleColrThemeStateBarUseWhite(ThemeUtil.getCurrentThemeId())) {
          break label57;
        }
        ImmersiveUtils.setStatusTextColor(false, paramWindow);
      }
    }
    label57:
    label64:
    while ((ImmersiveUtils.isSupporImmersive() == 0) || (paramSystemBarCompact == null))
    {
      boolean bool;
      for (;;)
      {
        return;
        bool = paramBoolean.booleanValue();
      }
      ImmersiveUtils.setStatusTextColor(true, paramWindow);
      return;
      ImmersiveUtils.setStatusTextColor(bool, paramWindow);
      return;
    }
    paramSystemBarCompact.setStatusBarColor(dJT);
  }
  
  public static void a(boolean paramBoolean, int paramInt, Window paramWindow)
  {
    if (ayn())
    {
      boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
      if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.aJW()) && (!bool))
      {
        if (!paramBoolean) {
          break label45;
        }
        ImmersiveUtils.setStatusTextColor(false, paramWindow);
      }
    }
    return;
    label45:
    ImmersiveUtils.setStatusTextColor(true, paramWindow);
  }
  
  public static final void aG(String paramString, int paramInt1, int paramInt2)
  {
    int i = 0;
    paramInt1 = anlj.nI[paramInt1];
    QLog.d("SimpleUILogSimpleUIUtil", 1, String.format("onGetSimpleUIPref type=%d bPref=%d uin=%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString }));
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject != null) && (paramString.equals(((QQAppInterface)localObject).getCurrentAccountUin())))
    {
      if (lG(paramInt1)) {
        break label158;
      }
      paramInt1 = i;
    }
    label158:
    for (;;)
    {
      bY.set(paramInt1);
      localObject = ThemeUtil.getUinThemePreferences((AppRuntime)localObject);
      ((SharedPreferences)localObject).edit().putInt("key_simple_ui_pref_828", paramInt1).apply();
      if (paramInt1 != dJU)
      {
        bZ.set(paramInt1);
        ((SharedPreferences)localObject).edit().putInt("key_simple_no_night_ui_828", paramInt1).apply();
      }
      if (paramInt2 == 1) {
        QH(paramString);
      }
      return;
    }
  }
  
  public static final boolean ayn()
  {
    int j = 1;
    boolean bool = false;
    if (BaseApplicationImpl.sProcessId == 1) {
      i = 1;
    }
    while ((i != 0) && (bX.get() != -2147483648)) {
      if (bX.get() == 1)
      {
        return true;
        i = 0;
      }
      else
      {
        return false;
      }
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null)
    {
      bool = ThemeUtil.getUinThemePreferences((AppRuntime)localObject).getBoolean("key_simple_ui_switch", false);
      localObject = bX;
      if (!bool) {
        break label92;
      }
    }
    label92:
    for (int i = j;; i = 0)
    {
      ((AtomicInteger)localObject).compareAndSet(-2147483648, i);
      return bool;
    }
  }
  
  public static final boolean ayo()
  {
    return (ayn()) && (!ThemeUtil.isNowThemeIsNightForQzone()) && (QzoneConfig.getInstance().getConfig("QZoneSetting", "qzonesimpleui", true));
  }
  
  public static boolean ayp()
  {
    return Color.parseColor("#03081A") == Kc();
  }
  
  private static void dRy()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      dJV = BaseApplicationImpl.getApplication().getSharedPreferences("key_simple_status_sp_" + ((QQAppInterface)localObject).getCurrentAccountUin(), 0).getInt("simple_ui_mode_switch", 0);
    }
  }
  
  private static void dRz()
  {
    if (dJV == 1) {}
  }
  
  public static int en(String paramString)
  {
    int i = 0;
    while (i < anlj.gS.length)
    {
      if (TextUtils.equals(paramString, anlj.gS[i])) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static boolean lG(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= anlj.gS.length))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SimpleUILogSimpleUIUtil", 2, "isValidSimplePref error bPref=" + paramInt);
      }
      return false;
    }
    return true;
  }
  
  public static final void m(String paramString, boolean paramBoolean, int paramInt)
  {
    int i = 0;
    QLog.d("SimpleUILogSimpleUIUtil", 1, String.format("onGetSimpleUISwitch type=%d bSwitch=%b uin=%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramString }));
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((localQQAppInterface != null) && (paramString.equals(localQQAppInterface.getCurrentAccountUin())))
    {
      AtomicInteger localAtomicInteger = bX;
      if (paramBoolean) {
        i = 1;
      }
      localAtomicInteger.set(i);
      ThemeUtil.getUinThemePreferences(localQQAppInterface).edit().putBoolean("key_simple_ui_switch", paramBoolean).commit();
      if (paramInt == 1) {
        QH(paramString);
      }
    }
  }
  
  public static void onDestroy()
  {
    bX.set(-2147483648);
    bY.set(-2147483648);
    bZ.set(-2147483648);
  }
  
  public static final boolean pp(String paramString)
  {
    return ("2920".equals(paramString)) || (pq(paramString));
  }
  
  public static boolean pq(String paramString)
  {
    return ("2971".equals(paramString)) || ("2921".equals(paramString)) || ("3064".equals(paramString)) || ("3063".equals(paramString)) || ("3066".equals(paramString)) || ("3065".equals(paramString)) || ("3067".equals(paramString)) || ("3491".equals(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anlm
 * JD-Core Version:    0.7.0.1
 */