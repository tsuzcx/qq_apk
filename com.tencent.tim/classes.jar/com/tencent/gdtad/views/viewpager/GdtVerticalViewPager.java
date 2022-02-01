package com.tencent.gdtad.views.viewpager;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.PageTransformer;
import android.util.AttributeSet;
import android.view.View;

public class GdtVerticalViewPager
  extends ViewPager
{
  public GdtVerticalViewPager(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public GdtVerticalViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    setPageTransformer(true, new a(null));
  }
  
  static class a
    implements ViewPager.PageTransformer
  {
    @TargetApi(11)
    public void transformPage(View paramView, float paramFloat)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        if (paramFloat < -1.0F) {
          paramView.setAlpha(0.0F);
        }
      }
      else {
        return;
      }
      if (paramFloat <= 1.0F)
      {
        paramView.setAlpha(1.0F);
        paramView.setTranslationX(paramView.getWidth() * -paramFloat);
        if (paramFloat > 0.0F) {}
        for (int i = 1;; i = -1)
        {
          paramFloat = (float)(Math.cos((Math.abs(paramFloat) + 1.0F) * 3.141592653589793D) / 2.0D);
          paramView.setTranslationY(i * (paramFloat + 0.5F) * paramView.getHeight());
          return;
        }
      }
      paramView.setAlpha(0.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.viewpager.GdtVerticalViewPager
 * JD-Core Version:    0.7.0.1
 */