import android.text.Editable;
import android.view.KeyEvent;
import android.widget.EditText;
import com.tencent.biz.subscribe.comment.EmoView;

public class wof
  implements wog
{
  public wof(EmoView paramEmoView) {}
  
  public boolean a()
  {
    if (EmoView.a(this.a) == null) {
      return false;
    }
    EmoView.a(this.a).dispatchKeyEvent(new KeyEvent(0L, 0L, 0, 67, 0, 0));
    return true;
  }
  
  public boolean a(String paramString)
  {
    if (EmoView.a(this.a) == null) {
      return false;
    }
    if ((EmoView.b(this.a) > 0) && (EmoView.a(this.a).getText().length() + paramString.length() > EmoView.b(this.a)))
    {
      bcql.a(this.a.getContext(), 0, ajya.a(2131704132), 0);
      return false;
    }
    EmoView.a(EmoView.a(this.a), paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wof
 * JD-Core Version:    0.7.0.1
 */