import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class zii
  extends ziu<zih, zih>
{
  public final int a;
  public final String a;
  public final WeakReference<yuy> a;
  public final WeakReference<yuz> b;
  
  public zii(yuy paramyuy)
  {
    this(paramyuy, null, 0);
  }
  
  public zii(yuy paramyuy, yuz paramyuz, int paramInt)
  {
    this(paramyuy, paramyuz, null, paramInt);
  }
  
  public zii(yuy paramyuy, yuz paramyuz, String paramString, int paramInt)
  {
    if (paramyuy == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramyuy);
    this.b = new WeakReference(paramyuz);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    if ((paramInt + 90) % 180 == 0) {
      try
      {
        yuk.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateOrientation begin!");
        long l = System.currentTimeMillis();
        int i = paramBitmap.getWidth();
        int j = paramBitmap.getHeight();
        Matrix localMatrix = new Matrix();
        localMatrix.reset();
        localMatrix.postRotate(paramInt);
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
        yuk.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateOrientation end, cost:" + (System.currentTimeMillis() - l) / 1000.0D);
        return paramBitmap;
      }
      catch (Exception paramBitmap)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqstory.publish.edit.GenerateDoodleImageSegment", 2, "rotate exception:" + paramBitmap);
        }
        return null;
      }
    }
    return null;
  }
  
  protected void a(JobContext paramJobContext, zih paramzih)
  {
    long l1 = SystemClock.uptimeMillis();
    String str = paramzih.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(str))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      yup.b("take_video", "create_doodle_result", 0, -1, new String[0]);
      return;
    }
    yuy localyuy = (yuy)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject2 = (yuz)this.b.get();
    if ((localyuy != null) && ((!localyuy.a(this.jdField_a_of_type_Int)) || ((localObject2 != null) && (((yuz)localObject2).a(this.jdField_a_of_type_Int)))))
    {
      paramJobContext = localyuy.a().a(this.jdField_a_of_type_Int);
      if (paramJobContext == null) {}
    }
    Bitmap localBitmap;
    for (Object localObject1 = zix.a(paramzih.jdField_a_of_type_Int, paramzih.b, "mosaic.png");; localObject1 = localBitmap) {
      for (;;)
      {
        try
        {
          zoc.a(paramJobContext, (String)localObject1, null);
          paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath = ((String)localObject1);
          yuk.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateMosaicBitmap success %s", localObject1);
          localBitmap = localyuy.a(this.jdField_a_of_type_Int);
          localObject1 = this.jdField_a_of_type_JavaLangString;
          paramJobContext = (JobContext)localObject1;
          if (localObject1 == null) {
            paramJobContext = zix.a(paramzih.jdField_a_of_type_Int, paramzih.b, ".png");
          }
          if (localBitmap == null) {
            break label696;
          }
          if (localObject2 != null) {}
          int i;
          int j;
          long l2;
          bool = zoc.a((Bitmap)localObject1, Bitmap.CompressFormat.PNG, 60, paramJobContext);
        }
        catch (IOException paramJobContext)
        {
          try
          {
            if (((yuz)localObject2).a(this.jdField_a_of_type_Int)) {
              ((yuz)localObject2).a(this.jdField_a_of_type_Int, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
            }
            i = paramzih.jdField_a_of_type_Zin.c;
            j = paramzih.jdField_a_of_type_Int;
            if ((j != 2) && (j != 3) && (j != 5) && (j != 101) && (j != 104) && (j != 6)) {
              break;
            }
            localObject1 = a(localBitmap, i);
            if (localObject1 == null) {
              break;
            }
            localObject2 = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
            try
            {
              bhmq.a(str, (BitmapFactory.Options)localObject2);
              localObject1 = zoc.c((Bitmap)localObject1, ((BitmapFactory.Options)localObject2).outWidth, ((BitmapFactory.Options)localObject2).outHeight, true, false);
              if (localObject1 == null) {
                break label764;
              }
              if (paramzih.jdField_a_of_type_Int != 1) {
                break label622;
              }
              str = zix.a(paramzih.jdField_a_of_type_Int, paramzih.b, ".png");
            }
            catch (OutOfMemoryError paramJobContext)
            {
              yuk.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "decode video thumb failed %s", paramJobContext);
              super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateDoodleImageSegment", 6));
              return;
            }
            try
            {
              zoc.a((Bitmap)localObject1, str, null);
              paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodleRawPath = str;
              bool = true;
              paramJobContext = null;
            }
            catch (Throwable localThrowable)
            {
              yuk.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", localThrowable);
              bool = zoc.a((Bitmap)localObject1, Bitmap.CompressFormat.PNG, 60, paramJobContext);
              continue;
            }
            localyuy.a(localBitmap);
            if (localObject1 != localBitmap) {
              zoc.a((Bitmap)localObject1);
            }
            if ((localObject1 == null) || (!bool)) {
              break label650;
            }
            yuk.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and crop original doodle image success");
            l2 = SystemClock.uptimeMillis();
            yup.b("take_video", "create_doodle_time", 0, 0, new String[] { "" + (l2 - l1) });
            yup.b("take_video", "create_doodle_result", 0, 0, new String[0]);
            paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
            super.notifyResult(paramzih);
            return;
          }
          finally
          {
            localyuy.a(localBitmap);
          }
          paramJobContext = paramJobContext;
          yuk.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", paramJobContext);
          super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
          return;
        }
        label622:
        continue;
        label650:
        yuk.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and save doodle image failed");
        yup.b("take_video", "create_doodle_result", 0, -2, new String[0]);
        paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
        super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
        return;
        label696:
        yuk.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "get doodle bitmap failed");
        yup.b("take_video", "create_doodle_result", 0, -2, new String[0]);
        paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
        super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
        return;
        yuk.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "do not generate doodle image because doodle is empty");
        paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
        super.notifyResult(paramzih);
        return;
        label764:
        boolean bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zii
 * JD-Core Version:    0.7.0.1
 */