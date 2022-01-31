import com.tencent.biz.qqstory.takevideo.music.QQStoryMusicInfo;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.AudioPlayer.AudioPlayerListener;
import com.tencent.mobileqq.activity.richmedia.QzDynamicVideoPreviewActivity;
import com.tencent.qphone.base.util.QLog;

public class xpw
  implements AudioPlayer.AudioPlayerListener
{
  public xpw(QzDynamicVideoPreviewActivity paramQzDynamicVideoPreviewActivity) {}
  
  public void a(AudioPlayer paramAudioPlayer)
  {
    QLog.d("QzDynamicVideoPreviewActivity", 2, "AudioPlayerListener - onCompletion");
    if ((QzDynamicVideoPreviewActivity.a(this.a) > 0) && (QzDynamicVideoPreviewActivity.a(this.a) != null))
    {
      QLog.d("QzDynamicVideoPreviewActivity", 2, "AudioPlayerListener - onCompletion - needLoop:" + QzDynamicVideoPreviewActivity.a(this.a));
      int i = QzDynamicVideoPreviewActivity.a(this.a);
      if (QzDynamicVideoPreviewActivity.a(this.a) > 0)
      {
        this.a.i();
        QzDynamicVideoPreviewActivity.a(this.a, i);
        QzDynamicVideoPreviewActivity.a(this.a, new AudioPlayer(this.a, QzDynamicVideoPreviewActivity.a(this.a)));
        QzDynamicVideoPreviewActivity.a(this.a).a(3);
        QzDynamicVideoPreviewActivity.a(this.a).a(QzDynamicVideoPreviewActivity.a(this.a).g, 0);
        QzDynamicVideoPreviewActivity.b(this.a);
        QLog.d("QzDynamicVideoPreviewActivity", 2, "AudioPlayerListener - onCompletion - seekPlayLoop:" + QzDynamicVideoPreviewActivity.a(this.a));
      }
    }
  }
  
  public void a(AudioPlayer paramAudioPlayer, int paramInt)
  {
    QLog.e("QzDynamicVideoPreviewActivity", 2, "AudioPlayer get an error, errorCode:" + paramInt);
  }
  
  public void b(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  public void c(AudioPlayer paramAudioPlayer, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xpw
 * JD-Core Version:    0.7.0.1
 */