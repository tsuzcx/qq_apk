import android.view.View;
import android.view.View.OnClickListener;

class wlw
  implements View.OnClickListener
{
  wlw(wlu paramwlu) {}
  
  public void onClick(View paramView)
  {
    if (!wku.c())
    {
      paramView = wlu.a(this.a);
      if (paramView != null)
      {
        this.a.d(paramView);
        if (this.a.a() != null) {
          this.a.a().c(paramView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wlw
 * JD-Core Version:    0.7.0.1
 */