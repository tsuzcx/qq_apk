import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import cooperation.gmersdk_warper.GMEAVEngineWalper.2.1;

public class aveq
  implements avev.b
{
  aveq(aveo paramaveo) {}
  
  public void onEnterRoomComplete(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      QLog.e("AVEngineWalper", 1, "enter room successfully!!!");
    }
    for (;;)
    {
      if (this.b.b != null) {
        this.b.b.bN(paramInt, paramString);
      }
      new Handler(Looper.getMainLooper()).postDelayed(new GMEAVEngineWalper.2.1(this), 500L);
      return;
      QLog.e("AVEngineWalper", 1, "enter room failed. result=" + paramInt + ", errorInfo=" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aveq
 * JD-Core Version:    0.7.0.1
 */