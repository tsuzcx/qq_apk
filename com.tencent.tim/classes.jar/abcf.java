import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class abcf
  implements MediaPlayer.OnCompletionListener
{
  abcf(abcb paramabcb, int paramInt, String paramString) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    QLog.e("QVipSpecialSoundWebViewPlugin", 1, "play completed, soundId:" + this.val$id);
    try
    {
      paramMediaPlayer = new JSONObject();
      paramMediaPlayer.put("code", 1);
      this.a.callJs(this.val$callback, new String[] { paramMediaPlayer.toString() });
      return;
    }
    catch (JSONException paramMediaPlayer)
    {
      QLog.e("QVipSpecialSoundWebViewPlugin", 1, "onCompletion: " + this.val$id, paramMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abcf
 * JD-Core Version:    0.7.0.1
 */