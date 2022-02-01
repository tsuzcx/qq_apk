import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.view.SurfaceHolder;
import com.tencent.qphone.base.util.QLog;

public class aquq
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, aqup
{
  private aqup.b jdField_a_of_type_Aqup$b;
  private aqup.c jdField_a_of_type_Aqup$c;
  private aqup.a b;
  private int cpq;
  private MediaPlayer mMediaPlayer;
  private int mPlayState = 0;
  
  public aquq()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer construct");
    }
  }
  
  private void GR(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer changePlayState " + paramInt);
    }
    this.mPlayState = paramInt;
    if (this.jdField_a_of_type_Aqup$b != null) {
      this.jdField_a_of_type_Aqup$b.onPlayStateChanged(this.mPlayState);
    }
  }
  
  public static String gn(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "null";
    case 0: 
      return " idle ";
    case 1: 
      return " playing ";
    case 2: 
      return " pause ";
    }
    return " error ";
  }
  
  public void a(aqup.a parama)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer setCompletionListener ");
    }
    this.b = parama;
  }
  
  public void a(aqup.b paramb)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer setPlayStateListener ");
    }
    this.jdField_a_of_type_Aqup$b = paramb;
  }
  
  public void a(aqup.c paramc)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer setPreparedListener ");
    }
    this.jdField_a_of_type_Aqup$c = paramc;
  }
  
  public int getCurrentPosition()
  {
    if (this.mMediaPlayer != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getCurrentPosition " + this.mMediaPlayer.getCurrentPosition());
      }
      return this.mMediaPlayer.getCurrentPosition();
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getCurrentPosition -1");
    }
    return -1;
  }
  
  public int getDuration()
  {
    if (this.mMediaPlayer != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getDuration " + this.mMediaPlayer.getDuration());
      }
      return this.mMediaPlayer.getDuration();
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getDuration -1");
    }
    return -1;
  }
  
  public int getPlayState()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getPlayState " + this.mPlayState);
    }
    if (this.mMediaPlayer != null) {
      return this.mPlayState;
    }
    return 3;
  }
  
  public int getVideoHeight()
  {
    if (this.mMediaPlayer != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getVideoHeight " + this.mMediaPlayer.getVideoHeight());
      }
      return this.mMediaPlayer.getVideoHeight();
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getVideoHeight -1");
    }
    return -1;
  }
  
  public int getVideoWidth()
  {
    if (this.mMediaPlayer != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getVideoWidth " + this.mMediaPlayer.getVideoWidth());
      }
      return this.mMediaPlayer.getVideoWidth();
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getVideoWidth -1");
    }
    return -1;
  }
  
  public boolean isPlaying()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer isPlaying ");
    }
    if (this.mMediaPlayer != null) {
      return this.mMediaPlayer.isPlaying();
    }
    return false;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer onCompletion ");
    }
    GR(0);
    if (this.b != null) {
      this.b.b(this);
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    QLog.e("LocalVideoMediaPlayer", 2, "mMediaPlayer onError what=" + paramInt1 + ",extra=" + paramInt2);
    GR(3);
    reset();
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer onPrepared ");
    }
    if (this.jdField_a_of_type_Aqup$c != null) {
      this.jdField_a_of_type_Aqup$c.a(this);
    }
    start();
    if (this.cpq > 0) {
      seekTo(this.cpq);
    }
  }
  
  public void pause()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer pause");
    }
    if (isPlaying())
    {
      this.mMediaPlayer.pause();
      GR(2);
    }
  }
  
  public boolean play(String paramString, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer play " + paramInt);
    }
    this.cpq = paramInt;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocalVideoMediaPlayer", 2, "#play#, msec=" + paramInt);
      }
      release();
      this.mMediaPlayer = new MediaPlayer();
      this.mMediaPlayer.setAudioStreamType(3);
      this.mMediaPlayer.setOnCompletionListener(this);
      this.mMediaPlayer.setOnErrorListener(this);
      this.mMediaPlayer.setOnPreparedListener(this);
      this.mMediaPlayer.setDataSource(paramString);
      this.mMediaPlayer.prepareAsync();
      return true;
    }
    catch (Exception paramString)
    {
      QLog.e("LocalVideoMediaPlayer", 2, "#play#, msec=" + paramInt, paramString);
      reset();
    }
    return false;
  }
  
  public void release()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer release");
    }
    if (this.mMediaPlayer != null)
    {
      this.mMediaPlayer.stop();
      this.mMediaPlayer.release();
      this.mMediaPlayer = null;
    }
    GR(0);
  }
  
  public void reset()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer reset ");
    }
    if (this.mMediaPlayer != null)
    {
      this.mMediaPlayer.reset();
      GR(0);
    }
  }
  
  public boolean resume()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer resume");
    }
    if (getPlayState() == 2) {
      start();
    }
    return getPlayState() == 1;
  }
  
  public void seekTo(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer seek to " + paramInt);
    }
    if (this.mMediaPlayer != null) {}
    try
    {
      this.mMediaPlayer.seekTo(paramInt);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      QLog.e("LocalVideoMediaPlayer", 2, "mMediaPlayer seekTo " + paramInt + " IllegalStateException");
    }
  }
  
  public void setDisplay(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer setDisplay ");
    }
    if (this.mMediaPlayer != null) {
      this.mMediaPlayer.setDisplay(paramSurfaceHolder);
    }
  }
  
  public void start()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer start");
    }
    if (this.mMediaPlayer != null)
    {
      this.mMediaPlayer.start();
      GR(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aquq
 * JD-Core Version:    0.7.0.1
 */