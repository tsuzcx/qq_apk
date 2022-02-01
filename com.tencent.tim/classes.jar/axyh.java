import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.cropvideo.CropVideoActivity;
import dov.com.qq.im.cropvideo.CropVideoActivity.a;

public class axyh
  extends Handler
{
  public axyh(CropVideoActivity paramCropVideoActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
      do
      {
        return;
        postDelayed(this.this$0.runnable, 1000L);
        CropVideoActivity.a(this.this$0).setProgress(paramMessage.arg1);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("CropVideoActivity", 2, "crop video begin");
        }
        if ((CropVideoActivity.a(this.this$0) >= CropVideoActivity.b(this.this$0)) && (CropVideoActivity.b(this.this$0) >= 0L))
        {
          if (QLog.isColorLevel()) {
            QLog.e("CropVideoActivity", 2, "startCropVideo illegal time!");
          }
          QQToast.a(this.this$0.getApplicationContext(), acfp.m(2131704528), 1).show();
          return;
        }
      } while (CropVideoActivity.a(this.this$0, CropVideoActivity.a(this.this$0)) != 0);
      if (Build.VERSION.SDK_INT >= 18) {
        CropVideoActivity.a.a(CropVideoActivity.a(this.this$0), CropVideoActivity.b(this.this$0), CropVideoActivity.a(this.this$0), CropVideoActivity.b(this.this$0), CropVideoActivity.c(this.this$0), CropVideoActivity.d(this.this$0), CropVideoActivity.e(this.this$0), CropVideoActivity.f(this.this$0), CropVideoActivity.a(this.this$0), CropVideoActivity.b(this.this$0), new axyi(this));
      }
      for (;;)
      {
        this.this$0.showProgressDialog();
        return;
        CropVideoActivity.a(this.this$0, CropVideoActivity.a(this.this$0), CropVideoActivity.b(this.this$0), CropVideoActivity.a(this.this$0), CropVideoActivity.b(this.this$0), CropVideoActivity.c(this.this$0), CropVideoActivity.d(this.this$0), CropVideoActivity.a(this.this$0), CropVideoActivity.b(this.this$0));
      }
    case 3: 
      if (QLog.isColorLevel()) {
        QLog.d("CropVideoActivity", 2, "crop video success");
      }
      this.this$0.finish();
      return;
    case 4: 
      if (QLog.isColorLevel()) {
        QLog.d("CropVideoActivity", 2, "crop video fail");
      }
      QQToast.a(this.this$0.getApplicationContext(), 1, acfp.m(2131704526), 1).show();
      this.this$0.finish();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CropVideoActivity", 2, "crop video with ffmpeg");
    }
    CropVideoActivity.a(this.this$0, CropVideoActivity.a(this.this$0), CropVideoActivity.b(this.this$0), CropVideoActivity.a(this.this$0), CropVideoActivity.b(this.this$0), CropVideoActivity.c(this.this$0), CropVideoActivity.d(this.this$0), CropVideoActivity.a(this.this$0), CropVideoActivity.b(this.this$0));
    this.this$0.showProgressDialog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axyh
 * JD-Core Version:    0.7.0.1
 */