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
import com.tencent.mobileqq.activity.recent.cur.DragRelativeLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemDiscussionMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.international.LocaleString;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import java.util.ArrayList;
import java.util.List;

public class RecentDefaultItemBuilder
  extends RecentItemBaseBuilder
{
  public static final int a = 2;
  public static int b = 0;
  private static final String b = "RecentDefaultItemBuilder";
  private List a;
  
  public View a(int paramInt, Object paramObject, Drawable paramDrawable, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragRelativeLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
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
      View localView = a(paramContext, 2130903928, paramOnDragModeChangedListener, 2);
      paramOnDragModeChangedListener.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131230940));
      paramOnDragModeChangedListener.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131234179));
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)localView.findViewById(2131234180));
      paramOnDragModeChangedListener.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131231883));
      paramOnDragModeChangedListener.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131234189));
      paramOnDragModeChangedListener.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(16908308));
      paramOnDragModeChangedListener.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131232903));
      paramOnDragModeChangedListener.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131232615));
      paramOnDragModeChangedListener.e = ((TextView)localView.findViewById(2131234183));
      paramOnDragModeChangedListener.f = ((TextView)localView.findViewById(16908309));
      a(localView, paramOnDragModeChangedListener.jdField_b_of_type_AndroidWidgetTextView, paramContext);
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
          paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText("");
          paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
          paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setText("");
          paramViewGroup.e.setText("");
          paramViewGroup.f.setText("");
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText("");
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
    int i = paramRecentBaseData.F;
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
      this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[4]));
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
        this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[5]));
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
      LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131231417);
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
    } while (paramView.jdField_c_of_type_AndroidWidgetTextView == null);
    paramView.jdField_c_of_type_AndroidWidgetTextView.setText(paramRecentBaseData.jdField_a_of_type_JavaLangString);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    int j = 1;
    if ((paramView == null) || (paramRecentBaseData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "bindView|param invalidate");
      }
      return;
    }
    Object localObject = paramView.getTag();
    if ((localObject instanceof RecentDefaultItemBuilder.RecentItemDefaultHolder)) {}
    for (RecentDefaultItemBuilder.RecentItemDefaultHolder localRecentItemDefaultHolder = (RecentDefaultItemBuilder.RecentItemDefaultHolder)localObject;; localRecentItemDefaultHolder = null)
    {
      if (localRecentItemDefaultHolder == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + localObject);
        return;
      }
      int i = paramRecentBaseData.F & 0xF0;
      label211:
      int k;
      if ((i == 32) || (i == 48))
      {
        localRecentItemDefaultHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        localRecentItemDefaultHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
        localObject = paramRecentBaseData.jdField_a_of_type_JavaLangString;
        CharSequence localCharSequence = localRecentItemDefaultHolder.jdField_c_of_type_AndroidWidgetTextView.getText();
        paramDrawable = (Drawable)localObject;
        if (localObject == null) {
          paramDrawable = "";
        }
        if (!paramDrawable.equals(localCharSequence)) {
          localRecentItemDefaultHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramDrawable);
        }
        i = paramRecentBaseData.B;
        if (i <= 0) {
          break label672;
        }
        localRecentItemDefaultHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        localRecentItemDefaultHolder.jdField_d_of_type_AndroidWidgetImageView.setImageResource(i);
        localObject = paramRecentBaseData.jdField_a_of_type_JavaLangCharSequence;
        localCharSequence = localRecentItemDefaultHolder.jdField_d_of_type_AndroidWidgetTextView.getText();
        paramDrawable = (Drawable)localObject;
        if (localObject == null) {
          paramDrawable = "";
        }
        if (!paramDrawable.equals(localCharSequence)) {
          localRecentItemDefaultHolder.jdField_d_of_type_AndroidWidgetTextView.setText(paramDrawable);
        }
        localObject = paramRecentBaseData.jdField_c_of_type_JavaLangCharSequence;
        localCharSequence = localRecentItemDefaultHolder.e.getText();
        i = localRecentItemDefaultHolder.e.getCurrentTextColor();
        paramDrawable = (Drawable)localObject;
        if (localObject == null) {
          paramDrawable = "";
        }
        if (!paramDrawable.equals(localCharSequence)) {
          localRecentItemDefaultHolder.e.setText(paramDrawable);
        }
        if ((i != paramRecentBaseData.D) && (paramRecentBaseData.D != 0)) {
          localRecentItemDefaultHolder.e.setTextColor(paramRecentBaseData.D);
        }
        localObject = paramRecentBaseData.jdField_b_of_type_JavaLangCharSequence;
        localCharSequence = localRecentItemDefaultHolder.f.getText();
        paramDrawable = (Drawable)localObject;
        if (localObject == null) {
          paramDrawable = "";
        }
        if (!paramDrawable.toString().equals("你的QQ暂不支持查看视频短片，请期待后续版本"))
        {
          localObject = paramDrawable;
          if (!paramDrawable.toString().equals("[视频]你的QQ暂不支持查看视频短片，请升级到最新版本后查看。")) {}
        }
        else
        {
          localObject = "[视频] 您的QQ版本暂不支持查看视频短片。";
        }
        if (!localObject.equals(localCharSequence))
        {
          paramDrawable = (Drawable)localObject;
          if ((paramRecentBaseData instanceof RecentItemTroopMsgData)) {
            paramDrawable = LocaleString.s(paramContext, ((CharSequence)localObject).toString());
          }
          localObject = paramDrawable;
          if ((paramRecentBaseData instanceof RecentItemDiscussionMsgData)) {
            localObject = LocaleString.w(paramContext, paramDrawable.toString());
          }
          paramDrawable = (Drawable)localObject;
          if ((paramRecentBaseData instanceof RecentItemChatMsgData)) {
            paramDrawable = LocaleString.v(paramContext, ((CharSequence)localObject).toString());
          }
          paramContext = new QQText(paramDrawable, 13, 16);
          localRecentItemDefaultHolder.f.setText(paramContext);
        }
        paramDrawable = paramRecentBaseData.jdField_b_of_type_JavaLangString;
        localObject = localRecentItemDefaultHolder.jdField_b_of_type_AndroidWidgetTextView.getText();
        paramContext = paramDrawable;
        if (paramDrawable == null) {
          paramContext = "";
        }
        if (!paramContext.equals(localObject)) {
          localRecentItemDefaultHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramContext);
        }
        a(localRecentItemDefaultHolder, paramRecentBaseData);
        k = paramRecentBaseData.A;
        i = paramRecentBaseData.z;
        if (k <= 0) {
          break label788;
        }
        if (i != 0) {
          break label685;
        }
        localRecentItemDefaultHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1);
        k = 0;
        i = 0;
        j = 0;
      }
      label788:
      for (;;)
      {
        CustomWidgetUtil.a(localRecentItemDefaultHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, j, k, i, 99);
        if (localRecentItemDefaultHolder.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0) {
          localRecentItemDefaultHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        paramView.setContentDescription(paramRecentBaseData.jdField_c_of_type_JavaLangString);
        return;
        localRecentItemDefaultHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break;
        label672:
        localRecentItemDefaultHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        break label211;
        label685:
        if (i == 2)
        {
          localRecentItemDefaultHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1);
          k = 0;
          i = 0;
        }
        else if (i == 3)
        {
          i = 2130840214;
          if ((paramRecentBaseData instanceof RecentTroopAssistantItem)) {}
          localRecentItemDefaultHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1);
          j = 3;
        }
        else if (i == 4)
        {
          i = 2130840213;
          localRecentItemDefaultHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
          j = 3;
        }
        else
        {
          i = 2130840213;
          localRecentItemDefaultHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
          j = 3;
          continue;
          k = 0;
          i = 0;
          j = 0;
        }
      }
    }
  }
  
  public void a(RecentDefaultItemBuilder.RecentItemDefaultHolder paramRecentItemDefaultHolder, RecentBaseData paramRecentBaseData)
  {
    switch (paramRecentBaseData.y)
    {
    default: 
      paramRecentItemDefaultHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      paramRecentItemDefaultHolder.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
      return;
    case 1: 
      paramRecentItemDefaultHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramRecentItemDefaultHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130838269);
      return;
    case 2: 
      paramRecentItemDefaultHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramRecentItemDefaultHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130838269);
      return;
    case 3: 
      paramRecentItemDefaultHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramRecentItemDefaultHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130838270);
      return;
    }
    paramRecentItemDefaultHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    paramRecentItemDefaultHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130837920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentDefaultItemBuilder
 * JD-Core Version:    0.7.0.1
 */