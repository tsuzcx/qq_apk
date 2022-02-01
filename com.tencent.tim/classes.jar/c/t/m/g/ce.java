package c.t.m.g;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ce
{
  public static final Pattern a;
  public static final Pattern b;
  public static final Pattern c = Pattern.compile("[A-Z0-9]{12}");
  
  static
  {
    Pattern localPattern = Pattern.compile("[0-9a-zA-Z+-]*");
    a = localPattern;
    b = localPattern;
  }
  
  public static String a(String paramString, Pattern paramPattern)
  {
    String str = paramString;
    if (!paramPattern.matcher(paramString).matches()) {
      str = "";
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.ce
 * JD-Core Version:    0.7.0.1
 */