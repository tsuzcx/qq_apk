package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import lie;

public class ComponentContentBigGallery
  extends ComponentContentBig
{
  TextView qh;
  
  public ComponentContentBigGallery(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentContentBigGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentContentBigGallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void P(Object paramObject)
  {
    super.P(paramObject);
    if ((paramObject instanceof lie))
    {
      paramObject = ((lie)paramObject).a();
      this.qh.setText(String.valueOf(paramObject.mGalleryPicNumber));
    }
  }
  
  public void aNf()
  {
    super.aNf();
  }
  
  public void cG(View paramView)
  {
    super.cG(paramView);
    this.qh = ((TextView)paramView.findViewById(2131367837));
  }
  
  public View f(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560295, this, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentBigGallery
 * JD-Core Version:    0.7.0.1
 */