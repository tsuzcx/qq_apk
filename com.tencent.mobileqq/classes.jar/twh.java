import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.HomeFeedPlayInfo;
import java.util.Iterator;
import java.util.List;

public class twh
  extends twc<HomeFeedPlayInfo>
{
  private int a;
  public uvw b = new uvw();
  
  public twh(HomeFeedPlayInfo paramHomeFeedPlayInfo)
  {
    super(paramHomeFeedPlayInfo);
    paramHomeFeedPlayInfo = (uwa)tdc.a(11);
    if (paramHomeFeedPlayInfo.b != null) {
      this.b = paramHomeFeedPlayInfo.b;
    }
  }
  
  public uvs a(String paramString)
  {
    Iterator localIterator = this.b.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      uvs localuvs = (uvs)localIterator.next();
      if (localuvs.a.equals(paramString)) {
        return localuvs;
      }
    }
    return null;
  }
  
  public void a(boolean paramBoolean, int paramInt, twu paramtwu)
  {
    Object localObject1 = this.b.jdField_a_of_type_JavaUtilList;
    if ((paramBoolean) && (((List)localObject1).size() > 0))
    {
      localObject2 = b((List)localObject1);
      paramtwu.a(new ErrorMessage(), (List)localObject2, this.b.jdField_a_of_type_Boolean);
      veg.a("Q.qqstory.player.data.HomeFeedPlayPageLoader", "return cache data size %d", Integer.valueOf(((List)localObject1).size()));
      return;
    }
    localObject1 = (uwa)tdc.a(11);
    Object localObject2 = new tnc();
    ((tnc)localObject2).a = ((uwa)localObject1).a;
    ((tnc)localObject2).b = this.b.a();
    veg.a("Q.qqstory.player.data.HomeFeedPlayPageLoader", "start request next feed id list with cookie %s", ((tnc)localObject2).b);
    this.a = 0;
    syr.a().a((syv)localObject2, new twi(this, paramtwu));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     twh
 * JD-Core Version:    0.7.0.1
 */