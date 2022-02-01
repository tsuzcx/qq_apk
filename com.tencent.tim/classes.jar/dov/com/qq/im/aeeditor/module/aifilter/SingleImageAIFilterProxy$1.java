package dov.com.qq.im.aeeditor.module.aifilter;

import android.content.Context;
import axkj;
import axkj.a;
import axkr;
import java.util.List;

public class SingleImageAIFilterProxy$1
  implements Runnable
{
  public SingleImageAIFilterProxy$1(axkr paramaxkr, List paramList, Context paramContext, axkj.a parama) {}
  
  public void run()
  {
    this.this$0.mPickUpBitmapList = axkj.n(this.val$imagePaths, axkr.a(this.this$0));
    this.this$0.a(this.val$context, this.this$0.mPickUpBitmapList, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.aifilter.SingleImageAIFilterProxy.1
 * JD-Core Version:    0.7.0.1
 */