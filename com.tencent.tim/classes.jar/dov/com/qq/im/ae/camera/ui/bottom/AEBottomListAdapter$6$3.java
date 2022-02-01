package dov.com.qq.im.ae.camera.ui.bottom;

import awxq;
import awxq.b;
import awxu;
import axbu;
import java.util.Map;

public class AEBottomListAdapter$6$3
  implements Runnable
{
  public AEBottomListAdapter$6$3(awxu paramawxu, axbu paramaxbu, int paramInt) {}
  
  public void run()
  {
    if (awxq.a(this.a.this$0).get(this.b.id) != null)
    {
      if ((this.val$progress < 100) && (!this.b.usable) && (this.b.downloading)) {
        ((awxq.b)awxq.a(this.a.this$0).get(this.b.id)).adx(1);
      }
    }
    else {
      return;
    }
    ((awxq.b)awxq.a(this.a.this$0).get(this.b.id)).adx(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.6.3
 * JD-Core Version:    0.7.0.1
 */