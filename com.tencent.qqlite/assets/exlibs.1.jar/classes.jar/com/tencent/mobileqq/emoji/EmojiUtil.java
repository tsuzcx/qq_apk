package com.tencent.mobileqq.emoji;

import android.content.Context;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EmojiUtil
{
  public static final String a = "Emoji.EmojiUtil";
  public static final String b = ".zip";
  public static final String c = "userEmojiSharedPreferences";
  public static final String d = "emojiDownloaded";
  
  public static int a(Context paramContext)
  {
    paramContext = new File(a(paramContext));
    if ((paramContext.exists()) && (paramContext.isDirectory())) {
      return paramContext.list().length;
    }
    return 0;
  }
  
  public static String a()
  {
    String str = AppConstants.bw;
    return str + "emoji2" + ".zip";
  }
  
  public static String a(Context paramContext)
  {
    if (Utils.f()) {}
    for (paramContext = AppConstants.bx;; paramContext = paramContext.getDir("qqlite_emoji", 0).getAbsolutePath()) {
      return paramContext + File.separator;
    }
  }
  
  private static String a(String paramString)
  {
    return FileUtils.a(paramString, "MD5");
  }
  
  public static boolean a()
  {
    boolean bool = false;
    Object localObject = AppConstants.bw;
    localObject = new File((String)localObject + "emoji2.zip.tmp");
    if (((File)localObject).exists()) {
      if (((File)localObject).isFile()) {
        bool = true;
      }
    }
    while (!QLog.isColorLevel()) {
      return bool;
    }
    QLog.d("Emoji.EmojiUtil", 2, "emojiZipFile not exist.");
    return false;
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool2 = false;
    Object localObject = AppConstants.bw;
    String str = (String)localObject + "emoji2.zip";
    localObject = new File(str);
    boolean bool1;
    if (((File)localObject).exists())
    {
      bool1 = bool2;
      if (((File)localObject).isFile())
      {
        str = a(str);
        bool1 = bool2;
        if (((File)localObject).length() == paramInt)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Emoji.EmojiUtil", 4, "emojiZipFile already exists.");
          }
          bool1 = bool2;
          if ("81d66de31020082c016f1de52864e1fb".equals(str)) {
            bool1 = true;
          }
        }
      }
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("Emoji.EmojiUtil", 2, "emojiZipFile not exist.");
    return false;
  }
  
  public static boolean a(File paramFile)
  {
    int i = 0;
    boolean bool = false;
    if (paramFile.isFile()) {
      bool = paramFile.delete();
    }
    while (!paramFile.isDirectory()) {
      return bool;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if ((arrayOfFile == null) || (arrayOfFile.length == 0)) {
      return paramFile.delete();
    }
    while (i < arrayOfFile.length)
    {
      a(arrayOfFile[i]);
      i += 1;
    }
    return paramFile.delete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoji.EmojiUtil
 * JD-Core Version:    0.7.0.1
 */