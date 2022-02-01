import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.widget.XEditTextEx;
import java.util.concurrent.atomic.AtomicBoolean;

class xqf
  implements TextWatcher
{
  xqf(xqa.a parama) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.this$0.a.bt.getAndSet(false);
    this.a.this$0.a.a.removeTextChangedListener(this);
    this.a.this$0.a.a.setTag(2131374485, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xqf
 * JD-Core Version:    0.7.0.1
 */