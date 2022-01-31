package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.widget.TintTypedArray;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.Window;
import android.view.Window.Callback;

@RequiresApi(14)
abstract class AppCompatDelegateImplBase
  extends AppCompatDelegate
{
  static final boolean DEBUG = false;
  static final String EXCEPTION_HANDLER_MESSAGE_SUFFIX = ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.";
  private static final boolean SHOULD_INSTALL_EXCEPTION_HANDLER;
  private static boolean sInstalledExceptionHandler;
  private static final int[] sWindowBackgroundStyleable;
  ActionBar mActionBar;
  final AppCompatCallback mAppCompatCallback;
  final Window.Callback mAppCompatWindowCallback;
  final Context mContext;
  private boolean mEatKeyUpEvent;
  boolean mHasActionBar;
  private boolean mIsDestroyed;
  boolean mIsFloating;
  private boolean mIsStarted;
  MenuInflater mMenuInflater;
  final Window.Callback mOriginalWindowCallback;
  boolean mOverlayActionBar;
  boolean mOverlayActionMode;
  private CharSequence mTitle;
  final Window mWindow;
  boolean mWindowNoTitle;
  
  static
  {
    if (Build.VERSION.SDK_INT < 21) {}
    for (boolean bool = true;; bool = false)
    {
      SHOULD_INSTALL_EXCEPTION_HANDLER = bool;
      if ((SHOULD_INSTALL_EXCEPTION_HANDLER) && (!sInstalledExceptionHandler))
      {
        Thread.setDefaultUncaughtExceptionHandler(new AppCompatDelegateImplBase.1(Thread.getDefaultUncaughtExceptionHandler()));
        sInstalledExceptionHandler = true;
      }
      sWindowBackgroundStyleable = new int[] { 16842836 };
      return;
    }
  }
  
  AppCompatDelegateImplBase(Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback)
  {
    this.mContext = paramContext;
    this.mWindow = paramWindow;
    this.mAppCompatCallback = paramAppCompatCallback;
    this.mOriginalWindowCallback = this.mWindow.getCallback();
    if ((this.mOriginalWindowCallback instanceof AppCompatDelegateImplBase.AppCompatWindowCallbackBase)) {
      throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }
    this.mAppCompatWindowCallback = wrapWindowCallback(this.mOriginalWindowCallback);
    this.mWindow.setCallback(this.mAppCompatWindowCallback);
    paramContext = TintTypedArray.obtainStyledAttributes(paramContext, null, sWindowBackgroundStyleable);
    paramWindow = paramContext.getDrawableIfKnown(0);
    if (paramWindow != null) {
      this.mWindow.setBackgroundDrawable(paramWindow);
    }
    paramContext.recycle();
  }
  
  public boolean applyDayNight()
  {
    return false;
  }
  
  abstract boolean dispatchKeyEvent(KeyEvent paramKeyEvent);
  
  final Context getActionBarThemedContext()
  {
    Context localContext = null;
    Object localObject = getSupportActionBar();
    if (localObject != null) {
      localContext = ((ActionBar)localObject).getThemedContext();
    }
    localObject = localContext;
    if (localContext == null) {
      localObject = this.mContext;
    }
    return localObject;
  }
  
  public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate()
  {
    return new AppCompatDelegateImplBase.ActionBarDrawableToggleImpl(this);
  }
  
  public MenuInflater getMenuInflater()
  {
    if (this.mMenuInflater == null)
    {
      initWindowDecorActionBar();
      if (this.mActionBar == null) {
        break label43;
      }
    }
    label43:
    for (Context localContext = this.mActionBar.getThemedContext();; localContext = this.mContext)
    {
      this.mMenuInflater = new SupportMenuInflater(localContext);
      return this.mMenuInflater;
    }
  }
  
  public ActionBar getSupportActionBar()
  {
    initWindowDecorActionBar();
    return this.mActionBar;
  }
  
  final CharSequence getTitle()
  {
    if ((this.mOriginalWindowCallback instanceof Activity)) {
      return ((Activity)this.mOriginalWindowCallback).getTitle();
    }
    return this.mTitle;
  }
  
  final Window.Callback getWindowCallback()
  {
    return this.mWindow.getCallback();
  }
  
  abstract void initWindowDecorActionBar();
  
  final boolean isDestroyed()
  {
    return this.mIsDestroyed;
  }
  
  public boolean isHandleNativeActionModesEnabled()
  {
    return false;
  }
  
  final boolean isStarted()
  {
    return this.mIsStarted;
  }
  
  public void onDestroy()
  {
    this.mIsDestroyed = true;
  }
  
  abstract boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent);
  
  abstract boolean onMenuOpened(int paramInt, Menu paramMenu);
  
  abstract void onPanelClosed(int paramInt, Menu paramMenu);
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStart()
  {
    this.mIsStarted = true;
  }
  
  public void onStop()
  {
    this.mIsStarted = false;
  }
  
  abstract void onTitleChanged(CharSequence paramCharSequence);
  
  final ActionBar peekSupportActionBar()
  {
    return this.mActionBar;
  }
  
  public void setHandleNativeActionModesEnabled(boolean paramBoolean) {}
  
  public void setLocalNightMode(int paramInt) {}
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.mTitle = paramCharSequence;
    onTitleChanged(paramCharSequence);
  }
  
  abstract ActionMode startSupportActionModeFromWindow(ActionMode.Callback paramCallback);
  
  Window.Callback wrapWindowCallback(Window.Callback paramCallback)
  {
    return new AppCompatDelegateImplBase.AppCompatWindowCallbackBase(this, paramCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplBase
 * JD-Core Version:    0.7.0.1
 */