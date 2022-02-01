import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;
import com.tencent.mobileqq.widget.QQToast;

public class yoh
  implements TextView.OnEditorActionListener
{
  public yoh(SearchBaseActivity paramSearchBaseActivity) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramInt != 3)
    {
      bool1 = bool2;
      if (paramKeyEvent != null)
      {
        bool1 = bool2;
        if (paramKeyEvent.getKeyCode() != 66) {}
      }
    }
    else
    {
      paramTextView = this.a.aN.getText().toString();
      if ((!TextUtils.isEmpty(paramTextView)) && (!TextUtils.isEmpty(paramTextView.trim()))) {
        break label102;
      }
      this.a.a(true, this.a.aN);
      QQToast.a(this.a.getApplicationContext(), acfp.m(2131714091), 0).show();
      bool1 = true;
    }
    return bool1;
    label102:
    if (!TextUtils.isEmpty(paramTextView))
    {
      amxk.d("add_page", "search", "clk_search_all", this.a.mFrom + 1, 0, new String[] { "", "", paramTextView, "" });
      this.a.a.bc(paramTextView, false);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yoh
 * JD-Core Version:    0.7.0.1
 */