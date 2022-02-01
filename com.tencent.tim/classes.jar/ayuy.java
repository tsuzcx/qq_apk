import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.Properties;

public class ayuy
{
  private static int cjC = 10000;
  
  public static void c(String paramString, Properties paramProperties)
  {
    Properties localProperties = paramProperties;
    if (paramProperties == null) {
      localProperties = new Properties();
    }
    localProperties.setProperty("shortvideo_business_type", "" + cjC);
    anol.a(VideoEnvironment.getContext()).reportKVEvent(paramString, localProperties);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayuy
 * JD-Core Version:    0.7.0.1
 */