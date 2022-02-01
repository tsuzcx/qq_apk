package com.tencent.qqmail.activity.media;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.view.imageview.QMGestureImageView;

class ImageCropActivity$2
  implements View.OnClickListener
{
  ImageCropActivity$2(ImageCropActivity paramImageCropActivity) {}
  
  public void onClick(View paramView)
  {
    try
    {
      int i = this.this$0.getResources().getDimensionPixelSize(2131297042);
      int j = ImageCropActivity.access$000(this.this$0).getMeasuredWidth();
      int k = ImageCropActivity.access$000(this.this$0).getMeasuredHeight();
      Object localObject1 = Bitmap.createBitmap(j, k, Bitmap.Config.ARGB_8888);
      Object localObject2 = new Canvas((Bitmap)localObject1);
      ((Canvas)localObject2).drawColor(0);
      ImageCropActivity.access$000(this.this$0).draw((Canvas)localObject2);
      localObject2 = Bitmap.createBitmap(160, 160, Bitmap.Config.ARGB_8888);
      new Canvas((Bitmap)localObject2).drawBitmap((Bitmap)localObject1, new Rect((j - i) / 2, (k - i) / 2, (j - i) / 2 + i, i + (k - i) / 2), new Rect(0, 0, 160, 160), null);
      ((Bitmap)localObject1).recycle();
      ImageCropActivity.setCropImage((Bitmap)localObject2);
      localObject1 = new Intent();
      this.this$0.setResult(-1, (Intent)localObject1);
      this.this$0.finish();
      this.this$0.overridePendingTransition(2130772423, 2130772402);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        QMLog.log(5, "ImageCropActivity", "crop image OOE");
        this.this$0.setResult(0, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImageCropActivity.2
 * JD-Core Version:    0.7.0.1
 */