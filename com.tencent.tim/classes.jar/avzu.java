import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;

final class avzu
  implements afmf
{
  avzu(EditText paramEditText) {}
  
  public void a(afmi paramafmi)
  {
    if ((paramafmi == null) || (this.bJ == null)) {}
    int i;
    int j;
    do
    {
      do
      {
        return;
      } while (!(paramafmi instanceof afqv));
      i = this.bJ.getSelectionStart();
      j = this.bJ.getSelectionEnd();
    } while ((i < 0) || (j < 0) || (j < i) || (this.bJ == null) || (this.bJ.getEditableText() == null));
    this.bJ.getEditableText().replace(i, j, aofy.fx(((afqv)paramafmi).code));
  }
  
  public void a(afmi paramafmi1, afmi paramafmi2, Drawable paramDrawable) {}
  
  public boolean a(afmi paramafmi)
  {
    return true;
  }
  
  public void b(afmi paramafmi) {}
  
  public void delete()
  {
    if (this.bJ == null) {}
    for (;;)
    {
      return;
      if (this.bJ.getSelectionStart() != 0) {
        try
        {
          Editable localEditable = this.bJ.getText();
          int i = this.bJ.getSelectionStart();
          int j = TextUtils.getOffsetBefore(this.bJ.getText(), i);
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
  }
  
  public void gq() {}
  
  public void send() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avzu
 * JD-Core Version:    0.7.0.1
 */