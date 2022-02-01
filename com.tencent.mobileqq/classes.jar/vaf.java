import android.view.View;
import android.view.View.OnFocusChangeListener;

class vaf
  implements View.OnFocusChangeListener
{
  vaf(vab paramvab) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.onClick(vab.a(this.a));
      return;
    }
    vab.a(this.a, 0, 8);
    this.a.b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vaf
 * JD-Core Version:    0.7.0.1
 */