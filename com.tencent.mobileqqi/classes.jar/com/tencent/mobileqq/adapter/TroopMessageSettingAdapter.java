package com.tencent.mobileqq.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TroopMessageSettingAdapter
  extends BaseExpandableListAdapter
{
  public static final String a;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List jdField_a_of_type_JavaUtilList;
  private Map jdField_a_of_type_JavaUtilMap;
  private int b;
  private int c;
  private int d;
  
  static
  {
    jdField_a_of_type_JavaLangString = UUID.randomUUID().toString();
  }
  
  public TroopMessageSettingAdapter(Context paramContext, QQAppInterface paramQQAppInterface, List paramList, Map paramMap)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131427387);
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131427388);
    this.c = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131427389);
    this.d = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131427390);
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(1));
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(4));
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2));
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(3));
    paramContext = paramList;
    if (paramList == null) {
      paramContext = new ArrayList();
    }
    paramQQAppInterface = paramMap;
    if (paramMap == null) {
      paramQQAppInterface = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilList = paramContext;
    this.jdField_a_of_type_JavaUtilMap = paramQQAppInterface;
    a(this.jdField_a_of_type_JavaUtilList);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopMessageSettingAdapter", 2, "setItemBackground() childPos = " + paramInt1 + ", listSize = " + paramInt2);
    }
    if (paramInt2 <= 1)
    {
      paramView.setBackgroundResource(2130837877);
      return;
    }
    if (paramInt1 == 0)
    {
      paramView.setBackgroundResource(2130837882);
      return;
    }
    if (paramInt1 == paramInt2 - 1)
    {
      paramView.setBackgroundResource(2130837879);
      return;
    }
    paramView.setBackgroundResource(2130837881);
  }
  
  private void a(List paramList)
  {
    int i = 0;
    for (;;)
    {
      TroopInfo localTroopInfo;
      if (i < paramList.size())
      {
        if (paramList.get(i) == null) {
          break label214;
        }
        localTroopInfo = (TroopInfo)paramList.get(i);
        if (localTroopInfo != null) {}
      }
      else
      {
        paramList = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (paramList.hasNext())
        {
          i = ((Integer)paramList.next()).intValue();
          if (this.jdField_a_of_type_AndroidUtilSparseArray.get(i) == null)
          {
            localTroopInfo = new TroopInfo();
            localTroopInfo.troopuin = jdField_a_of_type_JavaLangString;
            localTroopInfo.troopname = this.jdField_a_of_type_AndroidContentContext.getString(2131562481);
            this.jdField_a_of_type_AndroidUtilSparseArray.put(i, new ArrayList());
            ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(i)).add(localTroopInfo);
          }
        }
      }
      int j = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(localTroopInfo.troopuin)).intValue();
      if (this.jdField_a_of_type_AndroidUtilSparseArray.get(j) == null) {
        this.jdField_a_of_type_AndroidUtilSparseArray.put(j, new ArrayList());
      }
      ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(j)).add(localTroopInfo);
      label214:
      i += 1;
    }
  }
  
  public TextView a()
  {
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    localTextView.setLayoutParams(localLayoutParams);
    localTextView.setGravity(19);
    localTextView.setPadding(this.b, this.jdField_a_of_type_Int, this.d, this.c);
    localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131361798));
    return localTextView;
  }
  
  public TroopInfo a(int paramInt1, int paramInt2)
  {
    return (TroopInfo)((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(a(paramInt1).intValue())).get(paramInt2);
  }
  
  public Integer a(int paramInt)
  {
    return (Integer)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a(Map paramMap)
  {
    if (paramMap == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  @TargetApi(8)
  public int getChildType(int paramInt1, int paramInt2)
  {
    TroopInfo localTroopInfo = a(paramInt1, paramInt2);
    if ((localTroopInfo != null) && (jdField_a_of_type_JavaLangString.equals(localTroopInfo.troopuin))) {
      return 1;
    }
    return 0;
  }
  
  public int getChildTypeCount()
  {
    return 2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = a(paramInt1, paramInt2);
    int i = getChildType(paramInt1, paramInt2);
    if (i == 1) {
      if (paramView != null) {
        if (((Integer)paramView.getTag()).intValue() == 1)
        {
          paramViewGroup = (TextView)paramView.findViewById(2131234483);
          paramViewGroup.setEnabled(false);
          if (!TextUtils.isEmpty(((TroopInfo)localObject).troopname)) {
            break label268;
          }
        }
      }
    }
    label268:
    for (localObject = ((TroopInfo)localObject).troopuin;; localObject = ((TroopInfo)localObject).troopname)
    {
      paramViewGroup.setText((CharSequence)localObject);
      paramView.setTag(Integer.valueOf(i));
      return paramView;
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903979, null);
      break;
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903979, null);
      break;
      if (paramView != null) {
        if (((Integer)paramView.getTag()).intValue() != 0) {}
      }
      for (;;)
      {
        paramViewGroup = (TextView)paramView.findViewById(2131234483);
        ImageView localImageView = (ImageView)paramView.findViewById(2131234482);
        localImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((TroopInfo)localObject).troopuin));
        localImageView.setVisibility(0);
        paramView.findViewById(2131234484).setVisibility(0);
        a(paramView, paramInt2, getChildrenCount(paramInt1));
        break;
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903978, null);
        continue;
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903978, null);
      }
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    List localList = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(a(paramInt).intValue());
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public int getGroupCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public int getGroupType(int paramInt)
  {
    return paramInt;
  }
  
  public int getGroupTypeCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null) {}
    for (int i = ((Integer)paramView.getTag()).intValue();; i = -1)
    {
      View localView;
      if (paramView != null)
      {
        localView = paramView;
        if (i != -1)
        {
          localView = paramView;
          if (i == a(paramInt).intValue()) {}
        }
      }
      else
      {
        i = 0;
        switch (a(paramInt).intValue())
        {
        }
      }
      for (;;)
      {
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(i, null);
        localView.setTag(a(paramInt));
        return localView;
        i = 2130904016;
        continue;
        i = 2130904019;
        continue;
        i = 2130904017;
        continue;
        i = 2130904018;
      }
    }
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    a(this.jdField_a_of_type_JavaUtilList);
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.TroopMessageSettingAdapter
 * JD-Core Version:    0.7.0.1
 */