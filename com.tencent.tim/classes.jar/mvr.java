import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity.3;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mvr
  implements View.OnClickListener
{
  public mvr(VideoFeedsPlayActivity.3 param3) {}
  
  public void onClick(View paramView)
  {
    muj.a(this.a.this$0, this.a.a.a.k);
    nce.a locala = new nce.a(this.a.a).h(this.a.a.Wz).t(this.a.a.a.aHc);
    if (this.a.a.a.k != null) {}
    for (String str = this.a.a.a.k.WT;; str = "")
    {
      kbp.b(null, "", "0X800A18B", "0X800A18B", 0, 0, "", "", "", locala.p(str).a().toJsonString(), false);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mvr
 * JD-Core Version:    0.7.0.1
 */