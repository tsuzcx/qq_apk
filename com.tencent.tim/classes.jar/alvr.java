import com.tencent.qphone.base.util.QLog;

public class alvr
{
  public static int d(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, "##" + paramString2);
    }
    return 0;
  }
  
  public static int e(String paramString1, String paramString2)
  {
    QLog.e(paramString1, 2, "##" + paramString2);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alvr
 * JD-Core Version:    0.7.0.1
 */