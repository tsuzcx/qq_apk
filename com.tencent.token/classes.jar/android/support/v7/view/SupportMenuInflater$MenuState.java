package android.support.v7.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuItemWrapperICS;
import android.support.v7.widget.DrawableUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;

class SupportMenuInflater$MenuState
{
  private static final int defaultGroupId = 0;
  private static final int defaultItemCategory = 0;
  private static final int defaultItemCheckable = 0;
  private static final boolean defaultItemChecked = false;
  private static final boolean defaultItemEnabled = true;
  private static final int defaultItemId = 0;
  private static final int defaultItemOrder = 0;
  private static final boolean defaultItemVisible = true;
  private int groupCategory;
  private int groupCheckable;
  private boolean groupEnabled;
  private int groupId;
  private int groupOrder;
  private boolean groupVisible;
  ActionProvider itemActionProvider;
  private String itemActionProviderClassName;
  private String itemActionViewClassName;
  private int itemActionViewLayout;
  private boolean itemAdded;
  private int itemAlphabeticModifiers;
  private char itemAlphabeticShortcut;
  private int itemCategoryOrder;
  private int itemCheckable;
  private boolean itemChecked;
  private CharSequence itemContentDescription;
  private boolean itemEnabled;
  private int itemIconResId;
  private ColorStateList itemIconTintList = null;
  private PorterDuff.Mode itemIconTintMode = null;
  private int itemId;
  private String itemListenerMethodName;
  private int itemNumericModifiers;
  private char itemNumericShortcut;
  private int itemShowAsAction;
  private CharSequence itemTitle;
  private CharSequence itemTitleCondensed;
  private CharSequence itemTooltipText;
  private boolean itemVisible;
  private Menu menu;
  
  public SupportMenuInflater$MenuState(SupportMenuInflater paramSupportMenuInflater, Menu paramMenu)
  {
    this.menu = paramMenu;
    resetGroup();
  }
  
  private char getShortcut(String paramString)
  {
    if (paramString == null) {
      return '\000';
    }
    return paramString.charAt(0);
  }
  
