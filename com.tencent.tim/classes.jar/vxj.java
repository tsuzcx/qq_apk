import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.TextPreviewTranslateActivity;

public class vxj
  implements TextView.OnEditorActionListener
{
  public vxj(TextPreviewTranslateActivity paramTextPreviewTranslateActivity) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 6) && (TextPreviewTranslateActivity.a(this.a) != null))
    {
      TextPreviewTranslateActivity.a(this.a, TextPreviewTranslateActivity.a(this.a).getText().toString());
      TextPreviewTranslateActivity.a(this.a);
      TextPreviewTranslateActivity.a(this.a, TextPreviewTranslateActivity.a(this.a));
      TextPreviewTranslateActivity.b(this.a, TextPreviewTranslateActivity.b(this.a));
      TextPreviewTranslateActivity.a(this.a, TextPreviewTranslateActivity.b(this.a, TextPreviewTranslateActivity.c(this.a)), TextPreviewTranslateActivity.a(this.a), TextPreviewTranslateActivity.b(this.a));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vxj
 * JD-Core Version:    0.7.0.1
 */