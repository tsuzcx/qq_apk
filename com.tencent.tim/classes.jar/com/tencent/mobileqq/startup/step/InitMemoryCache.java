package com.tencent.mobileqq.startup.step;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.util.LruCache;
import android.support.v4.util.MQLruCache;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.commonsdk.cache.Sizeable;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import nov;
import npe;
import sxa;

public class InitMemoryCache
  extends Step
{
  private static volatile boolean sInited;
  
  protected boolean doStep()
  {
    int i = 4194304;
    if (sInited) {}
    do
    {
      long l;
      do
      {
        return true;
        sInited = true;
        sxa localsxa = sxa.a();
        QQHashMap.setManager(localsxa);
        QQConcurrentHashMap.setManager(localsxa);
        QQLruCache.setManager(localsxa);
        LruCache.setManager(localsxa);
        QLog.e("qiqili", 1, "InitMemoryCache BaseApplicationImpl.sProcessId =" + BaseApplicationImpl.sProcessId + "BaseApplicationImpl.processName=" + BaseApplicationImpl.processName);
        BaseApplicationImpl.sImageHashMap = new ConcurrentHashMap();
        if (BaseApplicationImpl.sProcessId == 1)
        {
          l = MemoryManager.eS() * 3L / 16L;
          BaseApplicationImpl.sImageCache = new a(Integer.valueOf((int)l));
          BaseApplicationImpl.sImageCacheSize = (int)l;
          return true;
        }
        if (BaseApplicationImpl.sProcessId == 5)
        {
          l = MemoryManager.eS() * 3L / 16L;
          BaseApplicationImpl.sImageCache = new a(Integer.valueOf((int)l));
          BaseApplicationImpl.sImageCacheSize = (int)l;
          return true;
        }
        if ((!BaseApplicationImpl.processName.endsWith(":peak")) && (!BaseApplicationImpl.processName.endsWith(":dataline")) && (!BaseApplicationImpl.processName.endsWith(":secmsg")) && (!BaseApplicationImpl.processName.endsWith(":dingdong")) && (!BaseApplicationImpl.processName.endsWith(":miniapp")) && (!BaseApplicationImpl.processName.endsWith(":troophomework")) && (!BaseApplicationImpl.processName.endsWith(":live"))) {
          break;
        }
        j = (int)(MemoryManager.eS() * 3L / 16L);
        if (j > 4194304) {
          i = j;
        }
        BaseApplicationImpl.sImageCache = new a(Integer.valueOf(i));
        BaseApplicationImpl.sImageCacheSize = j;
      } while (!QLog.isColorLevel());
      QLog.d("MemoryCache", 2, "memory size:" + j);
      return true;
      if ((BaseApplicationImpl.sProcessId == 7) || (BaseApplicationImpl.sProcessId == 2))
      {
        l = MemoryManager.eS() * 3L / 16L;
        BaseApplicationImpl.sImageCache = new a(Integer.valueOf((int)l));
        BaseApplicationImpl.sImageCacheSize = (int)l;
        return true;
      }
    } while (!BaseApplicationImpl.processName.endsWith(":video"));
    int j = (int)(MemoryManager.eS() / 16L);
    if (j > 4194304) {
      i = j;
    }
    BaseApplicationImpl.sImageCache = new a(Integer.valueOf(i));
    BaseApplicationImpl.sImageCacheSize = j;
    return true;
  }
  
  static class a
    extends MQLruCache<String, Object>
  {
    public a(Integer paramInteger)
    {
      super();
    }
    
    public Object a(String paramString, Object paramObject, byte paramByte)
    {
      Object localObject = paramObject;
      if ((paramObject instanceof nov)) {
        localObject = ((nov)paramObject).a();
      }
      return super.put(paramString, localObject, paramByte);
    }
    
    protected void a(boolean paramBoolean, String paramString, Object paramObject1, Object paramObject2)
    {
      if ((paramObject1 instanceof nov)) {
        ((nov)paramObject1).close();
      }
    }
    
    public void fY(String paramString, int paramInt) {}
    
    public Object put(String paramString, Object paramObject)
    {
      Object localObject = paramObject;
      if ((paramObject instanceof nov)) {
        localObject = ((nov)paramObject).a();
      }
      return super.put(paramString, localObject);
    }
    
    protected int sizeOfObj(String paramString, Object paramObject)
    {
      if ((paramObject instanceof Pair)) {
        return ((Integer)((Pair)paramObject).second).intValue();
      }
      if ((paramObject instanceof Bitmap))
      {
        paramString = (Bitmap)paramObject;
        return paramString.getRowBytes() * paramString.getHeight();
      }
      if ((paramObject instanceof BitmapDrawable))
      {
        paramObject = ((BitmapDrawable)paramObject).getBitmap();
        if (paramObject != null)
        {
          int i = paramObject.getRowBytes();
          return paramObject.getHeight() * i;
        }
      }
      else if ((paramObject instanceof nov))
      {
        paramObject = ((nov)paramObject).Q();
        if (paramObject != null) {
          return npe.getBitmapSize(paramObject);
        }
      }
      else if ((paramObject instanceof Sizeable))
      {
        return ((Sizeable)paramObject).getByteSize();
      }
      sxa.bI(paramString, sxa.bAc);
      return 204800;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitMemoryCache
 * JD-Core Version:    0.7.0.1
 */