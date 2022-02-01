package dov.com.qq.im.ae;

import android.widget.ImageView;
import awtq;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;

public class AEPituCameraUnit$23
  implements Runnable
{
  public AEPituCameraUnit$23(awtq paramawtq) {}
  
  public void run()
  {
    awtq.a(this.this$0).setVisibility(8);
    if (awtq.a(this.this$0).getDrawable() != null)
    {
      LazyLoadAnimationDrawable localLazyLoadAnimationDrawable = (LazyLoadAnimationDrawable)awtq.a(this.this$0).getDrawable();
      localLazyLoadAnimationDrawable.stop();
      localLazyLoadAnimationDrawable.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.23
 * JD-Core Version:    0.7.0.1
 */