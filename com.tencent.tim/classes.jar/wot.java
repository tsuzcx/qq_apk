import com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat.FriendShipWaveView;

public class wot
  implements anyb.a
{
  public wot(FriendShipWaveView paramFriendShipWaveView) {}
  
  public void aVH()
  {
    anyi localanyi = new anyi(500, 0.0F, 1.0F);
    this.this$0.e.opacity = 255;
    this.this$0.e.a(new anyb[] { localanyi });
    localanyi.a(new wou(this));
    this.this$0.f = new anyu();
    this.this$0.f.a(FriendShipWaveView.a(this.this$0));
    this.this$0.f.setPosition(this.this$0.JO / 2 + aqcx.dip2px(this.this$0.N, 120.0F), this.this$0.c.y + 30.0F);
    this.this$0.b(this.this$0.f);
    localanyi = new anyi(500, 0.0F, 1.0F);
    this.this$0.f.a(new anyb[] { localanyi });
    localanyi.a(new wov(this));
    this.this$0.g = new anyu();
    this.this$0.g.a(FriendShipWaveView.b(this.this$0));
    this.this$0.g.setPosition(this.this$0.JO / 2 - aqcx.dip2px(this.this$0.N, 142.0F), this.this$0.d.y - 50.0F);
    this.this$0.b(this.this$0.g);
    localanyi = new anyi(500, 0.0F, 1.0F);
    this.this$0.g.a(new anyb[] { localanyi });
    localanyi.a(new wow(this));
    this.this$0.h = new anyu();
    this.this$0.h.a(FriendShipWaveView.c(this.this$0));
    this.this$0.h.setPosition(this.this$0.JO / 2 + aqcx.dip2px(this.this$0.N, 140.0F), this.this$0.d.y);
    this.this$0.b(this.this$0.h);
    localanyi = new anyi(500, 0.0F, 1.0F);
    this.this$0.h.a(new anyb[] { localanyi });
    localanyi.a(new wox(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wot
 * JD-Core Version:    0.7.0.1
 */