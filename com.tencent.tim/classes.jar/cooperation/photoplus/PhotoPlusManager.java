package cooperation.photoplus;

import acbn;
import alab;
import android.text.TextUtils;
import aqft;
import aqhq;
import aquz;
import aqva;
import aqvc;
import aurf;
import avfq;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import cooperation.photoplus.sticker.Sticker;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class PhotoPlusManager
  implements Manager
{
  public static final String cKs = acbn.SDCARD_PATH + "PhotoPlus/";
  private aurf b;
  private ConcurrentHashMap<String, aquz> db = new ConcurrentHashMap();
  private volatile boolean dmR;
  private volatile boolean dmS;
  private AppInterface mApp;
  private List<Sticker> mStickers;
  
  public PhotoPlusManager(AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPlusManager", 2, "[constructor]");
    }
    this.mApp = paramAppInterface;
    paramAppInterface = this.mApp.getEntityManagerFactory().createEntityManager();
    this.mStickers = paramAppInterface.query(Sticker.class, new Sticker().getTableName(), false, null, null, null, null, null, null);
    paramAppInterface.close();
    this.b = new aurf(ThreadManager.getFileThreadLooper(), null);
    Ww(false);
  }
  
  private void P(String paramString1, String paramString2, String paramString3)
  {
    aquz localaquz = (aquz)this.db.get(paramString2);
    if (localaquz != null)
    {
      if ((localaquz.getStatus() == 2) || (localaquz.getStatus() == 3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPlusManager", 2, "[download] duplicated " + paramString2);
        }
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPlusManager", 2, "[download] task status error, cancel it " + paramString2);
      }
      localaquz.cancel(true);
    }
    localaquz = new aquz(paramString1, new File(paramString2));
    localaquz.cWw = true;
    aqvc localaqvc = ((aqva)this.mApp.getManager(47)).a(1);
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPlusManager", 2, "[download] startDownload: " + paramString1 + " path=" + paramString2);
    }
    this.db.put(paramString2, localaquz);
    localaqvc.a(localaquz, new avfq(this, paramString2, paramString1, paramString3), null);
  }
  
  private void ot(List<Sticker> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPlusManager", 2, "[deleteOldResources] start");
    }
    Object localObject1 = new File(cKs);
    if (((File)localObject1).exists())
    {
      if (!((File)localObject1).isDirectory()) {
        break label465;
      }
      if (paramList != null) {
        break label53;
      }
      aqhq.cn(cKs);
    }
    label53:
    do
    {
      return;
      localObject1 = ((File)localObject1).listFiles();
    } while (localObject1 == null);
    int k = localObject1.length;
    int i = 0;
    label72:
    Object localObject2;
    if (i < k)
    {
      localObject2 = localObject1[i];
      if (!localObject2.isDirectory()) {
        break label420;
      }
      String str = localObject2.getName();
      Object localObject3 = paramList.iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          Sticker localSticker = (Sticker)((Iterator)localObject3).next();
          if (str.equals(localSticker.id))
          {
            int m = localSticker.version;
            str = localSticker.version + ".zip";
            localObject3 = localObject2.listFiles();
            if (localObject3 != null)
            {
              int n = localObject3.length;
              j = 0;
              if (j < n)
              {
                localSticker = localObject3[j];
                if (localSticker.isDirectory()) {
                  if (!localSticker.getName().equals(String.valueOf(m)))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("PhotoPlusManager", 2, "[updateStickerResource] delete old dir: " + localObject2.getName() + File.separator + localSticker.getName());
                    }
                    aqhq.cn(localSticker.getAbsolutePath());
                  }
                }
                for (;;)
                {
                  j += 1;
                  break;
                  if (!localSticker.getName().equals(str))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("PhotoPlusManager", 2, "[updateStickerResource] delete old file: " + localObject2.getName() + File.separator + localSticker.getName());
                    }
                    localSticker.delete();
                  }
                }
              }
            }
          }
        }
      }
    }
    for (int j = 1;; j = 0)
    {
      if (j == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPlusManager", 2, "[updateStickerResource] delete old dir: " + localObject2.getName());
        }
        aqhq.cn(localObject2.getAbsolutePath());
      }
      for (;;)
      {
        i += 1;
        break label72;
        break;
        label420:
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPlusManager", 2, "[updateStickerResource] delete error file: " + localObject2.getName());
        }
        localObject2.delete();
      }
      label465:
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPlusManager", 2, "[updateStickerResource] delete photo plus root directory");
      }
      ((File)localObject1).delete();
      return;
    }
  }
  
  public void Ww(boolean paramBoolean)
  {
    if (VersionUtils.isIceScreamSandwich()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPlusManager", 2, "[updateStickerResource] isDelete=" + paramBoolean);
    }
    this.b.post(new UpdateTask(this.mStickers, paramBoolean));
  }
  
  public void Wx(boolean paramBoolean)
  {
    this.dmR = paramBoolean;
  }
  
  public void Wy(boolean paramBoolean)
  {
    this.dmS = paramBoolean;
  }
  
  public List<Sticker> hy()
  {
    if (this.mStickers == null) {
      return null;
    }
    return new ArrayList(this.mStickers);
  }
  
  public void onDestroy() {}
  
  public void sv(String paramString)
  {
    String str = paramString.substring(0, paramString.indexOf(".zip")) + File.separator;
    try
    {
      aqhq.W(paramString, str, false);
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPlusManager", 2, "[unzip] success: " + paramString);
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPlusManager", 2, "[unzip]", localException);
        }
      } while (aqft.hE() <= 40960L);
      aqhq.deleteFile(paramString);
    }
  }
  
  /* Error */
  public boolean tk(String paramString)
  {
    // Byte code:
    //   0: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +29 -> 32
    //   6: ldc 64
    //   8: iconst_2
    //   9: new 28	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 331
    //   19: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aload_0
    //   33: getfield 280	cooperation/photoplus/PhotoPlusManager:dmR	Z
    //   36: ifeq +5 -> 41
    //   39: iconst_0
    //   40: ireturn
    //   41: aload_0
    //   42: aload_1
    //   43: invokestatic 335	cooperation/photoplus/sticker/Sticker:parse	(Ljava/lang/String;)Ljava/util/List;
    //   46: putfield 98	cooperation/photoplus/PhotoPlusManager:mStickers	Ljava/util/List;
    //   49: aload_0
    //   50: getfield 98	cooperation/photoplus/PhotoPlusManager:mStickers	Ljava/util/List;
    //   53: ifnonnull +40 -> 93
    //   56: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +12 -> 71
    //   62: ldc 64
    //   64: iconst_2
    //   65: ldc_w 337
    //   68: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   71: iconst_1
    //   72: ireturn
    //   73: astore_1
    //   74: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   77: ifeq -28 -> 49
    //   80: ldc 64
    //   82: iconst_2
    //   83: ldc_w 339
    //   86: aload_1
    //   87: invokestatic 342	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   90: goto -41 -> 49
    //   93: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +61 -> 157
    //   99: aload_0
    //   100: getfield 98	cooperation/photoplus/PhotoPlusManager:mStickers	Ljava/util/List;
    //   103: invokeinterface 210 1 0
    //   108: astore_1
    //   109: aload_1
    //   110: invokeinterface 215 1 0
    //   115: ifeq +42 -> 157
    //   118: aload_1
    //   119: invokeinterface 219 1 0
    //   124: checkcast 86	cooperation/photoplus/sticker/Sticker
    //   127: astore_2
    //   128: ldc 64
    //   130: iconst_2
    //   131: new 28	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   138: ldc_w 344
    //   141: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_2
    //   145: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: goto -45 -> 109
    //   157: aload_0
    //   158: getfield 72	cooperation/photoplus/PhotoPlusManager:mApp	Lcom/tencent/common/app/AppInterface;
    //   161: invokevirtual 78	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   164: invokevirtual 84	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   167: astore_2
    //   168: aload_2
    //   169: invokevirtual 351	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   172: astore_1
    //   173: aload_1
    //   174: invokevirtual 356	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   177: aload_2
    //   178: ldc 86
    //   180: invokevirtual 360	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   183: pop
    //   184: aload_0
    //   185: getfield 98	cooperation/photoplus/PhotoPlusManager:mStickers	Ljava/util/List;
    //   188: invokeinterface 210 1 0
    //   193: astore_3
    //   194: aload_3
    //   195: invokeinterface 215 1 0
    //   200: ifeq +51 -> 251
    //   203: aload_2
    //   204: aload_3
    //   205: invokeinterface 219 1 0
    //   210: checkcast 86	cooperation/photoplus/sticker/Sticker
    //   213: invokevirtual 364	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   216: goto -22 -> 194
    //   219: astore_3
    //   220: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +13 -> 236
    //   226: ldc 64
    //   228: iconst_2
    //   229: ldc_w 366
    //   232: aload_3
    //   233: invokestatic 342	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   236: aload_1
    //   237: invokevirtual 369	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   240: aload_2
    //   241: invokevirtual 101	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   244: aload_0
    //   245: iconst_1
    //   246: invokevirtual 118	cooperation/photoplus/PhotoPlusManager:Ww	(Z)V
    //   249: iconst_1
    //   250: ireturn
    //   251: aload_1
    //   252: invokevirtual 372	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   255: aload_1
    //   256: invokevirtual 369	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   259: goto -19 -> 240
    //   262: astore_2
    //   263: aload_1
    //   264: invokevirtual 369	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   267: aload_2
    //   268: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	PhotoPlusManager
    //   0	269	1	paramString	String
    //   127	114	2	localObject1	Object
    //   262	6	2	localObject2	Object
    //   193	12	3	localIterator	Iterator
    //   219	14	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   41	49	73	org/json/JSONException
    //   173	194	219	java/lang/Exception
    //   194	216	219	java/lang/Exception
    //   251	255	219	java/lang/Exception
    //   173	194	262	finally
    //   194	216	262	finally
    //   220	236	262	finally
    //   251	255	262	finally
  }
  
  class UpdateTask
    implements Runnable
  {
    private List<Sticker> Lz;
    private boolean isDelete;
    
    public UpdateTask(boolean paramBoolean)
    {
      if (paramBoolean != null) {
        this.Lz = new ArrayList(paramBoolean);
      }
      boolean bool;
      this.isDelete = bool;
    }
    
    public void run()
    {
      if (this.isDelete) {
        PhotoPlusManager.a(PhotoPlusManager.this, this.Lz);
      }
      do
      {
        return;
        if (this.Lz != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("PhotoPlusManager", 2, "[updateStickerResource] saved stickers = null");
      return;
      if (!aqhq.aCJ())
      {
        QLog.e("PhotoPlusManager", 1, "sdcard unavailable");
        return;
      }
      int i = 0;
      label58:
      Sticker localSticker;
      String str;
      if (i < this.Lz.size())
      {
        localSticker = (Sticker)this.Lz.get(i);
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPlusManager", 2, "[updateStickerResource] saved sticker:" + localSticker);
        }
        str = PhotoPlusManager.cKs + localSticker.getZipFilePath();
        if (new File(str).exists()) {
          break label177;
        }
        PhotoPlusManager.a(PhotoPlusManager.this, localSticker.url, str, localSticker.md5);
      }
      for (;;)
      {
        i += 1;
        break label58;
        break;
        label177:
        Object localObject2 = localSticker.getUnzippedDir();
        Object localObject1 = PhotoPlusManager.cKs + (String)localObject2 + localSticker.getImageFileName();
        localObject2 = PhotoPlusManager.cKs + (String)localObject2 + localSticker.getThumbImageFileName();
        localObject1 = new File((String)localObject1);
        localObject2 = new File((String)localObject2);
        if ((!((File)localObject1).exists()) || (!((File)localObject2).exists()))
        {
          if (QLog.isColorLevel()) {
            QLog.e("PhotoPlusManager", 2, "[updateStickerResource] zip exist but resource not exist:" + localSticker.getZipFilePath());
          }
          if (TextUtils.isEmpty(localSticker.md5))
          {
            PhotoPlusManager.this.sv(str);
          }
          else
          {
            localObject1 = alab.getFileMD5String(str);
            if (localSticker.md5.equalsIgnoreCase((String)localObject1))
            {
              PhotoPlusManager.this.sv(str);
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("PhotoPlusManager", 2, "[updateStickerResource] checkMd5 failed: " + str);
              }
              aqhq.deleteFile(str);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.photoplus.PhotoPlusManager
 * JD-Core Version:    0.7.0.1
 */