package com.tencent.moai.mailsdk.protocol.auth;

import com.tencent.moai.mailsdk.util.ASCIIUtility;
import com.tencent.moai.mailsdk.util.stream.BASE64DecoderStream;
import com.tencent.moai.mailsdk.util.stream.BASE64EncoderStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StreamTokenizer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class DigestMD5
{
  private static char[] digits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private String clientResponse;
  private MessageDigest md5;
  private String uri;
  
  private static String toHex(byte[] paramArrayOfByte)
  {
    int j = 0;
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int k = paramArrayOfByte[i] & 0xFF;
      int m = j + 1;
      arrayOfChar[j] = digits[(k >> 4)];
      j = m + 1;
      arrayOfChar[m] = digits[(k & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  private Map<String, String> tokenize(String paramString)
    throws IOException
  {
    HashMap localHashMap = new HashMap();
    paramString = paramString.getBytes("iso-8859-1");
    StreamTokenizer localStreamTokenizer = new StreamTokenizer(new InputStreamReader(new BASE64DecoderStream(new ByteArrayInputStream(paramString, 4, paramString.length - 4)), "iso-8859-1"));
    localStreamTokenizer.ordinaryChars(48, 57);
    localStreamTokenizer.wordChars(48, 57);
    paramString = null;
    for (;;)
    {
      int i = localStreamTokenizer.nextToken();
      if (i == -1) {
        return localHashMap;
      }
      switch (i)
      {
      default: 
        break;
      case -3: 
        if (paramString != null) {
          break label128;
        }
        paramString = localStreamTokenizer.sval;
      }
    }
    label128:
    if (localHashMap.containsKey(paramString)) {
      localHashMap.put(paramString, (String)localHashMap.get(paramString) + "," + localStreamTokenizer.sval);
    }
    for (;;)
    {
      paramString = null;
      break;
      localHashMap.put(paramString, localStreamTokenizer.sval);
    }
    return localHashMap;
  }
  
  public byte[] authClient(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    BASE64EncoderStream localBASE64EncoderStream = new BASE64EncoderStream(localByteArrayOutputStream, 2147483647);
    for (;;)
    {
      try
      {
        SecureRandom localSecureRandom = new SecureRandom();
        this.md5 = MessageDigest.getInstance("MD5");
        StringBuffer localStringBuffer = new StringBuffer();
        this.uri = ("smtp/" + paramString1);
        byte[] arrayOfByte = new byte[32];
        paramString5 = tokenize(paramString5);
        if (paramString4 == null)
        {
          paramString4 = (String)paramString5.get("realm");
          if (paramString4 != null) {
            paramString1 = new StringTokenizer(paramString4, ",").nextToken();
          }
          paramString4 = (String)paramString5.get("nonce");
          localSecureRandom.nextBytes(arrayOfByte);
          localBASE64EncoderStream.write(arrayOfByte);
          localBASE64EncoderStream.flush();
          paramString5 = localByteArrayOutputStream.toString("iso-8859-1");
          localByteArrayOutputStream.reset();
          this.md5.update(this.md5.digest(ASCIIUtility.getBytes(paramString2 + ":" + paramString1 + ":" + paramString3)));
          this.md5.update(ASCIIUtility.getBytes(":" + paramString4 + ":" + paramString5));
          this.clientResponse = (toHex(this.md5.digest()) + ":" + paramString4 + ":" + "00000001" + ":" + paramString5 + ":" + "auth" + ":");
          this.md5.update(ASCIIUtility.getBytes("AUTHENTICATE:" + this.uri));
          this.md5.update(ASCIIUtility.getBytes(this.clientResponse + toHex(this.md5.digest())));
          localStringBuffer.append("username=\"" + paramString2 + "\"");
          localStringBuffer.append(",realm=\"" + paramString1 + "\"");
          localStringBuffer.append(",qop=" + "auth");
          localStringBuffer.append(",nc=" + "00000001");
          localStringBuffer.append(",nonce=\"" + paramString4 + "\"");
          localStringBuffer.append(",cnonce=\"" + paramString5 + "\"");
          localStringBuffer.append(",digest-uri=\"" + this.uri + "\"");
          localStringBuffer.append(",response=" + toHex(this.md5.digest()));
          localBASE64EncoderStream.write(ASCIIUtility.getBytes(localStringBuffer.toString()));
          localBASE64EncoderStream.flush();
          return localByteArrayOutputStream.toByteArray();
        }
      }
      catch (NoSuchAlgorithmException paramString1)
      {
        throw new IOException(paramString1.toString());
      }
      paramString1 = paramString4;
    }
  }
  
  public boolean authServer(String paramString)
    throws IOException
  {
    paramString = tokenize(paramString);
    this.md5.update(ASCIIUtility.getBytes(":" + this.uri));
    this.md5.update(ASCIIUtility.getBytes(this.clientResponse + toHex(this.md5.digest())));
    return toHex(this.md5.digest()).equals(paramString.get("rspauth"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.auth.DigestMD5
 * JD-Core Version:    0.7.0.1
 */