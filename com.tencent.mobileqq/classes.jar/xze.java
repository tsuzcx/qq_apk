import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;

class xze
  extends xqm
{
  xze(xzd paramxzd) {}
  
  public void d()
  {
    super.d();
    if (LiuHaiUtils.b(this.a.b()))
    {
      LinearLayout localLinearLayout = (LinearLayout)this.a.a().a.findViewById(2131363625);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
      localLayoutParams.height = xzd.a(this.a);
      if (!bdep.a(this.a.a.getContext())) {
        localLinearLayout.setBackgroundColor(Color.parseColor("#181818"));
      }
      localLinearLayout.setLayoutParams(localLayoutParams);
    }
  }
  
  public void g()
  {
    super.g();
    xzd.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xze
 * JD-Core Version:    0.7.0.1
 */