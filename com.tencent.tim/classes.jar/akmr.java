import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.ocr.OCRResultFragmentNew;
import com.tencent.mobileqq.widget.OCRBottomTabView;

public class akmr
  implements TextWatcher
{
  public akmr(OCRResultFragmentNew paramOCRResultFragmentNew) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().trim().length() == 0)
    {
      this.a.c.setEnabled(false);
      this.a.d.setEnabled(false);
      return;
    }
    this.a.c.setEnabled(true);
    this.a.d.setEnabled(true);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akmr
 * JD-Core Version:    0.7.0.1
 */