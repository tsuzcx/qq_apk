import android.text.TextUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class jqn
{
  public static final String a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      paramString2 = "";
      return paramString2;
    }
    if (!TextUtils.isEmpty(paramString2)) {}
    for (String str = paramString2;; str = "UTF-8")
    {
      paramString2 = paramString1;
      if (j(paramString1, str) <= paramInt) {
        break;
      }
      int i = 0;
      int j = 0;
      for (;;)
      {
        paramString2 = paramString1;
        if (i >= paramString1.length()) {
          break;
        }
        int k = j(paramString1.substring(i, i + 1), str);
        if (j + k > paramInt)
        {
          paramString2 = paramString1.substring(0, i);
          paramString1 = paramString2;
          if (!TextUtils.isEmpty(paramString3)) {
            paramString1 = paramString2 + paramString3;
          }
          return paramString1;
        }
        j += k;
        i += 1;
      }
    }
  }
  
  public static int aC(String paramString)
  {
    int j = 0;
    if (paramString == null) {
      return 0;
    }
    paramString = paramString.toCharArray();
    int i = 0;
    while (j < paramString.length)
    {
      int k = i + 1;
      i = k;
      if (!isLetter(paramString[j])) {
        i = k + 1;
      }
      j += 1;
    }
    return i;
  }
  
  public static String b(byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    if (paramArrayOfByte == null) {}
    int j;
    do
    {
      return null;
      int i = paramInt - 1;
      j = 0;
      while ((i >= 0) && (paramArrayOfByte[i] < 0))
      {
        j += 1;
        i -= 1;
      }
      if (j % 3 == 0) {
        return new String(paramArrayOfByte, 0, paramInt, "utf-8");
      }
      if (j % 3 == 1) {
        return new String(paramArrayOfByte, 0, paramInt - 1, "utf-8");
      }
    } while (j % 3 != 2);
    return new String(paramArrayOfByte, 0, paramInt - 2, "utf-8");
  }
  
  public static String c(String paramString1, int paramInt, String paramString2)
  {
    if (aC(paramString1) < paramInt) {
      return paramString1;
    }
    return y(paramString1, paramInt) + paramString2;
  }
  
  public static boolean isLetter(char paramChar)
  {
    return paramChar / '' == 0;
  }
  
  public static final int j(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return 0;
    }
    if (!TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      try
      {
        int i = paramString1.getBytes(paramString2).length;
        return i;
      }
      catch (UnsupportedEncodingException paramString2)
      {
        return paramString1.length() * 3;
      }
      paramString2 = "UTF-8";
    }
  }
  
  public static String y(String paramString, int paramInt)
  {
    int k = 0;
    for (;;)
    {
      int i;
      int j;
      try
      {
        paramString = paramString.getBytes("Unicode");
        i = 2;
        if ((i >= paramString.length) || (k >= paramInt)) {
          break label92;
        }
        if (i % 2 != 1) {
          break label75;
        }
        j = k + 1;
      }
      catch (UnsupportedEncodingException paramString)
      {
        return "";
      }
      paramString = new String(paramString, 0, paramInt, "Unicode");
      return paramString;
      paramInt = i + 1;
      continue;
      for (;;)
      {
        i += 1;
        k = j;
        break;
        label75:
        j = k;
        if (paramString[i] != 0) {
          j = k + 1;
        }
      }
      label92:
      paramInt = i;
      if (i % 2 == 1) {
        if (paramString[(i - 1)] != 0) {
          paramInt = i - 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jqn
 * JD-Core Version:    0.7.0.1
 */