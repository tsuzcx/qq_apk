package com.tencent.mobileqq.nearby.guide;

import ajrs;
import android.os.Bundle;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import java.util.ArrayList;
import java.util.Iterator;

class NearbyGuideActivity$7
  implements Runnable
{
  NearbyGuideActivity$7(NearbyGuideActivity paramNearbyGuideActivity, ArrayList paramArrayList, ajrs paramajrs, Bundle paramBundle) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.yd != null) && (this.yd.size() > 0))
    {
      Iterator localIterator = this.yd.iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        PicInfo localPicInfo = new PicInfo();
        localPicInfo.photoId = localInteger.intValue();
        localArrayList.add(localPicInfo);
      }
    }
    this.d.a(this.val$bundle, localArrayList, null, true, true, true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.7
 * JD-Core Version:    0.7.0.1
 */