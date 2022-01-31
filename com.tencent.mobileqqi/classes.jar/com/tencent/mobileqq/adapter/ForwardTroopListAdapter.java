package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQServiceEntry.Tag;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import fcw;
import fcx;
import java.util.Collections;
import java.util.List;

public class ForwardTroopListAdapter
  extends BaseAdapter
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  public Context a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public QQAppInterface a;
  List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = true;
  
  public ForwardTroopListAdapter(QQAppInterface paramQQAppInterface, Context paramContext, List paramList)
  {
    this(paramQQAppInterface, paramContext, paramList, 2130903146);
  }
  
  public ForwardTroopListAdapter(QQAppInterface paramQQAppInterface, Context paramContext, List paramList, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (paramList == null)) {
      throw new NullPointerException();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    Collections.sort(this.jdField_a_of_type_JavaUtilList, new fcx(this));
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(List paramList)
  {
    if (paramList == null) {
      throw new NullPointerException();
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
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
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(this.jdField_a_of_type_Int, paramViewGroup, false);
    }
    TroopInfo localTroopInfo = (TroopInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    String str = localTroopInfo.troopuin;
    paramViewGroup = (TextView)localView.findViewById(2131231395);
    paramView = (TextView)localView.findViewById(2131231396);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return localView;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    long l = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences((String)localObject1, 0).getLong((String)localObject1 + str, 1L);
    localObject1 = (ImageView)localView.findViewById(2131230940);
    Object localObject2 = (ImageView)localView.findViewById(2131231394);
    localView.setBackgroundResource(2130837848);
    if (localObject2 != null)
    {
      if (l == 1L) {
        ((ImageView)localObject2).setVisibility(4);
      }
    }
    else
    {
      localObject2 = localTroopInfo.troopname;
      if (localObject2 == null) {
        break label324;
      }
      paramViewGroup.setText((CharSequence)localObject2);
      label190:
      ViewUtils.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup, paramViewGroup.getText().toString(), 50);
      paramViewGroup = localTroopInfo.troopmemo;
      if (paramView != null)
      {
        if (paramViewGroup == null) {
          break label333;
        }
        paramView.setText(paramViewGroup);
      }
      label228:
      paramViewGroup = (QQServiceEntry.Tag)((ImageView)localObject1).getTag();
      paramView = paramViewGroup;
      if (paramViewGroup == null) {
        paramView = new QQServiceEntry.Tag();
      }
      paramView.a = str;
      paramView.b = ((String)localObject2);
      ((ImageView)localObject1).setTag(paramView);
      ((ImageView)localObject1).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localTroopInfo.troopuin));
      if (!this.jdField_a_of_type_Boolean) {
        break label342;
      }
      ((ImageView)localObject1).setOnClickListener(new fcw(this));
    }
    for (;;)
    {
      localView.setTag(paramView);
      return localView;
      ((ImageView)localObject2).setVisibility(0);
      break;
      label324:
      paramViewGroup.setText(str);
      break label190;
      label333:
      paramView.setText("");
      break label228;
      label342:
      ((ImageView)localObject1).setClickable(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ForwardTroopListAdapter
 * JD-Core Version:    0.7.0.1
 */