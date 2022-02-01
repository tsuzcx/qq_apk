package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import aqhq;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import java.util.Map;

class LightVideoItemBuilder$3
  implements Runnable
{
  public void run()
  {
    if (!TextUtils.isEmpty(this.aUW))
    {
      if (LightVideoItemBuilder.access$000().size() == 0) {
        RMVideoStateMgr.AS(this.aUW);
      }
      aqhq.cn(this.aUW);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.LightVideoItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */