import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.PoiMapActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class adba
  implements View.OnClickListener
{
  adba(aday paramaday) {}
  
  public void onClick(View paramView)
  {
    this.this$0.dismiss();
    Intent localIntent = new Intent(paramView.getContext(), PoiMapActivity.class).putExtra("lat", Double.toString(this.this$0.a.latitude * 1.0D / 1000000.0D)).putExtra("lon", Double.toString(this.this$0.a.longitude * 1.0D / 1000000.0D));
    this.this$0.activity.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adba
 * JD-Core Version:    0.7.0.1
 */