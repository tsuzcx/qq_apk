import android.widget.EditText;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.c;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.d;

class akgn
  implements IphonePickerView.c
{
  akgn(akgm paramakgm, IphonePickerView paramIphonePickerView, ausj paramausj) {}
  
  public void dn()
  {
    if ((this.val$actionSheet != null) && (this.val$actionSheet.isShowing()))
    {
      akgm.a(this.this$0, this.this$0.bn, false);
      this.val$actionSheet.dismiss();
    }
  }
  
  public void w(int paramInt1, int paramInt2)
  {
    paramInt1 = this.e.ha(0);
    this.this$0.bn.setTag(Byte.valueOf((byte)paramInt1));
    this.this$0.bn.setText(akgm.a(this.this$0).d(0, paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akgn
 * JD-Core Version:    0.7.0.1
 */