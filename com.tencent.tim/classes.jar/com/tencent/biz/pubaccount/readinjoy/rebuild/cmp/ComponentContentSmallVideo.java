package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import lie;
import mde;

public class ComponentContentSmallVideo
  extends ComponentContentSmall
{
  TextView mDuration;
  
  public ComponentContentSmallVideo(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentContentSmallVideo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentContentSmallVideo(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void P(Object paramObject)
  {
    super.P(paramObject);
    if ((paramObject instanceof lie))
    {
      paramObject = ((lie)paramObject).a();
      if (paramObject != null) {}
    }
    else
    {
      return;
    }
    this.mDuration.setText(mde.ba(paramObject.mVideoDuration));
  }
  
  public void aNf()
  {
    super.aNf();
  }
  
  public void cG(View paramView)
  {
    super.cG(paramView);
    this.mDuration = ((TextView)paramView.findViewById(2131366156));
  }
  
  public View f(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560307, this, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentSmallVideo
 * JD-Core Version:    0.7.0.1
 */