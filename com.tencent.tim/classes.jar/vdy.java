import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.tencent.mobileqq.activity.HotChatAnnounceActivity;

public class vdy
  implements TextWatcher
{
  public vdy(HotChatAnnounceActivity paramHotChatAnnounceActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    if ((paramEditable != null) && (paramEditable.trim().length() > 0))
    {
      this.a.tu.setEnabled(true);
      return;
    }
    this.a.tu.setEnabled(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vdy
 * JD-Core Version:    0.7.0.1
 */