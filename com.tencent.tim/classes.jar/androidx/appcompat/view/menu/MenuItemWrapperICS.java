package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportMenuItem;
import java.lang.reflect.Method;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuItemWrapperICS
  extends BaseMenuWrapper
  implements MenuItem
{
  static final String LOG_TAG = "MenuItemWrapper";
  private Method mSetExclusiveCheckableMethod;
  private final SupportMenuItem mWrappedObject;
  
  public MenuItemWrapperICS(Context paramContext, SupportMenuItem paramSupportMenuItem)
  {
    super(paramContext);
    if (paramSupportMenuItem == null) {
      throw new IllegalArgumentException("Wrapped Object can not be null.");
    }
    this.mWrappedObject = paramSupportMenuItem;
  }
  
  public boolean collapseActionView()
  {
    return this.mWrappedObject.collapseActionView();
  }
  
  public boolean expandActionView()
  {
    return this.mWrappedObject.expandActionView();
  }
  
  public android.view.ActionProvider getActionProvider()
  {
    androidx.core.view.ActionProvider localActionProvider = this.mWrappedObject.getSupportActionProvider();
    if ((localActionProvider instanceof ActionProviderWrapper)) {
      return ((ActionProviderWrapper)localActionProvider).mInner;
    }
    return null;
  }
  
  public View getActionView()
  {
    View localView2 = this.mWrappedObject.getActionView();
    View localView1 = localView2;
    if ((localView2 instanceof CollapsibleActionViewWrapper)) {
      localView1 = ((CollapsibleActionViewWrapper)localView2).getWrappedView();
    }
    return localView1;
  }
  
  public int getAlphabeticModifiers()
  {
    return this.mWrappedObject.getAlphabeticModifiers();
  }
  
  public char getAlphabeticShortcut()
  {
    return this.mWrappedObject.getAlphabeticShortcut();
  }
  
  public CharSequence getContentDescription()
  {
    return this.mWrappedObject.getContentDescription();
  }
  
  public int getGroupId()
  {
    return this.mWrappedObject.getGroupId();
  }
  
  public Drawable getIcon()
  {
    return this.mWrappedObject.getIcon();
  }
  
  public ColorStateList getIconTintList()
  {
    return this.mWrappedObject.getIconTintList();
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return this.mWrappedObject.getIconTintMode();
  }
  
  public Intent getIntent()
  {
    return this.mWrappedObject.getIntent();
  }
  
  public int getItemId()
  {
    return this.mWrappedObject.getItemId();
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return this.mWrappedObject.getMenuInfo();
  }
  
  public int getNumericModifiers()
  {
    return this.mWrappedObject.getNumericModifiers();
  }
  
  public char getNumericShortcut()
  {
    return this.mWrappedObject.getNumericShortcut();
  }
  
  public int getOrder()
  {
    return this.mWrappedObject.getOrder();
  }
  
  public SubMenu getSubMenu()
  {
    return getSubMenuWrapper(this.mWrappedObject.getSubMenu());
  }
  
  public CharSequence getTitle()
  {
    return this.mWrappedObject.getTitle();
  }
  
  public CharSequence getTitleCondensed()
  {
    return this.mWrappedObject.getTitleCondensed();
  }
  
  public CharSequence getTooltipText()
  {
    return this.mWrappedObject.getTooltipText();
  }
  
  public boolean hasSubMenu()
  {
    return this.mWrappedObject.hasSubMenu();
  }
  
  public boolean isActionViewExpanded()
  {
    return this.mWrappedObject.isActionViewExpanded();
  }
  
  public boolean isCheckable()
  {
    return this.mWrappedObject.isCheckable();
  }
  
  public boolean isChecked()
  {
    return this.mWrappedObject.isChecked();
  }
  
  public boolean isEnabled()
  {
    return this.mWrappedObject.isEnabled();
  }
  
  public boolean isVisible()
  {
    return this.mWrappedObject.isVisible();
  }
  
  public MenuItem setActionProvider(android.view.ActionProvider paramActionProvider)
  {
    Object localObject;
    SupportMenuItem localSupportMenuItem;
    if (Build.VERSION.SDK_INT >= 16)
    {
      localObject = new ActionProviderWrapperJB(this.mContext, paramActionProvider);
      localSupportMenuItem = this.mWrappedObject;
      if (paramActionProvider == null) {
        break label58;
      }
    }
    for (;;)
    {
      localSupportMenuItem.setSupportActionProvider((androidx.core.view.ActionProvider)localObject);
      return this;
      localObject = new ActionProviderWrapper(this.mContext, paramActionProvider);
      break;
      label58:
      localObject = null;
    }
  }
  
  public MenuItem setActionView(int paramInt)
  {
    this.mWrappedObject.setActionView(paramInt);
    View localView = this.mWrappedObject.getActionView();
    if ((localView instanceof android.view.CollapsibleActionView)) {
      this.mWrappedObject.setActionView(new CollapsibleActionViewWrapper(localView));
    }
    return this;
  }
  
  public MenuItem setActionView(View paramView)
  {
    Object localObject = paramView;
    if ((paramView instanceof android.view.CollapsibleActionView)) {
      localObject = new CollapsibleActionViewWrapper(paramView);
    }
    this.mWrappedObject.setActionView((View)localObject);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    this.mWrappedObject.setAlphabeticShortcut(paramChar);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    this.mWrappedObject.setAlphabeticShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    this.mWrappedObject.setCheckable(paramBoolean);
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    this.mWrappedObject.setChecked(paramBoolean);
    return this;
  }
  
  public MenuItem setContentDescription(CharSequence paramCharSequence)
  {
    this.mWrappedObject.setContentDescription(paramCharSequence);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    this.mWrappedObject.setEnabled(paramBoolean);
    return this;
  }
  
  public void setExclusiveCheckable(boolean paramBoolean)
  {
    try
    {
      if (this.mSetExclusiveCheckableMethod == null) {
        this.mSetExclusiveCheckableMethod = this.mWrappedObject.getClass().getDeclaredMethod("setExclusiveCheckable", new Class[] { Boolean.TYPE });
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
    this.mWrappedObject.setIcon(paramInt);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    this.mWrappedObject.setIcon(paramDrawable);
    return this;
  }
  
  public MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    this.mWrappedObject.setIconTintList(paramColorStateList);
    return this;
  }
  
  public MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    this.mWrappedObject.setIconTintMode(paramMode);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    this.mWrappedObject.setIntent(paramIntent);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    this.mWrappedObject.setNumericShortcut(paramChar);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    this.mWrappedObject.setNumericShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    SupportMenuItem localSupportMenuItem = this.mWrappedObject;
    if (paramOnActionExpandListener != null) {}
    for (paramOnActionExpandListener = new OnActionExpandListenerWrapper(paramOnActionExpandListener);; paramOnActionExpandListener = null)
    {
      localSupportMenuItem.setOnActionExpandListener(paramOnActionExpandListener);
      return this;
    }
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    SupportMenuItem localSupportMenuItem = this.mWrappedObject;
    if (paramOnMenuItemClickListener != null) {}
    for (paramOnMenuItemClickListener = new OnMenuItemClickListenerWrapper(paramOnMenuItemClickListener);; paramOnMenuItemClickListener = null)
    {
      localSupportMenuItem.setOnMenuItemClickListener(paramOnMenuItemClickListener);
      return this;
    }
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    this.mWrappedObject.setShortcut(paramChar1, paramChar2);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    this.mWrappedObject.setShortcut(paramChar1, paramChar2, paramInt1, paramInt2);
    return this;
  }
  
  public void setShowAsAction(int paramInt)
  {
    this.mWrappedObject.setShowAsAction(paramInt);
  }
  
  public MenuItem setShowAsActionFlags(int paramInt)
  {
    this.mWrappedObject.setShowAsActionFlags(paramInt);
    return this;
  }
  
  public MenuItem setTitle(int paramInt)
  {
    this.mWrappedObject.setTitle(paramInt);
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.mWrappedObject.setTitle(paramCharSequence);
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.mWrappedObject.setTitleCondensed(paramCharSequence);
    return this;
  }
  
  public MenuItem setTooltipText(CharSequence paramCharSequence)
  {
    this.mWrappedObject.setTooltipText(paramCharSequence);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    return this.mWrappedObject.setVisible(paramBoolean);
  }
  
  class ActionProviderWrapper
    extends androidx.core.view.ActionProvider
  {
    final android.view.ActionProvider mInner;
    
    ActionProviderWrapper(Context paramContext, android.view.ActionProvider paramActionProvider)
    {
      super();
      this.mInner = paramActionProvider;
    }
    
    public boolean hasSubMenu()
    {
      return this.mInner.hasSubMenu();
    }
    
    public View onCreateActionView()
    {
      return this.mInner.onCreateActionView();
    }
    
    public boolean onPerformDefaultAction()
    {
      return this.mInner.onPerformDefaultAction();
    }
    
    public void onPrepareSubMenu(SubMenu paramSubMenu)
    {
      this.mInner.onPrepareSubMenu(MenuItemWrapperICS.this.getSubMenuWrapper(paramSubMenu));
    }
  }
  
  @RequiresApi(16)
  class ActionProviderWrapperJB
    extends MenuItemWrapperICS.ActionProviderWrapper
    implements android.view.ActionProvider.VisibilityListener
  {
    private androidx.core.view.ActionProvider.VisibilityListener mListener;
    
    ActionProviderWrapperJB(Context paramContext, android.view.ActionProvider paramActionProvider)
    {
      super(paramContext, paramActionProvider);
    }
    
    public boolean isVisible()
    {
      return this.mInner.isVisible();
    }
    
    public void onActionProviderVisibilityChanged(boolean paramBoolean)
    {
      if (this.mListener != null) {
        this.mListener.onActionProviderVisibilityChanged(paramBoolean);
      }
    }
    
    public View onCreateActionView(MenuItem paramMenuItem)
    {
      return this.mInner.onCreateActionView(paramMenuItem);
    }
    
    public boolean overridesItemVisibility()
    {
      return this.mInner.overridesItemVisibility();
    }
    
    public void refreshVisibility()
    {
      this.mInner.refreshVisibility();
    }
    
    public void setVisibilityListener(androidx.core.view.ActionProvider.VisibilityListener paramVisibilityListener)
    {
      this.mListener = paramVisibilityListener;
      android.view.ActionProvider localActionProvider = this.mInner;
      if (paramVisibilityListener != null) {}
      for (paramVisibilityListener = this;; paramVisibilityListener = null)
      {
        localActionProvider.setVisibilityListener(paramVisibilityListener);
        return;
      }
    }
  }
  
  static class CollapsibleActionViewWrapper
    extends FrameLayout
    implements androidx.appcompat.view.CollapsibleActionView
  {
    final android.view.CollapsibleActionView mWrappedView;
    
    CollapsibleActionViewWrapper(View paramView)
    {
      super();
      this.mWrappedView = ((android.view.CollapsibleActionView)paramView);
      addView(paramView);
    }
    
    View getWrappedView()
    {
      return (View)this.mWrappedView;
    }
    
    public void onActionViewCollapsed()
    {
      this.mWrappedView.onActionViewCollapsed();
    }
    
    public void onActionViewExpanded()
    {
      this.mWrappedView.onActionViewExpanded();
    }
  }
  
  class OnActionExpandListenerWrapper
    implements MenuItem.OnActionExpandListener
  {
    private final MenuItem.OnActionExpandListener mObject;
    
    OnActionExpandListenerWrapper(MenuItem.OnActionExpandListener paramOnActionExpandListener)
    {
      this.mObject = paramOnActionExpandListener;
    }
    
    public boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
    {
      return this.mObject.onMenuItemActionCollapse(MenuItemWrapperICS.this.getMenuItemWrapper(paramMenuItem));
    }
    
    public boolean onMenuItemActionExpand(MenuItem paramMenuItem)
    {
      return this.mObject.onMenuItemActionExpand(MenuItemWrapperICS.this.getMenuItemWrapper(paramMenuItem));
    }
  }
  
  class OnMenuItemClickListenerWrapper
    implements MenuItem.OnMenuItemClickListener
  {
    private final MenuItem.OnMenuItemClickListener mObject;
    
    OnMenuItemClickListenerWrapper(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
    {
      this.mObject = paramOnMenuItemClickListener;
    }
    
    public boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      return this.mObject.onMenuItemClick(MenuItemWrapperICS.this.getMenuItemWrapper(paramMenuItem));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.view.menu.MenuItemWrapperICS
 * JD-Core Version:    0.7.0.1
 */