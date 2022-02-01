import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stSimpleMetaFeed;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class osa
  implements SeekBar.OnSeekBarChangeListener
{
  osa(ory paramory) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if ((paramSeekBar == null) || (ory.a(this.this$0) == null) || (ory.a(this.this$0) == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
      return;
      oqr localoqr = (oqr)ory.a(this.this$0).be;
      if ((localoqr != null) && ((localoqr.B() instanceof stSimpleMetaFeed)))
      {
        float f = paramSeekBar.getProgress();
        int i = ((stSimpleMetaFeed)localoqr.B()).video.duration;
        int j = (int)(f / 1000.0F * i);
        ooz.i("WS_VIDEO_seekBar", "WSVerticalItemVideoProgressController onStopTrackingTouch() progress:" + f + ", videoDuration:" + i + ", position:" + j);
        ory.a(this.this$0).Z(j, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     osa
 * JD-Core Version:    0.7.0.1
 */