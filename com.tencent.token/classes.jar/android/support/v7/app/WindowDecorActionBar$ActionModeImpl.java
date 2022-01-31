package android.support.v7.app;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.RestrictTo;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.DecorToolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class WindowDecorActionBar$ActionModeImpl
  extends ActionMode
  implements MenuBuilder.Callback
{
  private final Context mActionModeContext;
  private ActionMode.Callback mCallback;
  private WeakReference mCustomView;
  private final MenuBuilder mMenu;
  
  public WindowDecorActionBar$ActionModeImpl(WindowDecorActionBar paramWindowDecorActionBar, Context paramContext, ActionMode.Callback paramCallback)
  {
    this.mActionModeContext = paramContext;
    this.mCallback = paramCallback;
    this.mMenu = new MenuBuilder(paramContext).setDefaultShowAsAction(1);
    this.mMenu.setCallback(this);
  }
  
  public boolean dispatchOnCreate()
  {
    this.mMenu.stopDispatchingItemsChanged();
    try
    {
      boolean bool = this.mCallback.onCreateActionMode(this, this.mMenu);
      return bool;
    }
    finally
    {
      this.mMenu.startDispatchingItemsChanged();
    }
  }
  
  public void finish()
  {
    if (this.this$0.mActionMode != this) {
      return;
    }
    if (!WindowDecorActionBar.checkShowingFlags(this.this$0.mHiddenByApp, this.this$0.mHiddenBySystem, false))
    {
      this.this$0.mDeferredDestroyActionMode = this;
      this.this$0.mDeferredModeDestroyCallback = this.mCallback;
    }
    for (;;)
    {
      this.mCallback = null;
      this.this$0.animateToMode(false);
      this.this$0.mContextView.closeMode();
      this.this$0.mDecorToolbar.getViewGroup().sendAccessibilityEvent(32);
      this.this$0.mOverlayLayout.setHideOnContentScrollEnabled(this.this$0.mHideOnContentScroll);
      this.this$0.mActionMode = null;
      return;
      this.mCallback.onDestroyActionMode(this);
    }
  }
  
  public View getCustomView()
  {
    if (this.mCustomView != null) {
      return (View)this.mCustomView.get();
    }
    return null;
  }
  
  public Menu getMenu()
  {
    return this.mMenu;
  }
  
  public MenuInflater getMenuInflater()
  {
    return new SupportMenuInflater(this.mActionModeContext);
  }
  
  public CharSequence getSubtitle()
  {
    return this.this$0.mContextView.getSubtitle();
  }
  
  public CharSequence getTitle()
  {
    return this.this$0.mContextView.getTitle();
  }
  
  public void invalidate()
  {
    if (this.this$0.mActionMode != this) {
      return;
    }
    this.mMenu.stopDispatchingItemsChanged();
    try
    {
      this.mCallback.onPrepareActionMode(this, this.mMenu);
      return;
    }
    finally
    {
      this.mMenu.startDispatchingItemsChanged();
    }
  }
  
  public boolean isTitleOptional()
  {
    return this.this$0.mContextView.isTitleOptional();
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {}
  
  public void onCloseSubMenu(SubMenuBuilder paramSubMenuBuilder) {}
  
  public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    if (this.mCallback != null) {
      return this.mCallback.onActionItemClicked(this, paramMenuItem);
    }
    return false;
  }
  
  public void onMenuModeChange(MenuBuilder paramMenuBuilder)
  {
    if (this.mCallback == null) {
      return;
    }
    invalidate();
    this.this$0.mContextView.showOverflowMenu();
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    boolean bool = true;
    if (this.mCallback == null) {
      bool = false;
    }
    while (!paramSubMenuBuilder.hasVisibleItems()) {
      return bool;
    }
    new MenuPopupHelper(this.this$0.getThemedContext(), paramSubMenuBuilder).show();
    return true;
  }
  
  public void setCustomView(View paramView)
  {
    this.this$0.mContextView.setCustomView(paramView);
    this.mCustomView = new WeakReference(paramView);
  }
  
  public void setSubtitle(int paramInt)
  {
    setSubtitle(this.this$0.mContext.getResources().getString(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.this$0.mContextView.setSubtitle(paramCharSequence);
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(this.this$0.mContext.getResources().getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.this$0.mContextView.setTitle(paramCharSequence);
  }
  
  public void setTitleOptionalHint(boolean paramBoolean)
  {
    super.setTitleOptionalHint(paramBoolean);
    this.this$0.mContextView.setTitleOptional(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.WindowDecorActionBar.ActionModeImpl
 * JD-Core Version:    0.7.0.1
 */