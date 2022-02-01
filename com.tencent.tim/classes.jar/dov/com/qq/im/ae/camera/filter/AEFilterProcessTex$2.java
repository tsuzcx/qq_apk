package dov.com.qq.im.ae.camera.filter;

import awwg;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;

public class AEFilterProcessTex$2
  implements Runnable
{
  public AEFilterProcessTex$2(awwg paramawwg, boolean paramBoolean) {}
  
  public void run()
  {
    if (awwg.a(this.this$0) != null)
    {
      awwg.a(this.this$0).switchFilterOn(111, this.ajk);
      if (this.ajk) {
        awwg.a(this.this$0).setBeautyOrTransformLevel(BeautyRealConfig.TYPE.COLOR_TONE, 0);
      }
    }
    else
    {
      return;
    }
    awwg.a(this.this$0).setBeautyOrTransformLevel(BeautyRealConfig.TYPE.COLOR_TONE, 50);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.filter.AEFilterProcessTex.2
 * JD-Core Version:    0.7.0.1
 */