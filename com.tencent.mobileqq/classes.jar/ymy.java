import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.qqstory.takevideo.EditVideoFilter;

public class ymy
  implements yna
{
  private long jdField_a_of_type_Long;
  
  public ymy(EditVideoFilter paramEditVideoFilter) {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    ylc localylc = (ylc)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(ylc.class);
    if (localylc != null) {
      localylc.a(paramMotionEvent);
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    if (paramMotionEvent2 != null)
    {
      ylc localylc = (ylc)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(ylc.class);
      if (localylc != null) {}
      for (boolean bool = localylc.a(paramMotionEvent2);; bool = false)
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
      paramView = (ylc)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(ylc.class);
      if (paramView != null) {
        paramView.e_();
      }
      return;
    }
    ykq.b("Q.qqstory.publish.edit.EditVideoFilter", "repeat viewpager click.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymy
 * JD-Core Version:    0.7.0.1
 */