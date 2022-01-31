package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cok;
import col;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class TroopListInnerFrame$TroopListAdapter
  extends FacePreloadBaseAdapter
{
  public int a;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  public int b;
  public int c;
  public int d;
  
  public TroopListInnerFrame$TroopListAdapter(TroopListInnerFrame paramTroopListInnerFrame, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramInt, paramBoolean);
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    TroopListInnerFrame.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame);
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44);
    Object localObject3 = new ArrayList();
    Object localObject2 = new ArrayList();
    localObject1 = new ArrayList();
    Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject4).hasNext())
    {
      Entity localEntity = (Entity)((Iterator)localObject4).next();
      int i = a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((TroopInfo)localEntity).troopuin));
      if ((((TroopInfo)localEntity).dwAdditionalFlag & 1L) == 1L) {
        ((List)localObject3).add(new TroopListInnerFrame.TroopListAdapter.TroopListItemWithMask(this, i, localEntity));
      } else if ((((TroopInfo)localEntity).dwCmdUinUinFlag & 1L) == 1L) {
        ((List)localObject2).add(new TroopListInnerFrame.TroopListAdapter.TroopListItemWithMask(this, i, localEntity));
      } else {
        ((List)localObject1).add(new TroopListInnerFrame.TroopListAdapter.TroopListItemWithMask(this, i, localEntity));
      }
    }
    localObject4 = new cok(this, null);
    Collections.sort((List)localObject3, (Comparator)localObject4);
    Collections.sort((List)localObject2, (Comparator)localObject4);
    Collections.sort((List)localObject1, (Comparator)localObject4);
    this.jdField_a_of_type_Int = ((List)localObject3).size();
    if (this.jdField_a_of_type_Int > 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(new TroopListInnerFrame.TroopListAdapter.TroopListItem(this, 4, null));
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (TroopListInnerFrame.TroopListAdapter.TroopListItemWithMask)((Iterator)localObject3).next();
        this.jdField_a_of_type_JavaUtilList.add(new TroopListInnerFrame.TroopListAdapter.TroopListItem(this, 5, ((TroopListInnerFrame.TroopListAdapter.TroopListItemWithMask)localObject4).a));
      }
    }
    this.b = ((List)localObject2).size();
    if (this.b > 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(new TroopListInnerFrame.TroopListAdapter.TroopListItem(this, 6, null));
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (TroopListInnerFrame.TroopListAdapter.TroopListItemWithMask)((Iterator)localObject2).next();
        this.jdField_a_of_type_JavaUtilList.add(new TroopListInnerFrame.TroopListAdapter.TroopListItem(this, 7, ((TroopListInnerFrame.TroopListAdapter.TroopListItemWithMask)localObject3).a));
      }
    }
    this.c = ((List)localObject1).size();
    if (this.c > 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(new TroopListInnerFrame.TroopListAdapter.TroopListItem(this, 2, null));
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TroopListInnerFrame.TroopListAdapter.TroopListItemWithMask)((Iterator)localObject1).next();
        this.jdField_a_of_type_JavaUtilList.add(new TroopListInnerFrame.TroopListAdapter.TroopListItem(this, 3, ((TroopListInnerFrame.TroopListAdapter.TroopListItemWithMask)localObject2).a));
      }
    }
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return 1;
    case 4: 
      return 2;
    case 2: 
      return 3;
    }
    return 4;
  }
  
  protected Object a(int paramInt)
  {
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    localFaceInfo.jdField_a_of_type_JavaLangString = ((TroopInfo)getItem(paramInt)).troopuin;
    localFaceInfo.jdField_a_of_type_Int = 4;
    return localFaceInfo;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TroopListInnerFrame.TroopListAdapter.TroopListItem localTroopListItem = (TroopListInnerFrame.TroopListAdapter.TroopListItem)getItem(paramInt);
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject1 = (col)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject1;
    }
    for (;;)
    {
      localObject1 = paramViewGroup.findViewById(2131297673);
      localObject2 = (TextView)paramViewGroup.findViewById(2131297672);
      if (localTroopListItem.i != 0) {
        break;
      }
      ((View)localObject1).setVisibility(8);
      ((TextView)localObject2).setVisibility(0);
      ((TextView)localObject2).setText(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame.jdField_a_of_type_AndroidContentContext.getString(2131362301, new Object[] { String.valueOf(this.d) }));
      return paramViewGroup;
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903638, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false);
      paramView = new col(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame, null);
      paramView.b = ((ImageView)paramViewGroup.findViewById(2131296442));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297602));
      paramViewGroup.setTag(paramView);
    }
    if (localTroopListItem.i == 2)
    {
      ((View)localObject1).setVisibility(8);
      ((TextView)localObject2).setVisibility(0);
      ((TextView)localObject2).setText(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame.jdField_a_of_type_AndroidContentContext.getString(2131362304, new Object[] { String.valueOf(this.c) }));
      return paramViewGroup;
    }
    if (localTroopListItem.i == 4)
    {
      ((View)localObject1).setVisibility(8);
      ((TextView)localObject2).setVisibility(0);
      ((TextView)localObject2).setText(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame.jdField_a_of_type_AndroidContentContext.getString(2131362302, new Object[] { String.valueOf(this.jdField_a_of_type_Int) }));
      return paramViewGroup;
    }
    if (localTroopListItem.i == 6)
    {
      ((View)localObject1).setVisibility(8);
      ((TextView)localObject2).setVisibility(0);
      ((TextView)localObject2).setText(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame.jdField_a_of_type_AndroidContentContext.getString(2131362303, new Object[] { String.valueOf(this.b) }));
      return paramViewGroup;
    }
    ((View)localObject1).setVisibility(0);
    ((TextView)localObject2).setVisibility(8);
    Object localObject2 = localTroopListItem.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
    paramView.jdField_a_of_type_JavaLangString = ((TroopInfo)localObject2).troopuin;
    TextView localTextView = paramView.jdField_a_of_type_AndroidWidgetTextView;
    if (((TroopInfo)localObject2).troopname != null) {}
    for (Object localObject1 = ((TroopInfo)localObject2).troopname;; localObject1 = ((TroopInfo)localObject2).troopcode)
    {
      localTextView.setText((CharSequence)localObject1);
      paramView.b.setImageBitmap(a(4, ((TroopInfo)localObject2).troopuin));
      paramView.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject2);
      paramView.jdField_a_of_type_Int = localTroopListItem.i;
      paramViewGroup.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame);
      return paramViewGroup;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopListInnerFrame.TroopListAdapter
 * JD-Core Version:    0.7.0.1
 */