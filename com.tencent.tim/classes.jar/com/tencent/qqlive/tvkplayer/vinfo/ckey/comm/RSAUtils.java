package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public final class RSAUtils
{
  private static String RSA = "RSA";
  
  public static byte[] decryptData(byte[] paramArrayOfByte, PrivateKey paramPrivateKey)
  {
    try
    {
      Cipher localCipher = Cipher.getInstance(RSA);
      localCipher.init(2, paramPrivateKey);
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public static byte[] decryptData_pub(byte[] paramArrayOfByte, PublicKey paramPublicKey)
  {
    try
    {
      Cipher localCipher = Cipher.getInstance("RSA/NONE/PKCS1Padding");
      localCipher.init(2, paramPublicKey);
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public static byte[] encryptData(byte[] paramArrayOfByte, PublicKey paramPublicKey)
  {
    try
    {
      Cipher localCipher = Cipher.getInstance(RSA);
      localCipher.init(1, paramPublicKey);
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static byte[] encryptData_pri(byte[] paramArrayOfByte, PrivateKey paramPrivateKey)
  {
    try
    {
      Cipher localCipher = Cipher.getInstance("RSA/NONE/PKCS1Padding");
      localCipher.init(1, paramPrivateKey);
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static KeyPair generateRSAKeyPair()
  {
    return generateRSAKeyPair(1024);
  }
  
  public static KeyPair generateRSAKeyPair(int paramInt)
  {
    try
    {
      Object localObject = KeyPairGenerator.getInstance(RSA);
      ((KeyPairGenerator)localObject).initialize(paramInt);
      localObject = ((KeyPairGenerator)localObject).genKeyPair();
      return localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
    }
    return null;
  }
  
  public static String getNewVid(String paramString)
  {
    try
    {
      paramString = paramString + "magicCC";
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes());
      for (paramString = new BigInteger(1, localMessageDigest.digest()).toString(16).toLowerCase(); paramString.length() < 32; paramString = "0" + paramString) {}
      paramString = paramString.substring(0, 12);
      return paramString;
    }
    catch (Throwable paramString) {}
    return "";
  }
  
  public static PrivateKey getPrivateKey(String paramString1, String paramString2)
    throws NoSuchAlgorithmException, InvalidKeySpecException
  {
    paramString1 = new RSAPublicKeySpec(new BigInteger(paramString1), new BigInteger(paramString2));
    return KeyFactory.getInstance(RSA).generatePrivate(paramString1);
  }
  
  public static PrivateKey getPrivateKey(byte[] paramArrayOfByte)
    throws NoSuchAlgorithmException, InvalidKeySpecException
  {
    paramArrayOfByte = new PKCS8EncodedKeySpec(paramArrayOfByte);
    return KeyFactory.getInstance(RSA).generatePrivate(paramArrayOfByte);
  }
  
  public static PublicKey getPublicKey(String paramString1, String paramString2)
    throws NoSuchAlgorithmException, InvalidKeySpecException
  {
    paramString1 = new RSAPublicKeySpec(new BigInteger(paramString1), new BigInteger(paramString2));
    return KeyFactory.getInstance(RSA).generatePublic(paramString1);
  }
  
  public static PublicKey getPublicKey(byte[] paramArrayOfByte)
    throws NoSuchAlgorithmException, InvalidKeySpecException
  {
    paramArrayOfByte = new X509EncodedKeySpec(paramArrayOfByte);
    return KeyFactory.getInstance(RSA).generatePublic(paramArrayOfByte);
  }
  
  public static PrivateKey loadPrivateKey(InputStream paramInputStream)
    throws Exception
  {
    try
    {
      paramInputStream = loadPrivateKey(readKey(paramInputStream));
      return paramInputStream;
    }
    catch (IOException paramInputStream)
    {
      throw new Exception("私钥数据读取错误");
    }
    catch (NullPointerException paramInputStream)
    {
      throw new Exception("私钥输入流为空");
    }
  }
  
  public static PrivateKey loadPrivateKey(String paramString)
    throws Exception
  {
    try
    {
      paramString = new PKCS8EncodedKeySpec(Base64Utils.decode(paramString));
      paramString = (RSAPrivateKey)KeyFactory.getInstance(RSA).generatePrivate(paramString);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new Exception("无此算法");
    }
    catch (InvalidKeySpecException paramString)
    {
      throw new Exception("私钥非法");
    }
    catch (NullPointerException paramString)
    {
      throw new Exception("私钥数据为空");
    }
  }
  
  public static PublicKey loadPublicKey(InputStream paramInputStream)
    throws Exception
  {
    try
    {
      paramInputStream = loadPublicKey(readKey(paramInputStream));
      return paramInputStream;
    }
    catch (IOException paramInputStream)
    {
      throw new Exception("公钥数据流读取错误");
    }
    catch (NullPointerException paramInputStream)
    {
      throw new Exception("公钥输入流为空");
    }
  }
  
  public static PublicKey loadPublicKey(String paramString)
    throws Exception
  {
    try
    {
      paramString = Base64Utils.decode(paramString);
      paramString = (RSAPublicKey)KeyFactory.getInstance(RSA).generatePublic(new X509EncodedKeySpec(paramString));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new Exception("无此算法");
    }
    catch (InvalidKeySpecException paramString)
    {
      throw new Exception("公钥非法");
    }
    catch (NullPointerException paramString)
    {
      throw new Exception("公钥数据为空");
    }
  }
  
  public static void printPrivateKeyInfo(PrivateKey paramPrivateKey)
  {
    paramPrivateKey = (RSAPrivateKey)paramPrivateKey;
    System.out.println("----------RSAPrivateKey ----------");
    System.out.println("Modulus.length=" + paramPrivateKey.getModulus().bitLength());
    System.out.println("Modulus=" + paramPrivateKey.getModulus().toString());
    System.out.println("PrivateExponent.length=" + paramPrivateKey.getPrivateExponent().bitLength());
    System.out.println("PrivatecExponent=" + paramPrivateKey.getPrivateExponent().toString());
  }
  
  public static void printPublicKeyInfo(PublicKey paramPublicKey)
  {
    paramPublicKey = (RSAPublicKey)paramPublicKey;
    System.out.println("----------RSAPublicKey----------");
    System.out.println("Modulus.length=" + paramPublicKey.getModulus().bitLength());
    System.out.println("Modulus=" + paramPublicKey.getModulus().toString());
    System.out.println("PublicExponent.length=" + paramPublicKey.getPublicExponent().bitLength());
    System.out.println("PublicExponent=" + paramPublicKey.getPublicExponent().toString());
  }
  
  private static String readKey(InputStream paramInputStream)
    throws IOException
  {
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      String str = paramInputStream.readLine();
      if (str == null) {
        break;
      }
      if (str.charAt(0) != '-')
      {
        localStringBuilder.append(str);
        localStringBuilder.append('\r');
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.RSAUtils
 * JD-Core Version:    0.7.0.1
 */