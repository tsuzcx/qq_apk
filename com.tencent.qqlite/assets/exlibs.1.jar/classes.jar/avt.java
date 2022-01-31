import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.widget.QQToast;

public class avt
  extends FriendListObserver
{
  public avt(MoveToGroupActivity paramMoveToGroupActivity) {}
  
  protected void a(String paramString, byte paramByte1, byte paramByte2)
  {
    if (this.a.isFinishing()) {
      return;
    }
    MoveToGroupActivity.a(this.a);
    if (paramString == null) {
      QQToast.a(this.a, this.a.getString(2131363419), 0).b(this.a.getTitleBarHeight());
    }
    for (;;)
    {
      MoveToGroupActivity.b(this.a);
      this.a.removeObserver(MoveToGroupActivity.a(this.a));
      return;
      QQToast.a(this.a, 2, this.a.getString(2131363417), 0).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     avt
 * JD-Core Version:    0.7.0.1
 */