package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import wja;

class AIOLongShotHelper$6
  implements Runnable
{
  AIOLongShotHelper$6(AIOLongShotHelper paramAIOLongShotHelper) {}
  
  public void run()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mPlayGifImage = true;
    int i = wja.dp2px(248.0F, AIOLongShotHelper.a(this.this$0).mContext.getResources());
    int j = (int)(i * 420.0F / 472.0F);
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = j;
    URLDrawable.getDrawable("https://hbd.url.cn/myapp/qq_desk/mobileQQ_screenshoot/mobileQQ_screenshoot.gif", localURLDrawableOptions).downloadImediatly();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper.6
 * JD-Core Version:    0.7.0.1
 */