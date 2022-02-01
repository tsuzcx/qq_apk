import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.async.JobContext;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class ayqq
  extends ayqr<ayqb, ayqb>
{
  protected void a(JobContext paramJobContext, ayqb paramayqb)
  {
    int i = rpq.getScreenWidth(BaseApplication.getContext());
    int j = rpq.getScreenHeight(BaseApplication.getContext()) * 720 / i;
    i = j;
    if (j % 2 != 0) {
      i = j + 1;
    }
    Object localObject = paramayqb.jdField_a_of_type_Ayqh.aAY;
    paramJobContext = (JobContext)localObject;
    if (!paramayqb.jdField_a_of_type_Ayqh.aIF)
    {
      paramJobContext = (JobContext)localObject;
      if (paramayqb.jdField_a_of_type_Ayqh.result) {
        paramJobContext = paramayqb.jdField_a_of_type_Ayqh.aAZ;
      }
    }
    try
    {
      localObject = aqhu.d(paramJobContext, new BitmapFactory.Options());
      if (localObject == null)
      {
        ram.w("Q.qqstory.publish.edit.MakeStoryPicSegment", "aioBitmap is null please check!");
        super.notifyError(new BitmapError("Q.qqstory.publish.edit.MakeStoryPicSegment", 0));
        return;
      }
    }
    catch (OutOfMemoryError paramJobContext)
    {
      ram.w("Q.qqstory.publish.edit.MakeStoryPicSegment", "decodeFileWithBufferedStream failed", paramJobContext);
      super.notifyError(new BitmapError("Q.qqstory.publish.edit.MakeStoryPicSegment", 6));
      return;
    }
    if ((paramayqb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.eKg != ((Bitmap)localObject).getHeight()) || (paramayqb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.eKf != ((Bitmap)localObject).getWidth())) {}
    for (j = 1;; j = 0)
    {
      if (((Bitmap)localObject).getWidth() <= 720)
      {
        paramJobContext = (JobContext)localObject;
        if (((Bitmap)localObject).getHeight() <= i) {
          break;
        }
      }
      float f = Math.min(720 / ((Bitmap)localObject).getWidth(), i / ((Bitmap)localObject).getHeight());
      localObject = rop.b((Bitmap)localObject, f, true);
      ram.b("Q.qqstory.publish.edit.MakeStoryPicSegment", "scale by %s, aioBitmap=%s", Float.valueOf(f), localObject);
      paramJobContext = (JobContext)localObject;
      if (localObject != null) {
        break;
      }
      notifyError(new BitmapError("resizeBitmapByScale failed", -1));
      return;
    }
    ram.d("Q.qqstory.publish.edit.MakeStoryPicSegment", "current bitmap size " + paramJobContext.getWidth() + ", " + paramJobContext.getHeight());
    if (j != 0) {
      paramJobContext = rop.c(paramJobContext, 720, i, false, true);
    }
    for (;;)
    {
      if (paramJobContext == null)
      {
        notifyError(new BitmapError("fillBitmapEdge failed", -1));
        return;
      }
      if (paramJobContext.getHeight() % 2 == 0)
      {
        localObject = paramJobContext;
        if (paramJobContext.getWidth() % 2 == 0) {}
      }
      else
      {
        localObject = Bitmap.createScaledBitmap(paramJobContext, paramJobContext.getWidth() >> 1 << 1, paramJobContext.getHeight() >> 1 << 1, false);
      }
      paramJobContext = ayqu.f(paramayqb.businessId, paramayqb.aAU, ".jpg");
      rop.d((Bitmap)localObject, paramJobContext);
      ((Bitmap)localObject).recycle();
      paramayqb.g.thumbPath = paramJobContext;
      super.notifyResult(paramayqb);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayqq
 * JD-Core Version:    0.7.0.1
 */