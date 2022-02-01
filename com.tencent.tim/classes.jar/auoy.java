import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.tim.todo.TodoNewActivity;

public class auoy
  implements View.OnFocusChangeListener
{
  public auoy(TodoNewActivity paramTodoNewActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    TodoNewActivity.a(this.this$0).setCursorVisible(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auoy
 * JD-Core Version:    0.7.0.1
 */