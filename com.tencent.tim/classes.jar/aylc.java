import android.view.View;
import android.view.View.OnFocusChangeListener;
import dov.com.qq.im.capture.text.DynamicTextItem;

class aylc
  implements View.OnFocusChangeListener
{
  aylc(aykw paramaykw) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.this$0.b != null)) {
      this.this$0.b.cz(this.this$0.b.Rw(), true);
    }
    ram.d("EditTextDialog", "onFocusChange:" + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aylc
 * JD-Core Version:    0.7.0.1
 */