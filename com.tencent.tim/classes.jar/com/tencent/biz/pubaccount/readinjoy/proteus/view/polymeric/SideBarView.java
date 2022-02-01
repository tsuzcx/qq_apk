package com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.BezierSideBarView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ImageCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.qphone.base.util.QLog;

public class SideBarView
  extends BezierSideBarView
{
  private String mPath;
  
  public SideBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SideBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SideBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int oN()
  {
    int j = super.oN();
    int i = j;
    if (j < 0) {
      i = 0;
    }
    return i;
  }
  
  public int oO()
  {
    int j = super.oO();
    int i = j;
    if (j > getMeasuredHeight()) {
      i = getMeasuredHeight();
    }
    return i;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.mDrawable != null) {
      this.mDrawable.setBounds(0, 0, this.mDrawable.getIntrinsicWidth(), this.mDrawable.getIntrinsicHeight());
    }
    super.onDraw(paramCanvas);
  }
  
  public void setBgColor(String paramString)
  {
    if (paramString == null) {
      return;
    }
    try
    {
      int i = Color.parseColor(paramString);
      this.aE.setColor(i);
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("ProteusRecycleView", 1, "", paramString);
    }
  }
  
  public void setPath(String paramString)
  {
    this.mPath = paramString;
    if ((paramString != null) && (!paramString.equals("-1")))
    {
      if ((!paramString.startsWith("http")) && (!paramString.startsWith("pubaccount"))) {
        break label64;
      }
      Drawable localDrawable = getContext().getResources().getDrawable(2130844076);
      this.mDrawable = DrawableUtil.getDrawable(getContext(), paramString, localDrawable, localDrawable);
    }
    label64:
    do
    {
      return;
      paramString = ImageCommon.getDrawableResourceId(paramString);
    } while (paramString == null);
    QLog.d("ProteusRecycleView", 2, "loadImage: cant find in offline dir, try to load from resources");
    try
    {
      this.mDrawable = getContext().getResources().getDrawable(paramString.intValue());
      return;
    }
    catch (Resources.NotFoundException paramString)
    {
      QLog.d("ProteusRecycleView", 2, "loadImage: cant find in resources dir, do nothing");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.SideBarView
 * JD-Core Version:    0.7.0.1
 */