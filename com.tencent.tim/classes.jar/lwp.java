import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyUninterestComplainFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.qphone.base.util.QLog;

class lwp
  implements auua.a
{
  lwp(lwm paramlwm) {}
  
  public void aNT()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FeedItemCell", 2, "onAdComplain");
    }
    if ((this.this$0.context instanceof Activity))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_from_type", 1);
      localIntent.putExtra("key_ad_info", ((lie)this.this$0.aN).a());
      PublicFragmentActivity.startForResult((Activity)this.this$0.context, localIntent, ReadInJoyUninterestComplainFragment.class, 9999);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lwp
 * JD-Core Version:    0.7.0.1
 */