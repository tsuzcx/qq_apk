package dov.com.qq.im.ae;

import awtq;
import axbr;
import axbu;
import axgi;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.util.List;

public class AEPituCameraUnit$17
  implements Runnable
{
  public AEPituCameraUnit$17(awtq paramawtq, VideoMaterial paramVideoMaterial) {}
  
  public void run()
  {
    if ((awtq.a(this.this$0) != null) && (awtq.a(this.this$0).a(131072) != null)) {
      awtq.a(this.this$0).a(131072).F(114, this.val$material);
    }
    if ((axbr.b().dtX) && (LogicDataManager.getInstance().getEditableWMElement().size() > 0))
    {
      axbr.b().dtX = false;
      awtq.a(this.this$0).p(589825, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.17
 * JD-Core Version:    0.7.0.1
 */