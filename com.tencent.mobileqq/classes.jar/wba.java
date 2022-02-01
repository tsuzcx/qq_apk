import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import qqcircle.QQCircleDitto.StItemInfo;

class wba
  implements wal
{
  wba(waz paramwaz) {}
  
  public void a()
  {
    String str = "";
    if ((waz.c(this.a) instanceof QQCircleDitto.StItemInfo)) {
      str = ((QQCircleDitto.StItemInfo)waz.d(this.a)).id.get();
    }
    vtn.a(str, 3, 1, 19, 2, waz.e(this.a), waz.e(this.a).id.get(), "", waz.f(this.a).poster.id.get(), waz.f(this.a), waz.g(this.a), null, waz.g(this.a), -1);
  }
  
  public void a(int paramInt) {}
  
  public void b(int paramInt)
  {
    String str = "";
    if ((waz.a(this.a) instanceof QQCircleDitto.StItemInfo)) {
      str = ((QQCircleDitto.StItemInfo)waz.b(this.a)).id.get();
    }
    if (paramInt > 0) {}
    for (paramInt = 18;; paramInt = 17)
    {
      vtn.a(str, 3, 1, paramInt, 2, waz.a(this.a), waz.a(this.a).id.get(), "", waz.b(this.a).poster.id.get(), waz.b(this.a), waz.c(this.a), null, waz.c(this.a), -1);
      vud.a().a(new vuf().a("followbutton").b("follow").a(waz.d(this.a)).a(this.a.a()).a(waz.d(this.a)).c(str));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wba
 * JD-Core Version:    0.7.0.1
 */