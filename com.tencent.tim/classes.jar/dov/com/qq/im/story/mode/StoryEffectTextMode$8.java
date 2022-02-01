package dov.com.qq.im.story.mode;

import android.app.Activity;
import arib;
import awrq;
import aycm;
import dov.com.qq.im.capture.mode.CaptureModeController;

public class StoryEffectTextMode$8
  implements Runnable
{
  public StoryEffectTextMode$8(aycm paramaycm, arib paramarib) {}
  
  public void run()
  {
    if ((aycm.b(this.this$0)) || (aycm.a(this.this$0).getActivity().isFinishing())) {
      return;
    }
    if (this.c.isShowing()) {
      this.c.dismiss();
    }
    aycm.b(this.this$0, true);
    aycm.c(this.this$0).coB();
    aycm.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.story.mode.StoryEffectTextMode.8
 * JD-Core Version:    0.7.0.1
 */