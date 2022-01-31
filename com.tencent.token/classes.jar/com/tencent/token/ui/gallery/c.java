package com.tencent.token.ui.gallery;

import android.util.Log;
import com.tencent.token.dy;
import com.tmsdk.TMSDKContext;

class c
  implements dy
{
  c(GalleryActivity paramGalleryActivity) {}
  
  public void a()
  {
    GalleryActivity.access$202(this.a, true);
    this.a.runOnUiThread(new d(this));
    GalleryActivity.access$502(this.a, 0.0F);
    TMSDKContext.saveActionData(170017);
    Log.i("GalleryActivity", "onFinished: ");
  }
  
  public void a(float paramFloat)
  {
    Log.i("GalleryActivity", "onProgress: " + paramFloat);
    if ((paramFloat > 0.01D) && (paramFloat <= 1.0F) && (paramFloat > GalleryActivity.access$500(this.a)))
    {
      this.a.runOnUiThread(new e(this, paramFloat));
      GalleryActivity.access$502(this.a, paramFloat);
    }
  }
  
  public void b()
  {
    Log.i("GalleryActivity", "onPause: ");
    this.a.runOnUiThread(new f(this));
  }
  
  public void c()
  {
    this.a.runOnUiThread(new g(this));
    Log.i("GalleryActivity", "onCancel: ");
    GalleryActivity.access$502(this.a, 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.gallery.c
 * JD-Core Version:    0.7.0.1
 */