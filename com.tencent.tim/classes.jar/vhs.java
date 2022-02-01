import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.widget.QQToast;

public class vhs
  extends acfd
{
  public vhs(MoveToGroupActivity paramMoveToGroupActivity) {}
  
  protected void onUpdateMoveGroup(String paramString, byte paramByte1, byte paramByte2)
  {
    if (this.a.isFinishing()) {
      return;
    }
    MoveToGroupActivity.a(this.a);
    if (paramString == null) {
      QQToast.a(this.a, this.a.getString(2131695997), 0).show(this.a.getTitleBarHeight());
    }
    for (;;)
    {
      MoveToGroupActivity.b(this.a);
      this.a.removeObserver(MoveToGroupActivity.a(this.a));
      return;
      QQToast.a(this.a, 2, this.a.getString(2131695999), 0).show(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vhs
 * JD-Core Version:    0.7.0.1
 */