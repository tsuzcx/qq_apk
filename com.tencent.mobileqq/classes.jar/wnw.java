import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.HomeFeedPlayInfo;
import java.util.Iterator;
import java.util.List;

public class wnw
  extends wnr<HomeFeedPlayInfo>
{
  private int a;
  public xnl b = new xnl();
  
  public wnw(HomeFeedPlayInfo paramHomeFeedPlayInfo)
  {
    super(paramHomeFeedPlayInfo);
    paramHomeFeedPlayInfo = (xnp)vux.a(11);
    if (paramHomeFeedPlayInfo.b != null) {
      this.b = paramHomeFeedPlayInfo.b;
    }
  }
  
  public xnh a(String paramString)
  {
    Iterator localIterator = this.b.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      xnh localxnh = (xnh)localIterator.next();
      if (localxnh.a.equals(paramString)) {
        return localxnh;
      }
    }
    return null;
  }
  
  public void a(boolean paramBoolean, int paramInt, woj paramwoj)
  {
    Object localObject1 = this.b.jdField_a_of_type_JavaUtilList;
    if ((paramBoolean) && (((List)localObject1).size() > 0))
    {
      localObject2 = b((List)localObject1);
      paramwoj.a(new ErrorMessage(), (List)localObject2, this.b.jdField_a_of_type_Boolean);
      xvv.a("Q.qqstory.player.data.HomeFeedPlayPageLoader", "return cache data size %d", Integer.valueOf(((List)localObject1).size()));
      return;
    }
    localObject1 = (xnp)vux.a(11);
    Object localObject2 = new wex();
    ((wex)localObject2).a = ((xnp)localObject1).a;
    ((wex)localObject2).b = this.b.a();
    xvv.a("Q.qqstory.player.data.HomeFeedPlayPageLoader", "start request next feed id list with cookie %s", ((wex)localObject2).b);
    this.a = 0;
    vqn.a().a((vqr)localObject2, new wnx(this, paramwoj));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wnw
 * JD-Core Version:    0.7.0.1
 */