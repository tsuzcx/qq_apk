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

public class rkn
  extends rkz<rkm, rkm>
{
  public final String aAV;
  public final int bqF;
  public final WeakReference<rba> dh;
  public final WeakReference<rbb> di;
  
  public rkn(rba paramrba)
  {
    this(paramrba, null, 0);
  }
  
  public rkn(rba paramrba, rbb paramrbb, int paramInt)
  {
    this(paramrba, paramrbb, null, paramInt);
  }
  
  public rkn(rba paramrba, rbb paramrbb, String paramString, int paramInt)
  {
    if (paramrba == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.dh = new WeakReference(paramrba);
    this.di = new WeakReference(paramrbb);
    this.aAV = paramString;
    this.bqF = paramInt;
  }
  
  public static Bitmap c(Bitmap paramBitmap, int paramInt)
  {
    if ((paramInt + 90) % 180 == 0) {
      try
      {
        ram.w("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateOrientation begin!");
        long l = System.currentTimeMillis();
        int i = paramBitmap.getWidth();
        int j = paramBitmap.getHeight();
        Matrix localMatrix = new Matrix();
        localMatrix.reset();
        localMatrix.postRotate(paramInt);
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
        ram.w("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateOrientation end, cost:" + (System.currentTimeMillis() - l) / 1000.0D);
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
    Object localObject2 = (rbb)this.di.get();
    if ((localrba != null) && ((!localrba.y(this.bqF)) || ((localObject2 != null) && (((rbb)localObject2).eL(this.bqF)))))
    {
      paramJobContext = localrba.a().h(this.bqF);
      if (paramJobContext == null) {}
    }
    Bitmap localBitmap;
    for (Object localObject1 = rlc.f(paramrkm.businessId, paramrkm.aAU, "mosaic.png");; localObject1 = localBitmap) {
      for (;;)
      {
        try
        {
          rop.a(paramJobContext, (String)localObject1, null);
          paramrkm.g.mosaicPath = ((String)localObject1);
          ram.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateMosaicBitmap success %s", localObject1);
          localBitmap = localrba.e(this.bqF);
          localObject1 = this.aAV;
          paramJobContext = (JobContext)localObject1;
          if (localObject1 == null) {
            paramJobContext = rlc.f(paramrkm.businessId, paramrkm.aAU, ".png");
          }
          if (localBitmap == null) {
            break label696;
          }
          if (localObject2 != null) {}
          int i;
          int j;
          long l2;
          bool = rop.a((Bitmap)localObject1, Bitmap.CompressFormat.PNG, 60, paramJobContext);
        }
        catch (IOException paramJobContext)
        {
          try
          {
            if (((rbb)localObject2).eL(this.bqF)) {
              ((rbb)localObject2).a(this.bqF, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
            }
            i = paramrkm.a.mOrientation;
            j = paramrkm.businessId;
            if ((j != 2) && (j != 3) && (j != 5) && (j != 101) && (j != 104) && (j != 6)) {
              break;
            }
            localObject1 = c(localBitmap, i);
            if (localObject1 == null) {
              break;
            }
            localObject2 = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
            try
            {
              aqhu.d(str, (BitmapFactory.Options)localObject2);
              localObject1 = rop.c((Bitmap)localObject1, ((BitmapFactory.Options)localObject2).outWidth, ((BitmapFactory.Options)localObject2).outHeight, true, false);
              if (localObject1 == null) {
                break label764;
              }
              if (paramrkm.businessId != 1) {
                break label622;
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
              rop.a((Bitmap)localObject1, str, null);
              paramrkm.g.doodleRawPath = str;
              bool = true;
              paramJobContext = null;
            }
            catch (Throwable localThrowable)
            {
              ram.e("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", localThrowable);
              bool = rop.a((Bitmap)localObject1, Bitmap.CompressFormat.PNG, 60, paramJobContext);
              continue;
            }
            localrba.s(localBitmap);
            if (localObject1 != localBitmap) {
              rop.f((Bitmap)localObject1);
            }
            if ((localObject1 == null) || (!bool)) {
              break label650;
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
            localrba.s(localBitmap);
          }
          paramJobContext = paramJobContext;
          ram.e("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", paramJobContext);
          super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
          return;
        }
        label622:
        continue;
        label650:
        ram.w("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and save doodle image failed");
        rar.b("take_video", "create_doodle_result", 0, -2, new String[0]);
        paramrkm.g.doodlePath = null;
        super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
        return;
        label696:
        ram.w("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "get doodle bitmap failed");
        rar.b("take_video", "create_doodle_result", 0, -2, new String[0]);
        paramrkm.g.doodlePath = null;
        super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
        return;
        ram.w("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "do not generate doodle image because doodle is empty");
        paramrkm.g.doodlePath = null;
        super.notifyResult(paramrkm);
        return;
        label764:
        boolean bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rkn
 * JD-Core Version:    0.7.0.1
 */