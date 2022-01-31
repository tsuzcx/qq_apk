import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.View;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class xld
  extends xlo<xlb, xlb>
{
  public final String a;
  public final WeakReference<wxs> a;
  private boolean a;
  
  public xld(wxs paramwxs, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramwxs);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public xld(wxs paramwxs, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramwxs);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private Bitmap a(xlb paramxlb, Bitmap paramBitmap)
  {
    try
    {
      paramxlb = paramxlb.a();
      wxe.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view = %s", paramxlb);
      if (paramxlb == null)
      {
        wxe.e("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view has been recycled.");
        return null;
      }
      paramBitmap = Bitmap.createBitmap(paramBitmap);
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      float f3 = paramxlb.getWidth();
      float f4 = paramxlb.getHeight();
      Canvas localCanvas = new Canvas(paramBitmap);
      localCanvas.scale(f1 / f3, f2 / f4);
      paramxlb.draw(localCanvas);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramxlb)
    {
      wxe.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "create filterBitmap error : %s", paramxlb);
    }
    return null;
  }
  
  protected void a(JobContext paramJobContext, xlb paramxlb)
  {
    long l = SystemClock.uptimeMillis();
    paramJobContext = this.jdField_a_of_type_JavaLangString;
    if (paramJobContext == null) {
      paramJobContext = xlr.a(paramxlb.jdField_a_of_type_Int, paramxlb.b, ".png");
    }
    for (;;)
    {
      Object localObject = (wxs)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && (!((wxs)localObject).b()))
      {
        localObject = ((wxs)localObject).a();
        if (localObject != null)
        {
          paramxlb.jdField_a_of_type_Xlf.b = ((Bitmap)localObject);
          paramxlb.jdField_a_of_type_Boolean = true;
          Bitmap localBitmap = a(paramxlb, (Bitmap)localObject);
          if (localBitmap == null) {
            break label234;
          }
          wxe.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap success %s", Integer.valueOf(System.identityHashCode(localBitmap)));
          localObject = localBitmap;
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          boolean bool = xqw.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
          paramxlb.jdField_a_of_type_Boolean = bool;
          paramxlb.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
          if (!bool) {
            wxe.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "Save doodle bitmap to " + paramJobContext + " failed! error code = " + bool);
          }
        }
        wxe.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "GenerateEditPicDoodleSegment" + paramxlb.jdField_a_of_type_Boolean + " cost " + (SystemClock.uptimeMillis() - l));
        super.notifyResult(paramxlb);
        return;
        label234:
        wxe.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xld
 * JD-Core Version:    0.7.0.1
 */