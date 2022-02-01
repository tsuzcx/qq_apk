package com.tencent.qqmail.nativepages;

import com.tencent.qqmail.popularize.PopularizeManager;
import java.util.ArrayList;

class NativeAdsHelper$1
  implements Runnable
{
  NativeAdsHelper$1(NativeAdsHelper paramNativeAdsHelper, ArrayList paramArrayList) {}
  
  public void run()
  {
    PopularizeManager.sharedInstance().updatePopularizeListIsRender(this.val$popularizeArrayList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.nativepages.NativeAdsHelper.1
 * JD-Core Version:    0.7.0.1
 */