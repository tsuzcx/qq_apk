import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.HomeFeedPlayInfo;
import java.util.Iterator;
import java.util.List;

public class vkw
  extends vkr<HomeFeedPlayInfo>
{
  private int a;
  public wkl b = new wkl();
  
  public vkw(HomeFeedPlayInfo paramHomeFeedPlayInfo)
  {
    super(paramHomeFeedPlayInfo);
    paramHomeFeedPlayInfo = (wkp)urr.a(11);
    if (paramHomeFeedPlayInfo.b != null) {
      this.b = paramHomeFeedPlayInfo.b;
    }
  }
  
  public wkh a(String paramString)
  {
    Iterator localIterator = this.b.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      wkh localwkh = (wkh)localIterator.next();
      if (localwkh.a.equals(paramString)) {
        return localwkh;
      }
    }
    return null;
  }
  
  public void a(boolean paramBoolean, int paramInt, vlj paramvlj)
  {
    Object localObject1 = this.b.jdField_a_of_type_JavaUtilList;
    if ((paramBoolean) && (((List)localObject1).size() > 0))
    {
      localObject2 = b((List)localObject1);
      paramvlj.a(new ErrorMessage(), (List)localObject2, this.b.jdField_a_of_type_Boolean);
      wsv.a("Q.qqstory.player.data.HomeFeedPlayPageLoader", "return cache data size %d", Integer.valueOf(((List)localObject1).size()));
      return;
    }
    localObject1 = (wkp)urr.a(11);
    Object localObject2 = new vbr();
    ((vbr)localObject2).a = ((wkp)localObject1).a;
    ((vbr)localObject2).b = this.b.a();
    wsv.a("Q.qqstory.player.data.HomeFeedPlayPageLoader", "start request next feed id list with cookie %s", ((vbr)localObject2).b);
    this.a = 0;
    ung.a().a((unk)localObject2, new vkx(this, paramvlj));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vkw
 * JD-Core Version:    0.7.0.1
 */