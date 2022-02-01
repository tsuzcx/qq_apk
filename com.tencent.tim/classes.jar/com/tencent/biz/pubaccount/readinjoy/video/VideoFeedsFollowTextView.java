package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import mrw;
import mwl;

public class VideoFeedsFollowTextView
  extends TextView
  implements mrw
{
  public VideoFeedsFollowTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public VideoFeedsFollowTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VideoFeedsFollowTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setBackgroundDrawable(mwl.f(getContext(), 2130843962));
      setCompoundDrawables(null, null, null, null);
      return;
    }
    setBackgroundDrawable(mwl.f(getContext(), 2130843808));
  }
  
  public long cS()
  {
    return 3000L;
  }
  
  public View getView()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFollowTextView
 * JD-Core Version:    0.7.0.1
 */