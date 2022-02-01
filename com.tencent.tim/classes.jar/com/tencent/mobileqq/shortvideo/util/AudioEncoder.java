package com.tencent.mobileqq.shortvideo.util;

import aniq;
import java.io.File;

public class AudioEncoder
{
  public static int a(a parama)
  {
    try
    {
      int i = encode(parama.cey, parama.cez, parama.dIG, parama.dIH, parama.bitrate, parama.sample_rate, parama.dII);
      return i;
    }
    catch (UnsatisfiedLinkError parama) {}
    return -200;
  }
  
  public static a a(String paramString1, String paramString2, int paramInt)
  {
    a locala = new a();
    locala.cey = paramString1;
    locala.cez = paramString2;
    locala.dIG = paramInt;
    locala.sample_rate = aniq.bth;
    locala.bitrate = aniq.dHj;
    if (aniq.mAudioFormat == 2) {}
    for (locala.dIH = 16; aniq.ckG == 16; locala.dIH = 8)
    {
      locala.dII = 1;
      return locala;
    }
    locala.dII = 2;
    return locala;
  }
  
  public static int el(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return -201;
    }
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return -202;
    }
    if (paramString.length() <= 0L) {
      return -203;
    }
    return 0;
  }
  
  private static native int encode(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public static class a
  {
    public int bitrate;
    public String cey;
    public String cez;
    public int dIG;
    public int dIH;
    public int dII;
    public int sample_rate;
    public float zO = 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.AudioEncoder
 * JD-Core Version:    0.7.0.1
 */