package com.tencent.mobileqq.profile;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.util.MQLruCache;
import android.util.Pair;
import aqep;
import aqft;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class VipProfileCardPreviewActivity$6
  implements Runnable
{
  VipProfileCardPreviewActivity$6(VipProfileCardPreviewActivity paramVipProfileCardPreviewActivity, List paramList, String paramString, int paramInt) {}
  
  public void run()
  {
    long l = SystemClock.elapsedRealtime();
    Bitmap localBitmap1 = this.this$0.j(aqep.I(this.this$0.mContext, (String)this.val$list.get(1)), true);
    Bitmap localBitmap2 = this.this$0.j(aqep.I(this.this$0.mContext, (String)this.val$list.get(0)), true);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "ANIMATION_SCROLL time " + (SystemClock.elapsedRealtime() - l));
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localBitmap1 != null)
    {
      localObject1 = localObject2;
      if (localBitmap2 != null)
      {
        localObject1 = new BitmapDrawable(this.this$0.getResources(), localBitmap1);
        localObject1 = new TransitionDrawable(new Drawable[] { new BitmapDrawable(this.this$0.getResources(), localBitmap2), localObject1 });
      }
    }
    if (localObject1 != null)
    {
      localObject1 = new Pair(localObject1, Integer.valueOf(aqft.getBitmapSize(localBitmap1) + aqft.getBitmapSize(localBitmap2)));
      BaseApplicationImpl.sImageCache.put(this.val$cacheKey, localObject1);
      localObject1 = this.this$0.mHandler.obtainMessage();
      ((Message)localObject1).what = 29;
      ((Message)localObject1).arg1 = this.val$pos;
      this.this$0.mHandler.sendMessage((Message)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardPreviewActivity.6
 * JD-Core Version:    0.7.0.1
 */