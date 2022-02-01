import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class ayqn
  extends ayqr<ayqb, ayqb>
{
  public WeakReference<aydk> jt;
  
  public ayqn(aydk paramaydk)
  {
    this.jt = new WeakReference(paramaydk);
  }
  
  protected void a(JobContext paramJobContext, ayqb paramayqb)
  {
    paramJobContext = (aydk)this.jt.get();
    if (paramJobContext == null)
    {
      ram.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "EditVideoInteract is null, return directly.");
      notifyResult(paramayqb);
      return;
    }
    paramJobContext = paramJobContext.aX();
    if (paramJobContext == null)
    {
      ram.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "interact bitmap is null, return directly.");
      notifyResult(paramayqb);
      return;
    }
    int i = ayqm.a(paramayqb);
    Object localObject;
    if (i != 0)
    {
      localObject = rpq.rotateBitmap(paramJobContext, i);
      if (localObject != null)
      {
        paramJobContext.recycle();
        paramJobContext = (JobContext)localObject;
      }
    }
    for (;;)
    {
      localObject = ayqu.f(paramayqb.businessId, paramayqb.aAU, ".png");
      try
      {
        if (!rop.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, (String)localObject)) {
          break;
        }
        paramayqb.g.putExtra("il_pic", localObject);
        notifyResult(paramayqb);
        return;
      }
      catch (Exception paramJobContext)
      {
        ram.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "compressToFile Exception :", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
        return;
      }
      ram.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "rotate vote bitmap failed. rotation=%s", new Object[] { Integer.valueOf(i) });
    }
    ram.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "compressToFile failed.");
    super.notifyError(new ErrorMessage(-1, "compress interact bitmap failed !"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayqn
 * JD-Core Version:    0.7.0.1
 */