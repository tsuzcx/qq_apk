package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public abstract class RecentItemBaseBuilder
{
  public static final String a = "tag_recent_item_menu_item";
  public static final int[] a;
  public static final int[] b = { 2130837943, 2130837950, 2130837947, 2130837953 };
  public static final int c = -1;
  public static final int d = -2;
  public static final int e = -3;
  public static final int f = 0;
  public static final int g = 1;
  public static final int h = 2;
  public static final int i = 3;
  protected RecentAdapter a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131363247, 2131363823, 2131364386, 2131364385 };
  }
  
  public abstract View a(int paramInt, Object paramObject, Drawable paramDrawable, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener);
  
  public final View a(Context paramContext, int paramInt1, RecentItemBaseBuilder.RecentItemBaseHolder paramRecentItemBaseHolder, int paramInt2)
  {
    View localView3 = null;
    View localView2 = LayoutInflater.from(paramContext).inflate(paramInt1, null);
    View localView1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a()))
    {
      paramRecentItemBaseHolder.jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[paramInt2];
      localView3 = a(paramContext, paramInt2, paramRecentItemBaseHolder.jdField_a_of_type_ArrayOfAndroidWidgetImageView);
      localView1 = a(paramContext, localView2, localView3);
    }
    for (paramContext = localView3;; paramContext = localView3)
    {
      paramRecentItemBaseHolder.jdField_a_of_type_AndroidViewView = localView2;
      paramRecentItemBaseHolder.b = paramContext;
      return localView1;
      localView1 = localView2;
    }
  }
  
  public View a(Context paramContext, int paramInt, ImageView[] paramArrayOfImageView)
  {
    if ((paramContext == null) || (paramInt == 0)) {
      return null;
    }
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(0);
    int k = paramContext.getResources().getDimensionPixelSize(2131493095);
    int m = paramContext.getResources().getDimensionPixelSize(2131493094);
    int j = 0;
    while (j < paramInt)
    {
      ImageView localImageView = (ImageView)LayoutInflater.from(paramContext).inflate(2130903607, null);
      localLinearLayout.addView(localImageView, new LinearLayout.LayoutParams(k, m));
      if ((paramArrayOfImageView != null) && (j < paramArrayOfImageView.length)) {
        paramArrayOfImageView[j] = localImageView;
      }
      j += 1;
    }
    return localLinearLayout;
  }
  
  public View a(Context paramContext, View paramView1, View paramView2)
  {
    if ((paramContext == null) || (paramView1 == null) || (paramView2 == null))
    {
      if (paramView1 != null) {
        return paramView1;
      }
      return paramView2;
    }
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(0);
    localLinearLayout.addView(paramView1, new LinearLayout.LayoutParams(-1, -2));
    localLinearLayout.addView(paramView2, new LinearLayout.LayoutParams(paramContext.getResources().getDimensionPixelSize(2131493095), -2));
    return localLinearLayout;
  }
  
  public List a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    return null;
  }
  
  public void a(Context paramContext, View paramView, int paramInt, Object paramObject, RecentItemBaseBuilder.RecentItemBaseHolder paramRecentItemBaseHolder, View.OnClickListener paramOnClickListener)
  {
    if ((paramRecentItemBaseHolder == null) || (paramView == null) || (paramRecentItemBaseHolder.b == null) || (paramRecentItemBaseHolder.jdField_a_of_type_ArrayOfAndroidWidgetImageView == null) || (paramRecentItemBaseHolder.jdField_a_of_type_ArrayOfAndroidWidgetImageView.length == 0)) {
      return;
    }
    int n = paramRecentItemBaseHolder.jdField_a_of_type_ArrayOfAndroidWidgetImageView.length;
    if ((paramObject instanceof RecentBaseData)) {}
    for (int m = ((RecentBaseData)paramObject).A;; m = 0)
    {
      int j = 0;
      int k = j;
      if (n < 0)
      {
        k = j;
        if (paramRecentItemBaseHolder.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0] != null)
        {
          k = j;
          if ((m & 0xF00) == 256)
          {
            a(paramRecentItemBaseHolder.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0], paramInt, b[1], jdField_a_of_type_ArrayOfInt[1], 2130837942, paramOnClickListener);
            k = 1;
          }
        }
      }
      j = k;
      int i1;
      if (k < n)
      {
        j = k;
        if (paramRecentItemBaseHolder.jdField_a_of_type_ArrayOfAndroidWidgetImageView[k] != null)
        {
          i1 = m & 0xF0;
          if (i1 != 32) {
            break label362;
          }
          a(paramRecentItemBaseHolder.jdField_a_of_type_ArrayOfAndroidWidgetImageView[k], paramInt, b[2], jdField_a_of_type_ArrayOfInt[2], 2130837942, paramOnClickListener);
          j = k + 1;
        }
      }
      if ((j < n) && (paramRecentItemBaseHolder.jdField_a_of_type_ArrayOfAndroidWidgetImageView[j] != null) && ((m & 0xF) == 1))
      {
        a(paramRecentItemBaseHolder.jdField_a_of_type_ArrayOfAndroidWidgetImageView[j], paramInt, b[0], jdField_a_of_type_ArrayOfInt[0], 2130837944, paramOnClickListener);
        j += 1;
      }
      for (;;)
      {
        k = j;
        for (;;)
        {
          if (k < n)
          {
            if (paramRecentItemBaseHolder.jdField_a_of_type_ArrayOfAndroidWidgetImageView[j] != null)
            {
              paramRecentItemBaseHolder.jdField_a_of_type_ArrayOfAndroidWidgetImageView[k].setVisibility(8);
              paramRecentItemBaseHolder.jdField_a_of_type_ArrayOfAndroidWidgetImageView[k].setImageResource(0);
              paramRecentItemBaseHolder.jdField_a_of_type_ArrayOfAndroidWidgetImageView[k].setTag(null);
              paramRecentItemBaseHolder.jdField_a_of_type_ArrayOfAndroidWidgetImageView[k].setTag(-1, Integer.valueOf(paramInt));
              paramRecentItemBaseHolder.jdField_a_of_type_ArrayOfAndroidWidgetImageView[k].setOnClickListener(null);
            }
            k += 1;
            continue;
            label362:
            j = k;
            if (i1 != 16) {
              break;
            }
            a(paramRecentItemBaseHolder.jdField_a_of_type_ArrayOfAndroidWidgetImageView[k], paramInt, b[3], jdField_a_of_type_ArrayOfInt[3], 2130837942, paramOnClickListener);
            j = k + 1;
            break;
          }
        }
        j = paramContext.getResources().getDimensionPixelSize(2131493095) * j;
        paramContext = (LinearLayout.LayoutParams)paramRecentItemBaseHolder.b.getLayoutParams();
        if ((paramContext != null) && (paramContext.width != j)) {
          paramContext.width = j;
        }
        paramView.setTag(-3, Integer.valueOf(j));
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.c == -1)) {
          break;
        }
        if (paramInt != this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.c)
        {
          paramView.scrollTo(0, 0);
          return;
        }
        paramView.scrollTo(j, 0);
        return;
      }
    }
  }
  
  public void a(View paramView, Drawable paramDrawable) {}
  
  public void a(View paramView, RecentBaseData paramRecentBaseData) {}
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable) {}
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable, QQAppInterface paramQQAppInterface) {}
  
  public void a(ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, View.OnClickListener paramOnClickListener)
  {
    if (paramImageView != null)
    {
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(paramInt2);
      paramImageView.setBackgroundResource(paramInt4);
      paramImageView.setTag("tag_recent_item_menu_item");
      paramImageView.setTag(-2, Integer.valueOf(paramInt3));
      paramImageView.setTag(-1, Integer.valueOf(paramInt1));
      paramImageView.setContentDescription(paramImageView.getResources().getString(paramInt3));
      paramImageView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void a(RecentAdapter paramRecentAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = paramRecentAdapter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder
 * JD-Core Version:    0.7.0.1
 */