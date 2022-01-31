import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.HomeFeedPlayInfo;
import java.util.Iterator;
import java.util.List;

public class tjl
  extends tjg<HomeFeedPlayInfo>
{
  private int a;
  public uja b = new uja();
  
  public tjl(HomeFeedPlayInfo paramHomeFeedPlayInfo)
  {
    super(paramHomeFeedPlayInfo);
    paramHomeFeedPlayInfo = (uje)sqg.a(11);
    if (paramHomeFeedPlayInfo.b != null) {
      this.b = paramHomeFeedPlayInfo.b;
    }
  }
  
  public uiw a(String paramString)
  {
    Iterator localIterator = this.b.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      uiw localuiw = (uiw)localIterator.next();
      if (localuiw.a.equals(paramString)) {
        return localuiw;
      }
    }
    return null;
  }
  
  public void a(boolean paramBoolean, int paramInt, tjy paramtjy)
  {
    Object localObject1 = this.b.jdField_a_of_type_JavaUtilList;
    if ((paramBoolean) && (((List)localObject1).size() > 0))
    {
      localObject2 = b((List)localObject1);
      paramtjy.a(new ErrorMessage(), (List)localObject2, this.b.jdField_a_of_type_Boolean);
      urk.a("Q.qqstory.player.data.HomeFeedPlayPageLoader", "return cache data size %d", Integer.valueOf(((List)localObject1).size()));
      return;
    }
    localObject1 = (uje)sqg.a(11);
    Object localObject2 = new tag();
    ((tag)localObject2).a = ((uje)localObject1).a;
    ((tag)localObject2).b = this.b.a();
    urk.a("Q.qqstory.player.data.HomeFeedPlayPageLoader", "start request next feed id list with cookie %s", ((tag)localObject2).b);
    this.a = 0;
    slv.a().a((slz)localObject2, new tjm(this, paramtjy));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tjl
 * JD-Core Version:    0.7.0.1
 */