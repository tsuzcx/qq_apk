package com.tencent.qqmail.attachment.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView.ScaleType;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMLoading;
import com.tencent.qqmail.view.imageview.QMGestureImageView;
import java.io.File;

class ImagePagerFragment$5$2
  implements Runnable
{
  ImagePagerFragment$5$2(ImagePagerFragment.5 param5, File paramFile) {}
  
  public void run()
  {
    Bitmap localBitmap = ImageUtil.memSafeScaleImage(this.val$file.getAbsolutePath(), 1, 1.0F);
    String str = this.val$file.getAbsolutePath();
    if (ImagePagerFragment.access$1100(this.this$1.this$0))
    {
      if (localBitmap != null)
      {
        ImagePagerFragment.access$200(this.this$1.this$0).setVisibility(8);
        ImagePagerFragment.access$300(this.this$1.this$0).stop();
        ImagePagerFragment.access$400(this.this$1.this$0);
        ImagePagerFragment.access$502(this.this$1.this$0, new BitmapDrawable(this.this$1.this$0.getResources(), localBitmap));
        ImagePagerFragment.access$600(this.this$1.this$0).setImageDrawable(ImagePagerFragment.access$500(this.this$1.this$0));
        if ((localBitmap.getHeight() * 2.0F < ImagePagerFragment.access$200(this.this$1.this$0).getHeight()) && (localBitmap.getWidth() * 1.8F < ImagePagerFragment.access$200(this.this$1.this$0).getWidth()))
        {
          float f1 = ImagePagerFragment.access$200(this.this$1.this$0).getWidth() / localBitmap.getWidth();
          float f2 = ImagePagerFragment.access$200(this.this$1.this$0).getHeight() / localBitmap.getHeight();
          ImagePagerFragment.access$600(this.this$1.this$0).setScaleType(ImageView.ScaleType.CENTER);
          ImagePagerFragment.access$600(this.this$1.this$0).setFactorWidth(f1);
          ImagePagerFragment.access$600(this.this$1.this$0).setFactorHeight(f2);
        }
        Threads.runInBackground(new ImagePagerFragment.5.2.1(this, str));
      }
      ImagePagerFragment.access$1200(this.this$1.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ImagePagerFragment.5.2
 * JD-Core Version:    0.7.0.1
 */