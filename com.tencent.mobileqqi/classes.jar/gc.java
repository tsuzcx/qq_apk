import com.google.zxing.ReaderException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.StringUtils;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public final class gc
{
  private static final int jdField_a_of_type_Int = 1;
  private static final char[] jdField_a_of_type_ArrayOfChar;
  
  static
  {
    a = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 32, 36, 37, 42, 43, 45, 46, 47, 58 };
  }
  
  private static char a(int paramInt)
  {
    if (paramInt >= a.length) {
      throw ReaderException.getInstance();
    }
    return a[paramInt];
  }
  
  private static int a(BitSource paramBitSource)
  {
    int i = paramBitSource.a(8);
    if ((i & 0x80) == 0) {
      return i & 0x7F;
    }
    if ((i & 0xC0) == 128) {
      return (i & 0x3F) << 8 | paramBitSource.a(8);
    }
    if ((i & 0xE0) == 192) {
      return (i & 0x1F) << 16 | paramBitSource.a(16);
    }
    throw ReaderException.getInstance();
  }
  
  public static DecoderResult a(byte[] paramArrayOfByte, Version paramVersion, ErrorCorrectionLevel paramErrorCorrectionLevel, Map paramMap)
  {
    BitSource localBitSource = new BitSource(paramArrayOfByte);
    StringBuilder localStringBuilder = new StringBuilder(50);
    ArrayList localArrayList = new ArrayList(1);
    boolean bool = false;
    CharacterSetECI localCharacterSetECI = null;
    label181:
    label359:
    label367:
    label370:
    label373:
    label382:
    for (;;)
    {
      Mode localMode1;
      try
      {
        if (localBitSource.c() < 4)
        {
          localMode1 = Mode.TERMINATOR;
          if (localMode1 == Mode.TERMINATOR) {
            break label367;
          }
          if (localMode1 == Mode.FNC1_FIRST_POSITION) {
            break label373;
          }
          if (localMode1 == Mode.FNC1_SECOND_POSITION)
          {
            break label373;
            Mode localMode2 = Mode.TERMINATOR;
            if (localMode1 != localMode2) {
              break label370;
            }
            paramMap = localStringBuilder.toString();
            paramVersion = localArrayList;
            if (localArrayList.isEmpty()) {
              paramVersion = null;
            }
            if (paramErrorCorrectionLevel != null) {
              break label359;
            }
            paramErrorCorrectionLevel = null;
            return new DecoderResult(paramArrayOfByte, paramMap, paramVersion, paramErrorCorrectionLevel);
          }
        }
        else
        {
          localMode1 = Mode.forBits(localBitSource.a(4));
          continue;
        }
        if (localMode1 != Mode.STRUCTURED_APPEND) {
          break label181;
        }
        if (localBitSource.c() < 16) {
          throw ReaderException.getInstance();
        }
      }
      catch (IllegalArgumentException paramArrayOfByte)
      {
        throw ReaderException.getInstance();
      }
      localBitSource.a(16);
      continue;
      if (localMode1 == Mode.ECI)
      {
        localCharacterSetECI = CharacterSetECI.getCharacterSetECIByValue(a(localBitSource));
        if (localCharacterSetECI == null) {
          throw ReaderException.getInstance();
        }
      }
      else
      {
        if (localMode1 == Mode.HANZI)
        {
          i = localBitSource.a(4);
          int j = localBitSource.a(localMode1.getCharacterCountBits(paramVersion));
          if (i != 1) {
            break label382;
          }
          a(localBitSource, localStringBuilder, j);
          break label382;
        }
        int i = localBitSource.a(localMode1.getCharacterCountBits(paramVersion));
        if (localMode1 == Mode.NUMERIC)
        {
          c(localBitSource, localStringBuilder, i);
          continue;
        }
        if (localMode1 == Mode.ALPHANUMERIC)
        {
          a(localBitSource, localStringBuilder, i, bool);
          continue;
        }
        if (localMode1 == Mode.BYTE)
        {
          a(localBitSource, localStringBuilder, i, localCharacterSetECI, localArrayList, paramMap);
          continue;
        }
        if (localMode1 == Mode.KANJI)
        {
          b(localBitSource, localStringBuilder, i);
          continue;
        }
        throw ReaderException.getInstance();
        paramErrorCorrectionLevel = paramErrorCorrectionLevel.toString();
        continue;
        continue;
        continue;
        bool = true;
        continue;
      }
    }
  }
  
  private static void a(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt)
  {
    if (paramInt * 13 > paramBitSource.c()) {
      throw ReaderException.getInstance();
    }
    byte[] arrayOfByte = new byte[paramInt * 2];
    int j = 0;
    int i = paramInt;
    paramInt = j;
    if (i > 0)
    {
      j = paramBitSource.a(13);
      j = j % 96 | j / 96 << 8;
      if (j < 959) {
        j += 41377;
      }
      for (;;)
      {
        arrayOfByte[paramInt] = ((byte)(j >> 8 & 0xFF));
        arrayOfByte[(paramInt + 1)] = ((byte)(j & 0xFF));
        i -= 1;
        paramInt += 2;
        break;
        j += 42657;
      }
    }
    try
    {
      paramStringBuilder.append(new String(arrayOfByte, "GB2312"));
      return;
    }
    catch (UnsupportedEncodingException paramBitSource)
    {
      throw ReaderException.getInstance();
    }
  }
  
  private static void a(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt, CharacterSetECI paramCharacterSetECI, Collection paramCollection, Map paramMap)
  {
    if (paramInt << 3 > paramBitSource.c()) {
      throw ReaderException.getInstance();
    }
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfByte[i] = ((byte)paramBitSource.a(8));
      i += 1;
    }
    if (paramCharacterSetECI == null) {}
    for (paramBitSource = StringUtils.a(arrayOfByte, paramMap);; paramBitSource = paramCharacterSetECI.name()) {
      try
      {
        paramStringBuilder.append(new String(arrayOfByte, paramBitSource));
        paramCollection.add(arrayOfByte);
        return;
      }
      catch (UnsupportedEncodingException paramBitSource)
      {
        throw ReaderException.getInstance();
      }
    }
  }
  
  private static void a(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt, boolean paramBoolean)
  {
    int i = paramStringBuilder.length();
    while (paramInt > 1)
    {
      if (paramBitSource.c() < 11) {
        throw ReaderException.getInstance();
      }
      int j = paramBitSource.a(11);
      paramStringBuilder.append(a(j / 45));
      paramStringBuilder.append(a(j % 45));
      paramInt -= 2;
    }
    if (paramInt == 1)
    {
      if (paramBitSource.c() < 6) {
        throw ReaderException.getInstance();
      }
      paramStringBuilder.append(a(paramBitSource.a(6)));
    }
    if (paramBoolean)
    {
      paramInt = i;
      if (paramInt < paramStringBuilder.length())
      {
        if (paramStringBuilder.charAt(paramInt) == '%')
        {
          if ((paramInt >= paramStringBuilder.length() - 1) || (paramStringBuilder.charAt(paramInt + 1) != '%')) {
            break label159;
          }
          paramStringBuilder.deleteCharAt(paramInt + 1);
        }
        for (;;)
        {
          paramInt += 1;
          break;
          label159:
          paramStringBuilder.setCharAt(paramInt, '\035');
        }
      }
    }
  }
  
  private static void b(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt)
  {
    if (paramInt * 13 > paramBitSource.c()) {
      throw ReaderException.getInstance();
    }
    byte[] arrayOfByte = new byte[paramInt * 2];
    int j = 0;
    int i = paramInt;
    paramInt = j;
    if (i > 0)
    {
      j = paramBitSource.a(13);
      j = j % 192 | j / 192 << 8;
      if (j < 7936) {
        j += 33088;
      }
      for (;;)
      {
        arrayOfByte[paramInt] = ((byte)(j >> 8));
        arrayOfByte[(paramInt + 1)] = ((byte)j);
        i -= 1;
        paramInt += 2;
        break;
        j += 49472;
      }
    }
    try
    {
      paramStringBuilder.append(new String(arrayOfByte, "SJIS"));
      return;
    }
    catch (UnsupportedEncodingException paramBitSource)
    {
      throw ReaderException.getInstance();
    }
  }
  
  private static void c(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt)
  {
    while (paramInt >= 3)
    {
      if (paramBitSource.c() < 10) {
        throw ReaderException.getInstance();
      }
      int i = paramBitSource.a(10);
      if (i >= 1000) {
        throw ReaderException.getInstance();
      }
      paramStringBuilder.append(a(i / 100));
      paramStringBuilder.append(a(i / 10 % 10));
      paramStringBuilder.append(a(i % 10));
      paramInt -= 3;
    }
    if (paramInt == 2)
    {
      if (paramBitSource.c() < 7) {
        throw ReaderException.getInstance();
      }
      paramInt = paramBitSource.a(7);
      if (paramInt >= 100) {
        throw ReaderException.getInstance();
      }
      paramStringBuilder.append(a(paramInt / 10));
      paramStringBuilder.append(a(paramInt % 10));
    }
    while (paramInt != 1) {
      return;
    }
    if (paramBitSource.c() < 4) {
      throw ReaderException.getInstance();
    }
    paramInt = paramBitSource.a(4);
    if (paramInt >= 10) {
      throw ReaderException.getInstance();
    }
    paramStringBuilder.append(a(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gc
 * JD-Core Version:    0.7.0.1
 */