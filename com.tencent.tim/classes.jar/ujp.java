import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.BaseChatPie.95.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tim.todo.data.TodoInfo;

public class ujp
  extends aupd
{
  public ujp(BaseChatPie paramBaseChatPie) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString, TodoInfo paramTodoInfo, int paramInt2)
  {
    super.a(paramBoolean, paramInt1, paramString, paramTodoInfo, paramInt2);
    if ((paramBoolean) && (paramTodoInfo != null) && (paramInt1 == 1)) {
      ThreadManager.executeOnSubThread(new BaseChatPie.95.1(this, paramTodoInfo, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ujp
 * JD-Core Version:    0.7.0.1
 */