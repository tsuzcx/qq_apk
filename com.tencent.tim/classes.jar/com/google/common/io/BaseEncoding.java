package com.google.common.io;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import java.util.Arrays;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public abstract class BaseEncoding
{
  private static final BaseEncoding BASE16 = new Base16Encoding("base16()", "0123456789ABCDEF");
  private static final BaseEncoding BASE32;
  private static final BaseEncoding BASE32_HEX;
  private static final BaseEncoding BASE64 = new Base64Encoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", Character.valueOf('='));
  private static final BaseEncoding BASE64_URL = new Base64Encoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", Character.valueOf('='));
  
  static
  {
    BASE32 = new StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", Character.valueOf('='));
    BASE32_HEX = new StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", Character.valueOf('='));
  }
  
  public static BaseEncoding base16()
  {
    return BASE16;
  }
  
  public static BaseEncoding base32()
  {
    return BASE32;
  }
  
  public static BaseEncoding base32Hex()
  {
    return BASE32_HEX;
  }
  
  public static BaseEncoding base64()
  {
    return BASE64;
  }
  
  public static BaseEncoding base64Url()
  {
    return BASE64_URL;
  }
  
  private static byte[] extract(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt == paramArrayOfByte.length) {
      return paramArrayOfByte;
    }
    byte[] arrayOfByte = new byte[paramInt];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramInt);
    return arrayOfByte;
  }
  
  @GwtIncompatible
  static Reader ignoringReader(Reader paramReader, CharMatcher paramCharMatcher)
  {
    Preconditions.checkNotNull(paramReader);
    Preconditions.checkNotNull(paramCharMatcher);
    return new BaseEncoding.3(paramReader, paramCharMatcher);
  }
  
  static Appendable separatingAppendable(Appendable paramAppendable, String paramString, int paramInt)
  {
    Preconditions.checkNotNull(paramAppendable);
    Preconditions.checkNotNull(paramString);
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      return new BaseEncoding.4(paramInt, paramAppendable, paramString);
    }
  }
  
  @GwtIncompatible
  static Writer separatingWriter(Writer paramWriter, String paramString, int paramInt)
  {
    return new BaseEncoding.5(separatingAppendable(paramWriter, paramString, paramInt), paramWriter);
  }
  
  public abstract boolean canDecode(CharSequence paramCharSequence);
  
  public final byte[] decode(CharSequence paramCharSequence)
  {
    try
    {
      paramCharSequence = decodeChecked(paramCharSequence);
      return paramCharSequence;
    }
    catch (DecodingException paramCharSequence)
    {
      throw new IllegalArgumentException(paramCharSequence);
    }
  }
  
  final byte[] decodeChecked(CharSequence paramCharSequence)
    throws BaseEncoding.DecodingException
  {
    paramCharSequence = padding().trimTrailingFrom(paramCharSequence);
    byte[] arrayOfByte = new byte[maxDecodedSize(paramCharSequence.length())];
    return extract(arrayOfByte, decodeTo(arrayOfByte, paramCharSequence));
  }
  
  abstract int decodeTo(byte[] paramArrayOfByte, CharSequence paramCharSequence)
    throws BaseEncoding.DecodingException;
  
  @GwtIncompatible
  public final ByteSource decodingSource(CharSource paramCharSource)
  {
    Preconditions.checkNotNull(paramCharSource);
    return new BaseEncoding.2(this, paramCharSource);
  }
  
  @GwtIncompatible
  public abstract InputStream decodingStream(Reader paramReader);
  
  public String encode(byte[] paramArrayOfByte)
  {
    return encode(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public final String encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Preconditions.checkPositionIndexes(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
    StringBuilder localStringBuilder = new StringBuilder(maxEncodedSize(paramInt2));
    try
    {
      encodeTo(localStringBuilder, paramArrayOfByte, paramInt1, paramInt2);
      return localStringBuilder.toString();
    }
    catch (IOException paramArrayOfByte)
    {
      throw new AssertionError(paramArrayOfByte);
    }
  }
  
  abstract void encodeTo(Appendable paramAppendable, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  @GwtIncompatible
  public final ByteSink encodingSink(CharSink paramCharSink)
  {
    Preconditions.checkNotNull(paramCharSink);
    return new BaseEncoding.1(this, paramCharSink);
  }
  
  @GwtIncompatible
  public abstract OutputStream encodingStream(Writer paramWriter);
  
  public abstract BaseEncoding lowerCase();
  
  abstract int maxDecodedSize(int paramInt);
  
  abstract int maxEncodedSize(int paramInt);
  
  public abstract BaseEncoding omitPadding();
  
  abstract CharMatcher padding();
  
  public abstract BaseEncoding upperCase();
  
  public abstract BaseEncoding withPadChar(char paramChar);
  
  public abstract BaseEncoding withSeparator(String paramString, int paramInt);
  
  static final class Alphabet
    extends CharMatcher
  {
    final int bitsPerChar;
    final int bytesPerChunk;
    private final char[] chars;
    final int charsPerChunk;
    private final byte[] decodabet;
    final int mask;
    private final String name;
    private final boolean[] validPadding;
    
    /* Error */
    Alphabet(String paramString, char[] paramArrayOfChar)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore 5
      //   3: aload_0
      //   4: invokespecial 27	com/google/common/base/CharMatcher:<init>	()V
      //   7: aload_0
      //   8: aload_1
      //   9: invokestatic 33	com/google/common/base/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
      //   12: checkcast 35	java/lang/String
      //   15: putfield 37	com/google/common/io/BaseEncoding$Alphabet:name	Ljava/lang/String;
      //   18: aload_0
      //   19: aload_2
      //   20: invokestatic 33	com/google/common/base/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
      //   23: checkcast 38	[C
      //   26: putfield 40	com/google/common/io/BaseEncoding$Alphabet:chars	[C
      //   29: aload_0
      //   30: aload_2
      //   31: arraylength
      //   32: getstatic 46	java/math/RoundingMode:UNNECESSARY	Ljava/math/RoundingMode;
      //   35: invokestatic 52	com/google/common/math/IntMath:log2	(ILjava/math/RoundingMode;)I
      //   38: putfield 54	com/google/common/io/BaseEncoding$Alphabet:bitsPerChar	I
      //   41: bipush 8
      //   43: aload_0
      //   44: getfield 54	com/google/common/io/BaseEncoding$Alphabet:bitsPerChar	I
      //   47: invokestatic 60	java/lang/Integer:lowestOneBit	(I)I
      //   50: invokestatic 66	java/lang/Math:min	(II)I
      //   53: istore 4
      //   55: aload_0
      //   56: bipush 8
      //   58: iload 4
      //   60: idiv
      //   61: putfield 68	com/google/common/io/BaseEncoding$Alphabet:charsPerChunk	I
      //   64: aload_0
      //   65: aload_0
      //   66: getfield 54	com/google/common/io/BaseEncoding$Alphabet:bitsPerChar	I
      //   69: iload 4
      //   71: idiv
      //   72: putfield 70	com/google/common/io/BaseEncoding$Alphabet:bytesPerChunk	I
      //   75: aload_0
      //   76: aload_2
      //   77: arraylength
      //   78: iconst_1
      //   79: isub
      //   80: putfield 72	com/google/common/io/BaseEncoding$Alphabet:mask	I
      //   83: sipush 128
      //   86: newarray byte
      //   88: astore_1
      //   89: aload_1
      //   90: iconst_m1
      //   91: invokestatic 78	java/util/Arrays:fill	([BB)V
      //   94: iconst_0
      //   95: istore 4
      //   97: iload 4
      //   99: aload_2
      //   100: arraylength
      //   101: if_icmpge +126 -> 227
      //   104: aload_2
      //   105: iload 4
      //   107: caload
      //   108: istore_3
      //   109: invokestatic 82	com/google/common/base/CharMatcher:ascii	()Lcom/google/common/base/CharMatcher;
      //   112: iload_3
      //   113: invokevirtual 86	com/google/common/base/CharMatcher:matches	(C)Z
      //   116: ldc 88
      //   118: iload_3
      //   119: invokestatic 92	com/google/common/base/Preconditions:checkArgument	(ZLjava/lang/String;C)V
      //   122: aload_1
      //   123: iload_3
      //   124: baload
      //   125: iconst_m1
      //   126: if_icmpne +95 -> 221
      //   129: iconst_1
      //   130: istore 6
      //   132: iload 6
      //   134: ldc 94
      //   136: iload_3
      //   137: invokestatic 92	com/google/common/base/Preconditions:checkArgument	(ZLjava/lang/String;C)V
      //   140: aload_1
      //   141: iload_3
      //   142: iload 4
      //   144: i2b
      //   145: bastore
      //   146: iload 4
      //   148: iconst_1
      //   149: iadd
      //   150: istore 4
      //   152: goto -55 -> 97
      //   155: astore_1
      //   156: new 96	java/lang/IllegalArgumentException
      //   159: dup
      //   160: new 98	java/lang/StringBuilder
      //   163: dup
      //   164: invokespecial 99	java/lang/StringBuilder:<init>	()V
      //   167: ldc 101
      //   169: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   172: aload_2
      //   173: arraylength
      //   174: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   177: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   180: aload_1
      //   181: invokespecial 115	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   184: athrow
      //   185: astore_1
      //   186: new 96	java/lang/IllegalArgumentException
      //   189: dup
      //   190: new 98	java/lang/StringBuilder
      //   193: dup
      //   194: invokespecial 99	java/lang/StringBuilder:<init>	()V
      //   197: ldc 117
      //   199: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   202: new 35	java/lang/String
      //   205: dup
      //   206: aload_2
      //   207: invokespecial 120	java/lang/String:<init>	([C)V
      //   210: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   213: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   216: aload_1
      //   217: invokespecial 115	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   220: athrow
      //   221: iconst_0
      //   222: istore 6
      //   224: goto -92 -> 132
      //   227: aload_0
      //   228: aload_1
      //   229: putfield 122	com/google/common/io/BaseEncoding$Alphabet:decodabet	[B
      //   232: aload_0
      //   233: getfield 68	com/google/common/io/BaseEncoding$Alphabet:charsPerChunk	I
      //   236: newarray boolean
      //   238: astore_1
      //   239: iload 5
      //   241: istore 4
      //   243: iload 4
      //   245: aload_0
      //   246: getfield 70	com/google/common/io/BaseEncoding$Alphabet:bytesPerChunk	I
      //   249: if_icmpge +30 -> 279
      //   252: aload_1
      //   253: iload 4
      //   255: bipush 8
      //   257: imul
      //   258: aload_0
      //   259: getfield 54	com/google/common/io/BaseEncoding$Alphabet:bitsPerChar	I
      //   262: getstatic 125	java/math/RoundingMode:CEILING	Ljava/math/RoundingMode;
      //   265: invokestatic 129	com/google/common/math/IntMath:divide	(IILjava/math/RoundingMode;)I
      //   268: iconst_1
      //   269: bastore
      //   270: iload 4
      //   272: iconst_1
      //   273: iadd
      //   274: istore 4
      //   276: goto -33 -> 243
      //   279: aload_0
      //   280: aload_1
      //   281: putfield 131	com/google/common/io/BaseEncoding$Alphabet:validPadding	[Z
      //   284: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	285	0	this	Alphabet
      //   0	285	1	paramString	String
      //   0	285	2	paramArrayOfChar	char[]
      //   108	34	3	c	char
      //   53	222	4	i	int
      //   1	239	5	j	int
      //   130	93	6	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   29	41	155	java/lang/ArithmeticException
      //   55	75	185	java/lang/ArithmeticException
    }
    
    private boolean hasLowerCase()
    {
      boolean bool2 = false;
      char[] arrayOfChar = this.chars;
      int j = arrayOfChar.length;
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < j)
        {
          if (Ascii.isLowerCase(arrayOfChar[i])) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 1;
      }
    }
    
    private boolean hasUpperCase()
    {
      boolean bool2 = false;
      char[] arrayOfChar = this.chars;
      int j = arrayOfChar.length;
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < j)
        {
          if (Ascii.isUpperCase(arrayOfChar[i])) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 1;
      }
    }
    
    boolean canDecode(char paramChar)
    {
      return (paramChar <= '') && (this.decodabet[paramChar] != -1);
    }
    
    int decode(char paramChar)
      throws BaseEncoding.DecodingException
    {
      if ((paramChar > '') || (this.decodabet[paramChar] == -1))
      {
        StringBuilder localStringBuilder = new StringBuilder().append("Unrecognized character: ");
        if (CharMatcher.invisible().matches(paramChar)) {}
        for (Object localObject = "0x" + Integer.toHexString(paramChar);; localObject = Character.valueOf(paramChar)) {
          throw new BaseEncoding.DecodingException(localObject);
        }
      }
      return this.decodabet[paramChar];
    }
    
    char encode(int paramInt)
    {
      return this.chars[paramInt];
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if ((paramObject instanceof Alphabet))
      {
        paramObject = (Alphabet)paramObject;
        return Arrays.equals(this.chars, paramObject.chars);
      }
      return false;
    }
    
    public int hashCode()
    {
      return Arrays.hashCode(this.chars);
    }
    
    boolean isValidPaddingStartPosition(int paramInt)
    {
      return this.validPadding[(paramInt % this.charsPerChunk)];
    }
    
    Alphabet lowerCase()
    {
      int i = 0;
      if (!hasUpperCase()) {
        return this;
      }
      if (!hasLowerCase()) {}
      char[] arrayOfChar;
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool, "Cannot call lowerCase() on a mixed-case alphabet");
        arrayOfChar = new char[this.chars.length];
        while (i < this.chars.length)
        {
          arrayOfChar[i] = Ascii.toLowerCase(this.chars[i]);
          i += 1;
        }
      }
      return new Alphabet(this.name + ".lowerCase()", arrayOfChar);
    }
    
    public boolean matches(char paramChar)
    {
      return (CharMatcher.ascii().matches(paramChar)) && (this.decodabet[paramChar] != -1);
    }
    
    public String toString()
    {
      return this.name;
    }
    
    Alphabet upperCase()
    {
      int i = 0;
      if (!hasLowerCase()) {
        return this;
      }
      if (!hasUpperCase()) {}
      char[] arrayOfChar;
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool, "Cannot call upperCase() on a mixed-case alphabet");
        arrayOfChar = new char[this.chars.length];
        while (i < this.chars.length)
        {
          arrayOfChar[i] = Ascii.toUpperCase(this.chars[i]);
          i += 1;
        }
      }
      return new Alphabet(this.name + ".upperCase()", arrayOfChar);
    }
  }
  
  static final class Base16Encoding
    extends BaseEncoding.StandardBaseEncoding
  {
    final char[] encoding = new char[512];
    
    private Base16Encoding(BaseEncoding.Alphabet paramAlphabet)
    {
      super(null);
      if (paramAlphabet.chars.length == 16) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool);
        while (i < 256)
        {
          this.encoding[i] = paramAlphabet.encode(i >>> 4);
          this.encoding[(i | 0x100)] = paramAlphabet.encode(i & 0xF);
          i += 1;
        }
      }
    }
    
    Base16Encoding(String paramString1, String paramString2)
    {
      this(new BaseEncoding.Alphabet(paramString1, paramString2.toCharArray()));
    }
    
    int decodeTo(byte[] paramArrayOfByte, CharSequence paramCharSequence)
      throws BaseEncoding.DecodingException
    {
      int j = 0;
      Preconditions.checkNotNull(paramArrayOfByte);
      if (paramCharSequence.length() % 2 == 1) {
        throw new BaseEncoding.DecodingException("Invalid input length " + paramCharSequence.length());
      }
      int i = 0;
      while (j < paramCharSequence.length())
      {
        int k = this.alphabet.decode(paramCharSequence.charAt(j));
        paramArrayOfByte[i] = ((byte)(this.alphabet.decode(paramCharSequence.charAt(j + 1)) | k << 4));
        j += 2;
        i += 1;
      }
      return i;
    }
    
    void encodeTo(Appendable paramAppendable, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      Preconditions.checkNotNull(paramAppendable);
      Preconditions.checkPositionIndexes(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
      int i = 0;
      while (i < paramInt2)
      {
        int j = paramArrayOfByte[(paramInt1 + i)] & 0xFF;
        paramAppendable.append(this.encoding[j]);
        paramAppendable.append(this.encoding[(j | 0x100)]);
        i += 1;
      }
    }
    
    BaseEncoding newInstance(BaseEncoding.Alphabet paramAlphabet, @Nullable Character paramCharacter)
    {
      return new Base16Encoding(paramAlphabet);
    }
  }
  
  static final class Base64Encoding
    extends BaseEncoding.StandardBaseEncoding
  {
    private Base64Encoding(BaseEncoding.Alphabet paramAlphabet, @Nullable Character paramCharacter)
    {
      super(paramCharacter);
      if (paramAlphabet.chars.length == 64) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool);
        return;
      }
    }
    
    Base64Encoding(String paramString1, String paramString2, @Nullable Character paramCharacter)
    {
      this(new BaseEncoding.Alphabet(paramString1, paramString2.toCharArray()), paramCharacter);
    }
    
    int decodeTo(byte[] paramArrayOfByte, CharSequence paramCharSequence)
      throws BaseEncoding.DecodingException
    {
      int j = 0;
      Preconditions.checkNotNull(paramArrayOfByte);
      paramCharSequence = padding().trimTrailingFrom(paramCharSequence);
      if (!this.alphabet.isValidPaddingStartPosition(paramCharSequence.length())) {
        throw new BaseEncoding.DecodingException("Invalid input length " + paramCharSequence.length());
      }
      int i = 0;
      for (;;)
      {
        int k;
        int m;
        if (j < paramCharSequence.length())
        {
          BaseEncoding.Alphabet localAlphabet = this.alphabet;
          k = j + 1;
          m = localAlphabet.decode(paramCharSequence.charAt(j));
          localAlphabet = this.alphabet;
          j = k + 1;
          int n = m << 18 | localAlphabet.decode(paramCharSequence.charAt(k)) << 12;
          k = i + 1;
          paramArrayOfByte[i] = ((byte)(n >>> 16));
          if (j >= paramCharSequence.length()) {
            break label289;
          }
          localAlphabet = this.alphabet;
          m = j + 1;
          n |= localAlphabet.decode(paramCharSequence.charAt(j)) << 6;
          i = k + 1;
          paramArrayOfByte[k] = ((byte)(n >>> 8 & 0xFF));
          if (m < paramCharSequence.length())
          {
            localAlphabet = this.alphabet;
            j = m + 1;
            m = localAlphabet.decode(paramCharSequence.charAt(m));
            k = i + 1;
            paramArrayOfByte[i] = ((byte)((n | m) & 0xFF));
            i = k;
          }
        }
        else
        {
          return i;
        }
        j = m;
        continue;
        label289:
        i = k;
      }
    }
    
    void encodeTo(Appendable paramAppendable, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      Preconditions.checkNotNull(paramAppendable);
      Preconditions.checkPositionIndexes(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
      int i = paramInt2;
      int j = paramInt1;
      while (i >= 3)
      {
        int n = j + 1;
        int k = paramArrayOfByte[j];
        int m = n + 1;
        n = paramArrayOfByte[n];
        j = m + 1;
        k = (n & 0xFF) << 8 | (k & 0xFF) << 16 | paramArrayOfByte[m] & 0xFF;
        paramAppendable.append(this.alphabet.encode(k >>> 18));
        paramAppendable.append(this.alphabet.encode(k >>> 12 & 0x3F));
        paramAppendable.append(this.alphabet.encode(k >>> 6 & 0x3F));
        paramAppendable.append(this.alphabet.encode(k & 0x3F));
        i -= 3;
      }
      if (j < paramInt1 + paramInt2) {
        encodeChunkTo(paramAppendable, paramArrayOfByte, j, paramInt1 + paramInt2 - j);
      }
    }
    
    BaseEncoding newInstance(BaseEncoding.Alphabet paramAlphabet, @Nullable Character paramCharacter)
    {
      return new Base64Encoding(paramAlphabet, paramCharacter);
    }
  }
  
  public static final class DecodingException
    extends IOException
  {
    DecodingException(String paramString)
    {
      super();
    }
    
    DecodingException(Throwable paramThrowable)
    {
      super();
    }
  }
  
  static final class SeparatedBaseEncoding
    extends BaseEncoding
  {
    private final int afterEveryChars;
    private final BaseEncoding delegate;
    private final String separator;
    private final CharMatcher separatorChars;
    
    SeparatedBaseEncoding(BaseEncoding paramBaseEncoding, String paramString, int paramInt)
    {
      this.delegate = ((BaseEncoding)Preconditions.checkNotNull(paramBaseEncoding));
      this.separator = ((String)Preconditions.checkNotNull(paramString));
      this.afterEveryChars = paramInt;
      if (paramInt > 0) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "Cannot add a separator after every %s chars", paramInt);
        this.separatorChars = CharMatcher.anyOf(paramString).precomputed();
        return;
      }
    }
    
    public boolean canDecode(CharSequence paramCharSequence)
    {
      return this.delegate.canDecode(this.separatorChars.removeFrom(paramCharSequence));
    }
    
    int decodeTo(byte[] paramArrayOfByte, CharSequence paramCharSequence)
      throws BaseEncoding.DecodingException
    {
      return this.delegate.decodeTo(paramArrayOfByte, this.separatorChars.removeFrom(paramCharSequence));
    }
    
    @GwtIncompatible
    public InputStream decodingStream(Reader paramReader)
    {
      return this.delegate.decodingStream(ignoringReader(paramReader, this.separatorChars));
    }
    
    void encodeTo(Appendable paramAppendable, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      this.delegate.encodeTo(separatingAppendable(paramAppendable, this.separator, this.afterEveryChars), paramArrayOfByte, paramInt1, paramInt2);
    }
    
    @GwtIncompatible
    public OutputStream encodingStream(Writer paramWriter)
    {
      return this.delegate.encodingStream(separatingWriter(paramWriter, this.separator, this.afterEveryChars));
    }
    
    public BaseEncoding lowerCase()
    {
      return this.delegate.lowerCase().withSeparator(this.separator, this.afterEveryChars);
    }
    
    int maxDecodedSize(int paramInt)
    {
      return this.delegate.maxDecodedSize(paramInt);
    }
    
    int maxEncodedSize(int paramInt)
    {
      paramInt = this.delegate.maxEncodedSize(paramInt);
      return paramInt + this.separator.length() * IntMath.divide(Math.max(0, paramInt - 1), this.afterEveryChars, RoundingMode.FLOOR);
    }
    
    public BaseEncoding omitPadding()
    {
      return this.delegate.omitPadding().withSeparator(this.separator, this.afterEveryChars);
    }
    
    CharMatcher padding()
    {
      return this.delegate.padding();
    }
    
    public String toString()
    {
      return this.delegate + ".withSeparator(\"" + this.separator + "\", " + this.afterEveryChars + ")";
    }
    
    public BaseEncoding upperCase()
    {
      return this.delegate.upperCase().withSeparator(this.separator, this.afterEveryChars);
    }
    
    public BaseEncoding withPadChar(char paramChar)
    {
      return this.delegate.withPadChar(paramChar).withSeparator(this.separator, this.afterEveryChars);
    }
    
    public BaseEncoding withSeparator(String paramString, int paramInt)
    {
      throw new UnsupportedOperationException("Already have a separator");
    }
  }
  
  static class StandardBaseEncoding
    extends BaseEncoding
  {
    final BaseEncoding.Alphabet alphabet;
    private transient BaseEncoding lowerCase;
    @Nullable
    final Character paddingChar;
    private transient BaseEncoding upperCase;
    
    StandardBaseEncoding(BaseEncoding.Alphabet paramAlphabet, @Nullable Character paramCharacter)
    {
      this.alphabet = ((BaseEncoding.Alphabet)Preconditions.checkNotNull(paramAlphabet));
      if ((paramCharacter == null) || (!paramAlphabet.matches(paramCharacter.charValue()))) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "Padding character %s was already in alphabet", paramCharacter);
        this.paddingChar = paramCharacter;
        return;
      }
    }
    
    StandardBaseEncoding(String paramString1, String paramString2, @Nullable Character paramCharacter)
    {
      this(new BaseEncoding.Alphabet(paramString1, paramString2.toCharArray()), paramCharacter);
    }
    
    public boolean canDecode(CharSequence paramCharSequence)
    {
      paramCharSequence = padding().trimTrailingFrom(paramCharSequence);
      if (!this.alphabet.isValidPaddingStartPosition(paramCharSequence.length())) {
        return false;
      }
      int i = 0;
      for (;;)
      {
        if (i >= paramCharSequence.length()) {
          break label63;
        }
        if (!this.alphabet.canDecode(paramCharSequence.charAt(i))) {
          break;
        }
        i += 1;
      }
      label63:
      return true;
    }
    
    int decodeTo(byte[] paramArrayOfByte, CharSequence paramCharSequence)
      throws BaseEncoding.DecodingException
    {
      Preconditions.checkNotNull(paramArrayOfByte);
      paramCharSequence = padding().trimTrailingFrom(paramCharSequence);
      if (!this.alphabet.isValidPaddingStartPosition(paramCharSequence.length())) {
        throw new BaseEncoding.DecodingException("Invalid input length " + paramCharSequence.length());
      }
      int j = 0;
      int i = 0;
      long l1;
      int k;
      int m;
      if (i < paramCharSequence.length())
      {
        l1 = 0L;
        k = 0;
        m = 0;
        label86:
        if (m < this.alphabet.charsPerChunk)
        {
          l1 <<= this.alphabet.bitsPerChar;
          if (i + m >= paramCharSequence.length()) {
            break label260;
          }
          long l2 = this.alphabet.decode(paramCharSequence.charAt(k + i));
          k += 1;
          l1 |= l2;
        }
      }
      label260:
      for (;;)
      {
        m += 1;
        break label86;
        int n = this.alphabet.bytesPerChunk;
        int i1 = this.alphabet.bitsPerChar;
        m = (this.alphabet.bytesPerChunk - 1) * 8;
        while (m >= n * 8 - k * i1)
        {
          paramArrayOfByte[j] = ((byte)(int)(l1 >>> m & 0xFF));
          m -= 8;
          j += 1;
        }
        i += this.alphabet.charsPerChunk;
        break;
        return j;
      }
    }
    
    @GwtIncompatible
    public InputStream decodingStream(Reader paramReader)
    {
      Preconditions.checkNotNull(paramReader);
      return new BaseEncoding.StandardBaseEncoding.2(this, paramReader);
    }
    
    void encodeChunkTo(Appendable paramAppendable, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      Preconditions.checkNotNull(paramAppendable);
      Preconditions.checkPositionIndexes(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
      if (paramInt2 <= this.alphabet.bytesPerChunk) {}
      long l;
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool);
        l = 0L;
        i = 0;
        while (i < paramInt2)
        {
          l = (l | paramArrayOfByte[(paramInt1 + i)] & 0xFF) << 8;
          i += 1;
        }
      }
      int i = this.alphabet.bitsPerChar;
      paramInt1 = 0;
      while (paramInt1 < paramInt2 * 8)
      {
        int j = (int)(l >>> (paramInt2 + 1) * 8 - i - paramInt1);
        int k = this.alphabet.mask;
        paramAppendable.append(this.alphabet.encode(j & k));
        paramInt1 += this.alphabet.bitsPerChar;
      }
      if (this.paddingChar != null) {
        while (paramInt1 < this.alphabet.bytesPerChunk * 8)
        {
          paramAppendable.append(this.paddingChar.charValue());
          paramInt1 += this.alphabet.bitsPerChar;
        }
      }
    }
    
    void encodeTo(Appendable paramAppendable, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      Preconditions.checkNotNull(paramAppendable);
      Preconditions.checkPositionIndexes(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
      int i = 0;
      while (i < paramInt2)
      {
        encodeChunkTo(paramAppendable, paramArrayOfByte, paramInt1 + i, Math.min(this.alphabet.bytesPerChunk, paramInt2 - i));
        i += this.alphabet.bytesPerChunk;
      }
    }
    
    @GwtIncompatible
    public OutputStream encodingStream(Writer paramWriter)
    {
      Preconditions.checkNotNull(paramWriter);
      return new BaseEncoding.StandardBaseEncoding.1(this, paramWriter);
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof StandardBaseEncoding))
      {
        paramObject = (StandardBaseEncoding)paramObject;
        bool1 = bool2;
        if (this.alphabet.equals(paramObject.alphabet))
        {
          bool1 = bool2;
          if (Objects.equal(this.paddingChar, paramObject.paddingChar)) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    
    public int hashCode()
    {
      return this.alphabet.hashCode() ^ Objects.hashCode(new Object[] { this.paddingChar });
    }
    
    public BaseEncoding lowerCase()
    {
      BaseEncoding localBaseEncoding = this.lowerCase;
      Object localObject = localBaseEncoding;
      if (localBaseEncoding == null)
      {
        localObject = this.alphabet.lowerCase();
        if (localObject != this.alphabet) {
          break label36;
        }
      }
      label36:
      for (localObject = this;; localObject = newInstance((BaseEncoding.Alphabet)localObject, this.paddingChar))
      {
        this.lowerCase = ((BaseEncoding)localObject);
        return localObject;
      }
    }
    
    int maxDecodedSize(int paramInt)
    {
      return (int)((this.alphabet.bitsPerChar * paramInt + 7L) / 8L);
    }
    
    int maxEncodedSize(int paramInt)
    {
      return this.alphabet.charsPerChunk * IntMath.divide(paramInt, this.alphabet.bytesPerChunk, RoundingMode.CEILING);
    }
    
    BaseEncoding newInstance(BaseEncoding.Alphabet paramAlphabet, @Nullable Character paramCharacter)
    {
      return new StandardBaseEncoding(paramAlphabet, paramCharacter);
    }
    
    public BaseEncoding omitPadding()
    {
      if (this.paddingChar == null) {
        return this;
      }
      return newInstance(this.alphabet, null);
    }
    
    CharMatcher padding()
    {
      if (this.paddingChar == null) {
        return CharMatcher.none();
      }
      return CharMatcher.is(this.paddingChar.charValue());
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("BaseEncoding.");
      localStringBuilder.append(this.alphabet.toString());
      if (8 % this.alphabet.bitsPerChar != 0)
      {
        if (this.paddingChar != null) {
          break label54;
        }
        localStringBuilder.append(".omitPadding()");
      }
      for (;;)
      {
        return localStringBuilder.toString();
        label54:
        localStringBuilder.append(".withPadChar('").append(this.paddingChar).append("')");
      }
    }
    
    public BaseEncoding upperCase()
    {
      BaseEncoding localBaseEncoding = this.upperCase;
      Object localObject = localBaseEncoding;
      if (localBaseEncoding == null)
      {
        localObject = this.alphabet.upperCase();
        if (localObject != this.alphabet) {
          break label36;
        }
      }
      label36:
      for (localObject = this;; localObject = newInstance((BaseEncoding.Alphabet)localObject, this.paddingChar))
      {
        this.upperCase = ((BaseEncoding)localObject);
        return localObject;
      }
    }
    
    public BaseEncoding withPadChar(char paramChar)
    {
      if ((8 % this.alphabet.bitsPerChar == 0) || ((this.paddingChar != null) && (this.paddingChar.charValue() == paramChar))) {
        return this;
      }
      return newInstance(this.alphabet, Character.valueOf(paramChar));
    }
    
    public BaseEncoding withSeparator(String paramString, int paramInt)
    {
      Preconditions.checkArgument(padding().or(this.alphabet).matchesNoneOf(paramString), "Separator (%s) cannot contain alphabet or padding characters", paramString);
      return new BaseEncoding.SeparatedBaseEncoding(this, paramString, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.io.BaseEncoding
 * JD-Core Version:    0.7.0.1
 */