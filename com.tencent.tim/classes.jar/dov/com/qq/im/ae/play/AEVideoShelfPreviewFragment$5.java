package dov.com.qq.im.ae.play;

import android.text.TextUtils;
import axcg;
import axiy;
import ayja;
import com.tencent.ttpic.videoshelf.model.VideoShelfEngine;
import java.io.File;
import java.util.Timer;

class AEVideoShelfPreviewFragment$5
  implements Runnable
{
  AEVideoShelfPreviewFragment$5(AEVideoShelfPreviewFragment paramAEVideoShelfPreviewFragment, long paramLong) {}
  
  public void run()
  {
    if (AEVideoShelfPreviewFragment.a(this.this$0))
    {
      Object localObject = AEVideoShelfPreviewFragment.a(this.this$0).getOutputVideoPath();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        File localFile = new File((String)localObject);
        if (localFile.exists())
        {
          localFile.delete();
          axiy.i(AEVideoShelfPreviewFragment.access$200(), "onCompletion---delete temp silent file because user cancel generation: " + (String)localObject);
        }
      }
      if (!TextUtils.isEmpty(AEVideoShelfPreviewFragment.a(this.this$0)))
      {
        localObject = new File(AEVideoShelfPreviewFragment.a(this.this$0));
        if (((File)localObject).exists())
        {
          ((File)localObject).delete();
          axiy.i(AEVideoShelfPreviewFragment.access$200(), "onCompletion---delete final file because user cancel generation: " + AEVideoShelfPreviewFragment.a(this.this$0));
        }
      }
      AEVideoShelfPreviewFragment.b(this.this$0, false);
      return;
    }
    if ((int)AEVideoShelfPreviewFragment.a(this.this$0) < 100)
    {
      AEVideoShelfPreviewFragment.a(this.this$0, 100);
      new Timer().schedule(new AEVideoShelfPreviewFragment.5.1(this), 0L);
    }
    for (;;)
    {
      AEVideoShelfPreviewFragment.a(this.this$0, 0.0D);
      AEVideoShelfPreviewFragment.b(this.this$0, 0.0D);
      if (AEVideoShelfPreviewFragment.b(this.this$0))
      {
        AEVideoShelfPreviewFragment.c(this.this$0, false);
        AEVideoShelfPreviewFragment.ad(this.this$0.getActivity(), false);
      }
      ayja.a(this.this$0.getActivity(), AEVideoShelfPreviewFragment.a(this.this$0), this.this$0.getThumbPath(), axcg.G(this.this$0.getActivity()), "caller_aecamera");
      return;
      AEVideoShelfPreviewFragment.b(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEVideoShelfPreviewFragment.5
 * JD-Core Version:    0.7.0.1
 */