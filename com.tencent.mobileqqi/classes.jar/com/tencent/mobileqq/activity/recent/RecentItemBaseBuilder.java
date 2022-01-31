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
import com.tencent.mobileqq.activity.recent.cur.DragRelativeLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public abstract class RecentItemBaseBuilder
{
  public static final String a = "tag_recent_item_menu_item";
  public static final int[] a;
  public static final int[] b = { 2130837896, 2130837903, 2130837892, 2130837892, 2130837900, 2130837906 };
  public static final int c = -1;
  public static final int d = -2;
  public static final int e = -3;
  public static final int f = 0;
  public static final int g = 1;
  public static final int h = 2;
  public static final int i = 3;
  public static final int j = 4;
  public static final int k = 5;
  protected RecentAdapter a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131561917, 2131562370, 2131563191, 2131561856, 2131562756, 2131562552 };
  }
  
  public abstract View a(int paramInt, Object paramObject, Drawable paramDrawable, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragRelativeLayout.OnDragModeChangedListener paramOnDragModeChangedListener);
  
  public final View a(Context paramContext, int paramInt1, RecentItemBaseBuilder.RecentItemBaseHolder paramRecentItemBaseHolder, int paramInt2)
  {
    View localView3 = null;
    long l = System.currentTimeMillis();
    View localView2 = LayoutInflater.from(paramContext).inflate(paramInt1, null);
    View localView1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a()))
    {
      paramRecentItemBaseHolder.jdField_b_of_type_ArrayOfAndroidWidgetImageView = new ImageView[paramInt2];
      localView3 = a(paramContext, paramInt2, paramRecentItemBaseHolder.jdField_b_of_type_ArrayOfAndroidWidgetImageView);
      localView1 = a(paramContext, localView2, localView3);
    }
    for (paramContext = localView3;; paramContext = localView3)
    {
      paramRecentItemBaseHolder.a = localView2;
      paramRecentItemBaseHolder.jdField_b_of_type_AndroidViewView = paramContext;
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "createMenuView, cost = " + (System.currentTimeMillis() - l));
      }
      return localView1;
      localView1 = localView2;
    }
  }
  
  public View a(Context paramContext, int paramInt, ImageView[] paramArrayOfImageView)
  {
    long l = System.currentTimeMillis();
    if ((paramContext == null) || (paramInt == 0)) {
      return null;
    }
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(0);
    int n = paramContext.getResources().getDimensionPixelSize(2131427620);
    int i1 = paramContext.getResources().getDimensionPixelSize(2131427619);
    int m = 0;
    while (m < paramInt)
    {
      ImageView localImageView = (ImageView)LayoutInflater.from(paramContext).inflate(2130903928, null);
      localLinearLayout.addView(localImageView, new LinearLayout.LayoutParams(n, i1));
      if ((paramArrayOfImageView != null) && (m < paramArrayOfImageView.length)) {
        paramArrayOfImageView[m] = localImageView;
      }
      m += 1;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "createMenuView, cost = " + (System.currentTimeMillis() - l));
    }
    return localLinearLayout;
  }
  
  public View a(Context paramContext, View paramView1, View paramView2)
  {
    long l = System.currentTimeMillis();
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
    localLinearLayout.addView(paramView2, new LinearLayout.LayoutParams(paramContext.getResources().getDimensionPixelSize(2131427620), -2));
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "createListItemView, cost = " + (System.currentTimeMillis() - l));
    }
    return localLinearLayout;
  }
  
  public List a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    return null;
  }
  
  public void a(Context paramContext, View paramView, int paramInt, Object paramObject, RecentItemBaseBuilder.RecentItemBaseHolder paramRecentItemBaseHolder, View.OnClickListener paramOnClickListener)
  {
    long l = System.currentTimeMillis();
    if ((paramRecentItemBaseHolder == null) || (paramView == null) || (paramRecentItemBaseHolder.jdField_b_of_type_AndroidViewView == null) || (paramRecentItemBaseHolder.jdField_b_of_type_ArrayOfAndroidWidgetImageView == null) || (paramRecentItemBaseHolder.jdField_b_of_type_ArrayOfAndroidWidgetImageView.length == 0)) {
      return;
    }
    int i2 = paramRecentItemBaseHolder.jdField_b_of_type_ArrayOfAndroidWidgetImageView.length;
    if ((paramObject instanceof RecentBaseData)) {}
    for (int i1 = ((RecentBaseData)paramObject).F;; i1 = 0)
    {
      int m = 0;
      int n = m;
      if (i2 < 0)
      {
        n = m;
        if (paramRecentItemBaseHolder.jdField_b_of_type_ArrayOfAndroidWidgetImageView[0] != null)
        {
          n = m;
          if ((i1 & 0xF00) == 256)
          {
            a(paramRecentItemBaseHolder.jdField_b_of_type_ArrayOfAndroidWidgetImageView[0], paramInt, b[1], jdField_a_of_type_ArrayOfInt[1], 2130837895, paramOnClickListener);
            n = 1;
          }
        }
      }
      m = n;
      int i3;
      if (n < i2)
      {
        m = n;
        if (paramRecentItemBaseHolder.jdField_b_of_type_ArrayOfAndroidWidgetImageView[n] != null)
        {
          i3 = 0xF000 & i1;
          if (i3 != 4096) {
            break label441;
          }
          a(paramRecentItemBaseHolder.jdField_b_of_type_ArrayOfAndroidWidgetImageView[n], paramInt, b[2], jdField_a_of_type_ArrayOfInt[2], 2130837895, paramOnClickListener);
          m = n + 1;
        }
      }
      n = m;
      if (m < i2)
      {
        n = m;
        if (paramRecentItemBaseHolder.jdField_b_of_type_ArrayOfAndroidWidgetImageView[m] != null)
        {
          i3 = i1 & 0xF0;
          if (i3 != 32) {
            break label489;
          }
          a(paramRecentItemBaseHolder.jdField_b_of_type_ArrayOfAndroidWidgetImageView[m], paramInt, b[4], jdField_a_of_type_ArrayOfInt[4], 2130837895, paramOnClickListener);
          n = m + 1;
        }
      }
      label285:
      if ((n < i2) && (paramRecentItemBaseHolder.jdField_b_of_type_ArrayOfAndroidWidgetImageView[n] != null) && ((i1 & 0xF) == 1)) {
        a(paramRecentItemBaseHolder.jdField_b_of_type_ArrayOfAndroidWidgetImageView[n], paramInt, b[0], jdField_a_of_type_ArrayOfInt[0], 2130837897, paramOnClickListener);
      }
      for (m = n + 1;; m = n)
      {
        n = m;
        for (;;)
        {
          if (n < i2)
          {
            if (paramRecentItemBaseHolder.jdField_b_of_type_ArrayOfAndroidWidgetImageView[m] != null)
            {
              paramRecentItemBaseHolder.jdField_b_of_type_ArrayOfAndroidWidgetImageView[n].setVisibility(8);
              paramRecentItemBaseHolder.jdField_b_of_type_ArrayOfAndroidWidgetImageView[n].setImageResource(0);
              paramRecentItemBaseHolder.jdField_b_of_type_ArrayOfAndroidWidgetImageView[n].setTag(null);
              paramRecentItemBaseHolder.jdField_b_of_type_ArrayOfAndroidWidgetImageView[n].setTag(-1, Integer.valueOf(paramInt));
              paramRecentItemBaseHolder.jdField_b_of_type_ArrayOfAndroidWidgetImageView[n].setOnClickListener(null);
            }
            n += 1;
            continue;
            label441:
            m = n;
            if (i3 != 8192) {
              break;
            }
            a(paramRecentItemBaseHolder.jdField_b_of_type_ArrayOfAndroidWidgetImageView[n], paramInt, b[3], jdField_a_of_type_ArrayOfInt[3], 2130837895, paramOnClickListener);
            m = n + 1;
            break;
            label489:
            n = m;
            if (i3 != 16) {
              break label285;
            }
            a(paramRecentItemBaseHolder.jdField_b_of_type_ArrayOfAndroidWidgetImageView[m], paramInt, b[5], jdField_a_of_type_ArrayOfInt[5], 2130837895, paramOnClickListener);
            n = m + 1;
            break label285;
          }
        }
        m = paramContext.getResources().getDimensionPixelSize(2131427620) * m;
        paramContext = (LinearLayout.LayoutParams)paramRecentItemBaseHolder.jdField_b_of_type_AndroidViewView.getLayoutParams();
        if ((paramContext != null) && (paramContext.width != m)) {
          paramContext.width = m;
        }
        paramView.setTag(-3, Integer.valueOf(m));
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.c != -1))
        {
          if (paramInt == this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.c) {
            break label664;
          }
          paramView.scrollTo(0, 0);
        }
        while (QLog.isDevelopLevel())
        {
          QLog.i("Q.recent", 4, "updateItemMenuView, cost = " + (System.currentTimeMillis() - l));
          return;
          label664:
          paramView.scrollTo(m, 0);
        }
        break;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder
 * JD-Core Version:    0.7.0.1
 */