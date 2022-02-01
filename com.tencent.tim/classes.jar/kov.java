import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyCutImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;

class kov
  implements knm.a
{
  kov(kos paramkos) {}
  
  public void onAnimationEnd()
  {
    if (kos.a(this.this$0).booleanValue())
    {
      if ((kos.a(this.this$0).isShown()) && (kos.a(this.this$0).getWindowVisibility() == 0))
      {
        kos.a(this.this$0, kos.a(this.this$0));
        kos.a(this.this$0).removeCallbacks(kos.a(this.this$0));
        kos.a(this.this$0).postDelayed(kos.a(this.this$0), kos.a(this.this$0).mAdvertisementExtInfo.aJG);
      }
    }
    else {
      return;
    }
    kos.a(this.this$0, Boolean.valueOf(false));
    kos.a(this.this$0, kos.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kov
 * JD-Core Version:    0.7.0.1
 */