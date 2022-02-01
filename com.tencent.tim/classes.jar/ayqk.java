import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.io.File;
import java.lang.ref.WeakReference;

public class ayqk
  extends ayqr<ayqb, ayqb>
{
  private String aBb;
  private final int aDT;
  private boolean aII;
  private boolean dAs;
  private final WeakReference<ayhm> dk;
  
  public ayqk()
  {
    this.aBb = null;
    this.aII = false;
    this.dk = null;
    this.aDT = -1;
    this.dAs = true;
  }
  
  public ayqk(String paramString, ayhm paramayhm, int paramInt)
  {
    this.aBb = paramString;
    this.aII = true;
    this.dk = new WeakReference(paramayhm);
    this.aDT = paramInt;
    this.dAs = false;
  }
  
  private void a(ayqb paramayqb, boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString))) {}
    for (File localFile = new File(paramString);; localFile = null)
    {
      Object localObject2;
      int i;
      if ((paramBoolean) && (localFile != null) && (localFile.exists()) && (localFile.isFile()) && (localFile.length() > 0L))
      {
        localObject2 = this.aBb;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = ayqu.f(paramayqb.businessId, paramayqb.aAU, ".jpg");
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = new File((String)localObject1);
          if (localFile.renameTo((File)localObject2))
          {
            ram.w("Q.qqstory.publish.edit.GenerateThumbSegment", "copy thumb file to upload dir success : %s", new Object[] { ((File)localObject2).getPath() });
            paramayqb.aAT = ((String)localObject1);
            paramayqb.g.thumbPath = ((String)localObject1);
            i = 1;
          }
        }
      }
      while (i != 0)
      {
        ram.d("Q.qqstory.publish.edit.GenerateThumbSegment", "generate thumb success ...");
        super.notifyResult(paramayqb);
        return;
        if (this.aBb == null)
        {
          ram.w("Q.qqstory.publish.edit.GenerateThumbSegment", "copy failed : use the origin instead : origin %s, target %s", new Object[] { localFile.getPath(), ((File)localObject2).getPath() });
          paramayqb.aAT = paramString;
          paramayqb.g.thumbPath = paramString;
          i = 1;
        }
        else
        {
          ram.w("Q.qqstory.publish.edit.GenerateThumbSegment", "copy thumb file to upload dir failed : origin %s, target %s", new Object[] { localFile.getPath(), ((File)localObject2).getPath() });
          i = 0;
          continue;
          paramayqb.aAT = paramString;
          paramayqb.g.thumbPath = paramString;
          i = 1;
          continue;
          i = 0;
        }
      }
      ram.d("Q.qqstory.publish.edit.GenerateThumbSegment", "generate thumb failed ...");
      super.notifyError(new ErrorMessage(-1, "GenerateThumbTask error"));
      return;
    }
  }
  
  protected void a(JobContext paramJobContext, ayqb paramayqb)
  {
    ram.b("Q.qqstory.publish.edit.GenerateThumbSegment", "start generate thumb ... mVideoIndex = %d", Integer.valueOf(this.aDT));
    ayqj localayqj = paramayqb.a;
    int i = localayqj.mOrientation;
    if (paramayqb.businessId == 1) {
      i = 0;
    }
    if (this.dAs)
    {
      paramJobContext = new ayql(localayqj.bsU, localayqj.bsV, localayqj.mFileDir, localayqj.dw, localayqj.aIH, i, localayqj.bo, localayqj.bp, localayqj.aBa, paramayqb.businessId, localayqj.aGI);
      if (paramJobContext.a(new Void[0]).intValue() == 0) {}
      for (boolean bool = true;; bool = false)
      {
        a(paramayqb, bool, paramJobContext.bN);
        return;
      }
    }
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
            break label327;
          }
          paramayqb.aAT = str1;
          paramayqb.g.thumbPath = str1;
          ram.w("Q.qqstory.publish.edit.GenerateThumbSegment", "generate %d thumb success ...", new Object[] { Integer.valueOf(this.aDT) });
          super.notifyResult(paramayqb);
          return;
        }
        finally
        {
          paramJobContext.s(localBitmap);
        }
        paramJobContext = null;
        continue;
        label327:
        ram.w("Q.qqstory.publish.edit.GenerateThumbSegment", "generate %d thumb failed ...", new Object[] { Integer.valueOf(this.aDT) });
        super.notifyError(new ErrorMessage(-1, acfp.m(2131706945) + this.aDT));
      }
      else
      {
        ram.w("Q.qqstory.publish.edit.GenerateThumbSegment", "generate %d thumb failed ... EditVideoPlayerExport generateVideoFrameBitmap return null", new Object[] { Integer.valueOf(this.aDT) });
        super.notifyError(new ErrorMessage(-1, acfp.m(2131706947) + this.aDT));
        return;
      }
    }
    ram.w("Q.qqstory.publish.edit.GenerateThumbSegment", "generate %d thumb failed ... can not find EditVideoPlayerExport", new Object[] { Integer.valueOf(this.aDT) });
    super.notifyError(new ErrorMessage(-1, acfp.m(2131706944) + this.aDT));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayqk
 * JD-Core Version:    0.7.0.1
 */