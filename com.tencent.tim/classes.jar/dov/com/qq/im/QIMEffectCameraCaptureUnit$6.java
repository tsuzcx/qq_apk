package dov.com.qq.im;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import aqcu;

class QIMEffectCameraCaptureUnit$6
  implements Runnable
{
  QIMEffectCameraCaptureUnit$6(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit, String paramString1, String paramString2) {}
  
  public void run()
  {
    if ((TextUtils.isEmpty(this.val$content)) && (TextUtils.isEmpty(this.val$path)))
    {
      QIMEffectCameraCaptureUnit.b(this.this$0);
      return;
    }
    if (!TextUtils.isEmpty(this.val$content))
    {
      QIMEffectCameraCaptureUnit.b(this.this$0).setText(this.val$content);
      QIMEffectCameraCaptureUnit.b(this.this$0).setVisibility(0);
    }
    if (!TextUtils.isEmpty(this.val$path)) {}
    try
    {
      Bitmap localBitmap = aqcu.decodeFile(this.val$path);
      QIMEffectCameraCaptureUnit.a(this.this$0).setImageBitmap(localBitmap);
      QIMEffectCameraCaptureUnit.a(this.this$0).setVisibility(0);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.QIMEffectCameraCaptureUnit.6
 * JD-Core Version:    0.7.0.1
 */