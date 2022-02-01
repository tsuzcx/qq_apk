import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.qphone.base.util.QLog;

class ahiv
  implements afmf
{
  ahiv(ahio paramahio) {}
  
  public void a(afmi paramafmi)
  {
    int i;
    int j;
    if ((paramafmi instanceof afqv))
    {
      i = ahio.a(this.this$0).getSelectionStart();
      j = ahio.a(this.this$0).getSelectionEnd();
      if ((i < 0) || (j < 0) || (j < i)) {}
    }
    afqr localafqr;
    int k;
    int m;
    do
    {
      ahio.a(this.this$0).getEditableText().replace(i, j, aofy.fx(((afqv)paramafmi).code));
      do
      {
        return;
      } while (!(paramafmi instanceof afqr));
      localafqr = (afqr)paramafmi;
      i = ahio.a(this.this$0).getSelectionStart();
      j = ahio.a(this.this$0).getSelectionEnd();
      k = localafqr.ahx;
      m = localafqr.code;
      if ((i < 0) || (j < 0) || (j < i)) {
        break;
      }
    } while ((k == 2) && (m == -1));
    String str = "";
    if (k == 1) {}
    try
    {
      for (paramafmi = aofy.fx(m);; paramafmi = aofy.fw(m))
      {
        ahio.a(this.this$0).getEditableText().replace(i, j, paramafmi);
        ahio.a(this.this$0).requestFocus();
        localafqr.o((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), null);
        afkv.a().a(k).hL(m, 4);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramafmi = str;
        if (QLog.isColorLevel())
        {
          QLog.d("Forward.NewVersion.Dialog", 2, QLog.getStackTraceString(localException));
          paramafmi = str;
        }
      }
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
    if (ahio.a(this.this$0).getSelectionStart() == 0) {}
    for (;;)
    {
      return;
      try
      {
        Editable localEditable = ahio.a(this.this$0).getText();
        int i = ahio.a(this.this$0).getSelectionStart();
        int j = TextUtils.getOffsetBefore(ahio.a(this.this$0).getText(), i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahiv
 * JD-Core Version:    0.7.0.1
 */