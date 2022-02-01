package com.tencent.qqmail.view;

import com.tencent.qqmail.utilities.exception.DevRuntimeException;
import java.util.ArrayList;
import java.util.List;

public class Suffix
{
  private static String entr;
  public static int len126 = 8;
  public static int len163;
  public static int lengmail = 10;
  public static int lenoutlook = 12;
  public static int lenqq = 7;
  private static List<String> suffixs = new ArrayList();
  
  static
  {
    len163 = 8;
  }
  
  public static List<String> get(String paramString)
  {
    if (!paramString.equals(entr)) {
      suffixs.clear();
    }
    if (suffixs.size() == 0)
    {
      entr = paramString;
      if (!entr.equals("qqmail")) {
        break label125;
      }
      suffixs.add("@qq.com");
      suffixs.add("qq.com");
      suffixs.add("q.com");
      suffixs.add(".com");
      suffixs.add("com");
      suffixs.add("om");
      suffixs.add("m");
    }
    for (;;)
    {
      return suffixs;
      label125:
      if (entr.equals("mail163"))
      {
        suffixs.add("@163.com");
        suffixs.add("163.com");
        suffixs.add("63.com");
        suffixs.add("3.com");
        suffixs.add(".com");
        suffixs.add("com");
        suffixs.add("om");
        suffixs.add("m");
      }
      else if (entr.equals("mail126"))
      {
        suffixs.add("@126.com");
        suffixs.add("126.com");
        suffixs.add("26.com");
        suffixs.add("6.com");
        suffixs.add(".com");
        suffixs.add("com");
        suffixs.add("om");
        suffixs.add("m");
      }
      else if (entr.equals("outlook"))
      {
        suffixs.add("@outlook.com");
        suffixs.add("outlook.com");
        suffixs.add("utlook.com");
        suffixs.add("tlook.com");
        suffixs.add("look.com");
        suffixs.add("ook.com");
        suffixs.add("ok.com");
        suffixs.add("k.com");
        suffixs.add(".com");
        suffixs.add("com");
        suffixs.add("om");
        suffixs.add("m");
      }
      else
      {
        if (!entr.equals("gmail")) {
          break;
        }
        suffixs.add("@gmail.com");
        suffixs.add("gmail.com");
        suffixs.add("mail.com");
        suffixs.add("ail.com");
        suffixs.add("il.com");
        suffixs.add("l.com");
        suffixs.add(".com");
        suffixs.add("com");
        suffixs.add("om");
        suffixs.add("m");
      }
    }
    throw new DevRuntimeException("entrance not valid");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.Suffix
 * JD-Core Version:    0.7.0.1
 */