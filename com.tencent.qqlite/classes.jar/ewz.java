import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.widget.EditText;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput;

public class ewz
  implements EmoticonCallback
{
  public ewz(QQCustomDialogWtihEmoticonInput paramQQCustomDialogWtihEmoticonInput) {}
  
  public void a()
  {
    if (QQCustomDialogWtihEmoticonInput.a(this.a).getSelectionStart() == 0) {}
    for (;;)
    {
      return;
      try
      {
        Editable localEditable = QQCustomDialogWtihEmoticonInput.a(this.a).getText();
        int i = QQCustomDialogWtihEmoticonInput.a(this.a).getSelectionStart();
        int j = android.text.TextUtils.getOffsetBefore(QQCustomDialogWtihEmoticonInput.a(this.a).getText(), i);
        if (i != j)
        {
          localEditable.delete(Math.min(i, j), Math.max(i, j));
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    int i;
    int j;
    if ((paramEmoticonInfo instanceof SystemEmoticonInfo))
    {
      i = QQCustomDialogWtihEmoticonInput.a(this.a).getSelectionStart();
      j = QQCustomDialogWtihEmoticonInput.a(this.a).getSelectionEnd();
      if ((i < 0) || (j < 0) || (j < i)) {}
    }
    int k;
    int m;
    do
    {
      QQCustomDialogWtihEmoticonInput.a(this.a).getEditableText().replace(i, j, com.tencent.mobileqq.text.TextUtils.b(((SystemEmoticonInfo)paramEmoticonInfo).a));
      do
      {
        return;
      } while (!(paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo));
      paramEmoticonInfo = (SystemAndEmojiEmoticonInfo)paramEmoticonInfo;
      i = QQCustomDialogWtihEmoticonInput.a(this.a).getSelectionStart();
      j = QQCustomDialogWtihEmoticonInput.a(this.a).getSelectionEnd();
      k = paramEmoticonInfo.e;
      m = paramEmoticonInfo.f;
    } while ((i < 0) || (j < 0) || (j < i) || ((k == 2) && (m == -1)));
    if (k == 1) {}
    for (paramEmoticonInfo = com.tencent.mobileqq.text.TextUtils.b(m);; paramEmoticonInfo = com.tencent.mobileqq.text.TextUtils.a(m))
    {
      QQCustomDialogWtihEmoticonInput.a(this.a).getEditableText().replace(i, j, paramEmoticonInfo);
      QQCustomDialogWtihEmoticonInput.a(this.a).requestFocus();
      return;
    }
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
  {
    return true;
  }
  
  public void b() {}
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  public void c() {}
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ewz
 * JD-Core Version:    0.7.0.1
 */