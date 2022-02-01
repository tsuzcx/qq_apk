import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListAdapter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.ShortcutRouterActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils.3;
import com.tencent.mobileqq.activity.aio.AIOUtils.4;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.lang.reflect.Field;
import java.util.List;
import mqq.os.MqqHandler;

public final class wja
{
  private static SparseIntArray J = new SparseIntArray();
  private static Boolean W = Boolean.valueOf(true);
  private static String aSA = "HM NOTE 1LTETD";
  private static String aSB = "NX507J";
  private static String aSz;
  public static volatile int bNG;
  public static volatile int bNH;
  public static volatile boolean bcD;
  public static volatile boolean bcE;
  public static volatile boolean bcF;
  public static volatile boolean bcG;
  public static volatile boolean bcH;
  public static volatile boolean bcI;
  public static volatile boolean bcJ;
  public static volatile boolean bcK;
  public static volatile boolean bcL;
  public static volatile boolean bcM;
  public static volatile boolean bcN;
  public static boolean bcO;
  private static boolean bcP;
  public static volatile boolean logcatDBOperation;
  private static Field q;
  public static int sScreenWidth;
  private static ThreadLocal<char[]> t = new wjb();
  
  static
  {
    aSz = "OPPO;R7Plusm;22|OPPO;R7007;18|OPPO;R2017;18|OPPO;N5117;18|OPPO;A33;22|OPPO;OPPO A33;22";
  }
  
  public static boolean Rb()
  {
    return Build.MANUFACTURER.equalsIgnoreCase("Samsung");
  }
  
  public static boolean Rc()
  {
    return (Rb()) && (aK(BaseApplicationImpl.getContext())) && (!aJ(BaseApplicationImpl.getContext()));
  }
  
