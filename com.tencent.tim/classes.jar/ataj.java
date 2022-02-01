import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioManager;
import com.tencent.sharp.jni.TraeAudioManager.TraeAudioManagerLooper;

public class ataj
  implements atan.a
{
  public ataj(TraeAudioManager.TraeAudioManagerLooper paramTraeAudioManagerLooper) {}
  
  public void nk(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 1, "_ringPlayer onCompletion, _activeMode[" + this.b.this$0._activeMode + "], _preRingMode[" + this.b._preRingMode + "], seq[" + paramLong + "]");
    }
    TraeAudioManager.b(paramLong, null, -1L, true);
    this.b.nj(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ataj
 * JD-Core Version:    0.7.0.1
 */