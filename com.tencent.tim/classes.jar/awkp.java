import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.pb.TianShuAccess.AdItem;

class awkp
  implements View.OnClickListener
{
  awkp(awkn paramawkn) {}
  
  public void onClick(View paramView)
  {
    awkn.a(this.b);
    if ((awkn.a(this.b) != null) && (awkn.a(this.b).a() != null) && (awkn.a(this.b).a().app != null) && (awkn.a(this.b) != null)) {
      awkm.d(awkn.a(this.b).a().app, 122, String.valueOf(awkn.a(this.b).iAdId.get()), awkn.a(this.b).traceinfo.get());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awkp
 * JD-Core Version:    0.7.0.1
 */