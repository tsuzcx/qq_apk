import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.etrump.mixlayout.ETDecoration;
import com.etrump.mixlayout.ETFont;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class vfs
  extends Handler
{
  WeakReference<vgl> a;
  
  vfs(vgl paramvgl, Looper paramLooper)
  {
    super(paramLooper);
    this.a = new WeakReference(paramvgl);
  }
  
  public void handleMessage(Message paramMessage)
  {
    vgl localvgl = (vgl)this.a.get();
    if (localvgl == null) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        paramMessage = vfr.a(localvgl);
      }
    } while (paramMessage == null);
    localvgl.jdField_a_of_type_Vfp.a(paramMessage);
    return;
    paramMessage = (vfr)paramMessage.obj;
    boolean bool;
    int i;
    if ((paramMessage != null) && (localvgl.b().equals(paramMessage.jdField_a_of_type_JavaLangCharSequence.toString())) && (localvgl.jdField_a_of_type_ComEtrumpMixlayoutETDecoration != null) && (localvgl.jdField_a_of_type_ComEtrumpMixlayoutETDecoration.currentFrameIndex() == paramMessage.jdField_a_of_type_Int) && ((localvgl.a() instanceof vft)) && (((vft)localvgl.a()).a() != null) && (((vft)localvgl.a()).a().getId() == paramMessage.jdField_a_of_type_Vfv.a().getId()) && (((vft)localvgl.a()).a().getSize() == paramMessage.jdField_a_of_type_Vfv.a().getSize())) {
      if ((localvgl.jdField_a_of_type_Boolean) && (!localvgl.b()))
      {
        bool = true;
        if (!bool) {
          break label351;
        }
        localvgl.f();
        ETDecoration localETDecoration = localvgl.jdField_a_of_type_ComEtrumpMixlayoutETDecoration;
        if (!localETDecoration.nextFrame()) {
          break label313;
        }
        i = localETDecoration.getFrameDelay();
        int j = (int)(System.currentTimeMillis() - vfr.a(paramMessage));
        if ((j <= 0) || (j * 2 >= i)) {
          break label348;
        }
        i -= j;
        label274:
        if (i > 1) {
          break label302;
        }
        sendEmptyMessage(0);
        label285:
        bool = true;
      }
    }
    label302:
    label313:
    label348:
    label351:
    for (;;)
    {
      localvgl.jdField_a_of_type_Boolean = bool;
      return;
      bool = false;
      break;
      sendEmptyMessageDelayed(0, i);
      break label285;
      localvgl.b = true;
      localvgl.a(200L);
      bool = false;
      continue;
      QLog.e("ETAnimator", 1, "this textView reused!");
      localvgl.jdField_a_of_type_Boolean = false;
      return;
      break label274;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vfs
 * JD-Core Version:    0.7.0.1
 */