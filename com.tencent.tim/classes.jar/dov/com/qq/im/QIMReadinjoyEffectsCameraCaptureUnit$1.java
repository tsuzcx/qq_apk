package dov.com.qq.im;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import awsv;
import kqg;
import wja;

public class QIMReadinjoyEffectsCameraCaptureUnit$1
  implements Runnable
{
  public QIMReadinjoyEffectsCameraCaptureUnit$1(awsv paramawsv, Activity paramActivity) {}
  
  public void run()
  {
    if (this.val$context != null)
    {
      BitmapDrawable localBitmapDrawable = kqg.a(this.val$context);
      if (localBitmapDrawable != null)
      {
        int i = wja.dp2px(36.0F, this.this$0.HK.getResources());
        localBitmapDrawable.setBounds(0, 0, i, i);
        this.val$context.runOnUiThread(new QIMReadinjoyEffectsCameraCaptureUnit.1.1(this, localBitmapDrawable));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.QIMReadinjoyEffectsCameraCaptureUnit.1
 * JD-Core Version:    0.7.0.1
 */