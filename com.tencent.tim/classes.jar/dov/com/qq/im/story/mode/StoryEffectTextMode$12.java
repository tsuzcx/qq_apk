package dov.com.qq.im.story.mode;

import android.os.Handler;
import aycm;
import com.tencent.mobileqq.app.ThreadManagerV2;
import org.json.JSONObject;
import ram;

public class StoryEffectTextMode$12
  implements Runnable
{
  public StoryEffectTextMode$12(aycm paramaycm, JSONObject paramJSONObject) {}
  
  public void run()
  {
    boolean bool = aycm.a(this.this$0, "qg_InitConfig", this.val$jsonObject.toString());
    aycm.c(this.this$0, false);
    aycm.a(this.this$0, aycm.a(this.this$0), aycm.a(this.this$0), aycm.c(this.this$0), aycm.d(this.this$0), 27, null);
    if (bool)
    {
      if (aycm.c(this.this$0))
      {
        aycm.d(this.this$0, false);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new StoryEffectTextMode.12.1(this), 600L);
      }
      return;
    }
    aycm.b(this.this$0, 27);
    ram.d("StoryEffectTextMode", "这里没有注册EVENT_NAME_QG_INIT_CONFIG");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.story.mode.StoryEffectTextMode.12
 * JD-Core Version:    0.7.0.1
 */