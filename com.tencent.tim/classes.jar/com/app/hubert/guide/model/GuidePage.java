package com.app.hubert.guide.model;

import android.graphics.RectF;
import android.support.annotation.ColorInt;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.Animation;
import com.app.hubert.guide.listener.OnHighlightDrewListener;
import com.app.hubert.guide.listener.OnLayoutInflatedListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GuidePage
{
  private int backgroundColor;
  private int[] clickToDismissIds;
  private Animation enterAnimation;
  private boolean everywhereCancelable = true;
  private Animation exitAnimation;
  private List<HighLight> highLights = new ArrayList();
  private int layoutResId;
  private OnHighlightDrewListener onHighlightDrewListener;
  private OnLayoutInflatedListener onLayoutInflatedListener;
  
  public static GuidePage newInstance()
  {
    return new GuidePage();
  }
  
  public GuidePage addHighLight(RectF paramRectF)
  {
    return addHighLight(paramRectF, HighLight.Shape.RECTANGLE, 0, null);
  }
  
  public GuidePage addHighLight(RectF paramRectF, HighLight.Shape paramShape)
  {
    return addHighLight(paramRectF, paramShape, 0, null);
  }
  
  public GuidePage addHighLight(RectF paramRectF, HighLight.Shape paramShape, int paramInt)
  {
    return addHighLight(paramRectF, paramShape, paramInt, null);
  }
  
  public GuidePage addHighLight(RectF paramRectF, HighLight.Shape paramShape, int paramInt, RelativeGuide paramRelativeGuide)
  {
    paramRectF = new HighlightRectF(paramRectF, paramShape, paramInt);
    if (paramRelativeGuide != null)
    {
      paramRelativeGuide.highLight = paramRectF;
      paramRectF.setOptions(new HighlightOptions.Builder().setRelativeGuide(paramRelativeGuide).build());
    }
    this.highLights.add(paramRectF);
    return this;
  }
  
  public GuidePage addHighLight(RectF paramRectF, HighLight.Shape paramShape, RelativeGuide paramRelativeGuide)
  {
    return addHighLight(paramRectF, paramShape, 0, paramRelativeGuide);
  }
  
  public GuidePage addHighLight(RectF paramRectF, RelativeGuide paramRelativeGuide)
  {
    return addHighLight(paramRectF, HighLight.Shape.RECTANGLE, 0, paramRelativeGuide);
  }
  
  public GuidePage addHighLight(View paramView)
  {
    return addHighLight(paramView, HighLight.Shape.RECTANGLE, 0, 0, null);
  }
  
  public GuidePage addHighLight(View paramView, HighLight.Shape paramShape)
  {
    return addHighLight(paramView, paramShape, 0, 0, null);
  }
  
  public GuidePage addHighLight(View paramView, HighLight.Shape paramShape, int paramInt)
  {
    return addHighLight(paramView, paramShape, 0, paramInt, null);
  }
  
  public GuidePage addHighLight(View paramView, HighLight.Shape paramShape, int paramInt1, int paramInt2, @Nullable RelativeGuide paramRelativeGuide)
  {
    paramView = new HighlightView(paramView, paramShape, paramInt1, paramInt2);
    if (paramRelativeGuide != null)
    {
      paramRelativeGuide.highLight = paramView;
      paramView.setOptions(new HighlightOptions.Builder().setRelativeGuide(paramRelativeGuide).build());
    }
    this.highLights.add(paramView);
    return this;
  }
  
  public GuidePage addHighLight(View paramView, HighLight.Shape paramShape, int paramInt, RelativeGuide paramRelativeGuide)
  {
    return addHighLight(paramView, paramShape, 0, paramInt, paramRelativeGuide);
  }
  
  public GuidePage addHighLight(View paramView, HighLight.Shape paramShape, RelativeGuide paramRelativeGuide)
  {
    return addHighLight(paramView, paramShape, 0, 0, paramRelativeGuide);
  }
  
  public GuidePage addHighLight(View paramView, RelativeGuide paramRelativeGuide)
  {
    return addHighLight(paramView, HighLight.Shape.RECTANGLE, 0, 0, paramRelativeGuide);
  }
  
  public GuidePage addHighLightWithOptions(RectF paramRectF, HighLight.Shape paramShape, int paramInt, HighlightOptions paramHighlightOptions)
  {
    paramRectF = new HighlightRectF(paramRectF, paramShape, paramInt);
    if ((paramHighlightOptions != null) && (paramHighlightOptions.relativeGuide != null)) {
      paramHighlightOptions.relativeGuide.highLight = paramRectF;
    }
    paramRectF.setOptions(paramHighlightOptions);
    this.highLights.add(paramRectF);
    return this;
  }
  
  public GuidePage addHighLightWithOptions(RectF paramRectF, HighLight.Shape paramShape, HighlightOptions paramHighlightOptions)
  {
    return addHighLightWithOptions(paramRectF, paramShape, 0, paramHighlightOptions);
  }
  
  public GuidePage addHighLightWithOptions(RectF paramRectF, HighlightOptions paramHighlightOptions)
  {
    return addHighLightWithOptions(paramRectF, HighLight.Shape.RECTANGLE, 0, paramHighlightOptions);
  }
  
  public GuidePage addHighLightWithOptions(View paramView, HighLight.Shape paramShape, int paramInt1, int paramInt2, HighlightOptions paramHighlightOptions)
  {
    paramView = new HighlightView(paramView, paramShape, paramInt1, paramInt2);
    if ((paramHighlightOptions != null) && (paramHighlightOptions.relativeGuide != null)) {
      paramHighlightOptions.relativeGuide.highLight = paramView;
    }
    paramView.setOptions(paramHighlightOptions);
    this.highLights.add(paramView);
    return this;
  }
  
  public GuidePage addHighLightWithOptions(View paramView, HighLight.Shape paramShape, HighlightOptions paramHighlightOptions)
  {
    return addHighLightWithOptions(paramView, paramShape, 0, 0, paramHighlightOptions);
  }
  
  public GuidePage addHighLightWithOptions(View paramView, HighlightOptions paramHighlightOptions)
  {
    return addHighLightWithOptions(paramView, HighLight.Shape.RECTANGLE, 0, 0, paramHighlightOptions);
  }
  
  public int getBackgroundColor()
  {
    return this.backgroundColor;
  }
  
  public int[] getClickToDismissIds()
  {
    return this.clickToDismissIds;
  }
  
  public Animation getEnterAnimation()
  {
    return this.enterAnimation;
  }
  
  public Animation getExitAnimation()
  {
    return this.exitAnimation;
  }
  
  public List<HighLight> getHighLights()
  {
    return this.highLights;
  }
  
  public int getLayoutResId()
  {
    return this.layoutResId;
  }
  
  public OnLayoutInflatedListener getOnLayoutInflatedListener()
  {
    return this.onLayoutInflatedListener;
  }
  
  public List<RelativeGuide> getRelativeGuides()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.highLights.iterator();
    while (localIterator.hasNext())
    {
      HighlightOptions localHighlightOptions = ((HighLight)localIterator.next()).getOptions();
      if ((localHighlightOptions != null) && (localHighlightOptions.relativeGuide != null)) {
        localArrayList.add(localHighlightOptions.relativeGuide);
      }
    }
    return localArrayList;
  }
  
  public boolean isEmpty()
  {
    return (this.layoutResId == 0) && (this.highLights.size() == 0);
  }
  
  public boolean isEverywhereCancelable()
  {
    return this.everywhereCancelable;
  }
  
  public GuidePage setBackgroundColor(@ColorInt int paramInt)
  {
    this.backgroundColor = paramInt;
    return this;
  }
  
  public GuidePage setEnterAnimation(Animation paramAnimation)
  {
    this.enterAnimation = paramAnimation;
    return this;
  }
  
  public GuidePage setEverywhereCancelable(boolean paramBoolean)
  {
    this.everywhereCancelable = paramBoolean;
    return this;
  }
  
  public GuidePage setExitAnimation(Animation paramAnimation)
  {
    this.exitAnimation = paramAnimation;
    return this;
  }
  
  public GuidePage setLayoutRes(@LayoutRes int paramInt, int... paramVarArgs)
  {
    this.layoutResId = paramInt;
    this.clickToDismissIds = paramVarArgs;
    return this;
  }
  
  public GuidePage setOnLayoutInflatedListener(OnLayoutInflatedListener paramOnLayoutInflatedListener)
  {
    this.onLayoutInflatedListener = paramOnLayoutInflatedListener;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.app.hubert.guide.model.GuidePage
 * JD-Core Version:    0.7.0.1
 */