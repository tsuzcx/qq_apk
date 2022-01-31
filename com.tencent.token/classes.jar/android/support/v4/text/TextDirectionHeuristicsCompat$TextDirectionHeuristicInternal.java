package android.support.v4.text;

class TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal
  extends TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
{
  private final boolean mDefaultIsRtl;
  
  TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal(TextDirectionHeuristicsCompat.TextDirectionAlgorithm paramTextDirectionAlgorithm, boolean paramBoolean)
  {
    super(paramTextDirectionAlgorithm);
    this.mDefaultIsRtl = paramBoolean;
  }
  
  protected boolean defaultIsRtl()
  {
    return this.mDefaultIsRtl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal
 * JD-Core Version:    0.7.0.1
 */