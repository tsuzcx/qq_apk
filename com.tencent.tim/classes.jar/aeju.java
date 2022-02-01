import com.tencent.qphone.base.util.QLog;

public class aeju
{
  public String byc = "";
  
  public static aeju a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aeju localaeju = new aeju();
        localaeju.byc = paramString;
        QLog.d("ConfBean", 2, "confBean = " + localaeju.toString());
        return localaeju;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("ConfBean", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("configContent:").append(this.byc);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeju
 * JD-Core Version:    0.7.0.1
 */