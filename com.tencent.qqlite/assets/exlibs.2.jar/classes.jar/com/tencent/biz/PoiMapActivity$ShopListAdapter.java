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
import com.tencent.image.URLDrawable;
import java.util.ArrayList;
import kn;

public class PoiMapActivity$ShopListAdapter
  extends BaseAdapter
{
  public static final int a = 0;
  public static final int b = 1;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean;
  int c = 0;
  int d = 0;
  
  public PoiMapActivity$ShopListAdapter(PoiMapActivity paramPoiMapActivity) {}
  
  public PoiMapActivity.Shops a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return null;
    }
    return (PoiMapActivity.Shops)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    if (this.c != paramInt1) {
      return;
    }
    if (paramBoolean1) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    this.c = paramInt2;
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
    int i = 1;
    if (this.d == 0) {
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPoiMapActivity).inflate(2130903349, null);
        paramViewGroup = new PoiMapActivity.ShopHolderView(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297803));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297805));
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297806));
        paramViewGroup.c = ((TextView)paramView.findViewById(2131297807));
        paramViewGroup.d = ((TextView)paramView.findViewById(2131297809));
        paramViewGroup.e = ((TextView)paramView.findViewById(2131297810));
        paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131297802);
        paramViewGroup.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131297801);
        paramView.setTag(paramViewGroup);
        if (paramInt != this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label186;
        }
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(0);
        paramViewGroup = paramView;
      }
    }
    label186:
    Object localObject1;
    Object localObject2;
    do
    {
      return paramViewGroup;
      paramViewGroup = (PoiMapActivity.ShopHolderView)paramView.getTag();
      break;
      localObject1 = (PoiMapActivity.GeneralShops)a(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((PoiMapActivity.GeneralShops)localObject1).e);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(((PoiMapActivity.GeneralShops)localObject1).a);
      if (!TextUtils.isEmpty(((PoiMapActivity.GeneralShops)localObject1).f))
      {
        localObject2 = URLDrawable.getDrawable(((PoiMapActivity.GeneralShops)localObject1).f);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
        ((URLDrawable)localObject2).setURLDrawableListener(new kn(this, paramViewGroup.jdField_a_of_type_AndroidWidgetImageView));
      }
      for (;;)
      {
        paramViewGroup.c.setText(((PoiMapActivity.GeneralShops)localObject1).b);
        localObject2 = new SpannableString(((PoiMapActivity.GeneralShops)localObject1).c);
        ((SpannableString)localObject2).setSpan(new StrikethroughSpan(), 0, ((PoiMapActivity.GeneralShops)localObject1).c.length(), 33);
        paramViewGroup.d.setText((CharSequence)localObject2);
        paramViewGroup.e.setText(((PoiMapActivity.GeneralShops)localObject1).d);
        return paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      }
      paramViewGroup = paramView;
    } while (this.d != 1);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPoiMapActivity).inflate(2130903350, null);
      paramViewGroup = new PoiMapActivity.ShopHolderView(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131297811));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297803));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297805));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131297809));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131297813));
      paramViewGroup.g = ((TextView)paramView.findViewById(2131297812));
      paramView.setTag(paramViewGroup);
      localObject1 = (PoiMapActivity.SingleShops)a(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((PoiMapActivity.SingleShops)localObject1).e);
      if (TextUtils.isEmpty(((PoiMapActivity.SingleShops)localObject1).f)) {
        break label628;
      }
      localObject2 = URLDrawable.getDrawable(((PoiMapActivity.SingleShops)localObject1).f);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      paramInt = i;
      label565:
      if (paramInt > 5) {
        break label675;
      }
      localObject2 = new ImageView(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
      if (paramInt * 2 > ((PoiMapActivity.SingleShops)localObject1).d) {
        break label642;
      }
      ((ImageView)localObject2).setImageResource(2130838347);
    }
    for (;;)
    {
      paramInt += 1;
      break label565;
      paramViewGroup = (PoiMapActivity.ShopHolderView)paramView.getTag();
      break;
      label628:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramInt = i;
      break label565;
      label642:
      if (paramInt * 2 - 1 == ((PoiMapActivity.SingleShops)localObject1).d) {
        ((ImageView)localObject2).setImageResource(2130838346);
      } else {
        ((ImageView)localObject2).setImageResource(2130838345);
      }
    }
    label675:
    paramViewGroup.d.setText(((PoiMapActivity.SingleShops)localObject1).b);
    paramViewGroup.g.setText(((PoiMapActivity.SingleShops)localObject1).c);
    paramViewGroup.f.setText(((PoiMapActivity.SingleShops)localObject1).a);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.ShopListAdapter
 * JD-Core Version:    0.7.0.1
 */