package cooperation.qzone.zipanimate;

import awij;
import awij.a;
import awij.b;
import awim;

public class ZipAnimationDrawable$ZipAnimationState$1$1
  implements Runnable
{
  public ZipAnimationDrawable$ZipAnimationState$1$1(awim paramawim) {}
  
  public void run()
  {
    if (this.a.b.o.b != null) {
      this.a.b.o.b.onDrawableLoaded();
    }
    if (awij.a(this.a.b.o)) {
      this.a.b.o.restartAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.zipanimate.ZipAnimationDrawable.ZipAnimationState.1.1
 * JD-Core Version:    0.7.0.1
 */