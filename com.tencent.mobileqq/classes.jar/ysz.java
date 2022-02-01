import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.qqstory.takevideo.EditVideoFilter;

public class ysz
  implements ytb
{
  private long jdField_a_of_type_Long;
  
  public ysz(EditVideoFilter paramEditVideoFilter) {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    yrd localyrd = (yrd)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(yrd.class);
    if (localyrd != null) {
      localyrd.a(paramMotionEvent);
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    if (paramMotionEvent2 != null)
    {
      yrd localyrd = (yrd)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(yrd.class);
      if (localyrd != null) {}
      for (boolean bool = localyrd.a(paramMotionEvent2);; bool = false)
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
      paramView = (yrd)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(yrd.class);
      if (paramView != null) {
        paramView.f_();
      }
      return;
    }
    yqp.b("Q.qqstory.publish.edit.EditVideoFilter", "repeat viewpager click.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ysz
 * JD-Core Version:    0.7.0.1
 */