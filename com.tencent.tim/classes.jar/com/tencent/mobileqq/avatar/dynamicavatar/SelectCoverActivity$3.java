package com.tencent.mobileqq.avatar.dynamicavatar;

import acfp;
import advr;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import java.io.File;

class SelectCoverActivity$3
  implements Runnable
{
  SelectCoverActivity$3(SelectCoverActivity paramSelectCoverActivity, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.this$0.aNl) {}
    do
    {
      do
      {
        do
        {
          return;
          this.this$0.aEu = this.this$0.c(this.eW);
        } while (this.this$0.aNl);
        if (TextUtils.isEmpty(this.this$0.aEu))
        {
          SelectCoverActivity.a(this.this$0, 2, acfp.m(2131714196), 0);
          return;
        }
        SelectCoverActivity.a(this.this$0, 0, acfp.m(2131714189), 0);
        if ((this.this$0.mSource != 1) && (this.this$0.mSource != 3)) {
          break;
        }
      } while ((TextUtils.isEmpty(this.this$0.a.bvJ)) || (!new File(this.this$0.a.bvJ).exists()) || (TextUtils.isEmpty(this.this$0.a.bvK)) || (!new File(this.this$0.a.bvK).exists()));
      SelectCoverActivity.b(this.this$0);
      return;
    } while (this.this$0.mSource != 2);
    Intent localIntent = this.this$0.getIntent();
    localIntent.putExtra("key_photo_file_path", this.this$0.aEu);
    localIntent.putExtra("key_video_duration", this.this$0.mVideoDuration);
    localIntent.putExtra("key_video_has_voice", this.this$0.bvN);
    localIntent.putExtra("key_camera_id", this.this$0.bvO);
    localIntent.putExtra("key_photo_selected_by_user", this.this$0.bRt);
    this.this$0.setResult(-1, localIntent);
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity.3
 * JD-Core Version:    0.7.0.1
 */