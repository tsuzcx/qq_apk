import android.view.View;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.qphone.base.util.QLog;

public class uxl
  implements abej.b
{
  public uxl(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public boolean F(String paramString, int paramInt)
  {
    return ForwardRecentActivity.a(this.this$0, paramString, paramInt);
  }
  
  public void eK(View paramView)
  {
    boolean bool = ForwardRecentActivity.a(this.this$0);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardEntranceActivity", 2, "onItemViewClicked" + bool);
    }
    if (bool)
    {
      ForwardRecentActivity.a(this.this$0, paramView);
      return;
    }
    this.this$0.eL(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     uxl
 * JD-Core Version:    0.7.0.1
 */