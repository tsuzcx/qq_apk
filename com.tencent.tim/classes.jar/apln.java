import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.qphone.base.util.QLog;

class apln
  implements View.OnFocusChangeListener
{
  apln(aplj paramaplj, apkt paramapkt, aplj.a parama) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    QLog.i("xmediaEditor", 1, "mData.position:" + this.b.mPosition + ", text:" + this.b.mText + ",onFocusChange:" + paramBoolean);
    if (paramBoolean)
    {
      this.a.mEditText.setCursorVisible(true);
      this.this$0.a.j(this.a);
      this.b.cRf = true;
    }
    for (;;)
    {
      this.a.mEditText.setFocusable(paramBoolean);
      this.a.mEditText.setFocusableInTouchMode(paramBoolean);
      return;
      this.a.mEditText.setCursorVisible(false);
      this.this$0.a.k(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apln
 * JD-Core Version:    0.7.0.1
 */