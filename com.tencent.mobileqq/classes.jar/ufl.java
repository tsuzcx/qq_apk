import android.view.View;
import android.view.View.OnFocusChangeListener;

class ufl
  implements View.OnFocusChangeListener
{
  ufl(ufh paramufh) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.onClick(ufh.a(this.a));
      return;
    }
    ufh.a(this.a, 0, 8);
    this.a.b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ufl
 * JD-Core Version:    0.7.0.1
 */