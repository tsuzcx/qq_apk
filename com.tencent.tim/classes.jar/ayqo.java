import android.graphics.Bitmap;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class ayqo
  extends ayqr<ayqb, ayqb>
{
  private String aBb;
  private final int aDT;
  private boolean aII;
  private final WeakReference<ayhm> dk;
  
  public ayqo()
  {
    this.aBb = null;
    this.aII = false;
    this.dk = null;
    this.aDT = -1;
  }
  
  public ayqo(String paramString, ayhm paramayhm, int paramInt)
  {
    this.aBb = paramString;
    this.aII = true;
    this.dk = new WeakReference(paramayhm);
    this.aDT = paramInt;
  }
  
  protected void a(JobContext paramJobContext, ayqb paramayqb)
  {
    ram.b("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "start generate thumb ... mVideoIndex = %d", Integer.valueOf(this.aDT));
    ayqj localayqj = paramayqb.a;
    int i = localayqj.mOrientation;
    if (this.dk != null) {
      paramJobContext = (ayhm)this.dk.get();
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
            str1 = ayqu.f(paramayqb.businessId, paramayqb.aAU, ".jpg");
          }
          i = new ayql(localBitmap, str1, localayqj.bsU, localayqj.bsV, i, localayqj.dw, localayqj.bo, localayqj.bp, paramayqb.businessId).a(new Void[0]).intValue();
          paramJobContext.s(localBitmap);
          if (i != 0) {
            break label217;
          }
          paramayqb.aAT = str1;
          paramayqb.g.thumbPath = str1;
          ram.w("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb success ...", new Object[] { Integer.valueOf(this.aDT) });
          super.notifyResult(paramayqb);
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
        super.notifyError(new ErrorMessage(-1, acfp.m(2131707343) + this.aDT));
      }
      else
      {
        ram.w("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb failed ... EditVideoPlayerExport generateVideoFrameBitmap return null", new Object[] { Integer.valueOf(this.aDT) });
        super.notifyError(new ErrorMessage(-1, acfp.m(2131707344) + this.aDT));
        return;
      }
    }
    ram.w("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb failed ... can not find EditVideoPlayerExport", new Object[] { Integer.valueOf(this.aDT) });
    super.notifyError(new ErrorMessage(-1, acfp.m(2131707335) + this.aDT));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayqo
 * JD-Core Version:    0.7.0.1
 */