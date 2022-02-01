package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.StandaloneActionMode;
import androidx.appcompat.view.SupportActionModeWrapper.CallbackWrapper;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder.Callback;
import androidx.appcompat.view.menu.MenuPresenter.Callback;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.FitWindowsViewGroup;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.ViewUtils;
import androidx.collection.ArrayMap;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.KeyEventDispatcher.Component;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.widget.PopupWindowCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleOwner;
import b.a;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
class AppCompatDelegateImpl
  extends AppCompatDelegate
  implements LayoutInflater.Factory2, MenuBuilder.Callback
{
  private static final boolean DEBUG = false;
  static final String EXCEPTION_HANDLER_MESSAGE_SUFFIX = ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.";
  private static final boolean IS_PRE_LOLLIPOP;
  private static final boolean sAlwaysOverrideConfiguration;
  private static boolean sInstalledExceptionHandler;
  private static final Map<Class<?>, Integer> sLocalNightModes;
  private static final int[] sWindowBackgroundStyleable;
  ActionBar mActionBar;
  private ActionMenuPresenterCallback mActionMenuPresenterCallback;
  androidx.appcompat.view.ActionMode mActionMode;
  PopupWindow mActionModePopup;
  ActionBarContextView mActionModeView;
  private boolean mActivityHandlesUiMode;
  private boolean mActivityHandlesUiModeChecked;
  final AppCompatCallback mAppCompatCallback;
  private AppCompatViewInflater mAppCompatViewInflater;
  private AppCompatWindowCallback mAppCompatWindowCallback;
  private AutoNightModeManager mAutoBatteryNightModeManager;
  private AutoNightModeManager mAutoTimeNightModeManager;
  private boolean mBaseContextAttached;
  private boolean mClosingActionMenu;
  final Context mContext;
  private boolean mCreated;
  private DecorContentParent mDecorContentParent;
  private boolean mEnableDefaultActionBarUp;
  ViewPropertyAnimatorCompat mFadeAnim = null;
  private boolean mFeatureIndeterminateProgress;
  private boolean mFeatureProgress;
  private boolean mHandleNativeActionModes = true;
  boolean mHasActionBar;
  final Object mHost;
  int mInvalidatePanelMenuFeatures;
  boolean mInvalidatePanelMenuPosted;
  private final Runnable mInvalidatePanelMenuRunnable = new AppCompatDelegateImpl.2(this);
  boolean mIsDestroyed;
  boolean mIsFloating;
  private int mLocalNightMode = -100;
  private boolean mLongPressBackDown;
  MenuInflater mMenuInflater;
  boolean mOverlayActionBar;
  boolean mOverlayActionMode;
  private PanelMenuPresenterCallback mPanelMenuPresenterCallback;
  private PanelFeatureState[] mPanels;
  private PanelFeatureState mPreparedPanel;
  Runnable mShowActionModePopup;
  private boolean mStarted;
  private View mStatusGuard;
  private ViewGroup mSubDecor;
  private boolean mSubDecorInstalled;
  private Rect mTempRect1;
  private Rect mTempRect2;
  private int mThemeResId;
  private CharSequence mTitle;
  private TextView mTitleView;
  Window mWindow;
  boolean mWindowNoTitle;
  
  static
  {
    boolean bool2 = false;
    sLocalNightModes = new ArrayMap();
    if (Build.VERSION.SDK_INT < 21) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      IS_PRE_LOLLIPOP = bool1;
      sWindowBackgroundStyleable = new int[] { 16842836 };
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 21)
      {
        bool1 = bool2;
        if (Build.VERSION.SDK_INT <= 25) {
          bool1 = true;
        }
      }
      sAlwaysOverrideConfiguration = bool1;
      if ((IS_PRE_LOLLIPOP) && (!sInstalledExceptionHandler))
      {
        Thread.setDefaultUncaughtExceptionHandler(new AppCompatDelegateImpl.1(Thread.getDefaultUncaughtExceptionHandler()));
        sInstalledExceptionHandler = true;
      }
      return;
    }
  }
  
  AppCompatDelegateImpl(Activity paramActivity, AppCompatCallback paramAppCompatCallback)
  {
    this(paramActivity, null, paramAppCompatCallback, paramActivity);
  }
  
  AppCompatDelegateImpl(Dialog paramDialog, AppCompatCallback paramAppCompatCallback)
  {
    this(paramDialog.getContext(), paramDialog.getWindow(), paramAppCompatCallback, paramDialog);
  }
  
  AppCompatDelegateImpl(Context paramContext, Activity paramActivity, AppCompatCallback paramAppCompatCallback)
  {
    this(paramContext, null, paramAppCompatCallback, paramActivity);
  }
  
  AppCompatDelegateImpl(Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback)
  {
    this(paramContext, paramWindow, paramAppCompatCallback, paramContext);
  }
  
  private AppCompatDelegateImpl(Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback, Object paramObject)
  {
    this.mContext = paramContext;
    this.mAppCompatCallback = paramAppCompatCallback;
    this.mHost = paramObject;
    if ((this.mLocalNightMode == -100) && ((this.mHost instanceof Dialog)))
    {
      paramContext = tryUnwrapContext();
      if (paramContext != null) {
        this.mLocalNightMode = paramContext.getDelegate().getLocalNightMode();
      }
    }
    if (this.mLocalNightMode == -100)
    {
      paramContext = (Integer)sLocalNightModes.get(this.mHost.getClass());
      if (paramContext != null)
      {
        this.mLocalNightMode = paramContext.intValue();
        sLocalNightModes.remove(this.mHost.getClass());
      }
    }
    if (paramWindow != null) {
      attachToWindow(paramWindow);
    }
    AppCompatDrawableManager.preload();
  }
  
  private boolean applyDayNight(boolean paramBoolean)
  {
    if (this.mIsDestroyed) {
      paramBoolean = false;
    }
    boolean bool;
    do
    {
      return paramBoolean;
      int i = calculateNightMode();
      bool = updateForNightMode(mapNightMode(i), paramBoolean);
      if (i == 0) {
        getAutoTimeNightModeManager().setup();
      }
      while (i == 3)
      {
        getAutoBatteryNightModeManager().setup();
        return bool;
        if (this.mAutoTimeNightModeManager != null) {
          this.mAutoTimeNightModeManager.cleanup();
        }
      }
      paramBoolean = bool;
    } while (this.mAutoBatteryNightModeManager == null);
    this.mAutoBatteryNightModeManager.cleanup();
    return bool;
  }
  
  private void applyFixedSizeWindow()
  {
    ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)this.mSubDecor.findViewById(16908290);
    Object localObject = this.mWindow.getDecorView();
    localContentFrameLayout.setDecorPadding(((View)localObject).getPaddingLeft(), ((View)localObject).getPaddingTop(), ((View)localObject).getPaddingRight(), ((View)localObject).getPaddingBottom());
    localObject = this.mContext.obtainStyledAttributes(b.a.AppCompatTheme);
    ((TypedArray)localObject).getValue(b.a.AppCompatTheme_windowMinWidthMajor, localContentFrameLayout.getMinWidthMajor());
    ((TypedArray)localObject).getValue(b.a.AppCompatTheme_windowMinWidthMinor, localContentFrameLayout.getMinWidthMinor());
    if (((TypedArray)localObject).hasValue(b.a.AppCompatTheme_windowFixedWidthMajor)) {
      ((TypedArray)localObject).getValue(b.a.AppCompatTheme_windowFixedWidthMajor, localContentFrameLayout.getFixedWidthMajor());
    }
    if (((TypedArray)localObject).hasValue(b.a.AppCompatTheme_windowFixedWidthMinor)) {
      ((TypedArray)localObject).getValue(b.a.AppCompatTheme_windowFixedWidthMinor, localContentFrameLayout.getFixedWidthMinor());
    }
    if (((TypedArray)localObject).hasValue(b.a.AppCompatTheme_windowFixedHeightMajor)) {
      ((TypedArray)localObject).getValue(b.a.AppCompatTheme_windowFixedHeightMajor, localContentFrameLayout.getFixedHeightMajor());
    }
    if (((TypedArray)localObject).hasValue(b.a.AppCompatTheme_windowFixedHeightMinor)) {
      ((TypedArray)localObject).getValue(b.a.AppCompatTheme_windowFixedHeightMinor, localContentFrameLayout.getFixedHeightMinor());
    }
    ((TypedArray)localObject).recycle();
    localContentFrameLayout.requestLayout();
  }
  
  private void attachToWindow(@NonNull Window paramWindow)
  {
    if (this.mWindow != null) {
      throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }
    Object localObject = paramWindow.getCallback();
    if ((localObject instanceof AppCompatWindowCallback)) {
      throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }
    this.mAppCompatWindowCallback = new AppCompatWindowCallback((Window.Callback)localObject);
    paramWindow.setCallback(this.mAppCompatWindowCallback);
    localObject = TintTypedArray.obtainStyledAttributes(this.mContext, null, sWindowBackgroundStyleable);
    Drawable localDrawable = ((TintTypedArray)localObject).getDrawableIfKnown(0);
    if (localDrawable != null) {
      paramWindow.setBackgroundDrawable(localDrawable);
    }
    ((TintTypedArray)localObject).recycle();
    this.mWindow = paramWindow;
  }
  
  private int calculateNightMode()
  {
    if (this.mLocalNightMode != -100) {
      return this.mLocalNightMode;
    }
    return getDefaultNightMode();
  }
  
  private void cleanupAutoManagers()
  {
    if (this.mAutoTimeNightModeManager != null) {
      this.mAutoTimeNightModeManager.cleanup();
    }
    if (this.mAutoBatteryNightModeManager != null) {
      this.mAutoBatteryNightModeManager.cleanup();
    }
  }
  
  private ViewGroup createSubDecor()
  {
    Object localObject = this.mContext.obtainStyledAttributes(b.a.AppCompatTheme);
    if (!((TypedArray)localObject).hasValue(b.a.AppCompatTheme_windowActionBar))
    {
      ((TypedArray)localObject).recycle();
      throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }
    if (((TypedArray)localObject).getBoolean(b.a.AppCompatTheme_windowNoTitle, false))
    {
      requestWindowFeature(1);
      if (((TypedArray)localObject).getBoolean(b.a.AppCompatTheme_windowActionBarOverlay, false)) {
        requestWindowFeature(109);
      }
      if (((TypedArray)localObject).getBoolean(b.a.AppCompatTheme_windowActionModeOverlay, false)) {
        requestWindowFeature(10);
      }
      this.mIsFloating = ((TypedArray)localObject).getBoolean(b.a.AppCompatTheme_android_windowIsFloating, false);
      ((TypedArray)localObject).recycle();
      ensureWindow();
      this.mWindow.getDecorView();
      localObject = LayoutInflater.from(this.mContext);
      if (this.mWindowNoTitle) {
        break label434;
      }
      if (!this.mIsFloating) {
        break label275;
      }
      localObject = (ViewGroup)((LayoutInflater)localObject).inflate(2131558412, null);
      this.mOverlayActionBar = false;
      this.mHasActionBar = false;
    }
    for (;;)
    {
      if (localObject == null)
      {
        throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.mHasActionBar + ", windowActionBarOverlay: " + this.mOverlayActionBar + ", android:windowIsFloating: " + this.mIsFloating + ", windowActionModeOverlay: " + this.mOverlayActionMode + ", windowNoTitle: " + this.mWindowNoTitle + " }");
        if (!((TypedArray)localObject).getBoolean(b.a.AppCompatTheme_windowActionBar, false)) {
          break;
        }
        requestWindowFeature(108);
        break;
        label275:
        if (!this.mHasActionBar) {
          break label642;
        }
        localObject = new TypedValue();
        this.mContext.getTheme().resolveAttribute(2131034127, (TypedValue)localObject, true);
        if (((TypedValue)localObject).resourceId != 0) {}
        for (localObject = new androidx.appcompat.view.ContextThemeWrapper(this.mContext, ((TypedValue)localObject).resourceId);; localObject = this.mContext)
        {
          localObject = (ViewGroup)LayoutInflater.from((Context)localObject).inflate(2131558423, null);
          this.mDecorContentParent = ((DecorContentParent)((ViewGroup)localObject).findViewById(2131365659));
          this.mDecorContentParent.setWindowCallback(getWindowCallback());
          if (this.mOverlayActionBar) {
            this.mDecorContentParent.initFeature(109);
          }
          if (this.mFeatureProgress) {
            this.mDecorContentParent.initFeature(2);
          }
          if (this.mFeatureIndeterminateProgress) {
            this.mDecorContentParent.initFeature(5);
          }
          break;
        }
        label434:
        if (this.mOverlayActionMode) {}
        for (localObject = (ViewGroup)((LayoutInflater)localObject).inflate(2131558422, null);; localObject = (ViewGroup)((LayoutInflater)localObject).inflate(2131558421, null))
        {
          if (Build.VERSION.SDK_INT < 21) {
            break label491;
          }
          ViewCompat.setOnApplyWindowInsetsListener((View)localObject, new AppCompatDelegateImpl.3(this));
          break;
        }
        label491:
        ((FitWindowsViewGroup)localObject).setOnFitSystemWindowsListener(new AppCompatDelegateImpl.4(this));
        continue;
      }
      if (this.mDecorContentParent == null) {
        this.mTitleView = ((TextView)((ViewGroup)localObject).findViewById(2131379769));
      }
      ViewUtils.makeOptionalFitsSystemWindows((View)localObject);
      ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)((ViewGroup)localObject).findViewById(2131361969);
      ViewGroup localViewGroup = (ViewGroup)this.mWindow.findViewById(16908290);
      if (localViewGroup != null)
      {
        while (localViewGroup.getChildCount() > 0)
        {
          View localView = localViewGroup.getChildAt(0);
          localViewGroup.removeViewAt(0);
          localContentFrameLayout.addView(localView);
        }
        localViewGroup.setId(-1);
        localContentFrameLayout.setId(16908290);
        if ((localViewGroup instanceof FrameLayout)) {
          ((FrameLayout)localViewGroup).setForeground(null);
        }
      }
      this.mWindow.setContentView((View)localObject);
      localContentFrameLayout.setAttachListener(new AppCompatDelegateImpl.5(this));
      return localObject;
      label642:
      localObject = null;
    }
  }
  
  private void ensureSubDecor()
  {
    Object localObject;
    if (!this.mSubDecorInstalled)
    {
      this.mSubDecor = createSubDecor();
      localObject = getTitle();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (this.mDecorContentParent == null) {
          break label93;
        }
        this.mDecorContentParent.setWindowTitle((CharSequence)localObject);
      }
    }
    for (;;)
    {
      applyFixedSizeWindow();
      onSubDecorInstalled(this.mSubDecor);
      this.mSubDecorInstalled = true;
      localObject = getPanelState(0, false);
      if ((!this.mIsDestroyed) && ((localObject == null) || (((PanelFeatureState)localObject).menu == null))) {
        invalidatePanelMenu(108);
      }
      return;
      label93:
      if (peekSupportActionBar() != null) {
        peekSupportActionBar().setWindowTitle((CharSequence)localObject);
      } else if (this.mTitleView != null) {
        this.mTitleView.setText((CharSequence)localObject);
      }
    }
  }
  
  private void ensureWindow()
  {
    if ((this.mWindow == null) && ((this.mHost instanceof Activity))) {
      attachToWindow(((Activity)this.mHost).getWindow());
    }
    if (this.mWindow == null) {
      throw new IllegalStateException("We have not been given a Window");
    }
  }
  
  private AutoNightModeManager getAutoBatteryNightModeManager()
  {
    if (this.mAutoBatteryNightModeManager == null) {
      this.mAutoBatteryNightModeManager = new AutoBatteryNightModeManager(this.mContext);
    }
    return this.mAutoBatteryNightModeManager;
  }
  
  private void initWindowDecorActionBar()
  {
    ensureSubDecor();
    if ((!this.mHasActionBar) || (this.mActionBar != null)) {}
    for (;;)
    {
      return;
      if ((this.mHost instanceof Activity)) {
        this.mActionBar = new WindowDecorActionBar((Activity)this.mHost, this.mOverlayActionBar);
      }
      while (this.mActionBar != null)
      {
        this.mActionBar.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
        return;
        if ((this.mHost instanceof Dialog)) {
          this.mActionBar = new WindowDecorActionBar((Dialog)this.mHost);
        }
      }
    }
  }
  
  private boolean initializePanelContent(PanelFeatureState paramPanelFeatureState)
  {
    if (paramPanelFeatureState.createdPanelView != null)
    {
      paramPanelFeatureState.shownPanelView = paramPanelFeatureState.createdPanelView;
      return true;
    }
    if (paramPanelFeatureState.menu == null) {
      return false;
    }
    if (this.mPanelMenuPresenterCallback == null) {
      this.mPanelMenuPresenterCallback = new PanelMenuPresenterCallback();
    }
    paramPanelFeatureState.shownPanelView = ((View)paramPanelFeatureState.getListMenuView(this.mPanelMenuPresenterCallback));
    if (paramPanelFeatureState.shownPanelView != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean initializePanelDecor(PanelFeatureState paramPanelFeatureState)
  {
    paramPanelFeatureState.setStyle(getActionBarThemedContext());
    paramPanelFeatureState.decorView = new ListMenuDecorView(paramPanelFeatureState.listPresenterContext);
    paramPanelFeatureState.gravity = 81;
    return true;
  }
  
  private boolean initializePanelMenu(PanelFeatureState paramPanelFeatureState)
  {
    Context localContext = this.mContext;
    TypedValue localTypedValue;
    Resources.Theme localTheme;
    Object localObject1;
    if (((paramPanelFeatureState.featureId == 0) || (paramPanelFeatureState.featureId == 108)) && (this.mDecorContentParent != null))
    {
      localTypedValue = new TypedValue();
      localTheme = localContext.getTheme();
      localTheme.resolveAttribute(2131034127, localTypedValue, true);
      localObject1 = null;
      if (localTypedValue.resourceId != 0)
      {
        localObject1 = localContext.getResources().newTheme();
        ((Resources.Theme)localObject1).setTo(localTheme);
        ((Resources.Theme)localObject1).applyStyle(localTypedValue.resourceId, true);
        ((Resources.Theme)localObject1).resolveAttribute(2131034128, localTypedValue, true);
        Object localObject2 = localObject1;
        if (localTypedValue.resourceId != 0)
        {
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = localContext.getResources().newTheme();
            ((Resources.Theme)localObject2).setTo(localTheme);
          }
          ((Resources.Theme)localObject2).applyStyle(localTypedValue.resourceId, true);
        }
        if (localObject2 == null) {
          break label203;
        }
        localObject1 = new androidx.appcompat.view.ContextThemeWrapper(localContext, 0);
        ((Context)localObject1).getTheme().setTo((Resources.Theme)localObject2);
      }
    }
    for (;;)
    {
      localObject1 = new MenuBuilder((Context)localObject1);
      ((MenuBuilder)localObject1).setCallback(this);
      paramPanelFeatureState.setMenu((MenuBuilder)localObject1);
      return true;
      localTheme.resolveAttribute(2131034128, localTypedValue, true);
      break;
      label203:
      localObject1 = localContext;
    }
  }
  
  private void invalidatePanelMenu(int paramInt)
  {
    this.mInvalidatePanelMenuFeatures |= 1 << paramInt;
    if (!this.mInvalidatePanelMenuPosted)
    {
      ViewCompat.postOnAnimation(this.mWindow.getDecorView(), this.mInvalidatePanelMenuRunnable);
      this.mInvalidatePanelMenuPosted = true;
    }
  }
  
  private boolean isActivityManifestHandlingUiMode()
  {
    Object localObject;
    if ((!this.mActivityHandlesUiModeChecked) && ((this.mHost instanceof Activity)))
    {
      localObject = this.mContext.getPackageManager();
      if (localObject == null) {
        return false;
      }
    }
    for (;;)
    {
      try
      {
        localObject = ((PackageManager)localObject).getActivityInfo(new ComponentName(this.mContext, this.mHost.getClass()), 0);
        if ((localObject == null) || ((((ActivityInfo)localObject).configChanges & 0x200) == 0)) {
          continue;
        }
        bool = true;
        this.mActivityHandlesUiMode = bool;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        boolean bool;
        Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", localNameNotFoundException);
        this.mActivityHandlesUiMode = false;
        continue;
      }
      this.mActivityHandlesUiModeChecked = true;
      return this.mActivityHandlesUiMode;
      bool = false;
    }
  }
  
  private boolean onKeyDownPanel(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getRepeatCount() == 0)
    {
      PanelFeatureState localPanelFeatureState = getPanelState(paramInt, true);
      if (!localPanelFeatureState.isOpen) {
        return preparePanel(localPanelFeatureState, paramKeyEvent);
      }
    }
    return false;
  }
  
  private boolean onKeyUpPanel(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = true;
    if (this.mActionMode != null) {
      return false;
    }
    PanelFeatureState localPanelFeatureState = getPanelState(paramInt, true);
    if ((paramInt == 0) && (this.mDecorContentParent != null) && (this.mDecorContentParent.canShowOverflowMenu()) && (!ViewConfiguration.get(this.mContext).hasPermanentMenuKey())) {
      if (!this.mDecorContentParent.isOverflowMenuShowing())
      {
        if ((this.mIsDestroyed) || (!preparePanel(localPanelFeatureState, paramKeyEvent))) {
          break label229;
        }
        bool1 = this.mDecorContentParent.showOverflowMenu();
      }
    }
    for (;;)
    {
      if (bool1)
      {
        paramKeyEvent = (AudioManager)this.mContext.getSystemService("audio");
        if (paramKeyEvent == null) {
          break label216;
        }
        paramKeyEvent.playSoundEffect(0);
      }
      label122:
      return bool1;
      bool1 = this.mDecorContentParent.hideOverflowMenu();
      continue;
      if ((!localPanelFeatureState.isOpen) && (!localPanelFeatureState.isHandled)) {
        break;
      }
      bool1 = localPanelFeatureState.isOpen;
      closePanel(localPanelFeatureState, true);
    }
    if (localPanelFeatureState.isPrepared)
    {
      if (!localPanelFeatureState.refreshMenuContent) {
        break label234;
      }
      localPanelFeatureState.isPrepared = false;
    }
    label216:
    label229:
    label234:
    for (boolean bool1 = preparePanel(localPanelFeatureState, paramKeyEvent);; bool1 = true)
    {
      if (bool1)
      {
        openPanel(localPanelFeatureState, paramKeyEvent);
        bool1 = bool2;
        break;
        Log.w("AppCompatDelegate", "Couldn't get audio manager");
        break label122;
      }
      bool1 = false;
      break;
    }
  }
  
  private void openPanel(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    int j = -1;
    if ((paramPanelFeatureState.isOpen) || (this.mIsDestroyed)) {}
    int i;
    Object localObject;
    label87:
    label92:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (paramPanelFeatureState.featureId == 0) {
            if ((this.mContext.getResources().getConfiguration().screenLayout & 0xF) != 4) {
              break label87;
            }
          }
          for (i = 1; i == 0; i = 0)
          {
            localObject = getWindowCallback();
            if ((localObject == null) || (((Window.Callback)localObject).onMenuOpened(paramPanelFeatureState.featureId, paramPanelFeatureState.menu))) {
              break label92;
            }
            closePanel(paramPanelFeatureState, true);
            return;
          }
        }
        localObject = (WindowManager)this.mContext.getSystemService("window");
      } while ((localObject == null) || (!preparePanel(paramPanelFeatureState, paramKeyEvent)));
      if ((paramPanelFeatureState.decorView != null) && (!paramPanelFeatureState.refreshDecorView)) {
        break label364;
      }
      if (paramPanelFeatureState.decorView != null) {
        break;
      }
    } while ((!initializePanelDecor(paramPanelFeatureState)) || (paramPanelFeatureState.decorView == null));
    label157:
    if ((initializePanelContent(paramPanelFeatureState)) && (paramPanelFeatureState.hasPanelItems()))
    {
      paramKeyEvent = paramPanelFeatureState.shownPanelView.getLayoutParams();
      if (paramKeyEvent != null) {
        break label400;
      }
      paramKeyEvent = new ViewGroup.LayoutParams(-2, -2);
    }
    label400:
    for (;;)
    {
      i = paramPanelFeatureState.background;
      paramPanelFeatureState.decorView.setBackgroundResource(i);
      ViewParent localViewParent = paramPanelFeatureState.shownPanelView.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(paramPanelFeatureState.shownPanelView);
      }
      paramPanelFeatureState.decorView.addView(paramPanelFeatureState.shownPanelView, paramKeyEvent);
      if (!paramPanelFeatureState.shownPanelView.hasFocus()) {
        paramPanelFeatureState.shownPanelView.requestFocus();
      }
      i = -2;
      for (;;)
      {
        paramPanelFeatureState.isHandled = false;
        paramKeyEvent = new WindowManager.LayoutParams(i, -2, paramPanelFeatureState.x, paramPanelFeatureState.y, 1002, 8519680, -3);
        paramKeyEvent.gravity = paramPanelFeatureState.gravity;
        paramKeyEvent.windowAnimations = paramPanelFeatureState.windowAnimations;
        ((WindowManager)localObject).addView(paramPanelFeatureState.decorView, paramKeyEvent);
        paramPanelFeatureState.isOpen = true;
        return;
        if ((!paramPanelFeatureState.refreshDecorView) || (paramPanelFeatureState.decorView.getChildCount() <= 0)) {
          break label157;
        }
        paramPanelFeatureState.decorView.removeAllViews();
        break label157;
        break;
        label364:
        if (paramPanelFeatureState.createdPanelView != null)
        {
          paramKeyEvent = paramPanelFeatureState.createdPanelView.getLayoutParams();
          if (paramKeyEvent != null)
          {
            i = j;
            if (paramKeyEvent.width == -1) {
              continue;
            }
          }
        }
        i = -2;
      }
    }
  }
  
  private boolean performPanelShortcut(PanelFeatureState paramPanelFeatureState, int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramKeyEvent.isSystem()) {
      bool2 = bool1;
    }
    do
    {
      do
      {
        do
        {
          return bool2;
          if (!paramPanelFeatureState.isPrepared)
          {
            bool1 = bool2;
            if (!preparePanel(paramPanelFeatureState, paramKeyEvent)) {}
          }
          else
          {
            bool1 = bool2;
            if (paramPanelFeatureState.menu != null) {
              bool1 = paramPanelFeatureState.menu.performShortcut(paramInt1, paramKeyEvent, paramInt2);
            }
          }
          bool2 = bool1;
        } while (!bool1);
        bool2 = bool1;
      } while ((paramInt2 & 0x1) != 0);
      bool2 = bool1;
    } while (this.mDecorContentParent != null);
    closePanel(paramPanelFeatureState, true);
    return bool1;
  }
  
  private boolean preparePanel(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    if (this.mIsDestroyed) {
      return false;
    }
    if (paramPanelFeatureState.isPrepared) {
      return true;
    }
    if ((this.mPreparedPanel != null) && (this.mPreparedPanel != paramPanelFeatureState)) {
      closePanel(this.mPreparedPanel, false);
    }
    Window.Callback localCallback = getWindowCallback();
    if (localCallback != null) {
      paramPanelFeatureState.createdPanelView = localCallback.onCreatePanelView(paramPanelFeatureState.featureId);
    }
    if ((paramPanelFeatureState.featureId == 0) || (paramPanelFeatureState.featureId == 108)) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.mDecorContentParent != null)) {
        this.mDecorContentParent.setMenuPrepared();
      }
      if ((paramPanelFeatureState.createdPanelView != null) || ((i != 0) && ((peekSupportActionBar() instanceof ToolbarActionBar)))) {
        break label407;
      }
      if ((paramPanelFeatureState.menu != null) && (!paramPanelFeatureState.refreshMenuContent)) {
        break label277;
      }
      if ((paramPanelFeatureState.menu == null) && ((!initializePanelMenu(paramPanelFeatureState)) || (paramPanelFeatureState.menu == null))) {
        break;
      }
      if ((i != 0) && (this.mDecorContentParent != null))
      {
        if (this.mActionMenuPresenterCallback == null) {
          this.mActionMenuPresenterCallback = new ActionMenuPresenterCallback();
        }
        this.mDecorContentParent.setMenu(paramPanelFeatureState.menu, this.mActionMenuPresenterCallback);
      }
      paramPanelFeatureState.menu.stopDispatchingItemsChanged();
      if (localCallback.onCreatePanelMenu(paramPanelFeatureState.featureId, paramPanelFeatureState.menu)) {
        break label272;
      }
      paramPanelFeatureState.setMenu(null);
      if ((i == 0) || (this.mDecorContentParent == null)) {
        break;
      }
      this.mDecorContentParent.setMenu(null, this.mActionMenuPresenterCallback);
      return false;
    }
    label272:
    paramPanelFeatureState.refreshMenuContent = false;
    label277:
    paramPanelFeatureState.menu.stopDispatchingItemsChanged();
    if (paramPanelFeatureState.frozenActionViewState != null)
    {
      paramPanelFeatureState.menu.restoreActionViewStates(paramPanelFeatureState.frozenActionViewState);
      paramPanelFeatureState.frozenActionViewState = null;
    }
    if (!localCallback.onPreparePanel(0, paramPanelFeatureState.createdPanelView, paramPanelFeatureState.menu))
    {
      if ((i != 0) && (this.mDecorContentParent != null)) {
        this.mDecorContentParent.setMenu(null, this.mActionMenuPresenterCallback);
      }
      paramPanelFeatureState.menu.startDispatchingItemsChanged();
      return false;
    }
    if (paramKeyEvent != null)
    {
      i = paramKeyEvent.getDeviceId();
      if (KeyCharacterMap.load(i).getKeyboardType() == 1) {
        break label429;
      }
    }
    label407:
    label429:
    for (boolean bool = true;; bool = false)
    {
      paramPanelFeatureState.qwertyMode = bool;
      paramPanelFeatureState.menu.setQwertyMode(paramPanelFeatureState.qwertyMode);
      paramPanelFeatureState.menu.startDispatchingItemsChanged();
      paramPanelFeatureState.isPrepared = true;
      paramPanelFeatureState.isHandled = false;
      this.mPreparedPanel = paramPanelFeatureState;
      return true;
      i = -1;
      break;
    }
  }
  
  private void reopenMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if ((this.mDecorContentParent != null) && (this.mDecorContentParent.canShowOverflowMenu()) && ((!ViewConfiguration.get(this.mContext).hasPermanentMenuKey()) || (this.mDecorContentParent.isOverflowMenuShowPending())))
    {
      paramMenuBuilder = getWindowCallback();
      if ((!this.mDecorContentParent.isOverflowMenuShowing()) || (!paramBoolean)) {
        if ((paramMenuBuilder != null) && (!this.mIsDestroyed))
        {
          if ((this.mInvalidatePanelMenuPosted) && ((this.mInvalidatePanelMenuFeatures & 0x1) != 0))
          {
            this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
            this.mInvalidatePanelMenuRunnable.run();
          }
          PanelFeatureState localPanelFeatureState = getPanelState(0, true);
          if ((localPanelFeatureState.menu != null) && (!localPanelFeatureState.refreshMenuContent) && (paramMenuBuilder.onPreparePanel(0, localPanelFeatureState.createdPanelView, localPanelFeatureState.menu)))
          {
            paramMenuBuilder.onMenuOpened(108, localPanelFeatureState.menu);
            this.mDecorContentParent.showOverflowMenu();
          }
        }
      }
      do
      {
        return;
        this.mDecorContentParent.hideOverflowMenu();
      } while (this.mIsDestroyed);
      paramMenuBuilder.onPanelClosed(108, getPanelState(0, true).menu);
      return;
    }
    paramMenuBuilder = getPanelState(0, true);
    paramMenuBuilder.refreshDecorView = true;
    closePanel(paramMenuBuilder, false);
    openPanel(paramMenuBuilder, null);
  }
  
  private int sanitizeWindowFeatureId(int paramInt)
  {
    int i;
    if (paramInt == 8)
    {
      Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
      i = 108;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt != 9);
    Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
    return 109;
  }
  
  private boolean shouldInheritContext(ViewParent paramViewParent)
  {
    if (paramViewParent == null) {
      return false;
    }
    View localView = this.mWindow.getDecorView();
    for (;;)
    {
      if (paramViewParent == null) {
        return true;
      }
      if ((paramViewParent == localView) || (!(paramViewParent instanceof View)) || (ViewCompat.isAttachedToWindow((View)paramViewParent))) {
        return false;
      }
      paramViewParent = paramViewParent.getParent();
    }
  }
  
  private void throwFeatureRequestIfSubDecorInstalled()
  {
    if (this.mSubDecorInstalled) {
      throw new AndroidRuntimeException("Window feature must be requested before adding content");
    }
  }
  
  @Nullable
  private AppCompatActivity tryUnwrapContext()
  {
    Context localContext = this.mContext;
    while (localContext != null)
    {
      if ((localContext instanceof AppCompatActivity)) {
        return (AppCompatActivity)localContext;
      }
      if ((localContext instanceof ContextWrapper)) {
        localContext = ((ContextWrapper)localContext).getBaseContext();
      } else {
        return null;
      }
    }
    return null;
  }
  
  private boolean updateForNightMode(int paramInt, boolean paramBoolean)
  {
    boolean bool3 = true;
    int j = this.mContext.getApplicationContext().getResources().getConfiguration().uiMode & 0x30;
    int i;
    boolean bool4;
    Configuration localConfiguration;
    switch (paramInt)
    {
    default: 
      i = j;
      bool4 = isActivityManifestHandlingUiMode();
      if (((sAlwaysOverrideConfiguration) || (i != j)) && (!bool4) && (Build.VERSION.SDK_INT >= 17) && (!this.mBaseContextAttached) && ((this.mHost instanceof android.view.ContextThemeWrapper)))
      {
        localConfiguration = new Configuration();
        localConfiguration.uiMode = (localConfiguration.uiMode & 0xFFFFFFCF | i);
      }
      break;
    }
    for (;;)
    {
      try
      {
        ((android.view.ContextThemeWrapper)this.mHost).applyOverrideConfiguration(localConfiguration);
        bool1 = true;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        boolean bool2;
        Log.e("AppCompatDelegate", "updateForNightMode. Calling applyOverrideConfiguration() failed with an exception. Will fall back to using Resources.updateConfiguration()", localIllegalStateException);
        bool1 = false;
        continue;
        paramBoolean = bool2;
        continue;
      }
      j = this.mContext.getResources().getConfiguration().uiMode & 0x30;
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (j != i)
        {
          bool2 = bool1;
          if (paramBoolean)
          {
            bool2 = bool1;
            if (!bool4)
            {
              bool2 = bool1;
              if (this.mBaseContextAttached) {
                if (Build.VERSION.SDK_INT < 17)
                {
                  bool2 = bool1;
                  if (!this.mCreated) {}
                }
                else
                {
                  bool2 = bool1;
                  if ((this.mHost instanceof Activity))
                  {
                    ActivityCompat.recreate((Activity)this.mHost);
                    bool2 = true;
                  }
                }
              }
            }
          }
        }
      }
      if ((!bool2) && (j != i))
      {
        updateResourcesConfigurationForNightMode(i, bool4);
        paramBoolean = bool3;
        if ((paramBoolean) && ((this.mHost instanceof AppCompatActivity))) {
          ((AppCompatActivity)this.mHost).onNightModeChanged(paramInt);
        }
        return paramBoolean;
        i = 32;
        break;
        i = 16;
        break;
      }
      boolean bool1 = false;
    }
  }
  
  private void updateResourcesConfigurationForNightMode(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.mContext.getResources();
    Configuration localConfiguration = new Configuration(((Resources)localObject).getConfiguration());
    localConfiguration.uiMode = (((Resources)localObject).getConfiguration().uiMode & 0xFFFFFFCF | paramInt);
    ((Resources)localObject).updateConfiguration(localConfiguration, null);
    if (Build.VERSION.SDK_INT < 26) {
      ResourcesFlusher.flush((Resources)localObject);
    }
    if (this.mThemeResId != 0)
    {
      this.mContext.setTheme(this.mThemeResId);
      if (Build.VERSION.SDK_INT >= 23) {
        this.mContext.getTheme().applyStyle(this.mThemeResId, true);
      }
    }
    if ((paramBoolean) && ((this.mHost instanceof Activity)))
    {
      localObject = (Activity)this.mHost;
      if (!(localObject instanceof LifecycleOwner)) {
        break label160;
      }
      if (((LifecycleOwner)localObject).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
        ((Activity)localObject).onConfigurationChanged(localConfiguration);
      }
    }
    label160:
    while (!this.mStarted) {
      return;
    }
    ((Activity)localObject).onConfigurationChanged(localConfiguration);
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    ensureSubDecor();
    ((ViewGroup)this.mSubDecor.findViewById(16908290)).addView(paramView, paramLayoutParams);
    this.mAppCompatWindowCallback.getWrapped().onContentChanged();
  }
  
  public boolean applyDayNight()
  {
    return applyDayNight(true);
  }
  
  public void attachBaseContext(Context paramContext)
  {
    applyDayNight(false);
    this.mBaseContextAttached = true;
  }
  
  void callOnPanelClosed(int paramInt, PanelFeatureState paramPanelFeatureState, Menu paramMenu)
  {
    Object localObject1 = paramPanelFeatureState;
    Object localObject2 = paramMenu;
    if (paramMenu == null)
    {
      PanelFeatureState localPanelFeatureState = paramPanelFeatureState;
      if (paramPanelFeatureState == null)
      {
        localPanelFeatureState = paramPanelFeatureState;
        if (paramInt >= 0)
        {
          localPanelFeatureState = paramPanelFeatureState;
          if (paramInt < this.mPanels.length) {
            localPanelFeatureState = this.mPanels[paramInt];
          }
        }
      }
      localObject1 = localPanelFeatureState;
      localObject2 = paramMenu;
      if (localPanelFeatureState != null)
      {
        localObject2 = localPanelFeatureState.menu;
        localObject1 = localPanelFeatureState;
      }
    }
    if ((localObject1 != null) && (!((PanelFeatureState)localObject1).isOpen)) {}
    while (this.mIsDestroyed) {
      return;
    }
    this.mAppCompatWindowCallback.getWrapped().onPanelClosed(paramInt, (Menu)localObject2);
  }
  
  void checkCloseActionMenu(MenuBuilder paramMenuBuilder)
  {
    if (this.mClosingActionMenu) {
      return;
    }
    this.mClosingActionMenu = true;
    this.mDecorContentParent.dismissPopups();
    Window.Callback localCallback = getWindowCallback();
    if ((localCallback != null) && (!this.mIsDestroyed)) {
      localCallback.onPanelClosed(108, paramMenuBuilder);
    }
    this.mClosingActionMenu = false;
  }
  
  void closePanel(int paramInt)
  {
    closePanel(getPanelState(paramInt, true), true);
  }
  
  void closePanel(PanelFeatureState paramPanelFeatureState, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramPanelFeatureState.featureId == 0) && (this.mDecorContentParent != null) && (this.mDecorContentParent.isOverflowMenuShowing())) {
      checkCloseActionMenu(paramPanelFeatureState.menu);
    }
    do
    {
      return;
      WindowManager localWindowManager = (WindowManager)this.mContext.getSystemService("window");
      if ((localWindowManager != null) && (paramPanelFeatureState.isOpen) && (paramPanelFeatureState.decorView != null))
      {
        localWindowManager.removeView(paramPanelFeatureState.decorView);
        if (paramBoolean) {
          callOnPanelClosed(paramPanelFeatureState.featureId, paramPanelFeatureState, null);
        }
      }
      paramPanelFeatureState.isPrepared = false;
      paramPanelFeatureState.isHandled = false;
      paramPanelFeatureState.isOpen = false;
      paramPanelFeatureState.shownPanelView = null;
      paramPanelFeatureState.refreshDecorView = true;
    } while (this.mPreparedPanel != paramPanelFeatureState);
    this.mPreparedPanel = null;
  }
  
  public View createView(View paramView, String paramString, @NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet)
  {
    String str;
    boolean bool;
    if (this.mAppCompatViewInflater == null)
    {
      str = this.mContext.obtainStyledAttributes(b.a.AppCompatTheme).getString(b.a.AppCompatTheme_viewInflaterClass);
      if ((str == null) || (AppCompatViewInflater.class.getName().equals(str))) {
        this.mAppCompatViewInflater = new AppCompatViewInflater();
      }
    }
    else
    {
      if (!IS_PRE_LOLLIPOP) {
        break label208;
      }
      if (!(paramAttributeSet instanceof XmlPullParser)) {
        break label195;
      }
      if (((XmlPullParser)paramAttributeSet).getDepth() <= 1) {
        break label189;
      }
      bool = true;
    }
    for (;;)
    {
      for (;;)
      {
        return this.mAppCompatViewInflater.createView(paramView, paramString, paramContext, paramAttributeSet, bool, IS_PRE_LOLLIPOP, true, VectorEnabledTintResources.shouldBeUsed());
        try
        {
          this.mAppCompatViewInflater = ((AppCompatViewInflater)Class.forName(str).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        catch (Throwable localThrowable)
        {
          Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + str + ". Falling back to default.", localThrowable);
          this.mAppCompatViewInflater = new AppCompatViewInflater();
        }
      }
      break;
      label189:
      bool = false;
      continue;
      label195:
      bool = shouldInheritContext((ViewParent)paramView);
      continue;
      label208:
      bool = false;
    }
  }
  
  void dismissPopups()
  {
    if (this.mDecorContentParent != null) {
      this.mDecorContentParent.dismissPopups();
    }
    if (this.mActionModePopup != null)
    {
      this.mWindow.getDecorView().removeCallbacks(this.mShowActionModePopup);
      if (!this.mActionModePopup.isShowing()) {}
    }
    try
    {
      this.mActionModePopup.dismiss();
      label55:
      this.mActionModePopup = null;
      endOnGoingFadeAnimation();
      PanelFeatureState localPanelFeatureState = getPanelState(0, false);
      if ((localPanelFeatureState != null) && (localPanelFeatureState.menu != null)) {
        localPanelFeatureState.menu.close();
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label55;
    }
  }
  
  boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    int i = 1;
    if (((this.mHost instanceof KeyEventDispatcher.Component)) || ((this.mHost instanceof AppCompatDialog)))
    {
      View localView = this.mWindow.getDecorView();
      if ((localView == null) || (!KeyEventDispatcher.dispatchBeforeHierarchy(localView, paramKeyEvent))) {}
    }
    while ((paramKeyEvent.getKeyCode() == 82) && (this.mAppCompatWindowCallback.getWrapped().dispatchKeyEvent(paramKeyEvent))) {
      return true;
    }
    int j = paramKeyEvent.getKeyCode();
    if (paramKeyEvent.getAction() == 0) {}
    while (i != 0)
    {
      return onKeyDown(j, paramKeyEvent);
      i = 0;
    }
    return onKeyUp(j, paramKeyEvent);
  }
  
  void doInvalidatePanelMenu(int paramInt)
  {
    PanelFeatureState localPanelFeatureState = getPanelState(paramInt, true);
    if (localPanelFeatureState.menu != null)
    {
      Bundle localBundle = new Bundle();
      localPanelFeatureState.menu.saveActionViewStates(localBundle);
      if (localBundle.size() > 0) {
        localPanelFeatureState.frozenActionViewState = localBundle;
      }
      localPanelFeatureState.menu.stopDispatchingItemsChanged();
      localPanelFeatureState.menu.clear();
    }
    localPanelFeatureState.refreshMenuContent = true;
    localPanelFeatureState.refreshDecorView = true;
    if (((paramInt == 108) || (paramInt == 0)) && (this.mDecorContentParent != null))
    {
      localPanelFeatureState = getPanelState(0, false);
      if (localPanelFeatureState != null)
      {
        localPanelFeatureState.isPrepared = false;
        preparePanel(localPanelFeatureState, null);
      }
    }
  }
  
  void endOnGoingFadeAnimation()
  {
    if (this.mFadeAnim != null) {
      this.mFadeAnim.cancel();
    }
  }
  
  PanelFeatureState findMenuPanel(Menu paramMenu)
  {
    PanelFeatureState[] arrayOfPanelFeatureState = this.mPanels;
    int i;
    int j;
    if (arrayOfPanelFeatureState != null)
    {
      i = arrayOfPanelFeatureState.length;
      j = 0;
    }
    for (;;)
    {
      if (j >= i) {
        break label57;
      }
      PanelFeatureState localPanelFeatureState = arrayOfPanelFeatureState[j];
      if ((localPanelFeatureState != null) && (localPanelFeatureState.menu == paramMenu))
      {
        return localPanelFeatureState;
        i = 0;
        break;
      }
      j += 1;
    }
    label57:
    return null;
  }
  
  @Nullable
  public <T extends View> T findViewById(@IdRes int paramInt)
  {
    ensureSubDecor();
    return this.mWindow.findViewById(paramInt);
  }
  
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
  
  @NonNull
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  final AutoNightModeManager getAutoTimeNightModeManager()
  {
    if (this.mAutoTimeNightModeManager == null) {
      this.mAutoTimeNightModeManager = new AutoTimeNightModeManager(TwilightManager.getInstance(this.mContext));
    }
    return this.mAutoTimeNightModeManager;
  }
  
  public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate()
  {
    return new ActionBarDrawableToggleImpl();
  }
  
  public int getLocalNightMode()
  {
    return this.mLocalNightMode;
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
  
  protected PanelFeatureState getPanelState(int paramInt, boolean paramBoolean)
  {
    Object localObject2 = this.mPanels;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length > paramInt) {}
    }
    else
    {
      localObject1 = new PanelFeatureState[paramInt + 1];
      if (localObject2 != null) {
        System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
      }
      this.mPanels = ((PanelFeatureState[])localObject1);
    }
    localObject2 = localObject1[paramInt];
    if (localObject2 == null)
    {
      localObject2 = new PanelFeatureState(paramInt);
      localObject1[paramInt] = localObject2;
      return localObject2;
    }
    return localObject2;
  }
  
  ViewGroup getSubDecor()
  {
    return this.mSubDecor;
  }
  
  public ActionBar getSupportActionBar()
  {
    initWindowDecorActionBar();
    return this.mActionBar;
  }
  
  final CharSequence getTitle()
  {
    if ((this.mHost instanceof Activity)) {
      return ((Activity)this.mHost).getTitle();
    }
    return this.mTitle;
  }
  
  final Window.Callback getWindowCallback()
  {
    return this.mWindow.getCallback();
  }
  
  public boolean hasWindowFeature(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1;
    switch (sanitizeWindowFeatureId(paramInt))
    {
    default: 
      bool1 = false;
    }
    for (;;)
    {
      if (!bool1)
      {
        bool1 = bool2;
        if (!this.mWindow.hasFeature(paramInt)) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
      bool1 = this.mHasActionBar;
      continue;
      bool1 = this.mOverlayActionBar;
      continue;
      bool1 = this.mOverlayActionMode;
      continue;
      bool1 = this.mFeatureProgress;
      continue;
      bool1 = this.mFeatureIndeterminateProgress;
      continue;
      bool1 = this.mWindowNoTitle;
    }
  }
  
  public void installViewFactory()
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.mContext);
    if (localLayoutInflater.getFactory() == null) {
      LayoutInflaterCompat.setFactory2(localLayoutInflater, this);
    }
    while ((localLayoutInflater.getFactory2() instanceof AppCompatDelegateImpl)) {
      return;
    }
    Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
  }
  
  public void invalidateOptionsMenu()
  {
    ActionBar localActionBar = getSupportActionBar();
    if ((localActionBar != null) && (localActionBar.invalidateOptionsMenu())) {
      return;
    }
    invalidatePanelMenu(0);
  }
  
  public boolean isHandleNativeActionModesEnabled()
  {
    return this.mHandleNativeActionModes;
  }
  
  int mapNightMode(int paramInt)
  {
    int i = paramInt;
    switch (paramInt)
    {
    default: 
      throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
    case 0: 
      if ((Build.VERSION.SDK_INT >= 23) && (((UiModeManager)this.mContext.getSystemService(UiModeManager.class)).getNightMode() == 0)) {
        i = -1;
      }
    case -1: 
    case 1: 
    case 2: 
      return i;
      return getAutoTimeNightModeManager().getApplyableNightMode();
    case 3: 
      return getAutoBatteryNightModeManager().getApplyableNightMode();
    }
    return -1;
  }
  
  boolean onBackPressed()
  {
    if (this.mActionMode != null) {
      this.mActionMode.finish();
    }
    ActionBar localActionBar;
    do
    {
      return true;
      localActionBar = getSupportActionBar();
    } while ((localActionBar != null) && (localActionBar.collapseActionView()));
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((this.mHasActionBar) && (this.mSubDecorInstalled))
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar != null) {
        localActionBar.onConfigurationChanged(paramConfiguration);
      }
    }
    AppCompatDrawableManager.get().onConfigurationChanged(this.mContext);
    applyDayNight(false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mBaseContextAttached = true;
    applyDayNight(false);
    ensureWindow();
    if ((this.mHost instanceof Activity)) {}
    try
    {
      paramBundle = NavUtils.getParentActivityName((Activity)this.mHost);
      if (paramBundle != null)
      {
        paramBundle = peekSupportActionBar();
        if (paramBundle == null) {
          this.mEnableDefaultActionBarUp = true;
        }
      }
      else
      {
        this.mCreated = true;
        return;
      }
    }
    catch (IllegalArgumentException paramBundle)
    {
      for (;;)
      {
        paramBundle = null;
        continue;
        paramBundle.setDefaultDisplayHomeAsUpEnabled(true);
      }
    }
  }
  
  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return createView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
  
  public void onDestroy()
  {
    markStopped(this);
    if (this.mInvalidatePanelMenuPosted) {
      this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
    }
    this.mStarted = false;
    this.mIsDestroyed = true;
    if (this.mActionBar != null) {
      this.mActionBar.onDestroy();
    }
    cleanupAutoManagers();
  }
  
  boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      return false;
    case 82: 
      onKeyDownPanel(0, paramKeyEvent);
      return true;
    }
    if ((paramKeyEvent.getFlags() & 0x80) != 0) {}
    for (;;)
    {
      this.mLongPressBackDown = bool;
      break;
      bool = false;
    }
  }
  
  boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    Object localObject = getSupportActionBar();
    if ((localObject != null) && (((ActionBar)localObject).onKeyShortcut(paramInt, paramKeyEvent))) {}
    boolean bool;
    do
    {
      do
      {
        return true;
        if ((this.mPreparedPanel == null) || (!performPanelShortcut(this.mPreparedPanel, paramKeyEvent.getKeyCode(), paramKeyEvent, 1))) {
          break;
        }
      } while (this.mPreparedPanel == null);
      this.mPreparedPanel.isHandled = true;
      return true;
      if (this.mPreparedPanel != null) {
        break;
      }
      localObject = getPanelState(0, true);
      preparePanel((PanelFeatureState)localObject, paramKeyEvent);
      bool = performPanelShortcut((PanelFeatureState)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent, 1);
      ((PanelFeatureState)localObject).isPrepared = false;
    } while (bool);
    return false;
  }
  
  boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool1 = true;
    switch (paramInt)
    {
    }
    do
    {
      bool1 = false;
      boolean bool2;
      do
      {
        return bool1;
        onKeyUpPanel(0, paramKeyEvent);
        return true;
        bool2 = this.mLongPressBackDown;
        this.mLongPressBackDown = false;
        paramKeyEvent = getPanelState(0, false);
        if ((paramKeyEvent == null) || (!paramKeyEvent.isOpen)) {
          break;
        }
      } while (bool2);
      closePanel(paramKeyEvent, true);
      return true;
    } while (!onBackPressed());
    return true;
  }
  
  public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    Window.Callback localCallback = getWindowCallback();
    if ((localCallback != null) && (!this.mIsDestroyed))
    {
      paramMenuBuilder = findMenuPanel(paramMenuBuilder.getRootMenu());
      if (paramMenuBuilder != null) {
        return localCallback.onMenuItemSelected(paramMenuBuilder.featureId, paramMenuItem);
      }
    }
    return false;
  }
  
  public void onMenuModeChange(MenuBuilder paramMenuBuilder)
  {
    reopenMenu(paramMenuBuilder, true);
  }
  
  void onMenuOpened(int paramInt)
  {
    if (paramInt == 108)
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar != null) {
        localActionBar.dispatchMenuVisibilityChanged(true);
      }
    }
  }
  
  void onPanelClosed(int paramInt)
  {
    Object localObject;
    if (paramInt == 108)
    {
      localObject = getSupportActionBar();
      if (localObject != null) {
        ((ActionBar)localObject).dispatchMenuVisibilityChanged(false);
      }
    }
    do
    {
      do
      {
        return;
      } while (paramInt != 0);
      localObject = getPanelState(paramInt, true);
    } while (!((PanelFeatureState)localObject).isOpen);
    closePanel((PanelFeatureState)localObject, false);
  }
  
  public void onPostCreate(Bundle paramBundle)
  {
    ensureSubDecor();
  }
  
  public void onPostResume()
  {
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.setShowHideAnimationEnabled(true);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.mLocalNightMode != -100) {
      sLocalNightModes.put(this.mHost.getClass(), Integer.valueOf(this.mLocalNightMode));
    }
  }
  
  public void onStart()
  {
    this.mStarted = true;
    applyDayNight();
    markStarted(this);
  }
  
  public void onStop()
  {
    this.mStarted = false;
    markStopped(this);
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.setShowHideAnimationEnabled(false);
    }
    if ((this.mHost instanceof Dialog)) {
      cleanupAutoManagers();
    }
  }
  
  void onSubDecorInstalled(ViewGroup paramViewGroup) {}
  
  final ActionBar peekSupportActionBar()
  {
    return this.mActionBar;
  }
  
  public boolean requestWindowFeature(int paramInt)
  {
    paramInt = sanitizeWindowFeatureId(paramInt);
    if ((this.mWindowNoTitle) && (paramInt == 108)) {
      return false;
    }
    if ((this.mHasActionBar) && (paramInt == 1)) {
      this.mHasActionBar = false;
    }
    switch (paramInt)
    {
    default: 
      return this.mWindow.requestFeature(paramInt);
    case 108: 
      throwFeatureRequestIfSubDecorInstalled();
      this.mHasActionBar = true;
      return true;
    case 109: 
      throwFeatureRequestIfSubDecorInstalled();
      this.mOverlayActionBar = true;
      return true;
    case 10: 
      throwFeatureRequestIfSubDecorInstalled();
      this.mOverlayActionMode = true;
      return true;
    case 2: 
      throwFeatureRequestIfSubDecorInstalled();
      this.mFeatureProgress = true;
      return true;
    case 5: 
      throwFeatureRequestIfSubDecorInstalled();
      this.mFeatureIndeterminateProgress = true;
      return true;
    }
    throwFeatureRequestIfSubDecorInstalled();
    this.mWindowNoTitle = true;
    return true;
  }
  
  public void setContentView(int paramInt)
  {
    ensureSubDecor();
    ViewGroup localViewGroup = (ViewGroup)this.mSubDecor.findViewById(16908290);
    localViewGroup.removeAllViews();
    LayoutInflater.from(this.mContext).inflate(paramInt, localViewGroup);
    this.mAppCompatWindowCallback.getWrapped().onContentChanged();
  }
  
  public void setContentView(View paramView)
  {
    ensureSubDecor();
    ViewGroup localViewGroup = (ViewGroup)this.mSubDecor.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView);
    this.mAppCompatWindowCallback.getWrapped().onContentChanged();
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    ensureSubDecor();
    ViewGroup localViewGroup = (ViewGroup)this.mSubDecor.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView, paramLayoutParams);
    this.mAppCompatWindowCallback.getWrapped().onContentChanged();
  }
  
  public void setHandleNativeActionModesEnabled(boolean paramBoolean)
  {
    this.mHandleNativeActionModes = paramBoolean;
  }
  
  public void setLocalNightMode(int paramInt)
  {
    if (this.mLocalNightMode != paramInt)
    {
      this.mLocalNightMode = paramInt;
      applyDayNight();
    }
  }
  
  public void setSupportActionBar(Toolbar paramToolbar)
  {
    if (!(this.mHost instanceof Activity)) {
      return;
    }
    ActionBar localActionBar = getSupportActionBar();
    if ((localActionBar instanceof WindowDecorActionBar)) {
      throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
    }
    this.mMenuInflater = null;
    if (localActionBar != null) {
      localActionBar.onDestroy();
    }
    if (paramToolbar != null)
    {
      paramToolbar = new ToolbarActionBar(paramToolbar, getTitle(), this.mAppCompatWindowCallback);
      this.mActionBar = paramToolbar;
      this.mWindow.setCallback(paramToolbar.getWrappedWindowCallback());
    }
    for (;;)
    {
      invalidateOptionsMenu();
      return;
      this.mActionBar = null;
      this.mWindow.setCallback(this.mAppCompatWindowCallback);
    }
  }
  
  public void setTheme(@StyleRes int paramInt)
  {
    this.mThemeResId = paramInt;
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.mTitle = paramCharSequence;
    if (this.mDecorContentParent != null) {
      this.mDecorContentParent.setWindowTitle(paramCharSequence);
    }
    do
    {
      return;
      if (peekSupportActionBar() != null)
      {
        peekSupportActionBar().setWindowTitle(paramCharSequence);
        return;
      }
    } while (this.mTitleView == null);
    this.mTitleView.setText(paramCharSequence);
  }
  
  final boolean shouldAnimateActionModeView()
  {
    return (this.mSubDecorInstalled) && (this.mSubDecor != null) && (ViewCompat.isLaidOut(this.mSubDecor));
  }
  
  public androidx.appcompat.view.ActionMode startSupportActionMode(@NonNull androidx.appcompat.view.ActionMode.Callback paramCallback)
  {
    if (paramCallback == null) {
      throw new IllegalArgumentException("ActionMode callback can not be null.");
    }
    if (this.mActionMode != null) {
      this.mActionMode.finish();
    }
    paramCallback = new ActionModeCallbackWrapperV9(paramCallback);
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null)
    {
      this.mActionMode = localActionBar.startActionMode(paramCallback);
      if ((this.mActionMode != null) && (this.mAppCompatCallback != null)) {
        this.mAppCompatCallback.onSupportActionModeStarted(this.mActionMode);
      }
    }
    if (this.mActionMode == null) {
      this.mActionMode = startSupportActionModeFromWindow(paramCallback);
    }
    return this.mActionMode;
  }
  
  androidx.appcompat.view.ActionMode startSupportActionModeFromWindow(@NonNull androidx.appcompat.view.ActionMode.Callback paramCallback)
  {
    endOnGoingFadeAnimation();
    if (this.mActionMode != null) {
      this.mActionMode.finish();
    }
    Object localObject1 = paramCallback;
    if (!(paramCallback instanceof ActionModeCallbackWrapperV9)) {
      localObject1 = new ActionModeCallbackWrapperV9(paramCallback);
    }
    if ((this.mAppCompatCallback != null) && (!this.mIsDestroyed)) {}
    for (;;)
    {
      try
      {
        paramCallback = this.mAppCompatCallback.onWindowStartingSupportActionMode((androidx.appcompat.view.ActionMode.Callback)localObject1);
        if (paramCallback != null)
        {
          this.mActionMode = paramCallback;
          if ((this.mActionMode != null) && (this.mAppCompatCallback != null)) {
            this.mAppCompatCallback.onSupportActionModeStarted(this.mActionMode);
          }
          return this.mActionMode;
        }
      }
      catch (AbstractMethodError paramCallback)
      {
        paramCallback = null;
        continue;
        Object localObject2;
        if (this.mActionModeView == null)
        {
          if (!this.mIsFloating) {
            continue;
          }
          localObject2 = new TypedValue();
          paramCallback = this.mContext.getTheme();
          paramCallback.resolveAttribute(2131034127, (TypedValue)localObject2, true);
          if (((TypedValue)localObject2).resourceId != 0)
          {
            Resources.Theme localTheme = this.mContext.getResources().newTheme();
            localTheme.setTo(paramCallback);
            localTheme.applyStyle(((TypedValue)localObject2).resourceId, true);
            paramCallback = new androidx.appcompat.view.ContextThemeWrapper(this.mContext, 0);
            paramCallback.getTheme().setTo(localTheme);
            this.mActionModeView = new ActionBarContextView(paramCallback);
            this.mActionModePopup = new PopupWindow(paramCallback, null, 2131034141);
            PopupWindowCompat.setWindowLayoutType(this.mActionModePopup, 2);
            this.mActionModePopup.setContentView(this.mActionModeView);
            this.mActionModePopup.setWidth(-1);
            paramCallback.getTheme().resolveAttribute(2131034121, (TypedValue)localObject2, true);
            int i = TypedValue.complexToDimensionPixelSize(((TypedValue)localObject2).data, paramCallback.getResources().getDisplayMetrics());
            this.mActionModeView.setContentHeight(i);
            this.mActionModePopup.setHeight(-2);
            this.mShowActionModePopup = new AppCompatDelegateImpl.6(this);
          }
        }
        else
        {
          if (this.mActionModeView == null) {
            continue;
          }
          endOnGoingFadeAnimation();
          this.mActionModeView.killMode();
          paramCallback = this.mActionModeView.getContext();
          localObject2 = this.mActionModeView;
          if (this.mActionModePopup != null) {
            continue;
          }
          bool = true;
          paramCallback = new StandaloneActionMode(paramCallback, (ActionBarContextView)localObject2, (androidx.appcompat.view.ActionMode.Callback)localObject1, bool);
          if (!((androidx.appcompat.view.ActionMode.Callback)localObject1).onCreateActionMode(paramCallback, paramCallback.getMenu())) {
            continue;
          }
          paramCallback.invalidate();
          this.mActionModeView.initForMode(paramCallback);
          this.mActionMode = paramCallback;
          if (!shouldAnimateActionModeView()) {
            continue;
          }
          this.mActionModeView.setAlpha(0.0F);
          this.mFadeAnim = ViewCompat.animate(this.mActionModeView).alpha(1.0F);
          this.mFadeAnim.setListener(new AppCompatDelegateImpl.7(this));
          if (this.mActionModePopup == null) {
            continue;
          }
          this.mWindow.getDecorView().post(this.mShowActionModePopup);
          continue;
        }
        paramCallback = this.mContext;
        continue;
        paramCallback = (ViewStubCompat)this.mSubDecor.findViewById(2131361991);
        if (paramCallback == null) {
          continue;
        }
        paramCallback.setLayoutInflater(LayoutInflater.from(getActionBarThemedContext()));
        this.mActionModeView = ((ActionBarContextView)paramCallback.inflate());
        continue;
        boolean bool = false;
        continue;
        this.mActionModeView.setAlpha(1.0F);
        this.mActionModeView.setVisibility(0);
        this.mActionModeView.sendAccessibilityEvent(32);
        if (!(this.mActionModeView.getParent() instanceof View)) {
          continue;
        }
        ViewCompat.requestApplyInsets((View)this.mActionModeView.getParent());
        continue;
        this.mActionMode = null;
        continue;
      }
      paramCallback = null;
    }
  }
  
  int updateStatusGuard(int paramInt)
  {
    int j = 1;
    int k = 1;
    int m = 0;
    Object localObject1;
    Object localObject2;
    int i;
    if ((this.mActionModeView != null) && ((this.mActionModeView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)this.mActionModeView.getLayoutParams();
      if (this.mActionModeView.isShown())
      {
        if (this.mTempRect1 == null)
        {
          this.mTempRect1 = new Rect();
          this.mTempRect2 = new Rect();
        }
        localObject2 = this.mTempRect1;
        Rect localRect = this.mTempRect2;
        ((Rect)localObject2).set(0, paramInt, 0, 0);
        ViewUtils.computeFitSystemWindows(this.mSubDecor, (Rect)localObject2, localRect);
        if (localRect.top == 0)
        {
          i = paramInt;
          if (((ViewGroup.MarginLayoutParams)localObject1).topMargin == i) {
            break label355;
          }
          ((ViewGroup.MarginLayoutParams)localObject1).topMargin = paramInt;
          if (this.mStatusGuard != null) {
            break label279;
          }
          this.mStatusGuard = new View(this.mContext);
          this.mStatusGuard.setBackgroundColor(this.mContext.getResources().getColor(2131165206));
          this.mSubDecor.addView(this.mStatusGuard, -1, new ViewGroup.LayoutParams(-1, paramInt));
          i = 1;
          label201:
          if (this.mStatusGuard == null) {
            break label317;
          }
          label208:
          j = paramInt;
          if (!this.mOverlayActionMode)
          {
            j = paramInt;
            if (k != 0) {
              j = 0;
            }
          }
          paramInt = j;
          j = i;
          i = k;
          label233:
          if (j != 0) {
            this.mActionModeView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
        }
      }
    }
    for (;;)
    {
      if (this.mStatusGuard != null)
      {
        localObject1 = this.mStatusGuard;
        if (i == 0) {
          break label342;
        }
      }
      label279:
      label317:
      label342:
      for (i = m;; i = 8)
      {
        ((View)localObject1).setVisibility(i);
        return paramInt;
        i = 0;
        break;
        localObject2 = this.mStatusGuard.getLayoutParams();
        if (((ViewGroup.LayoutParams)localObject2).height != paramInt)
        {
          ((ViewGroup.LayoutParams)localObject2).height = paramInt;
          this.mStatusGuard.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        i = 1;
        break label201;
        k = 0;
        break label208;
        if (((ViewGroup.MarginLayoutParams)localObject1).topMargin == 0) {
          break label348;
        }
        ((ViewGroup.MarginLayoutParams)localObject1).topMargin = 0;
        i = 0;
        break label233;
      }
      label348:
      j = 0;
      i = 0;
      break label233;
      label355:
      i = 0;
      break label201;
      i = 0;
    }
  }
  
  class ActionBarDrawableToggleImpl
    implements ActionBarDrawerToggle.Delegate
  {
    ActionBarDrawableToggleImpl() {}
    
    public Context getActionBarThemedContext()
    {
      return AppCompatDelegateImpl.this.getActionBarThemedContext();
    }
    
    public Drawable getThemeUpIndicator()
    {
      TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(getActionBarThemedContext(), null, new int[] { 2131034667 });
      Drawable localDrawable = localTintTypedArray.getDrawable(0);
      localTintTypedArray.recycle();
      return localDrawable;
    }
    
    public boolean isNavigationVisible()
    {
      ActionBar localActionBar = AppCompatDelegateImpl.this.getSupportActionBar();
      return (localActionBar != null) && ((localActionBar.getDisplayOptions() & 0x4) != 0);
    }
    
    public void setActionBarDescription(int paramInt)
    {
      ActionBar localActionBar = AppCompatDelegateImpl.this.getSupportActionBar();
      if (localActionBar != null) {
        localActionBar.setHomeActionContentDescription(paramInt);
      }
    }
    
    public void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
    {
      ActionBar localActionBar = AppCompatDelegateImpl.this.getSupportActionBar();
      if (localActionBar != null)
      {
        localActionBar.setHomeAsUpIndicator(paramDrawable);
        localActionBar.setHomeActionContentDescription(paramInt);
      }
    }
  }
  
  final class ActionMenuPresenterCallback
    implements MenuPresenter.Callback
  {
    ActionMenuPresenterCallback() {}
    
    public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
    {
      AppCompatDelegateImpl.this.checkCloseActionMenu(paramMenuBuilder);
    }
    
    public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
    {
      Window.Callback localCallback = AppCompatDelegateImpl.this.getWindowCallback();
      if (localCallback != null) {
        localCallback.onMenuOpened(108, paramMenuBuilder);
      }
      return true;
    }
  }
  
  class ActionModeCallbackWrapperV9
    implements androidx.appcompat.view.ActionMode.Callback
  {
    private androidx.appcompat.view.ActionMode.Callback mWrapped;
    
    public ActionModeCallbackWrapperV9(androidx.appcompat.view.ActionMode.Callback paramCallback)
    {
      this.mWrapped = paramCallback;
    }
    
    public boolean onActionItemClicked(androidx.appcompat.view.ActionMode paramActionMode, MenuItem paramMenuItem)
    {
      return this.mWrapped.onActionItemClicked(paramActionMode, paramMenuItem);
    }
    
    public boolean onCreateActionMode(androidx.appcompat.view.ActionMode paramActionMode, Menu paramMenu)
    {
      return this.mWrapped.onCreateActionMode(paramActionMode, paramMenu);
    }
    
    public void onDestroyActionMode(androidx.appcompat.view.ActionMode paramActionMode)
    {
      this.mWrapped.onDestroyActionMode(paramActionMode);
      if (AppCompatDelegateImpl.this.mActionModePopup != null) {
        AppCompatDelegateImpl.this.mWindow.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.mShowActionModePopup);
      }
      if (AppCompatDelegateImpl.this.mActionModeView != null)
      {
        AppCompatDelegateImpl.this.endOnGoingFadeAnimation();
        AppCompatDelegateImpl.this.mFadeAnim = ViewCompat.animate(AppCompatDelegateImpl.this.mActionModeView).alpha(0.0F);
        AppCompatDelegateImpl.this.mFadeAnim.setListener(new AppCompatDelegateImpl.ActionModeCallbackWrapperV9.1(this));
      }
      if (AppCompatDelegateImpl.this.mAppCompatCallback != null) {
        AppCompatDelegateImpl.this.mAppCompatCallback.onSupportActionModeFinished(AppCompatDelegateImpl.this.mActionMode);
      }
      AppCompatDelegateImpl.this.mActionMode = null;
    }
    
    public boolean onPrepareActionMode(androidx.appcompat.view.ActionMode paramActionMode, Menu paramMenu)
    {
      return this.mWrapped.onPrepareActionMode(paramActionMode, paramMenu);
    }
  }
  
  class AppCompatWindowCallback
    extends WindowCallbackWrapper
  {
    AppCompatWindowCallback(Window.Callback paramCallback)
    {
      super();
    }
    
    public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      return (AppCompatDelegateImpl.this.dispatchKeyEvent(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
    }
    
    public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
    {
      return (super.dispatchKeyShortcutEvent(paramKeyEvent)) || (AppCompatDelegateImpl.this.onKeyShortcut(paramKeyEvent.getKeyCode(), paramKeyEvent));
    }
    
    public void onContentChanged() {}
    
    public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
    {
      if ((paramInt == 0) && (!(paramMenu instanceof MenuBuilder))) {
        return false;
      }
      return super.onCreatePanelMenu(paramInt, paramMenu);
    }
    
    public boolean onMenuOpened(int paramInt, Menu paramMenu)
    {
      super.onMenuOpened(paramInt, paramMenu);
      AppCompatDelegateImpl.this.onMenuOpened(paramInt);
      return true;
    }
    
    public void onPanelClosed(int paramInt, Menu paramMenu)
    {
      super.onPanelClosed(paramInt, paramMenu);
      AppCompatDelegateImpl.this.onPanelClosed(paramInt);
    }
    
    public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      MenuBuilder localMenuBuilder;
      boolean bool1;
      if ((paramMenu instanceof MenuBuilder))
      {
        localMenuBuilder = (MenuBuilder)paramMenu;
        if ((paramInt != 0) || (localMenuBuilder != null)) {
          break label34;
        }
        bool1 = false;
      }
      label34:
      boolean bool2;
      do
      {
        return bool1;
        localMenuBuilder = null;
        break;
        if (localMenuBuilder != null) {
          localMenuBuilder.setOverrideVisibleItems(true);
        }
        bool2 = super.onPreparePanel(paramInt, paramView, paramMenu);
        bool1 = bool2;
      } while (localMenuBuilder == null);
      localMenuBuilder.setOverrideVisibleItems(false);
      return bool2;
    }
    
    @RequiresApi(24)
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> paramList, Menu paramMenu, int paramInt)
    {
      AppCompatDelegateImpl.PanelFeatureState localPanelFeatureState = AppCompatDelegateImpl.this.getPanelState(0, true);
      if ((localPanelFeatureState != null) && (localPanelFeatureState.menu != null))
      {
        super.onProvideKeyboardShortcuts(paramList, localPanelFeatureState.menu, paramInt);
        return;
      }
      super.onProvideKeyboardShortcuts(paramList, paramMenu, paramInt);
    }
    
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback paramCallback)
    {
      if (Build.VERSION.SDK_INT >= 23) {
        return null;
      }
      if (AppCompatDelegateImpl.this.isHandleNativeActionModesEnabled()) {
        return startAsSupportActionMode(paramCallback);
      }
      return super.onWindowStartingActionMode(paramCallback);
    }
    
    @RequiresApi(23)
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback paramCallback, int paramInt)
    {
      if (AppCompatDelegateImpl.this.isHandleNativeActionModesEnabled()) {}
      switch (paramInt)
      {
      default: 
        return super.onWindowStartingActionMode(paramCallback, paramInt);
      }
      return startAsSupportActionMode(paramCallback);
    }
    
    final android.view.ActionMode startAsSupportActionMode(android.view.ActionMode.Callback paramCallback)
    {
      paramCallback = new SupportActionModeWrapper.CallbackWrapper(AppCompatDelegateImpl.this.mContext, paramCallback);
      androidx.appcompat.view.ActionMode localActionMode = AppCompatDelegateImpl.this.startSupportActionMode(paramCallback);
      if (localActionMode != null) {
        return paramCallback.getActionModeWrapper(localActionMode);
      }
      return null;
    }
  }
  
  class AutoBatteryNightModeManager
    extends AppCompatDelegateImpl.AutoNightModeManager
  {
    private final PowerManager mPowerManager;
    
    AutoBatteryNightModeManager(@NonNull Context paramContext)
    {
      super();
      this.mPowerManager = ((PowerManager)paramContext.getSystemService("power"));
    }
    
    IntentFilter createIntentFilterForBroadcastReceiver()
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
        return localIntentFilter;
      }
      return null;
    }
    
    public int getApplyableNightMode()
    {
      int j = 1;
      int i = j;
      if (Build.VERSION.SDK_INT >= 21)
      {
        i = j;
        if (this.mPowerManager.isPowerSaveMode()) {
          i = 2;
        }
      }
      return i;
    }
    
    public void onChange()
    {
      AppCompatDelegateImpl.this.applyDayNight();
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  @VisibleForTesting
  abstract class AutoNightModeManager
  {
    private BroadcastReceiver mReceiver;
    
    AutoNightModeManager() {}
    
    void cleanup()
    {
      if (this.mReceiver != null) {}
      try
      {
        AppCompatDelegateImpl.this.mContext.unregisterReceiver(this.mReceiver);
        label21:
        this.mReceiver = null;
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        break label21;
      }
    }
    
    @Nullable
    abstract IntentFilter createIntentFilterForBroadcastReceiver();
    
    abstract int getApplyableNightMode();
    
    boolean isListening()
    {
      return this.mReceiver != null;
    }
    
    abstract void onChange();
    
    void setup()
    {
      cleanup();
      IntentFilter localIntentFilter = createIntentFilterForBroadcastReceiver();
      if ((localIntentFilter == null) || (localIntentFilter.countActions() == 0)) {
        return;
      }
      if (this.mReceiver == null) {
        this.mReceiver = new AppCompatDelegateImpl.AutoNightModeManager.1(this);
      }
      AppCompatDelegateImpl.this.mContext.registerReceiver(this.mReceiver, localIntentFilter);
    }
  }
  
  class AutoTimeNightModeManager
    extends AppCompatDelegateImpl.AutoNightModeManager
  {
    private final TwilightManager mTwilightManager;
    
    AutoTimeNightModeManager(@NonNull TwilightManager paramTwilightManager)
    {
      super();
      this.mTwilightManager = paramTwilightManager;
    }
    
    IntentFilter createIntentFilterForBroadcastReceiver()
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.TIME_SET");
      localIntentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
      localIntentFilter.addAction("android.intent.action.TIME_TICK");
      return localIntentFilter;
    }
    
    public int getApplyableNightMode()
    {
      if (this.mTwilightManager.isNight()) {
        return 2;
      }
      return 1;
    }
    
    public void onChange()
    {
      AppCompatDelegateImpl.this.applyDayNight();
    }
  }
  
  class ListMenuDecorView
    extends ContentFrameLayout
  {
    public ListMenuDecorView(Context paramContext)
    {
      super();
    }
    
    private boolean isOutOfBounds(int paramInt1, int paramInt2)
    {
      return (paramInt1 < -5) || (paramInt2 < -5) || (paramInt1 > getWidth() + 5) || (paramInt2 > getHeight() + 5);
    }
    
    public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      return (AppCompatDelegateImpl.this.dispatchKeyEvent(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      if ((paramMotionEvent.getAction() == 0) && (isOutOfBounds((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))
      {
        AppCompatDelegateImpl.this.closePanel(0);
        return true;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    
    public void setBackgroundResource(int paramInt)
    {
      setBackgroundDrawable(AppCompatResources.getDrawable(getContext(), paramInt));
    }
  }
  
  public static final class PanelFeatureState
  {
    int background;
    View createdPanelView;
    ViewGroup decorView;
    int featureId;
    Bundle frozenActionViewState;
    Bundle frozenMenuState;
    int gravity;
    boolean isHandled;
    boolean isOpen;
    boolean isPrepared;
    ListMenuPresenter listMenuPresenter;
    Context listPresenterContext;
    MenuBuilder menu;
    public boolean qwertyMode;
    boolean refreshDecorView;
    boolean refreshMenuContent;
    View shownPanelView;
    boolean wasLastOpen;
    int windowAnimations;
    int x;
    int y;
    
    PanelFeatureState(int paramInt)
    {
      this.featureId = paramInt;
      this.refreshDecorView = false;
    }
    
    void applyFrozenState()
    {
      if ((this.menu != null) && (this.frozenMenuState != null))
      {
        this.menu.restorePresenterStates(this.frozenMenuState);
        this.frozenMenuState = null;
      }
    }
    
    public void clearMenuPresenters()
    {
      if (this.menu != null) {
        this.menu.removeMenuPresenter(this.listMenuPresenter);
      }
      this.listMenuPresenter = null;
    }
    
    MenuView getListMenuView(MenuPresenter.Callback paramCallback)
    {
      if (this.menu == null) {
        return null;
      }
      if (this.listMenuPresenter == null)
      {
        this.listMenuPresenter = new ListMenuPresenter(this.listPresenterContext, 2131558416);
        this.listMenuPresenter.setCallback(paramCallback);
        this.menu.addMenuPresenter(this.listMenuPresenter);
      }
      return this.listMenuPresenter.getMenuView(this.decorView);
    }
    
    public boolean hasPanelItems()
    {
      boolean bool2 = true;
      boolean bool1;
      if (this.shownPanelView == null) {
        bool1 = false;
      }
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this.createdPanelView != null);
        bool1 = bool2;
      } while (this.listMenuPresenter.getAdapter().getCount() > 0);
      return false;
    }
    
    void onRestoreInstanceState(Parcelable paramParcelable)
    {
      paramParcelable = (SavedState)paramParcelable;
      this.featureId = paramParcelable.featureId;
      this.wasLastOpen = paramParcelable.isOpen;
      this.frozenMenuState = paramParcelable.menuState;
      this.shownPanelView = null;
      this.decorView = null;
    }
    
    Parcelable onSaveInstanceState()
    {
      SavedState localSavedState = new SavedState();
      localSavedState.featureId = this.featureId;
      localSavedState.isOpen = this.isOpen;
      if (this.menu != null)
      {
        localSavedState.menuState = new Bundle();
        this.menu.savePresenterStates(localSavedState.menuState);
      }
      return localSavedState;
    }
    
    void setMenu(MenuBuilder paramMenuBuilder)
    {
      if (paramMenuBuilder == this.menu) {}
      do
      {
        return;
        if (this.menu != null) {
          this.menu.removeMenuPresenter(this.listMenuPresenter);
        }
        this.menu = paramMenuBuilder;
      } while ((paramMenuBuilder == null) || (this.listMenuPresenter == null));
      paramMenuBuilder.addMenuPresenter(this.listMenuPresenter);
    }
    
    void setStyle(Context paramContext)
    {
      TypedValue localTypedValue = new TypedValue();
      Resources.Theme localTheme = paramContext.getResources().newTheme();
      localTheme.setTo(paramContext.getTheme());
      localTheme.resolveAttribute(2131034120, localTypedValue, true);
      if (localTypedValue.resourceId != 0) {
        localTheme.applyStyle(localTypedValue.resourceId, true);
      }
      localTheme.resolveAttribute(2131034966, localTypedValue, true);
      if (localTypedValue.resourceId != 0) {
        localTheme.applyStyle(localTypedValue.resourceId, true);
      }
      for (;;)
      {
        paramContext = new androidx.appcompat.view.ContextThemeWrapper(paramContext, 0);
        paramContext.getTheme().setTo(localTheme);
        this.listPresenterContext = paramContext;
        paramContext = paramContext.obtainStyledAttributes(b.a.AppCompatTheme);
        this.background = paramContext.getResourceId(b.a.AppCompatTheme_panelBackground, 0);
        this.windowAnimations = paramContext.getResourceId(b.a.AppCompatTheme_android_windowAnimationStyle, 0);
        paramContext.recycle();
        return;
        localTheme.applyStyle(2131755688, true);
      }
    }
    
    @SuppressLint({"BanParcelableUsage"})
    static class SavedState
      implements Parcelable
    {
      public static final Parcelable.Creator<SavedState> CREATOR = new AppCompatDelegateImpl.PanelFeatureState.SavedState.1();
      int featureId;
      boolean isOpen;
      Bundle menuState;
      
      static SavedState readFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        boolean bool = true;
        SavedState localSavedState = new SavedState();
        localSavedState.featureId = paramParcel.readInt();
        if (paramParcel.readInt() == 1) {}
        for (;;)
        {
          localSavedState.isOpen = bool;
          if (localSavedState.isOpen) {
            localSavedState.menuState = paramParcel.readBundle(paramClassLoader);
          }
          return localSavedState;
          bool = false;
        }
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        paramParcel.writeInt(this.featureId);
        if (this.isOpen) {}
        for (paramInt = 1;; paramInt = 0)
        {
          paramParcel.writeInt(paramInt);
          if (this.isOpen) {
            paramParcel.writeBundle(this.menuState);
          }
          return;
        }
      }
    }
  }
  
  final class PanelMenuPresenterCallback
    implements MenuPresenter.Callback
  {
    PanelMenuPresenterCallback() {}
    
    public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
    {
      MenuBuilder localMenuBuilder = paramMenuBuilder.getRootMenu();
      if (localMenuBuilder != paramMenuBuilder) {}
      for (int i = 1;; i = 0)
      {
        AppCompatDelegateImpl localAppCompatDelegateImpl = AppCompatDelegateImpl.this;
        if (i != 0) {
          paramMenuBuilder = localMenuBuilder;
        }
        paramMenuBuilder = localAppCompatDelegateImpl.findMenuPanel(paramMenuBuilder);
        if (paramMenuBuilder != null)
        {
          if (i == 0) {
            break;
          }
          AppCompatDelegateImpl.this.callOnPanelClosed(paramMenuBuilder.featureId, paramMenuBuilder, localMenuBuilder);
          AppCompatDelegateImpl.this.closePanel(paramMenuBuilder, true);
        }
        return;
      }
      AppCompatDelegateImpl.this.closePanel(paramMenuBuilder, paramBoolean);
    }
    
    public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
    {
      if ((paramMenuBuilder == null) && (AppCompatDelegateImpl.this.mHasActionBar))
      {
        Window.Callback localCallback = AppCompatDelegateImpl.this.getWindowCallback();
        if ((localCallback != null) && (!AppCompatDelegateImpl.this.mIsDestroyed)) {
          localCallback.onMenuOpened(108, paramMenuBuilder);
        }
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDelegateImpl
 * JD-Core Version:    0.7.0.1
 */