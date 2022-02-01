package dov.com.qq.im.story.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import axgi;
import axoo;
import rpq;

public class BeautyProviderView
  extends FrameLayout
{
  private float DV = 1.0F;
  private axoo a;
  private axgi c;
  private int eEm = 500;
  private final int eEn = 300;
  public int translationY = rpq.dip2px(getContext(), 242.0F);
  
  public BeautyProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  public BeautyProviderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void setControllerAndManager(axoo paramaxoo, axgi paramaxgi)
  {
    this.a = paramaxoo;
    this.c = paramaxgi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.story.view.BeautyProviderView
 * JD-Core Version:    0.7.0.1
 */