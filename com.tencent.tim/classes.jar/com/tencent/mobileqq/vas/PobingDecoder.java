package com.tencent.mobileqq.vas;

import ajdq;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import aqhq;
import aqqq;
import aqsr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.Sizeable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class PobingDecoder
  implements aqqq, Runnable
{
  private static final HashMap<Integer, Integer> pf = new PobingDecoder.1();
  WeakReference<ajdq<a>> callbackRef;
  int id;
  HashMap<Integer, String> jl;
  
  public PobingDecoder(int paramInt, HashMap<Integer, String> paramHashMap, ajdq<a> paramajdq)
  {
    this.id = paramInt;
    this.jl = paramHashMap;
    this.callbackRef = new WeakReference(paramajdq);
    ThreadManagerV2.excute(this, 64, null, false);
  }
  
  private static int ks(int paramInt)
  {
    Integer localInteger = (Integer)pf.get(Integer.valueOf(paramInt));
    if (localInteger == null) {
      return -16777216;
    }
    return localInteger.intValue();
  }
  
  public void onCompleted(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      process(true);
      return;
    }
    QLog.e("PobingDecoder", 1, "onCompleted: " + paramString1 + " error:" + paramInt1 + ", " + paramInt2);
  }
  
  public void onProgress(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3) {}
  
  public void process(boolean paramBoolean)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    a locala = new a();
    aqsr localaqsr = aqsr.a;
    if (!localaqsr.i(((QQAppInterface)localObject).getApp(), this.id))
    {
      if (!paramBoolean)
      {
        localaqsr.download((QQAppInterface)localObject, this.id, this, false);
        return;
      }
      QLog.e("PobingDecoder", 1, "bitmaps still missing after download: " + this.id);
      return;
    }
    Iterator localIterator = this.jl.entrySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label197;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Bitmap localBitmap = localaqsr.a(((QQAppInterface)localObject).getApp(), this.id, (String)localEntry.getValue());
      if (localBitmap == null)
      {
        if (this.id != 2000) {
          break;
        }
        if (!"addgroup_preview.png".equals(localEntry.getValue())) {
          continue;
        }
        return;
      }
      locala.pg.put(localEntry.getKey(), localBitmap);
    }
    label197:
    localObject = aqhq.readFileContent(new File(localaqsr.getDir(((QQAppInterface)localObject).getApp(), localaqsr.getScid(this.id)), "config.json"));
    try
    {
      locala.textColor = Color.parseColor(new JSONObject((String)localObject).getString("textColor"));
      locala.id = this.id;
      ThreadManagerV2.getUIHandlerV2().post(new PobingDecoder.2(this, locala));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        locala.textColor = ks(this.id);
        QLog.e("PobingDecoder", 1, "content:" + (String)localObject, localException);
      }
    }
  }
  
  public void run()
  {
    process(false);
  }
  
  public static class a
    implements Sizeable
  {
    public int id;
    public HashMap<Integer, Bitmap> pg = new HashMap();
    public int textColor;
    
    public int getByteSize()
    {
      Iterator localIterator = this.pg.values().iterator();
      for (int i = 0; localIterator.hasNext(); i = Utils.getBitmapSize((Bitmap)localIterator.next()) + i) {}
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.PobingDecoder
 * JD-Core Version:    0.7.0.1
 */