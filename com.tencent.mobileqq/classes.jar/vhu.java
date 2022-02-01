import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.etrump.mixlayout.ETDecoration;
import com.etrump.mixlayout.ETEngine;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class vhu
  extends Handler
{
  vhu(vht paramvht, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    label282:
    label286:
    for (;;)
    {
      return;
      ETEngine localETEngine = vhy.a().c();
      if (localETEngine == null)
      {
        QLog.e("ETAnimator", 1, "ETAnimator get animation engine is null ");
        return;
      }
      vhv localvhv = (vhv)paramMessage.obj;
      if (localvhv != null)
      {
        vip localvip = (vip)vht.a(this.a).get();
        if (localvip != null)
        {
          Object localObject = localvip.a();
          if (localObject != null)
          {
            paramMessage = (Message)localObject;
            if (!((Bitmap)localObject).isRecycled()) {}
          }
          else
          {
            paramMessage = localvip.b();
            if (paramMessage == null) {
              continue;
            }
          }
          int i = paramMessage.getWidth();
          int j = paramMessage.getHeight();
          if ((vht.a() != null) && ((vht.a().getWidth() < i) || (vht.a().getHeight() < j)))
          {
            vht.a().recycle();
            vht.a(null);
          }
          if (vht.a() == null)
          {
            vht.a(Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888));
            localObject = localvhv.jdField_a_of_type_Vhz.a(localETEngine, false);
            if (localObject == null) {
              continue;
            }
            ((ETDecoration)localObject).gotoFrame(localvhv.jdField_a_of_type_Int);
            localvhv.jdField_a_of_type_Vhz.a(localETEngine, vht.a(), (ETDecoration)localObject, true);
            ((ETDecoration)localObject).deleteDescriptor(localETEngine);
            if (localvip == null) {
              break label282;
            }
          }
          for (boolean bool = localvip.a(localvhv, localETEngine, vht.a(), paramMessage);; bool = false)
          {
            if (!bool) {
              break label286;
            }
            vht.a(this.a).obtainMessage(1, localvhv).sendToTarget();
            return;
            vht.a().eraseColor(0);
            break;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vhu
 * JD-Core Version:    0.7.0.1
 */