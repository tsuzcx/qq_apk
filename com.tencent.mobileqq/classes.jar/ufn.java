import android.view.View;
import android.view.View.OnFocusChangeListener;

class ufn
  implements View.OnFocusChangeListener
{
  ufn(ufj paramufj) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.onClick(ufj.a(this.a));
      return;
    }
    ufj.a(this.a, 0, 8);
    this.a.b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufn
 * JD-Core Version:    0.7.0.1
 */