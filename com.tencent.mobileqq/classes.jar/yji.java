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

public class yji
  extends yju<yjh, yjh>
{
  public final int a;
  public final String a;
  public final WeakReference<xwj> a;
  public final WeakReference<xwk> b;
  
  public yji(xwj paramxwj)
  {
    this(paramxwj, null, 0);
  }
  
  public yji(xwj paramxwj, xwk paramxwk, int paramInt)
  {
    this(paramxwj, paramxwk, null, paramInt);
  }
  
  public yji(xwj paramxwj, xwk paramxwk, String paramString, int paramInt)
  {
    if (paramxwj == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramxwj);
    this.b = new WeakReference(paramxwk);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    if ((paramInt + 90) % 180 == 0) {
      try
      {
        xvv.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateOrientation begin!");
        long l = System.currentTimeMillis();
        int i = paramBitmap.getWidth();
        int j = paramBitmap.getHeight();
        Matrix localMatrix = new Matrix();
        localMatrix.reset();
        localMatrix.postRotate(paramInt);
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
        xvv.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateOrientation end, cost:" + (System.currentTimeMillis() - l) / 1000.0D);
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
  
  protected void a(JobContext paramJobContext, yjh paramyjh)
  {
    long l1 = SystemClock.uptimeMillis();
    String str = paramyjh.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(str))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      xwa.b("take_video", "create_doodle_result", 0, -1, new String[0]);
      return;
    }
    xwj localxwj = (xwj)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject2 = (xwk)this.b.get();
    if ((localxwj != null) && ((!localxwj.a(this.jdField_a_of_type_Int)) || ((localObject2 != null) && (((xwk)localObject2).a(this.jdField_a_of_type_Int)))))
    {
      paramJobContext = localxwj.a().a(this.jdField_a_of_type_Int);
      if (paramJobContext == null) {}
    }
    Bitmap localBitmap;
    for (Object localObject1 = yjx.a(paramyjh.jdField_a_of_type_Int, paramyjh.b, "mosaic.png");; localObject1 = localBitmap) {
      for (;;)
      {
        try
        {
          yoy.a(paramJobContext, (String)localObject1, null);
          paramyjh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath = ((String)localObject1);
          xvv.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateMosaicBitmap success %s", localObject1);
          localBitmap = localxwj.a(this.jdField_a_of_type_Int);
          localObject1 = this.jdField_a_of_type_JavaLangString;
          paramJobContext = (JobContext)localObject1;
          if (localObject1 == null) {
            paramJobContext = yjx.a(paramyjh.jdField_a_of_type_Int, paramyjh.b, ".png");
          }
          if (localBitmap == null) {
            break label689;
          }
          if (localObject2 != null) {}
          int i;
          int j;
          long l2;
          bool = yoy.a((Bitmap)localObject1, Bitmap.CompressFormat.PNG, 60, paramJobContext);
        }
        catch (IOException paramJobContext)
        {
          try
          {
            if (((xwk)localObject2).a(this.jdField_a_of_type_Int)) {
              ((xwk)localObject2).a(this.jdField_a_of_type_Int, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
            }
            i = paramyjh.jdField_a_of_type_Yjn.c;
            j = paramyjh.jdField_a_of_type_Int;
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
              bfvo.a(str, (BitmapFactory.Options)localObject2);
              localObject1 = yoy.c((Bitmap)localObject1, ((BitmapFactory.Options)localObject2).outWidth, ((BitmapFactory.Options)localObject2).outHeight, true, false);
              if (localObject1 == null) {
                break label757;
              }
              if (paramyjh.jdField_a_of_type_Int != 1) {
                break label615;
              }
              str = yjx.a(paramyjh.jdField_a_of_type_Int, paramyjh.b, ".png");
            }
            catch (OutOfMemoryError paramJobContext)
            {
              xvv.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "decode video thumb failed %s", paramJobContext);
              super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateDoodleImageSegment", 6));
              return;
            }
            try
            {
              yoy.a((Bitmap)localObject1, str, null);
              paramyjh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodleRawPath = str;
              bool = true;
              paramJobContext = null;
            }
            catch (Throwable localThrowable)
            {
              xvv.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", localThrowable);
              bool = yoy.a((Bitmap)localObject1, Bitmap.CompressFormat.PNG, 60, paramJobContext);
              continue;
            }
            localxwj.a(localBitmap);
            if (localObject1 != localBitmap) {
              yoy.a((Bitmap)localObject1);
            }
            if ((localObject1 == null) || (!bool)) {
              break label643;
            }
            xvv.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and crop original doodle image success");
            l2 = SystemClock.uptimeMillis();
            xwa.b("take_video", "create_doodle_time", 0, 0, new String[] { "" + (l2 - l1) });
            xwa.b("take_video", "create_doodle_result", 0, 0, new String[0]);
            paramyjh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
            super.notifyResult(paramyjh);
            return;
          }
          finally
          {
            localxwj.a(localBitmap);
          }
          paramJobContext = paramJobContext;
          xvv.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", paramJobContext);
          super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
          return;
        }
        label615:
        continue;
        label643:
        xvv.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and save doodle image failed");
        xwa.b("take_video", "create_doodle_result", 0, -2, new String[0]);
        paramyjh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
        super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
        return;
        label689:
        xvv.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "get doodle bitmap failed");
        xwa.b("take_video", "create_doodle_result", 0, -2, new String[0]);
        paramyjh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
        super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
        return;
        xvv.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "do not generate doodle image because doodle is empty");
        paramyjh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
        super.notifyResult(paramyjh);
        return;
        label757:
        boolean bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yji
 * JD-Core Version:    0.7.0.1
 */