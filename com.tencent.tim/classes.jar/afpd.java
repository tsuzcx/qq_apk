import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.emoticonview.EmotionSearchPanel;
import com.tencent.qphone.base.util.QLog;

public class afpd
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public afpd(EmotionSearchPanel paramEmotionSearchPanel) {}
  
  public void onGlobalLayout()
  {
    if (this.b.isDestory) {}
    Rect localRect;
    int j;
    boolean bool;
    do
    {
      return;
      localRect = new Rect();
      this.b.BT.getWindowVisibleDisplayFrame(localRect);
      int i = localRect.bottom - localRect.top;
      j = this.b.BT.getHeight();
      if (i / j >= 0.8D) {
        break;
      }
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("EmotionSearchPanel", 2, "visible" + bool + " isVisiableForLast=" + this.b.caa + " displayHight=" + i + " hight=" + j);
      }
    } while (bool == this.b.caa);
    if (bool)
    {
      EmotionSearchPanel.keyboardHeight = j - localRect.bottom;
      if (QLog.isColorLevel()) {
        QLog.d("EmotionSearchPanel", 2, "keyboardHeight=" + EmotionSearchPanel.keyboardHeight);
      }
      EmotionSearchPanel.c(this.b, EmotionSearchPanel.keyboardHeight);
      this.b.MX(2);
    }
    for (;;)
    {
      this.b.caa = bool;
      return;
      bool = false;
      break;
      if (this.b.cSR == 2) {
        this.b.a.Af(12);
      }
      this.b.dbj();
      if (!aqmr.isEmpty(this.b.bc.getText().toString())) {
        afnu.cN("0X800AE25", 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afpd
 * JD-Core Version:    0.7.0.1
 */