package com.tencent.token.ui.gallery;

import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.ui.qqpim.ProgressTextView;

class e
  implements Runnable
{
  e(c paramc, float paramFloat) {}
  
  public void run()
  {
    GalleryActivity.access$000(this.b.a).setVisibility(4);
    GalleryActivity.access$100(this.b.a).setVisibility(0);
    GalleryActivity.access$600(this.b.a).setTextWhiteLength(this.a);
    GalleryActivity.access$700(this.b.a).setProgress((int)(this.a * 100.0F));
    GalleryActivity.access$600(this.b.a).setText("下载中..." + (int)(this.a * 100.0F) + "%");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.gallery.e
 * JD-Core Version:    0.7.0.1
 */