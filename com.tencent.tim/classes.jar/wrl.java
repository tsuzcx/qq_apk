import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.activity.aio.doodle.DoodlePanel;
import com.tencent.mobileqq.activity.aio.doodle.DoodlePanel.5.1;
import com.tencent.qphone.base.util.QLog;

public class wrl
  implements amjb.a
{
  public wrl(DoodlePanel paramDoodlePanel, wrb paramwrb) {}
  
  public void CJ(int paramInt)
  {
    QLog.i("Scribble", 2, "bsuc " + paramInt);
    new Handler(Looper.getMainLooper()).post(new DoodlePanel.5.1(this, paramInt));
  }
  
  public boolean hI(String paramString)
  {
    return DoodlePanel.a(this.b, paramString, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wrl
 * JD-Core Version:    0.7.0.1
 */