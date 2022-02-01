import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.qphone.base.util.QLog;

class pet
  implements sea.a
{
  pet(peo parampeo) {}
  
  public void onSoftKeyboardClosed()
  {
    QLog.d("QCircleBaseInputPopupWindow", 1, "onSoftKeyboardClosed");
    if (peo.a(this.this$0))
    {
      peo.b(this.this$0, false);
      if (peo.a(this.this$0) != null) {
        peo.a(this.this$0).setVisibility(0);
      }
      if (peo.a(this.this$0) != null) {
        peo.a(this.this$0).setVisibility(0);
      }
    }
    for (;;)
    {
      peo.a(this.this$0, false);
      return;
      this.this$0.dismiss();
    }
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    QLog.d("QCircleBaseInputPopupWindow", 1, "onSoftKeyboardOpened");
    if (peo.a(this.this$0) != paramInt)
    {
      peo.a(this.this$0, paramInt);
      peo.a(this.this$0);
      peo.a(this.this$0).putInt("GroupSoftKeyboardHeight", paramInt);
      peo.a(this.this$0).commit();
    }
    this.this$0.bkm();
    peo.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pet
 * JD-Core Version:    0.7.0.1
 */