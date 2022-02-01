import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.events.QCircleTaskCenterEvent;
import com.tencent.biz.qqcircle.widgets.QCircleTaskItemView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import qqcircle.TaskCenterReader.TaskRecord;

public class phj
  implements View.OnClickListener
{
  public phj(QCircleTaskItemView paramQCircleTaskItemView, TaskCenterReader.TaskRecord paramTaskRecord) {}
  
  public void onClick(View paramView)
  {
    try
    {
      if (aqmr.isEmpty(this.jdField_a_of_type_QqcircleTaskCenterReader$TaskRecord.jumpUrl.get())) {
        QLog.w("QCircleTaskItemView", 1, "task item url is empty");
      }
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTaskItemView.getContext(), JumpActivity.class);
      localIntent.setData(Uri.parse(this.jdField_a_of_type_QqcircleTaskCenterReader$TaskRecord.jumpUrl.get()));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTaskItemView.getContext().startActivity(localIntent);
      pco.b(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 8, 3L, this.jdField_a_of_type_QqcircleTaskCenterReader$TaskRecord.taskType.get());
      rwv.a().a(new QCircleTaskCenterEvent(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTaskItemView.getContext().hashCode(), false));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     phj
 * JD-Core Version:    0.7.0.1
 */