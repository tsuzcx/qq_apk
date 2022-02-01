package com.tencent.util;

import com.tencent.ttpic.model.SizeI;

public class TextureInfo
{
  private final SizeI size;
  private final String stackTrace;
  
  public TextureInfo()
  {
    this(null, null);
  }
  
  public TextureInfo(SizeI paramSizeI, String paramString)
  {
    SizeI localSizeI = paramSizeI;
    if (paramSizeI == null) {
      localSizeI = new SizeI(0, 0);
    }
    paramSizeI = paramString;
    if (paramString == null) {
      paramSizeI = "";
    }
    this.size = localSizeI;
    this.stackTrace = paramSizeI;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof TextureInfo)) {
        paramObject = (TextureInfo)paramObject;
      }
    }
    else {
      return (this.size.equals(paramObject.size)) && (this.stackTrace.equals(paramObject.stackTrace));
    }
    return false;
  }
  
  public SizeI getSize()
  {
    return this.size;
  }
  
  public String getStackTrace()
  {
    return this.stackTrace;
  }
  
  public int hashCode()
  {
    int j = 0;
    Object localObject = this.size;
    if (localObject != null) {}
    for (int i = ((SizeI)localObject).hashCode();; i = 0)
    {
      localObject = this.stackTrace;
      if (localObject != null) {
        j = ((String)localObject).hashCode();
      }
      return i * 31 + j;
    }
  }
  
  public String toString()
  {
    return "TextureInfo(size=" + this.size + ", stackTrace=" + this.stackTrace + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.util.TextureInfo
 * JD-Core Version:    0.7.0.1
 */