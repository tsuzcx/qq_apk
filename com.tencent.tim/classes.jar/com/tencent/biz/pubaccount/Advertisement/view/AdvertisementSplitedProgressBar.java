package com.tencent.biz.pubaccount.Advertisement.view;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.qqstory.view.SplitedProgressBar;
import wja;

public class AdvertisementSplitedProgressBar
  extends SplitedProgressBar
{
  public AdvertisementSplitedProgressBar(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public AdvertisementSplitedProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AdvertisementSplitedProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mProgressBgColor = 872415231;
    this.buC = -2130706433;
    this.buD = 4;
    this.Xd = wja.dp2px(1.5F, paramContext.getResources());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.AdvertisementSplitedProgressBar
 * JD-Core Version:    0.7.0.1
 */