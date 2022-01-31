package com.tencent.mobileqq.text;

import android.text.Editable.Factory;
import android.text.SpannableStringBuilder;
import com.tencent.qphone.base.util.QLog;
import egf;

public class QQTextBuilder
  extends SpannableStringBuilder
{
  public static Editable.Factory a;
  private int a;
  private int b;
  
  static
  {
    jdField_a_of_type_AndroidTextEditable$Factory = new egf();
  }
  
  public QQTextBuilder(int paramInt)
  {
    this(paramInt, 32);
  }
  
  public QQTextBuilder(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public QQTextBuilder(CharSequence paramCharSequence, int paramInt)
  {
    this(paramCharSequence, paramInt, 32);
  }
  
  public QQTextBuilder(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    super(a(paramCharSequence, paramInt1, paramInt2));
    this.b = paramInt2;
    this.jdField_a_of_type_Int = paramInt1;
  }
  
  private static final CharSequence a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if ((paramCharSequence instanceof QQText)) {
      return ((QQText)paramCharSequence).a();
    }
    return new QQText(paramCharSequence, paramInt1, paramInt2).a();
  }
  
  public String a()
  {
    int j = 0;
    int i = length();
    Object localObject1 = new char[i];
    getChars(0, i, (char[])localObject1, 0);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append((char[])localObject1);
    int k = "[emoji]".length();
    localObject1 = (QQText.EmotcationSpan[])getSpans(0, i, QQText.EmotcationSpan.class);
    i = 0;
    if (j < localObject1.length)
    {
      Object localObject2 = localObject1[j];
      int m = getSpanStart(localObject2);
      int n = getSpanEnd(localObject2);
      if (((QQText.EmotcationSpan)localObject2).jdField_a_of_type_Boolean)
      {
        localStringBuffer.replace(m + i, n + i, "[emoji]");
        i += k - (n - m);
      }
      for (;;)
      {
        j += 1;
        break;
        localObject2 = EmotcationConstants.a[(localObject2.jdField_a_of_type_Int & 0x7FFFFFFF)];
        localStringBuffer.replace(m + i, n + i, (String)localObject2);
        i += ((String)localObject2).length() - (n - m);
      }
    }
    return localStringBuffer.toString();
  }
  
  public String b()
  {
    String str = toString();
    char[] arrayOfChar = str.toCharArray();
    int k = str.length() - 1;
    int i = 0;
    while ((i <= k) && (arrayOfChar[i] <= ' ') && (arrayOfChar[i] != '\024')) {
      i += 1;
    }
    for (;;)
    {
      int j;
      if ((j >= i) && (arrayOfChar[j] <= ' ') && ((j == 0) || (arrayOfChar[(j - 1)] != '\024')))
      {
        j -= 1;
      }
      else
      {
        if ((i == 0) && (j == k)) {
          return str;
        }
        return str.substring(i, j + 1);
        j = k;
      }
    }
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
    super.getChars(i, paramInt1, paramArrayOfChar, paramInt3);
  }
  
  public SpannableStringBuilder replace(int paramInt1, int paramInt2, CharSequence paramCharSequence, int paramInt3, int paramInt4)
  {
    if (paramInt1 < 0) {
      i = 0;
    }
    for (;;)
    {
      try
      {
        paramInt1 = length();
        if (paramInt2 <= paramInt1) {}
      }
      catch (Throwable localThrowable1)
      {
        Object localObject;
        paramInt1 = paramInt2;
        if (QLog.isColorLevel()) {
          QLog.e("QQText", 2, "QQTextBuilder.replace caused crash..text:" + toString() + ", replace text:" + paramCharSequence + " , " + i + "-" + paramInt1 + " , " + paramInt3 + "-" + paramInt4);
        }
        return new SpannableStringBuilder();
      }
      for (;;)
      {
        try
        {
          if (paramCharSequence.length() <= 0) {
            continue;
          }
          localObject = new QQText(paramCharSequence, this.jdField_a_of_type_Int, this.b).a();
          paramCharSequence = (CharSequence)localObject;
        }
        catch (Throwable localThrowable2)
        {
          break label82;
          break;
        }
        try
        {
          localObject = super.replace(i, paramInt1, paramCharSequence, paramInt3, paramInt4);
          return localObject;
        }
        catch (Throwable localThrowable3)
        {
          break label82;
        }
      }
      i = paramInt1;
      continue;
      paramInt1 = paramInt2;
    }
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    int j = 0;
    if (!QQText.jdField_a_of_type_Boolean) {
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
    int k = length();
    paramInt1 = paramInt2;
    if (paramInt2 > k) {
      paramInt1 = k;
    }
    Object localObject2 = new char[paramInt1 - i];
    getChars(i, paramInt1, (char[])localObject2, 0);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((char[])localObject2);
    localObject2 = (QQText.EmotcationSpan[])getSpans(i, paramInt1, QQText.EmotcationSpan.class);
    if (paramInt1 - i > 0)
    {
      paramInt2 = j;
      if (paramInt2 < localObject2.length)
      {
        Object localObject3 = localObject2[paramInt2];
        k = getSpanStart(localObject3);
        int m = getSpanEnd(localObject3);
        j = k;
        if (k < i) {
          j = i;
        }
        k = m;
        if (m > paramInt1) {
          k = paramInt1;
        }
        if (localObject3.jdField_a_of_type_Boolean) {
          ((StringBuilder)localObject1).replace(j - i, k - i, TextUtils.a(localObject3.jdField_a_of_type_Int));
        }
        for (;;)
        {
          paramInt2 += 1;
          break;
          ((StringBuilder)localObject1).replace(j - i, k - i, TextUtils.b(localObject3.jdField_a_of_type_Int));
        }
      }
    }
    return localObject1;
  }
  
  public String toString()
  {
    int i = 0;
    if (!QQText.jdField_a_of_type_Boolean) {
      return super.toString();
    }
    int k = length();
    Object localObject1 = new char[k];
    getChars(0, k, (char[])localObject1, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((char[])localObject1);
    int j = localStringBuilder.length();
    localObject1 = (QQText.EmotcationSpan[])getSpans(0, k, QQText.EmotcationSpan.class);
    if (i < localObject1.length)
    {
      Object localObject2 = localObject1[i];
      k = getSpanStart(localObject2);
      int m = getSpanEnd(localObject2);
      if ((k < j) && (m <= j)) {
        if (localObject2.jdField_a_of_type_Boolean) {
          localStringBuilder.replace(k, m, TextUtils.a(localObject2.jdField_a_of_type_Int));
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.replace(k, m, TextUtils.b(localObject2.jdField_a_of_type_Int));
        continue;
        if (QLog.isColorLevel()) {
          QLog.e("QQText", 2, "error emo pos. start:" + k + " end: " + m + " length: " + j);
        }
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.text.QQTextBuilder
 * JD-Core Version:    0.7.0.1
 */