package org.java_websocket.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class Base64
{
  public static final int DO_BREAK_LINES = 8;
  public static final int ENCODE = 1;
  private static final byte EQUALS_SIGN = 61;
  public static final int GZIP = 2;
  private static final int MAX_LINE_LENGTH = 76;
  private static final byte NEW_LINE = 10;
  public static final int NO_OPTIONS = 0;
  public static final int ORDERED = 32;
  private static final String PREFERRED_ENCODING = "US-ASCII";
  public static final int URL_SAFE = 16;
  private static final byte WHITE_SPACE_ENC = -5;
  private static final byte[] _ORDERED_ALPHABET;
  private static final byte[] _ORDERED_DECODABET;
  private static final byte[] _STANDARD_ALPHABET;
  private static final byte[] _STANDARD_DECODABET;
  private static final byte[] _URL_SAFE_ALPHABET;
  private static final byte[] _URL_SAFE_DECODABET;
  
  static
  {
    if (!Base64.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      _STANDARD_ALPHABET = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
      _STANDARD_DECODABET = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
      _URL_SAFE_ALPHABET = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
      _URL_SAFE_DECODABET = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
      _ORDERED_ALPHABET = new byte[] { 45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122 };
      _ORDERED_DECODABET = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
      return;
    }
  }
  
  private static int decode4to3(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    if (paramArrayOfByte1 == null) {
      throw new IllegalArgumentException("Source array was null.");
    }
    if (paramArrayOfByte2 == null) {
      throw new IllegalArgumentException("Destination array was null.");
    }
    if ((paramInt1 < 0) || (paramInt1 + 3 >= paramArrayOfByte1.length)) {
      throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", new Object[] { Integer.valueOf(paramArrayOfByte1.length), Integer.valueOf(paramInt1) }));
    }
    if ((paramInt2 < 0) || (paramInt2 + 2 >= paramArrayOfByte2.length)) {
      throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", new Object[] { Integer.valueOf(paramArrayOfByte2.length), Integer.valueOf(paramInt2) }));
    }
    byte[] arrayOfByte = getDecodabet(paramInt3);
    if (paramArrayOfByte1[(paramInt1 + 2)] == 61)
    {
      paramArrayOfByte2[paramInt2] = ((byte)(((arrayOfByte[paramArrayOfByte1[paramInt1]] & 0xFF) << 18 | (arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]] & 0xFF) << 12) >>> 16));
      return 1;
    }
    if (paramArrayOfByte1[(paramInt1 + 3)] == 61)
    {
      paramInt1 = (arrayOfByte[paramArrayOfByte1[paramInt1]] & 0xFF) << 18 | (arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]] & 0xFF) << 12 | (arrayOfByte[paramArrayOfByte1[(paramInt1 + 2)]] & 0xFF) << 6;
      paramArrayOfByte2[paramInt2] = ((byte)(paramInt1 >>> 16));
      paramArrayOfByte2[(paramInt2 + 1)] = ((byte)(paramInt1 >>> 8));
      return 2;
    }
    paramInt1 = (arrayOfByte[paramArrayOfByte1[paramInt1]] & 0xFF) << 18 | (arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]] & 0xFF) << 12 | (arrayOfByte[paramArrayOfByte1[(paramInt1 + 2)]] & 0xFF) << 6 | arrayOfByte[paramArrayOfByte1[(paramInt1 + 3)]] & 0xFF;
    paramArrayOfByte2[paramInt2] = ((byte)(paramInt1 >> 16));
    paramArrayOfByte2[(paramInt2 + 1)] = ((byte)(paramInt1 >> 8));
    paramArrayOfByte2[(paramInt2 + 2)] = ((byte)paramInt1);
    return 3;
  }
  
  private static byte[] encode3to4(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4)
  {
    int j = 0;
    byte[] arrayOfByte = getAlphabet(paramInt4);
    if (paramInt2 > 0)
    {
      paramInt4 = paramArrayOfByte1[paramInt1] << 24 >>> 8;
      label25:
      if (paramInt2 <= 1) {
        break label104;
      }
    }
    label104:
    for (int i = paramArrayOfByte1[(paramInt1 + 1)] << 24 >>> 16;; i = 0)
    {
      if (paramInt2 > 2) {
        j = paramArrayOfByte1[(paramInt1 + 2)] << 24 >>> 24;
      }
      paramInt1 = j | i | paramInt4;
      switch (paramInt2)
      {
      default: 
        return paramArrayOfByte2;
        paramInt4 = 0;
        break label25;
      }
    }
    paramArrayOfByte2[paramInt3] = arrayOfByte[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = arrayOfByte[(paramInt1 >>> 6 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 3)] = arrayOfByte[(paramInt1 & 0x3F)];
    return paramArrayOfByte2;
    paramArrayOfByte2[paramInt3] = arrayOfByte[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = arrayOfByte[(paramInt1 >>> 6 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 3)] = 61;
    return paramArrayOfByte2;
    paramArrayOfByte2[paramInt3] = arrayOfByte[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = 61;
    paramArrayOfByte2[(paramInt3 + 3)] = 61;
    return paramArrayOfByte2;
  }
  
  private static byte[] encode3to4(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    encode3to4(paramArrayOfByte2, 0, paramInt1, paramArrayOfByte1, 0, paramInt2);
    return paramArrayOfByte1;
  }
  
  public static String encodeBytes(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    try
    {
      paramArrayOfByte = encodeBytes(paramArrayOfByte, 0, paramArrayOfByte.length, 0);
      if ((!$assertionsDisabled) && (paramArrayOfByte == null)) {
        throw new AssertionError();
      }
    }
    catch (IOException localIOException)
    {
      do
      {
        paramArrayOfByte = localObject;
      } while ($assertionsDisabled);
      throw new AssertionError(localIOException.getMessage());
    }
    return paramArrayOfByte;
  }
  
  public static String encodeBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    paramArrayOfByte = encodeBytesToBytes(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    try
    {
      String str = new String(paramArrayOfByte, "US-ASCII");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return new String(paramArrayOfByte);
  }
  
  /* Error */
  public static byte[] encodeBytesToBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 14
    //   3: aconst_null
    //   4: astore 13
    //   6: aload_0
    //   7: ifnonnull +14 -> 21
    //   10: new 195	java/lang/IllegalArgumentException
    //   13: dup
    //   14: ldc_w 258
    //   17: invokespecial 200	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   20: athrow
    //   21: iload_1
    //   22: ifge +31 -> 53
    //   25: new 195	java/lang/IllegalArgumentException
    //   28: dup
    //   29: new 260	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 263
    //   39: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: iload_1
    //   43: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokespecial 200	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   52: athrow
    //   53: iload_2
    //   54: ifge +31 -> 85
    //   57: new 195	java/lang/IllegalArgumentException
    //   60: dup
    //   61: new 260	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   68: ldc_w 275
    //   71: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: iload_2
    //   75: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   78: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokespecial 200	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   84: athrow
    //   85: iload_1
    //   86: iload_2
    //   87: iadd
    //   88: aload_0
    //   89: arraylength
    //   90: if_icmple +43 -> 133
    //   93: new 195	java/lang/IllegalArgumentException
    //   96: dup
    //   97: ldc_w 277
    //   100: iconst_3
    //   101: anewarray 4	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: iload_1
    //   107: invokestatic 210	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   110: aastore
    //   111: dup
    //   112: iconst_1
    //   113: iload_2
    //   114: invokestatic 210	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   117: aastore
    //   118: dup
    //   119: iconst_2
    //   120: aload_0
    //   121: arraylength
    //   122: invokestatic 210	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   125: aastore
    //   126: invokestatic 216	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   129: invokespecial 200	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   132: athrow
    //   133: iload_3
    //   134: iconst_2
    //   135: iand
    //   136: ifeq +146 -> 282
    //   139: new 279	java/io/ByteArrayOutputStream
    //   142: dup
    //   143: invokespecial 280	java/io/ByteArrayOutputStream:<init>	()V
    //   146: astore 10
    //   148: new 6	org/java_websocket/util/Base64$OutputStream
    //   151: dup
    //   152: aload 10
    //   154: iload_3
    //   155: iconst_1
    //   156: ior
    //   157: invokespecial 283	org/java_websocket/util/Base64$OutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   160: astore 12
    //   162: new 285	java/util/zip/GZIPOutputStream
    //   165: dup
    //   166: aload 12
    //   168: invokespecial 288	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   171: astore 11
    //   173: aload 11
    //   175: aload_0
    //   176: iload_1
    //   177: iload_2
    //   178: invokevirtual 292	java/util/zip/GZIPOutputStream:write	([BII)V
    //   181: aload 11
    //   183: invokevirtual 295	java/util/zip/GZIPOutputStream:close	()V
    //   186: aload 11
    //   188: ifnull +8 -> 196
    //   191: aload 11
    //   193: invokevirtual 295	java/util/zip/GZIPOutputStream:close	()V
    //   196: aload 12
    //   198: ifnull +8 -> 206
    //   201: aload 12
    //   203: invokevirtual 296	org/java_websocket/util/Base64$OutputStream:close	()V
    //   206: aload 10
    //   208: ifnull +8 -> 216
    //   211: aload 10
    //   213: invokevirtual 297	java/io/ByteArrayOutputStream:close	()V
    //   216: aload 10
    //   218: invokevirtual 301	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   221: astore_0
    //   222: aload_0
    //   223: areturn
    //   224: astore 11
    //   226: aconst_null
    //   227: astore 10
    //   229: aconst_null
    //   230: astore_0
    //   231: aload 13
    //   233: astore 12
    //   235: aload 11
    //   237: athrow
    //   238: astore 14
    //   240: aload_0
    //   241: astore 13
    //   243: aload 10
    //   245: astore 11
    //   247: aload 14
    //   249: astore_0
    //   250: aload 12
    //   252: ifnull +8 -> 260
    //   255: aload 12
    //   257: invokevirtual 295	java/util/zip/GZIPOutputStream:close	()V
    //   260: aload 11
    //   262: ifnull +8 -> 270
    //   265: aload 11
    //   267: invokevirtual 296	org/java_websocket/util/Base64$OutputStream:close	()V
    //   270: aload 13
    //   272: ifnull +8 -> 280
    //   275: aload 13
    //   277: invokevirtual 297	java/io/ByteArrayOutputStream:close	()V
    //   280: aload_0
    //   281: athrow
    //   282: iload_3
    //   283: bipush 8
    //   285: iand
    //   286: ifeq +153 -> 439
    //   289: iconst_1
    //   290: istore 6
    //   292: iload_2
    //   293: iconst_3
    //   294: idiv
    //   295: istore 5
    //   297: iload_2
    //   298: iconst_3
    //   299: irem
    //   300: ifle +145 -> 445
    //   303: iconst_4
    //   304: istore 4
    //   306: iload 4
    //   308: iload 5
    //   310: iconst_4
    //   311: imul
    //   312: iadd
    //   313: istore 5
    //   315: iload 5
    //   317: istore 4
    //   319: iload 6
    //   321: ifeq +13 -> 334
    //   324: iload 5
    //   326: iload 5
    //   328: bipush 76
    //   330: idiv
    //   331: iadd
    //   332: istore 4
    //   334: iload 4
    //   336: newarray byte
    //   338: astore 10
    //   340: iconst_0
    //   341: istore 5
    //   343: iconst_0
    //   344: istore 4
    //   346: iconst_0
    //   347: istore 7
    //   349: iload 7
    //   351: iload_2
    //   352: iconst_2
    //   353: isub
    //   354: if_icmpge +97 -> 451
    //   357: aload_0
    //   358: iload 7
    //   360: iload_1
    //   361: iadd
    //   362: iconst_3
    //   363: aload 10
    //   365: iload 4
    //   367: iload_3
    //   368: invokestatic 224	org/java_websocket/util/Base64:encode3to4	([BII[BII)[B
    //   371: pop
    //   372: iload 5
    //   374: iconst_4
    //   375: iadd
    //   376: istore 9
    //   378: iload 9
    //   380: istore 5
    //   382: iload 4
    //   384: istore 8
    //   386: iload 6
    //   388: ifeq +36 -> 424
    //   391: iload 9
    //   393: istore 5
    //   395: iload 4
    //   397: istore 8
    //   399: iload 9
    //   401: bipush 76
    //   403: if_icmplt +21 -> 424
    //   406: aload 10
    //   408: iload 4
    //   410: iconst_4
    //   411: iadd
    //   412: bipush 10
    //   414: bastore
    //   415: iload 4
    //   417: iconst_1
    //   418: iadd
    //   419: istore 8
    //   421: iconst_0
    //   422: istore 5
    //   424: iload 8
    //   426: iconst_4
    //   427: iadd
    //   428: istore 4
    //   430: iload 7
    //   432: iconst_3
    //   433: iadd
    //   434: istore 7
    //   436: goto -87 -> 349
    //   439: iconst_0
    //   440: istore 6
    //   442: goto -150 -> 292
    //   445: iconst_0
    //   446: istore 4
    //   448: goto -142 -> 306
    //   451: iload 4
    //   453: istore 5
    //   455: iload 7
    //   457: iload_2
    //   458: if_icmpge +27 -> 485
    //   461: aload_0
    //   462: iload 7
    //   464: iload_1
    //   465: iadd
    //   466: iload_2
    //   467: iload 7
    //   469: isub
    //   470: aload 10
    //   472: iload 4
    //   474: iload_3
    //   475: invokestatic 224	org/java_websocket/util/Base64:encode3to4	([BII[BII)[B
    //   478: pop
    //   479: iload 4
    //   481: iconst_4
    //   482: iadd
    //   483: istore 5
    //   485: aload 10
    //   487: astore_0
    //   488: iload 5
    //   490: aload 10
    //   492: arraylength
    //   493: iconst_1
    //   494: isub
    //   495: if_icmpgt -273 -> 222
    //   498: iload 5
    //   500: newarray byte
    //   502: astore_0
    //   503: aload 10
    //   505: iconst_0
    //   506: aload_0
    //   507: iconst_0
    //   508: iload 5
    //   510: invokestatic 307	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   513: aload_0
    //   514: areturn
    //   515: astore_0
    //   516: goto -320 -> 196
    //   519: astore_0
    //   520: goto -314 -> 206
    //   523: astore_0
    //   524: goto -308 -> 216
    //   527: astore 10
    //   529: goto -269 -> 260
    //   532: astore 10
    //   534: goto -264 -> 270
    //   537: astore 10
    //   539: goto -259 -> 280
    //   542: astore_0
    //   543: aconst_null
    //   544: astore 11
    //   546: aconst_null
    //   547: astore 13
    //   549: aload 14
    //   551: astore 12
    //   553: goto -303 -> 250
    //   556: astore_0
    //   557: aconst_null
    //   558: astore 11
    //   560: aload 14
    //   562: astore 12
    //   564: aload 10
    //   566: astore 13
    //   568: goto -318 -> 250
    //   571: astore_0
    //   572: aload 12
    //   574: astore 11
    //   576: aload 14
    //   578: astore 12
    //   580: aload 10
    //   582: astore 13
    //   584: goto -334 -> 250
    //   587: astore_0
    //   588: aload 11
    //   590: astore 13
    //   592: aload 12
    //   594: astore 11
    //   596: aload 13
    //   598: astore 12
    //   600: aload 10
    //   602: astore 13
    //   604: goto -354 -> 250
    //   607: astore 11
    //   609: aconst_null
    //   610: astore 12
    //   612: aload 10
    //   614: astore_0
    //   615: aload 12
    //   617: astore 10
    //   619: aload 13
    //   621: astore 12
    //   623: goto -388 -> 235
    //   626: astore 11
    //   628: aload 10
    //   630: astore_0
    //   631: aload 12
    //   633: astore 10
    //   635: aload 13
    //   637: astore 12
    //   639: goto -404 -> 235
    //   642: astore 14
    //   644: aload 11
    //   646: astore 13
    //   648: aload 10
    //   650: astore_0
    //   651: aload 14
    //   653: astore 11
    //   655: aload 12
    //   657: astore 10
    //   659: aload 13
    //   661: astore 12
    //   663: goto -428 -> 235
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	666	0	paramArrayOfByte	byte[]
    //   0	666	1	paramInt1	int
    //   0	666	2	paramInt2	int
    //   0	666	3	paramInt3	int
    //   304	179	4	i	int
    //   295	214	5	j	int
    //   290	151	6	k	int
    //   347	123	7	m	int
    //   384	44	8	n	int
    //   376	28	9	i1	int
    //   146	358	10	localObject1	Object
    //   527	1	10	localException1	java.lang.Exception
    //   532	1	10	localException2	java.lang.Exception
    //   537	76	10	localException3	java.lang.Exception
    //   617	41	10	localObject2	Object
    //   171	21	11	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    //   224	12	11	localIOException1	IOException
    //   245	350	11	localObject3	Object
    //   607	1	11	localIOException2	IOException
    //   626	19	11	localIOException3	IOException
    //   653	1	11	localIOException4	IOException
    //   160	502	12	localObject4	Object
    //   4	656	13	localObject5	Object
    //   1	1	14	localObject6	Object
    //   238	339	14	localObject7	Object
    //   642	10	14	localIOException5	IOException
    // Exception table:
    //   from	to	target	type
    //   139	148	224	java/io/IOException
    //   235	238	238	finally
    //   191	196	515	java/lang/Exception
    //   201	206	519	java/lang/Exception
    //   211	216	523	java/lang/Exception
    //   255	260	527	java/lang/Exception
    //   265	270	532	java/lang/Exception
    //   275	280	537	java/lang/Exception
    //   139	148	542	finally
    //   148	162	556	finally
    //   162	173	571	finally
    //   173	186	587	finally
    //   148	162	607	java/io/IOException
    //   162	173	626	java/io/IOException
    //   173	186	642	java/io/IOException
  }
  
  private static final byte[] getAlphabet(int paramInt)
  {
    if ((paramInt & 0x10) == 16) {
      return _URL_SAFE_ALPHABET;
    }
    if ((paramInt & 0x20) == 32) {
      return _ORDERED_ALPHABET;
    }
    return _STANDARD_ALPHABET;
  }
  
  private static final byte[] getDecodabet(int paramInt)
  {
    if ((paramInt & 0x10) == 16) {
      return _URL_SAFE_DECODABET;
    }
    if ((paramInt & 0x20) == 32) {
      return _ORDERED_DECODABET;
    }
    return _STANDARD_DECODABET;
  }
  
  public static class OutputStream
    extends FilterOutputStream
  {
    private byte[] b4;
    private boolean breakLines;
    private byte[] buffer;
    private int bufferLength;
    private byte[] decodabet;
    private boolean encode;
    private int lineLength;
    private int options;
    private int position;
    private boolean suspendEncoding;
    
    public OutputStream(OutputStream paramOutputStream)
    {
      this(paramOutputStream, 1);
    }
    
    public OutputStream(OutputStream paramOutputStream, int paramInt)
    {
      super();
      boolean bool1;
      if ((paramInt & 0x8) != 0)
      {
        bool1 = true;
        this.breakLines = bool1;
        if ((paramInt & 0x1) == 0) {
          break label106;
        }
        bool1 = bool2;
        label34:
        this.encode = bool1;
        if (!this.encode) {
          break label112;
        }
      }
      label106:
      label112:
      for (int i = 3;; i = 4)
      {
        this.bufferLength = i;
        this.buffer = new byte[this.bufferLength];
        this.position = 0;
        this.lineLength = 0;
        this.suspendEncoding = false;
        this.b4 = new byte[4];
        this.options = paramInt;
        this.decodabet = Base64.getDecodabet(paramInt);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label34;
      }
    }
    
    public void close()
      throws IOException
    {
      flushBase64();
      super.close();
      this.buffer = null;
      this.out = null;
    }
    
    public void flushBase64()
      throws IOException
    {
      if (this.position > 0)
      {
        if (this.encode)
        {
          this.out.write(Base64.encode3to4(this.b4, this.buffer, this.position, this.options));
          this.position = 0;
        }
      }
      else {
        return;
      }
      throw new IOException("Base64 input not properly padded.");
    }
    
    public void write(int paramInt)
      throws IOException
    {
      if (this.suspendEncoding) {
        this.out.write(paramInt);
      }
      do
      {
        do
        {
          do
          {
            return;
            if (!this.encode) {
              break;
            }
            arrayOfByte = this.buffer;
            i = this.position;
            this.position = (i + 1);
            arrayOfByte[i] = ((byte)paramInt);
          } while (this.position < this.bufferLength);
          this.out.write(Base64.encode3to4(this.b4, this.buffer, this.bufferLength, this.options));
          this.lineLength += 4;
          if ((this.breakLines) && (this.lineLength >= 76))
          {
            this.out.write(10);
            this.lineLength = 0;
          }
          this.position = 0;
          return;
          if (this.decodabet[(paramInt & 0x7F)] <= -5) {
            break;
          }
          byte[] arrayOfByte = this.buffer;
          int i = this.position;
          this.position = (i + 1);
          arrayOfByte[i] = ((byte)paramInt);
        } while (this.position < this.bufferLength);
        paramInt = Base64.decode4to3(this.buffer, 0, this.b4, 0, this.options);
        this.out.write(this.b4, 0, paramInt);
        this.position = 0;
        return;
      } while (this.decodabet[(paramInt & 0x7F)] == -5);
      throw new IOException("Invalid character in Base64 data.");
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      if (this.suspendEncoding) {
        this.out.write(paramArrayOfByte, paramInt1, paramInt2);
      }
      for (;;)
      {
        return;
        int i = 0;
        while (i < paramInt2)
        {
          write(paramArrayOfByte[(paramInt1 + i)]);
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.java_websocket.util.Base64
 * JD-Core Version:    0.7.0.1
 */