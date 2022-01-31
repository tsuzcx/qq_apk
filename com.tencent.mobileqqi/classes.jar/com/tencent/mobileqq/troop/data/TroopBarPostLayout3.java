package com.tencent.mobileqq.troop.data;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.data.TroopBarAbsDataEntity;
import com.tencent.mobileqq.data.TroopBarPageEntity;
import com.tencent.mobileqq.data.TroopBarPostContentEntity;
import com.tencent.mobileqq.data.TroopBarPostContentEntity.Pic_list;
import com.tencent.mobileqq.data.TroopBarPostEntity;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import gzp;
import java.util.ArrayList;

public class TroopBarPostLayout3
  extends TroopBarPostAbsLayout
  implements View.OnClickListener
{
  protected static final int a = 2130903405;
  
  public View a(Activity paramActivity, LayoutInflater paramLayoutInflater, View paramView, TroopBarAbsDataEntity paramTroopBarAbsDataEntity)
  {
    gzp localgzp;
    if (paramView == null)
    {
      paramView = paramLayoutInflater.inflate(2130903405, null);
      localgzp = (gzp)a(paramView);
      paramView.setTag(localgzp);
    }
    for (;;)
    {
      paramTroopBarAbsDataEntity = (TroopBarPostEntity)paramTroopBarAbsDataEntity;
      localgzp.jdField_a_of_type_AndroidWidgetTextView.setText(paramTroopBarAbsDataEntity.title);
      Resources localResources = paramActivity.getResources();
      TroopBarUtils.a(localResources, paramLayoutInflater, localgzp.jdField_b_of_type_AndroidWidgetLinearLayout, paramTroopBarAbsDataEntity.getIconListEntitys());
      label107:
      ColorDrawable localColorDrawable;
      if (paramTroopBarAbsDataEntity.contentBytes != null)
      {
        paramLayoutInflater = paramTroopBarAbsDataEntity.getContentEntity();
        if (paramLayoutInflater != null)
        {
          if ((paramLayoutInflater.pic_lists != null) && (!paramLayoutInflater.pic_lists.isEmpty())) {
            break label380;
          }
          paramActivity = null;
          localColorDrawable = new ColorDrawable(-1710619);
          if ((paramActivity == null) || (TextUtils.isEmpty(paramActivity.url))) {
            break label395;
          }
        }
      }
      try
      {
        localgzp.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(paramActivity.url, localColorDrawable, localColorDrawable));
        label151:
        if ((!TextUtils.isEmpty(paramTroopBarAbsDataEntity.subscript_addr)) && (!TextUtils.isEmpty(TroopBarPageEntity.sPostCornerImgPrefix))) {}
        try
        {
          localgzp.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
          localgzp.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(URLDrawable.getDrawable(TroopBarPageEntity.sPostCornerImgPrefix + paramTroopBarAbsDataEntity.subscript_addr, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable));
          label226:
          localgzp.jdField_b_of_type_AndroidWidgetTextView.setText(paramLayoutInflater.price);
          localgzp.c.setText(paramLayoutInflater.time);
          if (!TextUtils.isEmpty(paramLayoutInflater.addr))
          {
            localgzp.d.setVisibility(0);
            localgzp.d.setText(paramLayoutInflater.addr);
          }
          for (;;)
          {
            paramActivity = localResources.getString(2131560693, new Object[] { TroopBarUtils.a(paramTroopBarAbsDataEntity.subscribers) });
            paramLayoutInflater = localResources.getString(2131560692, new Object[] { TroopBarUtils.a(paramTroopBarAbsDataEntity.total_comment) });
            localgzp.e.setText(paramActivity);
            localgzp.f.setText(paramLayoutInflater);
            localgzp.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(2131230861, paramTroopBarAbsDataEntity);
            localgzp.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
            return paramView;
            localgzp = (gzp)paramView.getTag();
            break;
            label380:
            paramActivity = (TroopBarPostContentEntity.Pic_list)paramLayoutInflater.pic_lists.get(0);
            break label107;
            label395:
            localgzp.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localColorDrawable);
            break label151;
            localgzp.d.setVisibility(4);
          }
        }
        catch (Exception paramActivity)
        {
          break label226;
        }
      }
      catch (Exception paramActivity)
      {
        break label151;
      }
    }
  }
  
  public TroopBarPostAbsLayout.AbsItemViewHolder a(View paramView)
  {
    return new gzp(this, paramView);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    Context localContext;
    do
    {
      return;
      localContext = paramView.getContext();
      paramView = paramView.getTag(2131230861);
    } while ((localContext == null) || (!(paramView instanceof TroopBarPostEntity)));
    paramView = (TroopBarPostEntity)paramView;
    TroopBarPostLayout1.a(localContext, paramView.bid, paramView.id, paramView.type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopBarPostLayout3
 * JD-Core Version:    0.7.0.1
 */