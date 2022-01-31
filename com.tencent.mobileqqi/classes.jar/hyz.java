import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioManager;
import com.tencent.sharp.jni.TraeMediaPlayer.OnCompletionListener;
import java.util.HashMap;

class hyz
  implements TraeMediaPlayer.OnCompletionListener
{
  hyz(hyy paramhyy) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "_ringPlayer onCompletion _activeMode:" + this.a.b.w + " _preRingMode:" + this.a.t);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(true));
    this.a.a(32783, localHashMap);
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hyz
 * JD-Core Version:    0.7.0.1
 */