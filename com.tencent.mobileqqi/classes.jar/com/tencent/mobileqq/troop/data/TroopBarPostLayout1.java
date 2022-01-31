package com.tencent.mobileqq.troop.data;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.mobileqq.data.TroopBarPostEntity;
import com.tencent.mobileqq.data.TroopBarUserEntity;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import gzn;

public class TroopBarPostLayout1
  extends TroopBarPostAbsLayout
  implements View.OnClickListener
{
  protected static final int a = 2130903403;
  
  public static final boolean a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return false;
    }
    TroopBarUtils.a(paramContext, "action", new String[] { "&bid=" + paramString1, "&pid=" + paramString2, "&type=" + paramString3 });
    TroopBarUtils.a("Clk_onepost", paramString1, "");
    return true;
  }
  
  public View a(Activity paramActivity, LayoutInflater paramLayoutInflater, View paramView, TroopBarAbsDataEntity paramTroopBarAbsDataEntity)
  {
    gzn localgzn;
    if (paramView == null)
    {
      paramView = paramLayoutInflater.inflate(2130903403, null);
      localgzn = (gzn)a(paramView);
      paramView.setTag(localgzn);
    }
    for (;;)
    {
      paramTroopBarAbsDataEntity = (TroopBarPostEntity)paramTroopBarAbsDataEntity;
      localgzn.jdField_a_of_type_AndroidWidgetTextView.setText(paramTroopBarAbsDataEntity.title);
      paramActivity = paramActivity.getResources();
      TroopBarUtils.a(paramActivity, paramLayoutInflater, localgzn.jdField_b_of_type_AndroidWidgetLinearLayout, paramTroopBarAbsDataEntity.getIconListEntitys());
      TroopBarUserEntity localTroopBarUserEntity = paramTroopBarAbsDataEntity.getUsers();
      int i;
      if (localTroopBarUserEntity != null)
      {
        localgzn.jdField_b_of_type_AndroidWidgetTextView.setText(localTroopBarUserEntity.nickName);
        TroopBarUtils.a(paramActivity, paramLayoutInflater, localgzn.jdField_c_of_type_AndroidWidgetLinearLayout, localTroopBarUserEntity.getIconListEntitys());
        if (localTroopBarUserEntity.gender != 1) {
          break label319;
        }
        i = 2130838067;
        label121:
        localgzn.jdField_a_of_type_AndroidWidgetImageView.setImageResource(i);
        if (localTroopBarUserEntity.gender != 1) {
          break label326;
        }
        localgzn.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramActivity.getString(2131560707));
        if (TextUtils.isEmpty(TroopBarPageEntity.sUserLevelSmallIconPrefix)) {}
      }
      try
      {
        localgzn.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
        paramLayoutInflater = TroopBarPageEntity.sUserLevelSmallIconPrefix + String.valueOf(localTroopBarUserEntity.level) + ".png";
        localgzn.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(URLDrawable.getDrawable(paramLayoutInflater, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable));
        localgzn.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(paramActivity.getString(2131560709));
        label239:
        localgzn.jdField_c_of_type_AndroidWidgetTextView.setText(TroopBarUtils.a(paramTroopBarAbsDataEntity.time));
        localgzn.d.setText(paramActivity.getString(2131560692, new Object[] { TroopBarUtils.a(paramTroopBarAbsDataEntity.total_comment) }));
        localgzn.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(2131230861, paramTroopBarAbsDataEntity);
        localgzn.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
        return paramView;
        localgzn = (gzn)paramView.getTag();
        continue;
        label319:
        i = 2130838066;
        break label121;
        label326:
        localgzn.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramActivity.getString(2131560708));
      }
      catch (Exception paramLayoutInflater)
      {
        break label239;
      }
    }
  }
  
  public TroopBarPostAbsLayout.AbsItemViewHolder a(View paramView)
  {
    return new gzn(this, paramView);
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
    a(localContext, paramView.bid, paramView.id, paramView.type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopBarPostLayout1
 * JD-Core Version:    0.7.0.1
 */