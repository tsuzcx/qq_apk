import android.text.TextUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import java.io.File;
import java.net.HttpURLConnection;

public class afka
{
  public final int action;
  public final String bDA;
  public String bDB = "";
  public String bDC;
  public String bDD;
  public String bDE;
  public String bDF;
  public String bDG;
  public boolean bYr;
  public int cRn = -1;
  public int cRo;
  public int cRp;
  public byte[] data;
  public HttpURLConnection e;
  public String errorDetail;
  public final File file;
  public String host;
  public String ip;
  public boolean isHttps;
  public String reqUrl;
  public int resultCode = -1;
  
  public afka(String paramString, File paramFile, int paramInt)
  {
    this.reqUrl = paramString;
    this.bDA = paramString;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(HttpDownloadUtil.PROTOCOL_HTTPS))) {
      this.isHttps = true;
    }
    this.file = paramFile;
    this.action = paramInt;
  }
  
  public void cZT()
  {
    this.reqUrl = this.bDA;
    this.bYr = false;
    this.host = null;
    this.errorDetail = "";
    this.data = null;
    this.cRn = -1;
    this.cRp = 0;
    this.bDD = null;
    this.bDE = null;
    this.bDC = null;
    this.bDG = null;
    this.bDF = null;
    this.ip = null;
    this.bYr = false;
  }
  
  public String uu()
  {
    return this.file.getAbsolutePath() + ".tmp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afka
 * JD-Core Version:    0.7.0.1
 */