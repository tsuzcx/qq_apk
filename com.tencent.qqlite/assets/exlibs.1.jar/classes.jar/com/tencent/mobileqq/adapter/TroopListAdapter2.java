package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.widget.XListView;
import cqo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TroopListAdapter2
  extends FacePreloadBaseAdapter
{
  public static final int a = 0;
  public static final int b = 1;
  Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new cqo(this);
  public TroopListAdapter2.OnTroopListClickListener a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected TroopManager a;
  protected TroopObserver a;
  SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView;
  protected HashMap a;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  protected boolean a;
  private List b = new ArrayList();
  int c = 0;
  public int d;
  public int e;
  public int f;
  
  public TroopListAdapter2(Context paramContext, QQAppInterface paramQQAppInterface, TroopListAdapter2.OnTroopListClickListener paramOnTroopListClickListener, XListView paramXListView, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 4, true);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$OnTroopListClickListener = paramOnTroopListClickListener;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.c = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)paramXListView);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)paramQQAppInterface.getManager(44));
    if (paramBoolean1) {
      a();
    }
  }
  
  public static int a(int paramInt)
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
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilHashMap != null)) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    this.b = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44)).b();
    if (this.b == null) {
      this.b = new ArrayList();
    }
    for (;;)
    {
      return;
      Object localObject3 = new ArrayList();
      Object localObject2 = new ArrayList();
      Object localObject1 = new ArrayList();
      Object localObject4 = this.b.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        Entity localEntity = (Entity)((Iterator)localObject4).next();
        int i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((TroopInfo)localEntity).troopuin));
        if ((((TroopInfo)localEntity).dwAdditionalFlag & 1L) == 1L) {
          ((List)localObject3).add(new TroopListAdapter2.TroopListItemWithMask(i, localEntity));
        } else if ((((TroopInfo)localEntity).dwCmdUinUinFlag & 1L) == 1L) {
          ((List)localObject2).add(new TroopListAdapter2.TroopListItemWithMask(i, localEntity));
        } else {
          ((List)localObject1).add(new TroopListAdapter2.TroopListItemWithMask(i, localEntity));
        }
      }
      localObject4 = new TroopListAdapter2.TroopCompator();
      Collections.sort((List)localObject3, (Comparator)localObject4);
      Collections.sort((List)localObject2, (Comparator)localObject4);
      Collections.sort((List)localObject1, (Comparator)localObject4);
      this.d = ((List)localObject3).size();
      if (this.d > 0)
      {
        this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter2.TroopListItem(4, null));
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (TroopListAdapter2.TroopListItemWithMask)((Iterator)localObject3).next();
          this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter2.TroopListItem(5, ((TroopListAdapter2.TroopListItemWithMask)localObject4).a));
        }
      }
      this.e = ((List)localObject2).size();
      if (this.e > 0)
      {
        this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter2.TroopListItem(6, null));
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (TroopListAdapter2.TroopListItemWithMask)((Iterator)localObject2).next();
          this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter2.TroopListItem(7, ((TroopListAdapter2.TroopListItemWithMask)localObject3).a));
        }
      }
      this.f = ((List)localObject1).size();
      if (this.f > 0)
      {
        this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter2.TroopListItem(2, null));
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (TroopListAdapter2.TroopListItemWithMask)((Iterator)localObject1).next();
          this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter2.TroopListItem(3, ((TroopListAdapter2.TroopListItemWithMask)localObject2).a));
        }
      }
    }
  }
  
  public TroopInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return ((TroopListAdapter2.TroopListItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a;
    }
    return null;
  }
  
  protected Object a(int paramInt)
  {
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    if ((getItem(paramInt) instanceof TroopInfo))
    {
      localFaceInfo.jdField_a_of_type_JavaLangString = ((TroopInfo)getItem(paramInt)).troopuin;
      localFaceInfo.jdField_a_of_type_Int = 4;
    }
    return localFaceInfo;
  }
  
  public List a()
  {
    return this.b;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = (TroopListAdapter2.TroopListItem)getItem(paramInt);
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903317, paramViewGroup, false);
      paramViewGroup = new TroopListAdapter2.TroopListViewItemTag(paramView);
      paramView.setTag(paramViewGroup);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    TextView localTextView;
    ImageView localImageView;
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$TroopListItem = ((TroopListAdapter2.TroopListItem)localObject1);
      localObject2 = paramView.findViewById(2131297673);
      localTextView = (TextView)paramView.findViewById(2131297672);
      localImageView = (ImageView)paramView.findViewById(2131297402);
      if (((TroopListAdapter2.TroopListItem)localObject1).g != 2) {
        break;
      }
      ((View)localObject2).setVisibility(8);
      localImageView.setVisibility(8);
      localTextView.setVisibility(0);
      localTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131362304, new Object[] { String.valueOf(this.f) }));
      return paramView;
      paramViewGroup = (TroopListAdapter2.TroopListViewItemTag)paramView.getTag();
    }
    if (((TroopListAdapter2.TroopListItem)localObject1).g == 4)
    {
      ((View)localObject2).setVisibility(8);
      localImageView.setVisibility(8);
      localTextView.setVisibility(0);
      localTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131362302, new Object[] { String.valueOf(this.d) }));
      return paramView;
    }
    if (((TroopListAdapter2.TroopListItem)localObject1).g == 6)
    {
      ((View)localObject2).setVisibility(8);
      localImageView.setVisibility(8);
      localTextView.setVisibility(0);
      localTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131362303, new Object[] { String.valueOf(this.e) }));
      return paramView;
    }
    ((View)localObject2).setVisibility(0);
    localImageView.setVisibility(0);
    localTextView.setVisibility(8);
    Object localObject2 = ((TroopListAdapter2.TroopListItem)localObject1).a;
    paramViewGroup.jdField_a_of_type_JavaLangString = ((TroopInfo)localObject2).troopuin;
    paramInt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((TroopInfo)localObject2).troopuin);
    localObject1 = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
    if (paramInt != 3)
    {
      paramInt = 4;
      ((ImageView)localObject1).setVisibility(paramInt);
      localTextView = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
      if (((TroopInfo)localObject2).troopname == null) {
        break label464;
      }
      localObject1 = ((TroopInfo)localObject2).troopname;
      label361:
      localTextView.setText((CharSequence)localObject1);
      localTextView = paramViewGroup.jdField_b_of_type_AndroidWidgetTextView;
      if (((TroopInfo)localObject2).troopmemo == null) {
        break label474;
      }
    }
    label464:
    label474:
    for (localObject1 = ((TroopInfo)localObject2).troopmemo;; localObject1 = "")
    {
      localTextView.setText((CharSequence)localObject1);
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(a(4, ((TroopInfo)localObject2).troopuin));
      if ((((TroopInfo)localObject2).dwGroupFlagExt & 0x800) == 0L) {
        break label523;
      }
      if (((TroopInfo)localObject2).dwAuthGroupType != 2L) {
        break label482;
      }
      paramViewGroup.c.setVisibility(0);
      paramViewGroup.c.setBackgroundResource(2130838196);
      return paramView;
      paramInt = 0;
      break;
      localObject1 = ((TroopInfo)localObject2).troopcode;
      break label361;
    }
    label482:
    if (((TroopInfo)localObject2).dwAuthGroupType == 1L)
    {
      paramViewGroup.c.setVisibility(0);
      paramViewGroup.c.setBackgroundResource(2130838257);
      return paramView;
    }
    paramViewGroup.c.setVisibility(8);
    return paramView;
    label523:
    paramViewGroup.c.setVisibility(8);
    return paramView;
  }
  
  public void notifyDataSetChanged()
  {
    a();
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.TroopListAdapter2
 * JD-Core Version:    0.7.0.1
 */