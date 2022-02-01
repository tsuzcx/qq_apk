import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.tencent.mobileqq.freshnews.BlockableEditTextView;
import com.tencent.mobileqq.freshnews.BlockableEditTextView.a;

public class ahpe
  implements TextWatcher
{
  public boolean chQ;
  public CharSequence charSequence = "";
  int dat = -1;
  int dau = -1;
  public int flag;
  
  public ahpe(BlockableEditTextView paramBlockableEditTextView) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((this.chQ) || (this.flag == 0)) {}
    while (this.flag >= 0) {
      return;
    }
    if (BlockableEditTextView.a(this.c) == 2)
    {
      this.chQ = true;
      this.c.setText(this.charSequence);
      this.chQ = false;
      return;
    }
    this.chQ = true;
    this.c.setText(TextUtils.concat(new CharSequence[] { this.charSequence.subSequence(this.dau, this.charSequence.length()), this.charSequence.subSequence(0, this.dat) }));
    this.chQ = false;
    this.c.setSelection(this.dat);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.chQ) || (BlockableEditTextView.a(this.c) == 0)) {}
    do
    {
      Editable localEditable;
      BlockableEditTextView.a[] arrayOfa;
      do
      {
        do
        {
          do
          {
            return;
            this.flag = 0;
          } while (paramInt3 == paramInt2);
          localEditable = this.c.getEditableText();
        } while (localEditable == null);
        arrayOfa = (BlockableEditTextView.a[])localEditable.getSpans(paramInt1, paramInt1, BlockableEditTextView.a.class);
      } while ((arrayOfa == null) || (arrayOfa.length <= 0));
      this.dat = localEditable.getSpanStart(arrayOfa[0]);
      this.dau = localEditable.getSpanEnd(arrayOfa[0]);
    } while ((this.dau < 0) || (this.dau < this.dat) || (paramInt2 <= paramInt3) || (BlockableEditTextView.a(this.c) == 0) || (paramInt1 == this.dat) || (paramInt1 == this.dau));
    this.charSequence = new SpannableStringBuilder(paramCharSequence).subSequence(0, paramCharSequence.length());
    this.flag = -1;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahpe
 * JD-Core Version:    0.7.0.1
 */