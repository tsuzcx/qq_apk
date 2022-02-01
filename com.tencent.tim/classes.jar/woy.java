import com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat.FriendShipWaveView;

public class woy
  implements anyb.a
{
  public woy(FriendShipWaveView paramFriendShipWaveView) {}
  
  public void aVH()
  {
    anyj localanyj = new anyj(new anyb[] { new anyi(400, 0.2F, 1.0F), new anyi(400, 1.0F, 0.2F) });
    this.this$0.i.opacity = 255;
    localanyj.isRepeat = true;
    this.this$0.i.a(new anyb[] { localanyj });
    this.this$0.m = new anyu();
    this.this$0.m.a(FriendShipWaveView.d(this.this$0));
    this.this$0.m.rotate = 30.0F;
    this.this$0.m.setPosition(this.this$0.f.x - aqcx.dip2px(this.this$0.N, 25.0F), this.this$0.f.y - aqcx.dip2px(this.this$0.N, 25.0F));
    localanyj = new anyj(new anyb[] { new anyi(600, 0.0F, 0.6F), new anyi(600, 0.6F, 0.0F) });
    localanyj.isRepeat = true;
    this.this$0.b(this.this$0.m);
    this.this$0.m.a(new anyb[] { localanyj });
    this.this$0.j = new anyu();
    this.this$0.j.a(FriendShipWaveView.d(this.this$0));
    this.this$0.j.setPosition(this.this$0.f.x + aqcx.dip2px(this.this$0.N, 20.0F), this.this$0.f.y - aqcx.dip2px(this.this$0.N, 10.0F));
    localanyj = new anyj(new anyb[] { new anyi(500, 0.0F, 1.2F), new anyi(500, 1.2F, 0.0F) });
    localanyj.isRepeat = true;
    this.this$0.b(this.this$0.j);
    this.this$0.j.a(new anyb[] { localanyj });
    this.this$0.k = new anyu();
    this.this$0.k.a(FriendShipWaveView.d(this.this$0));
    this.this$0.k.setPosition(this.this$0.g.x + aqcx.dip2px(this.this$0.N, 13.0F), this.this$0.g.y + aqcx.dip2px(this.this$0.N, 13.0F));
    localanyj = new anyj(new anyb[] { new anyi(500, 0.2F, 0.6F), new anyi(500, 0.6F, 0.2F) });
    localanyj.isRepeat = true;
    this.this$0.b(this.this$0.k);
    this.this$0.k.a(new anyb[] { localanyj });
    this.this$0.l = new anyu();
    this.this$0.l.a(FriendShipWaveView.d(this.this$0));
    this.this$0.l.setPosition(this.this$0.h.x - aqcx.dip2px(this.this$0.N, 10.0F), this.this$0.h.y - aqcx.dip2px(this.this$0.N, 3.0F));
    localanyj = new anyj(new anyb[] { new anyi(400, 0.0F, 0.6F), new anyi(400, 0.6F, 0.0F) });
    localanyj.isRepeat = true;
    this.this$0.b(this.this$0.l);
    this.this$0.l.a(new anyb[] { localanyj });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     woy
 * JD-Core Version:    0.7.0.1
 */