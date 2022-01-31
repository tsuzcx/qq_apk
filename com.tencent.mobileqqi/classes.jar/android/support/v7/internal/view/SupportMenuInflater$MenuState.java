package android.support.v7.internal.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuItemWrapperICS;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.tencent.mobileqqi.R.styleable;
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
  private ActionProvider itemActionProvider;
  private String itemActionProviderClassName;
  private String itemActionViewClassName;
  private int itemActionViewLayout;
  private boolean itemAdded;
  private char itemAlphabeticShortcut;
  private int itemCategoryOrder;
  private int itemCheckable;
  private boolean itemChecked;
  private boolean itemEnabled;
  private int itemIconResId;
  private int itemId;
  private String itemListenerMethodName;
  private char itemNumericShortcut;
  private int itemShowAsAction;
  private CharSequence itemTitle;
  private CharSequence itemTitleCondensed;
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
      paramArrayOfClass = SupportMenuInflater.access$100(this.this$0).getClassLoader().loadClass(paramString).getConstructor(paramArrayOfClass).newInstance(paramArrayOfObject);
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
      ((MenuItem)localObject).setCheckable(bool).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId).setAlphabeticShortcut(this.itemAlphabeticShortcut).setNumericShortcut(this.itemNumericShortcut);
      if (this.itemShowAsAction >= 0) {
        MenuItemCompat.setShowAsAction(paramMenuItem, this.itemShowAsAction);
      }
      if (this.itemListenerMethodName == null) {
        break label162;
      }
      if (!SupportMenuInflater.access$100(this.this$0).isRestricted()) {
        break;
      }
      throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
    }
    paramMenuItem.setOnMenuItemClickListener(new SupportMenuInflater.InflatedOnMenuItemClickListener(SupportMenuInflater.access$400(this.this$0), this.itemListenerMethodName));
    label162:
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
        break label297;
      }
      MenuItemCompat.setActionView(paramMenuItem, (View)newInstance(this.itemActionViewClassName, SupportMenuInflater.access$500(), SupportMenuInflater.access$600(this.this$0)));
    }
    for (;;)
    {
      if (this.itemActionViewLayout > 0)
      {
        if (i != 0) {
          break label286;
        }
        MenuItemCompat.setActionView(paramMenuItem, this.itemActionViewLayout);
      }
      for (;;)
      {
        if (this.itemActionProvider != null) {
          MenuItemCompat.setActionProvider(paramMenuItem, this.itemActionProvider);
        }
        return;
        if (!(paramMenuItem instanceof MenuItemWrapperICS)) {
          break;
        }
        ((MenuItemWrapperICS)paramMenuItem).setExclusiveCheckable(true);
        break;
        label286:
        Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
      }
      label297:
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
    paramAttributeSet = SupportMenuInflater.access$100(this.this$0).obtainStyledAttributes(paramAttributeSet, R.styleable.K);
    this.groupId = paramAttributeSet.getResourceId(1, 0);
    this.groupCategory = paramAttributeSet.getInt(3, 0);
    this.groupOrder = paramAttributeSet.getInt(4, 0);
    this.groupCheckable = paramAttributeSet.getInt(5, 0);
    this.groupVisible = paramAttributeSet.getBoolean(2, true);
    this.groupEnabled = paramAttributeSet.getBoolean(0, true);
    paramAttributeSet.recycle();
  }
  
  public void readItem(AttributeSet paramAttributeSet)
  {
    int j = 1;
    paramAttributeSet = SupportMenuInflater.access$100(this.this$0).obtainStyledAttributes(paramAttributeSet, R.styleable.L);
    this.itemId = paramAttributeSet.getResourceId(2, 0);
    this.itemCategoryOrder = (paramAttributeSet.getInt(5, this.groupCategory) & 0xFFFF0000 | paramAttributeSet.getInt(6, this.groupOrder) & 0xFFFF);
    this.itemTitle = paramAttributeSet.getText(7);
    this.itemTitleCondensed = paramAttributeSet.getText(8);
    this.itemIconResId = paramAttributeSet.getResourceId(0, 0);
    this.itemAlphabeticShortcut = getShortcut(paramAttributeSet.getString(9));
    this.itemNumericShortcut = getShortcut(paramAttributeSet.getString(10));
    int i;
    if (paramAttributeSet.hasValue(11)) {
      if (paramAttributeSet.getBoolean(11, false))
      {
        i = 1;
        this.itemCheckable = i;
        label143:
        this.itemChecked = paramAttributeSet.getBoolean(3, false);
        this.itemVisible = paramAttributeSet.getBoolean(4, this.groupVisible);
        this.itemEnabled = paramAttributeSet.getBoolean(1, this.groupEnabled);
        this.itemShowAsAction = paramAttributeSet.getInt(13, -1);
        this.itemListenerMethodName = paramAttributeSet.getString(12);
        this.itemActionViewLayout = paramAttributeSet.getResourceId(14, 0);
        this.itemActionViewClassName = paramAttributeSet.getString(15);
        this.itemActionProviderClassName = paramAttributeSet.getString(16);
        if (this.itemActionProviderClassName == null) {
          break label309;
        }
        i = j;
        label240:
        if ((i == 0) || (this.itemActionViewLayout != 0) || (this.itemActionViewClassName != null)) {
          break label314;
        }
      }
    }
    for (this.itemActionProvider = ((ActionProvider)newInstance(this.itemActionProviderClassName, SupportMenuInflater.access$200(), SupportMenuInflater.access$300(this.this$0)));; this.itemActionProvider = null)
    {
      paramAttributeSet.recycle();
      this.itemAdded = false;
      return;
      i = 0;
      break;
      this.itemCheckable = this.groupCheckable;
      break label143;
      label309:
      i = 0;
      break label240;
      label314:
      if (i != 0) {
        Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.view.SupportMenuInflater.MenuState
 * JD-Core Version:    0.7.0.1
 */