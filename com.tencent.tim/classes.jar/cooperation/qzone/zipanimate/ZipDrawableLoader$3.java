package cooperation.qzone.zipanimate;

import android.graphics.drawable.BitmapDrawable;
import awin;
import awin.b;
import awip;
import awiq;
import java.util.concurrent.CopyOnWriteArrayList;

public class ZipDrawableLoader$3
  implements Runnable
{
  public ZipDrawableLoader$3(awin paramawin, int paramInt, awiq paramawiq) {}
  
  public void run()
  {
    int j = this.val$frameIndex;
    int i = j;
    if (j < awin.a(this.this$0)) {
      i = j + awin.a(this.this$0).size();
    }
    if (i - awin.a(this.this$0) > awin.b(this.this$0)) {}
    while (this.val$frameIndex >= awin.a(this.this$0).size()) {
      return;
    }
    awin.b localb = null;
    for (;;)
    {
      synchronized (this.this$0)
      {
        if (this.val$frameIndex < awin.a(this.this$0).size()) {
          localb = (awin.b)awin.a(this.this$0).get(this.val$frameIndex);
        }
        if (localb == null) {
          break;
        }
        if (localb.k == null)
        {
          ??? = awin.a(this.this$0, localb.path);
          if (??? != null)
          {
            j = ((BitmapDrawable)???).getIntrinsicWidth();
            i = ((BitmapDrawable)???).getIntrinsicHeight();
            j = (int)(j * awin.a(this.this$0));
            i = (int)(i * awin.a(this.this$0));
            if (awin.a(this.this$0) == null) {
              break label285;
            }
            ((BitmapDrawable)???).setBounds(awin.a(this.this$0));
            localb.k = ((BitmapDrawable)???);
          }
        }
        if (!this.this$0.dqq)
        {
          this.this$0.dqq = true;
          if (awin.a(this.this$0) != null) {
            awin.a(this.this$0).al(localb.k);
          }
        }
        if (this.c == null) {
          break;
        }
        this.c.b(this.val$frameIndex, localb.k);
        return;
      }
      label285:
      ((BitmapDrawable)???).setBounds(0, 0, j, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.zipanimate.ZipDrawableLoader.3
 * JD-Core Version:    0.7.0.1
 */