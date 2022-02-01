package com.tencent.mobileqq.troop.filemanager.thumbnail;

import ahav;
import ahbj;
import ahwo;
import ahwy;
import akyr;
import android.text.TextUtils;
import android.util.Pair;
import apdw;
import apef.b;
import apfp;
import apfq;
import apsv;
import apue.a;
import aqhq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Timer;

public class TroopFileThumbnailGenTask
  implements Runnable
{
  protected Timer K;
  protected a a;
  protected int bYf;
  protected boolean bkn = true;
  protected TroopFileTransferManager.Item c;
  protected boolean cQk;
  protected String coD;
  protected String coy;
  protected String coz;
  protected String mFileDir;
  protected String mFilePath;
  protected String mTmpFilePath;
  protected long mTroopUin;
  
  protected TroopFileThumbnailGenTask(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, String paramString, a parama)
  {
    this.mTroopUin = paramLong;
    this.c = paramItem;
    this.a = parama;
    this.bYf = paramInt;
    this.coy = apfp.b(this.c.Id, paramInt);
    if (!TextUtils.isEmpty(this.c.LocalFile)) {}
    for (paramItem = ahbj.getExtension(this.c.LocalFile);; paramItem = ahbj.getExtension(this.c.FileName))
    {
      if (ahav.getFileType(paramItem) == 2) {
        this.cQk = true;
      }
      if (TextUtils.isEmpty(paramString)) {
        break;
      }
      this.coD = paramString;
      return;
    }
    this.coD = this.c.LocalFile;
  }
  
  /* Error */
  private int Ln()
  {
    // Byte code:
    //   0: aconst_null
    //   1: aload_0
    //   2: getfield 82	com/tencent/mobileqq/troop/filemanager/thumbnail/TroopFileThumbnailGenTask:coD	Ljava/lang/String;
    //   5: invokestatic 102	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getVideoThumbnail	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnull +80 -> 90
    //   13: aload_0
    //   14: getfield 104	com/tencent/mobileqq/troop/filemanager/thumbnail/TroopFileThumbnailGenTask:mTmpFilePath	Ljava/lang/String;
    //   17: invokestatic 110	aqhq:deleteFile	(Ljava/lang/String;)Z
    //   20: pop
    //   21: new 112	com/tencent/mm/vfs/VFSFile
    //   24: dup
    //   25: aload_0
    //   26: getfield 104	com/tencent/mobileqq/troop/filemanager/thumbnail/TroopFileThumbnailGenTask:mTmpFilePath	Ljava/lang/String;
    //   29: invokespecial 115	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   32: astore_1
    //   33: aload_1
    //   34: invokevirtual 119	com/tencent/mm/vfs/VFSFile:createNewFile	()Z
    //   37: pop
    //   38: new 121	java/io/BufferedOutputStream
    //   41: dup
    //   42: new 123	java/io/FileOutputStream
    //   45: dup
    //   46: aload_0
    //   47: getfield 104	com/tencent/mobileqq/troop/filemanager/thumbnail/TroopFileThumbnailGenTask:mTmpFilePath	Ljava/lang/String;
    //   50: invokespecial 124	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   53: invokespecial 127	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   56: astore_2
    //   57: aload_2
    //   58: astore_1
    //   59: aload_3
    //   60: getstatic 133	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   63: bipush 100
    //   65: aload_2
    //   66: invokevirtual 139	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   69: pop
    //   70: aload_2
    //   71: astore_1
    //   72: aload_3
    //   73: invokevirtual 142	android/graphics/Bitmap:recycle	()V
    //   76: aload_2
    //   77: astore_1
    //   78: aload_2
    //   79: invokevirtual 145	java/io/BufferedOutputStream:flush	()V
    //   82: aload_2
    //   83: ifnull +7 -> 90
    //   86: aload_2
    //   87: invokevirtual 148	java/io/BufferedOutputStream:close	()V
    //   90: iconst_0
    //   91: ireturn
    //   92: astore_1
    //   93: bipush 254
    //   95: ireturn
    //   96: astore_1
    //   97: aload_1
    //   98: invokevirtual 151	java/lang/Exception:printStackTrace	()V
    //   101: iconst_0
    //   102: ireturn
    //   103: astore_1
    //   104: bipush 253
    //   106: ireturn
    //   107: astore_3
    //   108: aconst_null
    //   109: astore_2
    //   110: aload_2
    //   111: astore_1
    //   112: aload_3
    //   113: invokevirtual 152	java/io/FileNotFoundException:printStackTrace	()V
    //   116: aload_2
    //   117: ifnull +45 -> 162
    //   120: aload_2
    //   121: invokevirtual 148	java/io/BufferedOutputStream:close	()V
    //   124: iconst_m1
    //   125: ireturn
    //   126: astore_1
    //   127: aload_1
    //   128: invokevirtual 151	java/lang/Exception:printStackTrace	()V
    //   131: iconst_m1
    //   132: ireturn
    //   133: astore_2
    //   134: aconst_null
    //   135: astore_1
    //   136: aload_1
    //   137: ifnull +7 -> 144
    //   140: aload_1
    //   141: invokevirtual 148	java/io/BufferedOutputStream:close	()V
    //   144: aload_2
    //   145: athrow
    //   146: astore_1
    //   147: aload_1
    //   148: invokevirtual 151	java/lang/Exception:printStackTrace	()V
    //   151: goto -7 -> 144
    //   154: astore_2
    //   155: goto -19 -> 136
    //   158: astore_3
    //   159: goto -49 -> 110
    //   162: iconst_m1
    //   163: ireturn
    //   164: astore_1
    //   165: bipush 252
    //   167: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	TroopFileThumbnailGenTask
    //   32	46	1	localObject1	Object
    //   92	1	1	localIOException	IOException
    //   96	2	1	localException1	Exception
    //   103	1	1	localException2	Exception
    //   111	1	1	localObject2	Object
    //   126	2	1	localException3	Exception
    //   135	6	1	localObject3	Object
    //   146	2	1	localException4	Exception
    //   164	1	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   56	65	2	localBufferedOutputStream	java.io.BufferedOutputStream
    //   133	12	2	localObject4	Object
    //   154	1	2	localObject5	Object
    //   8	65	3	localBitmap	android.graphics.Bitmap
    //   107	6	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   158	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   33	38	92	java/io/IOException
    //   86	90	96	java/lang/Exception
    //   0	9	103	java/lang/Exception
    //   13	33	103	java/lang/Exception
    //   33	38	103	java/lang/Exception
    //   97	101	103	java/lang/Exception
    //   127	131	103	java/lang/Exception
    //   144	146	103	java/lang/Exception
    //   147	151	103	java/lang/Exception
    //   38	57	107	java/io/FileNotFoundException
    //   120	124	126	java/lang/Exception
    //   38	57	133	finally
    //   140	144	146	java/lang/Exception
    //   59	70	154	finally
    //   72	76	154	finally
    //   78	82	154	finally
    //   112	116	154	finally
    //   59	70	158	java/io/FileNotFoundException
    //   72	76	158	java/io/FileNotFoundException
    //   78	82	158	java/io/FileNotFoundException
    //   0	9	164	java/lang/OutOfMemoryError
    //   13	33	164	java/lang/OutOfMemoryError
    //   33	38	164	java/lang/OutOfMemoryError
    //   86	90	164	java/lang/OutOfMemoryError
    //   97	101	164	java/lang/OutOfMemoryError
    //   120	124	164	java/lang/OutOfMemoryError
    //   127	131	164	java/lang/OutOfMemoryError
    //   140	144	164	java/lang/OutOfMemoryError
    //   144	146	164	java/lang/OutOfMemoryError
    //   147	151	164	java/lang/OutOfMemoryError
  }
  
  private int Lo()
  {
    int i = 1;
    if ((this.bYf == 383) || (this.bYf == 640)) {
      if (this.bYf == 640) {
        i = 2;
      }
    }
    while (apsv.f(this.coD, this.mTmpFilePath, this.bYf, this.bYf)) {
      try
      {
        boolean bool = akyr.a(this.coD, this.mTmpFilePath, true, "", i);
        if (!bool) {
          break;
        }
        return 0;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return -2;
      }
    }
    return -1;
  }
  
  public static TroopFileThumbnailGenTask a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, String paramString, a parama)
  {
    if (paramLong == 0L)
    {
      apef.b.e("TroopFileThumbnailGenTask", apef.b.USR, "getTask. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      apef.b.e("TroopFileThumbnailGenTask", apef.b.USR, "getTask. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      apef.b.e("TroopFileThumbnailGenTask", apef.b.USR, "getTask. item.id=null");
      return null;
    }
    if (paramInt == 0)
    {
      apef.b.e("TroopFileThumbnailGenTask", apef.b.USR, "getTask. nThumbSize=0");
      return null;
    }
    if ((TextUtils.isEmpty(paramString)) && (TextUtils.isEmpty(paramItem.LocalFile)))
    {
      apef.b.e("TroopFileThumbnailGenTask", apef.b.USR, "getTask. localfilepath=null");
      return null;
    }
    return new TroopFileThumbnailGenTask(paramLong, paramItem, paramInt, paramString, parama);
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
      this.K.schedule(new TroopFileThumbnailGenTask.2(this), paramLong);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String Bf()
  {
    return this.coD;
  }
  
  public int Lm()
  {
    return this.bYf;
  }
  
  protected void bY(int paramInt, boolean paramBoolean)
  {
    if (this.bkn) {
      apef.b.w("TroopFileThumbnailGenTask", apef.b.USR, "[" + this.coy + "] onGenErr but had stop. errCode:" + paramInt);
    }
    do
    {
      return;
      dYY();
      this.bkn = true;
      if (!TextUtils.isEmpty(this.mTmpFilePath)) {
        aqhq.deleteFile(this.mTmpFilePath);
      }
      apfq.b(this.c, this.bYf);
      apef.b.e("TroopFileThumbnailGenTask", apef.b.USR, "[" + this.coy + "] onGenErr  errCode:" + paramInt + " passvieErr:" + paramBoolean);
      this.c.StatusUpdateTimeMs = 0L;
      apdw.b(this.mTroopUin, this.c);
    } while ((paramBoolean) || (this.a == null));
    this.a.a(getTaskId(), false, paramInt, this);
  }
  
  protected void cy(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.bkn)
    {
      apef.b.w("TroopFileThumbnailGenTask", apef.b.USR, "[" + this.coy + "] doSuc but had stop.");
      return;
    }
    dYY();
    this.bkn = true;
    if ((!paramBoolean1) && (!ahav.b(new VFSFile(this.mTmpFilePath), new VFSFile(this.mFilePath))))
    {
      apef.b.e("TroopFileThumbnailGenTask", apef.b.USR, "[" + this.coy + "] renameFile fail  mFilePath:" + this.mFilePath);
      if (aqhq.fileExistsAndNotEmpty(this.mFilePath))
      {
        bY(apue.a.dWl, false);
        return;
      }
    }
    dZl();
    apef.b.i("TroopFileThumbnailGenTask", apef.b.USR, "[" + this.coy + "] onGenSuc  mFilePath:" + this.mFilePath + " bHit:" + paramBoolean1 + " bPassiveEnd:" + paramBoolean2);
    if (!paramBoolean1) {
      this.c.StatusUpdateTimeMs = 0L;
    }
    Object localObject1;
    if (ahwy.a().aom()) {
      if (this.coD.equalsIgnoreCase(this.c.LocalFile)) {
        localObject1 = new File(this.mFilePath);
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = ahwo.a(BaseApplicationImpl.getContext(), (File)localObject1);
        if (localObject1 != null)
        {
          this.c.strQRUrl = ((StringBuilder)((Pair)localObject1).first).toString();
          if (QLog.isDevelopLevel()) {
            QLog.i("IMG_FILE_QR", 1, "TroopFIleThumbGenTask success:" + this.c.strQRUrl);
          }
          apdw.a(this.mTroopUin, this.c);
          apdw.b(this.mTroopUin, this.c);
          if ((paramBoolean2) || (this.a == null)) {
            break;
          }
          this.a.a(getTaskId(), true, 0, this);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.i("IMG_FILE_QR", 2, "JumpShareUtils.getQRCodeResult crash");
        }
        Object localObject2 = null;
        continue;
        if (ahwo.ciI)
        {
          this.c.strQRUrl = null;
          continue;
        }
        this.c.strQRUrl = "";
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.i("IMG_FILE", 1, "choushane false!");
      }
    }
  }
  
  protected void dZh()
  {
    if ((!TextUtils.isEmpty(this.mFileDir)) && (!TextUtils.isEmpty(this.coz))) {
      return;
    }
    this.mFileDir = apfq.Bg();
    this.coz = this.mFileDir;
  }
  
  public void dZk()
  {
    apef.b.i("TroopFileThumbnailGenTask", apef.b.USR, "[" + this.coy + "] passiveStart.");
    this.bkn = false;
    lL(90000L);
  }
  
  protected void dZl()
  {
    apfq.b(this.c, this.bYf);
    apfq.a(this.mTroopUin, this.c, this.bYf, this.mFilePath);
  }
  
  public String getTaskId()
  {
    return this.coy;
  }
  
  public String getThumbPath()
  {
    return this.mFilePath;
  }
  
  public void run()
  {
    if (this.bkn)
    {
      apef.b.w("TroopFileThumbnailGenTask", apef.b.USR, "[" + this.coy + "] run genThumb. but had stop");
      return;
    }
    dZh();
    this.mFilePath = this.c.getThumbnailFile(this.mTroopUin, this.bYf);
    this.mTmpFilePath = (this.mFilePath + ".ttmp");
    apef.b.i("TroopFileThumbnailGenTask", apef.b.USR, "[" + this.coy + "] run genThumb. mTmpFilePath:" + this.mTmpFilePath + " thumbPath:" + this.mFilePath);
    if (aqhq.fileExistsAndNotEmpty(this.mFilePath))
    {
      apef.b.w("TroopFileThumbnailGenTask", apef.b.USR, "[" + this.coy + "] thumb had exsited");
      cy(true, false);
      return;
    }
    if (!aqhq.fileExistsAndNotEmpty(this.coD))
    {
      apef.b.w("TroopFileThumbnailGenTask", apef.b.USR, "[" + this.coy + "] origfile is no exsit");
      bY(-111, false);
      return;
    }
    aqhq.deleteFile(this.mTmpFilePath);
    VFSFile localVFSFile = new VFSFile(this.mTmpFilePath);
    for (;;)
    {
      try
      {
        localVFSFile.createNewFile();
        if (this.cQk)
        {
          i = Ln();
          if (i == 0) {
            break;
          }
          bY(i, false);
          return;
        }
      }
      catch (IOException localIOException)
      {
        bY(-1, false);
        return;
      }
      int i = Lo();
    }
    cy(false, false);
  }
  
  public boolean start()
  {
    this.bkn = false;
    lL(90000L);
    apef.b.i("TroopFileThumbnailGenTask", apef.b.USR, "[" + this.coy + "] start.");
    ThreadManager.post(this, 5, null, true);
    return true;
  }
  
  public void stop()
  {
    if (this.bkn)
    {
      apef.b.i("TroopFileThumbnailGenTask", apef.b.USR, "[" + this.coy + "] stop. but had stoped");
      return;
    }
    apef.b.i("TroopFileThumbnailGenTask", apef.b.USR, "[" + this.coy + "] stop.");
    dYY();
    this.bkn = true;
    apfq.b(this.c, this.bYf);
    if (!TextUtils.isEmpty(this.mTmpFilePath)) {
      aqhq.deleteFile(this.mTmpFilePath);
    }
    this.c.StatusUpdateTimeMs = 0L;
    apdw.b(this.mTroopUin, this.c);
  }
  
  public void w(boolean paramBoolean, int paramInt, String paramString)
  {
    ThreadManager.post(new TroopFileThumbnailGenTask.1(this, paramBoolean, paramInt, paramString), 5, null, true);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, boolean paramBoolean, int paramInt, TroopFileThumbnailGenTask paramTroopFileThumbnailGenTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailGenTask
 * JD-Core Version:    0.7.0.1
 */