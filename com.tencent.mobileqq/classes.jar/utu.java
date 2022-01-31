import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.qqstory.takevideo.EditVideoFilter;

public class utu
  implements utw
{
  private long jdField_a_of_type_Long;
  
  public utu(EditVideoFilter paramEditVideoFilter) {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    ury localury = (ury)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(ury.class);
    if (localury != null) {
      localury.a(paramMotionEvent);
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    if (paramMotionEvent2 != null)
    {
      ury localury = (ury)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(ury.class);
      if (localury != null) {}
      for (boolean bool = localury.a(paramMotionEvent2);; bool = false)
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
      paramView = (ury)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(ury.class);
      if (paramView != null) {
        paramView.d_();
      }
      return;
    }
    urk.b("Q.qqstory.publish.edit.EditVideoFilter", "repeat viewpager click.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     utu
 * JD-Core Version:    0.7.0.1
 */