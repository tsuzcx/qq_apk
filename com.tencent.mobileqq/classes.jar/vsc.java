import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.View;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class vsc
  extends vsn<vsa, vsa>
{
  public final String a;
  public final WeakReference<ver> a;
  private boolean a;
  
  public vsc(ver paramver, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramver);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public vsc(ver paramver, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramver);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private Bitmap a(vsa paramvsa, Bitmap paramBitmap)
  {
    try
    {
      paramvsa = paramvsa.a();
      ved.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view = %s", paramvsa);
      if (paramvsa == null)
      {
        ved.e("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view has been recycled.");
        return null;
      }
      paramBitmap = Bitmap.createBitmap(paramBitmap);
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      float f3 = paramvsa.getWidth();
      float f4 = paramvsa.getHeight();
      Canvas localCanvas = new Canvas(paramBitmap);
      localCanvas.scale(f1 / f3, f2 / f4);
      paramvsa.draw(localCanvas);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramvsa)
    {
      ved.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "create filterBitmap error : %s", paramvsa);
    }
    return null;
  }
  
  protected void a(JobContext paramJobContext, vsa paramvsa)
  {
    long l = SystemClock.uptimeMillis();
    paramJobContext = this.jdField_a_of_type_JavaLangString;
    if (paramJobContext == null) {
      paramJobContext = vsq.a(paramvsa.jdField_a_of_type_Int, paramvsa.b, ".png");
    }
    for (;;)
    {
      Object localObject = (ver)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && (!((ver)localObject).b()))
      {
        localObject = ((ver)localObject).a();
        if (localObject != null)
        {
          paramvsa.jdField_a_of_type_Vse.b = ((Bitmap)localObject);
          paramvsa.jdField_a_of_type_Boolean = true;
          Bitmap localBitmap = a(paramvsa, (Bitmap)localObject);
          if (localBitmap == null) {
            break label234;
          }
          ved.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap success %s", Integer.valueOf(System.identityHashCode(localBitmap)));
          localObject = localBitmap;
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          boolean bool = vxv.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
          paramvsa.jdField_a_of_type_Boolean = bool;
          paramvsa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
          if (!bool) {
            ved.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "Save doodle bitmap to " + paramJobContext + " failed! error code = " + bool);
          }
        }
        ved.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "GenerateEditPicDoodleSegment" + paramvsa.jdField_a_of_type_Boolean + " cost " + (SystemClock.uptimeMillis() - l));
        super.notifyResult(paramvsa);
        return;
        label234:
        ved.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vsc
 * JD-Core Version:    0.7.0.1
 */