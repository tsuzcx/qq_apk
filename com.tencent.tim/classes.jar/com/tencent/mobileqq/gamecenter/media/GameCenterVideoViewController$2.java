package com.tencent.mobileqq.gamecenter.media;

import acfp;
import aqiw;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.widget.QQToast;

class GameCenterVideoViewController$2
  implements Runnable
{
  GameCenterVideoViewController$2(GameCenterVideoViewController paramGameCenterVideoViewController) {}
  
  public void run()
  {
    String str2 = acfp.m(2131706722);
    String str1 = str2;
    if (aqiw.isNetworkAvailable(this.this$0.getContext()))
    {
      str1 = str2;
      if (GameCenterVideoViewController.a(this.this$0).type == 1) {
        str1 = acfp.m(2131706729);
      }
    }
    QQToast.a(this.this$0.getContext(), 1, str1, 0).show(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.2
 * JD-Core Version:    0.7.0.1
 */