import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import com.tencent.av.thread.Future;
import com.tencent.av.thread.FutureListener;
import com.tencent.av.ui.VideoLayerUI;

public class blh
  implements FutureListener
{
  public blh(VideoLayerUI paramVideoLayerUI, Handler.Callback paramCallback) {}
  
  public void a(Future paramFuture)
  {
    if (this.jdField_a_of_type_AndroidOsHandler$Callback != null) {
      new Handler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback).sendEmptyMessage(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     blh
 * JD-Core Version:    0.7.0.1
 */