package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import java.util.ArrayList;
import java.util.List;

public class RecentDefaultItemBuilder
  extends RecentItemBaseBuilder
{
  public static final int a = 0;
  public static int b = 0;
  private static final String b = "RecentDefaultItemBuilder";
  private List a;
  
  public View a(int paramInt, Object paramObject, Drawable paramDrawable, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    paramOnDragModeChangedListener = null;
    paramViewGroup = paramOnDragModeChangedListener;
    if (paramView != null)
    {
      paramViewGroup = paramOnDragModeChangedListener;
      if ((paramView.getTag() instanceof RecentDefaultItemBuilder.RecentItemDefaultHolder)) {
        paramViewGroup = (RecentDefaultItemBuilder.RecentItemDefaultHolder)paramView.getTag();
      }
    }
    if (paramViewGroup == null)
    {
      paramOnDragModeChangedListener = new RecentDefaultItemBuilder.RecentItemDefaultHolder();
      View localView = a(paramContext, 2130903598, paramOnDragModeChangedListener, 0);
      paramOnDragModeChangedListener.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131296456));
      paramOnDragModeChangedListener.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131298688));
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)localView.findViewById(2131298692));
      paramOnDragModeChangedListener.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297251));
      paramOnDragModeChangedListener.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131298690));
      paramOnDragModeChangedListener.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(16908308));
      paramOnDragModeChangedListener.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131298327));
      paramOnDragModeChangedListener.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131298689));
      paramOnDragModeChangedListener.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131298691));
      paramOnDragModeChangedListener.e = ((TextView)localView.findViewById(16908309));
      a(localView, paramOnDragModeChangedListener.jdField_a_of_type_AndroidWidgetTextView, paramContext);
      localView.setTag(paramOnDragModeChangedListener);
      paramView = localView;
      paramViewGroup = paramOnDragModeChangedListener;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
      {
        paramOnDragModeChangedListener.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a());
        paramViewGroup = paramOnDragModeChangedListener;
        paramView = localView;
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      paramView.setContentDescription(null);
      if ((paramViewGroup != null) && ((paramObject instanceof RecentBaseData))) {
        a(paramView, (RecentBaseData)paramObject, paramContext, paramDrawable);
      }
      for (;;)
      {
        a(paramContext, paramView, paramInt, paramObject, paramViewGroup, paramOnClickListener);
        paramView.setOnClickListener(paramOnClickListener);
        paramView.setOnLongClickListener(paramOnLongClickListener);
        paramView.setTag(-1, Integer.valueOf(paramInt));
        return paramView;
        if (paramViewGroup != null)
        {
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText("");
          paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
          paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText("");
          paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setText("");
          paramViewGroup.e.setText("");
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("");
          paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
        }
      }
    }
  }
  
  public List a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData == null) || (paramContext == null)) {
      return null;
    }
    int i = paramRecentBaseData.A;
    paramRecentBaseData = paramContext.getResources();
    int j;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      if ((i & 0xF00) == 256) {
        this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[1]));
      }
      j = i & 0xF0;
      if (j != 32) {
        break label145;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[2]));
    }
    for (;;)
    {
      if ((i & 0xF) == 1) {
        this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[0]));
      }
      return this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_JavaUtilList.clear();
      break;
      label145:
      if (j == 16) {
        this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[3]));
      }
    }
  }
  
  public void a(View paramView, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramDrawable == null)) {}
    do
    {
      do
      {
        return;
        paramView = paramView.getTag();
      } while (!(paramView instanceof RecentDefaultItemBuilder.RecentItemDefaultHolder));
      paramView = (RecentDefaultItemBuilder.RecentItemDefaultHolder)paramView;
    } while (paramView.jdField_a_of_type_AndroidWidgetImageView == null);
    paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
  }
  
  protected void a(View paramView, TextView paramTextView, Context paramContext)
  {
    try
    {
      LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131296881);
      paramView = TimeManager.a().a("000000", 1225168973512L);
      if (TextUtils.isEmpty(paramView))
      {
        paramView = TimeManager.a().a();
        if ((!TextUtils.isEmpty(paramView)) && (paramView.length() != "yyyy-MM-dd".length()))
        {
          i = 1;
          int j;
          if ((b <= 0) || (i != 0))
          {
            f = paramContext.getResources().getDisplayMetrics().density;
            paramContext = paramTextView.getPaint();
            paramTextView = paramContext;
            if (paramContext == null)
            {
              paramTextView = new TextPaint();
              paramTextView.setTextSize(12.0F * f);
            }
            if (i == 0) {
              break label234;
            }
            i = (int)(paramTextView.measureText("yyyy-MM-dd") + f * 6.0F);
            j = (int)(paramTextView.measureText(paramView) + f * 6.0F);
            if (j <= i) {
              break label208;
            }
          }
          label208:
          for (b = j; localLinearLayout.getPaddingRight() < b; b = i)
          {
            i = localLinearLayout.getPaddingLeft();
            j = localLinearLayout.getPaddingTop();
            int k = localLinearLayout.getPaddingBottom();
            int m = b;
            localLinearLayout.setPadding(i, j, b, k);
            return;
          }
        }
      }
    }
    catch (Exception paramView)
    {
      int i;
      float f;
      while (QLog.isDevelopLevel())
      {
        QLog.i("RecentDefaultItemBuilder", 4, paramView.toString());
        return;
        label234:
        b = (int)(paramTextView.measureText("yyyy-MM-dd") + f * 6.0F);
        continue;
        i = 0;
      }
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData)
  {
    if ((paramView == null) || (paramRecentBaseData == null)) {}
    do
    {
      do
      {
        return;
        paramView = paramView.getTag();
      } while (!(paramView instanceof RecentDefaultItemBuilder.RecentItemDefaultHolder));
      paramView = (RecentDefaultItemBuilder.RecentItemDefaultHolder)paramView;
    } while (paramView.jdField_b_of_type_AndroidWidgetTextView == null);
    paramView.jdField_b_of_type_AndroidWidgetTextView.setText(paramRecentBaseData.jdField_a_of_type_JavaLangString);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "bindView|param invalidate");
      }
      return;
    }
    Object localObject = paramView.getTag();
    if ((localObject instanceof RecentDefaultItemBuilder.RecentItemDefaultHolder)) {}
    for (paramContext = (RecentDefaultItemBuilder.RecentItemDefaultHolder)localObject;; paramContext = null)
    {
      if (paramContext == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + localObject);
        return;
      }
      int i = paramRecentBaseData.A & 0xF0;
      if ((i == 32) || (i == 48)) {
        paramContext.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      for (;;)
      {
        paramContext.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
        localObject = paramRecentBaseData.jdField_a_of_type_JavaLangString;
        CharSequence localCharSequence = paramContext.jdField_b_of_type_AndroidWidgetTextView.getText();
        paramDrawable = (Drawable)localObject;
        if (localObject == null) {
          paramDrawable = "";
        }
        if (!paramDrawable.equals(localCharSequence)) {
          paramContext.jdField_b_of_type_AndroidWidgetTextView.setText(paramDrawable);
        }
        i = paramRecentBaseData.w;
        if (i > 0)
        {
          paramContext.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
          paramContext.jdField_d_of_type_AndroidWidgetImageView.setImageResource(i);
          localObject = paramRecentBaseData.jdField_a_of_type_JavaLangCharSequence;
          localCharSequence = paramContext.jdField_c_of_type_AndroidWidgetTextView.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (!paramDrawable.equals(localCharSequence)) {
            paramContext.jdField_c_of_type_AndroidWidgetTextView.setText(paramDrawable);
          }
          localObject = paramRecentBaseData.jdField_c_of_type_JavaLangCharSequence;
          localCharSequence = paramContext.jdField_d_of_type_AndroidWidgetTextView.getText();
          i = paramContext.jdField_d_of_type_AndroidWidgetTextView.getCurrentTextColor();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (!paramDrawable.equals(localCharSequence)) {
            paramContext.jdField_d_of_type_AndroidWidgetTextView.setText(paramDrawable);
          }
          if ((i != paramRecentBaseData.y) && (paramRecentBaseData.y != 0)) {
            paramContext.jdField_d_of_type_AndroidWidgetTextView.setTextColor(paramRecentBaseData.y);
          }
          localObject = paramRecentBaseData.jdField_b_of_type_JavaLangCharSequence;
          localCharSequence = paramContext.e.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (paramDrawable.equals(localCharSequence)) {}
        }
        try
        {
          paramContext.e.setText(paramDrawable);
          localObject = paramRecentBaseData.jdField_b_of_type_JavaLangString;
          localCharSequence = paramContext.jdField_a_of_type_AndroidWidgetTextView.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (!paramDrawable.equals(localCharSequence)) {
            paramContext.jdField_a_of_type_AndroidWidgetTextView.setText(paramDrawable);
          }
          a(paramContext, paramRecentBaseData);
          m = paramRecentBaseData.v;
          i = paramRecentBaseData.u;
          if (m > 0) {
            if (i == 0)
            {
              paramContext.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1);
              k = 99;
              m = 0;
              j = 0;
              i = 0;
              CustomWidgetUtil.a(paramContext.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, m, j, k, null);
              if (paramContext.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
                paramContext.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
              }
              paramView.setContentDescription(paramRecentBaseData.jdField_c_of_type_JavaLangString);
              return;
              paramContext.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
              continue;
              paramContext.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int m;
            int k;
            int j;
            localException.printStackTrace();
            paramContext.e.setText(paramDrawable + " ");
            continue;
            if (i == 2)
            {
              paramContext.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1);
              m = 0;
              j = 0;
              i = 1;
              k = 99;
            }
            else if (i == 3)
            {
              j = 2130839405;
              if ((paramRecentBaseData instanceof RecentTroopAssistantItem)) {}
              paramContext.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1);
              k = 99;
              i = 3;
            }
            else if (i == 4)
            {
              j = 2130839404;
              paramContext.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
              k = 99;
              i = 3;
            }
            else
            {
              j = 2130839404;
              paramContext.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
              k = 99;
              i = 3;
              continue;
              k = 99;
              m = 0;
              j = 0;
              i = 0;
            }
          }
        }
      }
    }
  }
  
  public void a(RecentDefaultItemBuilder.RecentItemDefaultHolder paramRecentItemDefaultHolder, RecentBaseData paramRecentBaseData)
  {
    switch (paramRecentBaseData.t)
    {
    default: 
      paramRecentItemDefaultHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      paramRecentItemDefaultHolder.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
      return;
    }
    paramRecentItemDefaultHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    paramRecentItemDefaultHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130837971);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentDefaultItemBuilder
 * JD-Core Version:    0.7.0.1
 */