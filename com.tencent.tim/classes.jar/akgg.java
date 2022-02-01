import android.widget.EditText;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.c;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.d;

class akgg
  implements IphonePickerView.c
{
  akgg(akfk paramakfk, IphonePickerView paramIphonePickerView, ausj paramausj) {}
  
  public void dn()
  {
    if ((this.val$actionSheet != null) && (this.val$actionSheet.isShowing()))
    {
      akfk.a(this.this$0, this.this$0.bu, false);
      this.val$actionSheet.dismiss();
    }
  }
  
  public void w(int paramInt1, int paramInt2)
  {
    paramInt1 = this.e.ha(0);
    this.this$0.bu.setTag(Byte.valueOf((byte)(paramInt1 + 1)));
    this.this$0.bu.setText(akfk.b(this.this$0).d(0, paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akgg
 * JD-Core Version:    0.7.0.1
 */