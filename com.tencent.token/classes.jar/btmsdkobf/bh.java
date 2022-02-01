package btmsdkobf;

import com.tmsdk.base.AbsTMSBaseConfig;
import java.security.GeneralSecurityException;
import java.security.interfaces.RSAPublicKey;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;

public class bh
{
  private static volatile bh fM;
  private bf fN;
  private Calendar fO = Calendar.getInstance();
  private bg fP;
  
  private bh()
  {
    if (bc.o().isCheckLicence()) {
      C();
    }
  }
  
  public static bh B()
  {
    try
    {
      if (fM == null) {
        fM = new bh();
      }
      bh localbh = fM;
      return localbh;
    }
    finally {}
  }
  
  /* Error */
  private void C()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: iload_1
    //   4: invokespecial 56	btmsdkobf/bh:h	(I)[B
    //   7: astore 4
    //   9: aload 4
    //   11: ifnull +189 -> 200
    //   14: invokestatic 60	btmsdkobf/bh:E	()Ljava/security/interfaces/RSAPublicKey;
    //   17: astore 5
    //   19: sipush 128
    //   22: newarray byte
    //   24: astore 6
    //   26: aload 4
    //   28: iconst_0
    //   29: aload 6
    //   31: iconst_0
    //   32: aload 6
    //   34: arraylength
    //   35: invokestatic 66	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   38: aconst_null
    //   39: astore_3
    //   40: aload_3
    //   41: astore_2
    //   42: aload 5
    //   44: ifnull +23 -> 67
    //   47: ldc 68
    //   49: invokestatic 73	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   52: astore_2
    //   53: aload_2
    //   54: iconst_2
    //   55: aload 5
    //   57: invokevirtual 77	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   60: aload_2
    //   61: aload 6
    //   63: invokevirtual 81	javax/crypto/Cipher:doFinal	([B)[B
    //   66: astore_2
    //   67: aload_2
    //   68: ifnull +122 -> 190
    //   71: aload 4
    //   73: arraylength
    //   74: sipush 128
    //   77: isub
    //   78: newarray byte
    //   80: astore_3
    //   81: aload 4
    //   83: sipush 128
    //   86: aload_3
    //   87: iconst_0
    //   88: aload_3
    //   89: arraylength
    //   90: invokestatic 66	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   93: aload_3
    //   94: aload_2
    //   95: invokestatic 85	btmsdkobf/bh:a	([B[B)[B
    //   98: astore_2
    //   99: aload_2
    //   100: ifnonnull +4 -> 104
    //   103: return
    //   104: new 87	java/io/ByteArrayInputStream
    //   107: dup
    //   108: aload_2
    //   109: invokespecial 90	java/io/ByteArrayInputStream:<init>	([B)V
    //   112: astore_2
    //   113: new 92	java/util/Properties
    //   116: dup
    //   117: invokespecial 93	java/util/Properties:<init>	()V
    //   120: astore_3
    //   121: aload_3
    //   122: aload_2
    //   123: invokevirtual 97	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   126: aload_2
    //   127: invokevirtual 100	java/io/ByteArrayInputStream:close	()V
    //   130: goto +13 -> 143
    //   133: goto +10 -> 143
    //   136: astore_3
    //   137: aload_2
    //   138: invokevirtual 100	java/io/ByteArrayInputStream:close	()V
    //   141: aload_3
    //   142: athrow
    //   143: aload_0
    //   144: new 102	btmsdkobf/bg
    //   147: dup
    //   148: aload_3
    //   149: invokestatic 106	btmsdkobf/bc:n	()Landroid/content/Context;
    //   152: invokespecial 109	btmsdkobf/bg:<init>	(Ljava/util/Properties;Landroid/content/Context;)V
    //   155: putfield 111	btmsdkobf/bh:fP	Lbtmsdkobf/bg;
    //   158: aload_0
    //   159: getfield 111	btmsdkobf/bh:fP	Lbtmsdkobf/bg;
    //   162: invokevirtual 114	btmsdkobf/bg:z	()Z
    //   165: ifeq +18 -> 183
    //   168: aload_0
    //   169: invokespecial 117	btmsdkobf/bh:D	()V
    //   172: aload_0
    //   173: getfield 26	btmsdkobf/bh:fO	Ljava/util/Calendar;
    //   176: invokestatic 121	java/lang/System:currentTimeMillis	()J
    //   179: invokevirtual 125	java/util/Calendar:setTimeInMillis	(J)V
    //   182: return
    //   183: iload_1
    //   184: iconst_1
    //   185: iadd
    //   186: istore_1
    //   187: goto -185 -> 2
    //   190: new 48	java/lang/RuntimeException
    //   193: dup
    //   194: ldc 127
    //   196: invokespecial 130	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   199: athrow
    //   200: new 48	java/lang/RuntimeException
    //   203: dup
    //   204: ldc 132
    //   206: invokespecial 130	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   209: athrow
    //   210: new 48	java/lang/RuntimeException
    //   213: dup
    //   214: ldc 134
    //   216: invokespecial 130	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   219: athrow
    //   220: astore_2
    //   221: goto -11 -> 210
    //   224: astore_2
    //   225: aload_3
    //   226: astore_2
    //   227: goto -160 -> 67
    //   230: astore 4
    //   232: goto -106 -> 126
    //   235: astore_2
    //   236: goto -103 -> 133
    //   239: astore_2
    //   240: goto -99 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	bh
    //   1	186	1	i	int
    //   41	97	2	localObject1	Object
    //   220	1	2	localRuntimeException	java.lang.RuntimeException
    //   224	1	2	localThrowable	java.lang.Throwable
    //   226	1	2	localProperties1	java.util.Properties
    //   235	1	2	localIOException1	java.io.IOException
    //   239	1	2	localIOException2	java.io.IOException
    //   39	83	3	localObject2	Object
    //   136	90	3	localProperties2	java.util.Properties
    //   7	75	4	arrayOfByte1	byte[]
    //   230	1	4	localIOException3	java.io.IOException
    //   17	39	5	localRSAPublicKey	RSAPublicKey
    //   24	38	6	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   121	126	136	finally
    //   2	9	220	java/lang/RuntimeException
    //   47	67	224	java/lang/Throwable
    //   121	126	230	java/io/IOException
    //   126	130	235	java/io/IOException
    //   137	141	239	java/io/IOException
  }
  
  private final void D()
  {
    long l = this.fP.A();
    boolean bool;
    if (System.currentTimeMillis() / 1000L >= l) {
      bool = true;
    } else {
      bool = false;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(1000L * l);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("expirySeconds=");
    localStringBuilder.append(l);
    localStringBuilder.append("(");
    localStringBuilder.append(localCalendar.get(1));
    localStringBuilder.append("-");
    localStringBuilder.append(localCalendar.get(2));
    localStringBuilder.append("-");
    localStringBuilder.append(localCalendar.get(5));
    localStringBuilder.append(") expired=");
    localStringBuilder.append(bool);
    eg.e("LicenceManager", localStringBuilder.toString());
    this.fN = new bf(bool);
  }
  
  private static RSAPublicKey E()
  {
    try
    {
      RSAPublicKey localRSAPublicKey = (RSAPublicKey)X509Certificate.getInstance(dw.decode("LS0tLS1CRUdJTiBDRVJUSUZJQ0FURS0tLS0tCk1JSUM5ekNDQWQ4Q0NRRGlsbUFjTWxiczVEQU5C\nZ2txaGtpRzl3MEJBUVVGQURCK01Rc3dDUVlEVlFRR0V3SkQKVGpFTE1Ba0dBMVVFQ0JNQ1IwUXhD\nekFKQmdOVkJBY1RBa2RhTVJJd0VBWURWUVFLRkFsMFpXTUlibU5sYm5ReApDekFKQmdOVkJBc1RB\nak5ITVE0d0RBWURWUVFERXdWdlltRnRZVEVrTUNJR0NTcUdTSWIzRFFFSkFSWVZiMkpoCmJXRjZa\nVzVuUUhSbGJtTmxiblF1WTI5dE1CNFhEVEV4TVRFeE5qRXhNVGN4TjFvWERURXlNREl5TkRFeE1U\nY3gKTjFvd2dZQXhDekFKQmdOVkJBWVRBa05PTVFzd0NRWURWUVFJRXdKSFJERUxNQWtHQTFVRUJ4\nTUNSMW94RURBTwpCZ05WQkFvVEIzUmxibU5sYm5ReEN6QUpCZ05WQkFzVEFqTkhNUkl3RUFZRFZR\nUURFd2x2WW1GdFlYcGxibWN4CkpEQWlCZ2txaGtpRzl3MEJDUUVXRlc5aVlXMWhlbVZ1WjBCMFpX\nNWpaVzUwTG1OdmJUQ0JuekFOQmdrcWhraUcKOXcwQkFRRUZBQU9CalFBd2dZa0NnWUVBd1kvV3FI\nV2NlRERkSm16anI3TlpSeS9qTllwS1NzVzExZngxaTIrQwpxTUE3NTJXb1d1bDZuSTB1MGZkWitk\nUzVUandRNkU0Qm13dXduVTVnQmJYK1VzQ2VHRHZaQVhQc045UEVWYnZTCkcvR25YclQrcTI2VUpP\nNHcrd3VNdmk5YWxkZHhhbkNKeXJ2ZWQ2NUdvMXhXUEErWGNHaVQxMndubjZtUHhyMnUKcVEwQ0F3\nRUFBVEFOQmdrcWhraUc5dzBCQVFVRkFBT0NBUUVBblpzV3FpSmV5SC9sT0prSWN6L2ZidDN3MXFL\nRApGTXJ5cFVHVFN6Z3NONWNaMW9yOGlvVG5ENGRLaDdJN2ttbDRpcGNvMDF0enc2MGhLYUtwNG9G\nMnYrMEs2NGZDCnBEMG9EUlkrOGoyK2RsMmNxeHBsT0FYdDc1RWFKNW40MG1DZDdTN0VBS0d2Z2Na\naVhyV0Z1eUtCL2QvNTh3Qm4KOEFGUVJhTnBySXNOSHpxMkMwL0JXR1pTSnJicmhOWExFY0ZtL0Ru\nTG14ZEVNYWxPSXhnSkhGcEFOS2tadXBzdgo0L0lDVFhSL0RJaURjbXJjbDFkNkc2VmgyaUcwaS9v\nRDBHQnBMZlFPcEF0Vmx6Y2lxZnBsTkphcnpRUTZUVXRyCm5GRmVNVDNDc2t5VGJwYnp1R2dDdUxj\nQVR3cnRQd1BOOWZzQXYrSjRJZm0rZUNVVDVnZlorMSsyNHc9PQotLS0tLUVORCBDRVJUSUZJQ0FU\nRS0tLS0tCg==\n".getBytes(), 0)).getPublicKey();
      return localRSAPublicKey;
    }
    catch (CertificateException localCertificateException)
    {
      label21:
      break label21;
    }
    return null;
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      paramArrayOfByte2 = new DESKeySpec(paramArrayOfByte2);
      paramArrayOfByte2 = SecretKeyFactory.getInstance("DES").generateSecret(paramArrayOfByte2);
      Cipher localCipher = Cipher.getInstance("DES/ECB/NoPadding");
      localCipher.init(2, paramArrayOfByte2);
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
      return paramArrayOfByte1;
    }
    catch (GeneralSecurityException paramArrayOfByte1)
    {
      label39:
      break label39;
    }
    return null;
  }
  
  /* Error */
  private byte[] h(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload 5
    //   8: astore_2
    //   9: aload 6
    //   11: astore_3
    //   12: invokestatic 106	btmsdkobf/bc:n	()Landroid/content/Context;
    //   15: invokevirtual 237	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   18: astore 7
    //   20: iload_1
    //   21: ifne +10 -> 31
    //   24: ldc 239
    //   26: astore 4
    //   28: goto +72 -> 100
    //   31: aload 5
    //   33: astore_2
    //   34: aload 6
    //   36: astore_3
    //   37: new 141	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   44: astore 4
    //   46: aload 5
    //   48: astore_2
    //   49: aload 6
    //   51: astore_3
    //   52: aload 4
    //   54: ldc 241
    //   56: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 5
    //   62: astore_2
    //   63: aload 6
    //   65: astore_3
    //   66: aload 4
    //   68: iload_1
    //   69: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload 5
    //   75: astore_2
    //   76: aload 6
    //   78: astore_3
    //   79: aload 4
    //   81: ldc 243
    //   83: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 5
    //   89: astore_2
    //   90: aload 6
    //   92: astore_3
    //   93: aload 4
    //   95: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: astore 4
    //   100: aload 5
    //   102: astore_2
    //   103: aload 6
    //   105: astore_3
    //   106: aload 7
    //   108: aload 4
    //   110: invokevirtual 249	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   113: astore 4
    //   115: aload 4
    //   117: astore_2
    //   118: aload 4
    //   120: astore_3
    //   121: aload 4
    //   123: invokevirtual 255	java/io/InputStream:available	()I
    //   126: newarray byte
    //   128: astore 5
    //   130: aload 4
    //   132: astore_2
    //   133: aload 4
    //   135: astore_3
    //   136: aload 4
    //   138: aload 5
    //   140: invokevirtual 259	java/io/InputStream:read	([B)I
    //   143: pop
    //   144: aload 4
    //   146: ifnull +8 -> 154
    //   149: aload 4
    //   151: invokevirtual 260	java/io/InputStream:close	()V
    //   154: aload 5
    //   156: areturn
    //   157: astore_3
    //   158: goto +17 -> 175
    //   161: astore 4
    //   163: aload_3
    //   164: astore_2
    //   165: new 48	java/lang/RuntimeException
    //   168: dup
    //   169: aload 4
    //   171: invokespecial 263	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   174: athrow
    //   175: aload_2
    //   176: ifnull +7 -> 183
    //   179: aload_2
    //   180: invokevirtual 260	java/io/InputStream:close	()V
    //   183: aload_3
    //   184: athrow
    //   185: astore_2
    //   186: aload 5
    //   188: areturn
    //   189: astore_2
    //   190: goto -7 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	bh
    //   0	193	1	paramInt	int
    //   8	172	2	localObject1	Object
    //   185	1	2	localIOException1	java.io.IOException
    //   189	1	2	localIOException2	java.io.IOException
    //   11	125	3	localObject2	Object
    //   157	27	3	localObject3	Object
    //   26	124	4	localObject4	Object
    //   161	9	4	localIOException3	java.io.IOException
    //   4	183	5	arrayOfByte	byte[]
    //   1	103	6	localObject5	Object
    //   18	89	7	localAssetManager	android.content.res.AssetManager
    // Exception table:
    //   from	to	target	type
    //   12	20	157	finally
    //   37	46	157	finally
    //   52	60	157	finally
    //   66	73	157	finally
    //   79	87	157	finally
    //   93	100	157	finally
    //   106	115	157	finally
    //   121	130	157	finally
    //   136	144	157	finally
    //   165	175	157	finally
    //   12	20	161	java/io/IOException
    //   37	46	161	java/io/IOException
    //   52	60	161	java/io/IOException
    //   66	73	161	java/io/IOException
    //   79	87	161	java/io/IOException
    //   93	100	161	java/io/IOException
    //   106	115	161	java/io/IOException
    //   121	130	161	java/io/IOException
    //   136	144	161	java/io/IOException
    //   149	154	185	java/io/IOException
    //   179	183	189	java/io/IOException
  }
  
  public String getChannel()
  {
    if (bc.o().isCheckLicence()) {
      return this.fP.getChannel();
    }
    return bc.o().getChannel();
  }
  
  public boolean isExpired()
  {
    if (!bc.o().isCheckLicence()) {
      return false;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(System.currentTimeMillis());
    if ((localCalendar.get(1) != this.fO.get(1)) || (localCalendar.get(6) != this.fO.get(6))) {
      D();
    }
    this.fO.setTimeInMillis(System.currentTimeMillis());
    return this.fN.isExpired();
  }
  
  public final boolean z()
  {
    if (bc.o().isCheckLicence()) {
      return this.fP.z();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.bh
 * JD-Core Version:    0.7.0.1
 */