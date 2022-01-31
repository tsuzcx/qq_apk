import cooperation.qzone.util.UrlKeyGenerator;

public class idi
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
      int j = paramString.lastIndexOf("#");
      if (i == -1) {
        break label96;
      }
      if (j == -1) {
        break label87;
      }
      paramString = paramString.substring(i, j);
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
      label87:
      paramString = paramString.substring(i);
      continue;
      label96:
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     idi
 * JD-Core Version:    0.7.0.1
 */