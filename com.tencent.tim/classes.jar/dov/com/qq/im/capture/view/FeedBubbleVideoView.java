package dov.com.qq.im.capture.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.widget.BubbleImageView;

public class FeedBubbleVideoView
  extends BubbleImageView
{
  public URLDrawable n;
  URLDrawable v;
  
  public FeedBubbleVideoView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FeedBubbleVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FeedBubbleVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (paramURLDrawable == this.v)
    {
      setURLDrawable(paramURLDrawable);
      return;
    }
    super.onLoadFialed(paramURLDrawable, paramThrowable);
  }
  
  @TargetApi(11)
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == this.v) {
      setURLDrawable(paramURLDrawable);
    }
    super.onLoadSuccessed(paramURLDrawable);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (this.v != null)
    {
      this.v.setURLDrawableListener(null);
      this.v = null;
    }
  }
  
  public void setURLDrawable(URLDrawable paramURLDrawable)
  {
    setImageDrawable(paramURLDrawable);
    if (this.n != paramURLDrawable) {
      this.n = paramURLDrawable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.FeedBubbleVideoView
 * JD-Core Version:    0.7.0.1
 */