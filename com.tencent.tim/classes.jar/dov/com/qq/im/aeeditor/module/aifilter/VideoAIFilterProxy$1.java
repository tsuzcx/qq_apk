package dov.com.qq.im.aeeditor.module.aifilter;

import android.content.Context;
import axiy;
import axkj.a;
import axkt;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.util.Logger;
import java.util.List;

public class VideoAIFilterProxy$1
  implements Runnable
{
  public VideoAIFilterProxy$1(axkt paramaxkt, List paramList, Context paramContext, axkj.a parama) {}
  
  public void run()
  {
    if (axkt.a(this.this$0) != null)
    {
      axiy.d(axkt.access$100(), "getVideoFrame start");
      this.this$0.mPickUpBitmapList = axkt.a(this.this$0).getVideoFrame(this.MU, 250);
      axiy.d(axkt.access$100(), "getVideoFrame end");
      Logger.i("Cover", "get covers num =" + this.this$0.mPickUpBitmapList.size());
      this.this$0.eFO = this.this$0.mPickUpBitmapList.size();
      this.this$0.a(this.val$context, this.this$0.mPickUpBitmapList, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.aifilter.VideoAIFilterProxy.1
 * JD-Core Version:    0.7.0.1
 */