  private Object newInstance(String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      paramArrayOfClass = this.this$0.mContext.getClassLoader().loadClass(paramString).getConstructor(paramArrayOfClass);
      paramArrayOfClass.setAccessible(true);
      paramArrayOfClass = paramArrayOfClass.newInstance(paramArrayOfObject);
      return paramArrayOfClass;
    }
    catch (Exception paramArrayOfClass)
    {
      Log.w("SupportMenuInflater", "Cannot instantiate class: " + paramString, paramArrayOfClass);
    }
    return null;
  }
  
  private void setItem(MenuItem paramMenuItem)
  {
    int i = 1;
    Object localObject = paramMenuItem.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled);
    if (this.itemCheckable >= 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((MenuItem)localObject).setCheckable(bool).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId);
      if (this.itemShowAsAction >= 0) {
        paramMenuItem.setShowAsAction(this.itemShowAsAction);
      }
      if (this.itemListenerMethodName == null) {
        break label146;
      }
      if (!this.this$0.mContext.isRestricted()) {
        break;
      }
      throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
    }
    paramMenuItem.setOnMenuItemClickListener(new SupportMenuInflater.InflatedOnMenuItemClickListener(this.this$0.getRealOwner(), this.itemListenerMethodName));
    label146:
    if ((paramMenuItem instanceof MenuItemImpl)) {
      localObject = (MenuItemImpl)paramMenuItem;
    }
    if (this.itemCheckable >= 2)
    {
      if ((paramMenuItem instanceof MenuItemImpl)) {
        ((MenuItemImpl)paramMenuItem).setExclusiveCheckable(true);
      }
    }
    else
    {
      if (this.itemActionViewClassName == null) {
        break label356;
      }
      paramMenuItem.setActionView((View)newInstance(this.itemActionViewClassName, SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, this.this$0.mActionViewConstructorArguments));
    }
    for (;;)
    {
      if (this.itemActionViewLayout > 0)
      {
        if (i != 0) {
          break label344;
        }
        paramMenuItem.setActionView(this.itemActionViewLayout);
      }
      for (;;)
      {
        if (this.itemActionProvider != null) {
          MenuItemCompat.setActionProvider(paramMenuItem, this.itemActionProvider);
        }
        MenuItemCompat.setContentDescription(paramMenuItem, this.itemContentDescription);
        MenuItemCompat.setTooltipText(paramMenuItem, this.itemTooltipText);
        MenuItemCompat.setAlphabeticShortcut(paramMenuItem, this.itemAlphabeticShortcut, this.itemAlphabeticModifiers);
        MenuItemCompat.setNumericShortcut(paramMenuItem, this.itemNumericShortcut, this.itemNumericModifiers);
        if (this.itemIconTintMode != null) {
          MenuItemCompat.setIconTintMode(paramMenuItem, this.itemIconTintMode);
        }
        if (this.itemIconTintList != null) {
          MenuItemCompat.setIconTintList(paramMenuItem, this.itemIconTintList);
        }
        return;
        if (!(paramMenuItem instanceof MenuItemWrapperICS)) {
          break;
        }
        ((MenuItemWrapperICS)paramMenuItem).setExclusiveCheckable(true);
        break;
        label344:
        Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
      }
      label356:
      i = 0;
    }
  }
  
  public void addItem()
  {
    this.itemAdded = true;
    setItem(this.menu.add(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle));
  }
  
  public SubMenu addSubMenuItem()
  {
    this.itemAdded = true;
    SubMenu localSubMenu = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
    setItem(localSubMenu.getItem());
    return localSubMenu;
  }
  
  public boolean hasAddedItem()
  {
    return this.itemAdded;
  }
  
  public void readGroup(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = this.this$0.mContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MenuGroup);
    this.groupId = paramAttributeSet.getResourceId(R.styleable.MenuGroup_android_id, 0);
    this.groupCategory = paramAttributeSet.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
    this.groupOrder = paramAttributeSet.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
    this.groupCheckable = paramAttributeSet.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
    this.groupVisible = paramAttributeSet.getBoolean(R.styleable.MenuGroup_android_visible, true);
    this.groupEnabled = paramAttributeSet.getBoolean(R.styleable.MenuGroup_android_enabled, true);
    paramAttributeSet.recycle();
  }
  
  public void readItem(AttributeSet paramAttributeSet)
  {
    int j = 1;
    paramAttributeSet = this.this$0.mContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MenuItem);
    this.itemId = paramAttributeSet.getResourceId(R.styleable.MenuItem_android_id, 0);
    this.itemCategoryOrder = (paramAttributeSet.getInt(R.styleable.MenuItem_android_menuCategory, this.groupCategory) & 0xFFFF0000 | paramAttributeSet.getInt(R.styleable.MenuItem_android_orderInCategory, this.groupOrder) & 0xFFFF);
    this.itemTitle = paramAttributeSet.getText(R.styleable.MenuItem_android_title);
    this.itemTitleCondensed = paramAttributeSet.getText(R.styleable.MenuItem_android_titleCondensed);
    this.itemIconResId = paramAttributeSet.getResourceId(R.styleable.MenuItem_android_icon, 0);
    this.itemAlphabeticShortcut = getShortcut(paramAttributeSet.getString(R.styleable.MenuItem_android_alphabeticShortcut));
    this.itemAlphabeticModifiers = paramAttributeSet.getInt(R.styleable.MenuItem_alphabeticModifiers, 4096);
    this.itemNumericShortcut = getShortcut(paramAttributeSet.getString(R.styleable.MenuItem_android_numericShortcut));
    this.itemNumericModifiers = paramAttributeSet.getInt(R.styleable.MenuItem_numericModifiers, 4096);
    int i;
    if (paramAttributeSet.hasValue(R.styleable.MenuItem_android_checkable)) {
      if (paramAttributeSet.getBoolean(R.styleable.MenuItem_android_checkable, false))
      {
        i = 1;
        this.itemCheckable = i;
        label184:
        this.itemChecked = paramAttributeSet.getBoolean(R.styleable.MenuItem_android_checked, false);
        this.itemVisible = paramAttributeSet.getBoolean(R.styleable.MenuItem_android_visible, this.groupVisible);
        this.itemEnabled = paramAttributeSet.getBoolean(R.styleable.MenuItem_android_enabled, this.groupEnabled);
        this.itemShowAsAction = paramAttributeSet.getInt(R.styleable.MenuItem_showAsAction, -1);
        this.itemListenerMethodName = paramAttributeSet.getString(R.styleable.MenuItem_android_onClick);
        this.itemActionViewLayout = paramAttributeSet.getResourceId(R.styleable.MenuItem_actionLayout, 0);
        this.itemActionViewClassName = paramAttributeSet.getString(R.styleable.MenuItem_actionViewClass);
        this.itemActionProviderClassName = paramAttributeSet.getString(R.styleable.MenuItem_actionProviderClass);
        if (this.itemActionProviderClassName == null) {
          break label433;
        }
        i = j;
        label292:
        if ((i == 0) || (this.itemActionViewLayout != 0) || (this.itemActionViewClassName != null)) {
          break label438;
        }
        this.itemActionProvider = ((ActionProvider)newInstance(this.itemActionProviderClassName, SupportMenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, this.this$0.mActionProviderConstructorArguments));
        label335:
        this.itemContentDescription = paramAttributeSet.getText(R.styleable.MenuItem_contentDescription);
        this.itemTooltipText = paramAttributeSet.getText(R.styleable.MenuItem_tooltipText);
        if (!paramAttributeSet.hasValue(R.styleable.MenuItem_iconTintMode)) {
          break label459;
        }
        this.itemIconTintMode = DrawableUtils.parseTintMode(paramAttributeSet.getInt(R.styleable.MenuItem_iconTintMode, -1), this.itemIconTintMode);
        label386:
        if (!paramAttributeSet.hasValue(R.styleable.MenuItem_iconTint)) {
          break label467;
        }
      }
    }
    label433:
    label438:
    label459:
    label467:
    for (this.itemIconTintList = paramAttributeSet.getColorStateList(R.styleable.MenuItem_iconTint);; this.itemIconTintList = null)
    {
      paramAttributeSet.recycle();
      this.itemAdded = false;
      return;
      i = 0;
      break;
      this.itemCheckable = this.groupCheckable;
      break label184;
      i = 0;
      break label292;
      if (i != 0) {
        Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
      }
      this.itemActionProvider = null;
      break label335;
      this.itemIconTintMode = null;
      break label386;
    }
  }
  
  public void resetGroup()
  {
    this.groupId = 0;
    this.groupCategory = 0;
    this.groupOrder = 0;
    this.groupCheckable = 0;
    this.groupVisible = true;
    this.groupEnabled = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.view.SupportMenuInflater.MenuState
 * JD-Core Version:    0.7.0.1
 */