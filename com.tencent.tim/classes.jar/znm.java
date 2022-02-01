import com.tencent.qphone.base.util.QLog;

public class znm
{
  public static void report(String paramString)
  {
    report(paramString, "");
  }
  
  public static void report(String paramString1, String paramString2)
  {
    report(paramString1, paramString2, "");
  }
  
  public static void report(String paramString1, String paramString2, String paramString3)
  {
    anot.a(null, "dc00898", "", "", paramString1, paramString1, 0, 0, paramString2, paramString3, "", "");
    if (QLog.isColorLevel()) {
      QLog.d(zos.TAG + ".report", 2, "tag=" + paramString1 + ",extra1=" + paramString2 + ",extra2=" + paramString3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     znm
 * JD-Core Version:    0.7.0.1
 */