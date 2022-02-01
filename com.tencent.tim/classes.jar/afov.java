import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmotionSearchPanel;

public class afov
  implements TextView.OnEditorActionListener
{
  public afov(EmotionSearchPanel paramEmotionSearchPanel) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (paramInt == 3)
    {
      if (!aqmr.isEmpty(this.b.bc.getText().toString()))
      {
        anot.a(this.b.app, "dc00898", "", "", "0X800AE28", "0X800AE28", 0, 0, "2", "", this.b.bc.getText().toString(), "");
        EmotionSearchPanel.a(this.b, true);
        ((afnd)this.b.a.a().a().a(7)).daN();
      }
      bool = true;
      EmotionSearchPanel.a(this.b);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afov
 * JD-Core Version:    0.7.0.1
 */