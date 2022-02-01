package com.tencent.map.sdk.a;

import java.io.File;

final class oe$1
  implements oe.a
{
  public final File a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    paramString1 = new File(paramString2, paramString1);
    om.a(paramString1, paramArrayOfByte);
    return paramString1;
  }
  
  public final boolean a(File paramFile)
  {
    return om.b(paramFile);
  }
  
  public final byte[] a(String paramString, File paramFile)
  {
    return om.c(paramFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.oe.1
 * JD-Core Version:    0.7.0.1
 */