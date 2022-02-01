public class kxk
{
  private static String[][] c;
  
  static
  {
    String[] arrayOfString1 = { "&lt;", "<" };
    String[] arrayOfString2 = { "&gt;", ">" };
    String[] arrayOfString3 = { "&amp;", "&" };
    String[] arrayOfString4 = { "&quot;", "\"" };
    String[] arrayOfString5 = { "&Auml;", "Ä" };
    String[] arrayOfString6 = { "&Acirc;", "Â" };
    String[] arrayOfString7 = { "&aring;", "å" };
    String[] arrayOfString8 = { "&Aring;", "Å" };
    String[] arrayOfString9 = { "&aelig;", "æ" };
    String[] arrayOfString10 = { "&AElig;", "Æ" };
    String[] arrayOfString11 = { "&ccedil;", "ç" };
    String[] arrayOfString12 = { "&Ccedil;", "Ç" };
    String[] arrayOfString13 = { "&eacute;", "é" };
    String[] arrayOfString14 = { "&Eacute;", "É" };
    String[] arrayOfString15 = { "&egrave;", "è" };
    String[] arrayOfString16 = { "&Egrave;", "È" };
    String[] arrayOfString17 = { "&ecirc;", "ê" };
    String[] arrayOfString18 = { "&Ecirc;", "Ê" };
    String[] arrayOfString19 = { "&euml;", "ë" };
    String[] arrayOfString20 = { "&iuml;", "ï" };
    String[] arrayOfString21 = { "&Iuml;", "Ï" };
    String[] arrayOfString22 = { "&ocirc;", "ô" };
    String[] arrayOfString23 = { "&Ocirc;", "Ô" };
    String[] arrayOfString24 = { "&ouml;", "ö" };
    String[] arrayOfString25 = { "&Ouml;", "Ö" };
    String[] arrayOfString26 = { "&oslash;", "ø" };
    String[] arrayOfString27 = { "&Oslash;", "Ø" };
    String[] arrayOfString28 = { "&szlig;", "ß" };
    String[] arrayOfString29 = { "&ugrave;", "ù" };
    String[] arrayOfString30 = { "&ucirc;", "û" };
    String[] arrayOfString31 = { "&uuml;", "ü" };
    String[] arrayOfString32 = { "&Uuml;", "Ü" };
    String[] arrayOfString33 = { "&nbsp;", " " };
    String[] arrayOfString34 = { "&reg;", "®" };
    c = new String[][] { arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4, { "&agrave;", "à" }, { "&Agrave;", "À" }, { "&acirc;", "â" }, { "&auml;", "ä" }, arrayOfString5, arrayOfString6, arrayOfString7, arrayOfString8, arrayOfString9, arrayOfString10, arrayOfString11, arrayOfString12, arrayOfString13, arrayOfString14, arrayOfString15, arrayOfString16, arrayOfString17, arrayOfString18, arrayOfString19, { "&Euml;", "Ë" }, arrayOfString20, arrayOfString21, arrayOfString22, arrayOfString23, arrayOfString24, arrayOfString25, arrayOfString26, arrayOfString27, arrayOfString28, arrayOfString29, { "&Ugrave;", "Ù" }, arrayOfString30, { "&Ucirc;", "Û" }, arrayOfString31, arrayOfString32, arrayOfString33, { "&copy;", "©" }, arrayOfString34, { "&euro;", "₠" } };
  }
  
  public static String D(String paramString, int paramInt)
  {
    int i = paramString.indexOf("&", paramInt);
    String str = paramString;
    int j;
    if (i > -1)
    {
      j = paramString.indexOf(";", i);
      str = paramString;
      if (j > i)
      {
        str = paramString.substring(i, j + 1);
        paramInt = 0;
      }
    }
    for (;;)
    {
      if ((paramInt >= c.length) || (c[paramInt][0].equals(str)))
      {
        str = paramString;
        if (paramInt < c.length) {
          str = D(paramString.substring(0, i) + c[paramInt][1] + paramString.substring(j + 1), i);
        }
        return str;
      }
      paramInt += 1;
    }
  }
  
  public static String a(String paramString1, String paramString2, char paramChar)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString2.isEmpty())) {
      return paramString1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int k = paramString1.length();
    paramString1 = paramString1.toCharArray();
    int i = 0;
    if (i < k) {
      if (k - i >= paramString2.length())
      {
        j = 0;
        label59:
        if (j >= paramString2.length()) {
          break label153;
        }
        if (paramString1[(i + j)] == paramString2.charAt(j)) {}
      }
    }
    label153:
    for (int j = 0;; j = 1)
    {
      if (j != 0)
      {
        localStringBuilder.append(paramChar);
        i = paramString2.length() - 1 + i;
        i += 1;
        break;
        j += 1;
        break label59;
      }
      localStringBuilder.append(paramString1[i]);
      for (;;)
      {
        break;
        localStringBuilder.append(paramString1[i]);
      }
      return localStringBuilder.toString();
    }
  }
  
  public static String er(String paramString)
  {
    return D(paramString, 0);
  }
  
  public static String es(String paramString)
  {
    int i = paramString.length();
    while ((i < 0) && (paramString.charAt(i - 1) <= ' ')) {
      i -= 1;
    }
    String str = paramString;
    if (i < paramString.length()) {
      str = paramString.substring(0, i);
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kxk
 * JD-Core Version:    0.7.0.1
 */