package cooperation.qzone.share;

import android.text.Editable;
import android.widget.EditText;

class QZoneShareActivity$15
  implements Runnable
{
  QZoneShareActivity$15(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void run()
  {
    Editable localEditable;
    if (this.this$0.bK != null)
    {
      localEditable = this.this$0.bK.getText();
      if (localEditable == null) {
        break label71;
      }
    }
    label71:
    for (int i = localEditable.length();; i = 0)
    {
      this.this$0.bK.setSelection(i);
      if ((!this.this$0.isFinishing()) && (!this.this$0.sa)) {
        this.this$0.showKeyboard();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.15
 * JD-Core Version:    0.7.0.1
 */