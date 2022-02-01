import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.PlayerGestureGroupHolder.OnViewPagerGestureListener.1;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class qiz
  extends qir
{
  private qiz.a jdField_a_of_type_Qiz$a;
  private roo jdField_a_of_type_Roo;
  public ImageView mI;
  
  public qiz(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.mI = ((ImageView)this.mItemView.findViewById(2131381767));
    ((StoryPlayerGroupHolder)a()).a.setOnTouchListener(new qiz.b(null));
    this.jdField_a_of_type_Qiz$a = new qiz.a(null);
    this.jdField_a_of_type_Roo = new roo(n(), this.jdField_a_of_type_Qiz$a);
    this.jdField_a_of_type_Roo.setLongPressTimeout(50);
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void setVisibility(int paramInt)
  {
    ram.d(this.TAG, "setVisibility ignore");
  }
  
  public class a
    extends GestureDetector.SimpleOnGestureListener
  {
    private a() {}
    
    public boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      int i = 0;
      Object localObject = (StoryPlayerGroupHolder)qiz.this.a();
      if (((StoryPlayerGroupHolder)localObject).a() == null) {
        return super.onDoubleTap(paramMotionEvent);
      }
      localObject = (qmo)((StoryPlayerGroupHolder)localObject).b(qmo.class);
      if ((localObject != null) && (((qmo)localObject).Ka()))
      {
        try
        {
          localObject = (AnimationDrawable)qiz.this.n().getResources().getDrawable(2130847802);
          qiz.this.mI.setBackgroundDrawable((Drawable)localObject);
          qiz.this.mI.setVisibility(0);
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
          annt.e(paramMotionEvent);
          return false;
        }
        ram.i(qiz.this.TAG, "onDoubleTap handle");
      }
      for (;;)
      {
        return super.onDoubleTap(paramMotionEvent);
        ram.i(qiz.this.TAG, "onDoubleTap not handle");
      }
    }
    
    public void onLongPress(MotionEvent paramMotionEvent)
    {
      super.onLongPress(paramMotionEvent);
    }
    
    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      paramMotionEvent = (StoryPlayerGroupHolder)qiz.this.a();
      VideoViewVideoHolder localVideoViewVideoHolder = paramMotionEvent.a();
      if (localVideoViewVideoHolder != null) {
        switch (localVideoViewVideoHolder.sF())
        {
        }
      }
      for (;;)
      {
        ram.i(qiz.this.TAG, "onSingleTapConfirmed");
        return true;
        paramMotionEvent.am(true, true);
        rar.a("play_video", "clk_video", 0, 0, new String[] { "", "2", "", "" });
        continue;
        paramMotionEvent.am(false, true);
        rar.a("play_video", "clk_video", 0, 0, new String[] { "", "1", "", "" });
      }
    }
  }
  
  class b
    implements View.OnTouchListener
  {
    private b() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      return qiz.a(qiz.this).onTouchEvent(paramMotionEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qiz
 * JD-Core Version:    0.7.0.1
 */