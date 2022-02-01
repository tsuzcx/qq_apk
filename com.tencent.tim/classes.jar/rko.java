import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.View;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class rko
  extends rkz<rkm, rkm>
{
  public final String aAW;
  private boolean aIE;
  public final WeakReference<rba> dj;
  
  public rko(rba paramrba, String paramString)
  {
    this.dj = new WeakReference(paramrba);
    this.aAW = paramString;
    this.aIE = false;
  }
  
  public rko(rba paramrba, String paramString, boolean paramBoolean)
  {
    this.dj = new WeakReference(paramrba);
    this.aAW = paramString;
    this.aIE = paramBoolean;
  }
  
  private Bitmap a(rkm paramrkm, Bitmap paramBitmap)
  {
    try
    {
      paramrkm = paramrkm.ay();
      ram.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view = %s", paramrkm);
      if (paramrkm == null)
      {
        ram.e("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view has been recycled.");
        return null;
      }
      paramBitmap = Bitmap.createBitmap(paramBitmap);
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      float f3 = paramrkm.getWidth();
      float f4 = paramrkm.getHeight();
      Canvas localCanvas = new Canvas(paramBitmap);
      localCanvas.scale(f1 / f3, f2 / f4);
      paramrkm.draw(localCanvas);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramrkm)
    {
      ram.e("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "create filterBitmap error : %s", paramrkm);
    }
    return null;
  }
  
  protected void a(JobContext paramJobContext, rkm paramrkm)
  {
    long l = SystemClock.uptimeMillis();
    paramJobContext = this.aAW;
    if (paramJobContext == null) {
      paramJobContext = rlc.f(paramrkm.businessId, paramrkm.aAU, ".png");
    }
    for (;;)
    {
      Object localObject = (rba)this.dj.get();
      if ((localObject != null) && (!((rba)localObject).isEmpty()))
      {
        localObject = ((rba)localObject).U();
        if (localObject != null)
        {
          paramrkm.a.doodleBitmap = ((Bitmap)localObject);
          paramrkm.aIA = true;
          Bitmap localBitmap = a(paramrkm, (Bitmap)localObject);
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
          paramrkm.aIA = bool;
          paramrkm.g.doodlePath = paramJobContext;
          if (!bool) {
            ram.w("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "Save doodle bitmap to " + paramJobContext + " failed! error code = " + bool);
          }
        }
        ram.w("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "GenerateEditPicDoodleSegment" + paramrkm.aIA + " cost " + (SystemClock.uptimeMillis() - l));
        super.notifyResult(paramrkm);
        return;
        label234:
        ram.w("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rko
 * JD-Core Version:    0.7.0.1
 */