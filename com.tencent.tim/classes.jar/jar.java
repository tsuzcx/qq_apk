import com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat;
import com.tencent.qphone.base.util.QLog;

public class jar
  extends iya
{
  public jar(MultiVideoCtrlLayerUI4NewGroupChat paramMultiVideoCtrlLayerUI4NewGroupChat) {}
  
  protected void a(aqji.b paramb)
  {
    if ((QLog.isDevelopLevel()) || (this.this$0.Xg != paramb.cUo)) {
      QLog.w(this.this$0.TAG, 1, "onGroupInviteFlagChanged, mCanAutoInviteMemIntoTroop[" + this.this$0.Xg + "->" + paramb.cUo + "]");
    }
    if (this.this$0.Xg != paramb.cUo)
    {
      this.this$0.Xg = paramb.cUo;
      this.this$0.O(0L, 65535);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jar
 * JD-Core Version:    0.7.0.1
 */