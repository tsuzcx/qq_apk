package com.tencent.biz;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import bnj;
import com.tencent.image.URLDrawable;
import java.util.ArrayList;

public class PoiMapActivity$ShopListAdapter
  extends BaseAdapter
{
  public static final int a = 0;
  public static final int b = 1;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  int c;
  int d = 0;
  
  public PoiMapActivity$ShopListAdapter(PoiMapActivity paramPoiMapActivity)
  {
    this.jdField_c_of_type_Int = 0;
  }
  
  public PoiMapActivity.Shops a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return null;
    }
    return (PoiMapActivity.Shops)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.a((int)(PoiMapActivity.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity) * 1000000.0D), (int)(PoiMapActivity.b(this.jdField_a_of_type_ComTencentBizPoiMapActivity) * 1000000.0D), this.jdField_c_of_type_Int, 10);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.b(paramString);
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    if (this.jdField_c_of_type_Int != paramInt1) {
      return;
    }
    if (paramBoolean1) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0) {
      return i + j;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 1;
    int i = 8;
    if (this.d == 0) {
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPoiMapActivity).inflate(2130903421, null);
        paramViewGroup = new PoiMapActivity.ShopHolderView(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131232553));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131232555));
        paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131232550);
        paramViewGroup.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131232556);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131232557));
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131232558));
        paramViewGroup.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131232560));
        paramViewGroup.e = ((TextView)paramView.findViewById(2131232561));
        paramViewGroup.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131232552);
        paramViewGroup.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131232551);
        paramView.setTag(paramViewGroup);
        if (paramInt != this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label210;
        }
        paramViewGroup.jdField_c_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup.jdField_d_of_type_AndroidViewView.setVisibility(0);
        paramViewGroup = paramView;
      }
    }
    label210:
    Object localObject1;
    label405:
    label443:
    label448:
    do
    {
      return paramViewGroup;
      paramViewGroup = (PoiMapActivity.ShopHolderView)paramView.getTag();
      break;
      localObject1 = (PoiMapActivity.GeneralShops)a(paramInt);
      paramViewGroup.jdField_c_of_type_AndroidViewView.setVisibility(0);
      paramViewGroup.jdField_d_of_type_AndroidViewView.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((PoiMapActivity.GeneralShops)localObject1).e);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(((PoiMapActivity.GeneralShops)localObject1).a);
      if (!TextUtils.isEmpty(((PoiMapActivity.GeneralShops)localObject1).f))
      {
        localObject2 = URLDrawable.getDrawable(((PoiMapActivity.GeneralShops)localObject1).f);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
        ((URLDrawable)localObject2).setURLDrawableListener(new bnj(this, paramViewGroup.jdField_a_of_type_AndroidWidgetImageView));
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(((PoiMapActivity.GeneralShops)localObject1).jdField_b_of_type_JavaLangString);
        localObject2 = new SpannableString(((PoiMapActivity.GeneralShops)localObject1).jdField_c_of_type_JavaLangString);
        ((SpannableString)localObject2).setSpan(new StrikethroughSpan(), 0, ((PoiMapActivity.GeneralShops)localObject1).jdField_c_of_type_JavaLangString.length(), 33);
        paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        paramViewGroup.e.setText(((PoiMapActivity.GeneralShops)localObject1).d);
        localObject2 = paramViewGroup.jdField_b_of_type_AndroidViewView;
        if (((PoiMapActivity.GeneralShops)localObject1).jdField_c_of_type_Int != 0) {
          break label443;
        }
        paramInt = 8;
        ((View)localObject2).setVisibility(paramInt);
        paramViewGroup = paramViewGroup.jdField_a_of_type_AndroidViewView;
        if (((PoiMapActivity.GeneralShops)localObject1).jdField_b_of_type_Int != 0) {
          break label448;
        }
      }
      for (;;)
      {
        paramViewGroup.setVisibility(i);
        return paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        break;
        paramInt = 0;
        break label405;
        i = 0;
      }
      paramViewGroup = paramView;
    } while (this.d != 1);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPoiMapActivity).inflate(2130903422, null);
      paramViewGroup = new PoiMapActivity.ShopHolderView(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131232562));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131232553));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131232555));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131232550);
      paramViewGroup.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131232556);
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131232560));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131232564));
      paramViewGroup.g = ((TextView)paramView.findViewById(2131232563));
      paramView.setTag(paramViewGroup);
      localObject1 = (PoiMapActivity.SingleShops)a(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((PoiMapActivity.SingleShops)localObject1).e);
      if (TextUtils.isEmpty(((PoiMapActivity.SingleShops)localObject1).f)) {
        break label725;
      }
      localObject2 = URLDrawable.getDrawable(((PoiMapActivity.SingleShops)localObject1).f);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      paramInt = j;
      label662:
      if (paramInt > 5) {
        break label772;
      }
      localObject2 = new ImageView(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
      if (paramInt * 2 > ((PoiMapActivity.SingleShops)localObject1).d) {
        break label739;
      }
      ((ImageView)localObject2).setImageResource(2130838474);
    }
    for (;;)
    {
      paramInt += 1;
      break label662;
      paramViewGroup = (PoiMapActivity.ShopHolderView)paramView.getTag();
      break;
      label725:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramInt = j;
      break label662;
      label739:
      if (paramInt * 2 - 1 == ((PoiMapActivity.SingleShops)localObject1).d) {
        ((ImageView)localObject2).setImageResource(2130838473);
      } else {
        ((ImageView)localObject2).setImageResource(2130838472);
      }
    }
    label772:
    paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setText(((PoiMapActivity.SingleShops)localObject1).jdField_b_of_type_JavaLangString);
    paramViewGroup.g.setText(((PoiMapActivity.SingleShops)localObject1).jdField_c_of_type_JavaLangString);
    paramViewGroup.f.setText(((PoiMapActivity.SingleShops)localObject1).a);
    Object localObject2 = paramViewGroup.jdField_a_of_type_AndroidViewView;
    if (((PoiMapActivity.SingleShops)localObject1).jdField_b_of_type_Int == 0)
    {
      paramInt = 8;
      ((View)localObject2).setVisibility(paramInt);
      paramViewGroup = paramViewGroup.jdField_b_of_type_AndroidViewView;
      if (((PoiMapActivity.SingleShops)localObject1).jdField_c_of_type_Int != 0) {
        break label857;
      }
    }
    for (;;)
    {
      paramViewGroup.setVisibility(i);
      return paramView;
      paramInt = 0;
      break;
      label857:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.ShopListAdapter
 * JD-Core Version:    0.7.0.1
 */