import android.view.View;
import android.view.View.OnFocusChangeListener;

class ohi
  implements View.OnFocusChangeListener
{
  ohi(ohe paramohe) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ohe.a(this.this$0, true);
      return;
    }
    this.this$0.hideSoftInput(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ohi
 * JD-Core Version:    0.7.0.1
 */