import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aejn
{
  public int cNu;
  
  public static aejn a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aejn localaejn = new aejn();
        localaejn.cNu = new JSONObject(paramString).optInt("kDeviceManageShowMuteKey", 0);
        QLog.d("DeviceManageConfProcessor", 2, "confBean = " + localaejn.toString());
        return localaejn;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("DeviceManageConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append("kDeviceManageShowMuteKey:").append(this.cNu);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aejn
 * JD-Core Version:    0.7.0.1
 */