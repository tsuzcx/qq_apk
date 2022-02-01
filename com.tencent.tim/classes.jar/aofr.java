import android.text.Editable.Factory;
import android.text.SpannableStringBuilder;
import com.tencent.qphone.base.util.QLog;

public class aofr
  extends SpannableStringBuilder
{
  public static Editable.Factory a = new aofs();
  public static Editable.Factory c = new aoft();
  private int dOo;
  private int dOv;
  
  public aofr(CharSequence paramCharSequence, int paramInt)
  {
    this(paramCharSequence, paramInt, 32);
  }
  
  public aofr(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    super(c(paramCharSequence, paramInt1, paramInt2));
    this.dOo = paramInt2;
    this.dOv = paramInt1;
  }
  
  public static Editable.Factory a(int paramInt)
  {
    return new aofu(paramInt);
  }
  
  private static final CharSequence c(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if ((paramCharSequence instanceof aofk)) {
      return ((aofk)paramCharSequence).l();
    }
    return new aofk(paramCharSequence, paramInt1, paramInt2).l();
  }
  
  public String AE()
  {
    int j = 0;
    int i = length();
    Object localObject1 = new char[i];
    getChars(0, i, (char[])localObject1, 0);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append((char[])localObject1);
    int k = "[emoji]".length();
    localObject1 = (aofk.a[])getSpans(0, i, aofk.a.class);
    i = 0;
    if (j < localObject1.length)
    {
      Object localObject2 = localObject1[j];
      int m = getSpanStart(localObject2);
      int n = getSpanEnd(localObject2);
      switch (((aofk.a)localObject2).emojiType)
      {
      }
      for (;;)
      {
        j += 1;
        break;
        localStringBuffer.replace(m + i, n + i, "[emoji]");
        i += k - (n - m);
        continue;
        localObject2 = ((aofk.a)localObject2).getDescription();
        localStringBuffer.replace(m + i, n + i, (String)localObject2);
        i += ((String)localObject2).length() - (n - m);
        continue;
        localObject2 = afky.ea(((aofk.a)localObject2).index & 0x7FFFFFFF);
        localStringBuffer.replace(m + i, n + i, (String)localObject2);
        i += ((String)localObject2).length() - (n - m);
      }
    }
    return localStringBuffer.toString();
  }
  
  public void getChars(int paramInt1, int paramInt2, char[] paramArrayOfChar, int paramInt3)
  {
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    int j = length();
    paramInt1 = paramInt2;
    if (paramInt2 > j) {
      paramInt1 = j;
    }
    try
    {
      super.getChars(i, paramInt1, paramArrayOfChar, paramInt3);
      return;
    }
    catch (IndexOutOfBoundsException paramArrayOfChar)
    {
      QLog.e("QQTextBuilder", 1, "text:" + AE());
    }
  }
  
  public SpannableStringBuilder replace(int paramInt1, int paramInt2, CharSequence paramCharSequence, int paramInt3, int paramInt4)
  {
    if (paramInt1 < 0) {
      j = 0;
    }
    for (;;)
    {
      try
      {
        k = length();
        if (paramInt2 > k)
        {
          paramInt1 = k;
          paramInt2 = paramInt1;
          if (paramInt1 < 0) {
            i = paramInt1;
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        int k;
        Object localObject;
        QLog.e("QQText", 1, "QQTextBuilder.replace caused crash..text:" + toString() + ", replace text:" + paramCharSequence + " , " + j + "-" + paramInt2 + " , " + paramInt3 + "-" + paramInt4, localThrowable1);
        return new SpannableStringBuilder();
      }
      try
      {
        if (!QLog.isColorLevel()) {
          break label259;
        }
        i = paramInt1;
        QLog.w("QQTextBuilder", 2, "selection error, start = " + j + " end = " + paramInt1 + " length = " + k);
      }
      catch (Throwable localThrowable2)
      {
        paramInt2 = i;
        continue;
        continue;
        paramInt2 = 0;
        continue;
      }
      i = paramInt2;
      if (paramCharSequence.length() <= 0) {
        break label256;
      }
      i = paramInt2;
      localObject = new aofk(paramCharSequence, this.dOv, this.dOo).l();
      paramCharSequence = (CharSequence)localObject;
      try
      {
        localObject = super.replace(j, paramInt2, paramCharSequence, paramInt3, paramInt4);
        return localObject;
      }
      catch (Throwable localThrowable3)
      {
        continue;
      }
      j = paramInt1;
      continue;
      paramInt1 = paramInt2;
    }
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    if (!aofk.cLs) {
      localObject1 = super.subSequence(paramInt1, paramInt2);
    }
    do
    {
      return localObject1;
      if (paramInt1 != 0) {
        break;
      }
      localObject1 = this;
    } while (paramInt2 == length());
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    int j = length();
    paramInt1 = paramInt2;
    if (paramInt2 > j) {
      paramInt1 = j;
    }
    Object localObject2 = new char[paramInt1 - i];
    getChars(i, paramInt1, (char[])localObject2, 0);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((char[])localObject2);
    localObject2 = (aofk.a[])getSpans(i, paramInt1, aofk.a.class);
    if (paramInt1 - i > 0)
    {
      paramInt2 = 0;
      if (paramInt2 < localObject2.length)
      {
        Object localObject3 = localObject2[paramInt2];
        int k = getSpanStart(localObject3);
        int m = getSpanEnd(localObject3);
        j = k;
        if (k < i) {
          j = i;
        }
        k = m;
        if (m > paramInt1) {
          k = paramInt1;
        }
        switch (localObject3.emojiType)
        {
        }
        for (;;)
        {
          paramInt2 += 1;
          break;
          try
          {
            ((StringBuilder)localObject1).replace(j - i, k - i, aofy.fw(localObject3.index));
          }
          catch (Exception localException)
          {
            QLog.e("QQTextBuilder", 1, localException.getStackTrace());
          }
          continue;
          Object localObject4 = (aofk.c)localException;
          localObject4 = afgc.a(((aofk.c)localObject4).dOt, ((aofk.c)localObject4).dOu);
          ((StringBuilder)localObject1).replace(j - i, k - i, String.valueOf(new char[] { '\024', localObject4[3], localObject4[2], localObject4[1], localObject4[0] }));
          continue;
          ((StringBuilder)localObject1).replace(j - i, k - i, aofy.fx(((aofk.a)localObject4).index));
        }
      }
    }
    return localObject1;
  }
  
  public String toString()
  {
    if (!aofk.cLs) {
      return super.toString();
    }
    int i = length();
    Object localObject1 = new char[i];
    getChars(0, i, (char[])localObject1, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((char[])localObject1);
    int j = localStringBuilder.length();
    localObject1 = (aofk.a[])getSpans(0, i, aofk.a.class);
    i = 0;
    if (i < localObject1.length)
    {
      Object localObject2 = localObject1[i];
      int k = getSpanStart(localObject2);
      int m = getSpanEnd(localObject2);
      if ((k < j) && (m <= j)) {
        switch (((aofk.a)localObject2).emojiType)
        {
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.replace(k, m, aofy.fw(((aofk.a)localObject2).index));
        continue;
        localObject2 = (aofk.c)localObject2;
        localObject2 = afgc.a(((aofk.c)localObject2).dOt, ((aofk.c)localObject2).dOu);
        localStringBuilder.replace(k, m, String.valueOf(new char[] { '\024', localObject2[3], localObject2[2], localObject2[1], localObject2[0] }));
        if (QLog.isColorLevel())
        {
          QLog.d("QQTextBuilder", 2, "start:" + k + ",end:" + m);
          continue;
          localStringBuilder.replace(k, m, aofy.fx(((aofk.a)localObject2).index));
          continue;
          if (QLog.isColorLevel()) {
            QLog.e("QQText", 2, "error emo pos. start:" + k + " end: " + m + " length: " + j);
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aofr
 * JD-Core Version:    0.7.0.1
 */