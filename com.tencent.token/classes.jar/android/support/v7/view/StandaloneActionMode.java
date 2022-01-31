package android.support.v7.view;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class StandaloneActionMode
  extends ActionMode
  implements MenuBuilder.Callback
{
  private ActionMode.Callback mCallback;
  private Context mContext;
  private ActionBarContextView mContextView;
  private WeakReference mCustomView;
  private boolean mFinished;
  private boolean mFocusable;
  private MenuBuilder mMenu;
  
  public StandaloneActionMode(Context paramContext, ActionBarContextView paramActionBarContextView, ActionMode.Callback paramCallback, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.mContextView = paramActionBarContextView;
    this.mCallback = paramCallback;
    this.mMenu = new MenuBuilder(paramActionBarContextView.getContext()).setDefaultShowAsAction(1);
    this.mMenu.setCallback(this);
    this.mFocusable = paramBoolean;
  }
  
  public void finish()
  {
    if (this.mFinished) {
      return;
    }
    this.mFinished = true;
    this.mContextView.sendAccessibilityEvent(32);
    this.mCallback.onDestroyActionMode(this);
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
    return new SupportMenuInflater(this.mContextView.getContext());
  }
  
  public CharSequence getSubtitle()
  {
    return this.mContextView.getSubtitle();
  }
  
  public CharSequence getTitle()
  {
    return this.mContextView.getTitle();
  }
  
  public void invalidate()
  {
    this.mCallback.onPrepareActionMode(this, this.mMenu);
  }
  
  public boolean isTitleOptional()
  {
    return this.mContextView.isTitleOptional();
  }
  
  public boolean isUiFocusable()
  {
    return this.mFocusable;
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {}
  
  public void onCloseSubMenu(SubMenuBuilder paramSubMenuBuilder) {}
  
  public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    return this.mCallback.onActionItemClicked(this, paramMenuItem);
  }
  
  public void onMenuModeChange(MenuBuilder paramMenuBuilder)
  {
    invalidate();
    this.mContextView.showOverflowMenu();
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    if (!paramSubMenuBuilder.hasVisibleItems()) {
      return true;
    }
    new MenuPopupHelper(this.mContextView.getContext(), paramSubMenuBuilder).show();
    return true;
  }
  
  public void setCustomView(View paramView)
  {
    this.mContextView.setCustomView(paramView);
    if (paramView != null) {}
    for (paramView = new WeakReference(paramView);; paramView = null)
    {
      this.mCustomView = paramView;
      return;
    }
  }
  
  public void setSubtitle(int paramInt)
  {
    setSubtitle(this.mContext.getString(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.mContextView.setSubtitle(paramCharSequence);
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(this.mContext.getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.mContextView.setTitle(paramCharSequence);
  }
  
  public void setTitleOptionalHint(boolean paramBoolean)
  {
    super.setTitleOptionalHint(paramBoolean);
    this.mContextView.setTitleOptional(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.view.StandaloneActionMode
 * JD-Core Version:    0.7.0.1
 */