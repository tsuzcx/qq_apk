package android.support.v7.view.menu;

import android.support.annotation.RestrictTo;
import android.support.v7.appcompat.R.layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class MenuAdapter
  extends BaseAdapter
{
  static final int ITEM_LAYOUT = R.layout.abc_popup_menu_item_layout;
  MenuBuilder mAdapterMenu;
  private int mExpandedIndex = -1;
  private boolean mForceShowIcon;
  private final LayoutInflater mInflater;
  private final boolean mOverflowOnly;
  
  public MenuAdapter(MenuBuilder paramMenuBuilder, LayoutInflater paramLayoutInflater, boolean paramBoolean)
  {
    this.mOverflowOnly = paramBoolean;
    this.mInflater = paramLayoutInflater;
    this.mAdapterMenu = paramMenuBuilder;
    findExpandedIndex();
  }
  
  void findExpandedIndex()
  {
    MenuItemImpl localMenuItemImpl = this.mAdapterMenu.getExpandedItem();
    if (localMenuItemImpl != null)
    {
      ArrayList localArrayList = this.mAdapterMenu.getNonActionItems();
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        if ((MenuItemImpl)localArrayList.get(i) == localMenuItemImpl)
        {
          this.mExpandedIndex = i;
          return;
        }
        i += 1;
      }
    }
    this.mExpandedIndex = -1;
  }
  
  public MenuBuilder getAdapterMenu()
  {
    return this.mAdapterMenu;
  }
  
  public int getCount()
  {
    if (this.mOverflowOnly) {}
    for (ArrayList localArrayList = this.mAdapterMenu.getNonActionItems(); this.mExpandedIndex < 0; localArrayList = this.mAdapterMenu.getVisibleItems()) {
      return localArrayList.size();
    }
    return localArrayList.size() - 1;
  }
  
  public boolean getForceShowIcon()
  {
    return this.mForceShowIcon;
  }
  
  public MenuItemImpl getItem(int paramInt)
  {
    if (this.mOverflowOnly) {}
    for (ArrayList localArrayList = this.mAdapterMenu.getNonActionItems();; localArrayList = this.mAdapterMenu.getVisibleItems())
    {
      int i = paramInt;
      if (this.mExpandedIndex >= 0)
      {
        i = paramInt;
        if (paramInt >= this.mExpandedIndex) {
          i = paramInt + 1;
        }
      }
      return (MenuItemImpl)localArrayList.get(i);
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = this.mInflater.inflate(ITEM_LAYOUT, paramViewGroup, false);
    }
    for (;;)
    {
      paramViewGroup = (MenuView.ItemView)paramView;
      if (this.mForceShowIcon) {
        ((ListMenuItemView)paramView).setForceShowIcon(true);
      }
      paramViewGroup.initialize(getItem(paramInt), 0);
      return paramView;
    }
  }
  
  public void notifyDataSetChanged()
  {
    findExpandedIndex();
    super.notifyDataSetChanged();
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    this.mForceShowIcon = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.view.menu.MenuAdapter
 * JD-Core Version:    0.7.0.1
 */