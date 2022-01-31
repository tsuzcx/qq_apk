package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NavUtils;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.color;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.view.StandaloneActionMode;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.DecorContentParent;
import android.support.v7.widget.FitWindowsViewGroup;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.VectorEnabledTintResources;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.ViewUtils;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuItem;
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
import android.widget.PopupWindow;
import android.widget.TextView;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;

@RequiresApi(14)
class AppCompatDelegateImplV9
  extends AppCompatDelegateImplBase
  implements MenuBuilder.Callback, LayoutInflater.Factory2
{
  private static final boolean IS_PRE_LOLLIPOP;
  private AppCompatDelegateImplV9.ActionMenuPresenterCallback mActionMenuPresenterCallback;
  ActionMode mActionMode;
  PopupWindow mActionModePopup;
  ActionBarContextView mActionModeView;
  private AppCompatViewInflater mAppCompatViewInflater;
  private boolean mClosingActionMenu;
  private DecorContentParent mDecorContentParent;
  private boolean mEnableDefaultActionBarUp;
  ViewPropertyAnimatorCompat mFadeAnim = null;
  private boolean mFeatureIndeterminateProgress;
  private boolean mFeatureProgress;
  int mInvalidatePanelMenuFeatures;
  boolean mInvalidatePanelMenuPosted;
  private final Runnable mInvalidatePanelMenuRunnable = new AppCompatDelegateImplV9.1(this);
  private boolean mLongPressBackDown;
  private AppCompatDelegateImplV9.PanelMenuPresenterCallback mPanelMenuPresenterCallback;
  private AppCompatDelegateImplV9.PanelFeatureState[] mPanels;
  private AppCompatDelegateImplV9.PanelFeatureState mPreparedPanel;
  Runnable mShowActionModePopup;
  private View mStatusGuard;
  private ViewGroup mSubDecor;
  private boolean mSubDecorInstalled;
  private Rect mTempRect1;
  private Rect mTempRect2;
  private TextView mTitleView;
  
  static
  {
    if (Build.VERSION.SDK_INT < 21) {}
    for (boolean bool = true;; bool = false)
    {
      IS_PRE_LOLLIPOP = bool;
      return;
    }
  }
  
  AppCompatDelegateImplV9(Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback)
  {
    super(paramContext, paramWindow, paramAppCompatCallback);
  }
  
  private void applyFixedSizeWindow()
  {
    ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)this.mSubDecor.findViewById(16908290);
    Object localObject = this.mWindow.getDecorView();
    localContentFrameLayout.setDecorPadding(((View)localObject).getPaddingLeft(), ((View)localObject).getPaddingTop(), ((View)localObject).getPaddingRight(), ((View)localObject).getPaddingBottom());
    localObject = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
    ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, localContentFrameLayout.getMinWidthMajor());
    ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, localContentFrameLayout.getMinWidthMinor());
    if (((TypedArray)localObject).hasValue(R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
      ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowFixedWidthMajor, localContentFrameLayout.getFixedWidthMajor());
    }
    if (((TypedArray)localObject).hasValue(R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
      ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowFixedWidthMinor, localContentFrameLayout.getFixedWidthMinor());
    }
    if (((TypedArray)localObject).hasValue(R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
      ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowFixedHeightMajor, localContentFrameLayout.getFixedHeightMajor());
    }
    if (((TypedArray)localObject).hasValue(R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
      ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowFixedHeightMinor, localContentFrameLayout.getFixedHeightMinor());
    }
    ((TypedArray)localObject).recycle();
    localContentFrameLayout.requestLayout();
  }
  
  private ViewGroup createSubDecor()
  {
    Object localObject = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
    if (!((TypedArray)localObject).hasValue(R.styleable.AppCompatTheme_windowActionBar))
    {
      ((TypedArray)localObject).recycle();
      throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }
    if (((TypedArray)localObject).getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false))
    {
      requestWindowFeature(1);
      if (((TypedArray)localObject).getBoolean(R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
        requestWindowFeature(109);
      }
      if (((TypedArray)localObject).getBoolean(R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
        requestWindowFeature(10);
      }
      this.mIsFloating = ((TypedArray)localObject).getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
      ((TypedArray)localObject).recycle();
      this.mWindow.getDecorView();
      localObject = LayoutInflater.from(this.mContext);
      if (this.mWindowNoTitle) {
        break label428;
      }
      if (!this.mIsFloating) {
        break label269;
      }
      localObject = (ViewGroup)((LayoutInflater)localObject).inflate(R.layout.abc_dialog_title_material, null);
      this.mOverlayActionBar = false;
      this.mHasActionBar = false;
    }
    for (;;)
    {
      if (localObject == null)
      {
        throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.mHasActionBar + ", windowActionBarOverlay: " + this.mOverlayActionBar + ", android:windowIsFloating: " + this.mIsFloating + ", windowActionModeOverlay: " + this.mOverlayActionMode + ", windowNoTitle: " + this.mWindowNoTitle + " }");
        if (!((TypedArray)localObject).getBoolean(R.styleable.AppCompatTheme_windowActionBar, false)) {
          break;
        }
        requestWindowFeature(108);
        break;
        label269:
        if (!this.mHasActionBar) {
          break label634;
        }
        localObject = new TypedValue();
        this.mContext.getTheme().resolveAttribute(R.attr.actionBarTheme, (TypedValue)localObject, true);
        if (((TypedValue)localObject).resourceId != 0) {}
        for (localObject = new ContextThemeWrapper(this.mContext, ((TypedValue)localObject).resourceId);; localObject = this.mContext)
        {
          localObject = (ViewGroup)LayoutInflater.from((Context)localObject).inflate(R.layout.abc_screen_toolbar, null);
          this.mDecorContentParent = ((DecorContentParent)((ViewGroup)localObject).findViewById(R.id.decor_content_parent));
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
        label428:
        if (this.mOverlayActionMode) {}
        for (localObject = (ViewGroup)((LayoutInflater)localObject).inflate(R.layout.abc_screen_simple_overlay_action_mode, null);; localObject = (ViewGroup)((LayoutInflater)localObject).inflate(R.layout.abc_screen_simple, null))
        {
          if (Build.VERSION.SDK_INT < 21) {
            break label485;
          }
          ViewCompat.setOnApplyWindowInsetsListener((View)localObject, new AppCompatDelegateImplV9.2(this));
          break;
        }
        label485:
        ((FitWindowsViewGroup)localObject).setOnFitSystemWindowsListener(new AppCompatDelegateImplV9.3(this));
        continue;
      }
      if (this.mDecorContentParent == null) {
        this.mTitleView = ((TextView)((ViewGroup)localObject).findViewById(R.id.title));
      }
      ViewUtils.makeOptionalFitsSystemWindows((View)localObject);
      ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)((ViewGroup)localObject).findViewById(R.id.action_bar_activity_content);
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
      localContentFrameLayout.setAttachListener(new AppCompatDelegateImplV9.4(this));
      return localObject;
      label634:
      localObject = null;
    }
  }
  
  private void ensureSubDecor()
  {
    if (!this.mSubDecorInstalled)
    {
      this.mSubDecor = createSubDecor();
      Object localObject = getTitle();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        onTitleChanged((CharSequence)localObject);
      }
      applyFixedSizeWindow();
      onSubDecorInstalled(this.mSubDecor);
      this.mSubDecorInstalled = true;
      localObject = getPanelState(0, false);
      if ((!isDestroyed()) && ((localObject == null) || (((AppCompatDelegateImplV9.PanelFeatureState)localObject).menu == null))) {
        invalidatePanelMenu(108);
      }
    }
  }
  
  private boolean initializePanelContent(AppCompatDelegateImplV9.PanelFeatureState paramPanelFeatureState)
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
      this.mPanelMenuPresenterCallback = new AppCompatDelegateImplV9.PanelMenuPresenterCallback(this);
    }
    paramPanelFeatureState.shownPanelView = ((View)paramPanelFeatureState.getListMenuView(this.mPanelMenuPresenterCallback));
    if (paramPanelFeatureState.shownPanelView != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean initializePanelDecor(AppCompatDelegateImplV9.PanelFeatureState paramPanelFeatureState)
  {
    paramPanelFeatureState.setStyle(getActionBarThemedContext());
    paramPanelFeatureState.decorView = new AppCompatDelegateImplV9.ListMenuDecorView(this, paramPanelFeatureState.listPresenterContext);
    paramPanelFeatureState.gravity = 81;
    return true;
  }
  
  private boolean initializePanelMenu(AppCompatDelegateImplV9.PanelFeatureState paramPanelFeatureState)
  {
    Context localContext = this.mContext;
    TypedValue localTypedValue;
    Resources.Theme localTheme;
    Object localObject1;
    if (((paramPanelFeatureState.featureId == 0) || (paramPanelFeatureState.featureId == 108)) && (this.mDecorContentParent != null))
    {
      localTypedValue = new TypedValue();
      localTheme = localContext.getTheme();
      localTheme.resolveAttribute(R.attr.actionBarTheme, localTypedValue, true);
      localObject1 = null;
      if (localTypedValue.resourceId != 0)
      {
        localObject1 = localContext.getResources().newTheme();
        ((Resources.Theme)localObject1).setTo(localTheme);
        ((Resources.Theme)localObject1).applyStyle(localTypedValue.resourceId, true);
        ((Resources.Theme)localObject1).resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
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
        localObject1 = new ContextThemeWrapper(localContext, 0);
        ((Context)localObject1).getTheme().setTo((Resources.Theme)localObject2);
      }
    }
    for (;;)
    {
      localObject1 = new MenuBuilder((Context)localObject1);
      ((MenuBuilder)localObject1).setCallback(this);
      paramPanelFeatureState.setMenu((MenuBuilder)localObject1);
      return true;
      localTheme.resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
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
  
  private boolean onKeyDownPanel(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getRepeatCount() == 0)
    {
      AppCompatDelegateImplV9.PanelFeatureState localPanelFeatureState = getPanelState(paramInt, true);
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
    AppCompatDelegateImplV9.PanelFeatureState localPanelFeatureState = getPanelState(paramInt, true);
    if ((paramInt == 0) && (this.mDecorContentParent != null) && (this.mDecorContentParent.canShowOverflowMenu()) && (!ViewConfiguration.get(this.mContext).hasPermanentMenuKey())) {
      if (!this.mDecorContentParent.isOverflowMenuShowing())
      {
        if ((isDestroyed()) || (!preparePanel(localPanelFeatureState, paramKeyEvent))) {
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
  
  private void openPanel(AppCompatDelegateImplV9.PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    int j = -1;
    if ((paramPanelFeatureState.isOpen) || (isDestroyed())) {}
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
        break label369;
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
        break label405;
      }
      paramKeyEvent = new ViewGroup.LayoutParams(-2, -2);
    }
    label405:
    for (;;)
    {
      i = paramPanelFeatureState.background;
      paramPanelFeatureState.decorView.setBackgroundResource(i);
      ViewParent localViewParent = paramPanelFeatureState.shownPanelView.getParent();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
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
        label369:
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
  
  private boolean performPanelShortcut(AppCompatDelegateImplV9.PanelFeatureState paramPanelFeatureState, int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
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
  
  private boolean preparePanel(AppCompatDelegateImplV9.PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    if (isDestroyed()) {
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
          this.mActionMenuPresenterCallback = new AppCompatDelegateImplV9.ActionMenuPresenterCallback(this);
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
        if ((paramMenuBuilder != null) && (!isDestroyed()))
        {
          if ((this.mInvalidatePanelMenuPosted) && ((this.mInvalidatePanelMenuFeatures & 0x1) != 0))
          {
            this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
            this.mInvalidatePanelMenuRunnable.run();
          }
          AppCompatDelegateImplV9.PanelFeatureState localPanelFeatureState = getPanelState(0, true);
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
      } while (isDestroyed());
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
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    ensureSubDecor();
    ((ViewGroup)this.mSubDecor.findViewById(16908290)).addView(paramView, paramLayoutParams);
    this.mOriginalWindowCallback.onContentChanged();
  }
  
  View callActivityOnCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if ((this.mOriginalWindowCallback instanceof LayoutInflater.Factory))
    {
      paramView = ((LayoutInflater.Factory)this.mOriginalWindowCallback).onCreateView(paramString, paramContext, paramAttributeSet);
      if (paramView != null) {
        return paramView;
      }
    }
    return null;
  }
  
  void callOnPanelClosed(int paramInt, AppCompatDelegateImplV9.PanelFeatureState paramPanelFeatureState, Menu paramMenu)
  {
    Object localObject1 = paramPanelFeatureState;
    Object localObject2 = paramMenu;
    if (paramMenu == null)
    {
      AppCompatDelegateImplV9.PanelFeatureState localPanelFeatureState = paramPanelFeatureState;
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
    if ((localObject1 != null) && (!((AppCompatDelegateImplV9.PanelFeatureState)localObject1).isOpen)) {}
    while (isDestroyed()) {
      return;
    }
    this.mOriginalWindowCallback.onPanelClosed(paramInt, (Menu)localObject2);
  }
  
  void checkCloseActionMenu(MenuBuilder paramMenuBuilder)
  {
    if (this.mClosingActionMenu) {
      return;
    }
    this.mClosingActionMenu = true;
    this.mDecorContentParent.dismissPopups();
    Window.Callback localCallback = getWindowCallback();
    if ((localCallback != null) && (!isDestroyed())) {
      localCallback.onPanelClosed(108, paramMenuBuilder);
    }
    this.mClosingActionMenu = false;
  }
  
  void closePanel(int paramInt)
  {
    closePanel(getPanelState(paramInt, true), true);
  }
  
  void closePanel(AppCompatDelegateImplV9.PanelFeatureState paramPanelFeatureState, boolean paramBoolean)
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
      str = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme).getString(R.styleable.AppCompatTheme_viewInflaterClass);
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
      AppCompatDelegateImplV9.PanelFeatureState localPanelFeatureState = getPanelState(0, false);
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
    if ((paramKeyEvent.getKeyCode() == 82) && (this.mOriginalWindowCallback.dispatchKeyEvent(paramKeyEvent))) {
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
    AppCompatDelegateImplV9.PanelFeatureState localPanelFeatureState = getPanelState(paramInt, true);
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
  
  AppCompatDelegateImplV9.PanelFeatureState findMenuPanel(Menu paramMenu)
  {
    AppCompatDelegateImplV9.PanelFeatureState[] arrayOfPanelFeatureState = this.mPanels;
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
      AppCompatDelegateImplV9.PanelFeatureState localPanelFeatureState = arrayOfPanelFeatureState[j];
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
  public View findViewById(@IdRes int paramInt)
  {
    ensureSubDecor();
    return this.mWindow.findViewById(paramInt);
  }
  
  protected AppCompatDelegateImplV9.PanelFeatureState getPanelState(int paramInt, boolean paramBoolean)
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
      localObject1 = new AppCompatDelegateImplV9.PanelFeatureState[paramInt + 1];
      if (localObject2 != null) {
        System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
      }
      this.mPanels = ((AppCompatDelegateImplV9.PanelFeatureState[])localObject1);
    }
    localObject2 = localObject1[paramInt];
    if (localObject2 == null)
    {
      localObject2 = new AppCompatDelegateImplV9.PanelFeatureState(paramInt);
      localObject1[paramInt] = localObject2;
      return localObject2;
    }
    return localObject2;
  }
  
  ViewGroup getSubDecor()
  {
    return this.mSubDecor;
  }
  
  public boolean hasWindowFeature(int paramInt)
  {
    switch (sanitizeWindowFeatureId(paramInt))
    {
    default: 
      return false;
    case 108: 
      return this.mHasActionBar;
    case 109: 
      return this.mOverlayActionBar;
    case 10: 
      return this.mOverlayActionMode;
    case 2: 
      return this.mFeatureProgress;
    case 5: 
      return this.mFeatureIndeterminateProgress;
    }
    return this.mWindowNoTitle;
  }
  
  public void initWindowDecorActionBar()
  {
    ensureSubDecor();
    if ((!this.mHasActionBar) || (this.mActionBar != null)) {}
    for (;;)
    {
      return;
      if ((this.mOriginalWindowCallback instanceof Activity)) {
        this.mActionBar = new WindowDecorActionBar((Activity)this.mOriginalWindowCallback, this.mOverlayActionBar);
      }
      while (this.mActionBar != null)
      {
        this.mActionBar.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
        return;
        if ((this.mOriginalWindowCallback instanceof Dialog)) {
          this.mActionBar = new WindowDecorActionBar((Dialog)this.mOriginalWindowCallback);
        }
      }
    }
  }
  
  public void installViewFactory()
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.mContext);
    if (localLayoutInflater.getFactory() == null) {
      LayoutInflaterCompat.setFactory2(localLayoutInflater, this);
    }
    while ((localLayoutInflater.getFactory2() instanceof AppCompatDelegateImplV9)) {
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
    applyDayNight();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (((this.mOriginalWindowCallback instanceof Activity)) && (NavUtils.getParentActivityName((Activity)this.mOriginalWindowCallback) != null))
    {
      paramBundle = peekSupportActionBar();
      if (paramBundle == null) {
        this.mEnableDefaultActionBarUp = true;
      }
    }
    else
    {
      return;
    }
    paramBundle.setDefaultDisplayHomeAsUpEnabled(true);
  }
  
  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    View localView = callActivityOnCreateView(paramView, paramString, paramContext, paramAttributeSet);
    if (localView != null) {
      return localView;
    }
    return createView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
  
  public void onDestroy()
  {
    if (this.mInvalidatePanelMenuPosted) {
      this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
    }
    super.onDestroy();
    if (this.mActionBar != null) {
      this.mActionBar.onDestroy();
    }
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
      preparePanel((AppCompatDelegateImplV9.PanelFeatureState)localObject, paramKeyEvent);
      bool = performPanelShortcut((AppCompatDelegateImplV9.PanelFeatureState)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent, 1);
      ((AppCompatDelegateImplV9.PanelFeatureState)localObject).isPrepared = false;
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
    if ((localCallback != null) && (!isDestroyed()))
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
  
  boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    if (paramInt == 108)
    {
      paramMenu = getSupportActionBar();
      if (paramMenu != null) {
        paramMenu.dispatchMenuVisibilityChanged(true);
      }
      return true;
    }
    return false;
  }
  
  void onPanelClosed(int paramInt, Menu paramMenu)
  {
    if (paramInt == 108)
    {
      paramMenu = getSupportActionBar();
      if (paramMenu != null) {
        paramMenu.dispatchMenuVisibilityChanged(false);
      }
    }
    do
    {
      do
      {
        return;
      } while (paramInt != 0);
      paramMenu = getPanelState(paramInt, true);
    } while (!paramMenu.isOpen);
    closePanel(paramMenu, false);
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
  
  public void onStop()
  {
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.setShowHideAnimationEnabled(false);
    }
  }
  
  void onSubDecorInstalled(ViewGroup paramViewGroup) {}
  
  void onTitleChanged(CharSequence paramCharSequence)
  {
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
    this.mOriginalWindowCallback.onContentChanged();
  }
  
  public void setContentView(View paramView)
  {
    ensureSubDecor();
    ViewGroup localViewGroup = (ViewGroup)this.mSubDecor.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView);
    this.mOriginalWindowCallback.onContentChanged();
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    ensureSubDecor();
    ViewGroup localViewGroup = (ViewGroup)this.mSubDecor.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView, paramLayoutParams);
    this.mOriginalWindowCallback.onContentChanged();
  }
  
  public void setSupportActionBar(Toolbar paramToolbar)
  {
    if (!(this.mOriginalWindowCallback instanceof Activity)) {
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
      paramToolbar = new ToolbarActionBar(paramToolbar, ((Activity)this.mOriginalWindowCallback).getTitle(), this.mAppCompatWindowCallback);
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
  
  final boolean shouldAnimateActionModeView()
  {
    return (this.mSubDecorInstalled) && (this.mSubDecor != null) && (ViewCompat.isLaidOut(this.mSubDecor));
  }
  
  public ActionMode startSupportActionMode(@NonNull ActionMode.Callback paramCallback)
  {
    if (paramCallback == null) {
      throw new IllegalArgumentException("ActionMode callback can not be null.");
    }
    if (this.mActionMode != null) {
      this.mActionMode.finish();
    }
    paramCallback = new AppCompatDelegateImplV9.ActionModeCallbackWrapperV9(this, paramCallback);
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
  
  ActionMode startSupportActionModeFromWindow(@NonNull ActionMode.Callback paramCallback)
  {
    endOnGoingFadeAnimation();
    if (this.mActionMode != null) {
      this.mActionMode.finish();
    }
    Object localObject1 = paramCallback;
    if (!(paramCallback instanceof AppCompatDelegateImplV9.ActionModeCallbackWrapperV9)) {
      localObject1 = new AppCompatDelegateImplV9.ActionModeCallbackWrapperV9(this, paramCallback);
    }
    if ((this.mAppCompatCallback != null) && (!isDestroyed())) {}
    for (;;)
    {
      try
      {
        paramCallback = this.mAppCompatCallback.onWindowStartingSupportActionMode((ActionMode.Callback)localObject1);
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
          paramCallback.resolveAttribute(R.attr.actionBarTheme, (TypedValue)localObject2, true);
          if (((TypedValue)localObject2).resourceId != 0)
          {
            Resources.Theme localTheme = this.mContext.getResources().newTheme();
            localTheme.setTo(paramCallback);
            localTheme.applyStyle(((TypedValue)localObject2).resourceId, true);
            paramCallback = new ContextThemeWrapper(this.mContext, 0);
            paramCallback.getTheme().setTo(localTheme);
            this.mActionModeView = new ActionBarContextView(paramCallback);
            this.mActionModePopup = new PopupWindow(paramCallback, null, R.attr.actionModePopupWindowStyle);
            PopupWindowCompat.setWindowLayoutType(this.mActionModePopup, 2);
            this.mActionModePopup.setContentView(this.mActionModeView);
            this.mActionModePopup.setWidth(-1);
            paramCallback.getTheme().resolveAttribute(R.attr.actionBarSize, (TypedValue)localObject2, true);
            int i = TypedValue.complexToDimensionPixelSize(((TypedValue)localObject2).data, paramCallback.getResources().getDisplayMetrics());
            this.mActionModeView.setContentHeight(i);
            this.mActionModePopup.setHeight(-2);
            this.mShowActionModePopup = new AppCompatDelegateImplV9.5(this);
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
          paramCallback = new StandaloneActionMode(paramCallback, (ActionBarContextView)localObject2, (ActionMode.Callback)localObject1, bool);
          if (!((ActionMode.Callback)localObject1).onCreateActionMode(paramCallback, paramCallback.getMenu())) {
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
          this.mFadeAnim.setListener(new AppCompatDelegateImplV9.6(this));
          if (this.mActionModePopup == null) {
            continue;
          }
          this.mWindow.getDecorView().post(this.mShowActionModePopup);
          continue;
        }
        paramCallback = this.mContext;
        continue;
        paramCallback = (ViewStubCompat)this.mSubDecor.findViewById(R.id.action_mode_bar_stub);
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
          this.mStatusGuard.setBackgroundColor(this.mContext.getResources().getColor(R.color.abc_input_method_navigation_guard));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplV9
 * JD-Core Version:    0.7.0.1
 */