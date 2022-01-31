import android.graphics.Bitmap;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class wyt
  extends JobSegment<Bitmap, Bitmap>
{
  public int a;
  
  public wyt()
  {
    this.a = 10;
  }
  
  public wyt(int paramInt)
  {
    this.a = paramInt;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    if (paramBitmap == null) {
      return null;
    }
    bdjc.a(paramBitmap, paramInt);
    return paramBitmap;
  }
  
  protected void a(JobContext paramJobContext, Bitmap paramBitmap)
  {
    long l = System.currentTimeMillis();
    paramJobContext = a(paramBitmap, this.a, false);
    wsv.b("BlurJobSegment", "blur time = " + (System.currentTimeMillis() - l) + ", blur ratio = " + this.a);
    if (paramJobContext == null)
    {
      super.notifyError(new BitmapError("BlurJobSegment", 7));
      return;
    }
    super.notifyResult(paramJobContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wyt
 * JD-Core Version:    0.7.0.1
 */