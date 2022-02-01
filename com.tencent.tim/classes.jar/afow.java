import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.tencent.mobileqq.emoticonview.EmotionSearchPanel;

public class afow
  implements TextWatcher
{
  public afow(EmotionSearchPanel paramEmotionSearchPanel) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (!aqmr.isEmpty(paramEditable.toString())) {
      this.b.yU.setVisibility(0);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afow
 * JD-Core Version:    0.7.0.1
 */