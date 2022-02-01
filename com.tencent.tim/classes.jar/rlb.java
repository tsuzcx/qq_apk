import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity;
import com.tribe.async.async.JobContext;
import java.io.File;
import java.io.IOException;

public class rlb
  extends rkz<rkm, rkm>
{
  private final String aBd;
  
  public rlb()
  {
    this(null);
  }
  
  public rlb(String paramString)
  {
    this.aBd = paramString;
  }
  
  protected void a(JobContext paramJobContext, rkm paramrkm)
  {
    paramJobContext = null;
    int i = 0;
    Object localObject3 = paramrkm.aAT;
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      return;
    }
    Object localObject2 = this.aBd;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = rlc.f(paramrkm.businessId, paramrkm.aAU, ".jpg");
    }
    String str2 = paramrkm.g.doodleRawPath;
    String str1 = paramrkm.g.doodlePath;
    if ((str2 != null) || (str1 != null))
    {
      try
      {
        localObject3 = BitmapFactory.decodeFile((String)localObject3);
        if (localObject3 != null) {
          break label184;
        }
        super.notifyError(new ErrorMessage(-1, acfp.m(2131708133)));
        return;
      }
      catch (OutOfMemoryError paramJobContext)
      {
        ram.e("Q.qqstory.publish.edit.MergeThumbSegment", "merge doodle and thumb image failed : " + paramJobContext);
      }
      if (i == 0) {
        break label466;
      }
      rox.copyFile(new File(paramrkm.g.thumbPath), new File(QQStoryTakeVideoCloseAnimationActivity.azX));
      super.notifyResult(paramrkm);
      return;
      label184:
      if (str2 == null) {
        break label484;
      }
      try
      {
        localObject2 = rop.a(str2, null);
        paramJobContext = (JobContext)localObject2;
        ram.w("Q.qqstory.publish.edit.MergeThumbSegment", "unSerializeBitmapFromFile success %s", new Object[] { str2 });
        paramJobContext = (JobContext)localObject2;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          try
          {
            label219:
            localObject2 = BitmapFactory.decodeFile(str1);
            paramJobContext = (JobContext)localObject2;
            if (paramJobContext == null) {
              break label501;
            }
            localObject2 = rop.c((Bitmap)localObject3, paramJobContext);
            paramJobContext.recycle();
            ((Bitmap)localObject3).recycle();
            paramJobContext = (JobContext)localObject2;
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            ram.e("Q.qqstory.publish.edit.MergeThumbSegment", "decode " + str1 + " failed", localOutOfMemoryError);
            break label498;
          }
          localIOException = localIOException;
          ram.e("Q.qqstory.publish.edit.MergeThumbSegment", "unSerializeBitmapFromFile failed", localIOException);
        }
      }
      if ((paramJobContext != null) || (str1 == null)) {
        break label498;
      }
    }
    label238:
    label495:
    label498:
    label501:
    label505:
    for (;;)
    {
      rox.checkDirAndCreate(plr.atc);
      boolean bool = rop.d(paramJobContext, (String)localObject1);
      if (paramJobContext != null) {
        paramJobContext.recycle();
      }
      if (bool)
      {
        paramrkm.g.thumbPath = ((String)localObject1);
        ram.d("Q.qqstory.publish.edit.MergeThumbSegment", "merge doodle and thumb image success : " + (String)localObject1);
        i = 1;
      }
      else
      {
        ram.w("Q.qqstory.publish.edit.MergeThumbSegment", "merge doodle and thumb image failed");
        i = 0;
        break label495;
        ram.b("Q.qqstory.publish.edit.MergeThumbSegment", "use thumb image as merged image, copy to target destination = %s", localObject1);
        if (rox.copyFile(new File((String)localObject3), new File((String)localObject1)))
        {
          paramrkm.g.thumbPath = ((String)localObject1);
          i = 1;
          break;
        }
        ram.w("Q.qqstory.publish.edit.MergeThumbSegment", "copy failed, original = %s, target = %s", new Object[] { localObject3, localObject1 });
        break;
        super.notifyError(new ErrorMessage(-1, acfp.m(2131708132)));
        return;
        paramJobContext = null;
        break label219;
      }
      for (;;)
      {
        if (paramJobContext != null) {
          break label505;
        }
        i = 0;
        break;
        break label238;
        paramJobContext = (JobContext)localObject3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rlb
 * JD-Core Version:    0.7.0.1
 */