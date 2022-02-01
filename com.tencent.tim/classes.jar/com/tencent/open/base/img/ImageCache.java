package com.tencent.open.base.img;

import android.text.TextUtils;
import aroi;
import arug;
import arwo;
import arwq;
import arwt;
import arwv;
import arxj;
import arxk;
import arxl;
import arxm;
import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ImageCache
{
  public static final String LOCAL_PATH = File.separator + "tencent" + File.separator + "qzone" + File.separator + ".AppCenterImgCache" + File.separator;
  protected static arxj a;
  protected static final String cCP = File.separator + "tencent" + File.separator + "qzone" + File.separator + "ImgCache2" + File.separator;
  protected static ThreadPoolExecutor o;
  
  static
  {
    try
    {
      File localFile = new File(arug.Dh() + cCP);
      if (localFile.exists()) {
        localFile.renameTo(new File(arug.Dh() + LOCAL_PATH));
      }
      a = new arxj(aroi.a().getContext());
      o = new ThreadPoolExecutor(3, 5, 120L, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static void Xo(String paramString)
  {
    try
    {
      new File(ci("app", paramString)).delete();
      return;
    }
    catch (Exception paramString)
    {
      arwt.e("ImageCache", "-->delete image file failed.", paramString);
    }
  }
  
  protected static void a(UpdateTask paramUpdateTask)
  {
    try
    {
      if (o.getQueue().contains(paramUpdateTask)) {
        arwt.v("ImageCache", "download task already exist, return. key= " + paramUpdateTask.key + " url=" + paramUpdateTask.url);
      }
      for (;;)
      {
        return;
        arwt.v("ImageCache", "add download task to queue. key= " + paramUpdateTask.key + " url=" + paramUpdateTask.url);
        o.execute(paramUpdateTask);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        arwt.e("ImageCache", "execute>>> ", localException);
        if (paramUpdateTask.a != null) {
          paramUpdateTask.a.bq(paramUpdateTask.key, paramUpdateTask.cCQ, paramUpdateTask.url);
        }
      }
    }
    finally {}
  }
  
  public static void a(String paramString1, String paramString2, arxk paramarxk)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    a(arwv.encodeHexStr(paramString2), paramString1, paramString2, paramarxk);
  }
  
  protected static void a(String paramString1, String paramString2, String paramString3, arxk paramarxk)
  {
    a(new UpdateTask(paramString1, paramString2, paramString3, paramarxk));
  }
  
  public static String ci(String paramString1, String paramString2)
  {
    return arug.Dh() + LOCAL_PATH + paramString1 + File.separator + arwq.getFileName(paramString2);
  }
  
  public static class UpdateTask
    implements Runnable
  {
    protected arxk a;
    protected String cCQ;
    protected String key;
    protected String url;
    
    public UpdateTask(String paramString1, String paramString2, String paramString3, arxk paramarxk)
    {
      this.key = paramString1;
      this.cCQ = paramString2;
      this.url = paramString3;
      this.a = paramarxk;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof UpdateTask)) {
        return false;
      }
      return this.key.equals(((UpdateTask)paramObject).key);
    }
    
    public void run()
    {
      for (;;)
      {
        arxm localarxm;
        try
        {
          if (((!arug.cC()) || (!arwo.isNetworkAvailable(aroi.a().getContext()))) && (this.a != null)) {
            this.a.bq(this.key, this.cCQ, this.url);
          }
          Object localObject1 = arug.Dh() + ImageCache.LOCAL_PATH + this.cCQ + File.separator + arwq.getFileName(this.url);
          arwt.d("downloadImage", "imgFilePath = " + (String)localObject1 + " | " + this.cCQ + " | " + arwq.getFileName(this.url) + " key=" + this.key + " url=" + this.url);
          if ((new File((String)localObject1).exists()) && (this.a != null))
          {
            this.a.bp(this.key, this.cCQ, (String)localObject1);
            this.a = null;
          }
          localarxm = ImageCache.a.a(this.key);
          if (localarxm == null)
          {
            arwt.v("ImageCache", "image not in db. key=" + this.key + " url=" + this.url);
            localObject1 = new arxm();
            ((arxm)localObject1).key = this.key;
            ((arxm)localObject1).url = this.url;
            ((arxm)localObject1).awL = 0L;
            ((arxm)localObject1).cCQ = this.cCQ;
            if (!arxl.a((arxm)localObject1)) {
              break;
            }
            arwt.w("ImageCache", "download image succ. " + this.url + " key=" + this.key);
            ImageCache.a.a((arxm)localObject1);
            if (this.a == null) {
              return;
            }
            this.a.bp(this.key, this.cCQ, arug.Dh() + ImageCache.LOCAL_PATH + this.cCQ + File.separator + arwq.getFileName(((arxm)localObject1).url));
            return;
          }
          localarxm.url = this.url;
          if (this.a != null)
          {
            arwt.v("ImageCache", "file is deleted." + this.url + " key=" + this.key);
            localarxm.awL = 0L;
            localObject1 = localarxm;
            continue;
          }
          l = System.currentTimeMillis();
        }
        catch (Exception localException)
        {
          arwt.w("ImageCache", "Download img warning", localException);
          return;
        }
        long l;
        Object localObject2 = localarxm;
        if (l > localarxm.updatetime)
        {
          localObject2 = localarxm;
          if (l < localarxm.awK + localarxm.updatetime)
          {
            arwt.v("ImageCache", "currenttime=" + System.currentTimeMillis() + "\nmaxage+updatetime=" + localarxm.awK + localarxm.updatetime + " key=" + this.key + " url=" + this.url);
            return;
          }
        }
      }
      arwt.w("ImageCache", "download failed." + this.url + " key=" + this.key);
      if (this.a != null) {
        this.a.bq(this.key, this.cCQ, this.url);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.base.img.ImageCache
 * JD-Core Version:    0.7.0.1
 */