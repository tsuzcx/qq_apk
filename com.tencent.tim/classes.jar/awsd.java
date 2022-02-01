import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;

public class awsd
  extends Handler
{
  public awsd(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1000: 
      for (;;)
      {
        super.handleMessage(paramMessage);
        return;
        QIMEffectCameraCaptureUnit.d(this.this$0).setVisibility(8);
        if (((paramMessage.obj instanceof Boolean)) && (((Boolean)paramMessage.obj).booleanValue()))
        {
          QIMEffectCameraCaptureUnit.f(this.this$0, false);
          this.this$0.c.dLi();
        }
      }
    }
    boolean bool1;
    label104:
    boolean bool2;
    label134:
    Object localObject;
    if (paramMessage.arg1 == 1)
    {
      bool1 = true;
      if ((!this.this$0.drR) || (this.this$0.b.getCount() == 0) || (!bool1)) {
        break label234;
      }
      bool2 = true;
      localObject = this.this$0;
      if (!bool2) {
        break label240;
      }
      i = 0;
      label147:
      ((QIMEffectCameraCaptureUnit)localObject).acW(i);
      localObject = this.this$0.a;
      if (!bool1) {
        break label245;
      }
    }
    label234:
    label240:
    label245:
    for (int i = 0;; i = 4)
    {
      ((VideoFilterViewPager)localObject).setVisibility(i);
      this.this$0.a.setEnabled(bool1);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QIMEffectCameraCaptureUnit", 2, new Object[] { "checkEffectButton ", Boolean.valueOf(bool2), " filter So exists:", Boolean.valueOf(bool1) });
      break;
      bool1 = false;
      break label104;
      bool2 = false;
      break label134;
      i = 4;
      break label147;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awsd
 * JD-Core Version:    0.7.0.1
 */