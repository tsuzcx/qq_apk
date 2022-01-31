import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.async.JobContext;

public class vst
  extends vsn<vsa, vsa>
{
  protected void a(JobContext paramJobContext, vsa paramvsa)
  {
    System.currentTimeMillis();
    int i = vzl.a(BaseApplication.getContext());
    i = vzl.d(BaseApplication.getContext()) * 720 / i;
    if (i % 2 != 0) {
      i += 1;
    }
    for (;;)
    {
      Object localObject = paramvsa.jdField_a_of_type_Vse.jdField_a_of_type_JavaLangString;
      paramJobContext = (JobContext)localObject;
      if (!paramvsa.jdField_a_of_type_Vse.jdField_b_of_type_Boolean)
      {
        paramJobContext = (JobContext)localObject;
        if (paramvsa.jdField_a_of_type_Vse.jdField_a_of_type_Boolean) {
          paramJobContext = paramvsa.jdField_a_of_type_Vse.jdField_b_of_type_JavaLangString;
        }
      }
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      for (;;)
      {
        try
        {
          bbef.a(paramJobContext, (BitmapFactory.Options)localObject);
          if (((BitmapFactory.Options)localObject).outWidth * 720 == ((BitmapFactory.Options)localObject).outHeight * i)
          {
            j = 1;
            if ((!(paramvsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource)) && ((paramvsa.jdField_a_of_type_Int != 1) || (j != 0)) && (((BitmapFactory.Options)localObject).outWidth <= 720) && (((BitmapFactory.Options)localObject).outHeight <= i) && (((BitmapFactory.Options)localObject).outWidth % 2 == 0) && (((BitmapFactory.Options)localObject).outHeight % 2 == 0)) {
              break label384;
            }
            paramJobContext = paramvsa.jdField_a_of_type_Vse.jdField_a_of_type_AndroidGraphicsBitmap;
            if (paramJobContext != null) {
              break;
            }
            ved.d("Q.qqstory.publish.edit.ResizeBitmapSegment", "srcBitmap is null please check!");
            super.notifyError(new BitmapError("Q.qqstory.publish.edit.ResizeBitmapSegment", 0));
            return;
          }
        }
        catch (OutOfMemoryError paramJobContext)
        {
          ved.b("Q.qqstory.publish.edit.ResizeBitmapSegment", "decode image failed", paramJobContext);
          super.notifyError(new BitmapError("Q.qqstory.publish.edit.ResizeBitmapSegment", 6));
          return;
        }
        int j = 0;
      }
      ved.a("Q.qqstory.publish.edit.ResizeBitmapSegment", "srcBitmap width=%s, height=%s", Integer.valueOf(paramJobContext.getWidth()), Integer.valueOf(paramJobContext.getHeight()));
      localObject = vxv.b(paramJobContext, 720, i, false, false);
      if (localObject == null)
      {
        super.notifyError(new BitmapError("Q.qqstory.publish.edit.ResizeBitmapSegment", 5));
        return;
      }
      paramvsa.jdField_a_of_type_Vse.jdField_b_of_type_Boolean = false;
      paramvsa.jdField_a_of_type_Vse.jdField_a_of_type_Boolean = true;
      String str = vsq.a(paramvsa.jdField_a_of_type_Int, paramvsa.jdField_b_of_type_JavaLangString, ".jpg");
      vxv.a((Bitmap)localObject, str);
      if (paramJobContext != localObject)
      {
        ((Bitmap)localObject).recycle();
        ved.d("Q.qqstory.publish.edit.ResizeBitmapSegment", "BitmapUtils.resizeAndFillBitmapEdge recycle bitmap");
      }
      for (;;)
      {
        paramvsa.jdField_a_of_type_Vse.jdField_b_of_type_JavaLangString = str;
        super.notifyResult(paramvsa);
        return;
        ved.d("Q.qqstory.publish.edit.ResizeBitmapSegment", "BitmapUtils.resizeAndFillBitmapEdge do not recycle bitmap");
      }
      label384:
      ved.b("Q.qqstory.publish.edit.ResizeBitmapSegment", "no need resize. srcWidth=%s, srcHeight=%s, destWidth=%s, destHeight=%s", Integer.valueOf(((BitmapFactory.Options)localObject).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject).outHeight), Integer.valueOf(720), Integer.valueOf(i));
      super.notifyResult(paramvsa);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vst
 * JD-Core Version:    0.7.0.1
 */