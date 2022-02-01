import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.View;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class yyc
  extends yyn<yya, yya>
{
  public final String a;
  public final WeakReference<ylc> a;
  private boolean a;
  
  public yyc(ylc paramylc, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramylc);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public yyc(ylc paramylc, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramylc);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private Bitmap a(yya paramyya, Bitmap paramBitmap)
  {
    try
    {
      paramyya = paramyya.a();
      ykq.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view = %s", paramyya);
      if (paramyya == null)
      {
        ykq.e("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view has been recycled.");
        return null;
      }
      paramBitmap = Bitmap.createBitmap(paramBitmap);
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      float f3 = paramyya.getWidth();
      float f4 = paramyya.getHeight();
      Canvas localCanvas = new Canvas(paramBitmap);
      localCanvas.scale(f1 / f3, f2 / f4);
      paramyya.draw(localCanvas);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramyya)
    {
      ykq.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "create filterBitmap error : %s", paramyya);
    }
    return null;
  }
  
  protected void a(JobContext paramJobContext, yya paramyya)
  {
    long l = SystemClock.uptimeMillis();
    paramJobContext = this.jdField_a_of_type_JavaLangString;
    if (paramJobContext == null) {
      paramJobContext = yyq.a(paramyya.jdField_a_of_type_Int, paramyya.b, ".png");
    }
    for (;;)
    {
      Object localObject = (ylc)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && (!((ylc)localObject).b()))
      {
        localObject = ((ylc)localObject).a();
        if (localObject != null)
        {
          paramyya.jdField_a_of_type_Yye.b = ((Bitmap)localObject);
          paramyya.jdField_a_of_type_Boolean = true;
          Bitmap localBitmap = a(paramyya, (Bitmap)localObject);
          if (localBitmap == null) {
            break label234;
          }
          ykq.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap success %s", Integer.valueOf(System.identityHashCode(localBitmap)));
          localObject = localBitmap;
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          boolean bool = zdr.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
          paramyya.jdField_a_of_type_Boolean = bool;
          paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
          if (!bool) {
            ykq.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "Save doodle bitmap to " + paramJobContext + " failed! error code = " + bool);
          }
        }
        ykq.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "GenerateEditPicDoodleSegment" + paramyya.jdField_a_of_type_Boolean + " cost " + (SystemClock.uptimeMillis() - l));
        super.notifyResult(paramyya);
        return;
        label234:
        ykq.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yyc
 * JD-Core Version:    0.7.0.1
 */