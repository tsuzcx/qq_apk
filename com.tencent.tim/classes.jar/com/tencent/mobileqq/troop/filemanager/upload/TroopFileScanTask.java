package com.tencent.mobileqq.troop.filemanager.upload;

import android.os.Bundle;
import android.text.TextUtils;
import apef.b;
import apft.a;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.Timer;

public class TroopFileScanTask
  implements Runnable
{
  private Timer K;
  private apft.a jdField_a_of_type_Apft$a;
  private a jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScanTask$a;
  private long ark;
  private boolean bkn = true;
  private int dTZ;
  private byte[] gq;
  private byte[] gr;
  private byte[] gs;
  private int mDuration;
  private int mErrCode = 0;
  private String mFilePath;
  private long mFileSize;
  private int mHeight;
  
  protected TroopFileScanTask(long paramLong, String paramString, a parama, apft.a parama1)
  {
    this.ark = paramLong;
    this.mFilePath = paramString;
    this.jdField_a_of_type_Apft$a = parama1;
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScanTask$a = parama;
  }
  
  private void RD(boolean paramBoolean)
  {
    if (this.bkn) {
      apef.b.w("TroopFileScanTask", apef.b.USR, "[" + this.ark + "] scan suc. but had stop. passiveHit:" + paramBoolean);
    }
    do
    {
      return;
      dYY();
      String str1 = HexUtil.bytes2HexStr(this.gq);
      String str2 = HexUtil.bytes2HexStr(this.gr);
      String str3 = HexUtil.bytes2HexStr(this.gs);
      apef.b.i("TroopFileScanTask", apef.b.USR, "[" + this.ark + "] scan suc. passiveHit:" + paramBoolean + " md5:" + str1 + " sha1:" + str2 + " sha3:" + str3 + " mWith:" + this.dTZ + " mHeight:" + this.mHeight + " mDuration:" + this.mDuration);
      this.mErrCode = 0;
      this.bkn = true;
      if (this.jdField_a_of_type_Apft$a != null) {
        this.jdField_a_of_type_Apft$a.a(this.ark, this.mFilePath, this.mFileSize, this.gq, this.gr, this.gs, q(), this.mErrCode);
      }
    } while ((paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScanTask$a == null));
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScanTask$a.a(this.ark, true, this.mErrCode, this);
  }
  
  public static TroopFileScanTask a(long paramLong, String paramString, a parama, apft.a parama1)
  {
    if (TextUtils.isEmpty(paramString))
    {
      apef.b.e("TroopFileScanTask", apef.b.USR, "[" + paramLong + "] getTask filepath=null");
      return null;
    }
    return new TroopFileScanTask(paramLong, paramString, parama, parama1);
  }
  
  private void bZ(int paramInt, boolean paramBoolean)
  {
    if (this.bkn) {
      apef.b.w("TroopFileScanTask", apef.b.USR, "[" + this.ark + "] scan fail had stop. errCode:" + paramInt);
    }
    do
    {
      return;
      apef.b.i("TroopFileScanTask", apef.b.USR, "[" + this.ark + "] scan fail. errCode:" + paramInt + " passiveErr:" + paramBoolean);
      dYY();
      this.bkn = true;
      this.mErrCode = paramInt;
      if (this.jdField_a_of_type_Apft$a != null) {
        this.jdField_a_of_type_Apft$a.a(this.ark, this.mFilePath, this.mFileSize, null, null, null, null, this.mErrCode);
      }
    } while ((paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScanTask$a == null));
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScanTask$a.a(this.ark, false, this.mErrCode, this);
  }
  
  private void dYY()
  {
    try
    {
      if (this.K != null)
      {
        this.K.cancel();
        this.K = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void lL(long paramLong)
  {
    try
    {
      dYY();
      this.K = new Timer();
      this.K.schedule(new TroopFileScanTask.1(this), paramLong);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, Bundle paramBundle)
  {
    if (this.bkn) {
      apef.b.w("TroopFileScanTask", apef.b.USR, "[" + this.ark + "] passiveEnd. but had stop");
    }
    while (!this.mFilePath.equalsIgnoreCase(paramString)) {
      return;
    }
    if (!paramBoolean)
    {
      bZ(paramInt, true);
      return;
    }
    this.mFileSize = paramLong;
    this.gq = paramArrayOfByte1;
    this.gr = paramArrayOfByte2;
    this.gs = paramArrayOfByte3;
    if (paramBundle != null)
    {
      this.dTZ = paramBundle.getInt("_with_", 0);
      this.mHeight = paramBundle.getInt("_height_", 0);
      this.mDuration = paramBundle.getInt("_duration_", 0);
    }
    RD(true);
  }
  
  public byte[] aa()
  {
    return this.gq;
  }
  
  public byte[] aw()
  {
    return this.gr;
  }
  
  public byte[] ax()
  {
    return this.gs;
  }
  
  public void dZk()
  {
    apef.b.i("TroopFileScanTask", apef.b.USR, "[" + this.ark + "] passiveStart.");
    this.bkn = false;
    lL(90000L);
  }
  
  public String getFilePath()
  {
    return this.mFilePath;
  }
  
  public long getFileSize()
  {
    return this.mFileSize;
  }
  
  public long ht()
  {
    return this.ark;
  }
  
  public Bundle q()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("_with_", this.dTZ);
    localBundle.putInt("_height_", this.mHeight);
    localBundle.putInt("_duration_", this.mDuration);
    return localBundle;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_2
    //   2: aload_0
    //   3: getfield 36	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:bkn	Z
    //   6: ifeq +39 -> 45
    //   9: ldc 51
    //   11: getstatic 56	apef$b:USR	I
    //   14: new 58	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   21: ldc 61
    //   23: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: getfield 40	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:ark	J
    //   30: invokevirtual 68	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   33: ldc 234
    //   35: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 81	apef$b:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: return
    //   45: ldc 51
    //   47: getstatic 56	apef$b:USR	I
    //   50: new 58	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   57: ldc 61
    //   59: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_0
    //   63: getfield 40	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:ark	J
    //   66: invokevirtual 68	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   69: ldc 236
    //   71: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 122	apef$b:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: new 238	com/tencent/mm/vfs/VFSFile
    //   83: dup
    //   84: aload_0
    //   85: getfield 42	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:mFilePath	Ljava/lang/String;
    //   88: invokespecial 241	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   91: astore 7
    //   93: aload 7
    //   95: invokevirtual 245	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   98: ifeq +21 -> 119
    //   101: aload 7
    //   103: invokevirtual 248	com/tencent/mm/vfs/VFSFile:isFile	()Z
    //   106: ifne +41 -> 147
    //   109: aload 7
    //   111: invokevirtual 251	com/tencent/mm/vfs/VFSFile:length	()J
    //   114: lconst_0
    //   115: lcmp
    //   116: ifge +31 -> 147
    //   119: aload_0
    //   120: getfield 44	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_Apft$a	Lapft$a;
    //   123: ifnull +17 -> 140
    //   126: aload_0
    //   127: getfield 44	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_Apft$a	Lapft$a;
    //   130: aload_0
    //   131: getfield 40	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:ark	J
    //   134: lconst_0
    //   135: invokeinterface 255 5 0
    //   140: aload_0
    //   141: iconst_m1
    //   142: iconst_0
    //   143: invokespecial 155	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:bZ	(IZ)V
    //   146: return
    //   147: aload_0
    //   148: aload 7
    //   150: invokevirtual 251	com/tencent/mm/vfs/VFSFile:length	()J
    //   153: putfield 124	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:mFileSize	J
    //   156: aload_0
    //   157: getfield 44	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_Apft$a	Lapft$a;
    //   160: ifnull +20 -> 180
    //   163: aload_0
    //   164: getfield 44	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_Apft$a	Lapft$a;
    //   167: aload_0
    //   168: getfield 40	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:ark	J
    //   171: aload_0
    //   172: getfield 124	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:mFileSize	J
    //   175: invokeinterface 255 5 0
    //   180: aload_0
    //   181: getfield 124	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:mFileSize	J
    //   184: ldc2_w 256
    //   187: lcmp
    //   188: iflt +11 -> 199
    //   191: aload_0
    //   192: bipush 252
    //   194: iconst_0
    //   195: invokespecial 155	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:bZ	(IZ)V
    //   198: return
    //   199: ldc_w 259
    //   202: invokestatic 265	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   205: astore 5
    //   207: ldc_w 267
    //   210: invokestatic 265	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   213: astore 6
    //   215: new 269	com/tencent/mm/vfs/VFSFileInputStream
    //   218: dup
    //   219: aload 7
    //   221: invokespecial 272	com/tencent/mm/vfs/VFSFileInputStream:<init>	(Lcom/tencent/mm/vfs/VFSFile;)V
    //   224: astore 7
    //   226: ldc_w 273
    //   229: newarray byte
    //   231: astore 8
    //   233: aload 7
    //   235: aload 8
    //   237: invokevirtual 277	com/tencent/mm/vfs/VFSFileInputStream:read	([B)I
    //   240: istore_1
    //   241: iload_1
    //   242: ifge +117 -> 359
    //   245: aload 7
    //   247: invokevirtual 280	com/tencent/mm/vfs/VFSFileInputStream:close	()V
    //   250: aload_0
    //   251: aload 5
    //   253: invokevirtual 283	java/security/MessageDigest:digest	()[B
    //   256: putfield 86	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:gq	[B
    //   259: aload_0
    //   260: aload 6
    //   262: invokevirtual 283	java/security/MessageDigest:digest	()[B
    //   265: putfield 94	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:gr	[B
    //   268: aload_0
    //   269: aload_0
    //   270: getfield 42	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:mFilePath	Ljava/lang/String;
    //   273: invokestatic 289	ahav:A	(Ljava/lang/String;)[B
    //   276: putfield 96	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:gs	[B
    //   279: aload_0
    //   280: getfield 42	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:mFilePath	Ljava/lang/String;
    //   283: invokestatic 293	ahav:getFileType	(Ljava/lang/String;)I
    //   286: istore_1
    //   287: iload_1
    //   288: ifne +197 -> 485
    //   291: new 295	android/graphics/BitmapFactory$Options
    //   294: dup
    //   295: invokespecial 296	android/graphics/BitmapFactory$Options:<init>	()V
    //   298: astore 5
    //   300: aload 5
    //   302: iconst_1
    //   303: putfield 299	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   306: aload_0
    //   307: getfield 42	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:mFilePath	Ljava/lang/String;
    //   310: aload 5
    //   312: invokestatic 305	aqhu:d	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   315: pop
    //   316: aload_0
    //   317: aload 5
    //   319: getfield 308	android/graphics/BitmapFactory$Options:outWidth	I
    //   322: putfield 108	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:dTZ	I
    //   325: aload_0
    //   326: aload 5
    //   328: getfield 311	android/graphics/BitmapFactory$Options:outHeight	I
    //   331: putfield 115	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:mHeight	I
    //   334: aload_0
    //   335: iconst_0
    //   336: invokespecial 203	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:RD	(Z)V
    //   339: return
    //   340: astore 5
    //   342: aload_0
    //   343: bipush 254
    //   345: iconst_0
    //   346: invokespecial 155	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:bZ	(IZ)V
    //   349: return
    //   350: astore 5
    //   352: aload_0
    //   353: iconst_m1
    //   354: iconst_0
    //   355: invokespecial 155	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:bZ	(IZ)V
    //   358: return
    //   359: aload 5
    //   361: aload 8
    //   363: iconst_0
    //   364: iload_1
    //   365: invokevirtual 315	java/security/MessageDigest:update	([BII)V
    //   368: aload 6
    //   370: aload 8
    //   372: iconst_0
    //   373: iload_1
    //   374: invokevirtual 315	java/security/MessageDigest:update	([BII)V
    //   377: lload_2
    //   378: iload_1
    //   379: i2l
    //   380: ladd
    //   381: lstore_2
    //   382: aload_0
    //   383: getfield 44	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_Apft$a	Lapft$a;
    //   386: ifnull +21 -> 407
    //   389: aload_0
    //   390: getfield 44	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_Apft$a	Lapft$a;
    //   393: aload_0
    //   394: getfield 40	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:ark	J
    //   397: lload_2
    //   398: aload_0
    //   399: getfield 124	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:mFileSize	J
    //   402: invokeinterface 319 7 0
    //   407: aload_0
    //   408: getfield 36	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:bkn	Z
    //   411: istore 4
    //   413: iload 4
    //   415: ifeq -182 -> 233
    //   418: aload 7
    //   420: invokevirtual 280	com/tencent/mm/vfs/VFSFileInputStream:close	()V
    //   423: return
    //   424: astore 5
    //   426: aload 5
    //   428: invokevirtual 322	java/io/IOException:printStackTrace	()V
    //   431: return
    //   432: astore 7
    //   434: aload 7
    //   436: invokevirtual 322	java/io/IOException:printStackTrace	()V
    //   439: goto -189 -> 250
    //   442: astore 5
    //   444: aload_0
    //   445: bipush 253
    //   447: iconst_0
    //   448: invokespecial 155	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:bZ	(IZ)V
    //   451: aload 7
    //   453: invokevirtual 280	com/tencent/mm/vfs/VFSFileInputStream:close	()V
    //   456: return
    //   457: astore 5
    //   459: aload 5
    //   461: invokevirtual 322	java/io/IOException:printStackTrace	()V
    //   464: return
    //   465: astore 5
    //   467: aload 7
    //   469: invokevirtual 280	com/tencent/mm/vfs/VFSFileInputStream:close	()V
    //   472: aload 5
    //   474: athrow
    //   475: astore 6
    //   477: aload 6
    //   479: invokevirtual 322	java/io/IOException:printStackTrace	()V
    //   482: goto -10 -> 472
    //   485: iload_1
    //   486: iconst_2
    //   487: if_icmpne -153 -> 334
    //   490: aload_0
    //   491: getfield 42	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:mFilePath	Ljava/lang/String;
    //   494: invokestatic 328	com/tencent/mobileqq/shortvideo/ShortVideoUtils:n	(Ljava/lang/String;)[I
    //   497: astore 5
    //   499: aload_0
    //   500: aload 5
    //   502: iconst_0
    //   503: iaload
    //   504: putfield 108	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:dTZ	I
    //   507: aload_0
    //   508: aload 5
    //   510: iconst_1
    //   511: iaload
    //   512: putfield 115	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:mHeight	I
    //   515: aload_0
    //   516: aload 5
    //   518: iconst_2
    //   519: iaload
    //   520: putfield 119	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:mDuration	I
    //   523: goto -189 -> 334
    //   526: astore 5
    //   528: goto -194 -> 334
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	531	0	this	TroopFileScanTask
    //   240	248	1	i	int
    //   1	397	2	l	long
    //   411	3	4	bool	boolean
    //   205	122	5	localObject1	Object
    //   340	1	5	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   350	10	5	localFileNotFoundException	java.io.FileNotFoundException
    //   424	3	5	localIOException1	java.io.IOException
    //   442	1	5	localIOException2	java.io.IOException
    //   457	3	5	localIOException3	java.io.IOException
    //   465	8	5	localObject2	Object
    //   497	20	5	arrayOfInt	int[]
    //   526	1	5	localException	java.lang.Exception
    //   213	156	6	localMessageDigest	java.security.MessageDigest
    //   475	3	6	localIOException4	java.io.IOException
    //   91	328	7	localObject3	Object
    //   432	36	7	localIOException5	java.io.IOException
    //   231	140	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   199	215	340	java/security/NoSuchAlgorithmException
    //   215	226	350	java/io/FileNotFoundException
    //   418	423	424	java/io/IOException
    //   245	250	432	java/io/IOException
    //   226	233	442	java/io/IOException
    //   233	241	442	java/io/IOException
    //   359	377	442	java/io/IOException
    //   382	407	442	java/io/IOException
    //   407	413	442	java/io/IOException
    //   451	456	457	java/io/IOException
    //   226	233	465	finally
    //   233	241	465	finally
    //   359	377	465	finally
    //   382	407	465	finally
    //   407	413	465	finally
    //   444	451	465	finally
    //   467	472	475	java/io/IOException
    //   291	334	526	java/lang/Exception
  }
  
  public boolean start()
  {
    this.bkn = false;
    lL(90000L);
    apef.b.i("TroopFileScanTask", apef.b.USR, "[" + this.ark + "] sart");
    ThreadManager.post(this, 5, null, true);
    return true;
  }
  
  public void stop()
  {
    apef.b.i("TroopFileScanTask", apef.b.USR, "[" + this.ark + "] stop");
    dYY();
    this.bkn = true;
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong, boolean paramBoolean, int paramInt, TroopFileScanTask paramTroopFileScanTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileScanTask
 * JD-Core Version:    0.7.0.1
 */