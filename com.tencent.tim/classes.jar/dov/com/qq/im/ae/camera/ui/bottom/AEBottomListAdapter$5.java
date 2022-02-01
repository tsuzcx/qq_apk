package dov.com.qq.im.ae.camera.ui.bottom;

import awxq;
import axbr;
import axbu;
import com.tencent.qphone.base.util.QLog;

public class AEBottomListAdapter$5
  implements Runnable
{
  public AEBottomListAdapter$5(awxq paramawxq, axbu paramaxbu) {}
  
  public void run()
  {
    if (awxq.a(this.this$0).getVisibility() == 0)
    {
      awxq.a(this.this$0).b(this.b, true);
      QLog.d("AEBottomListAdapter", 4, "### [bottom list] select material " + this.b.id);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.5
 * JD-Core Version:    0.7.0.1
 */