import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.qqstory.takevideo.EditVideoFilter;

public class ywu
  implements yww
{
  private long jdField_a_of_type_Long;
  
  public ywu(EditVideoFilter paramEditVideoFilter) {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    yuy localyuy = (yuy)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(yuy.class);
    if (localyuy != null) {
      localyuy.a(paramMotionEvent);
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    if (paramMotionEvent2 != null)
    {
      yuy localyuy = (yuy)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(yuy.class);
      if (localyuy != null) {}
      for (boolean bool = localyuy.a(paramMotionEvent2);; bool = false)
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
      paramView = (yuy)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(yuy.class);
      if (paramView != null) {
        paramView.g_();
      }
      return;
    }
    yuk.b("Q.qqstory.publish.edit.EditVideoFilter", "repeat viewpager click.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ywu
 * JD-Core Version:    0.7.0.1
 */