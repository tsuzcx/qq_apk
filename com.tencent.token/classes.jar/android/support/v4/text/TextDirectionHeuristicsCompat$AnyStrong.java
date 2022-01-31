package android.support.v4.text;

class TextDirectionHeuristicsCompat$AnyStrong
  implements TextDirectionHeuristicsCompat.TextDirectionAlgorithm
{
  static final AnyStrong INSTANCE_LTR = new AnyStrong(false);
  static final AnyStrong INSTANCE_RTL = new AnyStrong(true);
  private final boolean mLookForRtl;
  
  private TextDirectionHeuristicsCompat$AnyStrong(boolean paramBoolean)
  {
    this.mLookForRtl = paramBoolean;
  }
  
  public int checkRtl(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int k = 1;
    int j = 0;
    int m;
    for (int i = paramInt1;; i = m)
    {
      m = i;
      if (m >= paramInt1 + paramInt2) {
        break;
      }
      switch (TextDirectionHeuristicsCompat.isRtlText(Character.getDirectionality(paramCharSequence.charAt(m))))
      {
      default: 
        i = j;
        m += 1;
        j = i;
      }
    }
    if (this.mLookForRtl) {
      i = 0;
    }
    do
    {
      do
      {
        return i;
        i = 1;
        break;
        i = k;
      } while (!this.mLookForRtl);
      i = 1;
      break;
      if (j == 0) {
        break label131;
      }
      i = k;
    } while (this.mLookForRtl);
    return 0;
    label131:
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.text.TextDirectionHeuristicsCompat.AnyStrong
 * JD-Core Version:    0.7.0.1
 */