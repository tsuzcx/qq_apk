package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.widget.XListView;
import eyn;
import eyq;
import eyr;
import eys;
import eyt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class TroopListAdapter2
  extends FacePreloadBaseAdapter
{
  public static final int a = 0;
  public static final int b = 1;
  public Context a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new eyq(this);
  public TroopListAdapter2.OnTroopListClickListener a;
  public QQAppInterface a;
  public SlideDetectListView a;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new eyr(this);
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  int c = 0;
  public int d;
  public int e;
  public int f;
  public int g;
  
  public TroopListAdapter2(Context paramContext, QQAppInterface paramQQAppInterface, TroopListAdapter2.OnTroopListClickListener paramOnTroopListClickListener, XListView paramXListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 4, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$OnTroopListClickListener = paramOnTroopListClickListener;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.c = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)paramXListView);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    if (paramBoolean) {
      a();
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47);
    this.jdField_b_of_type_JavaUtilList = ((TroopManager)localObject1).b();
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      return;
      Object localObject2 = new ArrayList();
      Object localObject3 = ((TroopManager)localObject1).b();
      if (localObject3 != null)
      {
        Collections.sort((List)localObject3, new eys(null));
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = ((TroopManager)localObject1).a(((CommonlyUsedTroop)((Iterator)localObject3).next()).troopUin);
          if (localObject4 != null) {
            ((List)localObject2).add(localObject4);
          }
        }
        this.g = ((List)localObject2).size();
      }
      Object localObject4 = new ArrayList();
      localObject3 = new ArrayList();
      localObject1 = new ArrayList();
      Object localObject5 = this.jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject5).hasNext())
      {
        Entity localEntity = (Entity)((Iterator)localObject5).next();
        i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((TroopInfo)localEntity).troopuin));
        if ((((TroopInfo)localEntity).dwAdditionalFlag & 1L) == 1L) {
          ((List)localObject4).add(new TroopListAdapter2.TroopListItemWithMask(this, i, localEntity));
        } else if ((((TroopInfo)localEntity).dwCmdUinUinFlag & 1L) == 1L) {
          ((List)localObject3).add(new TroopListAdapter2.TroopListItemWithMask(this, i, localEntity));
        } else {
          ((List)localObject1).add(new TroopListAdapter2.TroopListItemWithMask(this, i, localEntity));
        }
      }
      localObject5 = new eyt(null);
      Collections.sort((List)localObject4, (Comparator)localObject5);
      Collections.sort((List)localObject3, (Comparator)localObject5);
      Collections.sort((List)localObject1, (Comparator)localObject5);
      if (!((List)localObject2).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter2.TroopListItem(0, null));
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject5 = (Entity)((Iterator)localObject2).next();
          this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter2.TroopListItem(1, (Entity)localObject5));
        }
      }
      this.d = ((List)localObject4).size();
      if (this.d > 0)
      {
        this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter2.TroopListItem(4, null));
        localObject2 = ((List)localObject4).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (TroopListAdapter2.TroopListItemWithMask)((Iterator)localObject2).next();
          this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter2.TroopListItem(5, ((TroopListAdapter2.TroopListItemWithMask)localObject4).a));
        }
      }
      this.e = ((List)localObject3).size();
      if (this.e > 0)
      {
        this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter2.TroopListItem(6, null));
        localObject2 = ((List)localObject3).iterator();
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
    return this.jdField_b_of_type_JavaUtilList;
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
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903381, paramViewGroup, false);
      paramViewGroup = new TroopListAdapter2.TroopListViewItemTag(paramView);
      paramView.setTag(paramViewGroup);
      ((Button)paramView.findViewById(2131232385)).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      paramView.setOnLongClickListener(new eyn(this));
    }
    TextView localTextView;
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$TroopListItem = ((TroopListAdapter2.TroopListItem)localObject1);
      localObject2 = paramView.findViewById(2131232383);
      localTextView = (TextView)paramView.findViewById(2131232382);
      if (((TroopListAdapter2.TroopListItem)localObject1).i != 0) {
        break;
      }
      ((View)localObject2).setVisibility(8);
      localTextView.setVisibility(0);
      localTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131560390, new Object[] { String.valueOf(this.g) }));
      return paramView;
      paramViewGroup = (TroopListAdapter2.TroopListViewItemTag)paramView.getTag();
    }
    if (((TroopListAdapter2.TroopListItem)localObject1).i == 2)
    {
      ((View)localObject2).setVisibility(8);
      localTextView.setVisibility(0);
      localTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131560393, new Object[] { String.valueOf(this.f) }));
      return paramView;
    }
    if (((TroopListAdapter2.TroopListItem)localObject1).i == 4)
    {
      ((View)localObject2).setVisibility(8);
      localTextView.setVisibility(0);
      localTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131560391, new Object[] { String.valueOf(this.d) }));
      return paramView;
    }
    if (((TroopListAdapter2.TroopListItem)localObject1).i == 6)
    {
      ((View)localObject2).setVisibility(8);
      localTextView.setVisibility(0);
      localTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131560392, new Object[] { String.valueOf(this.e) }));
      return paramView;
    }
    ((View)localObject2).setVisibility(0);
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
        break label508;
      }
      localObject1 = ((TroopInfo)localObject2).troopname;
      label405:
      localTextView.setText((CharSequence)localObject1);
      localTextView = paramViewGroup.jdField_b_of_type_AndroidWidgetTextView;
      if (((TroopInfo)localObject2).troopmemo == null) {
        break label518;
      }
    }
    label518:
    for (localObject1 = ((TroopInfo)localObject2).troopmemo;; localObject1 = "")
    {
      localTextView.setText((CharSequence)localObject1);
      paramViewGroup.c.setImageBitmap(a(4, ((TroopInfo)localObject2).troopuin));
      if ((((TroopInfo)localObject2).dwGroupFlagExt & 0x800) == 0L) {
        break label567;
      }
      if (((TroopInfo)localObject2).dwAuthGroupType != 2L) {
        break label526;
      }
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838181);
      return paramView;
      paramInt = 0;
      break;
      label508:
      localObject1 = ((TroopInfo)localObject2).troopcode;
      break label405;
    }
    label526:
    if (((TroopInfo)localObject2).dwAuthGroupType == 1L)
    {
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838357);
      return paramView;
    }
    paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    return paramView;
    label567:
    paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    return paramView;
  }
  
  public void notifyDataSetChanged()
  {
    a();
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.TroopListAdapter2
 * JD-Core Version:    0.7.0.1
 */