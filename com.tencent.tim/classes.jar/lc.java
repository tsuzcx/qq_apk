import android.text.Spanned;
import android.text.style.CharacterStyle;
import com.tencent.qphone.base.util.QLog;

public class lc
{
  private aure<CharacterStyle> a;
  private CharSequence charSequence;
  
  public lc(CharSequence paramCharSequence)
  {
    this.charSequence = paramCharSequence;
    if ((paramCharSequence instanceof Spanned))
    {
      Spanned localSpanned = (Spanned)paramCharSequence;
      paramCharSequence = (CharacterStyle[])localSpanned.getSpans(0, paramCharSequence.length(), CharacterStyle.class);
      if ((paramCharSequence != null) && (paramCharSequence.length > 0))
      {
        this.a = new aure(paramCharSequence.length);
        while (i < paramCharSequence.length)
        {
          Object localObject = paramCharSequence[i];
          if (((localObject instanceof aofk.a)) || ((localObject instanceof amfz)))
          {
            int j = localSpanned.getSpanStart(localObject);
            int k = localSpanned.getSpanEnd(localObject);
            this.a.put(b(j, k), localObject);
          }
          i += 1;
        }
      }
    }
  }
  
  private static long b(int paramInt1, int paramInt2)
  {
    return (paramInt1 << 32) + (0xFFFFFFFF & paramInt2);
  }
  
  private void b(String paramString, int paramInt1, int paramInt2)
  {
    QLog.e("ETTextView", 1, paramString + ":" + paramInt1 + "," + paramInt2 + " > " + this.charSequence.length() + ":" + this.charSequence);
  }
  
  private static int e(long paramLong)
  {
    return (int)(paramLong >>> 32);
  }
  
  private static int f(long paramLong)
  {
    return (int)(0xFFFFFFFF & paramLong);
  }
  
  public int y(int paramInt)
  {
    if (this.charSequence == null) {}
    do
    {
      return paramInt;
      if ((paramInt < 0) || (paramInt > this.charSequence.length()))
      {
        if (paramInt > 0) {
          b("convertToGraphIndex", paramInt, 0);
        }
        return -1;
      }
    } while (this.a == null);
    int k = this.a.size();
    int j = 0;
    int i = paramInt;
    while (j < k)
    {
      long l = this.a.keyAt(j);
      int m = e(l);
      int n = f(l);
      if (m >= paramInt) {
        return i;
      }
      if (n <= paramInt)
      {
        j += 1;
        i -= n - m - 1;
      }
      else
      {
        return i - (paramInt - m);
      }
    }
    return i;
  }
  
  public int z(int paramInt)
  {
    if (this.charSequence == null) {
      return paramInt;
    }
    if ((paramInt < 0) || (paramInt > this.charSequence.length()))
    {
      if (paramInt > 0) {
        b("convertToTextIndex1", paramInt, 0);
      }
      return -1;
    }
    int j;
    int i;
    int n;
    if (this.a != null)
    {
      int m = this.a.size();
      j = 0;
      i = paramInt;
      k = i;
      if (j < m)
      {
        long l = this.a.keyAt(j);
        k = e(l);
        n = f(l);
        if (k < i) {
          break label127;
        }
      }
    }
    for (int k = i;; k = paramInt)
    {
      if (k > this.charSequence.length())
      {
        b("convertToTextIndex2", paramInt, k);
        return -1;
        label127:
        j += 1;
        i = n - k - 1 + i;
        break;
      }
      return k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lc
 * JD-Core Version:    0.7.0.1
 */