import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.LocationPickFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aisv
  implements View.OnClickListener
{
  public aisv(LocationPickFragment paramLocationPickFragment, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    int i = 2;
    if (!aqiw.isNetworkAvailable())
    {
      QQToast.a(this.val$activity, 2131695491, 0).show();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    LocationRoom.Venue localVenue = LocationPickFragment.a(this.this$0).c();
    if (QLog.isColorLevel()) {
      QLog.d("LocationPickFragment", 2, "[venue] pick confirm click: venue: " + localVenue);
    }
    if (LocationPickFragment.a(this.this$0).apE()) {}
    for (;;)
    {
      anot.a(null, "CliOper", "", "", "0X800A962", "0X800A962", i, 0, "", "0", "0", "");
      Intent localIntent = new Intent();
      localIntent.putExtra("key_picked_location", localVenue);
      this.val$activity.setResult(-1, localIntent);
      this.val$activity.finish();
      break;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aisv
 * JD-Core Version:    0.7.0.1
 */