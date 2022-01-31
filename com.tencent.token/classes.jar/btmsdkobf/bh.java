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
  private static volatile bh fM = null;
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
    //   11: ifnonnull +24 -> 35
    //   14: new 48	java/lang/RuntimeException
    //   17: dup
    //   18: ldc 58
    //   20: invokespecial 61	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   23: athrow
    //   24: astore_2
    //   25: new 48	java/lang/RuntimeException
    //   28: dup
    //   29: ldc 63
    //   31: invokespecial 61	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   34: athrow
    //   35: invokestatic 67	btmsdkobf/bh:E	()Ljava/security/interfaces/RSAPublicKey;
    //   38: astore 5
    //   40: sipush 128
    //   43: newarray byte
    //   45: astore 6
    //   47: aload 4
    //   49: iconst_0
    //   50: aload 6
    //   52: iconst_0
    //   53: aload 6
    //   55: arraylength
    //   56: invokestatic 73	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   59: aconst_null
    //   60: astore_3
    //   61: aload_3
    //   62: astore_2
    //   63: aload 5
    //   65: ifnull +23 -> 88
    //   68: ldc 75
    //   70: invokestatic 80	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   73: astore_2
    //   74: aload_2
    //   75: iconst_2
    //   76: aload 5
    //   78: invokevirtual 84	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   81: aload_2
    //   82: aload 6
    //   84: invokevirtual 88	javax/crypto/Cipher:doFinal	([B)[B
    //   87: astore_2
    //   88: aload_2
    //   89: ifnonnull +13 -> 102
    //   92: new 48	java/lang/RuntimeException
    //   95: dup
    //   96: ldc 90
    //   98: invokespecial 61	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   101: athrow
    //   102: aload 4
    //   104: arraylength
    //   105: sipush 128
    //   108: isub
    //   109: newarray byte
    //   111: astore_3
    //   112: aload 4
    //   114: sipush 128
    //   117: aload_3
    //   118: iconst_0
    //   119: aload_3
    //   120: arraylength
    //   121: invokestatic 73	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   124: aload_3
    //   125: aload_2
    //   126: invokestatic 94	btmsdkobf/bh:a	([B[B)[B
    //   129: astore_2
    //   130: aload_2
    //   131: ifnonnull +4 -> 135
    //   134: return
    //   135: new 96	java/io/ByteArrayInputStream
    //   138: dup
    //   139: aload_2
    //   140: invokespecial 99	java/io/ByteArrayInputStream:<init>	([B)V
    //   143: astore_3
    //   144: new 101	java/util/Properties
    //   147: dup
    //   148: invokespecial 102	java/util/Properties:<init>	()V
    //   151: astore_2
    //   152: aload_2
    //   153: aload_3
    //   154: invokevirtual 106	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   157: aload_3
    //   158: invokevirtual 109	java/io/ByteArrayInputStream:close	()V
    //   161: aload_0
    //   162: new 111	btmsdkobf/bg
    //   165: dup
    //   166: aload_2
    //   167: invokestatic 115	btmsdkobf/bc:n	()Landroid/content/Context;
    //   170: invokespecial 118	btmsdkobf/bg:<init>	(Ljava/util/Properties;Landroid/content/Context;)V
    //   173: putfield 120	btmsdkobf/bh:fP	Lbtmsdkobf/bg;
    //   176: aload_0
    //   177: getfield 120	btmsdkobf/bh:fP	Lbtmsdkobf/bg;
    //   180: invokevirtual 123	btmsdkobf/bg:z	()Z
    //   183: ifeq +38 -> 221
    //   186: aload_0
    //   187: invokespecial 126	btmsdkobf/bh:D	()V
    //   190: aload_0
    //   191: getfield 28	btmsdkobf/bh:fO	Ljava/util/Calendar;
    //   194: invokestatic 130	java/lang/System:currentTimeMillis	()J
    //   197: invokevirtual 134	java/util/Calendar:setTimeInMillis	(J)V
    //   200: return
    //   201: astore 4
    //   203: aload_3
    //   204: invokevirtual 109	java/io/ByteArrayInputStream:close	()V
    //   207: goto -46 -> 161
    //   210: astore_3
    //   211: goto -50 -> 161
    //   214: astore_2
    //   215: aload_3
    //   216: invokevirtual 109	java/io/ByteArrayInputStream:close	()V
    //   219: aload_2
    //   220: athrow
    //   221: iload_1
    //   222: iconst_1
    //   223: iadd
    //   224: istore_1
    //   225: goto -223 -> 2
    //   228: astore_3
    //   229: goto -68 -> 161
    //   232: astore_3
    //   233: goto -14 -> 219
    //   236: astore_2
    //   237: aload_3
    //   238: astore_2
    //   239: goto -151 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	bh
    //   1	224	1	i	int
    //   24	1	2	localRuntimeException	java.lang.RuntimeException
    //   62	105	2	localObject1	Object
    //   214	6	2	localObject2	Object
    //   236	1	2	localThrowable	java.lang.Throwable
    //   238	1	2	localObject3	Object
    //   60	144	3	localObject4	Object
    //   210	6	3	localIOException1	java.io.IOException
    //   228	1	3	localIOException2	java.io.IOException
    //   232	6	3	localIOException3	java.io.IOException
    //   7	106	4	arrayOfByte1	byte[]
    //   201	1	4	localIOException4	java.io.IOException
    //   38	39	5	localRSAPublicKey	RSAPublicKey
    //   45	38	6	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   2	9	24	java/lang/RuntimeException
    //   152	157	201	java/io/IOException
    //   203	207	210	java/io/IOException
    //   152	157	214	finally
    //   157	161	228	java/io/IOException
    //   215	219	232	java/io/IOException
    //   68	88	236	java/lang/Throwable
  }
  
  private final void D()
  {
    long l = -1L;
    if (-1L == -1L) {
      l = this.fP.A();
    }
    if (System.currentTimeMillis() / 1000L >= l) {}
    for (boolean bool = true;; bool = false)
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(1000L * l);
      eg.e("LicenceManager", "expirySeconds=" + l + "(" + localCalendar.get(1) + "-" + localCalendar.get(2) + "-" + localCalendar.get(5) + ") expired=" + bool);
      this.fN = new bf(bool);
      return;
    }
  }
  
  private static RSAPublicKey E()
  {
    try
    {
      RSAPublicKey localRSAPublicKey = (RSAPublicKey)X509Certificate.getInstance(dw.decode("LS0tLS1CRUdJTiBDRVJUSUZJQ0FURS0tLS0tCk1JSUM5ekNDQWQ4Q0NRRGlsbUFjTWxiczVEQU5C\nZ2txaGtpRzl3MEJBUVVGQURCK01Rc3dDUVlEVlFRR0V3SkQKVGpFTE1Ba0dBMVVFQ0JNQ1IwUXhD\nekFKQmdOVkJBY1RBa2RhTVJJd0VBWURWUVFLRkFsMFpXTUlibU5sYm5ReApDekFKQmdOVkJBc1RB\nak5ITVE0d0RBWURWUVFERXdWdlltRnRZVEVrTUNJR0NTcUdTSWIzRFFFSkFSWVZiMkpoCmJXRjZa\nVzVuUUhSbGJtTmxiblF1WTI5dE1CNFhEVEV4TVRFeE5qRXhNVGN4TjFvWERURXlNREl5TkRFeE1U\nY3gKTjFvd2dZQXhDekFKQmdOVkJBWVRBa05PTVFzd0NRWURWUVFJRXdKSFJERUxNQWtHQTFVRUJ4\nTUNSMW94RURBTwpCZ05WQkFvVEIzUmxibU5sYm5ReEN6QUpCZ05WQkFzVEFqTkhNUkl3RUFZRFZR\nUURFd2x2WW1GdFlYcGxibWN4CkpEQWlCZ2txaGtpRzl3MEJDUUVXRlc5aVlXMWhlbVZ1WjBCMFpX\nNWpaVzUwTG1OdmJUQ0JuekFOQmdrcWhraUcKOXcwQkFRRUZBQU9CalFBd2dZa0NnWUVBd1kvV3FI\nV2NlRERkSm16anI3TlpSeS9qTllwS1NzVzExZngxaTIrQwpxTUE3NTJXb1d1bDZuSTB1MGZkWitk\nUzVUandRNkU0Qm13dXduVTVnQmJYK1VzQ2VHRHZaQVhQc045UEVWYnZTCkcvR25YclQrcTI2VUpP\nNHcrd3VNdmk5YWxkZHhhbkNKeXJ2ZWQ2NUdvMXhXUEErWGNHaVQxMndubjZtUHhyMnUKcVEwQ0F3\nRUFBVEFOQmdrcWhraUc5dzBCQVFVRkFBT0NBUUVBblpzV3FpSmV5SC9sT0prSWN6L2ZidDN3MXFL\nRApGTXJ5cFVHVFN6Z3NONWNaMW9yOGlvVG5ENGRLaDdJN2ttbDRpcGNvMDF0enc2MGhLYUtwNG9G\nMnYrMEs2NGZDCnBEMG9EUlkrOGoyK2RsMmNxeHBsT0FYdDc1RWFKNW40MG1DZDdTN0VBS0d2Z2Na\naVhyV0Z1eUtCL2QvNTh3Qm4KOEFGUVJhTnBySXNOSHpxMkMwL0JXR1pTSnJicmhOWExFY0ZtL0Ru\nTG14ZEVNYWxPSXhnSkhGcEFOS2tadXBzdgo0L0lDVFhSL0RJaURjbXJjbDFkNkc2VmgyaUcwaS9v\nRDBHQnBMZlFPcEF0Vmx6Y2lxZnBsTkphcnpRUTZUVXRyCm5GRmVNVDNDc2t5VGJwYnp1R2dDdUxj\nQVR3cnRQd1BOOWZzQXYrSjRJZm0rZUNVVDVnZlorMSsyNHc9PQotLS0tLUVORCBDRVJUSUZJQ0FU\nRS0tLS0tCg==\n".getBytes(), 0)).getPublicKey();
      return localRSAPublicKey;
    }
    catch (CertificateException localCertificateException) {}
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
    catch (GeneralSecurityException paramArrayOfByte1) {}
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
    //   8: astore_3
    //   9: aload 6
    //   11: astore_2
    //   12: invokestatic 115	btmsdkobf/bc:n	()Landroid/content/Context;
    //   15: invokevirtual 239	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   18: astore 7
    //   20: iload_1
    //   21: ifne +64 -> 85
    //   24: ldc 241
    //   26: astore 4
    //   28: aload 5
    //   30: astore_3
    //   31: aload 6
    //   33: astore_2
    //   34: aload 7
    //   36: aload 4
    //   38: invokevirtual 247	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   41: astore 4
    //   43: aload 4
    //   45: astore_3
    //   46: aload 4
    //   48: astore_2
    //   49: aload 4
    //   51: invokevirtual 253	java/io/InputStream:available	()I
    //   54: newarray byte
    //   56: astore 5
    //   58: aload 4
    //   60: astore_3
    //   61: aload 4
    //   63: astore_2
    //   64: aload 4
    //   66: aload 5
    //   68: invokevirtual 257	java/io/InputStream:read	([B)I
    //   71: pop
    //   72: aload 4
    //   74: ifnull +8 -> 82
    //   77: aload 4
    //   79: invokevirtual 258	java/io/InputStream:close	()V
    //   82: aload 5
    //   84: areturn
    //   85: aload 5
    //   87: astore_3
    //   88: aload 6
    //   90: astore_2
    //   91: new 145	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   98: ldc_w 260
    //   101: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: iload_1
    //   105: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   108: ldc_w 262
    //   111: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: astore 4
    //   119: goto -91 -> 28
    //   122: astore 4
    //   124: aload_3
    //   125: astore_2
    //   126: new 48	java/lang/RuntimeException
    //   129: dup
    //   130: aload 4
    //   132: invokespecial 265	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   135: athrow
    //   136: astore_3
    //   137: aload_2
    //   138: ifnull +7 -> 145
    //   141: aload_2
    //   142: invokevirtual 258	java/io/InputStream:close	()V
    //   145: aload_3
    //   146: athrow
    //   147: astore_2
    //   148: aload 5
    //   150: areturn
    //   151: astore_2
    //   152: goto -7 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	bh
    //   0	155	1	paramInt	int
    //   11	131	2	localObject1	Object
    //   147	1	2	localIOException1	java.io.IOException
    //   151	1	2	localIOException2	java.io.IOException
    //   8	117	3	localObject2	Object
    //   136	10	3	localObject3	Object
    //   26	92	4	localObject4	Object
    //   122	9	4	localIOException3	java.io.IOException
    //   4	145	5	arrayOfByte	byte[]
    //   1	88	6	localObject5	Object
    //   18	17	7	localAssetManager	android.content.res.AssetManager
    // Exception table:
    //   from	to	target	type
    //   12	20	122	java/io/IOException
    //   34	43	122	java/io/IOException
    //   49	58	122	java/io/IOException
    //   64	72	122	java/io/IOException
    //   91	119	122	java/io/IOException
    //   12	20	136	finally
    //   34	43	136	finally
    //   49	58	136	finally
    //   64	72	136	finally
    //   91	119	136	finally
    //   126	136	136	finally
    //   77	82	147	java/io/IOException
    //   141	145	151	java/io/IOException
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