package com.tencent.mobileqq.vip.diy;

import acfp;
import afcy;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import aqvt;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.widget.VoteViewV2;
import ram;
import rpq;

public class TemplateLikeView
  extends VoteViewV2
{
  protected TextView abG = (TextView)findViewById(2131382088);
  public ViewGroup eK = (ViewGroup)findViewById(2131382078);
  public ViewGroup eL = (ViewGroup)findViewById(2131370147);
  protected int height;
  protected URLDrawable mDrawable;
  protected int mPaddingLeft;
  protected int mPaddingRight;
  protected int width;
  
  public TemplateLikeView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TemplateLikeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TemplateLikeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, afcy paramafcy, boolean paramBoolean3)
  {
    super.a(paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramafcy, paramBoolean3);
    paramafcy = this.eK.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams = this.eL.getLayoutParams();
    this.width = ((int)(this.mPaddingLeft + this.mPaddingRight + this.abG.getPaint().measureText(acfp.m(2131715208) + this.acq.getText().toString()) + rpq.dip2px(getContext(), 30.0F)));
    paramafcy.width = this.width;
    localLayoutParams.width = this.width;
    this.eK.setLayoutParams(paramafcy);
    this.eL.setLayoutParams(localLayoutParams);
    paramafcy = super.getLayoutParams();
    paramafcy.width = this.width;
    super.setLayoutParams(paramafcy);
    if (this.mDrawable != null) {
      this.mDrawable.invalidateSelf();
    }
  }
  
  public int getLayout()
  {
    return 2131562239;
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    super.invalidateDrawable(paramDrawable);
    ram.e("zhiqiang", "invalidateDrawable");
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    ram.d("zhiqiang", "draw +++++++++++");
  }
  
  public void setContainerLayoutParams(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mPaddingRight = paramInt4;
    this.mPaddingLeft = paramInt3;
    ViewGroup.LayoutParams localLayoutParams1 = this.eK.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams2 = this.eL.getLayoutParams();
    this.width = ((int)(this.mPaddingLeft + this.mPaddingRight + this.abG.getPaint().measureText(acfp.m(2131715210) + this.cQn) + rpq.dip2px(getContext(), 30.0F)));
    this.height = paramInt2;
    localLayoutParams1.width = this.width;
    localLayoutParams1.height = this.height;
    localLayoutParams2.width = this.width;
    localLayoutParams2.height = this.height;
    this.eK.setLayoutParams(localLayoutParams1);
    this.eL.setLayoutParams(localLayoutParams2);
  }
  
  public void setVoteContainerBackground(URLDrawable paramURLDrawable)
  {
    if (this.mDrawable != null) {
      this.mDrawable.setURLDrawableListener(null);
    }
    this.mDrawable = paramURLDrawable;
    if ((paramURLDrawable != null) && (paramURLDrawable.getStatus() != 1)) {
      paramURLDrawable.setURLDrawableListener(new aqvt(this));
    }
    this.eK.setBackgroundDrawable(paramURLDrawable);
    this.eL.setBackgroundDrawable(paramURLDrawable);
  }
  
  public void tA(int paramInt)
  {
    super.tA(paramInt);
    if (this.mStyle == 1) {
      if (this.abG != null)
      {
        this.abG.setTextColor(getContext().getResources().getColor(2131167379));
        this.acs.setTextColor(getContext().getResources().getColor(2131167379));
      }
    }
    while (this.abG == null) {
      return;
    }
    this.abG.setTextColor(getContext().getResources().getColor(2131167461));
    this.acs.setTextColor(getContext().getResources().getColor(2131167461));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.TemplateLikeView
 * JD-Core Version:    0.7.0.1
 */