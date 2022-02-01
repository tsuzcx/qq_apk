package com.tencent.mobileqq.troop.honor.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import apmc;
import apmd;
import apmg;
import aqnm;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.Collections;
import java.util.List;

public class TroopHonorView
  extends LinearLayout
{
  private static final int ICON_HEIGHT = aqnm.dip2px(16.0F);
  private static final int ICON_WIDTH = aqnm.dip2px(16.0F);
  private static final int dUV = aqnm.dip2px(1.0F);
  private List<apmd> HY;
  private String cpW = "";
  
  public TroopHonorView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TroopHonorView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TroopHonorView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
  }
  
  public String Bt()
  {
    return apmc.U(this.HY);
  }
  
  public int Lw()
  {
    if ((this.HY == null) || (this.HY.size() == 0)) {
      return 0;
    }
    return this.HY.size() * ICON_WIDTH + (this.HY.size() - 1) * ICON_WIDTH + getPaddingLeft() + getPaddingRight();
  }
  
  public void setHonorList(List<apmd> paramList)
  {
    if (this.cpW.equals(apmc.T(paramList))) {}
    for (;;)
    {
      return;
      if (paramList != null) {
        Collections.sort(paramList);
      }
      this.HY = paramList;
      this.cpW = apmc.T(this.HY);
      removeAllViews();
      if ((paramList != null) && (paramList.size() > 0))
      {
        int i = 0;
        int k;
        for (int j = 0; i < paramList.size(); j = k)
        {
          apmd localapmd = (apmd)paramList.get(i);
          k = j;
          if (!TextUtils.isEmpty(localapmd.iconUrl))
          {
            Object localObject = URLDrawable.URLDrawableOptions.obtain();
            localObject = URLDrawable.getDrawable(localapmd.iconUrl, (URLDrawable.URLDrawableOptions)localObject);
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(ICON_WIDTH, ICON_HEIGHT);
            ImageView localImageView = new ImageView(getContext());
            ((URLDrawable)localObject).setURLDrawableListener(new apmg(this, localImageView));
            localImageView.setImageDrawable((Drawable)localObject);
            localImageView.setContentDescription(localapmd.name);
            if (j != 0) {
              localLayoutParams.leftMargin = dUV;
            }
            addView(localImageView, localLayoutParams);
            k = j + 1;
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.widget.TroopHonorView
 * JD-Core Version:    0.7.0.1
 */