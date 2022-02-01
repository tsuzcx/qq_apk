import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tribe.async.async.JobContext;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import java.lang.ref.WeakReference;

public class ayqd
  extends ayqr<ayqb, ayqb>
  implements ppe
{
  public final String aAV;
  public final int bqF;
  public final WeakReference<aydg> dh;
  public final WeakReference<aydh> di;
  
  public ayqd(aydg paramaydg, aydh paramaydh, int paramInt)
  {
    this(paramaydg, paramaydh, null, paramInt);
  }
  
  public ayqd(aydg paramaydg, aydh paramaydh, String paramString, int paramInt)
  {
    if (paramaydg == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.dh = new WeakReference(paramaydg);
    this.di = new WeakReference(paramaydh);
    this.aAV = paramString;
    this.bqF = paramInt;
  }
  
  protected void a(JobContext paramJobContext, ayqb paramayqb)
  {
    long l1 = SystemClock.uptimeMillis();
    paramJobContext = paramayqb.aAT;
    if (TextUtils.isEmpty(paramJobContext))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      rar.b("take_video", "create_doodle_result", 0, -1, new String[0]);
      return;
    }
    aydg localaydg = (aydg)this.dh.get();
    Object localObject = (aydh)this.di.get();
    Bitmap localBitmap;
    String str;
    if ((localaydg != null) && ((!localaydg.y(this.bqF)) || ((localObject != null) && (((aydh)localObject).eL(this.bqF)))))
    {
      localBitmap = localaydg.a(this.bqF, true);
      str = this.aAV;
      if (str != null) {
        break label688;
      }
      str = ayqu.f(paramayqb.businessId, paramayqb.aAU, ".png");
      if (localBitmap != null) {
        if (localObject == null) {}
      }
    }
    for (;;)
    {
      try
      {
        if (((aydh)localObject).eL(this.bqF)) {
          ((aydh)localObject).a(this.bqF, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
        }
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        try
        {
          aqhu.d(paramJobContext, (BitmapFactory.Options)localObject);
          m = ((BitmapFactory.Options)localObject).outWidth;
          n = ((BitmapFactory.Options)localObject).outHeight;
          if ((paramayqb.a.asi == 14) && (paramayqb.a.Ld()) && (paramayqb.a.a.getWidth() < paramayqb.a.a.getHeight())) {
            break label691;
          }
          if (paramayqb.a.asi == 14) {
            continue;
          }
        }
        catch (OutOfMemoryError paramJobContext)
        {
          int m;
          int n;
          int k;
          int i;
          long l2;
          ram.w("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "decode video thumb failed %s", paramJobContext);
          super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", 6));
          return;
        }
        k = n;
        i = m;
        if (m > n)
        {
          k = n;
          i = m;
          if (j != 0)
          {
            i = ((BitmapFactory.Options)localObject).outHeight;
            k = ((BitmapFactory.Options)localObject).outWidth;
          }
        }
        paramJobContext = rop.c(localBitmap, i, k, true, false);
        i = ayqm.a(paramayqb);
        if (i != 0)
        {
          paramJobContext = rpq.rotateBitmap(paramJobContext, i);
          if (paramJobContext == null) {
            break label679;
          }
          bool = rop.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, str);
          localaydg.s(localBitmap);
          if (paramJobContext != localBitmap) {
            rop.f(paramJobContext);
          }
          if ((paramJobContext != null) && (bool))
          {
            ram.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "resize and crop original doodle image success");
            l2 = SystemClock.uptimeMillis();
            rar.b("take_video", "create_doodle_time", 0, 0, new String[] { "" + (l2 - l1) });
            rar.b("take_video", "create_doodle_result", 0, 0, new String[0]);
            paramayqb.g.putExtra("dynamic_Sticker_image_path", str);
            super.notifyResult(paramayqb);
            return;
            j = 0;
          }
        }
        else
        {
          if ((((BitmapFactory.Options)localObject).outWidth <= ((BitmapFactory.Options)localObject).outHeight) || ((paramayqb.businessId != 12) && (paramayqb.businessId != 11))) {
            break label685;
          }
          paramJobContext = rpq.rotateBitmap(paramJobContext, 270.0F);
          continue;
        }
        ram.w("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "resize and save doodle image failed");
      }
      finally
      {
        localaydg.s(localBitmap);
      }
      rar.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
      return;
      ram.w("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "get doodle bitmap failed");
      rar.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
      return;
      ram.w("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "do not generate doodle image because doodle is empty");
      super.notifyResult(paramayqb);
      return;
      label679:
      boolean bool = false;
      continue;
      label685:
      continue;
      label688:
      break;
      label691:
      int j = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayqd
 * JD-Core Version:    0.7.0.1
 */