import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.EditInfoActivity;
import java.io.UnsupportedEncodingException;

public class alc
  implements TextWatcher
{
  public alc(EditInfoActivity paramEditInfoActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
    {
      this.a.b = ("0/" + this.a.c);
      this.a.a.post(new ald(this));
      return;
    }
    try
    {
      paramInt1 = paramCharSequence.toString().getBytes("utf-8").length;
      this.a.b = (paramInt1 + "/" + this.a.c);
      this.a.a.post(new ale(this, paramInt1));
      return;
    }
    catch (UnsupportedEncodingException paramCharSequence)
    {
      paramCharSequence.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     alc
 * JD-Core Version:    0.7.0.1
 */