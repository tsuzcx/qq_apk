import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqTodayStoryVidList;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.Calendar;

public class ypg
  implements yqf
{
  protected ypi a;
  protected yqg a;
  protected yqh a;
  
  public Object a()
  {
    return this.jdField_a_of_type_Ypi;
  }
  
  public String a()
  {
    return getClass().getSimpleName();
  }
  
  public void a()
  {
    yuk.c("GetMyStoryVideoListStep", "GetMyStoryVideoListStep");
    d();
  }
  
  public void a(Object paramObject) {}
  
  public void a(yqg paramyqg)
  {
    this.jdField_a_of_type_Yqg = paramyqg;
  }
  
  public void a(yqh paramyqh)
  {
    this.jdField_a_of_type_Yqh = paramyqh;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
  
  protected void d()
  {
    String str = wnu.a("StorySvc.homepage_my_day_710");
    qqstory_service.ReqTodayStoryVidList localReqTodayStoryVidList = new qqstory_service.ReqTodayStoryVidList();
    long l = NetConnInfoCenter.getServerTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(l);
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    int k = localCalendar.get(5);
    localReqTodayStoryVidList.date.set(i * 10000 + (j + 1) * 100 + k);
    this.jdField_a_of_type_Ypi = new ypi();
    wow.a().a(new xcg(str, localReqTodayStoryVidList, null), new yph(this, localReqTodayStoryVidList, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ypg
 * JD-Core Version:    0.7.0.1
 */