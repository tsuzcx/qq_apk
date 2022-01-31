import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.qqstory.takevideo.EditVideoFilter;

public class vgn
  implements vgp
{
  private long jdField_a_of_type_Long;
  
  public vgn(EditVideoFilter paramEditVideoFilter) {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    ver localver = (ver)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(ver.class);
    if (localver != null) {
      localver.a(paramMotionEvent);
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    if (paramMotionEvent2 != null)
    {
      ver localver = (ver)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(ver.class);
      if (localver != null) {}
      for (boolean bool = localver.a(paramMotionEvent2);; bool = false)
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
      paramView = (ver)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(ver.class);
      if (paramView != null) {
        paramView.d_();
      }
      return;
    }
    ved.b("Q.qqstory.publish.edit.EditVideoFilter", "repeat viewpager click.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vgn
 * JD-Core Version:    0.7.0.1
 */