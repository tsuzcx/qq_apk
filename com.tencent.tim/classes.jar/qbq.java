import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class qbq
  extends qdh
{
  private boolean aCL;
  private String mFeedId;
  private String mUrl;
  
  public qbq(String paramString1, String paramString2, boolean paramBoolean)
  {
    a(false, true);
    this.mUrl = paramString1;
    this.mFeedId = paramString2;
    this.aCL = paramBoolean;
  }
  
  protected void M(Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()) && (this.cb != null) && (!this.cb.isEmpty()))
    {
      if (paramMap.containsKey("EncryptUrlJob_shareUrl")) {
        this.mUrl = ((String)k("EncryptUrlJob_shareUrl"));
      }
      if (paramMap.containsKey("EncryptUrlJob_feedId")) {
        this.mFeedId = ((String)k("EncryptUrlJob_feedId"));
      }
    }
  }
  
  public void bnE()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EncryptUrlJob", 2, new Object[] { "encrypt url:", this.mUrl });
    }
    pzs localpzs = new pzs();
    localpzs.type = 1;
    String[] arrayOfString = this.mUrl.split("\\?");
    if (arrayOfString.length != 2)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EncryptUrlJob", 2, new Object[] { "Illegal url:", this.mUrl });
      }
      p("EncryptUrlJob_encryptedUrl", this.mUrl);
      sA(true);
      return;
    }
    localpzs.awo = arrayOfString[1];
    localpzs.feedId = this.mFeedId;
    ppv.a().a(localpzs, new qbr(this, arrayOfString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qbq
 * JD-Core Version:    0.7.0.1
 */