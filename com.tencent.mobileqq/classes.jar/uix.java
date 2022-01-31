import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

class uix
  extends uaf
{
  uix(uiw paramuiw) {}
  
  public void d()
  {
    super.d();
    if (bkvi.b(this.a.b()))
    {
      LinearLayout localLinearLayout = (LinearLayout)this.a.a().a.findViewById(2131363368);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
      localLayoutParams.height = uiw.a(this.a);
      if (!axlk.a(this.a.a.getContext())) {
        localLinearLayout.setBackgroundColor(Color.parseColor("#181818"));
      }
      localLinearLayout.setLayoutParams(localLayoutParams);
    }
  }
  
  public void g()
  {
    super.g();
    uiw.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uix
 * JD-Core Version:    0.7.0.1
 */