package com.tencent.mobileqq.msf.sdk.utils;

import android.content.Context;
import android.os.Build.VERSION;
import android.security.KeyPairGeneratorSpec.Builder;
import android.security.keystore.KeyGenParameterSpec.Builder;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStore.Entry;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.security.auth.x500.X500Principal;

public class SignUtils
{
  public static final String KEYSTORE_PROVIDER_ANDROID_KEYSTORE = "AndroidKeyStore";
  public static final String SIGNATURE_SHA256withRSA = "SHA256withRSA";
  public static final String TAG = "SignUtils";
  public static final String TYPE_RSA = "RSA";
  
  private static void createKeys(Context paramContext, String paramString)
    throws NoSuchProviderException, NoSuchAlgorithmException, InvalidAlgorithmParameterException
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
      GregorianCalendar localGregorianCalendar2 = new GregorianCalendar();
      localGregorianCalendar2.add(1, 3);
      KeyPairGenerator localKeyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
      Object localObject = null;
      if (Build.VERSION.SDK_INT >= 23) {
        localObject = new KeyGenParameterSpec.Builder(paramString, 4).setCertificateSubject(new X500Principal("CN=" + paramString)).setDigests(new String[] { "SHA-256" }).setSignaturePaddings(new String[] { "PKCS1" }).setCertificateSerialNumber(BigInteger.valueOf(1337L)).setCertificateNotBefore(localGregorianCalendar1.getTime()).setCertificateNotAfter(localGregorianCalendar2.getTime()).build();
      }
      while (localObject != null)
      {
        localKeyPairGenerator.initialize((AlgorithmParameterSpec)localObject);
        localKeyPairGenerator.generateKeyPair();
        return;
        if (Build.VERSION.SDK_INT >= 18) {
          localObject = new KeyPairGeneratorSpec.Builder(paramContext).setAlias(paramString).setSubject(new X500Principal("CN=" + paramString)).setSerialNumber(BigInteger.valueOf(1337L)).setStartDate(localGregorianCalendar1.getTime()).setEndDate(localGregorianCalendar2.getTime()).build();
        }
      }
    }
  }
  
  public static boolean isSupportKeyStore()
  {
    boolean bool = false;
    try
    {
      KeyStore localKeyStore = KeyStore.getInstance("AndroidKeyStore");
      localKeyStore.load(null);
      KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
      Signature.getInstance("SHA256withRSA");
      KeyStore.Entry localEntry2 = localKeyStore.getEntry("test", null);
      KeyStore.Entry localEntry1 = localEntry2;
      if (localEntry2 == null)
      {
        createKeys(BaseApplication.getContext(), "test");
        localEntry1 = localKeyStore.getEntry("test", null);
      }
      if (localEntry1 != null) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  /* Error */
  public static String readFile(java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: ifnonnull +8 -> 15
    //   10: aload 6
    //   12: astore_2
    //   13: aload_2
    //   14: areturn
    //   15: aload 6
    //   17: astore_2
    //   18: aload_0
    //   19: invokevirtual 201	java/io/File:exists	()Z
    //   22: ifeq -9 -> 13
    //   25: aload 6
    //   27: astore_2
    //   28: aload_0
    //   29: invokevirtual 204	java/io/File:isFile	()Z
    //   32: ifeq -19 -> 13
    //   35: new 206	java/io/FileInputStream
    //   38: dup
    //   39: aload_0
    //   40: invokespecial 209	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   43: astore_2
    //   44: new 211	java/io/InputStreamReader
    //   47: dup
    //   48: aload_2
    //   49: ldc 213
    //   51: invokespecial 216	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   54: astore 5
    //   56: aload 5
    //   58: astore 4
    //   60: aload_2
    //   61: astore_3
    //   62: aload_0
    //   63: invokevirtual 220	java/io/File:length	()J
    //   66: l2i
    //   67: istore_1
    //   68: iload_1
    //   69: sipush 12288
    //   72: if_icmple +154 -> 226
    //   75: aload 5
    //   77: astore 4
    //   79: aload_2
    //   80: astore_3
    //   81: sipush 4096
    //   84: newarray char
    //   86: astore_0
    //   87: aload 5
    //   89: astore 4
    //   91: aload_2
    //   92: astore_3
    //   93: new 66	java/lang/StringBuilder
    //   96: dup
    //   97: sipush 12288
    //   100: invokespecial 223	java/lang/StringBuilder:<init>	(I)V
    //   103: astore 8
    //   105: aload 5
    //   107: astore 4
    //   109: aload_2
    //   110: astore_3
    //   111: aload 5
    //   113: aload_0
    //   114: invokevirtual 227	java/io/InputStreamReader:read	([C)I
    //   117: istore_1
    //   118: iconst_m1
    //   119: iload_1
    //   120: if_icmpeq +70 -> 190
    //   123: aload 5
    //   125: astore 4
    //   127: aload_2
    //   128: astore_3
    //   129: aload 8
    //   131: aload_0
    //   132: iconst_0
    //   133: iload_1
    //   134: invokevirtual 230	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: goto -33 -> 105
    //   141: astore_3
    //   142: aload 5
    //   144: astore_0
    //   145: aload_3
    //   146: astore 5
    //   148: aload_0
    //   149: astore 4
    //   151: aload_2
    //   152: astore_3
    //   153: ldc 14
    //   155: iconst_1
    //   156: ldc 232
    //   158: aload 5
    //   160: invokestatic 238	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   163: aload_2
    //   164: ifnull +7 -> 171
    //   167: aload_2
    //   168: invokevirtual 243	java/io/InputStream:close	()V
    //   171: aload 6
    //   173: astore_2
    //   174: aload_0
    //   175: ifnull -162 -> 13
    //   178: aload 7
    //   180: astore_2
    //   181: aload_0
    //   182: invokevirtual 244	java/io/InputStreamReader:close	()V
    //   185: aconst_null
    //   186: areturn
    //   187: astore_0
    //   188: aload_2
    //   189: areturn
    //   190: aload 5
    //   192: astore 4
    //   194: aload_2
    //   195: astore_3
    //   196: aload 8
    //   198: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: astore_0
    //   202: aload_2
    //   203: ifnull +7 -> 210
    //   206: aload_2
    //   207: invokevirtual 243	java/io/InputStream:close	()V
    //   210: aload_0
    //   211: astore_2
    //   212: aload 5
    //   214: ifnull -201 -> 13
    //   217: aload_0
    //   218: astore_2
    //   219: aload 5
    //   221: invokevirtual 244	java/io/InputStreamReader:close	()V
    //   224: aload_0
    //   225: areturn
    //   226: aload 5
    //   228: astore 4
    //   230: aload_2
    //   231: astore_3
    //   232: iload_1
    //   233: newarray char
    //   235: astore_0
    //   236: aload 5
    //   238: astore 4
    //   240: aload_2
    //   241: astore_3
    //   242: new 86	java/lang/String
    //   245: dup
    //   246: aload_0
    //   247: iconst_0
    //   248: aload 5
    //   250: aload_0
    //   251: invokevirtual 227	java/io/InputStreamReader:read	([C)I
    //   254: invokespecial 247	java/lang/String:<init>	([CII)V
    //   257: astore_0
    //   258: goto -56 -> 202
    //   261: astore_0
    //   262: aconst_null
    //   263: astore 4
    //   265: aconst_null
    //   266: astore_2
    //   267: aload_2
    //   268: ifnull +7 -> 275
    //   271: aload_2
    //   272: invokevirtual 243	java/io/InputStream:close	()V
    //   275: aload 4
    //   277: ifnull +8 -> 285
    //   280: aload 4
    //   282: invokevirtual 244	java/io/InputStreamReader:close	()V
    //   285: aload_0
    //   286: athrow
    //   287: astore_2
    //   288: goto -13 -> 275
    //   291: astore_2
    //   292: goto -7 -> 285
    //   295: astore_2
    //   296: goto -125 -> 171
    //   299: astore_2
    //   300: goto -90 -> 210
    //   303: astore_0
    //   304: aconst_null
    //   305: astore 4
    //   307: goto -40 -> 267
    //   310: astore_0
    //   311: aload_3
    //   312: astore_2
    //   313: goto -46 -> 267
    //   316: astore 5
    //   318: aconst_null
    //   319: astore_0
    //   320: aconst_null
    //   321: astore_2
    //   322: goto -174 -> 148
    //   325: astore 5
    //   327: aconst_null
    //   328: astore_0
    //   329: goto -181 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	paramFile	java.io.File
    //   67	166	1	i	int
    //   12	260	2	localObject1	Object
    //   287	1	2	localException1	java.lang.Exception
    //   291	1	2	localException2	java.lang.Exception
    //   295	1	2	localException3	java.lang.Exception
    //   299	1	2	localException4	java.lang.Exception
    //   312	10	2	localObject2	Object
    //   61	68	3	localObject3	Object
    //   141	5	3	localException5	java.lang.Exception
    //   152	160	3	localObject4	Object
    //   58	248	4	localObject5	Object
    //   54	195	5	localObject6	Object
    //   316	1	5	localException6	java.lang.Exception
    //   325	1	5	localException7	java.lang.Exception
    //   4	168	6	localObject7	Object
    //   1	178	7	localObject8	Object
    //   103	94	8	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   62	68	141	java/lang/Exception
    //   81	87	141	java/lang/Exception
    //   93	105	141	java/lang/Exception
    //   111	118	141	java/lang/Exception
    //   129	138	141	java/lang/Exception
    //   196	202	141	java/lang/Exception
    //   232	236	141	java/lang/Exception
    //   242	258	141	java/lang/Exception
    //   181	185	187	java/lang/Exception
    //   219	224	187	java/lang/Exception
    //   35	44	261	finally
    //   271	275	287	java/lang/Exception
    //   280	285	291	java/lang/Exception
    //   167	171	295	java/lang/Exception
    //   206	210	299	java/lang/Exception
    //   44	56	303	finally
    //   62	68	310	finally
    //   81	87	310	finally
    //   93	105	310	finally
    //   111	118	310	finally
    //   129	138	310	finally
    //   153	163	310	finally
    //   196	202	310	finally
    //   232	236	310	finally
    //   242	258	310	finally
    //   35	44	316	java/lang/Exception
    //   44	56	325	java/lang/Exception
  }
  
  public static String signData(Context paramContext, String paramString1, String paramString2)
    throws KeyStoreException, UnrecoverableEntryException, NoSuchAlgorithmException, InvalidKeyException, SignatureException, IOException, CertificateException, NoSuchProviderException, InvalidAlgorithmParameterException
  {
    byte[] arrayOfByte = paramString1.getBytes();
    KeyStore localKeyStore = KeyStore.getInstance("AndroidKeyStore");
    localKeyStore.load(null);
    KeyStore.Entry localEntry = localKeyStore.getEntry(paramString2, null);
    paramString1 = localEntry;
    if (localEntry == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SignUtils", 2, "create new key for:" + paramString2);
      }
      createKeys(paramContext, paramString2);
      paramString1 = localKeyStore.getEntry(paramString2, null);
    }
    if (paramString1 == null)
    {
      QLog.e("SignUtils", 1, "null entry:" + paramString2);
      return null;
    }
    if (!(paramString1 instanceof KeyStore.PrivateKeyEntry))
    {
      QLog.e("SignUtils", 1, "Not an instance of a PrivateKeyEntry:" + paramString2);
      return null;
    }
    paramContext = Signature.getInstance("SHA256withRSA");
    paramContext.initSign(((KeyStore.PrivateKeyEntry)paramString1).getPrivateKey());
    paramContext.update(arrayOfByte);
    return Base64.encodeToString(paramContext.sign(), 0);
  }
  
  public static boolean verifyData(String paramString1, String paramString2, String paramString3)
    throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException, UnrecoverableEntryException, InvalidKeyException, SignatureException
  {
    paramString1 = paramString1.getBytes();
    if (paramString2 == null)
    {
      QLog.e("SignUtils", 1, "Invalid signature:" + paramString3);
      return false;
    }
    Object localObject;
    try
    {
      paramString2 = Base64.decode(paramString2, 0);
      localObject = KeyStore.getInstance("AndroidKeyStore");
      ((KeyStore)localObject).load(null);
      localObject = ((KeyStore)localObject).getEntry(paramString3, null);
      if (localObject == null)
      {
        QLog.e("SignUtils", 1, "No key found under alias:" + paramString3);
        return false;
      }
    }
    catch (IllegalArgumentException paramString1)
    {
      QLog.e("SignUtils", 1, "decode signature error:", paramString1);
      return false;
    }
    if (!(localObject instanceof KeyStore.PrivateKeyEntry))
    {
      QLog.e("SignUtils", 1, "Not an instance of a PrivateKeyEntry:" + paramString3);
      return false;
    }
    paramString3 = Signature.getInstance("SHA256withRSA");
    paramString3.initVerify(((KeyStore.PrivateKeyEntry)localObject).getCertificate());
    paramString3.update(paramString1);
    return paramString3.verify(paramString2);
  }
  
  /* Error */
  public static void writeFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 198	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 332	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: aconst_null
    //   11: astore_2
    //   12: aconst_null
    //   13: astore_3
    //   14: aload_2
    //   15: astore_0
    //   16: aload 4
    //   18: invokevirtual 201	java/io/File:exists	()Z
    //   21: ifne +11 -> 32
    //   24: aload_2
    //   25: astore_0
    //   26: aload 4
    //   28: invokevirtual 335	java/io/File:createNewFile	()Z
    //   31: pop
    //   32: aload_2
    //   33: astore_0
    //   34: new 337	java/io/FileOutputStream
    //   37: dup
    //   38: aload 4
    //   40: iconst_0
    //   41: invokespecial 340	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   44: astore_2
    //   45: aload_2
    //   46: aload_1
    //   47: invokevirtual 265	java/lang/String:getBytes	()[B
    //   50: invokevirtual 343	java/io/FileOutputStream:write	([B)V
    //   53: aload_2
    //   54: invokevirtual 346	java/io/FileOutputStream:flush	()V
    //   57: aload_2
    //   58: ifnull +7 -> 65
    //   61: aload_2
    //   62: invokevirtual 347	java/io/FileOutputStream:close	()V
    //   65: return
    //   66: astore_2
    //   67: aload_3
    //   68: astore_1
    //   69: aload_1
    //   70: astore_0
    //   71: ldc 14
    //   73: iconst_1
    //   74: ldc_w 349
    //   77: aload_2
    //   78: invokestatic 238	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   81: aload_1
    //   82: ifnull -17 -> 65
    //   85: aload_1
    //   86: invokevirtual 347	java/io/FileOutputStream:close	()V
    //   89: return
    //   90: astore_0
    //   91: return
    //   92: astore_2
    //   93: aload_0
    //   94: astore_1
    //   95: aload_2
    //   96: astore_0
    //   97: aload_1
    //   98: ifnull +7 -> 105
    //   101: aload_1
    //   102: invokevirtual 347	java/io/FileOutputStream:close	()V
    //   105: aload_0
    //   106: athrow
    //   107: astore_1
    //   108: goto -3 -> 105
    //   111: astore_0
    //   112: aload_2
    //   113: astore_1
    //   114: goto -17 -> 97
    //   117: astore_0
    //   118: aload_2
    //   119: astore_1
    //   120: aload_0
    //   121: astore_2
    //   122: goto -53 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	paramString1	String
    //   0	125	1	paramString2	String
    //   11	51	2	localFileOutputStream	java.io.FileOutputStream
    //   66	12	2	localException	java.lang.Exception
    //   92	27	2	localObject1	Object
    //   121	1	2	str	String
    //   13	55	3	localObject2	Object
    //   8	31	4	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   16	24	66	java/lang/Exception
    //   26	32	66	java/lang/Exception
    //   34	45	66	java/lang/Exception
    //   61	65	90	java/lang/Exception
    //   85	89	90	java/lang/Exception
    //   16	24	92	finally
    //   26	32	92	finally
    //   34	45	92	finally
    //   71	81	92	finally
    //   101	105	107	java/lang/Exception
    //   45	57	111	finally
    //   45	57	117	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.SignUtils
 * JD-Core Version:    0.7.0.1
 */