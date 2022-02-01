import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.etrump.mixlayout.ETDecoration;
import com.etrump.mixlayout.ETFont;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class vhw
  extends Handler
{
  WeakReference<vip> a;
  
  vhw(vip paramvip, Looper paramLooper)
  {
    super(paramLooper);
    this.a = new WeakReference(paramvip);
  }
  
  public void handleMessage(Message paramMessage)
  {
    vip localvip = (vip)this.a.get();
    if (localvip == null) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        paramMessage = vhv.a(localvip);
      }
    } while (paramMessage == null);
    localvip.jdField_a_of_type_Vht.a(paramMessage);
    return;
    paramMessage = (vhv)paramMessage.obj;
    boolean bool;
    int i;
    if ((paramMessage != null) && (localvip.b().equals(paramMessage.jdField_a_of_type_JavaLangCharSequence.toString())) && (localvip.jdField_a_of_type_ComEtrumpMixlayoutETDecoration != null) && (localvip.jdField_a_of_type_ComEtrumpMixlayoutETDecoration.currentFrameIndex() == paramMessage.jdField_a_of_type_Int) && ((localvip.a() instanceof vhx)) && (((vhx)localvip.a()).a() != null) && (((vhx)localvip.a()).a().getId() == paramMessage.jdField_a_of_type_Vhz.a().getId()) && (((vhx)localvip.a()).a().getSize() == paramMessage.jdField_a_of_type_Vhz.a().getSize())) {
      if ((localvip.jdField_a_of_type_Boolean) && (!localvip.b()))
      {
        bool = true;
        if (!bool) {
          break label351;
        }
        localvip.f();
        ETDecoration localETDecoration = localvip.jdField_a_of_type_ComEtrumpMixlayoutETDecoration;
        if (!localETDecoration.nextFrame()) {
          break label313;
        }
        i = localETDecoration.getFrameDelay();
        int j = (int)(System.currentTimeMillis() - vhv.a(paramMessage));
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
      localvip.jdField_a_of_type_Boolean = bool;
      return;
      bool = false;
      break;
      sendEmptyMessageDelayed(0, i);
      break label285;
      localvip.b = true;
      localvip.a(200L);
      bool = false;
      continue;
      QLog.e("ETAnimator", 1, "this textView reused!");
      localvip.jdField_a_of_type_Boolean = false;
      return;
      break label274;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vhw
 * JD-Core Version:    0.7.0.1
 */