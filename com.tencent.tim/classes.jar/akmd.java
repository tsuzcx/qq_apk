import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.tencent.mobileqq.ocr.OCRResultActivity;
import com.tencent.mobileqq.widget.OCRBottomTabView;

public class akmd
  implements TextWatcher
{
  public akmd(OCRResultActivity paramOCRResultActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().trim().length() == 0)
    {
      this.a.c.setEnabled(false);
      this.a.d.setEnabled(false);
      this.a.mx.setEnabled(false);
      return;
    }
    this.a.c.setEnabled(true);
    this.a.d.setEnabled(true);
    this.a.mx.setEnabled(true);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akmd
 * JD-Core Version:    0.7.0.1
 */