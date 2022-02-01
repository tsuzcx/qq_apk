package com.tencent.ad.tangram.protocol;

public final class gdt_abtest
{
  public static final class ABTest
  {
    public static final int ALL = 1;
    public static final int NONE = 0;
    public static final int UV_BY_UIN = 2;
    public LimitByUIN limitByUIN = new LimitByUIN();
    public int mode = 0;
    
    public static final class LimitByUIN
    {
      public String[] blackList;
      public String lower;
      public String upper;
      public String[] whiteList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.protocol.gdt_abtest
 * JD-Core Version:    0.7.0.1
 */