import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

class pev
  implements TextWatcher
{
  private int beY;
  private int lastCount;
  
  pev(peo parampeo) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    skb.b localb = null;
    if (paramEditable == null) {
      return;
    }
    this.this$0.a.removeTextChangedListener(this);
    String str = paramEditable.toString().substring(this.beY, this.beY + this.lastCount);
    int i = str.indexOf('/');
    Object localObject = localb;
    if (i >= 0)
    {
      localObject = localb;
      if (i < str.length() - 1)
      {
        localObject = new skb.a(paramEditable.toString());
        localb = new skb.b();
        localb.oj = ((int)(22.0D * BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density + 0.5D));
        localb.verticalAlignment = 0;
        localb.D = paramEditable.toString();
        skb.a(localb, str, null, (skb.a)localObject, false);
      }
    }
    if (localObject != null) {
      i = this.this$0.a.getSelectionEnd();
    }
    try
    {
      this.this$0.a.setText((CharSequence)localObject);
      this.this$0.a.setSelection(i);
      this.lastCount = 0;
      this.beY = 0;
      this.this$0.a.addTextChangedListener(this);
      return;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      for (;;)
      {
        this.this$0.a.setText(paramEditable.toString());
        i = paramEditable.toString().length();
      }
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
 * Qualified Name:     pev
 * JD-Core Version:    0.7.0.1
 */