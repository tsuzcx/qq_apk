package com.tencent.mobileqq.activity.aio.stickerrecommended;

import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import yhf;

public class StickerRecManager$9
  implements Runnable
{
  public StickerRecManager$9(yhf paramyhf, List paramList) {}
  
  public void run()
  {
    Iterator localIterator = this.sD.iterator();
    while (localIterator.hasNext())
    {
      StickerRecCacheEntity localStickerRecCacheEntity1 = (StickerRecCacheEntity)localIterator.next();
      StickerRecCacheEntity localStickerRecCacheEntity2 = (StickerRecCacheEntity)yhf.a(this.this$0).find(StickerRecCacheEntity.class, "md5=?", new String[] { localStickerRecCacheEntity1.md5 });
      if (localStickerRecCacheEntity2 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecManager", 2, "old exist: fileName=" + localStickerRecCacheEntity2.md5 + " lastTime=" + localStickerRecCacheEntity2.lastTime);
        }
        localStickerRecCacheEntity2.lastTime = localStickerRecCacheEntity1.lastTime;
        yhf.a(this.this$0).update(localStickerRecCacheEntity2);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecManager", 2, "old not exist: fileName=" + localStickerRecCacheEntity1.md5 + " lastTime=" + localStickerRecCacheEntity1.lastTime);
        }
        yhf.a(this.this$0).persistOrReplace(localStickerRecCacheEntity1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.9
 * JD-Core Version:    0.7.0.1
 */