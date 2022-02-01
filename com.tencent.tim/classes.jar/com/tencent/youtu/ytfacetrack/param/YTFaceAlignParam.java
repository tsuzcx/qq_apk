package com.tencent.youtu.ytfacetrack.param;

public class YTFaceAlignParam
{
  public int net_fix_config;
  public int refine_config;
  
  public static class NETFIXCONFIG
  {
    public static int FIX_EYE;
    public static int FIX_EYEBROW;
    public static int FIX_EYEBROW_MOUTH = 6;
    public static int FIX_EYE_EYEBROW;
    public static int FIX_EYE_EYEBROW_MOUTH = 7;
    public static int FIX_EYE_MOUTH;
    public static int FIX_MOUTH;
    public static int FIX_NONE = 0;
    
    static
    {
      FIX_EYE = 1;
      FIX_EYEBROW = 2;
      FIX_EYE_EYEBROW = 3;
      FIX_MOUTH = 4;
      FIX_EYE_MOUTH = 5;
    }
  }
  
  public static class REFINE
  {
    public static int REFINE_CONFIG_ALL = 8198;
    public static int REFINE_CONFIG_EYEMOUTH = 8199;
    public static int REFINE_CONFIG_OFF = 8197;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtu.ytfacetrack.param.YTFaceAlignParam
 * JD-Core Version:    0.7.0.1
 */