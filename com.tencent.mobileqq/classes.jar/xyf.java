import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.qqstory.takevideo.EditVideoFilter;

public class xyf
  implements xyh
{
  private long jdField_a_of_type_Long;
  
  public xyf(EditVideoFilter paramEditVideoFilter) {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    xwj localxwj = (xwj)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(xwj.class);
    if (localxwj != null) {
      localxwj.a(paramMotionEvent);
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    if (paramMotionEvent2 != null)
    {
      xwj localxwj = (xwj)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(xwj.class);
      if (localxwj != null) {}
      for (boolean bool = localxwj.a(paramMotionEvent2);; bool = false)
      {
        if (bool)
        {
          a(paramMotionEvent1);
          a(paramMotionEvent2);
        }
        return bool;
      }
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long > 300L)
    {
      this.jdField_a_of_type_Long = l;
      paramView = (xwj)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(xwj.class);
      if (paramView != null) {
        paramView.e_();
      }
      return;
    }
    xvv.b("Q.qqstory.publish.edit.EditVideoFilter", "repeat viewpager click.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xyf
 * JD-Core Version:    0.7.0.1
 */