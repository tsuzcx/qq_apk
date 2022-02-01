import android.app.Activity;
import android.text.Editable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mobileqq.ocr.ui.BaseOCRTextSearchFragment.a;
import com.tencent.mobileqq.ocr.ui.OCRTextSearchActivity;
import com.tencent.mobileqq.ocr.ui.OCRTextSearchActivity.a;

public class akof
  implements BaseOCRTextSearchFragment.a
{
  public akof(OCRTextSearchActivity paramOCRTextSearchActivity) {}
  
  public void MV(boolean paramBoolean)
  {
    this.a.a.MW(paramBoolean);
  }
  
  public void NH(String paramString)
  {
    this.a.NH(paramString);
  }
  
  public void eI(View paramView)
  {
    if (paramView == null) {
      this.a.d.hideSoftInputFromWindow(this.a.I.getWindowToken(), 0);
    }
    for (;;)
    {
      this.a.I.clearFocus();
      this.a.I.setCursorVisible(false);
      NH(this.a.I.getText().toString().trim());
      this.a.I.setSelection(this.a.I.getText().length());
      return;
      this.a.d.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    }
  }
  
  public Activity getActivity()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akof
 * JD-Core Version:    0.7.0.1
 */