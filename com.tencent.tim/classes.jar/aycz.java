import android.text.InputFilter.LengthFilter;
import android.text.Spanned;
import com.tencent.mobileqq.widget.QQToast;

class aycz
  extends InputFilter.LengthFilter
{
  boolean isNeedReport = true;
  
  aycz(aycy paramaycy, int paramInt1, int paramInt2)
  {
    super(paramInt1);
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if (this.val$length - (paramSpanned.length() - (paramInt4 - paramInt3)) <= 0)
    {
      if (this.isNeedReport)
      {
        rar.a("textEdit", "overLimit", aycm.b(this.a.this$0), 0, new String[0]);
        this.isNeedReport = false;
      }
      if (aycm.a(this.a.this$0) != null) {
        QQToast.a(this.a.getContext(), acfp.m(2131714847) + aycm.a(this.a.this$0).bjZ + acfp.m(2131714833), 0).show();
      }
    }
    for (;;)
    {
      return super.filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
      this.isNeedReport = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aycz
 * JD-Core Version:    0.7.0.1
 */