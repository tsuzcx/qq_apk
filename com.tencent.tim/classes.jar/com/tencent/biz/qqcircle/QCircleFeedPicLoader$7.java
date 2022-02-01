package com.tencent.biz.qqcircle;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

class QCircleFeedPicLoader$7
  implements Runnable
{
  QCircleFeedPicLoader$7(QCircleFeedPicLoader paramQCircleFeedPicLoader, QCircleFeedPicLoader.b paramb, Drawable paramDrawable) {}
  
  public void run()
  {
    if (this.a.isValid())
    {
      this.a.j().setImageDrawable(null);
      this.a.j().setImageDrawable(this.val$drawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCircleFeedPicLoader.7
 * JD-Core Version:    0.7.0.1
 */