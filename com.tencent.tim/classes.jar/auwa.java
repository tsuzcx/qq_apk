import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;

public class auwa
  implements Handler.Callback
{
  public static boolean mInPortrait;
  private static int mhasNavBar;
  private static String sNavBarOverride;
  private ColorFilter jdField_a_of_type_AndroidGraphicsColorFilter;
  private final auwa.a jdField_a_of_type_Auwa$a;
  public View aY;
  private boolean iU;
  public boolean iV;
  public Handler mHandler;
  
  static
  {
    if (VersionUtils.isKITKAT()) {}
    try
    {
      Method localMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[] { String.class });
      localMethod.setAccessible(true);
      sNavBarOverride = (String)localMethod.invoke(null, new Object[] { "qemu.hw.mainkeys" });
      mhasNavBar = -1;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        sNavBarOverride = null;
      }
    }
  }
  
  @TargetApi(19)
  public auwa(Window paramWindow, boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)paramWindow.getDecorView();
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.iU = paramBoolean;
    }
    this.jdField_a_of_type_Auwa$a = new auwa.a(paramWindow, this.iU, null);
    if (this.iU) {
      a(paramWindow, localViewGroup);
    }
    this.mHandler = new Handler(Looper.getMainLooper(), this);
    if (paramWindow.getContext().getResources().getConfiguration().orientation == 1) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      mInPortrait = paramBoolean;
      return;
    }
  }
  
  private void a(Window paramWindow, ViewGroup paramViewGroup)
  {
    this.aY = new View(paramWindow.getContext());
    paramWindow = new FrameLayout.LayoutParams(-1, this.jdField_a_of_type_Auwa$a.getStatusBarHeight());
    paramWindow.gravity = 48;
    this.aY.setLayoutParams(paramWindow);
    try
    {
      IphoneTitleBarActivity.setLayerType(this.aY);
      this.aY.setVisibility(8);
      paramViewGroup.addView(this.aY);
      return;
    }
    catch (Exception paramWindow)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("setupStatusBarView", 2, paramWindow.toString());
        }
      }
    }
  }
  
  private static int getInternalDimensionSize(Resources paramResources, String paramString)
  {
    int i = 0;
    int j = paramResources.getIdentifier(paramString, "dimen", "android");
    if (j > 0) {
      i = paramResources.getDimensionPixelSize(j);
    }
    return i;
  }
  
  @TargetApi(14)
  public static int getNavigationBarHeight(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    int i = 0;
    if (Build.VERSION.SDK_INT >= 14) {
      if (!mInPortrait) {
        break label32;
      }
    }
    label32:
    for (paramContext = "navigation_bar_height";; paramContext = "navigation_bar_height_landscape")
    {
      i = getInternalDimensionSize(localResources, paramContext);
      return i;
    }
  }
  
  @TargetApi(14)
  public static boolean hasNavBar(Context paramContext)
  {
    if (mhasNavBar != -1) {
      return mhasNavBar == 1;
    }
    Resources localResources = paramContext.getResources();
    int i = localResources.getIdentifier("config_showNavigationBar", "bool", "android");
    boolean bool;
    if (i != 0)
    {
      bool = localResources.getBoolean(i);
      if ("1".equals(sNavBarOverride)) {
        bool = false;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("XPanelContainer", 2, "hasNavbar=" + bool);
      }
      if (bool) {}
      for (mhasNavBar = 1;; mhasNavBar = 0)
      {
        return bool;
        if (!"0".equals(sNavBarOverride)) {
          break;
        }
        bool = true;
        break;
        if (Build.VERSION.SDK_INT < 14) {
          break label149;
        }
        if (!ViewConfiguration.get(paramContext).hasPermanentMenuKey())
        {
          bool = true;
          break;
        }
        bool = false;
        break;
      }
      label149:
      bool = false;
    }
  }
  
  public void bo(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SystemBarTintManager", 2, "setStatusBarTintEnabled enabled = " + paramBoolean);
    }
    this.iV = paramBoolean;
    View localView;
    if (this.iU)
    {
      localView = this.aY;
      if (!paramBoolean) {
        break label62;
      }
    }
    label62:
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void cG(int paramInt)
  {
    if (this.iU)
    {
      this.aY.setBackgroundColor(paramInt);
      if (this.aY.getBackground() != null) {
        this.aY.getBackground().setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
      }
    }
  }
  
  public void e(Drawable paramDrawable)
  {
    if (this.iU)
    {
      if (paramDrawable != null) {
        paramDrawable.setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
      }
      this.aY.setBackgroundDrawable(paramDrawable);
    }
  }
  
  public void e(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("status", 2, "setStatusBarVisible=" + paramBoolean);
    }
    this.iV = paramBoolean;
    if (paramBoolean)
    {
      this.mHandler.sendEmptyMessageDelayed(0, paramInt);
      return;
    }
    this.mHandler.sendEmptyMessageDelayed(1, paramInt);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("status", 2, "SystemBarTintManager=" + paramMessage.what);
    }
    if (this.aY == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      this.aY.setVisibility(0);
      return false;
    case 1: 
      this.aY.setVisibility(4);
      return false;
    }
    this.aY.setVisibility(8);
    return false;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsColorFilter = paramColorFilter;
    Drawable localDrawable = this.aY.getBackground();
    if (localDrawable != null)
    {
      localDrawable.setColorFilter(paramColorFilter);
      localDrawable.invalidateSelf();
    }
  }
  
  public void setStatusBarVisible(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("status", 2, "setStatusBarVisible=" + paramInt1);
    }
    if (paramInt1 == 0) {}
    for (this.iV = true;; this.iV = false)
    {
      this.mHandler.sendEmptyMessageDelayed(paramInt1, paramInt2);
      return;
    }
  }
  
  public static class a
  {
    private final boolean iW;
    private final boolean mInPortrait;
    private final int mStatusBarHeight;
    
    private a(Window paramWindow, boolean paramBoolean)
    {
      if (paramWindow.getContext().getResources().getConfiguration().orientation == 1) {}
      for (;;)
      {
        this.mInPortrait = bool;
        this.mStatusBarHeight = ImmersiveUtils.getStatusBarHeight(paramWindow.getContext());
        this.iW = paramBoolean;
        return;
        bool = false;
      }
    }
    
    public int getStatusBarHeight()
    {
      return this.mStatusBarHeight;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     auwa
 * JD-Core Version:    0.7.0.1
 */