  public static boolean Rd()
  {
    if (aSB.equalsIgnoreCase(Build.MODEL)) {}
    while (aSA.equalsIgnoreCase(Build.MODEL)) {
      return true;
    }
    String str = Build.MANUFACTURER + ";" + Build.MODEL + ";" + Build.VERSION.SDK_INT;
    String[] arrayOfString = aSz.split("\\|");
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label101;
      }
      if (arrayOfString[i].equalsIgnoreCase(str)) {
        break;
      }
      i += 1;
    }
    label101:
    return false;
  }
  
  public static void S(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    int i = paramView.getPaddingTop();
    int j = paramView.getPaddingLeft();
    int k = paramView.getPaddingRight();
    int m = paramView.getPaddingBottom();
    paramView.setBackgroundResource(paramInt);
    paramView.setPadding(j, i, k, m);
  }
  
  public static final float a(int paramInt1, int paramInt2, Resources paramResources)
  {
    return TypedValue.applyDimension(paramInt1, paramInt2, paramResources.getDisplayMetrics());
  }
  
  public static final float a(int paramInt, Resources paramResources)
  {
    if (paramInt == 0) {
      return 0.0F;
    }
    return paramInt / paramResources.getDisplayMetrics().density;
  }
  
  public static final int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(Math.round(paramResources.getDisplayMetrics().density) * paramFloat);
  }
  
  public static int a(long paramLong, ListAdapter paramListAdapter)
  {
    int j;
    if (paramListAdapter == null)
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramListAdapter.getCount()) {
        break label62;
      }
      Object localObject = paramListAdapter.getItem(i);
      if ((localObject instanceof ChatMessage))
      {
        j = i;
        if (((ChatMessage)localObject).uniseq == paramLong) {
          break;
        }
      }
      i += 1;
    }
    label62:
    return -1;
  }
  
  public static int a(ansf paramansf, String paramString)
  {
    paramansf = paramansf.getAttribute(paramString);
    if (TextUtils.isEmpty(paramansf)) {}
    do
    {
      return 0;
      try
      {
        int i = Integer.parseInt(paramansf);
        return i;
      }
      catch (Exception paramansf) {}
    } while (!QLog.isColorLevel());
    QLog.d("StructMsg", 2, paramansf.getMessage());
    return 0;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Intent paramIntent)
  {
    if ((paramIntent.getBooleanExtra("open_chatfragment", false)) && ((paramFragmentActivity instanceof SplashActivity)))
    {
      Fragment localFragment = paramFragmentActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if ((localFragment != null) && (localFragment.isVisible()))
      {
        if (a(paramFragmentActivity, paramQQAppInterface, false, paramIntent)) {
          return 2;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "openAIO by MT");
        }
        paramQQAppInterface = (ChatFragment)localFragment;
        paramIntent.putExtra("isBack2Root", true);
        paramFragmentActivity.setIntent(paramIntent);
        paramQQAppInterface.sm(3);
        paramQQAppInterface.onPause();
        paramQQAppInterface.onStop();
        paramQQAppInterface.bJy();
        paramQQAppInterface.onStart();
        paramQQAppInterface.onResume();
        return 1;
      }
    }
    return 0;
  }
  
  public static Intent a(Intent paramIntent, int[] paramArrayOfInt)
  {
    paramIntent.putExtra("open_chatfragment", true);
    paramIntent.addFlags(67108864);
    if (paramArrayOfInt != null)
    {
      int j = paramArrayOfInt.length;
      int i = 0;
      if (i < j)
      {
        switch (paramArrayOfInt[i])
        {
        }
        for (;;)
        {
          i += 1;
          break;
          paramIntent.putExtra("open_chatfragment_withanim", true);
          continue;
          paramIntent.addFlags(268435456);
        }
      }
    }
    return paramIntent;
  }
  
  public static final View a(ListView paramListView, int paramInt)
  {
    if ((paramInt >= paramListView.getFirstVisiblePosition()) && (paramInt <= paramListView.getLastVisiblePosition())) {
      return paramListView.getChildAt(paramInt - paramListView.getFirstVisiblePosition());
    }
    return null;
  }
  
  public static ChatMessage a(long paramLong, ListAdapter paramListAdapter)
  {
    Object localObject;
    if (paramListAdapter == null)
    {
      localObject = null;
      return localObject;
    }
    int i = paramListAdapter.getCount() - 1;
    for (;;)
    {
      if (i <= 0) {
        break label68;
      }
      localObject = paramListAdapter.getItem(i);
      if ((localObject instanceof ChatMessage))
      {
        ChatMessage localChatMessage = (ChatMessage)localObject;
        localObject = localChatMessage;
        if (localChatMessage.uniseq == paramLong) {
          break;
        }
      }
      i -= 1;
    }
    label68:
    return null;
  }
  
  @Deprecated
  public static final ChatMessage a(View paramView)
  {
    paramView = (wko.a)a(paramView);
    if (paramView != null) {
      return paramView.mMessage;
    }
    return null;
  }
  
  public static final Object a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    if ((paramView.getParent() == null) || ((paramView.getParent() instanceof ListView))) {
      return paramView.getTag();
    }
    return a((View)paramView.getParent());
  }
  
  public static Runnable a(View paramView, URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable.getStatus() == 0) || (paramURLDrawable.getStatus() == 4)) {}
    for (int i = 1;; i = 0)
    {
      AIOUtils.4 local4 = null;
      if (i != 0)
      {
        local4 = new AIOUtils.4(paramURLDrawable, paramView);
        paramView.postDelayed(local4, 200L);
      }
      return local4;
    }
  }
  
  public static void a(View paramView, Drawable paramDrawable)
  {
    if ((paramDrawable == null) || (paramView == null)) {
      return;
    }
    Rect localRect = new Rect();
    paramDrawable.getPadding(localRect);
    int i = paramView.getPaddingTop();
    int j = localRect.top;
    int k = paramView.getPaddingLeft();
    int m = localRect.left;
    int n = paramView.getPaddingRight();
    int i1 = localRect.right;
    int i2 = paramView.getPaddingBottom();
    int i3 = localRect.bottom;
    paramView.setBackgroundDrawable(paramDrawable);
    paramView.setPadding(k + m, i + j, n + i1, i3 + i2);
  }
  
  public static final void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, wki paramwki, ChatMessage paramChatMessage)
  {
    
    if (wgv.bNc <= 0) {
      return;
    }
    m(paramQQAppInterface, a(paramBaseChatPie, paramwki, paramChatMessage));
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, int paramInt3, Object paramObject, int paramInt4)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
    } while (paramQQAppInterface == null);
    if (QLog.isColorLevel()) {
      QLog.d(paramString, 2, new Object[] { "postDelayedChatPieMessage MSG: ", Integer.valueOf(paramInt1), " arg1: ", Integer.valueOf(paramInt2), "arg2: ", Integer.valueOf(paramInt3), "obj: ", String.valueOf(paramObject) });
    }
    paramQQAppInterface.removeMessages(paramInt1);
    paramQQAppInterface.sendMessageDelayed(paramQQAppInterface.obtainMessage(paramInt1, paramInt2, paramInt3, paramObject), paramInt4);
  }
  
  @Deprecated
  public static void a(String paramString1, String paramString2, Exception paramException)
  {
    QLog.e(paramString1, 1, paramString2, paramException);
  }
  
  public static void a(String paramString1, String paramString2, RuntimeException paramRuntimeException)
  {
    QLog.e(paramString1, 1, paramString2, paramRuntimeException);
  }
  
  protected static boolean a(BaseChatPie paramBaseChatPie, wki paramwki, ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    boolean bool1;
    int j;
    if (paramChatMessage == null)
    {
      paramwki = paramwki.getList();
      bool1 = bool2;
      if (paramwki != null)
      {
        bool1 = bool2;
        if (paramwki.size() > 0)
        {
          j = paramwki.size();
          if (wgv.bNc <= 1) {
            break label115;
          }
          i = wgv.bNc;
          if (j <= i) {
            break label121;
          }
          j = i;
          label61:
          if (!(paramBaseChatPie instanceof ycd)) {
            break label162;
          }
        }
      }
    }
    label140:
    label162:
    for (int i = 1;; i = 0)
    {
      j -= 1;
      label76:
      bool1 = bool2;
      if (j > -1)
      {
        paramBaseChatPie = (ChatMessage)paramwki.get(j);
        if (i == 0) {
          break label124;
        }
        if (!wgv.f(paramBaseChatPie)) {
          break label140;
        }
        bool1 = true;
      }
      label115:
      label121:
      label124:
      do
      {
        return bool1;
        i = 10;
        break;
        break label61;
        if ((!paramBaseChatPie.isread) && (wgv.f(paramBaseChatPie))) {
          return true;
        }
        j -= 1;
        break label76;
        bool1 = bool2;
      } while (!wgv.f(paramChatMessage));
      return true;
    }
  }
  
  private static boolean a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    try
    {
      String str = paramIntent.getStringExtra("uin");
      int i = paramIntent.getIntExtra("uintype", -1);
      if (str == null) {
        return false;
      }
      if (i == -1)
      {
        QQToast.a(paramBaseActivity, paramBaseActivity.getString(2131720225), 0).show(paramBaseActivity.getTitleBarHeight());
        return false;
      }
      if (paramIntent.hasExtra("account"))
      {
        anot.a(paramQQAppInterface, "CliOper", "", "", "Fast_launch", "Fast_launch_msg", 0, 0, "1", "", "", "");
        if (!((acff)paramQQAppInterface.getManager(51)).isFriend(str))
        {
          paramIntent.removeExtra("account");
          paramIntent.putExtra("shotcut_forward", ChatActivity.class.getName());
          paramIntent.setClassName(paramBaseActivity, ShortcutRouterActivity.class.getName());
          paramBaseActivity.startActivity(paramIntent);
          return false;
        }
      }
      if ((paramIntent.getBooleanExtra("shortcut", false)) && (!((acff)paramQQAppInterface.getManager(51)).isFriend(str)))
      {
        QQToast.a(paramBaseActivity.getApplicationContext(), paramBaseActivity.getString(2131720226), 0).show(paramBaseActivity.getTitleBarHeight());
        return false;
      }
      return true;
    }
    catch (RuntimeException paramBaseActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.AIOUtils", 2, "RuntimeException isValidChat beforeEnterAIO.");
      }
    }
    return false;
  }
  
  public static boolean a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, boolean paramBoolean, Intent paramIntent)
  {
    aqmq.track(null, "AIO_doOnCreate_BeforeEnterCost");
    if (!paramQQAppInterface.isLogin())
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.setClass(paramBaseActivity, LoginActivity.class);
      paramQQAppInterface.addFlags(262144);
      paramBaseActivity.startActivity(paramQQAppInterface);
      paramBaseActivity.finish();
    }
    do
    {
      do
      {
        do
        {
          return true;
          if (paramBoolean)
          {
            if (a(paramBaseActivity, paramQQAppInterface, paramIntent)) {
              break label212;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.AIOUtils", 2, " isValidChat 1 false");
            }
            paramBaseActivity.finish();
            return true;
          }
          if (!paramBaseActivity.isFinishing()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("Q.aio.AIOUtils", 2, "onNewIntent isFinishing");
        return true;
        if (!skd.a().a(paramIntent, paramBaseActivity, paramQQAppInterface)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.aio.AIOUtils", 2, "onNewIntent ThridApp to chatactivity");
      return true;
      Bundle localBundle = paramIntent.getExtras();
      if ((localBundle == null) || (!localBundle.getBoolean("back_from_emojimall", false))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.aio.AIOUtils", 2, "onNewIntent KEY_EMOJIMALL_CLOSE_BACK to chatactivity");
    return true;
    if (!a(paramBaseActivity, paramQQAppInterface, paramIntent))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.AIOUtils", 2, " isValidChat 2 false");
      }
      paramBaseActivity.finish();
      return true;
    }
    label212:
    aqmq.track("AIO_doOnCreate_BeforeEnterCost", null);
    return false;
  }
  
  public static boolean aJ(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().hardKeyboardHidden == 1;
  }
  
  public static boolean aK(Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    return (paramContext.hasSystemFeature("com.sec.feature.folder_type")) && (paramContext.hasSystemFeature("com.sec.feature.dual_lcd"));
  }
  
  public static StringBuilder b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      if (W.booleanValue())
      {
        q = StringBuilder.class.getSuperclass().getDeclaredField("value");
        q.setAccessible(true);
        W = Boolean.valueOf(false);
      }
      if (q != null) {
        q.set(localStringBuilder, t.get());
      }
      return localStringBuilder;
    }
    catch (Exception localException) {}
    return localStringBuilder;
  }
  
  protected static void bYu()
  {
    boolean bool = true;
    Object localObject;
    if (wgv.bNc == -1)
    {
      localObject = DeviceProfileManager.a().jf(DeviceProfileManager.DpcNames.aio_gifplay.name());
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length > 3) {
          if ((!localObject[0].equals("1")) || (!localObject[1].equals("1"))) {
            break label111;
          }
        }
      }
    }
    for (;;)
    {
      wgv.bck = bool;
      if (!"0".equals(localObject[3])) {}
      try
      {
        i = Integer.parseInt(localObject[3]);
        if (wgv.bcj)
        {
          wgv.bNc = i;
          if (wgv.bNc == -1) {
            wgv.bNc = 0;
          }
          return;
          label111:
          bool = false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i = 0;
          continue;
          i = 0;
        }
      }
    }
  }
  
  public static final int dp2px(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static void eR(View paramView)
  {
    if (paramView == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.XPanelContainer", 2, "showKeyboard failed, view is null ");
      }
    }
    label386:
    for (;;)
    {
      return;
      InputMethodManager localInputMethodManager;
      if (paramView.requestFocus())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.XPanelContainer", 2, " requestFocus success ");
        }
        boolean bool = paramView.hasFocus();
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.XPanelContainer", 2, " hasFocus " + bool);
        }
        localInputMethodManager = (InputMethodManager)paramView.getContext().getSystemService("input_method");
        if (!localInputMethodManager.showSoftInput(paramView, 0)) {
          break label177;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.XPanelContainer", 2, " showSoftInput success ");
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label386;
        }
        QLog.d("Q.aio.XPanelContainer", 2, " imm.isActive() = " + localInputMethodManager.isActive());
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.aio.XPanelContainer", 2, " requestFocus fail ");
        break;
        label177:
        if (QLog.isColorLevel()) {
          QLog.e("Q.aio.XPanelContainer", 2, " showSoftInput fail ");
        }
        try
        {
          Object localObject2 = localInputMethodManager.getClass();
          Object localObject1 = ((Class)localObject2).getDeclaredField("mServedView");
          localObject2 = ((Class)localObject2).getDeclaredField("mNextServedView");
          ((Field)localObject1).setAccessible(true);
          ((Field)localObject2).setAccessible(true);
          localObject1 = ((Field)localObject1).get(localInputMethodManager);
          localObject2 = ((Field)localObject2).get(localInputMethodManager);
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.XPanelContainer", 2, " showSoftInput fail mNextServedObject = " + localObject2 + " mServedObject" + localObject1 + " messageInputer = " + paramView);
          }
          if ((localObject1 != null) && (localObject1 != paramView) && ((localObject1 instanceof View)))
          {
            localInputMethodManager.hideSoftInputFromWindow(((View)localObject1).getWindowToken(), 0);
            paramView.requestFocusFromTouch();
            paramView.requestFocus();
            if ((!localInputMethodManager.showSoftInput(paramView, 0)) && (QLog.isColorLevel())) {
              QLog.d("Q.aio.XPanelContainer", 2, " try showSoftInput fail ");
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.XPanelContainer", 2, " try showSoftInput end");
            }
          }
        }
        catch (Exception paramView)
        {
          paramView.printStackTrace();
        }
      }
    }
  }
  
  public static int eU(int paramInt)
  {
    int i = 0;
    long l = 0L;
    int j = eW(paramInt);
    if (QLog.isColorLevel()) {
      l = SystemClock.uptimeMillis();
    }
    for (;;)
    {
      try
      {
        if (bcP) {
          return eV(paramInt);
        }
        Object localObject = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.aio_config.name(), "-1|1=0,2=0,3=0,4=0,5=1");
        if (QLog.isColorLevel()) {
          QLog.d("AIOUtils", 2, "aioConfig:" + (String)localObject);
        }
        localObject = ((String)localObject).split("\\|");
        if (localObject.length > 1)
        {
          localObject = localObject[1].split(",");
          if (localObject != null)
          {
            int k = localObject.length;
            if (i < k)
            {
              String[] arrayOfString = localObject[i].split("=");
              if ((arrayOfString == null) || (arrayOfString.length <= 1)) {
                break label284;
              }
              int m = Integer.valueOf(arrayOfString[0]).intValue();
              int n = Integer.valueOf(arrayOfString[1]).intValue();
              J.put(m, n);
              break label284;
            }
          }
        }
        bcP = true;
        i = eV(paramInt);
      }
      catch (Exception localException)
      {
        i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("AIOUtils", 2, "AIOTime getAIOMsgMenuState dpc exception", localException);
        i = j;
        continue;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("AIOUtils", 2, "AIOTime initAIOMsgMenuState|" + paramInt + "|" + i + "|" + (SystemClock.uptimeMillis() - l));
        return i;
      }
      return i;
      label284:
      i += 1;
    }
  }
  
  private static int eV(int paramInt)
  {
    int j = eW(paramInt);
    try
    {
      i = J.get(paramInt, j);
      if (QLog.isColorLevel()) {
        QLog.d("AIOUtils", 2, "AIOTime getVisibilityFromCache|" + J.toString() + "|" + paramInt + "|" + i);
      }
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = j;
        if (QLog.isColorLevel())
        {
          QLog.e("AIOUtils", 2, "AIOTime getAIOMsgMenuState dpc exception", localException);
          i = j;
        }
      }
    }
  }
  
  private static int eW(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    default: 
      return 1;
    }
    return 0;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    if (sScreenWidth > 0) {
      return sScreenWidth;
    }
    paramContext = (WindowManager)paramContext.getSystemService("window");
    Point localPoint;
    if (Build.VERSION.SDK_INT >= 13)
    {
      localPoint = new Point();
      paramContext.getDefaultDisplay().getSize(localPoint);
    }
    for (sScreenWidth = localPoint.y;; sScreenWidth = paramContext.getDefaultDisplay().getWidth()) {
      return sScreenWidth;
    }
  }
  
  public static void h(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, "AIOTime " + paramString2 + "|" + paramInt1 + "|" + paramInt2);
    }
  }
  
  public static void i(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramView == null) {
      return;
    }
    ((View)paramView.getParent()).post(new AIOUtils.3(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  protected static void m(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramBoolean) {
      ((WebProcessManager)paramQQAppInterface.getManager(13)).a(1, new wjc());
    }
  }
  
  public static void yn(boolean paramBoolean)
  {
    bcI = paramBoolean;
    bcJ = paramBoolean;
    bcK = paramBoolean;
    bcL = paramBoolean;
    bcN = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wja
 * JD-Core Version:    0.7.0.1
 */