import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.EditInfoActivity;
import java.io.UnsupportedEncodingException;

public class cqa
  implements TextWatcher
{
  public cqa(EditInfoActivity paramEditInfoActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
    {
      this.a.b = ("0/" + this.a.c);
      this.a.a.post(new cqb(this));
      return;
    }
    try
    {
      paramInt1 = paramCharSequence.toString().getBytes("utf-8").length;
      this.a.b = (paramInt1 + "/" + this.a.c);
      this.a.a.post(new cqc(this, paramInt1));
      return;
    }
    catch (UnsupportedEncodingException paramCharSequence)
    {
      paramCharSequence.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cqa
 * JD-Core Version:    0.7.0.1
 */