package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.emoticon.EPRecommendTask;

public class GetEmoticonWhenNoFile
  extends AsyncStep
{
  protected int a()
  {
    new EPRecommendTask(this.a.a).execute(new String[] { "http://imgcache.qq.com/club/item/parcel/android_tab.json", "1" });
    new EPRecommendTask(this.a.a).execute(new String[] { "http://imgcache.qq.com/club/item/parcel/android_magictab.json", "2" });
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetEmoticonWhenNoFile
 * JD-Core Version:    0.7.0.1
 */