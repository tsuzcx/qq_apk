import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqTodayStoryVidList;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.Calendar;

public class wnr
  implements woq
{
  protected wnt a;
  protected wor a;
  protected wos a;
  
  public Object a()
  {
    return this.jdField_a_of_type_Wnt;
  }
  
  public String a()
  {
    return getClass().getSimpleName();
  }
  
  public void a()
  {
    wsv.c("GetMyStoryVideoListStep", "GetMyStoryVideoListStep");
    d();
  }
  
  public void a(Object paramObject) {}
  
  public void a(wor paramwor)
  {
    this.jdField_a_of_type_Wor = paramwor;
  }
  
  public void a(wos paramwos)
  {
    this.jdField_a_of_type_Wos = paramwos;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
  
  protected void d()
  {
    String str = ume.a("StorySvc.homepage_my_day_710");
    qqstory_service.ReqTodayStoryVidList localReqTodayStoryVidList = new qqstory_service.ReqTodayStoryVidList();
    long l = NetConnInfoCenter.getServerTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(l);
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    int k = localCalendar.get(5);
    localReqTodayStoryVidList.date.set(i * 10000 + (j + 1) * 100 + k);
    this.jdField_a_of_type_Wnt = new wnt();
    ung.a().a(new vaq(str, localReqTodayStoryVidList, null), new wns(this, localReqTodayStoryVidList, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wnr
 * JD-Core Version:    0.7.0.1
 */