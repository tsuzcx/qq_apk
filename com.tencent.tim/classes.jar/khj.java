import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveUtils;

public class khj
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public khj(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity) {}
  
  public void onGlobalLayout()
  {
    Rect localRect = new Rect();
    this.this$0.c.getWindowVisibleDisplayFrame(localRect);
    int j = this.this$0.c.getRootView().getHeight();
    int i = j - localRect.height();
    if (i > 100) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseDeliverActivity", 2, "onGlobalLayout screenHeight:" + j + ", ExternalPanelheight:" + i + ", isShowKeybroad:" + bool);
      }
      if (bool != this.this$0.BE)
      {
        if (i > this.this$0.aIN) {
          this.this$0.aIN = i;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseDeliverActivity", 2, "onGlobalLayout mMAXExternalPanelheight:" + this.this$0.aIN);
        }
        i = aqnm.dpToPx(this.this$0.aIO);
        j = j - ImmersiveUtils.getStatusBarHeight(this.this$0) - this.this$0.getTitleBarHeight() - this.this$0.aIN;
        int k = j - i;
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseDeliverActivity", 2, "onGlobalLayout contentHeight:" + j + ", fixedHeight:" + i + ", maxHeight:" + k);
        }
        this.this$0.N.setMaxHeight(k);
      }
      this.this$0.BE = bool;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     khj
 * JD-Core Version:    0.7.0.1
 */