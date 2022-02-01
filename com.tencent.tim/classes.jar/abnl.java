import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.qphone.base.util.QLog;

class abnl
  implements SoundPool.OnLoadCompleteListener
{
  abnl(abnj paramabnj, float paramFloat, int paramInt, String paramString, abjq paramabjq, long paramLong) {}
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if (-1.0F == this.sA) {}
    for (float f = 1.0F;; f = this.sA)
    {
      paramInt1 = abnj.a(this.b).play(paramInt1, f, f, 0, this.cqh, 1.0F);
      if (paramInt1 != 0) {
        break;
      }
      QLog.w("cmgame_process.CmGameSoudPoolPlayer", 1, "fail to play, musicPath:" + this.bhc);
      return;
    }
    abnj.a(this.b, this.c, paramInt1, this.ND);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abnl
 * JD-Core Version:    0.7.0.1
 */