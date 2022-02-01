public class kpo
  extends aofr
{
  public kpo(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    super(paramCharSequence, paramInt1, paramInt2);
  }
  
  public int nz()
  {
    int j = 0;
    aofk.a[] arrayOfa = (aofk.a[])getSpans(0, super.length(), aofk.a.class);
    if ((arrayOfa == null) || (arrayOfa.length <= 0)) {
      return super.length();
    }
    int k = arrayOfa.length;
    int i = 0;
    if (i < k)
    {
      aofk.a locala = arrayOfa[i];
      switch (locala.emojiType)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        int m = getSpanStart(locala);
        j += getSpanEnd(locala) - m - 1;
      }
    }
    return super.length() - j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kpo
 * JD-Core Version:    0.7.0.1
 */