import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class jps
{
  private static final String TAG = jps.class.getName();
  
  public static void a(String paramString, jps.a parama)
  {
    new jpt(parama, paramString).execute(new Void[0]);
  }
  
  public static String dQ(String paramString)
  {
    localStringBuffer = new StringBuffer();
    try
    {
      paramString = new BufferedReader(new InputStreamReader(((HttpURLConnection)new URL(paramString).openConnection()).getInputStream()));
      for (;;)
      {
        String str = paramString.readLine();
        if (str == null) {
          break;
        }
        localStringBuffer.append(str);
      }
      return localStringBuffer.toString();
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "http error");
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void ayW();
    
    public abstract void lc(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jps
 * JD-Core Version:    0.7.0.1
 */