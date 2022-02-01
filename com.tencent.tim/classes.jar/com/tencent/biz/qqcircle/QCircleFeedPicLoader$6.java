package com.tencent.biz.qqcircle;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

class QCircleFeedPicLoader$6
  implements Runnable
{
  QCircleFeedPicLoader$6(QCircleFeedPicLoader paramQCircleFeedPicLoader, QCircleFeedPicLoader.b paramb, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.a.isValid())
    {
      this.a.j().setImageDrawable(null);
      this.a.j().setImageDrawable(new BitmapDrawable(this.val$bitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCircleFeedPicLoader.6
 * JD-Core Version:    0.7.0.1
 */