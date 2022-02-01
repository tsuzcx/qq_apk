package dov.com.qq.im.capture.view;

import android.content.res.Resources;
import com.tencent.mobileqq.troop.widget.RedDotImageView;

class QIMProviderContainerView$6$1
  implements Runnable
{
  QIMProviderContainerView$6$1(QIMProviderContainerView.6 param6, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.dxl) && (!this.a.g.rL()))
    {
      this.a.g.setReddotXOffsetDp(12);
      this.a.g.setReddotYOffsetDp(11);
      this.a.g.setRedDotDrawable(this.a.g.getResources().getDrawable(2130851401));
      this.a.g.showRedDot(true);
    }
    while ((this.dxl) || (!this.a.g.rL())) {
      return;
    }
    this.a.g.showRedDot(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMProviderContainerView.6.1
 * JD-Core Version:    0.7.0.1
 */