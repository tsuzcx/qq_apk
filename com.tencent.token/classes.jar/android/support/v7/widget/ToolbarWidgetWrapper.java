package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.drawable;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.string;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.menu.ActionMenuItem;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ToolbarWidgetWrapper
  implements DecorToolbar
{
  private static final int AFFECTS_LOGO_MASK = 3;
  private static final long DEFAULT_FADE_DURATION_MS = 200L;
  private static final String TAG = "ToolbarWidgetWrapper";
  private ActionMenuPresenter mActionMenuPresenter;
  private View mCustomView;
  private int mDefaultNavigationContentDescription = 0;
  private Drawable mDefaultNavigationIcon;
  private int mDisplayOpts;
  private CharSequence mHomeDescription;
  private Drawable mIcon;
  private Drawable mLogo;
  boolean mMenuPrepared;
  private Drawable mNavIcon;
  private int mNavigationMode = 0;
  private Spinner mSpinner;
  private CharSequence mSubtitle;
  private View mTabView;
  CharSequence mTitle;
  private boolean mTitleSet;
  Toolbar mToolbar;
  Window.Callback mWindowCallback;
  
  public ToolbarWidgetWrapper(Toolbar paramToolbar, boolean paramBoolean)
  {
    this(paramToolbar, paramBoolean, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_material);
  }
  
  public ToolbarWidgetWrapper(Toolbar paramToolbar, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.mToolbar = paramToolbar;
    this.mTitle = paramToolbar.getTitle();
    this.mSubtitle = paramToolbar.getSubtitle();
    boolean bool;
    if (this.mTitle != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.mTitleSet = bool;
    this.mNavIcon = paramToolbar.getNavigationIcon();
    paramToolbar = TintTypedArray.obtainStyledAttributes(paramToolbar.getContext(), null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
    this.mDefaultNavigationIcon = paramToolbar.getDrawable(R.styleable.ActionBar_homeAsUpIndicator);
    if (paramBoolean)
    {
      Object localObject = paramToolbar.getText(R.styleable.ActionBar_title);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        setTitle((CharSequence)localObject);
      }
      localObject = paramToolbar.getText(R.styleable.ActionBar_subtitle);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        setSubtitle((CharSequence)localObject);
      }
      localObject = paramToolbar.getDrawable(R.styleable.ActionBar_logo);
      if (localObject != null) {
        setLogo((Drawable)localObject);
      }
      localObject = paramToolbar.getDrawable(R.styleable.ActionBar_icon);
      if (localObject != null) {
        setIcon((Drawable)localObject);
      }
      if (this.mNavIcon == null)
      {
        localObject = this.mDefaultNavigationIcon;
        if (localObject != null) {
          setNavigationIcon((Drawable)localObject);
        }
      }
      setDisplayOptions(paramToolbar.getInt(R.styleable.ActionBar_displayOptions, 0));
      paramInt2 = paramToolbar.getResourceId(R.styleable.ActionBar_customNavigationLayout, 0);
      if (paramInt2 != 0)
      {
        setCustomView(LayoutInflater.from(this.mToolbar.getContext()).inflate(paramInt2, this.mToolbar, false));
        setDisplayOptions(this.mDisplayOpts | 0x10);
      }
      paramInt2 = paramToolbar.getLayoutDimension(R.styleable.ActionBar_height, 0);
      if (paramInt2 > 0)
      {
        localObject = this.mToolbar.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = paramInt2;
        this.mToolbar.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      paramInt2 = paramToolbar.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetStart, -1);
      int i = paramToolbar.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetEnd, -1);
      if ((paramInt2 >= 0) || (i >= 0)) {
        this.mToolbar.setContentInsetsRelative(Math.max(paramInt2, 0), Math.max(i, 0));
      }
      paramInt2 = paramToolbar.getResourceId(R.styleable.ActionBar_titleTextStyle, 0);
      if (paramInt2 != 0)
      {
        localObject = this.mToolbar;
        ((Toolbar)localObject).setTitleTextAppearance(((Toolbar)localObject).getContext(), paramInt2);
      }
      paramInt2 = paramToolbar.getResourceId(R.styleable.ActionBar_subtitleTextStyle, 0);
      if (paramInt2 != 0)
      {
        localObject = this.mToolbar;
        ((Toolbar)localObject).setSubtitleTextAppearance(((Toolbar)localObject).getContext(), paramInt2);
      }
      paramInt2 = paramToolbar.getResourceId(R.styleable.ActionBar_popupTheme, 0);
      if (paramInt2 != 0) {
        this.mToolbar.setPopupTheme(paramInt2);
      }
    }
    else
    {
      this.mDisplayOpts = detectDisplayOptions();
    }
    paramToolbar.recycle();
    setDefaultNavigationContentDescription(paramInt1);
    this.mHomeDescription = this.mToolbar.getNavigationContentDescription();
    this.mToolbar.setNavigationOnClickListener(new View.OnClickListener()
    {
      final ActionMenuItem mNavItem = new ActionMenuItem(ToolbarWidgetWrapper.this.mToolbar.getContext(), 0, 16908332, 0, 0, ToolbarWidgetWrapper.this.mTitle);
      
      public void onClick(View paramAnonymousView)
      {
        if ((ToolbarWidgetWrapper.this.mWindowCallback != null) && (ToolbarWidgetWrapper.this.mMenuPrepared)) {
          ToolbarWidgetWrapper.this.mWindowCallback.onMenuItemSelected(0, this.mNavItem);
        }
      }
    });
  }
  
  private int detectDisplayOptions()
  {
    if (this.mToolbar.getNavigationIcon() != null)
    {
      this.mDefaultNavigationIcon = this.mToolbar.getNavigationIcon();
      return 15;
    }
    return 11;
  }
  
  private void ensureSpinner()
  {
    if (this.mSpinner == null)
    {
      this.mSpinner = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
      Toolbar.LayoutParams localLayoutParams = new Toolbar.LayoutParams(-2, -2, 8388627);
      this.mSpinner.setLayoutParams(localLayoutParams);
    }
  }
  
  private void setTitleInt(CharSequence paramCharSequence)
  {
    this.mTitle = paramCharSequence;
    if ((this.mDisplayOpts & 0x8) != 0) {
      this.mToolbar.setTitle(paramCharSequence);
    }
  }
  
  private void updateHomeAccessibility()
  {
    if ((this.mDisplayOpts & 0x4) != 0)
    {
      if (TextUtils.isEmpty(this.mHomeDescription))
      {
        this.mToolbar.setNavigationContentDescription(this.mDefaultNavigationContentDescription);
        return;
      }
      this.mToolbar.setNavigationContentDescription(this.mHomeDescription);
    }
  }
  
  private void updateNavigationIcon()
  {
    if ((this.mDisplayOpts & 0x4) != 0)
    {
      Toolbar localToolbar = this.mToolbar;
      Drawable localDrawable = this.mNavIcon;
      if (localDrawable == null) {
        localDrawable = this.mDefaultNavigationIcon;
      }
      localToolbar.setNavigationIcon(localDrawable);
      return;
    }
    this.mToolbar.setNavigationIcon(null);
  }
  
  private void updateToolbarLogo()
  {
    int i = this.mDisplayOpts;
    Drawable localDrawable;
    if ((i & 0x2) != 0)
    {
      if ((i & 0x1) != 0)
      {
        localDrawable = this.mLogo;
        if (localDrawable == null) {
          localDrawable = this.mIcon;
        }
      }
      else
      {
        localDrawable = this.mIcon;
      }
    }
    else {
      localDrawable = null;
    }
    this.mToolbar.setLogo(localDrawable);
  }
  
  public void animateToVisibility(int paramInt)
  {
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = setupAnimatorToVisibility(paramInt, 200L);
    if (localViewPropertyAnimatorCompat != null) {
      localViewPropertyAnimatorCompat.start();
    }
  }
  
  public boolean canShowOverflowMenu()
  {
    return this.mToolbar.canShowOverflowMenu();
  }
  
  public void collapseActionView()
  {
    this.mToolbar.collapseActionView();
  }
  
  public void dismissPopupMenus()
  {
    this.mToolbar.dismissPopupMenus();
  }
  
  public Context getContext()
  {
    return this.mToolbar.getContext();
  }
  
  public View getCustomView()
  {
    return this.mCustomView;
  }
  
  public int getDisplayOptions()
  {
    return this.mDisplayOpts;
  }
  
  public int getDropdownItemCount()
  {
    Spinner localSpinner = this.mSpinner;
    if (localSpinner != null) {
      return localSpinner.getCount();
    }
    return 0;
  }
  
  public int getDropdownSelectedPosition()
  {
    Spinner localSpinner = this.mSpinner;
    if (localSpinner != null) {
      return localSpinner.getSelectedItemPosition();
    }
    return 0;
  }
  
  public int getHeight()
  {
    return this.mToolbar.getHeight();
  }
  
  public Menu getMenu()
  {
    return this.mToolbar.getMenu();
  }
  
  public int getNavigationMode()
  {
    return this.mNavigationMode;
  }
  
  public CharSequence getSubtitle()
  {
    return this.mToolbar.getSubtitle();
  }
  
  public CharSequence getTitle()
  {
    return this.mToolbar.getTitle();
  }
  
  public ViewGroup getViewGroup()
  {
    return this.mToolbar;
  }
  
  public int getVisibility()
  {
    return this.mToolbar.getVisibility();
  }
  
  public boolean hasEmbeddedTabs()
  {
    return this.mTabView != null;
  }
  
  public boolean hasExpandedActionView()
  {
    return this.mToolbar.hasExpandedActionView();
  }
  
  public boolean hasIcon()
  {
    return this.mIcon != null;
  }
  
  public boolean hasLogo()
  {
    return this.mLogo != null;
  }
  
  public boolean hideOverflowMenu()
  {
    return this.mToolbar.hideOverflowMenu();
  }
  
  public void initIndeterminateProgress()
  {
    Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
  }
  
  public void initProgress()
  {
    Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
  }
  
  public boolean isOverflowMenuShowPending()
  {
    return this.mToolbar.isOverflowMenuShowPending();
  }
  
  public boolean isOverflowMenuShowing()
  {
    return this.mToolbar.isOverflowMenuShowing();
  }
  
  public boolean isTitleTruncated()
  {
    return this.mToolbar.isTitleTruncated();
  }
  
  public void restoreHierarchyState(SparseArray<Parcelable> paramSparseArray)
  {
    this.mToolbar.restoreHierarchyState(paramSparseArray);
  }
  
  public void saveHierarchyState(SparseArray<Parcelable> paramSparseArray)
  {
    this.mToolbar.saveHierarchyState(paramSparseArray);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    ViewCompat.setBackground(this.mToolbar, paramDrawable);
  }
  
  public void setCollapsible(boolean paramBoolean)
  {
    this.mToolbar.setCollapsible(paramBoolean);
  }
  
  public void setCustomView(View paramView)
  {
    View localView = this.mCustomView;
    if ((localView != null) && ((this.mDisplayOpts & 0x10) != 0)) {
      this.mToolbar.removeView(localView);
    }
    this.mCustomView = paramView;
    if ((paramView != null) && ((this.mDisplayOpts & 0x10) != 0)) {
      this.mToolbar.addView(this.mCustomView);
    }
  }
  
  public void setDefaultNavigationContentDescription(int paramInt)
  {
    if (paramInt == this.mDefaultNavigationContentDescription) {
      return;
    }
    this.mDefaultNavigationContentDescription = paramInt;
    if (TextUtils.isEmpty(this.mToolbar.getNavigationContentDescription())) {
      setNavigationContentDescription(this.mDefaultNavigationContentDescription);
    }
  }
  
  public void setDefaultNavigationIcon(Drawable paramDrawable)
  {
    if (this.mDefaultNavigationIcon != paramDrawable)
    {
      this.mDefaultNavigationIcon = paramDrawable;
      updateNavigationIcon();
    }
  }
  
  public void setDisplayOptions(int paramInt)
  {
    int i = this.mDisplayOpts ^ paramInt;
    this.mDisplayOpts = paramInt;
    if (i != 0)
    {
      if ((i & 0x4) != 0)
      {
        if ((paramInt & 0x4) != 0) {
          updateHomeAccessibility();
        }
        updateNavigationIcon();
      }
      if ((i & 0x3) != 0) {
        updateToolbarLogo();
      }
      if ((i & 0x8) != 0) {
        if ((paramInt & 0x8) != 0)
        {
          this.mToolbar.setTitle(this.mTitle);
          this.mToolbar.setSubtitle(this.mSubtitle);
        }
        else
        {
          this.mToolbar.setTitle(null);
          this.mToolbar.setSubtitle(null);
        }
      }
      if ((i & 0x10) != 0)
      {
        View localView = this.mCustomView;
        if (localView != null)
        {
          if ((paramInt & 0x10) != 0)
          {
            this.mToolbar.addView(localView);
            return;
          }
          this.mToolbar.removeView(localView);
        }
      }
    }
  }
  
  public void setDropdownParams(SpinnerAdapter paramSpinnerAdapter, AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    ensureSpinner();
    this.mSpinner.setAdapter(paramSpinnerAdapter);
    this.mSpinner.setOnItemSelectedListener(paramOnItemSelectedListener);
  }
  
  public void setDropdownSelectedPosition(int paramInt)
  {
    Spinner localSpinner = this.mSpinner;
    if (localSpinner != null)
    {
      localSpinner.setSelection(paramInt);
      return;
    }
    throw new IllegalStateException("Can't set dropdown selected position without an adapter");
  }
  
  public void setEmbeddedTabView(ScrollingTabContainerView paramScrollingTabContainerView)
  {
    Object localObject = this.mTabView;
    if (localObject != null)
    {
      localObject = ((View)localObject).getParent();
      Toolbar localToolbar = this.mToolbar;
      if (localObject == localToolbar) {
        localToolbar.removeView(this.mTabView);
      }
    }
    this.mTabView = paramScrollingTabContainerView;
    if ((paramScrollingTabContainerView != null) && (this.mNavigationMode == 2))
    {
      this.mToolbar.addView(this.mTabView, 0);
      localObject = (Toolbar.LayoutParams)this.mTabView.getLayoutParams();
      ((Toolbar.LayoutParams)localObject).width = -2;
      ((Toolbar.LayoutParams)localObject).height = -2;
      ((Toolbar.LayoutParams)localObject).gravity = 8388691;
      paramScrollingTabContainerView.setAllowCollapse(true);
    }
  }
  
  public void setHomeButtonEnabled(boolean paramBoolean) {}
  
  public void setIcon(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = AppCompatResources.getDrawable(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setIcon(localDrawable);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.mIcon = paramDrawable;
    updateToolbarLogo();
  }
  
  public void setLogo(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = AppCompatResources.getDrawable(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setLogo(localDrawable);
  }
  
  public void setLogo(Drawable paramDrawable)
  {
    this.mLogo = paramDrawable;
    updateToolbarLogo();
  }
  
  public void setMenu(Menu paramMenu, MenuPresenter.Callback paramCallback)
  {
    if (this.mActionMenuPresenter == null)
    {
      this.mActionMenuPresenter = new ActionMenuPresenter(this.mToolbar.getContext());
      this.mActionMenuPresenter.setId(R.id.action_menu_presenter);
    }
    this.mActionMenuPresenter.setCallback(paramCallback);
    this.mToolbar.setMenu((MenuBuilder)paramMenu, this.mActionMenuPresenter);
  }
  
  public void setMenuCallbacks(MenuPresenter.Callback paramCallback, MenuBuilder.Callback paramCallback1)
  {
    this.mToolbar.setMenuCallbacks(paramCallback, paramCallback1);
  }
  
  public void setMenuPrepared()
  {
    this.mMenuPrepared = true;
  }
  
  public void setNavigationContentDescription(int paramInt)
  {
    String str;
    if (paramInt == 0) {
      str = null;
    } else {
      str = getContext().getString(paramInt);
    }
    setNavigationContentDescription(str);
  }
  
  public void setNavigationContentDescription(CharSequence paramCharSequence)
  {
    this.mHomeDescription = paramCharSequence;
    updateHomeAccessibility();
  }
  
  public void setNavigationIcon(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = AppCompatResources.getDrawable(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setNavigationIcon(localDrawable);
  }
  
  public void setNavigationIcon(Drawable paramDrawable)
  {
    this.mNavIcon = paramDrawable;
    updateNavigationIcon();
  }
  
  public void setNavigationMode(int paramInt)
  {
    int i = this.mNavigationMode;
    if (paramInt != i)
    {
      Object localObject;
      Toolbar localToolbar;
      switch (i)
      {
      default: 
        break;
      case 2: 
        localObject = this.mTabView;
        if (localObject != null)
        {
          localObject = ((View)localObject).getParent();
          localToolbar = this.mToolbar;
          if (localObject == localToolbar) {
            localToolbar.removeView(this.mTabView);
          }
        }
        break;
      case 1: 
        localObject = this.mSpinner;
        if (localObject != null)
        {
          localObject = ((Spinner)localObject).getParent();
          localToolbar = this.mToolbar;
          if (localObject == localToolbar) {
            localToolbar.removeView(this.mSpinner);
          }
        }
        break;
      }
      this.mNavigationMode = paramInt;
      switch (paramInt)
      {
      default: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Invalid navigation mode ");
        ((StringBuilder)localObject).append(paramInt);
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      case 2: 
        localObject = this.mTabView;
        if (localObject != null)
        {
          this.mToolbar.addView((View)localObject, 0);
          localObject = (Toolbar.LayoutParams)this.mTabView.getLayoutParams();
          ((Toolbar.LayoutParams)localObject).width = -2;
          ((Toolbar.LayoutParams)localObject).height = -2;
          ((Toolbar.LayoutParams)localObject).gravity = 8388691;
          return;
        }
        break;
      case 1: 
        ensureSpinner();
        this.mToolbar.addView(this.mSpinner, 0);
      }
    }
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.mSubtitle = paramCharSequence;
    if ((this.mDisplayOpts & 0x8) != 0) {
      this.mToolbar.setSubtitle(paramCharSequence);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.mTitleSet = true;
    setTitleInt(paramCharSequence);
  }
  
  public void setVisibility(int paramInt)
  {
    this.mToolbar.setVisibility(paramInt);
  }
  
  public void setWindowCallback(Window.Callback paramCallback)
  {
    this.mWindowCallback = paramCallback;
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    if (!this.mTitleSet) {
      setTitleInt(paramCharSequence);
    }
  }
  
  public ViewPropertyAnimatorCompat setupAnimatorToVisibility(final int paramInt, long paramLong)
  {
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.animate(this.mToolbar);
    float f;
    if (paramInt == 0) {
      f = 1.0F;
    } else {
      f = 0.0F;
    }
    localViewPropertyAnimatorCompat.alpha(f).setDuration(paramLong).setListener(new ViewPropertyAnimatorListenerAdapter()
    {
      private boolean mCanceled = false;
      
      public void onAnimationCancel(View paramAnonymousView)
      {
        this.mCanceled = true;
      }
      
      public void onAnimationEnd(View paramAnonymousView)
      {
        if (!this.mCanceled) {
          ToolbarWidgetWrapper.this.mToolbar.setVisibility(paramInt);
        }
      }
      
      public void onAnimationStart(View paramAnonymousView)
      {
        ToolbarWidgetWrapper.this.mToolbar.setVisibility(0);
      }
    });
  }
  
  public boolean showOverflowMenu()
  {
    return this.mToolbar.showOverflowMenu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ToolbarWidgetWrapper
 * JD-Core Version:    0.7.0.1
 */