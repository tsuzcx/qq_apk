package com.tencent.biz.webviewplugin;

import java.io.FileInputStream;
import java.io.IOException;

public class MyFileInputStream
  extends FileInputStream
{
  public MyFileInputStream(String paramString)
  {
    super(paramString);
  }
  
  public void close()
  {
    try
    {
      super.close();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.MyFileInputStream
 * JD-Core Version:    0.7.0.1
 */