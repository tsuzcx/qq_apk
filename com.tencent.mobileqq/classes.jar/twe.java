import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.HomeFeedPlayInfo;
import java.util.Iterator;
import java.util.List;

public class twe
  extends tvz<HomeFeedPlayInfo>
{
  private int a;
  public uvt b = new uvt();
  
  public twe(HomeFeedPlayInfo paramHomeFeedPlayInfo)
  {
    super(paramHomeFeedPlayInfo);
    paramHomeFeedPlayInfo = (uvx)tcz.a(11);
    if (paramHomeFeedPlayInfo.b != null) {
      this.b = paramHomeFeedPlayInfo.b;
    }
  }
  
  public uvp a(String paramString)
  {
    Iterator localIterator = this.b.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      uvp localuvp = (uvp)localIterator.next();
      if (localuvp.a.equals(paramString)) {
        return localuvp;
      }
    }
    return null;
  }
  
  public void a(boolean paramBoolean, int paramInt, twr paramtwr)
  {
    Object localObject1 = this.b.jdField_a_of_type_JavaUtilList;
    if ((paramBoolean) && (((List)localObject1).size() > 0))
    {
      localObject2 = b((List)localObject1);
      paramtwr.a(new ErrorMessage(), (List)localObject2, this.b.jdField_a_of_type_Boolean);
      ved.a("Q.qqstory.player.data.HomeFeedPlayPageLoader", "return cache data size %d", Integer.valueOf(((List)localObject1).size()));
      return;
    }
    localObject1 = (uvx)tcz.a(11);
    Object localObject2 = new tmz();
    ((tmz)localObject2).a = ((uvx)localObject1).a;
    ((tmz)localObject2).b = this.b.a();
    ved.a("Q.qqstory.player.data.HomeFeedPlayPageLoader", "start request next feed id list with cookie %s", ((tmz)localObject2).b);
    this.a = 0;
    syo.a().a((sys)localObject2, new twf(this, paramtwr));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     twe
 * JD-Core Version:    0.7.0.1
 */