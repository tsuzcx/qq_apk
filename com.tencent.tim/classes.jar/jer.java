import com.tencent.av.VideoController;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.qphone.base.util.QLog;

class jer
  implements jcr.e
{
  jer(jeq paramjeq, int paramInt) {}
  
  public void aoD()
  {
    if (this.a.this$0.a != null)
    {
      this.a.this$0.a.setViewEnable(2131374106, false);
      this.a.this$0.a.setViewEnable(2131363158, false);
      this.a.this$0.a.setViewEnable(2131363170, false);
      this.a.this$0.a.setViewEnable(2131363169, false);
    }
  }
  
  public void aoE()
  {
    this.a.this$0.b().O(this.a.this$0.mPeerUin, 250);
    this.a.this$0.b().ko(250);
    this.a.this$0.b().P(this.a.this$0.mPeerUin, this.axS);
    this.a.this$0.Ox = true;
    QLog.d(this.a.this$0.TAG, 1, "onClose()-> onOutAnimationEnd ->finish  ");
    this.a.this$0.finish();
    this.a.this$0.overridePendingTransition(0, 2130772238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jer
 * JD-Core Version:    0.7.0.1
 */