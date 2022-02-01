import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.data.LocationRoom.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aivg
  implements View.OnClickListener
{
  aivg(aivd paramaivd, BaseActivity paramBaseActivity, LocationRoom.b paramb) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = this.val$activity.app;
    int i = this.c.getSessionType();
    Object localObject = this.c.xc();
    aiqs.a(localQQAppInterface).a.G(3, i, (String)localObject);
    localObject = new LocationRoom.b(i, (String)localObject);
    aiqs.a(localQQAppInterface).a((LocationRoom.b)localObject, false);
    anot.a(null, "CliOper", "", "", "0X800A979", "0X800A979", 0, 0, "", "0", "0", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aivg
 * JD-Core Version:    0.7.0.1
 */