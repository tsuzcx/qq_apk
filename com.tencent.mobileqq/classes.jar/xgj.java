import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.PlayerGestureGroupHolder.OnViewPagerGestureListener.1;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class xgj
  extends GestureDetector.SimpleOnGestureListener
{
  private xgj(xgh paramxgh) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    int i = 0;
    Object localObject = (StoryPlayerGroupHolder)this.a.a();
    if (((StoryPlayerGroupHolder)localObject).a() == null) {
      return super.onDoubleTap(paramMotionEvent);
    }
    localObject = (xmx)((StoryPlayerGroupHolder)localObject).b(xmx.class);
    if ((localObject != null) && (((xmx)localObject).d()))
    {
      try
      {
        localObject = (AnimationDrawable)this.a.a().getResources().getDrawable(2130846940);
        this.a.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
        this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        ((AnimationDrawable)localObject).start();
        int j = 0;
        while (i < ((AnimationDrawable)localObject).getNumberOfFrames())
        {
          j += ((AnimationDrawable)localObject).getDuration(i);
          i += 1;
        }
        ThreadManager.getUIHandler().postDelayed(new PlayerGestureGroupHolder.OnViewPagerGestureListener.1(this, (AnimationDrawable)localObject), j);
      }
      catch (OutOfMemoryError paramMotionEvent)
      {
        bdjw.a(paramMotionEvent);
        return false;
      }
      ykq.c(this.a.jdField_a_of_type_JavaLangString, "onDoubleTap handle");
    }
    for (;;)
    {
      return super.onDoubleTap(paramMotionEvent);
      ykq.c(this.a.jdField_a_of_type_JavaLangString, "onDoubleTap not handle");
    }
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    super.onLongPress(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = (StoryPlayerGroupHolder)this.a.a();
    VideoViewVideoHolder localVideoViewVideoHolder = paramMotionEvent.a();
    if (localVideoViewVideoHolder != null) {
      switch (localVideoViewVideoHolder.a())
      {
      }
    }
    for (;;)
    {
      ykq.c(this.a.jdField_a_of_type_JavaLangString, "onSingleTapConfirmed");
      return true;
      paramMotionEvent.a(true, true);
      ykv.a("play_video", "clk_video", 0, 0, new String[] { "", "2", "", "" });
      continue;
      paramMotionEvent.a(false, true);
      ykv.a("play_video", "clk_video", 0, 0, new String[] { "", "1", "", "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xgj
 * JD-Core Version:    0.7.0.1
 */