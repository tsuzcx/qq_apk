import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.videostory.capture.PlayViewPagerAdapter;

class wrx
  implements bhwg<wsh>
{
  wrx(wru paramwru) {}
  
  public void a(@Nullable wsh paramwsh)
  {
    if (paramwsh == null) {}
    do
    {
      return;
      if (paramwsh == wsh.a)
      {
        if ((wrn.a == null) || (wrn.a != bgxx.a())) {
          bhcm.a().f("none");
        }
        wru.a(this.a).setVisibility(8);
        return;
      }
      if (paramwsh == wsh.c)
      {
        wru.a(this.a).setVisibility(8);
        return;
      }
    } while (paramwsh != wsh.b);
    if (wru.a(this.a) != null)
    {
      paramwsh = wru.a(this.a).a();
      if ((!TextUtils.isEmpty(paramwsh)) && (!"-1".equals(paramwsh))) {
        bhcm.a().f(paramwsh);
      }
    }
    wru.a(this.a).setVisibility(0);
    wru.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wrx
 * JD-Core Version:    0.7.0.1
 */