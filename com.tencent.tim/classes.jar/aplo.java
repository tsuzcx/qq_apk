import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class aplo
  implements TextWatcher
{
  aplo(aplj paramaplj, aplj.a parama, apkt paramapkt) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    int k;
    if (this.this$0.e.wC() != 0)
    {
      int j = this.this$0.e.wC();
      i = this.this$0.e.getContentLength();
      j -= i;
      k = paramInt3 - paramInt2;
      if (k > j)
      {
        QQToast.a(aplj.a(this.this$0), "最多可以输入500个字", 1).show();
        paramInt2 = j + paramInt2;
        this.a.mEditText.removeTextChangedListener(this);
        CharSequence localCharSequence = paramCharSequence.subSequence(0, paramInt1 + paramInt2);
        paramCharSequence = paramCharSequence.subSequence(paramInt1 + paramInt3, paramCharSequence.length());
        paramCharSequence = localCharSequence.toString() + paramCharSequence.toString();
        this.a.mEditText.setText(paramCharSequence);
        this.a.mEditText.addTextChangedListener(this);
        this.a.mEditText.setSelection(paramInt1 + paramInt2);
        this.this$0.a.jR(i, i + paramInt2);
        this.b.dUT = (paramInt2 + paramInt1);
        this.b.setText(paramCharSequence);
      }
    }
    for (;;)
    {
      QLog.i("xmediaEditor", 1, "onTextChanged, mData.position:" + this.b.mPosition + ", text:" + this.b.mText + ",Listener:" + toString());
      return;
      this.this$0.a.jR(i, i + k);
      this.b.dUT = (paramInt1 + k);
      this.b.setText(paramCharSequence.toString());
      continue;
      i = this.this$0.e.getContentLength();
      this.this$0.a.jR(i, i + paramInt3 - paramInt2);
      this.b.dUT = (paramInt1 + paramInt3);
      this.b.setText(paramCharSequence.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aplo
 * JD-Core Version:    0.7.0.1
 */