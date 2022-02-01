import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class ayqa
  extends ayqr<ayqb, ayqb>
{
  public final String aAW;
  public final String cXP;
  @NonNull
  public final WeakReference<ayff> js;
  
  public ayqa(ayff paramayff, String paramString1, String paramString2)
  {
    if (paramayff == null) {
      throw new IllegalArgumentException("atDoodleController is illegal");
    }
    this.js = new WeakReference(paramayff);
    this.aAW = paramString1;
    this.cXP = paramString2;
  }
  
  private boolean a(ayqb paramayqb, String paramString1, String paramString2)
  {
    paramayqb.g.atDoodlePath = paramString1;
    paramayqb.g.atJsonData = paramString2;
    return true;
  }
  
  protected void a(JobContext paramJobContext, ayqb paramayqb)
  {
    int i = 0;
    int j = 0;
    String str = paramayqb.aAT;
    if (str == null)
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      return;
    }
    ayff localayff = (ayff)this.js.get();
    Object localObject;
    BitmapFactory.Options localOptions;
    if ((localayff != null) && (!localayff.isEmpty()))
    {
      localObject = this.aAW;
      paramJobContext = (JobContext)localObject;
      if (localObject == null) {
        paramJobContext = ayqu.f(paramayqb.businessId, paramayqb.aAU, ".png");
      }
      localObject = localayff.aY();
      if (localObject != null)
      {
        localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
      }
    }
    for (;;)
    {
      try
      {
        aqhu.d(str, localOptions);
        localObject = rop.b((Bitmap)localObject, localOptions.outWidth, localOptions.outHeight, true, false);
        if (localObject == null) {
          break label388;
        }
        bool1 = rop.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
        if ((localObject != null) && (bool1))
        {
          ram.d("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "resize and crop original doodle image success");
          i = j;
          if (a(paramayqb, paramJobContext, this.cXP)) {
            i = 1;
          }
          rop.f((Bitmap)localObject);
          if (i == 0) {
            break label360;
          }
          super.notifyResult(paramayqb);
          return;
        }
      }
      catch (OutOfMemoryError paramJobContext)
      {
        ram.w("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "decode video thumb failed %s", paramJobContext);
        super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", 6));
        return;
      }
      if (localObject != null) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        ram.w("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "resize and save doodle image failed, resize result=%s, save result=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        bool1 = localayff.un(paramJobContext);
        ram.d("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "generate original doodle png file : success = " + bool1 + ", path = " + paramJobContext);
        if (!bool1) {
          break label347;
        }
        ram.d("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "use the original doodle image instead");
        i = j;
        if (!a(paramayqb, paramJobContext, this.cXP)) {
          break;
        }
        i = 1;
        break;
      }
      label347:
      ram.w("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "copy the original doodle image failed, we'll ignore the doodle then publish");
      i = j;
      continue;
      label360:
      super.notifyError(new ErrorMessage(-1, "DoodleLayout generate image failed"));
      return;
      ram.w("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "do not generate at doodle image because at doodle is empty");
      super.notifyResult(paramayqb);
      return;
      label388:
      boolean bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayqa
 * JD-Core Version:    0.7.0.1
 */