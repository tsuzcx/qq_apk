import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

class twe
  extends tnm
{
  twe(twd paramtwd) {}
  
  public void d()
  {
    super.d();
    if (bjeh.b(this.a.b()))
    {
      LinearLayout localLinearLayout = (LinearLayout)this.a.a().a.findViewById(2131297823);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
      localLayoutParams.height = twd.a(this.a);
      if (!awmc.a(this.a.a.getContext())) {
        localLinearLayout.setBackgroundColor(Color.parseColor("#181818"));
      }
      localLinearLayout.setLayoutParams(localLayoutParams);
    }
  }
  
  public void g()
  {
    super.g();
    twd.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     twe
 * JD-Core Version:    0.7.0.1
 */