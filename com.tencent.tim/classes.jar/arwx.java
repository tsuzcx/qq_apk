import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class arwx
{
  public static String aO(String paramString, int paramInt)
  {
    if (paramString == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    CharBuffer localCharBuffer = Charset.forName("UTF-16").decode(Charset.forName("UTF-16").encode(paramString));
    int k = localCharBuffer.length();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    if (paramInt < k)
    {
      if (Character.isHighSurrogate(localCharBuffer.charAt(paramInt)))
      {
        paramString = localCharBuffer.subSequence(paramInt, paramInt + 2).toString();
        paramInt += 2;
      }
      for (;;)
      {
        j = fz(paramString);
        if (i < j) {
          break label139;
        }
        i -= j;
        localStringBuilder.append(paramString);
        break;
        paramString = localCharBuffer.subSequence(paramInt, paramInt + 1).toString();
        paramInt += 1;
      }
      label139:
      localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length());
      localStringBuilder.append("…");
    }
    return localStringBuilder.toString();
  }
  
  public static String d(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramString == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    CharBuffer localCharBuffer = Charset.forName("UTF-16").decode(Charset.forName("UTF-16").encode(paramString));
    int k = localCharBuffer.length();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    if (paramInt < k)
    {
      if (Character.isHighSurrogate(localCharBuffer.charAt(paramInt)))
      {
        paramString = localCharBuffer.subSequence(paramInt, paramInt + 2).toString();
        paramInt += 2;
      }
      for (;;)
      {
        j = fz(paramString);
        if (i < j) {
          break label148;
        }
        i -= j;
        localStringBuilder.append(paramString);
        break;
        paramString = localCharBuffer.subSequence(paramInt, paramInt + 1).toString();
        paramInt += 1;
      }
      label148:
      if ((!paramBoolean1) || (paramBoolean2)) {
        break label188;
      }
      localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length());
      localStringBuilder.append("…");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      label188:
      if ((paramBoolean1) && (paramBoolean2)) {
        localStringBuilder.append("…");
      }
    }
  }
  
  public static int fz(String paramString)
  {
    int j = 0;
    if (paramString == null) {
      return 0;
    }
    int i = 0;
    if (j < paramString.length())
    {
      if (g(paramString.charAt(j))) {
        i += 2;
      }
      for (;;)
      {
        j += 1;
        break;
        i += 1;
      }
    }
    return i;
  }
  
  protected static boolean g(char paramChar)
  {
    return (paramChar >= 'ÿ') || (paramChar < 0);
  }
  
  public static String h(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramString == null) {
      return "";
    }
    if (!paramBoolean) {
      return aO(paramString, paramInt);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    CharBuffer localCharBuffer = Charset.forName("UTF-16").decode(Charset.forName("UTF-16").encode(paramString));
    int k = localCharBuffer.length();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    if (paramInt < k)
    {
      if (Character.isHighSurrogate(localCharBuffer.charAt(paramInt)))
      {
        paramString = localCharBuffer.subSequence(paramInt, paramInt + 2).toString();
        paramInt += 2;
      }
      for (;;)
      {
        j = fz(paramString);
        if (i < j) {
          break label154;
        }
        i -= j;
        localStringBuilder.append(paramString);
        break;
        paramString = localCharBuffer.subSequence(paramInt, paramInt + 1).toString();
        paramInt += 1;
      }
      label154:
      localStringBuilder.append("…");
    }
    return localStringBuilder.toString();
  }
  
  public static boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() == 0);
  }
  
  public static String qA(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return paramString.replace("\\n", "\n").replace("&#92;", "\\").replace("&#39;", "'").replace("&quot;", "\"").replace("&gt;", ">").replace("&lt;", "<");
  }
  
  public static String qB(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return paramString.replace("%7D", "%257D").replace("%3A;", "%253A").replace("%2C';", "%252C").replace("}", "%7D").replace(":", "%3A").replace(",", "%2C");
  }
  
  public static String[] split(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString2.length() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int j;
    for (int i = 0;; i = paramString2.length() + j)
    {
      j = paramString1.indexOf(paramString2, i);
      if (j < 0)
      {
        localArrayList.add(paramString1.substring(i));
        i = localArrayList.size() - 1;
        while ((i >= 0) && (((String)localArrayList.get(i)).length() == 0))
        {
          localArrayList.remove(i);
          i -= 1;
        }
      }
      localArrayList.add(paramString1.substring(i, j));
    }
    return (String[])localArrayList.toArray(new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arwx
 * JD-Core Version:    0.7.0.1
 */