package dov.com.qq.im.capture.view;

import android.widget.LinearLayout;
import axwg;
import ayva;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import mqq.os.MqqHandler;

class QIMProviderContainerView$6
  implements Runnable
{
  QIMProviderContainerView$6(QIMProviderContainerView paramQIMProviderContainerView, RedDotImageView paramRedDotImageView) {}
  
  public void run()
  {
    boolean bool2 = false;
    int j = this.this$0.kg.getChildCount();
    ayva.dKj();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (QIMProviderContainerView.a(this.this$0).ow(i)) {
          bool1 = true;
        }
      }
      else
      {
        ThreadManager.getUIHandler().post(new QIMProviderContainerView.6.1(this, bool1));
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMProviderContainerView.6
 * JD-Core Version:    0.7.0.1
 */