import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.View;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class xgu
  extends xhf<xgs, xgs>
{
  public final String a;
  public final WeakReference<wtj> a;
  private boolean a;
  
  public xgu(wtj paramwtj, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramwtj);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public xgu(wtj paramwtj, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramwtj);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private Bitmap a(xgs paramxgs, Bitmap paramBitmap)
  {
    try
    {
      paramxgs = paramxgs.a();
      wsv.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view = %s", paramxgs);
      if (paramxgs == null)
      {
        wsv.e("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view has been recycled.");
        return null;
      }
      paramBitmap = Bitmap.createBitmap(paramBitmap);
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      float f3 = paramxgs.getWidth();
      float f4 = paramxgs.getHeight();
      Canvas localCanvas = new Canvas(paramBitmap);
      localCanvas.scale(f1 / f3, f2 / f4);
      paramxgs.draw(localCanvas);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramxgs)
    {
      wsv.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "create filterBitmap error : %s", paramxgs);
    }
    return null;
  }
  
  protected void a(JobContext paramJobContext, xgs paramxgs)
  {
    long l = SystemClock.uptimeMillis();
    paramJobContext = this.jdField_a_of_type_JavaLangString;
    if (paramJobContext == null) {
      paramJobContext = xhi.a(paramxgs.jdField_a_of_type_Int, paramxgs.b, ".png");
    }
    for (;;)
    {
      Object localObject = (wtj)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && (!((wtj)localObject).b()))
      {
        localObject = ((wtj)localObject).a();
        if (localObject != null)
        {
          paramxgs.jdField_a_of_type_Xgw.b = ((Bitmap)localObject);
          paramxgs.jdField_a_of_type_Boolean = true;
          Bitmap localBitmap = a(paramxgs, (Bitmap)localObject);
          if (localBitmap == null) {
            break label234;
          }
          wsv.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap success %s", Integer.valueOf(System.identityHashCode(localBitmap)));
          localObject = localBitmap;
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          boolean bool = xmn.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
          paramxgs.jdField_a_of_type_Boolean = bool;
          paramxgs.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
          if (!bool) {
            wsv.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "Save doodle bitmap to " + paramJobContext + " failed! error code = " + bool);
          }
        }
        wsv.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "GenerateEditPicDoodleSegment" + paramxgs.jdField_a_of_type_Boolean + " cost " + (SystemClock.uptimeMillis() - l));
        super.notifyResult(paramxgs);
        return;
        label234:
        wsv.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xgu
 * JD-Core Version:    0.7.0.1
 */