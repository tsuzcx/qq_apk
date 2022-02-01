import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stSimpleMetaFeed;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vrh
  implements SeekBar.OnSeekBarChangeListener
{
  vrh(vrf paramvrf) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if ((paramSeekBar == null) || (vrf.a(this.a) == null) || (vrf.a(this.a) == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
      return;
      vpj localvpj = (vpj)vrf.a(this.a).a;
      if ((localvpj != null) && ((localvpj.a() instanceof stSimpleMetaFeed)))
      {
        float f = paramSeekBar.getProgress();
        int i = ((stSimpleMetaFeed)localvpj.a()).video.duration;
        int j = (int)(f / 1000.0F * i);
        vmp.a("WS_VIDEO_seekBar", "WSVerticalItemVideoProgressController onStopTrackingTouch() progress:" + f + ", videoDuration:" + i + ", position:" + j);
        vrf.a(this.a).a(j, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrh
 * JD-Core Version:    0.7.0.1
 */