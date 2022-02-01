import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;

class vqf
  implements aakg
{
  vqf(vqe paramvqe) {}
  
  public void a()
  {
    QLog.d("QCircleBaseInputPopupWindow", 1, "onSoftKeyboardClosed");
    if (!vqe.a(this.a)) {
      this.a.dismiss();
    }
    vqe.b(this.a, false);
  }
  
  public void a(int paramInt)
  {
    QLog.d("QCircleBaseInputPopupWindow", 1, "onSoftKeyboardOpened");
    if (vqe.a(this.a) != paramInt)
    {
      vqe.a(this.a, paramInt);
      vqe.a(this.a).putInt("GroupSoftKeyboardHeight", paramInt);
      vqe.b(this.a).commit();
    }
    vqe.a(this.a);
    vqe.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqf
 * JD-Core Version:    0.7.0.1
 */