import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;

class axey
  implements TextWatcher
{
  boolean dur = false;
  
  axey(axeu paramaxeu) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    int j;
    int i;
    int m;
    int k;
    if (paramEditable.length() > 0)
    {
      axeu.a(this.this$0).setVisibility(0);
      j = 1;
      i = 0;
      m = 0;
      k = 0;
    }
    char c;
    label55:
    int n;
    for (;;)
    {
      if (i < paramEditable.length())
      {
        c = paramEditable.charAt(i);
        if (c == '\n')
        {
          return;
          axeu.a(this.this$0).setVisibility(4);
          j = 1;
          i = 0;
          m = 0;
          k = 0;
        }
        else
        {
          n = j;
          if (c == ' ')
          {
            if (j == 0) {
              break label244;
            }
            n = 0;
            m = i;
          }
        }
      }
    }
    for (;;)
    {
      k += axeu.a(this.this$0, c);
      if ((k > 16) && (!this.dur))
      {
        axeu.a(this.this$0).removeTextChangedListener(this);
        if (n == 0) {
          axeu.a(this.this$0).setText(paramEditable.insert(m, "\r\n"));
        }
        for (;;)
        {
          axeu.a(this.this$0).setSelection(paramEditable.length());
          this.dur = true;
          axeu.a(this.this$0).addTextChangedListener(this);
          return;
          axeu.a(this.this$0).setText(paramEditable.insert(i, "\r\n"));
        }
      }
      i += 1;
      j = n;
      break;
      if (k > 16) {
        break label55;
      }
      this.dur = false;
      return;
      label244:
      m = i;
      n = j;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axey
 * JD-Core Version:    0.7.0.1
 */