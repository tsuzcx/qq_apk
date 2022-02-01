import android.graphics.Bitmap;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class ayji
  extends JobSegment<Bitmap, Bitmap>
{
  public final boolean aHz;
  public final float mScaleFactor;
  
  public ayji(float paramFloat, boolean paramBoolean)
  {
    this.mScaleFactor = paramFloat;
    this.aHz = paramBoolean;
  }
  
  protected void a(JobContext paramJobContext, Bitmap paramBitmap)
  {
    paramJobContext = rop.b(paramBitmap, this.mScaleFactor, this.aHz);
    if (paramJobContext == null)
    {
      super.notifyError(new BitmapError("Q.qqstory.publish:ImageAdjustJobSegment", 5));
      return;
    }
    super.notifyResult(paramJobContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayji
 * JD-Core Version:    0.7.0.1
 */