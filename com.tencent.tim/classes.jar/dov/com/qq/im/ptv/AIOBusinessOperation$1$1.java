package dov.com.qq.im.ptv;

import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;
import ayag;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class AIOBusinessOperation$1$1
  implements Runnable
{
  AIOBusinessOperation$1$1(AIOBusinessOperation.1 param1, String paramString) {}
  
  public void run()
  {
    long l1 = SystemClock.uptimeMillis();
    long l2;
    if (ayag.access$000().equalsIgnoreCase(this.val$themeId))
    {
      Drawable localDrawable = (Drawable)ayag.access$100().get(ayag.access$000());
      if (localDrawable != null) {
        this.this$0.IJ.setImageDrawable(localDrawable);
      }
      l2 = SystemClock.uptimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("AIOBusinessOperation", 2, "updateLightVideoEntry cost:" + (l2 - l1) + " ms");
      }
    }
    do
    {
      return;
      ayag.access$100().clear();
      if (!"1000".equals(this.val$themeId)) {
        break;
      }
      this.this$0.IJ.setImageResource(2130845317);
      l2 = SystemClock.uptimeMillis();
    } while (!QLog.isColorLevel());
    QLog.i("AIOBusinessOperation", 2, "updateLightVideoEntry total cost:" + (l2 - l1) + " ms");
    return;
    if (this.this$0.dxq) {
      ayag.t(this.this$0.IJ, this.val$themeId);
    }
    for (;;)
    {
      ayag.access$002(this.val$themeId);
      break;
      ayag.u(this.this$0.IJ, this.val$themeId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ptv.AIOBusinessOperation.1.1
 * JD-Core Version:    0.7.0.1
 */