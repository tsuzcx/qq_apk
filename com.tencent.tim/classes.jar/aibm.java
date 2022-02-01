import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

class aibm
  implements TextWatcher
{
  aibm(aibl paramaibl) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (aibl.a(this.this$0) != null)
    {
      if (TextUtils.isEmpty(paramCharSequence)) {
        break label45;
      }
      if (!aibl.b(this.this$0))
      {
        aibl.b(this.this$0, true);
        aibl.a(this.this$0, 1);
      }
    }
    return;
    label45:
    this.this$0.drR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aibm
 * JD-Core Version:    0.7.0.1
 */