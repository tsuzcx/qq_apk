import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.widget.QQToast;

public class cwj
  extends FriendListObserver
{
  public cwj(MoveToGroupActivity paramMoveToGroupActivity) {}
  
  protected void a(String paramString, byte paramByte1, byte paramByte2)
  {
    if (this.a.isFinishing()) {
      return;
    }
    MoveToGroupActivity.a(this.a);
    if (paramString == null) {
      QQToast.a(this.a, this.a.getString(2131562081), 0).b(this.a.d());
    }
    for (;;)
    {
      MoveToGroupActivity.b(this.a);
      this.a.b(MoveToGroupActivity.a(this.a));
      return;
      QQToast.a(this.a, 2, this.a.getString(2131562990), 0).b(this.a.d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cwj
 * JD-Core Version:    0.7.0.1
 */