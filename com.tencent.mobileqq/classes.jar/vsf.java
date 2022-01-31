import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.View;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class vsf
  extends vsq<vsd, vsd>
{
  public final String a;
  public final WeakReference<veu> a;
  private boolean a;
  
  public vsf(veu paramveu, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramveu);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public vsf(veu paramveu, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramveu);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private Bitmap a(vsd paramvsd, Bitmap paramBitmap)
  {
    try
    {
      paramvsd = paramvsd.a();
      veg.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view = %s", paramvsd);
      if (paramvsd == null)
      {
        veg.e("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view has been recycled.");
        return null;
      }
      paramBitmap = Bitmap.createBitmap(paramBitmap);
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      float f3 = paramvsd.getWidth();
      float f4 = paramvsd.getHeight();
      Canvas localCanvas = new Canvas(paramBitmap);
      localCanvas.scale(f1 / f3, f2 / f4);
      paramvsd.draw(localCanvas);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramvsd)
    {
      veg.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "create filterBitmap error : %s", paramvsd);
    }
    return null;
  }
  
  protected void a(JobContext paramJobContext, vsd paramvsd)
  {
    long l = SystemClock.uptimeMillis();
    paramJobContext = this.jdField_a_of_type_JavaLangString;
    if (paramJobContext == null) {
      paramJobContext = vst.a(paramvsd.jdField_a_of_type_Int, paramvsd.b, ".png");
    }
    for (;;)
    {
      Object localObject = (veu)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && (!((veu)localObject).b()))
      {
        localObject = ((veu)localObject).a();
        if (localObject != null)
        {
          paramvsd.jdField_a_of_type_Vsh.b = ((Bitmap)localObject);
          paramvsd.jdField_a_of_type_Boolean = true;
          Bitmap localBitmap = a(paramvsd, (Bitmap)localObject);
          if (localBitmap == null) {
            break label234;
          }
          veg.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap success %s", Integer.valueOf(System.identityHashCode(localBitmap)));
          localObject = localBitmap;
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          boolean bool = vxy.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
          paramvsd.jdField_a_of_type_Boolean = bool;
          paramvsd.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
          if (!bool) {
            veg.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "Save doodle bitmap to " + paramJobContext + " failed! error code = " + bool);
          }
        }
        veg.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "GenerateEditPicDoodleSegment" + paramvsd.jdField_a_of_type_Boolean + " cost " + (SystemClock.uptimeMillis() - l));
        super.notifyResult(paramvsd);
        return;
        label234:
        veg.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vsf
 * JD-Core Version:    0.7.0.1
 */