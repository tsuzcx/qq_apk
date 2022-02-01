package dov.com.qq.im;

import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import awrq;
import wja;

class QIMCameraCaptureUnit$1$1
  implements Runnable
{
  QIMCameraCaptureUnit$1$1(QIMCameraCaptureUnit.1 param1) {}
  
  public void run()
  {
    if ((this.a.this$0.er != null) && (this.a.this$0.HK != null))
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(this.a.this$0.HK.getResources(), this.a.this$0.er);
      int i = wja.dp2px(36.0F, this.a.this$0.HK.getResources());
      localBitmapDrawable.setBounds(0, 0, i, i);
      this.a.this$0.HK.setImageDrawable(localBitmapDrawable);
      this.a.this$0.HK.setVisibility(0);
      this.a.this$0.HK.setEnabled(true);
      return;
    }
    this.a.this$0.HK.setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureUnit.1.1
 * JD-Core Version:    0.7.0.1
 */