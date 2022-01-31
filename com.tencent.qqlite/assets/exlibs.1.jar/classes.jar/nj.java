import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.biz.lebasearch.SearchActivity;
import com.tencent.biz.lebasearch.SearchProtocol;

public class nj
  implements TextView.OnEditorActionListener
{
  public nj(SearchActivity paramSearchActivity) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 3) || ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 84)))
    {
      if (!TextUtils.isEmpty(SearchActivity.a(this.a).getText()))
      {
        SearchProtocol.a(this.a.app, this.a, SearchActivity.a(this.a), SearchActivity.a(this.a).getText().toString(), SearchActivity.a(this.a));
        SearchActivity.a(this.a, true);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     nj
 * JD-Core Version:    0.7.0.1
 */