import android.widget.EditText;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.c;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.d;

class akfl
  implements IphonePickerView.c
{
  akfl(akfk paramakfk, IphonePickerView paramIphonePickerView, ausj paramausj) {}
  
  public void dn()
  {
    if ((this.val$actionSheet != null) && (this.val$actionSheet.isShowing()))
    {
      akfk.a(this.this$0, this.this$0.bn, false);
      this.val$actionSheet.dismiss();
    }
  }
  
  public void w(int paramInt1, int paramInt2)
  {
    paramInt1 = this.e.ha(0);
    this.this$0.bn.setTag(Byte.valueOf((byte)paramInt1));
    this.this$0.bn.setText(akfk.a(this.this$0).d(0, paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akfl
 * JD-Core Version:    0.7.0.1
 */