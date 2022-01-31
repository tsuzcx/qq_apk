package com.tencent.mobileqq.troop.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.data.FavOpenTroopInfo;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.widget.MenuPopupDialog;
import ehy;
import java.util.ArrayList;

public class FavOpenTroopActivity$TroopAdapter
  extends BaseAdapter
  implements View.OnClickListener, View.OnLongClickListener
{
  public FavOpenTroopActivity$TroopAdapter(FavOpenTroopActivity paramFavOpenTroopActivity) {}
  
  public int getCount()
  {
    if (this.a.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.a.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt < this.a.jdField_a_of_type_JavaUtilArrayList.size()) {
      return this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = this.a.d();
    paramViewGroup = paramView.getTag();
    if ((paramViewGroup instanceof FavOpenTroopActivity.CustomViewHolder)) {
      ((FavOpenTroopActivity.CustomViewHolder)paramViewGroup).a = paramInt;
    }
    this.a.a(paramView, (FavOpenTroopInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
    paramView.setOnClickListener(this);
    paramView.setOnLongClickListener(this);
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof FavOpenTroopActivity.CustomViewHolder)) {}
    for (int i = ((FavOpenTroopActivity.CustomViewHolder)paramView).a;; i = 2147483647)
    {
      if (i < this.a.jdField_a_of_type_JavaUtilArrayList.size()) {
        this.a.a(i);
      }
      return;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof FavOpenTroopActivity.CustomViewHolder))
    {
      int i = ((FavOpenTroopActivity.CustomViewHolder)localObject).a;
      if (i < this.a.jdField_a_of_type_JavaUtilArrayList.size()) {
        this.a.b = i;
      }
      localObject = new QQCustomMenu();
      ((QQCustomMenu)localObject).a(i, this.a.getString(2131363247));
      FavOpenTroopActivity.a(this.a, MenuPopupDialog.a(paramView, this.a.getString(2131363274), (QQCustomMenu)localObject, this.a.jdField_a_of_type_AndroidViewView$OnClickListener, new ehy(this, paramView)));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.FavOpenTroopActivity.TroopAdapter
 * JD-Core Version:    0.7.0.1
 */