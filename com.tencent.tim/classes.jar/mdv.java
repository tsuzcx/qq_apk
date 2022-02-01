import android.view.ViewGroup;
import android.view.animation.Animation;
import com.tencent.qphone.base.util.QLog;

class mdv
  extends auqs.a
{
  mdv(mdu parammdu) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    try
    {
      this.a.ba.removeView(mdu.a(this.a));
      return;
    }
    catch (Exception paramAnimation)
    {
      QLog.d("BaseRIJRedPacketDialog", 2, QLog.getStackTraceString(paramAnimation));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mdv
 * JD-Core Version:    0.7.0.1
 */