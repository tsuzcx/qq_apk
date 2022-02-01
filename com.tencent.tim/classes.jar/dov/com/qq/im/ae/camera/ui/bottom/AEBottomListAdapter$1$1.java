package dov.com.qq.im.ae.camera.ui.bottom;

import awxq;
import awxr;
import java.util.List;
import jqc;

public class AEBottomListAdapter$1$1
  implements Runnable
{
  public AEBottomListAdapter$1$1(awxr paramawxr) {}
  
  public void run()
  {
    int i = jqc.getNetWorkType();
    if (i != 0) {
      this.a.this$0.notifyDataSetChanged();
    }
    if ((i == 1) && (awxq.a(this.a.this$0).size() > 1)) {
      this.a.this$0.eHv();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */