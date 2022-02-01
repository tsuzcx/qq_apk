import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;

public final class afdf
{
  public static afdf.a a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = new afdf.a();
    aetx localaetx = aety.a();
    paramQQAppInterface.mEnable = localaetx.ahW();
    paramQQAppInterface.bBw = localaetx.getPlainContent();
    paramQQAppInterface.bDc = localaetx.ua();
    paramQQAppInterface.ctb = localaetx.Cy();
    paramQQAppInterface.bDd = localaetx.aL();
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocEntryUtils", 2, "getGrayTipsInfo " + paramQQAppInterface.toString());
    }
    return paramQQAppInterface;
  }
  
  public static Pair<Boolean, Integer> a(AppInterface paramAppInterface)
  {
    paramAppInterface = aetm.a();
    return new Pair(Boolean.valueOf(paramAppInterface.ahO()), Integer.valueOf(paramAppInterface.Cs()));
  }
  
  public static class a
  {
    public String bBw = "";
    public String bDc = "";
    public String bDd = "";
    public int ctb = 1;
    public boolean mEnable;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enable:").append(this.mEnable).append(",");
      localStringBuilder.append("mPlainContent:").append(this.bBw).append(",");
      localStringBuilder.append("mHighLightContent:").append(this.bDc).append(",");
      localStringBuilder.append("times:").append(this.ctb).append(",");
      localStringBuilder.append("mJumpLinkUrls:").append(this.bDd).append(",");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afdf
 * JD-Core Version:    0.7.0.1
 */