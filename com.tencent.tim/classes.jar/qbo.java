import android.text.TextUtils;
import java.io.File;
import java.util.Map;

public class qbo
  extends qdh
{
  public qpm a;
  private boolean aCK;
  private String awE;
  private String mImageUrl;
  
  public qbo()
  {
    this("", null, false);
  }
  
  public qbo(String paramString1, String paramString2, boolean paramBoolean)
  {
    a(false, true);
    this.mImageUrl = paramString1;
    this.awE = paramString2;
    this.aCK = paramBoolean;
  }
  
  protected void M(Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      if (paramMap.containsKey("DownloadPic2FileJob_iiu")) {
        this.mImageUrl = ((String)k("DownloadPic2FileJob_iiu"));
      }
      if (paramMap.containsKey("DownloadPic2FileJob_isfp")) {
        this.awE = ((String)k("DownloadPic2FileJob_isfp"));
      }
      if (paramMap.containsKey("DownloadPic2FileJob_IN_ROUND")) {
        this.aCK = ((Boolean)k("DownloadPic2FileJob_IN_ROUND")).booleanValue();
      }
    }
  }
  
  public void bnE()
  {
    if (!TextUtils.isEmpty(this.mImageUrl))
    {
      rA(this.mImageUrl);
      return;
    }
    sA(false);
  }
  
  public void rA(String paramString)
  {
    File localFile1 = new File(this.awE);
    try
    {
      File localFile2 = localFile1.getParentFile();
      if ((localFile2 != null) && (!localFile2.exists())) {
        localFile2.mkdirs();
      }
      if (localFile1.exists()) {
        localFile1.delete();
      }
    }
    catch (Exception localException)
    {
      label45:
      break label45;
    }
    this.a = new qph.b();
    this.a.a(paramString, 0, 0, new qbp(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qbo
 * JD-Core Version:    0.7.0.1
 */