import cooperation.qzone.util.UrlKeyGenerator;

public class fof
  extends UrlKeyGenerator
{
  public String b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i;
    if (UrlKeyGenerator.a(paramString, "http://"))
    {
      i = paramString.indexOf("/", "http://".length());
      int j = paramString.indexOf(".mp4?") - 4;
      if (i == -1) {
        break label102;
      }
      if (j == -1) {
        break label91;
      }
      paramString = paramString.substring(i + 1, j);
    }
    for (;;)
    {
      return paramString;
      if (UrlKeyGenerator.a(paramString, "https://"))
      {
        i = paramString.indexOf("/", "https://".length());
        break;
      }
      i = paramString.indexOf("/");
      break;
      label91:
      paramString = paramString.substring(i + 1);
      continue;
      label102:
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fof
 * JD-Core Version:    0.7.0.1
 */