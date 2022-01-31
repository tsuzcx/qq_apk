package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.v4.internal.view.SupportMenuItem;
import android.util.Log;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Method;

@RequiresApi(14)
@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class MenuItemWrapperICS
  extends BaseMenuWrapper
  implements MenuItem
{
  static final String LOG_TAG = "MenuItemWrapper";
  private Method mSetExclusiveCheckableMethod;
  
  MenuItemWrapperICS(Context paramContext, SupportMenuItem paramSupportMenuItem)
  {
    super(paramContext, paramSupportMenuItem);
  }
  
  public boolean collapseActionView()
  {
    return ((SupportMenuItem)this.mWrappedObject).collapseActionView();
  }
  
  MenuItemWrapperICS.ActionProviderWrapper createActionProviderWrapper(android.view.ActionProvider paramActionProvider)
  {
    return new MenuItemWrapperICS.ActionProviderWrapper(this, this.mContext, paramActionProvider);
  }
  
  public boolean expandActionView()
  {
    return ((SupportMenuItem)this.mWrappedObject).expandActionView();
  }
  
  public android.view.ActionProvider getActionProvider()
  {
    android.support.v4.view.ActionProvider localActionProvider = ((SupportMenuItem)this.mWrappedObject).getSupportActionProvider();
    if ((localActionProvider instanceof MenuItemWrapperICS.ActionProviderWrapper)) {
      return ((MenuItemWrapperICS.ActionProviderWrapper)localActionProvider).mInner;
    }
    return null;
  }
  
  public View getActionView()
  {
    View localView2 = ((SupportMenuItem)this.mWrappedObject).getActionView();
    View localView1 = localView2;
    if ((localView2 instanceof MenuItemWrapperICS.CollapsibleActionViewWrapper)) {
      localView1 = ((MenuItemWrapperICS.CollapsibleActionViewWrapper)localView2).getWrappedView();
    }
    return localView1;
  }
  
  public int getAlphabeticModifiers()
  {
    return ((SupportMenuItem)this.mWrappedObject).getAlphabeticModifiers();
  }
  
  public char getAlphabeticShortcut()
  {
    return ((SupportMenuItem)this.mWrappedObject).getAlphabeticShortcut();
  }
  
  public CharSequence getContentDescription()
  {
    return ((SupportMenuItem)this.mWrappedObject).getContentDescription();
  }
  
  public int getGroupId()
  {
    return ((SupportMenuItem)this.mWrappedObject).getGroupId();
  }
  
  public Drawable getIcon()
  {
    return ((SupportMenuItem)this.mWrappedObject).getIcon();
  }
  
  public ColorStateList getIconTintList()
  {
    return ((SupportMenuItem)this.mWrappedObject).getIconTintList();
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return ((SupportMenuItem)this.mWrappedObject).getIconTintMode();
  }
  
  public Intent getIntent()
  {
    return ((SupportMenuItem)this.mWrappedObject).getIntent();
  }
  
  public int getItemId()
  {
    return ((SupportMenuItem)this.mWrappedObject).getItemId();
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return ((SupportMenuItem)this.mWrappedObject).getMenuInfo();
  }
  
  public int getNumericModifiers()
  {
    return ((SupportMenuItem)this.mWrappedObject).getNumericModifiers();
  }
  
  public char getNumericShortcut()
  {
    return ((SupportMenuItem)this.mWrappedObject).getNumericShortcut();
  }
  
  public int getOrder()
  {
    return ((SupportMenuItem)this.mWrappedObject).getOrder();
  }
  
  public SubMenu getSubMenu()
  {
    return getSubMenuWrapper(((SupportMenuItem)this.mWrappedObject).getSubMenu());
  }
  
  public CharSequence getTitle()
  {
    return ((SupportMenuItem)this.mWrappedObject).getTitle();
  }
  
  public CharSequence getTitleCondensed()
  {
    return ((SupportMenuItem)this.mWrappedObject).getTitleCondensed();
  }
  
  public CharSequence getTooltipText()
  {
    return ((SupportMenuItem)this.mWrappedObject).getTooltipText();
  }
  
  public boolean hasSubMenu()
  {
    return ((SupportMenuItem)this.mWrappedObject).hasSubMenu();
  }
  
  public boolean isActionViewExpanded()
  {
    return ((SupportMenuItem)this.mWrappedObject).isActionViewExpanded();
  }
  
  public boolean isCheckable()
  {
    return ((SupportMenuItem)this.mWrappedObject).isCheckable();
  }
  
  public boolean isChecked()
  {
    return ((SupportMenuItem)this.mWrappedObject).isChecked();
  }
  
  public boolean isEnabled()
  {
    return ((SupportMenuItem)this.mWrappedObject).isEnabled();
  }
  
  public boolean isVisible()
  {
    return ((SupportMenuItem)this.mWrappedObject).isVisible();
  }
  
  public MenuItem setActionProvider(android.view.ActionProvider paramActionProvider)
  {
    SupportMenuItem localSupportMenuItem = (SupportMenuItem)this.mWrappedObject;
    if (paramActionProvider != null) {}
    for (paramActionProvider = createActionProviderWrapper(paramActionProvider);; paramActionProvider = null)
    {
      localSupportMenuItem.setSupportActionProvider(paramActionProvider);
      return this;
    }
  }
  
  public MenuItem setActionView(int paramInt)
  {
    ((SupportMenuItem)this.mWrappedObject).setActionView(paramInt);
    View localView = ((SupportMenuItem)this.mWrappedObject).getActionView();
    if ((localView instanceof CollapsibleActionView)) {
      ((SupportMenuItem)this.mWrappedObject).setActionView(new MenuItemWrapperICS.CollapsibleActionViewWrapper(localView));
    }
    return this;
  }
  
  public MenuItem setActionView(View paramView)
  {
    Object localObject = paramView;
    if ((paramView instanceof CollapsibleActionView)) {
      localObject = new MenuItemWrapperICS.CollapsibleActionViewWrapper(paramView);
    }
    ((SupportMenuItem)this.mWrappedObject).setActionView((View)localObject);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    ((SupportMenuItem)this.mWrappedObject).setAlphabeticShortcut(paramChar);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    ((SupportMenuItem)this.mWrappedObject).setAlphabeticShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    ((SupportMenuItem)this.mWrappedObject).setCheckable(paramBoolean);
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    ((SupportMenuItem)this.mWrappedObject).setChecked(paramBoolean);
    return this;
  }
  
  public MenuItem setContentDescription(CharSequence paramCharSequence)
  {
    ((SupportMenuItem)this.mWrappedObject).setContentDescription(paramCharSequence);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    ((SupportMenuItem)this.mWrappedObject).setEnabled(paramBoolean);
    return this;
  }
  
  public void setExclusiveCheckable(boolean paramBoolean)
  {
    try
    {
      if (this.mSetExclusiveCheckableMethod == null) {
        this.mSetExclusiveCheckableMethod = ((SupportMenuItem)this.mWrappedObject).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[] { Boolean.TYPE });
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
    ((SupportMenuItem)this.mWrappedObject).setIcon(paramInt);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    ((SupportMenuItem)this.mWrappedObject).setIcon(paramDrawable);
    return this;
  }
  
  public MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    ((SupportMenuItem)this.mWrappedObject).setIconTintList(paramColorStateList);
    return this;
  }
  
  public MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    ((SupportMenuItem)this.mWrappedObject).setIconTintMode(paramMode);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    ((SupportMenuItem)this.mWrappedObject).setIntent(paramIntent);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    ((SupportMenuItem)this.mWrappedObject).setNumericShortcut(paramChar);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    ((SupportMenuItem)this.mWrappedObject).setNumericShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    SupportMenuItem localSupportMenuItem = (SupportMenuItem)this.mWrappedObject;
    if (paramOnActionExpandListener != null) {}
    for (paramOnActionExpandListener = new MenuItemWrapperICS.OnActionExpandListenerWrapper(this, paramOnActionExpandListener);; paramOnActionExpandListener = null)
    {
      localSupportMenuItem.setOnActionExpandListener(paramOnActionExpandListener);
      return this;
    }
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    SupportMenuItem localSupportMenuItem = (SupportMenuItem)this.mWrappedObject;
    if (paramOnMenuItemClickListener != null) {}
    for (paramOnMenuItemClickListener = new MenuItemWrapperICS.OnMenuItemClickListenerWrapper(this, paramOnMenuItemClickListener);; paramOnMenuItemClickListener = null)
    {
      localSupportMenuItem.setOnMenuItemClickListener(paramOnMenuItemClickListener);
      return this;
    }
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    ((SupportMenuItem)this.mWrappedObject).setShortcut(paramChar1, paramChar2);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    ((SupportMenuItem)this.mWrappedObject).setShortcut(paramChar1, paramChar2, paramInt1, paramInt2);
    return this;
  }
  
  public void setShowAsAction(int paramInt)
  {
    ((SupportMenuItem)this.mWrappedObject).setShowAsAction(paramInt);
  }
  
  public MenuItem setShowAsActionFlags(int paramInt)
  {
    ((SupportMenuItem)this.mWrappedObject).setShowAsActionFlags(paramInt);
    return this;
  }
  
  public MenuItem setTitle(int paramInt)
  {
    ((SupportMenuItem)this.mWrappedObject).setTitle(paramInt);
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    ((SupportMenuItem)this.mWrappedObject).setTitle(paramCharSequence);
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    ((SupportMenuItem)this.mWrappedObject).setTitleCondensed(paramCharSequence);
    return this;
  }
  
  public MenuItem setTooltipText(CharSequence paramCharSequence)
  {
    ((SupportMenuItem)this.mWrappedObject).setTooltipText(paramCharSequence);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    return ((SupportMenuItem)this.mWrappedObject).setVisible(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.view.menu.MenuItemWrapperICS
 * JD-Core Version:    0.7.0.1
 */