import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.av.VideoController;

public class ihi
  extends OrientationEventListener
{
  private long lastTime;
  
  public ihi(VideoController paramVideoController, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if (paramInt == -1) {}
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
    } while (l - this.lastTime < 50L);
    this.lastTime = l;
    if ((paramInt > 315) || (paramInt <= 45))
    {
      VideoController.a(this.this$0, 1);
      return;
    }
    if ((paramInt > 45) && (paramInt <= 135))
    {
      VideoController.a(this.this$0, 2);
      return;
    }
    if ((paramInt > 135) && (paramInt <= 225))
    {
      VideoController.a(this.this$0, 3);
      return;
    }
    VideoController.a(this.this$0, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ihi
 * JD-Core Version:    0.7.0.1
 */