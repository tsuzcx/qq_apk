package com.tencent.av.opengl.filter.qqavimage;

import com.tencent.av.video.effect.core.qqavimage.QQAVImageEffectFilterConstants.QQAVEFFECT;

public class QQAVImageFilterConstants
{
  public static int getFilterType(int paramInt)
  {
    if (paramInt == 9) {
      return 1;
    }
    if ((paramInt == 1006) || (paramInt == 1016) || (paramInt == 1007) || (paramInt == 1008) || (paramInt == 1009) || (paramInt == 1010) || (paramInt == 1011) || (paramInt == 1012) || (paramInt == 1013) || (paramInt == 1014) || (paramInt == 1015)) {
      return 2;
    }
    if (paramInt == 10) {
      return 3;
    }
    if ((paramInt == 1017) || (paramInt == 1018)) {
      return 4;
    }
    if (paramInt == 12) {
      return 5;
    }
    return 0;
  }
  
  public static boolean isMusicSpecialFilter(int paramInt)
  {
    return (paramInt == 1013) || (paramInt == 1014) || (paramInt == 1017);
  }
  
  public static boolean isNormalFilterSpecialCases(int paramInt, String paramString)
  {
    return (getFilterType(paramInt) == 0) && (paramString.equals("MANHUA"));
  }
  
  public static abstract interface FilterEffect
    extends QQAVImageEffectFilterConstants.QQAVEFFECT
  {
    public static final int QQAVARTFILTER = 9;
    public static final int QQAVBLUR = 1008;
    public static final int QQAVBOX = 1015;
    public static final int QQAVBULGEDISTORTION = 1007;
    public static final int QQAVDANCEGAME = 10;
    public static final int QQAVGHOST = 1010;
    public static final int QQAVKALEIDOSCOPE = 1009;
    public static final int QQAVMIRROR = 1006;
    public static final int QQAVMIRROR_VERTICAL = 1016;
    public static final int QQAVOLDTV = 1012;
    public static final int QQAVSHAKE = 1013;
    public static final int QQAVSOUL = 1014;
    public static final int QQAVWRONGERASE = 1011;
    public static final int QQFILM = 1018;
    public static final int QQMTV1 = 1017;
    public static final int QQPTUCOLORFILTER = 12;
  }
  
  public static abstract interface QQAVEFFECT_TYPE
  {
    public static final int ART_FILTER = 1;
    public static final int DANCE_GAME_FILTER = 3;
    public static final int MTV_FILTER = 4;
    public static final int NORMAL_FILTER = 0;
    public static final int PTU_COLOR_FILTER = 5;
    public static final int SPECIAL_FILTER = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants
 * JD-Core Version:    0.7.0.1
 */