import com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat.FriendShipWaveView;

public class woq
  implements anyb.a
{
  public woq(FriendShipWaveView paramFriendShipWaveView) {}
  
  public void aVH()
  {
    int i = (int)(this.this$0.mViewHeight - aqcx.dip2px(this.this$0.N, 165.0F) - this.this$0.b.height / 2.0F);
    int j = (int)(this.this$0.mViewHeight - aqcx.dip2px(this.this$0.N, 200.0F) - this.this$0.b.height / 2.0F);
    int k = (int)(this.this$0.mViewHeight - aqcx.dip2px(this.this$0.N, 178.0F) - this.this$0.b.height / 2.0F);
    anyj localanyj = new anyj(new anyb[] { new anye(450, this.this$0.JO / 2, (int)(-this.this$0.b.height / 2.0F), this.this$0.JO / 2, i), new anye(450, this.this$0.JO / 2, i, this.this$0.JO / 2, j), new anye(450, this.this$0.JO / 2, j, this.this$0.JO / 2, k) });
    localanyj.a(new wor(this));
    this.this$0.b.a(new anyb[] { localanyj });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     woq
 * JD-Core Version:    0.7.0.1
 */