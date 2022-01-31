import android.text.Editable;
import android.view.KeyEvent;
import android.widget.EditText;
import com.tencent.biz.subscribe.comment.EmoView;
import com.tencent.mobileqq.widget.QQToast;

public class ycu
  implements ycv
{
  public ycu(EmoView paramEmoView) {}
  
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
      QQToast.a(this.a.getContext(), 0, alpo.a(2131704504), 0);
      return false;
    }
    EmoView.a(EmoView.a(this.a), paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ycu
 * JD-Core Version:    0.7.0.1
 */