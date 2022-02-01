import android.content.Context;
import android.content.res.Resources;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

public class aopl
{
  private static aopk a;
  private static boolean cNO;
  
  public static String F(Context paramContext, String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = paramString.toLowerCase();
    }
    return a(paramContext).getMimeType(str);
  }
  
  private static aopk a(Context paramContext)
  {
    fm(paramContext);
    return a;
  }
  
  private static void fm(Context paramContext)
  {
    aopj localaopj;
    if (!cNO)
    {
      localaopj = new aopj();
      paramContext = paramContext.getResources().getXml(2131886089);
    }
    try
    {
      a = localaopj.a(paramContext);
      cNO = true;
      return;
    }
    catch (XmlPullParserException paramContext)
    {
      throw new RuntimeException("PreselectedChannelsActivity: XmlPullParserException");
    }
    catch (IOException paramContext)
    {
      throw new RuntimeException("PreselectedChannelsActivity: IOException");
    }
  }
  
  public static List<String> q(Context paramContext)
  {
    return a(paramContext).gw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aopl
 * JD-Core Version:    0.7.0.1
 */