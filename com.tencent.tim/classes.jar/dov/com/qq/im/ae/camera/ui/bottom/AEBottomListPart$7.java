package dov.com.qq.im.ae.camera.ui.bottom;

import awxq;
import awxv;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AEBottomListPart$7
  implements Runnable
{
  public AEBottomListPart$7(awxv paramawxv, long paramLong) {}
  
  public void run()
  {
    if (awxv.b(this.this$0))
    {
      awxv.a(this.this$0).setVisibility(0);
      awxv.a(this.this$0).oA(new ArrayList());
      QLog.d("AEWaterMarkListPart", 4, "hot data is empty, updatePackage, total cost=" + (System.currentTimeMillis() - this.aBG));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.7
 * JD-Core Version:    0.7.0.1
 */