import cooperation.qzone.util.UrlKeyGenerator;

public class iib
  extends UrlKeyGenerator
{
  public String b(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return null;
      paramString = paramString.toLowerCase();
      int i;
      if (paramString.startsWith("http://")) {
        i = paramString.indexOf("/", "http://".length());
      }
      while (i != -1)
      {
        return paramString.substring(i);
        if (paramString.startsWith("https://")) {
          i = paramString.indexOf("/", "https://".length());
        } else {
          i = paramString.indexOf("/");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     iib
 * JD-Core Version:    0.7.0.1
 */