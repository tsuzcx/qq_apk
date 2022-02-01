import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.mobileqq.activity.H5MagicPlayerActivity;
import com.tencent.qphone.base.util.QLog;

public class vdo
  implements SoundPool.OnLoadCompleteListener
{
  public vdo(H5MagicPlayerActivity paramH5MagicPlayerActivity, String paramString) {}
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if ((this.this$0.mSoundPool.play(paramInt1, 1.0F, 1.0F, 0, this.this$0.loop - 1, 1.0F) == 0) && (QLog.isColorLevel())) {
      QLog.d("SoundPoolUtil", 2, "play failure filepath=" + this.val$filePath);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vdo
 * JD-Core Version:    0.7.0.1
 */