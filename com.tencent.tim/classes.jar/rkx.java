import android.graphics.Bitmap;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class rkx
  extends rkz<rkm, rkm>
{
  private String aBb;
  private final int aDT;
  private final WeakReference<rdo> dk;
  
  public rkx(String paramString, rdo paramrdo, int paramInt)
  {
    this.aBb = paramString;
    this.dk = new WeakReference(paramrdo);
    this.aDT = paramInt;
  }
  
  protected void a(JobContext paramJobContext, rkm paramrkm)
  {
    ram.b("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "start generate thumb ... mVideoIndex = %d", Integer.valueOf(this.aDT));
    rks localrks = paramrkm.a;
    int i = localrks.mOrientation;
    if (this.dk != null) {
      paramJobContext = (rdo)this.dk.get();
    }
    while (paramJobContext != null)
    {
      Bitmap localBitmap = paramJobContext.f(this.aDT);
      if (localBitmap != null)
      {
        try
        {
          String str2 = this.aBb;
          String str1 = str2;
          if (str2 == null) {
            str1 = rlc.f(paramrkm.businessId, paramrkm.aAU, ".jpg");
          }
          i = new rku(localBitmap, str1, localrks.bsU, localrks.bsV, i, localrks.dw, localrks.bo, localrks.bp, paramrkm.businessId).a(new Void[0]).intValue();
          paramJobContext.s(localBitmap);
          if (i != 0) {
            break label217;
          }
          paramrkm.aAT = str1;
          paramrkm.g.thumbPath = str1;
          ram.w("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb success ...", new Object[] { Integer.valueOf(this.aDT) });
          super.notifyResult(paramrkm);
          return;
        }
        finally
        {
          paramJobContext.s(localBitmap);
        }
        paramJobContext = null;
        continue;
        label217:
        ram.w("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb failed ...", new Object[] { Integer.valueOf(this.aDT) });
        super.notifyError(new ErrorMessage(-1, acfp.m(2131707337) + this.aDT));
      }
      else
      {
        ram.w("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb failed ... EditVideoPlayerExport generateVideoFrameBitmap return null", new Object[] { Integer.valueOf(this.aDT) });
        super.notifyError(new ErrorMessage(-1, acfp.m(2131707342) + this.aDT));
        return;
      }
    }
    ram.w("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb failed ... can not find EditVideoPlayerExport", new Object[] { Integer.valueOf(this.aDT) });
    super.notifyError(new ErrorMessage(-1, acfp.m(2131707338) + this.aDT));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rkx
 * JD-Core Version:    0.7.0.1
 */