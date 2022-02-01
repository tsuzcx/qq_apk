package dov.com.qq.im.capture.view;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import axwg;

class QIMProviderContainerView$7$1
  implements Runnable
{
  QIMProviderContainerView$7$1(QIMProviderContainerView.7 param7, int paramInt, Drawable[] paramArrayOfDrawable) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.eID)
    {
      if (QIMProviderContainerView.a(this.a.this$0).ow(i))
      {
        Object localObject = (ImageView)this.a.this$0.kg.getChildAt(i);
        if (this.d[i] != null)
        {
          ((ImageView)localObject).setImageDrawable(this.d[i]);
          if ((((ImageView)localObject).getDrawable() instanceof AnimationDrawable))
          {
            localObject = (AnimationDrawable)((ImageView)localObject).getDrawable();
            ((AnimationDrawable)localObject).stop();
            ((AnimationDrawable)localObject).setOneShot(true);
            ((AnimationDrawable)localObject).start();
          }
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMProviderContainerView.7.1
 * JD-Core Version:    0.7.0.1
 */