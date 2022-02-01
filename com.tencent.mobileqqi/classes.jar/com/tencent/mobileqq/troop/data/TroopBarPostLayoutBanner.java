package com.tencent.mobileqq.troop.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopBarAbsDataEntity;
import com.tencent.mobileqq.data.TroopBarLevelEntity;
import com.tencent.mobileqq.data.TroopBarPageEntity;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import gvi;
import gvj;
import gvk;
import mqq.util.WeakReference;

public class TroopBarPostLayoutBanner
  extends TroopBarPostAbsLayout
  implements View.OnClickListener
{
  protected static final int a = 2130903403;
  protected static final int b = -14275539;
  public HttpWebCgiAsyncTask.Callback a;
  public WeakReference a;
  Drawable b = null;
  
  public TroopBarPostLayoutBanner()
  {
    this.jdField_a_of_type_MqqUtilWeakReference = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback = new gvk(this);
  }
  
  public View a(Activity paramActivity, LayoutInflater paramLayoutInflater, View paramView, TroopBarAbsDataEntity paramTroopBarAbsDataEntity)
  {
    TroopBarPostLayoutBanner.BannerItemViewHolder localBannerItemViewHolder;
    if (paramView == null)
    {
      paramView = paramLayoutInflater.inflate(2130903403, null);
      localBannerItemViewHolder = (TroopBarPostLayoutBanner.BannerItemViewHolder)a(paramView);
      paramView.setTag(localBannerItemViewHolder);
    }
    for (;;)
    {
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramActivity);
      if (this.jdField_a_of_type_MqqUtilWeakReference.get() != null) {
        this.b = ((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDrawable(2130838419);
      }
      paramTroopBarAbsDataEntity = (TroopBarPageEntity)paramTroopBarAbsDataEntity;
      Object localObject = new ColorDrawable(-14275539);
      if (!TextUtils.isEmpty(paramTroopBarAbsDataEntity.cover)) {}
      try
      {
        localBannerItemViewHolder.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(URLDrawable.getDrawable(paramTroopBarAbsDataEntity.cover, (Drawable)localObject, (Drawable)localObject));
        label121:
        paramActivity = paramActivity.getResources();
        localObject = paramActivity.getDrawable(2130838418);
        if (!TextUtils.isEmpty(paramTroopBarAbsDataEntity.pic)) {}
        try
        {
          localBannerItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(paramTroopBarAbsDataEntity.pic, (Drawable)localObject, (Drawable)localObject));
          label165:
          localBannerItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramActivity.getString(2131560706));
          localBannerItemViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setContentDescription(paramActivity.getString(2131560709));
          localBannerItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramTroopBarAbsDataEntity.name);
          TroopBarUtils.a(paramActivity, paramLayoutInflater, localBannerItemViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout, paramTroopBarAbsDataEntity.getIconListEntitys());
          localBannerItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(TroopBarUtils.a(paramTroopBarAbsDataEntity.pids));
          localBannerItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(TroopBarUtils.a(paramTroopBarAbsDataEntity.fans));
          if (paramTroopBarAbsDataEntity.exsit)
          {
            paramLayoutInflater = paramTroopBarAbsDataEntity.getLevel();
            localBannerItemViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
            localBannerItemViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
            if (paramLayoutInflater != null)
            {
              localBannerItemViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setMax(paramLayoutInflater.next);
              localBannerItemViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramLayoutInflater.point);
              localBannerItemViewHolder.e.setText(paramActivity.getString(2131560695, new Object[] { Integer.valueOf(paramLayoutInflater.point), Integer.valueOf(paramLayoutInflater.next) }));
              if (TextUtils.isEmpty(TroopBarPageEntity.sUserLevelBigIconPrefix)) {}
            }
          }
          try
          {
            localBannerItemViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
            paramLayoutInflater = URLDrawable.getDrawable(TroopBarPageEntity.sUserLevelBigIconPrefix + String.valueOf(paramLayoutInflater.level) + ".png", this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
            localBannerItemViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramLayoutInflater);
            label424:
            if (paramTroopBarAbsDataEntity.sign) {
              if (paramTroopBarAbsDataEntity.continueSignDays > 1)
              {
                localBannerItemViewHolder.d.setText(paramActivity.getString(2131560696, new Object[] { TroopBarUtils.a(paramTroopBarAbsDataEntity.continueSignDays) }));
                label472:
                localBannerItemViewHolder.d.setTextColor(2147483647);
                localBannerItemViewHolder.d.setEnabled(false);
                localBannerItemViewHolder.d.setOnClickListener(null);
                localBannerItemViewHolder.d.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                localBannerItemViewHolder.d.setTag(paramView);
              }
            }
            for (;;)
            {
              label513:
              localBannerItemViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
              paramView.setTag(2131230860, paramTroopBarAbsDataEntity);
              return paramView;
              localBannerItemViewHolder = (TroopBarPostLayoutBanner.BannerItemViewHolder)paramView.getTag();
              break;
              localBannerItemViewHolder.jdField_c_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
              break label121;
              localBannerItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
              break label165;
              localBannerItemViewHolder.d.setText(paramActivity.getString(2131560694));
              break label472;
              localBannerItemViewHolder.d.setText(2131560697);
              localBannerItemViewHolder.d.setTextColor(-1);
              localBannerItemViewHolder.d.setEnabled(true);
              localBannerItemViewHolder.d.setOnClickListener(this);
              localBannerItemViewHolder.d.setCompoundDrawablesWithIntrinsicBounds(this.b, null, null, null);
              break label513;
              localBannerItemViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
              localBannerItemViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
              localBannerItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
              localBannerItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramView);
            }
          }
          catch (Exception paramLayoutInflater)
          {
            break label424;
          }
        }
        catch (Exception localException1)
        {
          break label165;
        }
      }
      catch (Exception localException2)
      {
        break label121;
      }
    }
  }
  
  public TroopBarPostAbsLayout.AbsItemViewHolder a(View paramView)
  {
    return new TroopBarPostLayoutBanner.BannerItemViewHolder(this, paramView);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    Object localObject;
    do
    {
      return;
      localObject = new Intent("refresh_page");
      ((Intent)localObject).putExtra("sub_action", "show_loading");
      paramView.getContext().sendBroadcast((Intent)localObject);
      ThreadManager.a(new gvi(this, paramView));
      return;
      localObject = new Intent("refresh_page");
      ((Intent)localObject).putExtra("sub_action", "show_loading");
      paramView.getContext().sendBroadcast((Intent)localObject);
      ThreadManager.a(new gvj(this, paramView));
      return;
      localObject = paramView.getContext();
      paramView = paramView.getTag(2131230860);
    } while ((localObject == null) || (paramView == null) || (!(paramView instanceof TroopBarPageEntity)));
    paramView = (TroopBarPageEntity)paramView;
    TroopBarUtils.a((Context)localObject, "info", new String[] { "&bid=" + paramView.id });
    TroopBarUtils.a("Clk_banner", paramView.id, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopBarPostLayoutBanner
 * JD-Core Version:    0.7.0.1
 */