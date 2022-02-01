import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.AccessibilityUtil.3;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.List;

public class aqcl
{
  public static void Q(View paramView, boolean paramBoolean)
  {
    if ((AppSetting.enableTalkBack) && (Build.VERSION.SDK_INT >= 16))
    {
      if (paramBoolean) {
        ViewCompat.setImportantForAccessibility(paramView, 1);
      }
    }
    else {
      return;
    }
    ViewCompat.setImportantForAccessibility(paramView, 2);
  }
  
  public static void R(View paramView, boolean paramBoolean)
  {
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = localViewGroup.getChildCount();
      int i = 0;
      while (i < j)
      {
        R(localViewGroup.getChildAt(i), paramBoolean);
        i += 1;
      }
    }
    if (paramBoolean)
    {
      ViewCompat.setImportantForAccessibility(paramView, 1);
      return;
    }
    ViewCompat.setImportantForAccessibility(paramView, 2);
  }
  
  public static void a(View paramView, aqcl.a parama)
  {
    paramView.setAccessibilityDelegate(new aqcp(parama));
  }
  
  @TargetApi(14)
  public static void b(EditText paramEditText, String paramString)
  {
    if ((AppSetting.enableTalkBack) && (Build.VERSION.SDK_INT >= 14))
    {
      paramEditText.setContentDescription(paramString);
      paramEditText.setAccessibilityDelegate(new aqcm());
    }
  }
  
  public static boolean bJ(Context paramContext)
  {
    return ((AccessibilityManager)paramContext.getSystemService("accessibility")).isEnabled();
  }
  
  @TargetApi(14)
  public static void changeAccessibilityForView(View paramView, CharSequence paramCharSequence, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      paramView.setAccessibilityDelegate(new aqcq(paramCharSequence, paramString));
    }
  }
  
  public static void changeAccessibilityForView(View paramView, String paramString)
  {
    changeAccessibilityForView(paramView, null, paramString);
  }
  
  @TargetApi(14)
  public static void fu(Context paramContext)
  {
    try
    {
      paramContext = (AccessibilityManager)paramContext.getSystemService("accessibility");
      boolean bool1 = paramContext.isEnabled();
      boolean bool2 = paramContext.isTouchExplorationEnabled();
      if ((bool1) && (bool2)) {}
      for (bool1 = true;; bool1 = false)
      {
        AppSetting.enableTalkBack = bool1;
        if (QLog.isColorLevel()) {
          QLog.d("AccessibilityUtil", 2, "setTalkbackSwitch: " + AppSetting.enableTalkBack);
        }
        return;
      }
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  @TargetApi(16)
  public static void io(View paramView)
  {
    if ((AppSetting.enableTalkBack) && (Build.VERSION.SDK_INT >= 14)) {
      paramView.setAccessibilityDelegate(new aqcn());
    }
  }
  
  @TargetApi(14)
  public static void ip(View paramView)
  {
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("AccessibilityUtil", 2, "requestFocus view can't be null");
      }
      return;
    }
    paramView.postDelayed(new AccessibilityUtil.3(paramView), 200L);
  }
  
  @TargetApi(16)
  public static void iq(View paramView)
  {
    AccessibilityManager localAccessibilityManager = (AccessibilityManager)paramView.getContext().getSystemService("accessibility");
    if ((localAccessibilityManager != null) && (Build.VERSION.SDK_INT >= 14) && (localAccessibilityManager.isEnabled()))
    {
      paramView.setFocusable(true);
      paramView.setAccessibilityDelegate(new aqco());
    }
  }
  
  @TargetApi(16)
  public static void ir(View paramView)
  {
    int i = 0;
    if (paramView == null) {
      if (QLog.isColorLevel()) {
        QLog.w("AccessibilityUtil", 2, "clearFocus view can't be null");
      }
    }
    label122:
    for (;;)
    {
      return;
      if ((AppSetting.enableTalkBack) && (Build.VERSION.SDK_INT > 15))
      {
        Method[] arrayOfMethod = paramView.getClass().getMethods();
        int j = arrayOfMethod.length;
        for (;;)
        {
          if (i >= j) {
            break label122;
          }
          Method localMethod = arrayOfMethod[i];
          if (localMethod.getName().equals("clearAccessibilityFocus"))
          {
            try
            {
              localMethod.invoke(paramView, new Object[0]);
              return;
            }
            catch (Exception paramView) {}
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.w("AccessibilityUtil", 2, "clearFocus: " + paramView.toString());
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  public static void s(View paramView, String paramString)
  {
    if (AppSetting.enableTalkBack) {
      paramView.setContentDescription(paramString);
    }
  }
  
  @TargetApi(16)
  public static boolean speak(View paramView, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(16384);
      localAccessibilityEvent.setPackageName(paramView.getContext().getPackageName());
      localAccessibilityEvent.setClassName(paramView.getClass().getName());
      localAccessibilityEvent.setSource(paramView);
      localAccessibilityEvent.getText().add(paramString);
      paramView.getParent().requestSendAccessibilityEvent(paramView, localAccessibilityEvent);
    }
    for (;;)
    {
      return true;
      QQAppInterface.EI(paramString);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onClick(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqcl
 * JD-Core Version:    0.7.0.1
 */