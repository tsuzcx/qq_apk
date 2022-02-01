package com.tencent.mobileqq.activity.photo.album;

import android.content.Intent;
import anot;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import java.util.ArrayList;
import zud;
import zug;

public class PhotoPreviewLogicDefault$5
  implements Runnable
{
  public PhotoPreviewLogicDefault$5(zug paramzug, boolean paramBoolean, Intent paramIntent, ArrayList paramArrayList, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.btt)
    {
      PhotoUtils.a(this.this$0.mActivity, this.val$intent, this.rQ, this.this$0.a.hA, this.this$0.mPhotoCommonData.currentQualityType, true);
      ((NewPhotoPreviewActivity)this.this$0.mActivity).setResult(-1);
      ((NewPhotoPreviewActivity)this.this$0.mActivity).finish();
    }
    for (;;)
    {
      anot.a(null, "CliOper", "", "", "0X8009AB1", "0X8009AB1", this.cfn, 0, this.aWv, this.aWw, "", "");
      anfr.akV = System.currentTimeMillis();
      return;
      PhotoUtils.a(this.this$0.mActivity, this.val$intent, this.rQ, this.this$0.mPhotoCommonData.currentQualityType, this.this$0.a.bjL);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicDefault.5
 * JD-Core Version:    0.7.0.1
 */