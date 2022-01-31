package com.tencent.token.ui.gallery;

import android.content.res.Resources;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.token.ui.qqpim.a;

class d
  implements Runnable
{
  d(c paramc) {}
  
  public void run()
  {
    GalleryActivity.access$000(this.a.a).setText(this.a.a.getResources().getText(2131231060));
    Toast.makeText(this.a.a, this.a.a.getResources().getText(2131231068), 0).show();
    a.a(this.a.a, GalleryActivity.access$300(this.a.a));
    GalleryActivity.access$402(this.a.a, true);
    GalleryActivity.access$000(this.a.a).setVisibility(0);
    GalleryActivity.access$100(this.a.a).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.gallery.d
 * JD-Core Version:    0.7.0.1
 */