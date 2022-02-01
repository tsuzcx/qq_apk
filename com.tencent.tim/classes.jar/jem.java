import com.tencent.av.VideoController;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoInviteActivity;

public class jem
  implements jcr.e
{
  public jem(VideoInviteActivity paramVideoInviteActivity, long paramLong, boolean paramBoolean) {}
  
  public void aoD()
  {
    if (this.this$0.a != null)
    {
      this.this$0.a.setViewEnable(2131374106, false);
      this.this$0.a.setViewEnable(2131363158, false);
      this.this$0.a.setViewEnable(2131363170, false);
      this.this$0.a.setViewEnable(2131363169, false);
    }
  }
  
  public void aoE()
  {
    if (this.this$0.Td)
    {
      this.this$0.b().a(this.kQ, this.this$0.mPeerUin, 1, true);
      long l = jji.B(this.this$0.mPeerUin);
      this.this$0.b().c(this.kQ, 3, l);
      this.this$0.Yn = true;
      this.this$0.b().f(this.kQ, l, 1);
      this.this$0.Ox = true;
      this.this$0.finish();
    }
    for (;;)
    {
      this.this$0.overridePendingTransition(0, 2130772238);
      return;
      this.this$0.b().a(this.kQ, this.this$0.mPeerUin, 1, false);
      this.this$0.b().O(this.this$0.mPeerUin, 248);
      this.this$0.b().ko(248);
      if (this.Yr) {
        this.this$0.b().P(this.this$0.mPeerUin, 1);
      }
      this.this$0.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jem
 * JD-Core Version:    0.7.0.1
 */