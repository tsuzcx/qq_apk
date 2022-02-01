import com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel;
import java.io.File;

public class aqxu
{
  public static final int edz = ListenChangeVoicePanel.hm.length;
  
  public static String aM(String paramString, int paramInt)
  {
    int i = paramString.lastIndexOf(".");
    return paramString.substring(0, i).concat("_" + paramInt).concat(paramString.substring(i, paramString.length()));
  }
  
  public static void ac(String paramString1, String paramString2, int paramInt)
  {
    String str = null;
    new File(paramString1).delete();
    new File(paramString2).delete();
    int i = 0;
    paramString2 = str;
    if (i < edz)
    {
      str = aM(paramString1, i);
      if (i == paramInt) {
        paramString2 = str;
      }
      for (;;)
      {
        i += 1;
        break;
        new File(str).delete();
      }
    }
    if (paramString2 != null) {
      new File(paramString2).renameTo(new File(paramString1));
    }
  }
  
  public static void iw(String paramString1, String paramString2)
  {
    new File(paramString1).delete();
    new File(paramString2).delete();
    int i = 0;
    while (i < edz)
    {
      new File(aM(paramString1, i)).delete();
      i += 1;
    }
  }
  
  public static void ix(String paramString1, String paramString2)
  {
    new File(paramString1).deleteOnExit();
    new File(paramString2).deleteOnExit();
    int i = 0;
    while (i < edz)
    {
      new File(aM(paramString1, i)).deleteOnExit();
      i += 1;
    }
  }
  
  public static String pW(String paramString)
  {
    String str = paramString.substring(0, paramString.lastIndexOf(".")).concat(".pcm");
    new File(paramString).renameTo(new File(str));
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqxu
 * JD-Core Version:    0.7.0.1
 */