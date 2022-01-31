package com.tencent.widget;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import fjz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ActionSheetAdapter
  extends BaseAdapter
{
  public static final int a = -1;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  Context jdField_a_of_type_AndroidContentContext;
  final List jdField_a_of_type_JavaUtilList;
  
  public ActionSheetAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static ActionSheet a(Context paramContext, ActionSheetAdapter paramActionSheetAdapter, AdapterView.OnItemClickListener paramOnItemClickListener, DialogInterface.OnDismissListener paramOnDismissListener, ActionSheet.OnButtonClickListener paramOnButtonClickListener, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      if (paramActionSheetAdapter == null) {
        return null;
      }
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(paramContext, null, 2131624120);
      localActionSheet.a(2131364523);
      GridView localGridView = (GridView)View.inflate(paramContext, 2130903693, null);
      localGridView.setBackgroundResource(2130839345);
      localGridView.setAdapter(paramActionSheetAdapter);
      localGridView.setOnItemClickListener(paramOnItemClickListener);
      paramContext = new ImageView(paramContext);
      paramContext.setLayoutParams(new ViewGroup.LayoutParams(-1, 1));
      paramContext.setBackgroundResource(2130838010);
      localActionSheet.a(paramContext);
      localActionSheet.a(localGridView);
      localActionSheet.d(2131362801);
      if (paramBoolean) {
        localActionSheet.setOnDismissListener(new fjz(paramOnDismissListener));
      }
      for (;;)
      {
        localActionSheet.a(paramOnButtonClickListener);
        return localActionSheet;
        localActionSheet.setOnDismissListener(paramOnDismissListener);
      }
    }
    return null;
  }
  
  public static ActionSheetAdapter.ShareChanelInfo a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt <= 4) {
        localObject1 = new ActionSheetAdapter.ShareChanelInfo();
      }
    }
    switch (paramInt)
    {
    default: 
      return localObject1;
    case 2: 
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).a = 2;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).b = 2131363695;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).c = 2130837693;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).d = 2131363718;
      return localObject1;
    case 1: 
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).a = 1;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).b = 2131363696;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).c = 2130837695;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).d = 2131363719;
      return localObject1;
    case 0: 
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).a = 0;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).b = 2131362965;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).c = 2130839071;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).d = 2131363720;
      return localObject1;
    case 4: 
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).a = 4;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).b = 2131362426;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).c = 2130838258;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).d = 2131363721;
      return localObject1;
    }
    ((ActionSheetAdapter.ShareChanelInfo)localObject1).a = 3;
    ((ActionSheetAdapter.ShareChanelInfo)localObject1).c = 2130837692;
    ((ActionSheetAdapter.ShareChanelInfo)localObject1).b = 2131363701;
    ((ActionSheetAdapter.ShareChanelInfo)localObject1).d = 2131363722;
    return localObject1;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ActionSheetAdapter.ShareChanelInfo localShareChanelInfo = (ActionSheetAdapter.ShareChanelInfo)paramList.next();
        if ((localShareChanelInfo != null) && (localShareChanelInfo.a >= 0)) {
          this.jdField_a_of_type_JavaUtilList.add(localShareChanelInfo);
        }
      }
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    ActionSheetAdapter.ShareChanelInfo localShareChanelInfo = (ActionSheetAdapter.ShareChanelInfo)getItem(paramInt);
    if (localShareChanelInfo != null) {
      return localShareChanelInfo.a;
    }
    return -1L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ActionSheetAdapter.ShareChanelInfo localShareChanelInfo = (ActionSheetAdapter.ShareChanelInfo)getItem(paramInt);
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903682, null);
    }
    paramView = (ImageView)paramViewGroup.findViewById(2131297783);
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131297784);
    if (localShareChanelInfo != null)
    {
      paramView.setImageResource(localShareChanelInfo.c);
      localTextView.setText(localShareChanelInfo.b);
    }
    while (localShareChanelInfo != null)
    {
      paramViewGroup.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(localShareChanelInfo.d));
      return paramViewGroup;
      paramView.setImageResource(2130839071);
      localTextView.setText("");
    }
    paramViewGroup.setContentDescription("");
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.widget.ActionSheetAdapter
 * JD-Core Version:    0.7.0.1
 */