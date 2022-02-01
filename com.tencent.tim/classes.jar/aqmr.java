import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class aqmr
{
  public static String ToDBC(String paramString)
  {
    paramString = paramString.toCharArray();
    int i = 0;
    if (i < paramString.length)
    {
      if (paramString[i] == '　') {
        paramString[i] = 32;
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramString[i] > 65280) && (paramString[i] < 65375)) {
          paramString[i] = ((char)(paramString[i] - 65248));
        }
      }
    }
    return new String(paramString);
  }
  
  public static String aL(String paramString, int paramInt)
    throws UnsupportedEncodingException
  {
    String str;
    if (paramString == null)
    {
      str = "";
      return str;
    }
    int i;
    if (paramString.length() < paramInt)
    {
      i = paramString.length();
      label24:
      str = paramString.substring(0, i);
      j = str.getBytes("UTF-8").length;
      i = paramInt;
      label43:
      if (j > paramInt)
      {
        i -= 1;
        if (paramString.length() >= i) {
          break label90;
        }
      }
    }
    label90:
    for (int j = paramString.length();; j = i)
    {
      str = paramString.substring(0, j);
      j = str.getBytes("UTF-8").length;
      break label43;
      break;
      i = paramInt;
      break label24;
    }
  }
  
  public static String byte2HexString(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      if (Integer.toHexString(paramArrayOfByte[i] & 0xFF).length() == 1) {
        localStringBuffer.append("0").append(Integer.toHexString(paramArrayOfByte[i] & 0xFF));
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuffer.append(Integer.toHexString(paramArrayOfByte[i] & 0xFF));
      }
    }
    return localStringBuffer.toString();
  }
  
  public static String crypticCenter(String paramString)
  {
    int i = 2;
    if ((paramString == null) || (paramString.length() < 2)) {
      return paramString;
    }
    int j = paramString.length() - 1;
    if (j == 1) {}
    for (;;)
    {
      paramString = new StringBuffer(paramString);
      paramString.replace(1, i, "*");
      return paramString.toString();
      i = j;
    }
  }
  
  public static String formatSize(long paramLong)
  {
    String str2 = "" + paramLong;
    String str1 = "";
    if ((paramLong >= 0L) && (paramLong < 1024L)) {
      str1 = str2 + "B";
    }
    do
    {
      return str1;
      if ((paramLong >= 1024L) && (paramLong < 1048576L)) {
        return Long.toString(paramLong / 1024L) + "KB";
      }
      if ((paramLong >= 1048576L) && (paramLong < 1073741824L)) {
        return Long.toString(paramLong / 1048576L) + "MB";
      }
    } while (paramLong < 1073741824L);
    return Long.toString(paramLong / 1073741824L) + "GB";
  }
  
  public static String getSimpleUinForPrint(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() <= 4)) {
      return paramString;
    }
    return substring(paramString, paramString.length() - 4, paramString.length());
  }
  
  public static int getWordCount(String paramString)
  {
    int j = 0;
    if (paramString == null) {
      return 0;
    }
    int i = 0;
    if (j < paramString.length())
    {
      int k = paramString.charAt(j);
      if ((k >= 0) && (k <= 255)) {
        i += 1;
      }
      for (;;)
      {
        j += 1;
        break;
        i += 2;
      }
    }
    return i;
  }
  
  public static int getWordCountNeo(String paramString)
  {
    int i = 0;
    int k = 0;
    if (paramString == null) {}
    int m;
    int j;
    do
    {
      return k;
      m = paramString.length();
      j = 0;
      k = i;
    } while (j >= m);
    k = paramString.codePointAt(j);
    if ((k >= 0) && (k <= 255)) {
      i += 1;
    }
    for (;;)
    {
      j += Character.charCount(k);
      break;
      i += 2;
    }
  }
  
  public static boolean isAsciiAlpha(char paramChar)
  {
    return ((paramChar >= 'A') && (paramChar <= 'Z')) || ((paramChar >= 'a') && (paramChar <= 'z'));
  }
  
  public static boolean isChinese(char paramChar)
  {
    Character.UnicodeBlock localUnicodeBlock = Character.UnicodeBlock.of(paramChar);
    return (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) || (localUnicodeBlock == Character.UnicodeBlock.GENERAL_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS);
  }
  
  public static boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static boolean isReadableChar(char paramChar)
  {
    return (!Character.isISOControl(paramChar)) || (Character.isLetterOrDigit(paramChar)) || (Character.isSpace(paramChar)) || (Character.isSpaceChar(paramChar));
  }
  
  public static boolean isValidMobileNumForHead(String paramString)
  {
    boolean bool = true;
    if ((paramString == null) || ("".equals(paramString.trim())) || (!paramString.trim().startsWith("+"))) {
      bool = false;
    }
    return bool;
  }
  
  public static boolean isValideUin(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString.trim()))) {}
    int j;
    do
    {
      return false;
      paramString = paramString.trim();
      j = paramString.length();
    } while (j < 5);
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label58;
      }
      if (!Character.isDigit(paramString.charAt(i))) {
        break;
      }
      i += 1;
    }
    label58:
    return true;
  }
  
  public static String listToString(List<? extends Object> paramList, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramList.size())
    {
      localStringBuffer.append(paramList.get(i).toString());
      localStringBuffer.append(paramString);
      i += 1;
    }
    localStringBuffer.delete(localStringBuffer.lastIndexOf(paramString), localStringBuffer.length());
    return localStringBuffer.toString();
  }
  
  public static String longToString(long paramLong)
  {
    BigInteger localBigInteger2 = BigInteger.valueOf(paramLong);
    BigInteger localBigInteger1 = localBigInteger2;
    if (localBigInteger2.signum() < 0) {
      localBigInteger1 = localBigInteger2.add(BigInteger.ONE.shiftLeft(64));
    }
    return localBigInteger1.toString();
  }
  
  public static String makeLogMsg(Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    int j = paramVarArgs.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = paramVarArgs[i];
      if (localObject != null) {}
      for (localObject = localObject.toString();; localObject = null)
      {
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" , ");
        i += 1;
        break;
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public static String[] split(String paramString, char paramChar)
  {
    if (paramString == null) {
      return null;
    }
    int m = paramString.length();
    if (m == 0) {
      return new String[] { paramString };
    }
    ArrayList localArrayList = new ArrayList(50);
    char[] arrayOfChar = paramString.toCharArray();
    int i = 0;
    int j = 0;
    int k = 0;
    while (j < m) {
      if (arrayOfChar[j] == paramChar)
      {
        localArrayList.add(paramString.substring(k, j));
        k = j + 1;
        j = k;
        i = 1;
      }
      else
      {
        j += 1;
        i = 0;
      }
    }
    if (i == 0) {
      localArrayList.add(paramString.substring(k, j));
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public static long stringToLong(String paramString1, String paramString2)
  {
    try
    {
      long l = Long.parseLong(paramString2);
      return l;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w(paramString1, 1, "stringToLong Exception, value[" + paramString2 + "]", localException);
      }
    }
    return 0L;
  }
  
  public static String substring(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      return null;
    }
    int j = 0;
    StringBuffer localStringBuffer = new StringBuffer(paramInt2);
    int i = paramInt1;
    paramInt1 = j;
    for (;;)
    {
      char c;
      if (i < paramString.length())
      {
        c = paramString.charAt(i);
        if ((c < 0) || (c > 'ÿ')) {
          break label67;
        }
        paramInt1 += 1;
      }
      while (paramInt1 > paramInt2)
      {
        return localStringBuffer.toString();
        label67:
        paramInt1 += 2;
      }
      localStringBuffer.append(c);
      i += 1;
    }
  }
  
  public static String substring(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    int j = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramInt1;
    paramInt1 = j;
    for (;;)
    {
      char c;
      if (i < paramString1.length())
      {
        c = paramString1.charAt(i);
        if ((c < 0) || (c > 'ÿ')) {
          break label76;
        }
        paramInt1 += 1;
      }
      while (paramInt1 > paramInt2)
      {
        localStringBuffer.append(paramString2);
        return localStringBuffer.toString();
        label76:
        paramInt1 += 2;
      }
      localStringBuffer.append(c);
      i += 1;
    }
  }
  
  public static String substring(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {}
    int i;
    int j;
    do
    {
      do
      {
        return null;
        i = paramString1.indexOf(paramString2);
      } while (i < 0);
      j = paramString1.indexOf(paramString3, paramString2.length() + i);
    } while (j < 0);
    return paramString1.substring(paramString2.length() + i, j);
  }
  
  public static String substringNeo(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer(paramInt2);
    for (;;)
    {
      char c;
      if (paramInt1 < paramString.length())
      {
        c = paramString.charAt(paramInt1);
        if (getWordCountNeo(localStringBuffer.toString() + c) <= paramInt2) {}
      }
      else
      {
        return localStringBuffer.toString();
      }
      localStringBuffer.append(c);
      paramInt1 += 1;
    }
  }
  
  public static String toHexString(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    paramString = paramString.getBytes();
    int i = 0;
    while (i < paramString.length)
    {
      localStringBuffer.append(Integer.toHexString(new Integer(paramString[i] & 0xFF).intValue())).append(" ");
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String toNoSpaceHexString(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    paramString = paramString.getBytes();
    int i = 0;
    while (i < paramString.length)
    {
      localStringBuffer.append(Integer.toHexString(new Integer(paramString[i] & 0xFF).intValue()));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String toSemiAngleString(String paramString)
  {
    paramString = paramString.toCharArray();
    int i = 0;
    if (i < paramString.length)
    {
      if (paramString[i] == '　') {
        paramString[i] = 32;
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramString[i] > 65280) && (paramString[i] < 65375)) {
          paramString[i] = ((char)(paramString[i] - 65248));
        }
      }
    }
    return String.valueOf(paramString);
  }
  
  public static String trim(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return paramString;
    }
    paramString = new StringBuffer(paramString);
    while ((paramString.length() > 0) && ((Character.isWhitespace(paramString.charAt(0))) || (paramString.charAt(0) == 0))) {
      paramString.deleteCharAt(0);
    }
    for (int i = paramString.length(); (i > 0) && ((Character.isWhitespace(paramString.charAt(i - 1))) || (paramString.charAt(0) == 0)); i = paramString.length()) {
      paramString.deleteCharAt(i - 1);
    }
    return paramString.toString();
  }
  
  public static String trimUnreadableInFriendRequest(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    int j = 0;
    int k = 1;
    int i = 0;
    if (i < paramString.length())
    {
      int n;
      if (k != 0)
      {
        n = j;
        m = k;
        if (isReadableChar(paramString.charAt(i)))
        {
          n = i;
          m = 0;
        }
      }
      do
      {
        do
        {
          i += 1;
          j = n;
          k = m;
          break;
          n = j;
          m = k;
        } while (!isReadableChar(paramString.charAt(i)));
        m = i;
        if (paramString.length() - 1 == i) {
          break label113;
        }
        n = j;
        m = k;
      } while (isReadableChar(paramString.charAt(i + 1)));
    }
    for (int m = i;; m = 0)
    {
      label113:
      if (j < m + 1) {
        if (m + 1 < paramString.length()) {
          i = m + 1;
        }
      }
      for (paramString = paramString.substring(j, i);; paramString = "")
      {
        return paramString;
        i = paramString.length();
        break;
      }
    }
  }
  
  public static boolean verifyUin(String paramString)
  {
    boolean bool = false;
    try
    {
      long l = Long.valueOf(Long.parseLong(paramString)).longValue();
      if (l > 10000L) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqmr
 * JD-Core Version:    0.7.0.1
 */