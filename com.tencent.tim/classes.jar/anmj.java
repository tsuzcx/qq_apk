import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class anmj
{
  public long amg = -1L;
  public String ceI;
  public String ceJ;
  public String mSoPath;
  public String mUrl;
  
  public anmj() {}
  
  public anmj(String paramString)
  {
    this.mSoPath = paramString;
  }
  
  public anmj(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4)
  {
    this.ceI = paramString1;
    this.ceJ = paramString2;
    this.mSoPath = paramString3;
    this.amg = paramLong;
    this.mUrl = paramString4;
  }
  
  public static anmj a(String paramString)
  {
    anmj localanmj = new anmj();
    try
    {
      paramString = Uri.parse(paramString);
      localanmj.ceI = paramString.getQueryParameter("ver");
      localanmj.ceJ = paramString.getQueryParameter("name");
      localanmj.mSoPath = paramString.getQueryParameter("path");
      localanmj.amg = aJ(paramString.getQueryParameter("crc"));
      localanmj.mUrl = paramString.getQueryParameter("url");
      return localanmj;
    }
    catch (Throwable paramString)
    {
      QLog.e("SoLoadWidget.SoLocalInfo", 1, paramString, new Object[0]);
    }
    return localanmj;
  }
  
  private static long aJ(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        long l = Long.parseLong(paramString);
        return l;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("SoLoadWidget.SoLocalInfo", 1, paramString, new Object[0]);
    }
    return -1L;
  }
  
  public String encode()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?").append("ver=").append(this.ceI).append("&name=").append(this.ceJ).append("&path=").append(aagd.fG(this.mSoPath)).append("&crc=").append(this.amg).append("&url=").append(aagd.fG(this.mUrl));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anmj
 * JD-Core Version:    0.7.0.1
 */