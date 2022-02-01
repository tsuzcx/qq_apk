import android.graphics.Bitmap;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class zai
  extends JobSegment<Bitmap, Bitmap>
{
  public int a;
  
  public zai()
  {
    this.a = 10;
  }
  
  public zai(int paramInt)
  {
    this.a = paramInt;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    if (paramBitmap == null) {
      return null;
    }
    bhsp.a(paramBitmap, paramInt);
    return paramBitmap;
  }
  
  protected void a(JobContext paramJobContext, Bitmap paramBitmap)
  {
    long l = System.currentTimeMillis();
    paramJobContext = a(paramBitmap, this.a, false);
    yuk.b("BlurJobSegment", "blur time = " + (System.currentTimeMillis() - l) + ", blur ratio = " + this.a);
    if (paramJobContext == null)
    {
      super.notifyError(new BitmapError("BlurJobSegment", 7));
      return;
    }
    super.notifyResult(paramJobContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zai
 * JD-Core Version:    0.7.0.1
 */