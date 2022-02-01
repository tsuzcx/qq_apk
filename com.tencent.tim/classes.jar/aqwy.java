import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class aqwy
  implements MediaPlayer.OnErrorListener
{
  aqwy(int paramInt, aqxa paramaqxa, VideoView paramVideoView, boolean paramBoolean) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipFunCallManager", 2, "playing onError what=" + paramInt1 + ", extra=" + paramInt2 + ", funcallid=" + this.val$id);
    }
    if (this.b != null) {
      this.b.F(paramInt1, paramInt2, this.val$id);
    }
    paramMediaPlayer = aqwu.a(null, this.val$id, 7, null);
    if (TextUtils.isEmpty(paramMediaPlayer)) {}
    label159:
    RelativeLayout localRelativeLayout;
    do
    {
      for (;;)
      {
        return true;
        if (new File(paramMediaPlayer).exists())
        {
          paramMediaPlayer = aqcu.decodeFile(paramMediaPlayer);
          if (paramMediaPlayer != null) {}
          for (paramMediaPlayer = new BitmapDrawable(paramMediaPlayer); (paramMediaPlayer != null) && (this.e != null); paramMediaPlayer = null)
          {
            if (this.cWK != true) {
              break label159;
            }
            this.e.setBackgroundDrawable(paramMediaPlayer);
            return true;
          }
        }
      }
      this.e.setVisibility(8);
      localRelativeLayout = (RelativeLayout)this.e.getParent();
    } while (localRelativeLayout == null);
    localRelativeLayout.setBackgroundDrawable(paramMediaPlayer);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqwy
 * JD-Core Version:    0.7.0.1
 */