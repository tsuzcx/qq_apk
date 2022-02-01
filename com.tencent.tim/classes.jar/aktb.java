import android.text.Editable;
import android.text.Editable.Factory;
import android.text.TextPaint;
import android.widget.EditText;
import com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity;

public class aktb
  extends Editable.Factory
{
  public aktb(AutoReplyEditActivity paramAutoReplyEditActivity) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof aofr)) {
      return (Editable)paramCharSequence;
    }
    return new aofr(paramCharSequence, 3, (int)(AutoReplyEditActivity.a(this.this$0).getTextSize() / AutoReplyEditActivity.a(this.this$0).getPaint().density));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aktb
 * JD-Core Version:    0.7.0.1
 */