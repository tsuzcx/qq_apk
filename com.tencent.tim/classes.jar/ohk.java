import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.mobileqq.widget.QQToast;

class ohk
  implements TextWatcher
{
  private int beY;
  private int lastCount;
  
  ohk(ohe paramohe) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {
      return;
    }
    ohe.a(this.this$0).removeTextChangedListener(this);
    if (paramEditable.length() > ohe.b(this.this$0))
    {
      QQToast.a(this.this$0.getContext(), acfp.m(2131704193) + ohe.b(this.this$0) + acfp.m(2131704194), 0).show();
      paramEditable.delete(this.beY, this.beY + this.lastCount);
      ohe.a(this.this$0).addTextChangedListener(this);
      return;
    }
    Object localObject1 = paramEditable.toString().substring(this.beY, this.beY + this.lastCount);
    int i = ((String)localObject1).indexOf('/');
    if ((i >= 0) && (i < ((String)localObject1).length() - 1))
    {
      localObject1 = new SpannableStringBuilder(paramEditable.toString());
      sdp.a(ohe.a(this.this$0).getContext(), (SpannableStringBuilder)localObject1);
    }
    for (;;)
    {
      for (;;)
      {
        if (localObject1 != null) {
          i = ohe.a(this.this$0).getSelectionEnd();
        }
        try
        {
          ohe.a(this.this$0).setText((CharSequence)localObject1);
          ohe.a(this.this$0).setSelection(i);
          this.lastCount = 0;
          this.beY = 0;
        }
        catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
        {
          for (;;)
          {
            ohe.a(this.this$0).setText(paramEditable.toString());
            i = paramEditable.toString().length();
          }
        }
      }
      Object localObject2 = null;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence == null) {
      return;
    }
    this.beY = paramInt1;
    this.lastCount = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ohk
 * JD-Core Version:    0.7.0.1
 */