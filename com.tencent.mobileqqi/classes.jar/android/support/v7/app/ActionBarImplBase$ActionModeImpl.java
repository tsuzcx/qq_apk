package android.support.v7.app;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.internal.view.SupportMenuInflater;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuBuilder.Callback;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarView;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

class ActionBarImplBase$ActionModeImpl
  extends ActionMode
  implements MenuBuilder.Callback
{
  private ActionMode.Callback mCallback;
  private WeakReference mCustomView;
  private MenuBuilder mMenu;
  
  public ActionBarImplBase$ActionModeImpl(ActionBarImplBase paramActionBarImplBase, ActionMode.Callback paramCallback)
  {
    this.mCallback = paramCallback;
    this.mMenu = new MenuBuilder(paramActionBarImplBase.getThemedContext()).setDefaultShowAsAction(1);
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
    if (!ActionBarImplBase.access$400(ActionBarImplBase.access$200(this.this$0), ActionBarImplBase.access$300(this.this$0), false))
    {
      this.this$0.mDeferredDestroyActionMode = this;
      this.this$0.mDeferredModeDestroyCallback = this.mCallback;
    }
    for (;;)
    {
      this.mCallback = null;
      this.this$0.animateToMode(false);
      ActionBarImplBase.access$500(this.this$0).closeMode();
      ActionBarImplBase.access$600(this.this$0).sendAccessibilityEvent(32);
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
    return new SupportMenuInflater(this.this$0.getThemedContext());
  }
  
  public CharSequence getSubtitle()
  {
    return ActionBarImplBase.access$500(this.this$0).getSubtitle();
  }
  
  public CharSequence getTitle()
  {
    return ActionBarImplBase.access$500(this.this$0).getTitle();
  }
  
  public void invalidate()
  {
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
    return ActionBarImplBase.access$500(this.this$0).isTitleOptional();
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
    ActionBarImplBase.access$500(this.this$0).showOverflowMenu();
  }
  
  public void onMenuModeChange(Menu paramMenu)
  {
    if (this.mCallback == null) {
      return;
    }
    invalidate();
    ActionBarImplBase.access$500(this.this$0).showOverflowMenu();
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    boolean bool = true;
    if (this.mCallback == null) {
      bool = false;
    }
    while (paramSubMenuBuilder.hasVisibleItems()) {
      return bool;
    }
    return true;
  }
  
  public void setCustomView(View paramView)
  {
    ActionBarImplBase.access$500(this.this$0).setCustomView(paramView);
    this.mCustomView = new WeakReference(paramView);
  }
  
  public void setSubtitle(int paramInt)
  {
    setSubtitle(ActionBarImplBase.access$100(this.this$0).getResources().getString(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    ActionBarImplBase.access$500(this.this$0).setSubtitle(paramCharSequence);
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(ActionBarImplBase.access$100(this.this$0).getResources().getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    ActionBarImplBase.access$500(this.this$0).setTitle(paramCharSequence);
  }
  
  public void setTitleOptionalHint(boolean paramBoolean)
  {
    super.setTitleOptionalHint(paramBoolean);
    ActionBarImplBase.access$500(this.this$0).setTitleOptional(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.app.ActionBarImplBase.ActionModeImpl
 * JD-Core Version:    0.7.0.1
 */