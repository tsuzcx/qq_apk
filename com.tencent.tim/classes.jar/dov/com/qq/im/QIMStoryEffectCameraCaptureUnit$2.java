package dov.com.qq.im;

import acfp;
import awsy;
import dov.com.qq.im.capture.view.StoryImageToastView;
import dov.com.qq.im.capture.view.StoryTextToastView;
import java.util.List;

public class QIMStoryEffectCameraCaptureUnit$2
  implements Runnable
{
  public QIMStoryEffectCameraCaptureUnit$2(awsy paramawsy, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if ((this.drB) && (!this.dsp)) {
      awsy.a(this.this$0).b(String.format("%02d", new Object[] { Integer.valueOf(this.this$0.LX.size() + 1) })).a(acfp.m(2131711257)).show();
    }
    this.this$0.a.hide();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.QIMStoryEffectCameraCaptureUnit.2
 * JD-Core Version:    0.7.0.1
 */