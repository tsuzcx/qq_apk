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

public class yyb
  extends yyn<yya, yya>
{
  public final int a;
  public final String a;
  public final WeakReference<ylc> a;
  public final WeakReference<yld> b;
  
  public yyb(ylc paramylc)
  {
    this(paramylc, null, 0);
  }
  
  public yyb(ylc paramylc, yld paramyld, int paramInt)
  {
    this(paramylc, paramyld, null, paramInt);
  }
  
  public yyb(ylc paramylc, yld paramyld, String paramString, int paramInt)
  {
    if (paramylc == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramylc);
    this.b = new WeakReference(paramyld);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    if ((paramInt + 90) % 180 == 0) {
      try
      {
        ykq.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateOrientation begin!");
        long l = System.currentTimeMillis();
        int i = paramBitmap.getWidth();
        int j = paramBitmap.getHeight();
        Matrix localMatrix = new Matrix();
        localMatrix.reset();
        localMatrix.postRotate(paramInt);
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
        ykq.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateOrientation end, cost:" + (System.currentTimeMillis() - l) / 1000.0D);
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
  
  protected void a(JobContext paramJobContext, yya paramyya)
  {
    long l1 = SystemClock.uptimeMillis();
    String str = paramyya.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(str))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      ykv.b("take_video", "create_doodle_result", 0, -1, new String[0]);
      return;
    }
    ylc localylc = (ylc)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject2 = (yld)this.b.get();
    if ((localylc != null) && ((!localylc.a(this.jdField_a_of_type_Int)) || ((localObject2 != null) && (((yld)localObject2).a(this.jdField_a_of_type_Int)))))
    {
      paramJobContext = localylc.a().a(this.jdField_a_of_type_Int);
      if (paramJobContext == null) {}
    }
    Bitmap localBitmap;
    for (Object localObject1 = yyq.a(paramyya.jdField_a_of_type_Int, paramyya.b, "mosaic.png");; localObject1 = localBitmap) {
      for (;;)
      {
        try
        {
          zdr.a(paramJobContext, (String)localObject1, null);
          paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath = ((String)localObject1);
          ykq.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateMosaicBitmap success %s", localObject1);
          localBitmap = localylc.a(this.jdField_a_of_type_Int);
          localObject1 = this.jdField_a_of_type_JavaLangString;
          paramJobContext = (JobContext)localObject1;
          if (localObject1 == null) {
            paramJobContext = yyq.a(paramyya.jdField_a_of_type_Int, paramyya.b, ".png");
          }
          if (localBitmap == null) {
            break label689;
          }
          if (localObject2 != null) {}
          int i;
          int j;
          long l2;
          bool = zdr.a((Bitmap)localObject1, Bitmap.CompressFormat.PNG, 60, paramJobContext);
        }
        catch (IOException paramJobContext)
        {
          try
          {
            if (((yld)localObject2).a(this.jdField_a_of_type_Int)) {
              ((yld)localObject2).a(this.jdField_a_of_type_Int, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
            }
            i = paramyya.jdField_a_of_type_Yyg.c;
            j = paramyya.jdField_a_of_type_Int;
            if ((j != 2) && (j != 3) && (j != 5) && (j != 104) && (j != 6)) {
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
              bheg.a(str, (BitmapFactory.Options)localObject2);
              localObject1 = zdr.c((Bitmap)localObject1, ((BitmapFactory.Options)localObject2).outWidth, ((BitmapFactory.Options)localObject2).outHeight, true, false);
              if (localObject1 == null) {
                break label757;
              }
              if (paramyya.jdField_a_of_type_Int != 1) {
                break label615;
              }
              str = yyq.a(paramyya.jdField_a_of_type_Int, paramyya.b, ".png");
            }
            catch (OutOfMemoryError paramJobContext)
            {
              ykq.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "decode video thumb failed %s", paramJobContext);
              super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateDoodleImageSegment", 6));
              return;
            }
            try
            {
              zdr.a((Bitmap)localObject1, str, null);
              paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodleRawPath = str;
              bool = true;
              paramJobContext = null;
            }
            catch (Throwable localThrowable)
            {
              ykq.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", localThrowable);
              bool = zdr.a((Bitmap)localObject1, Bitmap.CompressFormat.PNG, 60, paramJobContext);
              continue;
            }
            localylc.a(localBitmap);
            if (localObject1 != localBitmap) {
              zdr.a((Bitmap)localObject1);
            }
            if ((localObject1 == null) || (!bool)) {
              break label643;
            }
            ykq.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and crop original doodle image success");
            l2 = SystemClock.uptimeMillis();
            ykv.b("take_video", "create_doodle_time", 0, 0, new String[] { "" + (l2 - l1) });
            ykv.b("take_video", "create_doodle_result", 0, 0, new String[0]);
            paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
            super.notifyResult(paramyya);
            return;
          }
          finally
          {
            localylc.a(localBitmap);
          }
          paramJobContext = paramJobContext;
          ykq.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", paramJobContext);
          super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
          return;
        }
        label615:
        continue;
        label643:
        ykq.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and save doodle image failed");
        ykv.b("take_video", "create_doodle_result", 0, -2, new String[0]);
        paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
        super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
        return;
        label689:
        ykq.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "get doodle bitmap failed");
        ykv.b("take_video", "create_doodle_result", 0, -2, new String[0]);
        paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
        super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
        return;
        ykq.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "do not generate doodle image because doodle is empty");
        paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
        super.notifyResult(paramyya);
        return;
        label757:
        boolean bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yyb
 * JD-Core Version:    0.7.0.1
 */