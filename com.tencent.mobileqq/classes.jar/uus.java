import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stSimpleMetaFeed;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class uus
  implements SeekBar.OnSeekBarChangeListener
{
  uus(uuq paramuuq) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if ((paramSeekBar == null) || (uuq.a(this.a) == null) || (uuq.a(this.a) == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
      return;
      usv localusv = (usv)uuq.a(this.a).a;
      if ((localusv != null) && ((localusv.a() instanceof stSimpleMetaFeed)))
      {
        float f = paramSeekBar.getProgress();
        int i = ((stSimpleMetaFeed)localusv.a()).video.duration;
        int j = (int)(f / 1000.0F * i);
        uqf.a("WS_VIDEO_seekBar", "WSVerticalItemVideoProgressController onStopTrackingTouch() progress:" + f + ", videoDuration:" + i + ", position:" + j);
        uuq.a(this.a).a(j, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uus
 * JD-Core Version:    0.7.0.1
 */