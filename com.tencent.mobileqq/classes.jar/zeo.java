import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.View;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class zeo
  extends zez<zem, zem>
{
  public final String a;
  public final WeakReference<yrd> a;
  private boolean a;
  
  public zeo(yrd paramyrd, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramyrd);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public zeo(yrd paramyrd, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramyrd);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private Bitmap a(zem paramzem, Bitmap paramBitmap)
  {
    try
    {
      paramzem = paramzem.a();
      yqp.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view = %s", paramzem);
      if (paramzem == null)
      {
        yqp.e("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view has been recycled.");
        return null;
      }
      paramBitmap = Bitmap.createBitmap(paramBitmap);
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      float f3 = paramzem.getWidth();
      float f4 = paramzem.getHeight();
      Canvas localCanvas = new Canvas(paramBitmap);
      localCanvas.scale(f1 / f3, f2 / f4);
      paramzem.draw(localCanvas);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramzem)
    {
      yqp.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "create filterBitmap error : %s", paramzem);
    }
    return null;
  }
  
  protected void a(JobContext paramJobContext, zem paramzem)
  {
    long l = SystemClock.uptimeMillis();
    paramJobContext = this.jdField_a_of_type_JavaLangString;
    if (paramJobContext == null) {
      paramJobContext = zfc.a(paramzem.jdField_a_of_type_Int, paramzem.b, ".png");
    }
    for (;;)
    {
      Object localObject = (yrd)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && (!((yrd)localObject).b()))
      {
        localObject = ((yrd)localObject).a();
        if (localObject != null)
        {
          paramzem.jdField_a_of_type_Zeq.b = ((Bitmap)localObject);
          paramzem.jdField_a_of_type_Boolean = true;
          Bitmap localBitmap = a(paramzem, (Bitmap)localObject);
          if (localBitmap == null) {
            break label234;
          }
          yqp.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap success %s", Integer.valueOf(System.identityHashCode(localBitmap)));
          localObject = localBitmap;
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          boolean bool = zkh.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
          paramzem.jdField_a_of_type_Boolean = bool;
          paramzem.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
          if (!bool) {
            yqp.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "Save doodle bitmap to " + paramJobContext + " failed! error code = " + bool);
          }
        }
        yqp.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "GenerateEditPicDoodleSegment" + paramzem.jdField_a_of_type_Boolean + " cost " + (SystemClock.uptimeMillis() - l));
        super.notifyResult(paramzem);
        return;
        label234:
        yqp.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zeo
 * JD-Core Version:    0.7.0.1
 */