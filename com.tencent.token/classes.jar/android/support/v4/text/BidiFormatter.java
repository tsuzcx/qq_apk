package android.support.v4.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;

public final class BidiFormatter
{
  private static final int DEFAULT_FLAGS = 2;
  private static final BidiFormatter DEFAULT_LTR_INSTANCE = new BidiFormatter(false, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
  private static final BidiFormatter DEFAULT_RTL_INSTANCE = new BidiFormatter(true, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
  private static TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
  private static final int DIR_LTR = -1;
  private static final int DIR_RTL = 1;
  private static final int DIR_UNKNOWN = 0;
  private static final String EMPTY_STRING = "";
  private static final int FLAG_STEREO_RESET = 2;
  private static final char LRE = '‪';
  private static final char LRM = '‎';
  private static final String LRM_STRING = Character.toString('‎');
  private static final char PDF = '‬';
  private static final char RLE = '‫';
  private static final char RLM = '‏';
  private static final String RLM_STRING = Character.toString('‏');
  private final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
  private final int mFlags;
  private final boolean mIsRtlContext;
  
  private BidiFormatter(boolean paramBoolean, int paramInt, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    this.mIsRtlContext = paramBoolean;
    this.mFlags = paramInt;
    this.mDefaultTextDirectionHeuristicCompat = paramTextDirectionHeuristicCompat;
  }
  
  private static int getEntryDir(CharSequence paramCharSequence)
  {
    return new BidiFormatter.DirectionalityEstimator(paramCharSequence, false).getEntryDir();
  }
  
  private static int getExitDir(CharSequence paramCharSequence)
  {
    return new BidiFormatter.DirectionalityEstimator(paramCharSequence, false).getExitDir();
  }
  
  public static BidiFormatter getInstance()
  {
    return new BidiFormatter.Builder().build();
  }
  
  public static BidiFormatter getInstance(Locale paramLocale)
  {
    return new BidiFormatter.Builder(paramLocale).build();
  }
  
  public static BidiFormatter getInstance(boolean paramBoolean)
  {
    return new BidiFormatter.Builder(paramBoolean).build();
  }
  
  private static boolean isRtlLocale(Locale paramLocale)
  {
    return TextUtilsCompat.getLayoutDirectionFromLocale(paramLocale) == 1;
  }
  
  private String markAfter(CharSequence paramCharSequence, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    boolean bool = paramTextDirectionHeuristicCompat.isRtl(paramCharSequence, 0, paramCharSequence.length());
    if ((!this.mIsRtlContext) && ((bool) || (getExitDir(paramCharSequence) == 1))) {
      return LRM_STRING;
    }
    if ((this.mIsRtlContext) && ((!bool) || (getExitDir(paramCharSequence) == -1))) {
      return RLM_STRING;
    }
    return "";
  }
  
  private String markBefore(CharSequence paramCharSequence, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    boolean bool = paramTextDirectionHeuristicCompat.isRtl(paramCharSequence, 0, paramCharSequence.length());
    if ((!this.mIsRtlContext) && ((bool) || (getEntryDir(paramCharSequence) == 1))) {
      return LRM_STRING;
    }
    if ((this.mIsRtlContext) && ((!bool) || (getEntryDir(paramCharSequence) == -1))) {
      return RLM_STRING;
    }
    return "";
  }
  
  public boolean getStereoReset()
  {
    return (this.mFlags & 0x2) != 0;
  }
  
  public boolean isRtl(CharSequence paramCharSequence)
  {
    return this.mDefaultTextDirectionHeuristicCompat.isRtl(paramCharSequence, 0, paramCharSequence.length());
  }
  
  public boolean isRtl(String paramString)
  {
    return isRtl(paramString);
  }
  
  public boolean isRtlContext()
  {
    return this.mIsRtlContext;
  }
  
  public CharSequence unicodeWrap(CharSequence paramCharSequence)
  {
    return unicodeWrap(paramCharSequence, this.mDefaultTextDirectionHeuristicCompat, true);
  }
  
  public CharSequence unicodeWrap(CharSequence paramCharSequence, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    return unicodeWrap(paramCharSequence, paramTextDirectionHeuristicCompat, true);
  }
  
  public CharSequence unicodeWrap(CharSequence paramCharSequence, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat, boolean paramBoolean)
  {
    if (paramCharSequence == null) {
      return null;
    }
    boolean bool = paramTextDirectionHeuristicCompat.isRtl(paramCharSequence, 0, paramCharSequence.length());
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((getStereoReset()) && (paramBoolean))
    {
      if (bool)
      {
        paramTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.RTL;
        localSpannableStringBuilder.append(markBefore(paramCharSequence, paramTextDirectionHeuristicCompat));
      }
    }
    else
    {
      if (bool == this.mIsRtlContext) {
        break label149;
      }
      if (!bool) {
        break label141;
      }
      int i = 8235;
      label82:
      localSpannableStringBuilder.append(i);
      localSpannableStringBuilder.append(paramCharSequence);
      localSpannableStringBuilder.append('‬');
      label106:
      if (paramBoolean) {
        if (!bool) {
          break label159;
        }
      }
    }
    label141:
    label149:
    label159:
    for (paramTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.RTL;; paramTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.LTR)
    {
      localSpannableStringBuilder.append(markAfter(paramCharSequence, paramTextDirectionHeuristicCompat));
      return localSpannableStringBuilder;
      paramTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.LTR;
      break;
      int j = 8234;
      break label82;
      localSpannableStringBuilder.append(paramCharSequence);
      break label106;
    }
  }
  
  public CharSequence unicodeWrap(CharSequence paramCharSequence, boolean paramBoolean)
  {
    return unicodeWrap(paramCharSequence, this.mDefaultTextDirectionHeuristicCompat, paramBoolean);
  }
  
  public String unicodeWrap(String paramString)
  {
    return unicodeWrap(paramString, this.mDefaultTextDirectionHeuristicCompat, true);
  }
  
  public String unicodeWrap(String paramString, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    return unicodeWrap(paramString, paramTextDirectionHeuristicCompat, true);
  }
  
  public String unicodeWrap(String paramString, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat, boolean paramBoolean)
  {
    if (paramString == null) {
      return null;
    }
    return unicodeWrap(paramString, paramTextDirectionHeuristicCompat, paramBoolean).toString();
  }
  
  public String unicodeWrap(String paramString, boolean paramBoolean)
  {
    return unicodeWrap(paramString, this.mDefaultTextDirectionHeuristicCompat, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.text.BidiFormatter
 * JD-Core Version:    0.7.0.1
 */