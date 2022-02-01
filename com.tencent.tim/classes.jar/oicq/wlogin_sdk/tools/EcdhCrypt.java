package oicq.wlogin_sdk.tools;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.KeyAgreement;
import oicq.wlogin_sdk.report.Reporter;
import oicq.wlogin_sdk.request.u;

public class EcdhCrypt
{
  public static final String DEFAULT_PUB_KEY = "04edb8906046f5bfbe9abbc5a88b37d70a6006bfbabc1f0cd49dfb33505e63efc5d78ee4e0a4595033b93d02096dcd3190279211f7b4f6785079e19004aa0e03bc";
  public static final String DEFAULT_SHARE_KEY = "c129edba736f4909ecc4ab8e010f46a3";
  static String SvrPubKey;
  static final String X509Prefix = "3059301306072a8648ce3d020106082a8648ce3d030107034200";
  public static byte[] _c_pri_key = new byte[0];
  public static byte[] _c_pub_key;
  private static byte[] _g_share_key = new byte[0];
  private static boolean initFlg = false;
  public static PrivateKey pkcs8PrivateKey;
  private static int sKeyVersion = 1;
  private static boolean userOpenSSLLib;
  public static PublicKey x509PublicKey;
  
  static
  {
    SvrPubKey = "04EBCA94D733E399B2DB96EACDD3F69A8BB0F74224E2B44E3357812211D2E62EFBC91BB553098E25E33A799ADC7F76FEB208DA7C6522CDB0719A305180CC54A82E";
    userOpenSSLLib = true;
    _c_pub_key = new byte[0];
  }
  
  public EcdhCrypt(Context paramContext)
  {
    util.loadLibrary("wtecdh", paramContext);
  }
  
  private byte[] calShareKeyByBouncycastle(byte[] paramArrayOfByte)
  {
    try
    {
      Object localObject1 = util.buf_to_string(paramArrayOfByte);
      localObject1 = constructX509PublicKey("3059301306072a8648ce3d020106082a8648ce3d030107034200" + (String)localObject1);
      Object localObject2 = KeyAgreement.getInstance("ECDH", "BC");
      ((KeyAgreement)localObject2).init(pkcs8PrivateKey);
      ((KeyAgreement)localObject2).doPhase((Key)localObject1, true);
      localObject1 = ((KeyAgreement)localObject2).generateSecret();
      localObject2 = new byte[16];
      System.arraycopy(localObject1, 0, localObject2, 0, 16);
      localObject1 = MD5.toMD5Byte((byte[])localObject2);
      return localObject1;
    }
    catch (ExceptionInInitializerError paramArrayOfByte)
    {
      util.LOGW("create key failed ExceptionInInitializerError, " + paramArrayOfByte.getMessage(), "");
      u.at.attr_api(2459818);
      return null;
    }
    catch (Throwable localThrowable)
    {
      util.LOGI("calShareKeyByBouncycastle failed " + pkcs8PrivateKey.toString() + " peer public key " + util.buf_to_string(paramArrayOfByte), "");
      util.printThrowable(localThrowable, "calShareKeyByBouncycastle");
      u.at.attr_api(2459818);
    }
    return null;
  }
  
  private byte[] calShareKeyByOpenSSL(String paramString1, String paramString2, String paramString3)
  {
    util.LOGI("calShareKeyByOpenSSL publickey " + paramString2, "");
    if (GenECDHKeyEx(paramString3, paramString2, paramString1) == 0) {
      return _g_share_key;
    }
    u.at.attr_api(2461268);
    return null;
  }
  
  private PublicKey constructX509PublicKey(String paramString)
  {
    util.LOGI("constructX509PublicKey publickey " + paramString + " at " + u.m(), "");
    return KeyFactory.getInstance("EC", "BC").generatePublic(new X509EncodedKeySpec(util.string_to_buf(paramString)));
  }
  
  private int initShareKeyByBouncycastle()
  {
    try
    {
      Object localObject1 = util.buf_to_string(util.string_to_buf(SvrPubKey));
      Object localObject3 = "3059301306072a8648ce3d020106082a8648ce3d030107034200" + (String)localObject1;
      localObject1 = KeyPairGenerator.getInstance("EC", "BC");
      ((KeyPairGenerator)localObject1).initialize(new ECGenParameterSpec("prime256v1"));
      Object localObject2 = ((KeyPairGenerator)localObject1).genKeyPair();
      localObject1 = ((KeyPair)localObject2).getPublic();
      byte[] arrayOfByte = ((PublicKey)localObject1).getEncoded();
      localObject2 = ((KeyPair)localObject2).getPrivate();
      ((PrivateKey)localObject2).getEncoded();
      localObject3 = constructX509PublicKey((String)localObject3);
      Object localObject4 = KeyAgreement.getInstance("ECDH", "BC");
      ((KeyAgreement)localObject4).init((Key)localObject2);
      ((KeyAgreement)localObject4).doPhase((Key)localObject3, true);
      localObject3 = ((KeyAgreement)localObject4).generateSecret();
      localObject4 = new byte[16];
      System.arraycopy(localObject3, 0, localObject4, 0, 16);
      _g_share_key = MD5.toMD5Byte((byte[])localObject4);
      _c_pub_key = new byte[65];
      System.arraycopy(arrayOfByte, 26, _c_pub_key, 0, 65);
      x509PublicKey = (PublicKey)localObject1;
      pkcs8PrivateKey = (PrivateKey)localObject2;
      util.LOGI("initShareKeyByBouncycastle OK", "");
      return 0;
    }
    catch (ExceptionInInitializerError localExceptionInInitializerError)
    {
      util.LOGW("create key pair and shared key failed ExceptionInInitializerError, " + localExceptionInInitializerError.getMessage(), "");
      u.at.attr_api(2368735);
      return -1;
    }
    catch (Throwable localThrowable)
    {
      util.LOGI("initShareKeyByBouncycastle failed, ", "");
      util.printThrowable(localThrowable, "initShareKeyByBouncycastle");
      u.at.attr_api(2368735);
    }
    return -2;
  }
  
