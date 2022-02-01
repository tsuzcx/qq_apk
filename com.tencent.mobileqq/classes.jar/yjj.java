import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.View;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class yjj
  extends yju<yjh, yjh>
{
  public final String a;
  public final WeakReference<xwj> a;
  private boolean a;
  
  public yjj(xwj paramxwj, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramxwj);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public yjj(xwj paramxwj, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramxwj);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private Bitmap a(yjh paramyjh, Bitmap paramBitmap)
  {
    try
    {
      paramyjh = paramyjh.a();
      xvv.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view = %s", paramyjh);
      if (paramyjh == null)
      {
        xvv.e("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view has been recycled.");
        return null;
      }
      paramBitmap = Bitmap.createBitmap(paramBitmap);
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      float f3 = paramyjh.getWidth();
      float f4 = paramyjh.getHeight();
      Canvas localCanvas = new Canvas(paramBitmap);
      localCanvas.scale(f1 / f3, f2 / f4);
      paramyjh.draw(localCanvas);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramyjh)
    {
      xvv.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "create filterBitmap error : %s", paramyjh);
    }
    return null;
  }
  
  protected void a(JobContext paramJobContext, yjh paramyjh)
  {
    long l = SystemClock.uptimeMillis();
    paramJobContext = this.jdField_a_of_type_JavaLangString;
    if (paramJobContext == null) {
      paramJobContext = yjx.a(paramyjh.jdField_a_of_type_Int, paramyjh.b, ".png");
    }
    for (;;)
    {
      Object localObject = (xwj)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && (!((xwj)localObject).b()))
      {
        localObject = ((xwj)localObject).a();
        if (localObject != null)
        {
          paramyjh.jdField_a_of_type_Yjl.b = ((Bitmap)localObject);
          paramyjh.jdField_a_of_type_Boolean = true;
          Bitmap localBitmap = a(paramyjh, (Bitmap)localObject);
          if (localBitmap == null) {
            break label234;
          }
          xvv.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap success %s", Integer.valueOf(System.identityHashCode(localBitmap)));
          localObject = localBitmap;
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          boolean bool = yoy.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
          paramyjh.jdField_a_of_type_Boolean = bool;
          paramyjh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
          if (!bool) {
            xvv.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "Save doodle bitmap to " + paramJobContext + " failed! error code = " + bool);
          }
        }
        xvv.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "GenerateEditPicDoodleSegment" + paramyjh.jdField_a_of_type_Boolean + " cost " + (SystemClock.uptimeMillis() - l));
        super.notifyResult(paramyjh);
        return;
        label234:
        xvv.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjj
 * JD-Core Version:    0.7.0.1
 */