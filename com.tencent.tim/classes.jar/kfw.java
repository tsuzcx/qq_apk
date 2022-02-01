import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;

class kfw
  implements View.OnClickListener
{
  kfw(kfv paramkfv) {}
  
  public void onClick(View paramView)
  {
    if (kyo.Bg()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent();
      localIntent.putExtra("currentIndex", kfv.a(this.this$0).getCurrentItem());
      PublicTransFragmentActivity.start(kfv.a(this.this$0), localIntent, ReadInJoyChannelPanelFragment.class);
      try
      {
        ReadInJoyChannelPanelFragment.C("0X8009497", new kxm.b().c().c(this.this$0.ds()).build());
        kfv.a(this.this$0, false);
        kfv.a(this.this$0).setVisibility(8);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("ReadInJoyChannelViewPagerController", 1, QLog.getStackTraceString(localJSONException));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kfw
 * JD-Core Version:    0.7.0.1
 */