package dov.com.qq.im.ae;

import android.os.Handler;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import awtq;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;

public class AEPituCameraUnit$22
  implements Runnable
{
  public AEPituCameraUnit$22(awtq paramawtq, LazyLoadAnimationDrawable paramLazyLoadAnimationDrawable) {}
  
  public void run()
  {
    if (awtq.a(this.this$0) == null)
    {
      ViewStub localViewStub = (ViewStub)awtq.b(this.this$0).findViewById(2131378865);
      awtq.a(this.this$0, (ImageView)localViewStub.inflate().findViewById(2131362724));
    }
    awtq.a(this.this$0).postDelayed(awtq.a(this.this$0), this.a.getTotalDuration());
    awtq.a(this.this$0).setVisibility(0);
    awtq.a(this.this$0).setImageDrawable(this.a);
    this.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.22
 * JD-Core Version:    0.7.0.1
 */