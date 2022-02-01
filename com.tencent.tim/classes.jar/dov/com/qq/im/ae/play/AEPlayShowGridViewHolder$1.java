package dov.com.qq.im.ae.play;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import aqnm;
import axgq;
import com.tencent.qphone.base.util.QLog;

public class AEPlayShowGridViewHolder$1
  implements Runnable
{
  public AEPlayShowGridViewHolder$1(axgq paramaxgq, View paramView) {}
  
  public void run()
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.val$itemView.getLayoutParams();
    ViewGroup localViewGroup = (ViewGroup)this.val$itemView.getParent();
    int k = aqnm.dip2px(10.0F);
    int j = aqnm.getScreenWidth() - k * 2;
    int i = localViewGroup.getHeight() - k;
    if (j * 16 / 9 > i) {
      j = i * 9 / 16;
    }
    for (;;)
    {
      localMarginLayoutParams.width = j;
      localMarginLayoutParams.height = i;
      k += (localViewGroup.getWidth() - j - k * 2) / 2;
      if (QLog.isDevelopLevel()) {
        QLog.d("AEPlayShowGridViewHolder", 4, "one itemHeight " + i + " itemWidth: " + j + " screenWidth: " + aqnm.getScreenWidth() + " viewWidth: " + localViewGroup.getWidth() + " padding: " + k);
      }
      this.val$itemView.setLayoutParams(localMarginLayoutParams);
      localViewGroup.setPadding(k, 0, 0, 0);
      return;
      i = j * 16 / 9;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowGridViewHolder.1
 * JD-Core Version:    0.7.0.1
 */