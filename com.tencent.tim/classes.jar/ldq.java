import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ldq
  implements View.OnClickListener
{
  public ldq(ReadInJoyChannelPanelFragment paramReadInJoyChannelPanelFragment, String paramString) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.this$0.getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", this.val$url);
    this.this$0.getActivity().startActivity(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyChannelPanelFragment", 2, "info.mChannelJumpUrl:" + this.val$url);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ldq
 * JD-Core Version:    0.7.0.1
 */