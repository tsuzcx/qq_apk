package com.tencent.qqmail.marcos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonMatch
{
  public static final String CGI_REX = "((^http(s?)://[\\w\\.]*mail.qq.com/+cgi-bin/+)|(^/cgi-bin/+))";
  public static final Pattern PROTOCOL_PATTERN = Pattern.compile("^cid:", 2);
  public static final Pattern QQMAIL_CGI_PATTERN = Pattern.compile("((^http(s?)://[\\w\\.]*mail.qq.com/+cgi-bin/+)|(^/cgi-bin/+))", 2);
  public static final Pattern QQMAIL_FTN_CGI_PATTERN = Pattern.compile("((^http(s?)://[\\w\\.]*mail.qq.com/+cgi-bin/+)|(^/cgi-bin/+))ftn_handler", 2);
  public static final Pattern QQMAIL_NOTE_CDN_PATTERN = Pattern.compile("^http(s?)://[\\w\\.]*.qlogo.cn/+qqmail_head/+", 2);
  
  public static String findCgiName(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return "";
    }
    if (Pattern.compile("((^http(s?)://[\\w\\.]*mail.qq.com/+cgi-bin/+)|(^/cgi-bin/+))").matcher(paramString).find())
    {
      paramString = Pattern.compile("cgi-bin/+(.*?)([?/]|$)").matcher(paramString);
      if (paramString.find()) {
        return paramString.group(1);
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.marcos.CommonMatch
 * JD-Core Version:    0.7.0.1
 */