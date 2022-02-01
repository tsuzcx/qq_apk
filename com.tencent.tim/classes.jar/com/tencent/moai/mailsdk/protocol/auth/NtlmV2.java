package com.tencent.moai.mailsdk.protocol.auth;

import android.util.Log;
import com.tencent.moai.mailsdk.util.log.Logger;
import com.tencent.moai.mailsdk.util.stream.BASE64DecoderStream;
import com.tencent.moai.mailsdk.util.stream.BASE64EncoderStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class NtlmV2
{
  private static String DEFAULT_OEM_ENCODING = "Cp850";
  private static final byte[] NTLMSSP_SIGNATURE = { 78, 84, 76, 77, 83, 83, 80, 0 };
  private static final Random RANDOM;
  private static final String RC4_NAME = "RC4";
  private static final String TAG = "NtlmV2";
  protected String hostname;
  protected MD4 md4;
  protected String ntdomain;
  protected String password;
  protected byte[] type1;
  protected String username;
  
  static
  {
    try
    {
      "".getBytes(DEFAULT_OEM_ENCODING);
      RANDOM = new Random();
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Logger.log(5, "NtlmV2", "WARNING: The default OEM encoding " + DEFAULT_OEM_ENCODING + " does not appear to be supported by this JRE. The default encoding will be US-ASCII.");
        DEFAULT_OEM_ENCODING = "US-ASCII";
      }
    }
  }
  
  public NtlmV2(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    int i = paramString2.indexOf('.');
    String str1 = paramString2;
    if (i != -1) {
      str1 = paramString2.substring(0, i);
    }
    i = paramString3.indexOf('\\');
    String str2;
    if (i != -1)
    {
      paramString2 = paramString3.substring(0, i).toUpperCase(Locale.ENGLISH);
      str2 = paramString3.substring(i + 1);
    }
    for (;;)
    {
      this.ntdomain = paramString2;
      this.hostname = str1;
      this.username = str2;
      this.password = paramString4;
      init0();
      return;
      paramString2 = paramString1;
      str2 = paramString3;
      if (paramString1 == null)
      {
        paramString2 = "";
        str2 = paramString3;
      }
    }
  }
  
  private byte[] computeResponse(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2)
  {
    paramArrayOfByte1 = new HMACT64(paramArrayOfByte1);
    paramArrayOfByte1.update(paramArrayOfByte2);
    paramArrayOfByte1.update(paramArrayOfByte3, paramInt1, paramInt2);
    paramArrayOfByte1 = paramArrayOfByte1.digest();
    paramArrayOfByte2 = new byte[paramArrayOfByte1.length + paramArrayOfByte3.length];
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte2, paramArrayOfByte1.length, paramArrayOfByte3.length);
    return paramArrayOfByte2;
  }
  
  private void copybytes(byte[] paramArrayOfByte, int paramInt, String paramString1, String paramString2)
    throws UnsupportedEncodingException
  {
    try
    {
      paramString1 = paramString1.getBytes(paramString2);
      System.arraycopy(paramString1, 0, paramArrayOfByte, paramInt, paramString1.length);
      return;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw paramArrayOfByte;
    }
  }
  
  private static Cipher createRC4(byte[] paramArrayOfByte)
  {
    try
    {
      Cipher localCipher = Cipher.getInstance("RC4");
      localCipher.init(1, new SecretKeySpec(paramArrayOfByte, "RC4"));
      return localCipher;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new RuntimeException("Internal error", paramArrayOfByte);
    }
  }
  
  private int getDefaultFlags(Type2Message paramType2Message)
  {
    if ((paramType2Message.getFlags() & 1L) != 0L) {}
    for (int i = 1;; i = 2) {
      return i | 0x200;
    }
  }
  
  private byte[] getLMv2Response(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      byte[] arrayOfByte = new byte[16];
      arrayOfByte = new byte[24];
      paramString3 = new HMACT64(this.md4.digest(paramString3.getBytes("UTF-16LE")));
      paramString3.update(paramString2.toUpperCase().getBytes("UTF-16LE"));
      paramString3.update(paramString1.toUpperCase().getBytes("UTF-16LE"));
      paramString1 = new HMACT64(paramString3.digest());
      paramString1.update(paramArrayOfByte1);
      paramString1.update(paramArrayOfByte2);
      paramString1.digest(arrayOfByte, 0, 16);
      System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, 16, 8);
      return arrayOfByte;
    }
    catch (Exception paramString1)
    {
      Logger.log(6, "NtlmV2", "getLMv2Response " + Log.getStackTraceString(paramString1));
    }
    return null;
  }
  
  private byte[] getNTLMv2Response(Type2Message paramType2Message, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramType2Message != null) && (paramArrayOfByte1 != null) && (paramArrayOfByte2 != null))
    {
      long l = System.currentTimeMillis();
      return getNTLMv2Response(paramArrayOfByte1, paramType2Message.getChallenge(), paramArrayOfByte2, (l + 11644473600000L) * 10000L, paramType2Message.getTargetInformation());
    }
    return null;
  }
  
  private byte[] getNTLMv2Response(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, long paramLong, byte[] paramArrayOfByte4)
  {
    if (paramArrayOfByte4 != null) {}
    for (int i = paramArrayOfByte4.length;; i = 0)
    {
      byte[] arrayOfByte = new byte[i + 28 + 4];
      Encdec.enc_uint32le(257, arrayOfByte, 0);
      Encdec.enc_uint32le(0, arrayOfByte, 4);
      Encdec.enc_uint64le(paramLong, arrayOfByte, 8);
      System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, 16, 8);
      Encdec.enc_uint32le(0, arrayOfByte, 24);
      if (paramArrayOfByte4 != null) {
        System.arraycopy(paramArrayOfByte4, 0, arrayOfByte, 28, i);
      }
      Encdec.enc_uint32le(0, arrayOfByte, i + 28);
      return computeResponse(paramArrayOfByte1, paramArrayOfByte2, arrayOfByte, 0, arrayOfByte.length);
    }
  }
  
  private String getType3Message(Type2Message paramType2Message, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
    throws Exception
  {
    byte[] arrayOfByte3 = nTOWFv2(paramString2, paramString3, paramString1);
    byte[] arrayOfByte1 = new byte[8];
    RANDOM.nextBytes(arrayOfByte1);
    arrayOfByte1 = getLMv2Response(paramString2, paramString3, paramString1, paramType2Message.getChallenge(), arrayOfByte1);
    paramString1 = new byte[8];
    RANDOM.nextBytes(paramString1);
    byte[] arrayOfByte2 = getNTLMv2Response(paramType2Message, arrayOfByte3, paramString1);
    int i = getDefaultFlags(paramType2Message) | paramInt;
    paramType2Message = null;
    if ((i & 0x10) == 16)
    {
      paramType2Message = new HMACT64(arrayOfByte3);
      paramType2Message.update(arrayOfByte2, 0, 16);
      paramString1 = paramType2Message.digest();
      paramType2Message = paramString1;
      if ((i & 0x40000000) != 0)
      {
        arrayOfByte3 = new byte[16];
        RANDOM.nextBytes(arrayOfByte3);
        paramType2Message = new byte[16];
        createRC4(paramString1).doFinal(arrayOfByte3, 0, 16, paramType2Message, 0);
      }
    }
    try
    {
      paramType2Message = new String(BASE64EncoderStream.encode(toByteArray(paramString2, paramString3, paramString4, arrayOfByte1, arrayOfByte2, paramType2Message, paramInt)), "iso-8859-1");
      return paramType2Message;
    }
    catch (UnsupportedEncodingException paramType2Message)
    {
      throw paramType2Message;
    }
  }
  
  private byte[] nTOWFv2(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString3 = new HMACT64(this.md4.digest(paramString3.getBytes("UTF-16LE")));
      paramString3.update(paramString2.toUpperCase().getBytes("UTF-16LE"));
      paramString3.update(paramString1.getBytes("UTF-16LE"));
      paramString1 = paramString3.digest();
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      throw new RuntimeException(paramString1.getMessage());
    }
  }
  
  private static byte[] readSecurityBuffer(byte[] paramArrayOfByte, int paramInt)
  {
    int i = readUShort(paramArrayOfByte, paramInt);
    paramInt = readULong(paramArrayOfByte, paramInt + 4);
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(paramArrayOfByte, paramInt, arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  private static int readULong(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[paramInt] & 0xFF | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24;
  }
  
  private static int readUShort(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[paramInt] & 0xFF | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8;
  }
  
  private byte[] toByteArray(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt)
    throws IllegalStateException
  {
    int k;
    String str;
    if ((paramInt & 0x1) != 0)
    {
      k = 1;
      if (k != 0)
      {
        str = null;
        label18:
        if (paramString1 == null) {
          break label383;
        }
      }
    }
    for (;;)
    {
      try
      {
        if (paramString1.length() == 0) {
          break label383;
        }
        if (k != 0)
        {
          paramString1 = paramString1.getBytes("UTF-16LE");
          break label389;
          if (localObject == null) {
            break label409;
          }
          i = localObject.length;
          if ((paramString2 == null) || (paramString2.length() == 0)) {
            break label378;
          }
          if (k == 0) {
            continue;
          }
          paramString1 = paramString2.getBytes("UTF-16LE");
          break label395;
          if (paramString2 == null) {
            break label415;
          }
          j = paramString2.length;
          if ((paramString3 == null) || (paramString3.length() == 0)) {
            break label373;
          }
          if (k == 0) {
            continue;
          }
          paramString1 = paramString3.getBytes("UTF-16LE");
          break label400;
          if (paramString1 == null) {
            continue;
          }
          k = paramString1.length;
          if (paramArrayOfByte1 == null) {
            continue;
          }
          m = paramArrayOfByte1.length;
          if (paramArrayOfByte2 == null) {
            continue;
          }
          n = paramArrayOfByte2.length;
          if (paramArrayOfByte3 == null) {
            continue;
          }
          i1 = paramArrayOfByte3.length;
          paramString3 = new byte[i1 + (i + 64 + j + k + m + n)];
          System.arraycopy(NTLMSSP_SIGNATURE, 0, paramString3, 0, 8);
          writeULong(paramString3, 8, 3);
          writeSecurityBuffer(paramString3, 12, 64, paramArrayOfByte1);
          m += 64;
          writeSecurityBuffer(paramString3, 20, m, paramArrayOfByte2);
          m = n + m;
          writeSecurityBuffer(paramString3, 28, m, (byte[])localObject);
          i = m + i;
          writeSecurityBuffer(paramString3, 36, i, paramString2);
          i += j;
          writeSecurityBuffer(paramString3, 44, i, paramString1);
          writeSecurityBuffer(paramString3, 52, i + k, paramArrayOfByte3);
          writeULong(paramString3, 60, paramInt);
          return paramString3;
          str = DEFAULT_OEM_ENCODING;
          break label18;
        }
        paramString1 = paramString1.getBytes(str);
        break label389;
        paramString1 = paramString2.toUpperCase().getBytes(str);
        break label395;
        paramString1 = paramString3.toUpperCase().getBytes(str);
        break label400;
        k = 0;
        continue;
        int m = 0;
        continue;
        int n = 0;
        continue;
        int i1 = 0;
        continue;
        paramString1 = null;
      }
      catch (IOException paramString1)
      {
        throw new IllegalStateException(paramString1.getMessage());
      }
      label373:
      continue;
      label378:
      paramString2 = null;
      continue;
      label383:
      Object localObject = null;
      continue;
      label389:
      localObject = paramString1;
      continue;
      label395:
      paramString2 = paramString1;
      continue;
      label400:
      continue;
      k = 0;
      break;
      label409:
      int i = 0;
      continue;
      label415:
      int j = 0;
    }
  }
  
  private static void writeSecurityBuffer(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte2 != null) {}
    for (int i = paramArrayOfByte2.length;; i = 0)
    {
      if (i != 0)
      {
        writeUShort(paramArrayOfByte1, paramInt1, i);
        writeUShort(paramArrayOfByte1, paramInt1 + 2, i);
        writeULong(paramArrayOfByte1, paramInt1 + 4, paramInt2);
        System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, paramInt2, i);
      }
      return;
    }
  }
  
  private static void writeULong(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[paramInt1] = ((byte)(paramInt2 & 0xFF));
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(paramInt2 >> 8 & 0xFF));
    paramArrayOfByte[(paramInt1 + 2)] = ((byte)(paramInt2 >> 16 & 0xFF));
    paramArrayOfByte[(paramInt1 + 3)] = ((byte)(paramInt2 >> 24 & 0xFF));
  }
  
  private static void writeUShort(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[paramInt1] = ((byte)(paramInt2 & 0xFF));
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(paramInt2 >> 8 & 0xFF));
  }
  
  public String generateType1Msg()
    throws Exception
  {
    int i = this.ntdomain.length();
    this.type1[16] = ((byte)(i % 256));
    this.type1[17] = ((byte)(i / 256));
    this.type1[18] = this.type1[16];
    this.type1[19] = this.type1[17];
    if (i == 0)
    {
      arrayOfByte = this.type1;
      arrayOfByte[13] = ((byte)(arrayOfByte[13] & 0xFFFFFFEF));
    }
    int j = this.hostname.length();
    this.type1[24] = ((byte)(j % 256));
    this.type1[25] = ((byte)(j / 256));
    this.type1[26] = this.type1[24];
    this.type1[27] = this.type1[25];
    copybytes(this.type1, 32, this.hostname, "iso-8859-1");
    copybytes(this.type1, j + 32, this.ntdomain, "iso-8859-1");
    this.type1[20] = ((byte)((j + 32) % 256));
    this.type1[21] = ((byte)((j + 32) / 256));
    byte[] arrayOfByte = new byte[j + 32 + i];
    System.arraycopy(this.type1, 0, arrayOfByte, 0, i + (j + 32));
    return new String(BASE64EncoderStream.encode(arrayOfByte), "iso-8859-1");
  }
  
  public String generateType3Msg(String paramString)
  {
    try
    {
      paramString = BASE64DecoderStream.decode(paramString.getBytes("us-ascii"));
      int i;
      int j;
      int k;
      return "";
    }
    catch (UnsupportedEncodingException paramString)
    {
      try
      {
        paramString = new Type2Message(paramString);
        i = (int)paramString.getFlags();
        j = NtlmFlag.NTLMSSP_TARGET_TYPE_DOMAIN;
        k = NtlmFlag.NTLMSSP_TARGET_TYPE_SERVER;
        return getType3Message(paramString, this.password, this.ntdomain, this.username, this.hostname, i & ((j | k) ^ 0xFFFFFFFF));
      }
      catch (IOException paramString)
      {
        Logger.log(6, "type2message", "Invalid Type 2 message " + paramString.getMessage());
      }
      paramString = paramString;
      throw paramString;
    }
    catch (Exception paramString)
    {
      Logger.log(6, "NtlmV2", "generateType3MsgV2 error: " + Log.getStackTraceString(paramString));
      return "";
    }
  }
  
  protected void init0()
  {
    this.type1 = new byte[256];
    byte[] arrayOfByte = this.type1;
    System.arraycopy(new byte[] { 78, 84, 76, 77, 83, 83, 80, 0, 1 }, 0, arrayOfByte, 0, 9);
    this.type1[12] = 3;
    this.type1[13] = -78;
    this.type1[14] = 8;
    this.type1[28] = 32;
    this.md4 = new MD4();
  }
  
  class Type2Message
  {
    byte[] challenge;
    byte[] context;
    long flags;
    String target;
    byte[] targetInformation;
    
    Type2Message(byte[] paramArrayOfByte)
      throws IOException
    {
      parse(paramArrayOfByte);
    }
    
    private byte[] getTargetInformation()
    {
      return this.targetInformation;
    }
    
    public byte[] getChallenge()
    {
      return this.challenge;
    }
    
    public long getFlags()
    {
      return this.flags;
    }
    
    void parse(byte[] paramArrayOfByte)
      throws IOException
    {
      int i = 0;
      while (i < 8)
      {
        if (paramArrayOfByte[i] != NtlmV2.NTLMSSP_SIGNATURE[i]) {
          throw new IOException("Not an NTLMSSP message.");
        }
        i += 1;
      }
      if (NtlmV2.readULong(paramArrayOfByte, 8) != 2) {
        throw new IOException("Not a Type 2 message.");
      }
      i = NtlmV2.readULong(paramArrayOfByte, 20);
      setFlags(i);
      Object localObject = null;
      byte[] arrayOfByte = NtlmV2.readSecurityBuffer(paramArrayOfByte, 12);
      label119:
      int j;
      if (arrayOfByte.length != 0)
      {
        if ((NtlmFlag.NTLMSSP_NEGOTIATE_UNICODE & i) != 0)
        {
          localObject = "UTF-16LE";
          localObject = new String(arrayOfByte, (String)localObject);
        }
      }
      else
      {
        setTarget((String)localObject);
        i = 24;
        if (i < 32)
        {
          if (paramArrayOfByte[i] == 0) {
            break label251;
          }
          localObject = new byte[8];
          System.arraycopy(paramArrayOfByte, 24, localObject, 0, 8);
          setChallenge((byte[])localObject);
        }
        j = NtlmV2.readULong(paramArrayOfByte, 16);
        if ((j != 32) && (paramArrayOfByte.length != 32)) {
          i = 32;
        }
      }
      for (;;)
      {
        if (i < 40)
        {
          if (paramArrayOfByte[i] != 0)
          {
            localObject = new byte[8];
            System.arraycopy(paramArrayOfByte, 32, localObject, 0, 8);
            setContext((byte[])localObject);
          }
        }
        else
        {
          if ((j != 40) && (paramArrayOfByte.length != 40))
          {
            paramArrayOfByte = NtlmV2.readSecurityBuffer(paramArrayOfByte, 40);
            if (paramArrayOfByte.length != 0) {
              setTargetInformation(paramArrayOfByte);
            }
          }
          return;
          localObject = NtlmV2.DEFAULT_OEM_ENCODING;
          break;
          label251:
          i += 1;
          break label119;
        }
        i += 1;
      }
    }
    
    void setChallenge(byte[] paramArrayOfByte)
    {
      this.challenge = paramArrayOfByte;
    }
    
    void setContext(byte[] paramArrayOfByte)
    {
      this.context = paramArrayOfByte;
    }
    
    void setFlags(int paramInt)
    {
      this.flags = paramInt;
    }
    
    void setTarget(String paramString)
    {
      this.target = paramString;
    }
    
    void setTargetInformation(byte[] paramArrayOfByte)
    {
      this.targetInformation = paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.auth.NtlmV2
 * JD-Core Version:    0.7.0.1
 */