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

public class xqd
  extends GestureDetector.SimpleOnGestureListener
{
  private xqd(xqb paramxqb) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    int i = 0;
    Object localObject = (StoryPlayerGroupHolder)this.a.a();
    if (((StoryPlayerGroupHolder)localObject).a() == null) {
      return super.onDoubleTap(paramMotionEvent);
    }
    localObject = (xwr)((StoryPlayerGroupHolder)localObject).b(xwr.class);
    if ((localObject != null) && (((xwr)localObject).d()))
    {
      try
      {
        localObject = (AnimationDrawable)this.a.a().getResources().getDrawable(2130846936);
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
        bdkh.a(paramMotionEvent);
        return false;
      }
      yuk.c(this.a.jdField_a_of_type_JavaLangString, "onDoubleTap handle");
    }
    for (;;)
    {
      return super.onDoubleTap(paramMotionEvent);
      yuk.c(this.a.jdField_a_of_type_JavaLangString, "onDoubleTap not handle");
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
      yuk.c(this.a.jdField_a_of_type_JavaLangString, "onSingleTapConfirmed");
      return true;
      paramMotionEvent.a(true, true);
      yup.a("play_video", "clk_video", 0, 0, new String[] { "", "2", "", "" });
      continue;
      paramMotionEvent.a(false, true);
      yup.a("play_video", "clk_video", 0, 0, new String[] { "", "1", "", "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xqd
 * JD-Core Version:    0.7.0.1
 */