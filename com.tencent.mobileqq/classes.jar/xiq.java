import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.HomeFeedPlayInfo;
import java.util.Iterator;
import java.util.List;

public class xiq
  extends xil<HomeFeedPlayInfo>
{
  private int a;
  public yif b = new yif();
  
  public xiq(HomeFeedPlayInfo paramHomeFeedPlayInfo)
  {
    super(paramHomeFeedPlayInfo);
    paramHomeFeedPlayInfo = (yij)wpm.a(11);
    if (paramHomeFeedPlayInfo.b != null) {
      this.b = paramHomeFeedPlayInfo.b;
    }
  }
  
  public yib a(String paramString)
  {
    Iterator localIterator = this.b.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      yib localyib = (yib)localIterator.next();
      if (localyib.a.equals(paramString)) {
        return localyib;
      }
    }
    return null;
  }
  
  public void a(boolean paramBoolean, int paramInt, xjd paramxjd)
  {
    Object localObject1 = this.b.jdField_a_of_type_JavaUtilList;
    if ((paramBoolean) && (((List)localObject1).size() > 0))
    {
      localObject2 = b((List)localObject1);
      paramxjd.a(new ErrorMessage(), (List)localObject2, this.b.jdField_a_of_type_Boolean);
      yqp.a("Q.qqstory.player.data.HomeFeedPlayPageLoader", "return cache data size %d", Integer.valueOf(((List)localObject1).size()));
      return;
    }
    localObject1 = (yij)wpm.a(11);
    Object localObject2 = new wzm();
    ((wzm)localObject2).a = ((yij)localObject1).a;
    ((wzm)localObject2).b = this.b.a();
    yqp.a("Q.qqstory.player.data.HomeFeedPlayPageLoader", "start request next feed id list with cookie %s", ((wzm)localObject2).b);
    this.a = 0;
    wlb.a().a((wlf)localObject2, new xir(this, paramxjd));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xiq
 * JD-Core Version:    0.7.0.1
 */