package com.tencent.mobileqq.activity.photo;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class MimeHelper
{
  public static final String a = "image";
  public static final String b = "image/jpeg";
  public static final String c = "image/gif";
  public static final String d = "image/bmp";
  public static final String e = "image/png";
  public static final String f = "jpg";
  public static final String g = "jpeg";
  public static final String h = "gif";
  public static final String i = "bmp";
  public static final String j = "png";
  public static final String k = "video";
  public static final String l = "video/mp4";
  public static final String m = "mobileqq";
  private static final String n = "MimeHelper";
  
  public static boolean a(String paramString)
  {
    return ("jpg".equals(paramString)) || ("gif".equals(paramString)) || ("png".equals(paramString)) || ("bmp".equals(paramString)) || ("jpeg".equals(paramString));
  }
  
  public static String[] a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String[] arrayOfString;
    do
    {
      return null;
      arrayOfString = paramString.split("/");
      if (arrayOfString.length == 2) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("MimeHelper", 2, "Mimetype error:" + paramString);
    return null;
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.MimeHelper
 * JD-Core Version:    0.7.0.1
 */