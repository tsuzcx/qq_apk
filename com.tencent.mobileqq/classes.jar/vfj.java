import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.View;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class vfj
  extends vfu<vfh, vfh>
{
  public final String a;
  public final WeakReference<ury> a;
  private boolean a;
  
  public vfj(ury paramury, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramury);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public vfj(ury paramury, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramury);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private Bitmap a(vfh paramvfh, Bitmap paramBitmap)
  {
    try
    {
      paramvfh = paramvfh.a();
      urk.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view = %s", paramvfh);
      if (paramvfh == null)
      {
        urk.e("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view has been recycled.");
        return null;
      }
      paramBitmap = Bitmap.createBitmap(paramBitmap);
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      float f3 = paramvfh.getWidth();
      float f4 = paramvfh.getHeight();
      Canvas localCanvas = new Canvas(paramBitmap);
      localCanvas.scale(f1 / f3, f2 / f4);
      paramvfh.draw(localCanvas);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramvfh)
    {
      urk.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "create filterBitmap error : %s", paramvfh);
    }
    return null;
  }
  
  protected void a(JobContext paramJobContext, vfh paramvfh)
  {
    long l = SystemClock.uptimeMillis();
    paramJobContext = this.jdField_a_of_type_JavaLangString;
    if (paramJobContext == null) {
      paramJobContext = vfx.a(paramvfh.jdField_a_of_type_Int, paramvfh.b, ".png");
    }
    for (;;)
    {
      Object localObject = (ury)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && (!((ury)localObject).b()))
      {
        localObject = ((ury)localObject).a();
        if (localObject != null)
        {
          paramvfh.jdField_a_of_type_Vfl.b = ((Bitmap)localObject);
          paramvfh.jdField_a_of_type_Boolean = true;
          Bitmap localBitmap = a(paramvfh, (Bitmap)localObject);
          if (localBitmap == null) {
            break label234;
          }
          urk.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap success %s", Integer.valueOf(System.identityHashCode(localBitmap)));
          localObject = localBitmap;
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          boolean bool = vlc.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
          paramvfh.jdField_a_of_type_Boolean = bool;
          paramvfh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
          if (!bool) {
            urk.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "Save doodle bitmap to " + paramJobContext + " failed! error code = " + bool);
          }
        }
        urk.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "GenerateEditPicDoodleSegment" + paramvfh.jdField_a_of_type_Boolean + " cost " + (SystemClock.uptimeMillis() - l));
        super.notifyResult(paramvfh);
        return;
        label234:
        urk.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vfj
 * JD-Core Version:    0.7.0.1
 */