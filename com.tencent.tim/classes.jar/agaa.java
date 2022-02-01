import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import java.io.UnsupportedEncodingException;

public class agaa
  implements TextWatcher
{
  public agaa(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  private int bC(String paramString)
  {
    byte[] arrayOfByte = new byte[0];
    try
    {
      paramString = paramString.getBytes("utf-8");
      if (paramString.length % 3 == 0) {
        return paramString.length / 3;
      }
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = arrayOfByte;
      }
    }
    return paramString.length / 3 + 1;
  }
  
  private String hb(String paramString)
  {
    while (bC(paramString) > 32)
    {
      int i = paramString.length();
      if ((i >= 2) && (Character.isHighSurrogate(paramString.charAt(i - 2)))) {
        paramString = paramString.substring(0, i - 2);
      } else {
        paramString = paramString.substring(0, i - 1);
      }
    }
    return paramString;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.this$0.bf.getText().toString();
    if (bC(paramEditable) > 32)
    {
      int i = this.this$0.bf.getSelectionStart();
      paramEditable = hb(paramEditable);
      this.this$0.bf.setText(paramEditable);
      if (i >= paramEditable.length()) {
        this.this$0.bf.setSelection(paramEditable.length());
      }
    }
    if (this.this$0.cch)
    {
      anot.a(null, "CliOper", "", "", "0X80050F0", "0X80050F0", 0, 0, "", "", "", "");
      this.this$0.cch = false;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agaa
 * JD-Core Version:    0.7.0.1
 */