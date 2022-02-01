import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;

class aylg
  implements View.OnSystemUiVisibilityChangeListener
{
  aylg(aykw paramaykw) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if ((paramInt & 0x4) == 0)
    {
      ram.d("EditTextDialog", "onStatusBarShow");
      this.this$0.getWindow().getDecorView().removeCallbacks(aykw.a(this.this$0));
      this.this$0.getWindow().getDecorView().postDelayed(aykw.a(this.this$0), 1500L);
      return;
    }
    ram.d("EditTextDialog", "onStatusBarHide");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aylg
 * JD-Core Version:    0.7.0.1
 */