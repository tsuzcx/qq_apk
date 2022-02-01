package com.tencent.mobileqq.activity.aio.stickerrecommended;

import com.tencent.mobileqq.persistence.EntityManager;
import yhf;

public class StickerRecManager$7
  implements Runnable
{
  public StickerRecManager$7(yhf paramyhf, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.bZa == 1)
    {
      yhf.a(this.this$0).delete(StickerRecommendEntity.class.getSimpleName(), "usrMessage=? AND recommendType==1", new String[] { this.aXG });
      return;
    }
    yhf.a(this.this$0).delete(StickerRecommendEntity.class.getSimpleName(), "usrMessage=? AND recommendType!=1", new String[] { this.aXG });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.7
 * JD-Core Version:    0.7.0.1
 */