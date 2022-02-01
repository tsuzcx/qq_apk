import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class iys
  implements ViewTreeObserver.OnPreDrawListener
{
  iys(iyr paramiyr, TextView paramTextView) {}
  
  public boolean onPreDraw()
  {
    this.mF.getViewTreeObserver().removeOnPreDrawListener(this);
    this.this$0.mApp.b().b().Rg = true;
    jll.u(this.this$0.mApp);
    QLog.d("qav_face_guide", 1, "onPreDraw");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iys
 * JD-Core Version:    0.7.0.1
 */