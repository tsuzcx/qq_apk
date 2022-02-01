import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.qqstory.takevideo.EditVideoFilter;
import com.tencent.biz.qqstory.takevideo.EditVideoFilter.b;

public class rck
  implements EditVideoFilter.b
{
  private long iu;
  
  public rck(EditVideoFilter paramEditVideoFilter) {}
  
  public void L(MotionEvent paramMotionEvent)
  {
    rba localrba = (rba)this.a.a(rba.class);
    if (localrba != null) {
      localrba.K(paramMotionEvent);
    }
  }
  
  public boolean c(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    if (paramMotionEvent2 != null)
    {
      rba localrba = (rba)this.a.a(rba.class);
      if (localrba != null) {}
      for (boolean bool = localrba.G(paramMotionEvent2);; bool = false)
      {
        if (bool)
        {
          L(paramMotionEvent1);
          L(paramMotionEvent2);
        }
        return bool;
      }
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.iu > 300L)
    {
      this.iu = l;
      paramView = (rba)this.a.a(rba.class);
      if (paramView != null) {
        paramView.KS();
      }
      return;
    }
    ram.d("Q.qqstory.publish.edit.EditVideoFilter", "repeat viewpager click.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rck
 * JD-Core Version:    0.7.0.1
 */