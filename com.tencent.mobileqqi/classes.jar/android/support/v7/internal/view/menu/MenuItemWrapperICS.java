package android.support.v7.internal.view.menu;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.support.v7.view.CollapsibleActionView;
import android.util.Log;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Method;

public class MenuItemWrapperICS
  extends BaseMenuWrapper
  implements SupportMenuItem
{
  static final String LOG_TAG = "MenuItemWrapper";
  private final boolean mEmulateProviderVisibilityOverride;
  private boolean mLastRequestVisible;
  private Method mSetExclusiveCheckableMethod;
  
  MenuItemWrapperICS(MenuItem paramMenuItem)
  {
    this(paramMenuItem, true);
  }
  
  MenuItemWrapperICS(MenuItem paramMenuItem, boolean paramBoolean)
  {
    super(paramMenuItem);
    this.mLastRequestVisible = paramMenuItem.isVisible();
    this.mEmulateProviderVisibilityOverride = paramBoolean;
  }
  
  final boolean checkActionProviderOverrideVisibility()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mLastRequestVisible)
    {
      android.support.v4.view.ActionProvider localActionProvider = getSupportActionProvider();
      bool1 = bool2;
      if (localActionProvider != null)
      {
        bool1 = bool2;
        if (localActionProvider.overridesItemVisibility())
        {
          bool1 = bool2;
          if (!localActionProvider.isVisible())
          {
            wrappedSetVisible(false);
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean collapseActionView()
  {
    return ((MenuItem)this.mWrappedObject).collapseActionView();
  }
  
  MenuItemWrapperICS.ActionProviderWrapper createActionProviderWrapper(android.support.v4.view.ActionProvider paramActionProvider)
  {
    return new MenuItemWrapperICS.ActionProviderWrapper(this, paramActionProvider);
  }
  
  public boolean expandActionView()
  {
    return ((MenuItem)this.mWrappedObject).expandActionView();
  }
  
  public android.view.ActionProvider getActionProvider()
  {
    return ((MenuItem)this.mWrappedObject).getActionProvider();
  }
  
  public View getActionView()
  {
    View localView2 = ((MenuItem)this.mWrappedObject).getActionView();
    View localView1 = localView2;
    if ((localView2 instanceof MenuItemWrapperICS.CollapsibleActionViewWrapper)) {
      localView1 = ((MenuItemWrapperICS.CollapsibleActionViewWrapper)localView2).getWrappedView();
    }
    return localView1;
  }
  
  public char getAlphabeticShortcut()
  {
    return ((MenuItem)this.mWrappedObject).getAlphabeticShortcut();
  }
  
  public int getGroupId()
  {
    return ((MenuItem)this.mWrappedObject).getGroupId();
  }
  
  public Drawable getIcon()
  {
    return ((MenuItem)this.mWrappedObject).getIcon();
  }
  
  public Intent getIntent()
  {
    return ((MenuItem)this.mWrappedObject).getIntent();
  }
  
  public int getItemId()
  {
    return ((MenuItem)this.mWrappedObject).getItemId();
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return ((MenuItem)this.mWrappedObject).getMenuInfo();
  }
  
  public char getNumericShortcut()
  {
    return ((MenuItem)this.mWrappedObject).getNumericShortcut();
  }
  
  public int getOrder()
  {
    return ((MenuItem)this.mWrappedObject).getOrder();
  }
  
  public SubMenu getSubMenu()
  {
    return getSubMenuWrapper(((MenuItem)this.mWrappedObject).getSubMenu());
  }
  
  public android.support.v4.view.ActionProvider getSupportActionProvider()
  {
    MenuItemWrapperICS.ActionProviderWrapper localActionProviderWrapper = (MenuItemWrapperICS.ActionProviderWrapper)((MenuItem)this.mWrappedObject).getActionProvider();
    if (localActionProviderWrapper != null) {
      return localActionProviderWrapper.mInner;
    }
    return null;
  }
  
  public CharSequence getTitle()
  {
    return ((MenuItem)this.mWrappedObject).getTitle();
  }
  
  public CharSequence getTitleCondensed()
  {
    return ((MenuItem)this.mWrappedObject).getTitleCondensed();
  }
  
  public boolean hasSubMenu()
  {
    return ((MenuItem)this.mWrappedObject).hasSubMenu();
  }
  
  public boolean isActionViewExpanded()
  {
    return ((MenuItem)this.mWrappedObject).isActionViewExpanded();
  }
  
  public boolean isCheckable()
  {
    return ((MenuItem)this.mWrappedObject).isCheckable();
  }
  
  public boolean isChecked()
  {
    return ((MenuItem)this.mWrappedObject).isChecked();
  }
  
  public boolean isEnabled()
  {
    return ((MenuItem)this.mWrappedObject).isEnabled();
  }
  
  public boolean isVisible()
  {
    return ((MenuItem)this.mWrappedObject).isVisible();
  }
  
  public MenuItem setActionProvider(android.view.ActionProvider paramActionProvider)
  {
    ((MenuItem)this.mWrappedObject).setActionProvider(paramActionProvider);
    if ((paramActionProvider != null) && (this.mEmulateProviderVisibilityOverride)) {
      checkActionProviderOverrideVisibility();
    }
    return this;
  }
  
  public MenuItem setActionView(int paramInt)
  {
    ((MenuItem)this.mWrappedObject).setActionView(paramInt);
    View localView = ((MenuItem)this.mWrappedObject).getActionView();
    if ((localView instanceof CollapsibleActionView)) {
      ((MenuItem)this.mWrappedObject).setActionView(new MenuItemWrapperICS.CollapsibleActionViewWrapper(localView));
    }
    return this;
  }
  
  public MenuItem setActionView(View paramView)
  {
    Object localObject = paramView;
    if ((paramView instanceof CollapsibleActionView)) {
      localObject = new MenuItemWrapperICS.CollapsibleActionViewWrapper(paramView);
    }
    ((MenuItem)this.mWrappedObject).setActionView((View)localObject);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    ((MenuItem)this.mWrappedObject).setAlphabeticShortcut(paramChar);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    ((MenuItem)this.mWrappedObject).setCheckable(paramBoolean);
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    ((MenuItem)this.mWrappedObject).setChecked(paramBoolean);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    ((MenuItem)this.mWrappedObject).setEnabled(paramBoolean);
    return this;
  }
  
  public void setExclusiveCheckable(boolean paramBoolean)
  {
    try
    {
      if (this.mSetExclusiveCheckableMethod == null) {
        this.mSetExclusiveCheckableMethod = ((MenuItem)this.mWrappedObject).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[] { Boolean.TYPE });
      }
      this.mSetExclusiveCheckableMethod.invoke(this.mWrappedObject, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception localException)
    {
      Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", localException);
    }
  }
  
  public MenuItem setIcon(int paramInt)
  {
    ((MenuItem)this.mWrappedObject).setIcon(paramInt);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    ((MenuItem)this.mWrappedObject).setIcon(paramDrawable);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    ((MenuItem)this.mWrappedObject).setIntent(paramIntent);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    ((MenuItem)this.mWrappedObject).setNumericShortcut(paramChar);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    ((MenuItem)this.mWrappedObject).setOnActionExpandListener(paramOnActionExpandListener);
    return this;
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    MenuItem localMenuItem = (MenuItem)this.mWrappedObject;
    if (paramOnMenuItemClickListener != null) {}
    for (paramOnMenuItemClickListener = new MenuItemWrapperICS.OnMenuItemClickListenerWrapper(this, paramOnMenuItemClickListener);; paramOnMenuItemClickListener = null)
    {
      localMenuItem.setOnMenuItemClickListener(paramOnMenuItemClickListener);
      return this;
    }
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    ((MenuItem)this.mWrappedObject).setShortcut(paramChar1, paramChar2);
    return this;
  }
  
  public void setShowAsAction(int paramInt)
  {
    ((MenuItem)this.mWrappedObject).setShowAsAction(paramInt);
  }
  
  public MenuItem setShowAsActionFlags(int paramInt)
  {
    ((MenuItem)this.mWrappedObject).setShowAsActionFlags(paramInt);
    return this;
  }
  
  public SupportMenuItem setSupportActionProvider(android.support.v4.view.ActionProvider paramActionProvider)
  {
    MenuItem localMenuItem = (MenuItem)this.mWrappedObject;
    if (paramActionProvider != null) {}
    for (paramActionProvider = createActionProviderWrapper(paramActionProvider);; paramActionProvider = null)
    {
      localMenuItem.setActionProvider(paramActionProvider);
      return this;
    }
  }
  
  public SupportMenuItem setSupportOnActionExpandListener(MenuItemCompat.OnActionExpandListener paramOnActionExpandListener)
  {
    MenuItem localMenuItem = (MenuItem)this.mWrappedObject;
    if (paramOnActionExpandListener != null) {}
    for (paramOnActionExpandListener = new MenuItemWrapperICS.OnActionExpandListenerWrapper(this, paramOnActionExpandListener);; paramOnActionExpandListener = null)
    {
      localMenuItem.setOnActionExpandListener(paramOnActionExpandListener);
      return null;
    }
  }
  
  public MenuItem setTitle(int paramInt)
  {
    ((MenuItem)this.mWrappedObject).setTitle(paramInt);
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    ((MenuItem)this.mWrappedObject).setTitle(paramCharSequence);
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    ((MenuItem)this.mWrappedObject).setTitleCondensed(paramCharSequence);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    if (this.mEmulateProviderVisibilityOverride)
    {
      this.mLastRequestVisible = paramBoolean;
      if (checkActionProviderOverrideVisibility()) {
        return this;
      }
    }
    return wrappedSetVisible(paramBoolean);
  }
  
  final MenuItem wrappedSetVisible(boolean paramBoolean)
  {
    return ((MenuItem)this.mWrappedObject).setVisible(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuItemWrapperICS
 * JD-Core Version:    0.7.0.1
 */