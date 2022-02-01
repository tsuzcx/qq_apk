import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class abnk
  implements SoundPool.OnLoadCompleteListener
{
  abnk(abnj paramabnj, float paramFloat, int paramInt, String paramString, abob paramabob, JSONObject paramJSONObject) {}
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    float f = 1.0F;
    if (abnj.a(this.jdField_b_of_type_Abnj) != null)
    {
      try
      {
        if (-1.0F == this.sA) {}
        for (;;)
        {
          paramInt1 = abnj.a(this.jdField_b_of_type_Abnj).play(paramInt1, f, f, 0, this.cqh, 1.0F);
          if (paramInt1 != 0) {
            break;
          }
          QLog.w("cmgame_process.CmGameSoudPoolPlayer", 1, "fail to play, musicPath:" + this.bhc);
          return;
          f = this.sA;
        }
        paramSoundPool = this.jdField_b_of_type_Abob;
        if (paramSoundPool == null) {
          break label159;
        }
        try
        {
          if (this.bf != null)
          {
            this.bf.put("id", paramInt1);
            this.jdField_b_of_type_Abob.aJ(this.bf);
            return;
          }
        }
        catch (Throwable paramSoundPool)
        {
          QLog.e("cmgame_process.CmGameSoudPoolPlayer", 1, paramSoundPool, new Object[0]);
          return;
        }
        QLog.e("cmgame_process.CmGameSoudPoolPlayer", 1, "result is null");
      }
      catch (Throwable paramSoundPool)
      {
        QLog.e("cmgame_process.CmGameSoudPoolPlayer", 1, "pool play failed", paramSoundPool);
        return;
      }
      return;
      label159:
      QLog.e("cmgame_process.CmGameSoudPoolPlayer", 1, "handler is null");
      return;
    }
    QLog.e("cmgame_process.CmGameSoudPoolPlayer", 1, "soundpool is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abnk
 * JD-Core Version:    0.7.0.1
 */