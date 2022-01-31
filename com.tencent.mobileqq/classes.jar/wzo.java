import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.qqstory.takevideo.EditVideoFilter;

public class wzo
  implements wzq
{
  private long jdField_a_of_type_Long;
  
  public wzo(EditVideoFilter paramEditVideoFilter) {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    wxs localwxs = (wxs)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(wxs.class);
    if (localwxs != null) {
      localwxs.a(paramMotionEvent);
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    if (paramMotionEvent2 != null)
    {
      wxs localwxs = (wxs)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(wxs.class);
      if (localwxs != null) {}
      for (boolean bool = localwxs.a(paramMotionEvent2);; bool = false)
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
      paramView = (wxs)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(wxs.class);
      if (paramView != null) {
        paramView.d_();
      }
      return;
    }
    wxe.b("Q.qqstory.publish.edit.EditVideoFilter", "repeat viewpager click.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wzo
 * JD-Core Version:    0.7.0.1
 */