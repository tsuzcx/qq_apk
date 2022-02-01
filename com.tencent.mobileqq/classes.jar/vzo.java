import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;

class vzo
  implements vye
{
  vzo(vzl paramvzl) {}
  
  public void a(int paramInt)
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(vri.a("ext2", String.valueOf(paramInt)));
    vrc.a(34, 2, this.a.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, (List)localObject, this.a.b());
    vrr localvrr;
    vrt localvrt;
    if ((this.a.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed))
    {
      localObject = (FeedCloudMeta.StFeed)this.a.jdField_a_of_type_JavaLangObject;
      localvrr = vrr.a();
      localvrt = new vrt().a("pushbutton").b("push").a((FeedCloudMeta.StFeed)localObject).a(this.a.a()).a(this.a.jdField_a_of_type_Int);
      if (localObject == null) {
        break label154;
      }
    }
    label154:
    for (localObject = ((FeedCloudMeta.StFeed)localObject).poster.id.get();; localObject = "")
    {
      localvrr.a(localvrt.c((String)localObject).d(String.valueOf(paramInt)));
      return;
      localObject = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vzo
 * JD-Core Version:    0.7.0.1
 */