import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.qphone.base.util.QLog;

class aiyn
  implements SoundPool.OnLoadCompleteListener
{
  aiyn(aiym paramaiym, int paramInt, String paramString) {}
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if ((this.this$0.mSoundPool.play(paramInt1, 1.0F, 1.0F, 0, this.dgU, 1.0F) == 0) && (QLog.isColorLevel())) {
      QLog.d("SoundPoolUtil", 2, "play failure filepath=" + this.val$filepath);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiyn
 * JD-Core Version:    0.7.0.1
 */