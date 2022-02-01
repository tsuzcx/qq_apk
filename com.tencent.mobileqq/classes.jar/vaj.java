import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class vaj
  implements View.OnClickListener
{
  vaj(vai paramvai) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (vai.a(this.a) != null)
    {
      if (bhsr.a(vai.a(this.a))) {
        QLog.w("QCircleTaskCenterAdapter", 1, "task center url is empty");
      }
      localObject = bhni.a(QQStoryContext.a(), paramView.getContext(), vai.a(this.a));
      if (localObject != null) {
        ((bhmr)localObject).a();
      }
      localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      if (!QCircleReportBean.isContentDetailPage(this.a.a())) {
        break label113;
      }
    }
    label113:
    for (int i = this.a.b();; i = this.a.a())
    {
      vtq.a((String)localObject, 8, 2, 0, i);
      vqo.a().b(false);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vaj
 * JD-Core Version:    0.7.0.1
 */