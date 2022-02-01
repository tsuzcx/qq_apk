import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.HomeFeedPlayInfo;
import java.util.Iterator;
import java.util.List;

public class xml
  extends xmg<HomeFeedPlayInfo>
{
  private int a;
  public yma b = new yma();
  
  public xml(HomeFeedPlayInfo paramHomeFeedPlayInfo)
  {
    super(paramHomeFeedPlayInfo);
    paramHomeFeedPlayInfo = (yme)wth.a(11);
    if (paramHomeFeedPlayInfo.b != null) {
      this.b = paramHomeFeedPlayInfo.b;
    }
  }
  
  public ylw a(String paramString)
  {
    Iterator localIterator = this.b.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ylw localylw = (ylw)localIterator.next();
      if (localylw.a.equals(paramString)) {
        return localylw;
      }
    }
    return null;
  }
  
  public void a(boolean paramBoolean, int paramInt, xmy paramxmy)
  {
    Object localObject1 = this.b.jdField_a_of_type_JavaUtilList;
    if ((paramBoolean) && (((List)localObject1).size() > 0))
    {
      localObject2 = b((List)localObject1);
      paramxmy.a(new ErrorMessage(), (List)localObject2, this.b.jdField_a_of_type_Boolean);
      yuk.a("Q.qqstory.player.data.HomeFeedPlayPageLoader", "return cache data size %d", Integer.valueOf(((List)localObject1).size()));
      return;
    }
    localObject1 = (yme)wth.a(11);
    Object localObject2 = new xdh();
    ((xdh)localObject2).a = ((yme)localObject1).a;
    ((xdh)localObject2).b = this.b.a();
    yuk.a("Q.qqstory.player.data.HomeFeedPlayPageLoader", "start request next feed id list with cookie %s", ((xdh)localObject2).b);
    this.a = 0;
    wow.a().a((wpa)localObject2, new xmm(this, paramxmy));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xml
 * JD-Core Version:    0.7.0.1
 */