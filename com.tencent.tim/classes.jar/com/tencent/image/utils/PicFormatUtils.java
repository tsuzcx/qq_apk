package com.tencent.image.utils;

import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.io.IOException;

public class PicFormatUtils
{
  public static final String TAG = "URLDrawable.PicFormatUtils";
  private static final char[] digits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static String bytes2HexStr(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    char[] arrayOfChar;
    for (;;)
    {
      return null;
      arrayOfChar = new char[paramArrayOfByte.length * 2];
      int i = 0;
      try
      {
        while (i < paramArrayOfByte.length)
        {
          int j = paramArrayOfByte[i];
          arrayOfChar[(i * 2 + 1)] = digits[(j & 0xF)];
          j = (byte)(j >>> 4);
          arrayOfChar[(i * 2 + 0)] = digits[(j & 0xF)];
          i += 1;
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Exception paramArrayOfByte) {}
    }
    QLog.d("HexUtil", 2, " === bytes2HexStr error === " + paramArrayOfByte.toString());
    return null;
    return new String(arrayOfChar);
  }
  
  public static String getTypeByStream(FileInputStream paramFileInputStream)
  {
    Object localObject = new byte[8];
    try
    {
      paramFileInputStream.read((byte[])localObject, 0, localObject.length);
      localObject = bytes2HexStr((byte[])localObject).toUpperCase();
      if (((String)localObject).contains("FFD8FF"))
      {
        paramFileInputStream = "jpg";
        return paramFileInputStream;
      }
    }
    catch (IOException paramFileInputStream)
    {
      do
      {
        for (;;)
        {
          paramFileInputStream.printStackTrace();
        }
        if (((String)localObject).contains("89504E470D0A1A0A")) {
          return "png";
        }
        if (((String)localObject).contains("47494638")) {
          return "gif";
        }
        if (((String)localObject).contains("49492A00")) {
          return "tif";
        }
        if (((String)localObject).contains("424D")) {
          return "bmp";
        }
        if (((String)localObject).contains("0A")) {
          return "pcx";
        }
        if ((((String)localObject).contains("4D4D")) || (((String)localObject).contains("4949"))) {
          return "tiff";
        }
        if (((String)localObject).contains("464F524D")) {
          return "iff";
        }
        if (((String)localObject).contains("52494646")) {
          return "ani";
        }
        if (((String)localObject).contains("0000020000")) {
          return "tga";
        }
        if (((String)localObject).contains("0000100000")) {
          return "rle";
        }
        if (((String)localObject).contains("0000010001002020")) {
          return "ico";
        }
        paramFileInputStream = (FileInputStream)localObject;
      } while (!((String)localObject).contains("0000020001002020"));
    }
    return "cur";
  }
  
  public static boolean isJPEGImage(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new FileInputStream(paramString);
        boolean bool = "jpg".equals(getTypeByStream(paramString));
        if (bool) {
          bool = true;
        }
        bool = false;
      }
      catch (Exception paramString)
      {
        try
        {
          paramString.close();
          return bool;
        }
        catch (Exception paramString)
        {
          continue;
        }
        paramString = paramString;
        bool = false;
        QLog.e("URLDrawable.PicFormatUtils", 2, "isJPEGImage", paramString);
        return bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.image.utils.PicFormatUtils
 * JD-Core Version:    0.7.0.1
 */