package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import android.widget.ImageView;
import ayiz;
import ram;

public class LocalVideoSelectActivity$5$1
  implements Runnable
{
  public LocalVideoSelectActivity$5$1(ayiz paramayiz, Bitmap paramBitmap) {}
  
  public void run()
  {
    ram.b("Q.qqstory.publish.edit.LocalVideoSelectActivity", "load cover completed and havePlaying=%s", Boolean.valueOf(LocalVideoSelectActivity.c(this.a.this$0)));
    if (!LocalVideoSelectActivity.c(this.a.this$0))
    {
      LocalVideoSelectActivity.a(this.a.this$0).setImageBitmap(this.val$bitmap);
      LocalVideoSelectActivity.a(this.a.this$0).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity.5.1
 * JD-Core Version:    0.7.0.1
 */