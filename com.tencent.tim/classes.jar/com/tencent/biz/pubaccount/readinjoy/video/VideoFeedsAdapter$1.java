package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.HashMap;
import kxm;
import mtg;

public class VideoFeedsAdapter$1
  implements Runnable
{
  public VideoFeedsAdapter$1(mtg parammtg, long paramLong) {}
  
  public void run()
  {
    if (mtg.a(this.this$0) != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_scrollInterval", String.valueOf(this.wO));
      kxm.e(mtg.a(this.this$0), kxm.getAccount(), true, localHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.1
 * JD-Core Version:    0.7.0.1
 */