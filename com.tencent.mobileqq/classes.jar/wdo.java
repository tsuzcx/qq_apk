import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;

class wdo
  implements wal
{
  wdo(wdn paramwdn) {}
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void b(int paramInt)
  {
    if ((this.a.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed))
    {
      FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)this.a.jdField_a_of_type_JavaLangObject;
      vtn.a(localStFeed.poster.id.get(), 17, 2, this.a.jdField_a_of_type_Int, localStFeed, null, this.a.b());
      vud.a().a(new vuf().a("followbutton").b("follow").a(localStFeed).a(this.a.a()).a(this.a.jdField_a_of_type_Int).c(localStFeed.poster.id.get()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wdo
 * JD-Core Version:    0.7.0.1
 */