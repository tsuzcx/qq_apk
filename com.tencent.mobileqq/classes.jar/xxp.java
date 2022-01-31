import com.tencent.mobileqq.activity.richmedia.view.ExtendEditText.LengthConvertor;

public final class xxp
  implements ExtendEditText.LengthConvertor
{
  private boolean a(char paramChar)
  {
    Character.UnicodeBlock localUnicodeBlock = Character.UnicodeBlock.of(paramChar);
    return (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) || (localUnicodeBlock == Character.UnicodeBlock.GENERAL_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS);
  }
  
  public int a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 <= paramInt2)
    {
      i = paramInt1;
      if (paramInt1 > paramInt2) {
        break label75;
      }
    }
    int j;
    for (;;)
    {
      j = 0;
      paramInt1 = i;
      while ((paramInt1 < paramInt2) && (paramInt1 < paramCharSequence.length()))
      {
        int k = j;
        if (a(paramCharSequence.charAt(paramInt1))) {
          k = j + 1;
        }
        paramInt1 += 1;
        j = k;
      }
      i = paramInt2;
      break;
      label75:
      paramInt2 = paramInt1;
    }
    return j + (paramInt2 - i);
  }
  
  public int b(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int m = 0;
    int i;
    if (paramInt1 <= paramInt2)
    {
      i = paramInt1;
      if (paramInt1 > paramInt2) {
        break label83;
      }
      label16:
      paramInt1 = i;
    }
    int k;
    for (int j = 0;; j = k)
    {
      k = m;
      if (paramInt1 < paramCharSequence.length())
      {
        k = j;
        if (a(paramCharSequence.charAt(paramInt1))) {
          k = j + 1;
        }
        if (paramInt1 + k >= paramInt2) {
          k = paramInt1 - i;
        }
      }
      else
      {
        return k;
        i = paramInt2;
        break;
        label83:
        paramInt2 = paramInt1;
        break label16;
      }
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xxp
 * JD-Core Version:    0.7.0.1
 */