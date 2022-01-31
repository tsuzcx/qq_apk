import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.widget.ActionSheet.OnDismissListener;
import cooperation.qzone.RDMEtraMsgCollector;

public class xlc
  implements ActionSheet.OnDismissListener
{
  public xlc(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  public void onDismiss()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Actvity]").append(getClass().getSimpleName()).append(" QQCustomDialog click :").append("取消");
    RDMEtraMsgCollector.a().c(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xlc
 * JD-Core Version:    0.7.0.1
 */