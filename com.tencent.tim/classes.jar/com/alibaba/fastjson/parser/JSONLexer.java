package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public final class JSONLexer
{
  public static final char[] CA;
  public static final int END = 4;
  public static final char EOI = '\032';
  static final int[] IA;
  public static final int NOT_MATCH = -1;
  public static final int NOT_MATCH_NAME = -2;
  public static final int UNKNOWN = 0;
  private static boolean V6 = false;
  public static final int VALUE = 3;
  protected static final int[] digits;
  public static final boolean[] firstIdentifierFlags;
  public static final boolean[] identifierFlags;
  private static final ThreadLocal<char[]> sbufLocal;
  protected int bp;
  public Calendar calendar = null;
  protected char ch;
  public boolean disableCircularReferenceDetect;
  protected int eofPos;
  protected boolean exp = false;
  public int features = JSON.DEFAULT_PARSER_FEATURE;
  protected boolean hasSpecial;
  protected boolean isDouble = false;
  protected final int len;
  public Locale locale = JSON.defaultLocale;
  public int matchStat = 0;
  protected int np;
  protected int pos;
  protected char[] sbuf = (char[])sbufLocal.get();
  protected int sp;
  protected String stringDefaultValue;
  protected final String text;
  public TimeZone timeZone = JSON.defaultTimeZone;
  protected int token;
  
  static
  {
    int j = 0;
    int i = -1;
    try
    {
      k = Class.forName("android.os.Build$VERSION").getField("SDK_INT").getInt(null);
      i = k;
    }
    catch (Exception localException)
    {
      int k;
      label21:
      boolean bool;
      break label21;
    }
    if (i >= 23) {}
    for (bool = true;; bool = false)
    {
      V6 = bool;
      sbufLocal = new ThreadLocal();
      digits = new int[103];
      i = 48;
      while (i <= 57)
      {
        digits[i] = (i - 48);
        i += 1;
      }
    }
    i = 97;
    while (i <= 102)
    {
      digits[i] = (i - 97 + 10);
      i += 1;
    }
    i = 65;
    while (i <= 70)
    {
      digits[i] = (i - 65 + 10);
      i += 1;
    }
    CA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    IA = new int[256];
    Arrays.fill(IA, -1);
    k = CA.length;
    i = 0;
    while (i < k)
    {
      IA[CA[i]] = i;
      i += 1;
    }
    IA[61] = 0;
    firstIdentifierFlags = new boolean[256];
    i = 0;
    if (i < firstIdentifierFlags.length)
    {
      if ((i >= 65) && (i <= 90)) {
        firstIdentifierFlags[i] = true;
      }
      for (;;)
      {
        i = (char)(i + 1);
        break;
        if ((i >= 97) && (i <= 122)) {
          firstIdentifierFlags[i] = true;
        } else if (i == 95) {
          firstIdentifierFlags[i] = true;
        }
      }
    }
    identifierFlags = new boolean[256];
    i = j;
    if (i < identifierFlags.length)
    {
      if ((i >= 65) && (i <= 90)) {
        identifierFlags[i] = true;
      }
      for (;;)
      {
        i = (char)(i + 1);
        break;
        if ((i >= 97) && (i <= 122)) {
          identifierFlags[i] = true;
        } else if (i == 95) {
          identifierFlags[i] = true;
        } else if ((i >= 48) && (i <= 57)) {
          identifierFlags[i] = true;
        }
      }
    }
  }
  
  public JSONLexer(String paramString)
  {
    this(paramString, JSON.DEFAULT_PARSER_FEATURE);
  }
  
  public JSONLexer(String paramString, int paramInt)
  {
    if (this.sbuf == null) {
      this.sbuf = new char[512];
    }
    this.features = paramInt;
    this.text = paramString;
    this.len = this.text.length();
    this.bp = -1;
    int i = this.bp + 1;
    this.bp = i;
    char c;
    if (i >= this.len)
    {
      c = '\032';
      this.ch = c;
      if (this.ch == 65279) {
        next();
      }
      if ((Feature.InitStringFieldAsEmpty.mask & paramInt) == 0) {
        break label198;
      }
      paramString = "";
      label159:
      this.stringDefaultValue = paramString;
      if ((Feature.DisableCircularReferenceDetect.mask & paramInt) == 0) {
        break label203;
      }
    }
    label198:
    label203:
    for (boolean bool = true;; bool = false)
    {
      this.disableCircularReferenceDetect = bool;
      return;
      c = this.text.charAt(i);
      break;
      paramString = null;
      break label159;
    }
  }
  
  public JSONLexer(char[] paramArrayOfChar, int paramInt)
  {
    this(paramArrayOfChar, paramInt, JSON.DEFAULT_PARSER_FEATURE);
  }
  
  public JSONLexer(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    this(new String(paramArrayOfChar, 0, paramInt1), paramInt2);
  }
  
  static boolean checkDate(char paramChar1, char paramChar2, char paramChar3, char paramChar4, char paramChar5, char paramChar6, int paramInt1, int paramInt2)
  {
    if ((paramChar1 != '1') && (paramChar1 != '2')) {}
    label71:
    do
    {
      do
      {
        do
        {
          return false;
        } while ((paramChar2 < '0') || (paramChar2 > '9') || (paramChar3 < '0') || (paramChar3 > '9') || (paramChar4 < '0') || (paramChar4 > '9'));
        if (paramChar5 != '0') {
          break;
        }
      } while ((paramChar6 < '1') || (paramChar6 > '9'));
      if (paramInt1 != 48) {
        break label124;
      }
    } while ((paramInt2 < 49) || (paramInt2 > 57));
    label124:
    do
    {
      do
      {
        return true;
        if (paramChar5 != '1') {
          break;
        }
        if ((paramChar6 == '0') || (paramChar6 == '1') || (paramChar6 == '2')) {
          break label71;
        }
        return false;
        if ((paramInt1 != 49) && (paramInt1 != 50)) {
          break label154;
        }
        if (paramInt2 < 48) {
          break;
        }
      } while (paramInt2 <= 57);
      return false;
      if (paramInt1 != 51) {
        break;
      }
    } while ((paramInt2 == 48) || (paramInt2 == 49));
    label154:
    return false;
  }
  
  static boolean checkTime(char paramChar1, char paramChar2, char paramChar3, char paramChar4, char paramChar5, char paramChar6)
  {
    if (paramChar1 == '0') {
      if ((paramChar2 >= '0') && (paramChar2 <= '9')) {
        break label38;
      }
    }
    label38:
    label62:
    do
    {
      do
      {
        do
        {
          return false;
          if (paramChar1 != '1') {
            break;
          }
        } while ((paramChar2 < '0') || (paramChar2 > '9'));
        if ((paramChar3 < '0') || (paramChar3 > '5')) {
          break label112;
        }
      } while ((paramChar4 < '0') || (paramChar4 > '9'));
      if ((paramChar5 < '0') || (paramChar5 > '5')) {
        break label126;
      }
    } while ((paramChar6 < '0') || (paramChar6 > '9'));
    label112:
    label126:
    do
    {
      return true;
      if ((paramChar1 != '2') || (paramChar2 < '0')) {
        break;
      }
      if (paramChar2 <= '4') {
        break label38;
      }
      return false;
      if (paramChar3 != '6') {
        break;
      }
      if (paramChar4 == '0') {
        break label62;
      }
      return false;
      if (paramChar5 != '6') {
        break;
      }
    } while (paramChar6 == '0');
    return false;
  }
  
  public static final byte[] decodeFast(String paramString, int paramInt1, int paramInt2)
  {
    int n = 0;
    if (paramInt2 == 0) {
      return new byte[0];
    }
    int k = paramInt1 + paramInt2 - 1;
    while ((paramInt1 < k) && (IA[paramString.charAt(paramInt1)] < 0)) {
      paramInt1 += 1;
    }
    for (;;)
    {
      if ((k > 0) && (IA[paramString.charAt(k)] < 0))
      {
        k -= 1;
      }
      else
      {
        int i;
        int j;
        if (paramString.charAt(k) == '=') {
          if (paramString.charAt(k - 1) == '=')
          {
            i = 2;
            j = k - paramInt1 + 1;
            if (paramInt2 <= 76) {
              break label375;
            }
            if (paramString.charAt(76) != '\r') {
              break label370;
            }
            paramInt2 = j / 78;
          }
        }
        label127:
        int i4;
        byte[] arrayOfByte;
        int i1;
        label370:
        label375:
        for (int m = paramInt2 << 1;; m = 0)
        {
          i4 = ((j - m) * 6 >> 3) - i;
          arrayOfByte = new byte[i4];
          int i5 = i4 / 3;
          j = 0;
          paramInt2 = 0;
          while (paramInt2 < i5 * 3)
          {
            int[] arrayOfInt = IA;
            int i2 = paramInt1 + 1;
            paramInt1 = arrayOfInt[paramString.charAt(paramInt1)];
            arrayOfInt = IA;
            i1 = i2 + 1;
            i2 = arrayOfInt[paramString.charAt(i2)];
            arrayOfInt = IA;
            int i3 = i1 + 1;
            int i6 = arrayOfInt[paramString.charAt(i1)];
            arrayOfInt = IA;
            i1 = i3 + 1;
            paramInt1 = i6 << 6 | paramInt1 << 18 | i2 << 12 | arrayOfInt[paramString.charAt(i3)];
            i2 = paramInt2 + 1;
            arrayOfByte[paramInt2] = ((byte)(paramInt1 >> 16));
            paramInt2 = i2 + 1;
            arrayOfByte[i2] = ((byte)(paramInt1 >> 8));
            i2 = paramInt2 + 1;
            arrayOfByte[paramInt2] = ((byte)paramInt1);
            paramInt1 = i1;
            paramInt2 = i2;
            if (m > 0)
            {
              i3 = j + 1;
              j = i3;
              paramInt1 = i1;
              paramInt2 = i2;
              if (i3 == 19)
              {
                paramInt1 = i1 + 2;
                j = 0;
                paramInt2 = i2;
              }
            }
          }
          i = 1;
          break;
          i = 0;
          break;
          paramInt2 = 0;
          break label127;
        }
        if (paramInt2 < i4)
        {
          m = paramInt1;
          j = 0;
          paramInt1 = n;
          for (;;)
          {
            n = paramInt1;
            if (m > k - i) {
              break;
            }
            i1 = IA[paramString.charAt(m)];
            paramInt1 = n + 1;
            j = i1 << 18 - n * 6 | j;
            m += 1;
          }
          i = 16;
          paramInt1 = paramInt2;
          paramInt2 = i;
          while (paramInt1 < i4)
          {
            arrayOfByte[paramInt1] = ((byte)(j >> paramInt2));
            paramInt2 -= 8;
            paramInt1 += 1;
          }
        }
        return arrayOfByte;
      }
    }
  }
  
  private int matchFieldHash(long paramLong)
  {
    int i = 1;
    int j = this.ch;
    int m = this.bp + 1;
    label23:
    long l;
    int k;
    label32:
    int n;
    if (j == 34)
    {
      l = -2128831035L;
      k = m;
      if (k >= this.len) {
        break label352;
      }
      n = this.text.charAt(k);
      if (n != j) {
        break label188;
      }
      i = k - m + i;
    }
    label188:
    label352:
    for (;;)
    {
      if (l != paramLong)
      {
        this.matchStat = -2;
        return 0;
        if (j == 39) {
          break label23;
        }
        if ((j <= 32) && ((j == 32) || (j == 10) || (j == 13) || (j == 9) || (j == 12) || (j == 8)))
        {
          j = this.bp + i;
          if (j >= this.len) {}
          for (j = 26;; j = this.text.charAt(j))
          {
            i += 1;
            break;
          }
        }
        this.matchStat = -2;
        return 0;
        l = (l ^ n) * 16777619L;
        k += 1;
        break label32;
      }
      k = this.bp;
      j = i + 1;
      i = k + j;
      if (i >= this.len) {}
      for (i = 26; i == 58; i = this.text.charAt(i)) {
        return j + 1;
      }
      if ((i <= 32) && ((i == 32) || (i == 10) || (i == 13) || (i == 9) || (i == 12) || (i == 8)))
      {
        i = this.bp + j;
        if (i >= this.len) {}
        for (i = 26;; i = this.text.charAt(i))
        {
          j += 1;
          break;
        }
      }
      throw new JSONException("match feild error expect ':'");
    }
  }
  
  private static String readString(char[] paramArrayOfChar, int paramInt)
  {
    char[] arrayOfChar = new char[paramInt];
    int n = 0;
    int m = 0;
    if (n < paramInt)
    {
      int i = paramArrayOfChar[n];
      int i1;
      if (i != 92)
      {
        i1 = m + 1;
        arrayOfChar[m] = i;
        m = i1;
      }
      for (;;)
      {
        n += 1;
        break;
        n += 1;
        switch (paramArrayOfChar[n])
        {
        default: 
          throw new JSONException("unclosed.str.lit");
        case '0': 
          i1 = m + 1;
          arrayOfChar[m] = '\000';
          m = i1;
          break;
        case '1': 
          i1 = m + 1;
          arrayOfChar[m] = '\001';
          m = i1;
          break;
        case '2': 
          i1 = m + 1;
          arrayOfChar[m] = '\002';
          m = i1;
          break;
        case '3': 
          i1 = m + 1;
          arrayOfChar[m] = '\003';
          m = i1;
          break;
        case '4': 
          i1 = m + 1;
          arrayOfChar[m] = '\004';
          m = i1;
          break;
        case '5': 
          i1 = m + 1;
          arrayOfChar[m] = '\005';
          m = i1;
          break;
        case '6': 
          i1 = m + 1;
          arrayOfChar[m] = '\006';
          m = i1;
          break;
        case '7': 
          i1 = m + 1;
          arrayOfChar[m] = '\007';
          m = i1;
          break;
        case 'b': 
          i1 = m + 1;
          arrayOfChar[m] = '\b';
          m = i1;
          break;
        case 't': 
          i1 = m + 1;
          arrayOfChar[m] = '\t';
          m = i1;
          break;
        case 'n': 
          i1 = m + 1;
          arrayOfChar[m] = '\n';
          m = i1;
          break;
        case 'v': 
          i1 = m + 1;
          arrayOfChar[m] = '\013';
          m = i1;
          break;
        case 'F': 
        case 'f': 
          i1 = m + 1;
          arrayOfChar[m] = '\f';
          m = i1;
          break;
        case 'r': 
          i1 = m + 1;
          arrayOfChar[m] = '\r';
          m = i1;
          break;
        case '"': 
          i1 = m + 1;
          arrayOfChar[m] = '"';
          m = i1;
          break;
        case '\'': 
          i1 = m + 1;
          arrayOfChar[m] = '\'';
          m = i1;
          break;
        case '/': 
          i1 = m + 1;
          arrayOfChar[m] = '/';
          m = i1;
          break;
        case '\\': 
          i1 = m + 1;
          arrayOfChar[m] = '\\';
          m = i1;
          break;
        case 'x': 
          i1 = m + 1;
          int[] arrayOfInt = digits;
          n += 1;
          int i2 = arrayOfInt[paramArrayOfChar[n]];
          arrayOfInt = digits;
          n += 1;
          arrayOfChar[m] = ((char)(i2 * 16 + arrayOfInt[paramArrayOfChar[n]]));
          m = i1;
          break;
        case 'u': 
          i1 = m + 1;
          n += 1;
          i = paramArrayOfChar[n];
          n += 1;
          int j = paramArrayOfChar[n];
          n += 1;
          int k = paramArrayOfChar[n];
          n += 1;
          arrayOfChar[m] = ((char)Integer.parseInt(new String(new char[] { i, j, k, paramArrayOfChar[n] }), 16));
          m = i1;
        }
      }
    }
    return new String(arrayOfChar, 0, m);
  }
  
  private void scanIdent()
  {
    this.np = (this.bp - 1);
    this.hasSpecial = false;
    do
    {
      this.sp += 1;
      next();
    } while (Character.isLetterOrDigit(this.ch));
    String str = stringVal();
    if (str.equals("null"))
    {
      this.token = 8;
      return;
    }
    if (str.equals("true"))
    {
      this.token = 6;
      return;
    }
    if (str.equals("false"))
    {
      this.token = 7;
      return;
    }
    if (str.equals("new"))
    {
      this.token = 9;
      return;
    }
    if (str.equals("undefined"))
    {
      this.token = 23;
      return;
    }
    if (str.equals("Set"))
    {
      this.token = 21;
      return;
    }
    if (str.equals("TreeSet"))
    {
      this.token = 22;
      return;
    }
    this.token = 18;
  }
  
  private void setCalendar(char paramChar1, char paramChar2, char paramChar3, char paramChar4, char paramChar5, char paramChar6, char paramChar7, char paramChar8)
  {
    this.calendar = Calendar.getInstance(this.timeZone, this.locale);
    this.calendar.set(1, (paramChar1 - '0') * 1000 + (paramChar2 - '0') * 100 + (paramChar3 - '0') * 10 + (paramChar4 - '0'));
    this.calendar.set(2, (paramChar5 - '0') * 10 + (paramChar6 - '0') - 1);
    this.calendar.set(5, (paramChar7 - '0') * 10 + (paramChar8 - '0'));
  }
  
  private final String subString(int paramInt1, int paramInt2)
  {
    if (paramInt2 < this.sbuf.length)
    {
      this.text.getChars(paramInt1, paramInt1 + paramInt2, this.sbuf, 0);
      return new String(this.sbuf, 0, paramInt2);
    }
    char[] arrayOfChar = new char[paramInt2];
    this.text.getChars(paramInt1, paramInt1 + paramInt2, arrayOfChar, 0);
    return new String(arrayOfChar);
  }
  
  public byte[] bytesValue()
  {
    return decodeFast(this.text, this.np + 1, this.sp);
  }
  
  protected char charAt(int paramInt)
  {
    if (paramInt >= this.len) {
      return '\032';
    }
    return this.text.charAt(paramInt);
  }
  
  public void close()
  {
    if (this.sbuf.length <= 8196) {
      sbufLocal.set(this.sbuf);
    }
    this.sbuf = null;
  }
  
  public final void config(Feature paramFeature, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.features |= paramFeature.mask;
      if (paramFeature == Feature.InitStringFieldAsEmpty)
      {
        if (!paramBoolean) {
          break label76;
        }
        paramFeature = "";
        label31:
        this.stringDefaultValue = paramFeature;
      }
      if ((this.features & Feature.DisableCircularReferenceDetect.mask) == 0) {
        break label81;
      }
    }
    label76:
    label81:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.disableCircularReferenceDetect = paramBoolean;
      return;
      this.features &= (paramFeature.mask ^ 0xFFFFFFFF);
      break;
      paramFeature = null;
      break label31;
    }
  }
  
  public final Number decimalValue(boolean paramBoolean)
  {
    int k = 2;
    int i = this.np + this.sp - 1;
    if (i >= this.len) {}
    for (i = 26; i == 70; i = this.text.charAt(i)) {
      try
      {
        float f = Float.parseFloat(numberString());
        return Float.valueOf(f);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new JSONException(localNumberFormatException.getMessage() + ", " + info());
      }
    }
    if (i == 68) {
      return Double.valueOf(Double.parseDouble(numberString()));
    }
    if (paramBoolean) {
      return decimalValue();
    }
    i = this.np;
    int j = this.sp;
    i = this.text.charAt(i + j - 1);
    int m = this.sp;
    if ((i != 76) && (i != 83) && (i != 66) && (i != 70)) {
      if (i == 68) {
        break label361;
      }
    }
    for (;;)
    {
      i = this.np;
      char[] arrayOfChar;
      if (m < this.sbuf.length)
      {
        this.text.getChars(i, i + m, this.sbuf, 0);
        arrayOfChar = this.sbuf;
      }
      while ((m <= 9) && (!this.exp))
      {
        j = arrayOfChar[0];
        if (j != 45) {
          break label429;
        }
        j = arrayOfChar[1];
        i = 1;
        break label370;
        arrayOfChar = new char[m];
        this.text.getChars(i, i + m, arrayOfChar, 0);
        continue;
        double d2 = j / n;
        d1 = d2;
        if (i != 0) {
          d1 = -d2;
        }
        return Double.valueOf(d1);
      }
      double d1 = Double.parseDouble(new String(arrayOfChar, 0, m));
      return Double.valueOf(d1);
      continue;
      label361:
      m -= 1;
    }
    label370:
    j -= 48;
    int n = 0;
    label380:
    int i1;
    if (k < m)
    {
      i1 = localNumberFormatException[k];
      if (i1 != 46) {
        break label457;
      }
      n = 1;
      i1 = j;
      j = n;
    }
    for (;;)
    {
      k += 1;
      n = j;
      j = i1;
      break label380;
      break;
      label429:
      if (j == 43)
      {
        j = localNumberFormatException[1];
        i = 0;
        break label370;
      }
      k = 1;
      i = 0;
      break label370;
      label457:
      int i2 = j * 10 + (i1 - 48);
      j = n;
      i1 = i2;
      if (n != 0)
      {
        j = n * 10;
        i1 = i2;
      }
    }
  }
  
  public final BigDecimal decimalValue()
  {
    int i = this.np;
    int j = this.sp;
    int k = this.text.charAt(i + j - 1);
    j = this.sp;
    if ((k != 76) && (k != 83) && (k != 66) && (k != 70))
    {
      i = j;
      if (k != 68) {}
    }
    else
    {
      i = j - 1;
    }
    j = this.np;
    if (i < this.sbuf.length)
    {
      this.text.getChars(j, j + i, this.sbuf, 0);
      return new BigDecimal(this.sbuf, 0, i);
    }
    char[] arrayOfChar = new char[i];
    this.text.getChars(j, i + j, arrayOfChar, 0);
    return new BigDecimal(arrayOfChar);
  }
  
  public String info()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("pos ").append(this.bp).append(", json : ");
    if (this.len < 65536) {}
    for (String str = this.text;; str = this.text.substring(0, 65536)) {
      return str;
    }
  }
  
  public final int intValue()
  {
    int j = 0;
    int k = this.np;
    int i1 = this.np + this.sp;
    int i;
    int m;
    int n;
    if (this.np >= this.len)
    {
      i = 26;
      if (i != 45) {
        break label154;
      }
      m = 1;
      n = -2147483648;
      i = k + 1;
      label50:
      if (i >= i1) {
        break label272;
      }
      j = i + 1;
      if (i < this.len) {
        break label167;
      }
      i = 26;
      label71:
      k = -(i - 48);
      i = j;
      j = k;
    }
    label264:
    label272:
    for (;;)
    {
      label81:
      if (i < i1)
      {
        k = i + 1;
        if (i >= this.len)
        {
          i = 26;
          label102:
          if ((i == 76) || (i == 83)) {
            break label264;
          }
          if (i != 66) {
            break label191;
          }
          i = k;
        }
      }
      for (;;)
      {
        if (m != 0)
        {
          if (i > this.np + 1)
          {
            return j;
            i = this.text.charAt(this.np);
            break;
            label154:
            n = -2147483647;
            m = 0;
            i = k;
            break label50;
            label167:
            i = this.text.charAt(i);
            break label71;
            i = this.text.charAt(i);
            break label102;
            label191:
            i -= 48;
            if (j < -214748364) {
              throw new NumberFormatException(numberString());
            }
            j *= 10;
            if (j < n + i) {
              throw new NumberFormatException(numberString());
            }
            j -= i;
            i = k;
            break label81;
          }
          throw new NumberFormatException(numberString());
        }
        return -j;
        i = k;
      }
    }
  }
  
  public final Number integerValue()
    throws NumberFormatException
  {
    long l1 = 0L;
    int m = this.np;
    int i = this.np;
    int j = this.sp + i;
    int k = 32;
    i = j - 1;
    label78:
    label92:
    int n;
    long l2;
    if (i >= this.len)
    {
      i = 26;
      switch (i)
      {
      default: 
        i = k;
        if (this.np >= this.len)
        {
          k = 26;
          if (k != 45) {
            break label246;
          }
          n = 1;
          l2 = -9223372036854775808L;
          k = m + 1;
          label111:
          m = k;
          if (k < j)
          {
            if (k < this.len) {
              break label260;
            }
            m = 26;
            label131:
            l1 = -(m - 48);
            m = k + 1;
          }
        }
        break;
      }
    }
    for (;;)
    {
      if (m >= j) {
        break label333;
      }
      if (m >= this.len) {}
      for (k = 26;; k = this.text.charAt(m))
      {
        k -= 48;
        if (l1 >= -922337203685477580L) {
          break label286;
        }
        return new BigInteger(numberString());
        i = this.text.charAt(i);
        break;
        j -= 1;
        i = 76;
        break label78;
        j -= 1;
        i = 83;
        break label78;
        j -= 1;
        i = 66;
        break label78;
        k = this.text.charAt(this.np);
        break label92;
        label246:
        n = 0;
        l2 = -9223372036854775807L;
        k = m;
        break label111;
        label260:
        m = this.text.charAt(k);
        break label131;
      }
      label286:
      l1 *= 10L;
      if (l1 < k + l2) {
        return new BigInteger(numberString());
      }
      l1 -= k;
      m += 1;
    }
    label333:
    if (n != 0)
    {
      if (m > this.np + 1)
      {
        if ((l1 >= -2147483648L) && (i != 76))
        {
          if (i == 83) {
            return Short.valueOf((short)(int)l1);
          }
          if (i == 66) {
            return Byte.valueOf((byte)(int)l1);
          }
          return Integer.valueOf((int)l1);
        }
        return Long.valueOf(l1);
      }
      throw new NumberFormatException(numberString());
    }
    l1 = -l1;
    if ((l1 <= 2147483647L) && (i != 76))
    {
      if (i == 83) {
        return Short.valueOf((short)(int)l1);
      }
      if (i == 66) {
        return Byte.valueOf((byte)(int)l1);
      }
      return Integer.valueOf((int)l1);
    }
    return Long.valueOf(l1);
  }
  
  public final boolean isBlankInput()
  {
    boolean bool2 = false;
    int i = 0;
    int j = charAt(i);
    boolean bool1;
    if (j == 26)
    {
      bool1 = true;
      label19:
      return bool1;
    }
    if ((j <= 32) && ((j == 32) || (j == 10) || (j == 13) || (j == 9) || (j == 12) || (j == 8))) {}
    for (j = 1;; j = 0)
    {
      bool1 = bool2;
      if (j == 0) {
        break label19;
      }
      i += 1;
      break;
    }
  }
  
  public final boolean isEnabled(Feature paramFeature)
  {
    return (this.features & paramFeature.mask) != 0;
  }
  
  public final long longValue()
    throws NumberFormatException
  {
    long l1 = 0L;
    int i = this.np;
    int n = this.np + this.sp;
    int j;
    long l2;
    int k;
    if (charAt(this.np) == '-')
    {
      j = 1;
      l2 = -9223372036854775808L;
      i += 1;
      if (i >= n) {
        break label246;
      }
      k = i + 1;
      l1 = -(charAt(i) - '0');
      i = k;
    }
    label67:
    label88:
    label246:
    for (;;)
    {
      if (i < n)
      {
        k = i + 1;
        if (i >= this.len)
        {
          i = 26;
          m = k;
          if (i != 76)
          {
            m = k;
            if (i != 83) {
              if (i != 66) {
                break label155;
              }
            }
          }
        }
      }
      for (int m = k;; m = i)
      {
        if (j != 0)
        {
          if (m > this.np + 1)
          {
            return l1;
            j = 0;
            l2 = -9223372036854775807L;
            break;
            i = this.text.charAt(i);
            break label88;
            i -= 48;
            if (l1 < -922337203685477580L) {
              throw new NumberFormatException(numberString());
            }
            l1 *= 10L;
            if (l1 < i + l2) {
              throw new NumberFormatException(numberString());
            }
            l1 -= i;
            i = k;
            break label67;
          }
          throw new NumberFormatException(numberString());
        }
        return -l1;
      }
    }
  }
  
  public boolean matchField(long paramLong)
  {
    char c = '\032';
    int i = 1;
    int j = this.ch;
    int m = this.bp + 1;
    label27:
    long l;
    int k;
    label36:
    int n;
    if (j == 34)
    {
      l = -2128831035L;
      k = m;
      if (k >= this.len) {
        break label566;
      }
      n = this.text.charAt(k);
      if (n != j) {
        break label199;
      }
      i = k - m + 1 + i;
    }
    label281:
    label566:
    for (;;)
    {
      if (l != paramLong)
      {
        this.matchStat = -2;
        return false;
        if (j == 39) {
          break label27;
        }
        if ((j <= 32) && ((j == 32) || (j == 10) || (j == 13) || (j == 9) || (j == 12) || (j == 8)))
        {
          j = this.bp + i;
          if (j >= this.len) {}
          for (j = 26;; j = this.text.charAt(j))
          {
            i += 1;
            break;
          }
        }
        this.matchStat = -2;
        return false;
        label199:
        l = (l ^ n) * 16777619L;
        k += 1;
        break label36;
      }
      k = this.bp;
      j = i + 1;
      i += k;
      if (i >= this.len)
      {
        i = 26;
        if (i != 58) {
          break label348;
        }
        j += this.bp;
        if (j < this.len) {
          break label334;
        }
        i = 26;
        if (i != 123) {
          break label467;
        }
        this.bp = (j + 1);
        if (this.bp < this.len) {
          break label452;
        }
      }
      for (;;)
      {
        this.ch = c;
        this.token = 12;
        return true;
        i = this.text.charAt(i);
        break;
        label334:
        i = this.text.charAt(j);
        break label281;
        label348:
        if ((i <= 32) && ((i == 32) || (i == 10) || (i == 13) || (i == 9) || (i == 12) || (i == 8)))
        {
          i = this.bp + j;
          if (i >= this.len) {}
          for (i = 26;; i = this.text.charAt(i))
          {
            j += 1;
            break;
          }
        }
        throw new JSONException("match feild error expect ':'");
        label452:
        c = this.text.charAt(this.bp);
      }
      label467:
      if (i == 91)
      {
        this.bp = (j + 1);
        if (this.bp >= this.len) {}
        for (;;)
        {
          this.ch = c;
          this.token = 14;
          break;
          c = this.text.charAt(this.bp);
        }
      }
      this.bp = j;
      if (this.bp >= this.len) {}
      for (;;)
      {
        this.ch = c;
        nextToken();
        break;
        c = this.text.charAt(this.bp);
      }
    }
  }
  
  public char next()
  {
    int i = this.bp + 1;
    this.bp = i;
    if (i >= this.len) {}
    for (char c = '\032';; c = this.text.charAt(i))
    {
      this.ch = c;
      return c;
    }
  }
  
  public final void nextIdent()
  {
    for (;;)
    {
      if ((this.ch <= ' ') && ((this.ch == ' ') || (this.ch == '\n') || (this.ch == '\r') || (this.ch == '\t') || (this.ch == '\f') || (this.ch == '\b'))) {}
      for (int i = 1; i == 0; i = 0)
      {
        if ((this.ch != '_') && (!Character.isLetter(this.ch))) {
          break label106;
        }
        scanIdent();
        return;
      }
      next();
    }
    label106:
    nextToken();
  }
  
  public final void nextToken()
  {
    char c = '\032';
    this.sp = 0;
    for (;;)
    {
      this.pos = this.bp;
      if (this.ch == '/')
      {
        skipComment();
      }
      else
      {
        if (this.ch == '"')
        {
          scanString();
          return;
        }
        if (((this.ch >= '0') && (this.ch <= '9')) || (this.ch == '-'))
        {
          scanNumber();
          return;
        }
        if (this.ch == ',')
        {
          next();
          this.token = 16;
          return;
        }
        int i;
        switch (this.ch)
        {
        default: 
          if ((this.bp == this.len) || ((this.ch == '\032') && (this.bp + 1 == this.len))) {
            i = 1;
          }
          break;
        }
        for (;;)
        {
          if (i != 0)
          {
            if (this.token == 20)
            {
              throw new JSONException("EOF error");
              scanString();
              return;
              next();
              break;
              if (this.text.startsWith("true", this.bp))
              {
                this.bp += 4;
                this.ch = charAt(this.bp);
                if ((this.ch == ' ') || (this.ch == ',') || (this.ch == '}') || (this.ch == ']') || (this.ch == '\n') || (this.ch == '\r') || (this.ch == '\t') || (this.ch == '\032') || (this.ch == '\f') || (this.ch == '\b') || (this.ch == ':'))
                {
                  this.token = 6;
                  return;
                }
              }
              throw new JSONException("scan true error");
              scanIdent();
              return;
              if (this.text.startsWith("false", this.bp))
              {
                this.bp += 5;
                this.ch = charAt(this.bp);
                if ((this.ch == ' ') || (this.ch == ',') || (this.ch == '}') || (this.ch == ']') || (this.ch == '\n') || (this.ch == '\r') || (this.ch == '\t') || (this.ch == '\032') || (this.ch == '\f') || (this.ch == '\b') || (this.ch == ':'))
                {
                  this.token = 7;
                  return;
                }
              }
              throw new JSONException("scan false error");
              i = 0;
              if (this.text.startsWith("null", this.bp))
              {
                this.bp += 4;
                i = 8;
              }
              while (i != 0)
              {
                this.ch = charAt(this.bp);
                if ((this.ch != ' ') && (this.ch != ',') && (this.ch != '}') && (this.ch != ']') && (this.ch != '\n') && (this.ch != '\r') && (this.ch != '\t') && (this.ch != '\032') && (this.ch != '\f') && (this.ch != '\b')) {
                  break;
                }
                this.token = i;
                return;
                if (this.text.startsWith("new", this.bp))
                {
                  this.bp += 3;
                  i = 9;
                }
              }
              throw new JSONException("scan null/new error");
              next();
              this.token = 10;
              return;
              next();
              this.token = 11;
              return;
              i = this.bp + 1;
              this.bp = i;
              if (i >= this.len) {}
              for (;;)
              {
                this.ch = c;
                this.token = 14;
                return;
                c = this.text.charAt(i);
              }
              next();
              this.token = 15;
              return;
              i = this.bp + 1;
              this.bp = i;
              if (i >= this.len) {}
              for (;;)
              {
                this.ch = c;
                this.token = 12;
                return;
                c = this.text.charAt(i);
              }
              i = this.bp + 1;
              this.bp = i;
              if (i >= this.len) {}
              for (;;)
              {
                this.ch = c;
                this.token = 13;
                return;
                c = this.text.charAt(i);
              }
              next();
              this.token = 17;
              return;
              i = 0;
              continue;
            }
            this.token = 20;
            i = this.eofPos;
            this.bp = i;
            this.pos = i;
            return;
          }
        }
        if ((this.ch > '\037') && (this.ch != '')) {
          break;
        }
        next();
      }
    }
    this.token = 1;
    next();
  }
  
  public final void nextToken(int paramInt)
  {
    char c = '\032';
    this.sp = 0;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((this.ch == ' ') || (this.ch == '\n') || (this.ch == '\r') || (this.ch == '\t') || (this.ch == '\f') || (this.ch == '\b'))
      {
        next();
        break;
        if (this.ch == '{')
        {
          this.token = 12;
          paramInt = this.bp + 1;
          this.bp = paramInt;
          if (paramInt >= this.len) {}
          for (;;)
          {
            this.ch = c;
            return;
            c = this.text.charAt(paramInt);
          }
        }
        if (this.ch == '[')
        {
          this.token = 14;
          paramInt = this.bp + 1;
          this.bp = paramInt;
          if (paramInt >= this.len) {}
          for (;;)
          {
            this.ch = c;
            return;
            c = this.text.charAt(paramInt);
          }
          if (this.ch == ',')
          {
            this.token = 16;
            paramInt = this.bp + 1;
            this.bp = paramInt;
            if (paramInt >= this.len) {}
            for (;;)
            {
              this.ch = c;
              return;
              c = this.text.charAt(paramInt);
            }
          }
          if (this.ch == '}')
          {
            this.token = 13;
            paramInt = this.bp + 1;
            this.bp = paramInt;
            if (paramInt >= this.len) {}
            for (;;)
            {
              this.ch = c;
              return;
              c = this.text.charAt(paramInt);
            }
          }
          if (this.ch == ']')
          {
            this.token = 15;
            paramInt = this.bp + 1;
            this.bp = paramInt;
            if (paramInt >= this.len) {}
            for (;;)
            {
              this.ch = c;
              return;
              c = this.text.charAt(paramInt);
            }
          }
          if (this.ch == '\032')
          {
            this.token = 20;
            return;
            if ((this.ch >= '0') && (this.ch <= '9'))
            {
              this.pos = this.bp;
              scanNumber();
              return;
            }
            if (this.ch == '"')
            {
              this.pos = this.bp;
              scanString();
              return;
            }
            if (this.ch == '[')
            {
              this.token = 14;
              next();
              return;
            }
            if (this.ch == '{')
            {
              this.token = 12;
              next();
              return;
              if (this.ch == '"')
              {
                this.pos = this.bp;
                scanString();
                return;
              }
              if ((this.ch >= '0') && (this.ch <= '9'))
              {
                this.pos = this.bp;
                scanNumber();
                return;
              }
              if (this.ch == '{')
              {
                this.token = 12;
                paramInt = this.bp + 1;
                this.bp = paramInt;
                if (paramInt >= this.len) {}
                for (;;)
                {
                  this.ch = c;
                  return;
                  c = this.text.charAt(paramInt);
                }
                if (this.ch == '[')
                {
                  this.token = 14;
                  next();
                  return;
                }
                if (this.ch == '{')
                {
                  this.token = 12;
                  next();
                  return;
                  if (this.ch == ']')
                  {
                    this.token = 15;
                    next();
                    return;
                  }
                  if (this.ch == '\032')
                  {
                    this.token = 20;
                    return;
                    nextIdent();
                    return;
                  }
                }
              }
            }
          }
        }
      }
    }
    nextToken();
  }
  
  public final void nextTokenWithChar(char paramChar)
  {
    this.sp = 0;
    for (;;)
    {
      if (this.ch == paramChar)
      {
        int i = this.bp + 1;
        this.bp = i;
        if (i >= this.len) {}
        for (paramChar = '\032';; paramChar = this.text.charAt(i))
        {
          this.ch = paramChar;
          nextToken();
          return;
        }
      }
      if ((this.ch != ' ') && (this.ch != '\n') && (this.ch != '\r') && (this.ch != '\t') && (this.ch != '\f') && (this.ch != '\b')) {
        break;
      }
      next();
    }
    throw new JSONException("not match " + paramChar + " - " + this.ch);
  }
  
  public final String numberString()
  {
    int i = this.np;
    int j = this.sp;
    int k = this.text.charAt(i + j - 1);
    j = this.sp;
    if ((k != 76) && (k != 83) && (k != 66) && (k != 70))
    {
      i = j;
      if (k != 68) {}
    }
    else
    {
      i = j - 1;
    }
    return subString(this.np, i);
  }
  
  public boolean scanBoolean()
  {
    boolean bool = false;
    int i = 1;
    if (this.text.startsWith("false", this.bp)) {
      i = 5;
    }
    do
    {
      for (;;)
      {
        this.bp = (i + this.bp);
        this.ch = charAt(this.bp);
        return bool;
        if (this.text.startsWith("true", this.bp))
        {
          i = 4;
          bool = true;
        }
        else
        {
          if (this.ch != '1') {
            break;
          }
          bool = true;
        }
      }
    } while (this.ch == '0');
    this.matchStat = -1;
    return false;
  }
  
  public boolean scanFieldBoolean(long paramLong)
  {
    boolean bool = true;
    char c = '\032';
    this.matchStat = 0;
    int i = matchFieldHash(paramLong);
    if (i == 0) {
      return false;
    }
    int k;
    int j;
    if (this.text.startsWith("false", this.bp + i))
    {
      i += 5;
      bool = false;
      k = this.bp;
      j = i + 1;
      i += k;
      if (i < this.len) {
        break label248;
      }
      i = 26;
      label85:
      if (i != 44) {
        break label275;
      }
      this.bp += j - 1;
      i = this.bp + 1;
      this.bp = i;
      if (i < this.len) {
        break label262;
      }
    }
    label262:
    for (c = '\032';; c = this.text.charAt(i))
    {
      this.ch = c;
      this.matchStat = 3;
      this.token = 16;
      return bool;
      if (this.text.startsWith("true", this.bp + i))
      {
        i += 4;
        break;
      }
      if (this.text.startsWith("\"false\"", this.bp + i))
      {
        i += 7;
        bool = false;
        break;
      }
      if (this.text.startsWith("\"true\"", this.bp + i))
      {
        i += 6;
        break;
      }
      this.matchStat = -1;
      return false;
      label248:
      i = this.text.charAt(i);
      break label85;
    }
    label275:
    if (i == 125)
    {
      k = this.bp;
      i = j + 1;
      j = charAt(k + j);
      if (j == 44)
      {
        this.token = 16;
        this.bp += i - 1;
        i = this.bp + 1;
        this.bp = i;
        if (i >= this.len) {
          this.ch = c;
        }
      }
      for (;;)
      {
        this.matchStat = 4;
        return bool;
        c = this.text.charAt(i);
        break;
        if (j == 93)
        {
          this.token = 15;
          this.bp += i - 1;
          i = this.bp + 1;
          this.bp = i;
          if (i >= this.len) {}
          for (;;)
          {
            this.ch = c;
            break;
            c = this.text.charAt(i);
          }
        }
        if (j == 125)
        {
          this.token = 13;
          this.bp += i - 1;
          i = this.bp + 1;
          this.bp = i;
          if (i >= this.len) {}
          for (;;)
          {
            this.ch = c;
            break;
            c = this.text.charAt(i);
          }
        }
        if (j != 26) {
          break label555;
        }
        this.token = 20;
        this.bp += i - 1;
        this.ch = '\032';
      }
      label555:
      this.matchStat = -1;
      return false;
    }
    this.matchStat = -1;
    return false;
  }
  
  public final double scanFieldDouble(long paramLong)
  {
    this.matchStat = 0;
    int j = matchFieldHash(paramLong);
    if (j == 0) {
      return 0.0D;
    }
    int k = this.bp;
    int i = j + 1;
    j = charAt(j + k);
    int i4 = this.bp + i - 1;
    int m;
    if (j == 45)
    {
      k = 1;
      if (k == 0) {
        break label838;
      }
      m = this.bp;
      j = i + 1;
      m = charAt(m + i);
      i = j;
      j = m;
    }
    label513:
    label805:
    label838:
    for (;;)
    {
      int n;
      int i2;
      int i1;
      if ((j >= 48) && (j <= 57))
      {
        j -= 48;
        m = i;
        i = j;
        for (;;)
        {
          n = this.bp;
          j = m + 1;
          i2 = charAt(m + n);
          if ((i2 < 48) || (i2 > 57)) {
            break;
          }
          i = i * 10 + (i2 - 48);
          m = j;
        }
        k = 0;
        break;
        if (i2 == 46) {
          m = 1;
        }
        while (m != 0)
        {
          m = charAt(this.bp + j);
          if ((m >= 48) && (m <= 57))
          {
            i = m - 48 + i * 10;
            m = 10;
            n = j + 1;
            j = m;
            for (;;)
            {
              i1 = this.bp;
              m = n + 1;
              i1 = charAt(n + i1);
              if ((i1 < 48) || (i1 > 57)) {
                break;
              }
              i = i * 10 + (i1 - 48);
              j *= 10;
              n = m;
            }
            m = 0;
          }
          else
          {
            this.matchStat = -1;
            return 0.0D;
            i2 = m;
            n = i;
            m = j;
            i = i2;
            j = i1;
          }
        }
      }
      for (;;)
      {
        int i3;
        if ((j == 101) || (j == 69))
        {
          i1 = 1;
          i3 = j;
          i2 = i;
          if (i1 == 0) {
            break label513;
          }
          i2 = this.bp;
          j = i + 1;
          i = charAt(i2 + i);
          if ((i != 43) && (i != 45)) {
            break label805;
          }
          i2 = this.bp;
          i = j + 1;
          i2 = charAt(i2 + j);
          j = i;
          i = i2;
        }
        for (;;)
        {
          i3 = i;
          i2 = j;
          if (i >= 48)
          {
            i3 = i;
            i2 = j;
            if (i <= 57)
            {
              i = charAt(this.bp + j);
              j += 1;
              continue;
              i1 = 0;
              break;
            }
          }
          i = this.bp + i2 - i4 - 1;
          double d1;
          if ((i1 == 0) && (i < 10))
          {
            double d2 = n / m;
            d1 = d2;
            if (k != 0) {
              d1 = -d2;
            }
          }
          while (i3 == 44)
          {
            this.bp += i2 - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return d1;
            d1 = Double.parseDouble(subString(i4, i));
            continue;
            this.matchStat = -1;
            return 0.0D;
          }
          if (i3 == 125)
          {
            j = this.bp;
            i = i2 + 1;
            j = charAt(j + i2);
            if (j == 44)
            {
              this.token = 16;
              this.bp += i - 1;
              next();
            }
            for (;;)
            {
              this.matchStat = 4;
              return d1;
              if (j == 93)
              {
                this.token = 15;
                this.bp += i - 1;
                next();
              }
              else if (j == 125)
              {
                this.token = 13;
                this.bp += i - 1;
                next();
              }
              else
              {
                if (j != 26) {
                  break;
                }
                this.bp += i - 1;
                this.token = 20;
                this.ch = '\032';
              }
            }
            this.matchStat = -1;
            return 0.0D;
          }
          this.matchStat = -1;
          return 0.0D;
        }
        i1 = 1;
        n = i;
        i = i2;
        m = j;
        j = i;
        i = m;
        m = i1;
      }
    }
  }
  
  public final double[] scanFieldDoubleArray(long paramLong)
  {
    this.matchStat = 0;
    int i = matchFieldHash(paramLong);
    if (i == 0) {
      return null;
    }
    int k = this.bp;
    int j = i + 1;
    i += k;
    if (i >= this.len) {}
    for (i = 26; i != 91; i = this.text.charAt(i))
    {
      this.matchStat = -2;
      return null;
    }
    i = this.bp;
    k = j + 1;
    i += j;
    Object localObject;
    int n;
    int i5;
    int i1;
    label150:
    label185:
    label212:
    int m;
    if (i >= this.len)
    {
      i = 26;
      localObject = new double[16];
      j = i;
      n = 0;
      i = k;
      i5 = this.bp + i - 1;
      if (j != 45) {
        break label292;
      }
      i1 = 1;
      k = j;
      j = i;
      if (i1 != 0)
      {
        j = this.bp + i;
        if (j < this.len) {
          break label298;
        }
        k = 26;
        j = i + 1;
      }
      if ((k < 48) || (k > 57)) {
        break label1064;
      }
      i = k - 48;
      m = this.bp;
      k = j + 1;
      j += m;
      if (j < this.len) {
        break label312;
      }
    }
    label292:
    label298:
    label312:
    for (j = 26;; j = this.text.charAt(j))
    {
      if ((j < 48) || (j > 57)) {
        break label326;
      }
      i = i * 10 + (j - 48);
      j = k;
      break label212;
      i = this.text.charAt(i);
      break;
      i1 = 0;
      break label150;
      k = this.text.charAt(j);
      break label185;
    }
    label326:
    if (j == 46)
    {
      m = 1;
      if (m == 0) {
        break label1296;
      }
      j = this.bp + k;
      if (j < this.len) {
        break label483;
      }
      j = 26;
      label363:
      if ((j < 48) || (j > 57)) {
        break label511;
      }
      k += 1;
      m = 10;
      i = i * 10 + (j - 48);
      j = m;
      i2 = this.bp;
      m = k + 1;
      k += i2;
      if (k < this.len) {
        break label497;
      }
      k = 26;
    }
    for (;;)
    {
      label404:
      if ((k >= 48) && (k <= 57))
      {
        i = i * 10 + (k - 48);
        j *= 10;
        k = m;
        break label404;
        m = 0;
        break;
        label483:
        j = this.text.charAt(j);
        break label363;
        label497:
        k = this.text.charAt(k);
        continue;
        label511:
        this.matchStat = -1;
        return null;
      }
    }
    int i3 = i;
    int i2 = j;
    i = m;
    j = k;
    for (;;)
    {
      int i4;
      if ((j == 101) || (j == 69))
      {
        i4 = 1;
        m = j;
        k = i;
        if (i4 == 0) {
          break label759;
        }
        k = this.bp;
        j = i + 1;
        i = k + i;
        if (i < this.len) {
          break label713;
        }
        i = 26;
        label596:
        if ((i != 43) && (i != 45)) {
          break label1293;
        }
        i = this.bp;
        k = j + 1;
        i += j;
        if (i < this.len) {
          break label727;
        }
        i = 26;
        j = k;
      }
      label646:
      label1163:
      label1293:
      for (;;)
      {
        m = i;
        k = j;
        if (i >= 48)
        {
          m = i;
          k = j;
          if (i <= 57)
          {
            i = this.bp + j;
            if (i >= this.len) {}
            for (i = 26;; i = this.text.charAt(i))
            {
              j += 1;
              break label646;
              i4 = 0;
              break;
              label713:
              i = this.text.charAt(i);
              break label596;
              label727:
              i = this.text.charAt(i);
              j = k;
              break label646;
            }
          }
        }
        label759:
        i = this.bp + k - i5 - 1;
        double d1;
        label806:
        double[] arrayOfDouble;
        if ((i4 == 0) && (i < 10))
        {
          double d2 = i3 / i2;
          d1 = d2;
          if (i1 != 0) {
            d1 = -d2;
          }
          if (n < localObject.length) {
            break label1290;
          }
          arrayOfDouble = new double[localObject.length * 3 / 2];
          System.arraycopy(localObject, 0, arrayOfDouble, 0, n);
          localObject = arrayOfDouble;
        }
        for (;;)
        {
          j = n + 1;
          localObject[n] = d1;
          if (m == 44)
          {
            i = this.bp;
            m = k + 1;
            i += k;
            if (i >= this.len)
            {
              i = 26;
              k = m;
            }
          }
          for (;;)
          {
            n = j;
            j = i;
            i = k;
            break;
            d1 = Double.parseDouble(subString(i5, i));
            break label806;
            i = this.text.charAt(i);
            k = m;
            continue;
            if (m == 93)
            {
              i = this.bp;
              m = k + 1;
              i += k;
              if (i >= this.len)
              {
                i = 26;
                if (j == localObject.length) {
                  break label1280;
                }
                arrayOfDouble = new double[j];
                System.arraycopy(localObject, 0, arrayOfDouble, 0, j);
                localObject = arrayOfDouble;
              }
              for (;;)
              {
                if (i == 44)
                {
                  this.bp += m - 1;
                  next();
                  this.matchStat = 3;
                  this.token = 16;
                  return localObject;
                  i = this.text.charAt(i);
                  break;
                  label1064:
                  this.matchStat = -1;
                  return null;
                }
                if (i == 125)
                {
                  i = this.bp;
                  j = m + 1;
                  i += m;
                  if (i >= this.len)
                  {
                    i = 26;
                    if (i != 44) {
                      break label1163;
                    }
                    this.token = 16;
                    this.bp += j - 1;
                    next();
                  }
                  for (;;)
                  {
                    this.matchStat = 4;
                    return localObject;
                    i = this.text.charAt(i);
                    break;
                    if (i == 93)
                    {
                      this.token = 15;
                      this.bp += j - 1;
                      next();
                    }
                    else if (i == 125)
                    {
                      this.token = 13;
                      this.bp += j - 1;
                      next();
                    }
                    else
                    {
                      if (i != 26) {
                        break label1266;
                      }
                      this.bp += j - 1;
                      this.token = 20;
                      this.ch = '\032';
                    }
                  }
                  label1266:
                  this.matchStat = -1;
                  return null;
                }
                this.matchStat = -1;
                return null;
              }
            }
            i = m;
          }
        }
      }
      label1280:
      label1290:
      label1296:
      i2 = 1;
      i3 = i;
      i = k;
    }
  }
  
  public final double[][] scanFieldDoubleArray2(long paramLong)
  {
    this.matchStat = 0;
    int i = matchFieldHash(paramLong);
    if (i == 0) {
      return (double[][])null;
    }
    int j = this.bp;
    int k = i + 1;
    i += j;
    if (i >= this.len) {}
    for (i = 26; i != 91; i = this.text.charAt(i))
    {
      this.matchStat = -2;
      return (double[][])null;
    }
    i = this.bp;
    j = k + 1;
    i += k;
    Object localObject2;
    int n;
    label167:
    Object localObject1;
    int i1;
    label184:
    int i6;
    int i2;
    label205:
    label240:
    int m;
    if (i >= this.len)
    {
      i = 26;
      localObject2 = new double[16][];
      n = 0;
      if (i != 91) {
        break label1157;
      }
      i = this.bp;
      k = j + 1;
      i += j;
      if (i < this.len) {
        break label347;
      }
      i = 26;
      localObject1 = new double[16];
      j = i;
      i1 = 0;
      i = k;
      i6 = this.bp + i - 1;
      if (j != 45) {
        break label361;
      }
      i2 = 1;
      k = j;
      j = i;
      if (i2 != 0)
      {
        j = this.bp + i;
        if (j < this.len) {
          break label367;
        }
        k = 26;
        j = i + 1;
      }
      if ((k < 48) || (k > 57)) {
        break label1173;
      }
      i = k - 48;
      label267:
      m = this.bp;
      k = j + 1;
      j += m;
      if (j < this.len) {
        break label381;
      }
    }
    label347:
    label361:
    label367:
    label381:
    for (j = 26;; j = this.text.charAt(j))
    {
      if ((j < 48) || (j > 57)) {
        break label395;
      }
      i = i * 10 + (j - 48);
      j = k;
      break label267;
      i = this.text.charAt(i);
      break;
      i = this.text.charAt(i);
      break label167;
      i2 = 0;
      break label205;
      k = this.text.charAt(j);
      break label240;
    }
    label395:
    label461:
    int i3;
    label548:
    label562:
    int i4;
    if (j == 46)
    {
      j = this.bp + k;
      if (j >= this.len)
      {
        j = 26;
        if ((j < 48) || (j > 57)) {
          break label562;
        }
        i = j - 48 + i * 10;
        j = 10;
        k += 1;
        i3 = this.bp;
        m = k + 1;
        k += i3;
        if (k < this.len) {
          break label548;
        }
        k = 26;
      }
      for (;;)
      {
        if ((k >= 48) && (k <= 57))
        {
          i = i * 10 + (k - 48);
          j *= 10;
          k = m;
          break label461;
          j = this.text.charAt(j);
          break;
          k = this.text.charAt(k);
          continue;
          this.matchStat = -1;
          return (double[][])null;
        }
      }
      i4 = i;
      i3 = j;
      i = m;
      j = k;
    }
    for (;;)
    {
      int i5;
      if ((j == 101) || (j == 69))
      {
        i5 = 1;
        m = j;
        k = i;
        if (i5 == 0) {
          break label813;
        }
        k = this.bp;
        j = i + 1;
        i = k + i;
        if (i < this.len) {
          break label767;
        }
        i = 26;
        label650:
        if ((i != 43) && (i != 45)) {
          break label1535;
        }
        i = this.bp;
        k = j + 1;
        i += j;
        if (i < this.len) {
          break label781;
        }
        i = 26;
        j = k;
      }
      label700:
      label860:
      label1518:
      label1532:
      label1535:
      for (;;)
      {
        m = i;
        k = j;
        if (i >= 48)
        {
          m = i;
          k = j;
          if (i <= 57)
          {
            i = this.bp + j;
            if (i >= this.len) {}
            for (i = 26;; i = this.text.charAt(i))
            {
              j += 1;
              break label700;
              i5 = 0;
              break;
              label767:
              i = this.text.charAt(i);
              break label650;
              i = this.text.charAt(i);
              j = k;
              break label700;
            }
          }
        }
        i = this.bp + k - i6 - 1;
        double d1;
        Object localObject3;
        if ((i5 == 0) && (i < 10))
        {
          double d2 = i4 / i3;
          d1 = d2;
          if (i2 != 0) {
            d1 = -d2;
          }
          if (i1 < localObject1.length) {
            break label1532;
          }
          localObject3 = new double[localObject1.length * 3 / 2];
          System.arraycopy(localObject1, 0, localObject3, 0, i1);
          localObject1 = localObject3;
        }
        for (;;)
        {
          j = i1 + 1;
          localObject1[i1] = d1;
          if (m == 44)
          {
            i = this.bp;
            m = k + 1;
            i += k;
            if (i >= this.len)
            {
              i = 26;
              k = m;
            }
          }
          for (;;)
          {
            i1 = j;
            j = i;
            i = k;
            break label184;
            d1 = Double.parseDouble(subString(i6, i));
            break label860;
            i = this.text.charAt(i);
            k = m;
            continue;
            if (m == 93)
            {
              i = this.bp;
              m = k + 1;
              i += k;
              if (i >= this.len)
              {
                i = 26;
                localObject3 = localObject1;
                if (j != localObject1.length)
                {
                  localObject3 = new double[j];
                  System.arraycopy(localObject1, 0, localObject3, 0, j);
                }
                if (n < localObject2.length) {
                  break label1518;
                }
                localObject1 = new double[localObject2.length * 3 / 2][];
                System.arraycopy(localObject3, 0, localObject1, 0, j);
              }
              for (;;)
              {
                k = n + 1;
                localObject1[n] = localObject3;
                if (i == 44)
                {
                  i = this.bp;
                  j = m + 1;
                  i += m;
                  if (i >= this.len) {
                    i = 26;
                  }
                }
                for (;;)
                {
                  n = k;
                  localObject2 = localObject1;
                  break;
                  break;
                  i = this.text.charAt(i);
                  break label1036;
                  this.matchStat = -1;
                  return (double[][])null;
                  i = this.text.charAt(i);
                  continue;
                  if (i == 93)
                  {
                    i = this.bp;
                    j = m + 1;
                    i += m;
                    if (i >= this.len) {}
                    for (i = 26;; i = this.text.charAt(i))
                    {
                      localObject2 = localObject1;
                      if (k != localObject1.length)
                      {
                        localObject2 = new double[k][];
                        System.arraycopy(localObject1, 0, localObject2, 0, k);
                      }
                      if (i != 44) {
                        break;
                      }
                      this.bp += j - 1;
                      next();
                      this.matchStat = 3;
                      this.token = 16;
                      return localObject2;
                    }
                    if (i == 125)
                    {
                      k = this.bp;
                      i = j + 1;
                      j = charAt(k + j);
                      if (j == 44)
                      {
                        this.token = 16;
                        this.bp += i - 1;
                        next();
                      }
                      for (;;)
                      {
                        this.matchStat = 4;
                        return localObject2;
                        if (j == 93)
                        {
                          this.token = 15;
                          this.bp += i - 1;
                          next();
                        }
                        else if (j == 125)
                        {
                          this.token = 13;
                          this.bp += i - 1;
                          next();
                        }
                        else
                        {
                          if (j != 26) {
                            break;
                          }
                          this.bp += i - 1;
                          this.token = 20;
                          this.ch = '\032';
                        }
                      }
                      this.matchStat = -1;
                      return (double[][])null;
                    }
                    this.matchStat = -1;
                    return (double[][])null;
                  }
                  j = m;
                }
                localObject1 = localObject2;
              }
            }
            i = m;
          }
        }
      }
      label781:
      label813:
      i3 = 1;
      label1036:
      label1173:
      i4 = i;
      label1157:
      i = k;
    }
  }
  
  public final float scanFieldFloat(long paramLong)
  {
    this.matchStat = 0;
    int j = matchFieldHash(paramLong);
    if (j == 0) {
      return 0.0F;
    }
    int k = this.bp;
    int i = j + 1;
    j = charAt(j + k);
    int i4 = this.bp + i - 1;
    int m;
    if (j == 45)
    {
      k = 1;
      if (k == 0) {
        break label838;
      }
      m = this.bp;
      j = i + 1;
      m = charAt(m + i);
      i = j;
      j = m;
    }
    label513:
    label805:
    label838:
    for (;;)
    {
      int n;
      int i2;
      int i1;
      if ((j >= 48) && (j <= 57))
      {
        j -= 48;
        m = i;
        i = j;
        for (;;)
        {
          n = this.bp;
          j = m + 1;
          i2 = charAt(m + n);
          if ((i2 < 48) || (i2 > 57)) {
            break;
          }
          i = i * 10 + (i2 - 48);
          m = j;
        }
        k = 0;
        break;
        if (i2 == 46) {
          m = 1;
        }
        while (m != 0)
        {
          m = charAt(this.bp + j);
          if ((m >= 48) && (m <= 57))
          {
            i = m - 48 + i * 10;
            m = 10;
            n = j + 1;
            j = m;
            for (;;)
            {
              i1 = this.bp;
              m = n + 1;
              i1 = charAt(n + i1);
              if ((i1 < 48) || (i1 > 57)) {
                break;
              }
              i = i * 10 + (i1 - 48);
              j *= 10;
              n = m;
            }
            m = 0;
          }
          else
          {
            this.matchStat = -1;
            return 0.0F;
            i2 = m;
            n = i;
            m = j;
            i = i2;
            j = i1;
          }
        }
      }
      for (;;)
      {
        int i3;
        if ((j == 101) || (j == 69))
        {
          i1 = 1;
          i3 = j;
          i2 = i;
          if (i1 == 0) {
            break label513;
          }
          i2 = this.bp;
          j = i + 1;
          i = charAt(i2 + i);
          if ((i != 43) && (i != 45)) {
            break label805;
          }
          i2 = this.bp;
          i = j + 1;
          i2 = charAt(i2 + j);
          j = i;
          i = i2;
        }
        for (;;)
        {
          i3 = i;
          i2 = j;
          if (i >= 48)
          {
            i3 = i;
            i2 = j;
            if (i <= 57)
            {
              i = charAt(this.bp + j);
              j += 1;
              continue;
              i1 = 0;
              break;
            }
          }
          i = this.bp + i2 - i4 - 1;
          float f1;
          if ((i1 == 0) && (i < 10))
          {
            float f2 = n / m;
            f1 = f2;
            if (k != 0) {
              f1 = -f2;
            }
          }
          while (i3 == 44)
          {
            this.bp += i2 - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return f1;
            f1 = Float.parseFloat(subString(i4, i));
            continue;
            this.matchStat = -1;
            return 0.0F;
          }
          if (i3 == 125)
          {
            j = this.bp;
            i = i2 + 1;
            j = charAt(j + i2);
            if (j == 44)
            {
              this.token = 16;
              this.bp += i - 1;
              next();
            }
            for (;;)
            {
              this.matchStat = 4;
              return f1;
              if (j == 93)
              {
                this.token = 15;
                this.bp += i - 1;
                next();
              }
              else if (j == 125)
              {
                this.token = 13;
                this.bp += i - 1;
                next();
              }
              else
              {
                if (j != 26) {
                  break;
                }
                this.bp += i - 1;
                this.token = 20;
                this.ch = '\032';
              }
            }
            this.matchStat = -1;
            return 0.0F;
          }
          this.matchStat = -1;
          return 0.0F;
        }
        i1 = 1;
        n = i;
        i = i2;
        m = j;
        j = i;
        i = m;
        m = i1;
      }
    }
  }
  
  public final float[] scanFieldFloatArray(long paramLong)
  {
    this.matchStat = 0;
    int i = matchFieldHash(paramLong);
    if (i == 0) {
      return null;
    }
    int k = this.bp;
    int j = i + 1;
    i += k;
    if (i >= this.len) {}
    for (i = 26; i != 91; i = this.text.charAt(i))
    {
      this.matchStat = -2;
      return null;
    }
    i = this.bp;
    k = j + 1;
    i += j;
    Object localObject;
    int n;
    int i5;
    int i1;
    label150:
    label185:
    label212:
    int m;
    if (i >= this.len)
    {
      i = 26;
      localObject = new float[16];
      j = i;
      n = 0;
      i = k;
      i5 = this.bp + i - 1;
      if (j != 45) {
        break label292;
      }
      i1 = 1;
      k = j;
      j = i;
      if (i1 != 0)
      {
        j = this.bp + i;
        if (j < this.len) {
          break label298;
        }
        k = 26;
        j = i + 1;
      }
      if ((k < 48) || (k > 57)) {
        break label1059;
      }
      i = k - 48;
      m = this.bp;
      k = j + 1;
      j += m;
      if (j < this.len) {
        break label312;
      }
    }
    label292:
    label298:
    label312:
    for (j = 26;; j = this.text.charAt(j))
    {
      if ((j < 48) || (j > 57)) {
        break label326;
      }
      i = i * 10 + (j - 48);
      j = k;
      break label212;
      i = this.text.charAt(i);
      break;
      i1 = 0;
      break label150;
      k = this.text.charAt(j);
      break label185;
    }
    label326:
    if (j == 46)
    {
      m = 1;
      if (m == 0) {
        break label1294;
      }
      j = this.bp + k;
      if (j < this.len) {
        break label483;
      }
      j = 26;
      label363:
      if ((j < 48) || (j > 57)) {
        break label511;
      }
      k += 1;
      m = 10;
      i = i * 10 + (j - 48);
      j = m;
      i2 = this.bp;
      m = k + 1;
      k += i2;
      if (k < this.len) {
        break label497;
      }
      k = 26;
    }
    for (;;)
    {
      label404:
      if ((k >= 48) && (k <= 57))
      {
        i = i * 10 + (k - 48);
        j *= 10;
        k = m;
        break label404;
        m = 0;
        break;
        label483:
        j = this.text.charAt(j);
        break label363;
        label497:
        k = this.text.charAt(k);
        continue;
        label511:
        this.matchStat = -1;
        return null;
      }
    }
    int i3 = i;
    int i2 = j;
    i = m;
    j = k;
    for (;;)
    {
      int i4;
      if ((j == 101) || (j == 69))
      {
        i4 = 1;
        m = j;
        k = i;
        if (i4 == 0) {
          break label759;
        }
        k = this.bp;
        j = i + 1;
        i = k + i;
        if (i < this.len) {
          break label713;
        }
        i = 26;
        label596:
        if ((i != 43) && (i != 45)) {
          break label1291;
        }
        i = this.bp;
        k = j + 1;
        i += j;
        if (i < this.len) {
          break label727;
        }
        i = 26;
        j = k;
      }
      label646:
      label1158:
      label1288:
      label1291:
      for (;;)
      {
        m = i;
        k = j;
        if (i >= 48)
        {
          m = i;
          k = j;
          if (i <= 57)
          {
            i = this.bp + j;
            if (i >= this.len) {}
            for (i = 26;; i = this.text.charAt(i))
            {
              j += 1;
              break label646;
              i4 = 0;
              break;
              label713:
              i = this.text.charAt(i);
              break label596;
              label727:
              i = this.text.charAt(i);
              j = k;
              break label646;
            }
          }
        }
        label759:
        i = this.bp + k - i5 - 1;
        float f;
        if ((i4 == 0) && (i < 10))
        {
          f = i3 / i2;
          if (i1 == 0) {
            break label1288;
          }
          f = -f;
        }
        for (;;)
        {
          label801:
          float[] arrayOfFloat;
          if (n >= localObject.length)
          {
            arrayOfFloat = new float[localObject.length * 3 / 2];
            System.arraycopy(localObject, 0, arrayOfFloat, 0, n);
            localObject = arrayOfFloat;
          }
          for (;;)
          {
            j = n + 1;
            localObject[n] = f;
            if (m == 44)
            {
              i = this.bp;
              m = k + 1;
              i += k;
              if (i >= this.len)
              {
                i = 26;
                k = m;
              }
            }
            for (;;)
            {
              n = j;
              j = i;
              i = k;
              break;
              f = Float.parseFloat(subString(i5, i));
              break label801;
              i = this.text.charAt(i);
              k = m;
              continue;
              if (m == 93)
              {
                i = this.bp;
                m = k + 1;
                i += k;
                if (i >= this.len)
                {
                  i = 26;
                  if (j == localObject.length) {
                    break label1275;
                  }
                  arrayOfFloat = new float[j];
                  System.arraycopy(localObject, 0, arrayOfFloat, 0, j);
                  localObject = arrayOfFloat;
                }
                label1059:
                label1261:
                label1275:
                for (;;)
                {
                  if (i == 44)
                  {
                    this.bp += m - 1;
                    next();
                    this.matchStat = 3;
                    this.token = 16;
                    return localObject;
                    i = this.text.charAt(i);
                    break;
                    this.matchStat = -1;
                    return null;
                  }
                  if (i == 125)
                  {
                    i = this.bp;
                    j = m + 1;
                    i += m;
                    if (i >= this.len)
                    {
                      i = 26;
                      if (i != 44) {
                        break label1158;
                      }
                      this.token = 16;
                      this.bp += j - 1;
                      next();
                    }
                    for (;;)
                    {
                      this.matchStat = 4;
                      return localObject;
                      i = this.text.charAt(i);
                      break;
                      if (i == 93)
                      {
                        this.token = 15;
                        this.bp += j - 1;
                        next();
                      }
                      else if (i == 125)
                      {
                        this.token = 13;
                        this.bp += j - 1;
                        next();
                      }
                      else
                      {
                        if (i != 26) {
                          break label1261;
                        }
                        this.bp += j - 1;
                        this.token = 20;
                        this.ch = '\032';
                      }
                    }
                    this.matchStat = -1;
                    return null;
                  }
                  this.matchStat = -1;
                  return null;
                }
              }
              i = m;
            }
          }
        }
      }
      label1294:
      i2 = 1;
      i3 = i;
      i = k;
    }
  }
  
  public final float[][] scanFieldFloatArray2(long paramLong)
  {
    this.matchStat = 0;
    int i = matchFieldHash(paramLong);
    if (i == 0) {
      return (float[][])null;
    }
    int j = this.bp;
    int k = i + 1;
    i += j;
    if (i >= this.len) {}
    for (i = 26; i != 91; i = this.text.charAt(i))
    {
      this.matchStat = -2;
      return (float[][])null;
    }
    i = this.bp;
    j = k + 1;
    i += k;
    Object localObject2;
    int n;
    label167:
    Object localObject1;
    int i1;
    label184:
    int i6;
    int i2;
    label205:
    label240:
    int m;
    if (i >= this.len)
    {
      i = 26;
      localObject2 = new float[16][];
      n = 0;
      if (i != 91) {
        break label1152;
      }
      i = this.bp;
      k = j + 1;
      i += j;
      if (i < this.len) {
        break label347;
      }
      i = 26;
      localObject1 = new float[16];
      j = i;
      i1 = 0;
      i = k;
      i6 = this.bp + i - 1;
      if (j != 45) {
        break label361;
      }
      i2 = 1;
      k = j;
      j = i;
      if (i2 != 0)
      {
        j = this.bp + i;
        if (j < this.len) {
          break label367;
        }
        k = 26;
        j = i + 1;
      }
      if ((k < 48) || (k > 57)) {
        break label1168;
      }
      i = k - 48;
      label267:
      m = this.bp;
      k = j + 1;
      j += m;
      if (j < this.len) {
        break label381;
      }
    }
    label347:
    label361:
    label367:
    label381:
    for (j = 26;; j = this.text.charAt(j))
    {
      if ((j < 48) || (j > 57)) {
        break label395;
      }
      i = i * 10 + (j - 48);
      j = k;
      break label267;
      i = this.text.charAt(i);
      break;
      i = this.text.charAt(i);
      break label167;
      i2 = 0;
      break label205;
      k = this.text.charAt(j);
      break label240;
    }
    label395:
    label461:
    int i3;
    label548:
    label562:
    int i4;
    if (j == 46)
    {
      j = this.bp + k;
      if (j >= this.len)
      {
        j = 26;
        if ((j < 48) || (j > 57)) {
          break label562;
        }
        i = j - 48 + i * 10;
        j = 10;
        k += 1;
        i3 = this.bp;
        m = k + 1;
        k += i3;
        if (k < this.len) {
          break label548;
        }
        k = 26;
      }
      for (;;)
      {
        if ((k >= 48) && (k <= 57))
        {
          i = i * 10 + (k - 48);
          j *= 10;
          k = m;
          break label461;
          j = this.text.charAt(j);
          break;
          k = this.text.charAt(k);
          continue;
          this.matchStat = -1;
          return (float[][])null;
        }
      }
      i4 = i;
      i3 = j;
      i = m;
      j = k;
    }
    for (;;)
    {
      int i5;
      if ((j == 101) || (j == 69))
      {
        i5 = 1;
        m = j;
        k = i;
        if (i5 == 0) {
          break label813;
        }
        k = this.bp;
        j = i + 1;
        i = k + i;
        if (i < this.len) {
          break label767;
        }
        i = 26;
        label650:
        if ((i != 43) && (i != 45)) {
          break label1533;
        }
        i = this.bp;
        k = j + 1;
        i += j;
        if (i < this.len) {
          break label781;
        }
        i = 26;
        j = k;
      }
      label700:
      label855:
      label1513:
      label1530:
      label1533:
      for (;;)
      {
        m = i;
        k = j;
        if (i >= 48)
        {
          m = i;
          k = j;
          if (i <= 57)
          {
            i = this.bp + j;
            if (i >= this.len) {}
            for (i = 26;; i = this.text.charAt(i))
            {
              j += 1;
              break label700;
              i5 = 0;
              break;
              label767:
              i = this.text.charAt(i);
              break label650;
              i = this.text.charAt(i);
              j = k;
              break label700;
            }
          }
        }
        i = this.bp + k - i6 - 1;
        float f;
        if ((i5 == 0) && (i < 10))
        {
          f = i4 / i3;
          if (i2 == 0) {
            break label1530;
          }
          f = -f;
        }
        for (;;)
        {
          Object localObject3;
          if (i1 >= localObject1.length)
          {
            localObject3 = new float[localObject1.length * 3 / 2];
            System.arraycopy(localObject1, 0, localObject3, 0, i1);
            localObject1 = localObject3;
          }
          for (;;)
          {
            j = i1 + 1;
            localObject1[i1] = f;
            if (m == 44)
            {
              i = this.bp;
              m = k + 1;
              i += k;
              if (i >= this.len)
              {
                i = 26;
                k = m;
              }
            }
            for (;;)
            {
              i1 = j;
              j = i;
              i = k;
              break label184;
              f = Float.parseFloat(subString(i6, i));
              break label855;
              i = this.text.charAt(i);
              k = m;
              continue;
              if (m == 93)
              {
                i = this.bp;
                m = k + 1;
                i += k;
                if (i >= this.len)
                {
                  i = 26;
                  localObject3 = localObject1;
                  if (j != localObject1.length)
                  {
                    localObject3 = new float[j];
                    System.arraycopy(localObject1, 0, localObject3, 0, j);
                  }
                  if (n < localObject2.length) {
                    break label1513;
                  }
                  localObject1 = new float[localObject2.length * 3 / 2][];
                  System.arraycopy(localObject3, 0, localObject1, 0, j);
                }
                for (;;)
                {
                  k = n + 1;
                  localObject1[n] = localObject3;
                  if (i == 44)
                  {
                    i = this.bp;
                    j = m + 1;
                    i += m;
                    if (i >= this.len) {
                      i = 26;
                    }
                  }
                  for (;;)
                  {
                    n = k;
                    localObject2 = localObject1;
                    break;
                    break;
                    i = this.text.charAt(i);
                    break label1031;
                    this.matchStat = -1;
                    return (float[][])null;
                    i = this.text.charAt(i);
                    continue;
                    if (i == 93)
                    {
                      i = this.bp;
                      j = m + 1;
                      i += m;
                      if (i >= this.len) {}
                      for (i = 26;; i = this.text.charAt(i))
                      {
                        localObject2 = localObject1;
                        if (k != localObject1.length)
                        {
                          localObject2 = new float[k][];
                          System.arraycopy(localObject1, 0, localObject2, 0, k);
                        }
                        if (i != 44) {
                          break;
                        }
                        this.bp += j - 1;
                        next();
                        this.matchStat = 3;
                        this.token = 16;
                        return localObject2;
                      }
                      if (i == 125)
                      {
                        k = this.bp;
                        i = j + 1;
                        j = charAt(k + j);
                        if (j == 44)
                        {
                          this.token = 16;
                          this.bp += i - 1;
                          next();
                        }
                        for (;;)
                        {
                          this.matchStat = 4;
                          return localObject2;
                          if (j == 93)
                          {
                            this.token = 15;
                            this.bp += i - 1;
                            next();
                          }
                          else if (j == 125)
                          {
                            this.token = 13;
                            this.bp += i - 1;
                            next();
                          }
                          else
                          {
                            if (j != 26) {
                              break;
                            }
                            this.bp += i - 1;
                            this.token = 20;
                            this.ch = '\032';
                          }
                        }
                        this.matchStat = -1;
                        return (float[][])null;
                      }
                      this.matchStat = -1;
                      return (float[][])null;
                    }
                    j = m;
                  }
                  localObject1 = localObject2;
                }
              }
              i = m;
            }
          }
        }
      }
      label781:
      label813:
      i3 = 1;
      label1031:
      label1168:
      i4 = i;
      label1152:
      i = k;
    }
  }
  
  public int scanFieldInt(long paramLong)
  {
    char c = '\032';
    this.matchStat = 0;
    int i = matchFieldHash(paramLong);
    if (i == 0) {
      return 0;
    }
    int k = this.bp;
    int j = i + 1;
    i += k;
    if (i >= this.len)
    {
      i = 26;
      if (i != 34) {
        break label704;
      }
      i = this.bp + j;
      if (i < this.len) {
        break label201;
      }
      i = 26;
      label83:
      k = 1;
      j += 1;
    }
    for (;;)
    {
      label121:
      int n;
      label201:
      label229:
      int i1;
      if ((i >= 48) && (i <= 57))
      {
        int m = i - 48;
        i = j;
        j = m;
        n = this.bp;
        m = i + 1;
        i += n;
        if (i >= this.len) {}
        for (i = 26;; i = this.text.charAt(i))
        {
          if ((i < 48) || (i > 57)) {
            break label229;
          }
          j = j * 10 + (i - 48);
          i = m;
          break label121;
          i = this.text.charAt(i);
          break;
          i = this.text.charAt(i);
          break label83;
        }
        if (i == 46)
        {
          this.matchStat = -1;
          return 0;
        }
        i1 = i;
        n = m;
        if (i == 34)
        {
          if (k == 0)
          {
            this.matchStat = -1;
            return 0;
          }
          i = this.bp + m;
          if (i < this.len) {
            break label314;
          }
        }
        label314:
        for (i = 26;; i = this.text.charAt(i))
        {
          n = m + 1;
          i1 = i;
          if (j >= 0) {
            break;
          }
          this.matchStat = -1;
          return 0;
        }
      }
      this.matchStat = -1;
      return 0;
      if (i1 == 44)
      {
        this.bp += n - 1;
        i = this.bp + 1;
        this.bp = i;
        if (i >= this.len) {}
        for (;;)
        {
          this.ch = c;
          this.matchStat = 3;
          this.token = 16;
          return j;
          c = this.text.charAt(i);
        }
      }
      if (i1 == 125)
      {
        k = this.bp;
        i = n + 1;
        k = charAt(k + n);
        if (k == 44)
        {
          this.token = 16;
          this.bp += i - 1;
          i = this.bp + 1;
          this.bp = i;
          if (i >= this.len) {
            this.ch = c;
          }
        }
        for (;;)
        {
          this.matchStat = 4;
          return j;
          c = this.text.charAt(i);
          break;
          if (k == 93)
          {
            this.token = 15;
            this.bp += i - 1;
            i = this.bp + 1;
            this.bp = i;
            if (i >= this.len) {}
            for (;;)
            {
              this.ch = c;
              break;
              c = this.text.charAt(i);
            }
          }
          if (k == 125)
          {
            this.token = 13;
            this.bp += i - 1;
            i = this.bp + 1;
            this.bp = i;
            if (i >= this.len) {}
            for (;;)
            {
              this.ch = c;
              break;
              c = this.text.charAt(i);
            }
          }
          if (k != 26) {
            break label690;
          }
          this.token = 20;
          this.bp += i - 1;
          this.ch = '\032';
        }
        label690:
        this.matchStat = -1;
        return 0;
      }
      this.matchStat = -1;
      return 0;
      label704:
      k = 0;
    }
  }
  
  public final int[] scanFieldIntArray(long paramLong)
  {
    this.matchStat = 0;
    int i = matchFieldHash(paramLong);
    if (i == 0) {
      return null;
    }
    int k = this.bp;
    int j = i + 1;
    i += k;
    if (i >= this.len) {}
    for (i = 26; i != 91; i = this.text.charAt(i))
    {
      this.matchStat = -2;
      return null;
    }
    i = this.bp;
    k = j + 1;
    i += j;
    Object localObject;
    if (i >= this.len)
    {
      j = 26;
      localObject = new int[16];
      if (j != 93) {
        break label760;
      }
      i = this.bp + k;
      if (i < this.len) {
        break label225;
      }
    }
    int m;
    int[] arrayOfInt;
    label174:
    label225:
    for (i = 26;; i = this.text.charAt(i))
    {
      m = k + 1;
      k = i;
      j = 0;
      i = m;
      if (j == localObject.length) {
        break label742;
      }
      arrayOfInt = new int[j];
      System.arraycopy(localObject, 0, arrayOfInt, 0, j);
      localObject = arrayOfInt;
      if (k != 44) {
        break label563;
      }
      this.bp += i - 1;
      next();
      this.matchStat = 3;
      this.token = 16;
      return localObject;
      j = this.text.charAt(i);
      break;
    }
    label237:
    int n;
    label271:
    int i1;
    if (k >= localObject.length)
    {
      arrayOfInt = new int[localObject.length * 3 / 2];
      System.arraycopy(localObject, 0, arrayOfInt, 0, k);
      localObject = arrayOfInt;
      n = k + 1;
      int i2 = i;
      if (i1 != 0) {
        i2 = -i;
      }
      localObject[k] = i2;
      if (j == 44)
      {
        i = this.bp + m;
        if (i >= this.len)
        {
          j = 26;
          label323:
          i = m + 1;
        }
      }
    }
    label328:
    for (k = n;; k = m)
    {
      if (j == 45)
      {
        j = this.bp + i;
        if (j >= this.len)
        {
          j = 26;
          i1 = 1;
          i += 1;
        }
      }
      for (;;)
      {
        if ((j >= 48) && (j <= 57))
        {
          m = j - 48;
          j = i;
          i = m;
          n = this.bp;
          m = j + 1;
          j += n;
          if (j >= this.len) {}
          for (j = 26;; j = this.text.charAt(j))
          {
            if ((j < 48) || (j > 57)) {
              break label484;
            }
            i = i * 10 + (j - 48);
            j = m;
            break label394;
            j = this.text.charAt(j);
            break;
          }
          label484:
          break label237;
          j = this.text.charAt(i);
          break label323;
          if (j != 93) {
            break label745;
          }
          i = this.bp + m;
          if (i >= this.len) {}
          for (i = 26;; i = this.text.charAt(i))
          {
            j = n;
            m += 1;
            k = i;
            i = m;
            break;
          }
        }
        this.matchStat = -1;
        return null;
        if (k == 125)
        {
          k = this.bp;
          j = i + 1;
          i = charAt(k + i);
          if (i == 44)
          {
            this.token = 16;
            this.bp += j - 1;
            next();
          }
          for (;;)
          {
            this.matchStat = 4;
            return localObject;
            if (i == 93)
            {
              this.token = 15;
              this.bp += j - 1;
              next();
            }
            else if (i == 125)
            {
              this.token = 13;
              this.bp += j - 1;
              next();
            }
            else
            {
              if (i != 26) {
                break;
              }
              this.bp += j - 1;
              this.token = 20;
              this.ch = '\032';
            }
          }
          this.matchStat = -1;
          return null;
        }
        this.matchStat = -1;
        return null;
        label742:
        break label174;
        label745:
        i = m;
        break label328;
        break label271;
        i1 = 0;
      }
      label760:
      m = 0;
      i = k;
    }
  }
  
  public long scanFieldLong(long paramLong)
  {
    char c = '\032';
    this.matchStat = 0;
    int i = matchFieldHash(paramLong);
    if (i == 0) {
      return 0L;
    }
    int k = this.bp;
    int j = i + 1;
    i += k;
    if (i >= this.len)
    {
      i = 26;
      if (i != 34) {
        break label699;
      }
      i = this.bp + j;
      if (i < this.len) {
        break label197;
      }
      i = 26;
      label83:
      k = 1;
      j += 1;
    }
    for (;;)
    {
      label117:
      int m;
      label197:
      label225:
      int n;
      if ((i >= 48) && (i <= 57))
      {
        paramLong = i - 48;
        i = j;
        m = this.bp;
        j = i + 1;
        i += m;
        if (i >= this.len) {}
        for (i = 26;; i = this.text.charAt(i))
        {
          if ((i < 48) || (i > 57)) {
            break label225;
          }
          paramLong = paramLong * 10L + (i - 48);
          i = j;
          break label117;
          i = this.text.charAt(i);
          break;
          i = this.text.charAt(i);
          break label83;
        }
        if (i == 46)
        {
          this.matchStat = -1;
          return 0L;
        }
        n = i;
        m = j;
        if (i == 34)
        {
          if (k == 0)
          {
            this.matchStat = -1;
            return 0L;
          }
          i = this.bp + j;
          if (i < this.len) {
            break label311;
          }
        }
        label311:
        for (i = 26;; i = this.text.charAt(i))
        {
          m = j + 1;
          n = i;
          if (paramLong >= 0L) {
            break;
          }
          this.matchStat = -1;
          return 0L;
        }
      }
      this.matchStat = -1;
      return 0L;
      if (n == 44)
      {
        this.bp += m - 1;
        i = this.bp + 1;
        this.bp = i;
        if (i >= this.len) {}
        for (;;)
        {
          this.ch = c;
          this.matchStat = 3;
          this.token = 16;
          return paramLong;
          c = this.text.charAt(i);
        }
      }
      if (n == 125)
      {
        j = this.bp;
        i = m + 1;
        j = charAt(j + m);
        if (j == 44)
        {
          this.token = 16;
          this.bp += i - 1;
          i = this.bp + 1;
          this.bp = i;
          if (i >= this.len) {
            this.ch = c;
          }
        }
        for (;;)
        {
          this.matchStat = 4;
          return paramLong;
          c = this.text.charAt(i);
          break;
          if (j == 93)
          {
            this.token = 15;
            this.bp += i - 1;
            i = this.bp + 1;
            this.bp = i;
            if (i >= this.len) {}
            for (;;)
            {
              this.ch = c;
              break;
              c = this.text.charAt(i);
            }
          }
          if (j == 125)
          {
            this.token = 13;
            this.bp += i - 1;
            i = this.bp + 1;
            this.bp = i;
            if (i >= this.len) {}
            for (;;)
            {
              this.ch = c;
              break;
              c = this.text.charAt(i);
            }
          }
          if (j != 26) {
            break label685;
          }
          this.token = 20;
          this.bp += i - 1;
          this.ch = '\032';
        }
        label685:
        this.matchStat = -1;
        return 0L;
      }
      this.matchStat = -1;
      return 0L;
      label699:
      k = 0;
    }
  }
  
  public String scanFieldString(long paramLong)
  {
    this.matchStat = 0;
    int i = matchFieldHash(paramLong);
    if (i == 0) {
      return null;
    }
    int j = this.bp;
    int n = i + 1;
    i += j;
    if (i >= this.len) {
      throw new JSONException("unclosed str, " + info());
    }
    if (this.text.charAt(i) != '"')
    {
      this.matchStat = -1;
      return this.stringDefaultValue;
    }
    int i1 = this.bp + n;
    j = this.text.indexOf('"', i1);
    if (j == -1) {
      throw new JSONException("unclosed str, " + info());
    }
    if (V6) {}
    Object localObject1;
    int k;
    int m;
    for (Object localObject2 = this.text.substring(i1, j);; localObject2 = new String(sub_chars(this.bp + n, i), 0, i))
    {
      localObject1 = localObject2;
      i = j;
      if (((String)localObject2).indexOf('\\') == -1) {
        break label330;
      }
      i = j;
      j = 0;
      k = i - 1;
      m = 0;
      while ((k >= 0) && (this.text.charAt(k) == '\\'))
      {
        m += 1;
        k -= 1;
        j = 1;
      }
      i = j - i1;
    }
    if (m % 2 == 0)
    {
      k = i - i1;
      localObject2 = sub_chars(this.bp + n, k);
      if (j == 0) {
        break label425;
      }
      localObject1 = readString((char[])localObject2, k);
    }
    label643:
    label663:
    for (;;)
    {
      label330:
      j = i + 1;
      if (j >= this.len)
      {
        i = 26;
        label349:
        if (i != 44) {
          break label489;
        }
        this.bp = j;
        i = this.bp + 1;
        this.bp = i;
        if (i < this.len) {
          break label476;
        }
      }
      label425:
      label476:
      for (char c = '\032';; c = this.text.charAt(i))
      {
        this.ch = c;
        this.matchStat = 3;
        this.token = 16;
        return localObject1;
        i = this.text.indexOf('"', i + 1);
        break;
        localObject1 = new String((char[])localObject2, 0, k);
        if (((String)localObject1).indexOf('\\') == -1) {
          break label663;
        }
        localObject1 = readString((char[])localObject2, k);
        break label330;
        i = this.text.charAt(j);
        break label349;
      }
      label489:
      if (i == 125)
      {
        j += 1;
        if (j >= this.len)
        {
          i = 26;
          if (i != 44) {
            break label561;
          }
          this.token = 16;
          this.bp = j;
          next();
        }
        for (;;)
        {
          this.matchStat = 4;
          return localObject1;
          i = this.text.charAt(j);
          break;
          if (i == 93)
          {
            this.token = 15;
            this.bp = j;
            next();
          }
          else if (i == 125)
          {
            this.token = 13;
            this.bp = j;
            next();
          }
          else
          {
            if (i != 26) {
              break label643;
            }
            this.token = 20;
            this.bp = j;
            this.ch = '\032';
          }
        }
        this.matchStat = -1;
        return this.stringDefaultValue;
      }
      label561:
      this.matchStat = -1;
      return this.stringDefaultValue;
    }
  }
  
  public long scanFieldSymbol(long paramLong)
  {
    char c = '\032';
    this.matchStat = 0;
    int i = matchFieldHash(paramLong);
    if (i == 0) {
      return 0L;
    }
    int k = this.bp;
    int j = i + 1;
    i += k;
    if (i >= this.len) {}
    for (i = 26; i != 34; i = this.text.charAt(i))
    {
      this.matchStat = -1;
      return 0L;
    }
    paramLong = -2128831035L;
    i = this.bp;
    label167:
    label236:
    label495:
    for (i = j;; i = j)
    {
      k = this.bp;
      j = i + 1;
      i += k;
      if (i >= this.len)
      {
        i = 26;
        if (i != 34) {
          break label250;
        }
        i = this.bp;
        k = j + 1;
        i += j;
        if (i < this.len) {
          break label236;
        }
        i = 26;
        if (i != 44) {
          break label287;
        }
        this.bp += k - 1;
        i = this.bp + 1;
        this.bp = i;
        if (i < this.len) {
          break label274;
        }
      }
      for (;;)
      {
        this.ch = c;
        this.matchStat = 3;
        return paramLong;
        i = this.text.charAt(i);
        break;
        i = this.text.charAt(i);
        break label167;
        label250:
        paramLong = (paramLong ^ i) * 16777619L;
        if (i != 92) {
          break label495;
        }
        this.matchStat = -1;
        return 0L;
        c = this.text.charAt(i);
      }
      if (i == 125)
      {
        i = this.bp;
        j = k + 1;
        i += k;
        if (i >= this.len)
        {
          i = 26;
          if (i != 44) {
            break label378;
          }
          this.token = 16;
          this.bp += j - 1;
          next();
        }
        for (;;)
        {
          this.matchStat = 4;
          return paramLong;
          i = this.text.charAt(i);
          break;
          label378:
          if (i == 93)
          {
            this.token = 15;
            this.bp += j - 1;
            next();
          }
          else if (i == 125)
          {
            this.token = 13;
            this.bp += j - 1;
            next();
          }
          else
          {
            if (i != 26) {
              break label481;
            }
            this.token = 20;
            this.bp += j - 1;
            this.ch = '\032';
          }
        }
        this.matchStat = -1;
        return 0L;
      }
      this.matchStat = -1;
      return 0L;
    }
  }
  
  public boolean scanISO8601DateIfMatch(boolean paramBoolean)
  {
    int n = this.len - this.bp;
    if ((!paramBoolean) && (n > 13) && (this.text.startsWith("/Date(", this.bp)) && (charAt(this.bp + n - 1) == '/') && (charAt(this.bp + n - 2) == ')'))
    {
      j = -1;
      i = 6;
      if (i < n)
      {
        m = charAt(this.bp + i);
        if (m == 43) {
          k = i;
        }
        do
        {
          i += 1;
          j = k;
          break;
          if (m < 48) {
            break label144;
          }
          k = j;
        } while (m <= 57);
      }
      label144:
      if (j == -1) {
        return false;
      }
      i = this.bp + 6;
      long l = Long.parseLong(subString(i, j - i), 10);
      this.calendar = Calendar.getInstance(this.timeZone, this.locale);
      this.calendar.setTimeInMillis(l);
      this.token = 5;
      return true;
    }
    if ((n == 8) || (n == 14) || (n == 17))
    {
      if (paramBoolean) {
        return false;
      }
      c1 = charAt(this.bp);
      c2 = charAt(this.bp + 1);
      c3 = charAt(this.bp + 2);
      c4 = charAt(this.bp + 3);
      c5 = charAt(this.bp + 4);
      c6 = charAt(this.bp + 5);
      c7 = charAt(this.bp + 6);
      c8 = charAt(this.bp + 7);
      if (!checkDate(c1, c2, c3, c4, c5, c6, c7, c8)) {
        return false;
      }
      setCalendar(c1, c2, c3, c4, c5, c6, c7, c8);
      if (n != 8)
      {
        c1 = charAt(this.bp + 8);
        c2 = charAt(this.bp + 9);
        c3 = charAt(this.bp + 10);
        c4 = charAt(this.bp + 11);
        c5 = charAt(this.bp + 12);
        c6 = charAt(this.bp + 13);
        if (!checkTime(c1, c2, c3, c4, c5, c6)) {
          return false;
        }
        if (n == 17)
        {
          i = charAt(this.bp + 14);
          j = charAt(this.bp + 15);
          k = charAt(this.bp + 16);
          if ((i < 48) || (i > 57)) {
            return false;
          }
          if ((j < 48) || (j > 57)) {
            return false;
          }
          if ((k < 48) || (k > 57)) {
            return false;
          }
          i = (i - 48) * 100 + (j - 48) * 10 + (k - 48);
          j = c4 - '0' + (c3 - '0') * 10;
          n = (c5 - '0') * 10 + (c6 - '0');
          k = (c1 - '0') * 10 + (c2 - '0');
          m = i;
          i = n;
        }
      }
      for (;;)
      {
        this.calendar.set(11, k);
        this.calendar.set(12, j);
        this.calendar.set(13, i);
        this.calendar.set(14, m);
        this.token = 5;
        return true;
        i = 0;
        break;
        i = 0;
        j = 0;
        k = 0;
        m = 0;
      }
    }
    if (n < 10) {
      return false;
    }
    if (charAt(this.bp + 4) != '-') {
      return false;
    }
    if (charAt(this.bp + 7) != '-') {
      return false;
    }
    char c1 = charAt(this.bp);
    char c2 = charAt(this.bp + 1);
    char c3 = charAt(this.bp + 2);
    char c4 = charAt(this.bp + 3);
    char c5 = charAt(this.bp + 5);
    char c6 = charAt(this.bp + 6);
    char c7 = charAt(this.bp + 8);
    char c8 = charAt(this.bp + 9);
    if (!checkDate(c1, c2, c3, c4, c5, c6, c7, c8)) {
      return false;
    }
    setCalendar(c1, c2, c3, c4, c5, c6, c7, c8);
    int i = charAt(this.bp + 10);
    if ((i == 84) || ((i == 32) && (!paramBoolean)))
    {
      if (n < 19) {
        return false;
      }
    }
    else
    {
      if ((i == 34) || (i == 26))
      {
        this.calendar.set(11, 0);
        this.calendar.set(12, 0);
        this.calendar.set(13, 0);
        this.calendar.set(14, 0);
        i = this.bp + 10;
        this.bp = i;
        this.ch = charAt(i);
        this.token = 5;
        return true;
      }
      return false;
    }
    if (charAt(this.bp + 13) != ':') {
      return false;
    }
    if (charAt(this.bp + 16) != ':') {
      return false;
    }
    c1 = charAt(this.bp + 11);
    c2 = charAt(this.bp + 12);
    c3 = charAt(this.bp + 14);
    c4 = charAt(this.bp + 15);
    c5 = charAt(this.bp + 17);
    c6 = charAt(this.bp + 18);
    if (!checkTime(c1, c2, c3, c4, c5, c6)) {
      return false;
    }
    this.calendar.set(11, (c1 - '0') * 10 + (c2 - '0'));
    this.calendar.set(12, (c3 - '0') * 10 + (c4 - '0'));
    this.calendar.set(13, (c5 - '0') * 10 + (c6 - '0'));
    i = charAt(this.bp + 19);
    Object localObject;
    if (i == 46)
    {
      if (n < 21) {
        return false;
      }
    }
    else
    {
      this.calendar.set(14, 0);
      j = this.bp + 19;
      this.bp = j;
      this.ch = charAt(j);
      this.token = 5;
      if ((i == 90) && (this.calendar.getTimeZone().getRawOffset() != 0))
      {
        localObject = TimeZone.getAvailableIDs(0);
        if (localObject.length > 0)
        {
          localObject = TimeZone.getTimeZone(localObject[0]);
          this.calendar.setTimeZone((TimeZone)localObject);
        }
      }
      return true;
    }
    i = charAt(this.bp + 20);
    if ((i < 48) || (i > 57)) {
      return false;
    }
    int k = digits[i];
    int m = 1;
    int j = m;
    i = k;
    if (n > 21)
    {
      n = charAt(this.bp + 21);
      j = m;
      i = k;
      if (n >= 48)
      {
        j = m;
        i = k;
        if (n <= 57)
        {
          i = digits[n] + k * 10;
          j = 2;
        }
      }
    }
    k = j;
    m = i;
    if (j == 2)
    {
      n = charAt(this.bp + 22);
      k = j;
      m = i;
      if (n >= 48)
      {
        k = j;
        m = i;
        if (n <= 57)
        {
          m = digits[n] + i * 10;
          k = 3;
        }
      }
    }
    this.calendar.set(14, m);
    j = 0;
    n = charAt(this.bp + 20 + k);
    if ((n == 43) || (n == 45))
    {
      j = charAt(this.bp + 20 + k + 1);
      if ((j < 48) || (j > 49)) {
        return false;
      }
      m = charAt(this.bp + 20 + k + 2);
      if ((m < 48) || (m > 57)) {
        return false;
      }
      i = charAt(this.bp + 20 + k + 3);
      if (i == 58)
      {
        if (charAt(this.bp + 20 + k + 4) != '0') {
          return false;
        }
        if (charAt(this.bp + 20 + k + 5) != '0') {
          return false;
        }
        i = 6;
        j = (digits[j] * 10 + digits[m]) * 3600 * 1000;
        m = j;
        if (n == 45) {
          m = -j;
        }
        j = i;
        if (this.calendar.getTimeZone().getRawOffset() != m)
        {
          localObject = TimeZone.getAvailableIDs(m);
          j = i;
          if (localObject.length > 0)
          {
            localObject = TimeZone.getTimeZone(localObject[0]);
            this.calendar.setTimeZone((TimeZone)localObject);
            j = i;
          }
        }
      }
    }
    for (;;)
    {
      i = charAt(this.bp + (k + 20 + j));
      if ((i == 26) || (i == 34)) {
        break label1963;
      }
      return false;
      if (i == 48)
      {
        if (charAt(this.bp + 20 + k + 4) != '0') {
          return false;
        }
        i = 5;
        break;
      }
      i = 3;
      break;
      if (n == 90)
      {
        i = 1;
        j = i;
        if (this.calendar.getTimeZone().getRawOffset() != 0)
        {
          localObject = TimeZone.getAvailableIDs(0);
          j = i;
          if (localObject.length > 0)
          {
            localObject = TimeZone.getTimeZone(localObject[0]);
            this.calendar.setTimeZone((TimeZone)localObject);
            j = i;
          }
        }
      }
    }
    label1963:
    i = k + 20 + j + this.bp;
    this.bp = i;
    this.ch = charAt(i);
    this.token = 5;
    return true;
  }
  
  public final long scanLongValue()
  {
    int i = 0;
    this.np = 0;
    if (this.ch == '-')
    {
      i = 1;
      l2 = -9223372036854775808L;
      this.np += 1;
      j = this.bp + 1;
      this.bp = j;
      if (j >= this.len) {
        throw new JSONException("syntax error, " + info());
      }
      this.ch = this.text.charAt(j);
    }
    long l1;
    for (;;)
    {
      l1 = 0L;
      if ((this.ch < '0') || (this.ch > '9')) {
        break label305;
      }
      j = this.ch - '0';
      if (l1 >= -922337203685477580L) {
        break;
      }
      throw new JSONException("error long value, " + l1 + ", " + info());
      l2 = -9223372036854775807L;
    }
    l1 *= 10L;
    if (l1 < j + l2) {
      throw new JSONException("error long value, " + l1 + ", " + info());
    }
    l1 -= j;
    this.np += 1;
    int j = this.bp + 1;
    this.bp = j;
    if (j >= this.len) {}
    for (char c = '\032';; c = this.text.charAt(j))
    {
      this.ch = c;
      break;
    }
    label305:
    long l2 = l1;
    if (i == 0) {
      l2 = -l1;
    }
    return l2;
  }
  
  public final void scanNumber()
  {
    this.np = this.bp;
    this.exp = false;
    int i;
    if (this.ch == '-')
    {
      this.sp += 1;
      i = this.bp + 1;
      this.bp = i;
      if (i >= this.len)
      {
        c = '\032';
        this.ch = c;
      }
    }
    else
    {
      label60:
      if ((this.ch < '0') || (this.ch > '9')) {
        break label143;
      }
      this.sp += 1;
      i = this.bp + 1;
      this.bp = i;
      if (i < this.len) {
        break label131;
      }
    }
    label131:
    for (char c = '\032';; c = this.text.charAt(i))
    {
      this.ch = c;
      break label60;
      c = this.text.charAt(i);
      break;
    }
    label143:
    this.isDouble = false;
    if (this.ch == '.')
    {
      this.sp += 1;
      i = this.bp + 1;
      this.bp = i;
      if (i >= this.len)
      {
        c = '\032';
        this.ch = c;
        this.isDouble = true;
        label200:
        if ((this.ch < '0') || (this.ch > '9')) {
          break label283;
        }
        this.sp += 1;
        i = this.bp + 1;
        this.bp = i;
        if (i < this.len) {
          break label271;
        }
      }
      label271:
      for (c = '\032';; c = this.text.charAt(i))
      {
        this.ch = c;
        break label200;
        c = this.text.charAt(i);
        break;
      }
    }
    label283:
    if (this.ch == 'L')
    {
      this.sp += 1;
      next();
    }
    while (this.isDouble)
    {
      this.token = 3;
      return;
      if (this.ch == 'S')
      {
        this.sp += 1;
        next();
      }
      else if (this.ch == 'B')
      {
        this.sp += 1;
        next();
      }
      else if (this.ch == 'F')
      {
        this.sp += 1;
        next();
        this.isDouble = true;
      }
      else if (this.ch == 'D')
      {
        this.sp += 1;
        next();
        this.isDouble = true;
      }
      else if ((this.ch == 'e') || (this.ch == 'E'))
      {
        this.sp += 1;
        i = this.bp + 1;
        this.bp = i;
        if (i >= this.len)
        {
          c = '\032';
          this.ch = c;
          if ((this.ch == '+') || (this.ch == '-'))
          {
            this.sp += 1;
            i = this.bp + 1;
            this.bp = i;
            if (i < this.len) {
              break label621;
            }
            c = '\032';
            label545:
            this.ch = c;
          }
          label550:
          if ((this.ch < '0') || (this.ch > '9')) {
            break label645;
          }
          this.sp += 1;
          i = this.bp + 1;
          this.bp = i;
          if (i < this.len) {
            break label633;
          }
        }
        label621:
        label633:
        for (c = '\032';; c = this.text.charAt(i))
        {
          this.ch = c;
          break label550;
          c = this.text.charAt(i);
          break;
          c = this.text.charAt(i);
          break label545;
        }
        label645:
        if ((this.ch == 'D') || (this.ch == 'F'))
        {
          this.sp += 1;
          next();
        }
        this.exp = true;
        this.isDouble = true;
      }
    }
    this.token = 2;
  }
  
  public final Number scanNumberValue()
  {
    int i1 = this.bp;
    this.np = 0;
    int k;
    label69:
    long l1;
    label75:
    int j;
    if (this.ch == '-')
    {
      this.np += 1;
      i = this.bp + 1;
      this.bp = i;
      if (i >= this.len)
      {
        c = '\032';
        this.ch = c;
        k = 1;
        l2 = -9223372036854775808L;
        l1 = 0L;
        i = 0;
        if ((this.ch < '0') || (this.ch > '9')) {
          break label226;
        }
        j = this.ch - '0';
        if (l1 < -922337203685477580L) {
          i = 1;
        }
        l1 *= 10L;
        if (l1 < j + l2) {
          i = 1;
        }
        l1 -= j;
        this.np += 1;
        j = this.bp + 1;
        this.bp = j;
        if (j < this.len) {
          break label213;
        }
      }
    }
    label213:
    for (char c = '\032';; c = this.text.charAt(j))
    {
      this.ch = c;
      break label75;
      c = this.text.charAt(i);
      break;
      k = 0;
      l2 = -9223372036854775807L;
      break label69;
    }
    label226:
    long l2 = l1;
    if (k == 0) {
      l2 = -l1;
    }
    Object localObject1;
    if (this.ch == 'L')
    {
      this.np += 1;
      next();
      localObject1 = Long.valueOf(l2);
    }
    int m;
    label319:
    label324:
    label753:
    label766:
    Object localObject2;
    for (;;)
    {
      m = 0;
      if (this.ch == '.')
      {
        this.np += 1;
        j = this.bp + 1;
        this.bp = j;
        if (j >= this.len)
        {
          c = '\032';
          this.ch = c;
          if ((this.ch < '0') || (this.ch > '9')) {
            break label554;
          }
          this.np += 1;
          j = this.bp + 1;
          this.bp = j;
          if (j < this.len) {
            break label541;
          }
        }
        label541:
        for (c = '\032';; c = this.text.charAt(j))
        {
          this.ch = c;
          break label324;
          if (this.ch == 'S')
          {
            this.np += 1;
            next();
            localObject1 = Short.valueOf((short)(int)l2);
            break;
          }
          if (this.ch == 'B')
          {
            this.np += 1;
            next();
            localObject1 = Byte.valueOf((byte)(int)l2);
            break;
          }
          if (this.ch == 'F')
          {
            this.np += 1;
            next();
            localObject1 = Float.valueOf((float)l2);
            break;
          }
          if (this.ch != 'D') {
            break label1239;
          }
          this.np += 1;
          next();
          localObject1 = Double.valueOf(l2);
          break;
          c = this.text.charAt(j);
          break label319;
        }
        label554:
        m = 1;
      }
      j = 0;
      if ((this.ch == 'e') || (this.ch == 'E'))
      {
        this.np += 1;
        j = this.bp + 1;
        this.bp = j;
        if (j >= this.len)
        {
          c = '\032';
          this.ch = c;
          if ((this.ch == '+') || (this.ch == '-'))
          {
            this.np += 1;
            j = this.bp + 1;
            this.bp = j;
            if (j < this.len) {
              break label753;
            }
            c = '\032';
            label673:
            this.ch = c;
          }
          label678:
          if ((this.ch < '0') || (this.ch > '9')) {
            break label779;
          }
          this.np += 1;
          j = this.bp + 1;
          this.bp = j;
          if (j < this.len) {
            break label766;
          }
        }
        for (c = '\032';; c = this.text.charAt(j))
        {
          this.ch = c;
          break label678;
          c = this.text.charAt(j);
          break;
          c = this.text.charAt(j);
          break label673;
        }
        label779:
        if ((this.ch == 'D') || (this.ch == 'F'))
        {
          this.np += 1;
          j = this.ch;
          next();
        }
      }
      for (n = 1;; n = 0)
      {
        if ((m == 0) && (n == 0))
        {
          if (i != 0)
          {
            localObject1 = new char[this.bp - i1];
            this.text.getChars(i1, this.bp, (char[])localObject1, 0);
            localObject1 = new BigInteger(new String((char[])localObject1));
          }
          Object localObject3 = localObject1;
          if (localObject1 == null)
          {
            if ((l2 > -2147483648L) && (l2 < 2147483647L)) {
              localObject3 = Integer.valueOf((int)l2);
            }
          }
          else {
            return localObject3;
          }
          return Long.valueOf(l2);
        }
        i = this.bp - i1;
        m = i;
        if (j != 0) {
          m = i - 1;
        }
        if (m < this.sbuf.length)
        {
          this.text.getChars(i1, i1 + m, this.sbuf, 0);
          localObject1 = this.sbuf;
        }
        while ((n == 0) && ((this.features & Feature.UseBigDecimal.mask) != 0))
        {
          return new BigDecimal((char[])localObject1, 0, m);
          localObject1 = new char[m];
          this.text.getChars(i1, i1 + m, (char[])localObject1, 0);
        }
        if ((m <= 9) && (n == 0))
        {
          i = 1;
          i1 = localObject1[0];
          if (i1 == 45) {
            break label1245;
          }
          n = i1;
          if (i1 != 43) {
            break label1254;
          }
          break label1245;
          if (j != 70) {}
        }
        try
        {
          float f2 = i / i1;
          float f1 = f2;
          if (k != 0) {
            f1 = -f2;
          }
          return Float.valueOf(f1);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          double d2;
          double d1;
          throw new JSONException(localNumberFormatException.getMessage() + ", " + info(), localNumberFormatException);
        }
        d2 = i / i1;
        d1 = d2;
        if (k != 0) {
          d1 = -d2;
        }
        return Double.valueOf(d1);
        localObject1 = new String((char[])localObject1, 0, m);
        if (j == 70) {
          return Float.valueOf((String)localObject1);
        }
        d1 = Double.parseDouble((String)localObject1);
        return Double.valueOf(d1);
        j = 0;
        break;
      }
      label1239:
      localObject2 = null;
    }
    label1245:
    int n = localObject2[1];
    int i = 2;
    label1254:
    i1 = 0;
    int i2 = n - 48;
    n = i;
    i = i2;
    label1272:
    if (n < m)
    {
      i2 = localObject2[n];
      if (i2 != 46) {
        break label1321;
      }
      i1 = 1;
      i2 = i;
      i = i1;
    }
    for (;;)
    {
      n += 1;
      i1 = i;
      i = i2;
      break label1272;
      break;
      label1321:
      int i3 = i * 10 + (i2 - 48);
      i = i1;
      i2 = i3;
      if (i1 != 0)
      {
        i = i1 * 10;
        i2 = i3;
      }
    }
  }
  
  public final void scanString()
  {
    int i2 = this.ch;
    int i = this.bp + 1;
    int j = this.text.indexOf(i2, i);
    if (j == -1) {
      throw new JSONException("unclosed str, " + info());
    }
    i = j - i;
    Object localObject = sub_chars(this.bp + 1, i);
    boolean bool1 = false;
    int m;
    boolean bool2;
    if ((i > 0) && (localObject[(i - 1)] == '\\'))
    {
      k = i - 2;
      m = 1;
      while ((k >= 0) && (localObject[k] == '\\'))
      {
        m += 1;
        k -= 1;
      }
      if (m % 2 != 0) {}
    }
    else
    {
      bool2 = bool1;
      if (bool1) {
        break label285;
      }
      k = 0;
      for (;;)
      {
        bool2 = bool1;
        if (k >= i) {
          break;
        }
        if (localObject[k] == '\\') {
          bool1 = true;
        }
        k += 1;
      }
    }
    int n = this.text.indexOf(i2, j + 1);
    int k = i + (n - j);
    if (k >= localObject.length)
    {
      int i1 = localObject.length * 3 / 2;
      m = i1;
      if (i1 < k) {
        m = k;
      }
      char[] arrayOfChar = new char[m];
      System.arraycopy(localObject, 0, arrayOfChar, 0, localObject.length);
      localObject = arrayOfChar;
    }
    for (;;)
    {
      this.text.getChars(j, n, (char[])localObject, i);
      i = k;
      j = n;
      bool1 = true;
      break;
      label285:
      this.sbuf = ((char[])localObject);
      this.sp = i;
      this.np = this.bp;
      this.hasSpecial = bool2;
      this.bp = (j + 1);
      i = this.bp;
      if (i >= this.len) {}
      for (char c = '\032';; c = this.text.charAt(i))
      {
        this.ch = c;
        this.token = 4;
        return;
      }
    }
  }
  
  public String scanStringValue(char paramChar)
  {
    int m = this.bp + 1;
    int i = this.text.indexOf(paramChar, m);
    if (i == -1) {
      throw new JSONException("unclosed str, " + info());
    }
    if (V6) {}
    String str2;
    int j;
    int k;
    for (String str1 = this.text.substring(m, i);; str1 = new String(sub_chars(this.bp + 1, j), 0, j))
    {
      str2 = str1;
      j = i;
      if (str1.indexOf('\\') == -1) {
        break label198;
      }
      j = i - 1;
      k = 0;
      while ((j >= 0) && (this.text.charAt(j) == '\\'))
      {
        k += 1;
        j -= 1;
      }
      j = i - m;
    }
    if (k % 2 == 0)
    {
      paramChar = i - m;
      str2 = readString(sub_chars(this.bp + 1, paramChar), paramChar);
      j = i;
      label198:
      this.bp = (j + 1);
      paramChar = this.bp;
      if (paramChar < this.len) {
        break label245;
      }
    }
    label245:
    for (char c = '\032';; c = this.text.charAt(paramChar))
    {
      this.ch = c;
      return str2;
      i = this.text.indexOf(paramChar, i + 1);
      break;
    }
  }
  
  public final String scanSymbol(SymbolTable paramSymbolTable)
  {
    while ((this.ch == ' ') || (this.ch == '\n') || (this.ch == '\r') || (this.ch == '\t') || (this.ch == '\f') || (this.ch == '\b')) {
      next();
    }
    if (this.ch == '"') {
      return scanSymbol(paramSymbolTable, '"');
    }
    if (this.ch == '\'') {
      return scanSymbol(paramSymbolTable, '\'');
    }
    if (this.ch == '}')
    {
      next();
      this.token = 13;
      return null;
    }
    if (this.ch == ',')
    {
      next();
      this.token = 16;
      return null;
    }
    if (this.ch == '\032')
    {
      this.token = 20;
      return null;
    }
    return scanSymbolUnQuoted(paramSymbolTable);
  }
  
  public String scanSymbol(SymbolTable paramSymbolTable, char paramChar)
  {
    char c2 = this.bp + 1;
    int i = this.text.indexOf(paramChar, c2);
    if (i == -1) {
      throw new JSONException("unclosed str, " + info());
    }
    char c3 = i - c2;
    Object localObject = sub_chars(this.bp + 1, c3);
    c2 = '\000';
    int j;
    if ((c3 > 0) && (localObject[(c3 - '\001')] == '\\'))
    {
      j = c3 - '\002';
      k = 1;
      while ((j >= 0) && (localObject[j] == '\\'))
      {
        k += 1;
        j -= 1;
      }
      if (k % 2 != 0) {}
    }
    else
    {
      if (c2 != 0) {
        break label382;
      }
      paramChar = '\000';
      j = 0;
      while (paramChar < c3)
      {
        k = localObject[paramChar];
        j = j * 31 + k;
        if (k == 92) {
          c2 = '\001';
        }
        paramChar += '\001';
      }
    }
    int k = this.text.indexOf(paramChar, i + 1);
    c2 = c3 + (k - i);
    if (c2 >= localObject.length)
    {
      int m = localObject.length * 3 / 2;
      j = m;
      if (m < c2) {
        j = c2;
      }
      char[] arrayOfChar = new char[j];
      System.arraycopy(localObject, 0, arrayOfChar, 0, localObject.length);
      localObject = arrayOfChar;
    }
    for (;;)
    {
      this.text.getChars(i, k, (char[])localObject, c3);
      c3 = c2;
      i = k;
      c2 = '\001';
      break;
      if (c2 != 0)
      {
        paramSymbolTable = readString((char[])localObject, c3);
        this.bp = (i + 1);
        paramChar = this.bp;
        if (paramChar < this.len) {
          break label393;
        }
      }
      label393:
      for (char c1 = '\032';; c1 = this.text.charAt(paramChar))
      {
        this.ch = c1;
        return paramSymbolTable;
        if (c3 < '\024')
        {
          paramSymbolTable = paramSymbolTable.addSymbol((char[])localObject, 0, c3, j);
          break;
        }
        paramSymbolTable = new String((char[])localObject, 0, c3);
        break;
        label382:
        paramSymbolTable = readString((char[])localObject, c3);
        break;
      }
    }
  }
  
  public final String scanSymbolUnQuoted(SymbolTable paramSymbolTable)
  {
    int j = this.ch;
    if ((this.ch >= firstIdentifierFlags.length) || (firstIdentifierFlags[j] != 0)) {}
    for (int i = 1; i == 0; i = 0) {
      throw new JSONException("illegal identifier : " + this.ch + ", " + info());
    }
    this.np = this.bp;
    this.sp = 1;
    i = j;
    for (;;)
    {
      j = next();
      if ((j < identifierFlags.length) && (identifierFlags[j] == 0))
      {
        this.ch = charAt(this.bp);
        this.token = 18;
        if ((this.sp != 4) || (!this.text.startsWith("null", this.np))) {
          break;
        }
        return null;
      }
      i = i * 31 + j;
      this.sp += 1;
    }
    return paramSymbolTable.addSymbol(this.text, this.np, this.sp, i);
  }
  
  protected void skipComment()
  {
    next();
    if (this.ch == '/')
    {
      do
      {
        next();
      } while (this.ch != '\n');
      next();
    }
    for (;;)
    {
      return;
      if (this.ch != '*') {
        break;
      }
      next();
      while (this.ch != '\032') {
        if (this.ch == '*')
        {
          next();
          if (this.ch == '/') {
            next();
          }
        }
        else
        {
          next();
        }
      }
    }
    throw new JSONException("invalid comment");
  }
  
  final void skipWhitespace()
  {
    while (this.ch <= '/') {
      if ((this.ch == ' ') || (this.ch == '\r') || (this.ch == '\n') || (this.ch == '\t') || (this.ch == '\f') || (this.ch == '\b'))
      {
        next();
      }
      else
      {
        if (this.ch != '/') {
          break;
        }
        skipComment();
      }
    }
  }
  
  public final String stringVal()
  {
    if (this.hasSpecial) {
      return readString(this.sbuf, this.sp);
    }
    return subString(this.np + 1, this.sp);
  }
  
  final char[] sub_chars(int paramInt1, int paramInt2)
  {
    if (paramInt2 < this.sbuf.length)
    {
      this.text.getChars(paramInt1, paramInt1 + paramInt2, this.sbuf, 0);
      return this.sbuf;
    }
    char[] arrayOfChar = new char[paramInt2];
    this.sbuf = arrayOfChar;
    this.text.getChars(paramInt1, paramInt1 + paramInt2, arrayOfChar, 0);
    return arrayOfChar;
  }
  
  public final int token()
  {
    return this.token;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.parser.JSONLexer
 * JD-Core Version:    0.7.0.1
 */