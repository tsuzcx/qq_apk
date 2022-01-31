package com.tencent.i18n.protocal.util;

import java.io.PrintStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSAEncrypt
{
  private static final String jdField_a_of_type_JavaLangString = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCx6BNoEAvdQtJp4DVoHZXjqtpd\r4oqVMG5nJXzp0v8DBshM9GVYV1udEs28fJ4w1W+X/3ZUenot/0p9Hst/mbg7wLDJ\r1qMPH/b4CfdYCrqDfdAczjN2XarrRPF1BrFpCX0H5JlrsehKhZGhSPc6HinnS89n\rdD77Dtnj2jYgxjjr/QIDAQAB\r";
  private static final char[] jdField_a_of_type_ArrayOfChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final String b = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAKEPNyPD+taAXCfG\r";
  private RSAPrivateKey jdField_a_of_type_JavaSecurityInterfacesRSAPrivateKey;
  private RSAPublicKey jdField_a_of_type_JavaSecurityInterfacesRSAPublicKey;
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(jdField_a_of_type_ArrayOfChar[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(jdField_a_of_type_ArrayOfChar[(paramArrayOfByte[i] & 0xF)]);
      if (i < paramArrayOfByte.length - 1) {
        localStringBuilder.append(' ');
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static void a(String[] paramArrayOfString)
  {
    Object localObject = new RSAEncrypt();
    ((RSAEncrypt)localObject).a();
    try
    {
      paramArrayOfString = ((RSAEncrypt)localObject).a(((RSAEncrypt)localObject).a(), "Test String".getBytes());
      localObject = ((RSAEncrypt)localObject).a(((RSAEncrypt)localObject).a(), paramArrayOfString);
      System.out.println("密文长度:" + paramArrayOfString.length);
      System.out.println(a(paramArrayOfString));
      System.out.println("明文长度:" + localObject.length);
      System.out.println(a((byte[])localObject));
      System.out.println(new String((byte[])localObject));
      return;
    }
    catch (Exception paramArrayOfString)
    {
      System.err.println(paramArrayOfString.getMessage());
    }
  }
  
  public RSAPrivateKey a()
  {
    return this.jdField_a_of_type_JavaSecurityInterfacesRSAPrivateKey;
  }
  
  public RSAPublicKey a()
  {
    if (this.jdField_a_of_type_JavaSecurityInterfacesRSAPublicKey == null) {}
    try
    {
      a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCx6BNoEAvdQtJp4DVoHZXjqtpd\r4oqVMG5nJXzp0v8DBshM9GVYV1udEs28fJ4w1W+X/3ZUenot/0p9Hst/mbg7wLDJ\r1qMPH/b4CfdYCrqDfdAczjN2XarrRPF1BrFpCX0H5JlrsehKhZGhSPc6HinnS89n\rdD77Dtnj2jYgxjjr/QIDAQAB\r");
      return this.jdField_a_of_type_JavaSecurityInterfacesRSAPublicKey;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        System.err.println(localException.getMessage());
      }
    }
  }
  
  public void a()
  {
    Object localObject = null;
    try
    {
      KeyPairGenerator localKeyPairGenerator = KeyPairGenerator.getInstance("RSA");
      localObject = localKeyPairGenerator;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      for (;;)
      {
        localNoSuchAlgorithmException.printStackTrace();
      }
    }
    ((KeyPairGenerator)localObject).initialize(1024, new SecureRandom());
    localObject = ((KeyPairGenerator)localObject).generateKeyPair();
    this.jdField_a_of_type_JavaSecurityInterfacesRSAPrivateKey = ((RSAPrivateKey)((KeyPair)localObject).getPrivate());
    this.jdField_a_of_type_JavaSecurityInterfacesRSAPublicKey = ((RSAPublicKey)((KeyPair)localObject).getPublic());
  }
  
  /* Error */
  public void a(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 160	java/io/BufferedReader
    //   3: dup
    //   4: new 162	java/io/InputStreamReader
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 164	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   12: invokespecial 167	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   15: astore_1
    //   16: new 41	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   23: astore_2
    //   24: aload_1
    //   25: invokevirtual 170	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull +40 -> 70
    //   33: aload_3
    //   34: iconst_0
    //   35: invokevirtual 174	java/lang/String:charAt	(I)C
    //   38: bipush 45
    //   40: if_icmpeq -16 -> 24
    //   43: aload_2
    //   44: aload_3
    //   45: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_2
    //   50: bipush 13
    //   52: invokevirtual 46	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: goto -32 -> 24
    //   59: astore_1
    //   60: new 53	java/lang/Exception
    //   63: dup
    //   64: ldc 176
    //   66: invokespecial 178	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   69: athrow
    //   70: aload_0
    //   71: aload_2
    //   72: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokevirtual 115	com/tencent/i18n/protocal/util/RSAEncrypt:a	(Ljava/lang/String;)V
    //   78: return
    //   79: astore_1
    //   80: new 53	java/lang/Exception
    //   83: dup
    //   84: ldc 180
    //   86: invokespecial 178	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	RSAEncrypt
    //   0	90	1	paramInputStream	java.io.InputStream
    //   23	49	2	localStringBuilder	StringBuilder
    //   28	17	3	str	String
    // Exception table:
    //   from	to	target	type
    //   0	24	59	java/io/IOException
    //   24	29	59	java/io/IOException
    //   33	56	59	java/io/IOException
    //   70	78	59	java/io/IOException
    //   0	24	79	java/lang/NullPointerException
    //   24	29	79	java/lang/NullPointerException
    //   33	56	79	java/lang/NullPointerException
    //   70	78	79	java/lang/NullPointerException
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = new BigInteger("B1E81368100BDD42D269E035681D95E3AADA5DE28A95306E67257CE9D2FF0306C84CF46558575B9D12CDBC7C9E30D56F97FF76547A7A2DFF4A7D1ECB7F99B83BC0B0C9D6A30F1FF6F809F7580ABA837DD01CCE33765DAAEB44F17506B169097D07E4996BB1E84A8591A148F73A1E29E74BCF67743EFB0ED9E3DA3620C638EBFD", 16);
      BigInteger localBigInteger = new BigInteger("010001", 16);
      this.jdField_a_of_type_JavaSecurityInterfacesRSAPublicKey = ((RSAPublicKey)KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(paramString, localBigInteger)));
      return;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new Exception("无此算法");
    }
    catch (InvalidKeySpecException paramString)
    {
      throw new Exception("公钥非法");
    }
  }
  
  public byte[] a(RSAPrivateKey paramRSAPrivateKey, byte[] paramArrayOfByte)
  {
    if (paramRSAPrivateKey == null) {
      throw new Exception("解密私钥为空, 请设置");
    }
    try
    {
      Cipher localCipher = Cipher.getInstance("RSA");
      localCipher.init(2, paramRSAPrivateKey);
      paramRSAPrivateKey = localCipher.doFinal(paramArrayOfByte);
      return paramRSAPrivateKey;
    }
    catch (NoSuchAlgorithmException paramRSAPrivateKey)
    {
      throw new Exception("无此解密算法");
    }
    catch (NoSuchPaddingException paramRSAPrivateKey)
    {
      paramRSAPrivateKey.printStackTrace();
      return null;
    }
    catch (InvalidKeyException paramRSAPrivateKey)
    {
      throw new Exception("解密私钥非法,请检查");
    }
    catch (IllegalBlockSizeException paramRSAPrivateKey)
    {
      throw new Exception("密文长度非法");
    }
    catch (BadPaddingException paramRSAPrivateKey)
    {
      throw new Exception("密文数据已损坏");
    }
  }
  
  public byte[] a(RSAPublicKey paramRSAPublicKey, byte[] paramArrayOfByte)
  {
    if (paramRSAPublicKey == null) {
      throw new Exception("加密公钥为空, 请设置");
    }
    try
    {
      Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      localCipher.init(1, paramRSAPublicKey);
      paramRSAPublicKey = localCipher.doFinal(paramArrayOfByte);
      return paramRSAPublicKey;
    }
    catch (NoSuchAlgorithmException paramRSAPublicKey)
    {
      throw new Exception("无此加密算法");
    }
    catch (InvalidKeyException paramRSAPublicKey)
    {
      throw new Exception("加密公钥非法,请检查");
    }
    catch (IllegalBlockSizeException paramRSAPublicKey)
    {
      throw new Exception("明文长度非法");
    }
    catch (BadPaddingException paramRSAPublicKey)
    {
      throw new Exception("明文数据已损坏");
    }
  }
  
  /* Error */
  public void b(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 160	java/io/BufferedReader
    //   3: dup
    //   4: new 162	java/io/InputStreamReader
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 164	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   12: invokespecial 167	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   15: astore_1
    //   16: new 41	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   23: astore_2
    //   24: aload_1
    //   25: invokevirtual 170	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull +40 -> 70
    //   33: aload_3
    //   34: iconst_0
    //   35: invokevirtual 174	java/lang/String:charAt	(I)C
    //   38: bipush 45
    //   40: if_icmpeq -16 -> 24
    //   43: aload_2
    //   44: aload_3
    //   45: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_2
    //   50: bipush 13
    //   52: invokevirtual 46	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: goto -32 -> 24
    //   59: astore_1
    //   60: new 53	java/lang/Exception
    //   63: dup
    //   64: ldc 255
    //   66: invokespecial 178	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   69: athrow
    //   70: aload_0
    //   71: aload_2
    //   72: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokevirtual 257	com/tencent/i18n/protocal/util/RSAEncrypt:b	(Ljava/lang/String;)V
    //   78: return
    //   79: astore_1
    //   80: new 53	java/lang/Exception
    //   83: dup
    //   84: ldc_w 259
    //   87: invokespecial 178	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	RSAEncrypt
    //   0	91	1	paramInputStream	java.io.InputStream
    //   23	49	2	localStringBuilder	StringBuilder
    //   28	17	3	str	String
    // Exception table:
    //   from	to	target	type
    //   0	24	59	java/io/IOException
    //   24	29	59	java/io/IOException
    //   33	56	59	java/io/IOException
    //   70	78	59	java/io/IOException
    //   0	24	79	java/lang/NullPointerException
    //   24	29	79	java/lang/NullPointerException
    //   33	56	79	java/lang/NullPointerException
    //   70	78	79	java/lang/NullPointerException
  }
  
  public void b(String paramString)
  {
    try
    {
      paramString = new PKCS8EncodedKeySpec(Base64.a(paramString, 0));
      this.jdField_a_of_type_JavaSecurityInterfacesRSAPrivateKey = ((RSAPrivateKey)KeyFactory.getInstance("RSA").generatePrivate(paramString));
      return;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new Exception("无此算法");
    }
    catch (InvalidKeySpecException paramString)
    {
      throw new Exception("私钥非法");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.i18n.protocal.util.RSAEncrypt
 * JD-Core Version:    0.7.0.1
 */