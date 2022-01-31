package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.emoticonview.PanelRecycleBin;
import com.tencent.qphone.base.util.QLog;
import ebn;
import java.util.ArrayList;

public class PanelAdapter
  extends PagerAdapter
{
  int jdField_a_of_type_Int = 3;
  Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  PanelRecycleBin jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin = new PanelRecycleBin();
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  int b = 2;
  
  public PanelAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(int paramInt, ebn paramebn)
  {
    int m = this.jdField_a_of_type_Int;
    int n = this.b;
    paramebn.jdField_a_of_type_Int = paramInt;
    int j = 0;
    int i = 0;
    while (j < this.b)
    {
      LinearLayout localLinearLayout = (LinearLayout)paramebn.getChildAt(j);
      int k = 0;
      if (k < this.jdField_a_of_type_Int)
      {
        View localView = localLinearLayout.getChildAt(k);
        PanelAdapter.ViewHolder localViewHolder = (PanelAdapter.ViewHolder)localView.getTag();
        int i1 = m * n * paramInt + i;
        if (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          PlusPanel.PluginData localPluginData = (PlusPanel.PluginData)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localPluginData.jdField_a_of_type_JavaLangString);
          if (localPluginData.jdField_a_of_type_Boolean)
          {
            localViewHolder.b.setVisibility(0);
            label153:
            localViewHolder.jdField_a_of_type_Int = localPluginData.jdField_a_of_type_Int;
            localView.setContentDescription(localPluginData.b);
            localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          }
        }
        for (;;)
        {
          i += 1;
          k += 1;
          break;
          localViewHolder.b.setVisibility(8);
          break label153;
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
          localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(null);
          localViewHolder.b.setVisibility(8);
          localViewHolder.jdField_a_of_type_Int = 0;
          localView.setContentDescription(null);
          localView.setOnClickListener(null);
        }
      }
      j += 1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View.OnClickListener a()
  {
    return this.jdField_a_of_type_AndroidViewView$OnClickListener;
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
    for (;;)
    {
      return;
      if (paramInt >= 0)
      {
        int i = 0;
        while (i < this.jdField_a_of_type_AndroidViewViewGroup.getChildCount())
        {
          ebn localebn = (ebn)this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i);
          if ((localebn != null) && (paramInt == localebn.jdField_a_of_type_Int))
          {
            a(paramInt, localebn);
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    ebn localebn = (ebn)paramObject;
    ((ViewGroup)paramView).removeView(localebn);
    localebn.a();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin.a((View)paramObject);
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_Int == 0) || (this.b == 0) || (this.jdField_a_of_type_JavaUtilArrayList == null)) {
      return 0;
    }
    return (this.jdField_a_of_type_JavaUtilArrayList.size() + this.jdField_a_of_type_Int * this.b - 1) / (this.jdField_a_of_type_Int * this.b);
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    QLog.d("PanelIconAdapter", 2, "instantiateItem " + paramInt);
    ebn localebn2 = (ebn)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin.a();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
    ebn localebn1 = localebn2;
    if (localebn2 == null) {
      localebn1 = new ebn(this, this.jdField_a_of_type_AndroidContentContext, null);
    }
    localebn1.jdField_a_of_type_Int = paramInt;
    a(paramInt, localebn1);
    if ((localebn1.getParent() != paramView) && (paramInt < getCount())) {
      ((ViewGroup)paramView).addView(localebn1);
    }
    return localebn1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PanelAdapter
 * JD-Core Version:    0.7.0.1
 */