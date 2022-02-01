import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;

class aqkt
  implements afmf
{
  aqkt(aqkk paramaqkk) {}
  
  public void a(afmi paramafmi)
  {
    int i;
    int j;
    if ((paramafmi instanceof afqv))
    {
      i = this.this$0.U.getSelectionStart();
      j = this.this$0.U.getSelectionEnd();
      if ((i < 0) || (j < 0) || (j < i)) {}
    }
    afqr localafqr;
    int k;
    int m;
    do
    {
      this.this$0.U.getEditableText().replace(i, j, aofy.fx(((afqv)paramafmi).code));
      do
      {
        return;
      } while (!(paramafmi instanceof afqr));
      localafqr = (afqr)paramafmi;
      i = this.this$0.U.getSelectionStart();
      j = this.this$0.U.getSelectionEnd();
      k = localafqr.ahx;
      m = localafqr.code;
      if ((i < 0) || (j < 0) || (j < i)) {
        break;
      }
    } while ((k == 2) && (m == -1));
    if (k == 1) {}
    for (paramafmi = aofy.fx(m);; paramafmi = aofy.fw(m))
    {
      this.this$0.U.getEditableText().replace(i, j, paramafmi);
      this.this$0.U.requestFocus();
      if (this.this$0.cUt) {
        localafqr.o((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), null);
      }
      afkv.a().a(k).hL(m, 5);
      return;
    }
  }
  
  public void a(afmi paramafmi1, afmi paramafmi2, Drawable paramDrawable) {}
  
  public boolean a(afmi paramafmi)
  {
    return true;
  }
  
  public void b(afmi paramafmi) {}
  
  public void delete()
  {
    if (this.this$0.U.getSelectionStart() == 0) {}
    for (;;)
    {
      return;
      try
      {
        Editable localEditable = this.this$0.U.getText();
        int i = this.this$0.U.getSelectionStart();
        int j = TextUtils.getOffsetBefore(this.this$0.U.getText(), i);
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
  
  public void gq() {}
  
  public void send() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqkt
 * JD-Core Version:    0.7.0.1
 */