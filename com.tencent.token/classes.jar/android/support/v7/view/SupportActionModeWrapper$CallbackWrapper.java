package android.support.v7.view;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.util.SimpleArrayMap;
import android.support.v7.view.menu.MenuWrapperFactory;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class SupportActionModeWrapper$CallbackWrapper
  implements ActionMode.Callback
{
  final ArrayList mActionModes;
  final Context mContext;
  final SimpleArrayMap mMenus;
  final android.view.ActionMode.Callback mWrappedCallback;
  
  public SupportActionModeWrapper$CallbackWrapper(Context paramContext, android.view.ActionMode.Callback paramCallback)
  {
    this.mContext = paramContext;
    this.mWrappedCallback = paramCallback;
    this.mActionModes = new ArrayList();
    this.mMenus = new SimpleArrayMap();
  }
  
  private Menu getMenuWrapper(Menu paramMenu)
  {
    Menu localMenu2 = (Menu)this.mMenus.get(paramMenu);
    Menu localMenu1 = localMenu2;
    if (localMenu2 == null)
    {
      localMenu1 = MenuWrapperFactory.wrapSupportMenu(this.mContext, (SupportMenu)paramMenu);
      this.mMenus.put(paramMenu, localMenu1);
    }
    return localMenu1;
  }
  
  public android.view.ActionMode getActionModeWrapper(ActionMode paramActionMode)
  {
    int j = this.mActionModes.size();
    int i = 0;
    while (i < j)
    {
      SupportActionModeWrapper localSupportActionModeWrapper = (SupportActionModeWrapper)this.mActionModes.get(i);
      if ((localSupportActionModeWrapper != null) && (localSupportActionModeWrapper.mWrappedObject == paramActionMode)) {
        return localSupportActionModeWrapper;
      }
      i += 1;
    }
    paramActionMode = new SupportActionModeWrapper(this.mContext, paramActionMode);
    this.mActionModes.add(paramActionMode);
    return paramActionMode;
  }
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    return this.mWrappedCallback.onActionItemClicked(getActionModeWrapper(paramActionMode), MenuWrapperFactory.wrapSupportMenuItem(this.mContext, (SupportMenuItem)paramMenuItem));
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return this.mWrappedCallback.onCreateActionMode(getActionModeWrapper(paramActionMode), getMenuWrapper(paramMenu));
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode)
  {
    this.mWrappedCallback.onDestroyActionMode(getActionModeWrapper(paramActionMode));
  }
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return this.mWrappedCallback.onPrepareActionMode(getActionModeWrapper(paramActionMode), getMenuWrapper(paramMenu));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.view.SupportActionModeWrapper.CallbackWrapper
 * JD-Core Version:    0.7.0.1
 */