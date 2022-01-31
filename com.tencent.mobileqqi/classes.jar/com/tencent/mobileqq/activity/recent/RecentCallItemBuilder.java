package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.cur.DragRelativeLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class RecentCallItemBuilder
  extends RecentItemBaseBuilder
  implements View.OnTouchListener
{
  private List a;
  
  public View a(int paramInt, Object paramObject, Drawable paramDrawable, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragRelativeLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    paramOnDragModeChangedListener = null;
    paramViewGroup = paramOnDragModeChangedListener;
    if (paramView != null)
    {
      paramViewGroup = paramOnDragModeChangedListener;
      if ((paramView.getTag() instanceof RecentCallItemBuilder.RecentCallItemBuilderViewHolder)) {
        paramViewGroup = (RecentCallItemBuilder.RecentCallItemBuilderViewHolder)paramView.getTag();
      }
    }
    if (paramViewGroup == null)
    {
      paramViewGroup = new RecentCallItemBuilder.RecentCallItemBuilderViewHolder();
      paramView = a(paramContext, 2130903562, paramViewGroup, 1);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)paramView.findViewById(2131230987));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131230940));
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131232928));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231395));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131232929));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131232930));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(16908309));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131232931));
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131232932));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramView.setContentDescription(null);
      if ((paramViewGroup != null) && ((paramObject instanceof RecentBaseData))) {
        a(paramView, (RecentBaseData)paramObject, paramContext, paramDrawable);
      }
      for (;;)
      {
        a(paramContext, paramView, paramInt, paramObject, paramViewGroup, paramOnClickListener);
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setOnTouchListener(this);
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setTag(-1, Integer.valueOf(paramInt));
        paramView.setOnClickListener(paramOnClickListener);
        paramView.setOnLongClickListener(paramOnLongClickListener);
        paramView.setTag(-1, Integer.valueOf(paramInt));
        return paramView;
        if (paramViewGroup != null)
        {
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout.setVisibility(8);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("");
          paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setText("");
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText("");
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
    }
  }
  
  public List a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    paramRecentBaseData = paramContext.getResources();
    if (this.a == null) {
      this.a = new ArrayList();
    }
    for (;;)
    {
      this.a.add(paramRecentBaseData.getString(2131561917));
      return this.a;
      this.a.clear();
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
      } while (!(paramView instanceof RecentCallItemBuilder.RecentCallItemBuilderViewHolder));
      paramView = (RecentCallItemBuilder.RecentCallItemBuilderViewHolder)paramView;
    } while (paramView.jdField_a_of_type_AndroidWidgetImageView == null);
    paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
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
      } while (!(paramView instanceof RecentCallItemBuilder.RecentCallItemBuilderViewHolder));
      paramView = (RecentCallItemBuilder.RecentCallItemBuilderViewHolder)paramView;
    } while (paramView.jdField_a_of_type_AndroidWidgetTextView == null);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramRecentBaseData.a);
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
    if ((localObject instanceof RecentCallItemBuilder.RecentCallItemBuilderViewHolder)) {}
    for (RecentCallItemBuilder.RecentCallItemBuilderViewHolder localRecentCallItemBuilderViewHolder = (RecentCallItemBuilder.RecentCallItemBuilderViewHolder)localObject;; localRecentCallItemBuilderViewHolder = null)
    {
      if (localRecentCallItemBuilderViewHolder == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + localObject);
        return;
      }
      localRecentCallItemBuilderViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
      int m = paramRecentBaseData.B;
      long l = ((RecentCallItem)paramRecentBaseData).b;
      if (QLog.isColorLevel()) {
        QLog.d("RecentCallItemBuilder", 2, "zswzsw number = " + l);
      }
      int j;
      int i;
      if (m == 0)
      {
        j = paramRecentBaseData.A;
        i = 2130838731;
      }
      for (;;)
      {
        int k = i;
        if (l > 0L)
        {
          k = i;
          if (m != 3) {
            k = 2130838736;
          }
        }
        if (k == 0)
        {
          localRecentCallItemBuilderViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          label194:
          if (m != 0) {
            break label672;
          }
          i = 2131362116;
          label203:
          paramDrawable = paramRecentBaseData.a;
          localObject = localRecentCallItemBuilderViewHolder.jdField_a_of_type_AndroidWidgetTextView.getText();
          if (paramDrawable != null) {
            break label759;
          }
          paramDrawable = "";
        }
        label366:
        label751:
        label759:
        for (;;)
        {
          k = 0;
          if ((localRecentCallItemBuilderViewHolder.jdField_a_of_type_AndroidWidgetTextView.getTag() instanceof Integer)) {
            k = ((Integer)localRecentCallItemBuilderViewHolder.jdField_a_of_type_AndroidWidgetTextView.getTag()).intValue();
          }
          if (k != i)
          {
            localRecentCallItemBuilderViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColorStateList(i));
            localRecentCallItemBuilderViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(i));
          }
          if (!paramDrawable.equals(localObject)) {
            localRecentCallItemBuilderViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramDrawable);
          }
          if ((m == 0) && (j >= 1)) {
            if (paramRecentBaseData.a() == 3000)
            {
              paramDrawable = " [" + j + "]";
              if (!paramDrawable.equals(localRecentCallItemBuilderViewHolder.jdField_d_of_type_AndroidWidgetTextView.getText())) {
                localRecentCallItemBuilderViewHolder.jdField_d_of_type_AndroidWidgetTextView.setText(paramDrawable);
              }
              localObject = null;
              if ((paramRecentBaseData.F & 0xF000) != 12288) {
                break label719;
              }
              if (localRecentCallItemBuilderViewHolder.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0) {
                localRecentCallItemBuilderViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
              }
              paramDrawable = paramContext.getString(2131561554);
              CharSequence localCharSequence = localRecentCallItemBuilderViewHolder.jdField_b_of_type_AndroidWidgetTextView.getText();
              localObject = paramDrawable;
              if (paramDrawable == null) {
                localObject = "";
              }
              if (!localObject.equals(localCharSequence)) {
                localRecentCallItemBuilderViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
              }
              if ((paramRecentBaseData.B != 3) && (l <= 0L)) {
                break label751;
              }
            }
          }
          for (paramContext = paramContext.getString(2131562417);; paramContext = paramRecentBaseData.b)
          {
            localObject = localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetTextView.getText();
            paramDrawable = paramContext;
            if (paramContext == null) {
              paramDrawable = "";
            }
            if (!paramDrawable.equals(localObject)) {
              localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramDrawable);
            }
            if (localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetImageView.getVisibility() != 0) {
              localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            }
            a(localRecentCallItemBuilderViewHolder, paramRecentBaseData);
            localRecentCallItemBuilderViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout.setVisibility(8);
            paramView.setContentDescription(paramRecentBaseData.c);
            localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetImageView.setContentDescription("点击进入通话详情页面");
            return;
            if (m <= 1)
            {
              i = 2130838720;
              j = 0;
              break;
            }
            if (m <= 2)
            {
              i = 2130838725;
              j = 0;
              break;
            }
            if (m > 3) {
              break label762;
            }
            i = 2130838723;
            j = 0;
            break;
            localRecentCallItemBuilderViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            localRecentCallItemBuilderViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(k);
            break label194;
            i = 2131362072;
            break label203;
            paramDrawable = " (" + j + ")";
            break label366;
            paramDrawable = "";
            break label366;
            paramDrawable = (Drawable)localObject;
            if (localRecentCallItemBuilderViewHolder.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0) {
              break label436;
            }
            localRecentCallItemBuilderViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            paramDrawable = (Drawable)localObject;
            break label436;
          }
        }
        label436:
        label719:
        label762:
        j = 0;
        label672:
        i = 0;
      }
    }
  }
  
  protected void a(RecentCallItemBuilder.RecentCallItemBuilderViewHolder paramRecentCallItemBuilderViewHolder, RecentBaseData paramRecentBaseData)
  {
    if ((paramRecentCallItemBuilderViewHolder == null) || (paramRecentBaseData == null)) {
      return;
    }
    int i;
    switch (paramRecentBaseData.y)
    {
    default: 
      i = 0;
    }
    while (i == 0)
    {
      paramRecentCallItemBuilderViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      i = 2130838714;
      continue;
      i = 2130838717;
      continue;
      i = 2130838733;
      continue;
      i = 2130838711;
    }
    paramRecentCallItemBuilderViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    paramRecentCallItemBuilderViewHolder.jdField_d_of_type_AndroidWidgetImageView.setImageResource(i);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return true;
    case 0: 
      paramView.setDuplicateParentStateEnabled(false);
      paramView.setPressed(true);
      return true;
    }
    paramView.setDuplicateParentStateEnabled(true);
    paramView.setPressed(false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentCallItemBuilder
 * JD-Core Version:    0.7.0.1
 */