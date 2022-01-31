import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.HomeFeedPlayInfo;
import java.util.Iterator;
import java.util.List;

public class vpf
  extends vpa<HomeFeedPlayInfo>
{
  private int a;
  public wou b = new wou();
  
  public vpf(HomeFeedPlayInfo paramHomeFeedPlayInfo)
  {
    super(paramHomeFeedPlayInfo);
    paramHomeFeedPlayInfo = (woy)uwa.a(11);
    if (paramHomeFeedPlayInfo.b != null) {
      this.b = paramHomeFeedPlayInfo.b;
    }
  }
  
  public woq a(String paramString)
  {
    Iterator localIterator = this.b.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      woq localwoq = (woq)localIterator.next();
      if (localwoq.a.equals(paramString)) {
        return localwoq;
      }
    }
    return null;
  }
  
  public void a(boolean paramBoolean, int paramInt, vps paramvps)
  {
    Object localObject1 = this.b.jdField_a_of_type_JavaUtilList;
    if ((paramBoolean) && (((List)localObject1).size() > 0))
    {
      localObject2 = b((List)localObject1);
      paramvps.a(new ErrorMessage(), (List)localObject2, this.b.jdField_a_of_type_Boolean);
      wxe.a("Q.qqstory.player.data.HomeFeedPlayPageLoader", "return cache data size %d", Integer.valueOf(((List)localObject1).size()));
      return;
    }
    localObject1 = (woy)uwa.a(11);
    Object localObject2 = new vga();
    ((vga)localObject2).a = ((woy)localObject1).a;
    ((vga)localObject2).b = this.b.a();
    wxe.a("Q.qqstory.player.data.HomeFeedPlayPageLoader", "start request next feed id list with cookie %s", ((vga)localObject2).b);
    this.a = 0;
    urp.a().a((urt)localObject2, new vpg(this, paramvps));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vpf
 * JD-Core Version:    0.7.0.1
 */