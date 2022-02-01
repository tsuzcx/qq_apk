import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stSimpleMetaFeed;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vcn
  implements SeekBar.OnSeekBarChangeListener
{
  vcn(vcl paramvcl) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if ((paramSeekBar == null) || (vcl.a(this.a) == null) || (vcl.a(this.a) == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
      return;
      vaq localvaq = (vaq)vcl.a(this.a).a;
      if ((localvaq != null) && ((localvaq.a() instanceof stSimpleMetaFeed)))
      {
        float f = paramSeekBar.getProgress();
        int i = ((stSimpleMetaFeed)localvaq.a()).video.duration;
        int j = (int)(f / 1000.0F * i);
        uya.a("WS_VIDEO_seekBar", "WSVerticalItemVideoProgressController onStopTrackingTouch() progress:" + f + ", videoDuration:" + i + ", position:" + j);
        vcl.a(this.a).a(j, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcn
 * JD-Core Version:    0.7.0.1
 */