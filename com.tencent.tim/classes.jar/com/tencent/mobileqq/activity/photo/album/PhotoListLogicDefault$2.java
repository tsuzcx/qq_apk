package com.tencent.mobileqq.activity.photo.album;

import android.content.Intent;
import anot;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import java.util.ArrayList;
import ztu;
import ztv;

public class PhotoListLogicDefault$2
  implements Runnable
{
  public PhotoListLogicDefault$2(ztv paramztv, boolean paramBoolean, Intent paramIntent, ArrayList paramArrayList, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.btt) {
      PhotoUtils.a(this.this$0.mActivity, this.val$intent, this.rP, this.this$0.a.hw, this.this$0.mPhotoCommonData.currentQualityType, false);
    }
    for (;;)
    {
      anot.a(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", this.lM, 0, this.aWv, this.aWw, "", "");
      anfr.akV = System.currentTimeMillis();
      return;
      PhotoUtils.a(this.this$0.mActivity, this.val$intent, this.rP, this.this$0.mPhotoCommonData.currentQualityType, this.this$0.a.bjL);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault.2
 * JD-Core Version:    0.7.0.1
 */