import android.text.Editable;
import android.text.Spannable;
import android.text.TextWatcher;
import com.tencent.mobileqq.richstatus.RichStatusEditText;
import com.tencent.mobileqq.richstatus.RichStatusEditText.b;

public class amfn
  implements TextWatcher
{
  private boolean fp;
  private boolean fq;
  private String hB;
  private int qD;
  private int qE;
  
  public amfn(RichStatusEditText paramRichStatusEditText) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((this.b.fn) && (this.fq))
    {
      this.b.fn = false;
      this.fq = false;
      this.b.getText().replace(this.qD, this.qD + this.qE, this.hB);
      this.b.setSelection(this.qD + this.hB.length());
      this.b.fn = true;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.b.fn) {
      return;
    }
    if (paramInt3 > 0)
    {
      this.fp = true;
      this.qD = paramInt1;
      this.qE = paramInt3;
      RichStatusEditText.a(this.b);
      this.b.setCursorVisible(true);
      return;
    }
    this.fp = false;
    paramCharSequence = RichStatusEditText.a(this.b, paramInt1, false, false);
    if (paramCharSequence != null)
    {
      paramInt3 = RichStatusEditText.a(this.b).getSpanStart(paramCharSequence);
      if (paramInt3 != paramInt1)
      {
        this.fq = true;
        this.qD = paramInt3;
        this.qE = (paramInt1 - paramInt3);
        this.hB = "";
      }
    }
    RichStatusEditText.a(this.b, paramInt1, paramInt2);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.b.fn) {}
    do
    {
      do
      {
        return;
      } while (!this.fp);
      arev localarev = RichStatusEditText.a(this.b, paramInt1 + paramInt3, true, false);
      if ((localarev != null) && (RichStatusEditText.a(this.b) != null) && (!RichStatusEditText.a(this.b).a(localarev)))
      {
        this.hB = "";
        this.fq = true;
        return;
      }
      this.hB = paramCharSequence.subSequence(paramInt1, paramInt1 + paramInt3).toString();
    } while (!this.hB.contains("\n"));
    this.fq = true;
    this.hB = this.hB.replace("\n", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amfn
 * JD-Core Version:    0.7.0.1
 */