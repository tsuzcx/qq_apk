import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.widget.QQToast;

public class ytk
  extends accn
{
  public ytk(SystemMsgListView paramSystemMsgListView) {}
  
  protected void onSetConnectionsSwitch(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      if (SystemMsgListView.a(this.this$0) != null) {
        SystemMsgListView.a(this.this$0).refreshData();
      }
      QQToast.a(this.this$0.getContext(), 2131701422, 3000).show();
      return;
    }
    QQToast.a(this.this$0.getContext(), 2131701421, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ytk
 * JD-Core Version:    0.7.0.1
 */