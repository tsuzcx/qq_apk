import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.qqstory.takevideo.EditVideoFilter;

public class wvf
  implements wvh
{
  private long jdField_a_of_type_Long;
  
  public wvf(EditVideoFilter paramEditVideoFilter) {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    wtj localwtj = (wtj)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(wtj.class);
    if (localwtj != null) {
      localwtj.a(paramMotionEvent);
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    if (paramMotionEvent2 != null)
    {
      wtj localwtj = (wtj)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(wtj.class);
      if (localwtj != null) {}
      for (boolean bool = localwtj.a(paramMotionEvent2);; bool = false)
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
      paramView = (wtj)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(wtj.class);
      if (paramView != null) {
        paramView.e_();
      }
      return;
    }
    wsv.b("Q.qqstory.publish.edit.EditVideoFilter", "repeat viewpager click.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wvf
 * JD-Core Version:    0.7.0.1
 */