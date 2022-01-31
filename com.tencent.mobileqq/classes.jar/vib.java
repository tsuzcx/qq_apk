import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.biz.qqstory.takevideo.EditVideoPoi.2.1;
import com.tencent.biz.qqstory.takevideo.EditVideoPoi.2.2;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;

public class vib
  implements bfub
{
  vib(vhz paramvhz) {}
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    paramView = (PullRefreshHeader)paramView;
    if (this.a.jdField_a_of_type_Long == 0L) {}
    for (long l = System.currentTimeMillis();; l = this.a.jdField_a_of_type_Long)
    {
      paramView.c(l);
      return;
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    paramListView = (PullRefreshHeader)paramView;
    long l;
    if (this.a.jdField_a_of_type_Long == 0L)
    {
      l = System.currentTimeMillis();
      paramListView.a(l);
      if (!bbfj.g(this.a.a())) {
        break label118;
      }
      if (this.a.jdField_a_of_type_Tey != null) {
        this.a.jdField_a_of_type_Tey.a();
      }
      this.a.f();
      new Handler(Looper.getMainLooper()).postDelayed(new EditVideoPoi.2.1(this), 300L);
    }
    for (;;)
    {
      ((aavt)paramView.getTag()).a = true;
      return true;
      l = this.a.jdField_a_of_type_Long;
      break;
      label118:
      new Handler(Looper.getMainLooper()).postDelayed(new EditVideoPoi.2.2(this), 300L);
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    paramView = (PullRefreshHeader)paramView;
    if (this.a.jdField_a_of_type_Long == 0L) {}
    for (long l = System.currentTimeMillis();; l = this.a.jdField_a_of_type_Long)
    {
      paramView.b(l);
      return;
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vib
 * JD-Core Version:    0.7.0.1
 */