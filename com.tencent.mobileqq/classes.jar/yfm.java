import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqTodayStoryVidList;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.Calendar;

public class yfm
  implements ygl
{
  protected yfo a;
  protected ygm a;
  protected ygn a;
  
  public Object a()
  {
    return this.jdField_a_of_type_Yfo;
  }
  
  public String a()
  {
    return getClass().getSimpleName();
  }
  
  public void a()
  {
    ykq.c("GetMyStoryVideoListStep", "GetMyStoryVideoListStep");
    d();
  }
  
  public void a(Object paramObject) {}
  
  public void a(ygm paramygm)
  {
    this.jdField_a_of_type_Ygm = paramygm;
  }
  
  public void a(ygn paramygn)
  {
    this.jdField_a_of_type_Ygn = paramygn;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
  
  protected void d()
  {
    String str = weg.a("StorySvc.homepage_my_day_710");
    qqstory_service.ReqTodayStoryVidList localReqTodayStoryVidList = new qqstory_service.ReqTodayStoryVidList();
    long l = NetConnInfoCenter.getServerTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(l);
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    int k = localCalendar.get(5);
    localReqTodayStoryVidList.date.set(i * 10000 + (j + 1) * 100 + k);
    this.jdField_a_of_type_Yfo = new yfo();
    wfi.a().a(new wsr(str, localReqTodayStoryVidList, null), new yfn(this, localReqTodayStoryVidList, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfm
 * JD-Core Version:    0.7.0.1
 */