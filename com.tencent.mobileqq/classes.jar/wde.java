import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;

class wde
  implements wbw
{
  wde(wdb paramwdb) {}
  
  public void a(int paramInt)
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(vtt.a("ext2", String.valueOf(paramInt)));
    vtn.a(34, 2, this.a.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, (List)localObject, this.a.b());
    vud localvud;
    vuf localvuf;
    if ((this.a.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed))
    {
      localObject = (FeedCloudMeta.StFeed)this.a.jdField_a_of_type_JavaLangObject;
      localvud = vud.a();
      localvuf = new vuf().a("pushbutton").b("push").a((FeedCloudMeta.StFeed)localObject).a(this.a.a()).a(this.a.jdField_a_of_type_Int);
      if (localObject == null) {
        break label154;
      }
    }
    label154:
    for (localObject = ((FeedCloudMeta.StFeed)localObject).poster.id.get();; localObject = "")
    {
      localvud.a(localvuf.c((String)localObject).d(String.valueOf(paramInt)));
      return;
      localObject = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wde
 * JD-Core Version:    0.7.0.1
 */