package com.tencent.mobileqq.soload;

import aagd;
import anmb;
import java.io.Serializable;

public class LoadOptions
  implements Serializable
{
  public boolean isDownloadOnly = false;
  public boolean isLoadLastSuccWhenFail = false;
  String oldSoPathFor32Bit;
  String oldSoPathFor64Bit;
  
  public String getOldSoPath()
  {
    if (anmb.is64Bit()) {
      return this.oldSoPathFor64Bit;
    }
    return this.oldSoPathFor32Bit;
  }
  
  public boolean isSame(LoadOptions paramLoadOptions)
  {
    if (paramLoadOptions == null) {}
    while ((this.isLoadLastSuccWhenFail != paramLoadOptions.isLoadLastSuccWhenFail) || (!aagd.j(this.oldSoPathFor32Bit, paramLoadOptions.oldSoPathFor32Bit)) || (!aagd.j(this.oldSoPathFor64Bit, paramLoadOptions.oldSoPathFor64Bit))) {
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    return "LoadOptions{isLoadLastSuccWhenFail=" + this.isLoadLastSuccWhenFail + ", old32Bit='" + this.oldSoPathFor32Bit + '\'' + ", old64Bit='" + this.oldSoPathFor64Bit + '\'' + '}';
  }
  
  public static class a
  {
    private LoadOptions a = new LoadOptions();
    
    public a a(boolean paramBoolean)
    {
      this.a.isDownloadOnly = paramBoolean;
      return this;
    }
    
    public LoadOptions a()
    {
      return this.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.soload.LoadOptions
 * JD-Core Version:    0.7.0.1
 */