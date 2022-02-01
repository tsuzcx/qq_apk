package com.tencent.qqmail.attachment.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.ui.QMLoading;
import com.tencent.qqmail.view.imageview.QMGestureImageView;
import java.io.File;

class ImagePagerFragment$1$1$1$1
  implements Runnable
{
  ImagePagerFragment$1$1$1$1(ImagePagerFragment.1.1.1 param1, File paramFile) {}
  
  public void run()
  {
    Bitmap localBitmap = ImageUtil.memSafeScaleImage(this.val$file.getAbsolutePath(), 1, 1.0F);
    ImagePagerFragment.access$200(this.this$3.this$2.this$1.this$0).setVisibility(8);
    ImagePagerFragment.access$300(this.this$3.this$2.this$1.this$0).stop();
    ImagePagerFragment.access$400(this.this$3.this$2.this$1.this$0);
    ImagePagerFragment.access$502(this.this$3.this$2.this$1.this$0, new BitmapDrawable(this.this$3.this$2.this$1.this$0.getResources(), localBitmap));
    ImagePagerFragment.access$600(this.this$3.this$2.this$1.this$0).setImageDrawable(ImagePagerFragment.access$500(this.this$3.this$2.this$1.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ImagePagerFragment.1.1.1.1
 * JD-Core Version:    0.7.0.1
 */