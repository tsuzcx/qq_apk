import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import org.json.JSONObject;

class abng
  implements MediaPlayer.OnPreparedListener
{
  abng(abnc paramabnc, JSONObject paramJSONObject, abob paramabob) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.a.gd(3);
    if (abnc.a(this.a)) {
      this.a.b(this.val$result, this.b);
    }
    if (this.val$result != null) {
      abnc.a(this.a, this.b, this.val$result);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abng
 * JD-Core Version:    0.7.0.1
 */