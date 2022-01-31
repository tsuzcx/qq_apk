import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class wr
  implements Runnable
{
  public wr(AddFriendLogicActivity paramAddFriendLogicActivity) {}
  
  public void run()
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.a = true;
    AddFriendLogicActivity.a(this.a).hide();
    AddFriendLogicActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     wr
 * JD-Core Version:    0.7.0.1
 */