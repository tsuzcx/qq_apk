import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.qqstory.playvideo.VideoCoverListBar;

public class tvp
  implements View.OnTouchListener
{
  float jdField_a_of_type_Float = -1.0F;
  float b = -1.0F;
  
  public tvp(VideoCoverListBar paramVideoCoverListBar, int paramInt) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return false;
    case 0: 
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.b = paramMotionEvent.getY();
      return false;
    }
    if (Math.abs(paramMotionEvent.getY() - this.b) > Math.min(this.jdField_a_of_type_Int, 40)) {
      vei.a("play_video", "slide_mini", 0, 0, new String[] { "2", "", "", VideoCoverListBar.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar) });
    }
    this.jdField_a_of_type_Float = -1.0F;
    this.b = -1.0F;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tvp
 * JD-Core Version:    0.7.0.1
 */