import android.content.Intent;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyUninterestComplainFragment;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogView.a;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.qphone.base.util.QLog;

class mws
  implements ReadInJoyDisLikeDialogView.a
{
  mws(mwq parammwq, VideoInfo paramVideoInfo) {}
  
  public void aNT()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsShareController", 2, "onDislikeDialogViewForAdComplain");
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_type", 2);
    if (this.n != null) {
      localIntent.putExtra("key_ad_info", this.n.b);
    }
    PublicFragmentActivity.startForResult(mwq.a(this.b), localIntent, ReadInJoyUninterestComplainFragment.class, 9999);
    mwq.a(this.b).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mws
 * JD-Core Version:    0.7.0.1
 */