import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.widget.ClearableEditText;

public class uvm
  implements TextWatcher
{
  String aMQ;
  String aMR;
  String aMS;
  boolean aVG = true;
  boolean aVH = false;
  int bDM = 0;
  boolean fp = true;
  
  public uvm(EditActivity paramEditActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    EditActivity.b(this.this$0, true);
    if (!this.aVG) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(this.aMQ);
    if (this.fp) {}
    for (paramEditable = this.aMS;; paramEditable = "")
    {
      paramEditable = paramEditable + this.aMR;
      if (this.aVH)
      {
        this.aVG = false;
        this.this$0.e.setText(paramEditable);
        this.aVG = true;
      }
      int i = this.aMQ.length();
      int j = this.bDM;
      this.this$0.e.setSelection(i + j);
      this.this$0.bNv();
      return;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.aVG) {
      return;
    }
    this.aVH = false;
    this.aMQ = paramCharSequence.toString().substring(0, paramInt1);
    this.aMR = paramCharSequence.toString().substring(paramInt1 + paramInt2);
    if (paramInt3 > 0)
    {
      this.fp = true;
      return;
    }
    this.fp = false;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.aVG) {
      return;
    }
    this.aMS = paramCharSequence.toString().substring(paramInt1, paramInt1 + paramInt3);
    if (this.fp)
    {
      if ((this.this$0.action == 100) && (this.aMS.contains("\n")))
      {
        this.aVH = true;
        this.aMS = this.aMS.replace("\n", "");
      }
      this.bDM = this.aMS.length();
      return;
    }
    this.bDM = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uvm
 * JD-Core Version:    0.7.0.1
 */