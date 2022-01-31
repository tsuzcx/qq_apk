import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.qphone.base.util.QLog;

class ucj
  implements yhs
{
  ucj(uce paramuce) {}
  
  public void a()
  {
    QLog.d("QCircleBaseInputPopupWindow", 1, "onSoftKeyboardClosed");
    if (uce.a(this.a))
    {
      uce.b(this.a, false);
      if (uce.a(this.a) != null) {
        uce.a(this.a).setVisibility(0);
      }
      if (uce.a(this.a) != null) {
        uce.a(this.a).setVisibility(0);
      }
    }
    for (;;)
    {
      uce.a(this.a, false);
      return;
      this.a.dismiss();
    }
  }
  
  public void a(int paramInt)
  {
    QLog.d("QCircleBaseInputPopupWindow", 1, "onSoftKeyboardOpened");
    if (uce.a(this.a) != paramInt)
    {
      uce.a(this.a, paramInt);
      uce.a(this.a);
      uce.a(this.a).putInt("GroupSoftKeyboardHeight", paramInt);
      uce.a(this.a).commit();
    }
    this.a.c();
    uce.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ucj
 * JD-Core Version:    0.7.0.1
 */