import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.View;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class ayqe
  extends ayqr<ayqb, ayqb>
{
  public final String aAW;
  private boolean aIE;
  public final WeakReference<aydg> dj;
  
  public ayqe(aydg paramaydg, String paramString)
  {
    this.dj = new WeakReference(paramaydg);
    this.aAW = paramString;
    this.aIE = false;
  }
  
  public ayqe(aydg paramaydg, String paramString, boolean paramBoolean)
  {
    this.dj = new WeakReference(paramaydg);
    this.aAW = paramString;
    this.aIE = paramBoolean;
  }
  
  private Bitmap a(ayqb paramayqb, Bitmap paramBitmap)
  {
    try
    {
      paramayqb = paramayqb.ay();
      ram.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view = %s", paramayqb);
      if (paramayqb == null)
      {
        ram.e("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view has been recycled.");
        return paramBitmap;
      }
      paramBitmap = Bitmap.createBitmap(paramBitmap);
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      float f3 = paramayqb.getWidth();
      float f4 = paramayqb.getHeight();
      Canvas localCanvas = new Canvas(paramBitmap);
      localCanvas.scale(f1 / f3, f2 / f4);
      paramayqb.draw(localCanvas);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramayqb)
    {
      ram.e("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "create filterBitmap error : %s", paramayqb);
    }
    return null;
  }
  
  protected void a(JobContext paramJobContext, ayqb paramayqb)
  {
    long l = SystemClock.uptimeMillis();
    paramJobContext = this.aAW;
    if (paramJobContext == null) {
      paramJobContext = ayqu.f(paramayqb.businessId, paramayqb.aAU, ".png");
    }
    for (;;)
    {
      Object localObject = (aydg)this.dj.get();
      if ((localObject != null) && (!((aydg)localObject).isEmpty()))
      {
        localObject = ((aydg)localObject).U();
        if (localObject != null)
        {
          paramayqb.a.doodleBitmap = ((Bitmap)localObject);
          paramayqb.aIA = true;
          Bitmap localBitmap = a(paramayqb, (Bitmap)localObject);
          if (localBitmap == null) {
            break label234;
          }
          ram.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap success %s", Integer.valueOf(System.identityHashCode(localBitmap)));
          localObject = localBitmap;
        }
      }
      for (;;)
      {
        if (this.aIE)
        {
          boolean bool = rop.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
          paramayqb.aIA = bool;
          paramayqb.g.doodlePath = paramJobContext;
          if (!bool) {
            ram.w("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "Save doodle bitmap to " + paramJobContext + " failed! error code = " + bool);
          }
        }
        ram.w("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "GenerateEditPicDoodleSegment" + paramayqb.aIA + " cost " + (SystemClock.uptimeMillis() - l));
        super.notifyResult(paramayqb);
        return;
        label234:
        ram.w("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayqe
 * JD-Core Version:    0.7.0.1
 */