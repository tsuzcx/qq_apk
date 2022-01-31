package android.support.v7.internal.view.menu;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v4.internal.view.SupportMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

class MenuWrapperICS
  extends BaseMenuWrapper
  implements SupportMenu
{
  MenuWrapperICS(Menu paramMenu)
  {
    super(paramMenu);
  }
  
  public MenuItem add(int paramInt)
  {
    return getMenuItemWrapper(((Menu)this.mWrappedObject).add(paramInt));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return getMenuItemWrapper(((Menu)this.mWrappedObject).add(paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return getMenuItemWrapper(((Menu)this.mWrappedObject).add(paramInt1, paramInt2, paramInt3, paramCharSequence));
  }
  
  public MenuItem add(CharSequence paramCharSequence)
  {
    return getMenuItemWrapper(((Menu)this.mWrappedObject).add(paramCharSequence));
  }
  
  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem)
  {
    MenuItem[] arrayOfMenuItem = null;
    if (paramArrayOfMenuItem != null) {
      arrayOfMenuItem = new MenuItem[paramArrayOfMenuItem.length];
    }
    paramInt2 = ((Menu)this.mWrappedObject).addIntentOptions(paramInt1, paramInt2, paramInt3, paramComponentName, paramArrayOfIntent, paramIntent, paramInt4, arrayOfMenuItem);
    if (arrayOfMenuItem != null)
    {
      paramInt1 = 0;
      paramInt3 = arrayOfMenuItem.length;
      while (paramInt1 < paramInt3)
      {
        paramArrayOfMenuItem[paramInt1] = getMenuItemWrapper(arrayOfMenuItem[paramInt1]);
        paramInt1 += 1;
      }
    }
    return paramInt2;
  }
  
  public SubMenu addSubMenu(int paramInt)
  {
    return getSubMenuWrapper(((Menu)this.mWrappedObject).addSubMenu(paramInt));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return getSubMenuWrapper(((Menu)this.mWrappedObject).addSubMenu(paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return getSubMenuWrapper(((Menu)this.mWrappedObject).addSubMenu(paramInt1, paramInt2, paramInt3, paramCharSequence));
  }
  
  public SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    return getSubMenuWrapper(((Menu)this.mWrappedObject).addSubMenu(paramCharSequence));
  }
  
  public void clear()
  {
    internalClear();
    ((Menu)this.mWrappedObject).clear();
  }
  
  public void close()
  {
    ((Menu)this.mWrappedObject).close();
  }
  
  public MenuItem findItem(int paramInt)
  {
    return getMenuItemWrapper(((Menu)this.mWrappedObject).findItem(paramInt));
  }
  
  public MenuItem getItem(int paramInt)
  {
    return getMenuItemWrapper(((Menu)this.mWrappedObject).getItem(paramInt));
  }
  
  public boolean hasVisibleItems()
  {
    return ((Menu)this.mWrappedObject).hasVisibleItems();
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    return ((Menu)this.mWrappedObject).isShortcutKey(paramInt, paramKeyEvent);
  }
  
  public boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    return ((Menu)this.mWrappedObject).performIdentifierAction(paramInt1, paramInt2);
  }
  
  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    return ((Menu)this.mWrappedObject).performShortcut(paramInt1, paramKeyEvent, paramInt2);
  }
  
  public void removeGroup(int paramInt)
  {
    internalRemoveGroup(paramInt);
    ((Menu)this.mWrappedObject).removeGroup(paramInt);
  }
  
  public void removeItem(int paramInt)
  {
    internalRemoveItem(paramInt);
    ((Menu)this.mWrappedObject).removeItem(paramInt);
  }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    ((Menu)this.mWrappedObject).setGroupCheckable(paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean)
  {
    ((Menu)this.mWrappedObject).setGroupEnabled(paramInt, paramBoolean);
  }
  
  public void setGroupVisible(int paramInt, boolean paramBoolean)
  {
    ((Menu)this.mWrappedObject).setGroupVisible(paramInt, paramBoolean);
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    ((Menu)this.mWrappedObject).setQwertyMode(paramBoolean);
  }
  
  public int size()
  {
    return ((Menu)this.mWrappedObject).size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuWrapperICS
 * JD-Core Version:    0.7.0.1
 */