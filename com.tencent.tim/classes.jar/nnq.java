import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyUninterestComplainFragment;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.qphone.base.util.QLog;

final class nnq
  implements auud.a
{
  nnq(Context paramContext, AdData paramAdData) {}
  
  public void aNT()
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpAdUtils", 2, "onPopupWindowForAdComplain");
    }
    if ((this.val$context instanceof Activity))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_from_type", 3);
      localIntent.putExtra("key_ad_info", this.d);
      PublicFragmentActivity.startForResult((Activity)this.val$context, localIntent, ReadInJoyUninterestComplainFragment.class, 9999);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nnq
 * JD-Core Version:    0.7.0.1
 */