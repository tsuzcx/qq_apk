import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stSimpleMetaFeed;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;

class tng
  implements SeekBar.OnSeekBarChangeListener
{
  tng(tne paramtne) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if ((paramSeekBar == null) || (tne.a(this.a) == null) || (tne.a(this.a) == null)) {}
    while ((tne.a(this.a).a() == null) || (!(tne.a(this.a).a().a() instanceof stSimpleMetaFeed))) {
      return;
    }
    float f = paramSeekBar.getProgress();
    int i = ((stSimpleMetaFeed)tne.a(this.a).a().a()).video.duration;
    int j = (int)(f / 1000.0F * i);
    tlo.a("WS_VIDEO_seekBar", "WSVerticalItemVideoProgressController onStopTrackingTouch() progress:" + f + ", videoDuration:" + i + ", position:" + j);
    tne.a(this.a).a(j, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tng
 * JD-Core Version:    0.7.0.1
 */