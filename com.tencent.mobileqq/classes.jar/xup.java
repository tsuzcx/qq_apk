import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.widget.ActionSheet.OnDismissListener;
import cooperation.qzone.RDMEtraMsgCollector;

public class xup
  implements ActionSheet.OnDismissListener
{
  public xup(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  public void onDismiss()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Actvity]").append(getClass().getSimpleName()).append(" QQCustomDialog click :").append("取消");
    RDMEtraMsgCollector.a().c(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xup
 * JD-Core Version:    0.7.0.1
 */