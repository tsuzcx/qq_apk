package com.tencent.qqmail.utilities;

import com.tencent.qqmail.trd.jchardet.nsDetector;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class FileCharsetDetector
{
  private String encoding = null;
  private boolean found = false;
  
  private String guestFileEncoding(File paramFile, nsDetector paramnsDetector)
    throws FileNotFoundException, IOException
  {
    paramnsDetector.Init(new FileCharsetDetector.1(this));
    paramFile = new BufferedInputStream(new FileInputStream(paramFile));
    byte[] arrayOfByte = new byte[1024];
    boolean bool2 = true;
    boolean bool1 = false;
    for (;;)
    {
      int i = paramFile.read(arrayOfByte, 0, arrayOfByte.length);
      if (i == -1) {
        break;
      }
      boolean bool3 = bool2;
      if (bool2) {
        bool3 = paramnsDetector.isAscii(arrayOfByte, i);
      }
      bool2 = bool3;
      if (!bool3)
      {
        bool2 = bool3;
        if (!bool1)
        {
          bool1 = paramnsDetector.DoIt(arrayOfByte, i, false);
          bool2 = bool3;
        }
      }
    }
    paramnsDetector.DataEnd();
    paramFile.close();
    if (bool2)
    {
      this.encoding = "ASCII";
      this.found = true;
    }
    if (!this.found)
    {
      paramFile = paramnsDetector.getProbableCharsets();
      if (paramFile.length > 0) {
        this.encoding = paramFile[0];
      }
    }
    else
    {
      return this.encoding;
    }
    return null;
  }
  
  private String guestFileEncoding(String paramString, nsDetector paramnsDetector)
    throws FileNotFoundException, IOException
  {
    paramnsDetector.Init(new FileCharsetDetector.2(this));
    paramString = new BufferedInputStream(new ByteArrayInputStream(paramString.getBytes()));
    byte[] arrayOfByte = new byte[1024];
    boolean bool2 = true;
    boolean bool1 = false;
    for (;;)
    {
      int i = paramString.read(arrayOfByte, 0, arrayOfByte.length);
      if (i == -1) {
        break;
      }
      boolean bool3 = bool2;
      if (bool2) {
        bool3 = paramnsDetector.isAscii(arrayOfByte, i);
      }
      bool2 = bool3;
      if (!bool3)
      {
        bool2 = bool3;
        if (!bool1)
        {
          bool1 = paramnsDetector.DoIt(arrayOfByte, i, false);
          bool2 = bool3;
        }
      }
    }
    paramnsDetector.DataEnd();
    paramString.close();
    if (bool2)
    {
      this.encoding = "ASCII";
      this.found = true;
    }
    if (!this.found)
    {
      paramString = paramnsDetector.getProbableCharsets();
      if (paramString.length > 0) {
        this.encoding = paramString[0];
      }
    }
    else
    {
      return this.encoding;
    }
    return null;
  }
  
  public static void main(String[] paramArrayOfString)
    throws Exception
  {
    paramArrayOfString = new FileCharsetDetector().guestFileEncoding("d:/b.txt", true);
    System.out.println("文件编码:" + paramArrayOfString);
  }
  
  public String guestFileEncoding(File paramFile)
    throws FileNotFoundException, IOException
  {
    return guestFileEncoding(paramFile, new nsDetector());
  }
  
  public String guestFileEncoding(String paramString, boolean paramBoolean)
    throws FileNotFoundException, IOException
  {
    if (paramBoolean) {
      return guestFileEncoding(new File(paramString));
    }
    return guestFileEncoding(paramString, new nsDetector());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.FileCharsetDetector
 * JD-Core Version:    0.7.0.1
 */