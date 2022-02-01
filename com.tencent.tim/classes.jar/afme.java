import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class afme
  extends afmi
{
  public static int cRU = 165;
  public int code;
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    int i = paramEditText.getSelectionStart();
    int j = paramEditText.getSelectionEnd();
    paramEditText.getEditableText().replace(i, j, aofy.fw(this.code));
    paramEditText.requestFocus();
  }
  
  public Drawable b(Context paramContext, float paramFloat)
  {
    return afku.x(this.code);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afme
 * JD-Core Version:    0.7.0.1
 */