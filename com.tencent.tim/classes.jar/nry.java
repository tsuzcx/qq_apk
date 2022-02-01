import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoySelectPositionHeader;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoySelectPositionHeader.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nry
  implements View.OnClickListener
{
  public nry(ReadInJoySelectPositionHeader paramReadInJoySelectPositionHeader, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    SelectPositionModule localSelectPositionModule = lbz.a().a();
    SelectPositionModule.PositionData localPositionData;
    if (localSelectPositionModule != null)
    {
      localPositionData = localSelectPositionModule.b();
      if (!localSelectPositionModule.a(localPositionData)) {
        break label60;
      }
      localSelectPositionModule.f(localPositionData);
      if (ReadInJoySelectPositionHeader.a(this.b) != null) {
        ReadInJoySelectPositionHeader.a(this.b).a(localPositionData);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label60:
      if (localPositionData != null) {
        QQToast.a(this.val$context, String.format("你当前在%s，暂无本地频道。", new Object[] { localPositionData.cityGPS }), 0).show();
      }
      if (QLog.isColorLevel()) {
        QLog.i("ReadInJoySelectPositionHeader", 2, "onClick not in city white list gpsPosition = " + localPositionData);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nry
 * JD-Core Version:    0.7.0.1
 */