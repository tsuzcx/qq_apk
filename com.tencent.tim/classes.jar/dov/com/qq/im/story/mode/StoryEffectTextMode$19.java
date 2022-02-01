package dov.com.qq.im.story.mode;

import android.os.Handler;
import aycm;
import com.tencent.mobileqq.app.ThreadManagerV2;

public class StoryEffectTextMode$19
  implements Runnable
{
  public StoryEffectTextMode$19(aycm paramaycm) {}
  
  public void run()
  {
    if (aycm.e(this.this$0) != 0) {
      aycm.a(this.this$0, aycm.a(this.this$0), aycm.a(this.this$0), aycm.c(this.this$0), aycm.d(this.this$0), aycm.e(this.this$0), null);
    }
    if (aycm.c(this.this$0))
    {
      aycm.d(this.this$0, false);
      ThreadManagerV2.getUIHandlerV2().postDelayed(new StoryEffectTextMode.19.1(this), 600L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.story.mode.StoryEffectTextMode.19
 * JD-Core Version:    0.7.0.1
 */