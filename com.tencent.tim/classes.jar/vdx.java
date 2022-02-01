import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.mobileqq.activity.HotChatAnnounceActivity;

public class vdx
  implements TextWatcher
{
  public vdx(HotChatAnnounceActivity paramHotChatAnnounceActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    int i = 0;
    if (!TextUtils.isEmpty(paramEditable)) {
      i = paramEditable.getBytes().length / 3;
    }
    if (i <= 40) {
      this.a.DK.setTextColor(this.a.getResources().getColor(2131167379));
    }
    for (;;)
    {
      this.a.DK.setText("" + (40 - i));
      return;
      this.a.DK.setTextColor(-65536);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vdx
 * JD-Core Version:    0.7.0.1
 */