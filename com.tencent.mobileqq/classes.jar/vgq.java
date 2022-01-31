import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.qqstory.takevideo.EditVideoFilter;

public class vgq
  implements vgs
{
  private long jdField_a_of_type_Long;
  
  public vgq(EditVideoFilter paramEditVideoFilter) {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    veu localveu = (veu)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(veu.class);
    if (localveu != null) {
      localveu.a(paramMotionEvent);
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    if (paramMotionEvent2 != null)
    {
      veu localveu = (veu)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(veu.class);
      if (localveu != null) {}
      for (boolean bool = localveu.a(paramMotionEvent2);; bool = false)
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
      paramView = (veu)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(veu.class);
      if (paramView != null) {
        paramView.d_();
      }
      return;
    }
    veg.b("Q.qqstory.publish.edit.EditVideoFilter", "repeat viewpager click.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vgq
 * JD-Core Version:    0.7.0.1
 */