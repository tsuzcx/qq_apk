import com.tencent.qphone.base.util.QLog;

public class ilb
{
  public static void anM()
  {
    report("0X8009850");
  }
  
  public static void anN()
  {
    report("0X8009851");
  }
  
  static void report(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("VoiceRecogReport", 1, "report, key[" + paramString + "]");
    }
    anot.a(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ilb
 * JD-Core Version:    0.7.0.1
 */