import com.tencent.tim.todo.TodoNewActivity;
import com.tencent.tim.todo.data.TodoInfo;

public class auos
  extends aupd
{
  public auos(TodoNewActivity paramTodoNewActivity) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString, TodoInfo paramTodoInfo, int paramInt2)
  {
    super.a(paramBoolean, paramInt1, paramString, paramTodoInfo, paramInt2);
    if (paramBoolean)
    {
      if ((paramInt1 == 1) || (paramInt1 == 2)) {
        TodoNewActivity.a(this.this$0, "已添加到待办");
      }
      if (paramInt1 == 2) {
        aupe.L(this.this$0.app, "0X80091B9", 1);
      }
    }
    do
    {
      for (;;)
      {
        this.this$0.finish();
        return;
        if (paramInt1 == 0) {
          aupe.L(this.this$0.app, "0X80091C0", 1);
        }
      }
      if (paramInt2 == 133) {
        TodoNewActivity.a(this.this$0, "待办条数超过限制");
      }
      while (paramInt1 == 2)
      {
        aupe.L(this.this$0.app, "0X80091BA", 1);
        return;
        TodoNewActivity.a(this.this$0, "保存失败，请稍后重试");
      }
    } while (paramInt1 != 0);
    aupe.L(this.this$0.app, "0X80091C1", 1);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt, TodoInfo paramTodoInfo)
  {
    super.a(paramBoolean, paramString, paramInt, paramTodoInfo);
    if (paramInt == 1)
    {
      if (paramBoolean)
      {
        this.this$0.finish();
        TodoNewActivity.a(this.this$0, "已更新待办");
      }
    }
    else {
      return;
    }
    TodoNewActivity.a(this.this$0, "保存失败，请稍后重试");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auos
 * JD-Core Version:    0.7.0.1
 */