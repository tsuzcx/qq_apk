import android.graphics.Bitmap.CompressFormat;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class ayqf
  extends ayqr<ayqb, ayqb>
{
  public WeakReference<aydk> jt;
  
  public ayqf(aydk paramaydk)
  {
    this.jt = new WeakReference(paramaydk);
  }
  
  protected void a(JobContext paramJobContext, ayqb paramayqb)
  {
    paramJobContext = (aydk)this.jt.get();
    if (paramJobContext == null)
    {
      ram.e("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "EditInteractExport is null, return directly.");
      notifyResult(paramayqb);
      return;
    }
    paramJobContext = paramJobContext.aX();
    if (paramJobContext == null)
    {
      ram.e("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "interact bitmap is null, return directly.");
      notifyResult(paramayqb);
      return;
    }
    String str = ayqu.f(paramayqb.businessId, paramayqb.aAU, ".png");
    try
    {
      if (rop.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, str))
      {
        paramayqb.g.putExtra("il_pic", str);
        notifyResult(paramayqb);
        return;
      }
    }
    catch (Exception paramJobContext)
    {
      ram.e("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "compressToFile Exception :", paramJobContext);
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      return;
    }
    ram.e("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "compressToFile failed.");
    super.notifyError(new ErrorMessage(-1, "compress interact bitmap failed !"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayqf
 * JD-Core Version:    0.7.0.1
 */