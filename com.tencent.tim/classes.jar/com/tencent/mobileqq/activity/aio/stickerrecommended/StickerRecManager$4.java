package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.util.Base64;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import yhf;

public class StickerRecManager$4
  implements Runnable
{
  public void run()
  {
    Object localObject;
    if (yhf.a(this.this$0) != null)
    {
      localObject = (StickerRecommendEntity)yhf.a(this.this$0).find(StickerRecommendEntity.class, "usrMessage=? AND recommendType==1", new String[] { this.aXM });
      if (localObject != null) {
        break label140;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "entity is null");
      }
    }
    while ((localObject != null) && (System.currentTimeMillis() - ((StickerRecommendEntity)localObject).cachedTime < 86400000L))
    {
      localObject = Base64.decode(((StickerRecommendEntity)localObject).recList, 0);
      StickerRecommendSortEntity localStickerRecommendSortEntity = (StickerRecommendSortEntity)yhf.a(this.this$0).find(StickerRecommendSortEntity.class, "usrMessage=? AND recommendType==1", new String[] { this.aXM });
      if (localStickerRecommendSortEntity != null) {
        localStickerRecommendSortEntity.convertToList();
      }
      yhf.a(this.this$0, (byte[])localObject, this.aXM, "cache", false, localStickerRecommendSortEntity, 1);
      return;
      label140:
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "cache Time : " + (System.currentTimeMillis() - ((StickerRecommendEntity)localObject).cachedTime));
      }
    }
    yhf.a(this.this$0).delete(StickerRecommendEntity.class.getSimpleName(), "usrMessage=? AND recommendType==1", new String[] { this.aXM });
    int i = yhf.a(this.this$0, this.ber);
    this.this$0.a(yhf.a(this.this$0).getCurrentUin(), 3, i, this.Lw, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.4
 * JD-Core Version:    0.7.0.1
 */