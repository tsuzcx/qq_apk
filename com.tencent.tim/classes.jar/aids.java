import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.intervideo.huayang.Monitor.1;

public class aids
{
  public static boolean ckd = true;
  
  public static void Lb(String paramString)
  {
    if (ckd) {
      report(paramString);
    }
  }
  
  public static void report(String paramString)
  {
    ThreadManager.executeOnNetWorkThread(new Monitor.1("https://cgi.pub.qq.com/report/report_vm?monitors=[$ID$]&t=$TIMESTAMP$".replace("$ID$", paramString).replace("$TIMESTAMP$", String.valueOf(System.currentTimeMillis()))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aids
 * JD-Core Version:    0.7.0.1
 */