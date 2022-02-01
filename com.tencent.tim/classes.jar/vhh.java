import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.qphone.base.util.QLog;

public class vhh
  implements View.OnLongClickListener
{
  public vhh(MainFragment paramMainFragment) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.this$0.getCurrentTab() == MainFragment.bIk)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "Mainfragment onLongClick");
      }
      paramView = (Conversation)this.this$0.a(Conversation.class);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vhh
 * JD-Core Version:    0.7.0.1
 */