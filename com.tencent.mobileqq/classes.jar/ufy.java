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
import mqq.app.AppRuntime;
import qqcircle.TaskCenterReader.TaskRecord;

public class ufy
  implements View.OnClickListener
{
  public ufy(QCircleTaskItemView paramQCircleTaskItemView, TaskCenterReader.TaskRecord paramTaskRecord) {}
  
  public void onClick(View paramView)
  {
    try
    {
      if (bdnn.a(this.jdField_a_of_type_QqcircleTaskCenterReader$TaskRecord.jumpUrl.get())) {
        QLog.w("QCircleTaskItemView", 1, "task item url is empty");
      }
      paramView = new Intent(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTaskItemView.getContext(), JumpActivity.class);
      paramView.setData(Uri.parse(this.jdField_a_of_type_QqcircleTaskCenterReader$TaskRecord.jumpUrl.get()));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTaskItemView.getContext().startActivity(paramView);
      tzv.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 8, 3L, this.jdField_a_of_type_QqcircleTaskCenterReader$TaskRecord.taskType.get());
      yiw.a().a(new QCircleTaskCenterEvent(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTaskItemView.getContext().hashCode(), false));
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ufy
 * JD-Core Version:    0.7.0.1
 */