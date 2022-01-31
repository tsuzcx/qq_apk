package android.support.v7.internal.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.util.Log;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;

public final class MenuItemImpl
  implements SupportMenuItem
{
  private static final int CHECKABLE = 1;
  private static final int CHECKED = 2;
  private static final int ENABLED = 16;
  private static final int EXCLUSIVE = 4;
  private static final int HIDDEN = 8;
  private static final int IS_ACTION = 32;
  static final int NO_ICON = 0;
  private static final int SHOW_AS_ACTION_MASK = 3;
  private static final String TAG = "MenuItemImpl";
  private static String sDeleteShortcutLabel;
  private static String sEnterShortcutLabel;
  private static String sPrependShortcutLabel;
  private static String sSpaceShortcutLabel;
  private android.support.v4.view.ActionProvider mActionProvider;
  private View mActionView;
  private final int mCategoryOrder;
  private MenuItem.OnMenuItemClickListener mClickListener;
  private int mFlags = 16;
  private final int mGroup;
  private Drawable mIconDrawable;
  private int mIconResId = 0;
  private final int mId;
  private Intent mIntent;
  private boolean mIsActionViewExpanded = false;
  private Runnable mItemCallback;
  private MenuBuilder mMenu;
  private ContextMenu.ContextMenuInfo mMenuInfo;
  private MenuItemCompat.OnActionExpandListener mOnActionExpandListener;
  private final int mOrdering;
  private char mShortcutAlphabeticChar;
  private char mShortcutNumericChar;
  private int mShowAsAction = 0;
  private SubMenuBuilder mSubMenu;
  private CharSequence mTitle;
  private CharSequence mTitleCondensed;
  
  MenuItemImpl(MenuBuilder paramMenuBuilder, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5)
  {
    this.mMenu = paramMenuBuilder;
    this.mId = paramInt2;
    this.mGroup = paramInt1;
    this.mCategoryOrder = paramInt3;
    this.mOrdering = paramInt4;
    this.mTitle = paramCharSequence;
    this.mShowAsAction = paramInt5;
  }
  
  public void actionFormatChanged()
  {
    this.mMenu.onItemActionRequestChanged(this);
  }
  
  public boolean collapseActionView()
  {
    if ((this.mShowAsAction & 0x8) == 0) {}
    do
    {
      return false;
      if (this.mActionView == null) {
        return true;
      }
    } while ((this.mOnActionExpandListener != null) && (!this.mOnActionExpandListener.onMenuItemActionCollapse(this)));
    return this.mMenu.collapseItemActionView(this);
  }
  
  public boolean expandActionView()
  {
    if (((this.mShowAsAction & 0x8) == 0) || (this.mActionView == null)) {}
    while ((this.mOnActionExpandListener != null) && (!this.mOnActionExpandListener.onMenuItemActionExpand(this))) {
      return false;
    }
    return this.mMenu.expandItemActionView(this);
  }
  
  public android.view.ActionProvider getActionProvider()
  {
    throw new UnsupportedOperationException("Implementation should use getSupportActionProvider!");
  }
  
  public View getActionView()
  {
    if (this.mActionView != null) {
      return this.mActionView;
    }
    if (this.mActionProvider != null)
    {
      this.mActionView = this.mActionProvider.onCreateActionView(this);
      return this.mActionView;
    }
    return null;
  }
  
  public char getAlphabeticShortcut()
  {
    return this.mShortcutAlphabeticChar;
  }
  
  Runnable getCallback()
  {
    return this.mItemCallback;
  }
  
  public int getGroupId()
  {
    return this.mGroup;
  }
  
  public Drawable getIcon()
  {
    if (this.mIconDrawable != null) {
      return this.mIconDrawable;
    }
    if (this.mIconResId != 0)
    {
      Drawable localDrawable = this.mMenu.getResources().getDrawable(this.mIconResId);
      this.mIconResId = 0;
      this.mIconDrawable = localDrawable;
      return localDrawable;
    }
    return null;
  }
  
  public Intent getIntent()
  {
    return this.mIntent;
  }
  
  @ViewDebug.CapturedViewProperty
  public int getItemId()
  {
    return this.mId;
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return this.mMenuInfo;
  }
  
  public char getNumericShortcut()
  {
    return this.mShortcutNumericChar;
  }
  
  public int getOrder()
  {
    return this.mCategoryOrder;
  }
  
  public int getOrdering()
  {
    return this.mOrdering;
  }
  
  char getShortcut()
  {
    return this.mShortcutAlphabeticChar;
  }
  
  String getShortcutLabel()
  {
    char c = getShortcut();
    if (c == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(sPrependShortcutLabel);
    switch (c)
    {
    default: 
      localStringBuilder.append(c);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(sEnterShortcutLabel);
      continue;
      localStringBuilder.append(sDeleteShortcutLabel);
      continue;
      localStringBuilder.append(sSpaceShortcutLabel);
    }
  }
  
  public SubMenu getSubMenu()
  {
    return this.mSubMenu;
  }
  
  public android.support.v4.view.ActionProvider getSupportActionProvider()
  {
    return this.mActionProvider;
  }
  
  @ViewDebug.CapturedViewProperty
  public CharSequence getTitle()
  {
    return this.mTitle;
  }
  
  public CharSequence getTitleCondensed()
  {
    if (this.mTitleCondensed != null) {
      return this.mTitleCondensed;
    }
    return this.mTitle;
  }
  
  CharSequence getTitleForItemView(MenuView.ItemView paramItemView)
  {
    if ((paramItemView != null) && (paramItemView.prefersCondensedTitle())) {
      return getTitleCondensed();
    }
    return getTitle();
  }
  
  public boolean hasCollapsibleActionView()
  {
    return ((this.mShowAsAction & 0x8) != 0) && (this.mActionView != null);
  }
  
  public boolean hasSubMenu()
  {
    return this.mSubMenu != null;
  }
  
  public boolean invoke()
  {
    if ((this.mClickListener != null) && (this.mClickListener.onMenuItemClick(this))) {}
    do
    {
      do
      {
        return true;
      } while (this.mMenu.dispatchMenuItemSelected(this.mMenu.getRootMenu(), this));
      if (this.mItemCallback != null)
      {
        this.mItemCallback.run();
        return true;
      }
      if (this.mIntent != null) {
        try
        {
          this.mMenu.getContext().startActivity(this.mIntent);
          return true;
        }
        catch (ActivityNotFoundException localActivityNotFoundException)
        {
          Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", localActivityNotFoundException);
        }
      }
    } while ((this.mActionProvider != null) && (this.mActionProvider.onPerformDefaultAction()));
    return false;
  }
  
  public boolean isActionButton()
  {
    return (this.mFlags & 0x20) == 32;
  }
  
  public boolean isActionViewExpanded()
  {
    return this.mIsActionViewExpanded;
  }
  
  public boolean isCheckable()
  {
    return (this.mFlags & 0x1) == 1;
  }
  
  public boolean isChecked()
  {
    return (this.mFlags & 0x2) == 2;
  }
  
  public boolean isEnabled()
  {
    return (this.mFlags & 0x10) != 0;
  }
  
  public boolean isExclusiveCheckable()
  {
    return (this.mFlags & 0x4) != 0;
  }
  
  public boolean isVisible()
  {
    if ((this.mActionProvider != null) && (this.mActionProvider.overridesItemVisibility())) {
      if (((this.mFlags & 0x8) != 0) || (!this.mActionProvider.isVisible())) {}
    }
    while ((this.mFlags & 0x8) == 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public boolean requestsActionButton()
  {
    return (this.mShowAsAction & 0x1) == 1;
  }
  
  public boolean requiresActionButton()
  {
    return (this.mShowAsAction & 0x2) == 2;
  }
  
  public MenuItem setActionProvider(android.view.ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException("Implementation should use setSupportActionProvider!");
  }
  
  public SupportMenuItem setActionView(int paramInt)
  {
    Context localContext = this.mMenu.getContext();
    setActionView(LayoutInflater.from(localContext).inflate(paramInt, new LinearLayout(localContext), false));
    return this;
  }
  
  public SupportMenuItem setActionView(View paramView)
  {
    this.mActionView = paramView;
    this.mActionProvider = null;
    if ((paramView != null) && (paramView.getId() == -1) && (this.mId > 0)) {
      paramView.setId(this.mId);
    }
    this.mMenu.onItemActionRequestChanged(this);
    return this;
  }
  
  public void setActionViewExpanded(boolean paramBoolean)
  {
    this.mIsActionViewExpanded = paramBoolean;
    this.mMenu.onItemsChanged(false);
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    if (this.mShortcutAlphabeticChar == paramChar) {
      return this;
    }
    this.mShortcutAlphabeticChar = Character.toLowerCase(paramChar);
    this.mMenu.onItemsChanged(false);
    return this;
  }
  
  public MenuItem setCallback(Runnable paramRunnable)
  {
    this.mItemCallback = paramRunnable;
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    int j = this.mFlags;
    int k = this.mFlags;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.mFlags = (i | k & 0xFFFFFFFE);
      if (j != this.mFlags) {
        this.mMenu.onItemsChanged(false);
      }
      return this;
    }
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    if ((this.mFlags & 0x4) != 0)
    {
      this.mMenu.setExclusiveItemChecked(this);
      return this;
    }
    setCheckedInt(paramBoolean);
    return this;
  }
  
  void setCheckedInt(boolean paramBoolean)
  {
    int j = this.mFlags;
    int k = this.mFlags;
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      this.mFlags = (i | k & 0xFFFFFFFD);
      if (j != this.mFlags) {
        this.mMenu.onItemsChanged(false);
      }
      return;
    }
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (this.mFlags |= 0x10;; this.mFlags &= 0xFFFFFFEF)
    {
      this.mMenu.onItemsChanged(false);
      return this;
    }
  }
  
  public void setExclusiveCheckable(boolean paramBoolean)
  {
    int j = this.mFlags;
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      this.mFlags = (i | j & 0xFFFFFFFB);
      return;
    }
  }
  
  public MenuItem setIcon(int paramInt)
  {
    this.mIconDrawable = null;
    this.mIconResId = paramInt;
    this.mMenu.onItemsChanged(false);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    this.mIconResId = 0;
    this.mIconDrawable = paramDrawable;
    this.mMenu.onItemsChanged(false);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    this.mIntent = paramIntent;
    return this;
  }
  
  public void setIsActionButton(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mFlags |= 0x20;
      return;
    }
    this.mFlags &= 0xFFFFFFDF;
  }
  
  void setMenuInfo(ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    this.mMenuInfo = paramContextMenuInfo;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    if (this.mShortcutNumericChar == paramChar) {
      return this;
    }
    this.mShortcutNumericChar = paramChar;
    this.mMenu.onItemsChanged(false);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    throw new UnsupportedOperationException("Implementation should use setSupportOnActionExpandListener!");
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mClickListener = paramOnMenuItemClickListener;
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    this.mShortcutNumericChar = paramChar1;
    this.mShortcutAlphabeticChar = Character.toLowerCase(paramChar2);
    this.mMenu.onItemsChanged(false);
    return this;
  }
  
  public void setShowAsAction(int paramInt)
  {
    switch (paramInt & 0x3)
    {
    default: 
      throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }
    this.mShowAsAction = paramInt;
    this.mMenu.onItemActionRequestChanged(this);
  }
  
  public SupportMenuItem setShowAsActionFlags(int paramInt)
  {
    setShowAsAction(paramInt);
    return this;
  }
  
  void setSubMenu(SubMenuBuilder paramSubMenuBuilder)
  {
    this.mSubMenu = paramSubMenuBuilder;
    paramSubMenuBuilder.setHeaderTitle(getTitle());
  }
  
  public SupportMenuItem setSupportActionProvider(android.support.v4.view.ActionProvider paramActionProvider)
  {
    if (this.mActionProvider == paramActionProvider) {}
    do
    {
      return this;
      this.mActionView = null;
      if (this.mActionProvider != null) {
        this.mActionProvider.setVisibilityListener(null);
      }
      this.mActionProvider = paramActionProvider;
      this.mMenu.onItemsChanged(true);
    } while (paramActionProvider == null);
    paramActionProvider.setVisibilityListener(new MenuItemImpl.1(this));
    return this;
  }
  
  public SupportMenuItem setSupportOnActionExpandListener(MenuItemCompat.OnActionExpandListener paramOnActionExpandListener)
  {
    this.mOnActionExpandListener = paramOnActionExpandListener;
    return this;
  }
  
  public MenuItem setTitle(int paramInt)
  {
    return setTitle(this.mMenu.getContext().getString(paramInt));
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.mTitle = paramCharSequence;
    this.mMenu.onItemsChanged(false);
    if (this.mSubMenu != null) {
      this.mSubMenu.setHeaderTitle(paramCharSequence);
    }
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.mTitleCondensed = paramCharSequence;
    if (paramCharSequence == null) {
      paramCharSequence = this.mTitle;
    }
    this.mMenu.onItemsChanged(false);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    if (setVisibleInt(paramBoolean)) {
      this.mMenu.onItemVisibleChanged(this);
    }
    return this;
  }
  
  boolean setVisibleInt(boolean paramBoolean)
  {
    boolean bool = false;
    int j = this.mFlags;
    int k = this.mFlags;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      this.mFlags = (i | k & 0xFFFFFFF7);
      paramBoolean = bool;
      if (j != this.mFlags) {
        paramBoolean = true;
      }
      return paramBoolean;
    }
  }
  
  public boolean shouldShowIcon()
  {
    return this.mMenu.getOptionalIconsVisible();
  }
  
  boolean shouldShowShortcut()
  {
    return (this.mMenu.isShortcutsVisible()) && (getShortcut() != 0);
  }
  
  public boolean showsTextAsAction()
  {
    return (this.mShowAsAction & 0x4) == 4;
  }
  
  public String toString()
  {
    return this.mTitle.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuItemImpl
 * JD-Core Version:    0.7.0.1
 */