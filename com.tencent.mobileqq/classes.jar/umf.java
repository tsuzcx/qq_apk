import android.view.View;
import android.view.View.OnFocusChangeListener;

class umf
  implements View.OnFocusChangeListener
{
  umf(umb paramumb) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.onClick(umb.a(this.a));
      return;
    }
    umb.a(this.a, 0, 8);
    this.a.b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     umf
 * JD-Core Version:    0.7.0.1
 */