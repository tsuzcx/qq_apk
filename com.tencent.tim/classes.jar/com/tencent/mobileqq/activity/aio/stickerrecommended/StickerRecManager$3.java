package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.util.Base64;
import aurp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import yhf;

public class StickerRecManager$3
  implements Runnable
{
  public StickerRecManager$3(yhf paramyhf, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, int paramInt, String paramString3) {}
  
  public void run()
  {
    if (yhf.a(this.this$0) != null) {
      try
      {
        yhf.a(this.this$0, this.bmF, this.this$0.hE(this.aXL));
        Object localObject1 = (StickerRecommendEntity)yhf.a(this.this$0).find(StickerRecommendEntity.class, "usrMessage=? AND recommendType!=1", new String[] { this.aXG });
        if (localObject1 == null) {
          if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "entity is null");
          }
        }
        Object localObject2;
        while ((localObject1 != null) && (System.currentTimeMillis() - ((StickerRecommendEntity)localObject1).cachedTime < 86400000L))
        {
          localObject1 = Base64.decode(((StickerRecommendEntity)localObject1).recList, 0);
          localObject2 = (StickerRecommendSortEntity)yhf.a(this.this$0).find(StickerRecommendSortEntity.class, "usrMessage=? AND recommendType!=1", new String[] { this.aXG });
          if (localObject2 != null) {
            ((StickerRecommendSortEntity)localObject2).convertToList();
          }
          yhf.a(this.this$0, (byte[])localObject1, this.aXG, "cache", this.bmG, (StickerRecommendSortEntity)localObject2, 0);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "cache Time : " + (System.currentTimeMillis() - ((StickerRecommendEntity)localObject1).cachedTime));
          }
        }
        int j;
        ArrayList localArrayList;
        String str;
        int i;
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("StickerRecManager", 2, aurp.getStackTraceAsString(localException));
          return;
          yhf.a(this.this$0).delete(StickerRecommendEntity.class.getSimpleName(), "usrMessage=? AND recommendType!=1", new String[] { this.aXG });
          j = yhf.a(this.this$0, this.ber);
          localArrayList = new ArrayList();
          localArrayList.add(this.aXG);
          localObject2 = this.this$0;
          str = yhf.a(this.this$0).getCurrentUin();
          if (this.bmG) {}
          for (i = 4;; i = 3)
          {
            ((yhf)localObject2).a(str, i, j, this.Lw, localArrayList);
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.3
 * JD-Core Version:    0.7.0.1
 */