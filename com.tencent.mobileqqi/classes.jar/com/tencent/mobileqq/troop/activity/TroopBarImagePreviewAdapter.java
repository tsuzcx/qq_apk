package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.BaseApplication;
import gry;
import java.io.File;
import java.net.MalformedURLException;
import java.util.List;

public class TroopBarImagePreviewAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  public static final int a = 100;
  public static final int b = 100;
  protected Drawable a;
  protected LayoutInflater a;
  protected ExtendGridView a;
  protected CharSequence a;
  protected List a;
  protected boolean a;
  protected CharSequence b = null;
  protected int c = 8;
  
  public TroopBarImagePreviewAdapter(Context paramContext, ExtendGridView paramExtendGridView)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_JavaLangCharSequence = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView = paramExtendGridView;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130839362);
    this.jdField_a_of_type_JavaLangCharSequence = BaseApplication.getContext().getText(2131558481);
    this.b = BaseApplication.getContext().getResources().getText(2131561262);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView == null) {
      return;
    }
    int k = getCount();
    int j = k / this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getNumColumns();
    int i = j;
    if (k < this.c)
    {
      i = j;
      if (k % this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getNumColumns() != 0) {
        i = j + 1;
      }
    }
    Object localObject = getView(0, null, this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView);
    ((View)localObject).measure(0, 0);
    j = this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getVerticalSpacing();
    k = ((View)localObject).getMeasuredHeight();
    int m = this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getPaddingTop();
    int n = this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getPaddingBottom();
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = (i * k + j * (i - 1) + m + n);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    a();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    if (paramBoolean2) {
      notifyDataSetChanged();
    }
  }
  
  public boolean a(int paramInt)
  {
    return (this.jdField_a_of_type_Boolean) && (paramInt == getCount() - 1);
  }
  
  public int getCount()
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      i = this.jdField_a_of_type_JavaUtilList.size();
    }
    int j = i;
    if (this.jdField_a_of_type_Boolean) {
      j = i + 1;
    }
    return j;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (a(paramInt))) {
      return null;
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return paramInt;
    }
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (a(paramInt)) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int k = 2147483647;
    View localView;
    int i;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903411, null);
      paramViewGroup = new gry();
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131232527));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131232528));
      localView.setTag(paramViewGroup);
      i = this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.a();
      paramView = localView.getLayoutParams();
      if ((paramView != null) && ((paramView instanceof AbsListView.LayoutParams))) {
        break label173;
      }
      paramView = new AbsListView.LayoutParams(i, i);
      label100:
      localView.setLayoutParams((AbsListView.LayoutParams)paramView);
      if (!a(paramInt)) {
        break label188;
      }
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130839499);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    label173:
    label188:
    do
    {
      return localView;
      paramViewGroup = (gry)paramView.getTag();
      localView = paramView;
      break;
      paramView.width = i;
      paramView.height = i;
      break label100;
      paramView = (String)getItem(paramInt);
    } while (TextUtils.isEmpty(paramView));
    int j;
    if (i < 0) {
      j = 2147483647;
    }
    for (;;)
    {
      j = Math.min(100, j);
      if (i < 0)
      {
        i = k;
        label231:
        i = Math.min(100, i);
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setAdjustViewBounds(false);
        paramView = new File(paramView);
      }
      try
      {
        if (paramView.exists()) {}
        for (paramView = URLDrawable.getDrawable(paramView.toURL(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);; paramView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)
        {
          Object localObject = paramView;
          if (paramView == null) {
            localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          }
          ((Drawable)localObject).setBounds(0, 0, j, i);
          paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
          paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(this.b);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(paramInt));
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
          return localView;
          j = i;
          break;
          break label231;
        }
      }
      catch (MalformedURLException paramView)
      {
        for (;;)
        {
          paramView = null;
        }
      }
    }
  }
  
  public int getViewTypeCount()
  {
    if (this.jdField_a_of_type_Boolean) {
      return 2;
    }
    return 1;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    paramView = (Integer)paramView.getTag();
    Intent localIntent = new Intent("key_photo_delete_action");
    localIntent.putExtra("key_photo_delete_position", paramView.intValue());
    BaseApplication.getContext().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarImagePreviewAdapter
 * JD-Core Version:    0.7.0.1
 */