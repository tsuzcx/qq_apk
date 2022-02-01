import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.ImageButton;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel;

public class afqu
  implements TextWatcher
{
  public afqu(SystemAndEmojiUniversalPanel paramSystemAndEmojiUniversalPanel) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    ImageButton localImageButton;
    if (SystemAndEmojiUniversalPanel.a(this.this$0) != null)
    {
      localImageButton = SystemAndEmojiUniversalPanel.a(this.this$0);
      if (TextUtils.isEmpty(paramEditable)) {
        break label33;
      }
    }
    label33:
    for (boolean bool = true;; bool = false)
    {
      localImageButton.setEnabled(bool);
      return;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afqu
 * JD-Core Version:    0.7.0.1
 */