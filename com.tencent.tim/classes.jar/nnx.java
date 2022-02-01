import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class nnx
{
  private String amU = "utf-8";
  private boolean atE = true;
  private String mBaseUrl = "";
  private StringBuilder x;
  
  public nnx(String paramString)
  {
    this(paramString, "utf-8");
  }
  
  public nnx(String paramString1, String paramString2)
  {
    this.mBaseUrl = paramString1;
    this.amU = paramString2;
    aZF();
    this.x = new StringBuilder(this.mBaseUrl);
    this.atE = true;
  }
  
  private void aZF()
  {
    if (!this.mBaseUrl.endsWith("?")) {
      this.mBaseUrl += "?";
    }
  }
  
  public nnx a(String paramString1, String paramString2)
  {
    try
    {
      if (!this.atE) {
        this.x.append("&");
      }
      this.atE = false;
      this.x.append(paramString1);
      this.x.append("=");
      this.x.append(URLEncoder.encode(paramString2, this.amU));
      return this;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
    return this;
  }
  
  public String getUrl()
  {
    return this.x.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nnx
 * JD-Core Version:    0.7.0.1
 */