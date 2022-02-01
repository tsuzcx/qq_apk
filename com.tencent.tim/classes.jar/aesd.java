import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aesd
{
  private int cOE = 1;
  private int cOF = 1;
  private int cOG = 1;
  public int cOH = 2;
  public int cOI = 1;
  public int cOJ = 1;
  
  @NonNull
  public static aesd a()
  {
    return new aesd();
  }
  
  @NonNull
  public static aesd a(@Nullable String paramString)
  {
    aesd localaesd = new aesd();
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        localaesd.cOH = paramString.optInt("kingcard", localaesd.cOH);
        localaesd.cOE = paramString.optInt("gldrawable", localaesd.cOE);
        localaesd.cOI = paramString.optInt("webso_preload", localaesd.cOI);
        localaesd.cOJ = paramString.optInt("webso_screenshot", localaesd.cOJ);
        localaesd.cOF = paramString.optInt("etcdrawable", localaesd.cOF);
        localaesd.cOG = paramString.optInt("gldrawableEtcApng", localaesd.cOG);
      }
      if (QLog.isColorLevel()) {
        QLog.e("QVIP.SDK.ConfigProcessor", 1, " : " + localaesd.toString());
      }
      return localaesd;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("QVIP.SDK.ConfigProcessor", 1, "json parse error:" + paramString);
      }
    }
  }
  
  public boolean ahv()
  {
    return this.cOE > 0;
  }
  
  public boolean ahw()
  {
    return this.cOF > 0;
  }
  
  public boolean ahx()
  {
    return this.cOG > 0;
  }
  
  public String toString()
  {
    return "QVipSDKConfig{kingCard=" + this.cOH + ", gldrawable=" + this.cOE + ", webso_preload=" + this.cOI + ", webso_screenshot=" + this.cOJ + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aesd
 * JD-Core Version:    0.7.0.1
 */