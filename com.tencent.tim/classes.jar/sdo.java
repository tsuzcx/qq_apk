import android.text.Editable;
import android.view.KeyEvent;
import android.widget.EditText;
import com.tencent.biz.subscribe.comment.EmoView;
import com.tencent.biz.subscribe.comment.EmoView.a;
import com.tencent.mobileqq.widget.QQToast;

public class sdo
  implements EmoView.a
{
  public sdo(EmoView paramEmoView) {}
  
  public boolean MD()
  {
    if (EmoView.a(this.this$0) == null) {
      return false;
    }
    EmoView.a(this.this$0).dispatchKeyEvent(new KeyEvent(0L, 0L, 0, 67, 0, 0));
    return true;
  }
  
  public boolean fT(String paramString)
  {
    if (EmoView.a(this.this$0) == null) {
      return false;
    }
    if ((EmoView.b(this.this$0) > 0) && (EmoView.a(this.this$0).getText().length() + paramString.length() > EmoView.b(this.this$0)))
    {
      QQToast.a(this.this$0.getContext(), 0, acfp.m(2131705883), 0);
      return false;
    }
    EmoView.a(EmoView.a(this.this$0), paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sdo
 * JD-Core Version:    0.7.0.1
 */