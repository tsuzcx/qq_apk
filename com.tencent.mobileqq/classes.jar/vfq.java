import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.etrump.mixlayout.ETDecoration;
import com.etrump.mixlayout.ETEngine;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class vfq
  extends Handler
{
  vfq(vfp paramvfp, Looper paramLooper)
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
      ETEngine localETEngine = vfu.a().c();
      if (localETEngine == null)
      {
        QLog.e("ETAnimator", 1, "ETAnimator get animation engine is null ");
        return;
      }
      vfr localvfr = (vfr)paramMessage.obj;
      if (localvfr != null)
      {
        vgl localvgl = (vgl)vfp.a(this.a).get();
        if (localvgl != null)
        {
          Object localObject = localvgl.a();
          if (localObject != null)
          {
            paramMessage = (Message)localObject;
            if (!((Bitmap)localObject).isRecycled()) {}
          }
          else
          {
            paramMessage = localvgl.b();
            if (paramMessage == null) {
              continue;
            }
          }
          int i = paramMessage.getWidth();
          int j = paramMessage.getHeight();
          if ((vfp.a() != null) && ((vfp.a().getWidth() < i) || (vfp.a().getHeight() < j)))
          {
            vfp.a().recycle();
            vfp.a(null);
          }
          if (vfp.a() == null)
          {
            vfp.a(Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888));
            localObject = localvfr.jdField_a_of_type_Vfv.a(localETEngine, false);
            if (localObject == null) {
              continue;
            }
            ((ETDecoration)localObject).gotoFrame(localvfr.jdField_a_of_type_Int);
            localvfr.jdField_a_of_type_Vfv.a(localETEngine, vfp.a(), (ETDecoration)localObject, true);
            ((ETDecoration)localObject).deleteDescriptor(localETEngine);
            if (localvgl == null) {
              break label282;
            }
          }
          for (boolean bool = localvgl.a(localvfr, localETEngine, vfp.a(), paramMessage);; bool = false)
          {
            if (!bool) {
              break label286;
            }
            vfp.a(this.a).obtainMessage(1, localvfr).sendToTarget();
            return;
            vfp.a().eraseColor(0);
            break;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vfq
 * JD-Core Version:    0.7.0.1
 */