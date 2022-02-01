package dov.com.qq.im.capture.view;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import axwg;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class QIMProviderContainerView$7
  implements Runnable
{
  QIMProviderContainerView$7(QIMProviderContainerView paramQIMProviderContainerView) {}
  
  public void run()
  {
    int j = this.this$0.kg.getChildCount();
    if (QIMProviderContainerView.b(this.this$0))
    {
      Drawable[] arrayOfDrawable = new Drawable[j];
      int i = 0;
      while (i < j)
      {
        if (QIMProviderContainerView.a(this.this$0).ow(i))
        {
          int k = ((Integer)((ImageView)this.this$0.kg.getChildAt(i)).getTag()).intValue();
          arrayOfDrawable[i] = this.this$0.getResources().getDrawable(QIMProviderContainerView.a(this.this$0).lT(k));
        }
        i += 1;
      }
      ThreadManager.getUIHandler().post(new QIMProviderContainerView.7.1(this, j, arrayOfDrawable));
      QIMProviderContainerView.b(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMProviderContainerView.7
 * JD-Core Version:    0.7.0.1
 */