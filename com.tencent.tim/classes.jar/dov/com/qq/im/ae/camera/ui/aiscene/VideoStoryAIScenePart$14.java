package dov.com.qq.im.ae.camera.ui.aiscene;

import android.os.Bundle;
import awtq;
import awwf;
import awwg;
import awxg;
import axim;
import axpr;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.panel.AEFilterProviderView;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;

public class VideoStoryAIScenePart$14
  implements Runnable
{
  public VideoStoryAIScenePart$14(awxg paramawxg, QIMFilterCategoryItem paramQIMFilterCategoryItem, Bundle paramBundle, axpr paramaxpr) {}
  
  public void run()
  {
    if ((awxg.a(this.this$0) != null) && (!awxg.a(this.this$0).aNF())) {}
    while ((awxg.c(this.this$0) == null) || (awxg.a(this.this$0).Is() != 2)) {
      return;
    }
    awxg.b(this.this$0, true);
    axim.a().acL(this.d.id);
    if ((awwf.a() != null) && (!awwf.a().dtj)) {
      this.val$bundle.putBoolean("capture_force_enable", true);
    }
    this.a.a(this.d, awxg.d(this.this$0), this.val$bundle);
    AEFilterProviderView.ack(this.d.id);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.14
 * JD-Core Version:    0.7.0.1
 */