import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoySkinAnimManager;
import com.tencent.qphone.base.util.QLog;

public class nqc
  implements SoundPool.OnLoadCompleteListener
{
  public nqc(ReadInJoySkinAnimManager paramReadInJoySkinAnimManager, long paramLong) {}
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySkinAnimManager", 1, "setSoundPool onLoadComplete time = " + (l - this.val$startTime));
    }
    anot.a(null, "dc00899", "BizTechReport", "", "kan_dian_skin_pull_refresh", "sound_load_time", 0, 0, ReadInJoySkinAnimManager.a(this.this$0), String.valueOf(l - this.val$startTime), null, null);
    ReadInJoySkinAnimManager.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nqc
 * JD-Core Version:    0.7.0.1
 */