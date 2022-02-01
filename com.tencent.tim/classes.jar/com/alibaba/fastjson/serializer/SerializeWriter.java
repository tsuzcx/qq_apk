package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.JSONLexer;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;

public final class SerializeWriter
  extends Writer
{
  public static final char[] DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  static final char[] DigitOnes;
  static final char[] DigitTens;
  static final char[] ascii_chars;
  private static final ThreadLocal<char[]> bufLocal = new ThreadLocal();
  static final char[] digits;
  static final char[] replaceChars;
  static final int[] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, 2147483647 };
  static final byte[] specicalFlags_doubleQuotes;
  static final byte[] specicalFlags_singleQuotes;
  protected char[] buf;
  protected int count;
  protected int features;
  protected final Writer writer;
  
  static
  {
    digits = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122 };
    DigitTens = new char[] { 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 54, 54, 54, 54, 54, 54, 54, 54, 54, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 56, 56, 56, 56, 56, 56, 56, 56, 56, 56, 57, 57, 57, 57, 57, 57, 57, 57, 57, 57 };
    DigitOnes = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57 };
    ascii_chars = new char[] { 48, 48, 48, 49, 48, 50, 48, 51, 48, 52, 48, 53, 48, 54, 48, 55, 48, 56, 48, 57, 48, 65, 48, 66, 48, 67, 48, 68, 48, 69, 48, 70, 49, 48, 49, 49, 49, 50, 49, 51, 49, 52, 49, 53, 49, 54, 49, 55, 49, 56, 49, 57, 49, 65, 49, 66, 49, 67, 49, 68, 49, 69, 49, 70, 50, 48, 50, 49, 50, 50, 50, 51, 50, 52, 50, 53, 50, 54, 50, 55, 50, 56, 50, 57, 50, 65, 50, 66, 50, 67, 50, 68, 50, 69, 50, 70 };
    specicalFlags_doubleQuotes = new byte['¡'];
    specicalFlags_singleQuotes = new byte['¡'];
    replaceChars = new char[93];
    specicalFlags_doubleQuotes[0] = 4;
    specicalFlags_doubleQuotes[1] = 4;
    specicalFlags_doubleQuotes[2] = 4;
    specicalFlags_doubleQuotes[3] = 4;
    specicalFlags_doubleQuotes[4] = 4;
    specicalFlags_doubleQuotes[5] = 4;
    specicalFlags_doubleQuotes[6] = 4;
    specicalFlags_doubleQuotes[7] = 4;
    specicalFlags_doubleQuotes[8] = 1;
    specicalFlags_doubleQuotes[9] = 1;
    specicalFlags_doubleQuotes[10] = 1;
    specicalFlags_doubleQuotes[11] = 4;
    specicalFlags_doubleQuotes[12] = 1;
    specicalFlags_doubleQuotes[13] = 1;
    specicalFlags_doubleQuotes[34] = 1;
    specicalFlags_doubleQuotes[92] = 1;
    specicalFlags_singleQuotes[0] = 4;
    specicalFlags_singleQuotes[1] = 4;
    specicalFlags_singleQuotes[2] = 4;
    specicalFlags_singleQuotes[3] = 4;
    specicalFlags_singleQuotes[4] = 4;
    specicalFlags_singleQuotes[5] = 4;
    specicalFlags_singleQuotes[6] = 4;
    specicalFlags_singleQuotes[7] = 4;
    specicalFlags_singleQuotes[8] = 1;
    specicalFlags_singleQuotes[9] = 1;
    specicalFlags_singleQuotes[10] = 1;
    specicalFlags_singleQuotes[11] = 4;
    specicalFlags_singleQuotes[12] = 1;
    specicalFlags_singleQuotes[13] = 1;
    specicalFlags_singleQuotes[92] = 1;
    specicalFlags_singleQuotes[39] = 1;
    int i = 14;
    while (i <= 31)
    {
      specicalFlags_doubleQuotes[i] = 4;
      specicalFlags_singleQuotes[i] = 4;
      i += 1;
    }
    i = 127;
    while (i < 160)
    {
      specicalFlags_doubleQuotes[i] = 4;
      specicalFlags_singleQuotes[i] = 4;
      i += 1;
    }
    replaceChars[0] = '0';
    replaceChars[1] = '1';
    replaceChars[2] = '2';
    replaceChars[3] = '3';
    replaceChars[4] = '4';
    replaceChars[5] = '5';
    replaceChars[6] = '6';
    replaceChars[7] = '7';
    replaceChars[8] = 'b';
    replaceChars[9] = 't';
    replaceChars[10] = 'n';
    replaceChars[11] = 'v';
    replaceChars[12] = 'f';
    replaceChars[13] = 'r';
    replaceChars[34] = '"';
    replaceChars[39] = '\'';
    replaceChars[47] = '/';
    replaceChars[92] = '\\';
  }
  
  public SerializeWriter()
  {
    this((Writer)null);
  }
  
  public SerializeWriter(int paramInt)
  {
    this(null, paramInt);
  }
  
  public SerializeWriter(Writer paramWriter)
  {
    this.writer = paramWriter;
    this.features = JSON.DEFAULT_GENERATE_FEATURE;
    this.buf = ((char[])bufLocal.get());
    if (bufLocal != null) {
      bufLocal.set(null);
    }
    if (this.buf == null) {
      this.buf = new char[1024];
    }
  }
  
  public SerializeWriter(Writer paramWriter, int paramInt)
  {
    this.writer = paramWriter;
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Negative initial size: " + paramInt);
    }
    this.buf = new char[paramInt];
  }
  
  public SerializeWriter(Writer paramWriter, int paramInt, SerializerFeature[] paramArrayOfSerializerFeature)
  {
    this.writer = paramWriter;
    this.buf = ((char[])bufLocal.get());
    if (this.buf != null) {
      bufLocal.set(null);
    }
    if (this.buf == null) {
      this.buf = new char[1024];
    }
    int k = paramArrayOfSerializerFeature.length;
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < k)
    {
      i |= paramArrayOfSerializerFeature[paramInt].mask;
      paramInt += 1;
    }
    this.features = i;
  }
  
  public SerializeWriter(SerializerFeature... paramVarArgs)
  {
    this(null, 0, paramVarArgs);
  }
  
  protected static void getChars(long paramLong, int paramInt, char[] paramArrayOfChar)
  {
    int i;
    if (paramLong < 0L)
    {
      paramLong = -paramLong;
      i = 45;
    }
    for (;;)
    {
      int j;
      if (paramLong > 2147483647L)
      {
        long l = paramLong / 100L;
        j = (int)(paramLong - ((l << 6) + (l << 5) + (l << 2)));
        paramInt -= 1;
        paramArrayOfChar[paramInt] = DigitOnes[j];
        paramInt -= 1;
        paramArrayOfChar[paramInt] = DigitTens[j];
        paramLong = l;
      }
      else
      {
        int k = (int)paramLong;
        j = paramInt;
        paramInt = k;
        while (paramInt >= 65536)
        {
          k = paramInt / 100;
          paramInt -= (k << 6) + (k << 5) + (k << 2);
          j -= 1;
          paramArrayOfChar[j] = DigitOnes[paramInt];
          j -= 1;
          paramArrayOfChar[j] = DigitTens[paramInt];
          paramInt = k;
          continue;
          paramInt = k;
        }
        for (;;)
        {
          k = 52429 * paramInt >>> 19;
          j -= 1;
          paramArrayOfChar[j] = digits[(paramInt - ((k << 3) + (k << 1)))];
          if (k != 0) {
            break;
          }
          if (i != 0) {
            paramArrayOfChar[(j - 1)] = i;
          }
          return;
        }
        i = 0;
      }
    }
  }
  
  private void writeKeyWithDoubleQuoteIfHasSpecial(String paramString)
  {
    int k = paramString.length();
    int i3 = this.count + k + 1;
    int j;
    if (i3 > this.buf.length) {
      if (this.writer != null)
      {
        if (k == 0)
        {
          write(34);
          write(34);
          write(58);
          return;
        }
        i = 0;
        if (i >= k) {
          break label650;
        }
        j = paramString.charAt(i);
        if ((j >= specicalFlags_doubleQuotes.length) || (specicalFlags_doubleQuotes[j] == 0)) {}
      }
    }
    label650:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        write(34);
      }
      j = 0;
      label102:
      int m;
      if (j < k)
      {
        m = paramString.charAt(j);
        if ((m < specicalFlags_doubleQuotes.length) && (specicalFlags_doubleQuotes[m] != 0))
        {
          write(92);
          write(replaceChars[m]);
        }
        for (;;)
        {
          j += 1;
          break label102;
          i += 1;
          break;
          write(m);
        }
      }
      if (i != 0) {
        write(34);
      }
      write(58);
      return;
      expandCapacity(i3);
      if (k == 0)
      {
        if (this.count + 3 > this.buf.length) {
          expandCapacity(this.count + 3);
        }
        paramString = this.buf;
        i = this.count;
        this.count = (i + 1);
        paramString[i] = 34;
        paramString = this.buf;
        i = this.count;
        this.count = (i + 1);
        paramString[i] = 34;
        paramString = this.buf;
        i = this.count;
        this.count = (i + 1);
        paramString[i] = 58;
        return;
      }
      int i4 = this.count;
      int n = i4 + k;
      paramString.getChars(0, k, this.buf, i4);
      this.count = i3;
      int i1 = 0;
      k = i4;
      if (k < n)
      {
        int i5 = this.buf[k];
        m = k;
        int i2 = i1;
        i = n;
        j = i3;
        if (i5 < specicalFlags_doubleQuotes.length)
        {
          m = k;
          i2 = i1;
          i = n;
          j = i3;
          if (specicalFlags_doubleQuotes[i5] != 0)
          {
            if (i1 != 0) {
              break label546;
            }
            j = i3 + 3;
            if (j > this.buf.length) {
              expandCapacity(j);
            }
            this.count = j;
            System.arraycopy(this.buf, k + 1, this.buf, k + 3, n - k - 1);
            System.arraycopy(this.buf, 0, this.buf, 1, k);
            this.buf[i4] = '"';
            paramString = this.buf;
            i = k + 1;
            paramString[i] = 92;
            paramString = this.buf;
            m = i + 1;
            paramString[m] = replaceChars[i5];
            i = n + 2;
            this.buf[(this.count - 2)] = '"';
          }
        }
        for (i2 = 1;; i2 = i1)
        {
          k = m + 1;
          i1 = i2;
          n = i;
          i3 = j;
          break;
          label546:
          j = i3 + 1;
          if (j > this.buf.length) {
            expandCapacity(j);
          }
          this.count = j;
          System.arraycopy(this.buf, k + 1, this.buf, k + 2, n - k);
          this.buf[k] = '\\';
          paramString = this.buf;
          m = k + 1;
          paramString[m] = replaceChars[i5];
          i = n + 1;
        }
      }
      this.buf[(this.count - 1)] = ':';
      return;
    }
  }
  
  private void writeKeyWithSingleQuoteIfHasSpecial(String paramString)
  {
    int k = paramString.length();
    int i3 = this.count + k + 1;
    int j;
    if (i3 > this.buf.length) {
      if (this.writer != null)
      {
        if (k == 0)
        {
          write(39);
          write(39);
          write(58);
          return;
        }
        i = 0;
        if (i >= k) {
          break label648;
        }
        j = paramString.charAt(i);
        if ((j >= specicalFlags_singleQuotes.length) || (specicalFlags_singleQuotes[j] == 0)) {}
      }
    }
    label648:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        write(39);
      }
      j = 0;
      label102:
      int m;
      if (j < k)
      {
        m = paramString.charAt(j);
        if ((m < specicalFlags_singleQuotes.length) && (specicalFlags_singleQuotes[m] != 0))
        {
          write(92);
          write(replaceChars[m]);
        }
        for (;;)
        {
          j += 1;
          break label102;
          i += 1;
          break;
          write(m);
        }
      }
      if (i != 0) {
        write(39);
      }
      write(58);
      return;
      expandCapacity(i3);
      if (k == 0)
      {
        if (this.count + 3 > this.buf.length) {
          expandCapacity(this.count + 3);
        }
        paramString = this.buf;
        i = this.count;
        this.count = (i + 1);
        paramString[i] = 39;
        paramString = this.buf;
        i = this.count;
        this.count = (i + 1);
        paramString[i] = 39;
        paramString = this.buf;
        i = this.count;
        this.count = (i + 1);
        paramString[i] = 58;
        return;
      }
      int i4 = this.count;
      int n = i4 + k;
      paramString.getChars(0, k, this.buf, i4);
      this.count = i3;
      int i1 = 0;
      k = i4;
      if (k < n)
      {
        int i5 = this.buf[k];
        m = k;
        int i2 = i1;
        i = n;
        j = i3;
        if (i5 < specicalFlags_singleQuotes.length)
        {
          m = k;
          i2 = i1;
          i = n;
          j = i3;
          if (specicalFlags_singleQuotes[i5] != 0)
          {
            if (i1 != 0) {
              break label546;
            }
            j = i3 + 3;
            if (j > this.buf.length) {
              expandCapacity(j);
            }
            this.count = j;
            System.arraycopy(this.buf, k + 1, this.buf, k + 3, n - k - 1);
            System.arraycopy(this.buf, 0, this.buf, 1, k);
            this.buf[i4] = '\'';
            paramString = this.buf;
            i = k + 1;
            paramString[i] = 92;
            paramString = this.buf;
            m = i + 1;
            paramString[m] = replaceChars[i5];
            i = n + 2;
            this.buf[(this.count - 2)] = '\'';
          }
        }
        for (i2 = 1;; i2 = i1)
        {
          k = m + 1;
          i1 = i2;
          n = i;
          i3 = j;
          break;
          label546:
          j = i3 + 1;
          if (j > this.buf.length) {
            expandCapacity(j);
          }
          this.count = j;
          System.arraycopy(this.buf, k + 1, this.buf, k + 2, n - k);
          this.buf[k] = '\\';
          paramString = this.buf;
          m = k + 1;
          paramString[m] = replaceChars[i5];
          i = n + 1;
        }
      }
      this.buf[(i3 - 1)] = ':';
      return;
    }
  }
  
  public SerializeWriter append(char paramChar)
  {
    write(paramChar);
    return this;
  }
  
  public SerializeWriter append(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {}
    for (paramCharSequence = "null";; paramCharSequence = paramCharSequence.toString())
    {
      write(paramCharSequence, 0, paramCharSequence.length());
      return this;
    }
  }
  
  public SerializeWriter append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "null";
    }
    paramCharSequence = ((CharSequence)localObject).subSequence(paramInt1, paramInt2).toString();
    write(paramCharSequence, 0, paramCharSequence.length());
    return this;
  }
  
  public void close()
  {
    if ((this.writer != null) && (this.count > 0)) {
      flush();
    }
    if (this.buf.length <= 8192) {
      bufLocal.set(this.buf);
    }
    this.buf = null;
  }
  
  public void config(SerializerFeature paramSerializerFeature, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.features |= paramSerializerFeature.mask;
      return;
    }
    this.features &= (paramSerializerFeature.mask ^ 0xFFFFFFFF);
  }
  
  protected void expandCapacity(int paramInt)
  {
    int i = this.buf.length * 3 / 2 + 1;
    if (i < paramInt) {}
    for (;;)
    {
      char[] arrayOfChar = new char[paramInt];
      System.arraycopy(this.buf, 0, arrayOfChar, 0, this.count);
      this.buf = arrayOfChar;
      return;
      paramInt = i;
    }
  }
  
  public void flush()
  {
    if (this.writer == null) {
      return;
    }
    try
    {
      this.writer.write(this.buf, 0, this.count);
      this.writer.flush();
      this.count = 0;
      return;
    }
    catch (IOException localIOException)
    {
      throw new JSONException(localIOException.getMessage(), localIOException);
    }
  }
  
  public boolean isEnabled(SerializerFeature paramSerializerFeature)
  {
    return (this.features & paramSerializerFeature.mask) != 0;
  }
  
  public byte[] toBytes(String paramString)
  {
    if (this.writer != null) {
      throw new UnsupportedOperationException("writer not null");
    }
    String str = paramString;
    if (paramString == null) {
      str = "UTF-8";
    }
    try
    {
      paramString = new String(this.buf, 0, this.count).getBytes(str);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new JSONException("toBytes error", paramString);
    }
  }
  
  public String toString()
  {
    return new String(this.buf, 0, this.count);
  }
  
  public void write(int paramInt)
  {
    int j = this.count + 1;
    int i = j;
    if (j > this.buf.length)
    {
      if (this.writer != null) {
        break label49;
      }
      expandCapacity(j);
    }
    for (i = j;; i = 1)
    {
      this.buf[this.count] = ((char)paramInt);
      this.count = i;
      return;
      label49:
      flush();
    }
  }
  
  public void write(String paramString)
  {
    if (paramString == null)
    {
      writeNull();
      return;
    }
    write(paramString, 0, paramString.length());
  }
  
  public void write(String paramString, int paramInt1, int paramInt2)
  {
    int k = this.count + paramInt2;
    int i;
    int j;
    if (k > this.buf.length)
    {
      i = paramInt1;
      j = paramInt2;
      if (this.writer == null)
      {
        expandCapacity(k);
        i = k;
        j = paramInt1;
      }
    }
    for (;;)
    {
      paramString.getChars(j, paramInt2 + j, this.buf, this.count);
      this.count = i;
      return;
      do
      {
        paramInt2 = this.buf.length - this.count;
        paramString.getChars(i, i + paramInt2, this.buf, this.count);
        this.count = this.buf.length;
        flush();
        paramInt1 = j - paramInt2;
        k = i + paramInt2;
        i = k;
        j = paramInt1;
      } while (paramInt1 > this.buf.length);
      paramInt2 = paramInt1;
      j = k;
      i = paramInt1;
      continue;
      i = k;
      j = paramInt1;
    }
  }
  
  public void write(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "true";; str = "false")
    {
      write(str);
      return;
    }
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > paramArrayOfChar.length) || (paramInt2 < 0) || (paramInt1 + paramInt2 > paramArrayOfChar.length) || (paramInt1 + paramInt2 < 0)) {
      throw new IndexOutOfBoundsException();
    }
    if (paramInt2 == 0) {
      return;
    }
    int k = this.count + paramInt2;
    int i;
    int j;
    if (k > this.buf.length)
    {
      i = paramInt1;
      j = paramInt2;
      if (this.writer == null)
      {
        expandCapacity(k);
        i = k;
        j = paramInt1;
      }
    }
    for (;;)
    {
      System.arraycopy(paramArrayOfChar, j, this.buf, this.count, paramInt2);
      this.count = i;
      return;
      do
      {
        paramInt2 = this.buf.length - this.count;
        System.arraycopy(paramArrayOfChar, i, this.buf, this.count, paramInt2);
        this.count = this.buf.length;
        flush();
        paramInt1 = j - paramInt2;
        k = i + paramInt2;
        i = k;
        j = paramInt1;
      } while (paramInt1 > this.buf.length);
      paramInt2 = paramInt1;
      j = k;
      i = paramInt1;
      continue;
      i = k;
      j = paramInt1;
    }
  }
  
  public void writeByteArray(byte[] paramArrayOfByte)
  {
    int n = 0;
    int m = 0;
    int i1 = paramArrayOfByte.length;
    int i;
    if ((this.features & SerializerFeature.UseSingleQuotes.mask) != 0)
    {
      k = 1;
      if (k == 0) {
        break label61;
      }
      i = 39;
      label35:
      if (i1 != 0) {
        break label74;
      }
      if (k == 0) {
        break label67;
      }
    }
    label61:
    label67:
    for (paramArrayOfByte = "''";; paramArrayOfByte = "\"\"")
    {
      write(paramArrayOfByte);
      return;
      k = 0;
      break;
      i = 34;
      break label35;
    }
    label74:
    char[] arrayOfChar1 = JSONLexer.CA;
    int i2 = i1 / 3 * 3;
    int k = (i1 - 1) / 3;
    int i4 = this.count;
    int i3 = (k + 1 << 2) + this.count + 2;
    if (i3 > this.buf.length)
    {
      if (this.writer != null)
      {
        write(i);
        k = 0;
        while (k < i2)
        {
          i4 = k + 1;
          n = paramArrayOfByte[k];
          i3 = i4 + 1;
          i4 = paramArrayOfByte[i4];
          k = i3 + 1;
          n = (i4 & 0xFF) << 8 | (n & 0xFF) << 16 | paramArrayOfByte[i3] & 0xFF;
          write(arrayOfChar1[(n >>> 18 & 0x3F)]);
          write(arrayOfChar1[(n >>> 12 & 0x3F)]);
          write(arrayOfChar1[(n >>> 6 & 0x3F)]);
          write(arrayOfChar1[(n & 0x3F)]);
        }
        n = i1 - i2;
        if (n > 0)
        {
          i2 = paramArrayOfByte[i2];
          k = m;
          if (n == 2) {
            k = (paramArrayOfByte[(i1 - 1)] & 0xFF) << 2;
          }
          k |= (i2 & 0xFF) << 10;
          write(arrayOfChar1[(k >> 12)]);
          write(arrayOfChar1[(k >>> 6 & 0x3F)]);
          if (n != 2) {
            break label385;
          }
        }
        label385:
        for (k = arrayOfChar1[(k & 0x3F)];; k = 61)
        {
          write(k);
          write(61);
          write(i);
          return;
        }
      }
      expandCapacity(i3);
    }
    this.count = i3;
    char[] arrayOfChar2 = this.buf;
    k = i4 + 1;
    arrayOfChar2[i4] = i;
    m = 0;
    while (m < i2)
    {
      int i6 = m + 1;
      i4 = paramArrayOfByte[m];
      int i5 = i6 + 1;
      i6 = paramArrayOfByte[i6];
      m = i5 + 1;
      i4 = (i6 & 0xFF) << 8 | (i4 & 0xFF) << 16 | paramArrayOfByte[i5] & 0xFF;
      arrayOfChar2 = this.buf;
      i5 = k + 1;
      arrayOfChar2[k] = arrayOfChar1[(i4 >>> 18 & 0x3F)];
      arrayOfChar2 = this.buf;
      k = i5 + 1;
      arrayOfChar2[i5] = arrayOfChar1[(i4 >>> 12 & 0x3F)];
      arrayOfChar2 = this.buf;
      i5 = k + 1;
      arrayOfChar2[k] = arrayOfChar1[(i4 >>> 6 & 0x3F)];
      arrayOfChar2 = this.buf;
      k = i5 + 1;
      arrayOfChar2[i5] = arrayOfChar1[(i4 & 0x3F)];
    }
    m = i1 - i2;
    if (m > 0)
    {
      i2 = paramArrayOfByte[i2];
      k = n;
      if (m == 2) {
        k = (paramArrayOfByte[(i1 - 1)] & 0xFF) << 2;
      }
      k |= (i2 & 0xFF) << 10;
      this.buf[(i3 - 5)] = arrayOfChar1[(k >> 12)];
      this.buf[(i3 - 4)] = arrayOfChar1[(k >>> 6 & 0x3F)];
      paramArrayOfByte = this.buf;
      if (m != 2) {
        break label746;
      }
    }
    label746:
    for (int j = arrayOfChar1[(k & 0x3F)];; j = 61)
    {
      paramArrayOfByte[(i3 - 3)] = j;
      this.buf[(i3 - 2)] = '=';
      this.buf[(i3 - 1)] = i;
      return;
    }
  }
  
  public void writeFieldName(String paramString, boolean paramBoolean)
  {
    if ((this.features & SerializerFeature.UseSingleQuotes.mask) != 0)
    {
      if ((this.features & SerializerFeature.QuoteFieldNames.mask) != 0)
      {
        writeStringWithSingleQuote(paramString);
        write(58);
        return;
      }
      writeKeyWithSingleQuoteIfHasSpecial(paramString);
      return;
    }
    if ((this.features & SerializerFeature.QuoteFieldNames.mask) != 0)
    {
      writeStringWithDoubleQuote(paramString, ':', paramBoolean);
      return;
    }
    writeKeyWithDoubleQuoteIfHasSpecial(paramString);
  }
  
  public void writeInt(int paramInt)
  {
    if (paramInt == -2147483648)
    {
      write("-2147483648");
      return;
    }
    int i;
    int j;
    if (paramInt < 0)
    {
      i = -paramInt;
      j = 0;
    }
    for (;;)
    {
      if (i <= sizeTable[j])
      {
        j += 1;
        i = j;
        if (paramInt < 0) {
          i = j + 1;
        }
        j = this.count + i;
        if (j > this.buf.length)
        {
          if (this.writer != null) {
            break label103;
          }
          expandCapacity(j);
        }
        getChars(paramInt, j, this.buf);
        this.count = j;
        return;
        i = paramInt;
        break;
      }
      j += 1;
    }
    label103:
    char[] arrayOfChar = new char[i];
    getChars(paramInt, i, arrayOfChar);
    write(arrayOfChar, 0, arrayOfChar.length);
  }
  
  public void writeLong(long paramLong)
  {
    if (paramLong == -9223372036854775808L)
    {
      write("-9223372036854775808");
      return;
    }
    long l1;
    int i;
    long l2;
    if (paramLong < 0L)
    {
      l1 = -paramLong;
      i = 1;
      l2 = 10L;
      label33:
      if (i >= 19) {
        break label165;
      }
      if (l1 >= l2) {
        break label125;
      }
    }
    label165:
    for (int j = i;; j = 0)
    {
      i = j;
      if (j == 0) {
        i = 19;
      }
      j = i;
      if (paramLong < 0L) {
        j = i + 1;
      }
      i = this.count + j;
      if (i > this.buf.length)
      {
        if (this.writer == null) {
          expandCapacity(i);
        }
      }
      else
      {
        getChars(paramLong, i, this.buf);
        this.count = i;
        return;
        l1 = paramLong;
        break;
        label125:
        l2 *= 10L;
        i += 1;
        break label33;
      }
      char[] arrayOfChar = new char[j];
      getChars(paramLong, j, arrayOfChar);
      write(arrayOfChar, 0, arrayOfChar.length);
      return;
    }
  }
  
  public void writeNull()
  {
    write("null");
  }
  
  public void writeString(String paramString)
  {
    if ((this.features & SerializerFeature.UseSingleQuotes.mask) != 0)
    {
      writeStringWithSingleQuote(paramString);
      return;
    }
    writeStringWithDoubleQuote(paramString, '\000', true);
  }
  
  protected void writeStringWithDoubleQuote(String paramString, char paramChar, boolean paramBoolean)
  {
    if (paramString == null)
    {
      writeNull();
      if (paramChar != 0) {
        write(paramChar);
      }
    }
    int m;
    int k;
    int j;
    do
    {
      return;
      m = paramString.length();
      k = this.count + m + 2;
      j = k;
      if (paramChar != 0) {
        j = k + 1;
      }
      if (j <= this.buf.length) {
        break label418;
      }
      if (this.writer == null) {
        break;
      }
      write(34);
      j = 0;
      if (j < paramString.length())
      {
        k = paramString.charAt(j);
        if ((this.features & SerializerFeature.BrowserCompatible.mask) != 0) {
          if ((k == 8) || (k == 12) || (k == 10) || (k == 13) || (k == 9) || (k == 34) || (k == 47) || (k == 92))
          {
            write(92);
            write(replaceChars[k]);
          }
        }
        for (;;)
        {
          j += 1;
          break;
          if (k < 32)
          {
            write(92);
            write(117);
            write(48);
            write(48);
            write(ascii_chars[(k * 2)]);
            write(ascii_chars[(k * 2 + 1)]);
          }
          else
          {
            if (k >= 127)
            {
              write(92);
              write(117);
              write(DIGITS[(k >>> 12 & 0xF)]);
              write(DIGITS[(k >>> 8 & 0xF)]);
              write(DIGITS[(k >>> 4 & 0xF)]);
              write(DIGITS[(k & 0xF)]);
              continue;
              if (((k < specicalFlags_doubleQuotes.length) && (specicalFlags_doubleQuotes[k] != 0)) || ((k == 47) && ((this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0)))
              {
                write(92);
                write(replaceChars[k]);
                continue;
              }
            }
            write(k);
          }
        }
      }
      write(34);
    } while (paramChar == 0);
    write(paramChar);
    return;
    expandCapacity(j);
    label418:
    int i5 = this.count + 1;
    int i6 = i5 + m;
    this.buf[this.count] = '"';
    paramString.getChars(0, m, this.buf, i5);
    this.count = j;
    int n;
    int i1;
    int i;
    if ((this.features & SerializerFeature.BrowserCompatible.mask) != 0)
    {
      n = j;
      k = -1;
      j = i5;
      if (j < i6)
      {
        i1 = this.buf[j];
        if ((i1 == 34) || (i1 == 47) || (i1 == 92))
        {
          m = n + 1;
          k = j;
        }
        for (;;)
        {
          j += 1;
          n = m;
          break;
          if ((i1 == 8) || (i1 == 12) || (i1 == 10) || (i1 == 13) || (i1 == 9))
          {
            m = n + 1;
            k = j;
          }
          else if (i1 < 32)
          {
            m = n + 5;
            k = j;
          }
          else
          {
            m = n;
            if (i1 >= 127)
            {
              m = n + 5;
              k = j;
            }
          }
        }
      }
      if (n > this.buf.length) {
        expandCapacity(n);
      }
      this.count = n;
      m = i6;
      if (k >= i5)
      {
        i = this.buf[k];
        if ((i == 8) || (i == 12) || (i == 10) || (i == 13) || (i == 9))
        {
          System.arraycopy(this.buf, k + 1, this.buf, k + 2, m - k - 1);
          this.buf[k] = '\\';
          this.buf[(k + 1)] = replaceChars[i];
          j = m + 1;
        }
        for (;;)
        {
          k -= 1;
          m = j;
          break;
          if ((i == 34) || (i == 47) || (i == 92))
          {
            System.arraycopy(this.buf, k + 1, this.buf, k + 2, m - k - 1);
            this.buf[k] = '\\';
            this.buf[(k + 1)] = i;
            j = m + 1;
          }
          else if (i < 32)
          {
            System.arraycopy(this.buf, k + 1, this.buf, k + 6, m - k - 1);
            this.buf[k] = '\\';
            this.buf[(k + 1)] = 'u';
            this.buf[(k + 2)] = '0';
            this.buf[(k + 3)] = '0';
            this.buf[(k + 4)] = ascii_chars[(i * 2)];
            this.buf[(k + 5)] = ascii_chars[(i * 2 + 1)];
            j = m + 5;
          }
          else
          {
            j = m;
            if (i >= 127)
            {
              System.arraycopy(this.buf, k + 1, this.buf, k + 6, m - k - 1);
              this.buf[k] = '\\';
              this.buf[(k + 1)] = 'u';
              this.buf[(k + 2)] = DIGITS[(i >>> 12 & 0xF)];
              this.buf[(k + 3)] = DIGITS[(i >>> 8 & 0xF)];
              this.buf[(k + 4)] = DIGITS[(i >>> 4 & 0xF)];
              this.buf[(k + 5)] = DIGITS[(i & 0xF)];
              j = m + 5;
            }
          }
        }
      }
      if (paramChar != 0)
      {
        this.buf[(this.count - 2)] = '"';
        this.buf[(this.count - 1)] = paramChar;
        return;
      }
      this.buf[(this.count - 1)] = '"';
      return;
    }
    int i3 = 0;
    int i4 = -1;
    int i2 = 0;
    if (paramBoolean)
    {
      k = i5;
      m = -1;
      i1 = j;
      j = k;
      k = m;
      if (j < i6)
      {
        n = this.buf[j];
        if (n == 8232)
        {
          m = i3 + 1;
          i3 = i1 + 4;
          i1 = m;
          i2 = i3;
          if (k != -1) {
            break label2447;
          }
          k = n;
          i2 = i3;
          i1 = m;
          m = j;
          n = j;
        }
      }
    }
    for (;;)
    {
      j += 1;
      int i7 = i2;
      i2 = k;
      k = m;
      i4 = n;
      i3 = i1;
      i1 = i7;
      break;
      if (n >= 93)
      {
        if ((n >= 127) && (n < 160))
        {
          m = k;
          if (k == -1) {
            m = j;
          }
          i2 = i1 + 4;
          i3 += 1;
          i1 = j;
          k = n;
          n = i1;
          i1 = i3;
        }
      }
      else
      {
        if (n == 32)
        {
          m = 0;
          label1386:
          if (m == 0) {
            break label2473;
          }
          i3 += 1;
          if ((n >= specicalFlags_doubleQuotes.length) || (specicalFlags_doubleQuotes[n] != 4)) {
            break label2466;
          }
        }
        label2447:
        label2466:
        for (m = i1 + 4;; m = i1)
        {
          i1 = i3;
          i2 = m;
          if (k == -1)
          {
            k = n;
            i2 = m;
            i1 = i3;
            m = j;
            n = j;
            break;
            if ((n == 47) && ((this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0))
            {
              m = 1;
              break label1386;
            }
            if ((n > 35) && (n != 92))
            {
              m = 0;
              break label1386;
            }
            if ((n <= 31) || (n == 92) || (n == 34))
            {
              m = 1;
              break label1386;
            }
            m = 0;
            break label1386;
            if (i3 > 0)
            {
              j = i1 + i3;
              if (j > this.buf.length) {
                expandCapacity(j);
              }
              this.count = j;
              if (i3 != 1) {
                break label1964;
              }
              if (i2 != 8232) {
                break label1732;
              }
              System.arraycopy(this.buf, i4 + 1, this.buf, i4 + 6, i6 - i4 - 1);
              this.buf[i4] = '\\';
              paramString = this.buf;
              j = i4 + 1;
              paramString[j] = 117;
              paramString = this.buf;
              j += 1;
              paramString[j] = 50;
              paramString = this.buf;
              j += 1;
              paramString[j] = 48;
              paramString = this.buf;
              j += 1;
              paramString[j] = 50;
              this.buf[(j + 1)] = '8';
            }
            label1964:
            label1985:
            while (paramChar != 0)
            {
              this.buf[(this.count - 2)] = '"';
              this.buf[(this.count - 1)] = paramChar;
              return;
              label1732:
              if ((i2 < specicalFlags_doubleQuotes.length) && (specicalFlags_doubleQuotes[i2] == 4))
              {
                System.arraycopy(this.buf, i4 + 1, this.buf, i4 + 6, i6 - i4 - 1);
                paramString = this.buf;
                j = i4 + 1;
                paramString[i4] = 92;
                paramString = this.buf;
                k = j + 1;
                paramString[j] = 117;
                paramString = this.buf;
                j = k + 1;
                paramString[k] = DIGITS[(i2 >>> 12 & 0xF)];
                paramString = this.buf;
                k = j + 1;
                paramString[j] = DIGITS[(i2 >>> 8 & 0xF)];
                paramString = this.buf;
                j = k + 1;
                paramString[k] = DIGITS[(i2 >>> 4 & 0xF)];
                this.buf[j] = DIGITS[(i2 & 0xF)];
              }
              else
              {
                System.arraycopy(this.buf, i4 + 1, this.buf, i4 + 2, i6 - i4 - 1);
                this.buf[i4] = '\\';
                this.buf[(i4 + 1)] = replaceChars[i2];
                continue;
                if (i3 > 1)
                {
                  m = k - i5;
                  j = k;
                  k = i6;
                  char[] arrayOfChar;
                  if (m < paramString.length())
                  {
                    i = paramString.charAt(m);
                    if (((i >= specicalFlags_doubleQuotes.length) || (specicalFlags_doubleQuotes[i] == 0)) && ((i != 47) || ((this.features & SerializerFeature.WriteSlashAsSpecial.mask) == 0))) {
                      break label2248;
                    }
                    arrayOfChar = this.buf;
                    n = j + 1;
                    arrayOfChar[j] = '\\';
                    if (specicalFlags_doubleQuotes[i] != 4) {
                      break label2216;
                    }
                    arrayOfChar = this.buf;
                    j = n + 1;
                    arrayOfChar[n] = 'u';
                    arrayOfChar = this.buf;
                    n = j + 1;
                    arrayOfChar[j] = DIGITS[(i >>> 12 & 0xF)];
                    arrayOfChar = this.buf;
                    j = n + 1;
                    arrayOfChar[n] = DIGITS[(i >>> 8 & 0xF)];
                    arrayOfChar = this.buf;
                    n = j + 1;
                    arrayOfChar[j] = DIGITS[(i >>> 4 & 0xF)];
                    arrayOfChar = this.buf;
                    j = n + 1;
                    arrayOfChar[n] = DIGITS[(i & 0xF)];
                    k += 5;
                  }
                  for (;;)
                  {
                    m += 1;
                    break label1985;
                    break;
                    arrayOfChar = this.buf;
                    j = n + 1;
                    arrayOfChar[n] = replaceChars[i];
                    k += 1;
                    continue;
                    label2248:
                    if (i == 8232)
                    {
                      arrayOfChar = this.buf;
                      n = j + 1;
                      arrayOfChar[j] = '\\';
                      arrayOfChar = this.buf;
                      j = n + 1;
                      arrayOfChar[n] = 'u';
                      arrayOfChar = this.buf;
                      n = j + 1;
                      arrayOfChar[j] = DIGITS[(i >>> 12 & 0xF)];
                      arrayOfChar = this.buf;
                      j = n + 1;
                      arrayOfChar[n] = DIGITS[(i >>> 8 & 0xF)];
                      arrayOfChar = this.buf;
                      n = j + 1;
                      arrayOfChar[j] = DIGITS[(i >>> 4 & 0xF)];
                      arrayOfChar = this.buf;
                      j = n + 1;
                      arrayOfChar[n] = DIGITS[(i & 0xF)];
                      k += 5;
                    }
                    else
                    {
                      this.buf[j] = i;
                      j += 1;
                    }
                  }
                }
              }
            }
            label2216:
            this.buf[(this.count - 1)] = '"';
            return;
          }
          i3 = j;
          m = k;
          k = n;
          n = i3;
          break;
        }
      }
      label2473:
      m = k;
      k = i2;
      n = i4;
      i2 = i1;
      i1 = i3;
    }
  }
  
  protected void writeStringWithSingleQuote(String paramString)
  {
    if (paramString == null)
    {
      i = this.count + 4;
      if (i > this.buf.length) {
        expandCapacity(i);
      }
      "null".getChars(0, 4, this.buf, this.count);
      this.count = i;
      return;
    }
    int i = paramString.length();
    int i3 = this.count + i + 2;
    if (i3 > this.buf.length)
    {
      if (this.writer != null)
      {
        write(39);
        i = 0;
        if (i < paramString.length())
        {
          j = paramString.charAt(i);
          if ((j <= 13) || (j == 92) || (j == 39) || ((j == 47) && ((this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0)))
          {
            write(92);
            write(replaceChars[j]);
          }
          for (;;)
          {
            i += 1;
            break;
            write(j);
          }
        }
        write(39);
        return;
      }
      expandCapacity(i3);
    }
    int i1 = this.count + 1;
    int i2 = i1 + i;
    this.buf[this.count] = '\'';
    paramString.getChars(0, i, this.buf, i1);
    this.count = i3;
    int j = 0;
    int k = -1;
    int m = 0;
    i = i1;
    int n;
    if (i < i2)
    {
      n = this.buf[i];
      if ((n > 13) && (n != 92) && (n != 39) && ((n != 47) || ((this.features & SerializerFeature.WriteSlashAsSpecial.mask) == 0))) {
        break label601;
      }
      k = j + 1;
      m = n;
      j = i;
    }
    for (;;)
    {
      i += 1;
      n = k;
      k = j;
      j = n;
      break;
      i = i3 + j;
      if (i > this.buf.length) {
        expandCapacity(i);
      }
      this.count = i;
      if (j == 1)
      {
        System.arraycopy(this.buf, k + 1, this.buf, k + 2, i2 - k - 1);
        this.buf[k] = '\\';
        this.buf[(k + 1)] = replaceChars[m];
      }
      for (;;)
      {
        this.buf[(this.count - 1)] = '\'';
        return;
        if (j > 1)
        {
          System.arraycopy(this.buf, k + 1, this.buf, k + 2, i2 - k - 1);
          this.buf[k] = '\\';
          paramString = this.buf;
          i = k + 1;
          paramString[i] = replaceChars[m];
          j = i2 + 1;
          i -= 2;
          while (i >= i1)
          {
            m = this.buf[i];
            if ((m > 13) && (m != 92) && (m != 39))
            {
              k = j;
              if (m == 47)
              {
                k = j;
                if ((this.features & SerializerFeature.WriteSlashAsSpecial.mask) == 0) {}
              }
            }
            else
            {
              System.arraycopy(this.buf, i + 1, this.buf, i + 2, j - i - 1);
              this.buf[i] = '\\';
              this.buf[(i + 1)] = replaceChars[m];
              k = j + 1;
            }
            i -= 1;
            j = k;
          }
        }
      }
      label601:
      n = j;
      j = k;
      k = n;
    }
  }
  
  public void writeTo(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    writeTo(paramOutputStream, Charset.forName(paramString));
  }
  
  public void writeTo(OutputStream paramOutputStream, Charset paramCharset)
    throws IOException
  {
    if (this.writer != null) {
      throw new UnsupportedOperationException("writer not null");
    }
    paramOutputStream.write(new String(this.buf, 0, this.count).getBytes(paramCharset.name()));
  }
  
  public void writeTo(Writer paramWriter)
    throws IOException
  {
    if (this.writer != null) {
      throw new UnsupportedOperationException("writer not null");
    }
    paramWriter.write(this.buf, 0, this.count);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.SerializeWriter
 * JD-Core Version:    0.7.0.1
 */