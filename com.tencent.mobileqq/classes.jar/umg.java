import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqTodayStoryVidList;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.Calendar;

public class umg
  implements unf
{
  protected umi a;
  protected ung a;
  protected unh a;
  
  public Object a()
  {
    return this.jdField_a_of_type_Umi;
  }
  
  public String a()
  {
    return getClass().getSimpleName();
  }
  
  public void a()
  {
    urk.c("GetMyStoryVideoListStep", "GetMyStoryVideoListStep");
    d();
  }
  
  public void a(Object paramObject) {}
  
  public void a(ung paramung)
  {
    this.jdField_a_of_type_Ung = paramung;
  }
  
  public void a(unh paramunh)
  {
    this.jdField_a_of_type_Unh = paramunh;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
  
  protected void d()
  {
    String str = skt.a("StorySvc.homepage_my_day_710");
    qqstory_service.ReqTodayStoryVidList localReqTodayStoryVidList = new qqstory_service.ReqTodayStoryVidList();
    long l = NetConnInfoCenter.getServerTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(l);
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    int k = localCalendar.get(5);
    localReqTodayStoryVidList.date.set(i * 10000 + (j + 1) * 100 + k);
    this.jdField_a_of_type_Umi = new umi();
    slv.a().a(new szf(str, localReqTodayStoryVidList, null), new umh(this, localReqTodayStoryVidList, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     umg
 * JD-Core Version:    0.7.0.1
 */