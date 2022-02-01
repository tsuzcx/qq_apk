import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.View;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class zij
  extends ziu<zih, zih>
{
  public final String a;
  public final WeakReference<yuy> a;
  private boolean a;
  
  public zij(yuy paramyuy, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramyuy);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public zij(yuy paramyuy, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramyuy);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private Bitmap a(zih paramzih, Bitmap paramBitmap)
  {
    try
    {
      paramzih = paramzih.a();
      yuk.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view = %s", paramzih);
      if (paramzih == null)
      {
        yuk.e("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view has been recycled.");
        return null;
      }
      paramBitmap = Bitmap.createBitmap(paramBitmap);
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      float f3 = paramzih.getWidth();
      float f4 = paramzih.getHeight();
      Canvas localCanvas = new Canvas(paramBitmap);
      localCanvas.scale(f1 / f3, f2 / f4);
      paramzih.draw(localCanvas);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramzih)
    {
      yuk.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "create filterBitmap error : %s", paramzih);
    }
    return null;
  }
  
  protected void a(JobContext paramJobContext, zih paramzih)
  {
    long l = SystemClock.uptimeMillis();
    paramJobContext = this.jdField_a_of_type_JavaLangString;
    if (paramJobContext == null) {
      paramJobContext = zix.a(paramzih.jdField_a_of_type_Int, paramzih.b, ".png");
    }
    for (;;)
    {
      Object localObject = (yuy)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && (!((yuy)localObject).b()))
      {
        localObject = ((yuy)localObject).a();
        if (localObject != null)
        {
          paramzih.jdField_a_of_type_Zil.b = ((Bitmap)localObject);
          paramzih.jdField_a_of_type_Boolean = true;
          Bitmap localBitmap = a(paramzih, (Bitmap)localObject);
          if (localBitmap == null) {
            break label234;
          }
          yuk.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap success %s", Integer.valueOf(System.identityHashCode(localBitmap)));
          localObject = localBitmap;
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          boolean bool = zoc.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
          paramzih.jdField_a_of_type_Boolean = bool;
          paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
          if (!bool) {
            yuk.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "Save doodle bitmap to " + paramJobContext + " failed! error code = " + bool);
          }
        }
        yuk.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "GenerateEditPicDoodleSegment" + paramzih.jdField_a_of_type_Boolean + " cost " + (SystemClock.uptimeMillis() - l));
        super.notifyResult(paramzih);
        return;
        label234:
        yuk.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zij
 * JD-Core Version:    0.7.0.1
 */