  private int initShareKeyByOpenSSL()
  {
    if (Build.VERSION.SDK_INT >= 23) {}
    while (GenereateKey() != 0) {
      return -1;
    }
    if ((_c_pub_key == null) || (_c_pub_key.length == 0) || (_c_pri_key == null) || (_c_pri_key.length == 0) || (_g_share_key == null) || (_g_share_key.length == 0))
    {
      util.LOGI("_c_pub_key " + util.buf_to_string(_c_pub_key), "");
      util.LOGI("_c_pri_key " + util.buf_to_string(_c_pri_key), "");
      util.LOGI("_g_share_key " + util.buf_to_string(_g_share_key), "");
      util.LOGI("initShareKeyByOpenSSL generate null key", "");
      return -2;
    }
    util.LOGI("initShareKeyByOpenSSL OK", "");
    return 0;
  }
  
  public native int GenECDHKeyEx(String paramString1, String paramString2, String paramString3);
  
  public int GenereateKey()
  {
    try
    {
      try
      {
        int i = GenECDHKeyEx(SvrPubKey, "", "");
        return i;
      }
      finally {}
      return -4;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      util.LOGI("GenereateKey failed " + localUnsatisfiedLinkError.getMessage(), "");
      return -1;
    }
    catch (RuntimeException localRuntimeException)
    {
      util.LOGW("OpenSSL generate key failed, turn another method " + localRuntimeException.getMessage(), "");
      return -2;
    }
    catch (Exception localException)
    {
      util.LOGI("GenereateKey failed " + localException.getMessage(), "");
      return -3;
    }
    catch (Error localError)
    {
      util.LOGI("GenereateKey failed " + localError.getMessage(), "");
    }
  }
  
  public byte[] calShareKeyMd5ByPeerPublicKey(byte[] paramArrayOfByte)
  {
    util.LOGI("userOpenSSLLib " + userOpenSSLLib + " peerRawPublicKey " + util.buf_to_string(paramArrayOfByte) + " at " + u.m(), "");
    if (true == userOpenSSLLib) {
      return calShareKeyByOpenSSL(util.buf_to_string(_c_pri_key), util.buf_to_string(_c_pub_key), util.buf_to_string(paramArrayOfByte));
    }
    return calShareKeyByBouncycastle(paramArrayOfByte);
  }
  
  public byte[] get_c_pub_key()
  {
    return (byte[])_c_pub_key.clone();
  }
  
  public byte[] get_g_share_key()
  {
    return (byte[])_g_share_key.clone();
  }
  
  public int get_pub_key_ver()
  {
    return sKeyVersion;
  }
  
  public int initShareKey()
  {
    if (true == initFlg) {
      return 0;
    }
    initFlg = true;
    if (initShareKeyByOpenSSL() == 0)
    {
      userOpenSSLLib = true;
      return 0;
    }
    if (initShareKeyByBouncycastle() == 0)
    {
      userOpenSSLLib = false;
      return 0;
    }
    return initShareKeyByDefault();
  }
  
  public int initShareKeyByDefault()
  {
    _c_pub_key = util.string_to_buf("04edb8906046f5bfbe9abbc5a88b37d70a6006bfbabc1f0cd49dfb33505e63efc5d78ee4e0a4595033b93d02096dcd3190279211f7b4f6785079e19004aa0e03bc");
    _g_share_key = util.string_to_buf("c129edba736f4909ecc4ab8e010f46a3");
    util.LOGI("initShareKeyByDefault OK", "");
    return 0;
  }
  
  public void setPubKey(String paramString, int paramInt)
  {
    try
    {
      util.LOGI("setPubKey " + paramString + " ver:" + paramInt, "");
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramInt <= 0) {
          return;
        }
        SvrPubKey = paramString;
        sKeyVersion = paramInt;
        return;
      }
    }
    catch (Throwable paramString)
    {
      util.printThrowable(paramString, "setPubKey");
    }
  }
  
  public void set_c_pri_key(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      _c_pri_key = (byte[])paramArrayOfByte.clone();
      return;
    }
    _c_pri_key = new byte[0];
  }
  
  public void set_c_pub_key(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      _c_pub_key = (byte[])paramArrayOfByte.clone();
      return;
    }
    _c_pub_key = new byte[0];
  }
  
  public void set_g_share_key(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      _g_share_key = (byte[])paramArrayOfByte.clone();
      return;
    }
    _g_share_key = new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.EcdhCrypt
 * JD-Core Version:    0.7.0.1
 */