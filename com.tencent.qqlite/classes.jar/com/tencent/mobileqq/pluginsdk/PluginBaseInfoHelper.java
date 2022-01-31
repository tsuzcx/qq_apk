package com.tencent.mobileqq.pluginsdk;

import android.util.Xml;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlSerializer;

public final class PluginBaseInfoHelper
{
  /* Error */
  public static PluginBaseInfo createFromFile(java.io.File paramFile, Class<? extends PluginBaseInfo> paramClass)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokevirtual 36	java/io/File:length	()J
    //   6: l2i
    //   7: newarray byte
    //   9: astore 5
    //   11: aconst_null
    //   12: astore_3
    //   13: aconst_null
    //   14: astore 4
    //   16: new 38	java/io/FileInputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 41	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   24: astore_0
    //   25: aload_0
    //   26: aload 5
    //   28: invokevirtual 45	java/io/FileInputStream:read	([B)I
    //   31: pop
    //   32: new 47	java/lang/String
    //   35: dup
    //   36: aload 5
    //   38: iconst_0
    //   39: invokestatic 51	com/tencent/mobileqq/pluginsdk/PluginBaseInfoHelper$Base64Helper:decode	([BI)[B
    //   42: invokespecial 54	java/lang/String:<init>	([B)V
    //   45: astore_3
    //   46: new 18	com/tencent/mobileqq/pluginsdk/PluginBaseInfoHelper$PluginInfoParser
    //   49: dup
    //   50: invokespecial 55	com/tencent/mobileqq/pluginsdk/PluginBaseInfoHelper$PluginInfoParser:<init>	()V
    //   53: astore 4
    //   55: aload 4
    //   57: aload_1
    //   58: invokevirtual 59	com/tencent/mobileqq/pluginsdk/PluginBaseInfoHelper$PluginInfoParser:setResultClass	(Ljava/lang/Class;)V
    //   61: aload_3
    //   62: aload 4
    //   64: invokestatic 63	com/tencent/mobileqq/pluginsdk/PluginBaseInfoHelper:parseConfig	(Ljava/lang/String;Lcom/tencent/mobileqq/pluginsdk/PluginBaseInfoHelper$PluginInfoParser;)Lcom/tencent/mobileqq/pluginsdk/PluginBaseInfo;
    //   67: astore_1
    //   68: aload_0
    //   69: ifnull +60 -> 129
    //   72: aload_0
    //   73: invokevirtual 66	java/io/FileInputStream:close	()V
    //   76: aload_1
    //   77: areturn
    //   78: astore_0
    //   79: aload_1
    //   80: areturn
    //   81: astore_0
    //   82: aload 4
    //   84: astore_0
    //   85: aload_2
    //   86: astore_1
    //   87: aload_0
    //   88: ifnull -12 -> 76
    //   91: aload_0
    //   92: invokevirtual 66	java/io/FileInputStream:close	()V
    //   95: aconst_null
    //   96: areturn
    //   97: astore_0
    //   98: aconst_null
    //   99: areturn
    //   100: astore_0
    //   101: aload_3
    //   102: astore_1
    //   103: aload_1
    //   104: ifnull +7 -> 111
    //   107: aload_1
    //   108: invokevirtual 66	java/io/FileInputStream:close	()V
    //   111: aload_0
    //   112: athrow
    //   113: astore_1
    //   114: goto -3 -> 111
    //   117: astore_2
    //   118: aload_0
    //   119: astore_1
    //   120: aload_2
    //   121: astore_0
    //   122: goto -19 -> 103
    //   125: astore_1
    //   126: goto -41 -> 85
    //   129: aload_1
    //   130: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramFile	java.io.File
    //   0	131	1	paramClass	Class<? extends PluginBaseInfo>
    //   1	85	2	localObject1	Object
    //   117	4	2	localObject2	Object
    //   12	90	3	str	String
    //   14	69	4	localPluginInfoParser	PluginInfoParser
    //   9	28	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   72	76	78	java/io/IOException
    //   16	25	81	java/lang/Exception
    //   91	95	97	java/io/IOException
    //   16	25	100	finally
    //   107	111	113	java/io/IOException
    //   25	68	117	finally
    //   25	68	125	java/lang/Exception
  }
  
  public static PluginBaseInfo parseConfig(String paramString, PluginInfoParser paramPluginInfoParser)
  {
    try
    {
      SAXParserFactory.newInstance().newSAXParser().parse(new ByteArrayInputStream(paramString.getBytes()), paramPluginInfoParser);
      paramString = paramPluginInfoParser.getResult();
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static class Base64Helper
  {
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;
    
    static
    {
      if (!PluginBaseInfoHelper.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }
    
    public static byte[] decode(String paramString, int paramInt)
    {
      return decode(paramString.getBytes(), paramInt);
    }
    
    public static byte[] decode(byte[] paramArrayOfByte, int paramInt)
    {
      return decode(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
    }
    
    public static byte[] decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    {
      Decoder localDecoder = new Decoder(paramInt3, new byte[paramInt2 * 3 / 4]);
      if (!localDecoder.process(paramArrayOfByte, paramInt1, paramInt2, true)) {
        throw new IllegalArgumentException("bad base-64");
      }
      if (localDecoder.op == localDecoder.output.length) {
        return localDecoder.output;
      }
      paramArrayOfByte = new byte[localDecoder.op];
      System.arraycopy(localDecoder.output, 0, paramArrayOfByte, 0, localDecoder.op);
      return paramArrayOfByte;
    }
    
    public static byte[] encode(byte[] paramArrayOfByte, int paramInt)
    {
      return encode(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
    }
    
    public static byte[] encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    {
      Encoder localEncoder = new Encoder(paramInt3, null);
      int i = paramInt2 / 3 * 4;
      int j;
      if (localEncoder.do_padding)
      {
        paramInt3 = i;
        if (paramInt2 % 3 > 0) {
          paramInt3 = i + 4;
        }
        i = paramInt3;
        if (localEncoder.do_newline)
        {
          i = paramInt3;
          if (paramInt2 > 0)
          {
            j = (paramInt2 - 1) / 57;
            if (!localEncoder.do_cr) {
              break label186;
            }
          }
        }
      }
      label186:
      for (i = 2;; i = 1)
      {
        i = paramInt3 + i * (j + 1);
        localEncoder.output = new byte[i];
        localEncoder.process(paramArrayOfByte, paramInt1, paramInt2, true);
        if (($assertionsDisabled) || (localEncoder.op == i)) {
          break label192;
        }
        throw new AssertionError();
        paramInt3 = i;
        switch (paramInt2 % 3)
        {
        case 0: 
        default: 
          paramInt3 = i;
          break;
        case 1: 
          paramInt3 = i + 2;
          break;
        case 2: 
          paramInt3 = i + 3;
          break;
        }
      }
      label192:
      return localEncoder.output;
    }
    
    public static String encodeToString(byte[] paramArrayOfByte, int paramInt)
    {
      try
      {
        paramArrayOfByte = new String(encode(paramArrayOfByte, paramInt), "US-ASCII");
        return paramArrayOfByte;
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        throw new AssertionError(paramArrayOfByte);
      }
    }
    
    public static String encodeToString(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    {
      try
      {
        paramArrayOfByte = new String(encode(paramArrayOfByte, paramInt1, paramInt2, paramInt3), "US-ASCII");
        return paramArrayOfByte;
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        throw new AssertionError(paramArrayOfByte);
      }
    }
    
    static abstract class Coder
    {
      public int op;
      public byte[] output;
      
      public abstract int maxOutputSize(int paramInt);
      
      public abstract boolean process(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean);
    }
    
    static class Decoder
      extends PluginBaseInfoHelper.Base64Helper.Coder
    {
      private static final int[] DECODE = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
      private static final int[] DECODE_WEBSAFE = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
      private static final int EQUALS = -2;
      private static final int SKIP = -1;
      private final int[] alphabet;
      private int state;
      private int value;
      
      public Decoder(int paramInt, byte[] paramArrayOfByte)
      {
        this.output = paramArrayOfByte;
        if ((paramInt & 0x8) == 0) {}
        for (paramArrayOfByte = DECODE;; paramArrayOfByte = DECODE_WEBSAFE)
        {
          this.alphabet = paramArrayOfByte;
          this.state = 0;
          this.value = 0;
          return;
        }
      }
      
      public int maxOutputSize(int paramInt)
      {
        return paramInt * 3 / 4 + 10;
      }
      
      public boolean process(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
      {
        if (this.state == 6) {
          return false;
        }
        int j = paramInt1;
        int i2 = paramInt2 + paramInt1;
        int n = this.state;
        paramInt2 = this.value;
        int i = 0;
        byte[] arrayOfByte = this.output;
        int[] arrayOfInt = this.alphabet;
        int k;
        int i1;
        int m;
        if (j < i2)
        {
          k = i;
          i1 = j;
          m = paramInt2;
          if (n == 0)
          {
            for (paramInt1 = paramInt2; j + 4 <= i2; paramInt1 = paramInt2)
            {
              paramInt2 = arrayOfInt[(paramArrayOfByte[j] & 0xFF)] << 18 | arrayOfInt[(paramArrayOfByte[(j + 1)] & 0xFF)] << 12 | arrayOfInt[(paramArrayOfByte[(j + 2)] & 0xFF)] << 6 | arrayOfInt[(paramArrayOfByte[(j + 3)] & 0xFF)];
              paramInt1 = paramInt2;
              if (paramInt2 < 0) {
                break;
              }
              arrayOfByte[(i + 2)] = ((byte)paramInt2);
              arrayOfByte[(i + 1)] = ((byte)(paramInt2 >> 8));
              arrayOfByte[i] = ((byte)(paramInt2 >> 16));
              i += 3;
              j += 4;
            }
            k = i;
            i1 = j;
            m = paramInt1;
            if (j >= i2) {
              paramInt2 = paramInt1;
            }
          }
        }
        for (paramInt1 = i;; paramInt1 = i)
        {
          if (!paramBoolean)
          {
            this.state = n;
            this.value = paramInt2;
            this.op = paramInt1;
            return true;
            j = arrayOfInt[(paramArrayOfByte[i1] & 0xFF)];
            switch (n)
            {
            default: 
              paramInt2 = m;
              paramInt1 = n;
              i = k;
            }
            label639:
            do
            {
              do
              {
                for (;;)
                {
                  j = i1 + 1;
                  n = paramInt1;
                  break;
                  if (j >= 0)
                  {
                    paramInt2 = j;
                    paramInt1 = n + 1;
                    i = k;
                  }
                  else
                  {
                    i = k;
                    paramInt1 = n;
                    paramInt2 = m;
                    if (j != -1)
                    {
                      this.state = 6;
                      return false;
                      if (j >= 0)
                      {
                        paramInt2 = m << 6 | j;
                        paramInt1 = n + 1;
                        i = k;
                      }
                      else
                      {
                        i = k;
                        paramInt1 = n;
                        paramInt2 = m;
                        if (j != -1)
                        {
                          this.state = 6;
                          return false;
                          if (j >= 0)
                          {
                            paramInt2 = m << 6 | j;
                            paramInt1 = n + 1;
                            i = k;
                          }
                          else if (j == -2)
                          {
                            arrayOfByte[k] = ((byte)(m >> 4));
                            paramInt1 = 4;
                            i = k + 1;
                            paramInt2 = m;
                          }
                          else
                          {
                            i = k;
                            paramInt1 = n;
                            paramInt2 = m;
                            if (j != -1)
                            {
                              this.state = 6;
                              return false;
                              if (j >= 0)
                              {
                                paramInt2 = m << 6 | j;
                                arrayOfByte[(k + 2)] = ((byte)paramInt2);
                                arrayOfByte[(k + 1)] = ((byte)(paramInt2 >> 8));
                                arrayOfByte[k] = ((byte)(paramInt2 >> 16));
                                i = k + 3;
                                paramInt1 = 0;
                              }
                              else if (j == -2)
                              {
                                arrayOfByte[(k + 1)] = ((byte)(m >> 2));
                                arrayOfByte[k] = ((byte)(m >> 10));
                                i = k + 2;
                                paramInt1 = 5;
                                paramInt2 = m;
                              }
                              else
                              {
                                i = k;
                                paramInt1 = n;
                                paramInt2 = m;
                                if (j != -1)
                                {
                                  this.state = 6;
                                  return false;
                                  if (j != -2) {
                                    break label639;
                                  }
                                  paramInt1 = n + 1;
                                  i = k;
                                  paramInt2 = m;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
                i = k;
                paramInt1 = n;
                paramInt2 = m;
              } while (j == -1);
              this.state = 6;
              return false;
              i = k;
              paramInt1 = n;
              paramInt2 = m;
            } while (j == -1);
            this.state = 6;
            return false;
          }
          switch (n)
          {
          default: 
          case 0: 
          case 1: 
          case 2: 
          case 3: 
            for (;;)
            {
              this.state = n;
              this.op = paramInt1;
              return true;
              continue;
              this.state = 6;
              return false;
              i = paramInt1 + 1;
              arrayOfByte[paramInt1] = ((byte)(paramInt2 >> 4));
              paramInt1 = i;
              continue;
              i = paramInt1 + 1;
              arrayOfByte[paramInt1] = ((byte)(paramInt2 >> 10));
              arrayOfByte[i] = ((byte)(paramInt2 >> 2));
              paramInt1 = i + 1;
            }
          }
          this.state = 6;
          return false;
        }
      }
    }
    
    static class Encoder
      extends PluginBaseInfoHelper.Base64Helper.Coder
    {
      private static final byte[] ENCODE;
      private static final byte[] ENCODE_WEBSAFE;
      public static final int LINE_GROUPS = 19;
      private final byte[] alphabet;
      private int count;
      public final boolean do_cr;
      public final boolean do_newline;
      public final boolean do_padding;
      private final byte[] tail;
      int tailLen;
      
      static
      {
        if (!PluginBaseInfoHelper.class.desiredAssertionStatus()) {}
        for (boolean bool = true;; bool = false)
        {
          $assertionsDisabled = bool;
          ENCODE = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
          ENCODE_WEBSAFE = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
          return;
        }
      }
      
      public Encoder(int paramInt, byte[] paramArrayOfByte)
      {
        this.output = paramArrayOfByte;
        boolean bool1;
        if ((paramInt & 0x1) == 0)
        {
          bool1 = true;
          this.do_padding = bool1;
          if ((paramInt & 0x2) != 0) {
            break label101;
          }
          bool1 = true;
          label33:
          this.do_newline = bool1;
          if ((paramInt & 0x4) == 0) {
            break label106;
          }
          bool1 = bool2;
          label47:
          this.do_cr = bool1;
          if ((paramInt & 0x8) != 0) {
            break label111;
          }
          paramArrayOfByte = ENCODE;
          label63:
          this.alphabet = paramArrayOfByte;
          this.tail = new byte[2];
          this.tailLen = 0;
          if (!this.do_newline) {
            break label118;
          }
        }
        label101:
        label106:
        label111:
        label118:
        for (paramInt = 19;; paramInt = -1)
        {
          this.count = paramInt;
          return;
          bool1 = false;
          break;
          bool1 = false;
          break label33;
          bool1 = false;
          break label47;
          paramArrayOfByte = ENCODE_WEBSAFE;
          break label63;
        }
      }
      
      public int maxOutputSize(int paramInt)
      {
        return paramInt * 8 / 5 + 10;
      }
      
      public boolean process(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
      {
        byte[] arrayOfByte1 = this.alphabet;
        byte[] arrayOfByte2 = this.output;
        int k = 0;
        int n = this.count;
        int i = paramInt1;
        int i1 = paramInt2 + paramInt1;
        paramInt2 = -1;
        paramInt1 = i;
        int j = paramInt2;
        int m;
        switch (this.tailLen)
        {
        default: 
          j = paramInt2;
          paramInt1 = i;
        case 0: 
          paramInt2 = n;
          i = k;
          k = paramInt1;
          if (j != -1)
          {
            i = 0 + 1;
            arrayOfByte2[0] = arrayOfByte1[(j >> 18 & 0x3F)];
            paramInt2 = i + 1;
            arrayOfByte2[i] = arrayOfByte1[(j >> 12 & 0x3F)];
            i = paramInt2 + 1;
            arrayOfByte2[paramInt2] = arrayOfByte1[(j >> 6 & 0x3F)];
            m = i + 1;
            arrayOfByte2[i] = arrayOfByte1[(j & 0x3F)];
            j = n - 1;
            paramInt2 = j;
            i = m;
            k = paramInt1;
            if (j == 0)
            {
              paramInt2 = m;
              if (this.do_cr)
              {
                arrayOfByte2[m] = 13;
                paramInt2 = m + 1;
              }
              i = paramInt2 + 1;
              arrayOfByte2[paramInt2] = 10;
              k = 19;
              paramInt2 = paramInt1;
              paramInt1 = i;
            }
          }
          break;
        }
        for (;;)
        {
          if (paramInt2 + 3 <= i1)
          {
            i = (paramArrayOfByte[paramInt2] & 0xFF) << 16 | (paramArrayOfByte[(paramInt2 + 1)] & 0xFF) << 8 | paramArrayOfByte[(paramInt2 + 2)] & 0xFF;
            arrayOfByte2[paramInt1] = arrayOfByte1[(i >> 18 & 0x3F)];
            arrayOfByte2[(paramInt1 + 1)] = arrayOfByte1[(i >> 12 & 0x3F)];
            arrayOfByte2[(paramInt1 + 2)] = arrayOfByte1[(i >> 6 & 0x3F)];
            arrayOfByte2[(paramInt1 + 3)] = arrayOfByte1[(i & 0x3F)];
            j = paramInt2 + 3;
            paramInt1 += 4;
            m = k - 1;
            paramInt2 = m;
            i = paramInt1;
            k = j;
            if (m != 0) {
              break label1242;
            }
            paramInt2 = paramInt1;
            if (this.do_cr)
            {
              arrayOfByte2[paramInt1] = 13;
              paramInt2 = paramInt1 + 1;
            }
            paramInt1 = paramInt2 + 1;
            arrayOfByte2[paramInt2] = 10;
            k = 19;
            paramInt2 = j;
            continue;
            paramInt1 = i;
            j = paramInt2;
            if (i + 2 > i1) {
              break;
            }
            paramInt2 = this.tail[0];
            j = i + 1;
            i = paramArrayOfByte[i];
            paramInt1 = j + 1;
            j = (paramInt2 & 0xFF) << 16 | (i & 0xFF) << 8 | paramArrayOfByte[j] & 0xFF;
            this.tailLen = 0;
            break;
            paramInt1 = i;
            j = paramInt2;
            if (i + 1 > i1) {
              break;
            }
            j = (this.tail[0] & 0xFF) << 16 | (this.tail[1] & 0xFF) << 8 | paramArrayOfByte[i] & 0xFF;
            this.tailLen = 0;
            paramInt1 = i + 1;
            break;
          }
          if (paramBoolean)
          {
            if (paramInt2 - this.tailLen == i1 - 1)
            {
              i = 0;
              if (this.tailLen > 0)
              {
                j = this.tail[0];
                i = 0 + 1;
              }
              for (;;)
              {
                j = (j & 0xFF) << 4;
                this.tailLen -= i;
                i = paramInt1 + 1;
                arrayOfByte2[paramInt1] = arrayOfByte1[(j >> 6 & 0x3F)];
                paramInt1 = i + 1;
                arrayOfByte2[i] = arrayOfByte1[(j & 0x3F)];
                j = paramInt1;
                if (this.do_padding)
                {
                  i = paramInt1 + 1;
                  arrayOfByte2[paramInt1] = 61;
                  j = i + 1;
                  arrayOfByte2[i] = 61;
                }
                paramInt1 = j;
                i = paramInt2;
                if (this.do_newline)
                {
                  paramInt1 = j;
                  if (this.do_cr)
                  {
                    arrayOfByte2[j] = 13;
                    paramInt1 = j + 1;
                  }
                  i = paramInt1 + 1;
                  arrayOfByte2[paramInt1] = 10;
                  paramInt1 = i;
                  i = paramInt2;
                }
                label736:
                if (($assertionsDisabled) || (this.tailLen == 0)) {
                  break;
                }
                throw new AssertionError();
                m = paramInt2 + 1;
                j = paramArrayOfByte[paramInt2];
                paramInt2 = m;
              }
            }
            if (paramInt2 - this.tailLen == i1 - 2)
            {
              i = 0;
              if (this.tailLen > 1)
              {
                j = this.tail[0];
                i = 0 + 1;
                label810:
                if (this.tailLen <= 0) {
                  break label1012;
                }
                m = this.tail[i];
                i += 1;
              }
              for (;;)
              {
                j = (j & 0xFF) << 10 | (m & 0xFF) << 2;
                this.tailLen -= i;
                i = paramInt1 + 1;
                arrayOfByte2[paramInt1] = arrayOfByte1[(j >> 12 & 0x3F)];
                m = i + 1;
                arrayOfByte2[i] = arrayOfByte1[(j >> 6 & 0x3F)];
                paramInt1 = m + 1;
                arrayOfByte2[m] = arrayOfByte1[(j & 0x3F)];
                j = paramInt1;
                if (this.do_padding)
                {
                  arrayOfByte2[paramInt1] = 61;
                  j = paramInt1 + 1;
                }
                paramInt1 = j;
                i = paramInt2;
                if (!this.do_newline) {
                  break label736;
                }
                paramInt1 = j;
                if (this.do_cr)
                {
                  arrayOfByte2[j] = 13;
                  paramInt1 = j + 1;
                }
                i = paramInt1 + 1;
                arrayOfByte2[paramInt1] = 10;
                paramInt1 = i;
                break;
                m = paramInt2 + 1;
                j = paramArrayOfByte[paramInt2];
                paramInt2 = m;
                break label810;
                label1012:
                m = paramArrayOfByte[paramInt2];
                paramInt2 += 1;
              }
            }
            i = paramInt1;
            if (this.do_newline)
            {
              i = paramInt1;
              if (paramInt1 > 0)
              {
                i = paramInt1;
                if (k != 19)
                {
                  if (!this.do_cr) {
                    break label1239;
                  }
                  i = paramInt1 + 1;
                  arrayOfByte2[paramInt1] = 13;
                  paramInt1 = i;
                }
              }
            }
          }
          label1168:
          label1239:
          for (;;)
          {
            i = paramInt1 + 1;
            arrayOfByte2[paramInt1] = 10;
            paramInt1 = i;
            i = paramInt2;
            break;
            paramInt2 = paramInt1;
            if (!$assertionsDisabled)
            {
              paramInt2 = paramInt1;
              if (i != i1)
              {
                throw new AssertionError();
                if (paramInt2 != i1 - 1) {
                  break label1168;
                }
                arrayOfByte1 = this.tail;
                i = this.tailLen;
                this.tailLen = (i + 1);
                arrayOfByte1[i] = paramArrayOfByte[paramInt2];
              }
            }
            for (paramInt2 = paramInt1;; paramInt2 = paramInt1)
            {
              this.op = paramInt2;
              this.count = k;
              return true;
              if (paramInt2 == i1 - 2)
              {
                arrayOfByte1 = this.tail;
                i = this.tailLen;
                this.tailLen = (i + 1);
                arrayOfByte1[i] = paramArrayOfByte[paramInt2];
                arrayOfByte1 = this.tail;
                i = this.tailLen;
                this.tailLen = (i + 1);
                arrayOfByte1[i] = paramArrayOfByte[(paramInt2 + 1)];
              }
            }
          }
          label1242:
          j = k;
          paramInt1 = i;
          k = paramInt2;
          paramInt2 = j;
        }
      }
    }
  }
  
  public static class PluginInfoParser
    extends DefaultHandler
  {
    private static final String TAG_CUR_VERSION = "CurVersion";
    private static final String TAG_FORCE_URL = "ForceUrl";
    private static final String TAG_ID = "ID";
    private static final String TAG_INSTALLED_PATH = "InstalledPath";
    private static final String TAG_INSTALL_TYPE = "InstallType";
    private static final String TAG_LENGTH = "Length";
    private static final String TAG_MD5 = "MD5";
    private static final String TAG_NAME = "Name";
    private static final String TAG_PACKAGE_NAME = "PackageName";
    private static final String TAG_PLUGIN_INFO = "PluginInfo";
    private static final String TAG_PROCESSES = "Processes";
    private static final String TAG_STATE = "State";
    private static final String TAG_TYPE = "Type";
    private static final String TAG_UPDATE_TYPE = "UpdateType";
    private static final String TAG_URL = "URL";
    private static final String TAG_VERSION = "Version";
    private StringBuilder mBuilder;
    private PluginBaseInfo mResult;
    private Class<? extends PluginBaseInfo> mResultClass;
    
    public static String pluginToXML(PluginBaseInfo paramPluginBaseInfo)
      throws Exception
    {
      XmlSerializer localXmlSerializer = Xml.newSerializer();
      StringWriter localStringWriter = new StringWriter();
      localXmlSerializer.setOutput(localStringWriter);
      localXmlSerializer.startDocument("utf-8", null);
      localXmlSerializer.startTag("", "PluginInfo");
      localXmlSerializer.startTag("", "ID");
      localXmlSerializer.text(paramPluginBaseInfo.mID);
      localXmlSerializer.endTag("", "ID");
      localXmlSerializer.startTag("", "Name");
      localXmlSerializer.text(paramPluginBaseInfo.mName);
      localXmlSerializer.endTag("", "Name");
      localXmlSerializer.startTag("", "Version");
      localXmlSerializer.text(paramPluginBaseInfo.mVersion);
      localXmlSerializer.endTag("", "Version");
      localXmlSerializer.startTag("", "URL");
      localXmlSerializer.text(paramPluginBaseInfo.mURL);
      localXmlSerializer.endTag("", "URL");
      localXmlSerializer.startTag("", "MD5");
      localXmlSerializer.text(paramPluginBaseInfo.mMD5);
      localXmlSerializer.endTag("", "MD5");
      localXmlSerializer.startTag("", "Type");
      localXmlSerializer.text(String.valueOf(paramPluginBaseInfo.mType));
      localXmlSerializer.endTag("", "Type");
      localXmlSerializer.startTag("", "PackageName");
      localXmlSerializer.text(paramPluginBaseInfo.mPackageName);
      localXmlSerializer.endTag("", "PackageName");
      localXmlSerializer.startTag("", "CurVersion");
      localXmlSerializer.text(String.valueOf(paramPluginBaseInfo.mCurVersion));
      localXmlSerializer.endTag("", "CurVersion");
      localXmlSerializer.startTag("", "Length");
      localXmlSerializer.text(String.valueOf(paramPluginBaseInfo.mLength));
      localXmlSerializer.endTag("", "Length");
      localXmlSerializer.startTag("", "State");
      localXmlSerializer.text(String.valueOf(paramPluginBaseInfo.mState));
      localXmlSerializer.endTag("", "State");
      String str1 = "";
      String str2 = str1;
      if (paramPluginBaseInfo.mProcesses != null)
      {
        String[] arrayOfString = paramPluginBaseInfo.mProcesses;
        int j = arrayOfString.length;
        int i = 0;
        for (;;)
        {
          str2 = str1;
          if (i >= j) {
            break;
          }
          str2 = arrayOfString[i];
          str1 = str1 + str2 + "|";
          i += 1;
        }
      }
      localXmlSerializer.startTag("", "Processes");
      localXmlSerializer.text(str2);
      localXmlSerializer.endTag("", "Processes");
      localXmlSerializer.startTag("", "UpdateType");
      localXmlSerializer.text(String.valueOf(paramPluginBaseInfo.mUpdateType));
      localXmlSerializer.endTag("", "UpdateType");
      localXmlSerializer.startTag("", "InstallType");
      localXmlSerializer.text(String.valueOf(paramPluginBaseInfo.mInstallType));
      localXmlSerializer.endTag("", "InstallType");
      localXmlSerializer.startTag("", "InstalledPath");
      if (paramPluginBaseInfo.mInstalledPath == null) {}
      for (paramPluginBaseInfo = "";; paramPluginBaseInfo = paramPluginBaseInfo.mInstalledPath)
      {
        localXmlSerializer.text(paramPluginBaseInfo);
        localXmlSerializer.endTag("", "InstalledPath");
        localXmlSerializer.endTag("", "PluginInfo");
        localXmlSerializer.endDocument();
        return localStringWriter.toString();
      }
    }
    
    public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
      throws SAXException
    {
      this.mBuilder.append(paramArrayOfChar, paramInt1, paramInt2);
    }
    
    public void endDocument()
      throws SAXException
    {
      this.mBuilder = null;
    }
    
    public void endElement(String paramString1, String paramString2, String paramString3)
      throws SAXException
    {
      paramString1 = this.mBuilder.toString();
      if ("ID".equals(paramString2)) {
        this.mResult.mID = paramString1;
      }
      do
      {
        return;
        if ("Name".equals(paramString2))
        {
          this.mResult.mName = paramString1;
          return;
        }
        if ("Version".equals(paramString2))
        {
          this.mResult.mVersion = paramString1;
          return;
        }
        if ("URL".equals(paramString2))
        {
          this.mResult.mURL = paramString1;
          return;
        }
        if ("MD5".equals(paramString2))
        {
          this.mResult.mMD5 = paramString1;
          return;
        }
        if ("Type".equals(paramString2))
        {
          this.mResult.mType = Integer.valueOf(paramString1).intValue();
          return;
        }
        if ("PackageName".equals(paramString2))
        {
          this.mResult.mPackageName = paramString1;
          return;
        }
        if ("CurVersion".equals(paramString2))
        {
          this.mResult.mCurVersion = Long.parseLong(paramString1);
          return;
        }
        if ("Length".equals(paramString2))
        {
          this.mResult.mLength = Long.parseLong(paramString1);
          return;
        }
        if ("State".equals(paramString2))
        {
          this.mResult.mState = Integer.parseInt(paramString1);
          return;
        }
        if ("Processes".equals(paramString2))
        {
          if (paramString1 != null)
          {
            this.mResult.mProcesses = paramString1.split("\\|");
            return;
          }
          this.mResult.mProcesses = new String[0];
          return;
        }
        if ("UpdateType".equals(paramString2))
        {
          this.mResult.mUpdateType = Integer.parseInt(paramString1);
          return;
        }
        if ("InstallType".equals(paramString2))
        {
          this.mResult.mInstallType = Integer.parseInt(paramString1);
          return;
        }
        if ("InstalledPath".equals(paramString2))
        {
          if ((paramString1 == null) || (paramString1.length() == 0))
          {
            this.mResult.mInstalledPath = null;
            return;
          }
          this.mResult.mInstalledPath = paramString1;
          return;
        }
      } while ((!"ForceUrl".equals(paramString2)) || (paramString1 == null) || (paramString1.length() <= 0));
      this.mResult.mForceUrl = 1;
    }
    
    public PluginBaseInfo getResult()
    {
      return this.mResult;
    }
    
    public void setResultClass(Class<? extends PluginBaseInfo> paramClass)
    {
      this.mResultClass = paramClass;
    }
    
    public void startDocument()
      throws SAXException
    {
      this.mBuilder = new StringBuilder();
    }
    
    public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
      throws SAXException
    {
      this.mBuilder.setLength(0);
      if ("PluginInfo".equals(paramString2)) {}
      try
      {
        this.mResult = ((PluginBaseInfo)this.mResultClass.newInstance());
        return;
      }
      catch (Exception paramString1) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper
 * JD-Core Version:    0.7.0.1
 */