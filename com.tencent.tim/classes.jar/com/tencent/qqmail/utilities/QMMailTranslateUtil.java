package com.tencent.qqmail.utilities;

import android.text.TextUtils;

public class QMMailTranslateUtil
{
  private static final String[] INVALID_TAG_ARRA = { "link", "script", "style" };
  
  public static String addCSSAndJSForTranslate(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n<style type=\"text/css\">\nmailTTag {\ndisplay: span;\n}\n.mailAppOrigin {display:none;}\n.mailTranslated {display:inline;}\n.origin .mailAppOrigin {display:inline;}\n.origin .mailTranslated {display:none;}\n</style>\n\n");
    localStringBuilder.append(paramString);
    localStringBuilder.append("<script src=\"file:///android_asset/mail/js/translate.js\"></script>");
    return localStringBuilder.toString();
  }
  
  public static String combineTranslatedContent(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return paramString1;
    }
    paramString1 = paramString1.replaceAll("<!--[\\s\\S]+?-->", "");
    paramString1 = "<mailTTag >" + paramString1 + "</mailTTag>";
    paramString2 = "<mailTTag >" + paramString2 + "</mailTTag>";
    int j = 0;
    int i = 0;
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("\n<style type=\"text/css\">\nmailTTag {\ndisplay: span;\n}\n.mailAppOrigin {display:none;}\n.mailTranslated {display:inline;}\n.origin .mailAppOrigin {display:inline;}\n.origin .mailTranslated {display:none;}\n</style>\n\n");
    StringBuilder localStringBuilder2 = new StringBuilder();
    StringBuilder localStringBuilder3 = new StringBuilder();
    StringBuilder localStringBuilder4 = new StringBuilder();
    StringBuilder localStringBuilder5 = new StringBuilder();
    int k = 0;
    for (;;)
    {
      if ((j >= paramString1.length()) || (i >= paramString2.length()))
      {
        localStringBuilder1.append("<script src=\"file:///android_asset/mail/js/translate.js\"></script>");
        return localStringBuilder1.toString();
      }
      localStringBuilder4.setLength(0);
      localStringBuilder5.setLength(0);
      int m = 0;
      if (j >= paramString1.length())
      {
        label191:
        localStringBuilder1.append(localStringBuilder4);
        label199:
        if (i < paramString2.length()) {
          break label364;
        }
        label207:
        localStringBuilder2.setLength(0);
        m = 0;
        label216:
        if (j < paramString1.length()) {
          break label391;
        }
        label225:
        localStringBuilder3.setLength(0);
      }
      for (;;)
      {
        if (i >= paramString2.length()) {}
        char c;
        label346:
        label364:
        do
        {
          if ((!isInvalidTag(localStringBuilder5.toString())) && (m != 0)) {
            break label482;
          }
          localStringBuilder1.append(localStringBuilder2);
          break;
          int n = j + 1;
          c = paramString1.charAt(j);
          localStringBuilder4.append(c);
          if (c == '>')
          {
            j = n;
            break label191;
          }
          j = m;
          if (c != '<')
          {
            if (c == ' ') {
              break label346;
            }
            j = m;
            if (m == 0)
            {
              localStringBuilder5.append(c);
              j = m;
            }
          }
          for (;;)
          {
            m = j;
            j = n;
            break;
            j = m;
            if (localStringBuilder5.length() > 0) {
              j = 1;
            }
          }
          m = i + 1;
          if (paramString2.charAt(i) == '>')
          {
            i = m;
            break label207;
          }
          i = m;
          break label199;
          c = paramString1.charAt(j);
          if (c == '<') {
            break label225;
          }
          n = m;
          if (m == 0)
          {
            n = m;
            if (c != ' ')
            {
              n = m;
              if (c != '\n') {
                n = 1;
              }
            }
          }
          j += 1;
          localStringBuilder2.append(c);
          m = n;
          break label216;
          c = paramString2.charAt(i);
        } while (c == '<');
        label391:
        i += 1;
        localStringBuilder3.append(c);
      }
      label482:
      String str1 = localStringBuilder2.toString();
      String str2 = localStringBuilder3.toString();
      k += 1;
      localStringBuilder1.append(spanWithOriginTextAndTranslatedText(str1, str2, k));
    }
  }
  
  private static boolean isInvalidTag(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = INVALID_TAG_ARRA;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramString.equals(arrayOfString[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private static String spanWithOriginTextAndTranslatedText(String paramString1, String paramString2, int paramInt)
  {
    return String.format("<mailTTag class=\"mailAppOrigin\" mailAppTag=\"mt%d\">%s</mailTTag><mailTTag class=\"mailTranslated\" mailAppTag=\"mt%d\">%s</mailTTag>", new Object[] { Integer.valueOf(paramInt), paramString1, Integer.valueOf(paramInt), paramString2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.QMMailTranslateUtil
 * JD-Core Version:    0.7.0.1
 */