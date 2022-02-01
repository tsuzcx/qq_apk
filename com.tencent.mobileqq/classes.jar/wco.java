import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.events.QCircleTaskCenterEvent;
import com.tencent.biz.qqcircle.widgets.QCircleTaskItemView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import qqcircle.TaskCenterReader.TaskRecord;

public class wco
  implements View.OnClickListener
{
  public wco(QCircleTaskItemView paramQCircleTaskItemView, TaskCenterReader.TaskRecord paramTaskRecord) {}
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      try
      {
        Context localContext = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTaskItemView.getContext();
        if (localContext != null) {
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (bhsr.a(this.jdField_a_of_type_QqcircleTaskCenterReader$TaskRecord.jumpUrl.get())) {
        QLog.w("QCircleTaskItemView", 1, "task item url is empty");
      }
      uyx.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTaskItemView.getContext(), this.jdField_a_of_type_QqcircleTaskCenterReader$TaskRecord.jumpUrl.get());
      vtq.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 8, 3, this.jdField_a_of_type_QqcircleTaskCenterReader$TaskRecord.taskType.get(), this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTaskItemView.d());
      aaak.a().a(new QCircleTaskCenterEvent(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTaskItemView.getContext().hashCode(), false));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wco
 * JD-Core Version:    0.7.0.1
 */