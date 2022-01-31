package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.recent.cur.DragRelativeLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;

public class QZoneShareAlbumDefaultItemBuilder
  extends RecentDefaultItemBuilder
{
  private static final String b = "ShareAlbumDefaultItemBuilder";
  
  public View a(int paramInt, Object paramObject, Drawable paramDrawable, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragRelativeLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    paramOnDragModeChangedListener = null;
    paramViewGroup = paramOnDragModeChangedListener;
    if (paramView != null)
    {
      paramViewGroup = paramOnDragModeChangedListener;
      if ((paramView.getTag() instanceof RecentDefaultItemBuilder.RecentItemDefaultHolder)) {
        paramViewGroup = (QZoneShareAlbumDefaultItemBuilder.RecentListForShareAlbumHolder)paramView.getTag();
      }
    }
    if (paramViewGroup == null)
    {
      paramViewGroup = new QZoneShareAlbumDefaultItemBuilder.RecentListForShareAlbumHolder();
      paramView = a(paramContext, 2130903868, paramViewGroup, 2);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131230940));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131234179));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131234180));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231883));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131234189));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(16908308));
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131232903));
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131232615));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131234183));
      paramViewGroup.f = ((TextView)paramView.findViewById(16908309));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0] = ((ImageView)paramView.findViewById(2131234184));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1] = ((ImageView)paramView.findViewById(2131234185));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2] = ((ImageView)paramView.findViewById(2131234186));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[3] = ((ImageView)paramView.findViewById(2131234187));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131234188));
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.a.a());
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
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
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0].setVisibility(8);
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1].setVisibility(8);
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2].setVisibility(8);
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[3].setVisibility(8);
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0].setImageDrawable(null);
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1].setImageDrawable(null);
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2].setImageDrawable(null);
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[3].setImageDrawable(null);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("");
        }
      }
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    super.a(paramView, paramRecentBaseData, paramContext, paramDrawable);
    Object localObject = paramView.getTag();
    paramDrawable = (QQAppInterface)((AppActivity)paramContext).getAppRuntime();
    if ((localObject instanceof QZoneShareAlbumDefaultItemBuilder.RecentListForShareAlbumHolder)) {}
    for (paramView = (QZoneShareAlbumDefaultItemBuilder.RecentListForShareAlbumHolder)localObject;; paramView = null)
    {
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + localObject);
        }
        return;
      }
      URLDrawable localURLDrawable;
      if (!TextUtils.isEmpty(paramRecentBaseData.d))
      {
        if (!(paramView.jdField_a_of_type_AndroidWidgetImageView instanceof URLImageView)) {
          break label365;
        }
        localObject = paramView.jdField_a_of_type_AndroidWidgetImageView;
        localURLDrawable = URLDrawable.getDrawable(paramRecentBaseData.d);
        if (localURLDrawable != null)
        {
          if (localURLDrawable.getStatus() != 2) {
            break label341;
          }
          localURLDrawable.restartDownload();
        }
        label132:
        ((ImageView)localObject).setImageDrawable(localURLDrawable);
        if (QLog.isColorLevel()) {
          QLog.d("ShareAlbumDefaultItemBuilder", 2, "ShareAlbum URLImageView loadurl:" + paramRecentBaseData.d);
        }
      }
      label173:
      paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      label211:
      int j;
      int k;
      int i;
      if (paramRecentBaseData.E > 4)
      {
        paramContext = paramContext.getString(2131559017, new Object[] { Integer.valueOf(paramRecentBaseData.E) });
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramContext);
        paramContext = paramRecentBaseData.e;
        paramView.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0].setVisibility(8);
        paramView.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1].setVisibility(8);
        paramView.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2].setVisibility(8);
        paramView.jdField_a_of_type_ArrayOfAndroidWidgetImageView[3].setVisibility(8);
        if ((paramContext != null) && (paramContext.length() > 0))
        {
          paramContext = paramContext.split(";");
          j = 0;
          k = paramContext.length;
          i = 0;
        }
      }
      for (;;)
      {
        if (i < k)
        {
          localObject = paramContext[i];
          j += 1;
          if (j <= 4) {}
        }
        else
        {
          if (!TextUtils.isEmpty(paramRecentBaseData.d)) {
            break;
          }
          paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839362);
          return;
          label341:
          if ((localURLDrawable.getStatus() != 0) || (localURLDrawable.isDownloadStarted())) {
            break label132;
          }
          localURLDrawable.startDownload();
          break label132;
          label365:
          if (!QLog.isColorLevel()) {
            break label173;
          }
          QLog.d("ShareAlbumDefaultItemBuilder", 2, "ShareAlbum this is not a URLImageView");
          break label173;
          paramContext = paramContext.getString(2131559018, new Object[] { Integer.valueOf(paramRecentBaseData.E) });
          break label211;
        }
        paramView.jdField_a_of_type_ArrayOfAndroidWidgetImageView[(j - 1)].setVisibility(0);
        paramView.jdField_a_of_type_ArrayOfAndroidWidgetImageView[(j - 1)].setImageDrawable(FaceDrawable.a(paramDrawable, 1, (String)localObject));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.QZoneShareAlbumDefaultItemBuilder
 * JD-Core Version:    0.7.0.1
 */