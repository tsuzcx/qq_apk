import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.HomeFeedPlayInfo;
import java.util.Iterator;
import java.util.List;

public class xcr
  extends xcm<HomeFeedPlayInfo>
{
  private int a;
  public ycg b = new ycg();
  
  public xcr(HomeFeedPlayInfo paramHomeFeedPlayInfo)
  {
    super(paramHomeFeedPlayInfo);
    paramHomeFeedPlayInfo = (yck)wjs.a(11);
    if (paramHomeFeedPlayInfo.b != null) {
      this.b = paramHomeFeedPlayInfo.b;
    }
  }
  
  public ycc a(String paramString)
  {
    Iterator localIterator = this.b.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ycc localycc = (ycc)localIterator.next();
      if (localycc.a.equals(paramString)) {
        return localycc;
      }
    }
    return null;
  }
  
  public void a(boolean paramBoolean, int paramInt, xde paramxde)
  {
    Object localObject1 = this.b.jdField_a_of_type_JavaUtilList;
    if ((paramBoolean) && (((List)localObject1).size() > 0))
    {
      localObject2 = b((List)localObject1);
      paramxde.a(new ErrorMessage(), (List)localObject2, this.b.jdField_a_of_type_Boolean);
      ykq.a("Q.qqstory.player.data.HomeFeedPlayPageLoader", "return cache data size %d", Integer.valueOf(((List)localObject1).size()));
      return;
    }
    localObject1 = (yck)wjs.a(11);
    Object localObject2 = new wts();
    ((wts)localObject2).a = ((yck)localObject1).a;
    ((wts)localObject2).b = this.b.a();
    ykq.a("Q.qqstory.player.data.HomeFeedPlayPageLoader", "start request next feed id list with cookie %s", ((wts)localObject2).b);
    this.a = 0;
    wfi.a().a((wfm)localObject2, new xcs(this, paramxde));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xcr
 * JD-Core Version:    0.7.0.1
 */