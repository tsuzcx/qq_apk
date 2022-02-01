import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;

class vnx
  implements aagf
{
  vnx(vnw paramvnw) {}
  
  public void a()
  {
    QLog.d("QCircleBaseInputPopupWindow", 1, "onSoftKeyboardClosed");
    if (!vnw.a(this.a)) {
      this.a.dismiss();
    }
    vnw.b(this.a, false);
  }
  
  public void a(int paramInt)
  {
    QLog.d("QCircleBaseInputPopupWindow", 1, "onSoftKeyboardOpened");
    if (vnw.a(this.a) != paramInt)
    {
      vnw.a(this.a, paramInt);
      vnw.a(this.a).putInt("GroupSoftKeyboardHeight", paramInt);
      vnw.b(this.a).commit();
    }
    vnw.a(this.a);
    vnw.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vnx
 * JD-Core Version:    0.7.0.1
 */