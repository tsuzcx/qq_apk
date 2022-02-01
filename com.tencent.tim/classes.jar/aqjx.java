import android.text.Layout;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;

class aqjx
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  aqjx(aqju paramaqju, int paramInt, String paramString) {}
  
  public void onGlobalLayout()
  {
    this.aG.text.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    int i;
    if (this.aG.text.getLineCount() > this.val$i)
    {
      i = this.aG.text.getLayout().getLineEnd(this.val$i - 1);
      if (this.val$strText != null) {
        break label134;
      }
    }
    label134:
    for (String str = "";; str = this.val$strText)
    {
      boolean bool1 = aofk.containsEmoji(str);
      boolean bool2 = aofk.pU(str);
      if ((!bool1) && (!bool2))
      {
        str = this.aG.text.getText().subSequence(0, i - 3) + "...";
        this.aG.text.setText(str);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqjx
 * JD-Core Version:    0.7.0.1
 */