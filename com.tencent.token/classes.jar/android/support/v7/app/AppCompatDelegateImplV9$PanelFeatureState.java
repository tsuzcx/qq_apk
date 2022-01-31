package android.support.v7.app;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.style;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.view.menu.ListMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.view.menu.MenuView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

public final class AppCompatDelegateImplV9$PanelFeatureState
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
  
  AppCompatDelegateImplV9$PanelFeatureState(int paramInt)
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
      this.listMenuPresenter = new ListMenuPresenter(this.listPresenterContext, R.layout.abc_list_menu_item_layout);
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
    paramParcelable = (AppCompatDelegateImplV9.PanelFeatureState.SavedState)paramParcelable;
    this.featureId = paramParcelable.featureId;
    this.wasLastOpen = paramParcelable.isOpen;
    this.frozenMenuState = paramParcelable.menuState;
    this.shownPanelView = null;
    this.decorView = null;
  }
  
  Parcelable onSaveInstanceState()
  {
    AppCompatDelegateImplV9.PanelFeatureState.SavedState localSavedState = new AppCompatDelegateImplV9.PanelFeatureState.SavedState();
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
    localTheme.resolveAttribute(R.attr.actionBarPopupTheme, localTypedValue, true);
    if (localTypedValue.resourceId != 0) {
      localTheme.applyStyle(localTypedValue.resourceId, true);
    }
    localTheme.resolveAttribute(R.attr.panelMenuListTheme, localTypedValue, true);
    if (localTypedValue.resourceId != 0) {
      localTheme.applyStyle(localTypedValue.resourceId, true);
    }
    for (;;)
    {
      paramContext = new ContextThemeWrapper(paramContext, 0);
      paramContext.getTheme().setTo(localTheme);
      this.listPresenterContext = paramContext;
      paramContext = paramContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
      this.background = paramContext.getResourceId(R.styleable.AppCompatTheme_panelBackground, 0);
      this.windowAnimations = paramContext.getResourceId(R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
      paramContext.recycle();
      return;
      localTheme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState
 * JD-Core Version:    0.7.0.1
 */