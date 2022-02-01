import android.view.View;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.tim.todo.TodoNewActivity;
import com.tencent.tim.todo.TodoNewActivity.a;
import com.tencent.tim.widget.IphonePickerView;
import com.tencent.tim.widget.IphonePickerView.c;

public class aupb
  implements IphonePickerView.c
{
  public aupb(TodoNewActivity paramTodoNewActivity) {}
  
  public void dn() {}
  
  public void w(int paramInt1, int paramInt2)
  {
    View localView = TodoNewActivity.a(this.this$0).findViewById(2131379693);
    if (TodoNewActivity.a(this.this$0).w() > NetConnInfoCenter.getServerTimeMillis()) {}
    for (boolean bool = true;; bool = false)
    {
      localView.setEnabled(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aupb
 * JD-Core Version:    0.7.0.1
 */