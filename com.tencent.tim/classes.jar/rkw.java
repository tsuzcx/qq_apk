import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tribe.async.async.JobContext;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class rkw
  extends rkz<rkm, rkm>
  implements ppe
{
  public final String aAV;
  public final int bqF;
  public final WeakReference<rba> dh;
  public final WeakReference<rbb> di;
  
  public rkw(rba paramrba)
  {
    this(paramrba, null, 0);
  }
  
  public rkw(rba paramrba, rbb paramrbb, int paramInt)
  {
    this(paramrba, paramrbb, null, paramInt);
  }
  
  public rkw(rba paramrba, rbb paramrbb, String paramString, int paramInt)
  {
    if (paramrba == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.dh = new WeakReference(paramrba);
    this.di = new WeakReference(paramrbb);
    this.aAV = paramString;
    this.bqF = paramInt;
  }
  
  protected void a(JobContext paramJobContext, rkm paramrkm)
  {
    long l1 = SystemClock.uptimeMillis();
    String str = paramrkm.aAT;
    if (TextUtils.isEmpty(str))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      rar.b("take_video", "create_doodle_result", 0, -1, new String[0]);
      return;
    }
    rba localrba = (rba)this.dh.get();
    rbb localrbb = (rbb)this.di.get();
    int i = paramrkm.jdField_a_of_type_Rks.mOrientation;
    Object localObject;
    if ((localrba != null) && ((!localrba.y(this.bqF)) || ((localrbb != null) && (localrbb.eL(this.bqF)))))
    {
      localObject = localrba.a().h(this.bqF);
      if (localObject != null)
      {
        if (paramrkm.businessId != 10)
        {
          paramJobContext = (JobContext)localObject;
          if (paramrkm.businessId != 12) {}
        }
        else
        {
          i = paramrkm.jdField_a_of_type_Rks.mOrientation;
          paramJobContext = rpq.rotateBitmap((Bitmap)localObject, 360 - i);
          ram.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "rotate mosaic bitmap for tribe, orientation=" + i);
        }
        localObject = rlc.f(paramrkm.businessId, paramrkm.aAU, "mosaic.png");
      }
    }
    label789:
    label931:
    label937:
    for (;;)
    {
      try
      {
        rop.a(paramJobContext, (String)localObject, null);
        paramrkm.g.mosaicPath = ((String)localObject);
        ram.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateMosaicBitmap success %s", localObject);
        localBitmap = localrba.e(this.bqF);
        localObject = this.aAV;
        paramJobContext = (JobContext)localObject;
        if (localObject == null) {
          paramJobContext = rlc.f(paramrkm.businessId, paramrkm.aAU, ".png");
        }
        if (localBitmap == null) {
          break label863;
        }
        if (localrbb != null) {}
        int k;
        int m;
        int j;
        long l2;
        bool = rop.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
      }
      catch (IOException paramJobContext)
      {
        try
        {
          if (localrbb.eL(this.bqF)) {
            localrbb.a(this.bqF, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
          }
          localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
          try
          {
            aqhu.d(str, (BitmapFactory.Options)localObject);
            k = ((BitmapFactory.Options)localObject).outWidth;
            m = ((BitmapFactory.Options)localObject).outHeight;
            j = m;
            i = k;
            if (k > m)
            {
              j = m;
              i = k;
              if (paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi != 10)
              {
                j = m;
                i = k;
                if (k > m)
                {
                  j = m;
                  i = k;
                  if (paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi != 12)
                  {
                    i = ((BitmapFactory.Options)localObject).outHeight;
                    j = ((BitmapFactory.Options)localObject).outWidth;
                  }
                }
              }
            }
            localObject = rop.c(localBitmap, i, j, true, false);
            i = paramrkm.bsQ;
            if ((i == 0) || (paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi == 10) || (i == 0) || (paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi == 12)) {
              break label937;
            }
            localObject = rpq.rotateBitmap((Bitmap)localObject, i);
            if (localObject == null) {
              break label931;
            }
            if (paramrkm.businessId != 1) {
              break label789;
            }
            str = rlc.f(paramrkm.businessId, paramrkm.aAU, ".png");
          }
          catch (OutOfMemoryError paramJobContext)
          {
            ram.w("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "decode video thumb failed %s", paramJobContext);
            super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateDoodleImageSegment", 6));
            return;
          }
          try
          {
            rop.a((Bitmap)localObject, str, null);
            paramrkm.g.doodleRawPath = str;
            bool = true;
            paramJobContext = null;
          }
          catch (Throwable localThrowable)
          {
            ram.e("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", localThrowable);
            bool = rop.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
            continue;
          }
          localrba.s(localBitmap);
          if (localObject != localBitmap) {
            rop.f((Bitmap)localObject);
          }
          if ((localObject == null) || (!bool)) {
            break label817;
          }
          ram.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and crop original doodle image success");
          l2 = SystemClock.uptimeMillis();
          rar.b("take_video", "create_doodle_time", 0, 0, new String[] { "" + (l2 - l1) });
          rar.b("take_video", "create_doodle_result", 0, 0, new String[0]);
          paramrkm.g.doodlePath = paramJobContext;
          super.notifyResult(paramrkm);
          return;
        }
        finally
        {
          Bitmap localBitmap;
          localrba.s(localBitmap);
        }
        paramJobContext = paramJobContext;
        ram.e("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
        return;
      }
      catch (UnsupportedOperationException paramJobContext)
      {
        ram.e("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "updateExif failed", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "updateExif failed."));
        return;
      }
      continue;
      label817:
      ram.w("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and save doodle image failed");
      rar.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      paramrkm.g.doodlePath = null;
      super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
      return;
      label863:
      ram.w("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "get doodle bitmap failed");
      rar.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      paramrkm.g.doodlePath = null;
      super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
      return;
      ram.w("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "do not generate doodle image because doodle is empty");
      paramrkm.g.doodlePath = null;
      super.notifyResult(paramrkm);
      return;
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rkw
 * JD-Core Version:    0.7.0.1
 */