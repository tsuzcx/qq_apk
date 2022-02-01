package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import aqhq;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import java.util.Map;

class ShortVideoRealItemBuilder$4
  implements Runnable
{
  ShortVideoRealItemBuilder$4(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder, String paramString) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.aUW))
    {
      if (ShortVideoRealItemBuilder.access$100().size() == 0) {
        RMVideoStateMgr.AS(this.aUW);
      }
      aqhq.cn(this.aUW);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */