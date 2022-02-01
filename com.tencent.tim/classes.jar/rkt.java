import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.io.File;
import java.lang.ref.WeakReference;

public class rkt
  extends rkz<rkm, rkm>
{
  private String aBb;
  private final int aDT;
  private boolean aII;
  private final WeakReference<rdo> dk;
  
  public rkt()
  {
    this.aBb = null;
    this.aII = false;
    this.dk = null;
    this.aDT = -1;
  }
  
  public rkt(String paramString, rdo paramrdo, int paramInt)
  {
    this.aBb = paramString;
    this.aII = true;
    this.dk = new WeakReference(paramrdo);
    this.aDT = paramInt;
  }
  
  private void a(rkm paramrkm, boolean paramBoolean, String paramString)
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
          localObject1 = rlc.f(paramrkm.businessId, paramrkm.aAU, ".jpg");
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = new File((String)localObject1);
          if (localFile.renameTo((File)localObject2))
          {
            ram.w("Q.qqstory.publish.edit.GenerateThumbSegment", "copy thumb file to upload dir success : %s", new Object[] { ((File)localObject2).getPath() });
            paramrkm.aAT = ((String)localObject1);
            paramrkm.g.thumbPath = ((String)localObject1);
            i = 1;
          }
        }
      }
      while (i != 0)
      {
        ram.d("Q.qqstory.publish.edit.GenerateThumbSegment", "generate thumb success ...");
        super.notifyResult(paramrkm);
        return;
        if (this.aBb == null)
        {
          ram.w("Q.qqstory.publish.edit.GenerateThumbSegment", "copy failed : use the origin instead : origin %s, target %s", new Object[] { localFile.getPath(), ((File)localObject2).getPath() });
          paramrkm.aAT = paramString;
          paramrkm.g.thumbPath = paramString;
          i = 1;
        }
        else
        {
          ram.w("Q.qqstory.publish.edit.GenerateThumbSegment", "copy thumb file to upload dir failed : origin %s, target %s", new Object[] { localFile.getPath(), ((File)localObject2).getPath() });
          i = 0;
          continue;
          paramrkm.aAT = paramString;
          paramrkm.g.thumbPath = paramString;
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
  
  protected void a(JobContext paramJobContext, rkm paramrkm)
  {
    ram.b("Q.qqstory.publish.edit.GenerateThumbSegment", "start generate thumb ... mVideoIndex = %d", Integer.valueOf(this.aDT));
    rks localrks = paramrkm.a;
    int i = localrks.mOrientation;
    if (paramrkm.businessId == 1) {
      i = 0;
    }
    if (!this.aII)
    {
      paramJobContext = new rku(localrks.bsU, localrks.bsV, localrks.mFileDir, localrks.dw, localrks.aIH, i, localrks.bo, localrks.bp, localrks.aBa, paramrkm.businessId, localrks.aGI);
      if (paramJobContext.a(new Void[0]).intValue() == 0) {}
      for (boolean bool = true;; bool = false)
      {
        a(paramrkm, bool, paramJobContext.bN);
        return;
      }
    }
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
            break label327;
          }
          paramrkm.aAT = str1;
          paramrkm.g.thumbPath = str1;
          ram.w("Q.qqstory.publish.edit.GenerateThumbSegment", "generate %d thumb success ...", new Object[] { Integer.valueOf(this.aDT) });
          super.notifyResult(paramrkm);
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
        super.notifyError(new ErrorMessage(-1, acfp.m(2131706943) + this.aDT));
      }
      else
      {
        ram.w("Q.qqstory.publish.edit.GenerateThumbSegment", "generate %d thumb failed ... EditVideoPlayerExport generateVideoFrameBitmap return null", new Object[] { Integer.valueOf(this.aDT) });
        super.notifyError(new ErrorMessage(-1, acfp.m(2131706942) + this.aDT));
        return;
      }
    }
    ram.w("Q.qqstory.publish.edit.GenerateThumbSegment", "generate %d thumb failed ... can not find EditVideoPlayerExport", new Object[] { Integer.valueOf(this.aDT) });
    super.notifyError(new ErrorMessage(-1, acfp.m(2131706946) + this.aDT));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rkt
 * JD-Core Version:    0.7.0.1
 */